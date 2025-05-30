package androidx.dynamicanimation.animation;

import android.view.Choreographer;
import androidx.annotation.RequiresApi;
import androidx.dynamicanimation.animation.AnimationHandler;

/* JADX INFO: Access modifiers changed from: private */
/* compiled from: Taobao */
@RequiresApi(16)
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public class AnimationHandler$FrameCallbackProvider16 extends AnimationHandler.AnimationFrameCallbackProvider {
    private final Choreographer mChoreographer;
    private final Choreographer.FrameCallback mChoreographerCallback;

    AnimationHandler$FrameCallbackProvider16(AnimationHandler.AnimationCallbackDispatcher animationCallbackDispatcher) {
        super(animationCallbackDispatcher);
        this.mChoreographer = Choreographer.getInstance();
        this.mChoreographerCallback = new 1(this);
    }

    void postFrameCallback() {
        this.mChoreographer.postFrameCallback(this.mChoreographerCallback);
    }
}
