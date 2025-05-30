package androidx.compose.p004ui.node;

import androidx.compose.p004ui.ExperimentalComposeUiApi;
import androidx.compose.p004ui.Modifier;
import androidx.compose.p004ui.draw.DrawModifier;
import androidx.compose.p004ui.focus.FocusEventModifier;
import androidx.compose.p004ui.focus.FocusEventModifierNode;
import androidx.compose.p004ui.focus.FocusOrderModifier;
import androidx.compose.p004ui.focus.FocusPropertiesKt;
import androidx.compose.p004ui.focus.FocusPropertiesModifierNode;
import androidx.compose.p004ui.focus.FocusTargetModifierNode;
import androidx.compose.p004ui.input.key.KeyInputModifierNode;
import androidx.compose.p004ui.input.pointer.PointerInputModifier;
import androidx.compose.p004ui.input.rotary.RotaryInputModifierNode;
import androidx.compose.p004ui.layout.IntermediateLayoutModifier;
import androidx.compose.p004ui.layout.LayoutModifier;
import androidx.compose.p004ui.layout.LookaheadOnPlacedModifier;
import androidx.compose.p004ui.layout.OnGloballyPositionedModifier;
import androidx.compose.p004ui.layout.OnPlacedModifier;
import androidx.compose.p004ui.layout.OnRemeasuredModifier;
import androidx.compose.p004ui.layout.ParentDataModifier;
import androidx.compose.p004ui.modifier.ModifierLocalConsumer;
import androidx.compose.p004ui.modifier.ModifierLocalNode;
import androidx.compose.p004ui.modifier.ModifierLocalProvider;
import androidx.compose.p004ui.semantics.SemanticsModifier;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public final class NodeKindKt {
    private static final int Inserted = 1;
    private static final int Removed = 2;
    private static final int Updated = 0;

    public static final void autoInvalidateInsertedNode(@NotNull Modifier.Node node) {
        Intrinsics.checkNotNullParameter(node, "node");
        autoInvalidateNode(node, 1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final void autoInvalidateNode(Modifier.Node node, int i) {
        if (((NodeKind.m4398constructorimpl(2) & node.getKindSet$ui_release()) != 0) && (node instanceof LayoutModifierNode)) {
            LayoutModifierNodeKt.invalidateMeasurements((LayoutModifierNode) node);
            if (i == 2) {
                DelegatableNodeKt.m4288requireCoordinator64DMado(node, NodeKind.m4398constructorimpl(2)).detach();
            }
        }
        if (((NodeKind.m4398constructorimpl(256) & node.getKindSet$ui_release()) != 0) && (node instanceof GlobalPositionAwareModifierNode)) {
            DelegatableNodeKt.requireLayoutNode(node).invalidateMeasurements$ui_release();
        }
        if (((NodeKind.m4398constructorimpl(4) & node.getKindSet$ui_release()) != 0) && (node instanceof DrawModifierNode)) {
            DrawModifierNodeKt.invalidateDraw((DrawModifierNode) node);
        }
        if (((NodeKind.m4398constructorimpl(8) & node.getKindSet$ui_release()) != 0) && (node instanceof SemanticsModifierNode)) {
            SemanticsModifierNodeKt.invalidateSemantics((SemanticsModifierNode) node);
        }
        if (((NodeKind.m4398constructorimpl(64) & node.getKindSet$ui_release()) != 0) && (node instanceof ParentDataModifierNode)) {
            ParentDataModifierNodeKt.invalidateParentData((ParentDataModifierNode) node);
        }
        if (((NodeKind.m4398constructorimpl(1024) & node.getKindSet$ui_release()) != 0) && (node instanceof FocusTargetModifierNode)) {
            if (i == 2) {
                ((FocusTargetModifierNode) node).onRemoved$ui_release();
            } else {
                DelegatableNodeKt.requireOwner(node).getFocusOwner().scheduleInvalidation((FocusTargetModifierNode) node);
            }
        }
        if (((NodeKind.m4398constructorimpl(2048) & node.getKindSet$ui_release()) != 0) && (node instanceof FocusPropertiesModifierNode)) {
            FocusPropertiesModifierNode focusPropertiesModifierNode = (FocusPropertiesModifierNode) node;
            if (specifiesCanFocusProperty(focusPropertiesModifierNode)) {
                if (i == 2) {
                    FocusPropertiesKt.scheduleInvalidationOfAssociatedFocusTargets(focusPropertiesModifierNode);
                } else {
                    DelegatableNodeKt.requireOwner(node).getFocusOwner().scheduleInvalidation(focusPropertiesModifierNode);
                }
            }
        }
        if (((NodeKind.m4398constructorimpl(4096) & node.getKindSet$ui_release()) != 0) && (node instanceof FocusEventModifierNode) && i != 2) {
            DelegatableNodeKt.requireOwner(node).getFocusOwner().scheduleInvalidation((FocusEventModifierNode) node);
        }
    }

    public static final void autoInvalidateRemovedNode(@NotNull Modifier.Node node) {
        Intrinsics.checkNotNullParameter(node, "node");
        autoInvalidateNode(node, 2);
    }

    public static final void autoInvalidateUpdatedNode(@NotNull Modifier.Node node) {
        Intrinsics.checkNotNullParameter(node, "node");
        autoInvalidateNode(node, 0);
    }

    public static final int calculateNodeKindSetFrom(@NotNull Modifier.Element element) {
        Intrinsics.checkNotNullParameter(element, "element");
        int m4398constructorimpl = NodeKind.m4398constructorimpl(1);
        if (element instanceof LayoutModifier) {
            m4398constructorimpl |= NodeKind.m4398constructorimpl(2);
        }
        if (element instanceof IntermediateLayoutModifier) {
            m4398constructorimpl |= NodeKind.m4398constructorimpl(512);
        }
        if (element instanceof DrawModifier) {
            m4398constructorimpl |= NodeKind.m4398constructorimpl(4);
        }
        if (element instanceof SemanticsModifier) {
            m4398constructorimpl |= NodeKind.m4398constructorimpl(8);
        }
        if (element instanceof PointerInputModifier) {
            m4398constructorimpl |= NodeKind.m4398constructorimpl(16);
        }
        if ((element instanceof ModifierLocalConsumer) || (element instanceof ModifierLocalProvider)) {
            m4398constructorimpl |= NodeKind.m4398constructorimpl(32);
        }
        if (element instanceof FocusEventModifier) {
            m4398constructorimpl |= NodeKind.m4398constructorimpl(4096);
        }
        if (element instanceof FocusOrderModifier) {
            m4398constructorimpl |= NodeKind.m4398constructorimpl(2048);
        }
        if (element instanceof OnGloballyPositionedModifier) {
            m4398constructorimpl |= NodeKind.m4398constructorimpl(256);
        }
        if (element instanceof ParentDataModifier) {
            m4398constructorimpl |= NodeKind.m4398constructorimpl(64);
        }
        return ((element instanceof OnPlacedModifier) || (element instanceof OnRemeasuredModifier) || (element instanceof LookaheadOnPlacedModifier)) ? m4398constructorimpl | NodeKind.m4398constructorimpl(128) : m4398constructorimpl;
    }

    /* renamed from: getIncludeSelfInTraversal-H91voCI, reason: not valid java name */
    public static final boolean m4406getIncludeSelfInTraversalH91voCI(int i) {
        return (i & NodeKind.m4398constructorimpl(128)) != 0;
    }

    /* renamed from: getIncludeSelfInTraversal-H91voCI$annotations, reason: not valid java name */
    public static /* synthetic */ void m4407getIncludeSelfInTraversalH91voCI$annotations(int i) {
    }

    /* renamed from: or-64DMado, reason: not valid java name */
    public static final int m4408or64DMado(int i, int i2) {
        return i | i2;
    }

    @ExperimentalComposeUiApi
    private static final boolean specifiesCanFocusProperty(FocusPropertiesModifierNode focusPropertiesModifierNode) {
        CanFocusChecker canFocusChecker = CanFocusChecker.INSTANCE;
        canFocusChecker.reset();
        focusPropertiesModifierNode.modifyFocusProperties(canFocusChecker);
        return canFocusChecker.isCanFocusSet();
    }

    public static final int calculateNodeKindSetFrom(@NotNull Modifier.Node node) {
        Intrinsics.checkNotNullParameter(node, "node");
        int m4398constructorimpl = NodeKind.m4398constructorimpl(1);
        if (node instanceof LayoutModifierNode) {
            m4398constructorimpl |= NodeKind.m4398constructorimpl(2);
        }
        if (node instanceof DrawModifierNode) {
            m4398constructorimpl |= NodeKind.m4398constructorimpl(4);
        }
        if (node instanceof SemanticsModifierNode) {
            m4398constructorimpl |= NodeKind.m4398constructorimpl(8);
        }
        if (node instanceof PointerInputModifierNode) {
            m4398constructorimpl |= NodeKind.m4398constructorimpl(16);
        }
        if (node instanceof ModifierLocalNode) {
            m4398constructorimpl |= NodeKind.m4398constructorimpl(32);
        }
        if (node instanceof ParentDataModifierNode) {
            m4398constructorimpl |= NodeKind.m4398constructorimpl(64);
        }
        if (node instanceof LayoutAwareModifierNode) {
            m4398constructorimpl |= NodeKind.m4398constructorimpl(128);
        }
        if (node instanceof GlobalPositionAwareModifierNode) {
            m4398constructorimpl |= NodeKind.m4398constructorimpl(256);
        }
        if (node instanceof IntermediateLayoutModifierNode) {
            m4398constructorimpl |= NodeKind.m4398constructorimpl(512);
        }
        if (node instanceof FocusTargetModifierNode) {
            m4398constructorimpl |= NodeKind.m4398constructorimpl(1024);
        }
        if (node instanceof FocusPropertiesModifierNode) {
            m4398constructorimpl |= NodeKind.m4398constructorimpl(2048);
        }
        if (node instanceof FocusEventModifierNode) {
            m4398constructorimpl |= NodeKind.m4398constructorimpl(4096);
        }
        if (node instanceof KeyInputModifierNode) {
            m4398constructorimpl |= NodeKind.m4398constructorimpl(8192);
        }
        return node instanceof RotaryInputModifierNode ? m4398constructorimpl | NodeKind.m4398constructorimpl(16384) : m4398constructorimpl;
    }
}
