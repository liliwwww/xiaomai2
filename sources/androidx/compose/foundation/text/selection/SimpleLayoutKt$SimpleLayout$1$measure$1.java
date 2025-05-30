package androidx.compose.foundation.text.selection;

import androidx.compose.ui.layout.Placeable;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
final class SimpleLayoutKt$SimpleLayout$1$measure$1 extends Lambda implements Function1<Placeable.PlacementScope, Unit> {
    final /* synthetic */ List<Placeable> $placeables;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    SimpleLayoutKt$SimpleLayout$1$measure$1(List<? extends Placeable> list) {
        super(1);
        this.$placeables = list;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Placeable.PlacementScope) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull Placeable.PlacementScope placementScope) {
        Intrinsics.checkNotNullParameter(placementScope, "$this$layout");
        List<Placeable> list = this.$placeables;
        int size = list.size();
        for (int i = 0; i < size; i++) {
            Placeable.PlacementScope.place$default(placementScope, list.get(i), 0, 0, 0.0f, 4, (Object) null);
        }
    }
}
