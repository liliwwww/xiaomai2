package androidx.compose.p004ui.unit;

import androidx.compose.p004ui.util.MathHelpersKt;
import androidx.compose.runtime.Stable;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public final class DpKt {
    @Stable
    /* renamed from: DpOffset-YgX7TsA, reason: not valid java name */
    public static final long m5237DpOffsetYgX7TsA(float f, float f2) {
        return DpOffset.m5272constructorimpl((Float.floatToIntBits(f2) & 4294967295L) | (Float.floatToIntBits(f) << 32));
    }

    @Stable
    /* renamed from: DpSize-YgX7TsA, reason: not valid java name */
    public static final long m5238DpSizeYgX7TsA(float f, float f2) {
        return DpSize.m5305constructorimpl((Float.floatToIntBits(f2) & 4294967295L) | (Float.floatToIntBits(f) << 32));
    }

    @Stable
    /* renamed from: coerceAtLeast-YgX7TsA, reason: not valid java name */
    public static final float m5239coerceAtLeastYgX7TsA(float f, float f2) {
        return C0856Dp.m5216constructorimpl(RangesKt.coerceAtLeast(f, f2));
    }

    @Stable
    /* renamed from: coerceAtMost-YgX7TsA, reason: not valid java name */
    public static final float m5240coerceAtMostYgX7TsA(float f, float f2) {
        return C0856Dp.m5216constructorimpl(RangesKt.coerceAtMost(f, f2));
    }

    @Stable
    /* renamed from: coerceIn-2z7ARbQ, reason: not valid java name */
    public static final float m5241coerceIn2z7ARbQ(float f, float f2, float f3) {
        return C0856Dp.m5216constructorimpl(RangesKt.coerceIn(f, f2, f3));
    }

    /* renamed from: getCenter-EaSLcWc, reason: not valid java name */
    public static final long m5242getCenterEaSLcWc(long j) {
        return m5237DpOffsetYgX7TsA(C0856Dp.m5216constructorimpl(DpSize.m5314getWidthD9Ej5fM(j) / 2.0f), C0856Dp.m5216constructorimpl(DpSize.m5312getHeightD9Ej5fM(j) / 2.0f));
    }

    @Stable
    /* renamed from: getCenter-EaSLcWc$annotations, reason: not valid java name */
    public static /* synthetic */ void m5243getCenterEaSLcWc$annotations(long j) {
    }

    public static final float getDp(int i) {
        return C0856Dp.m5216constructorimpl(i);
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
        return C0856Dp.m5216constructorimpl(dpRect.m5298getBottomD9Ej5fM() - dpRect.m5301getTopD9Ej5fM());
    }

    @Stable
    public static /* synthetic */ void getHeight$annotations(DpRect dpRect) {
    }

    public static final long getSize(@NotNull DpRect dpRect) {
        Intrinsics.checkNotNullParameter(dpRect, "<this>");
        return m5238DpSizeYgX7TsA(C0856Dp.m5216constructorimpl(dpRect.m5300getRightD9Ej5fM() - dpRect.m5299getLeftD9Ej5fM()), C0856Dp.m5216constructorimpl(dpRect.m5298getBottomD9Ej5fM() - dpRect.m5301getTopD9Ej5fM()));
    }

    @Stable
    public static /* synthetic */ void getSize$annotations(DpRect dpRect) {
    }

    public static final float getWidth(@NotNull DpRect dpRect) {
        Intrinsics.checkNotNullParameter(dpRect, "<this>");
        return C0856Dp.m5216constructorimpl(dpRect.m5300getRightD9Ej5fM() - dpRect.m5299getLeftD9Ej5fM());
    }

    @Stable
    public static /* synthetic */ void getWidth$annotations(DpRect dpRect) {
    }

    /* renamed from: isFinite-0680j_4, reason: not valid java name */
    public static final boolean m5244isFinite0680j_4(float f) {
        return !(f == Float.POSITIVE_INFINITY);
    }

    @Stable
    /* renamed from: isFinite-0680j_4$annotations, reason: not valid java name */
    public static /* synthetic */ void m5245isFinite0680j_4$annotations(float f) {
    }

    /* renamed from: isSpecified-0680j_4, reason: not valid java name */
    public static final boolean m5246isSpecified0680j_4(float f) {
        return !Float.isNaN(f);
    }

    @Stable
    /* renamed from: isSpecified-0680j_4$annotations, reason: not valid java name */
    public static /* synthetic */ void m5247isSpecified0680j_4$annotations(float f) {
    }

    /* renamed from: isSpecified-EaSLcWc, reason: not valid java name */
    public static final boolean m5248isSpecifiedEaSLcWc(long j) {
        return j != DpSize.Companion.m5323getUnspecifiedMYxV2XQ();
    }

    @Stable
    /* renamed from: isSpecified-EaSLcWc$annotations, reason: not valid java name */
    public static /* synthetic */ void m5249isSpecifiedEaSLcWc$annotations(long j) {
    }

    /* renamed from: isSpecified-jo-Fl9I, reason: not valid java name */
    public static final boolean m5250isSpecifiedjoFl9I(long j) {
        return j != DpOffset.Companion.m5286getUnspecifiedRKDOV3M();
    }

    @Stable
    /* renamed from: isSpecified-jo-Fl9I$annotations, reason: not valid java name */
    public static /* synthetic */ void m5251isSpecifiedjoFl9I$annotations(long j) {
    }

    /* renamed from: isUnspecified-0680j_4, reason: not valid java name */
    public static final boolean m5252isUnspecified0680j_4(float f) {
        return Float.isNaN(f);
    }

    @Stable
    /* renamed from: isUnspecified-0680j_4$annotations, reason: not valid java name */
    public static /* synthetic */ void m5253isUnspecified0680j_4$annotations(float f) {
    }

    /* renamed from: isUnspecified-EaSLcWc, reason: not valid java name */
    public static final boolean m5254isUnspecifiedEaSLcWc(long j) {
        return j == DpSize.Companion.m5323getUnspecifiedMYxV2XQ();
    }

    @Stable
    /* renamed from: isUnspecified-EaSLcWc$annotations, reason: not valid java name */
    public static /* synthetic */ void m5255isUnspecifiedEaSLcWc$annotations(long j) {
    }

    /* renamed from: isUnspecified-jo-Fl9I, reason: not valid java name */
    public static final boolean m5256isUnspecifiedjoFl9I(long j) {
        return j == DpOffset.Companion.m5286getUnspecifiedRKDOV3M();
    }

    @Stable
    /* renamed from: isUnspecified-jo-Fl9I$annotations, reason: not valid java name */
    public static /* synthetic */ void m5257isUnspecifiedjoFl9I$annotations(long j) {
    }

    @Stable
    /* renamed from: lerp-IDex15A, reason: not valid java name */
    public static final long m5258lerpIDex15A(long j, long j2, float f) {
        return m5238DpSizeYgX7TsA(m5259lerpMdfbLM(DpSize.m5314getWidthD9Ej5fM(j), DpSize.m5314getWidthD9Ej5fM(j2), f), m5259lerpMdfbLM(DpSize.m5312getHeightD9Ej5fM(j), DpSize.m5312getHeightD9Ej5fM(j2), f));
    }

    @Stable
    /* renamed from: lerp-Md-fbLM, reason: not valid java name */
    public static final float m5259lerpMdfbLM(float f, float f2, float f3) {
        return C0856Dp.m5216constructorimpl(MathHelpersKt.lerp(f, f2, f3));
    }

    @Stable
    /* renamed from: lerp-xhh869w, reason: not valid java name */
    public static final long m5260lerpxhh869w(long j, long j2, float f) {
        return m5237DpOffsetYgX7TsA(m5259lerpMdfbLM(DpOffset.m5277getXD9Ej5fM(j), DpOffset.m5277getXD9Ej5fM(j2), f), m5259lerpMdfbLM(DpOffset.m5279getYD9Ej5fM(j), DpOffset.m5279getYD9Ej5fM(j2), f));
    }

    @Stable
    /* renamed from: max-YgX7TsA, reason: not valid java name */
    public static final float m5261maxYgX7TsA(float f, float f2) {
        return C0856Dp.m5216constructorimpl(Math.max(f, f2));
    }

    @Stable
    /* renamed from: min-YgX7TsA, reason: not valid java name */
    public static final float m5262minYgX7TsA(float f, float f2) {
        return C0856Dp.m5216constructorimpl(Math.min(f, f2));
    }

    /* renamed from: takeOrElse-D5KLDUw, reason: not valid java name */
    public static final float m5263takeOrElseD5KLDUw(float f, @NotNull Function0<C0856Dp> function0) {
        Intrinsics.checkNotNullParameter(function0, "block");
        return Float.isNaN(f) ^ true ? f : ((C0856Dp) function0.invoke()).m5230unboximpl();
    }

    /* renamed from: takeOrElse-gVKV90s, reason: not valid java name */
    public static final long m5264takeOrElsegVKV90s(long j, @NotNull Function0<DpOffset> function0) {
        Intrinsics.checkNotNullParameter(function0, "block");
        return (j > DpOffset.Companion.m5286getUnspecifiedRKDOV3M() ? 1 : (j == DpOffset.Companion.m5286getUnspecifiedRKDOV3M() ? 0 : -1)) != 0 ? j : ((DpOffset) function0.invoke()).m5285unboximpl();
    }

    /* renamed from: takeOrElse-itqla9I, reason: not valid java name */
    public static final long m5265takeOrElseitqla9I(long j, @NotNull Function0<DpSize> function0) {
        Intrinsics.checkNotNullParameter(function0, "block");
        return (j > DpSize.Companion.m5323getUnspecifiedMYxV2XQ() ? 1 : (j == DpSize.Companion.m5323getUnspecifiedMYxV2XQ() ? 0 : -1)) != 0 ? j : ((DpSize) function0.invoke()).m5322unboximpl();
    }

    @Stable
    /* renamed from: times-3ABfNKs, reason: not valid java name */
    public static final float m5267times3ABfNKs(float f, float f2) {
        return C0856Dp.m5216constructorimpl(f * f2);
    }

    @Stable
    /* renamed from: times-6HolHcs, reason: not valid java name */
    public static final long m5270times6HolHcs(int i, long j) {
        return DpSize.m5320timesGh9hcWk(j, i);
    }

    public static final float getDp(double d) {
        return C0856Dp.m5216constructorimpl((float) d);
    }

    @Stable
    /* renamed from: times-3ABfNKs, reason: not valid java name */
    public static final float m5266times3ABfNKs(double d, float f) {
        return C0856Dp.m5216constructorimpl(((float) d) * f);
    }

    @Stable
    /* renamed from: times-6HolHcs, reason: not valid java name */
    public static final long m5269times6HolHcs(float f, long j) {
        return DpSize.m5319timesGh9hcWk(j, f);
    }

    public static final float getDp(float f) {
        return C0856Dp.m5216constructorimpl(f);
    }

    @Stable
    /* renamed from: times-3ABfNKs, reason: not valid java name */
    public static final float m5268times3ABfNKs(int i, float f) {
        return C0856Dp.m5216constructorimpl(i * f);
    }
}
