package androidx.compose.animation;

import androidx.compose.animation.core.AnimationVector4D;
import androidx.compose.animation.core.TwoWayConverter;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.p004ui.graphics.Color;
import androidx.compose.p004ui.graphics.ColorKt;
import androidx.compose.p004ui.graphics.colorspace.ColorSpace;
import androidx.compose.p004ui.graphics.colorspace.ColorSpaces;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public final class ColorVectorConverterKt {

    @NotNull
    private static final Function1<ColorSpace, TwoWayConverter<Color, AnimationVector4D>> ColorToVector = new Function1<ColorSpace, TwoWayConverter<Color, AnimationVector4D>>() { // from class: androidx.compose.animation.ColorVectorConverterKt$ColorToVector$1
        @NotNull
        public final TwoWayConverter<Color, AnimationVector4D> invoke(@NotNull final ColorSpace colorSpace) {
            Intrinsics.checkNotNullParameter(colorSpace, "colorSpace");
            return VectorConvertersKt.TwoWayConverter(new Function1<Color, AnimationVector4D>() { // from class: androidx.compose.animation.ColorVectorConverterKt$ColorToVector$1.1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    return m976invoke8_81llA(((Color) obj).m2797unboximpl());
                }

                @NotNull
                /* renamed from: invoke-8_81llA, reason: not valid java name */
                public final AnimationVector4D m976invoke8_81llA(long j) {
                    float[] fArr;
                    float multiplyColumn;
                    float[] fArr2;
                    float multiplyColumn2;
                    float[] fArr3;
                    float multiplyColumn3;
                    long m2784convertvNxB06k = Color.m2784convertvNxB06k(j, ColorSpaces.INSTANCE.getCieXyz());
                    float m2793getRedimpl = Color.m2793getRedimpl(m2784convertvNxB06k);
                    float m2792getGreenimpl = Color.m2792getGreenimpl(m2784convertvNxB06k);
                    float m2790getBlueimpl = Color.m2790getBlueimpl(m2784convertvNxB06k);
                    fArr = ColorVectorConverterKt.f62M1;
                    multiplyColumn = ColorVectorConverterKt.multiplyColumn(0, m2793getRedimpl, m2792getGreenimpl, m2790getBlueimpl, fArr);
                    double d = 0.33333334f;
                    float pow = (float) Math.pow(multiplyColumn, d);
                    fArr2 = ColorVectorConverterKt.f62M1;
                    multiplyColumn2 = ColorVectorConverterKt.multiplyColumn(1, m2793getRedimpl, m2792getGreenimpl, m2790getBlueimpl, fArr2);
                    float pow2 = (float) Math.pow(multiplyColumn2, d);
                    fArr3 = ColorVectorConverterKt.f62M1;
                    multiplyColumn3 = ColorVectorConverterKt.multiplyColumn(2, m2793getRedimpl, m2792getGreenimpl, m2790getBlueimpl, fArr3);
                    return new AnimationVector4D(Color.m2789getAlphaimpl(j), pow, pow2, (float) Math.pow(multiplyColumn3, d));
                }
            }, new Function1<AnimationVector4D, Color>() { // from class: androidx.compose.animation.ColorVectorConverterKt$ColorToVector$1.2
                {
                    super(1);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    return Color.m2777boximpl(m977invokevNxB06k((AnimationVector4D) obj));
                }

                /* renamed from: invoke-vNxB06k, reason: not valid java name */
                public final long m977invokevNxB06k(@NotNull AnimationVector4D animationVector4D) {
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
                    return Color.m2784convertvNxB06k(ColorKt.Color(RangesKt.coerceIn(multiplyColumn, -2.0f, 2.0f), RangesKt.coerceIn(multiplyColumn2, -2.0f, 2.0f), RangesKt.coerceIn(multiplyColumn3, -2.0f, 2.0f), RangesKt.coerceIn(animationVector4D.getV1(), 0.0f, 1.0f), ColorSpaces.INSTANCE.getCieXyz()), ColorSpace.this);
                }
            });
        }
    };

    /* renamed from: M1 */
    @NotNull
    private static final float[] f62M1 = {0.80405736f, 0.026893456f, 0.04586542f, 0.3188387f, 0.9319606f, 0.26299807f, -0.11419419f, 0.05105356f, 0.83999807f};

    @NotNull
    private static final float[] InverseM1 = {1.2485008f, -0.032856926f, -0.057883114f, -0.48331892f, 1.1044513f, -0.3194066f, 0.19910365f, -0.07159331f, 1.202023f};

    @NotNull
    public static final Function1<ColorSpace, TwoWayConverter<Color, AnimationVector4D>> getVectorConverter(@NotNull Color.Companion companion) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        return ColorToVector;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float multiplyColumn(int i, float f, float f2, float f3, float[] fArr) {
        return (f * fArr[i]) + (f2 * fArr[i + 3]) + (f3 * fArr[i + 6]);
    }
}
