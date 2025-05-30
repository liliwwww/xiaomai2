package androidx.compose.ui.graphics.drawscope;

import androidx.compose.runtime.Stable;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.unit.DpRect;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.w51;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class DrawScope$DefaultImpls {
    @Deprecated
    /* renamed from: drawImage-AZ2fEMs, reason: not valid java name */
    public static void m1276drawImageAZ2fEMs(@NotNull DrawScope drawScope, @NotNull ImageBitmap imageBitmap, long j, long j2, long j3, long j4, float f, @NotNull DrawStyle drawStyle, @Nullable ColorFilter colorFilter, int i, int i2) {
        Intrinsics.checkNotNullParameter(imageBitmap, "image");
        Intrinsics.checkNotNullParameter(drawStyle, "style");
        w51.e(drawScope, imageBitmap, j, j2, j3, j4, f, drawStyle, colorFilter, i, i2);
    }

    @Deprecated
    /* renamed from: getCenter-F1C5BW0, reason: not valid java name */
    public static long m1291getCenterF1C5BW0(@NotNull DrawScope drawScope) {
        return w51.f(drawScope);
    }

    @Deprecated
    /* renamed from: getSize-NH-jbRc, reason: not valid java name */
    public static long m1292getSizeNHjbRc(@NotNull DrawScope drawScope) {
        return w51.g(drawScope);
    }

    @Stable
    @Deprecated
    /* renamed from: roundToPx--R2X_6o, reason: not valid java name */
    public static int m1293roundToPxR2X_6o(@NotNull DrawScope drawScope, long j) {
        return w51.h(drawScope, j);
    }

    @Stable
    @Deprecated
    /* renamed from: roundToPx-0680j_4, reason: not valid java name */
    public static int m1294roundToPx0680j_4(@NotNull DrawScope drawScope, float f) {
        return w51.i(drawScope, f);
    }

    @Stable
    @Deprecated
    /* renamed from: toDp-GaN1DYA, reason: not valid java name */
    public static float m1295toDpGaN1DYA(@NotNull DrawScope drawScope, long j) {
        return w51.j(drawScope, j);
    }

    @Stable
    @Deprecated
    /* renamed from: toDp-u2uoSUM, reason: not valid java name */
    public static float m1296toDpu2uoSUM(@NotNull DrawScope drawScope, float f) {
        return w51.k(drawScope, f);
    }

    @Stable
    @Deprecated
    /* renamed from: toDpSize-k-rfVVM, reason: not valid java name */
    public static long m1298toDpSizekrfVVM(@NotNull DrawScope drawScope, long j) {
        return w51.m(drawScope, j);
    }

    @Stable
    @Deprecated
    /* renamed from: toPx--R2X_6o, reason: not valid java name */
    public static float m1299toPxR2X_6o(@NotNull DrawScope drawScope, long j) {
        return w51.n(drawScope, j);
    }

    @Stable
    @Deprecated
    /* renamed from: toPx-0680j_4, reason: not valid java name */
    public static float m1300toPx0680j_4(@NotNull DrawScope drawScope, float f) {
        return w51.o(drawScope, f);
    }

    @Stable
    @Deprecated
    @NotNull
    public static Rect toRect(@NotNull DrawScope drawScope, @NotNull DpRect dpRect) {
        Intrinsics.checkNotNullParameter(dpRect, "$receiver");
        return w51.p(drawScope, dpRect);
    }

    @Stable
    @Deprecated
    /* renamed from: toSize-XkaWNTQ, reason: not valid java name */
    public static long m1301toSizeXkaWNTQ(@NotNull DrawScope drawScope, long j) {
        return w51.q(drawScope, j);
    }

    @Stable
    @Deprecated
    /* renamed from: toSp-0xMU5do, reason: not valid java name */
    public static long m1302toSp0xMU5do(@NotNull DrawScope drawScope, float f) {
        return w51.r(drawScope, f);
    }

    @Stable
    @Deprecated
    /* renamed from: toSp-kPz2Gy4, reason: not valid java name */
    public static long m1303toSpkPz2Gy4(@NotNull DrawScope drawScope, float f) {
        return w51.s(drawScope, f);
    }

    @Stable
    @Deprecated
    /* renamed from: toDp-u2uoSUM, reason: not valid java name */
    public static float m1297toDpu2uoSUM(@NotNull DrawScope drawScope, int i) {
        return w51.l(drawScope, i);
    }

    @Stable
    @Deprecated
    /* renamed from: toSp-kPz2Gy4, reason: not valid java name */
    public static long m1304toSpkPz2Gy4(@NotNull DrawScope drawScope, int i) {
        return w51.t(drawScope, i);
    }
}
