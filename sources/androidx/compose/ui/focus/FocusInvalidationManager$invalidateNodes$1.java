package androidx.compose.ui.focus;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.NodeKind;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class FocusInvalidationManager$invalidateNodes$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ FocusInvalidationManager this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    FocusInvalidationManager$invalidateNodes$1(FocusInvalidationManager focusInvalidationManager) {
        super(0);
        this.this$0 = focusInvalidationManager;
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m982invoke();
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: collision with other method in class */
    public final void m982invoke() {
        FocusState focusState;
        Set access$getFocusPropertiesNodes$p = FocusInvalidationManager.access$getFocusPropertiesNodes$p(this.this$0);
        FocusInvalidationManager focusInvalidationManager = this.this$0;
        Iterator it = access$getFocusPropertiesNodes$p.iterator();
        while (true) {
            int i = 16;
            if (!it.hasNext()) {
                FocusInvalidationManager.access$getFocusPropertiesNodes$p(this.this$0).clear();
                LinkedHashSet linkedHashSet = new LinkedHashSet();
                Set<FocusEventModifierNode> access$getFocusEventNodes$p = FocusInvalidationManager.access$getFocusEventNodes$p(this.this$0);
                FocusInvalidationManager focusInvalidationManager2 = this.this$0;
                for (FocusEventModifierNode focusEventModifierNode : access$getFocusEventNodes$p) {
                    if (focusEventModifierNode.getNode().isAttached()) {
                        FocusTargetModifierNode focusTargetModifierNode = null;
                        int i2 = NodeKind.constructor-impl(AccessibilityEventCompat.TYPE_TOUCH_EXPLORATION_GESTURE_END);
                        if (!focusEventModifierNode.getNode().isAttached()) {
                            throw new IllegalStateException("Check failed.".toString());
                        }
                        MutableVector mutableVector = new MutableVector(new Modifier.Node[i], 0);
                        Modifier.Node child$ui_release = focusEventModifierNode.getNode().getChild$ui_release();
                        if (child$ui_release == null) {
                            DelegatableNodeKt.access$addLayoutNodeChildren(mutableVector, focusEventModifierNode.getNode());
                        } else {
                            mutableVector.add(child$ui_release);
                        }
                        boolean z = true;
                        boolean z2 = false;
                        while (mutableVector.isNotEmpty()) {
                            Modifier.Node node = (Modifier.Node) mutableVector.removeAt(mutableVector.getSize() - 1);
                            if ((node.getAggregateChildKindSet$ui_release() & i2) == 0) {
                                DelegatableNodeKt.access$addLayoutNodeChildren(mutableVector, node);
                            } else {
                                while (true) {
                                    if (node == null) {
                                        break;
                                    }
                                    if ((node.getKindSet$ui_release() & i2) == 0) {
                                        node = node.getChild$ui_release();
                                    } else if (node instanceof FocusTargetModifierNode) {
                                        FocusTargetModifierNode focusTargetModifierNode2 = (FocusTargetModifierNode) node;
                                        if (focusTargetModifierNode != null) {
                                            z2 = true;
                                        }
                                        if (FocusInvalidationManager.access$getFocusTargetNodes$p(focusInvalidationManager2).contains(focusTargetModifierNode2)) {
                                            linkedHashSet.add(focusTargetModifierNode2);
                                            z = false;
                                        }
                                        focusTargetModifierNode = focusTargetModifierNode2;
                                    }
                                }
                            }
                        }
                        if (z) {
                            if (z2) {
                                focusState = FocusEventModifierKt.getFocusState(focusEventModifierNode);
                            } else if (focusTargetModifierNode == null || (focusState = focusTargetModifierNode.getFocusState()) == null) {
                                focusState = FocusStateImpl.Inactive;
                            }
                            focusEventModifierNode.onFocusEvent(focusState);
                        }
                    }
                    i = 16;
                }
                FocusInvalidationManager.access$getFocusEventNodes$p(this.this$0).clear();
                for (FocusTargetModifierNode focusTargetModifierNode3 : FocusInvalidationManager.access$getFocusTargetNodes$p(this.this$0)) {
                    if (focusTargetModifierNode3.isAttached()) {
                        FocusState focusState2 = focusTargetModifierNode3.getFocusState();
                        focusTargetModifierNode3.invalidateFocus$ui_release();
                        if (!Intrinsics.areEqual(focusState2, focusTargetModifierNode3.getFocusState()) || linkedHashSet.contains(focusTargetModifierNode3)) {
                            FocusEventModifierKt.refreshFocusEventNodes(focusTargetModifierNode3);
                        }
                    }
                }
                FocusInvalidationManager.access$getFocusTargetNodes$p(this.this$0).clear();
                linkedHashSet.clear();
                if (!FocusInvalidationManager.access$getFocusPropertiesNodes$p(this.this$0).isEmpty()) {
                    throw new IllegalStateException("Check failed.".toString());
                }
                if (!FocusInvalidationManager.access$getFocusEventNodes$p(this.this$0).isEmpty()) {
                    throw new IllegalStateException("Check failed.".toString());
                }
                if (!FocusInvalidationManager.access$getFocusTargetNodes$p(this.this$0).isEmpty()) {
                    throw new IllegalStateException("Check failed.".toString());
                }
                return;
            }
            FocusPropertiesModifierNode focusPropertiesModifierNode = (FocusPropertiesModifierNode) it.next();
            int i3 = NodeKind.constructor-impl(AccessibilityEventCompat.TYPE_TOUCH_EXPLORATION_GESTURE_END);
            if (!focusPropertiesModifierNode.getNode().isAttached()) {
                throw new IllegalStateException("Check failed.".toString());
            }
            MutableVector mutableVector2 = new MutableVector(new Modifier.Node[16], 0);
            Modifier.Node child$ui_release2 = focusPropertiesModifierNode.getNode().getChild$ui_release();
            if (child$ui_release2 == null) {
                DelegatableNodeKt.access$addLayoutNodeChildren(mutableVector2, focusPropertiesModifierNode.getNode());
            } else {
                mutableVector2.add(child$ui_release2);
            }
            while (mutableVector2.isNotEmpty()) {
                Modifier.Node node2 = (Modifier.Node) mutableVector2.removeAt(mutableVector2.getSize() - 1);
                if ((node2.getAggregateChildKindSet$ui_release() & i3) == 0) {
                    DelegatableNodeKt.access$addLayoutNodeChildren(mutableVector2, node2);
                } else {
                    while (true) {
                        if (node2 == null) {
                            break;
                        }
                        if ((node2.getKindSet$ui_release() & i3) == 0) {
                            node2 = node2.getChild$ui_release();
                        } else if (node2 instanceof FocusTargetModifierNode) {
                            FocusInvalidationManager.access$getFocusTargetNodes$p(focusInvalidationManager).add((FocusTargetModifierNode) node2);
                        }
                    }
                }
            }
        }
    }
}
