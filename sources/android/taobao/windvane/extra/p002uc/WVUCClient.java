package android.taobao.windvane.extra.p002uc;

import android.net.Uri;
import android.taobao.windvane.config.GlobalConfig;
import android.taobao.windvane.config.WVCommonConfig;
import android.taobao.windvane.config.WVCommonConfigData;
import android.taobao.windvane.connect.HttpConnector;
import android.taobao.windvane.embed.BaseEmbedView;
import android.taobao.windvane.embed.Empty;
import android.taobao.windvane.embed.WVEVManager;
import android.taobao.windvane.extra.config.WindVaneUrlCacheManager;
import android.taobao.windvane.extra.performance2.UCTracker;
import android.taobao.windvane.extra.performance2.WVWPData;
import android.taobao.windvane.monitor.AppMonitorUtil;
import android.taobao.windvane.monitor.WVMonitorService;
import android.taobao.windvane.p003ha.UCHAReporter;
import android.taobao.windvane.util.FullTraceUtils;
import android.taobao.windvane.util.TaoLog;
import android.taobao.windvane.utils.TimeUtils;
import android.taobao.windvane.webview.IFullTrace;
import android.taobao.windvane.webview.IWVWebView;
import android.text.TextUtils;
import android.webkit.ValueCallback;
import com.taobao.monitor.procedure.IProcedure;
import com.uc.webview.export.WebView;
import com.uc.webview.export.extension.EmbedViewConfig;
import com.uc.webview.export.extension.IEmbedView;
import com.uc.webview.export.extension.IEmbedViewContainer;
import com.uc.webview.export.extension.UCClient;
import java.util.Map;
import org.json.JSONObject;
import tb.om3;
import tb.zy3;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class WVUCClient extends UCClient {
    private static final String TAG = "WVUCClient";
    String tStart;
    IWVWebView webView;

    public WVUCClient() {
        this.webView = null;
        this.tStart = "0";
    }

    public String getCachedFilePath(String str) {
        return WindVaneUrlCacheManager.getCacheFilePath(str);
    }

    public IEmbedView getEmbedView(EmbedViewConfig embedViewConfig, IEmbedViewContainer iEmbedViewContainer) {
        Map map = embedViewConfig.mObjectParam;
        if (map.containsKey("viewType")) {
            BaseEmbedView createEV = WVEVManager.createEV(map.containsKey("bridgeId") ? (String) map.get("bridgeId") : "", (String) map.get("viewType"), this.webView, embedViewConfig);
            if (createEV != null) {
                iEmbedViewContainer.setOnParamChangedListener(createEV);
                iEmbedViewContainer.setOnStateChangedListener(createEV);
                iEmbedViewContainer.setOnVisibilityChangedListener(createEV);
                return createEV;
            }
            TaoLog.m21e("EmbedView", "failed to create embedView");
        } else {
            TaoLog.m21e("EmbedView", "viewType should not be lost");
        }
        Empty empty = new Empty();
        empty.init("", "empty", this.webView, null);
        return empty;
    }

    public void onGpuProcessGone(String str) {
        TaoLog.m24i("sandbox", "onGpuProcessGone");
        if (str.contains("hasWebGl")) {
            Uri parse = Uri.parse(this.webView.getUrl());
            String str2 = parse.getHost() + parse.getPath();
            if (!GlobalConfig.isBackground) {
                TaoLog.m21e("GPU", "gpu process is killed, url = [" + str2 + "] , upload information!");
                AppMonitorUtil.commitFail(AppMonitorUtil.MONITOR_POINT_GPU_PROCESS_GONE_TYPE, 1, null, str2);
            }
            WVCommonConfigData wVCommonConfigData = WVCommonConfig.commonConfig;
            if (wVCommonConfigData.ucParam.glLostUnreloadList.contains(str2)) {
                TaoLog.m21e("GPU", "gpu process error, need not reload page, url = [" + str2 + "]");
                return;
            }
            WVCommonConfig.getInstance();
            if (wVCommonConfigData.enableGpuGoneReload) {
                this.webView.refresh();
                TaoLog.m21e("GPU", "gpu process error, reload page, url = [" + str2 + "]");
            }
        }
    }

    public void onWebViewEvent(final WebView webView, int i, Object obj) {
        String str;
        String str2;
        String str3;
        String str4;
        WVWPData wVWPData;
        if (i == 9) {
            try {
                Integer valueOf = obj instanceof String ? Integer.valueOf((String) obj) : (Integer) obj;
                String url = webView.getUrl();
                if (!TextUtils.isEmpty(url)) {
                    AppMonitorUtil.commitEmptyPage(url, "TYPEB_" + valueOf.toString());
                } else if (webView instanceof WVUCWebView) {
                    String currentUrl = ((WVUCWebView) webView).getCurrentUrl();
                    if (!TextUtils.isEmpty(currentUrl)) {
                        AppMonitorUtil.commitEmptyPage(currentUrl, "TYPEA_" + valueOf.toString());
                    }
                }
            } catch (Throwable unused) {
            }
        } else if (i == 107) {
            TaoLog.m24i("sandbox", "onRenderProcessReady");
            if ((webView instanceof WVUCWebView) && webView.getUCExtension() != null) {
                webView.getUCExtension().getCoreStatus(1, new ValueCallback<Object>() { // from class: android.taobao.windvane.extra.uc.WVUCClient.1
                    @Override // android.webkit.ValueCallback
                    public void onReceiveValue(Object obj2) {
                        WVUCWebViewClient wVUCWebViewClient = ((WVUCWebView) webView).webViewClient;
                        String str5 = wVUCWebViewClient == null ? "unknow" : wVUCWebViewClient.crashCount != 0 ? "Recover_Success" : "R_Success";
                        if (obj2 instanceof Integer) {
                            int intValue = ((Integer) obj2).intValue();
                            if (WVMonitorService.getWvMonitorInterface() != null) {
                                WVMonitorService.getWvMonitorInterface().commitRenderType(webView.getUrl(), str5, intValue);
                            }
                            TaoLog.m24i("sandbox", "process mode: " + intValue);
                        }
                    }
                });
            }
        } else if (i == 108) {
            TaoLog.m24i("sandbox", "WEBVIEW_EVENT_TYPE_DESTORY_NON_ISOLATE_STATIC_WEBVIEW");
            if (webView instanceof WVUCWebView) {
                WVUCWebView.destroyStaticWebViewIfNeeded();
            }
        } else if (i == 109) {
            TaoLog.m24i("sandbox", "WEBVIEW_EVENT_TYPE_CREATE_ISOLATE_STATIC_WEBVIEW");
            if ((webView instanceof WVUCWebView) && webView.getContext() != null) {
                WVUCWebView.createStaticWebViewIfNeeded(webView.getContext());
            }
        } else if (i != 4) {
            String str5 = "0";
            if (i == 6) {
                if (obj instanceof Map) {
                    Map map = (Map) obj;
                    if (map.containsKey("ts")) {
                        str5 = (String) map.get("ts");
                    }
                }
                long parseLong = Long.parseLong(str5);
                try {
                    ((WVUCWebView) webView).wvh5PPManager.recordUCT1(parseLong);
                    ((WVUCWebView) webView).pageTracker.onPageReceivedT1(parseLong);
                } catch (Throwable unused2) {
                }
                TaoLog.m24i("AIT", "UC_T1: " + parseLong);
            } else {
                str = "";
                if (i == 14) {
                    if (obj instanceof Map) {
                        Map map2 = (Map) obj;
                        String str6 = map2.containsKey("ts") ? (String) map2.get("ts") : "0";
                        if (map2.containsKey("time")) {
                            str5 = (String) map2.get("time");
                            if ((webView instanceof WVUCWebView) && (wVWPData = ((WVUCWebView) webView).wpData) != null) {
                                wVWPData.f12t2 = str5;
                            }
                        }
                        str = map2.containsKey(HttpConnector.URL) ? (String) map2.get(HttpConnector.URL) : "";
                        str4 = str5;
                        str5 = str6;
                    } else {
                        str4 = "0";
                    }
                    long parseLong2 = Long.parseLong(str5);
                    try {
                        if (webView instanceof IFullTrace) {
                            FullTraceUtils.addStage(((IFullTrace) webView).getSpanWrapper(), "UC_T2");
                            FullTraceUtils.addProperty(((IFullTrace) webView).getSpanWrapper(), "UC_T2", str4);
                        }
                        ((WVUCWebView) webView).wvh5PPManager.recordUCT2(parseLong2);
                        if (str4 != null) {
                            UCTracker.commitUCT2(str, (long) Double.parseDouble(str4));
                        }
                        Long valueOf2 = Long.valueOf(TimeUtils.generateUptimeFromCurrentTime(parseLong2));
                        IProcedure launcherProcedure = zy3.b.getLauncherProcedure();
                        if (launcherProcedure == null || !launcherProcedure.isAlive()) {
                            TaoLog.m27v(TAG, "LauncherProcedure is not Alive");
                        } else {
                            launcherProcedure.stage("H5_UC_T2", valueOf2.longValue());
                        }
                        IProcedure currentActivityProcedure = zy3.b.getCurrentActivityProcedure();
                        if (currentActivityProcedure == null || !currentActivityProcedure.isAlive()) {
                            TaoLog.m27v(TAG, "CurrentActivityProcedure is not Alive");
                        } else {
                            currentActivityProcedure.stage("H5_UC_T2", valueOf2.longValue());
                        }
                        IProcedure procedure = zy3.b.getProcedure(webView);
                        if (procedure == null || !procedure.isAlive()) {
                            TaoLog.m27v(TAG, "LauncherProcedure is not Alive");
                        } else {
                            procedure.stage("H5_UC_T2", valueOf2.longValue());
                        }
                        TaoLog.m21e(TAG, "H5_UC_T2 time:" + valueOf2);
                        om3.a.getPageGroup(webView).getPageRenderStandard().onPageVisible(TimeUtils.generateUptimeFromCurrentTime(parseLong2));
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                    TaoLog.m24i("AIT", "UC_T2: " + str5);
                } else if (i == 20) {
                    if (obj instanceof String) {
                        try {
                            JSONObject jSONObject = new JSONObject(String.valueOf(obj));
                            str2 = jSONObject.optString(HttpConnector.URL);
                            try {
                                str = jSONObject.optString("linkId");
                            } catch (Throwable unused3) {
                            }
                        } catch (Throwable unused4) {
                            str2 = "";
                        }
                    } else if (obj instanceof Map) {
                        Map map3 = (Map) obj;
                        str2 = map3.containsKey(HttpConnector.URL) ? (String) map3.get(HttpConnector.URL) : "";
                        if (map3.containsKey("linkId")) {
                            str = (String) map3.get("linkId");
                        }
                    } else {
                        str3 = "";
                        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str3)) {
                            UCHAReporter.getInstance().putLinkIdWithUrl(str3, str);
                        }
                        TaoLog.m24i("UCHA", "linkId: " + str3 + ", url: " + str);
                    }
                    str3 = str;
                    str = str2;
                    if (!TextUtils.isEmpty(str)) {
                        UCHAReporter.getInstance().putLinkIdWithUrl(str3, str);
                    }
                    TaoLog.m24i("UCHA", "linkId: " + str3 + ", url: " + str);
                } else if (i == 106) {
                    TaoLog.m21e("GPU", "page use webgl, url = [" + webView.getUrl() + "]");
                    if (WVMonitorService.getWvMonitorInterface() != null) {
                        WVMonitorService.getWvMonitorInterface().commitUseWebgl(webView.getUrl());
                    }
                }
            }
        } else if (obj instanceof Map) {
            Map map4 = (Map) obj;
            if (map4.containsKey("time")) {
                this.tStart = (String) map4.get("time");
            }
        }
        super.onWebViewEvent(webView, i, obj);
    }

    public WVUCClient(IWVWebView iWVWebView) {
        this.webView = null;
        this.tStart = "0";
        this.webView = iWVWebView;
    }
}
