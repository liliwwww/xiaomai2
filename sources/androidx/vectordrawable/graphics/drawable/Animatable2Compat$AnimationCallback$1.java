package androidx.vectordrawable.graphics.drawable;

import android.graphics.drawable.Animatable2;
import android.graphics.drawable.Drawable;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
class Animatable2Compat$AnimationCallback$1 extends Animatable2.AnimationCallback {
    final /* synthetic */ Animatable2Compat.AnimationCallback this$0;

    Animatable2Compat$AnimationCallback$1(Animatable2Compat.AnimationCallback animationCallback) {
        this.this$0 = animationCallback;
    }

    @Override // android.graphics.drawable.Animatable2.AnimationCallback
    public void onAnimationEnd(Drawable drawable) {
        this.this$0.onAnimationEnd(drawable);
    }

    @Override // android.graphics.drawable.Animatable2.AnimationCallback
    public void onAnimationStart(Drawable drawable) {
        this.this$0.onAnimationStart(drawable);
    }
}
