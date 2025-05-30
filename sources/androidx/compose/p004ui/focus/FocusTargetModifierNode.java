package androidx.compose.p004ui.focus;

import androidx.compose.p004ui.ExperimentalComposeUiApi;
import androidx.compose.p004ui.Modifier;
import androidx.compose.p004ui.layout.BeyondBoundsLayout;
import androidx.compose.p004ui.layout.BeyondBoundsLayoutKt;
import androidx.compose.p004ui.modifier.ModifierLocal;
import androidx.compose.p004ui.modifier.ModifierLocalMap;
import androidx.compose.p004ui.modifier.ModifierLocalNode;
import androidx.compose.p004ui.node.DelegatableNodeKt;
import androidx.compose.p004ui.node.LayoutNode;
import androidx.compose.p004ui.node.ModifierNodeElement;
import androidx.compose.p004ui.node.NodeChain;
import androidx.compose.p004ui.node.NodeKind;
import androidx.compose.p004ui.node.ObserverNode;
import androidx.compose.p004ui.node.ObserverNodeKt;
import androidx.compose.p004ui.platform.InspectableValueKt;
import androidx.compose.p004ui.platform.InspectorInfo;
import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.pt2;

/* compiled from: Taobao */
@StabilityInferred(parameters = 0)
@ExperimentalComposeUiApi
/* loaded from: classes.dex */
public final class FocusTargetModifierNode extends Modifier.Node implements ModifierLocalNode, ObserverNode {

    @NotNull
    private static final Modifier FocusTargetModifierElement;

