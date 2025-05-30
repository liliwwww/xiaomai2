package androidx.compose.ui.geometry;

import androidx.compose.runtime.Stable;
import androidx.compose.ui.util.MathHelpersKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class SizeKt {
    @Stable
    public static final long Size(float f, float f2) {
        return Size.m894constructorimpl((Float.floatToIntBits(f2) & 4294967295L) | (Float.floatToIntBits(f) << 32));
    }

    /* renamed from: getCenter-uvyYCjk, reason: not valid java name */
    public static final long m913getCenteruvyYCjk(long j) {
        return OffsetKt.Offset(Size.m903getWidthimpl(j) / 2.0f, Size.m900getHeightimpl(j) / 2.0f);
    }

    @Stable
    /* renamed from: getCenter-uvyYCjk$annotations, reason: not valid java name */
    public static /* synthetic */ void m914getCenteruvyYCjk$annotations(long j) {
    }

    /* renamed from: isSpecified-uvyYCjk, reason: not valid java name */
    public static final boolean m915isSpecifieduvyYCjk(long j) {
        return j != Size.Companion.m911getUnspecifiedNHjbRc();
    }

    @Stable
    /* renamed from: isSpecified-uvyYCjk$annotations, reason: not valid java name */
    public static /* synthetic */ void m916isSpecifieduvyYCjk$annotations(long j) {
    }

    /* renamed from: isUnspecified-uvyYCjk, reason: not valid java name */
    public static final boolean m917isUnspecifieduvyYCjk(long j) {
        return j == Size.Companion.m911getUnspecifiedNHjbRc();
    }

    @Stable
    /* renamed from: isUnspecified-uvyYCjk$annotations, reason: not valid java name */
    public static /* synthetic */ void m918isUnspecifieduvyYCjk$annotations(long j) {
    }

    @Stable
    /* renamed from: lerp-VgWVRYQ, reason: not valid java name */
    public static final long m919lerpVgWVRYQ(long j, long j2, float f) {
        return Size(MathHelpersKt.lerp(Size.m903getWidthimpl(j), Size.m903getWidthimpl(j2), f), MathHelpersKt.lerp(Size.m900getHeightimpl(j), Size.m900getHeightimpl(j2), f));
    }

    /* renamed from: takeOrElse-TmRCtEA, reason: not valid java name */
    public static final long m920takeOrElseTmRCtEA(long j, @NotNull Function0<Size> function0) {
        Intrinsics.checkNotNullParameter(function0, "block");
        return (j > Size.Companion.m911getUnspecifiedNHjbRc() ? 1 : (j == Size.Companion.m911getUnspecifiedNHjbRc() ? 0 : -1)) != 0 ? j : ((Size) function0.invoke()).m908unboximpl();
    }

    @Stable
    /* renamed from: times-d16Qtg0, reason: not valid java name */
    public static final long m923timesd16Qtg0(int i, long j) {
        return Size.m906times7Ah8Wj8(j, i);
    }

    @Stable
    @NotNull
    /* renamed from: toRect-uvyYCjk, reason: not valid java name */
    public static final Rect m924toRectuvyYCjk(long j) {
        return RectKt.m874Recttz77jQw(Offset.Companion.getZero-F1C5BW0(), j);
    }

    @Stable
    /* renamed from: times-d16Qtg0, reason: not valid java name */
    public static final long m921timesd16Qtg0(double d, long j) {
        return Size.m906times7Ah8Wj8(j, (float) d);
    }

    @Stable
    /* renamed from: times-d16Qtg0, reason: not valid java name */
    public static final long m922timesd16Qtg0(float f, long j) {
        return Size.m906times7Ah8Wj8(j, f);
    }
}
