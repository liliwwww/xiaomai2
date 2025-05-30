package androidx.compose.foundation.lazy.staggeredgrid;

import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
/* synthetic */ class LazyStaggeredGridState$scrollPosition$1 extends FunctionReferenceImpl implements Function2<Integer, Integer, int[]> {
    LazyStaggeredGridState$scrollPosition$1(Object obj) {
        super(2, obj, LazyStaggeredGridState.class, "fillNearestIndices", "fillNearestIndices(II)[I", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return invoke(((Number) obj).intValue(), ((Number) obj2).intValue());
    }

    @NotNull
    public final int[] invoke(int i, int i2) {
        return LazyStaggeredGridState.access$fillNearestIndices((LazyStaggeredGridState) ((CallableReference) this).receiver, i, i2);
    }
}
