package androidx.compose.ui.graphics;

import androidx.compose.runtime.Stable;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.unit.DpRect;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.cx1;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class GraphicsLayerScope$DefaultImpls {
    @Deprecated
    /* renamed from: getAmbientShadowColor-0d7_KjU, reason: not valid java name */
    public static long m1130getAmbientShadowColor0d7_KjU(@NotNull GraphicsLayerScope graphicsLayerScope) {
        return cx1.j(graphicsLayerScope);
    }

    public static /* synthetic */ void getClip$annotations() {
    }

    @Deprecated
    /* renamed from: getCompositingStrategy--NrFUSI, reason: not valid java name */
    public static int m1131getCompositingStrategyNrFUSI(@NotNull GraphicsLayerScope graphicsLayerScope) {
        return cx1.k(graphicsLayerScope);
    }

    @Deprecated
    @Nullable
    public static RenderEffect getRenderEffect(@NotNull GraphicsLayerScope graphicsLayerScope) {
        return cx1.l(graphicsLayerScope);
    }

    @Deprecated
    /* renamed from: getSize-NH-jbRc, reason: not valid java name */
    public static long m1132getSizeNHjbRc(@NotNull GraphicsLayerScope graphicsLayerScope) {
        return cx1.m(graphicsLayerScope);
    }

    @Deprecated
    /* renamed from: getSpotShadowColor-0d7_KjU, reason: not valid java name */
    public static long m1133getSpotShadowColor0d7_KjU(@NotNull GraphicsLayerScope graphicsLayerScope) {
        return cx1.n(graphicsLayerScope);
    }

    @Stable
    @Deprecated
    /* renamed from: roundToPx--R2X_6o, reason: not valid java name */
    public static int m1134roundToPxR2X_6o(@NotNull GraphicsLayerScope graphicsLayerScope, long j) {
        return cx1.o(graphicsLayerScope, j);
    }

    @Stable
    @Deprecated
    /* renamed from: roundToPx-0680j_4, reason: not valid java name */
    public static int m1135roundToPx0680j_4(@NotNull GraphicsLayerScope graphicsLayerScope, float f) {
        return cx1.p(graphicsLayerScope, f);
    }

    @Deprecated
    /* renamed from: setAmbientShadowColor-8_81llA, reason: not valid java name */
    public static void m1136setAmbientShadowColor8_81llA(@NotNull GraphicsLayerScope graphicsLayerScope, long j) {
        cx1.q(graphicsLayerScope, j);
    }

    @Deprecated
    /* renamed from: setCompositingStrategy-aDBOjCE, reason: not valid java name */
    public static void m1137setCompositingStrategyaDBOjCE(@NotNull GraphicsLayerScope graphicsLayerScope, int i) {
        cx1.r(graphicsLayerScope, i);
    }

    @Deprecated
    public static void setRenderEffect(@NotNull GraphicsLayerScope graphicsLayerScope, @Nullable RenderEffect renderEffect) {
        cx1.s(graphicsLayerScope, renderEffect);
    }

    @Deprecated
    /* renamed from: setSpotShadowColor-8_81llA, reason: not valid java name */
    public static void m1138setSpotShadowColor8_81llA(@NotNull GraphicsLayerScope graphicsLayerScope, long j) {
        cx1.t(graphicsLayerScope, j);
    }

    @Stable
    @Deprecated
    /* renamed from: toDp-GaN1DYA, reason: not valid java name */
    public static float m1139toDpGaN1DYA(@NotNull GraphicsLayerScope graphicsLayerScope, long j) {
        return cx1.u(graphicsLayerScope, j);
    }

    @Stable
    @Deprecated
    /* renamed from: toDp-u2uoSUM, reason: not valid java name */
    public static float m1140toDpu2uoSUM(@NotNull GraphicsLayerScope graphicsLayerScope, float f) {
        return cx1.v(graphicsLayerScope, f);
    }

    @Stable
    @Deprecated
    /* renamed from: toDpSize-k-rfVVM, reason: not valid java name */
    public static long m1142toDpSizekrfVVM(@NotNull GraphicsLayerScope graphicsLayerScope, long j) {
        return cx1.x(graphicsLayerScope, j);
    }

    @Stable
    @Deprecated
    /* renamed from: toPx--R2X_6o, reason: not valid java name */
    public static float m1143toPxR2X_6o(@NotNull GraphicsLayerScope graphicsLayerScope, long j) {
        return cx1.y(graphicsLayerScope, j);
    }

    @Stable
    @Deprecated
    /* renamed from: toPx-0680j_4, reason: not valid java name */
    public static float m1144toPx0680j_4(@NotNull GraphicsLayerScope graphicsLayerScope, float f) {
        return cx1.z(graphicsLayerScope, f);
    }

    @Stable
    @Deprecated
    @NotNull
    public static Rect toRect(@NotNull GraphicsLayerScope graphicsLayerScope, @NotNull DpRect dpRect) {
        Intrinsics.checkNotNullParameter(dpRect, "$receiver");
        return cx1.A(graphicsLayerScope, dpRect);
    }

    @Stable
    @Deprecated
    /* renamed from: toSize-XkaWNTQ, reason: not valid java name */
    public static long m1145toSizeXkaWNTQ(@NotNull GraphicsLayerScope graphicsLayerScope, long j) {
        return cx1.B(graphicsLayerScope, j);
    }

    @Stable
    @Deprecated
    /* renamed from: toSp-0xMU5do, reason: not valid java name */
    public static long m1146toSp0xMU5do(@NotNull GraphicsLayerScope graphicsLayerScope, float f) {
        return cx1.C(graphicsLayerScope, f);
    }

    @Stable
    @Deprecated
    /* renamed from: toSp-kPz2Gy4, reason: not valid java name */
    public static long m1147toSpkPz2Gy4(@NotNull GraphicsLayerScope graphicsLayerScope, float f) {
        return cx1.D(graphicsLayerScope, f);
    }

    @Stable
    @Deprecated
    /* renamed from: toDp-u2uoSUM, reason: not valid java name */
    public static float m1141toDpu2uoSUM(@NotNull GraphicsLayerScope graphicsLayerScope, int i) {
        return cx1.w(graphicsLayerScope, i);
    }

    @Stable
    @Deprecated
    /* renamed from: toSp-kPz2Gy4, reason: not valid java name */
    public static long m1148toSpkPz2Gy4(@NotNull GraphicsLayerScope graphicsLayerScope, int i) {
        return cx1.E(graphicsLayerScope, i);
    }
}
