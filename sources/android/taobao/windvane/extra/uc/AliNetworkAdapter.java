package android.taobao.windvane.extra.uc;

import android.content.Context;
import android.os.Handler;
import android.taobao.windvane.config.WVCommonConfig;
import android.taobao.windvane.monitor.WVMonitorService;
import android.taobao.windvane.util.CommonUtils;
import android.taobao.windvane.util.TaoLog;
import android.text.TextUtils;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import anetwork.channel.Network;
import anetwork.channel.NetworkCallBack;
import anetwork.channel.NetworkEvent;
import anetwork.channel.Request;
import anetwork.channel.Response;
import com.taobao.analysis.v3.FalcoGlobalTracer;
import com.taobao.analysis.v3.FalcoTracer;
import com.uc.webview.export.internal.interfaces.EventHandler;
import com.uc.webview.export.internal.interfaces.INetwork;
import com.uc.webview.export.internal.interfaces.IRequest;
import java.io.IOException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.HashSet;
import java.util.Map;
import org.apache.http.ParseException;
import tb.hw0;
import tb.i42;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public class AliNetworkAdapter implements INetwork {
    public static final int NETWORK_WORKING_MODE_ASYNC = 1;
    public static final int NETWORK_WORKING_MODE_SYNC = 0;
    private int BUFFER_SIZE;
    String LOGTAG;
    private String bizCode;
    public boolean isReload;
    public boolean isStop;
    private boolean isUseWebpImg;
    private Network mAliNetwork;
    private Context mContext;
    private int mNetworkType;
    private int mWorkingMode;
    public HashSet<EventHandler> mainRequest;
    private WVUCWebView webView;

    /* compiled from: Taobao */
    protected class AliNetCallback implements NetworkCallBack.FinishListener, NetworkCallBack.ProgressListener, NetworkCallBack.ResponseCodeListener {
        EventHandler mEventHandler;
        IRequest mReq;
        String mUrl;
        int size = 0;
        int total = 0;

        protected AliNetCallback() {
        }

        public void onDataReceived(NetworkEvent.ProgressEvent progressEvent, Object obj) {
            if (TaoLog.getLogStatus()) {
                TaoLog.d(AliNetworkAdapter.this.LOGTAG, "[onDataReceived] event:" + progressEvent + "event.getSize():" + progressEvent.getSize() + ", data:" + progressEvent.getBytedata().length + " bytes");
            }
            this.mEventHandler.data(progressEvent.getBytedata(), progressEvent.getSize());
            this.size += progressEvent.getSize();
            if (this.total == 0) {
                this.total = progressEvent.getTotal();
            }
        }

        public void onFinished(NetworkEvent.FinishEvent finishEvent, Object obj) {
            if (TaoLog.getLogStatus()) {
                TaoLog.d(AliNetworkAdapter.this.LOGTAG, "[onFinished] event:" + finishEvent);
                TaoLog.e(AliNetworkAdapter.this.LOGTAG, "onFinished code = " + finishEvent.getHttpCode() + ", url = " + this.mUrl + ", rev_size = " + this.size + ", total_size = " + this.total);
            }
            if (WVMonitorService.getPerformanceMonitor() != null) {
                try {
                    String str = finishEvent.getStatisticData().connectionType;
                    long j = finishEvent.getStatisticData().tcpConnTime;
                    WVMonitorService.getPerformanceMonitor().didResourceFinishLoadAtTime(this.mUrl, System.currentTimeMillis(), str, 0L);
                } catch (Throwable th) {
                    WVMonitorService.getPerformanceMonitor().didResourceFinishLoadAtTime(this.mUrl, System.currentTimeMillis(), "unknown", 0L);
                    TaoLog.e(AliNetworkAdapter.this.LOGTAG, "didResourceFinishLoadAtTime failed : " + th.getMessage());
                }
            }
            AliRequestAdapter aliRequestAdapter = (AliRequestAdapter) this.mReq;
            int httpCode = finishEvent.getHttpCode();
            UCNetworkDelegate.getInstance().onFinish(httpCode, this.mUrl);
            if (httpCode >= 0) {
                if (TaoLog.getLogStatus()) {
                    TaoLog.d(AliNetworkAdapter.this.LOGTAG, "endData");
                }
                aliRequestAdapter.cancelPhase = AliRequestAdapter.PHASE_ENDDATA;
                this.mEventHandler.endData();
                aliRequestAdapter.complete();
                return;
            }
            if (TaoLog.getLogStatus()) {
                TaoLog.e(AliNetworkAdapter.this.LOGTAG, "error code=" + httpCode + ",desc=" + finishEvent.getDesc() + ",url=" + this.mUrl);
            }
            this.mEventHandler.error(httpCode, finishEvent.getDesc());
            aliRequestAdapter.complete();
        }

        /* JADX WARN: Removed duplicated region for block: B:33:0x008f A[Catch: all -> 0x00e2, TryCatch #0 {all -> 0x00e2, blocks: (B:3:0x0003, B:5:0x0015, B:7:0x0023, B:10:0x0033, B:12:0x003b, B:14:0x0043, B:24:0x005f, B:26:0x0069, B:28:0x0073, B:30:0x007f, B:31:0x0089, B:33:0x008f, B:35:0x0097, B:38:0x00a0, B:40:0x00a8, B:41:0x00bc, B:62:0x00d0), top: B:2:0x0003 }] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public boolean onResponseCode(int r8, java.util.Map<java.lang.String, java.util.List<java.lang.String>> r9, java.lang.Object r10) {
            /*
                Method dump skipped, instructions count: 342
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: android.taobao.windvane.extra.uc.AliNetworkAdapter.AliNetCallback.onResponseCode(int, java.util.Map, java.lang.Object):boolean");
        }

        public void setEventHandler(EventHandler eventHandler) {
            this.mEventHandler = eventHandler;
        }

        public void setRequest(IRequest iRequest) {
            this.mReq = iRequest;
        }

        public void setURL(String str) {
            this.mUrl = str;
        }
    }

    public AliNetworkAdapter(Context context) {
        this(context, WVUCWebView.WINDVANE);
    }

    private void injectTraceContext(Request request) {
        try {
            WVUCWebView wVUCWebView = this.webView;
            if (wVUCWebView != null && wVUCWebView.getSpanWrapper() != null) {
                FalcoTracer falcoTracer = FalcoGlobalTracer.get();
                if (falcoTracer != null) {
                    request.setTraceContext(falcoTracer.injectContextToMap(this.webView.getSpanWrapper().context()));
                }
            } else if (this.webView == null) {
                TaoLog.i(this.LOGTAG, "webView == null");
            } else {
                TaoLog.i(this.LOGTAG, "webView.getFalcoSpan() == null");
            }
        } catch (Throwable th) {
            TaoLog.e(this.LOGTAG, CommonUtils.getStackTrace(th));
        }
    }

    private boolean sendRequestInternal(AliRequestAdapter aliRequestAdapter) {
        Request aliRequest = aliRequestAdapter.getAliRequest();
        injectTraceContext(aliRequest);
        EventHandler eventHandler = aliRequestAdapter.getEventHandler();
        if (TaoLog.getLogStatus()) {
            TaoLog.d(this.LOGTAG, "requestURL eventId=" + aliRequestAdapter.getEventHandler().hashCode() + ", url=" + aliRequestAdapter.getUrl() + ",isSync=" + eventHandler.isSynchronous());
        }
        int i = this.mWorkingMode;
        if (i == 0) {
            Response syncSend = this.mAliNetwork.syncSend(aliRequest, (Object) null);
            Throwable error = syncSend.getError();
            if (error != null) {
                eventHandler.error(getErrorFromException(error), error.toString());
            } else {
                int statusCode = syncSend.getStatusCode();
                String str = syncSend.getStatisticData().connectionType;
                if (TextUtils.isEmpty(str) || !str.startsWith("http2")) {
                    eventHandler.status(0, 0, statusCode, "");
                } else {
                    eventHandler.status(2, 0, statusCode, "");
                }
                if (TaoLog.getLogStatus()) {
                    TaoLog.d(this.LOGTAG, "status code=" + statusCode);
                }
                eventHandler.headers(syncSend.getConnHeadFields());
                byte[] bytedata = syncSend.getBytedata();
                if (bytedata != null) {
                    eventHandler.data(bytedata, bytedata.length);
                }
                aliRequestAdapter.cancelPhase = AliRequestAdapter.PHASE_ENDDATA;
                eventHandler.endData();
            }
        } else if (i == 1) {
            AliNetCallback aliNetCallback = new AliNetCallback();
            aliNetCallback.setEventHandler(eventHandler);
            aliNetCallback.setURL(aliRequestAdapter.getUrl());
            aliNetCallback.setRequest(aliRequestAdapter);
            aliRequestAdapter.setFutureResponse(this.mAliNetwork.asyncSend(aliRequest, (Object) null, (Handler) null, aliNetCallback));
        }
        return true;
    }

    private void setRequestBodyHandler(Request request, AliRequestAdapter aliRequestAdapter) {
        if (aliRequestAdapter.getUploadFileTotalLen() != 0) {
            Map<String, String> uploadFileMap = aliRequestAdapter.getUploadFileMap();
            Map<String, byte[]> uploadDataMap = aliRequestAdapter.getUploadDataMap();
            request.setBodyHandler(new 1(this, uploadFileMap.size() + uploadDataMap.size(), uploadFileMap, uploadDataMap));
        }
    }

    public static boolean willLog(EventHandler eventHandler) {
        int resourceType = eventHandler.getResourceType();
        return resourceType == 0 || resourceType == 14 || eventHandler.isSynchronous();
    }

    public void cancelPrefetchLoad() {
    }

    public void clearUserSslPrefTable() {
    }

    public IRequest formatRequest(EventHandler eventHandler, String str, String str2, boolean z, Map<String, String> map, Map<String, String> map2, Map<String, String> map3, Map<String, byte[]> map4, long j, int i, int i2) {
        AliRequestAdapter aliRequestAdapter;
        AliRequestAdapter aliRequestAdapter2 = new AliRequestAdapter(eventHandler, Escape.tryDecodeUrl(str), str2, z, map, map2, map3, map4, j, i, i2, this.isUseWebpImg, this.bizCode);
        if (this.isReload) {
            aliRequestAdapter = aliRequestAdapter2;
            aliRequestAdapter.cancelPhase = AliRequestAdapter.PHASE_RELOAD;
        } else {
            aliRequestAdapter = aliRequestAdapter2;
        }
        setRequestBodyHandler(aliRequestAdapter.getAliRequest(), aliRequestAdapter);
        eventHandler.setRequest(aliRequestAdapter);
        eventHandler.setResourceType(i);
        return aliRequestAdapter;
    }

    public int getErrorFromException(Throwable th) {
        if (th instanceof ParseException) {
            return -43;
        }
        if (th instanceof SocketTimeoutException) {
            return -46;
        }
        if (th instanceof SocketException) {
            return -47;
        }
        if (th instanceof IOException) {
            return -44;
        }
        if (th instanceof IllegalStateException) {
            return -45;
        }
        return th instanceof UnknownHostException ? -2 : -99;
    }

    public int getNetworkType() {
        return 1;
    }

    public String getVersion() {
        return "1.0";
    }

    public boolean requestURL(EventHandler eventHandler, String str, String str2, boolean z, Map<String, String> map, Map<String, String> map2, Map<String, String> map3, Map<String, byte[]> map4, long j, int i, int i2) {
        TaoLog.d(this.LOGTAG, "requestURL:" + str + " isUCProxyReq:" + z + " requestType:" + i);
        AliRequestAdapter aliRequestAdapter = new AliRequestAdapter(eventHandler, Escape.tryDecodeUrl(str), str2, z, map, map2, map3, map4, j, i, i2, this.isUseWebpImg, this.bizCode);
        if (this.isReload) {
            aliRequestAdapter.cancelPhase = AliRequestAdapter.PHASE_RELOAD;
        }
        setRequestBodyHandler(aliRequestAdapter.getAliRequest(), aliRequestAdapter);
        eventHandler.setRequest(aliRequestAdapter);
        return sendRequestInternal(aliRequestAdapter);
    }

    public boolean sendRequest(IRequest iRequest) {
        return sendRequestInternal((AliRequestAdapter) iRequest);
    }

    public AliNetworkAdapter(Context context, String str) {
        this(context, 2, str);
    }

    public AliNetworkAdapter(Context context, String str, WVUCWebView wVUCWebView) {
        this(context, 2, str);
        this.webView = wVUCWebView;
    }

    public AliNetworkAdapter(Context context, int i) {
        this(context, i, WVUCWebView.WINDVANE);
    }

    public AliNetworkAdapter(Context context, int i, String str) {
        this.LOGTAG = "AliNetwork";
        this.mNetworkType = -1;
        this.mWorkingMode = 1;
        this.BUFFER_SIZE = AccessibilityEventCompat.TYPE_TOUCH_EXPLORATION_GESTURE_END;
        this.isUseWebpImg = true;
        this.bizCode = "";
        this.isReload = false;
        this.isStop = false;
        this.mainRequest = new HashSet<>();
        this.mContext = context;
        this.mNetworkType = i;
        this.bizCode = str;
        if (WVCommonConfig.commonConfig.ucsdk_image_strategy_rate > Math.random()) {
            this.isUseWebpImg = true;
        } else {
            this.isUseWebpImg = false;
        }
        int i2 = this.mNetworkType;
        if (i2 == 0) {
            this.mAliNetwork = new i42(context);
        } else if (i2 == 1 || i2 == 2) {
            this.mAliNetwork = new hw0(context);
        }
    }
}
