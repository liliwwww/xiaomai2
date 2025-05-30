package androidx.compose.ui.layout;

import androidx.compose.ui.layout.MeasuringIntrinsics;
import androidx.compose.ui.unit.Constraints;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: private */
/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class MeasuringIntrinsics$DefaultIntrinsicMeasurable implements Measurable {

    @NotNull
    private final IntrinsicMeasurable measurable;

    @NotNull
    private final MeasuringIntrinsics$IntrinsicMinMax minMax;

    @NotNull
    private final MeasuringIntrinsics.IntrinsicWidthHeight widthHeight;

    public MeasuringIntrinsics$DefaultIntrinsicMeasurable(@NotNull IntrinsicMeasurable intrinsicMeasurable, @NotNull MeasuringIntrinsics$IntrinsicMinMax measuringIntrinsics$IntrinsicMinMax, @NotNull MeasuringIntrinsics.IntrinsicWidthHeight intrinsicWidthHeight) {
        Intrinsics.checkNotNullParameter(intrinsicMeasurable, "measurable");
        Intrinsics.checkNotNullParameter(measuringIntrinsics$IntrinsicMinMax, "minMax");
        Intrinsics.checkNotNullParameter(intrinsicWidthHeight, "widthHeight");
        this.measurable = intrinsicMeasurable;
        this.minMax = measuringIntrinsics$IntrinsicMinMax;
        this.widthHeight = intrinsicWidthHeight;
    }

    @NotNull
    public final IntrinsicMeasurable getMeasurable() {
        return this.measurable;
    }

    @NotNull
    public final MeasuringIntrinsics$IntrinsicMinMax getMinMax() {
        return this.minMax;
    }

    @Nullable
    public Object getParentData() {
        return this.measurable.getParentData();
    }

    @NotNull
    public final MeasuringIntrinsics.IntrinsicWidthHeight getWidthHeight() {
        return this.widthHeight;
    }

    public int maxIntrinsicHeight(int i) {
        return this.measurable.maxIntrinsicHeight(i);
    }

    public int maxIntrinsicWidth(int i) {
        return this.measurable.maxIntrinsicWidth(i);
    }

    @NotNull
    /* renamed from: measure-BRTryo0, reason: not valid java name */
    public Placeable m2065measureBRTryo0(long j) {
        if (this.widthHeight == MeasuringIntrinsics.IntrinsicWidthHeight.Width) {
            return new MeasuringIntrinsics.EmptyPlaceable(this.minMax == MeasuringIntrinsics$IntrinsicMinMax.Max ? this.measurable.maxIntrinsicWidth(Constraints.getMaxHeight-impl(j)) : this.measurable.minIntrinsicWidth(Constraints.getMaxHeight-impl(j)), Constraints.getMaxHeight-impl(j));
        }
        return new MeasuringIntrinsics.EmptyPlaceable(Constraints.getMaxWidth-impl(j), this.minMax == MeasuringIntrinsics$IntrinsicMinMax.Max ? this.measurable.maxIntrinsicHeight(Constraints.getMaxWidth-impl(j)) : this.measurable.minIntrinsicHeight(Constraints.getMaxWidth-impl(j)));
    }

    public int minIntrinsicHeight(int i) {
        return this.measurable.minIntrinsicHeight(i);
    }

    public int minIntrinsicWidth(int i) {
        return this.measurable.minIntrinsicWidth(i);
    }
}
