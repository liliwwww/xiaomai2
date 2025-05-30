package androidx.compose.material;

import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.Placeable$PlacementScope;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class ListItemKt$OffsetToBaselineOrCenter$1$measure$1 extends Lambda implements Function1<Placeable$PlacementScope, Unit> {
    final /* synthetic */ Placeable $placeable;
    final /* synthetic */ int $y;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ListItemKt$OffsetToBaselineOrCenter$1$measure$1(Placeable placeable, int i) {
        super(1);
        this.$placeable = placeable;
        this.$y = i;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Placeable$PlacementScope) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull Placeable$PlacementScope placeable$PlacementScope) {
        Intrinsics.checkNotNullParameter(placeable$PlacementScope, "$this$layout");
        Placeable$PlacementScope.placeRelative$default(placeable$PlacementScope, this.$placeable, 0, this.$y, 0.0f, 4, null);
    }
}
