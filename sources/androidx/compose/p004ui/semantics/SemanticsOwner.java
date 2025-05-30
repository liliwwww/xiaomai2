package androidx.compose.p004ui.semantics;

import androidx.compose.p004ui.node.LayoutNode;
import androidx.compose.p004ui.node.SemanticsModifierNode;
import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@StabilityInferred(parameters = 0)
/* loaded from: classes2.dex */
public final class SemanticsOwner {
    public static final int $stable = 8;

    @NotNull
    private final LayoutNode rootNode;

    public SemanticsOwner(@NotNull LayoutNode layoutNode) {
        Intrinsics.checkNotNullParameter(layoutNode, "rootNode");
        this.rootNode = layoutNode;
    }

    @NotNull
    public final SemanticsNode getRootSemanticsNode() {
        SemanticsModifierNode outerSemantics = SemanticsNodeKt.getOuterSemantics(this.rootNode);
        Intrinsics.checkNotNull(outerSemantics);
        return new SemanticsNode(outerSemantics, true, null, 4, null);
    }

    @NotNull
    public final SemanticsNode getUnmergedRootSemanticsNode() {
        SemanticsModifierNode outerSemantics = SemanticsNodeKt.getOuterSemantics(this.rootNode);
        Intrinsics.checkNotNull(outerSemantics);
        return new SemanticsNode(outerSemantics, false, null, 4, null);
    }
}
