package androidx.compose.runtime.internal;

import androidx.compose.runtime.Composer;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class ComposableLambdaImpl$invoke$17 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $changed;
    final /* synthetic */ int $changed1;
    final /* synthetic */ Object $p1;
    final /* synthetic */ Object $p10;
    final /* synthetic */ Object $p11;
    final /* synthetic */ Object $p12;
    final /* synthetic */ Object $p13;
    final /* synthetic */ Object $p14;
    final /* synthetic */ Object $p15;
    final /* synthetic */ Object $p16;
    final /* synthetic */ Object $p17;
    final /* synthetic */ Object $p2;
    final /* synthetic */ Object $p3;
    final /* synthetic */ Object $p4;
    final /* synthetic */ Object $p5;
    final /* synthetic */ Object $p6;
    final /* synthetic */ Object $p7;
    final /* synthetic */ Object $p8;
    final /* synthetic */ Object $p9;
    final /* synthetic */ ComposableLambdaImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ComposableLambdaImpl$invoke$17(ComposableLambdaImpl composableLambdaImpl, Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10, Object obj11, Object obj12, Object obj13, Object obj14, Object obj15, Object obj16, Object obj17, int i, int i2) {
        super(2);
        this.this$0 = composableLambdaImpl;
        this.$p1 = obj;
        this.$p2 = obj2;
        this.$p3 = obj3;
        this.$p4 = obj4;
        this.$p5 = obj5;
        this.$p6 = obj6;
        this.$p7 = obj7;
        this.$p8 = obj8;
        this.$p9 = obj9;
        this.$p10 = obj10;
        this.$p11 = obj11;
        this.$p12 = obj12;
        this.$p13 = obj13;
        this.$p14 = obj14;
        this.$p15 = obj15;
        this.$p16 = obj16;
        this.$p17 = obj17;
        this.$changed = i;
        this.$changed1 = i2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull Composer composer, int i) {
        Intrinsics.checkNotNullParameter(composer, "nc");
        this.this$0.invoke(this.$p1, this.$p2, this.$p3, this.$p4, this.$p5, this.$p6, this.$p7, this.$p8, this.$p9, this.$p10, this.$p11, this.$p12, this.$p13, this.$p14, this.$p15, this.$p16, this.$p17, composer, this.$changed | 1, this.$changed1);
    }
}
