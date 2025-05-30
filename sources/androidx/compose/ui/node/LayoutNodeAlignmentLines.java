package androidx.compose.ui.node;

import androidx.compose.ui.layout.AlignmentLine;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class LayoutNodeAlignmentLines extends AlignmentLines {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LayoutNodeAlignmentLines(@NotNull AlignmentLinesOwner alignmentLinesOwner) {
        super(alignmentLinesOwner, null);
        Intrinsics.checkNotNullParameter(alignmentLinesOwner, "alignmentLinesOwner");
    }

    @Override // androidx.compose.ui.node.AlignmentLines
    /* renamed from: calculatePositionInParent-R5De75A */
    protected long mo2091calculatePositionInParentR5De75A(@NotNull NodeCoordinator nodeCoordinator, long j) {
        Intrinsics.checkNotNullParameter(nodeCoordinator, "$this$calculatePositionInParent");
        return nodeCoordinator.toParentPosition-MK-Hz9U(j);
    }

    @Override // androidx.compose.ui.node.AlignmentLines
    @NotNull
    protected Map<AlignmentLine, Integer> getAlignmentLinesMap(@NotNull NodeCoordinator nodeCoordinator) {
        Intrinsics.checkNotNullParameter(nodeCoordinator, "<this>");
        return nodeCoordinator.getMeasureResult$ui_release().getAlignmentLines();
    }

    @Override // androidx.compose.ui.node.AlignmentLines
    protected int getPositionFor(@NotNull NodeCoordinator nodeCoordinator, @NotNull AlignmentLine alignmentLine) {
        Intrinsics.checkNotNullParameter(nodeCoordinator, "<this>");
        Intrinsics.checkNotNullParameter(alignmentLine, "alignmentLine");
        return nodeCoordinator.get(alignmentLine);
    }
}
