package androidx.compose.animation.core;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
final class VectorConvertersKt$IntToVector$2 extends Lambda implements Function1<AnimationVector1D, Integer> {
    public static final VectorConvertersKt$IntToVector$2 INSTANCE = new VectorConvertersKt$IntToVector$2();

    VectorConvertersKt$IntToVector$2() {
        super(1);
    }

    @NotNull
    public final Integer invoke(@NotNull AnimationVector1D animationVector1D) {
        Intrinsics.checkNotNullParameter(animationVector1D, "it");
        return Integer.valueOf((int) animationVector1D.getValue());
    }
}
