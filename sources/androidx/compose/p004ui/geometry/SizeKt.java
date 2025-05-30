package androidx.compose.p004ui.geometry;

import androidx.compose.p004ui.util.MathHelpersKt;
import androidx.compose.runtime.Stable;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public final class SizeKt {
    @Stable
    public static final long Size(float f, float f2) {
        return Size.m2616constructorimpl((Float.floatToIntBits(f2) & 4294967295L) | (Float.floatToIntBits(f) << 32));
    }

    /* renamed from: getCenter-uvyYCjk, reason: not valid java name */
    public static final long m2635getCenteruvyYCjk(long j) {
        return OffsetKt.Offset(Size.m2625getWidthimpl(j) / 2.0f, Size.m2622getHeightimpl(j) / 2.0f);
    }

    @Stable
    /* renamed from: getCenter-uvyYCjk$annotations, reason: not valid java name */
    public static /* synthetic */ void m2636getCenteruvyYCjk$annotations(long j) {
    }

    /* renamed from: isSpecified-uvyYCjk, reason: not valid java name */
    public static final boolean m2637isSpecifieduvyYCjk(long j) {
        return j != Size.Companion.m2633getUnspecifiedNHjbRc();
    }

    @Stable
    /* renamed from: isSpecified-uvyYCjk$annotations, reason: not valid java name */
    public static /* synthetic */ void m2638isSpecifieduvyYCjk$annotations(long j) {
    }

    /* renamed from: isUnspecified-uvyYCjk, reason: not valid java name */
    public static final boolean m2639isUnspecifieduvyYCjk(long j) {
        return j == Size.Companion.m2633getUnspecifiedNHjbRc();
    }

    @Stable
    /* renamed from: isUnspecified-uvyYCjk$annotations, reason: not valid java name */
    public static /* synthetic */ void m2640isUnspecifieduvyYCjk$annotations(long j) {
    }

    @Stable
    /* renamed from: lerp-VgWVRYQ, reason: not valid java name */
    public static final long m2641lerpVgWVRYQ(long j, long j2, float f) {
        return Size(MathHelpersKt.lerp(Size.m2625getWidthimpl(j), Size.m2625getWidthimpl(j2), f), MathHelpersKt.lerp(Size.m2622getHeightimpl(j), Size.m2622getHeightimpl(j2), f));
    }

    /* renamed from: takeOrElse-TmRCtEA, reason: not valid java name */
    public static final long m2642takeOrElseTmRCtEA(long j, @NotNull Function0<Size> function0) {
        Intrinsics.checkNotNullParameter(function0, "block");
        return (j > Size.Companion.m2633getUnspecifiedNHjbRc() ? 1 : (j == Size.Companion.m2633getUnspecifiedNHjbRc() ? 0 : -1)) != 0 ? j : ((Size) function0.invoke()).m2630unboximpl();
    }

    @Stable
    /* renamed from: times-d16Qtg0, reason: not valid java name */
    public static final long m2645timesd16Qtg0(int i, long j) {
        return Size.m2628times7Ah8Wj8(j, i);
    }

    @Stable
    @NotNull
    /* renamed from: toRect-uvyYCjk, reason: not valid java name */
    public static final Rect m2646toRectuvyYCjk(long j) {
        return RectKt.m2596Recttz77jQw(Offset.Companion.m2572getZeroF1C5BW0(), j);
    }

    @Stable
    /* renamed from: times-d16Qtg0, reason: not valid java name */
    public static final long m2643timesd16Qtg0(double d, long j) {
        return Size.m2628times7Ah8Wj8(j, (float) d);
    }

    @Stable
    /* renamed from: times-d16Qtg0, reason: not valid java name */
    public static final long m2644timesd16Qtg0(float f, long j) {
        return Size.m2628times7Ah8Wj8(j, f);
    }
}
