package androidx.dynamicanimation.animation;

import androidx.annotation.FloatRange;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class FlingAnimation extends DynamicAnimation<FlingAnimation> {
    private final DragForce mFlingForce;

    /* compiled from: Taobao */
    static final class DragForce implements Force {
        private static final float DEFAULT_FRICTION = -4.2f;
        private static final float VELOCITY_THRESHOLD_MULTIPLIER = 62.5f;
        private float mFriction = DEFAULT_FRICTION;
        private final DynamicAnimation$MassState mMassState = new DynamicAnimation$MassState();
        private float mVelocityThreshold;

        DragForce() {
        }

        @Override // androidx.dynamicanimation.animation.Force
        public float getAcceleration(float f, float f2) {
            return f2 * this.mFriction;
        }

        float getFrictionScalar() {
            return this.mFriction / DEFAULT_FRICTION;
        }

        @Override // androidx.dynamicanimation.animation.Force
        public boolean isAtEquilibrium(float f, float f2) {
            return Math.abs(f2) < this.mVelocityThreshold;
        }

        void setFrictionScalar(float f) {
            this.mFriction = f * DEFAULT_FRICTION;
        }

        void setValueThreshold(float f) {
            this.mVelocityThreshold = f * VELOCITY_THRESHOLD_MULTIPLIER;
        }

        DynamicAnimation$MassState updateValueAndVelocity(float f, float f2, long j) {
            float f3 = j;
            this.mMassState.mVelocity = (float) (f2 * Math.exp((f3 / 1000.0f) * this.mFriction));
            DynamicAnimation$MassState dynamicAnimation$MassState = this.mMassState;
            float f4 = this.mFriction;
            dynamicAnimation$MassState.mValue = (float) ((f - (f2 / f4)) + ((f2 / f4) * Math.exp((f4 * f3) / 1000.0f)));
            DynamicAnimation$MassState dynamicAnimation$MassState2 = this.mMassState;
            if (isAtEquilibrium(dynamicAnimation$MassState2.mValue, dynamicAnimation$MassState2.mVelocity)) {
                this.mMassState.mVelocity = 0.0f;
            }
            return this.mMassState;
        }
    }

    public FlingAnimation(FloatValueHolder floatValueHolder) {
        super(floatValueHolder);
        DragForce dragForce = new DragForce();
        this.mFlingForce = dragForce;
        dragForce.setValueThreshold(getValueThreshold());
    }

    float getAcceleration(float f, float f2) {
        return this.mFlingForce.getAcceleration(f, f2);
    }

    public float getFriction() {
        return this.mFlingForce.getFrictionScalar();
    }

    boolean isAtEquilibrium(float f, float f2) {
        return f >= ((DynamicAnimation) this).mMaxValue || f <= ((DynamicAnimation) this).mMinValue || this.mFlingForce.isAtEquilibrium(f, f2);
    }

    public FlingAnimation setFriction(@FloatRange(from = 0.0d, fromInclusive = false) float f) {
        if (f <= 0.0f) {
            throw new IllegalArgumentException("Friction must be positive");
        }
        this.mFlingForce.setFrictionScalar(f);
        return this;
    }

    void setValueThreshold(float f) {
        this.mFlingForce.setValueThreshold(f);
    }

    boolean updateValueAndVelocity(long j) {
        DynamicAnimation$MassState updateValueAndVelocity = this.mFlingForce.updateValueAndVelocity(((DynamicAnimation) this).mValue, ((DynamicAnimation) this).mVelocity, j);
        float f = updateValueAndVelocity.mValue;
        ((DynamicAnimation) this).mValue = f;
        float f2 = updateValueAndVelocity.mVelocity;
        ((DynamicAnimation) this).mVelocity = f2;
        float f3 = ((DynamicAnimation) this).mMinValue;
        if (f < f3) {
            ((DynamicAnimation) this).mValue = f3;
            return true;
        }
        float f4 = ((DynamicAnimation) this).mMaxValue;
        if (f <= f4) {
            return isAtEquilibrium(f, f2);
        }
        ((DynamicAnimation) this).mValue = f4;
        return true;
    }

    public FlingAnimation setMaxValue(float f) {
        super.setMaxValue(f);
        return this;
    }

    public FlingAnimation setMinValue(float f) {
        super.setMinValue(f);
        return this;
    }

    public FlingAnimation setStartVelocity(float f) {
        super.setStartVelocity(f);
        return this;
    }

    public <K> FlingAnimation(K k, FloatPropertyCompat<K> floatPropertyCompat) {
        super(k, floatPropertyCompat);
        DragForce dragForce = new DragForce();
        this.mFlingForce = dragForce;
        dragForce.setValueThreshold(getValueThreshold());
    }
}
