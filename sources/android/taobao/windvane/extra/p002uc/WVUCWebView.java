package android.taobao.windvane.extra.p002uc;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.MutableContextWrapper;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.taobao.windvane.WindVaneSDKForTB;
import android.taobao.windvane.config.GlobalConfig;
import android.taobao.windvane.config.UCParamData;
import android.taobao.windvane.config.WVCommonConfig;
import android.taobao.windvane.config.WVCommonConfigData;
import android.taobao.windvane.config.WVCookieConfig;
import android.taobao.windvane.config.WVServerConfig;
import android.taobao.windvane.config.WVUCPrecacheManager;
import android.taobao.windvane.config.WVURLConfig;
import android.taobao.windvane.connect.HttpConnector;
import android.taobao.windvane.embed.WVEVManager;
import android.taobao.windvane.extra.config.TBConfigManager;
import android.taobao.windvane.extra.core.WVCore;
import android.taobao.windvane.extra.jsbridge.WVUCBase;
import android.taobao.windvane.extra.p002uc.preRender.BasePreInitManager;
import android.taobao.windvane.extra.performance.WVErrorManager;
import android.taobao.windvane.extra.performance.WVH5PPManager;
import android.taobao.windvane.extra.performance2.IPerformance;
import android.taobao.windvane.extra.performance2.WVFSPManager;
import android.taobao.windvane.extra.performance2.WVPageTracker;
import android.taobao.windvane.extra.performance2.WVPerformance;
import android.taobao.windvane.extra.performance2.WVWPData;
import android.taobao.windvane.file.FileManager;
import android.taobao.windvane.filter.WVSecurityFilter;
import android.taobao.windvane.fullspan.SpanWrapper;
import android.taobao.windvane.jsbridge.WVApiPlugin;
import android.taobao.windvane.jsbridge.WVAppEvent;
import android.taobao.windvane.jsbridge.WVBridgeEngine;
import android.taobao.windvane.jsbridge.WVCallBackContext;
import android.taobao.windvane.jsbridge.WVH5PP;
import android.taobao.windvane.jsbridge.WVJsBridge;
import android.taobao.windvane.jsbridge.WVPluginEntryManager;
import android.taobao.windvane.jsbridge.WVPluginManager;
import android.taobao.windvane.jsbridge.api.WVFalco;
import android.taobao.windvane.jsbridge.api.WVFullTrace;
import android.taobao.windvane.jspatch.WVJsPatchListener;
import android.taobao.windvane.monitor.AppMonitorUtil;
import android.taobao.windvane.monitor.UserTrackUtil;
import android.taobao.windvane.monitor.WVMonitorService;
import android.taobao.windvane.monitor.WVPackageMonitorInterface;
import android.taobao.windvane.p003ha.UCHAManager;
import android.taobao.windvane.p003ha.WVHAManager;
import android.taobao.windvane.runtimepermission.PermissionProposer;
import android.taobao.windvane.service.WVEventId;
import android.taobao.windvane.service.WVEventService;
import android.taobao.windvane.thread.WVThreadPool;
import android.taobao.windvane.util.CommonUtils;
import android.taobao.windvane.util.ConfigStorage;
import android.taobao.windvane.util.EnvUtil;
import android.taobao.windvane.util.FullTraceUtils;
import android.taobao.windvane.util.ImageTool;
import android.taobao.windvane.util.NetWork;
import android.taobao.windvane.util.ReflectUtils;
import android.taobao.windvane.util.TaoLog;
import android.taobao.windvane.util.WVConstants;
import android.taobao.windvane.util.WVNativeCallbackUtil;
import android.taobao.windvane.util.WVUrlUtil;
import android.taobao.windvane.view.PopupWindowController;
import android.taobao.windvane.webview.CoreEventCallback;
import android.taobao.windvane.webview.IFullTrace;
import android.taobao.windvane.webview.IWVWebView;
import android.taobao.windvane.webview.WVRenderPolicy;
import android.taobao.windvane.webview.WVSchemeInterceptService;
import android.taobao.windvane.webview.WVSchemeIntercepterInterface;
import android.taobao.windvane.webview.WVUIModel;
import android.taobao.windvane.webview.WVURLFilter;
import android.taobao.windvane.webview.WindVaneError;
import android.text.TextUtils;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.webkit.CookieManager;
import android.webkit.DownloadListener;
import android.webkit.ValueCallback;
import android.widget.Toast;
import androidx.annotation.Keep;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import com.taobao.analysis.v3.FalcoSpan;
import com.taobao.monitor.procedure.ViewToken;
import com.taobao.orange.OrangeConfig;
import com.taobao.uc.UCSoSettings;
import com.taobao.weaver.prefetch.WMLPrefetch;
import com.uc.webview.export.ServiceWorkerController;
import com.uc.webview.export.WebChromeClient;
import com.uc.webview.export.WebResourceRequest;
import com.uc.webview.export.WebResourceResponse;
import com.uc.webview.export.WebSettings;
import com.uc.webview.export.WebView;
import com.uc.webview.export.WebViewClient;
import com.uc.webview.export.business.BusinessWrapper;
import com.uc.webview.export.cyclone.UCKnownException;
import com.uc.webview.export.extension.UCCore;
import com.uc.webview.export.extension.UCExtension;
import com.uc.webview.export.extension.UCSettings;
import com.uc.webview.export.internal.setup.UCMRunningInfo;
import com.uc.webview.export.internal.setup.UCSetupTask;
import com.uc.webview.export.utility.SetupTask;
import java.io.File;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Taobao */
@Keep
/* loaded from: classes2.dex */
public class WVUCWebView extends WebView implements Handler.Callback, IPerformance, IFullTrace, IWVWebView {
    private static final String STATIC_WEBVIEW_URL = "about:blank?static";
    private static final String TAG = "WVUCWebView";
    private static final String WIFI = "WIFI";
    public static final String WINDVANE = "windvane";
    private static final String _2G = "2g";
    private static final String _3G = "3g";
    private static final String _4G = "4g";
    private static final String _5g = "5g";
    public static String bizId = "windvane";
    private static int coreCode = -1;
    private static CoreEventCallback coreEventCallback;
    private static boolean evaluateJavascriptSupported;
    private static int gpuMultiPolicy;
    private static AtomicBoolean initAfterUCCoreReady;
    private static boolean initedJSBridge;
    private static boolean isSWInit;
    public static boolean isStop;
    private static boolean needDownLoad;
    private static boolean openUCDebug;
    private static Pattern pattern;
    private static int renderMultiPolicy;
    private static WVUCWebView sStaticUCWebView;
    private AliNetworkAdapter aliRequestAdapter;
    public String bizCode;
    private String cachedUrl;
    private FalcoSpan containerSpan;
    protected Context context;
    private String currentUrl;
    private String dataOnActive;

    /* renamed from: dx */
    float f13dx;

    /* renamed from: dy */
    float f14dy;
    protected WVPluginEntryManager entryManager;
    boolean firstTimeLoad;
    private boolean flag4commit;
    StringBuilder injectJs;
    private boolean isLive;
    private boolean isPreInit;
    boolean isUser;
    private WVJsPatchListener jsPatchListener;
    private boolean longPressSaveImage;
    private boolean mAllowAllOpen;
    SparseArray<MotionEvent> mEventSparseArray;
    private Hashtable<String, Hashtable<String, String>> mH5MonitorCache;
    protected Handler mHandler;
    private String mImageUrl;
    private boolean mIsCoreDestroy;
    private boolean mIsStaticWebView;
    private View.OnLongClickListener mLongClickListener;
    private int mPageLoadedCount;
    public long mPageStart;
    private PopupWindowController mPopupController;
    private String[] mPopupMenuTags;
    private final SpanWrapper mSpanWrapper;
    private boolean mUseGlobalUrlConfig;
    private int mWvNativeCallbackId;
    private long onErrorTime;
    private Map<String, String> openTracingContextMap;
    public WVPageTracker pageTracker;
    private WVPerformance performanceDelegate;
    private String pid;
    private View.OnClickListener popupClickListener;
    private boolean reportedFSP;
    protected boolean supportDownload;
    private String ucParam;
    private String uid;
    private boolean useUrlConfig;
    protected WVUCWebChromeClient webChromeClient;
    protected WVUCWebViewClient webViewClient;
    public WVWPData wpData;
    public WVErrorManager wvErrorManager;
    private WVSecurityFilter wvSecurityFilter;
    private WVUIModel wvUIModel;
    public WVFSPManager wvfspManager;
    public WVH5PPManager wvh5PPManager;
    private static final SpanWrapper sSpanWrapper = new SpanWrapper();
    private static int fromType = 70;
    private static final AtomicBoolean sCoreInitialized = new AtomicBoolean(false);
    private static final AtomicBoolean shouldUCLibInit = new AtomicBoolean(false);
    public static int INNER_FLAG = 0;
    public static String UC_CORE_URL = UCSoSettings.getInstance().UC_CORE_URL_32;
    private static String UC_PLAYER_URL = UCSoSettings.getInstance().UC_PLAYER_URL;
    private static boolean mUseAliNetwork = true;
    private static boolean mUseSystemWebView = false;
    private static boolean mDegradeAliNetwork = false;

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    private static final class CorePreparedCallback implements ValueCallback<SetupTask> {
        long startTime;

        CorePreparedCallback(long j) {
            this.startTime = 0L;
            this.startTime = j;
        }

        @Override // android.webkit.ValueCallback
        public void onReceiveValue(SetupTask setupTask) {
            Application application = GlobalConfig.context;
            if (application == null) {
                return;
            }
            WVUCWebView.onUCMCoreSwitched(application, this.startTime);
        }
    }

    /* compiled from: Taobao */
    private static final class DecompressCallable implements UCCore.Callable<Boolean, Bundle> {
        private Context mContext;

        public DecompressCallable(Context context) {
            this.mContext = context.getApplicationContext();
        }

