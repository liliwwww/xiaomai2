package androidx.compose.animation.core;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public final class SpringSimulationKt {
    private static final float UNSET = Float.MAX_VALUE;
    private static final double VelocityThresholdMultiplier = 62.5d;

    public static final long Motion(float f, float f2) {
        return Motion.m1055constructorimpl((Float.floatToIntBits(f2) & 4294967295L) | (Float.floatToIntBits(f) << 32));
    }

    public static final float getUNSET() {
        return UNSET;
    }
}
