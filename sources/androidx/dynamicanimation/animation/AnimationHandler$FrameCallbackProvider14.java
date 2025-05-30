package androidx.dynamicanimation.animation;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import androidx.dynamicanimation.animation.AnimationHandler;

/* JADX INFO: Access modifiers changed from: private */
/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public class AnimationHandler$FrameCallbackProvider14 extends AnimationHandler.AnimationFrameCallbackProvider {
    private final Handler mHandler;
    long mLastFrameTime;
    private final Runnable mRunnable;

    AnimationHandler$FrameCallbackProvider14(AnimationHandler.AnimationCallbackDispatcher animationCallbackDispatcher) {
        super(animationCallbackDispatcher);
        this.mLastFrameTime = -1L;
        this.mRunnable = new Runnable() { // from class: androidx.dynamicanimation.animation.AnimationHandler$FrameCallbackProvider14.1
            @Override // java.lang.Runnable
            public void run() {
                AnimationHandler$FrameCallbackProvider14.this.mLastFrameTime = SystemClock.uptimeMillis();
                ((AnimationHandler.AnimationFrameCallbackProvider) AnimationHandler$FrameCallbackProvider14.this).mDispatcher.dispatchAnimationFrame();
            }
        };
        this.mHandler = new Handler(Looper.myLooper());
    }

    void postFrameCallback() {
        this.mHandler.postDelayed(this.mRunnable, Math.max(10 - (SystemClock.uptimeMillis() - this.mLastFrameTime), 0L));
    }
}
