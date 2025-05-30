package androidx.compose.animation;

import androidx.compose.animation.core.AnimationVector4D;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.colorspace.ColorSpace;
import androidx.compose.ui.graphics.colorspace.ColorSpaces;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class ColorVectorConverterKt$ColorToVector$1$2 extends Lambda implements Function1<AnimationVector4D, Color> {
    final /* synthetic */ ColorSpace $colorSpace;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ColorVectorConverterKt$ColorToVector$1$2(ColorSpace colorSpace) {
        super(1);
        this.$colorSpace = colorSpace;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return Color.box-impl(m41invokevNxB06k((AnimationVector4D) obj));
    }

    /* renamed from: invoke-vNxB06k, reason: not valid java name */
    public final long m41invokevNxB06k(@NotNull AnimationVector4D animationVector4D) {
        float[] fArr;
        float multiplyColumn;
        float[] fArr2;
        float multiplyColumn2;
        float[] fArr3;
        float multiplyColumn3;
        Intrinsics.checkNotNullParameter(animationVector4D, "it");
        double d = 3.0f;
        float pow = (float) Math.pow(animationVector4D.getV2(), d);
        float pow2 = (float) Math.pow(animationVector4D.getV3(), d);
        float pow3 = (float) Math.pow(animationVector4D.getV4(), d);
        fArr = ColorVectorConverterKt.InverseM1;
        multiplyColumn = ColorVectorConverterKt.multiplyColumn(0, pow, pow2, pow3, fArr);
        fArr2 = ColorVectorConverterKt.InverseM1;
        multiplyColumn2 = ColorVectorConverterKt.multiplyColumn(1, pow, pow2, pow3, fArr2);
        fArr3 = ColorVectorConverterKt.InverseM1;
        multiplyColumn3 = ColorVectorConverterKt.multiplyColumn(2, pow, pow2, pow3, fArr3);
        return Color.convert-vNxB06k(ColorKt.Color(RangesKt.coerceIn(multiplyColumn, -2.0f, 2.0f), RangesKt.coerceIn(multiplyColumn2, -2.0f, 2.0f), RangesKt.coerceIn(multiplyColumn3, -2.0f, 2.0f), RangesKt.coerceIn(animationVector4D.getV1(), 0.0f, 1.0f), ColorSpaces.INSTANCE.getCieXyz()), this.$colorSpace);
    }
}
