package androidx.compose.animation.core;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public final class SpringSimulation {
    private double dampedFreq;
    private float finalPosition;
    private double gammaMinus;
    private double gammaPlus;
    private boolean initialized;
    private double naturalFreq = Math.sqrt(50.0d);
    private float dampingRatio = 1.0f;

    public SpringSimulation(float f) {
        this.finalPosition = f;
    }

    private final void init() {
        if (this.initialized) {
            return;
        }
        if (this.finalPosition == SpringSimulationKt.getUNSET()) {
            throw new IllegalStateException("Error: Final position of the spring must be set before the animation starts");
        }
        float f = this.dampingRatio;
        double d = f * f;
        if (f > 1.0f) {
            double d2 = this.naturalFreq;
            double d3 = d - 1;
            this.gammaPlus = ((-f) * d2) + (d2 * Math.sqrt(d3));
            double d4 = -this.dampingRatio;
            double d5 = this.naturalFreq;
            this.gammaMinus = (d4 * d5) - (d5 * Math.sqrt(d3));
        } else if (f >= 0.0f && f < 1.0f) {
            this.dampedFreq = this.naturalFreq * Math.sqrt(1 - d);
        }
        this.initialized = true;
    }

    public final float getAcceleration(float f, float f2) {
        float f3 = f - this.finalPosition;
        double d = this.naturalFreq;
        return (float) (((-(d * d)) * f3) - (((d * 2.0d) * this.dampingRatio) * f2));
    }

    public final float getDampingRatio() {
        return this.dampingRatio;
    }

    public final float getFinalPosition() {
        return this.finalPosition;
    }

    public final float getStiffness() {
        double d = this.naturalFreq;
        return (float) (d * d);
    }

    public final void setDampingRatio(float f) {
        if (f < 0.0f) {
            throw new IllegalArgumentException("Damping ratio must be non-negative");
        }
        this.dampingRatio = f;
        this.initialized = false;
    }

    public final void setFinalPosition(float f) {
        this.finalPosition = f;
    }

    public final void setStiffness(float f) {
        if (getStiffness() <= 0.0f) {
            throw new IllegalArgumentException("Spring stiffness constant must be positive.");
        }
        this.naturalFreq = Math.sqrt(f);
        this.initialized = false;
    }

    /* renamed from: updateValues-IJZedt4$animation_core_release, reason: not valid java name */
    public final long m1067updateValuesIJZedt4$animation_core_release(float f, float f2, long j) {
        double cos;
        double d;
        init();
        float f3 = f - this.finalPosition;
        double d2 = j / 1000.0d;
        float f4 = this.dampingRatio;
        if (f4 > 1.0f) {
            double d3 = f3;
            double d4 = this.gammaMinus;
            double d5 = f2;
            double d6 = this.gammaPlus;
            double d7 = d3 - (((d4 * d3) - d5) / (d4 - d6));
            double d8 = ((d3 * d4) - d5) / (d4 - d6);
            d = (Math.exp(d4 * d2) * d7) + (Math.exp(this.gammaPlus * d2) * d8);
            double d9 = this.gammaMinus;
            double exp = d7 * d9 * Math.exp(d9 * d2);
            double d10 = this.gammaPlus;
            cos = exp + (d8 * d10 * Math.exp(d10 * d2));
        } else {
            if (f4 == 1.0f) {
                double d11 = this.naturalFreq;
                double d12 = f3;
                double d13 = f2 + (d11 * d12);
                double d14 = d12 + (d13 * d2);
                double exp2 = Math.exp((-d11) * d2) * d14;
                double exp3 = d14 * Math.exp((-this.naturalFreq) * d2);
                double d15 = this.naturalFreq;
                cos = (exp3 * (-d15)) + (d13 * Math.exp((-d15) * d2));
                d = exp2;
            } else {
                double d16 = 1 / this.dampedFreq;
                double d17 = this.naturalFreq;
                double d18 = f3;
                double d19 = d16 * ((f4 * d17 * d18) + f2);
                double exp4 = Math.exp((-f4) * d17 * d2) * ((Math.cos(this.dampedFreq * d2) * d18) + (Math.sin(this.dampedFreq * d2) * d19));
                double d20 = this.naturalFreq;
                double d21 = (-d20) * exp4 * this.dampingRatio;
                double exp5 = Math.exp((-r5) * d20 * d2);
                double d22 = this.dampedFreq;
                double sin = (-d22) * d18 * Math.sin(d22 * d2);
                double d23 = this.dampedFreq;
                cos = d21 + (exp5 * (sin + (d19 * d23 * Math.cos(d23 * d2))));
                d = exp4;
            }
        }
        return SpringSimulationKt.Motion((float) (d + this.finalPosition), (float) cos);
    }
}
