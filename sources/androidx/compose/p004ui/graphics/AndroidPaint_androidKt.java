package androidx.compose.p004ui.graphics;

import android.graphics.Paint;
import android.graphics.PorterDuffXfermode;
import android.graphics.Shader;
import android.os.Build;
import androidx.compose.p004ui.graphics.StrokeCap;
import androidx.compose.p004ui.graphics.StrokeJoin;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public final class AndroidPaint_androidKt {

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2;

        static {
            int[] iArr = new int[Paint.Style.values().length];
            try {
                iArr[Paint.Style.STROKE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[Paint.Cap.values().length];
            try {
                iArr2[Paint.Cap.BUTT.ordinal()] = 1;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr2[Paint.Cap.ROUND.ordinal()] = 2;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr2[Paint.Cap.SQUARE.ordinal()] = 3;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$1 = iArr2;
            int[] iArr3 = new int[Paint.Join.values().length];
            try {
                iArr3[Paint.Join.MITER.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr3[Paint.Join.BEVEL.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr3[Paint.Join.ROUND.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            $EnumSwitchMapping$2 = iArr3;
        }
    }

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
        return !paint.isFilterBitmap() ? FilterQuality.Companion.m2884getNonefv9h1I() : FilterQuality.Companion.m2882getLowfv9h1I();
    }

    public static final int getNativeStrokeCap(@NotNull Paint paint) {
        Intrinsics.checkNotNullParameter(paint, "<this>");
        Paint.Cap strokeCap = paint.getStrokeCap();
        int i = strokeCap == null ? -1 : WhenMappings.$EnumSwitchMapping$1[strokeCap.ordinal()];
        return i != 1 ? i != 2 ? i != 3 ? StrokeCap.Companion.m3092getButtKaPHkGw() : StrokeCap.Companion.m3094getSquareKaPHkGw() : StrokeCap.Companion.m3093getRoundKaPHkGw() : StrokeCap.Companion.m3092getButtKaPHkGw();
    }

    public static final int getNativeStrokeJoin(@NotNull Paint paint) {
        Intrinsics.checkNotNullParameter(paint, "<this>");
        Paint.Join strokeJoin = paint.getStrokeJoin();
        int i = strokeJoin == null ? -1 : WhenMappings.$EnumSwitchMapping$2[strokeJoin.ordinal()];
        return i != 1 ? i != 2 ? i != 3 ? StrokeJoin.Companion.m3103getMiterLxFBmk8() : StrokeJoin.Companion.m3104getRoundLxFBmk8() : StrokeJoin.Companion.m3102getBevelLxFBmk8() : StrokeJoin.Companion.m3103getMiterLxFBmk8();
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
        return (style == null ? -1 : WhenMappings.$EnumSwitchMapping$0[style.ordinal()]) == 1 ? PaintingStyle.Companion.m3019getStrokeTiuSbCo() : PaintingStyle.Companion.m3018getFillTiuSbCo();
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
    public static final void m2682setNativeBlendModeGB0RdKg(@NotNull Paint paint, int i) {
        Intrinsics.checkNotNullParameter(paint, "$this$setNativeBlendMode");
        if (Build.VERSION.SDK_INT >= 29) {
            WrapperVerificationHelperMethods.INSTANCE.m3142setBlendModeGB0RdKg(paint, i);
        } else {
            paint.setXfermode(new PorterDuffXfermode(AndroidBlendMode_androidKt.m2649toPorterDuffModes9anfk8(i)));
        }
    }

    /* renamed from: setNativeColor-4WTKRHQ, reason: not valid java name */
    public static final void m2683setNativeColor4WTKRHQ(@NotNull Paint paint, long j) {
        Intrinsics.checkNotNullParameter(paint, "$this$setNativeColor");
        paint.setColor(ColorKt.m2841toArgb8_81llA(j));
    }

    public static final void setNativeColorFilter(@NotNull Paint paint, @Nullable ColorFilter colorFilter) {
        Intrinsics.checkNotNullParameter(paint, "<this>");
        paint.setColorFilter(colorFilter != null ? AndroidColorFilter_androidKt.asAndroidColorFilter(colorFilter) : null);
    }

    /* renamed from: setNativeFilterQuality-50PEsBU, reason: not valid java name */
    public static final void m2684setNativeFilterQuality50PEsBU(@NotNull Paint paint, int i) {
        Intrinsics.checkNotNullParameter(paint, "$this$setNativeFilterQuality");
        paint.setFilterBitmap(!FilterQuality.m2877equalsimpl0(i, FilterQuality.Companion.m2884getNonefv9h1I()));
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
    public static final void m2685setNativeStrokeCapCSYIeUk(@NotNull Paint paint, int i) {
        Intrinsics.checkNotNullParameter(paint, "$this$setNativeStrokeCap");
        StrokeCap.Companion companion = StrokeCap.Companion;
        paint.setStrokeCap(StrokeCap.m3088equalsimpl0(i, companion.m3094getSquareKaPHkGw()) ? Paint.Cap.SQUARE : StrokeCap.m3088equalsimpl0(i, companion.m3093getRoundKaPHkGw()) ? Paint.Cap.ROUND : StrokeCap.m3088equalsimpl0(i, companion.m3092getButtKaPHkGw()) ? Paint.Cap.BUTT : Paint.Cap.BUTT);
    }

    /* renamed from: setNativeStrokeJoin-kLtJ_vA, reason: not valid java name */
    public static final void m2686setNativeStrokeJoinkLtJ_vA(@NotNull Paint paint, int i) {
        Intrinsics.checkNotNullParameter(paint, "$this$setNativeStrokeJoin");
        StrokeJoin.Companion companion = StrokeJoin.Companion;
        paint.setStrokeJoin(StrokeJoin.m3098equalsimpl0(i, companion.m3103getMiterLxFBmk8()) ? Paint.Join.MITER : StrokeJoin.m3098equalsimpl0(i, companion.m3102getBevelLxFBmk8()) ? Paint.Join.BEVEL : StrokeJoin.m3098equalsimpl0(i, companion.m3104getRoundLxFBmk8()) ? Paint.Join.ROUND : Paint.Join.MITER);
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
    public static final void m2687setNativeStyle5YerkU(@NotNull Paint paint, int i) {
        Intrinsics.checkNotNullParameter(paint, "$this$setNativeStyle");
        paint.setStyle(PaintingStyle.m3014equalsimpl0(i, PaintingStyle.Companion.m3019getStrokeTiuSbCo()) ? Paint.Style.STROKE : Paint.Style.FILL);
    }

    @NotNull
    public static final Paint toComposePaint(@NotNull Paint paint) {
        Intrinsics.checkNotNullParameter(paint, "<this>");
        return new AndroidPaint(paint);
    }
}
