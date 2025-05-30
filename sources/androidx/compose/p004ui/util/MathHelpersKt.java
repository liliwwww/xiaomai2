package androidx.compose.p004ui.util;

import kotlin.math.MathKt;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public final class MathHelpersKt {
    public static final float lerp(float f, float f2, float f3) {
        return ((1 - f3) * f) + (f3 * f2);
    }

    public static final int lerp(int i, int i2, float f) {
        return i + MathKt.roundToInt((i2 - i) * f);
    }

    public static final long lerp(long j, long j2, float f) {
        return j + MathKt.roundToLong((j2 - j) * f);
    }
}
