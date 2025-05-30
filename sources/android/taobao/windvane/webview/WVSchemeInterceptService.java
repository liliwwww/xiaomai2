package android.taobao.windvane.webview;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public class WVSchemeInterceptService {
    private static WVSchemeIntercepterInterface mIntercepter;

    public static WVSchemeIntercepterInterface getWVSchemeIntercepter() {
        return mIntercepter;
    }

    public static void registerWVURLintercepter(WVSchemeIntercepterInterface wVSchemeIntercepterInterface) {
        mIntercepter = wVSchemeIntercepterInterface;
    }
}
