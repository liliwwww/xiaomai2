package androidx.compose.ui.geometry;

import androidx.compose.runtime.Stable;
import androidx.compose.ui.util.MathHelpersKt;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class CornerRadiusKt {
    @Stable
    public static final long CornerRadius(float f, float f2) {
        return CornerRadius.constructor-impl((Float.floatToIntBits(f2) & 4294967295L) | (Float.floatToIntBits(f) << 32));
    }

    public static /* synthetic */ long CornerRadius$default(float f, float f2, int i, Object obj) {
        if ((i & 2) != 0) {
            f2 = f;
        }
        return CornerRadius(f, f2);
    }

    @Stable
    /* renamed from: lerp-3Ry4LBc, reason: not valid java name */
    public static final long m836lerp3Ry4LBc(long j, long j2, float f) {
        return CornerRadius(MathHelpersKt.lerp(CornerRadius.getX-impl(j), CornerRadius.getX-impl(j2), f), MathHelpersKt.lerp(CornerRadius.getY-impl(j), CornerRadius.getY-impl(j2), f));
    }
}
