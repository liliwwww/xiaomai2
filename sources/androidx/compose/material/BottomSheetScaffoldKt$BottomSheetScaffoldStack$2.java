package androidx.compose.material;

import androidx.compose.runtime.State;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.MeasureScope$CC;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.Placeable$PlacementScope;
import androidx.compose.ui.unit.Constraints;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import org.jetbrains.annotations.NotNull;
import tb.on2;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class BottomSheetScaffoldKt$BottomSheetScaffoldStack$2 implements MeasurePolicy {
    final /* synthetic */ State<Float> $bottomSheetOffset;
    final /* synthetic */ int $floatingActionButtonPosition;

    BottomSheetScaffoldKt$BottomSheetScaffoldStack$2(State<Float> state, int i) {
        this.$bottomSheetOffset = state;
        this.$floatingActionButtonPosition = i;
    }

    public /* synthetic */ int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i) {
        return on2.a(this, intrinsicMeasureScope, list, i);
    }

    public /* synthetic */ int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i) {
        return on2.b(this, intrinsicMeasureScope, list, i);
    }

    @NotNull
    /* renamed from: measure-3p2s80s, reason: not valid java name */
    public final MeasureResult m678measure3p2s80s(@NotNull final MeasureScope measureScope, @NotNull final List<? extends Measurable> list, final long j) {
        Intrinsics.checkNotNullParameter(measureScope, "$this$Layout");
        Intrinsics.checkNotNullParameter(list, "measurables");
        final Placeable placeable = ((Measurable) CollectionsKt.first(list)).measure-BRTryo0(j);
        int width = placeable.getWidth();
        int height = placeable.getHeight();
        final State<Float> state = this.$bottomSheetOffset;
        final int i = this.$floatingActionButtonPosition;
        return MeasureScope$CC.p(measureScope, width, height, null, new Function1<Placeable$PlacementScope, Unit>() { // from class: androidx.compose.material.BottomSheetScaffoldKt$BottomSheetScaffoldStack$2$measure$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Placeable$PlacementScope) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull Placeable$PlacementScope placeable$PlacementScope) {
                Intrinsics.checkNotNullParameter(placeable$PlacementScope, "$this$layout");
                Placeable$PlacementScope.placeRelative$default(placeable$PlacementScope, placeable, 0, 0, 0.0f, 4, null);
                List drop = CollectionsKt.drop(list, 1);
                long j2 = j;
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(drop, 10));
                Iterator it = drop.iterator();
                while (it.hasNext()) {
                    arrayList.add(((Measurable) it.next()).measure-BRTryo0(Constraints.copy-Zbe2FdA$default(j2, 0, 0, 0, 0, 10, (Object) null)));
                }
                Placeable placeable2 = (Placeable) arrayList.get(0);
                Placeable placeable3 = (Placeable) arrayList.get(1);
                Placeable placeable4 = (Placeable) arrayList.get(2);
                int roundToInt = MathKt.roundToInt(state.getValue().floatValue());
                Placeable$PlacementScope.placeRelative$default(placeable$PlacementScope, placeable2, 0, roundToInt, 0.0f, 4, null);
                Placeable$PlacementScope.placeRelative$default(placeable$PlacementScope, placeable3, FabPosition.equals-impl0(i, FabPosition.Companion.m764getCenter5ygKITE()) ? (placeable.getWidth() - placeable3.getWidth()) / 2 : (placeable.getWidth() - placeable3.getWidth()) - measureScope.roundToPx-0680j_4(BottomSheetScaffoldKt.access$getFabEndSpacing$p()), roundToInt - (placeable3.getHeight() / 2), 0.0f, 4, null);
                Placeable$PlacementScope.placeRelative$default(placeable$PlacementScope, placeable4, (placeable.getWidth() - placeable4.getWidth()) / 2, placeable.getHeight() - placeable4.getHeight(), 0.0f, 4, null);
            }
        }, 4, null);
    }

    public /* synthetic */ int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i) {
        return on2.c(this, intrinsicMeasureScope, list, i);
    }

    public /* synthetic */ int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i) {
        return on2.d(this, intrinsicMeasureScope, list, i);
    }
}
