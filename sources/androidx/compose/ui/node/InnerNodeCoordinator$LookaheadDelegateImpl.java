package androidx.compose.ui.node;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.layout.LookaheadScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.LayoutNodeLayoutDelegate;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: private */
/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class InnerNodeCoordinator$LookaheadDelegateImpl extends LookaheadDelegate {
    final /* synthetic */ InnerNodeCoordinator this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InnerNodeCoordinator$LookaheadDelegateImpl(@NotNull InnerNodeCoordinator innerNodeCoordinator, LookaheadScope lookaheadScope) {
        super(innerNodeCoordinator, lookaheadScope);
        Intrinsics.checkNotNullParameter(lookaheadScope, "scope");
        this.this$0 = innerNodeCoordinator;
    }

    public int calculateAlignmentLine(@NotNull AlignmentLine alignmentLine) {
        Intrinsics.checkNotNullParameter(alignmentLine, "alignmentLine");
        Integer num = (Integer) getAlignmentLinesOwner().calculateAlignmentLines().get(alignmentLine);
        int intValue = num != null ? num.intValue() : Integer.MIN_VALUE;
        getCachedAlignmentLinesMap().put(alignmentLine, Integer.valueOf(intValue));
        return intValue;
    }

    public int maxIntrinsicHeight(int i) {
        return getLayoutNode().getIntrinsicsPolicy$ui_release().maxLookaheadIntrinsicHeight(i);
    }

    public int maxIntrinsicWidth(int i) {
        return getLayoutNode().getIntrinsicsPolicy$ui_release().maxLookaheadIntrinsicWidth(i);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    /* renamed from: measure-BRTryo0, reason: not valid java name */
    public Placeable m1607measureBRTryo0(long j) {
        LookaheadDelegate.access$setMeasurementConstraints-BRTryo0(this, j);
        MutableVector mutableVector = getLayoutNode().get_children$ui_release();
        int size = mutableVector.getSize();
        if (size > 0) {
            int i = 0;
            Object[] content = mutableVector.getContent();
            do {
                ((LayoutNode) content[i]).setMeasuredByParentInLookahead$ui_release(LayoutNode.UsageByParent.NotUsed);
                i++;
            } while (i < size);
        }
        LookaheadDelegate.access$set_measureResult(this, getLayoutNode().getMeasurePolicy().mo16measure3p2s80s(this, getLayoutNode().getChildLookaheadMeasurables$ui_release(), j));
        return this;
    }

    public int minIntrinsicHeight(int i) {
        return getLayoutNode().getIntrinsicsPolicy$ui_release().minLookaheadIntrinsicHeight(i);
    }

    public int minIntrinsicWidth(int i) {
        return getLayoutNode().getIntrinsicsPolicy$ui_release().minLookaheadIntrinsicWidth(i);
    }

    protected void placeChildren() {
        LayoutNodeLayoutDelegate.LookaheadPassDelegate lookaheadPassDelegate$ui_release = getLayoutNode().getLayoutDelegate$ui_release().getLookaheadPassDelegate$ui_release();
        Intrinsics.checkNotNull(lookaheadPassDelegate$ui_release);
        lookaheadPassDelegate$ui_release.onPlaced();
        getAlignmentLinesOwner().layoutChildren();
    }
}
