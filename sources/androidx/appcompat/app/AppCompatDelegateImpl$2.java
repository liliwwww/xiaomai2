package androidx.appcompat.app;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
class AppCompatDelegateImpl$2 implements Runnable {
    final /* synthetic */ AppCompatDelegateImpl this$0;

    AppCompatDelegateImpl$2(AppCompatDelegateImpl appCompatDelegateImpl) {
        this.this$0 = appCompatDelegateImpl;
    }

    @Override // java.lang.Runnable
    public void run() {
        AppCompatDelegateImpl appCompatDelegateImpl = this.this$0;
        if ((appCompatDelegateImpl.mInvalidatePanelMenuFeatures & 1) != 0) {
            appCompatDelegateImpl.doInvalidatePanelMenu(0);
        }
        AppCompatDelegateImpl appCompatDelegateImpl2 = this.this$0;
        if ((appCompatDelegateImpl2.mInvalidatePanelMenuFeatures & 4096) != 0) {
            appCompatDelegateImpl2.doInvalidatePanelMenu(108);
        }
        AppCompatDelegateImpl appCompatDelegateImpl3 = this.this$0;
        appCompatDelegateImpl3.mInvalidatePanelMenuPosted = false;
        appCompatDelegateImpl3.mInvalidatePanelMenuFeatures = 0;
    }
}
