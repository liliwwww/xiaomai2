package androidx.compose.p004ui.graphics.drawscope;

import androidx.compose.p004ui.geometry.Rect;
import androidx.compose.p004ui.graphics.ColorFilter;
import androidx.compose.p004ui.graphics.ImageBitmap;
import androidx.compose.p004ui.unit.DpRect;
import androidx.compose.runtime.Stable;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.c70;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public interface ContentDrawScope extends DrawScope {

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public static final class DefaultImpls {
        @Deprecated
        /* renamed from: drawImage-AZ2fEMs, reason: not valid java name */
        public static void m3220drawImageAZ2fEMs(@NotNull ContentDrawScope contentDrawScope, @NotNull ImageBitmap imageBitmap, long j, long j2, long j3, long j4, float f, @NotNull DrawStyle drawStyle, @Nullable ColorFilter colorFilter, int i, int i2) {
            Intrinsics.checkNotNullParameter(imageBitmap, "image");
            Intrinsics.checkNotNullParameter(drawStyle, "style");
            c70.a(contentDrawScope, imageBitmap, j, j2, j3, j4, f, drawStyle, colorFilter, i, i2);
        }

        @Deprecated
        /* renamed from: getCenter-F1C5BW0, reason: not valid java name */
        public static long m3221getCenterF1C5BW0(@NotNull ContentDrawScope contentDrawScope) {
            return c70.b(contentDrawScope);
        }

        @Deprecated
        /* renamed from: getSize-NH-jbRc, reason: not valid java name */
        public static long m3222getSizeNHjbRc(@NotNull ContentDrawScope contentDrawScope) {
            return c70.c(contentDrawScope);
        }

        @Stable
        @Deprecated
        /* renamed from: roundToPx--R2X_6o, reason: not valid java name */
        public static int m3223roundToPxR2X_6o(@NotNull ContentDrawScope contentDrawScope, long j) {
            return c70.d(contentDrawScope, j);
        }

        @Stable
        @Deprecated
        /* renamed from: roundToPx-0680j_4, reason: not valid java name */
        public static int m3224roundToPx0680j_4(@NotNull ContentDrawScope contentDrawScope, float f) {
            return c70.e(contentDrawScope, f);
        }

        @Stable
        @Deprecated
        /* renamed from: toDp-GaN1DYA, reason: not valid java name */
        public static float m3225toDpGaN1DYA(@NotNull ContentDrawScope contentDrawScope, long j) {
            return c70.f(contentDrawScope, j);
        }

        @Stable
        @Deprecated
        /* renamed from: toDp-u2uoSUM, reason: not valid java name */
        public static float m3226toDpu2uoSUM(@NotNull ContentDrawScope contentDrawScope, float f) {
            return c70.g(contentDrawScope, f);
        }

        @Stable
        @Deprecated
        /* renamed from: toDpSize-k-rfVVM, reason: not valid java name */
        public static long m3228toDpSizekrfVVM(@NotNull ContentDrawScope contentDrawScope, long j) {
            return c70.i(contentDrawScope, j);
        }

        @Stable
        @Deprecated
        /* renamed from: toPx--R2X_6o, reason: not valid java name */
        public static float m3229toPxR2X_6o(@NotNull ContentDrawScope contentDrawScope, long j) {
            return c70.j(contentDrawScope, j);
        }

        @Stable
        @Deprecated
        /* renamed from: toPx-0680j_4, reason: not valid java name */
        public static float m3230toPx0680j_4(@NotNull ContentDrawScope contentDrawScope, float f) {
            return c70.k(contentDrawScope, f);
        }

        @Stable
        @Deprecated
        @NotNull
        public static Rect toRect(@NotNull ContentDrawScope contentDrawScope, @NotNull DpRect dpRect) {
            Intrinsics.checkNotNullParameter(dpRect, "$receiver");
            return c70.l(contentDrawScope, dpRect);
        }

        @Stable
        @Deprecated
        /* renamed from: toSize-XkaWNTQ, reason: not valid java name */
        public static long m3231toSizeXkaWNTQ(@NotNull ContentDrawScope contentDrawScope, long j) {
            return c70.m(contentDrawScope, j);
        }

        @Stable
        @Deprecated
        /* renamed from: toSp-0xMU5do, reason: not valid java name */
        public static long m3232toSp0xMU5do(@NotNull ContentDrawScope contentDrawScope, float f) {
            return c70.n(contentDrawScope, f);
        }

        @Stable
        @Deprecated
        /* renamed from: toSp-kPz2Gy4, reason: not valid java name */
        public static long m3233toSpkPz2Gy4(@NotNull ContentDrawScope contentDrawScope, float f) {
            return c70.o(contentDrawScope, f);
        }

        @Stable
        @Deprecated
        /* renamed from: toDp-u2uoSUM, reason: not valid java name */
        public static float m3227toDpu2uoSUM(@NotNull ContentDrawScope contentDrawScope, int i) {
            return c70.h(contentDrawScope, i);
        }

        @Stable
        @Deprecated
        /* renamed from: toSp-kPz2Gy4, reason: not valid java name */
        public static long m3234toSpkPz2Gy4(@NotNull ContentDrawScope contentDrawScope, int i) {
            return c70.p(contentDrawScope, i);
        }
    }

    void drawContent();
}
