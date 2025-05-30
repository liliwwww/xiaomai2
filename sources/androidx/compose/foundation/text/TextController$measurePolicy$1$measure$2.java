package androidx.compose.foundation.text;

import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.IntOffset;
import java.util.List;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
final class TextController$measurePolicy$1$measure$2 extends Lambda implements Function1<Placeable.PlacementScope, Unit> {
    final /* synthetic */ List<Pair<Placeable, IntOffset>> $placeables;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    TextController$measurePolicy$1$measure$2(List<? extends Pair<? extends Placeable, IntOffset>> list) {
        super(1);
        this.$placeables = list;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Placeable.PlacementScope) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull Placeable.PlacementScope placementScope) {
        Intrinsics.checkNotNullParameter(placementScope, "$this$layout");
        List<Pair<Placeable, IntOffset>> list = this.$placeables;
        int size = list.size();
        for (int i = 0; i < size; i++) {
            Pair<Placeable, IntOffset> pair = list.get(i);
            Placeable.PlacementScope.place-70tqf50$default(placementScope, (Placeable) pair.component1(), ((IntOffset) pair.component2()).unbox-impl(), 0.0f, 2, (Object) null);
        }
    }
}
