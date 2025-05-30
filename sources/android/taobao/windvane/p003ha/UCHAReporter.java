package android.taobao.windvane.p003ha;

import android.os.Handler;
import android.os.HandlerThread;
import android.taobao.windvane.WVPerformanceManager;
import android.taobao.windvane.config.WVCommonConfig;
import android.taobao.windvane.connect.HttpConnector;
import android.taobao.windvane.extra.p002uc.preRender.BasePreInitManager;
import android.taobao.windvane.grey.GreyPageInfo;
import android.taobao.windvane.grey.GreyPageManager;
import android.taobao.windvane.util.TaoLog;
import android.text.TextUtils;
import androidx.collection.LruCache;
import com.uc.webview.export.WebView;
import java.lang.ref.WeakReference;
import java.util.HashMap;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class UCHAReporter {
    private static UCHAReporter INSTANCE = null;
    public static final String TAG = "UCHAReporter";
    private static long commonID;
    private static Runnable mLogRunnable = new Runnable() { // from class: android.taobao.windvane.ha.UCHAReporter.1
        @Override // java.lang.Runnable
        public void run() {
            UCHAReporter.getInstance().commitUCHA();
        }
    };
    private Handler logHandler;
    private WeakReference<WebView> webViewWeakReference;

    /* renamed from: sb */
    private StringBuffer f16sb = new StringBuffer();
    private LruCache<String, String> linkIdUrlCache = new LruCache<>(10);
    private String linkId = "";
    private String currentUrl = "";
    private String activityName = "";
    private int reportType = -1;
    private int minUploadInterval = 1000;

    private UCHAReporter() {
        this.logHandler = null;
        HandlerThread handlerThread = new HandlerThread("UC_HA");
        handlerThread.start();
        this.logHandler = new Handler(handlerThread.getLooper());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void commitUCHA() {
        GreyPageInfo greyPageInfo;
        if (TextUtils.isEmpty(this.f16sb) || WVPerformanceManager.getInstance().getConfig().closeUCHA()) {
            return;
        }
        HashMap hashMap = new HashMap();
        String str = this.linkId;
        String remove = str != null ? this.linkIdUrlCache.remove(str) : this.currentUrl;
        hashMap.put(HttpConnector.URL, remove);
        hashMap.put("error", this.f16sb.toString());
        if (this.reportType == 0 && !TextUtils.isEmpty(remove) && (greyPageInfo = GreyPageManager.getInstance().getGreyPageInfo(remove)) != null) {
            TaoLog.m27v(TAG, "found grey page: " + remove);
            hashMap.put(GreyPageInfo.KEY_AIR_TAG, greyPageInfo.generateOutputString());
        }
        int i = this.reportType;
        String str2 = i != 0 ? i != 1 ? i != 2 ? i != 3 ? "" : "WindVane.Memory" : "WindVane.BlackScreen" : "WindVane.UCHAR" : "TEMP_H5_ERROR_EVENT";
        if (!TextUtils.isEmpty(str2)) {
            WVHAManager.commitData(str2, remove, String.valueOf(commonID), this.activityName, hashMap);
        }
        StringBuffer stringBuffer = this.f16sb;
        stringBuffer.delete(0, stringBuffer.length());
        end();
    }

    private void end() {
        this.logHandler.removeCallbacks(mLogRunnable);
    }

    public static UCHAReporter getInstance() {
        if (INSTANCE == null) {
            synchronized (UCHAReporter.class) {
                if (INSTANCE == null) {
                    INSTANCE = new UCHAReporter();
                }
            }
        }
        return INSTANCE;
    }

    private boolean isPreRenderPage(int i, String str) {
        if (i != 0) {
            return false;
        }
        try {
            if (!WVCommonConfig.commonConfig.skipPreRenderBackgroundWhitePage) {
                return false;
            }
            String str2 = str != null ? this.linkIdUrlCache.get(str) : this.currentUrl;
            if (!TextUtils.isEmpty(str2) && str2.contains(BasePreInitManager.PRE_RENDER_URL_ADDITION_JUDGE)) {
                TaoLog.m21e(TAG, "IPreRenderWebView skip upload white page");
                return true;
            }
            TaoLog.m21e(TAG, "upload white page :" + str2);
            return false;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public void putLinkIdWithUrl(String str, String str2) {
        this.linkIdUrlCache.put(str, str2);
    }

    void reset(String str, String str2) {
        commitUCHA();
        this.currentUrl = str;
        commonID = System.currentTimeMillis();
        this.activityName = str2;
    }

    public void set(String str, int i, String str2) {
        if (isPreRenderPage(i, str2)) {
            return;
        }
        this.logHandler.removeCallbacks(mLogRunnable);
        if (!TextUtils.equals(this.linkId, str2)) {
            if (!TextUtils.isEmpty(this.linkId)) {
                commitUCHA();
            }
            this.linkId = str2;
        }
        this.reportType = i;
        this.logHandler.postDelayed(mLogRunnable, this.minUploadInterval);
        StringBuffer stringBuffer = this.f16sb;
        stringBuffer.append(str);
        stringBuffer.append("\n");
    }

    public void setWebview(WebView webView) {
        this.webViewWeakReference = new WeakReference<>(webView);
    }
}
