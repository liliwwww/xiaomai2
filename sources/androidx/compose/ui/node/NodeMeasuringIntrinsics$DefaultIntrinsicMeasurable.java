package androidx.compose.ui.node;

import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.NodeMeasuringIntrinsics;
import androidx.compose.ui.unit.Constraints;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: private */
/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class NodeMeasuringIntrinsics$DefaultIntrinsicMeasurable implements Measurable {

    @NotNull
    private final IntrinsicMeasurable measurable;

    @NotNull
    private final NodeMeasuringIntrinsics$IntrinsicMinMax minMax;

    @NotNull
    private final NodeMeasuringIntrinsics.IntrinsicWidthHeight widthHeight;

    public NodeMeasuringIntrinsics$DefaultIntrinsicMeasurable(@NotNull IntrinsicMeasurable intrinsicMeasurable, @NotNull NodeMeasuringIntrinsics$IntrinsicMinMax nodeMeasuringIntrinsics$IntrinsicMinMax, @NotNull NodeMeasuringIntrinsics.IntrinsicWidthHeight intrinsicWidthHeight) {
        Intrinsics.checkNotNullParameter(intrinsicMeasurable, "measurable");
        Intrinsics.checkNotNullParameter(nodeMeasuringIntrinsics$IntrinsicMinMax, "minMax");
        Intrinsics.checkNotNullParameter(intrinsicWidthHeight, "widthHeight");
        this.measurable = intrinsicMeasurable;
        this.minMax = nodeMeasuringIntrinsics$IntrinsicMinMax;
        this.widthHeight = intrinsicWidthHeight;
    }

    @NotNull
    public final IntrinsicMeasurable getMeasurable() {
        return this.measurable;
    }

    @NotNull
    public final NodeMeasuringIntrinsics$IntrinsicMinMax getMinMax() {
        return this.minMax;
    }

    @Nullable
    public Object getParentData() {
        return this.measurable.getParentData();
    }

    @NotNull
    public final NodeMeasuringIntrinsics.IntrinsicWidthHeight getWidthHeight() {
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
    public Placeable m2174measureBRTryo0(long j) {
        if (this.widthHeight == NodeMeasuringIntrinsics.IntrinsicWidthHeight.Width) {
            return new NodeMeasuringIntrinsics.EmptyPlaceable(this.minMax == NodeMeasuringIntrinsics$IntrinsicMinMax.Max ? this.measurable.maxIntrinsicWidth(Constraints.getMaxHeight-impl(j)) : this.measurable.minIntrinsicWidth(Constraints.getMaxHeight-impl(j)), Constraints.getMaxHeight-impl(j));
        }
        return new NodeMeasuringIntrinsics.EmptyPlaceable(Constraints.getMaxWidth-impl(j), this.minMax == NodeMeasuringIntrinsics$IntrinsicMinMax.Max ? this.measurable.maxIntrinsicHeight(Constraints.getMaxWidth-impl(j)) : this.measurable.minIntrinsicHeight(Constraints.getMaxWidth-impl(j)));
    }

    public int minIntrinsicHeight(int i) {
        return this.measurable.minIntrinsicHeight(i);
    }

    public int minIntrinsicWidth(int i) {
        return this.measurable.minIntrinsicWidth(i);
    }
}
