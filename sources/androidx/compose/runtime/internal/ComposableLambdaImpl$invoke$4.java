package androidx.compose.runtime.internal;

import androidx.compose.runtime.Composer;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class ComposableLambdaImpl$invoke$4 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $changed;
    final /* synthetic */ Object $p1;
    final /* synthetic */ Object $p2;
    final /* synthetic */ Object $p3;
    final /* synthetic */ Object $p4;
    final /* synthetic */ ComposableLambdaImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ComposableLambdaImpl$invoke$4(ComposableLambdaImpl composableLambdaImpl, Object obj, Object obj2, Object obj3, Object obj4, int i) {
        super(2);
        this.this$0 = composableLambdaImpl;
        this.$p1 = obj;
        this.$p2 = obj2;
        this.$p3 = obj3;
        this.$p4 = obj4;
        this.$changed = i;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull Composer composer, int i) {
        Intrinsics.checkNotNullParameter(composer, "nc");
        this.this$0.invoke(this.$p1, this.$p2, this.$p3, this.$p4, composer, this.$changed | 1);
    }
}
