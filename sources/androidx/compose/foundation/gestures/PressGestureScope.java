package androidx.compose.foundation.gestures;

import androidx.compose.runtime.Stable;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DpRect;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.gy3;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public interface PressGestureScope extends Density {

    /* compiled from: Taobao */
    public static final class DefaultImpls {
        @Stable
        @Deprecated
        /* renamed from: roundToPx--R2X_6o, reason: not valid java name */
        public static int m216roundToPxR2X_6o(@NotNull PressGestureScope pressGestureScope, long j) {
            return gy3.a(pressGestureScope, j);
        }

        @Stable
        @Deprecated
        /* renamed from: roundToPx-0680j_4, reason: not valid java name */
        public static int m217roundToPx0680j_4(@NotNull PressGestureScope pressGestureScope, float f) {
            return gy3.b(pressGestureScope, f);
        }

        @Stable
        @Deprecated
        /* renamed from: toDp-GaN1DYA, reason: not valid java name */
        public static float m218toDpGaN1DYA(@NotNull PressGestureScope pressGestureScope, long j) {
            return gy3.c(pressGestureScope, j);
        }

        @Stable
        @Deprecated
        /* renamed from: toDp-u2uoSUM, reason: not valid java name */
        public static float m219toDpu2uoSUM(@NotNull PressGestureScope pressGestureScope, float f) {
            return gy3.d(pressGestureScope, f);
        }

        @Stable
        @Deprecated
        /* renamed from: toDpSize-k-rfVVM, reason: not valid java name */
        public static long m221toDpSizekrfVVM(@NotNull PressGestureScope pressGestureScope, long j) {
            return gy3.f(pressGestureScope, j);
        }

        @Stable
        @Deprecated
        /* renamed from: toPx--R2X_6o, reason: not valid java name */
        public static float m222toPxR2X_6o(@NotNull PressGestureScope pressGestureScope, long j) {
            return gy3.g(pressGestureScope, j);
        }

        @Stable
        @Deprecated
        /* renamed from: toPx-0680j_4, reason: not valid java name */
        public static float m223toPx0680j_4(@NotNull PressGestureScope pressGestureScope, float f) {
            return gy3.h(pressGestureScope, f);
        }

        @Stable
        @Deprecated
        @NotNull
        public static Rect toRect(@NotNull PressGestureScope pressGestureScope, @NotNull DpRect dpRect) {
            Intrinsics.checkNotNullParameter(dpRect, "$receiver");
            return gy3.i(pressGestureScope, dpRect);
        }

        @Stable
        @Deprecated
        /* renamed from: toSize-XkaWNTQ, reason: not valid java name */
        public static long m224toSizeXkaWNTQ(@NotNull PressGestureScope pressGestureScope, long j) {
            return gy3.j(pressGestureScope, j);
        }

        @Stable
        @Deprecated
        /* renamed from: toSp-0xMU5do, reason: not valid java name */
        public static long m225toSp0xMU5do(@NotNull PressGestureScope pressGestureScope, float f) {
            return gy3.k(pressGestureScope, f);
        }

        @Stable
        @Deprecated
        /* renamed from: toSp-kPz2Gy4, reason: not valid java name */
        public static long m226toSpkPz2Gy4(@NotNull PressGestureScope pressGestureScope, float f) {
            return gy3.l(pressGestureScope, f);
        }

        @Stable
        @Deprecated
        /* renamed from: toDp-u2uoSUM, reason: not valid java name */
        public static float m220toDpu2uoSUM(@NotNull PressGestureScope pressGestureScope, int i) {
            return gy3.e(pressGestureScope, i);
        }

        @Stable
        @Deprecated
        /* renamed from: toSp-kPz2Gy4, reason: not valid java name */
        public static long m227toSpkPz2Gy4(@NotNull PressGestureScope pressGestureScope, int i) {
            return gy3.m(pressGestureScope, i);
        }
    }

    @Nullable
    Object awaitRelease(@NotNull Continuation<? super Unit> continuation);

    @Nullable
    Object tryAwaitRelease(@NotNull Continuation<? super Boolean> continuation);
}
