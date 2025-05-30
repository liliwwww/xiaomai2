package androidx.compose.ui.layout;

import androidx.compose.runtime.Stable;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.util.MathHelpersKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class ScaleFactorKt {
    @Stable
    public static final long ScaleFactor(float f, float f2) {
        return ScaleFactor.constructor-impl((Float.floatToIntBits(f2) & 4294967295L) | (Float.floatToIntBits(f) << 32));
    }

    @Stable
    /* renamed from: div-UQTWf7w, reason: not valid java name */
    public static final long m2081divUQTWf7w(long j, long j2) {
        return SizeKt.Size(Size.getWidth-impl(j) / ScaleFactor.getScaleX-impl(j2), Size.getHeight-impl(j) / ScaleFactor.getScaleY-impl(j2));
    }

    /* renamed from: isSpecified-FK8aYYs, reason: not valid java name */
    public static final boolean m2082isSpecifiedFK8aYYs(long j) {
        return j != ScaleFactor.Companion.m2080getUnspecified_hLwfpc();
    }

    @Stable
    /* renamed from: isSpecified-FK8aYYs$annotations, reason: not valid java name */
    public static /* synthetic */ void m2083isSpecifiedFK8aYYs$annotations(long j) {
    }

    /* renamed from: isUnspecified-FK8aYYs, reason: not valid java name */
    public static final boolean m2084isUnspecifiedFK8aYYs(long j) {
        return j == ScaleFactor.Companion.m2080getUnspecified_hLwfpc();
    }

    @Stable
    /* renamed from: isUnspecified-FK8aYYs$annotations, reason: not valid java name */
    public static /* synthetic */ void m2085isUnspecifiedFK8aYYs$annotations(long j) {
    }

    @Stable
    /* renamed from: lerp--bDIf60, reason: not valid java name */
    public static final long m2086lerpbDIf60(long j, long j2, float f) {
        return ScaleFactor(MathHelpersKt.lerp(ScaleFactor.getScaleX-impl(j), ScaleFactor.getScaleX-impl(j2), f), MathHelpersKt.lerp(ScaleFactor.getScaleY-impl(j), ScaleFactor.getScaleY-impl(j2), f));
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
    public static final long m2087takeOrElseoyDd2qo(long j, @NotNull Function0<ScaleFactor> function0) {
        Intrinsics.checkNotNullParameter(function0, "block");
        return (j > ScaleFactor.Companion.m2080getUnspecified_hLwfpc() ? 1 : (j == ScaleFactor.Companion.m2080getUnspecified_hLwfpc() ? 0 : -1)) != 0 ? j : ((ScaleFactor) function0.invoke()).unbox-impl();
    }

    @Stable
    /* renamed from: times-UQTWf7w, reason: not valid java name */
    public static final long m2088timesUQTWf7w(long j, long j2) {
        return SizeKt.Size(Size.getWidth-impl(j) * ScaleFactor.getScaleX-impl(j2), Size.getHeight-impl(j) * ScaleFactor.getScaleY-impl(j2));
    }

    @Stable
    /* renamed from: times-m-w2e94, reason: not valid java name */
    public static final long m2089timesmw2e94(long j, long j2) {
        return m2088timesUQTWf7w(j2, j);
    }
}
