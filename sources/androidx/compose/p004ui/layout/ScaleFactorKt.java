package androidx.compose.p004ui.layout;

import androidx.compose.p004ui.geometry.Size;
import androidx.compose.p004ui.geometry.SizeKt;
import androidx.compose.p004ui.util.MathHelpersKt;
import androidx.compose.runtime.Stable;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public final class ScaleFactorKt {
    @Stable
    public static final long ScaleFactor(float f, float f2) {
        return ScaleFactor.m4236constructorimpl((Float.floatToIntBits(f2) & 4294967295L) | (Float.floatToIntBits(f) << 32));
    }

    @Stable
    /* renamed from: div-UQTWf7w, reason: not valid java name */
    public static final long m4250divUQTWf7w(long j, long j2) {
        return SizeKt.Size(Size.m2625getWidthimpl(j) / ScaleFactor.m4242getScaleXimpl(j2), Size.m2622getHeightimpl(j) / ScaleFactor.m4243getScaleYimpl(j2));
    }

    /* renamed from: isSpecified-FK8aYYs, reason: not valid java name */
    public static final boolean m4251isSpecifiedFK8aYYs(long j) {
        return j != ScaleFactor.Companion.m4249getUnspecified_hLwfpc();
    }

    @Stable
    /* renamed from: isSpecified-FK8aYYs$annotations, reason: not valid java name */
    public static /* synthetic */ void m4252isSpecifiedFK8aYYs$annotations(long j) {
    }

    /* renamed from: isUnspecified-FK8aYYs, reason: not valid java name */
    public static final boolean m4253isUnspecifiedFK8aYYs(long j) {
        return j == ScaleFactor.Companion.m4249getUnspecified_hLwfpc();
    }

    @Stable
    /* renamed from: isUnspecified-FK8aYYs$annotations, reason: not valid java name */
    public static /* synthetic */ void m4254isUnspecifiedFK8aYYs$annotations(long j) {
    }

    @Stable
    /* renamed from: lerp--bDIf60, reason: not valid java name */
    public static final long m4255lerpbDIf60(long j, long j2, float f) {
        return ScaleFactor(MathHelpersKt.lerp(ScaleFactor.m4242getScaleXimpl(j), ScaleFactor.m4242getScaleXimpl(j2), f), MathHelpersKt.lerp(ScaleFactor.m4243getScaleYimpl(j), ScaleFactor.m4243getScaleYimpl(j2), f));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float roundToTenths(float f) {
        float f2 = 10;
        float f3 = f * f2;
        int i = (int) f3;
        if (f3 - i >= 0.5f) {
            i++;
        }
        return i / f2;
    }

    /* renamed from: takeOrElse-oyDd2qo, reason: not valid java name */
    public static final long m4256takeOrElseoyDd2qo(long j, @NotNull Function0<ScaleFactor> function0) {
        Intrinsics.checkNotNullParameter(function0, "block");
        return (j > ScaleFactor.Companion.m4249getUnspecified_hLwfpc() ? 1 : (j == ScaleFactor.Companion.m4249getUnspecified_hLwfpc() ? 0 : -1)) != 0 ? j : ((ScaleFactor) function0.invoke()).m4247unboximpl();
    }

    @Stable
    /* renamed from: times-UQTWf7w, reason: not valid java name */
    public static final long m4257timesUQTWf7w(long j, long j2) {
        return SizeKt.Size(Size.m2625getWidthimpl(j) * ScaleFactor.m4242getScaleXimpl(j2), Size.m2622getHeightimpl(j) * ScaleFactor.m4243getScaleYimpl(j2));
    }

    @Stable
    /* renamed from: times-m-w2e94, reason: not valid java name */
    public static final long m4258timesmw2e94(long j, long j2) {
        return m4257timesUQTWf7w(j2, j);
    }
}
