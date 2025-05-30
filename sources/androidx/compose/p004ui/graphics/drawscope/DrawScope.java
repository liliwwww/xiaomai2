package androidx.compose.p004ui.graphics.drawscope;

import androidx.compose.p004ui.geometry.Offset;
import androidx.compose.p004ui.geometry.Rect;
import androidx.compose.p004ui.graphics.BlendMode;
import androidx.compose.p004ui.graphics.Brush;
import androidx.compose.p004ui.graphics.ColorFilter;
import androidx.compose.p004ui.graphics.FilterQuality;
import androidx.compose.p004ui.graphics.ImageBitmap;
import androidx.compose.p004ui.graphics.Path;
import androidx.compose.p004ui.graphics.PathEffect;
import androidx.compose.p004ui.unit.Density;
import androidx.compose.p004ui.unit.DpRect;
import androidx.compose.p004ui.unit.LayoutDirection;
import androidx.compose.runtime.Stable;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.w51;

/* compiled from: Taobao */
@DrawScopeMarker
/* loaded from: classes.dex */
public interface DrawScope extends Density {

    @NotNull
    public static final Companion Companion = Companion.$$INSTANCE;

    /* compiled from: Taobao */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static final int DefaultBlendMode = BlendMode.Companion.m2737getSrcOver0nO6VwU();
        private static final int DefaultFilterQuality = FilterQuality.Companion.m2882getLowfv9h1I();

        private Companion() {
        }

        /* renamed from: getDefaultBlendMode-0nO6VwU, reason: not valid java name */
        public final int m3235getDefaultBlendMode0nO6VwU() {
            return DefaultBlendMode;
        }

