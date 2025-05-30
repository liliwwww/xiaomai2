package android.taobao.windvane.embed;

import android.taobao.windvane.util.TaoLog;
import android.taobao.windvane.webview.IWVWebView;
import android.text.TextUtils;
import com.uc.webview.export.extension.EmbedViewConfig;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class WVEVManager {
    private static final String TAG = "WVEVManager";
    private static final Map<String, WVEmbedViewInfo> embedViews = new ConcurrentHashMap();

    public static BaseEmbedView createEV(String str, String str2, IWVWebView iWVWebView, EmbedViewConfig embedViewConfig) {
        WVEmbedViewInfo ev = getEv(str2);
        if (ev == null) {
            TaoLog.m21e(TAG, "no register view with type:[" + str2 + "]");
            return null;
        }
        try {
            ClassLoader classLoader = ev.getClassLoader();
            Class<?> cls = classLoader == null ? Class.forName(ev.getClassName()) : classLoader.loadClass(ev.getClassName());
            if (cls == null || !BaseEmbedView.class.isAssignableFrom(cls)) {
                TaoLog.m21e(TAG, "no class found");
            } else {
                BaseEmbedView baseEmbedView = (BaseEmbedView) cls.newInstance();
                if (baseEmbedView.init(str, str2, iWVWebView, embedViewConfig)) {
                    return baseEmbedView;
                }
                TaoLog.m21e(TAG, "type check error, required type:[" + baseEmbedView.getViewType() + "], real type:[" + str2 + "]");
            }
        } catch (Exception e) {
            TaoLog.m21e(TAG, "create embed view error, type:" + str2 + " | msg:" + e.getMessage());
        }
        return null;
    }

    public static ArrayList<String> getEmbedViewNames() {
        Iterator<String> it = embedViews.keySet().iterator();
        ArrayList<String> arrayList = new ArrayList<>();
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        return arrayList;
    }

    public static WVEmbedViewInfo getEv(String str) {
        return embedViews.get(str);
    }

    public static void registerEmbedView(String str, Class<? extends BaseEmbedView> cls, boolean z) {
        if (TextUtils.isEmpty(str) || cls == null) {
            return;
        }
        WVEmbedViewInfo wVEmbedViewInfo = new WVEmbedViewInfo(cls.getName(), z ? cls.getClassLoader() : null);
        Map<String, WVEmbedViewInfo> map = embedViews;
        if (map.containsKey(str)) {
            TaoLog.m21e(TAG, "new view:[" + cls.getSimpleName() + "] will overlap the old view [" + map.get(str).getClassName() + "]");
        }
        map.put(str, wVEmbedViewInfo);
    }

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public static class WVEmbedViewInfo {
        private ClassLoader classLoader;
        private String className;

        WVEmbedViewInfo(String str) {
            this.className = str;
        }

        public ClassLoader getClassLoader() {
            return this.classLoader;
        }

        public String getClassName() {
            return this.className;
        }

        public void setClassLoader(ClassLoader classLoader) {
            this.classLoader = classLoader;
        }

        public void setClassName(String str) {
            this.className = str;
        }

        WVEmbedViewInfo(String str, ClassLoader classLoader) {
            this.className = str;
            this.classLoader = classLoader;
        }
    }
}
