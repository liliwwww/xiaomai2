package androidx.dynamicanimation.animation;

import android.view.Choreographer;
import androidx.dynamicanimation.animation.AnimationHandler;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
class AnimationHandler$FrameCallbackProvider16$1 implements Choreographer.FrameCallback {
    final /* synthetic */ AnimationHandler.FrameCallbackProvider16 this$0;

    AnimationHandler$FrameCallbackProvider16$1(AnimationHandler.FrameCallbackProvider16 frameCallbackProvider16) {
        this.this$0 = frameCallbackProvider16;
    }

    @Override // android.view.Choreographer.FrameCallback
    public void doFrame(long j) {
        this.this$0.mDispatcher.dispatchAnimationFrame();
    }
}
