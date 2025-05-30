package androidx.compose.animation;

import androidx.compose.animation.core.AnimationVector4D;
import androidx.compose.animation.core.TwoWayConverter;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.colorspace.ColorSpace;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
final class ColorVectorConverterKt$ColorToVector$1 extends Lambda implements Function1<ColorSpace, TwoWayConverter<Color, AnimationVector4D>> {
    public static final ColorVectorConverterKt$ColorToVector$1 INSTANCE = new ColorVectorConverterKt$ColorToVector$1();

    ColorVectorConverterKt$ColorToVector$1() {
        super(1);
    }

    @NotNull
    public final TwoWayConverter<Color, AnimationVector4D> invoke(@NotNull ColorSpace colorSpace) {
        Intrinsics.checkNotNullParameter(colorSpace, "colorSpace");
        return VectorConvertersKt.TwoWayConverter(1.INSTANCE, new 2(colorSpace));
    }
}
