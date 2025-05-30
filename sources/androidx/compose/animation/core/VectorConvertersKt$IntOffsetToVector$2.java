package androidx.compose.animation.core;

import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.math.MathKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
final class VectorConvertersKt$IntOffsetToVector$2 extends Lambda implements Function1<AnimationVector2D, IntOffset> {
    public static final VectorConvertersKt$IntOffsetToVector$2 INSTANCE = new VectorConvertersKt$IntOffsetToVector$2();

    VectorConvertersKt$IntOffsetToVector$2() {
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return IntOffset.box-impl(m105invokeBjo55l4((AnimationVector2D) obj));
    }

    /* renamed from: invoke-Bjo55l4, reason: not valid java name */
    public final long m105invokeBjo55l4(@NotNull AnimationVector2D animationVector2D) {
        Intrinsics.checkNotNullParameter(animationVector2D, "it");
        return IntOffsetKt.IntOffset(MathKt.roundToInt(animationVector2D.getV1()), MathKt.roundToInt(animationVector2D.getV2()));
    }
}