        public Boolean call(Bundle bundle) throws Exception {
            TaoLog.m18d(WVUCWebView.TAG, "decompress parameters:" + bundle);
            ProcessLockUtil processLockUtil = new ProcessLockUtil(this.mContext.getCacheDir() + "/.taobaoDec7zSo.lock");
            try {
                try {
                    processLockUtil.lock();
                    long currentTimeMillis = System.currentTimeMillis();
                    this.mContext.getDir("h5container", 0);
                    if (WVUCWebView.isMainProcess()) {
                        TaoLog.m18d(WVUCWebView.TAG, "init on main process, mark uc not init!");
                    }
                    boolean extractWebCoreLibraryIfNeeded = UCCore.extractWebCoreLibraryIfNeeded(this.mContext, bundle.getString("zipFilePath"), bundle.getString("zipFileType"), bundle.getString("decDirPath"), bundle.getBoolean("deleteAfterExtract"));
                    TaoLog.m18d(WVUCWebView.TAG, "taobaoDec7zSo elapse " + (System.currentTimeMillis() - currentTimeMillis));
                    return Boolean.valueOf(extractWebCoreLibraryIfNeeded);
                } catch (Exception e) {
                    TaoLog.m22e(WVUCWebView.TAG, "catch exception ", e, new Object[0]);
                    throw e;
                }
            } finally {
                processLockUtil.unlock();
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    private static final class DownLoadCallback implements ValueCallback<SetupTask> {
        private DownLoadCallback() {
        }

        @Override // android.webkit.ValueCallback
        public void onReceiveValue(SetupTask setupTask) {
            int percent = setupTask.getPercent();
            if (WVCore.getInstance().getCoreDownLoadBack() != null) {
                WVCore.getInstance().getCoreDownLoadBack().progress(percent);
            }
            TaoLog.m24i("UCCore", "download progress:[" + percent + "]%");
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    protected static final class DownloadEnv implements Callable<Boolean> {
        Context context;

        DownloadEnv(Context context) {
            this.context = context;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public Boolean call() throws Exception {
            String currentNetworkType = WVUCWebView.getCurrentNetworkType(GlobalConfig.context);
            boolean z = true;
            boolean z2 = GlobalConfig.getInstance().isOpen4GDownload() && TextUtils.equals(WVUCWebView._4G, currentNetworkType);
            WVCommonConfig.getInstance();
            if (!(WVCommonConfig.commonConfig.open5GAdapter && GlobalConfig.getInstance().isOpen5GDownload() && TextUtils.equals(WVUCWebView._5g, currentNetworkType)) && !z2 && !TextUtils.equals(WVUCWebView.WIFI, currentNetworkType)) {
                z = false;
            }
            if (z) {
                TaoLog.m24i("UCCore", "start download u4 core,is4G=[" + WVCore.getInstance().isOpen4GDownload() + "]");
            } else {
                WVUCWebView.sCoreInitialized.set(false);
                WVUCWebView.shouldUCLibInit.set(false);
                TaoLog.m21e("UCCore", "current env cannot download u4 core");
            }
            return Boolean.valueOf(z);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    private static final class ExceptionValueCallback implements ValueCallback<SetupTask> {
        private ExceptionValueCallback() {
        }

        @Override // android.webkit.ValueCallback
        public void onReceiveValue(SetupTask setupTask) {
            WVUCWebView.shouldUCLibInit.set(false);
            WVUCWebView.sCoreInitialized.set(false);
            try {
                if (setupTask.getException() != null) {
                    StringWriter stringWriter = new StringWriter();
                    setupTask.getException().printStackTrace(new PrintWriter(stringWriter));
                    TaoLog.m21e("UCCore", "UC ExceptionValueCallback : " + stringWriter.toString());
                }
                if (WVCore.getInstance().getCoreDownLoadBack() != null) {
                    WVCore.getInstance().getCoreDownLoadBack().initError();
                }
            } catch (Throwable th) {
                TaoLog.m21e(WVUCWebView.TAG, "UC ExceptionValueCallback Throwable : " + th.getMessage());
            }
        }
    }

    /* compiled from: Taobao */
    private static final class OldCoreVersionCallable implements UCCore.Callable<Boolean, String> {
        private OldCoreVersionCallable() {
        }

        public Boolean call(String str) {
            TaoLog.m24i(WVUCWebView.TAG, "version callable value:" + str);
            return Boolean.FALSE;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    private static class OnInitStart implements ValueCallback<Bundle> {
        private OnInitStart() {
        }

        @Override // android.webkit.ValueCallback
        public void onReceiveValue(Bundle bundle) {
            TaoLog.m24i(WVUCWebView.TAG, "on init start:[" + bundle + "]");
            if (bundle != null) {
                "bit_by_old_dex_dir".equals(bundle.getString("bo_init_type"));
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    private static final class SwitchValueCallback implements ValueCallback<SetupTask> {
        long startTime;

        SwitchValueCallback(long j) {
            this.startTime = 0L;
            this.startTime = j;
        }

        @Override // android.webkit.ValueCallback
        public void onReceiveValue(SetupTask setupTask) {
            WVThreadPool.getInstance().execute(new Runnable() { // from class: android.taobao.windvane.extra.uc.WVUCWebView.SwitchValueCallback.1
                @Override // java.lang.Runnable
                public void run() {
                    if (WVUCWebView.coreEventCallback != null) {
                        WVCoreSettings.getInstance().setCoreEventCallback(WVUCWebView.coreEventCallback);
                    }
                    if (WVCoreSettings.getInstance().coreEventCallbacks != null) {
                        for (CoreEventCallback coreEventCallback : WVCoreSettings.getInstance().coreEventCallbacks) {
                            if (coreEventCallback != null) {
                                coreEventCallback.onCoreSwitch();
                            }
                        }
                    }
                    WVEventService.getInstance().onEvent(WVEventId.WV_CORE_SWITCH);
                    if (WVCore.getInstance().isUCSupport() || WebView.getCoreType() != 3) {
                        if (WebView.getCoreType() == 2) {
                            WVCore.getInstance().setUCSupport(false);
                            return;
                        }
                        return;
                    }
                    WVCore.getInstance().setUCSupport(true);
                    WVEventService.getInstance().onEvent(WVEventId.WV_UCCORE_PREPARED);
                    TaoLog.m24i(WVUCWebView.TAG, "UCSDK onUCMCoreSwitched: " + WebView.getCoreType());
                    if (WVCoreSettings.getInstance().coreEventCallbacks != null) {
                        for (CoreEventCallback coreEventCallback2 : WVCoreSettings.getInstance().coreEventCallbacks) {
                            if (coreEventCallback2 != null) {
                                coreEventCallback2.onUCCorePrepared();
                            }
                        }
                    }
                    if (GlobalConfig.context == null || !WVUCWebView.initAfterUCCoreReady.compareAndSet(false, true)) {
                        return;
                    }
                    WVUCWebView.initAfterUCReady(GlobalConfig.context, SwitchValueCallback.this.startTime);
                }
            });
        }
    }

    /* compiled from: Taobao */
    protected class WVDownLoadListener implements DownloadListener {
        protected WVDownLoadListener() {
        }

        @Override // android.webkit.DownloadListener
        public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
            if (TaoLog.getLogStatus()) {
                TaoLog.m18d(WVUCWebView.TAG, "Download start, url: " + str + " contentDisposition: " + str3 + " mimetype: " + str4 + " contentLength: " + j);
            }
            if (!WVUCWebView.this.supportDownload) {
                TaoLog.m30w(WVUCWebView.TAG, "DownloadListener is not support for webview.");
                return;
            }
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
            intent.setFlags(268435456);
            try {
                WVUCWebView.this.context.startActivity(intent);
            } catch (ActivityNotFoundException e) {
                Toast.makeText(WVUCWebView.this._getContext(), EnvUtil.isCN() ? "对不起，您的设备找不到相应的程序" : "Can not find the corresponding application", 1).show();
                TaoLog.m21e(WVUCWebView.TAG, "DownloadListener not found activity to open this url." + e.getMessage());
            }
        }
    }

    /* compiled from: Taobao */
    public static class WVValueCallback implements ValueCallback<String> {
        @Override // android.webkit.ValueCallback
        public void onReceiveValue(String str) {
            TaoLog.m24i(WVUCWebView.TAG, "support : " + WVCore.getInstance().isUCSupport() + " UC SDK Callback : " + str);
            try {
                UserTrackUtil.commitEvent(UserTrackUtil.EVENTID_PA_UCSDK, String.valueOf(WVCore.getInstance().isUCSupport()), String.valueOf(WVUCWebView.getUseTaobaoNetwork()), str);
            } catch (Throwable th) {
                TaoLog.m21e(WVUCWebView.TAG, "UC commitEvent failed : " + th.getMessage());
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public interface whiteScreenCallback {
        void isPageEmpty(String str);
    }

    static {
        evaluateJavascriptSupported = Build.VERSION.SDK_INT >= 19;
        isSWInit = false;
        coreEventCallback = null;
        initedJSBridge = false;
        TaoLog.m18d(TAG, "static init uc core");
        if (GlobalConfig.getInstance().getInjectCode() == -1) {
            GlobalConfig.getInstance().setInjectCode(2);
        }
        if (!GlobalConfig.getInstance().isUcCoreOuterControl()) {
            initUCCore();
        }
        initAfterUCCoreReady = new AtomicBoolean(false);
        renderMultiPolicy = 0;
        gpuMultiPolicy = 0;
        needDownLoad = false;
    }

    public WVUCWebView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i, isUseSystemWebView(context));
        this.bizCode = "";
        this.flag4commit = false;
        this.mSpanWrapper = new SpanWrapper();
        this.isLive = false;
        this.mIsCoreDestroy = false;
        this.aliRequestAdapter = null;
        this.wvfspManager = new WVFSPManager();
        this.wvh5PPManager = new WVH5PPManager(this);
        this.wvErrorManager = new WVErrorManager();
        this.pageTracker = new WVPageTracker();
        this.wpData = new WVWPData();
        this.reportedFSP = false;
        this.isPreInit = false;
        this.wvSecurityFilter = null;
        this.jsPatchListener = null;
        this.mHandler = null;
        this.supportDownload = true;
        this.mWvNativeCallbackId = 1000;
        this.dataOnActive = null;
        this.longPressSaveImage = true;
        this.ucParam = "";
        this.currentUrl = null;
        this.cachedUrl = null;
        String[] strArr = new String[1];
        strArr[0] = EnvUtil.isCN() ? "保存到相册" : "Save to album";
        this.mPopupMenuTags = strArr;
        this.mLongClickListener = null;
        this.useUrlConfig = false;
        this.mUseGlobalUrlConfig = GlobalConfig.getInstance().isUseGlobalUrlConfig();
        this.mAllowAllOpen = false;
        this.mPageLoadedCount = 0;
        this.popupClickListener = new View.OnClickListener() { // from class: android.taobao.windvane.extra.uc.WVUCWebView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (WVUCWebView.this.mPopupMenuTags != null && WVUCWebView.this.mPopupMenuTags.length > 0 && WVUCWebView.this.mPopupMenuTags[0].equals(view.getTag())) {
                    try {
                        PermissionProposer.buildPermissionTask(WVUCWebView.this.context, new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}).setTaskOnPermissionGranted(new Runnable() { // from class: android.taobao.windvane.extra.uc.WVUCWebView.1.2
                            @Override // java.lang.Runnable
                            public void run() {
                                Context context2 = WVUCWebView.this.context;
                                if (context2 == null) {
                                    return;
                                }
                                ImageTool.saveImageToDCIM(context2.getApplicationContext(), WVUCWebView.this.mImageUrl, WVUCWebView.this.mHandler);
                            }
                        }).setTaskOnPermissionDenied(new Runnable() { // from class: android.taobao.windvane.extra.uc.WVUCWebView.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                WVUCWebView.this.mHandler.sendEmptyMessage(WVConstants.NOTIFY_SAVE_IMAGE_FAIL);
                            }
                        }).execute();
                    } catch (Exception unused) {
                    }
                }
                if (WVUCWebView.this.mPopupController != null) {
                    WVUCWebView.this.mPopupController.hide();
                }
            }
        };
        this.wvUIModel = null;
        this.onErrorTime = 0L;
        this.pid = "";
        this.uid = "";
        this.mIsStaticWebView = false;
        this.firstTimeLoad = true;
        this.isUser = true;
        this.mEventSparseArray = new SparseArray<>();
        this.mH5MonitorCache = null;
        this.mPageStart = 0L;
        this.injectJs = new StringBuilder("javascript:");
        this.context = context;
        init();
    }

    private static boolean checkOldCoreVersion(String str) {
        return false;
    }

    private static void checkSW() {
        try {
            TaoLog.m18d(TAG, "start to set ServiceWorker client");
            ServiceWorkerController serviceWorkerController = ServiceWorkerController.getInstance();
            if (serviceWorkerController != null) {
                serviceWorkerController.setServiceWorkerClient(new WVUCServiceWorkerClient());
            }
            isSWInit = true;
        } catch (Throwable unused) {
            isSWInit = false;
            TaoLog.m30w(TAG, "failed to set ServiceWorker client");
        }
    }

    public static void createStaticWebViewIfNeeded(final Context context) {
        if (isWebViewMultiProcessEnabled()) {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: android.taobao.windvane.extra.uc.WVUCWebView.4
                @Override // java.lang.Runnable
                public void run() {
                    WVUCWebView.createStaticWebViewOnMainThread(context);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void createStaticWebViewOnMainThread(Context context) {
        TaoLog.m24i("sandbox", "createStaticWebViewOnMainThread");
        if (sStaticUCWebView == null) {
            WVUCWebView wVUCWebView = new WVUCWebView(context.getApplicationContext(), true);
            sStaticUCWebView = wVUCWebView;
            wVUCWebView.loadUrl(STATIC_WEBVIEW_URL);
        }
    }

    public static void destroyStaticWebViewIfNeeded() {
        if (isWebViewMultiProcessEnabled()) {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: android.taobao.windvane.extra.uc.WVUCWebView.5
                @Override // java.lang.Runnable
                public void run() {
                    WVUCWebView.destroyStaticWebViewOnMainThread();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void destroyStaticWebViewOnMainThread() {
        TaoLog.m24i("sandbox", "destroyStaticWebViewOnMainThread");
        WVUCWebView wVUCWebView = sStaticUCWebView;
        if (wVUCWebView != null) {
            wVUCWebView.destroy();
            sStaticUCWebView = null;
        }
    }

    private static String getBusinessDecompressRootDir(Context context) {
        return UCCore.getExtractRootDirPath(context);
    }

    private static String getCore7zDecompressDir(Context context, String str) {
        return UCCore.getExtractDirPath(context, str);
    }

    public static String getCurrentNetworkType(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo == null) {
            return "null";
        }
        if (activeNetworkInfo.getType() == 1 || activeNetworkInfo.getType() == 9) {
            return WIFI;
        }
        if (activeNetworkInfo.getType() == 0) {
            int subtype = activeNetworkInfo.getSubtype();
            if (subtype == 4 || subtype == 1 || subtype == 2) {
                return _2G;
            }
            if (subtype == 3 || subtype == 8 || subtype == 6 || subtype == 5 || subtype == 12) {
                return _3G;
            }
            if (subtype == 13) {
                return _4G;
            }
            WVCommonConfig.getInstance();
            if (WVCommonConfig.commonConfig.open5GAdapter && subtype == 20) {
                return _5g;
            }
        }
        return "";
    }

    public static boolean getDegradeAliNetwork() {
        return mDegradeAliNetwork;
    }

    public static int getFromType() {
        fromType = 70;
        if (WVCore.getInstance().isUCSupport()) {
            fromType = getUseTaobaoNetwork() ? 6 : 5;
        } else if (!mUseSystemWebView) {
            fromType = 71;
        }
        return fromType;
    }

    private static String getMultiProcessPrivateDataDirectorySuffix() {
        if (isMainProcess()) {
            return "0";
        }
        String substring = CommonUtils.getProcessName(GlobalConfig.context).substring(GlobalConfig.context.getPackageName().length() + 1);
        if (substring == null || substring.length() <= 0) {
            throw new RuntimeException(String.format("%s getMultiProcessPrivateDataDirectorySuffix failure!Subprocess name: %s illegal.", TAG, CommonUtils.getProcessName(GlobalConfig.context)));
        }
        return substring;
    }

    private static String getOld7zDecompressPath(Context context) {
        String stringVal = ConfigStorage.getStringVal(TBConfigManager.WINDVANE_CONFIG, "UC_PATH");
        TaoLog.m24i(TAG, "get dex path:[" + stringVal + "]");
        return stringVal;
    }

    @Deprecated
    public static boolean getUCSDKSupport() {
        return WVCore.getInstance().isUCSupport();
    }

    public static boolean getUseTaobaoNetwork() {
        return WVCore.getInstance().isUCSupport() && mUseAliNetwork;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SuppressLint({"SetJavaScriptEnabled"})
    private void init() {
        String str;
        FalcoSpan makeSpanChildOf = FullTraceUtils.makeSpanChildOf("windvanePage", "H5Page", this.isPreInit ? null : getOpenTracingContext());
        this.containerSpan = makeSpanChildOf;
        setFalcoSpan(makeSpanChildOf);
        try {
            setTag(ViewToken.APM_VIEW_TOKEN, "invalid_view");
            setTag(ViewToken.VIEW_MANUAL_CALCULATE, Boolean.TRUE);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        this.wvh5PPManager.webViewDidStartInit();
        if (!sCoreInitialized.get()) {
            Log.e(TAG, "uc compensation initialization");
            initUCCore();
        }
        if (WVMonitorService.getWvMonitorInterface() != null) {
            WVMonitorService.getWvMonitorInterface().WebViewWrapType(this.context.getClass().getSimpleName());
        }
        this.mIsCoreDestroy = false;
        TaoLog.m24i(TAG, "uc webview init ");
        setContentDescription(TAG);
        this.mHandler = new Handler(Looper.getMainLooper(), this);
        if (GlobalConfig.getInstance().needSpeed() && !isSWInit) {
            checkSW();
        }
        if (WebView.getCoreType() == 3 && EnvUtil.isAppDebug()) {
            WebView.setWebContentsDebuggingEnabled(true);
        }
        this.isLive = true;
        WVCommonConfig.getInstance();
        WVCommonConfigData wVCommonConfigData = WVCommonConfig.commonConfig;
        setUseTaobaoNetwork(!mDegradeAliNetwork && wVCommonConfigData.ucsdk_alinetwork_rate > Math.random());
        TaoLog.m18d(TAG, "Webview init setUseTaobaoNetwork =" + getUseTaobaoNetwork());
        WVCommonConfig.getInstance();
        if (!TextUtils.isEmpty(wVCommonConfigData.ucCoreUrl)) {
            String str2 = UC_CORE_URL;
            WVCommonConfig.getInstance();
            if (!str2.equals(wVCommonConfigData.ucCoreUrl)) {
                Application application = GlobalConfig.context;
                WVCommonConfig.getInstance();
                UCCore.update(application, wVCommonConfigData.ucCoreUrl, new Callable<Boolean>() { // from class: android.taobao.windvane.extra.uc.WVUCWebView.6
                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // java.util.concurrent.Callable
                    public Boolean call() throws Exception {
                        return Boolean.valueOf(NetWork.isConnectionInexpensive());
                    }
                });
            }
        }
        try {
            WVCommonConfig.getInstance();
            if (!TextUtils.isEmpty(wVCommonConfigData.cookieUrlRule)) {
                pattern = Pattern.compile(wVCommonConfigData.cookieUrlRule);
            }
        } catch (Exception e) {
            TaoLog.m21e(TAG, "Pattern complile Exception" + e.getMessage());
        }
        WVRenderPolicy.disableAccessibility(this.context);
        WebSettings settings = getSettings();
        if (getCurrentViewCoreType() == 2 && Build.VERSION.SDK_INT >= 21 && settings != null) {
            settings.setMixedContentMode(0);
        }
        settings.setJavaScriptEnabled(true);
        settings.setDomStorageEnabled(true);
        int i = Build.VERSION.SDK_INT;
        if (i < 18) {
            settings.setSavePassword(false);
        }
        settings.setDatabaseEnabled(false);
        settings.setDatabasePath(this.context.getApplicationInfo().dataDir + "/localstorage");
        settings.setGeolocationEnabled(true);
        String appTag = GlobalConfig.getInstance().getAppTag();
        String appVersion = GlobalConfig.getInstance().getAppVersion();
        String userAgentString = settings.getUserAgentString();
        if (userAgentString != null) {
            if (!TextUtils.isEmpty(appTag) && !TextUtils.isEmpty(appVersion)) {
                userAgentString = userAgentString + " AliApp(" + appTag + WVNativeCallbackUtil.SEPERATER + appVersion + ")";
            }
            if (!userAgentString.contains("UCBS/") && getCurrentViewCoreType() == 3) {
                userAgentString = userAgentString + " UCBS/2.11.1.1";
            }
            if (!userAgentString.contains("TTID/") && !TextUtils.isEmpty(GlobalConfig.getInstance().getTtid())) {
                userAgentString = userAgentString + " TTID/" + GlobalConfig.getInstance().getTtid();
            }
        }
        settings.setUserAgentString(userAgentString + GlobalConfig.DEFAULT_UA);
        settings.setCacheMode(-1);
        settings.setMediaPlaybackRequiresUserGesture(false);
        settings.setLoadWithOverviewMode(true);
        settings.setUseWideViewPort(true);
        UCCore.setGlobalOption("adapter_build_version", appVersion);
        if (i >= 14) {
            settings.setTextZoom(WebSettings.TextSize.NORMAL.value);
        }
        if (mUseAliNetwork && getUCExtension() != null) {
            getUCExtension().getUCSettings();
            UCSettings.setGlobalIntValue("UCCookieType", 1);
        }
        if (getCurrentViewCoreType() == 1 || getCurrentViewCoreType() == 3) {
            TaoLog.m18d(TAG, "init  CurrentViewCoreType()= " + getCurrentViewCoreType());
            WVCore.getInstance().setUCSupport(true);
            if (mUseAliNetwork) {
                AliNetworkAdapter aliNetworkAdapter = new AliNetworkAdapter(this.context.getApplicationContext(), bizId, this);
                this.aliRequestAdapter = aliNetworkAdapter;
                UCCore.setThirdNetwork(aliNetworkAdapter, new AliNetworkDecider());
            }
            WVCommonConfigData wVCommonConfigData2 = WVCommonConfig.commonConfig;
            if (wVCommonConfigData2.openLog) {
                UCCore.setNetLogger(new UCLog());
            }
            UCSettings.setGlobalBoolValue("EnableCustomErrPage", true);
            UCSettings.updateBussinessInfo(1, 1, "u4_focus_auto_popup_input_list", wVCommonConfigData2.ucParam.u4FocusAutoPopupInputHostList);
            UCSettings.updateBussinessInfo(1, 1, "crwp_embed_surface_embed_view_enable_list", wVCommonConfigData2.ucParam.cdResourceEmbedSurfaceEmbedViewEnableList);
            UCSettings.updateBussinessInfo(1, 1, "crwp_embed_view_reattach_list", "map");
            setPageCacheCapacity(5);
            try {
                String str3 = WVCookieConfig.getInstance().cookieBlackList;
                if (!TextUtils.isEmpty(str3)) {
                    TaoLog.m24i(TAG, "set cookie black list = " + str3 + " to uc");
                    UCSettings.setGlobalStringValue("CookiesBlacklistForJs", str3);
                }
            } catch (Throwable unused) {
            }
            AppMonitorUtil.commitSuccess(AppMonitorUtil.MONITOR_POINT_WEB_CORE_TYPE, null);
        } else {
            TaoLog.m21e(TAG, "core type: Android");
            if (WVCommonConfig.commonConfig.useSystemWebView) {
                str = "forceSystem";
            } else if (GlobalConfig.getInstance().getInjectCode() == 0) {
                str = "injectError";
            } else if (!sCoreInitialized.get()) {
                str = "coreNotInit";
            } else if (WVCore.getInstance().isUCSupport()) {
                str = "successInit";
            } else {
                str = "core_" + coreCode;
            }
            AppMonitorUtil.commitFail(AppMonitorUtil.MONITOR_POINT_WEB_CORE_TYPE, WebView.getCoreType(), str + "_" + GlobalConfig.getInstance().getInjectCode(), CommonUtils.getProcessName(this.context));
            TaoLog.m21e(TAG, "WebViewCoreTypeByPV coreType=" + WebView.getCoreType() + " errorMsg=" + str + "_" + GlobalConfig.getInstance().getInjectCode() + " process=" + CommonUtils.getProcessName(this.context));
        }
        UCCore.setStatDataCallback(new WVValueCallback());
        setWebViewClient(new WVUCWebViewClient(this.context));
        setWebChromeClient(new WVUCWebChromeClient(this.context));
        UCExtension uCExtension = getUCExtension();
        if (uCExtension != null) {
            uCExtension.setClient(new WVUCClient(this));
        }
        this.wvUIModel = new WVUIModel(_getContext(), this);
        WVJsBridge.getInstance().init();
        this.entryManager = new WVPluginEntryManager(this.context, this);
        WVAppEvent wVAppEvent = new WVAppEvent();
        wVAppEvent.initialize(_getContext(), this);
        addJsObject("AppEvent", wVAppEvent);
        if (!initedJSBridge) {
            WVPluginManager.registerPlugin("WVUCBase", (Class<? extends WVApiPlugin>) WVUCBase.class);
            WVPluginManager.registerPlugin("WVPerformance", (Class<? extends WVApiPlugin>) WVH5PP.class);
            WVPluginManager.registerPlugin("WVFullTrace", (Class<? extends WVApiPlugin>) WVFullTrace.class);
            WVPluginManager.registerPlugin("WVFalco", (Class<? extends WVApiPlugin>) WVFalco.class);
            initedJSBridge = true;
        }
        try {
            ((WVH5PP) getJsObject("WVPerformance")).resetAllStoredSet();
        } catch (Exception e2) {
            TaoLog.m18d(TAG, "resetAllStoredSet error: " + e2);
        }
        setSupportLocalStorageFile();
        this.jsPatchListener = new WVJsPatchListener(this);
        WVEventService.getInstance().addEventListener(this.jsPatchListener, WVEventService.WV_BACKWARD_EVENT);
        int i2 = Build.VERSION.SDK_INT;
        if (i2 > 10 && i2 < 17) {
            try {
                removeJavascriptInterface("searchBoxJavaBridge_");
                removeJavascriptInterface("accessibility");
                removeJavascriptInterface("accessibilityTraversal");
            } catch (Throwable th2) {
                TaoLog.m18d(TAG, "removeJavascriptInterface " + th2.getMessage());
            }
        }
        View.OnLongClickListener onLongClickListener = new View.OnLongClickListener() { // from class: android.taobao.windvane.extra.uc.WVUCWebView.7
            /* JADX WARN: Type inference failed for: r2v5, types: [android.taobao.windvane.extra.uc.WVUCWebView, android.view.View] */
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                try {
                    WebView.HitTestResult hitTestResult = WVUCWebView.this.getHitTestResult();
                    if (hitTestResult == null || !WVUCWebView.this.longPressSaveImage) {
                        return false;
                    }
                    if (TaoLog.getLogStatus()) {
                        TaoLog.m18d(WVUCWebView.TAG, "Long click on WebView, " + hitTestResult.getExtra());
                    }
                    if (hitTestResult.getType() != 8 && hitTestResult.getType() != 5) {
                        return false;
                    }
                    WVUCWebView.this.mImageUrl = hitTestResult.getExtra();
                    WVUCWebView wVUCWebView = WVUCWebView.this;
                    Context _getContext = wVUCWebView._getContext();
                    ?? r2 = WVUCWebView.this;
                    wVUCWebView.mPopupController = new PopupWindowController(_getContext, r2, ((WVUCWebView) r2).mPopupMenuTags, WVUCWebView.this.popupClickListener);
                    WVUCWebView.this.mPopupController.show();
                    return true;
                } catch (Exception e3) {
                    TaoLog.m21e(WVUCWebView.TAG, "getHitTestResult error:" + e3.getMessage());
                    return false;
                }
            }
        };
        this.mLongClickListener = onLongClickListener;
        setOnLongClickListener(onLongClickListener);
        if (WVMonitorService.getPackageMonitorInterface() != null) {
            WVMonitorService.getPerformanceMonitor().didWebViewInitAtTime(System.currentTimeMillis());
        }
        if (Build.VERSION.SDK_INT >= 11 && WVRenderPolicy.shouldDisableHardwareRenderInLayer()) {
            try {
                setLayerType(1, null);
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }
        try {
            CookieManager.getInstance().setAcceptCookie(true);
        } catch (Throwable unused2) {
        }
        setAcceptThirdPartyCookies();
        addJavascriptInterface(new WVBridgeEngine(this), "__windvane__");
        injectJsEarly(WVBridgeEngine.WINDVANE_CORE_JS);
        try {
            ArrayList<String> embedViewNames = WVEVManager.getEmbedViewNames();
            for (String str4 : WVCommonConfig.commonConfig.disableMixViews) {
                embedViewNames.remove(str4);
            }
            StringBuilder sb = new StringBuilder("window.__mix_view_environment__={availableTypes:{");
            Iterator<String> it = embedViewNames.iterator();
            while (it.hasNext()) {
                sb.append(it.next());
                sb.append(":");
                sb.append("[]");
                sb.append(",");
            }
            if (sb.toString().contains(",")) {
                sb.deleteCharAt(sb.lastIndexOf(","));
            }
            sb.append("},matchType:'name',isForAppX:'no'}");
            injectJsEarly(sb.toString());
        } catch (Throwable unused3) {
        }
        this.wvh5PPManager.webViewDidFinishInit();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void initAfterUCReady(Context context, long j) {
        new UCHAManager().initHAParam(GlobalConfig.getInstance().getUcHASettings());
        try {
            Application application = GlobalConfig.context;
            UCCore.updateUCPlayer(application, UC_PLAYER_URL, new DownloadEnv(application));
        } catch (Exception e) {
            TaoLog.m21e("UCCore", "UCCore update UCPlayer failed:" + e.getMessage());
        }
        WVEventService.getInstance().onEvent(WVEventId.WV_UCCORE_PREPARED);
    }

    @Keep
    @Deprecated
    public static void initUCCore() {
        initUCCore(GlobalConfig.context);
    }

    @Deprecated
    public static boolean initUCLIb(Context context) {
        if (shouldUCLibInit.get()) {
            if (context == null) {
                return false;
            }
            return initUCLIb(GlobalConfig.getInstance().getUcsdkappkeySec(), context.getApplicationContext());
        }
        RuntimeException runtimeException = new RuntimeException("init uclib outer");
        runtimeException.fillInStackTrace();
        TaoLog.m21e(TAG, runtimeException.getStackTrace()[0].toString() + "\n" + runtimeException.getStackTrace()[1].toString() + "\n" + runtimeException.getStackTrace()[2].toString());
        return false;
    }

    public static boolean initUCLibBy7Z(String[] strArr, Context context, Object[] objArr) {
        INNER_FLAG = 1;
        String ucCore7ZFilePath = ucCore7ZFilePath(context);
        String old7zDecompressPath = getOld7zDecompressPath(context);
        if (old7zDecompressPath.equals(getCore7zDecompressDir(context, ucCore7ZFilePath))) {
            old7zDecompressPath = "";
        }
        TaoLog.m24i(TAG, "UCSDK initUCLibBy7Z zipPath: " + ucCore7ZFilePath);
        try {
            SetupTask upVar = BusinessWrapper.setup("CONTEXT", context.getApplicationContext());
            SetupTask upVar2 = upVar.setup("bo_dec_r_p", getBusinessDecompressRootDir(context)).setup("webview_multi_process", Integer.valueOf(renderMultiPolicy)).setup("gpu_process_mode", Integer.valueOf(gpuMultiPolicy));
            WVCommonConfigData wVCommonConfigData = WVCommonConfig.commonConfig;
            SetupTask upVar3 = upVar2.setup("webview_multi_process_fallback_timeout", Integer.valueOf(wVCommonConfigData.ucMultiTimeOut)).setup("webview_multi_process_enable_service_speedup", Boolean.valueOf(wVCommonConfigData.ucMultiServiceSpeedUp));
            Boolean bool = Boolean.TRUE;
            upVar3.setup("bo_f_u_dec_r_p", bool).setup("first_use_sw", Boolean.valueOf(wVCommonConfigData.firstUseSystemWebViewOn7zInit)).setup("bo_new_ucm_zf", ucCore7ZFilePath).setup("bo_new_ucm_z_type", "7z").setup("bo_old_dex_dp", old7zDecompressPath).setup("bo_dex_old_dex_dir", Boolean.valueOf(isMainProcess())).setup("bo_skip_io_dc", bool).setup("bo_prom_sp_v_c_i", new OldCoreVersionCallable()).setup("bo_s_i_uc_core", new OnInitStart()).setup("bo_dec_cl", new DecompressCallable(context)).onEvent("be_init_success", new ValueCallback<SetupTask>() { // from class: android.taobao.windvane.extra.uc.WVUCWebView.3
                @Override // android.webkit.ValueCallback
                public void onReceiveValue(SetupTask setupTask) {
                    Object field;
                    UCMRunningInfo totalLoadedUCM = UCSetupTask.getTotalLoadedUCM();
                    if (totalLoadedUCM == null || (field = ReflectUtils.getField(totalLoadedUCM, "ucmPackageInfo")) == null) {
                        return;
                    }
                    Object field2 = ReflectUtils.getField(field, "dataDir");
                    if (field2 instanceof String) {
                        WVUCWebView.saveUCCoeDexDirPath((String) field2);
                    }
                }
            });
            setupUCParam(ucCore7ZFilePath);
            upVar.setup("CONTEXT", context.getApplicationContext()).setup("provided_keys", strArr).setup("VIDEO_AC", bool).setup("AC", bool).setup("core_ver_excludes", wVCommonConfigData.excludeUCVersions).setup("MULTI_CORE_TYPE", bool).setup("SYSTEM_WEBVIEW", Boolean.valueOf(mUseSystemWebView)).setup("WEBVIEW_POLICY", 2).setup("loadPolicy", "SPECIFIED_ONLY").setup("VERIFY_POLICY", 0).setup("delete_core", Integer.valueOf(GlobalConfig.getInstance().getDeleteCorePolicy())).setup("log_conf", objArr).setup("wait_fallback_sys", Integer.valueOf(GlobalConfig.getInstance().getUcCoreWaitMills())).setup("ucPlayer", Boolean.valueOf(wVCommonConfigData.useUCPlayer)).setup("skip_old_extra_kernel", Boolean.valueOf(wVCommonConfigData.ucSkipOldKernel)).setup("sdk_international_env", Boolean.valueOf(GlobalConfig.getInstance().isUcSdkInternationalEnv())).setup("startup_policy", Integer.valueOf(wVCommonConfigData.initWebPolicy)).setup("PRIVATE_DATA_DIRECTORY_SUFFIX", getMultiProcessPrivateDataDirectorySuffix()).setup("disable_multi_unknown_crash", Boolean.valueOf(GlobalConfig.getInstance().isDisableMultiUnknownCrash())).onEvent("exception", new ExceptionValueCallback()).onEvent(FileManager.UNZIP_SUCCESS, new CorePreparedCallback(System.currentTimeMillis())).onEvent("switch", new SwitchValueCallback(System.currentTimeMillis())).setAsDefault().start();
        } catch (Exception e) {
            TaoLog.m21e(TAG, "initUCLibBy7Z fail " + e.getMessage());
        }
        return !mUseSystemWebView;
    }

    public static boolean initUCLibByDownload(String[] strArr, Context context, Object[] objArr) {
        SetupTask upVar;
        try {
            WVCommonConfigData wVCommonConfigData = WVCommonConfig.commonConfig;
            setUcCoreUrl(wVCommonConfigData.ucCoreUrl);
            if (TextUtils.isEmpty(GlobalConfig.getInstance().getUcLibDir())) {
                TaoLog.m24i(TAG, "下载内核初始化");
                setupUCParam(null);
                upVar = UCCore.setup("dlChecker", GlobalConfig.getInstance().getUcDownloadChecker() != null ? GlobalConfig.getInstance().getUcDownloadChecker() : new DownloadEnv(GlobalConfig.context)).setup("ucmUpdUrl", UC_CORE_URL);
            } else {
                upVar = UCCore.setup("dexFilePath", GlobalConfig.getInstance().getUcLibDir());
                TaoLog.m24i(TAG, "asset目录内核初始化");
                INNER_FLAG = 2;
            }
            int i = wVCommonConfigData.webMultiPolicy;
            int i2 = wVCommonConfigData.gpuMultiPolicy;
            SetupTask upVar2 = upVar.setup("CONTEXT", context.getApplicationContext()).setup("webview_multi_process", Integer.valueOf(renderMultiPolicy)).setup("gpu_process_mode", Integer.valueOf(gpuMultiPolicy)).setup("webview_multi_process_fallback_timeout", Integer.valueOf(wVCommonConfigData.ucMultiTimeOut)).setup("webview_multi_process_enable_service_speedup", Boolean.valueOf(wVCommonConfigData.ucMultiServiceSpeedUp)).setup("provided_keys", strArr);
            Boolean bool = Boolean.TRUE;
            upVar2.setup("VIDEO_AC", bool).setup("AC", bool).setup("core_ver_excludes", wVCommonConfigData.excludeUCVersions).setup("MULTI_CORE_TYPE", bool).setup("SYSTEM_WEBVIEW", Boolean.valueOf(mUseSystemWebView)).setup("WEBVIEW_POLICY", 2).setup("loadPolicy", "SPECIFIED_ONLY").setup("VERIFY_POLICY", 0).setup("delete_core", Integer.valueOf(GlobalConfig.getInstance().getDeleteCorePolicy())).setup("log_conf", objArr).setup("wait_fallback_sys", Integer.valueOf(GlobalConfig.getInstance().getUcCoreWaitMills())).setup("ucPlayer", Boolean.valueOf(wVCommonConfigData.useUCPlayer)).setup("skip_old_extra_kernel", Boolean.valueOf(wVCommonConfigData.ucSkipOldKernel)).setup("sdk_international_env", Boolean.valueOf(GlobalConfig.getInstance().isUcSdkInternationalEnv())).setup("startup_policy", Integer.valueOf(wVCommonConfigData.initWebPolicy)).setup("PRIVATE_DATA_DIRECTORY_SUFFIX", getMultiProcessPrivateDataDirectorySuffix()).setup("disable_multi_unknown_crash", Boolean.valueOf(GlobalConfig.getInstance().isDisableMultiUnknownCrash())).onEvent("updateProgress", new DownLoadCallback()).onEvent("exception", new ExceptionValueCallback()).onEvent(FileManager.UNZIP_SUCCESS, new CorePreparedCallback(System.currentTimeMillis())).onEvent("switch", new SwitchValueCallback(System.currentTimeMillis())).setAsDefault().start();
            TaoLog.m24i("UCCore", "final UCCore:" + UC_CORE_URL);
        } catch (Exception e) {
            TaoLog.m21e("UCCore", "UCCore init fail " + e.getMessage());
        }
        return !mUseSystemWebView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isMainProcess() {
        boolean isMainProcess = CommonUtils.isMainProcess(GlobalConfig.context);
        TaoLog.m24i(TAG, "是否在主进程:" + isMainProcess);
        return isMainProcess;
    }

    public static boolean isNeedCookie(String str) {
        Matcher matcher;
        try {
            Pattern pattern2 = pattern;
            if (pattern2 == null || (matcher = pattern2.matcher(str)) == null) {
                return true;
            }
            return !matcher.matches();
        } catch (Exception e) {
            TaoLog.m21e(TAG, "Pattern complile Exception" + e.getMessage());
            return true;
        }
    }

    public static boolean isNeedDownLoad() {
        return needDownLoad;
    }

    private static boolean isUseSystemWebView(Context context) {
        boolean z = mUseSystemWebView;
        if (!z) {
            try {
                String config = OrangeConfig.getInstance().getConfig(TBConfigManager.WINDVANE_COMMMON_CONFIG, "useSysWebViewBizList", "");
                if (!TextUtils.isEmpty(config)) {
                    String[] split = config.split(";");
                    String name = context.getClass().getName();
                    for (String str : split) {
                        if (name.equals(str)) {
                            z = true;
                        }
                    }
                }
            } catch (Throwable unused) {
            }
        }
        return z;
    }

    public static boolean isWebViewMultiProcessEnabled() {
        return WVCommonConfig.commonConfig.webMultiPolicy > 0;
    }

    private static Object[] logConfigCreate() {
        return new Object[]{Boolean.TRUE, Boolean.FALSE, new ValueCallback<Object[]>() { // from class: android.taobao.windvane.extra.uc.WVUCWebView.2
            @Override // android.webkit.ValueCallback
            public void onReceiveValue(Object[] objArr) {
                WVUCWebView.uploadLog(objArr);
            }
        }, "[all]", "[all]"};
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void onUCMCoreSwitched(Context context, long j) {
        TaoLog.m24i(TAG, "UCSDK init onUCMCoreSwitched: " + WebView.getCoreType());
        if (WVCore.getInstance().isUCSupport() || WebView.getCoreType() != 3) {
            return;
        }
        TaoLog.m24i(TAG, "CorePreparedCallback   isUCSDKSupport = true");
        WVCore.getInstance().setUCSupport(true);
        coreCode = 0;
        if (coreEventCallback != null) {
            WVCoreSettings.getInstance().setCoreEventCallback(coreEventCallback);
        }
        if (WVCoreSettings.getInstance().coreEventCallbacks != null) {
            for (CoreEventCallback coreEventCallback2 : WVCoreSettings.getInstance().coreEventCallbacks) {
                if (coreEventCallback2 != null) {
                    coreEventCallback2.onUCCorePrepared();
                }
            }
        }
        WVCommonConfig.getInstance();
        if (WVCommonConfig.commonConfig.enableThreadWatchdog) {
            UCCoreController.registerThreadANRCallback(sSpanWrapper);
        }
        if (initAfterUCCoreReady.compareAndSet(false, true)) {
            initAfterUCReady(context, j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void saveUCCoeDexDirPath(String str) {
        TaoLog.m24i(TAG, "save dex path:[" + str + "]");
        ConfigStorage.putStringVal(TBConfigManager.WINDVANE_CONFIG, "UC_PATH", str);
    }

    private void setAcceptThirdPartyCookies() {
        if (Build.VERSION.SDK_INT < 21 || WebView.getCoreType() == 1 || WebView.getCoreType() == 3) {
            return;
        }
        try {
            View view = getView();
            if (view == null || !(view instanceof android.webkit.WebView)) {
                return;
            }
            CookieManager.getInstance().setAcceptThirdPartyCookies((android.webkit.WebView) view, true);
        } catch (Throwable unused) {
        }
    }

    public static void setBizCode(String str) {
        bizId = str;
    }

    @Deprecated
    public static void setCoreEventCallback(CoreEventCallback coreEventCallback2) {
        coreEventCallback = coreEventCallback2;
    }

    public static void setDegradeAliNetwork(boolean z) {
        mDegradeAliNetwork = z;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0050, code lost:
    
        if (r0 != false) goto L20;
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0046  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void setMultiPolicy(android.content.Context r8) {
        /*
            android.taobao.windvane.config.WVCommonConfigData r0 = android.taobao.windvane.config.WVCommonConfig.commonConfig
            int r1 = r0.webMultiPolicy
            java.lang.String r1 = java.lang.String.valueOf(r1)
            int r0 = r0.gpuMultiPolicy
            java.lang.String r0 = java.lang.String.valueOf(r0)
            java.lang.String r2 = "1"
            boolean r3 = android.text.TextUtils.equals(r2, r1)
            java.lang.String r4 = "2"
            boolean r1 = android.text.TextUtils.equals(r4, r1)
            boolean r2 = android.text.TextUtils.equals(r2, r0)
            boolean r0 = android.text.TextUtils.equals(r4, r0)
            boolean r4 = isMainProcess()
            r5 = 2
            r6 = 1
            r7 = 0
            if (r4 == 0) goto L3d
            if (r3 == 0) goto L2f
        L2d:
            r8 = 1
            goto L3e
        L2f:
            if (r1 == 0) goto L3d
            android.taobao.windvane.extra.core.WVCore r1 = android.taobao.windvane.extra.core.WVCore.getInstance()
            boolean r8 = r1.checkIsolateIfOpen(r8)
            if (r8 == 0) goto L2d
            r8 = 2
            goto L3e
        L3d:
            r8 = 0
        L3e:
            android.taobao.windvane.extra.p002uc.WVUCWebView.renderMultiPolicy = r8
            int r8 = android.os.Build.VERSION.SDK_INT
            r1 = 21
            if (r8 < r1) goto L53
            boolean r8 = isMainProcess()
            if (r8 == 0) goto L53
            if (r2 == 0) goto L50
            r5 = 1
            goto L54
        L50:
            if (r0 == 0) goto L53
            goto L54
        L53:
            r5 = 0
        L54:
            android.taobao.windvane.extra.p002uc.WVUCWebView.gpuMultiPolicy = r5
            android.taobao.windvane.extra.core.WVCore r8 = android.taobao.windvane.extra.core.WVCore.getInstance()
            int r0 = android.taobao.windvane.extra.p002uc.WVUCWebView.renderMultiPolicy
            r8.setUsedWebMulti(r0)
            android.taobao.windvane.extra.core.WVCore r8 = android.taobao.windvane.extra.core.WVCore.getInstance()
            int r0 = android.taobao.windvane.extra.p002uc.WVUCWebView.gpuMultiPolicy
            r8.setUsedGpuMulti(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: android.taobao.windvane.extra.p002uc.WVUCWebView.setMultiPolicy(android.content.Context):void");
    }

    private void setSupportLocalStorageFile() {
        if (Build.VERSION.SDK_INT < 23) {
            this.wvSecurityFilter = new WVSecurityFilter();
            WVEventService.getInstance().addEventListener(this.wvSecurityFilter, WVEventService.WV_FORWARD_EVENT);
        }
    }

    public static void setUcCoreUrl(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        UC_CORE_URL = str;
    }

    public static void setUseSystemWebView(boolean z) {
        mUseSystemWebView = z;
        fromType = 70;
    }

    public static void setUseTaobaoNetwork(boolean z) {
        mUseAliNetwork = z;
    }

    private static void setupUCParam(String str) {
        WVCommonConfigData wVCommonConfigData = WVCommonConfig.commonConfig;
        UCParamData uCParamData = wVCommonConfigData.ucParam;
        if (!wVCommonConfigData.enableUcShareCore || uCParamData == null || (!UCParamData.hostApp() && !UCParamData.needLoadNeedShareCoreApp())) {
            TaoLog.m30w(TAG, "not taobao, or shared core disabled by config, or uc param is empty.");
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            if (UCParamData.hostApp() && TextUtils.isEmpty(uCParamData.scLoadPolicyCd) && !NetWork.isConnectionInexpensive()) {
                uCParamData.scLoadPolicyCd = "sc_lshco";
                uCParamData.scWaitMilts = "1";
            }
            if (!TextUtils.isEmpty(uCParamData.scWaitMilts)) {
                jSONObject.put("sc_ustwm", uCParamData.scWaitMilts);
            }
            if (UCParamData.hostApp() && uCParamData.validShareCoreToSdcardParams()) {
                jSONObject.put("sc_ta_fp", uCParamData.sdCopyPathCd);
                jSONObject.put("sc_cpy", uCParamData.scCopyToSdcardCd);
                jSONObject.put("sc_hucmv", uCParamData.hostUcmVersionsCd);
                jSONObject.put("sc_udst", uCParamData.scStillUpd);
                if (!TextUtils.isEmpty(str)) {
                    jSONObject.put("sc_cd_fp", str);
                }
            }
            if (uCParamData.validShareCoreFromSdcardParams()) {
                jSONObject.put("sc_ta_fp", uCParamData.sdCopyPathCd);
                jSONObject.put("sc_taucmv", uCParamData.thirtyUcmVersionsCd);
                jSONObject.put("sc_ldpl", uCParamData.scLoadPolicyCd);
                jSONObject.put("sc_pkgl", uCParamData.scPkgNames);
            }
            String str2 = "JSON_CMD" + jSONObject.toString();
            TaoLog.m18d(TAG, str2);
            UCCore.setParam(str2);
        } catch (Throwable th) {
            TaoLog.m31w(TAG, "failed to setup uc param", th, new Object[0]);
        }
    }

    private void tryPrcacheDocument(String str) {
        if (WVUCPrecacheManager.getInstance().canPrecacheDoc(str) && this.webViewClient != null) {
            WebResourceResponse shouldInterceptRequest = this.webViewClient.shouldInterceptRequest(this, new WebResourceRequest(str, new HashMap()));
            if (shouldInterceptRequest == null) {
                WVUCPrecacheManager.getInstance().addPrecacheDoc(str);
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put(str, shouldInterceptRequest);
            HashMap hashMap2 = new HashMap();
            hashMap2.put("maxAge", WVPackageMonitorInterface.SECURITY_FAILED);
            hashMap2.put("ignoreQuery", "0");
            UCCore.precacheResources(hashMap, hashMap2);
        }
    }

    private static String ucCore7ZFilePath(Context context) {
        String uc7ZPath = GlobalConfig.getInstance().getUc7ZPath();
        if (!TextUtils.isEmpty(uc7ZPath) && new File(uc7ZPath).exists()) {
            return uc7ZPath;
        }
        return context.getApplicationInfo().nativeLibraryDir + "/libkernelu4_7z_uc.so";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void uploadLog(Object[] objArr) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(":");
        stringBuffer.append(objArr[1]);
        stringBuffer.append(":");
        stringBuffer.append(objArr[2]);
        stringBuffer.append(":");
        stringBuffer.append(objArr[5]);
        String stringBuffer2 = stringBuffer.toString();
        if (objArr[6] == null) {
            WVCommonConfig.getInstance();
            if (WVCommonConfig.commonConfig.enableUCUploadToTlog) {
                TaoLog.m21e((String) objArr[4], stringBuffer2);
            } else {
                sSpanWrapper.log(objArr[4] + " " + stringBuffer2);
            }
            if (TextUtils.equals("uc.Loading", (String) objArr[4])) {
                HashMap hashMap = new HashMap(2);
                hashMap.put("tbNet", "false");
                hashMap.put(NotificationCompat.CATEGORY_MESSAGE, stringBuffer2);
                WVHAManager.uploadApmStage("uc loading", hashMap);
                return;
            }
            return;
        }
        if (objArr[6] instanceof UCKnownException) {
            int errCode = ((UCKnownException) objArr[6]).errCode();
            coreCode = errCode;
            if (errCode == 3007) {
                try {
                    System.loadLibrary("webviewuc");
                } catch (Throwable unused) {
                    coreCode = 307;
                }
            }
        }
        WVCommonConfig.getInstance();
        if (WVCommonConfig.commonConfig.enableUCUploadToTlog) {
            TaoLog.m22e((String) objArr[4], stringBuffer2, (Throwable) objArr[6], new Object[0]);
        } else {
            sSpanWrapper.log(objArr[4] + " " + stringBuffer2 + " " + objArr[6]);
        }
        if (TextUtils.equals("uc.Loading", (String) objArr[4])) {
            HashMap hashMap2 = new HashMap(2);
            hashMap2.put("tbNet", "false");
            hashMap2.put(NotificationCompat.CATEGORY_MESSAGE, stringBuffer2);
            WVHAManager.uploadApmStage("uc loading", hashMap2);
        }
    }

    public void OnScrollChanged(int i, int i2, int i3, int i4) {
        WVPluginEntryManager wVPluginEntryManager = this.entryManager;
        if (wVPluginEntryManager != null) {
            wVPluginEntryManager.onScrollChanged(i, i2, i3, i4);
        }
        try {
            super.onScrollChanged(i, i2, i3, i4);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.taobao.windvane.webview.IWVWebView
    public Context _getContext() {
        Context context = getContext();
        return context instanceof MutableContextWrapper ? ((MutableContextWrapper) context).getBaseContext() : context;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.taobao.windvane.webview.IWVWebView
    @TargetApi(19)
    public boolean _post(Runnable runnable) {
        if (isAttachedToWindow() || Build.VERSION.SDK_INT >= 24) {
            return post(runnable);
        }
        TaoLog.m18d(TAG, " wait webview attach to window");
        IWVWebView.taskQueue.add(runnable);
        return true;
    }

    public void addJavascriptInterface(Object obj, String str) {
        if ("accessibility".equals(str) || "accessibilityTraversal".equals(str)) {
            return;
        }
        super.addJavascriptInterface(obj, str);
    }

    @Override // android.taobao.windvane.webview.IWVWebView
    public void addJsObject(String str, Object obj) {
        WVPluginEntryManager wVPluginEntryManager = this.entryManager;
        if (wVPluginEntryManager != null) {
            wVPluginEntryManager.addEntry(str, obj);
        }
    }

    @Override // android.taobao.windvane.webview.IWVWebView
    public boolean allowAllOpen() {
        return this.mAllowAllOpen;
    }

    @Override // android.taobao.windvane.webview.IWVWebView
    public boolean back() {
        if (!canGoBack()) {
            return false;
        }
        goBack();
        int i = this.mPageLoadedCount;
        if (i > 0) {
            this.mPageLoadedCount = i - 1;
        } else {
            TaoLog.m21e(TAG, "back pressed, mPageLoadedCount=" + this.mPageLoadedCount);
        }
        return true;
    }

    public boolean canGoBack() {
        if (WVEventService.getInstance().onEvent(WVEventId.PAGE_back).isSuccess) {
            return false;
        }
        return super.canGoBack();
    }

    @Override // android.taobao.windvane.webview.IWVWebView
    public boolean canUseGlobalUrlConfig() {
        return this.mUseGlobalUrlConfig;
    }

    @Override // android.taobao.windvane.webview.IWVWebView
    public boolean canUseUrlConfig() {
        return this.useUrlConfig;
    }

    @Override // android.taobao.windvane.webview.IWVWebView
    public void clearCache() {
        super.clearCache(true);
    }

    public void clearH5MonitorData() {
        Hashtable<String, Hashtable<String, String>> hashtable = this.mH5MonitorCache;
        if (hashtable != null) {
            hashtable.clear();
        }
    }

    public boolean containsH5MonitorData(String str) {
        Hashtable<String, Hashtable<String, String>> hashtable = this.mH5MonitorCache;
        if (hashtable == null) {
            return false;
        }
        return hashtable.containsKey(str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:101:0x01d2 A[Catch: all -> 0x01d6, TRY_LEAVE, TryCatch #2 {all -> 0x01d6, blocks: (B:89:0x0199, B:91:0x019d, B:93:0x01a3, B:95:0x01a7, B:98:0x01ae, B:99:0x01ce, B:101:0x01d2, B:103:0x01b7), top: B:88:0x0199 }] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x004b A[Catch: all -> 0x004f, TRY_LEAVE, TryCatch #5 {all -> 0x004f, blocks: (B:7:0x0016, B:9:0x001c, B:11:0x0020, B:14:0x0027, B:15:0x0047, B:17:0x004b, B:22:0x0030), top: B:6:0x0016 }] */
    /* JADX WARN: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x011f A[Catch: all -> 0x0123, TRY_LEAVE, TryCatch #1 {all -> 0x0123, blocks: (B:40:0x00e6, B:42:0x00ea, B:44:0x00f0, B:46:0x00f4, B:49:0x00fb, B:50:0x011b, B:52:0x011f, B:56:0x0104), top: B:39:0x00e6 }] */
    /* JADX WARN: Removed duplicated region for block: B:55:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:78:0x017c A[Catch: all -> 0x0180, TRY_LEAVE, TryCatch #0 {all -> 0x0180, blocks: (B:66:0x0143, B:68:0x0147, B:70:0x014d, B:72:0x0151, B:75:0x0158, B:76:0x0178, B:78:0x017c, B:82:0x0161), top: B:65:0x0143 }] */
    /* JADX WARN: Removed duplicated region for block: B:81:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void coreDestroy() {
        /*
            Method dump skipped, instructions count: 494
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: android.taobao.windvane.extra.p002uc.WVUCWebView.coreDestroy():void");
    }

    public boolean coreDispatchTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        int pointerId = motionEvent.getPointerId(motionEvent.getActionIndex());
        if (action == 0) {
            this.f13dx = motionEvent.getX();
            this.f14dy = motionEvent.getY();
            if (!this.isUser) {
                this.mEventSparseArray.put(pointerId, MotionEvent.obtain(motionEvent));
                return true;
            }
        } else if (action == 2) {
            if (!this.isUser && Math.abs(motionEvent.getY() - this.f14dy) > 5.0f) {
                return true;
            }
        } else if (action == 1) {
            if (!this.isUser && Math.abs(motionEvent.getY() - this.f14dy) > 5.0f) {
                this.isUser = true;
                return true;
            }
            MotionEvent motionEvent2 = this.mEventSparseArray.get(pointerId);
            if (motionEvent2 != null) {
                super.coreDispatchTouchEvent(motionEvent2);
                motionEvent2.recycle();
                this.mEventSparseArray.remove(pointerId);
            }
        }
        return super.coreDispatchTouchEvent(motionEvent);
    }

    public void coreOnScrollChanged(int i, int i2, int i3, int i4) {
        OnScrollChanged(i, i2, i3, i4);
        super.coreOnScrollChanged(i, i2, i3, i4);
    }

    @Override // android.taobao.windvane.webview.IWVWebView
    public void evaluateJavascript(String str) {
        evaluateJavascript(str, null);
    }

    public void fireEvent(String str) {
        getWVCallBackContext().fireEvent(str, "{}");
    }

    @Override // android.taobao.windvane.extra.performance2.IPerformance
    public String getCachedUrl() {
        if (TextUtils.isEmpty(this.cachedUrl)) {
            return null;
        }
        return this.cachedUrl;
    }

    public int getContentHeight() {
        return (int) (super.getContentHeight() * super.getScale());
    }

    public Context getCurrentContext() {
        return _getContext();
    }

    public String getCurrentUrl() {
        String str;
        try {
            str = super.getUrl();
        } catch (Exception unused) {
            TaoLog.m30w(TAG, "WebView had destroyed,forbid to be called getUrl. currentUrl : " + this.currentUrl);
            str = null;
        }
        if (str == null) {
            TaoLog.m27v(TAG, "getUrl by currentUrl: " + this.currentUrl);
            return this.currentUrl;
        }
        TaoLog.m27v(TAG, "getUrl by webview: " + str);
        return str;
    }

    @Override // android.taobao.windvane.webview.IWVWebView
    public String getDataOnActive() {
        return this.dataOnActive;
    }

    @Override // android.taobao.windvane.webview.IFullTrace
    public FalcoSpan getFalcoSpan() {
        return this.containerSpan;
    }

    public String getH5MonitorData(String str, String str2) {
        Hashtable<String, String> hashtable;
        Hashtable<String, Hashtable<String, String>> hashtable2 = this.mH5MonitorCache;
        if (hashtable2 == null || (hashtable = hashtable2.get(str)) == null) {
            return null;
        }
        return hashtable.get(str2);
    }

    public JSONObject getH5MonitorDatas() throws JSONException {
        if (this.mH5MonitorCache == null) {
            return new JSONObject();
        }
        JSONArray jSONArray = new JSONArray();
        Iterator<String> it = this.mH5MonitorCache.keySet().iterator();
        while (it.hasNext()) {
            Hashtable<String, String> hashtable = this.mH5MonitorCache.get(it.next());
            JSONObject jSONObject = new JSONObject();
            Enumeration<String> keys = hashtable.keys();
            while (keys.hasMoreElements()) {
                String nextElement = keys.nextElement();
                jSONObject.put(nextElement, hashtable.get(nextElement));
            }
            jSONArray.put(jSONObject);
        }
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("resources", jSONArray);
        return jSONObject2;
    }

    @Override // android.taobao.windvane.webview.IWVWebView
    public Object getJsObject(String str) {
        WVPluginEntryManager wVPluginEntryManager = this.entryManager;
        if (wVPluginEntryManager == null) {
            return null;
        }
        return wVPluginEntryManager.getEntry(str);
    }

    @Override // android.taobao.windvane.webview.IFullTrace
    public Map<String, String> getOpenTracingContext() {
        return this.openTracingContextMap;
    }

    @Override // android.taobao.windvane.webview.IWVWebView
    public int getPageLoadedCount() {
        return this.mPageLoadedCount;
    }

    @Override // android.taobao.windvane.extra.performance2.IPerformance
    public WVPerformance getPerformanceDelegate() {
        return this.performanceDelegate;
    }

    @Override // android.taobao.windvane.webview.IFullTrace
    public SpanWrapper getSpanWrapper() {
        return this.mSpanWrapper;
    }

    @Override // android.taobao.windvane.webview.IWVWebView
    public String getUrl() {
        return getCurrentUrl();
    }

    @Override // android.taobao.windvane.webview.IWVWebView
    public String getUserAgentString() {
        return getSettings().getUserAgentString();
    }

    @Override // android.taobao.windvane.webview.IWVWebView
    public View getView() {
        return super.getCoreView();
    }

    public WVCallBackContext getWVCallBackContext() {
        return new WVCallBackContext(this);
    }

    public WVUIModel getWvUIModel() {
        return this.wvUIModel;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        switch (message.what) {
            case 400:
                WVUIModel wVUIModel = this.wvUIModel;
                if (wVUIModel.isShowLoading() & (wVUIModel != null)) {
                    this.wvUIModel.showLoadingView();
                    this.wvUIModel.switchNaviBar(1);
                }
                this.mPageLoadedCount++;
                TaoLog.m18d(TAG, "NOTIFY_PAGE_START mPageLoadedCount=" + this.mPageLoadedCount);
                return true;
            case 401:
                WVUIModel wVUIModel2 = this.wvUIModel;
                if (wVUIModel2.isShowLoading() & (wVUIModel2 != null)) {
                    this.wvUIModel.hideLoadingView();
                    this.wvUIModel.resetNaviBar();
                }
                if (this.onErrorTime != 0 && System.currentTimeMillis() - this.onErrorTime > 3000) {
                    this.wvUIModel.hideErrorPage();
                }
                return true;
            case 402:
                WVUIModel wVUIModel3 = this.wvUIModel;
                if (wVUIModel3 != null) {
                    wVUIModel3.loadErrorPage();
                }
                this.onErrorTime = System.currentTimeMillis();
                WVUIModel wVUIModel4 = this.wvUIModel;
                if (wVUIModel4.isShowLoading() & (wVUIModel4 != null)) {
                    this.wvUIModel.hideLoadingView();
                }
                return true;
            case 403:
                WVUIModel wVUIModel5 = this.wvUIModel;
                if (wVUIModel5.isShowLoading() & (wVUIModel5 != null)) {
                    this.wvUIModel.hideLoadingView();
                }
                return true;
            case WVConstants.NOTIFY_SAVE_IMAGE_SUCCESS /* 404 */:
                try {
                    Toast.makeText(_getContext(), EnvUtil.isCN() ? "图片保存到相册成功" : "Success to save picture", 1).show();
                } catch (Exception e) {
                    TaoLog.m21e(TAG, "NOTIFY_SAVE_IMAGE_SUCCESS fail " + e.getMessage());
                }
                return true;
            case WVConstants.NOTIFY_SAVE_IMAGE_FAIL /* 405 */:
                try {
                    Toast.makeText(_getContext(), EnvUtil.isCN() ? "图片保存到相册失败" : "Failed to save picture", 1).show();
                } catch (Exception e2) {
                    TaoLog.m21e(TAG, "NOTIFY_SAVE_IMAGE_FAIL fail " + e2.getMessage());
                }
                return true;
            default:
                return false;
        }
    }

    @Override // android.taobao.windvane.webview.IWVWebView
    public void hideLoadingView() {
        WVUIModel wVUIModel = this.wvUIModel;
        if (wVUIModel != null) {
            wVUIModel.hideLoadingView();
        }
    }

    public void injectJsEarly(String str) {
        if (str.startsWith("javascript:")) {
            str = str.replace("javascript:", "");
        }
        StringBuilder sb = this.injectJs;
        sb.append(str);
        sb.append(";\n");
        if (getUCExtension() != null) {
            getUCExtension().setInjectJSProvider(new UCExtension.InjectJSProvider() { // from class: android.taobao.windvane.extra.uc.WVUCWebView.10
                public String getJS(int i) {
                    return WVUCWebView.this.injectJs.toString();
                }
            }, 1);
        }
    }

    public void insertH5MonitorData(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (this.mH5MonitorCache == null) {
            this.mH5MonitorCache = new Hashtable<>();
        }
        Hashtable<String, String> hashtable = this.mH5MonitorCache.get(str);
        if (hashtable == null) {
            hashtable = new Hashtable<>();
            this.mH5MonitorCache.put(str, hashtable);
        }
        if (TextUtils.isEmpty(str3)) {
            str3 = "";
        }
        hashtable.put(str2, str3);
    }

    public boolean isLive() {
        return this.isLive;
    }

    public void isPageEmpty(final whiteScreenCallback whitescreencallback) {
        evaluateJavascript("(function(d){var filteredTagNames={'IFRAME':1,'STYLE':1,'HTML':1,'BODY':1,'HEAD':1,'SCRIPT':1,'TITLE':1};if(d.body){for(var nodes=d.body.childNodes,i=0;i<nodes.length;i++){var node=nodes[i];if(node!=undefined){if(node.nodeType==1&&filteredTagNames[node.tagName]!=1&&node.style.display!='none'){return'0'}else if(node.nodeType==3&&node.nodeValue.trim().length>0){return'0'}}}}return'1'}(document))", new ValueCallback<String>() { // from class: android.taobao.windvane.extra.uc.WVUCWebView.11
            @Override // android.webkit.ValueCallback
            public void onReceiveValue(String str) {
                whiteScreenCallback whitescreencallback2 = whitescreencallback;
                if (whitescreencallback2 != null) {
                    whitescreencallback2.isPageEmpty(str);
                }
            }
        });
    }

    @Override // android.taobao.windvane.extra.performance2.IPerformance
    public boolean isPreInit() {
        return this.isPreInit;
    }

    @Override // android.taobao.windvane.extra.performance2.IPerformance
    public boolean isReportedFSP() {
        return false;
    }

    public boolean isStaticWebView() {
        return this.mIsStaticWebView;
    }

    @Override // android.taobao.windvane.webview.IWVWebView
    public void loadUrl(String str) {
        if (str == null) {
            return;
        }
        this.mSpanWrapper.log("loadUrl: " + str);
        boolean isCommonUrl = WVUrlUtil.isCommonUrl(str);
        if (isCommonUrl && WVServerConfig.isBlackUrl(str, this)) {
            String forbiddenDomainRedirectURL = WVURLConfig.getInstance().getForbiddenDomainRedirectURL();
            if (TextUtils.isEmpty(forbiddenDomainRedirectURL)) {
                HashMap hashMap = new HashMap(2);
                hashMap.put("cause", "GET_ACCESS_FORBIDDEN");
                hashMap.put(HttpConnector.URL, str);
                onMessage(402, hashMap);
                return;
            }
            try {
                super.loadUrl(forbiddenDomainRedirectURL);
                return;
            } catch (Exception e) {
                TaoLog.m21e(TAG, e.getMessage());
                return;
            }
        }
        if (WVURLFilter.doFilter(str, this.context, this)) {
            TaoLog.m21e(TAG, "loadUrl filter url=" + str);
            AppMonitorUtil.commitFail(AppMonitorUtil.MONITOR_POINT_URL_CONFIG_FILTER_TYPE, 1, "WVUCWebView.loadUrl", str);
            return;
        }
        if (this.firstTimeLoad && !str.contains(BasePreInitManager.PRE_RENDER_URL_ADDITION)) {
            this.firstTimeLoad = false;
        }
        if (isCommonUrl) {
            try {
                HashMap hashMap2 = new HashMap();
                hashMap2.put("userAgent", getUserAgentString());
                String prefetchData = WMLPrefetch.getInstance().prefetchData(str, hashMap2);
                if (!TextUtils.isEmpty(prefetchData)) {
                    str = prefetchData;
                }
            } catch (Throwable th) {
                TaoLog.m21e(TAG, "failed to call prefetch: " + th.getMessage());
                th.getStackTrace();
            }
        }
        WVSchemeIntercepterInterface wVSchemeIntercepter = WVSchemeInterceptService.getWVSchemeIntercepter();
        if (wVSchemeIntercepter != null) {
            str = wVSchemeIntercepter.dealUrlScheme(str);
        }
        if (isCommonUrl) {
            if (WebView.getCoreType() == 3) {
                tryPrcacheDocument(str);
            }
            if (this.firstTimeLoad && !str.contains(BasePreInitManager.PRE_RENDER_URL_ADDITION_JUDGE)) {
                this.wvh5PPManager.pageDidLoadRequest();
                this.firstTimeLoad = false;
            }
            this.wvh5PPManager.receiveHtmlUrl(str);
        }
        try {
            UCNetworkDelegate.getInstance().onUrlChange(this, str);
            TaoLog.m24i(TAG, "loadUrl : " + str);
            super.loadUrl(str);
        } catch (Exception e2) {
            TaoLog.m21e(TAG, e2.getMessage());
        }
        setCachedUrl(str);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == 15 && this.webChromeClient.mFilePathCallback != null) {
            this.webChromeClient.mFilePathCallback.onReceiveValue(WebChromeClient.FileChooserParams.parseResult(i2, intent));
            this.webChromeClient.mFilePathCallback = null;
        }
        WVPluginEntryManager wVPluginEntryManager = this.entryManager;
        if (wVPluginEntryManager != null) {
            wVPluginEntryManager.onActivityResult(i, i2, intent);
        }
    }

    protected void onAttachedToWindow() {
        TaoLog.m18d(TAG, " webview attach to window, and execute remain task");
        Iterator<Runnable> it = IWVWebView.taskQueue.iterator();
        while (it.hasNext()) {
            it.next().run();
        }
        IWVWebView.taskQueue.clear();
        super.onAttachedToWindow();
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        UCNetworkDelegate.getInstance().removeWebview(this);
        List<Runnable> list = IWVWebView.taskQueue;
        if (list.size() != 0) {
            list.clear();
        }
    }

    public void onLowMemory() {
    }

    public void onMessage(int i, Object obj) {
        if (this.mHandler != null) {
            Message obtain = Message.obtain();
            obtain.what = i;
            obtain.obj = obj;
            this.mHandler.sendMessage(obtain);
        }
    }

    @TargetApi(11)
    public void onPause() {
        WVPluginEntryManager wVPluginEntryManager = this.entryManager;
        if (wVPluginEntryManager != null) {
            wVPluginEntryManager.onPause();
        }
        if (Build.VERSION.SDK_INT >= 11) {
            super.onPause();
        }
        WVEventService.getInstance().onEvent(WVEventId.PAGE_onPause);
    }

    @TargetApi(11)
    public void onResume() {
        WVPluginEntryManager wVPluginEntryManager = this.entryManager;
        if (wVPluginEntryManager != null) {
            wVPluginEntryManager.onResume();
        }
        if (Build.VERSION.SDK_INT >= 11) {
            try {
                super.onResume();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        WVEventService.getInstance().onEvent(WVEventId.PAGE_onResume, this, getUrl(), new Object[0]);
        this.isLive = true;
    }

    protected void onWindowVisibilityChanged(int i) {
        Window window;
        if (i == 0 && Build.VERSION.SDK_INT > 18) {
            Context _getContext = _getContext();
            if ((_getContext instanceof Activity) && (window = ((Activity) _getContext).getWindow()) != null) {
                final View decorView = window.getDecorView();
                decorView.postDelayed(new Runnable() { // from class: android.taobao.windvane.extra.uc.WVUCWebView.8
                    @Override // java.lang.Runnable
                    public void run() {
                        decorView.requestLayout();
                    }
                }, 100L);
            }
        }
        super.onWindowVisibilityChanged(i);
    }

    public void postUrl(String str, byte[] bArr) {
        if (str == null) {
            return;
        }
        if (WVUrlUtil.isCommonUrl(str) && WVServerConfig.isBlackUrl(str, this)) {
            String forbiddenDomainRedirectURL = WVURLConfig.getInstance().getForbiddenDomainRedirectURL();
            if (TextUtils.isEmpty(forbiddenDomainRedirectURL)) {
                HashMap hashMap = new HashMap(2);
                hashMap.put("cause", "POST_ACCESS_FORBIDDEN");
                hashMap.put(HttpConnector.URL, str);
                onMessage(402, hashMap);
                return;
            }
            try {
                loadUrl(forbiddenDomainRedirectURL);
                return;
            } catch (Exception e) {
                TaoLog.m21e(TAG, e.getMessage());
                return;
            }
        }
        if (WVURLFilter.doFilter(str, this.context, this)) {
            TaoLog.m21e(TAG, "postUrl filter url=" + str);
            AppMonitorUtil.commitFail(AppMonitorUtil.MONITOR_POINT_URL_CONFIG_FILTER_TYPE, 2, "WVUCWebView.loadUrl", str);
            return;
        }
        WVSchemeIntercepterInterface wVSchemeIntercepter = WVSchemeInterceptService.getWVSchemeIntercepter();
        if (wVSchemeIntercepter != null) {
            str = wVSchemeIntercepter.dealUrlScheme(str);
        }
        try {
            UCNetworkDelegate.getInstance().onUrlChange(this, str);
            TaoLog.m24i(TAG, "postUrl : " + str);
            super.postUrl(str, bArr);
        } catch (Exception e2) {
            TaoLog.m21e(TAG, e2.getMessage());
        }
        setCachedUrl(str);
    }

    @Override // android.taobao.windvane.extra.performance2.IPerformance
    public void receiveJSMessageForCustomizedFSP(long j) {
        this.pageTracker.onPageReceivedCustomizedFSP(j);
    }

    @Override // android.taobao.windvane.extra.performance2.IPerformance
    public void receiveJSMessageForCustomizedStage(long j, String str) {
        this.pageTracker.onPageReceivedCustomizedStage(j, str);
    }

    @Override // android.taobao.windvane.extra.performance2.IPerformance
    public void receiveJSMessageForFP(long j) {
        this.wvh5PPManager.receiveFPTime(j);
        this.pageTracker.onPageReceivedFP(j);
    }

    @Override // android.taobao.windvane.extra.performance2.IPerformance
    public void receiveJSMessageForFSP(long j) {
        this.wvfspManager.receiveJSMessage(j);
        this.pageTracker.onPageReceivedFSP(j);
    }

    @Override // android.taobao.windvane.extra.performance2.IPerformance
    public void receiveJSMessageForTTI(long j) {
        this.wvh5PPManager.receiveTTITime(j);
        this.pageTracker.onPageReceivedTTI(j);
    }

    @Override // android.taobao.windvane.webview.IWVWebView
    public void refresh() {
        reload();
    }

    public void reload() {
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("userAgent", getUserAgentString());
            WMLPrefetch.getInstance().prefetchData(getCurrentUrl(), hashMap);
        } catch (Throwable th) {
            TaoLog.m21e(TAG, "failed to call prefetch: " + th.getMessage());
            th.printStackTrace();
        }
        super.reload();
    }

    public void script2NativeCallback(String str, ValueCallback<String> valueCallback) {
        int i = this.mWvNativeCallbackId + 1;
        this.mWvNativeCallbackId = i;
        WVNativeCallbackUtil.putNativeCallbak(String.valueOf(i), valueCallback);
        loadUrl("javascript:console.log('wvNativeCallback/" + i + "/'+function(){var s = " + str + "; return (typeof s === 'object' ? JSON.stringify(s) : typeof s === 'string' ? '\"' + s + '\"' : s);}())");
    }

    @Override // android.taobao.windvane.webview.IWVWebView
    public void setAllowAllOpen(boolean z) {
        this.mAllowAllOpen = z;
    }

    public void setCachedUrl(String str) {
        if (TextUtils.isEmpty(str) || str.startsWith("javascript:") || str.startsWith("about:")) {
            return;
        }
        this.cachedUrl = str;
    }

    public void setCurrentUrl(String str, String str2) {
        this.currentUrl = str;
        TaoLog.m27v(TAG, "setCurrentUrl: " + str + " state : " + str2);
    }

    @Override // android.taobao.windvane.webview.IWVWebView
    public void setDataOnActive(String str) {
        this.dataOnActive = str;
    }

    public void setFalcoPageName(String str) {
        try {
            ((WVFalco) getJsObject("WVFalco")).setPageName(str);
        } catch (Exception e) {
            TaoLog.m21e(TAG, "setPageName fail " + e);
        }
    }

    @Override // android.taobao.windvane.webview.IFullTrace
    public void setFalcoSpan(FalcoSpan falcoSpan) {
        this.containerSpan = falcoSpan;
        sSpanWrapper.setFalcoSpan(falcoSpan);
        this.mSpanWrapper.setFalcoSpan(falcoSpan);
    }

    @Override // android.taobao.windvane.webview.IWVWebView
    public void setGlobalUrlConfigSwitch(boolean z) {
        this.mUseGlobalUrlConfig = z;
    }

    protected void setOnErrorTime(long j) {
        this.onErrorTime = j;
    }

    @Override // android.taobao.windvane.webview.IFullTrace
    public void setOpenTracingContext(Map<String, String> map) {
        this.openTracingContextMap = map;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setOuterContext(Context context) {
        Context context2 = this.context;
        if (context2 instanceof MutableContextWrapper) {
            ((MutableContextWrapper) context2).setBaseContext(context);
        } else {
            this.context = context;
        }
        if (WVCore.getInstance().isUCSupport() && (getContext() instanceof MutableContextWrapper)) {
            ((MutableContextWrapper) getContext()).setBaseContext(context);
        }
    }

    public void setPageCacheCapacity(int i) {
        if (getUCExtension() != null) {
            getUCExtension().getUCSettings();
            UCSettings.setGlobalIntValue("CachePageNumber", i);
        }
    }

    public void setPerformanceDelegate(WVPerformance wVPerformance) {
        this.performanceDelegate = wVPerformance;
    }

    public void setPid(String str) {
        this.pid = str;
    }

    public void setPreInitState(boolean z) {
        this.isPreInit = z;
    }

    @Override // android.taobao.windvane.extra.performance2.IPerformance
    public void setReportedFSP(boolean z) {
        this.reportedFSP = z;
    }

    public void setSupportDownload(boolean z) {
        this.supportDownload = z;
    }

    @Override // android.taobao.windvane.webview.IWVWebView
    public void setUrlConfigSwitch(boolean z) {
        this.useUrlConfig = z;
    }

    @Override // android.taobao.windvane.webview.IWVWebView
    public void setUserAgentString(String str) {
        getSettings().setUserAgentString(str);
    }

    public void setWebChromeClient(WebChromeClient webChromeClient) {
        if (!(webChromeClient instanceof WVUCWebChromeClient)) {
            throw new WindVaneError("Your WebChromeClient must be extended from WVUCWebChromeClient");
        }
        WVUCWebChromeClient wVUCWebChromeClient = (WVUCWebChromeClient) webChromeClient;
        this.webChromeClient = wVUCWebChromeClient;
        wVUCWebChromeClient.mWebView = this;
        super.setWebChromeClient(webChromeClient);
    }

    public void setWebViewClient(WebViewClient webViewClient) {
        if (!(webViewClient instanceof WVUCWebViewClient)) {
            throw new WindVaneError("Your WebViewClient must be extended from WVUCWebViewClient");
        }
        this.webViewClient = (WVUCWebViewClient) webViewClient;
        super.setWebViewClient(webViewClient);
    }

    public void setWvUIModel(WVUIModel wVUIModel) {
        this.wvUIModel = wVUIModel;
    }

    @Override // android.taobao.windvane.webview.IWVWebView
    public void showLoadingView() {
        WVUIModel wVUIModel = this.wvUIModel;
        if (wVUIModel != null) {
            wVUIModel.showLoadingView();
        }
    }

    public void stopLoading() {
        isStop = true;
        super.stopLoading();
    }

    public static void initUCCore(Context context) {
        boolean is64Bit;
        if (GlobalConfig.getInstance().getUcsdkappkeySec() == null) {
            new AndroidRuntimeException("WVUCWebView: can not init uc core for uc key is null").printStackTrace();
            return;
        }
        if (GlobalConfig.context == null) {
            new AndroidRuntimeException("WVUCWebView: can not init uc core for context is nulll").printStackTrace();
            return;
        }
        if (!WVCommonConfig.getInstance().hasInited()) {
            WVCommonConfig.getInstance().init();
            TaoLog.m24i(TAG, "init WVCommonConfig before init core");
        }
        AtomicBoolean atomicBoolean = sCoreInitialized;
        if (!atomicBoolean.compareAndSet(false, true)) {
            TaoLog.m18d(TAG, "uc core has been initialized");
            return;
        }
        try {
            is64Bit = WVUCUtils.is64Bit();
        } catch (Exception unused) {
            sCoreInitialized.set(false);
        }
        if (!is64Bit && WVUCUtils.isArchContains("x86")) {
            UC_CORE_URL = UCSoSettings.getInstance().UC_CORE_URL_DEBUG_X86;
            TaoLog.m24i(TAG, "UCCore use x86 core " + UC_CORE_URL);
            atomicBoolean.set(true);
            return;
        }
        if (EnvUtil.isAppDebug()) {
            if (TextUtils.equals(BasePreInitManager.PRE_RENDER_URL_ADDITION_VALUE, UCSoSettings.getInstance().UC_CORE_THICK) && GlobalConfig.getInstance().openUCDebug()) {
                openUCDebug = true;
            }
            UC_CORE_URL = is64Bit ? UCSoSettings.getInstance().UC_CORE_URL_DEBUG_64 : UCSoSettings.getInstance().UC_CORE_URL_DEBUG_32;
            TaoLog.m24i(TAG, "use 3.0 debug core, use 64bit = [" + is64Bit + "] " + UC_CORE_URL);
        } else {
            TaoLog.m24i(TAG, "use 3.0 release core, use 64bit = [" + is64Bit + "] " + UC_CORE_URL);
            UC_CORE_URL = is64Bit ? UCSoSettings.getInstance().UC_CORE_URL_64 : UCSoSettings.getInstance().UC_CORE_URL_32;
        }
        try {
            shouldUCLibInit.set(true);
            TaoLog.m21e(TAG, "init uclib inner");
            if (initUCLIb(GlobalConfig.getInstance().getUcsdkappkeySec(), GlobalConfig.context)) {
                return;
            }
            sCoreInitialized.set(false);
        } catch (Throwable unused2) {
            sCoreInitialized.set(false);
        }
    }

    @Override // android.taobao.windvane.webview.IWVWebView
    public void evaluateJavascript(String str, ValueCallback<String> valueCallback) {
        TaoLog.m18d(TAG, "evaluateJavascript : " + str);
        if (this.isLive) {
            if (str.length() > 10 && "javascript:".equals(str.substring(0, 11).toLowerCase())) {
                str = str.substring(11);
            }
            if (!evaluateJavascriptSupported && getCurrentViewCoreType() != 3) {
                if (valueCallback != null) {
                    script2NativeCallback(str, valueCallback);
                    return;
                }
                loadUrl("javascript:" + str);
                return;
            }
            try {
                super.evaluateJavascript(str, valueCallback);
            } catch (Exception unused) {
                if (getCurrentViewCoreType() != 3) {
                    evaluateJavascriptSupported = false;
                    evaluateJavascript(str, valueCallback);
                    AppMonitorUtil.commitUCWebviewError(ExifInterface.GPS_MEASUREMENT_2D, str, "exception");
                }
            } catch (NoSuchMethodError unused2) {
                if (getCurrentViewCoreType() != 3) {
                    evaluateJavascriptSupported = false;
                    evaluateJavascript(str, valueCallback);
                }
            }
        }
    }

    @Override // android.taobao.windvane.webview.IWVWebView
    public void fireEvent(String str, String str2) {
        getWVCallBackContext().fireEvent(str, str2);
    }

    private static boolean initUCLIb(String[] strArr, Context context) {
        TaoLog.m18d(TAG, "UCSDK initUCLib begin ");
        WVCommonConfigData wVCommonConfigData = WVCommonConfig.commonConfig;
        setUseSystemWebView(wVCommonConfigData.useSystemWebView);
        if (EnvUtil.isAppDebug()) {
            UCCore.setPrintLog(true);
        } else {
            UCCore.setPrintLog(false);
        }
        TaoLog.m18d(TAG, "UCSDK initUCLib UseSystemWebView " + mUseSystemWebView);
        if (WVCore.getInstance().isUCSupport()) {
            return true;
        }
        try {
            setUcCoreUrl(wVCommonConfigData.ucCoreUrl);
            if (strArr == null && EnvUtil.isTaobao()) {
                strArr = WindVaneSDKForTB.TB_UC_SDK_APP_KEY_SEC;
            }
            Object[] logConfigCreate = logConfigCreate();
            File file = new File(ucCore7ZFilePath(context));
            TaoLog.m24i(TAG, "uccore policy:[" + wVCommonConfigData.initUCCorePolicy + "]");
            TaoLog.m24i(TAG, "sandbox:policy [" + wVCommonConfigData.webMultiPolicy + "];timeout [" + wVCommonConfigData.ucMultiTimeOut + "]]");
            if (!TextUtils.equals(CommonUtils.getProcessName(context), context.getPackageName() + ":sandboxed_privilege_process0")) {
                if (!TextUtils.equals(CommonUtils.getProcessName(context), context.getPackageName() + ":sandboxed_process0")) {
                    if (!TextUtils.equals(CommonUtils.getProcessName(context), context.getPackageName() + ":gpu_process")) {
                        setMultiPolicy(context);
                        if (wVCommonConfigData.initUCCorePolicy == 0 && file.exists()) {
                            TaoLog.m21e(TAG, "内置uc初始化");
                            return initUCLibBy7Z(strArr, context, logConfigCreate);
                        }
                        if (TextUtils.isEmpty(UC_CORE_URL)) {
                            TaoLog.m21e(TAG, "UC_CORE_URL为空");
                            new AndroidRuntimeException("neither inner so, nor download so").printStackTrace();
                            if (WVUCUtils.is64Bit()) {
                                coreCode = 300764;
                            } else {
                                coreCode = 300732;
                            }
                            return false;
                        }
                        return initUCLibByDownload(strArr, context, logConfigCreate);
                    }
                }
            }
            return false;
        } catch (Exception e) {
            TaoLog.m21e(TAG, "UCCore init fail " + e.getMessage());
            return false;
        }
    }

    public WVUCWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, isUseSystemWebView(context));
        this.bizCode = "";
        this.flag4commit = false;
        this.mSpanWrapper = new SpanWrapper();
        this.isLive = false;
        this.mIsCoreDestroy = false;
        this.aliRequestAdapter = null;
        this.wvfspManager = new WVFSPManager();
        this.wvh5PPManager = new WVH5PPManager(this);
        this.wvErrorManager = new WVErrorManager();
        this.pageTracker = new WVPageTracker();
        this.wpData = new WVWPData();
        this.reportedFSP = false;
        this.isPreInit = false;
        this.wvSecurityFilter = null;
        this.jsPatchListener = null;
        this.mHandler = null;
        this.supportDownload = true;
        this.mWvNativeCallbackId = 1000;
        this.dataOnActive = null;
        this.longPressSaveImage = true;
        this.ucParam = "";
        this.currentUrl = null;
        this.cachedUrl = null;
        String[] strArr = new String[1];
        strArr[0] = EnvUtil.isCN() ? "保存到相册" : "Save to album";
        this.mPopupMenuTags = strArr;
        this.mLongClickListener = null;
        this.useUrlConfig = false;
        this.mUseGlobalUrlConfig = GlobalConfig.getInstance().isUseGlobalUrlConfig();
        this.mAllowAllOpen = false;
        this.mPageLoadedCount = 0;
        this.popupClickListener = new View.OnClickListener() { // from class: android.taobao.windvane.extra.uc.WVUCWebView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (WVUCWebView.this.mPopupMenuTags != null && WVUCWebView.this.mPopupMenuTags.length > 0 && WVUCWebView.this.mPopupMenuTags[0].equals(view.getTag())) {
                    try {
                        PermissionProposer.buildPermissionTask(WVUCWebView.this.context, new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}).setTaskOnPermissionGranted(new Runnable() { // from class: android.taobao.windvane.extra.uc.WVUCWebView.1.2
                            @Override // java.lang.Runnable
                            public void run() {
                                Context context2 = WVUCWebView.this.context;
                                if (context2 == null) {
                                    return;
                                }
                                ImageTool.saveImageToDCIM(context2.getApplicationContext(), WVUCWebView.this.mImageUrl, WVUCWebView.this.mHandler);
                            }
                        }).setTaskOnPermissionDenied(new Runnable() { // from class: android.taobao.windvane.extra.uc.WVUCWebView.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                WVUCWebView.this.mHandler.sendEmptyMessage(WVConstants.NOTIFY_SAVE_IMAGE_FAIL);
                            }
                        }).execute();
                    } catch (Exception unused) {
                    }
                }
                if (WVUCWebView.this.mPopupController != null) {
                    WVUCWebView.this.mPopupController.hide();
                }
            }
        };
        this.wvUIModel = null;
        this.onErrorTime = 0L;
        this.pid = "";
        this.uid = "";
        this.mIsStaticWebView = false;
        this.firstTimeLoad = true;
        this.isUser = true;
        this.mEventSparseArray = new SparseArray<>();
        this.mH5MonitorCache = null;
        this.mPageStart = 0L;
        this.injectJs = new StringBuilder("javascript:");
        this.context = context;
        init();
    }

    public WVUCWebView(Context context) {
        super(context, isUseSystemWebView(context));
        this.bizCode = "";
        this.flag4commit = false;
        this.mSpanWrapper = new SpanWrapper();
        this.isLive = false;
        this.mIsCoreDestroy = false;
        this.aliRequestAdapter = null;
        this.wvfspManager = new WVFSPManager();
        this.wvh5PPManager = new WVH5PPManager(this);
        this.wvErrorManager = new WVErrorManager();
        this.pageTracker = new WVPageTracker();
        this.wpData = new WVWPData();
        this.reportedFSP = false;
        this.isPreInit = false;
        this.wvSecurityFilter = null;
        this.jsPatchListener = null;
        this.mHandler = null;
        this.supportDownload = true;
        this.mWvNativeCallbackId = 1000;
        this.dataOnActive = null;
        this.longPressSaveImage = true;
        this.ucParam = "";
        this.currentUrl = null;
        this.cachedUrl = null;
        String[] strArr = new String[1];
        strArr[0] = EnvUtil.isCN() ? "保存到相册" : "Save to album";
        this.mPopupMenuTags = strArr;
        this.mLongClickListener = null;
        this.useUrlConfig = false;
        this.mUseGlobalUrlConfig = GlobalConfig.getInstance().isUseGlobalUrlConfig();
        this.mAllowAllOpen = false;
        this.mPageLoadedCount = 0;
        this.popupClickListener = new View.OnClickListener() { // from class: android.taobao.windvane.extra.uc.WVUCWebView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (WVUCWebView.this.mPopupMenuTags != null && WVUCWebView.this.mPopupMenuTags.length > 0 && WVUCWebView.this.mPopupMenuTags[0].equals(view.getTag())) {
                    try {
                        PermissionProposer.buildPermissionTask(WVUCWebView.this.context, new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}).setTaskOnPermissionGranted(new Runnable() { // from class: android.taobao.windvane.extra.uc.WVUCWebView.1.2
                            @Override // java.lang.Runnable
                            public void run() {
                                Context context2 = WVUCWebView.this.context;
                                if (context2 == null) {
                                    return;
                                }
                                ImageTool.saveImageToDCIM(context2.getApplicationContext(), WVUCWebView.this.mImageUrl, WVUCWebView.this.mHandler);
                            }
                        }).setTaskOnPermissionDenied(new Runnable() { // from class: android.taobao.windvane.extra.uc.WVUCWebView.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                WVUCWebView.this.mHandler.sendEmptyMessage(WVConstants.NOTIFY_SAVE_IMAGE_FAIL);
                            }
                        }).execute();
                    } catch (Exception unused) {
                    }
                }
                if (WVUCWebView.this.mPopupController != null) {
                    WVUCWebView.this.mPopupController.hide();
                }
            }
        };
        this.wvUIModel = null;
        this.onErrorTime = 0L;
        this.pid = "";
        this.uid = "";
        this.mIsStaticWebView = false;
        this.firstTimeLoad = true;
        this.isUser = true;
        this.mEventSparseArray = new SparseArray<>();
        this.mH5MonitorCache = null;
        this.mPageStart = 0L;
        this.injectJs = new StringBuilder("javascript:");
        this.context = context;
        init();
    }

    public WVUCWebView(Context context, Map<String, String> map) {
        super(context, isUseSystemWebView(context));
        this.bizCode = "";
        this.flag4commit = false;
        this.mSpanWrapper = new SpanWrapper();
        this.isLive = false;
        this.mIsCoreDestroy = false;
        this.aliRequestAdapter = null;
        this.wvfspManager = new WVFSPManager();
        this.wvh5PPManager = new WVH5PPManager(this);
        this.wvErrorManager = new WVErrorManager();
        this.pageTracker = new WVPageTracker();
        this.wpData = new WVWPData();
        this.reportedFSP = false;
        this.isPreInit = false;
        this.wvSecurityFilter = null;
        this.jsPatchListener = null;
        this.mHandler = null;
        this.supportDownload = true;
        this.mWvNativeCallbackId = 1000;
        this.dataOnActive = null;
        this.longPressSaveImage = true;
        this.ucParam = "";
        this.currentUrl = null;
        this.cachedUrl = null;
        String[] strArr = new String[1];
        strArr[0] = EnvUtil.isCN() ? "保存到相册" : "Save to album";
        this.mPopupMenuTags = strArr;
        this.mLongClickListener = null;
        this.useUrlConfig = false;
        this.mUseGlobalUrlConfig = GlobalConfig.getInstance().isUseGlobalUrlConfig();
        this.mAllowAllOpen = false;
        this.mPageLoadedCount = 0;
        this.popupClickListener = new View.OnClickListener() { // from class: android.taobao.windvane.extra.uc.WVUCWebView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (WVUCWebView.this.mPopupMenuTags != null && WVUCWebView.this.mPopupMenuTags.length > 0 && WVUCWebView.this.mPopupMenuTags[0].equals(view.getTag())) {
                    try {
                        PermissionProposer.buildPermissionTask(WVUCWebView.this.context, new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}).setTaskOnPermissionGranted(new Runnable() { // from class: android.taobao.windvane.extra.uc.WVUCWebView.1.2
                            @Override // java.lang.Runnable
                            public void run() {
                                Context context2 = WVUCWebView.this.context;
                                if (context2 == null) {
                                    return;
                                }
                                ImageTool.saveImageToDCIM(context2.getApplicationContext(), WVUCWebView.this.mImageUrl, WVUCWebView.this.mHandler);
                            }
                        }).setTaskOnPermissionDenied(new Runnable() { // from class: android.taobao.windvane.extra.uc.WVUCWebView.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                WVUCWebView.this.mHandler.sendEmptyMessage(WVConstants.NOTIFY_SAVE_IMAGE_FAIL);
                            }
                        }).execute();
                    } catch (Exception unused) {
                    }
                }
                if (WVUCWebView.this.mPopupController != null) {
                    WVUCWebView.this.mPopupController.hide();
                }
            }
        };
        this.wvUIModel = null;
        this.onErrorTime = 0L;
        this.pid = "";
        this.uid = "";
        this.mIsStaticWebView = false;
        this.firstTimeLoad = true;
        this.isUser = true;
        this.mEventSparseArray = new SparseArray<>();
        this.mH5MonitorCache = null;
        this.mPageStart = 0L;
        this.injectJs = new StringBuilder("javascript:");
        this.context = context;
        this.openTracingContextMap = map;
        init();
    }

    public WVUCWebView(Context context, @Nullable String str) {
        super(context, isUseSystemWebView(context));
        this.bizCode = "";
        this.flag4commit = false;
        this.mSpanWrapper = new SpanWrapper();
        this.isLive = false;
        this.mIsCoreDestroy = false;
        this.aliRequestAdapter = null;
        this.wvfspManager = new WVFSPManager();
        this.wvh5PPManager = new WVH5PPManager(this);
        this.wvErrorManager = new WVErrorManager();
        this.pageTracker = new WVPageTracker();
        this.wpData = new WVWPData();
        this.reportedFSP = false;
        this.isPreInit = false;
        this.wvSecurityFilter = null;
        this.jsPatchListener = null;
        this.mHandler = null;
        this.supportDownload = true;
        this.mWvNativeCallbackId = 1000;
        this.dataOnActive = null;
        this.longPressSaveImage = true;
        this.ucParam = "";
        this.currentUrl = null;
        this.cachedUrl = null;
        String[] strArr = new String[1];
        strArr[0] = EnvUtil.isCN() ? "保存到相册" : "Save to album";
        this.mPopupMenuTags = strArr;
        this.mLongClickListener = null;
        this.useUrlConfig = false;
        this.mUseGlobalUrlConfig = GlobalConfig.getInstance().isUseGlobalUrlConfig();
        this.mAllowAllOpen = false;
        this.mPageLoadedCount = 0;
        this.popupClickListener = new View.OnClickListener() { // from class: android.taobao.windvane.extra.uc.WVUCWebView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (WVUCWebView.this.mPopupMenuTags != null && WVUCWebView.this.mPopupMenuTags.length > 0 && WVUCWebView.this.mPopupMenuTags[0].equals(view.getTag())) {
                    try {
                        PermissionProposer.buildPermissionTask(WVUCWebView.this.context, new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}).setTaskOnPermissionGranted(new Runnable() { // from class: android.taobao.windvane.extra.uc.WVUCWebView.1.2
                            @Override // java.lang.Runnable
                            public void run() {
                                Context context2 = WVUCWebView.this.context;
                                if (context2 == null) {
                                    return;
                                }
                                ImageTool.saveImageToDCIM(context2.getApplicationContext(), WVUCWebView.this.mImageUrl, WVUCWebView.this.mHandler);
                            }
                        }).setTaskOnPermissionDenied(new Runnable() { // from class: android.taobao.windvane.extra.uc.WVUCWebView.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                WVUCWebView.this.mHandler.sendEmptyMessage(WVConstants.NOTIFY_SAVE_IMAGE_FAIL);
                            }
                        }).execute();
                    } catch (Exception unused) {
                    }
                }
                if (WVUCWebView.this.mPopupController != null) {
                    WVUCWebView.this.mPopupController.hide();
                }
            }
        };
        this.wvUIModel = null;
        this.onErrorTime = 0L;
        this.pid = "";
        this.uid = "";
        this.mIsStaticWebView = false;
        this.firstTimeLoad = true;
        this.isUser = true;
        this.mEventSparseArray = new SparseArray<>();
        this.mH5MonitorCache = null;
        this.mPageStart = 0L;
        this.injectJs = new StringBuilder("javascript:");
        if (!TextUtils.isEmpty(str)) {
            this.pid = str;
        }
        this.context = context;
        init();
    }

    public WVUCWebView(Context context, boolean z) {
        super(context, isUseSystemWebView(context));
        this.bizCode = "";
        this.flag4commit = false;
        this.mSpanWrapper = new SpanWrapper();
        this.isLive = false;
        this.mIsCoreDestroy = false;
        this.aliRequestAdapter = null;
        this.wvfspManager = new WVFSPManager();
        this.wvh5PPManager = new WVH5PPManager(this);
        this.wvErrorManager = new WVErrorManager();
        this.pageTracker = new WVPageTracker();
        this.wpData = new WVWPData();
        this.reportedFSP = false;
        this.isPreInit = false;
        this.wvSecurityFilter = null;
        this.jsPatchListener = null;
        this.mHandler = null;
        this.supportDownload = true;
        this.mWvNativeCallbackId = 1000;
        this.dataOnActive = null;
        this.longPressSaveImage = true;
        this.ucParam = "";
        this.currentUrl = null;
        this.cachedUrl = null;
        String[] strArr = new String[1];
        strArr[0] = EnvUtil.isCN() ? "保存到相册" : "Save to album";
        this.mPopupMenuTags = strArr;
        this.mLongClickListener = null;
        this.useUrlConfig = false;
        this.mUseGlobalUrlConfig = GlobalConfig.getInstance().isUseGlobalUrlConfig();
        this.mAllowAllOpen = false;
        this.mPageLoadedCount = 0;
        this.popupClickListener = new View.OnClickListener() { // from class: android.taobao.windvane.extra.uc.WVUCWebView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (WVUCWebView.this.mPopupMenuTags != null && WVUCWebView.this.mPopupMenuTags.length > 0 && WVUCWebView.this.mPopupMenuTags[0].equals(view.getTag())) {
                    try {
                        PermissionProposer.buildPermissionTask(WVUCWebView.this.context, new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}).setTaskOnPermissionGranted(new Runnable() { // from class: android.taobao.windvane.extra.uc.WVUCWebView.1.2
                            @Override // java.lang.Runnable
                            public void run() {
                                Context context2 = WVUCWebView.this.context;
                                if (context2 == null) {
                                    return;
                                }
                                ImageTool.saveImageToDCIM(context2.getApplicationContext(), WVUCWebView.this.mImageUrl, WVUCWebView.this.mHandler);
                            }
                        }).setTaskOnPermissionDenied(new Runnable() { // from class: android.taobao.windvane.extra.uc.WVUCWebView.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                WVUCWebView.this.mHandler.sendEmptyMessage(WVConstants.NOTIFY_SAVE_IMAGE_FAIL);
                            }
                        }).execute();
                    } catch (Exception unused) {
                    }
                }
                if (WVUCWebView.this.mPopupController != null) {
                    WVUCWebView.this.mPopupController.hide();
                }
            }
        };
        this.wvUIModel = null;
        this.onErrorTime = 0L;
        this.pid = "";
        this.uid = "";
        this.mIsStaticWebView = false;
        this.firstTimeLoad = true;
        this.isUser = true;
        this.mEventSparseArray = new SparseArray<>();
        this.mH5MonitorCache = null;
        this.mPageStart = 0L;
        this.injectJs = new StringBuilder("javascript:");
        this.context = context;
        this.mIsStaticWebView = z;
        if (WVMonitorService.getWvMonitorInterface() != null) {
            WVMonitorService.getWvMonitorInterface().WebViewWrapType(context.getClass().getSimpleName());
        }
        if (z) {
            setWebViewClient(new WVUCWebViewClient(context));
            setWebChromeClient(new WVUCWebChromeClient(context));
            UCExtension uCExtension = getUCExtension();
            if (uCExtension != null) {
                uCExtension.setClient(new WVUCClient(this));
                return;
            }
            return;
        }
        init();
    }
}
