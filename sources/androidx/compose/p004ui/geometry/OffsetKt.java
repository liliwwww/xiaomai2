package androidx.compose.p004ui.geometry;

import androidx.compose.p004ui.util.MathHelpersKt;
import androidx.compose.runtime.Stable;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public final class OffsetKt {
    @Stable
    public static final long Offset(float f, float f2) {
        return Offset.m2548constructorimpl((Float.floatToIntBits(f2) & 4294967295L) | (Float.floatToIntBits(f) << 32));
    }

    /* renamed from: isFinite-k-4lQ0M, reason: not valid java name */
    public static final boolean m2573isFinitek4lQ0M(long j) {
        float m2556getXimpl = Offset.m2556getXimpl(j);
        if ((Float.isInfinite(m2556getXimpl) || Float.isNaN(m2556getXimpl)) ? false : true) {
            float m2557getYimpl = Offset.m2557getYimpl(j);
            if ((Float.isInfinite(m2557getYimpl) || Float.isNaN(m2557getYimpl)) ? false : true) {
                return true;
            }
        }
        return false;
    }

    @Stable
    /* renamed from: isFinite-k-4lQ0M$annotations, reason: not valid java name */
    public static /* synthetic */ void m2574isFinitek4lQ0M$annotations(long j) {
    }

    /* renamed from: isSpecified-k-4lQ0M, reason: not valid java name */
    public static final boolean m2575isSpecifiedk4lQ0M(long j) {
        return j != Offset.Companion.m2571getUnspecifiedF1C5BW0();
    }

    @Stable
    /* renamed from: isSpecified-k-4lQ0M$annotations, reason: not valid java name */
    public static /* synthetic */ void m2576isSpecifiedk4lQ0M$annotations(long j) {
    }

    /* renamed from: isUnspecified-k-4lQ0M, reason: not valid java name */
    public static final boolean m2577isUnspecifiedk4lQ0M(long j) {
        return j == Offset.Companion.m2571getUnspecifiedF1C5BW0();
    }

    @Stable
    /* renamed from: isUnspecified-k-4lQ0M$annotations, reason: not valid java name */
    public static /* synthetic */ void m2578isUnspecifiedk4lQ0M$annotations(long j) {
    }

    @Stable
    /* renamed from: lerp-Wko1d7g, reason: not valid java name */
    public static final long m2579lerpWko1d7g(long j, long j2, float f) {
        return Offset(MathHelpersKt.lerp(Offset.m2556getXimpl(j), Offset.m2556getXimpl(j2), f), MathHelpersKt.lerp(Offset.m2557getYimpl(j), Offset.m2557getYimpl(j2), f));
    }

    /* renamed from: takeOrElse-3MmeM6k, reason: not valid java name */
    public static final long m2580takeOrElse3MmeM6k(long j, @NotNull Function0<Offset> function0) {
        Intrinsics.checkNotNullParameter(function0, "block");
        return m2575isSpecifiedk4lQ0M(j) ? j : ((Offset) function0.invoke()).m2566unboximpl();
    }
}
