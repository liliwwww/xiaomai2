package androidx.compose.material;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tb.on2;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
final class NavigationRailKt$NavigationRailItemBaselineLayout$2 implements MeasurePolicy {
    final /* synthetic */ float $iconPositionAnimationProgress;
    final /* synthetic */ Function2<Composer, Integer, Unit> $label;

    /* JADX WARN: Multi-variable type inference failed */
    NavigationRailKt$NavigationRailItemBaselineLayout$2(Function2<? super Composer, ? super Integer, Unit> function2, float f) {
        this.$label = function2;
        this.$iconPositionAnimationProgress = f;
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public /* synthetic */ int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i) {
        return on2.a(this, intrinsicMeasureScope, list, i);
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public /* synthetic */ int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i) {
        return on2.b(this, intrinsicMeasureScope, list, i);
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    @NotNull
    /* renamed from: measure-3p2s80s */
    public final MeasureResult mo16measure3p2s80s(@NotNull MeasureScope measureScope, @NotNull List<? extends Measurable> list, long j) {
        Placeable placeable;
        Intrinsics.checkNotNullParameter(measureScope, "$this$Layout");
        Intrinsics.checkNotNullParameter(list, "measurables");
        for (Measurable measurable : list) {
            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable), "icon")) {
                Placeable mo1521measureBRTryo0 = measurable.mo1521measureBRTryo0(j);
                if (this.$label != null) {
                    for (Measurable measurable2 : list) {
                        if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable2), "label")) {
                            placeable = measurable2.mo1521measureBRTryo0(Constraints.m2113copyZbe2FdA$default(j, 0, 0, 0, 0, 11, null));
                        }
                    }
                    throw new NoSuchElementException("Collection contains no element matching the predicate.");
                }
                placeable = null;
                if (this.$label == null) {
                    return NavigationRailKt.access$placeIcon-3p2s80s(measureScope, mo1521measureBRTryo0, j);
                }
                Intrinsics.checkNotNull(placeable);
                return NavigationRailKt.access$placeLabelAndIcon-DIyivk0(measureScope, placeable, mo1521measureBRTryo0, j, this.$iconPositionAnimationProgress);
            }
        }
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public /* synthetic */ int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i) {
        return on2.c(this, intrinsicMeasureScope, list, i);
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public /* synthetic */ int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i) {
        return on2.d(this, intrinsicMeasureScope, list, i);
    }
}
