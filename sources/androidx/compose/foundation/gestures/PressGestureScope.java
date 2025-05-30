package androidx.compose.foundation.gestures;

import androidx.compose.p004ui.geometry.Rect;
import androidx.compose.p004ui.unit.Density;
import androidx.compose.p004ui.unit.DpRect;
import androidx.compose.runtime.Stable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.gy3;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public interface PressGestureScope extends Density {

    /* compiled from: Taobao */
    public static final class DefaultImpls {
        @Stable
        @Deprecated
        /* renamed from: roundToPx--R2X_6o, reason: not valid java name */
        public static int m1264roundToPxR2X_6o(@NotNull PressGestureScope pressGestureScope, long j) {
            return gy3.a(pressGestureScope, j);
        }

        @Stable
        @Deprecated
        /* renamed from: roundToPx-0680j_4, reason: not valid java name */
        public static int m1265roundToPx0680j_4(@NotNull PressGestureScope pressGestureScope, float f) {
            return gy3.b(pressGestureScope, f);
        }

        @Stable
        @Deprecated
        /* renamed from: toDp-GaN1DYA, reason: not valid java name */
        public static float m1266toDpGaN1DYA(@NotNull PressGestureScope pressGestureScope, long j) {
            return gy3.c(pressGestureScope, j);
        }

        @Stable
        @Deprecated
        /* renamed from: toDp-u2uoSUM, reason: not valid java name */
        public static float m1267toDpu2uoSUM(@NotNull PressGestureScope pressGestureScope, float f) {
            return gy3.d(pressGestureScope, f);
        }

        @Stable
        @Deprecated
        /* renamed from: toDpSize-k-rfVVM, reason: not valid java name */
        public static long m1269toDpSizekrfVVM(@NotNull PressGestureScope pressGestureScope, long j) {
            return gy3.f(pressGestureScope, j);
        }

        @Stable
        @Deprecated
        /* renamed from: toPx--R2X_6o, reason: not valid java name */
        public static float m1270toPxR2X_6o(@NotNull PressGestureScope pressGestureScope, long j) {
            return gy3.g(pressGestureScope, j);
        }

        @Stable
        @Deprecated
        /* renamed from: toPx-0680j_4, reason: not valid java name */
        public static float m1271toPx0680j_4(@NotNull PressGestureScope pressGestureScope, float f) {
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
        public static long m1272toSizeXkaWNTQ(@NotNull PressGestureScope pressGestureScope, long j) {
            return gy3.j(pressGestureScope, j);
        }

        @Stable
        @Deprecated
        /* renamed from: toSp-0xMU5do, reason: not valid java name */
        public static long m1273toSp0xMU5do(@NotNull PressGestureScope pressGestureScope, float f) {
            return gy3.k(pressGestureScope, f);
        }

        @Stable
        @Deprecated
        /* renamed from: toSp-kPz2Gy4, reason: not valid java name */
        public static long m1274toSpkPz2Gy4(@NotNull PressGestureScope pressGestureScope, float f) {
            return gy3.l(pressGestureScope, f);
        }

        @Stable
        @Deprecated
        /* renamed from: toDp-u2uoSUM, reason: not valid java name */
        public static float m1268toDpu2uoSUM(@NotNull PressGestureScope pressGestureScope, int i) {
            return gy3.e(pressGestureScope, i);
        }

        @Stable
        @Deprecated
        /* renamed from: toSp-kPz2Gy4, reason: not valid java name */
        public static long m1275toSpkPz2Gy4(@NotNull PressGestureScope pressGestureScope, int i) {
            return gy3.m(pressGestureScope, i);
        }
    }

    @Nullable
    Object awaitRelease(@NotNull Continuation<? super Unit> continuation);

    @Nullable
    Object tryAwaitRelease(@NotNull Continuation<? super Boolean> continuation);
}
