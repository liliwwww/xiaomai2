package android.taobao.windvane.extra.uc;

import android.taobao.windvane.monitor.WVMonitorService;
import android.taobao.windvane.util.CommonUtils;
import android.taobao.windvane.util.TaoLog;
import android.text.TextUtils;
import anetwork.channel.Request;
import anetwork.channel.Response;
import com.taobao.tao.util.ImageStrategyDecider;
import com.uc.webview.export.internal.interfaces.EventHandler;
import com.uc.webview.export.internal.interfaces.IRequest;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import tb.kb4;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public class AliRequestAdapter implements IRequest {
    public static final String PHASE_ENDDATA = "enddata";
    private static final String PHASE_NORMAL = "normal";
    public static final String PHASE_RELOAD = "reload";
    public static final String PHASE_STOP = "stop";
    public static int connectTimeout = 10000;
    public static int readTimeout = 10000;
    public static int retryTimes = 1;
    String TAG;
    private String bizCode;
    public String cancelPhase;
    Request mAliRequest;
    private final Object mClientResource;
    private EventHandler mEventHandler;
    Future<Response> mFutureResponse;
    private Map<String, String> mHeaders;
    private boolean mIsUCProxy;
    private boolean mIsUseWebP;
    private int mLoadType;
    private String mMethod;
    private int mRequestType;
    private Map<String, String> mUCHeaders;
    private Map<String, byte[]> mUploadDataMap;
    private Map<String, String> mUploadFileMap;
    private long mUploadFileTotalLen;
    private String mUrl;

    AliRequestAdapter(Request request, EventHandler eventHandler) {
        this.TAG = "alinetwork";
        this.mMethod = "GET";
        this.mClientResource = new Object();
        this.cancelPhase = PHASE_NORMAL;
        this.mEventHandler = eventHandler;
    }

    private Request formatAliRequest() {
        return formatAliRequest(this.mUrl, this.mMethod, this.mIsUCProxy, this.mHeaders, this.mUCHeaders, this.mUploadFileMap, this.mUploadDataMap, this.mUploadFileTotalLen, this.mRequestType, this.mLoadType, this.mIsUseWebP);
    }

    public void cancel() {
        Future<Response> future;
        if (WVUCWebView.isStop) {
            this.cancelPhase = PHASE_STOP;
        }
        TaoLog.e(this.TAG, "cancel id= " + this.mEventHandler.hashCode() + ", phase:[" + this.cancelPhase + "]");
        try {
            if (TaoLog.getLogStatus() && (future = this.mFutureResponse) != null && future.get() != null) {
                TaoLog.d(this.TAG, "AliRequestAdapter cancel desc url=" + this.mFutureResponse.get().getDesc());
            }
            complete();
        } catch (InterruptedException e) {
            e.printStackTrace();
            TaoLog.d(this.TAG, "AliRequestAdapter cancel =" + e.getMessage());
        } catch (ExecutionException e2) {
            e2.printStackTrace();
            TaoLog.d(this.TAG, "AliRequestAdapter cancel =" + e2.getMessage());
        }
        Future<Response> future2 = this.mFutureResponse;
        if (future2 != null) {
            future2.cancel(true);
        }
    }

    void complete() {
        WVUCWebView.isStop = false;
        if (this.mEventHandler.isSynchronous()) {
            synchronized (this.mClientResource) {
                if (TaoLog.getLogStatus()) {
                    TaoLog.d(this.TAG, "AliRequestAdapter complete will notify");
                }
                this.mClientResource.notifyAll();
            }
        }
    }

    public Request getAliRequest() {
        return this.mAliRequest;
    }

    public EventHandler getEventHandler() {
        return this.mEventHandler;
    }

    public Map<String, String> getHeaders() {
        return this.mHeaders;
    }

    public boolean getIsUCProxy() {
        return this.mIsUCProxy;
    }

    public int getLoadtype() {
        return this.mLoadType;
    }

    public String getMethod() {
        return this.mMethod;
    }

    public int getRequestType() {
        return this.mRequestType;
    }

    public Map<String, String> getUCHeaders() {
        return this.mUCHeaders;
    }

    public Map<String, byte[]> getUploadDataMap() {
        return this.mUploadDataMap;
    }

    public Map<String, String> getUploadFileMap() {
        return this.mUploadFileMap;
    }

    public long getUploadFileTotalLen() {
        return this.mUploadFileTotalLen;
    }

    public String getUrl() {
        return this.mUrl;
    }

    public void handleSslErrorResponse(boolean z) {
    }

    public void setEventHandler(EventHandler eventHandler) {
        this.mEventHandler = eventHandler;
    }

    public void setFutureResponse(Future<Response> future) {
        this.mFutureResponse = future;
    }

    public void waitUntilComplete(int i) {
        if (this.mEventHandler.isSynchronous()) {
            synchronized (this.mClientResource) {
                try {
                    if (TaoLog.getLogStatus()) {
                        TaoLog.d(this.TAG, "AliRequestAdapter waitUntilComplete timeout=" + i + ",url=" + this.mUrl);
                    }
                    this.mClientResource.wait(i);
                } catch (InterruptedException unused) {
                }
            }
        }
    }

    private Request formatAliRequest(String str, String str2, boolean z, Map<String, String> map, Map<String, String> map2, Map<String, String> map3, Map<String, byte[]> map4, long j, int i, int i2, boolean z2) {
        if (z2) {
            try {
                if (CommonUtils.isPicture(str)) {
                    String justConvergeAndWebP = ImageStrategyDecider.justConvergeAndWebP(str);
                    if (!TextUtils.isEmpty(justConvergeAndWebP) && !justConvergeAndWebP.equals(str)) {
                        TaoLog.i(this.TAG, str + " decideUrl to : " + justConvergeAndWebP);
                        str = justConvergeAndWebP;
                    }
                }
            } catch (Throwable unused) {
            }
        }
        try {
            kb4 kb4Var = new kb4(str);
            kb4Var.setFollowRedirects(false);
            kb4Var.setBizId(this.bizCode);
            kb4Var.setRetryTime(retryTimes);
            kb4Var.setConnectTimeout(connectTimeout);
            kb4Var.setReadTimeout(readTimeout);
            kb4Var.setCookieEnabled(WVUCWebView.isNeedCookie(str));
            kb4Var.setMethod(str2);
            if (map != null) {
                kb4Var.addHeader("f-refer", "wv_h5");
                UCNetworkDelegate.getInstance().onSendRequest(map, str);
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    String key = entry.getKey();
                    String value = entry.getValue();
                    if (TaoLog.getLogStatus()) {
                        TaoLog.d(this.TAG, "AliRequestAdapter from uc header key=" + key + ",value=" + value);
                    }
                    kb4Var.addHeader(key, value);
                }
            }
            if (WVMonitorService.getPerformanceMonitor() != null) {
                WVMonitorService.getPerformanceMonitor().didResourceStartLoadAtTime(this.mUrl, System.currentTimeMillis());
            }
            return kb4Var;
        } catch (Exception e) {
            TaoLog.e(this.TAG, " AliRequestAdapter formatAliRequest Exception" + e.getMessage());
            return null;
        }
    }

    AliRequestAdapter(EventHandler eventHandler, String str, String str2, boolean z, Map<String, String> map, Map<String, String> map2, Map<String, String> map3, Map<String, byte[]> map4, long j, int i, int i2, boolean z2, String str3) {
        this.TAG = "alinetwork";
        this.mMethod = "GET";
        this.mClientResource = new Object();
        this.cancelPhase = PHASE_NORMAL;
        this.mIsUseWebP = z2;
        this.mEventHandler = eventHandler;
        this.mUrl = str;
        this.mMethod = str2;
        this.mIsUCProxy = z;
        this.mHeaders = map;
        this.mUCHeaders = map2;
        this.mUploadFileMap = map3;
        this.mUploadDataMap = map4;
        this.mUploadFileTotalLen = j;
        this.mRequestType = i;
        this.mLoadType = i2;
        this.bizCode = str3;
        this.mAliRequest = formatAliRequest();
    }
}