        /* renamed from: getDefaultFilterQuality-f-v9h1I, reason: not valid java name */
        public final int m3236getDefaultFilterQualityfv9h1I() {
            return DefaultFilterQuality;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public static final class DefaultImpls {
        @Deprecated
        /* renamed from: drawImage-AZ2fEMs, reason: not valid java name */
        public static void m3242drawImageAZ2fEMs(@NotNull DrawScope drawScope, @NotNull ImageBitmap imageBitmap, long j, long j2, long j3, long j4, float f, @NotNull DrawStyle drawStyle, @Nullable ColorFilter colorFilter, int i, int i2) {
            Intrinsics.checkNotNullParameter(imageBitmap, "image");
            Intrinsics.checkNotNullParameter(drawStyle, "style");
            w51.e(drawScope, imageBitmap, j, j2, j3, j4, f, drawStyle, colorFilter, i, i2);
        }

        @Deprecated
        /* renamed from: getCenter-F1C5BW0, reason: not valid java name */
        public static long m3257getCenterF1C5BW0(@NotNull DrawScope drawScope) {
            return w51.f(drawScope);
        }

        @Deprecated
        /* renamed from: getSize-NH-jbRc, reason: not valid java name */
        public static long m3258getSizeNHjbRc(@NotNull DrawScope drawScope) {
            return w51.g(drawScope);
        }

        @Stable
        @Deprecated
        /* renamed from: roundToPx--R2X_6o, reason: not valid java name */
        public static int m3259roundToPxR2X_6o(@NotNull DrawScope drawScope, long j) {
            return w51.h(drawScope, j);
        }

        @Stable
        @Deprecated
        /* renamed from: roundToPx-0680j_4, reason: not valid java name */
        public static int m3260roundToPx0680j_4(@NotNull DrawScope drawScope, float f) {
            return w51.i(drawScope, f);
        }

        @Stable
        @Deprecated
        /* renamed from: toDp-GaN1DYA, reason: not valid java name */
        public static float m3261toDpGaN1DYA(@NotNull DrawScope drawScope, long j) {
            return w51.j(drawScope, j);
        }

        @Stable
        @Deprecated
        /* renamed from: toDp-u2uoSUM, reason: not valid java name */
        public static float m3262toDpu2uoSUM(@NotNull DrawScope drawScope, float f) {
            return w51.k(drawScope, f);
        }

        @Stable
        @Deprecated
        /* renamed from: toDpSize-k-rfVVM, reason: not valid java name */
        public static long m3264toDpSizekrfVVM(@NotNull DrawScope drawScope, long j) {
            return w51.m(drawScope, j);
        }

        @Stable
        @Deprecated
        /* renamed from: toPx--R2X_6o, reason: not valid java name */
        public static float m3265toPxR2X_6o(@NotNull DrawScope drawScope, long j) {
            return w51.n(drawScope, j);
        }

        @Stable
        @Deprecated
        /* renamed from: toPx-0680j_4, reason: not valid java name */
        public static float m3266toPx0680j_4(@NotNull DrawScope drawScope, float f) {
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
        public static long m3267toSizeXkaWNTQ(@NotNull DrawScope drawScope, long j) {
            return w51.q(drawScope, j);
        }

        @Stable
        @Deprecated
        /* renamed from: toSp-0xMU5do, reason: not valid java name */
        public static long m3268toSp0xMU5do(@NotNull DrawScope drawScope, float f) {
            return w51.r(drawScope, f);
        }

        @Stable
        @Deprecated
        /* renamed from: toSp-kPz2Gy4, reason: not valid java name */
        public static long m3269toSpkPz2Gy4(@NotNull DrawScope drawScope, float f) {
            return w51.s(drawScope, f);
        }

        @Stable
        @Deprecated
        /* renamed from: toDp-u2uoSUM, reason: not valid java name */
        public static float m3263toDpu2uoSUM(@NotNull DrawScope drawScope, int i) {
            return w51.l(drawScope, i);
        }

        @Stable
        @Deprecated
        /* renamed from: toSp-kPz2Gy4, reason: not valid java name */
        public static long m3270toSpkPz2Gy4(@NotNull DrawScope drawScope, int i) {
            return w51.t(drawScope, i);
        }
    }

    /* renamed from: drawArc-illE91I */
    void mo3185drawArcillE91I(@NotNull Brush brush, float f, float f2, boolean z, long j, long j2, float f3, @NotNull DrawStyle drawStyle, @Nullable ColorFilter colorFilter, int i);

    /* renamed from: drawArc-yD3GUKo */
    void mo3186drawArcyD3GUKo(long j, float f, float f2, boolean z, long j2, long j3, float f3, @NotNull DrawStyle drawStyle, @Nullable ColorFilter colorFilter, int i);

    /* renamed from: drawCircle-V9BoPsw */
    void mo3187drawCircleV9BoPsw(@NotNull Brush brush, float f, long j, float f2, @NotNull DrawStyle drawStyle, @Nullable ColorFilter colorFilter, int i);

    /* renamed from: drawCircle-VaOC9Bg */
    void mo3188drawCircleVaOC9Bg(long j, float f, long j2, float f2, @NotNull DrawStyle drawStyle, @Nullable ColorFilter colorFilter, int i);

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Prefer usage of drawImage that consumes an optional FilterQuality parameter", replaceWith = @ReplaceWith(expression = "drawImage(image, srcOffset, srcSize, dstOffset, dstSize, alpha, style, colorFilter, blendMode, FilterQuality.Low)", imports = {"androidx.compose.ui.graphics.drawscope", "androidx.compose.ui.graphics.FilterQuality"}))
    /* renamed from: drawImage-9jGpkUE */
    /* synthetic */ void mo3189drawImage9jGpkUE(ImageBitmap imageBitmap, long j, long j2, long j3, long j4, float f, DrawStyle drawStyle, ColorFilter colorFilter, int i);

    /* renamed from: drawImage-AZ2fEMs */
    void mo3190drawImageAZ2fEMs(@NotNull ImageBitmap imageBitmap, long j, long j2, long j3, long j4, float f, @NotNull DrawStyle drawStyle, @Nullable ColorFilter colorFilter, int i, int i2);

    /* renamed from: drawImage-gbVJVH8 */
    void mo3191drawImagegbVJVH8(@NotNull ImageBitmap imageBitmap, long j, float f, @NotNull DrawStyle drawStyle, @Nullable ColorFilter colorFilter, int i);

    /* renamed from: drawLine-1RTmtNc */
    void mo3192drawLine1RTmtNc(@NotNull Brush brush, long j, long j2, float f, int i, @Nullable PathEffect pathEffect, float f2, @Nullable ColorFilter colorFilter, int i2);

    /* renamed from: drawLine-NGM6Ib0 */
    void mo3193drawLineNGM6Ib0(long j, long j2, long j3, float f, int i, @Nullable PathEffect pathEffect, float f2, @Nullable ColorFilter colorFilter, int i2);

    /* renamed from: drawOval-AsUm42w */
    void mo3194drawOvalAsUm42w(@NotNull Brush brush, long j, long j2, float f, @NotNull DrawStyle drawStyle, @Nullable ColorFilter colorFilter, int i);

    /* renamed from: drawOval-n-J9OG0 */
    void mo3195drawOvalnJ9OG0(long j, long j2, long j3, float f, @NotNull DrawStyle drawStyle, @Nullable ColorFilter colorFilter, int i);

    /* renamed from: drawPath-GBMwjPU */
    void mo3196drawPathGBMwjPU(@NotNull Path path, @NotNull Brush brush, float f, @NotNull DrawStyle drawStyle, @Nullable ColorFilter colorFilter, int i);

    /* renamed from: drawPath-LG529CI */
    void mo3197drawPathLG529CI(@NotNull Path path, long j, float f, @NotNull DrawStyle drawStyle, @Nullable ColorFilter colorFilter, int i);

    /* renamed from: drawPoints-F8ZwMP8 */
    void mo3198drawPointsF8ZwMP8(@NotNull List<Offset> list, int i, long j, float f, int i2, @Nullable PathEffect pathEffect, float f2, @Nullable ColorFilter colorFilter, int i3);

    /* renamed from: drawPoints-Gsft0Ws */
    void mo3199drawPointsGsft0Ws(@NotNull List<Offset> list, int i, @NotNull Brush brush, float f, int i2, @Nullable PathEffect pathEffect, float f2, @Nullable ColorFilter colorFilter, int i3);

    /* renamed from: drawRect-AsUm42w */
    void mo3200drawRectAsUm42w(@NotNull Brush brush, long j, long j2, float f, @NotNull DrawStyle drawStyle, @Nullable ColorFilter colorFilter, int i);

    /* renamed from: drawRect-n-J9OG0 */
    void mo3201drawRectnJ9OG0(long j, long j2, long j3, float f, @NotNull DrawStyle drawStyle, @Nullable ColorFilter colorFilter, int i);

    /* renamed from: drawRoundRect-ZuiqVtQ */
    void mo3202drawRoundRectZuiqVtQ(@NotNull Brush brush, long j, long j2, long j3, float f, @NotNull DrawStyle drawStyle, @Nullable ColorFilter colorFilter, int i);

    /* renamed from: drawRoundRect-u-Aw5IA */
    void mo3203drawRoundRectuAw5IA(long j, long j2, long j3, long j4, @NotNull DrawStyle drawStyle, float f, @Nullable ColorFilter colorFilter, int i);

    /* renamed from: getCenter-F1C5BW0 */
    long mo3204getCenterF1C5BW0();

    @NotNull
    DrawContext getDrawContext();

    @NotNull
    LayoutDirection getLayoutDirection();

    /* renamed from: getSize-NH-jbRc */
    long mo3205getSizeNHjbRc();
}
