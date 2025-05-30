package androidx.compose.ui.focus;

import androidx.compose.ui.ExperimentalComposeUiApi;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.node.NodeChain;
import androidx.compose.ui.node.NodeKind;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class FocusEventModifierKt {

    /* compiled from: Taobao */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[FocusStateImpl.values().length];
            try {
                iArr[FocusStateImpl.Active.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[FocusStateImpl.ActiveParent.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[FocusStateImpl.Captured.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[FocusStateImpl.Inactive.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x0034, code lost:
    
        continue;
     */
    @org.jetbrains.annotations.NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final androidx.compose.ui.focus.FocusState getFocusState(@org.jetbrains.annotations.NotNull androidx.compose.ui.focus.FocusEventModifierNode r5) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            r0 = 1024(0x400, float:1.435E-42)
            int r0 = androidx.compose.ui.node.NodeKind.constructor-impl(r0)
            androidx.compose.ui.Modifier$Node r1 = r5.getNode()
            boolean r1 = r1.isAttached()
            if (r1 == 0) goto L7e
            r1 = 16
            androidx.compose.runtime.collection.MutableVector r2 = new androidx.compose.runtime.collection.MutableVector
            androidx.compose.ui.Modifier$Node[] r1 = new androidx.compose.ui.Modifier.Node[r1]
            r3 = 0
            r2.<init>(r1, r3)
            androidx.compose.ui.Modifier$Node r1 = r5.getNode()
            androidx.compose.ui.Modifier$Node r1 = r1.getChild$ui_release()
            if (r1 != 0) goto L31
            androidx.compose.ui.Modifier$Node r5 = r5.getNode()
            androidx.compose.ui.node.DelegatableNodeKt.access$addLayoutNodeChildren(r2, r5)
            goto L34
        L31:
            r2.add(r1)
        L34:
            boolean r5 = r2.isNotEmpty()
            if (r5 == 0) goto L7b
            int r5 = r2.getSize()
            r1 = 1
            int r5 = r5 - r1
            java.lang.Object r5 = r2.removeAt(r5)
            androidx.compose.ui.Modifier$Node r5 = (androidx.compose.ui.Modifier.Node) r5
            int r3 = r5.getAggregateChildKindSet$ui_release()
            r3 = r3 & r0
            if (r3 != 0) goto L51
            androidx.compose.ui.node.DelegatableNodeKt.access$addLayoutNodeChildren(r2, r5)
            goto L34
        L51:
            if (r5 == 0) goto L34
            int r3 = r5.getKindSet$ui_release()
            r3 = r3 & r0
            if (r3 == 0) goto L76
            boolean r3 = r5 instanceof androidx.compose.ui.focus.FocusTargetModifierNode
            if (r3 == 0) goto L34
            androidx.compose.ui.focus.FocusTargetModifierNode r5 = (androidx.compose.ui.focus.FocusTargetModifierNode) r5
            androidx.compose.ui.focus.FocusStateImpl r5 = r5.getFocusStateImpl$ui_release()
            int[] r3 = androidx.compose.ui.focus.FocusEventModifierKt.WhenMappings.$EnumSwitchMapping$0
            int r4 = r5.ordinal()
            r3 = r3[r4]
            if (r3 == r1) goto L75
            r1 = 2
            if (r3 == r1) goto L75
            r1 = 3
            if (r3 == r1) goto L75
            goto L34
        L75:
            return r5
        L76:
            androidx.compose.ui.Modifier$Node r5 = r5.getChild$ui_release()
            goto L51
        L7b:
            androidx.compose.ui.focus.FocusStateImpl r5 = androidx.compose.ui.focus.FocusStateImpl.Inactive
            return r5
        L7e:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "Check failed."
            java.lang.String r0 = r0.toString()
            r5.<init>(r0)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.focus.FocusEventModifierKt.getFocusState(androidx.compose.ui.focus.FocusEventModifierNode):androidx.compose.ui.focus.FocusState");
    }

    @NotNull
    public static final Modifier onFocusEvent(@NotNull Modifier modifier, @NotNull final Function1<? super FocusState, Unit> function1) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(function1, "onFocusEvent");
        final Function1<InspectorInfo, Unit> noInspectorInfo = InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.ui.focus.FocusEventModifierKt$onFocusEvent$$inlined$modifierElementOf$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((InspectorInfo) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull InspectorInfo inspectorInfo) {
                Intrinsics.checkNotNullParameter(inspectorInfo, "$this$null");
                inspectorInfo.setName("onFocusEvent");
                inspectorInfo.getProperties().set("onFocusEvent", function1);
            }
        } : InspectableValueKt.getNoInspectorInfo();
        return modifier.then(new ModifierNodeElement<FocusEventModifierNodeImpl>(function1, noInspectorInfo) { // from class: androidx.compose.ui.focus.FocusEventModifierKt$onFocusEvent$$inlined$modifierElementOf$2
            @NotNull
            public FocusEventModifierNodeImpl create() {
                return new FocusEventModifierNodeImpl(function1);
            }

            @NotNull
            public FocusEventModifierNodeImpl update(@NotNull FocusEventModifierNodeImpl focusEventModifierNodeImpl) {
                Intrinsics.checkNotNullParameter(focusEventModifierNodeImpl, "node");
                focusEventModifierNodeImpl.setOnFocusEvent(function1);
                return focusEventModifierNodeImpl;
            }
        });
    }

    @ExperimentalComposeUiApi
    public static final void refreshFocusEventNodes(@NotNull FocusTargetModifierNode focusTargetModifierNode) {
        NodeChain nodes$ui_release;
        Intrinsics.checkNotNullParameter(focusTargetModifierNode, "<this>");
        int i = NodeKind.constructor-impl(AccessibilityEventCompat.TYPE_VIEW_SCROLLED) | NodeKind.constructor-impl(AccessibilityEventCompat.TYPE_TOUCH_EXPLORATION_GESTURE_END);
        if (!focusTargetModifierNode.getNode().isAttached()) {
            throw new IllegalStateException("Check failed.".toString());
        }
        FocusEventModifierNode parent$ui_release = focusTargetModifierNode.getNode().getParent$ui_release();
        LayoutNode requireLayoutNode = DelegatableNodeKt.requireLayoutNode(focusTargetModifierNode);
        while (requireLayoutNode != null) {
            if ((requireLayoutNode.getNodes$ui_release().getHead$ui_release().getAggregateChildKindSet$ui_release() & i) != 0) {
                while (parent$ui_release != null) {
                    if ((parent$ui_release.getKindSet$ui_release() & i) != 0) {
                        if ((NodeKind.constructor-impl(AccessibilityEventCompat.TYPE_TOUCH_EXPLORATION_GESTURE_END) & parent$ui_release.getKindSet$ui_release()) != 0) {
                            return;
                        }
                        if (!(parent$ui_release instanceof FocusEventModifierNode)) {
                            throw new IllegalStateException("Check failed.".toString());
                        }
                        FocusEventModifierNode focusEventModifierNode = parent$ui_release;
                        focusEventModifierNode.onFocusEvent(getFocusState(focusEventModifierNode));
                    }
                    parent$ui_release = parent$ui_release.getParent$ui_release();
                }
            }
            requireLayoutNode = requireLayoutNode.getParent$ui_release();
            parent$ui_release = (requireLayoutNode == null || (nodes$ui_release = requireLayoutNode.getNodes$ui_release()) == null) ? null : nodes$ui_release.getTail$ui_release();
        }
    }
}
