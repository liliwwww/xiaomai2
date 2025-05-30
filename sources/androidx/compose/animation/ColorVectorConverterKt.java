package androidx.compose.animation;

import androidx.compose.animation.core.AnimationVector4D;
import androidx.compose.animation.core.TwoWayConverter;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Color$Companion;
import androidx.compose.ui.graphics.colorspace.ColorSpace;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class ColorVectorConverterKt {

    @NotNull
    private static final Function1<ColorSpace, TwoWayConverter<Color, AnimationVector4D>> ColorToVector = ColorToVector.1.INSTANCE;

    @NotNull
    private static final float[] M1 = {0.80405736f, 0.026893456f, 0.04586542f, 0.3188387f, 0.9319606f, 0.26299807f, -0.11419419f, 0.05105356f, 0.83999807f};

    @NotNull
    private static final float[] InverseM1 = {1.2485008f, -0.032856926f, -0.057883114f, -0.48331892f, 1.1044513f, -0.3194066f, 0.19910365f, -0.07159331f, 1.202023f};

    @NotNull
    public static final Function1<ColorSpace, TwoWayConverter<Color, AnimationVector4D>> getVectorConverter(@NotNull Color$Companion color$Companion) {
        Intrinsics.checkNotNullParameter(color$Companion, "<this>");
        return ColorToVector;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float multiplyColumn(int i, float f, float f2, float f3, float[] fArr) {
        return (f * fArr[i]) + (f2 * fArr[i + 3]) + (f3 * fArr[i + 6]);
    }
}