    @NotNull
    private FocusStateImpl focusStateImpl = FocusStateImpl.Inactive;

    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final Modifier getFocusTargetModifierElement$ui_release() {
            return FocusTargetModifierNode.FocusTargetModifierElement;
        }
    }

    static {
        final Function1<InspectorInfo, Unit> noInspectorInfo = InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.ui.focus.FocusTargetModifierNode$special$$inlined$modifierElementOf$1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((InspectorInfo) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull InspectorInfo inspectorInfo) {
                Intrinsics.checkNotNullParameter(inspectorInfo, "$this$null");
                inspectorInfo.setName("focusTarget");
            }
        } : InspectableValueKt.getNoInspectorInfo();
        FocusTargetModifierElement = new ModifierNodeElement<FocusTargetModifierNode>(noInspectorInfo) { // from class: androidx.compose.ui.focus.FocusTargetModifierNode$special$$inlined$modifierElementOf$2
            @Override // androidx.compose.p004ui.node.ModifierNodeElement
            @NotNull
            public FocusTargetModifierNode create() {
                return new FocusTargetModifierNode();
            }

            @Override // androidx.compose.p004ui.node.ModifierNodeElement
            @NotNull
            public FocusTargetModifierNode update(@NotNull FocusTargetModifierNode focusTargetModifierNode) {
                Intrinsics.checkNotNullParameter(focusTargetModifierNode, "node");
                return focusTargetModifierNode;
            }
        };
    }

    @ExperimentalComposeUiApi
    @NotNull
    public final FocusProperties fetchFocusProperties$ui_release() {
        NodeChain nodes$ui_release;
        FocusPropertiesImpl focusPropertiesImpl = new FocusPropertiesImpl();
        int m4398constructorimpl = NodeKind.m4398constructorimpl(2048) | NodeKind.m4398constructorimpl(1024);
        if (!getNode().isAttached()) {
            throw new IllegalStateException("Check failed.".toString());
        }
        Modifier.Node parent$ui_release = getNode().getParent$ui_release();
        LayoutNode requireLayoutNode = DelegatableNodeKt.requireLayoutNode(this);
        while (requireLayoutNode != null) {
            if ((requireLayoutNode.getNodes$ui_release().getHead$ui_release().getAggregateChildKindSet$ui_release() & m4398constructorimpl) != 0) {
                while (parent$ui_release != null) {
                    if ((parent$ui_release.getKindSet$ui_release() & m4398constructorimpl) != 0) {
                        if ((NodeKind.m4398constructorimpl(1024) & parent$ui_release.getKindSet$ui_release()) != 0) {
                            return focusPropertiesImpl;
                        }
                        if (!(parent$ui_release instanceof FocusPropertiesModifierNode)) {
                            throw new IllegalStateException("Check failed.".toString());
                        }
                        ((FocusPropertiesModifierNode) parent$ui_release).modifyFocusProperties(focusPropertiesImpl);
                    }
                    parent$ui_release = parent$ui_release.getParent$ui_release();
                }
            }
            requireLayoutNode = requireLayoutNode.getParent$ui_release();
            parent$ui_release = (requireLayoutNode == null || (nodes$ui_release = requireLayoutNode.getNodes$ui_release()) == null) ? null : nodes$ui_release.getTail$ui_release();
        }
        return focusPropertiesImpl;
    }

    @Nullable
    public final BeyondBoundsLayout getBeyondBoundsLayoutParent$ui_release() {
        return (BeyondBoundsLayout) getCurrent(BeyondBoundsLayoutKt.getModifierLocalBeyondBoundsLayout());
    }

    @Override // androidx.compose.p004ui.modifier.ModifierLocalNode, androidx.compose.p004ui.modifier.ModifierLocalReadScope
    public /* synthetic */ Object getCurrent(ModifierLocal modifierLocal) {
        return pt2.a(this, modifierLocal);
    }

    @NotNull
    public final FocusState getFocusState() {
        return this.focusStateImpl;
    }

    @NotNull
    public final FocusStateImpl getFocusStateImpl$ui_release() {
        return this.focusStateImpl;
    }

    @Override // androidx.compose.p004ui.modifier.ModifierLocalNode
    public /* synthetic */ ModifierLocalMap getProvidedValues() {
        return pt2.b(this);
    }

    public final void invalidateFocus$ui_release() {
        FocusProperties focusProperties;
        FocusState focusState = getFocusState();
        if (!(focusState == FocusStateImpl.Active || focusState == FocusStateImpl.Captured)) {
            if (focusState == FocusStateImpl.ActiveParent) {
                return;
            }
            FocusStateImpl focusStateImpl = FocusStateImpl.Inactive;
            return;
        }
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        ObserverNodeKt.observeReads(this, new Function0<Unit>() { // from class: androidx.compose.ui.focus.FocusTargetModifierNode$invalidateFocus$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            public /* bridge */ /* synthetic */ Object invoke() {
                m2507invoke();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2507invoke() {
                objectRef.element = this.fetchFocusProperties$ui_release();
            }
        });
        Object obj = objectRef.element;
        if (obj == null) {
            Intrinsics.throwUninitializedPropertyAccessException("focusProperties");
            focusProperties = null;
        } else {
            focusProperties = (FocusProperties) obj;
        }
        if (focusProperties.getCanFocus()) {
            return;
        }
        DelegatableNodeKt.requireOwner(this).getFocusOwner().clearFocus(true);
    }

    @Override // androidx.compose.p004ui.node.ObserverNode
    public void onObservedReadsChanged() {
        FocusState focusState = getFocusState();
        invalidateFocus$ui_release();
        if (Intrinsics.areEqual(focusState, getFocusState())) {
            return;
        }
        FocusEventModifierKt.refreshFocusEventNodes(this);
    }

    public final void onRemoved$ui_release() {
        FocusState focusState = getFocusState();
        if (focusState == FocusStateImpl.Active || focusState == FocusStateImpl.Captured) {
            DelegatableNodeKt.requireOwner(this).getFocusOwner().clearFocus(true);
            return;
        }
        if (focusState == FocusStateImpl.ActiveParent || focusState == FocusStateImpl.Inactive) {
            scheduleInvalidationForFocusEvents$ui_release();
        }
    }

    @Override // androidx.compose.p004ui.modifier.ModifierLocalNode
    public /* synthetic */ void provide(ModifierLocal modifierLocal, Object obj) {
        pt2.c(this, modifierLocal, obj);
    }

    public final void scheduleInvalidationForFocusEvents$ui_release() {
        NodeChain nodes$ui_release;
        int m4398constructorimpl = NodeKind.m4398constructorimpl(4096) | NodeKind.m4398constructorimpl(1024);
        if (!getNode().isAttached()) {
            throw new IllegalStateException("Check failed.".toString());
        }
        Modifier.Node parent$ui_release = getNode().getParent$ui_release();
        LayoutNode requireLayoutNode = DelegatableNodeKt.requireLayoutNode(this);
        while (requireLayoutNode != null) {
            if ((requireLayoutNode.getNodes$ui_release().getHead$ui_release().getAggregateChildKindSet$ui_release() & m4398constructorimpl) != 0) {
                while (parent$ui_release != null) {
                    if ((parent$ui_release.getKindSet$ui_release() & m4398constructorimpl) != 0) {
                        if ((NodeKind.m4398constructorimpl(1024) & parent$ui_release.getKindSet$ui_release()) != 0) {
                            continue;
                        } else {
                            if (!(parent$ui_release instanceof FocusEventModifierNode)) {
                                throw new IllegalStateException("Check failed.".toString());
                            }
                            DelegatableNodeKt.requireOwner(this).getFocusOwner().scheduleInvalidation((FocusEventModifierNode) parent$ui_release);
                        }
                    }
                    parent$ui_release = parent$ui_release.getParent$ui_release();
                }
            }
            requireLayoutNode = requireLayoutNode.getParent$ui_release();
            parent$ui_release = (requireLayoutNode == null || (nodes$ui_release = requireLayoutNode.getNodes$ui_release()) == null) ? null : nodes$ui_release.getTail$ui_release();
        }
    }

    public final void setFocusStateImpl$ui_release(@NotNull FocusStateImpl focusStateImpl) {
        Intrinsics.checkNotNullParameter(focusStateImpl, "<set-?>");
        this.focusStateImpl = focusStateImpl;
    }
}
