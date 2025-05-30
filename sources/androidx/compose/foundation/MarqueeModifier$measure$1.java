package androidx.compose.foundation;

import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.Placeable$PlacementScope;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.math.MathKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class MarqueeModifier$measure$1 extends Lambda implements Function1<Placeable$PlacementScope, Unit> {
    final /* synthetic */ Placeable $placeable;
    final /* synthetic */ MarqueeModifier this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    MarqueeModifier$measure$1(Placeable placeable, MarqueeModifier marqueeModifier) {
        super(1);
        this.$placeable = placeable;
        this.this$0 = marqueeModifier;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Placeable$PlacementScope) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull Placeable$PlacementScope placeable$PlacementScope) {
        Intrinsics.checkNotNullParameter(placeable$PlacementScope, "$this$layout");
        Placeable$PlacementScope.placeWithLayer$default(placeable$PlacementScope, this.$placeable, MathKt.roundToInt((-((Number) MarqueeModifier.access$getOffset$p(this.this$0).getValue()).floatValue()) * MarqueeModifier.access$getDirection$p(this.this$0)), 0, 0.0f, null, 12, null);
    }
}
