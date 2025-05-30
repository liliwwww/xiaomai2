package androidx.compose.p004ui.input.pointer;

import androidx.compose.p004ui.geometry.Rect;
import androidx.compose.p004ui.platform.ViewConfiguration;
import androidx.compose.p004ui.unit.Density;
import androidx.compose.p004ui.unit.DpRect;
import androidx.compose.runtime.Stable;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.xv3;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public interface PointerInputScope extends Density {

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public static final class DefaultImpls {
        @Deprecated
        /* renamed from: getExtendedTouchPadding-NH-jbRc, reason: not valid java name */
        public static long m4105getExtendedTouchPaddingNHjbRc(@NotNull PointerInputScope pointerInputScope) {
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
        public static int m4106roundToPxR2X_6o(@NotNull PointerInputScope pointerInputScope, long j) {
            return xv3.f(pointerInputScope, j);
        }

        @Stable
        @Deprecated
        /* renamed from: roundToPx-0680j_4, reason: not valid java name */
        public static int m4107roundToPx0680j_4(@NotNull PointerInputScope pointerInputScope, float f) {
            return xv3.g(pointerInputScope, f);
        }

        @Deprecated
        public static void setInterceptOutOfBoundsChildEvents(@NotNull PointerInputScope pointerInputScope, boolean z) {
            xv3.h(pointerInputScope, z);
        }

        @Stable
        @Deprecated
        /* renamed from: toDp-GaN1DYA, reason: not valid java name */
        public static float m4108toDpGaN1DYA(@NotNull PointerInputScope pointerInputScope, long j) {
            return xv3.i(pointerInputScope, j);
        }

        @Stable
        @Deprecated
        /* renamed from: toDp-u2uoSUM, reason: not valid java name */
        public static float m4109toDpu2uoSUM(@NotNull PointerInputScope pointerInputScope, float f) {
            return xv3.j(pointerInputScope, f);
        }

        @Stable
        @Deprecated
        /* renamed from: toDpSize-k-rfVVM, reason: not valid java name */
        public static long m4111toDpSizekrfVVM(@NotNull PointerInputScope pointerInputScope, long j) {
            return xv3.l(pointerInputScope, j);
        }

        @Stable
        @Deprecated
        /* renamed from: toPx--R2X_6o, reason: not valid java name */
        public static float m4112toPxR2X_6o(@NotNull PointerInputScope pointerInputScope, long j) {
            return xv3.m(pointerInputScope, j);
        }

        @Stable
        @Deprecated
        /* renamed from: toPx-0680j_4, reason: not valid java name */
        public static float m4113toPx0680j_4(@NotNull PointerInputScope pointerInputScope, float f) {
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
        public static long m4114toSizeXkaWNTQ(@NotNull PointerInputScope pointerInputScope, long j) {
            return xv3.p(pointerInputScope, j);
        }

        @Stable
        @Deprecated
        /* renamed from: toSp-0xMU5do, reason: not valid java name */
        public static long m4115toSp0xMU5do(@NotNull PointerInputScope pointerInputScope, float f) {
            return xv3.q(pointerInputScope, f);
        }

        @Stable
        @Deprecated
        /* renamed from: toSp-kPz2Gy4, reason: not valid java name */
        public static long m4116toSpkPz2Gy4(@NotNull PointerInputScope pointerInputScope, float f) {
            return xv3.r(pointerInputScope, f);
        }

        @Stable
        @Deprecated
        /* renamed from: toDp-u2uoSUM, reason: not valid java name */
        public static float m4110toDpu2uoSUM(@NotNull PointerInputScope pointerInputScope, int i) {
            return xv3.k(pointerInputScope, i);
        }

        @Stable
        @Deprecated
        /* renamed from: toSp-kPz2Gy4, reason: not valid java name */
        public static long m4117toSpkPz2Gy4(@NotNull PointerInputScope pointerInputScope, int i) {
            return xv3.s(pointerInputScope, i);
        }
    }

    @Nullable
    <R> Object awaitPointerEventScope(@NotNull Function2<? super AwaitPointerEventScope, ? super Continuation<? super R>, ? extends Object> function2, @NotNull Continuation<? super R> continuation);

    /* renamed from: getExtendedTouchPadding-NH-jbRc, reason: not valid java name */
    long mo4103getExtendedTouchPaddingNHjbRc();

    boolean getInterceptOutOfBoundsChildEvents();

    /* renamed from: getSize-YbymL2g, reason: not valid java name */
    long m4104getSizeYbymL2g();

    @NotNull
    ViewConfiguration getViewConfiguration();

    void setInterceptOutOfBoundsChildEvents(boolean z);
}
