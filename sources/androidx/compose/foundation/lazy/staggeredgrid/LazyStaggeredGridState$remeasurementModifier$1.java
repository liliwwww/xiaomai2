package androidx.compose.foundation.lazy.staggeredgrid;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.Remeasurement;
import androidx.compose.ui.layout.RemeasurementModifier;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tb.mt2;
import tb.nt2;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class LazyStaggeredGridState$remeasurementModifier$1 implements RemeasurementModifier {
    final /* synthetic */ LazyStaggeredGridState this$0;

    LazyStaggeredGridState$remeasurementModifier$1(LazyStaggeredGridState lazyStaggeredGridState) {
        this.this$0 = lazyStaggeredGridState;
    }

    public /* synthetic */ boolean all(Function1 function1) {
        return nt2.a(this, function1);
    }

    public /* synthetic */ boolean any(Function1 function1) {
        return nt2.b(this, function1);
    }

    public /* synthetic */ Object foldIn(Object obj, Function2 function2) {
        return nt2.c(this, obj, function2);
    }

    public /* synthetic */ Object foldOut(Object obj, Function2 function2) {
        return nt2.d(this, obj, function2);
    }

    public void onRemeasurementAvailable(@NotNull Remeasurement remeasurement) {
        Intrinsics.checkNotNullParameter(remeasurement, "remeasurement");
        LazyStaggeredGridState.access$setRemeasurement$p(this.this$0, remeasurement);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ Modifier then(Modifier modifier) {
        return mt2.a(this, modifier);
    }
}
