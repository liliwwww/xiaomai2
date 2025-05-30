package androidx.compose.ui.node;

import androidx.compose.ui.node.NodeCoordinator;
import androidx.compose.ui.semantics.SemanticsConfiguration;
import androidx.compose.ui.semantics.SemanticsNodeKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class NodeCoordinator$Companion$SemanticsSource$1 implements NodeCoordinator.HitTestSource<SemanticsModifierNode> {
    NodeCoordinator$Companion$SemanticsSource$1() {
    }

    /* renamed from: childHitTest-YqVAtuI, reason: not valid java name */
    public void m2167childHitTestYqVAtuI(@NotNull LayoutNode layoutNode, long j, @NotNull HitTestResult<SemanticsModifierNode> hitTestResult, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(layoutNode, "layoutNode");
        Intrinsics.checkNotNullParameter(hitTestResult, "hitTestResult");
        layoutNode.m2130hitTestSemanticsM_7yMNQ$ui_release(j, hitTestResult, z, z2);
    }

    /* renamed from: entityType-OLwlOKw, reason: not valid java name */
    public int m2168entityTypeOLwlOKw() {
        return NodeKind.constructor-impl(8);
    }

    public boolean interceptOutOfBoundsChildEvents(@NotNull SemanticsModifierNode semanticsModifierNode) {
        Intrinsics.checkNotNullParameter(semanticsModifierNode, "node");
        return false;
    }

    public boolean shouldHitTestChildren(@NotNull LayoutNode layoutNode) {
        SemanticsConfiguration collapsedSemanticsConfiguration;
        Intrinsics.checkNotNullParameter(layoutNode, "parentLayoutNode");
        SemanticsModifierNode outerSemantics = SemanticsNodeKt.getOuterSemantics(layoutNode);
        boolean z = false;
        if (outerSemantics != null && (collapsedSemanticsConfiguration = SemanticsModifierNodeKt.collapsedSemanticsConfiguration(outerSemantics)) != null && collapsedSemanticsConfiguration.isClearingSemantics()) {
            z = true;
        }
        return !z;
    }
}
