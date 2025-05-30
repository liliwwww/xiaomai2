package androidx.compose.ui.focus;

import android.view.KeyEvent;
import androidx.compose.ui.ExperimentalComposeUiApi;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusDirection;
import androidx.compose.ui.focus.FocusOwnerImpl$special$;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.input.key.KeyInputModifierNode;
import androidx.compose.ui.input.rotary.RotaryInputModifierNode;
import androidx.compose.ui.input.rotary.RotaryScrollEvent;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.NodeKind;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class FocusOwnerImpl implements FocusOwner {

    @NotNull
    private final FocusInvalidationManager focusInvalidationManager;
    public LayoutDirection layoutDirection;

    @NotNull
    private final Modifier modifier;

    @NotNull
    private FocusTargetModifierNode rootFocusNode;

    public FocusOwnerImpl(@NotNull Function1<? super Function0<Unit>, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "onRequestApplyChangesListener");
        this.rootFocusNode = new FocusTargetModifierNode();
        this.focusInvalidationManager = new FocusInvalidationManager(function1);
        this.modifier = new FocusOwnerImpl$special$.inlined.modifierElementOf.2(InspectableValueKt.isDebugInspectorInfoEnabled() ? new FocusOwnerImpl$special$.inlined.modifierElementOf.1() : InspectableValueKt.getNoInspectorInfo(), this);
    }

    public static /* synthetic */ void getModifier$annotations() {
    }

    public static /* synthetic */ void getRootFocusNode$ui_release$annotations() {
    }

    private final KeyInputModifierNode lastLocalKeyInputNode(DelegatableNode delegatableNode) {
        int i = NodeKind.constructor-impl(AccessibilityEventCompat.TYPE_TOUCH_EXPLORATION_GESTURE_END) | NodeKind.constructor-impl(AccessibilityEventCompat.TYPE_VIEW_TEXT_SELECTION_CHANGED);
        if (!delegatableNode.getNode().isAttached()) {
            throw new IllegalStateException("Check failed.".toString());
        }
        Modifier.Node node = delegatableNode.getNode();
        KeyInputModifierNode keyInputModifierNode = null;
        if ((node.getAggregateChildKindSet$ui_release() & i) != 0) {
            for (KeyInputModifierNode child$ui_release = node.getChild$ui_release(); child$ui_release != null; child$ui_release = child$ui_release.getChild$ui_release()) {
                if ((child$ui_release.getKindSet$ui_release() & i) != 0) {
                    if ((NodeKind.constructor-impl(AccessibilityEventCompat.TYPE_TOUCH_EXPLORATION_GESTURE_END) & child$ui_release.getKindSet$ui_release()) != 0) {
                        return keyInputModifierNode;
                    }
                    if (!(child$ui_release instanceof KeyInputModifierNode)) {
                        throw new IllegalStateException("Check failed.".toString());
                    }
                    keyInputModifierNode = child$ui_release;
                }
            }
        }
        return keyInputModifierNode;
    }

    @ExperimentalComposeUiApi
    /* renamed from: traverseAncestors-Y-YKmho, reason: not valid java name */
    private final /* synthetic */ <T extends DelegatableNode> void m985traverseAncestorsYYKmho(T t, int i, Function1<? super T, Unit> function1, Function1<? super T, Unit> function12) {
        int size;
        List ancestors = DelegatableNodeKt.ancestors(t, i);
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
    private final boolean m986wrapAroundFocus3ESFkO8(int i) {
        if (this.rootFocusNode.getFocusState().getHasFocus() && !this.rootFocusNode.getFocusState().isFocused()) {
            FocusDirection.Companion companion = FocusDirection.Companion;
            if (FocusDirection.m964equalsimpl0(i, companion.m977getNextdhqQ8s()) ? true : FocusDirection.m964equalsimpl0(i, companion.m979getPreviousdhqQ8s())) {
                clearFocus(false);
                if (this.rootFocusNode.getFocusState().isFocused()) {
                    return mo983moveFocus3ESFkO8(i);
                }
                return false;
            }
        }
        return false;
    }

    @Override // androidx.compose.ui.focus.FocusManager
    public void clearFocus(boolean z) {
        clearFocus(z, true);
    }

    @Override // androidx.compose.ui.focus.FocusOwner
    /* renamed from: dispatchKeyEvent-ZmokQxo */
    public boolean mo984dispatchKeyEventZmokQxo(@NotNull KeyEvent keyEvent) {
        int size;
        Intrinsics.checkNotNullParameter(keyEvent, "keyEvent");
        FocusTargetModifierNode findActiveFocusNode = FocusTraversalKt.findActiveFocusNode(this.rootFocusNode);
        if (findActiveFocusNode == null) {
            throw new IllegalStateException("Event can't be processed because we do not have an active focus target.".toString());
        }
        KeyInputModifierNode lastLocalKeyInputNode = lastLocalKeyInputNode(findActiveFocusNode);
        if (lastLocalKeyInputNode == null) {
            Modifier.Node nearestAncestor = DelegatableNodeKt.nearestAncestor(findActiveFocusNode, NodeKind.constructor-impl(AccessibilityEventCompat.TYPE_VIEW_TEXT_SELECTION_CHANGED));
            if (!(nearestAncestor instanceof KeyInputModifierNode)) {
                nearestAncestor = null;
            }
            lastLocalKeyInputNode = (KeyInputModifierNode) nearestAncestor;
        }
        if (lastLocalKeyInputNode != null) {
            List ancestors = DelegatableNodeKt.ancestors(lastLocalKeyInputNode, NodeKind.constructor-impl(AccessibilityEventCompat.TYPE_VIEW_TEXT_SELECTION_CHANGED));
            List list = ancestors instanceof List ? ancestors : null;
            if (list != null && list.size() - 1 >= 0) {
                while (true) {
                    int i = size - 1;
                    if (((KeyInputModifierNode) list.get(size)).m1958onPreKeyEventZmokQxo(keyEvent)) {
                        return true;
                    }
                    if (i < 0) {
                        break;
                    }
                    size = i;
                }
            }
            if (lastLocalKeyInputNode.m1958onPreKeyEventZmokQxo(keyEvent) || lastLocalKeyInputNode.m1957onKeyEventZmokQxo(keyEvent)) {
                return true;
            }
            if (list != null) {
                int size2 = list.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    if (((KeyInputModifierNode) list.get(i2)).m1957onKeyEventZmokQxo(keyEvent)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override // androidx.compose.ui.focus.FocusOwner
    public boolean dispatchRotaryEvent(@NotNull RotaryScrollEvent rotaryScrollEvent) {
        RotaryInputModifierNode rotaryInputModifierNode;
        int size;
        Intrinsics.checkNotNullParameter(rotaryScrollEvent, "event");
        FocusTargetModifierNode findActiveFocusNode = FocusTraversalKt.findActiveFocusNode(this.rootFocusNode);
        if (findActiveFocusNode != null) {
            Modifier.Node nearestAncestor = DelegatableNodeKt.nearestAncestor(findActiveFocusNode, NodeKind.constructor-impl(AccessibilityEventCompat.TYPE_ANNOUNCEMENT));
            if (!(nearestAncestor instanceof RotaryInputModifierNode)) {
                nearestAncestor = null;
            }
            rotaryInputModifierNode = (RotaryInputModifierNode) nearestAncestor;
        } else {
            rotaryInputModifierNode = null;
        }
        if (rotaryInputModifierNode != null) {
            List ancestors = DelegatableNodeKt.ancestors(rotaryInputModifierNode, NodeKind.constructor-impl(AccessibilityEventCompat.TYPE_ANNOUNCEMENT));
            List list = ancestors instanceof List ? ancestors : null;
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

    @Override // androidx.compose.ui.focus.FocusOwner
    @Nullable
    public Rect getFocusRect() {
        FocusTargetModifierNode findActiveFocusNode = FocusTraversalKt.findActiveFocusNode(this.rootFocusNode);
        if (findActiveFocusNode != null) {
            return FocusTraversalKt.focusRect(findActiveFocusNode);
        }
        return null;
    }

    @Override // androidx.compose.ui.focus.FocusOwner
    @NotNull
    public LayoutDirection getLayoutDirection() {
        LayoutDirection layoutDirection = this.layoutDirection;
        if (layoutDirection != null) {
            return layoutDirection;
        }
        Intrinsics.throwUninitializedPropertyAccessException("layoutDirection");
        return null;
    }

    @Override // androidx.compose.ui.focus.FocusOwner
    @NotNull
    public Modifier getModifier() {
        return this.modifier;
    }

    @NotNull
    public final FocusTargetModifierNode getRootFocusNode$ui_release() {
        return this.rootFocusNode;
    }

    @Override // androidx.compose.ui.focus.FocusManager
    /* renamed from: moveFocus-3ESFkO8 */
    public boolean mo983moveFocus3ESFkO8(int i) {
        final FocusTargetModifierNode findActiveFocusNode = FocusTraversalKt.findActiveFocusNode(this.rootFocusNode);
        if (findActiveFocusNode == null) {
            return false;
        }
        FocusRequester focusRequester = FocusOrderModifierKt.customFocusSearch--OM-vw8(findActiveFocusNode, i, getLayoutDirection());
        FocusRequester.Companion companion = FocusRequester.Companion;
        if (Intrinsics.areEqual(focusRequester, companion.getCancel())) {
            return false;
        }
        if (Intrinsics.areEqual(focusRequester, companion.getDefault())) {
            return FocusTraversalKt.focusSearch-sMXa3k8(this.rootFocusNode, i, getLayoutDirection(), new Function1<FocusTargetModifierNode, Boolean>() { // from class: androidx.compose.ui.focus.FocusOwnerImpl$moveFocus$foundNextItem$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @NotNull
                public final Boolean invoke(@NotNull FocusTargetModifierNode focusTargetModifierNode) {
                    Intrinsics.checkNotNullParameter(focusTargetModifierNode, "destination");
                    if (Intrinsics.areEqual(focusTargetModifierNode, findActiveFocusNode)) {
                        return Boolean.FALSE;
                    }
                    Modifier.Node nearestAncestor = DelegatableNodeKt.nearestAncestor(focusTargetModifierNode, NodeKind.constructor-impl(AccessibilityEventCompat.TYPE_TOUCH_EXPLORATION_GESTURE_END));
                    if (!(nearestAncestor instanceof FocusTargetModifierNode)) {
                        nearestAncestor = null;
                    }
                    if (((FocusTargetModifierNode) nearestAncestor) != null) {
                        return Boolean.valueOf(FocusTransactionsKt.requestFocus(focusTargetModifierNode));
                    }
                    throw new IllegalStateException("Focus search landed at the root.".toString());
                }
            }) || m986wrapAroundFocus3ESFkO8(i);
        }
        Boolean findFocusTarget$ui_release = focusRequester.findFocusTarget$ui_release(moveFocus.1.INSTANCE);
        if (findFocusTarget$ui_release != null) {
            return findFocusTarget$ui_release.booleanValue();
        }
        return false;
    }

    @Override // androidx.compose.ui.focus.FocusOwner
    public void releaseFocus() {
        FocusTransactionsKt.clearFocus(this.rootFocusNode, true, true);
    }

    @Override // androidx.compose.ui.focus.FocusOwner
    public void scheduleInvalidation(@NotNull FocusTargetModifierNode focusTargetModifierNode) {
        Intrinsics.checkNotNullParameter(focusTargetModifierNode, "node");
        this.focusInvalidationManager.scheduleInvalidation(focusTargetModifierNode);
    }

    @Override // androidx.compose.ui.focus.FocusOwner
    public void setLayoutDirection(@NotNull LayoutDirection layoutDirection) {
        Intrinsics.checkNotNullParameter(layoutDirection, "<set-?>");
        this.layoutDirection = layoutDirection;
    }

    public final void setRootFocusNode$ui_release(@NotNull FocusTargetModifierNode focusTargetModifierNode) {
        Intrinsics.checkNotNullParameter(focusTargetModifierNode, "<set-?>");
        this.rootFocusNode = focusTargetModifierNode;
    }

    @Override // androidx.compose.ui.focus.FocusOwner
    public void takeFocus() {
        if (this.rootFocusNode.getFocusStateImpl$ui_release() == FocusStateImpl.Inactive) {
            this.rootFocusNode.setFocusStateImpl$ui_release(FocusStateImpl.Active);
        }
    }

    @Override // androidx.compose.ui.focus.FocusOwner
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

    @Override // androidx.compose.ui.focus.FocusOwner
    public void scheduleInvalidation(@NotNull FocusEventModifierNode focusEventModifierNode) {
        Intrinsics.checkNotNullParameter(focusEventModifierNode, "node");
        this.focusInvalidationManager.scheduleInvalidation(focusEventModifierNode);
    }

    @Override // androidx.compose.ui.focus.FocusOwner
    public void scheduleInvalidation(@NotNull FocusPropertiesModifierNode focusPropertiesModifierNode) {
        Intrinsics.checkNotNullParameter(focusPropertiesModifierNode, "node");
        this.focusInvalidationManager.scheduleInvalidation(focusPropertiesModifierNode);
    }
}
