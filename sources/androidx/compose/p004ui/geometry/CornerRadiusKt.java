package androidx.compose.p004ui.geometry;

import androidx.compose.p004ui.util.MathHelpersKt;
import androidx.compose.runtime.Stable;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public final class CornerRadiusKt {
    @Stable
    public static final long CornerRadius(float f, float f2) {
        return CornerRadius.m2525constructorimpl((Float.floatToIntBits(f2) & 4294967295L) | (Float.floatToIntBits(f) << 32));
    }

    public static /* synthetic */ long CornerRadius$default(float f, float f2, int i, Object obj) {
        if ((i & 2) != 0) {
            f2 = f;
        }
        return CornerRadius(f, f2);
    }

    @Stable
    /* renamed from: lerp-3Ry4LBc, reason: not valid java name */
    public static final long m2542lerp3Ry4LBc(long j, long j2, float f) {
        return CornerRadius(MathHelpersKt.lerp(CornerRadius.m2531getXimpl(j), CornerRadius.m2531getXimpl(j2), f), MathHelpersKt.lerp(CornerRadius.m2532getYimpl(j), CornerRadius.m2532getYimpl(j2), f));
    }
}
