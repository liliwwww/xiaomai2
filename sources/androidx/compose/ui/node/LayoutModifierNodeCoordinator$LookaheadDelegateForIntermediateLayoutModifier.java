package androidx.compose.ui.node;

import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.layout.LookaheadScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.IntSizeKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: private */
/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class LayoutModifierNodeCoordinator$LookaheadDelegateForIntermediateLayoutModifier extends LookaheadDelegate {

    @NotNull
    private final IntermediateLayoutModifierNode intermediateMeasureNode;

    @NotNull
    private final PassThroughMeasureResult passThroughMeasureResult;
    final /* synthetic */ LayoutModifierNodeCoordinator this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LayoutModifierNodeCoordinator$LookaheadDelegateForIntermediateLayoutModifier(@NotNull LayoutModifierNodeCoordinator layoutModifierNodeCoordinator, @NotNull LookaheadScope lookaheadScope, IntermediateLayoutModifierNode intermediateLayoutModifierNode) {
        super(layoutModifierNodeCoordinator, lookaheadScope);
        Intrinsics.checkNotNullParameter(lookaheadScope, "scope");
        Intrinsics.checkNotNullParameter(intermediateLayoutModifierNode, "intermediateMeasureNode");
        this.this$0 = layoutModifierNodeCoordinator;
        this.intermediateMeasureNode = intermediateLayoutModifierNode;
        this.passThroughMeasureResult = new PassThroughMeasureResult(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int calculateAlignmentLine(@NotNull AlignmentLine alignmentLine) {
        int calculateAlignmentAndPlaceChildAsNeeded;
        Intrinsics.checkNotNullParameter(alignmentLine, "alignmentLine");
        calculateAlignmentAndPlaceChildAsNeeded = LayoutModifierNodeCoordinatorKt.calculateAlignmentAndPlaceChildAsNeeded(this, alignmentLine);
        getCachedAlignmentLinesMap().put(alignmentLine, Integer.valueOf(calculateAlignmentAndPlaceChildAsNeeded));
        return calculateAlignmentAndPlaceChildAsNeeded;
    }

    @NotNull
    public final IntermediateLayoutModifierNode getIntermediateMeasureNode() {
        return this.intermediateMeasureNode;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    /* renamed from: measure-BRTryo0, reason: not valid java name */
    public Placeable m1608measureBRTryo0(long j) {
        IntermediateLayoutModifierNode intermediateLayoutModifierNode = this.intermediateMeasureNode;
        LayoutModifierNodeCoordinator layoutModifierNodeCoordinator = this.this$0;
        LookaheadDelegate.access$setMeasurementConstraints-BRTryo0(this, j);
        LookaheadDelegate lookaheadDelegate$ui_release = layoutModifierNodeCoordinator.getWrappedNonNull().getLookaheadDelegate$ui_release();
        Intrinsics.checkNotNull(lookaheadDelegate$ui_release);
        lookaheadDelegate$ui_release.mo1521measureBRTryo0(j);
        intermediateLayoutModifierNode.setTargetSize-ozmzZPI(IntSizeKt.IntSize(lookaheadDelegate$ui_release.getMeasureResult$ui_release().getWidth(), lookaheadDelegate$ui_release.getMeasureResult$ui_release().getHeight()));
        LookaheadDelegate.access$set_measureResult(this, this.passThroughMeasureResult);
        return this;
    }
}
