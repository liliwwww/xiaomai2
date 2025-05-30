package androidx.compose.ui.unit;

import androidx.compose.runtime.Stable;
import androidx.compose.ui.util.MathHelpersKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class DpKt {
    @Stable
    /* renamed from: DpOffset-YgX7TsA, reason: not valid java name */
    public static final long m2581DpOffsetYgX7TsA(float f, float f2) {
        return DpOffset.m2616constructorimpl((Float.floatToIntBits(f2) & 4294967295L) | (Float.floatToIntBits(f) << 32));
    }

    @Stable
    /* renamed from: DpSize-YgX7TsA, reason: not valid java name */
    public static final long m2582DpSizeYgX7TsA(float f, float f2) {
        return DpSize.constructor-impl((Float.floatToIntBits(f2) & 4294967295L) | (Float.floatToIntBits(f) << 32));
    }

    @Stable
    /* renamed from: coerceAtLeast-YgX7TsA, reason: not valid java name */
    public static final float m2583coerceAtLeastYgX7TsA(float f, float f2) {
        return Dp.constructor-impl(RangesKt.coerceAtLeast(f, f2));
    }

    @Stable
    /* renamed from: coerceAtMost-YgX7TsA, reason: not valid java name */
    public static final float m2584coerceAtMostYgX7TsA(float f, float f2) {
        return Dp.constructor-impl(RangesKt.coerceAtMost(f, f2));
    }

    @Stable
    /* renamed from: coerceIn-2z7ARbQ, reason: not valid java name */
    public static final float m2585coerceIn2z7ARbQ(float f, float f2, float f3) {
        return Dp.constructor-impl(RangesKt.coerceIn(f, f2, f3));
    }

    /* renamed from: getCenter-EaSLcWc, reason: not valid java name */
    public static final long m2586getCenterEaSLcWc(long j) {
        return m2581DpOffsetYgX7TsA(Dp.constructor-impl(DpSize.getWidth-D9Ej5fM(j) / 2.0f), Dp.constructor-impl(DpSize.getHeight-D9Ej5fM(j) / 2.0f));
    }

    @Stable
    /* renamed from: getCenter-EaSLcWc$annotations, reason: not valid java name */
    public static /* synthetic */ void m2587getCenterEaSLcWc$annotations(long j) {
    }

    public static final float getDp(int i) {
        return Dp.constructor-impl(i);
    }

    @Stable
    public static /* synthetic */ void getDp$annotations(double d) {
    }

    @Stable
    public static /* synthetic */ void getDp$annotations(float f) {
    }

    @Stable
    public static /* synthetic */ void getDp$annotations(int i) {
    }

    public static final float getHeight(@NotNull DpRect dpRect) {
        Intrinsics.checkNotNullParameter(dpRect, "<this>");
        return Dp.constructor-impl(dpRect.getBottom-D9Ej5fM() - dpRect.getTop-D9Ej5fM());
    }

    @Stable
    public static /* synthetic */ void getHeight$annotations(DpRect dpRect) {
    }

    public static final long getSize(@NotNull DpRect dpRect) {
        Intrinsics.checkNotNullParameter(dpRect, "<this>");
        return m2582DpSizeYgX7TsA(Dp.constructor-impl(dpRect.getRight-D9Ej5fM() - dpRect.getLeft-D9Ej5fM()), Dp.constructor-impl(dpRect.getBottom-D9Ej5fM() - dpRect.getTop-D9Ej5fM()));
    }

    @Stable
    public static /* synthetic */ void getSize$annotations(DpRect dpRect) {
    }

    public static final float getWidth(@NotNull DpRect dpRect) {
        Intrinsics.checkNotNullParameter(dpRect, "<this>");
        return Dp.constructor-impl(dpRect.getRight-D9Ej5fM() - dpRect.getLeft-D9Ej5fM());
    }

    @Stable
    public static /* synthetic */ void getWidth$annotations(DpRect dpRect) {
    }

    /* renamed from: isFinite-0680j_4, reason: not valid java name */
    public static final boolean m2588isFinite0680j_4(float f) {
        return !(f == Float.POSITIVE_INFINITY);
    }

    @Stable
    /* renamed from: isFinite-0680j_4$annotations, reason: not valid java name */
    public static /* synthetic */ void m2589isFinite0680j_4$annotations(float f) {
    }

    /* renamed from: isSpecified-0680j_4, reason: not valid java name */
    public static final boolean m2590isSpecified0680j_4(float f) {
        return !Float.isNaN(f);
    }

    @Stable
    /* renamed from: isSpecified-0680j_4$annotations, reason: not valid java name */
    public static /* synthetic */ void m2591isSpecified0680j_4$annotations(float f) {
    }

    /* renamed from: isSpecified-EaSLcWc, reason: not valid java name */
    public static final boolean m2592isSpecifiedEaSLcWc(long j) {
        return j != DpSize.Companion.m2632getUnspecifiedMYxV2XQ();
    }

    @Stable
    /* renamed from: isSpecified-EaSLcWc$annotations, reason: not valid java name */
    public static /* synthetic */ void m2593isSpecifiedEaSLcWc$annotations(long j) {
    }

    /* renamed from: isSpecified-jo-Fl9I, reason: not valid java name */
    public static final boolean m2594isSpecifiedjoFl9I(long j) {
        return j != DpOffset.Companion.m2630getUnspecifiedRKDOV3M();
    }

    @Stable
    /* renamed from: isSpecified-jo-Fl9I$annotations, reason: not valid java name */
    public static /* synthetic */ void m2595isSpecifiedjoFl9I$annotations(long j) {
    }

    /* renamed from: isUnspecified-0680j_4, reason: not valid java name */
    public static final boolean m2596isUnspecified0680j_4(float f) {
        return Float.isNaN(f);
    }

    @Stable
    /* renamed from: isUnspecified-0680j_4$annotations, reason: not valid java name */
    public static /* synthetic */ void m2597isUnspecified0680j_4$annotations(float f) {
    }

    /* renamed from: isUnspecified-EaSLcWc, reason: not valid java name */
    public static final boolean m2598isUnspecifiedEaSLcWc(long j) {
        return j == DpSize.Companion.m2632getUnspecifiedMYxV2XQ();
    }

    @Stable
    /* renamed from: isUnspecified-EaSLcWc$annotations, reason: not valid java name */
    public static /* synthetic */ void m2599isUnspecifiedEaSLcWc$annotations(long j) {
    }

    /* renamed from: isUnspecified-jo-Fl9I, reason: not valid java name */
    public static final boolean m2600isUnspecifiedjoFl9I(long j) {
        return j == DpOffset.Companion.m2630getUnspecifiedRKDOV3M();
    }

    @Stable
    /* renamed from: isUnspecified-jo-Fl9I$annotations, reason: not valid java name */
    public static /* synthetic */ void m2601isUnspecifiedjoFl9I$annotations(long j) {
    }

    @Stable
    /* renamed from: lerp-IDex15A, reason: not valid java name */
    public static final long m2602lerpIDex15A(long j, long j2, float f) {
        return m2582DpSizeYgX7TsA(m2603lerpMdfbLM(DpSize.getWidth-D9Ej5fM(j), DpSize.getWidth-D9Ej5fM(j2), f), m2603lerpMdfbLM(DpSize.getHeight-D9Ej5fM(j), DpSize.getHeight-D9Ej5fM(j2), f));
    }

    @Stable
    /* renamed from: lerp-Md-fbLM, reason: not valid java name */
    public static final float m2603lerpMdfbLM(float f, float f2, float f3) {
        return Dp.constructor-impl(MathHelpersKt.lerp(f, f2, f3));
    }

    @Stable
    /* renamed from: lerp-xhh869w, reason: not valid java name */
    public static final long m2604lerpxhh869w(long j, long j2, float f) {
        return m2581DpOffsetYgX7TsA(m2603lerpMdfbLM(DpOffset.m2621getXD9Ej5fM(j), DpOffset.m2621getXD9Ej5fM(j2), f), m2603lerpMdfbLM(DpOffset.m2623getYD9Ej5fM(j), DpOffset.m2623getYD9Ej5fM(j2), f));
    }

    @Stable
    /* renamed from: max-YgX7TsA, reason: not valid java name */
    public static final float m2605maxYgX7TsA(float f, float f2) {
        return Dp.constructor-impl(Math.max(f, f2));
    }

    @Stable
    /* renamed from: min-YgX7TsA, reason: not valid java name */
    public static final float m2606minYgX7TsA(float f, float f2) {
        return Dp.constructor-impl(Math.min(f, f2));
    }

    /* renamed from: takeOrElse-D5KLDUw, reason: not valid java name */
    public static final float m2607takeOrElseD5KLDUw(float f, @NotNull Function0<Dp> function0) {
        Intrinsics.checkNotNullParameter(function0, "block");
        return Float.isNaN(f) ^ true ? f : ((Dp) function0.invoke()).unbox-impl();
    }

    /* renamed from: takeOrElse-gVKV90s, reason: not valid java name */
    public static final long m2608takeOrElsegVKV90s(long j, @NotNull Function0<DpOffset> function0) {
        Intrinsics.checkNotNullParameter(function0, "block");
        return (j > DpOffset.Companion.m2630getUnspecifiedRKDOV3M() ? 1 : (j == DpOffset.Companion.m2630getUnspecifiedRKDOV3M() ? 0 : -1)) != 0 ? j : ((DpOffset) function0.invoke()).m2629unboximpl();
    }

    /* renamed from: takeOrElse-itqla9I, reason: not valid java name */
    public static final long m2609takeOrElseitqla9I(long j, @NotNull Function0<DpSize> function0) {
        Intrinsics.checkNotNullParameter(function0, "block");
        return (j > DpSize.Companion.m2632getUnspecifiedMYxV2XQ() ? 1 : (j == DpSize.Companion.m2632getUnspecifiedMYxV2XQ() ? 0 : -1)) != 0 ? j : ((DpSize) function0.invoke()).unbox-impl();
    }

    @Stable
    /* renamed from: times-3ABfNKs, reason: not valid java name */
    public static final float m2611times3ABfNKs(float f, float f2) {
        return Dp.constructor-impl(f * f2);
    }

    @Stable
    /* renamed from: times-6HolHcs, reason: not valid java name */
    public static final long m2614times6HolHcs(int i, long j) {
        return DpSize.times-Gh9hcWk(j, i);
    }

    public static final float getDp(double d) {
        return Dp.constructor-impl((float) d);
    }

    @Stable
    /* renamed from: times-3ABfNKs, reason: not valid java name */
    public static final float m2610times3ABfNKs(double d, float f) {
        return Dp.constructor-impl(((float) d) * f);
    }

    @Stable
    /* renamed from: times-6HolHcs, reason: not valid java name */
    public static final long m2613times6HolHcs(float f, long j) {
        return DpSize.times-Gh9hcWk(j, f);
    }

    public static final float getDp(float f) {
        return Dp.constructor-impl(f);
    }

    @Stable
    /* renamed from: times-3ABfNKs, reason: not valid java name */
    public static final float m2612times3ABfNKs(int i, float f) {
        return Dp.constructor-impl(i * f);
    }
}
