package androidx.compose.animation.core;

import androidx.compose.ui.geometry.Offset;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
final class VectorConvertersKt$OffsetToVector$1 extends Lambda implements Function1<Offset, AnimationVector2D> {
    public static final VectorConvertersKt$OffsetToVector$1 INSTANCE = new VectorConvertersKt$OffsetToVector$1();

    VectorConvertersKt$OffsetToVector$1() {
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return m106invokek4lQ0M(((Offset) obj).m858unboximpl());
    }

    @NotNull
    /* renamed from: invoke-k-4lQ0M, reason: not valid java name */
    public final AnimationVector2D m106invokek4lQ0M(long j) {
        return new AnimationVector2D(Offset.m848getXimpl(j), Offset.m849getYimpl(j));
    }
}
