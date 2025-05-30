package androidx.compose.ui.unit;

import androidx.compose.runtime.Stable;
import androidx.compose.ui.geometry.Rect;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tb.jw0;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class Density$DefaultImpls {
    @Stable
    public static /* synthetic */ void getDensity$annotations() {
    }

    @Stable
    public static /* synthetic */ void getFontScale$annotations() {
    }

    @Stable
    @Deprecated
    /* renamed from: roundToPx--R2X_6o, reason: not valid java name */
    public static int m2557roundToPxR2X_6o(@NotNull Density density, long j) {
        return jw0.n(density, j);
    }

    @Stable
    @Deprecated
    /* renamed from: roundToPx-0680j_4, reason: not valid java name */
    public static int m2558roundToPx0680j_4(@NotNull Density density, float f) {
        return jw0.o(density, f);
    }

    @Stable
    @Deprecated
    /* renamed from: toDp-GaN1DYA, reason: not valid java name */
    public static float m2559toDpGaN1DYA(@NotNull Density density, long j) {
        return jw0.p(density, j);
    }

    @Stable
    @Deprecated
    /* renamed from: toDp-u2uoSUM, reason: not valid java name */
    public static float m2561toDpu2uoSUM(@NotNull Density density, int i) {
        return jw0.r(density, i);
    }

    @Stable
    @Deprecated
    /* renamed from: toDpSize-k-rfVVM, reason: not valid java name */
    public static long m2562toDpSizekrfVVM(@NotNull Density density, long j) {
        return jw0.s(density, j);
    }

    @Stable
    @Deprecated
    /* renamed from: toPx--R2X_6o, reason: not valid java name */
    public static float m2563toPxR2X_6o(@NotNull Density density, long j) {
        return jw0.t(density, j);
    }

    @Stable
    @Deprecated
    /* renamed from: toPx-0680j_4, reason: not valid java name */
    public static float m2564toPx0680j_4(@NotNull Density density, float f) {
        return jw0.u(density, f);
    }

    @Stable
    @Deprecated
    @NotNull
    public static Rect toRect(@NotNull Density density, @NotNull DpRect dpRect) {
        Intrinsics.checkNotNullParameter(dpRect, "$receiver");
        return jw0.v(density, dpRect);
    }

    @Stable
    @Deprecated
    /* renamed from: toSize-XkaWNTQ, reason: not valid java name */
    public static long m2565toSizeXkaWNTQ(@NotNull Density density, long j) {
        return jw0.w(density, j);
    }

    @Stable
    @Deprecated
    /* renamed from: toSp-0xMU5do, reason: not valid java name */
    public static long m2566toSp0xMU5do(@NotNull Density density, float f) {
        return jw0.x(density, f);
    }

    @Stable
    @Deprecated
    /* renamed from: toSp-kPz2Gy4, reason: not valid java name */
    public static long m2568toSpkPz2Gy4(@NotNull Density density, int i) {
        return jw0.z(density, i);
    }

    @Stable
    @Deprecated
    /* renamed from: toDp-u2uoSUM, reason: not valid java name */
    public static float m2560toDpu2uoSUM(@NotNull Density density, float f) {
        return jw0.q(density, f);
    }

    @Stable
    @Deprecated
    /* renamed from: toSp-kPz2Gy4, reason: not valid java name */
    public static long m2567toSpkPz2Gy4(@NotNull Density density, float f) {
        return jw0.y(density, f);
    }
}
