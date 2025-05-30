package androidx.compose.p004ui.focus;

import androidx.compose.p004ui.Modifier;
import androidx.compose.p004ui.node.DelegatableNodeKt;
import androidx.compose.p004ui.node.NodeKind;
import androidx.compose.runtime.collection.MutableVector;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public final class FocusInvalidationManager {

    @NotNull
    private Set<FocusEventModifierNode> focusEventNodes;

    @NotNull
    private Set<FocusPropertiesModifierNode> focusPropertiesNodes;

    @NotNull
    private Set<FocusTargetModifierNode> focusTargetNodes;

    @NotNull
    private final Function0<Unit> invalidateNodes;

    @NotNull
    private final Function1<Function0<Unit>, Unit> onRequestApplyChangesListener;

    public FocusInvalidationManager(@NotNull Function1<? super Function0<Unit>, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "onRequestApplyChangesListener");
        this.onRequestApplyChangesListener = function1;
        this.focusTargetNodes = new LinkedHashSet();
        this.focusEventNodes = new LinkedHashSet();
        this.focusPropertiesNodes = new LinkedHashSet();
        this.invalidateNodes = new Function0<Unit>() { // from class: androidx.compose.ui.focus.FocusInvalidationManager$invalidateNodes$1
            {
                super(0);
            }

            public /* bridge */ /* synthetic */ Object invoke() {
                m2497invoke();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2497invoke() {
                Set set;
                Set set2;
                Set<FocusEventModifierNode> set3;
                Set set4;
                Set<FocusTargetModifierNode> set5;
                Set set6;
                Set set7;
                Set set8;
                Set set9;
                FocusState focusState;
                Set set10;
                Set set11;
                set = FocusInvalidationManager.this.focusPropertiesNodes;
                FocusInvalidationManager focusInvalidationManager = FocusInvalidationManager.this;
                Iterator it = set.iterator();
                while (true) {
                    int i = 16;
                    if (!it.hasNext()) {
                        set2 = FocusInvalidationManager.this.focusPropertiesNodes;
                        set2.clear();
                        LinkedHashSet linkedHashSet = new LinkedHashSet();
                        set3 = FocusInvalidationManager.this.focusEventNodes;
                        FocusInvalidationManager focusInvalidationManager2 = FocusInvalidationManager.this;
                        for (FocusEventModifierNode focusEventModifierNode : set3) {
                            if (focusEventModifierNode.getNode().isAttached()) {
                                FocusTargetModifierNode focusTargetModifierNode = null;
                                int m4398constructorimpl = NodeKind.m4398constructorimpl(1024);
                                if (!focusEventModifierNode.getNode().isAttached()) {
                                    throw new IllegalStateException("Check failed.".toString());
                                }
                                MutableVector mutableVector = new MutableVector(new Modifier.Node[i], 0);
                                Modifier.Node child$ui_release = focusEventModifierNode.getNode().getChild$ui_release();
                                if (child$ui_release == null) {
                                    DelegatableNodeKt.addLayoutNodeChildren(mutableVector, focusEventModifierNode.getNode());
                                } else {
                                    mutableVector.add(child$ui_release);
                                }
                                boolean z = true;
                                boolean z2 = false;
                                while (mutableVector.isNotEmpty()) {
                                    Modifier.Node node = (Modifier.Node) mutableVector.removeAt(mutableVector.getSize() - 1);
                                    if ((node.getAggregateChildKindSet$ui_release() & m4398constructorimpl) == 0) {
                                        DelegatableNodeKt.addLayoutNodeChildren(mutableVector, node);
                                    } else {
                                        while (true) {
                                            if (node == null) {
                                                break;
                                            }
                                            if ((node.getKindSet$ui_release() & m4398constructorimpl) == 0) {
                                                node = node.getChild$ui_release();
                                            } else if (node instanceof FocusTargetModifierNode) {
                                                FocusTargetModifierNode focusTargetModifierNode2 = (FocusTargetModifierNode) node;
                                                if (focusTargetModifierNode != null) {
                                                    z2 = true;
                                                }
                                                set10 = focusInvalidationManager2.focusTargetNodes;
                                                if (set10.contains(focusTargetModifierNode2)) {
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
                        set4 = FocusInvalidationManager.this.focusEventNodes;
                        set4.clear();
                        set5 = FocusInvalidationManager.this.focusTargetNodes;
                        for (FocusTargetModifierNode focusTargetModifierNode3 : set5) {
                            if (focusTargetModifierNode3.isAttached()) {
                                FocusState focusState2 = focusTargetModifierNode3.getFocusState();
                                focusTargetModifierNode3.invalidateFocus$ui_release();
                                if (!Intrinsics.areEqual(focusState2, focusTargetModifierNode3.getFocusState()) || linkedHashSet.contains(focusTargetModifierNode3)) {
                                    FocusEventModifierKt.refreshFocusEventNodes(focusTargetModifierNode3);
                                }
                            }
                        }
                        set6 = FocusInvalidationManager.this.focusTargetNodes;
                        set6.clear();
                        linkedHashSet.clear();
                        set7 = FocusInvalidationManager.this.focusPropertiesNodes;
                        if (!set7.isEmpty()) {
                            throw new IllegalStateException("Check failed.".toString());
                        }
                        set8 = FocusInvalidationManager.this.focusEventNodes;
                        if (!set8.isEmpty()) {
                            throw new IllegalStateException("Check failed.".toString());
                        }
                        set9 = FocusInvalidationManager.this.focusTargetNodes;
                        if (!set9.isEmpty()) {
                            throw new IllegalStateException("Check failed.".toString());
                        }
                        return;
                    }
                    FocusPropertiesModifierNode focusPropertiesModifierNode = (FocusPropertiesModifierNode) it.next();
                    int m4398constructorimpl2 = NodeKind.m4398constructorimpl(1024);
                    if (!focusPropertiesModifierNode.getNode().isAttached()) {
                        throw new IllegalStateException("Check failed.".toString());
                    }
                    MutableVector mutableVector2 = new MutableVector(new Modifier.Node[16], 0);
                    Modifier.Node child$ui_release2 = focusPropertiesModifierNode.getNode().getChild$ui_release();
                    if (child$ui_release2 == null) {
                        DelegatableNodeKt.addLayoutNodeChildren(mutableVector2, focusPropertiesModifierNode.getNode());
                    } else {
                        mutableVector2.add(child$ui_release2);
                    }
                    while (mutableVector2.isNotEmpty()) {
                        Modifier.Node node2 = (Modifier.Node) mutableVector2.removeAt(mutableVector2.getSize() - 1);
                        if ((node2.getAggregateChildKindSet$ui_release() & m4398constructorimpl2) == 0) {
                            DelegatableNodeKt.addLayoutNodeChildren(mutableVector2, node2);
                        } else {
                            while (true) {
                                if (node2 == null) {
                                    break;
                                }
                                if ((node2.getKindSet$ui_release() & m4398constructorimpl2) == 0) {
                                    node2 = node2.getChild$ui_release();
                                } else if (node2 instanceof FocusTargetModifierNode) {
                                    set11 = focusInvalidationManager.focusTargetNodes;
                                    set11.add((FocusTargetModifierNode) node2);
                                }
                            }
                        }
                    }
                }
            }
        };
    }

    public final void scheduleInvalidation(@NotNull FocusTargetModifierNode focusTargetModifierNode) {
        Intrinsics.checkNotNullParameter(focusTargetModifierNode, "node");
        scheduleInvalidation(this.focusTargetNodes, focusTargetModifierNode);
    }

    public final void scheduleInvalidation(@NotNull FocusEventModifierNode focusEventModifierNode) {
        Intrinsics.checkNotNullParameter(focusEventModifierNode, "node");
        scheduleInvalidation(this.focusEventNodes, focusEventModifierNode);
    }

    public final void scheduleInvalidation(@NotNull FocusPropertiesModifierNode focusPropertiesModifierNode) {
        Intrinsics.checkNotNullParameter(focusPropertiesModifierNode, "node");
        scheduleInvalidation(this.focusPropertiesNodes, focusPropertiesModifierNode);
    }

    private final <T> void scheduleInvalidation(Set<T> set, T t) {
        if (set.contains(t)) {
            return;
        }
        set.add(t);
        if (this.focusTargetNodes.size() + this.focusEventNodes.size() + this.focusPropertiesNodes.size() == 1) {
            this.onRequestApplyChangesListener.invoke(this.invalidateNodes);
        }
    }
}
