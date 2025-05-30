package androidx.compose.ui.node;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.ui.layout.MeasurePolicy;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class IntrinsicsPolicy {

    @NotNull
    private static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    @Deprecated
    @NotNull
    private static final String NoPolicyError = "Intrinsic size is queried but there is no measure policy in place.";

    @NotNull
    private final LayoutNode layoutNode;

    @NotNull
    private final MutableState measurePolicyState$delegate;

    public IntrinsicsPolicy(@NotNull LayoutNode layoutNode) {
        MutableState mutableStateOf$default;
        Intrinsics.checkNotNullParameter(layoutNode, "layoutNode");
        this.layoutNode = layoutNode;
        mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this.measurePolicyState$delegate = mutableStateOf$default;
    }

    private final MeasurePolicy getMeasurePolicyState() {
        return (MeasurePolicy) this.measurePolicyState$delegate.getValue();
    }

    private final MeasurePolicy measurePolicyFromState() {
        MeasurePolicy measurePolicyState = getMeasurePolicyState();
        if (measurePolicyState != null) {
            return measurePolicyState;
        }
        throw new IllegalStateException(NoPolicyError.toString());
    }

    private final void setMeasurePolicyState(MeasurePolicy measurePolicy) {
        this.measurePolicyState$delegate.setValue(measurePolicy);
    }

    @NotNull
    public final LayoutNode getLayoutNode() {
        return this.layoutNode;
    }

    public final int maxIntrinsicHeight(int i) {
        return measurePolicyFromState().maxIntrinsicHeight(this.layoutNode.getOuterCoordinator$ui_release(), this.layoutNode.getChildMeasurables$ui_release(), i);
    }

    public final int maxIntrinsicWidth(int i) {
        return measurePolicyFromState().maxIntrinsicWidth(this.layoutNode.getOuterCoordinator$ui_release(), this.layoutNode.getChildMeasurables$ui_release(), i);
    }

    public final int maxLookaheadIntrinsicHeight(int i) {
        return measurePolicyFromState().maxIntrinsicHeight(this.layoutNode.getOuterCoordinator$ui_release(), this.layoutNode.getChildLookaheadMeasurables$ui_release(), i);
    }

    public final int maxLookaheadIntrinsicWidth(int i) {
        return measurePolicyFromState().maxIntrinsicWidth(this.layoutNode.getOuterCoordinator$ui_release(), this.layoutNode.getChildLookaheadMeasurables$ui_release(), i);
    }

    public final int minIntrinsicHeight(int i) {
        return measurePolicyFromState().minIntrinsicHeight(this.layoutNode.getOuterCoordinator$ui_release(), this.layoutNode.getChildMeasurables$ui_release(), i);
    }

    public final int minIntrinsicWidth(int i) {
        return measurePolicyFromState().minIntrinsicWidth(this.layoutNode.getOuterCoordinator$ui_release(), this.layoutNode.getChildMeasurables$ui_release(), i);
    }

    public final int minLookaheadIntrinsicHeight(int i) {
        return measurePolicyFromState().minIntrinsicHeight(this.layoutNode.getOuterCoordinator$ui_release(), this.layoutNode.getChildLookaheadMeasurables$ui_release(), i);
    }

    public final int minLookaheadIntrinsicWidth(int i) {
        return measurePolicyFromState().minIntrinsicWidth(this.layoutNode.getOuterCoordinator$ui_release(), this.layoutNode.getChildLookaheadMeasurables$ui_release(), i);
    }

    public final void updateFrom(@NotNull MeasurePolicy measurePolicy) {
        Intrinsics.checkNotNullParameter(measurePolicy, "measurePolicy");
        setMeasurePolicyState(measurePolicy);
    }
}
