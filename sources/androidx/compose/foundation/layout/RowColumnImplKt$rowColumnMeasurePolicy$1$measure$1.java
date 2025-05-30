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
final class RowColumnImplKt$rowColumnMeasurePolicy$1$measure$1 extends Lambda implements Function1<Placeable.PlacementScope, Unit> {
    final /* synthetic */ RowColumnMeasureHelperResult $measureResult;
    final /* synthetic */ RowColumnMeasurementHelper $rowColumnMeasureHelper;
    final /* synthetic */ MeasureScope $this_measure;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    RowColumnImplKt$rowColumnMeasurePolicy$1$measure$1(RowColumnMeasurementHelper rowColumnMeasurementHelper, RowColumnMeasureHelperResult rowColumnMeasureHelperResult, MeasureScope measureScope) {
        super(1);
        this.$rowColumnMeasureHelper = rowColumnMeasurementHelper;
        this.$measureResult = rowColumnMeasureHelperResult;
        this.$this_measure = measureScope;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Placeable.PlacementScope) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull Placeable.PlacementScope placementScope) {
        Intrinsics.checkNotNullParameter(placementScope, "$this$layout");
        this.$rowColumnMeasureHelper.placeHelper(placementScope, this.$measureResult, 0, this.$this_measure.getLayoutDirection());
    }
}
