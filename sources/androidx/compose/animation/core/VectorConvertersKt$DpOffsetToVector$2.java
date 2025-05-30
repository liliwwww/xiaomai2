package androidx.compose.animation.core;

import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.DpKt;
import androidx.compose.ui.unit.DpOffset;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
final class VectorConvertersKt$DpOffsetToVector$2 extends Lambda implements Function1<AnimationVector2D, DpOffset> {
    public static final VectorConvertersKt$DpOffsetToVector$2 INSTANCE = new VectorConvertersKt$DpOffsetToVector$2();

    VectorConvertersKt$DpOffsetToVector$2() {
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return DpOffset.box-impl(m103invokegVRvYmI((AnimationVector2D) obj));
    }

    /* renamed from: invoke-gVRvYmI, reason: not valid java name */
    public final long m103invokegVRvYmI(@NotNull AnimationVector2D animationVector2D) {
        Intrinsics.checkNotNullParameter(animationVector2D, "it");
        return DpKt.DpOffset-YgX7TsA(Dp.m2142constructorimpl(animationVector2D.getV1()), Dp.m2142constructorimpl(animationVector2D.getV2()));
    }
}
