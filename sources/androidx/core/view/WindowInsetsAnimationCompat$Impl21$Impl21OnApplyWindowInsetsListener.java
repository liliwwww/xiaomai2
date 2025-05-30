package androidx.core.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.WindowInsets;
import android.view.animation.DecelerateInterpolator;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.core.view.WindowInsetsAnimationCompat;
import androidx.core.view.WindowInsetsCompat;
import java.util.Collections;
import java.util.Objects;

/* JADX INFO: Access modifiers changed from: private */
/* compiled from: Taobao */
@RequiresApi(21)
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public class WindowInsetsAnimationCompat$Impl21$Impl21OnApplyWindowInsetsListener implements View.OnApplyWindowInsetsListener {
    private static final int COMPAT_ANIMATION_DURATION = 160;
    final WindowInsetsAnimationCompat.Callback mCallback;
    private WindowInsetsCompat mLastInsets;

    WindowInsetsAnimationCompat$Impl21$Impl21OnApplyWindowInsetsListener(@NonNull View view, @NonNull WindowInsetsAnimationCompat.Callback callback) {
        this.mCallback = callback;
        WindowInsetsCompat rootWindowInsets = ViewCompat.getRootWindowInsets(view);
        this.mLastInsets = rootWindowInsets != null ? new WindowInsetsCompat.Builder(rootWindowInsets).build() : null;
    }

    @Override // android.view.View.OnApplyWindowInsetsListener
    public WindowInsets onApplyWindowInsets(final View view, WindowInsets windowInsets) {
        if (!view.isLaidOut()) {
            this.mLastInsets = WindowInsetsCompat.toWindowInsetsCompat(windowInsets, view);
            return WindowInsetsAnimationCompat.Impl21.forwardToViewIfNeeded(view, windowInsets);
        }
        final WindowInsetsCompat windowInsetsCompat = WindowInsetsCompat.toWindowInsetsCompat(windowInsets, view);
        if (this.mLastInsets == null) {
            this.mLastInsets = ViewCompat.getRootWindowInsets(view);
        }
        if (this.mLastInsets == null) {
            this.mLastInsets = windowInsetsCompat;
            return WindowInsetsAnimationCompat.Impl21.forwardToViewIfNeeded(view, windowInsets);
        }
        WindowInsetsAnimationCompat.Callback callback = WindowInsetsAnimationCompat.Impl21.getCallback(view);
        if (callback != null && Objects.equals(callback.mDispachedInsets, windowInsets)) {
            return WindowInsetsAnimationCompat.Impl21.forwardToViewIfNeeded(view, windowInsets);
        }
        final int buildAnimationMask = WindowInsetsAnimationCompat.Impl21.buildAnimationMask(windowInsetsCompat, this.mLastInsets);
        if (buildAnimationMask == 0) {
            return WindowInsetsAnimationCompat.Impl21.forwardToViewIfNeeded(view, windowInsets);
        }
        final WindowInsetsCompat windowInsetsCompat2 = this.mLastInsets;
        final WindowInsetsAnimationCompat windowInsetsAnimationCompat = new WindowInsetsAnimationCompat(buildAnimationMask, new DecelerateInterpolator(), 160L);
        windowInsetsAnimationCompat.setFraction(0.0f);
        final ValueAnimator duration = ValueAnimator.ofFloat(0.0f, 1.0f).setDuration(windowInsetsAnimationCompat.getDurationMillis());
        final WindowInsetsAnimationCompat.BoundsCompat computeAnimationBounds = WindowInsetsAnimationCompat.Impl21.computeAnimationBounds(windowInsetsCompat, windowInsetsCompat2, buildAnimationMask);
        WindowInsetsAnimationCompat.Impl21.dispatchOnPrepare(view, windowInsetsAnimationCompat, windowInsets, false);
        duration.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: androidx.core.view.WindowInsetsAnimationCompat$Impl21$Impl21OnApplyWindowInsetsListener.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                windowInsetsAnimationCompat.setFraction(valueAnimator.getAnimatedFraction());
                WindowInsetsAnimationCompat.Impl21.dispatchOnProgress(view, WindowInsetsAnimationCompat.Impl21.interpolateInsets(windowInsetsCompat, windowInsetsCompat2, windowInsetsAnimationCompat.getInterpolatedFraction(), buildAnimationMask), Collections.singletonList(windowInsetsAnimationCompat));
            }
        });
        duration.addListener(new AnimatorListenerAdapter() { // from class: androidx.core.view.WindowInsetsAnimationCompat$Impl21$Impl21OnApplyWindowInsetsListener.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                windowInsetsAnimationCompat.setFraction(1.0f);
                WindowInsetsAnimationCompat.Impl21.dispatchOnEnd(view, windowInsetsAnimationCompat);
            }
        });
        OneShotPreDrawListener.add(view, new Runnable() { // from class: androidx.core.view.WindowInsetsAnimationCompat$Impl21$Impl21OnApplyWindowInsetsListener.3
            @Override // java.lang.Runnable
            public void run() {
                WindowInsetsAnimationCompat.Impl21.dispatchOnStart(view, windowInsetsAnimationCompat, computeAnimationBounds);
                duration.start();
            }
        });
        this.mLastInsets = windowInsetsCompat;
        return WindowInsetsAnimationCompat.Impl21.forwardToViewIfNeeded(view, windowInsets);
    }
}
