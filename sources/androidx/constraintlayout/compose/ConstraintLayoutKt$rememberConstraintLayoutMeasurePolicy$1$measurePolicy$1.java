package androidx.constraintlayout.compose;

import androidx.compose.runtime.MutableState;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasurePolicy$DefaultImpls;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.unit.IntSize;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 5, 1})
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class ConstraintLayoutKt$rememberConstraintLayoutMeasurePolicy$1$measurePolicy$1 implements MeasurePolicy {
    final /* synthetic */ ConstraintSetForInlineDsl $constraintSet;
    final /* synthetic */ Measurer $measurer;
    final /* synthetic */ int $optimizationLevel;
    final /* synthetic */ MutableState<Boolean> $remeasureRequesterState;

    ConstraintLayoutKt$rememberConstraintLayoutMeasurePolicy$1$measurePolicy$1(Measurer measurer, ConstraintSetForInlineDsl constraintSetForInlineDsl, int i, MutableState<Boolean> mutableState) {
        this.$measurer = measurer;
        this.$constraintSet = constraintSetForInlineDsl;
        this.$optimizationLevel = i;
        this.$remeasureRequesterState = mutableState;
    }

    public int maxIntrinsicHeight(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull List<? extends IntrinsicMeasurable> list, int i) {
        return MeasurePolicy$DefaultImpls.maxIntrinsicHeight(this, intrinsicMeasureScope, list, i);
    }

    public int maxIntrinsicWidth(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull List<? extends IntrinsicMeasurable> list, int i) {
        return MeasurePolicy$DefaultImpls.maxIntrinsicWidth(this, intrinsicMeasureScope, list, i);
    }

    @NotNull
    /* renamed from: measure-3p2s80s, reason: not valid java name */
    public final MeasureResult m2749measure3p2s80s(@NotNull MeasureScope measureScope, @NotNull List<? extends Measurable> list, long j) {
        Intrinsics.checkNotNullParameter(measureScope, "$this$MeasurePolicy");
        Intrinsics.checkNotNullParameter(list, "measurables");
        long j2 = this.$measurer.performMeasure-DjhGOtQ(j, measureScope.getLayoutDirection(), this.$constraintSet, list, this.$optimizationLevel, measureScope);
        this.$remeasureRequesterState.getValue();
        return MeasureScope.DefaultImpls.layout$default(measureScope, IntSize.m2685getWidthimpl(j2), IntSize.m2684getHeightimpl(j2), (Map) null, new measure.1(this.$measurer, list), 4, (Object) null);
    }

    public int minIntrinsicHeight(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull List<? extends IntrinsicMeasurable> list, int i) {
        return MeasurePolicy$DefaultImpls.minIntrinsicHeight(this, intrinsicMeasureScope, list, i);
    }

    public int minIntrinsicWidth(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull List<? extends IntrinsicMeasurable> list, int i) {
        return MeasurePolicy$DefaultImpls.minIntrinsicWidth(this, intrinsicMeasureScope, list, i);
    }
}
