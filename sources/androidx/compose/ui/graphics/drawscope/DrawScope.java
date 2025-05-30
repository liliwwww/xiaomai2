package androidx.compose.ui.graphics.drawscope;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.BlendMode;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.FilterQuality;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.PathEffect;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.ReplaceWith;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@DrawScopeMarker
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public interface DrawScope extends Density {

    @NotNull
    public static final Companion Companion = Companion.$$INSTANCE;

    /* compiled from: Taobao */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static final int DefaultBlendMode = BlendMode.Companion.m1005getSrcOver0nO6VwU();
        private static final int DefaultFilterQuality = FilterQuality.Companion.m1086getLowfv9h1I();

        private Companion() {
        }

        /* renamed from: getDefaultBlendMode-0nO6VwU, reason: not valid java name */
        public final int m1334getDefaultBlendMode0nO6VwU() {
            return DefaultBlendMode;
        }

        /* renamed from: getDefaultFilterQuality-f-v9h1I, reason: not valid java name */
        public final int m1335getDefaultFilterQualityfv9h1I() {
            return DefaultFilterQuality;
        }
    }

    /* renamed from: drawArc-illE91I */
    void mo1301drawArcillE91I(@NotNull Brush brush, float f, float f2, boolean z, long j, long j2, float f3, @NotNull DrawStyle drawStyle, @Nullable ColorFilter colorFilter, int i);

    /* renamed from: drawArc-yD3GUKo */
    void mo1302drawArcyD3GUKo(long j, float f, float f2, boolean z, long j2, long j3, float f3, @NotNull DrawStyle drawStyle, @Nullable ColorFilter colorFilter, int i);

    /* renamed from: drawCircle-V9BoPsw */
    void mo1303drawCircleV9BoPsw(@NotNull Brush brush, float f, long j, float f2, @NotNull DrawStyle drawStyle, @Nullable ColorFilter colorFilter, int i);

    /* renamed from: drawCircle-VaOC9Bg */
    void mo1304drawCircleVaOC9Bg(long j, float f, long j2, float f2, @NotNull DrawStyle drawStyle, @Nullable ColorFilter colorFilter, int i);

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Prefer usage of drawImage that consumes an optional FilterQuality parameter", replaceWith = @ReplaceWith(expression = "drawImage(image, srcOffset, srcSize, dstOffset, dstSize, alpha, style, colorFilter, blendMode, FilterQuality.Low)", imports = {"androidx.compose.ui.graphics.drawscope", "androidx.compose.ui.graphics.FilterQuality"}))
    /* renamed from: drawImage-9jGpkUE */
    /* synthetic */ void mo1305drawImage9jGpkUE(ImageBitmap imageBitmap, long j, long j2, long j3, long j4, float f, DrawStyle drawStyle, ColorFilter colorFilter, int i);

    /* renamed from: drawImage-AZ2fEMs */
    void mo1306drawImageAZ2fEMs(@NotNull ImageBitmap imageBitmap, long j, long j2, long j3, long j4, float f, @NotNull DrawStyle drawStyle, @Nullable ColorFilter colorFilter, int i, int i2);

    /* renamed from: drawImage-gbVJVH8 */
    void mo1307drawImagegbVJVH8(@NotNull ImageBitmap imageBitmap, long j, float f, @NotNull DrawStyle drawStyle, @Nullable ColorFilter colorFilter, int i);

    /* renamed from: drawLine-1RTmtNc */
    void mo1308drawLine1RTmtNc(@NotNull Brush brush, long j, long j2, float f, int i, @Nullable PathEffect pathEffect, float f2, @Nullable ColorFilter colorFilter, int i2);

    /* renamed from: drawLine-NGM6Ib0 */
    void mo1309drawLineNGM6Ib0(long j, long j2, long j3, float f, int i, @Nullable PathEffect pathEffect, float f2, @Nullable ColorFilter colorFilter, int i2);

    /* renamed from: drawOval-AsUm42w */
    void mo1310drawOvalAsUm42w(@NotNull Brush brush, long j, long j2, float f, @NotNull DrawStyle drawStyle, @Nullable ColorFilter colorFilter, int i);

    /* renamed from: drawOval-n-J9OG0 */
    void mo1311drawOvalnJ9OG0(long j, long j2, long j3, float f, @NotNull DrawStyle drawStyle, @Nullable ColorFilter colorFilter, int i);

    /* renamed from: drawPath-GBMwjPU */
    void mo1312drawPathGBMwjPU(@NotNull Path path, @NotNull Brush brush, float f, @NotNull DrawStyle drawStyle, @Nullable ColorFilter colorFilter, int i);

    /* renamed from: drawPath-LG529CI */
    void mo1313drawPathLG529CI(@NotNull Path path, long j, float f, @NotNull DrawStyle drawStyle, @Nullable ColorFilter colorFilter, int i);

    /* renamed from: drawPoints-F8ZwMP8 */
    void mo1314drawPointsF8ZwMP8(@NotNull List<Offset> list, int i, long j, float f, int i2, @Nullable PathEffect pathEffect, float f2, @Nullable ColorFilter colorFilter, int i3);

    /* renamed from: drawPoints-Gsft0Ws */
    void mo1315drawPointsGsft0Ws(@NotNull List<Offset> list, int i, @NotNull Brush brush, float f, int i2, @Nullable PathEffect pathEffect, float f2, @Nullable ColorFilter colorFilter, int i3);

    /* renamed from: drawRect-AsUm42w */
    void mo1316drawRectAsUm42w(@NotNull Brush brush, long j, long j2, float f, @NotNull DrawStyle drawStyle, @Nullable ColorFilter colorFilter, int i);

    /* renamed from: drawRect-n-J9OG0 */
    void mo1317drawRectnJ9OG0(long j, long j2, long j3, float f, @NotNull DrawStyle drawStyle, @Nullable ColorFilter colorFilter, int i);

    /* renamed from: drawRoundRect-ZuiqVtQ */
    void mo1318drawRoundRectZuiqVtQ(@NotNull Brush brush, long j, long j2, long j3, float f, @NotNull DrawStyle drawStyle, @Nullable ColorFilter colorFilter, int i);

    /* renamed from: drawRoundRect-u-Aw5IA */
    void mo1319drawRoundRectuAw5IA(long j, long j2, long j3, long j4, @NotNull DrawStyle drawStyle, float f, @Nullable ColorFilter colorFilter, int i);

    /* renamed from: getCenter-F1C5BW0 */
    long mo1320getCenterF1C5BW0();

    @NotNull
    DrawContext getDrawContext();

    @NotNull
    LayoutDirection getLayoutDirection();

    /* renamed from: getSize-NH-jbRc */
    long mo1321getSizeNHjbRc();
}
