package android.taobao.windvane.webview;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public interface IPreRenderWebView {
    long getExpireTime();

    boolean isPreLoad();

    boolean isPreRenderSuccess();

    void preRenderInit(String str);

    void setExpireTime(long j);

    void setPreRenderSuccess(boolean z);
}
