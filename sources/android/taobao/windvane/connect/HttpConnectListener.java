package android.taobao.windvane.connect;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public abstract class HttpConnectListener<T> {
    public void onError(int i, String str) {
    }

    public abstract void onFinish(T t, int i);

    public void onProcess(int i) {
    }

    public void onStart() {
    }
}
