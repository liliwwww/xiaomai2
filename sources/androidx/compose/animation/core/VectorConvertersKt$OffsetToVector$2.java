package androidx.compose.animation.core;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
final class VectorConvertersKt$OffsetToVector$2 extends Lambda implements Function1<AnimationVector2D, Offset> {
    public static final VectorConvertersKt$OffsetToVector$2 INSTANCE = new VectorConvertersKt$OffsetToVector$2();

    VectorConvertersKt$OffsetToVector$2() {
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return Offset.m837boximpl(m107invoketuRUvjQ((AnimationVector2D) obj));
    }

    /* renamed from: invoke-tuRUvjQ, reason: not valid java name */
    public final long m107invoketuRUvjQ(@NotNull AnimationVector2D animationVector2D) {
        Intrinsics.checkNotNullParameter(animationVector2D, "it");
        return OffsetKt.Offset(animationVector2D.getV1(), animationVector2D.getV2());
    }
}
