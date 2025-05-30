package androidx.compose.ui.node;

import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.Placeable$PlacementScope;
import androidx.compose.ui.node.LayoutModifierNodeCoordinator;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: private */
/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class LayoutModifierNodeCoordinator$LookaheadDelegateForIntermediateLayoutModifier$PassThroughMeasureResult implements MeasureResult {

    @NotNull
    private final Map<AlignmentLine, Integer> alignmentLines = MapsKt.emptyMap();
    final /* synthetic */ LayoutModifierNodeCoordinator.LookaheadDelegateForIntermediateLayoutModifier this$0;

    public LayoutModifierNodeCoordinator$LookaheadDelegateForIntermediateLayoutModifier$PassThroughMeasureResult(LayoutModifierNodeCoordinator.LookaheadDelegateForIntermediateLayoutModifier lookaheadDelegateForIntermediateLayoutModifier) {
        this.this$0 = lookaheadDelegateForIntermediateLayoutModifier;
    }

    @Override // androidx.compose.ui.layout.MeasureResult
    @NotNull
    public Map<AlignmentLine, Integer> getAlignmentLines() {
        return this.alignmentLines;
    }

    @Override // androidx.compose.ui.layout.MeasureResult
    public int getHeight() {
        LookaheadDelegate lookaheadDelegate$ui_release = this.this$0.this$0.getWrappedNonNull().getLookaheadDelegate$ui_release();
        Intrinsics.checkNotNull(lookaheadDelegate$ui_release);
        return lookaheadDelegate$ui_release.getMeasureResult$ui_release().getHeight();
    }

    @Override // androidx.compose.ui.layout.MeasureResult
    public int getWidth() {
        LookaheadDelegate lookaheadDelegate$ui_release = this.this$0.this$0.getWrappedNonNull().getLookaheadDelegate$ui_release();
        Intrinsics.checkNotNull(lookaheadDelegate$ui_release);
        return lookaheadDelegate$ui_release.getMeasureResult$ui_release().getWidth();
    }

    @Override // androidx.compose.ui.layout.MeasureResult
    public void placeChildren() {
        Placeable$PlacementScope.Companion companion = Placeable$PlacementScope.Companion;
        LookaheadDelegate lookaheadDelegate$ui_release = this.this$0.this$0.getWrappedNonNull().getLookaheadDelegate$ui_release();
        Intrinsics.checkNotNull(lookaheadDelegate$ui_release);
        Placeable$PlacementScope.place$default(companion, lookaheadDelegate$ui_release, 0, 0, 0.0f, 4, null);
    }
}
