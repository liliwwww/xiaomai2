package androidx.compose.ui.node;

import androidx.compose.ui.ExperimentalComposeUiApi;
import androidx.compose.ui.Modifier$Element;
import androidx.compose.ui.Modifier$Node;
import androidx.compose.ui.draw.DrawModifier;
import androidx.compose.ui.focus.FocusEventModifier;
import androidx.compose.ui.focus.FocusEventModifierNode;
import androidx.compose.ui.focus.FocusOrderModifier;
import androidx.compose.ui.focus.FocusPropertiesKt;
import androidx.compose.ui.focus.FocusPropertiesModifierNode;
import androidx.compose.ui.focus.FocusTargetModifierNode;
import androidx.compose.ui.input.key.KeyInputModifierNode;
import androidx.compose.ui.input.pointer.PointerInputModifier;
import androidx.compose.ui.input.rotary.RotaryInputModifierNode;
import androidx.compose.ui.layout.IntermediateLayoutModifier;
import androidx.compose.ui.layout.LayoutModifier;
import androidx.compose.ui.layout.LookaheadOnPlacedModifier;
import androidx.compose.ui.layout.OnGloballyPositionedModifier;
import androidx.compose.ui.layout.OnPlacedModifier;
import androidx.compose.ui.layout.OnRemeasuredModifier;
import androidx.compose.ui.layout.ParentDataModifier;
import androidx.compose.ui.modifier.ModifierLocalConsumer;
import androidx.compose.ui.modifier.ModifierLocalNode;
import androidx.compose.ui.modifier.ModifierLocalProvider;
import androidx.compose.ui.semantics.SemanticsModifier;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class NodeKindKt {
    private static final int Inserted = 1;
    private static final int Removed = 2;
    private static final int Updated = 0;

    public static final void autoInvalidateInsertedNode(@NotNull Modifier$Node modifier$Node) {
        Intrinsics.checkNotNullParameter(modifier$Node, "node");
        autoInvalidateNode(modifier$Node, 1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final void autoInvalidateNode(Modifier$Node modifier$Node, int i) {
        if (((NodeKind.m1660constructorimpl(2) & modifier$Node.getKindSet$ui_release()) != 0) && (modifier$Node instanceof LayoutModifierNode)) {
            LayoutModifierNodeKt.invalidateMeasurements((LayoutModifierNode) modifier$Node);
            if (i == 2) {
                DelegatableNodeKt.m1600requireCoordinator64DMado(modifier$Node, NodeKind.m1660constructorimpl(2)).detach();
            }
        }
        if (((NodeKind.m1660constructorimpl(256) & modifier$Node.getKindSet$ui_release()) != 0) && (modifier$Node instanceof GlobalPositionAwareModifierNode)) {
            DelegatableNodeKt.requireLayoutNode(modifier$Node).invalidateMeasurements$ui_release();
        }
        if (((NodeKind.m1660constructorimpl(4) & modifier$Node.getKindSet$ui_release()) != 0) && (modifier$Node instanceof DrawModifierNode)) {
            DrawModifierNodeKt.invalidateDraw((DrawModifierNode) modifier$Node);
        }
        if (((NodeKind.m1660constructorimpl(8) & modifier$Node.getKindSet$ui_release()) != 0) && (modifier$Node instanceof SemanticsModifierNode)) {
            SemanticsModifierNodeKt.invalidateSemantics((SemanticsModifierNode) modifier$Node);
        }
        if (((NodeKind.m1660constructorimpl(64) & modifier$Node.getKindSet$ui_release()) != 0) && (modifier$Node instanceof ParentDataModifierNode)) {
            ParentDataModifierNodeKt.invalidateParentData((ParentDataModifierNode) modifier$Node);
        }
        if (((NodeKind.m1660constructorimpl(1024) & modifier$Node.getKindSet$ui_release()) != 0) && (modifier$Node instanceof FocusTargetModifierNode)) {
            if (i == 2) {
                ((FocusTargetModifierNode) modifier$Node).onRemoved$ui_release();
            } else {
                DelegatableNodeKt.requireOwner(modifier$Node).getFocusOwner().scheduleInvalidation((FocusTargetModifierNode) modifier$Node);
            }
        }
        if (((NodeKind.m1660constructorimpl(2048) & modifier$Node.getKindSet$ui_release()) != 0) && (modifier$Node instanceof FocusPropertiesModifierNode)) {
            FocusPropertiesModifierNode focusPropertiesModifierNode = (FocusPropertiesModifierNode) modifier$Node;
            if (specifiesCanFocusProperty(focusPropertiesModifierNode)) {
                if (i == 2) {
                    FocusPropertiesKt.scheduleInvalidationOfAssociatedFocusTargets(focusPropertiesModifierNode);
                } else {
                    DelegatableNodeKt.requireOwner(modifier$Node).getFocusOwner().scheduleInvalidation(focusPropertiesModifierNode);
                }
            }
        }
        if (((NodeKind.m1660constructorimpl(4096) & modifier$Node.getKindSet$ui_release()) != 0) && (modifier$Node instanceof FocusEventModifierNode) && i != 2) {
            DelegatableNodeKt.requireOwner(modifier$Node).getFocusOwner().scheduleInvalidation((FocusEventModifierNode) modifier$Node);
        }
    }

    public static final void autoInvalidateRemovedNode(@NotNull Modifier$Node modifier$Node) {
        Intrinsics.checkNotNullParameter(modifier$Node, "node");
        autoInvalidateNode(modifier$Node, 2);
    }

    public static final void autoInvalidateUpdatedNode(@NotNull Modifier$Node modifier$Node) {
        Intrinsics.checkNotNullParameter(modifier$Node, "node");
        autoInvalidateNode(modifier$Node, 0);
    }

    public static final int calculateNodeKindSetFrom(@NotNull Modifier$Element modifier$Element) {
        Intrinsics.checkNotNullParameter(modifier$Element, "element");
        int m1660constructorimpl = NodeKind.m1660constructorimpl(1);
        if (modifier$Element instanceof LayoutModifier) {
            m1660constructorimpl |= NodeKind.m1660constructorimpl(2);
        }
        if (modifier$Element instanceof IntermediateLayoutModifier) {
            m1660constructorimpl |= NodeKind.m1660constructorimpl(512);
        }
        if (modifier$Element instanceof DrawModifier) {
            m1660constructorimpl |= NodeKind.m1660constructorimpl(4);
        }
        if (modifier$Element instanceof SemanticsModifier) {
            m1660constructorimpl |= NodeKind.m1660constructorimpl(8);
        }
        if (modifier$Element instanceof PointerInputModifier) {
            m1660constructorimpl |= NodeKind.m1660constructorimpl(16);
        }
        if ((modifier$Element instanceof ModifierLocalConsumer) || (modifier$Element instanceof ModifierLocalProvider)) {
            m1660constructorimpl |= NodeKind.m1660constructorimpl(32);
        }
        if (modifier$Element instanceof FocusEventModifier) {
            m1660constructorimpl |= NodeKind.m1660constructorimpl(4096);
        }
        if (modifier$Element instanceof FocusOrderModifier) {
            m1660constructorimpl |= NodeKind.m1660constructorimpl(2048);
        }
        if (modifier$Element instanceof OnGloballyPositionedModifier) {
            m1660constructorimpl |= NodeKind.m1660constructorimpl(256);
        }
        if (modifier$Element instanceof ParentDataModifier) {
            m1660constructorimpl |= NodeKind.m1660constructorimpl(64);
        }
        return ((modifier$Element instanceof OnPlacedModifier) || (modifier$Element instanceof OnRemeasuredModifier) || (modifier$Element instanceof LookaheadOnPlacedModifier)) ? m1660constructorimpl | NodeKind.m1660constructorimpl(128) : m1660constructorimpl;
    }

    /* renamed from: getIncludeSelfInTraversal-H91voCI, reason: not valid java name */
    public static final boolean m1668getIncludeSelfInTraversalH91voCI(int i) {
        return (i & NodeKind.m1660constructorimpl(128)) != 0;
    }

    /* renamed from: getIncludeSelfInTraversal-H91voCI$annotations, reason: not valid java name */
    public static /* synthetic */ void m1669getIncludeSelfInTraversalH91voCI$annotations(int i) {
    }

    /* renamed from: or-64DMado, reason: not valid java name */
    public static final int m1670or64DMado(int i, int i2) {
        return i | i2;
    }

    @ExperimentalComposeUiApi
    private static final boolean specifiesCanFocusProperty(FocusPropertiesModifierNode focusPropertiesModifierNode) {
        CanFocusChecker canFocusChecker = CanFocusChecker.INSTANCE;
        canFocusChecker.reset();
        focusPropertiesModifierNode.modifyFocusProperties(canFocusChecker);
        return canFocusChecker.isCanFocusSet();
    }

    public static final int calculateNodeKindSetFrom(@NotNull Modifier$Node modifier$Node) {
        Intrinsics.checkNotNullParameter(modifier$Node, "node");
        int m1660constructorimpl = NodeKind.m1660constructorimpl(1);
        if (modifier$Node instanceof LayoutModifierNode) {
            m1660constructorimpl |= NodeKind.m1660constructorimpl(2);
        }
        if (modifier$Node instanceof DrawModifierNode) {
            m1660constructorimpl |= NodeKind.m1660constructorimpl(4);
        }
        if (modifier$Node instanceof SemanticsModifierNode) {
            m1660constructorimpl |= NodeKind.m1660constructorimpl(8);
        }
        if (modifier$Node instanceof PointerInputModifierNode) {
            m1660constructorimpl |= NodeKind.m1660constructorimpl(16);
        }
        if (modifier$Node instanceof ModifierLocalNode) {
            m1660constructorimpl |= NodeKind.m1660constructorimpl(32);
        }
        if (modifier$Node instanceof ParentDataModifierNode) {
            m1660constructorimpl |= NodeKind.m1660constructorimpl(64);
        }
        if (modifier$Node instanceof LayoutAwareModifierNode) {
            m1660constructorimpl |= NodeKind.m1660constructorimpl(128);
        }
        if (modifier$Node instanceof GlobalPositionAwareModifierNode) {
            m1660constructorimpl |= NodeKind.m1660constructorimpl(256);
        }
        if (modifier$Node instanceof IntermediateLayoutModifierNode) {
            m1660constructorimpl |= NodeKind.m1660constructorimpl(512);
        }
        if (modifier$Node instanceof FocusTargetModifierNode) {
            m1660constructorimpl |= NodeKind.m1660constructorimpl(1024);
        }
        if (modifier$Node instanceof FocusPropertiesModifierNode) {
            m1660constructorimpl |= NodeKind.m1660constructorimpl(2048);
        }
        if (modifier$Node instanceof FocusEventModifierNode) {
            m1660constructorimpl |= NodeKind.m1660constructorimpl(4096);
        }
        if (modifier$Node instanceof KeyInputModifierNode) {
            m1660constructorimpl |= NodeKind.m1660constructorimpl(8192);
        }
        return modifier$Node instanceof RotaryInputModifierNode ? m1660constructorimpl | NodeKind.m1660constructorimpl(AccessibilityNodeInfoCompat.ACTION_COPY) : m1660constructorimpl;
    }
}
