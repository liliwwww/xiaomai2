package androidx.compose.animation.core;

import androidx.compose.runtime.Immutable;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@Immutable
/* loaded from: classes2.dex */
public final class CubicBezierEasing implements Easing {

    /* renamed from: a */
    private final float f74a;

    /* renamed from: b */
    private final float f75b;

    /* renamed from: c */
    private final float f76c;

    /* renamed from: d */
    private final float f77d;

    public CubicBezierEasing(float f, float f2, float f3, float f4) {
        this.f74a = f;
        this.f75b = f2;
        this.f76c = f3;
        this.f77d = f4;
        if ((Float.isNaN(f) || Float.isNaN(f2) || Float.isNaN(f3) || Float.isNaN(f4)) ? false : true) {
            return;
        }
        throw new IllegalArgumentException(("Parameters to CubicBezierEasing cannot be NaN. Actual parameters are: " + f + ", " + f2 + ", " + f3 + ", " + f4 + '.').toString());
    }

    private final float evaluateCubic(float f, float f2, float f3) {
        float f4 = 3;
        float f5 = 1 - f3;
        return (f * f4 * f5 * f5 * f3) + (f4 * f2 * f5 * f3 * f3) + (f3 * f3 * f3);
    }

    public boolean equals(@Nullable Object obj) {
        if (obj instanceof CubicBezierEasing) {
            CubicBezierEasing cubicBezierEasing = (CubicBezierEasing) obj;
            if (this.f74a == cubicBezierEasing.f74a) {
                if (this.f75b == cubicBezierEasing.f75b) {
                    if (this.f76c == cubicBezierEasing.f76c) {
                        if (this.f77d == cubicBezierEasing.f77d) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public int hashCode() {
        return (((((Float.floatToIntBits(this.f74a) * 31) + Float.floatToIntBits(this.f75b)) * 31) + Float.floatToIntBits(this.f76c)) * 31) + Float.floatToIntBits(this.f77d);
    }

    @Override // androidx.compose.animation.core.Easing
    public float transform(float f) {
        float f2 = 0.0f;
        if (f > 0.0f) {
            float f3 = 1.0f;
            if (f < 1.0f) {
                while (true) {
                    float f4 = (f2 + f3) / 2;
                    float evaluateCubic = evaluateCubic(this.f74a, this.f76c, f4);
                    if (Math.abs(f - evaluateCubic) < 0.001f) {
                        return evaluateCubic(this.f75b, this.f77d, f4);
                    }
                    if (evaluateCubic < f) {
                        f2 = f4;
                    } else {
                        f3 = f4;
                    }
                }
            }
        }
        return f;
    }
}
