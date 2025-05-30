package androidx.compose.animation.core;

import android.taobao.windvane.urlintercept.WVURLRuleConstants;
import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: Taobao */
@StabilityInferred(parameters = 0)
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class FloatExponentialDecaySpec implements FloatDecayAnimationSpec {
    public static final int $stable = 0;
    private final float absVelocityThreshold;
    private final float friction;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public FloatExponentialDecaySpec() {
        /*
            r3 = this;
            r0 = 0
            r1 = 3
            r2 = 0
            r3.<init>(r0, r0, r1, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.animation.core.FloatExponentialDecaySpec.<init>():void");
    }

    public FloatExponentialDecaySpec(float f, float f2) {
        this.absVelocityThreshold = Math.max(1.0E-7f, Math.abs(f2));
        this.friction = Math.max(1.0E-4f, f) * (-4.2f);
    }

    public float getAbsVelocityThreshold() {
        return this.absVelocityThreshold;
    }

    public long getDurationNanos(float f, float f2) {
        return ((long) ((((float) Math.log(getAbsVelocityThreshold() / Math.abs(f2))) * 1000.0f) / this.friction)) * 1000000;
    }

    public float getTargetValue(float f, float f2) {
        if (Math.abs(f2) <= getAbsVelocityThreshold()) {
            return f;
        }
        double log = Math.log(Math.abs(getAbsVelocityThreshold() / f2));
        float f3 = this.friction;
        return (f - (f2 / f3)) + ((f2 / f3) * ((float) Math.exp((f3 * ((log / f3) * WVURLRuleConstants.LOGIN)) / 1000.0f)));
    }

    public float getValueFromNanos(long j, float f, float f2) {
        float f3 = this.friction;
        return (f - (f2 / f3)) + ((f2 / f3) * ((float) Math.exp((f3 * (j / 1000000)) / 1000.0f)));
    }

    public float getVelocityFromNanos(long j, float f, float f2) {
        return f2 * ((float) Math.exp(((j / 1000000) / 1000.0f) * this.friction));
    }

    public /* synthetic */ FloatExponentialDecaySpec(float f, float f2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 1.0f : f, (i & 2) != 0 ? 0.1f : f2);
    }
}
