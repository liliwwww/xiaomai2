package androidx.compose.animation;

import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class EnterExitTransitionKt$shrinkHorizontally$2 extends Lambda implements Function1<IntSize, IntSize> {
    final /* synthetic */ Function1<Integer, Integer> $targetWidth;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    EnterExitTransitionKt$shrinkHorizontally$2(Function1<? super Integer, Integer> function1) {
        super(1);
        this.$targetWidth = function1;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return IntSize.m2677boximpl(m45invokemzRDjE0(((IntSize) obj).m2689unboximpl()));
    }

    /* renamed from: invoke-mzRDjE0, reason: not valid java name */
    public final long m45invokemzRDjE0(long j) {
        return IntSizeKt.IntSize(((Number) this.$targetWidth.invoke(Integer.valueOf(IntSize.m2685getWidthimpl(j)))).intValue(), IntSize.m2684getHeightimpl(j));
    }
}
