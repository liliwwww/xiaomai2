package androidx.compose.p004ui.input.pointer;

import androidx.compose.p004ui.geometry.Rect;
import androidx.compose.p004ui.platform.ViewConfiguration;
import androidx.compose.p004ui.unit.Density;
import androidx.compose.p004ui.unit.DpRect;
import androidx.compose.runtime.Stable;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.RestrictsSuspension;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.je;

/* compiled from: Taobao */
@RestrictsSuspension
/* loaded from: classes.dex */
public interface AwaitPointerEventScope extends Density {

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public static final class DefaultImpls {
        @Deprecated
        /* renamed from: getExtendedTouchPadding-NH-jbRc, reason: not valid java name */
        public static long m3998getExtendedTouchPaddingNHjbRc(@NotNull AwaitPointerEventScope awaitPointerEventScope) {
            return je.d(awaitPointerEventScope);
        }

        @Stable
        @Deprecated
        /* renamed from: roundToPx--R2X_6o, reason: not valid java name */
        public static int m3999roundToPxR2X_6o(@NotNull AwaitPointerEventScope awaitPointerEventScope, long j) {
            return je.e(awaitPointerEventScope, j);
        }

        @Stable
        @Deprecated
        /* renamed from: roundToPx-0680j_4, reason: not valid java name */
        public static int m4000roundToPx0680j_4(@NotNull AwaitPointerEventScope awaitPointerEventScope, float f) {
            return je.f(awaitPointerEventScope, f);
        }

        @Stable
        @Deprecated
        /* renamed from: toDp-GaN1DYA, reason: not valid java name */
        public static float m4001toDpGaN1DYA(@NotNull AwaitPointerEventScope awaitPointerEventScope, long j) {
            return je.g(awaitPointerEventScope, j);
        }

        @Stable
        @Deprecated
        /* renamed from: toDp-u2uoSUM, reason: not valid java name */
        public static float m4002toDpu2uoSUM(@NotNull AwaitPointerEventScope awaitPointerEventScope, float f) {
            return je.h(awaitPointerEventScope, f);
        }

        @Stable
        @Deprecated
        /* renamed from: toDpSize-k-rfVVM, reason: not valid java name */
        public static long m4004toDpSizekrfVVM(@NotNull AwaitPointerEventScope awaitPointerEventScope, long j) {
            return je.j(awaitPointerEventScope, j);
        }

        @Stable
        @Deprecated
        /* renamed from: toPx--R2X_6o, reason: not valid java name */
        public static float m4005toPxR2X_6o(@NotNull AwaitPointerEventScope awaitPointerEventScope, long j) {
            return je.k(awaitPointerEventScope, j);
        }

        @Stable
        @Deprecated
        /* renamed from: toPx-0680j_4, reason: not valid java name */
        public static float m4006toPx0680j_4(@NotNull AwaitPointerEventScope awaitPointerEventScope, float f) {
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
        public static long m4007toSizeXkaWNTQ(@NotNull AwaitPointerEventScope awaitPointerEventScope, long j) {
            return je.n(awaitPointerEventScope, j);
        }

        @Stable
        @Deprecated
        /* renamed from: toSp-0xMU5do, reason: not valid java name */
        public static long m4008toSp0xMU5do(@NotNull AwaitPointerEventScope awaitPointerEventScope, float f) {
            return je.o(awaitPointerEventScope, f);
        }

        @Stable
        @Deprecated
        /* renamed from: toSp-kPz2Gy4, reason: not valid java name */
        public static long m4009toSpkPz2Gy4(@NotNull AwaitPointerEventScope awaitPointerEventScope, float f) {
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
        public static float m4003toDpu2uoSUM(@NotNull AwaitPointerEventScope awaitPointerEventScope, int i) {
            return je.i(awaitPointerEventScope, i);
        }

        @Stable
        @Deprecated
        /* renamed from: toSp-kPz2Gy4, reason: not valid java name */
        public static long m4010toSpkPz2Gy4(@NotNull AwaitPointerEventScope awaitPointerEventScope, int i) {
            return je.q(awaitPointerEventScope, i);
        }
    }

    @Nullable
    Object awaitPointerEvent(@NotNull PointerEventPass pointerEventPass, @NotNull Continuation<? super PointerEvent> continuation);

    @NotNull
    PointerEvent getCurrentEvent();

    /* renamed from: getExtendedTouchPadding-NH-jbRc, reason: not valid java name */
    long mo3996getExtendedTouchPaddingNHjbRc();

    /* renamed from: getSize-YbymL2g, reason: not valid java name */
    long mo3997getSizeYbymL2g();

    @NotNull
    ViewConfiguration getViewConfiguration();

    @Nullable
    <T> Object withTimeout(long j, @NotNull Function2<? super AwaitPointerEventScope, ? super Continuation<? super T>, ? extends Object> function2, @NotNull Continuation<? super T> continuation);

    @Nullable
    <T> Object withTimeoutOrNull(long j, @NotNull Function2<? super AwaitPointerEventScope, ? super Continuation<? super T>, ? extends Object> function2, @NotNull Continuation<? super T> continuation);
}
