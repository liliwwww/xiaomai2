package androidx.compose.ui.graphics;

import android.graphics.Paint;
import android.graphics.PorterDuffXfermode;
import android.graphics.Shader;
import android.os.Build;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.StrokeJoin;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class AndroidPaint_androidKt {
    @NotNull
    public static final Paint Paint() {
        return new AndroidPaint();
    }

    public static final float getNativeAlpha(@NotNull Paint paint) {
        Intrinsics.checkNotNullParameter(paint, "<this>");
        return paint.getAlpha() / 255.0f;
    }

    public static final boolean getNativeAntiAlias(@NotNull Paint paint) {
        Intrinsics.checkNotNullParameter(paint, "<this>");
        return paint.isAntiAlias();
    }

    public static final long getNativeColor(@NotNull Paint paint) {
        Intrinsics.checkNotNullParameter(paint, "<this>");
        return ColorKt.Color(paint.getColor());
    }

    public static final int getNativeFilterQuality(@NotNull Paint paint) {
        Intrinsics.checkNotNullParameter(paint, "<this>");
        return !paint.isFilterBitmap() ? FilterQuality.Companion.m1088getNonefv9h1I() : FilterQuality.Companion.m1086getLowfv9h1I();
    }

    public static final int getNativeStrokeCap(@NotNull Paint paint) {
        Intrinsics.checkNotNullParameter(paint, "<this>");
        Paint.Cap strokeCap = paint.getStrokeCap();
        int i = strokeCap == null ? -1 : WhenMappings.$EnumSwitchMapping$1[strokeCap.ordinal()];
        return i != 1 ? i != 2 ? i != 3 ? StrokeCap.Companion.getButt-KaPHkGw() : StrokeCap.Companion.getSquare-KaPHkGw() : StrokeCap.Companion.getRound-KaPHkGw() : StrokeCap.Companion.getButt-KaPHkGw();
    }

    public static final int getNativeStrokeJoin(@NotNull Paint paint) {
        Intrinsics.checkNotNullParameter(paint, "<this>");
        Paint.Join strokeJoin = paint.getStrokeJoin();
        int i = strokeJoin == null ? -1 : WhenMappings.$EnumSwitchMapping$2[strokeJoin.ordinal()];
        return i != 1 ? i != 2 ? i != 3 ? StrokeJoin.Companion.getMiter-LxFBmk8() : StrokeJoin.Companion.getRound-LxFBmk8() : StrokeJoin.Companion.getBevel-LxFBmk8() : StrokeJoin.Companion.getMiter-LxFBmk8();
    }

    public static final float getNativeStrokeMiterLimit(@NotNull Paint paint) {
        Intrinsics.checkNotNullParameter(paint, "<this>");
        return paint.getStrokeMiter();
    }

    public static final float getNativeStrokeWidth(@NotNull Paint paint) {
        Intrinsics.checkNotNullParameter(paint, "<this>");
        return paint.getStrokeWidth();
    }

    public static final int getNativeStyle(@NotNull Paint paint) {
        Intrinsics.checkNotNullParameter(paint, "<this>");
        Paint.Style style = paint.getStyle();
        return (style == null ? -1 : WhenMappings.$EnumSwitchMapping$0[style.ordinal()]) == 1 ? PaintingStyle.Companion.m1183getStrokeTiuSbCo() : PaintingStyle.Companion.m1182getFillTiuSbCo();
    }

    @NotNull
    public static final Paint makeNativePaint() {
        return new Paint(7);
    }

    public static final void setNativeAlpha(@NotNull Paint paint, float f) {
        Intrinsics.checkNotNullParameter(paint, "<this>");
        paint.setAlpha((int) Math.rint(f * 255.0f));
    }

    public static final void setNativeAntiAlias(@NotNull Paint paint, boolean z) {
        Intrinsics.checkNotNullParameter(paint, "<this>");
        paint.setAntiAlias(z);
    }

    /* renamed from: setNativeBlendMode-GB0RdKg, reason: not valid java name */
    public static final void m952setNativeBlendModeGB0RdKg(@NotNull Paint paint, int i) {
        Intrinsics.checkNotNullParameter(paint, "$this$setNativeBlendMode");
        if (Build.VERSION.SDK_INT >= 29) {
            WrapperVerificationHelperMethods.INSTANCE.m1278setBlendModeGB0RdKg(paint, i);
        } else {
            paint.setXfermode(new PorterDuffXfermode(AndroidBlendMode_androidKt.m927toPorterDuffModes9anfk8(i)));
        }
    }

    /* renamed from: setNativeColor-4WTKRHQ, reason: not valid java name */
    public static final void m953setNativeColor4WTKRHQ(@NotNull Paint paint, long j) {
        Intrinsics.checkNotNullParameter(paint, "$this$setNativeColor");
        paint.setColor(ColorKt.m1074toArgb8_81llA(j));
    }

    public static final void setNativeColorFilter(@NotNull Paint paint, @Nullable ColorFilter colorFilter) {
        Intrinsics.checkNotNullParameter(paint, "<this>");
        paint.setColorFilter(colorFilter != null ? AndroidColorFilter_androidKt.asAndroidColorFilter(colorFilter) : null);
    }

    /* renamed from: setNativeFilterQuality-50PEsBU, reason: not valid java name */
    public static final void m954setNativeFilterQuality50PEsBU(@NotNull Paint paint, int i) {
        Intrinsics.checkNotNullParameter(paint, "$this$setNativeFilterQuality");
        paint.setFilterBitmap(!FilterQuality.m1081equalsimpl0(i, FilterQuality.Companion.m1088getNonefv9h1I()));
    }

    public static final void setNativePathEffect(@NotNull Paint paint, @Nullable PathEffect pathEffect) {
        Intrinsics.checkNotNullParameter(paint, "<this>");
        AndroidPathEffect androidPathEffect = (AndroidPathEffect) pathEffect;
        paint.setPathEffect(androidPathEffect != null ? androidPathEffect.getNativePathEffect() : null);
    }

    public static final void setNativeShader(@NotNull Paint paint, @Nullable Shader shader) {
        Intrinsics.checkNotNullParameter(paint, "<this>");
        paint.setShader(shader);
    }

    /* renamed from: setNativeStrokeCap-CSYIeUk, reason: not valid java name */
    public static final void m955setNativeStrokeCapCSYIeUk(@NotNull Paint paint, int i) {
        Intrinsics.checkNotNullParameter(paint, "$this$setNativeStrokeCap");
        StrokeCap.Companion companion = StrokeCap.Companion;
        paint.setStrokeCap(StrokeCap.m1247equalsimpl0(i, companion.getSquare-KaPHkGw()) ? Paint.Cap.SQUARE : StrokeCap.m1247equalsimpl0(i, companion.getRound-KaPHkGw()) ? Paint.Cap.ROUND : StrokeCap.m1247equalsimpl0(i, companion.getButt-KaPHkGw()) ? Paint.Cap.BUTT : Paint.Cap.BUTT);
    }

    /* renamed from: setNativeStrokeJoin-kLtJ_vA, reason: not valid java name */
    public static final void m956setNativeStrokeJoinkLtJ_vA(@NotNull Paint paint, int i) {
        Intrinsics.checkNotNullParameter(paint, "$this$setNativeStrokeJoin");
        StrokeJoin.Companion companion = StrokeJoin.Companion;
        paint.setStrokeJoin(StrokeJoin.m1254equalsimpl0(i, companion.getMiter-LxFBmk8()) ? Paint.Join.MITER : StrokeJoin.m1254equalsimpl0(i, companion.getBevel-LxFBmk8()) ? Paint.Join.BEVEL : StrokeJoin.m1254equalsimpl0(i, companion.getRound-LxFBmk8()) ? Paint.Join.ROUND : Paint.Join.MITER);
    }

    public static final void setNativeStrokeMiterLimit(@NotNull Paint paint, float f) {
        Intrinsics.checkNotNullParameter(paint, "<this>");
        paint.setStrokeMiter(f);
    }

    public static final void setNativeStrokeWidth(@NotNull Paint paint, float f) {
        Intrinsics.checkNotNullParameter(paint, "<this>");
        paint.setStrokeWidth(f);
    }

    /* renamed from: setNativeStyle--5YerkU, reason: not valid java name */
    public static final void m957setNativeStyle5YerkU(@NotNull Paint paint, int i) {
        Intrinsics.checkNotNullParameter(paint, "$this$setNativeStyle");
        paint.setStyle(PaintingStyle.m1178equalsimpl0(i, PaintingStyle.Companion.m1183getStrokeTiuSbCo()) ? Paint.Style.STROKE : Paint.Style.FILL);
    }

    @NotNull
    public static final Paint toComposePaint(@NotNull Paint paint) {
        Intrinsics.checkNotNullParameter(paint, "<this>");
        return new AndroidPaint(paint);
    }
}
