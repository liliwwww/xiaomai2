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
final class SnackbarKt$OneRowSnackbar$2$measure$4 extends Lambda implements Function1<Placeable$PlacementScope, Unit> {
    final /* synthetic */ int $buttonPlaceX;
    final /* synthetic */ int $buttonPlaceY;
    final /* synthetic */ Placeable $buttonPlaceable;
    final /* synthetic */ int $textPlaceY;
    final /* synthetic */ Placeable $textPlaceable;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SnackbarKt$OneRowSnackbar$2$measure$4(Placeable placeable, int i, Placeable placeable2, int i2, int i3) {
        super(1);
        this.$textPlaceable = placeable;
        this.$textPlaceY = i;
        this.$buttonPlaceable = placeable2;
        this.$buttonPlaceX = i2;
        this.$buttonPlaceY = i3;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Placeable$PlacementScope) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull Placeable$PlacementScope placeable$PlacementScope) {
        Intrinsics.checkNotNullParameter(placeable$PlacementScope, "$this$layout");
        Placeable$PlacementScope.placeRelative$default(placeable$PlacementScope, this.$textPlaceable, 0, this.$textPlaceY, 0.0f, 4, null);
        Placeable$PlacementScope.placeRelative$default(placeable$PlacementScope, this.$buttonPlaceable, this.$buttonPlaceX, this.$buttonPlaceY, 0.0f, 4, null);
    }
}
