package androidx.constraintlayout.helper.widget;

import androidx.constraintlayout.helper.widget.Carousel;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
class Carousel$1$1 implements Runnable {
    final /* synthetic */ Carousel.1 this$1;
    final /* synthetic */ float val$v;

    Carousel$1$1(Carousel.1 r1, float f) {
        this.this$1 = r1;
        this.val$v = f;
    }

    @Override // java.lang.Runnable
    public void run() {
        Carousel.access$000(this.this$1.this$0).touchAnimateTo(5, 1.0f, this.val$v);
    }
}
