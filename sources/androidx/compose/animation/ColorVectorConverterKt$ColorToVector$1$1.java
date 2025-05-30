package androidx.compose.animation;

import androidx.compose.animation.core.AnimationVector4D;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.colorspace.ColorSpaces;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class ColorVectorConverterKt$ColorToVector$1$1 extends Lambda implements Function1<Color, AnimationVector4D> {
    public static final ColorVectorConverterKt$ColorToVector$1$1 INSTANCE = new ColorVectorConverterKt$ColorToVector$1$1();

    ColorVectorConverterKt$ColorToVector$1$1() {
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return m40invoke8_81llA(((Color) obj).unbox-impl());
    }

    @NotNull
    /* renamed from: invoke-8_81llA, reason: not valid java name */
    public final AnimationVector4D m40invoke8_81llA(long j) {
        float[] fArr;
        float multiplyColumn;
        float[] fArr2;
        float multiplyColumn2;
        float[] fArr3;
        float multiplyColumn3;
        long j2 = Color.convert-vNxB06k(j, ColorSpaces.INSTANCE.getCieXyz());
        float f = Color.getRed-impl(j2);
        float f2 = Color.getGreen-impl(j2);
        float f3 = Color.getBlue-impl(j2);
        fArr = ColorVectorConverterKt.M1;
        multiplyColumn = ColorVectorConverterKt.multiplyColumn(0, f, f2, f3, fArr);
        double d = 0.33333334f;
        float pow = (float) Math.pow(multiplyColumn, d);
        fArr2 = ColorVectorConverterKt.M1;
        multiplyColumn2 = ColorVectorConverterKt.multiplyColumn(1, f, f2, f3, fArr2);
        float pow2 = (float) Math.pow(multiplyColumn2, d);
        fArr3 = ColorVectorConverterKt.M1;
        multiplyColumn3 = ColorVectorConverterKt.multiplyColumn(2, f, f2, f3, fArr3);
        return new AnimationVector4D(Color.getAlpha-impl(j), pow, pow2, (float) Math.pow(multiplyColumn3, d));
    }
}
