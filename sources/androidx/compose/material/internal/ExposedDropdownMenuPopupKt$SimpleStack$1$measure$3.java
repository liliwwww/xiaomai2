package androidx.compose.material.internal;

import androidx.compose.ui.layout.Placeable;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class ExposedDropdownMenuPopupKt$SimpleStack$1$measure$3 extends Lambda implements Function1<Placeable.PlacementScope, Unit> {
    final /* synthetic */ List<Placeable> $placeables;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ExposedDropdownMenuPopupKt$SimpleStack$1$measure$3(List<? extends Placeable> list) {
        super(1);
        this.$placeables = list;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Placeable.PlacementScope) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull Placeable.PlacementScope placementScope) {
        Intrinsics.checkNotNullParameter(placementScope, "$this$layout");
        int lastIndex = CollectionsKt.getLastIndex(this.$placeables);
        if (lastIndex < 0) {
            return;
        }
        int i = 0;
        while (true) {
            Placeable.PlacementScope.placeRelative$default(placementScope, this.$placeables.get(i), 0, 0, 0.0f, 4, (Object) null);
            if (i == lastIndex) {
                return;
            } else {
                i++;
            }
        }
    }
}
