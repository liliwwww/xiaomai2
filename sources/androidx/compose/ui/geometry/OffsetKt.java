package androidx.compose.ui.geometry;

import androidx.compose.runtime.Stable;
import androidx.compose.ui.util.MathHelpersKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class OffsetKt {
    @Stable
    public static final long Offset(float f, float f2) {
        return Offset.constructor-impl((Float.floatToIntBits(f2) & 4294967295L) | (Float.floatToIntBits(f) << 32));
    }

    /* renamed from: isFinite-k-4lQ0M, reason: not valid java name */
    public static final boolean m1025isFinitek4lQ0M(long j) {
        float f = Offset.getX-impl(j);
        if ((Float.isInfinite(f) || Float.isNaN(f)) ? false : true) {
            float f2 = Offset.getY-impl(j);
            if ((Float.isInfinite(f2) || Float.isNaN(f2)) ? false : true) {
                return true;
            }
        }
        return false;
    }

    @Stable
    /* renamed from: isFinite-k-4lQ0M$annotations, reason: not valid java name */
    public static /* synthetic */ void m1026isFinitek4lQ0M$annotations(long j) {
    }

    /* renamed from: isSpecified-k-4lQ0M, reason: not valid java name */
    public static final boolean m1027isSpecifiedk4lQ0M(long j) {
        return j != Offset.Companion.m1023getUnspecifiedF1C5BW0();
    }

    @Stable
    /* renamed from: isSpecified-k-4lQ0M$annotations, reason: not valid java name */
    public static /* synthetic */ void m1028isSpecifiedk4lQ0M$annotations(long j) {
    }

    /* renamed from: isUnspecified-k-4lQ0M, reason: not valid java name */
    public static final boolean m1029isUnspecifiedk4lQ0M(long j) {
        return j == Offset.Companion.m1023getUnspecifiedF1C5BW0();
    }

    @Stable
    /* renamed from: isUnspecified-k-4lQ0M$annotations, reason: not valid java name */
    public static /* synthetic */ void m1030isUnspecifiedk4lQ0M$annotations(long j) {
    }

    @Stable
    /* renamed from: lerp-Wko1d7g, reason: not valid java name */
    public static final long m1031lerpWko1d7g(long j, long j2, float f) {
        return Offset(MathHelpersKt.lerp(Offset.getX-impl(j), Offset.getX-impl(j2), f), MathHelpersKt.lerp(Offset.getY-impl(j), Offset.getY-impl(j2), f));
    }

    /* renamed from: takeOrElse-3MmeM6k, reason: not valid java name */
    public static final long m1032takeOrElse3MmeM6k(long j, @NotNull Function0<Offset> function0) {
        Intrinsics.checkNotNullParameter(function0, "block");
        return m1027isSpecifiedk4lQ0M(j) ? j : ((Offset) function0.invoke()).unbox-impl();
    }
}
