package androidx.appcompat.graphics.drawable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
class DrawableContainerCompat$1 implements Runnable {
    final /* synthetic */ DrawableContainerCompat this$0;

    DrawableContainerCompat$1(DrawableContainerCompat drawableContainerCompat) {
        this.this$0 = drawableContainerCompat;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.this$0.animate(true);
        this.this$0.invalidateSelf();
    }
}
