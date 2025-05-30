package androidx.compose.foundation.layout;

import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
final class PaddingModifier$measure$1 extends Lambda implements Function1<Placeable.PlacementScope, Unit> {
    final /* synthetic */ Placeable $placeable;
    final /* synthetic */ MeasureScope $this_measure;
    final /* synthetic */ PaddingModifier this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PaddingModifier$measure$1(PaddingModifier paddingModifier, Placeable placeable, MeasureScope measureScope) {
        super(1);
        this.this$0 = paddingModifier;
        this.$placeable = placeable;
        this.$this_measure = measureScope;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Placeable.PlacementScope) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull Placeable.PlacementScope placementScope) {
        Intrinsics.checkNotNullParameter(placementScope, "$this$layout");
        if (this.this$0.getRtlAware()) {
            Placeable.PlacementScope.placeRelative$default(placementScope, this.$placeable, this.$this_measure.mo319roundToPx0680j_4(this.this$0.getStart-D9Ej5fM()), this.$this_measure.mo319roundToPx0680j_4(this.this$0.getTop-D9Ej5fM()), 0.0f, 4, (Object) null);
        } else {
            Placeable.PlacementScope.place$default(placementScope, this.$placeable, this.$this_measure.mo319roundToPx0680j_4(this.this$0.getStart-D9Ej5fM()), this.$this_measure.mo319roundToPx0680j_4(this.this$0.getTop-D9Ej5fM()), 0.0f, 4, (Object) null);
        }
    }
}
