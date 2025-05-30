package androidx.appcompat.graphics.drawable;

import androidx.appcompat.graphics.drawable.AnimatedStateListDrawableCompat;
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat;

/* JADX INFO: Access modifiers changed from: private */
/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public class AnimatedStateListDrawableCompat$AnimatedVectorDrawableTransition extends AnimatedStateListDrawableCompat.Transition {
    private final AnimatedVectorDrawableCompat mAvd;

    AnimatedStateListDrawableCompat$AnimatedVectorDrawableTransition(AnimatedVectorDrawableCompat animatedVectorDrawableCompat) {
        super((AnimatedStateListDrawableCompat.1) null);
        this.mAvd = animatedVectorDrawableCompat;
    }

    public void start() {
        this.mAvd.start();
    }

    public void stop() {
        this.mAvd.stop();
    }
}
