package android.taobao.windvane.extra.jsbridge;

import android.R;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.taobao.windvane.WindVaneSDKForTB;
import android.taobao.windvane.config.GlobalConfig;
import android.taobao.windvane.connect.HttpConnector;
import android.taobao.windvane.connect.HttpRequest;
import android.taobao.windvane.connect.HttpResponse;
import android.taobao.windvane.connect.api.ApiRequest;
import android.taobao.windvane.connect.api.ApiResponse;
import android.taobao.windvane.connect.api.WVApiWrapper;
import android.taobao.windvane.extra.WVIAdapter;
import android.taobao.windvane.extra.mtop.MtopApiAdapter;
import android.taobao.windvane.jsbridge.WVApiPlugin;
import android.taobao.windvane.jsbridge.WVCallBackContext;
import android.taobao.windvane.jsbridge.WVResult;
import android.taobao.windvane.jsbridge.WindVaneInterface;
import android.taobao.windvane.monitor.AppMonitorUtil;
import android.taobao.windvane.thread.LockObject;
import android.taobao.windvane.util.EnvUtil;
import android.taobao.windvane.util.TaoLog;
import android.widget.Toast;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public class WVServer extends WVApiPlugin implements Handler.Callback {
    public static final String API_SERVER = "WVServer";
    private static final int NOTIFY_RESULT = 500;
    private static final int NOT_REG_LOGIN = 510;
    static boolean NeedApiLock = false;
    private static final String TAG = "WVServer";
    static long lastlocktime;
    static long notiTime;
    private Handler mHandler;
    private ExecutorService singleExecutor = Executors.newSingleThreadExecutor();
    private LinkedBlockingQueue<LockObject> lockQueue = new LinkedBlockingQueue<>();
    private final Object lockLock = new Object();
    private Object jsContext = null;
    private String mParams = null;
    private boolean needLock = false;
    private boolean isUserLogin = false;

    /* compiled from: Taobao */
    private class ServerRequestTask implements Runnable {
        private Object context;
        private String params;

        public ServerRequestTask(Object obj, String str) {
            this.context = obj;
            this.params = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            LockObject lockObject;
            ServerParams parseParams = WVServer.this.parseParams(this.params);
            if (parseParams == null) {
                MtopResult mtopResult = WVServer.this.new MtopResult(this.context);
                mtopResult.addData("ret", new JSONArray().put(WVResult.PARAM_ERR));
                WVServer.this.callResult(mtopResult);
                return;
            }
            if (WVServer.this.needLock) {
                boolean z = false;
                synchronized (WVServer.this.lockLock) {
                    int size = WVServer.this.lockQueue.size();
                    lockObject = (LockObject) WVServer.this.lockQueue.peek();
                    if (TaoLog.getLogStatus()) {
                        TaoLog.d("WVServer", "queue size: " + size + " lock: " + lockObject);
                    }
                    if (WVServer.this.lockQueue.offer(new LockObject()) && size > 0) {
                        z = true;
                    }
                }
                if (z && lockObject != null) {
                    lockObject.lwait();
                }
            }
            WVServer.this.mParams = this.params;
            WVServer.this.jsContext = this.context;
            HttpRequest wrapRequest = WVServer.this.wrapRequest(parseParams);
            if (wrapRequest == null) {
                TaoLog.w("WVServer", "HttpRequest is null, and do nothing");
            } else {
                WVServer.this.parseResult(this.context, new HttpConnector().syncConnect(wrapRequest));
            }
        }
    }

    public WVServer() {
        this.mHandler = null;
        this.mHandler = new Handler(Looper.getMainLooper(), this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callResult(MtopResult mtopResult) {
        Message obtain = Message.obtain();
        obtain.what = 500;
        obtain.obj = mtopResult;
        this.mHandler.sendMessage(obtain);
    }

    private void notifyNext() {
        LockObject poll;
        if (this.needLock) {
            synchronized (this.lockLock) {
                poll = this.lockQueue.poll();
            }
            if (poll != null) {
                poll.lnotify();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ServerParams parseParams(String str) {
        try {
            ServerParams serverParams = new ServerParams();
            JSONObject jSONObject = new JSONObject(str);
            serverParams.api = jSONObject.getString("api");
            serverParams.v = jSONObject.optString("v", "*");
            serverParams.post = jSONObject.optInt("post", 0) != 0;
            serverParams.ecode = jSONObject.optInt("ecode", 0) != 0;
            serverParams.isSec = jSONObject.optInt("isSec", 1) != 0;
            JSONObject optJSONObject = jSONObject.optJSONObject("param");
            if (optJSONObject != null) {
                Iterator<String> keys = optJSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    serverParams.addData(next, optJSONObject.getString(next));
                }
            }
            return serverParams;
        } catch (JSONException unused) {
            TaoLog.e("WVServer", "parseParams error, param=" + str);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void parseResult(Object obj, HttpResponse httpResponse) {
        MtopResult mtopResult = new MtopResult(obj);
        mtopResult.addData("ret", new JSONArray().put(WVResult.FAIL));
        mtopResult.addData("code", String.valueOf(httpResponse.getHttpCode()));
        if (!httpResponse.isSuccess() || httpResponse.getData() == null) {
            TaoLog.d("WVServer", "parseResult: request illegal, response is null");
            int httpCode = httpResponse.getHttpCode();
            if (httpCode == 420 || httpCode == 499 || httpCode == 599) {
                lastlocktime = System.currentTimeMillis();
                NeedApiLock = true;
                Handler handler = this.mHandler;
                if (handler != null) {
                    handler.post(new 2(this));
                }
            } else if (httpCode >= 410 && httpCode <= 419) {
                Map headers = httpResponse.getHeaders();
                String str = (headers == null || !headers.containsKey("location")) ? "http://h5.m.taobao.com/" : (String) headers.get("location");
                Intent intent = new Intent();
                intent.setData(Uri.parse(str));
                intent.setPackage(((WVApiPlugin) this).mContext.getPackageName());
                try {
                    ((WVApiPlugin) this).mContext.startActivity(intent);
                    Handler handler2 = this.mHandler;
                    if (handler2 != null) {
                        handler2.post(new 3(this));
                    }
                } catch (Exception unused) {
                }
            }
            callResult(mtopResult);
            return;
        }
        try {
            String str2 = new String(httpResponse.getData(), "utf-8");
            if (TaoLog.getLogStatus()) {
                TaoLog.d("WVServer", "parseResult: content=" + str2);
            }
            try {
                JSONObject jSONObject = new JSONObject(str2);
                jSONObject.put("code", String.valueOf(httpResponse.getHttpCode()));
                JSONArray jSONArray = jSONObject.getJSONArray("ret");
                int length = jSONArray.length();
                int i = 0;
                while (true) {
                    if (i >= length) {
                        break;
                    }
                    String string = jSONArray.getString(i);
                    if (string.startsWith(ApiResponse.SUCCESS)) {
                        mtopResult.setSuccess(true);
                        break;
                    } else if (string.startsWith(ApiResponse.ERR_SID_INVALID)) {
                        WVIAdapter wVIAdapter = WindVaneSDKForTB.wvAdapter;
                        if (wVIAdapter != null) {
                            this.isUserLogin = true;
                            wVIAdapter.login(this.mHandler);
                            return;
                        }
                    } else {
                        i++;
                    }
                }
                mtopResult.setData(jSONObject);
                callResult(mtopResult);
            } catch (Exception unused2) {
                TaoLog.e("WVServer", "parseResult mtop response parse fail, content: " + str2);
                callResult(mtopResult);
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            callResult(mtopResult);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public HttpRequest wrapRequest(ServerParams serverParams) {
        ApiRequest apiRequest = new ApiRequest();
        apiRequest.addParam("api", serverParams.api);
        apiRequest.addParam("v", serverParams.v);
        WVIAdapter wVIAdapter = WindVaneSDKForTB.wvAdapter;
        String str = null;
        if (wVIAdapter == null) {
            TaoLog.w("WVServer", "wrapRequest wvAdapter is not exist.");
            if (serverParams.ecode) {
                this.mHandler.sendEmptyMessage(510);
                return null;
            }
        } else {
            this.isUserLogin = false;
            Map<String, String> loginInfo = wVIAdapter.getLoginInfo(this.mHandler);
            if (serverParams.ecode) {
                if (loginInfo == null) {
                    TaoLog.w("WVServer", "wrapRequest loginInfo is null.");
                } else {
                    apiRequest.addParam("sid", loginInfo.get("sid"));
                    apiRequest.addParam("ecode", loginInfo.get("ecode"));
                    if (TaoLog.getLogStatus()) {
                        TaoLog.d("WVServer", "login info, sid: " + loginInfo.get("sid") + " ecode: " + loginInfo.get("ecode"));
                    }
                }
            } else if (loginInfo != null) {
                apiRequest.addParam("sid", loginInfo.get("sid"));
            }
        }
        apiRequest.addDataParams(serverParams.getData());
        String mtopUrl = GlobalConfig.getMtopUrl();
        if (serverParams.isSec) {
            apiRequest.setSec(true);
            str = WVApiWrapper.formatBody(apiRequest, MtopApiAdapter.class);
        } else if (serverParams.post) {
            str = WVApiWrapper.formatBody(apiRequest, MtopApiAdapter.class);
        } else {
            mtopUrl = WVApiWrapper.formatUrl(apiRequest, MtopApiAdapter.class);
        }
        HttpRequest httpRequest = new HttpRequest(mtopUrl);
        httpRequest.setRedirect(false);
        if (str != null) {
            httpRequest.setMethod("POST");
            try {
                httpRequest.setPostData(str.getBytes("utf-8"));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        return httpRequest;
    }

    public boolean execute(String str, String str2, WVCallBackContext wVCallBackContext) {
        try {
            AppMonitorUtil.commitOffMonitor(wVCallBackContext.getWebview().getUrl(), "WVServer:" + str2, "101");
        } catch (Throwable unused) {
        }
        if (EnvUtil.isAppDebug()) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - notiTime > 3600000) {
                notiTime = currentTimeMillis;
                if (((WVApiPlugin) this).mContext instanceof Activity) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(((WVApiPlugin) this).mContext);
                    builder.setMessage("因安全原因，lib-mtop.js 需升级至1.5.0以上，WVServer接口已废弃，请使用MtopWVPlugin。 详询 ：益零");
                    builder.setTitle("警告(仅debug版本会弹出)");
                    builder.setCancelable(true);
                    builder.setPositiveButton(R.string.ok, (DialogInterface.OnClickListener) new 1(this));
                    builder.create();
                    builder.show();
                }
            }
        }
        if (!"send".equals(str)) {
            return false;
        }
        if (NeedApiLock && System.currentTimeMillis() - lastlocktime < 5000) {
            Toast.makeText(((WVApiPlugin) this).mContext, "哎呦喂，被挤爆啦，请稍后重试", 1).show();
            return true;
        }
        NeedApiLock = false;
        send(wVCallBackContext, str2);
        return true;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        int i = message.what;
        if (i == 0) {
            if (this.isUserLogin) {
                MtopResult mtopResult = new MtopResult();
                mtopResult.addData("ret", new JSONArray().put(ApiResponse.ERR_SID_INVALID));
                Object obj = this.jsContext;
                if (obj instanceof WVCallBackContext) {
                    ((WVCallBackContext) obj).error(mtopResult.toString());
                }
                if (TaoLog.getLogStatus()) {
                    TaoLog.d("WVServer", "login fail, call result, " + mtopResult.toString());
                }
                this.isUserLogin = false;
            }
            notifyNext();
            return true;
        }
        if (i == 1) {
            notifyNext();
            this.isUserLogin = false;
            this.singleExecutor.execute(new ServerRequestTask(this.jsContext, this.mParams));
            if (TaoLog.getLogStatus()) {
                TaoLog.d("WVServer", "login success, execute task, mParams:" + this.mParams);
            }
            return true;
        }
        if (i != 500) {
            if (i != 510) {
                return false;
            }
            MtopResult mtopResult2 = new MtopResult();
            mtopResult2.addData("ret", new JSONArray().put(WVResult.FAIL));
            mtopResult2.addData("code", "-1");
            Object obj2 = this.jsContext;
            if (obj2 instanceof WVCallBackContext) {
                ((WVCallBackContext) obj2).error(mtopResult2.toString());
            }
            if (TaoLog.getLogStatus()) {
                TaoLog.d("WVServer", "not reg login, call fail, " + mtopResult2.toString());
            }
            notifyNext();
            return true;
        }
        Object obj3 = message.obj;
        if (obj3 instanceof MtopResult) {
            MtopResult mtopResult3 = (MtopResult) obj3;
            if (mtopResult3.isSuccess()) {
                if (mtopResult3.getJsContext() instanceof WVCallBackContext) {
                    ((WVCallBackContext) mtopResult3.getJsContext()).success(mtopResult3.toString());
                }
            } else if (mtopResult3.getJsContext() instanceof WVCallBackContext) {
                ((WVCallBackContext) mtopResult3.getJsContext()).error(mtopResult3.toString());
            }
            if (TaoLog.getLogStatus()) {
                TaoLog.d("WVServer", "call result, retString: " + mtopResult3.toString());
            }
        }
        notifyNext();
        return true;
    }

    public boolean isLock() {
        return this.needLock;
    }

    public void onDestroy() {
        this.lockQueue.clear();
        this.jsContext = null;
    }

    @WindVaneInterface
    public void send(Object obj, String str) {
        this.singleExecutor.execute(new ServerRequestTask(obj, str));
    }

    public void setLock(boolean z) {
        this.needLock = z;
    }

    /* compiled from: Taobao */
    private class MtopResult {
        private Object jsContext;
        private JSONObject result;
        private boolean success;

        public MtopResult() {
            this.jsContext = null;
            this.success = false;
            this.result = new JSONObject();
        }

        public void addData(String str, String str2) {
            if (str == null || str2 == null) {
                return;
            }
            try {
                this.result.put(str, str2);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        public Object getJsContext() {
            return this.jsContext;
        }

        public boolean isSuccess() {
            return this.success;
        }

        public void setData(JSONObject jSONObject) {
            if (jSONObject != null) {
                this.result = jSONObject;
            }
        }

        public void setSuccess(boolean z) {
            this.success = z;
        }

        public String toString() {
            return this.result.toString();
        }

        public void addData(String str, JSONArray jSONArray) {
            if (str == null || jSONArray == null) {
                return;
            }
            try {
                this.result.put(str, jSONArray);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        public MtopResult(Object obj) {
            this.jsContext = null;
            this.success = false;
            this.result = new JSONObject();
            this.jsContext = obj;
        }
    }
}
