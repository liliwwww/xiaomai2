package androidx.compose.ui.input.pointer;

import androidx.compose.runtime.Stable;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.unit.DpRect;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tb.xv3;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class PointerInputScope$DefaultImpls {
    @Deprecated
    /* renamed from: getExtendedTouchPadding-NH-jbRc, reason: not valid java name */
    public static long m2009getExtendedTouchPaddingNHjbRc(@NotNull PointerInputScope pointerInputScope) {
        return xv3.d(pointerInputScope);
    }

    @Deprecated
    public static boolean getInterceptOutOfBoundsChildEvents(@NotNull PointerInputScope pointerInputScope) {
        return xv3.e(pointerInputScope);
    }

    public static /* synthetic */ void getInterceptOutOfBoundsChildEvents$annotations() {
    }

    @Stable
    @Deprecated
    /* renamed from: roundToPx--R2X_6o, reason: not valid java name */
    public static int m2010roundToPxR2X_6o(@NotNull PointerInputScope pointerInputScope, long j) {
        return xv3.f(pointerInputScope, j);
    }

    @Stable
    @Deprecated
    /* renamed from: roundToPx-0680j_4, reason: not valid java name */
    public static int m2011roundToPx0680j_4(@NotNull PointerInputScope pointerInputScope, float f) {
        return xv3.g(pointerInputScope, f);
    }

    @Deprecated
    public static void setInterceptOutOfBoundsChildEvents(@NotNull PointerInputScope pointerInputScope, boolean z) {
        xv3.h(pointerInputScope, z);
    }

    @Stable
    @Deprecated
    /* renamed from: toDp-GaN1DYA, reason: not valid java name */
    public static float m2012toDpGaN1DYA(@NotNull PointerInputScope pointerInputScope, long j) {
        return xv3.i(pointerInputScope, j);
    }

    @Stable
    @Deprecated
    /* renamed from: toDp-u2uoSUM, reason: not valid java name */
    public static float m2013toDpu2uoSUM(@NotNull PointerInputScope pointerInputScope, float f) {
        return xv3.j(pointerInputScope, f);
    }

    @Stable
    @Deprecated
    /* renamed from: toDpSize-k-rfVVM, reason: not valid java name */
    public static long m2015toDpSizekrfVVM(@NotNull PointerInputScope pointerInputScope, long j) {
        return xv3.l(pointerInputScope, j);
    }

    @Stable
    @Deprecated
    /* renamed from: toPx--R2X_6o, reason: not valid java name */
    public static float m2016toPxR2X_6o(@NotNull PointerInputScope pointerInputScope, long j) {
        return xv3.m(pointerInputScope, j);
    }

    @Stable
    @Deprecated
    /* renamed from: toPx-0680j_4, reason: not valid java name */
    public static float m2017toPx0680j_4(@NotNull PointerInputScope pointerInputScope, float f) {
        return xv3.n(pointerInputScope, f);
    }

    @Stable
    @Deprecated
    @NotNull
    public static Rect toRect(@NotNull PointerInputScope pointerInputScope, @NotNull DpRect dpRect) {
        Intrinsics.checkNotNullParameter(dpRect, "$receiver");
        return xv3.o(pointerInputScope, dpRect);
    }

    @Stable
    @Deprecated
    /* renamed from: toSize-XkaWNTQ, reason: not valid java name */
    public static long m2018toSizeXkaWNTQ(@NotNull PointerInputScope pointerInputScope, long j) {
        return xv3.p(pointerInputScope, j);
    }

    @Stable
    @Deprecated
    /* renamed from: toSp-0xMU5do, reason: not valid java name */
    public static long m2019toSp0xMU5do(@NotNull PointerInputScope pointerInputScope, float f) {
        return xv3.q(pointerInputScope, f);
    }

    @Stable
    @Deprecated
    /* renamed from: toSp-kPz2Gy4, reason: not valid java name */
    public static long m2020toSpkPz2Gy4(@NotNull PointerInputScope pointerInputScope, float f) {
        return xv3.r(pointerInputScope, f);
    }

    @Stable
    @Deprecated
    /* renamed from: toDp-u2uoSUM, reason: not valid java name */
    public static float m2014toDpu2uoSUM(@NotNull PointerInputScope pointerInputScope, int i) {
        return xv3.k(pointerInputScope, i);
    }

    @Stable
    @Deprecated
    /* renamed from: toSp-kPz2Gy4, reason: not valid java name */
    public static long m2021toSpkPz2Gy4(@NotNull PointerInputScope pointerInputScope, int i) {
        return xv3.s(pointerInputScope, i);
    }
}
