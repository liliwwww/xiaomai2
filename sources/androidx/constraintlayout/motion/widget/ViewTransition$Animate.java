package androidx.constraintlayout.motion.widget;

import android.graphics.Rect;
import android.view.animation.Interpolator;
import androidx.constraintlayout.core.motion.utils.KeyCache;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
class ViewTransition$Animate {
    boolean hold_at_100;
    private final int mClearsTag;
    float mDpositionDt;
    int mDuration;
    Interpolator mInterpolator;
    long mLastRender;
    MotionController mMC;
    float mPosition;
    private final int mSetsTag;
    long mStart;
    int mUpDuration;
    ViewTransitionController mVtController;
    KeyCache mCache = new KeyCache();
    boolean reverse = false;
    Rect mTempRec = new Rect();

    ViewTransition$Animate(ViewTransitionController viewTransitionController, MotionController motionController, int i, int i2, int i3, Interpolator interpolator, int i4, int i5) {
        this.hold_at_100 = false;
        this.mVtController = viewTransitionController;
        this.mMC = motionController;
        this.mDuration = i;
        this.mUpDuration = i2;
        long nanoTime = System.nanoTime();
        this.mStart = nanoTime;
        this.mLastRender = nanoTime;
        this.mVtController.addAnimation(this);
        this.mInterpolator = interpolator;
        this.mSetsTag = i4;
        this.mClearsTag = i5;
        if (i3 == 3) {
            this.hold_at_100 = true;
        }
        this.mDpositionDt = i == 0 ? Float.MAX_VALUE : 1.0f / i;
        mutate();
    }

    void mutate() {
        if (this.reverse) {
            mutateReverse();
        } else {
            mutateForward();
        }
    }

    void mutateForward() {
        long nanoTime = System.nanoTime();
        long j = nanoTime - this.mLastRender;
        this.mLastRender = nanoTime;
        float f = this.mPosition + (((float) (j * 1.0E-6d)) * this.mDpositionDt);
        this.mPosition = f;
        if (f >= 1.0f) {
            this.mPosition = 1.0f;
        }
        Interpolator interpolator = this.mInterpolator;
        float interpolation = interpolator == null ? this.mPosition : interpolator.getInterpolation(this.mPosition);
        MotionController motionController = this.mMC;
        boolean interpolate = motionController.interpolate(motionController.mView, interpolation, nanoTime, this.mCache);
        if (this.mPosition >= 1.0f) {
            if (this.mSetsTag != -1) {
                this.mMC.getView().setTag(this.mSetsTag, Long.valueOf(System.nanoTime()));
            }
            if (this.mClearsTag != -1) {
                this.mMC.getView().setTag(this.mClearsTag, null);
            }
            if (!this.hold_at_100) {
                this.mVtController.removeAnimation(this);
            }
        }
        if (this.mPosition < 1.0f || interpolate) {
            this.mVtController.invalidate();
        }
    }

    void mutateReverse() {
        long nanoTime = System.nanoTime();
        long j = nanoTime - this.mLastRender;
        this.mLastRender = nanoTime;
        float f = this.mPosition - (((float) (j * 1.0E-6d)) * this.mDpositionDt);
        this.mPosition = f;
        if (f < 0.0f) {
            this.mPosition = 0.0f;
        }
        Interpolator interpolator = this.mInterpolator;
        float interpolation = interpolator == null ? this.mPosition : interpolator.getInterpolation(this.mPosition);
        MotionController motionController = this.mMC;
        boolean interpolate = motionController.interpolate(motionController.mView, interpolation, nanoTime, this.mCache);
        if (this.mPosition <= 0.0f) {
            if (this.mSetsTag != -1) {
                this.mMC.getView().setTag(this.mSetsTag, Long.valueOf(System.nanoTime()));
            }
            if (this.mClearsTag != -1) {
                this.mMC.getView().setTag(this.mClearsTag, null);
            }
            this.mVtController.removeAnimation(this);
        }
        if (this.mPosition > 0.0f || interpolate) {
            this.mVtController.invalidate();
        }
    }

    public void reactTo(int i, float f, float f2) {
        if (i == 1) {
            if (this.reverse) {
                return;
            }
            reverse(true);
        } else {
            if (i != 2) {
                return;
            }
            this.mMC.getView().getHitRect(this.mTempRec);
            if (this.mTempRec.contains((int) f, (int) f2) || this.reverse) {
                return;
            }
            reverse(true);
        }
    }

    void reverse(boolean z) {
        int i;
        this.reverse = z;
        if (z && (i = this.mUpDuration) != -1) {
            this.mDpositionDt = i == 0 ? Float.MAX_VALUE : 1.0f / i;
        }
        this.mVtController.invalidate();
        this.mLastRender = System.nanoTime();
    }
}
