package androidx.compose.ui.input.pointer;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.node.PointerInputModifierNode;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class HitPathTracker {

    @NotNull
    private final NodeParent root;

    @NotNull
    private final LayoutCoordinates rootCoordinates;

    public HitPathTracker(@NotNull LayoutCoordinates layoutCoordinates) {
        Intrinsics.checkNotNullParameter(layoutCoordinates, "rootCoordinates");
        this.rootCoordinates = layoutCoordinates;
        this.root = new NodeParent();
    }

    public static /* synthetic */ boolean dispatchChanges$default(HitPathTracker hitPathTracker, InternalPointerEvent internalPointerEvent, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        return hitPathTracker.dispatchChanges(internalPointerEvent, z);
    }

    /* renamed from: addHitPath-KNwqfcY, reason: not valid java name */
    public final void m1411addHitPathKNwqfcY(long j, @NotNull List<? extends PointerInputModifierNode> list) {
        Object obj;
        Intrinsics.checkNotNullParameter(list, "pointerInputNodes");
        NodeParent nodeParent = this.root;
        int size = list.size();
        boolean z = true;
        for (int i = 0; i < size; i++) {
            PointerInputModifierNode pointerInputModifierNode = list.get(i);
            if (z) {
                MutableVector<Node> children = nodeParent.getChildren();
                int size2 = children.getSize();
                if (size2 > 0) {
                    Object[] content = children.getContent();
                    int i2 = 0;
                    do {
                        obj = content[i2];
                        if (Intrinsics.areEqual(((Node) obj).getPointerInputNode(), pointerInputModifierNode)) {
                            break;
                        } else {
                            i2++;
                        }
                    } while (i2 < size2);
                }
                obj = null;
                NodeParent nodeParent2 = (Node) obj;
                if (nodeParent2 != null) {
                    nodeParent2.markIsIn();
                    if (!nodeParent2.getPointerIds().contains(PointerId.m1447boximpl(j))) {
                        nodeParent2.getPointerIds().add(PointerId.m1447boximpl(j));
                    }
                    nodeParent = nodeParent2;
                } else {
                    z = false;
                }
            }
            NodeParent node = new Node(pointerInputModifierNode);
            node.getPointerIds().add(PointerId.m1447boximpl(j));
            nodeParent.getChildren().add(node);
            nodeParent = node;
        }
    }

    public final boolean dispatchChanges(@NotNull InternalPointerEvent internalPointerEvent, boolean z) {
        Intrinsics.checkNotNullParameter(internalPointerEvent, "internalPointerEvent");
        if (this.root.buildCache(internalPointerEvent.getChanges(), this.rootCoordinates, internalPointerEvent, z)) {
            return this.root.dispatchFinalEventPass(internalPointerEvent) || this.root.dispatchMainEventPass(internalPointerEvent.getChanges(), this.rootCoordinates, internalPointerEvent, z);
        }
        return false;
    }

    @NotNull
    public final NodeParent getRoot$ui_release() {
        return this.root;
    }

    public final void processCancel() {
        this.root.dispatchCancel();
        this.root.clear();
    }

    public final void removeDetachedPointerInputFilters() {
        this.root.removeDetachedPointerInputFilters();
    }
}
