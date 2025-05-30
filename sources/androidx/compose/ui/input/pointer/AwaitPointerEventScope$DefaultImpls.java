package androidx.compose.ui.input.pointer;

import androidx.compose.runtime.Stable;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.unit.DpRect;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.je;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class AwaitPointerEventScope$DefaultImpls {
    @Deprecated
    /* renamed from: getExtendedTouchPadding-NH-jbRc, reason: not valid java name */
    public static long m1966getExtendedTouchPaddingNHjbRc(@NotNull AwaitPointerEventScope awaitPointerEventScope) {
        return je.d(awaitPointerEventScope);
    }

    @Stable
    @Deprecated
    /* renamed from: roundToPx--R2X_6o, reason: not valid java name */
    public static int m1967roundToPxR2X_6o(@NotNull AwaitPointerEventScope awaitPointerEventScope, long j) {
        return je.e(awaitPointerEventScope, j);
    }

    @Stable
    @Deprecated
    /* renamed from: roundToPx-0680j_4, reason: not valid java name */
    public static int m1968roundToPx0680j_4(@NotNull AwaitPointerEventScope awaitPointerEventScope, float f) {
        return je.f(awaitPointerEventScope, f);
    }

    @Stable
    @Deprecated
    /* renamed from: toDp-GaN1DYA, reason: not valid java name */
    public static float m1969toDpGaN1DYA(@NotNull AwaitPointerEventScope awaitPointerEventScope, long j) {
        return je.g(awaitPointerEventScope, j);
    }

    @Stable
    @Deprecated
    /* renamed from: toDp-u2uoSUM, reason: not valid java name */
    public static float m1970toDpu2uoSUM(@NotNull AwaitPointerEventScope awaitPointerEventScope, float f) {
        return je.h(awaitPointerEventScope, f);
    }

    @Stable
    @Deprecated
    /* renamed from: toDpSize-k-rfVVM, reason: not valid java name */
    public static long m1972toDpSizekrfVVM(@NotNull AwaitPointerEventScope awaitPointerEventScope, long j) {
        return je.j(awaitPointerEventScope, j);
    }

    @Stable
    @Deprecated
    /* renamed from: toPx--R2X_6o, reason: not valid java name */
    public static float m1973toPxR2X_6o(@NotNull AwaitPointerEventScope awaitPointerEventScope, long j) {
        return je.k(awaitPointerEventScope, j);
    }

    @Stable
    @Deprecated
    /* renamed from: toPx-0680j_4, reason: not valid java name */
    public static float m1974toPx0680j_4(@NotNull AwaitPointerEventScope awaitPointerEventScope, float f) {
        return je.l(awaitPointerEventScope, f);
    }

    @Stable
    @Deprecated
    @NotNull
    public static Rect toRect(@NotNull AwaitPointerEventScope awaitPointerEventScope, @NotNull DpRect dpRect) {
        Intrinsics.checkNotNullParameter(dpRect, "$receiver");
        return je.m(awaitPointerEventScope, dpRect);
    }

    @Stable
    @Deprecated
    /* renamed from: toSize-XkaWNTQ, reason: not valid java name */
    public static long m1975toSizeXkaWNTQ(@NotNull AwaitPointerEventScope awaitPointerEventScope, long j) {
        return je.n(awaitPointerEventScope, j);
    }

    @Stable
    @Deprecated
    /* renamed from: toSp-0xMU5do, reason: not valid java name */
    public static long m1976toSp0xMU5do(@NotNull AwaitPointerEventScope awaitPointerEventScope, float f) {
        return je.o(awaitPointerEventScope, f);
    }

    @Stable
    @Deprecated
    /* renamed from: toSp-kPz2Gy4, reason: not valid java name */
    public static long m1977toSpkPz2Gy4(@NotNull AwaitPointerEventScope awaitPointerEventScope, float f) {
        return je.p(awaitPointerEventScope, f);
    }

    @Deprecated
    @Nullable
    public static <T> Object withTimeout(@NotNull AwaitPointerEventScope awaitPointerEventScope, long j, @NotNull Function2<? super AwaitPointerEventScope, ? super Continuation<? super T>, ? extends Object> function2, @NotNull Continuation<? super T> continuation) {
        return je.r(awaitPointerEventScope, j, function2, continuation);
    }

    @Deprecated
    @Nullable
    public static <T> Object withTimeoutOrNull(@NotNull AwaitPointerEventScope awaitPointerEventScope, long j, @NotNull Function2<? super AwaitPointerEventScope, ? super Continuation<? super T>, ? extends Object> function2, @NotNull Continuation<? super T> continuation) {
        return je.s(awaitPointerEventScope, j, function2, continuation);
    }

    @Stable
    @Deprecated
    /* renamed from: toDp-u2uoSUM, reason: not valid java name */
    public static float m1971toDpu2uoSUM(@NotNull AwaitPointerEventScope awaitPointerEventScope, int i) {
        return je.i(awaitPointerEventScope, i);
    }

    @Stable
    @Deprecated
    /* renamed from: toSp-kPz2Gy4, reason: not valid java name */
    public static long m1978toSpkPz2Gy4(@NotNull AwaitPointerEventScope awaitPointerEventScope, int i) {
        return je.q(awaitPointerEventScope, i);
    }
}
