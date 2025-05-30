package androidx.compose.p004ui.focus;

import android.view.KeyEvent;
import androidx.compose.p004ui.ExperimentalComposeUiApi;
import androidx.compose.p004ui.Modifier;
import androidx.compose.p004ui.focus.FocusDirection;
import androidx.compose.p004ui.focus.FocusRequester;
import androidx.compose.p004ui.geometry.Rect;
import androidx.compose.p004ui.input.key.KeyInputModifierNode;
import androidx.compose.p004ui.input.rotary.RotaryInputModifierNode;
import androidx.compose.p004ui.input.rotary.RotaryScrollEvent;
import androidx.compose.p004ui.node.DelegatableNode;
import androidx.compose.p004ui.node.DelegatableNodeKt;
import androidx.compose.p004ui.node.ModifierNodeElement;
import androidx.compose.p004ui.node.NodeKind;
import androidx.compose.p004ui.node.OwnerScope;
import androidx.compose.p004ui.platform.InspectableValueKt;
import androidx.compose.p004ui.platform.InspectorInfo;
import androidx.compose.p004ui.unit.LayoutDirection;
import androidx.core.app.NotificationCompat;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public final class FocusOwnerImpl implements FocusOwner {

    @NotNull
    private final FocusInvalidationManager focusInvalidationManager;
    public LayoutDirection layoutDirection;

    @NotNull
    private final Modifier modifier;

    @NotNull
    private FocusTargetModifierNode rootFocusNode;

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
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

    public FocusOwnerImpl(@NotNull Function1<? super Function0<Unit>, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "onRequestApplyChangesListener");
        this.rootFocusNode = new FocusTargetModifierNode();
        this.focusInvalidationManager = new FocusInvalidationManager(function1);
        final Function1<InspectorInfo, Unit> noInspectorInfo = InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.ui.focus.FocusOwnerImpl$special$$inlined$modifierElementOf$1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((InspectorInfo) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull InspectorInfo inspectorInfo) {
                Intrinsics.checkNotNullParameter(inspectorInfo, "$this$null");
                inspectorInfo.setName("RootFocusTarget");
            }
        } : InspectableValueKt.getNoInspectorInfo();
        this.modifier = new ModifierNodeElement<FocusTargetModifierNode>(noInspectorInfo) { // from class: androidx.compose.ui.focus.FocusOwnerImpl$special$$inlined$modifierElementOf$2
            @Override // androidx.compose.p004ui.node.ModifierNodeElement
            @NotNull
            public FocusTargetModifierNode create() {
                return this.getRootFocusNode$ui_release();
            }

            @Override // androidx.compose.p004ui.node.ModifierNodeElement
            @NotNull
            public FocusTargetModifierNode update(@NotNull FocusTargetModifierNode focusTargetModifierNode) {
                Intrinsics.checkNotNullParameter(focusTargetModifierNode, "node");
                return focusTargetModifierNode;
            }
        };
    }

    public static /* synthetic */ void getModifier$annotations() {
    }

    public static /* synthetic */ void getRootFocusNode$ui_release$annotations() {
    }

    private final KeyInputModifierNode lastLocalKeyInputNode(DelegatableNode delegatableNode) {
        int m4398constructorimpl = NodeKind.m4398constructorimpl(1024) | NodeKind.m4398constructorimpl(8192);
        if (!delegatableNode.getNode().isAttached()) {
            throw new IllegalStateException("Check failed.".toString());
        }
        Modifier.Node node = delegatableNode.getNode();
        Object obj = null;
        if ((node.getAggregateChildKindSet$ui_release() & m4398constructorimpl) != 0) {
            for (Modifier.Node child$ui_release = node.getChild$ui_release(); child$ui_release != null; child$ui_release = child$ui_release.getChild$ui_release()) {
                if ((child$ui_release.getKindSet$ui_release() & m4398constructorimpl) != 0) {
                    if ((NodeKind.m4398constructorimpl(1024) & child$ui_release.getKindSet$ui_release()) != 0) {
                        return (KeyInputModifierNode) obj;
                    }
                    if (!(child$ui_release instanceof KeyInputModifierNode)) {
                        throw new IllegalStateException("Check failed.".toString());
                    }
                    obj = child$ui_release;
                }
            }
        }
        return (KeyInputModifierNode) obj;
    }

    @ExperimentalComposeUiApi
    /* renamed from: traverseAncestors-Y-YKmho, reason: not valid java name */
    private final /* synthetic */ <T extends DelegatableNode> void m2501traverseAncestorsYYKmho(T t, int i, Function1<? super T, Unit> function1, Function1<? super T, Unit> function12) {
        int size;
        List<Modifier.Node> ancestors = DelegatableNodeKt.ancestors(t, i);
        if (!(ancestors instanceof List)) {
            ancestors = null;
        }
        if (ancestors != null && ancestors.size() - 1 >= 0) {
            while (true) {
                int i2 = size - 1;
                function1.invoke(ancestors.get(size));
                if (i2 < 0) {
                    break;
                } else {
                    size = i2;
                }
            }
        }
        function1.invoke(t);
        function12.invoke(t);
        if (ancestors != null) {
            int size2 = ancestors.size();
            for (int i3 = 0; i3 < size2; i3++) {
                function12.invoke(ancestors.get(i3));
            }
        }
    }

    /* renamed from: wrapAroundFocus-3ESFkO8, reason: not valid java name */
    private final boolean m2502wrapAroundFocus3ESFkO8(int i) {
        if (this.rootFocusNode.getFocusState().getHasFocus() && !this.rootFocusNode.getFocusState().isFocused()) {
            FocusDirection.Companion companion = FocusDirection.Companion;
            if (FocusDirection.m2479equalsimpl0(i, companion.m2492getNextdhqQ8s()) ? true : FocusDirection.m2479equalsimpl0(i, companion.m2494getPreviousdhqQ8s())) {
                clearFocus(false);
                if (this.rootFocusNode.getFocusState().isFocused()) {
                    return mo2498moveFocus3ESFkO8(i);
                }
                return false;
            }
        }
        return false;
    }

    @Override // androidx.compose.p004ui.focus.FocusManager
    public void clearFocus(boolean z) {
        clearFocus(z, true);
    }

    @Override // androidx.compose.p004ui.focus.FocusOwner
    /* renamed from: dispatchKeyEvent-ZmokQxo */
    public boolean mo2500dispatchKeyEventZmokQxo(@NotNull KeyEvent keyEvent) {
        int size;
        Intrinsics.checkNotNullParameter(keyEvent, "keyEvent");
        FocusTargetModifierNode findActiveFocusNode = FocusTraversalKt.findActiveFocusNode(this.rootFocusNode);
        if (findActiveFocusNode == null) {
            throw new IllegalStateException("Event can't be processed because we do not have an active focus target.".toString());
        }
        KeyInputModifierNode lastLocalKeyInputNode = lastLocalKeyInputNode(findActiveFocusNode);
        if (lastLocalKeyInputNode == null) {
            Object nearestAncestor = DelegatableNodeKt.nearestAncestor(findActiveFocusNode, NodeKind.m4398constructorimpl(8192));
            if (!(nearestAncestor instanceof KeyInputModifierNode)) {
                nearestAncestor = null;
            }
            lastLocalKeyInputNode = (KeyInputModifierNode) nearestAncestor;
        }
        if (lastLocalKeyInputNode != null) {
            List<Modifier.Node> ancestors = DelegatableNodeKt.ancestors(lastLocalKeyInputNode, NodeKind.m4398constructorimpl(8192));
            List<Modifier.Node> list = ancestors instanceof List ? ancestors : null;
            if (list != null && list.size() - 1 >= 0) {
                while (true) {
                    int i = size - 1;
                    if (((KeyInputModifierNode) list.get(size)).mo3972onPreKeyEventZmokQxo(keyEvent)) {
                        return true;
                    }
                    if (i < 0) {
                        break;
                    }
                    size = i;
                }
            }
            if (lastLocalKeyInputNode.mo3972onPreKeyEventZmokQxo(keyEvent) || lastLocalKeyInputNode.mo3971onKeyEventZmokQxo(keyEvent)) {
                return true;
            }
            if (list != null) {
                int size2 = list.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    if (((KeyInputModifierNode) list.get(i2)).mo3971onKeyEventZmokQxo(keyEvent)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override // androidx.compose.p004ui.focus.FocusOwner
    public boolean dispatchRotaryEvent(@NotNull RotaryScrollEvent rotaryScrollEvent) {
        RotaryInputModifierNode rotaryInputModifierNode;
        int size;
        Intrinsics.checkNotNullParameter(rotaryScrollEvent, NotificationCompat.CATEGORY_EVENT);
        FocusTargetModifierNode findActiveFocusNode = FocusTraversalKt.findActiveFocusNode(this.rootFocusNode);
        if (findActiveFocusNode != null) {
            OwnerScope nearestAncestor = DelegatableNodeKt.nearestAncestor(findActiveFocusNode, NodeKind.m4398constructorimpl(16384));
            if (!(nearestAncestor instanceof RotaryInputModifierNode)) {
                nearestAncestor = null;
            }
            rotaryInputModifierNode = (RotaryInputModifierNode) nearestAncestor;
        } else {
            rotaryInputModifierNode = null;
        }
        if (rotaryInputModifierNode != null) {
            List<Modifier.Node> ancestors = DelegatableNodeKt.ancestors(rotaryInputModifierNode, NodeKind.m4398constructorimpl(16384));
            List<Modifier.Node> list = ancestors instanceof List ? ancestors : null;
            if (list != null && list.size() - 1 >= 0) {
                while (true) {
                    int i = size - 1;
                    if (((RotaryInputModifierNode) list.get(size)).onPreRotaryScrollEvent(rotaryScrollEvent)) {
                        return true;
                    }
                    if (i < 0) {
                        break;
                    }
                    size = i;
                }
            }
            if (rotaryInputModifierNode.onPreRotaryScrollEvent(rotaryScrollEvent) || rotaryInputModifierNode.onRotaryScrollEvent(rotaryScrollEvent)) {
                return true;
            }
            if (list != null) {
                int size2 = list.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    if (((RotaryInputModifierNode) list.get(i2)).onRotaryScrollEvent(rotaryScrollEvent)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override // androidx.compose.p004ui.focus.FocusOwner
    @Nullable
    public Rect getFocusRect() {
        FocusTargetModifierNode findActiveFocusNode = FocusTraversalKt.findActiveFocusNode(this.rootFocusNode);
        if (findActiveFocusNode != null) {
            return FocusTraversalKt.focusRect(findActiveFocusNode);
        }
        return null;
    }

    @Override // androidx.compose.p004ui.focus.FocusOwner
    @NotNull
    public LayoutDirection getLayoutDirection() {
        LayoutDirection layoutDirection = this.layoutDirection;
        if (layoutDirection != null) {
            return layoutDirection;
        }
        Intrinsics.throwUninitializedPropertyAccessException("layoutDirection");
        return null;
    }

    @Override // androidx.compose.p004ui.focus.FocusOwner
    @NotNull
    public Modifier getModifier() {
        return this.modifier;
    }

    @NotNull
    public final FocusTargetModifierNode getRootFocusNode$ui_release() {
        return this.rootFocusNode;
    }

    @Override // androidx.compose.p004ui.focus.FocusManager
    /* renamed from: moveFocus-3ESFkO8 */
    public boolean mo2498moveFocus3ESFkO8(int i) {
        final FocusTargetModifierNode findActiveFocusNode = FocusTraversalKt.findActiveFocusNode(this.rootFocusNode);
        if (findActiveFocusNode == null) {
            return false;
        }
        FocusRequester m2499customFocusSearchOMvw8 = FocusOrderModifierKt.m2499customFocusSearchOMvw8(findActiveFocusNode, i, getLayoutDirection());
        FocusRequester.Companion companion = FocusRequester.Companion;
        if (Intrinsics.areEqual(m2499customFocusSearchOMvw8, companion.getCancel())) {
            return false;
        }
        if (Intrinsics.areEqual(m2499customFocusSearchOMvw8, companion.getDefault())) {
            return FocusTraversalKt.m2509focusSearchsMXa3k8(this.rootFocusNode, i, getLayoutDirection(), new Function1<FocusTargetModifierNode, Boolean>() { // from class: androidx.compose.ui.focus.FocusOwnerImpl$moveFocus$foundNextItem$1
                {
                    super(1);
                }

                @NotNull
                public final Boolean invoke(@NotNull FocusTargetModifierNode focusTargetModifierNode) {
                    Intrinsics.checkNotNullParameter(focusTargetModifierNode, "destination");
                    if (Intrinsics.areEqual(focusTargetModifierNode, FocusTargetModifierNode.this)) {
                        return Boolean.FALSE;
                    }
                    Modifier.Node nearestAncestor = DelegatableNodeKt.nearestAncestor(focusTargetModifierNode, NodeKind.m4398constructorimpl(1024));
                    if (!(nearestAncestor instanceof FocusTargetModifierNode)) {
                        nearestAncestor = null;
                    }
                    if (((FocusTargetModifierNode) nearestAncestor) != null) {
                        return Boolean.valueOf(FocusTransactionsKt.requestFocus(focusTargetModifierNode));
                    }
                    throw new IllegalStateException("Focus search landed at the root.".toString());
                }
            }) || m2502wrapAroundFocus3ESFkO8(i);
        }
        Boolean findFocusTarget$ui_release = m2499customFocusSearchOMvw8.findFocusTarget$ui_release(new Function1<FocusTargetModifierNode, Boolean>() { // from class: androidx.compose.ui.focus.FocusOwnerImpl$moveFocus$1
            @NotNull
            public final Boolean invoke(@NotNull FocusTargetModifierNode focusTargetModifierNode) {
                Intrinsics.checkNotNullParameter(focusTargetModifierNode, "it");
                return Boolean.valueOf(FocusTransactionsKt.requestFocus(focusTargetModifierNode));
            }
        });
        if (findFocusTarget$ui_release != null) {
            return findFocusTarget$ui_release.booleanValue();
        }
        return false;
    }

    @Override // androidx.compose.p004ui.focus.FocusOwner
    public void releaseFocus() {
        FocusTransactionsKt.clearFocus(this.rootFocusNode, true, true);
    }

    @Override // androidx.compose.p004ui.focus.FocusOwner
    public void scheduleInvalidation(@NotNull FocusTargetModifierNode focusTargetModifierNode) {
        Intrinsics.checkNotNullParameter(focusTargetModifierNode, "node");
        this.focusInvalidationManager.scheduleInvalidation(focusTargetModifierNode);
    }

    @Override // androidx.compose.p004ui.focus.FocusOwner
    public void setLayoutDirection(@NotNull LayoutDirection layoutDirection) {
        Intrinsics.checkNotNullParameter(layoutDirection, "<set-?>");
        this.layoutDirection = layoutDirection;
    }

    public final void setRootFocusNode$ui_release(@NotNull FocusTargetModifierNode focusTargetModifierNode) {
        Intrinsics.checkNotNullParameter(focusTargetModifierNode, "<set-?>");
        this.rootFocusNode = focusTargetModifierNode;
    }

    @Override // androidx.compose.p004ui.focus.FocusOwner
    public void takeFocus() {
        if (this.rootFocusNode.getFocusStateImpl$ui_release() == FocusStateImpl.Inactive) {
            this.rootFocusNode.setFocusStateImpl$ui_release(FocusStateImpl.Active);
        }
    }

    @Override // androidx.compose.p004ui.focus.FocusOwner
    public void clearFocus(boolean z, boolean z2) {
        FocusStateImpl focusStateImpl;
        FocusStateImpl focusStateImpl$ui_release = this.rootFocusNode.getFocusStateImpl$ui_release();
        if (FocusTransactionsKt.clearFocus(this.rootFocusNode, z, z2)) {
            FocusTargetModifierNode focusTargetModifierNode = this.rootFocusNode;
            int i = WhenMappings.$EnumSwitchMapping$0[focusStateImpl$ui_release.ordinal()];
            if (i == 1 || i == 2 || i == 3) {
                focusStateImpl = FocusStateImpl.Active;
            } else {
                if (i != 4) {
                    throw new NoWhenBranchMatchedException();
                }
                focusStateImpl = FocusStateImpl.Inactive;
            }
            focusTargetModifierNode.setFocusStateImpl$ui_release(focusStateImpl);
        }
    }

    @Override // androidx.compose.p004ui.focus.FocusOwner
    public void scheduleInvalidation(@NotNull FocusEventModifierNode focusEventModifierNode) {
        Intrinsics.checkNotNullParameter(focusEventModifierNode, "node");
        this.focusInvalidationManager.scheduleInvalidation(focusEventModifierNode);
    }

    @Override // androidx.compose.p004ui.focus.FocusOwner
    public void scheduleInvalidation(@NotNull FocusPropertiesModifierNode focusPropertiesModifierNode) {
        Intrinsics.checkNotNullParameter(focusPropertiesModifierNode, "node");
        this.focusInvalidationManager.scheduleInvalidation(focusPropertiesModifierNode);
    }
}
