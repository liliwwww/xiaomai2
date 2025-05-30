package androidx.appcompat.app;

import androidx.appcompat.app.AppLocalesStorageHelper;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final /* synthetic */ class c implements Runnable {
    public final /* synthetic */ AppLocalesStorageHelper.SerialExecutor a;
    public final /* synthetic */ Runnable b;

    public /* synthetic */ c(AppLocalesStorageHelper.SerialExecutor serialExecutor, Runnable runnable) {
        this.a = serialExecutor;
        this.b = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AppLocalesStorageHelper.SerialExecutor.a(this.a, this.b);
    }
}
