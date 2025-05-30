package androidx.compose.foundation.layout;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.MeasureScope$CC;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.Placeable$PlacementScope;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class FlowLayoutKt$flowMeasurePolicy$1 implements MeasurePolicy {
    final /* synthetic */ float $arrangementSpacing;
    final /* synthetic */ CrossAxisAlignment $crossAxisAlignment;
    final /* synthetic */ Function4<Integer, int[], MeasureScope, int[], Unit> $crossAxisArrangement;
    final /* synthetic */ SizeMode $crossAxisSize;
    final /* synthetic */ Function5<Integer, int[], LayoutDirection, Density, int[], Unit> $mainAxisArrangement;
    final /* synthetic */ int $maxItemsInMainAxis;
    final /* synthetic */ LayoutOrientation $orientation;

    @NotNull
    private final Function3<IntrinsicMeasurable, Integer, Integer, Integer> maxCrossAxisIntrinsicItemSize;

    @NotNull
    private final Function3<IntrinsicMeasurable, Integer, Integer, Integer> maxMainAxisIntrinsicItemSize;

    @NotNull
    private final Function3<IntrinsicMeasurable, Integer, Integer, Integer> minCrossAxisIntrinsicItemSize;

    @NotNull
    private final Function3<IntrinsicMeasurable, Integer, Integer, Integer> minMainAxisIntrinsicItemSize;

    /* JADX WARN: Multi-variable type inference failed */
    FlowLayoutKt$flowMeasurePolicy$1(LayoutOrientation layoutOrientation, Function5<? super Integer, ? super int[], ? super LayoutDirection, ? super Density, ? super int[], Unit> function5, float f, SizeMode sizeMode, CrossAxisAlignment crossAxisAlignment, int i, Function4<? super Integer, ? super int[], ? super MeasureScope, ? super int[], Unit> function4) {
        this.$orientation = layoutOrientation;
        this.$mainAxisArrangement = function5;
        this.$arrangementSpacing = f;
        this.$crossAxisSize = sizeMode;
        this.$crossAxisAlignment = crossAxisAlignment;
        this.$maxItemsInMainAxis = i;
        this.$crossAxisArrangement = function4;
        LayoutOrientation layoutOrientation2 = LayoutOrientation.Horizontal;
        this.maxMainAxisIntrinsicItemSize = layoutOrientation == layoutOrientation2 ? new Function3<IntrinsicMeasurable, Integer, Integer, Integer>() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$flowMeasurePolicy$1$maxMainAxisIntrinsicItemSize$1
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                return invoke((IntrinsicMeasurable) obj, ((Number) obj2).intValue(), ((Number) obj3).intValue());
            }

            @NotNull
            public final Integer invoke(@NotNull IntrinsicMeasurable intrinsicMeasurable, int i2, int i3) {
                Intrinsics.checkNotNullParameter(intrinsicMeasurable, "$this$null");
                return Integer.valueOf(intrinsicMeasurable.maxIntrinsicWidth(i3));
            }
        } : new Function3<IntrinsicMeasurable, Integer, Integer, Integer>() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$flowMeasurePolicy$1$maxMainAxisIntrinsicItemSize$2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                return invoke((IntrinsicMeasurable) obj, ((Number) obj2).intValue(), ((Number) obj3).intValue());
            }

            @NotNull
            public final Integer invoke(@NotNull IntrinsicMeasurable intrinsicMeasurable, int i2, int i3) {
                Intrinsics.checkNotNullParameter(intrinsicMeasurable, "$this$null");
                return Integer.valueOf(intrinsicMeasurable.maxIntrinsicHeight(i3));
            }
        };
        this.maxCrossAxisIntrinsicItemSize = layoutOrientation == layoutOrientation2 ? new Function3<IntrinsicMeasurable, Integer, Integer, Integer>() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$flowMeasurePolicy$1$maxCrossAxisIntrinsicItemSize$1
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                return invoke((IntrinsicMeasurable) obj, ((Number) obj2).intValue(), ((Number) obj3).intValue());
            }

            @NotNull
            public final Integer invoke(@NotNull IntrinsicMeasurable intrinsicMeasurable, int i2, int i3) {
                Intrinsics.checkNotNullParameter(intrinsicMeasurable, "$this$null");
                return Integer.valueOf(intrinsicMeasurable.maxIntrinsicHeight(i3));
            }
        } : new Function3<IntrinsicMeasurable, Integer, Integer, Integer>() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$flowMeasurePolicy$1$maxCrossAxisIntrinsicItemSize$2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                return invoke((IntrinsicMeasurable) obj, ((Number) obj2).intValue(), ((Number) obj3).intValue());
            }

            @NotNull
            public final Integer invoke(@NotNull IntrinsicMeasurable intrinsicMeasurable, int i2, int i3) {
                Intrinsics.checkNotNullParameter(intrinsicMeasurable, "$this$null");
                return Integer.valueOf(intrinsicMeasurable.maxIntrinsicWidth(i3));
            }
        };
        this.minCrossAxisIntrinsicItemSize = layoutOrientation == layoutOrientation2 ? minCrossAxisIntrinsicItemSize.1.INSTANCE : minCrossAxisIntrinsicItemSize.2.INSTANCE;
        this.minMainAxisIntrinsicItemSize = layoutOrientation == layoutOrientation2 ? minMainAxisIntrinsicItemSize.1.INSTANCE : minMainAxisIntrinsicItemSize.2.INSTANCE;
    }

    @NotNull
    public final Function3<IntrinsicMeasurable, Integer, Integer, Integer> getMaxCrossAxisIntrinsicItemSize() {
        return this.maxCrossAxisIntrinsicItemSize;
    }

    @NotNull
    public final Function3<IntrinsicMeasurable, Integer, Integer, Integer> getMaxMainAxisIntrinsicItemSize() {
        return this.maxMainAxisIntrinsicItemSize;
    }

    @NotNull
    public final Function3<IntrinsicMeasurable, Integer, Integer, Integer> getMinCrossAxisIntrinsicItemSize() {
        return this.minCrossAxisIntrinsicItemSize;
    }

    @NotNull
    public final Function3<IntrinsicMeasurable, Integer, Integer, Integer> getMinMainAxisIntrinsicItemSize() {
        return this.minMainAxisIntrinsicItemSize;
    }

    public final int intrinsicCrossAxisSize(@NotNull List<? extends IntrinsicMeasurable> list, int i, int i2) {
        Intrinsics.checkNotNullParameter(list, "measurables");
        return FlowLayoutKt.access$intrinsicCrossAxisSize(list, this.minMainAxisIntrinsicItemSize, this.minCrossAxisIntrinsicItemSize, i, i2, this.$maxItemsInMainAxis);
    }

    public int maxIntrinsicHeight(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull List<? extends IntrinsicMeasurable> list, int i) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        Intrinsics.checkNotNullParameter(list, "measurables");
        return this.$orientation == LayoutOrientation.Horizontal ? intrinsicCrossAxisSize(list, i, intrinsicMeasureScope.roundToPx-0680j_4(this.$arrangementSpacing)) : maxIntrinsicMainAxisSize(list, i, intrinsicMeasureScope.roundToPx-0680j_4(this.$arrangementSpacing));
    }

    public final int maxIntrinsicMainAxisSize(@NotNull List<? extends IntrinsicMeasurable> list, int i, int i2) {
        Intrinsics.checkNotNullParameter(list, "measurables");
        return FlowLayoutKt.access$maxIntrinsicMainAxisSize(list, this.maxMainAxisIntrinsicItemSize, i, i2, this.$maxItemsInMainAxis);
    }

    public int maxIntrinsicWidth(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull List<? extends IntrinsicMeasurable> list, int i) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        Intrinsics.checkNotNullParameter(list, "measurables");
        return this.$orientation == LayoutOrientation.Horizontal ? maxIntrinsicMainAxisSize(list, i, intrinsicMeasureScope.roundToPx-0680j_4(this.$arrangementSpacing)) : intrinsicCrossAxisSize(list, i, intrinsicMeasureScope.roundToPx-0680j_4(this.$arrangementSpacing));
    }

    @NotNull
    /* renamed from: measure-3p2s80s, reason: not valid java name */
    public MeasureResult m313measure3p2s80s(@NotNull final MeasureScope measureScope, @NotNull List<? extends Measurable> list, long j) {
        int crossAxisTotalSize;
        int mainAxisTotalSize;
        Intrinsics.checkNotNullParameter(measureScope, "$this$measure");
        Intrinsics.checkNotNullParameter(list, "measurables");
        final RowColumnMeasurementHelper rowColumnMeasurementHelper = new RowColumnMeasurementHelper(this.$orientation, this.$mainAxisArrangement, this.$arrangementSpacing, this.$crossAxisSize, this.$crossAxisAlignment, list, new Placeable[list.size()], (DefaultConstructorMarker) null);
        final FlowResult breakDownItems = FlowLayoutKt.breakDownItems(measureScope, rowColumnMeasurementHelper, this.$orientation, new OrientationIndependentConstraints(j, this.$orientation, (DefaultConstructorMarker) null), this.$maxItemsInMainAxis);
        int crossAxisTotalSize2 = breakDownItems.getCrossAxisTotalSize();
        MutableVector items = breakDownItems.getItems();
        int size = items.getSize();
        int[] iArr = new int[size];
        for (int i = 0; i < size; i++) {
            iArr[i] = ((RowColumnMeasureHelperResult) items.getContent()[i]).getCrossAxisSize();
        }
        final int[] iArr2 = new int[size];
        this.$crossAxisArrangement.invoke(Integer.valueOf(crossAxisTotalSize2), iArr, measureScope, iArr2);
        if (this.$orientation == LayoutOrientation.Horizontal) {
            crossAxisTotalSize = breakDownItems.getMainAxisTotalSize();
            mainAxisTotalSize = breakDownItems.getCrossAxisTotalSize();
        } else {
            crossAxisTotalSize = breakDownItems.getCrossAxisTotalSize();
            mainAxisTotalSize = breakDownItems.getMainAxisTotalSize();
        }
        return MeasureScope$CC.p(measureScope, ConstraintsKt.constrainWidth-K40F9xA(j, crossAxisTotalSize), ConstraintsKt.constrainHeight-K40F9xA(j, mainAxisTotalSize), null, new Function1<Placeable$PlacementScope, Unit>() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$flowMeasurePolicy$1$measure$1
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
                MutableVector items2 = breakDownItems.getItems();
                RowColumnMeasurementHelper rowColumnMeasurementHelper2 = rowColumnMeasurementHelper;
                int[] iArr3 = iArr2;
                MeasureScope measureScope2 = measureScope;
                int size2 = items2.getSize();
                if (size2 > 0) {
                    int i2 = 0;
                    Object[] content = items2.getContent();
                    do {
                        rowColumnMeasurementHelper2.placeHelper(placeable$PlacementScope, (RowColumnMeasureHelperResult) content[i2], iArr3[i2], measureScope2.getLayoutDirection());
                        i2++;
                    } while (i2 < size2);
                }
            }
        }, 4, null);
    }

    public int minIntrinsicHeight(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull List<? extends IntrinsicMeasurable> list, int i) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        Intrinsics.checkNotNullParameter(list, "measurables");
        return this.$orientation == LayoutOrientation.Horizontal ? intrinsicCrossAxisSize(list, i, intrinsicMeasureScope.roundToPx-0680j_4(this.$arrangementSpacing)) : minIntrinsicMainAxisSize(list, i, intrinsicMeasureScope.roundToPx-0680j_4(this.$arrangementSpacing));
    }

    public final int minIntrinsicMainAxisSize(@NotNull List<? extends IntrinsicMeasurable> list, int i, int i2) {
        Intrinsics.checkNotNullParameter(list, "measurables");
        return FlowLayoutKt.access$minIntrinsicMainAxisSize(list, this.minMainAxisIntrinsicItemSize, this.minCrossAxisIntrinsicItemSize, i, i2, this.$maxItemsInMainAxis);
    }

    public int minIntrinsicWidth(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull List<? extends IntrinsicMeasurable> list, int i) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        Intrinsics.checkNotNullParameter(list, "measurables");
        return this.$orientation == LayoutOrientation.Horizontal ? minIntrinsicMainAxisSize(list, i, intrinsicMeasureScope.roundToPx-0680j_4(this.$arrangementSpacing)) : intrinsicCrossAxisSize(list, i, intrinsicMeasureScope.roundToPx-0680j_4(this.$arrangementSpacing));
    }
}
