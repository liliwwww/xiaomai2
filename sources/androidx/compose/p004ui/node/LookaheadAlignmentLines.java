package androidx.compose.p004ui.node;

import androidx.compose.p004ui.geometry.Offset;
import androidx.compose.p004ui.geometry.OffsetKt;
import androidx.compose.p004ui.layout.AlignmentLine;
import androidx.compose.p004ui.unit.IntOffset;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public final class LookaheadAlignmentLines extends AlignmentLines {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LookaheadAlignmentLines(@NotNull AlignmentLinesOwner alignmentLinesOwner) {
        super(alignmentLinesOwner, null);
        Intrinsics.checkNotNullParameter(alignmentLinesOwner, "alignmentLinesOwner");
    }

    @Override // androidx.compose.p004ui.node.AlignmentLines
    /* renamed from: calculatePositionInParent-R5De75A */
    protected long mo4262calculatePositionInParentR5De75A(@NotNull NodeCoordinator nodeCoordinator, long j) {
        Intrinsics.checkNotNullParameter(nodeCoordinator, "$this$calculatePositionInParent");
        LookaheadDelegate lookaheadDelegate$ui_release = nodeCoordinator.getLookaheadDelegate$ui_release();
        Intrinsics.checkNotNull(lookaheadDelegate$ui_release);
        long mo4342getPositionnOccac = lookaheadDelegate$ui_release.mo4342getPositionnOccac();
        return Offset.m2561plusMKHz9U(OffsetKt.Offset(IntOffset.m5334getXimpl(mo4342getPositionnOccac), IntOffset.m5335getYimpl(mo4342getPositionnOccac)), j);
    }

    @Override // androidx.compose.p004ui.node.AlignmentLines
    @NotNull
    protected Map<AlignmentLine, Integer> getAlignmentLinesMap(@NotNull NodeCoordinator nodeCoordinator) {
        Intrinsics.checkNotNullParameter(nodeCoordinator, "<this>");
        LookaheadDelegate lookaheadDelegate$ui_release = nodeCoordinator.getLookaheadDelegate$ui_release();
        Intrinsics.checkNotNull(lookaheadDelegate$ui_release);
        return lookaheadDelegate$ui_release.getMeasureResult$ui_release().getAlignmentLines();
    }

    @Override // androidx.compose.p004ui.node.AlignmentLines
    protected int getPositionFor(@NotNull NodeCoordinator nodeCoordinator, @NotNull AlignmentLine alignmentLine) {
        Intrinsics.checkNotNullParameter(nodeCoordinator, "<this>");
        Intrinsics.checkNotNullParameter(alignmentLine, "alignmentLine");
        LookaheadDelegate lookaheadDelegate$ui_release = nodeCoordinator.getLookaheadDelegate$ui_release();
        Intrinsics.checkNotNull(lookaheadDelegate$ui_release);
        return lookaheadDelegate$ui_release.get(alignmentLine);
    }
}
