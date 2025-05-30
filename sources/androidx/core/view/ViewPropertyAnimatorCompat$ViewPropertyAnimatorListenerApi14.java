package androidx.core.view;

import android.annotation.SuppressLint;
import android.os.Build;
import android.view.View;
import androidx.annotation.NonNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
class ViewPropertyAnimatorCompat$ViewPropertyAnimatorListenerApi14 implements ViewPropertyAnimatorListener {
    boolean mAnimEndCalled;
    ViewPropertyAnimatorCompat mVpa;

    ViewPropertyAnimatorCompat$ViewPropertyAnimatorListenerApi14(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat) {
        this.mVpa = viewPropertyAnimatorCompat;
    }

    @Override // androidx.core.view.ViewPropertyAnimatorListener
    public void onAnimationCancel(@NonNull View view) {
        Object tag = view.getTag(2113929216);
        ViewPropertyAnimatorListener viewPropertyAnimatorListener = tag instanceof ViewPropertyAnimatorListener ? (ViewPropertyAnimatorListener) tag : null;
        if (viewPropertyAnimatorListener != null) {
            viewPropertyAnimatorListener.onAnimationCancel(view);
        }
    }

    @Override // androidx.core.view.ViewPropertyAnimatorListener
    @SuppressLint({"WrongConstant"})
    public void onAnimationEnd(@NonNull View view) {
        int i = this.mVpa.mOldLayerType;
        if (i > -1) {
            view.setLayerType(i, null);
            this.mVpa.mOldLayerType = -1;
        }
        if (Build.VERSION.SDK_INT >= 16 || !this.mAnimEndCalled) {
            ViewPropertyAnimatorCompat viewPropertyAnimatorCompat = this.mVpa;
            Runnable runnable = viewPropertyAnimatorCompat.mEndAction;
            if (runnable != null) {
                viewPropertyAnimatorCompat.mEndAction = null;
                runnable.run();
            }
            Object tag = view.getTag(2113929216);
            ViewPropertyAnimatorListener viewPropertyAnimatorListener = tag instanceof ViewPropertyAnimatorListener ? (ViewPropertyAnimatorListener) tag : null;
            if (viewPropertyAnimatorListener != null) {
                viewPropertyAnimatorListener.onAnimationEnd(view);
            }
            this.mAnimEndCalled = true;
        }
    }

    @Override // androidx.core.view.ViewPropertyAnimatorListener
    public void onAnimationStart(@NonNull View view) {
        this.mAnimEndCalled = false;
        if (this.mVpa.mOldLayerType > -1) {
            view.setLayerType(2, null);
        }
        ViewPropertyAnimatorCompat viewPropertyAnimatorCompat = this.mVpa;
        Runnable runnable = viewPropertyAnimatorCompat.mStartAction;
        if (runnable != null) {
            viewPropertyAnimatorCompat.mStartAction = null;
            runnable.run();
        }
        Object tag = view.getTag(2113929216);
        ViewPropertyAnimatorListener viewPropertyAnimatorListener = tag instanceof ViewPropertyAnimatorListener ? (ViewPropertyAnimatorListener) tag : null;
        if (viewPropertyAnimatorListener != null) {
            viewPropertyAnimatorListener.onAnimationStart(view);
        }
    }
}
