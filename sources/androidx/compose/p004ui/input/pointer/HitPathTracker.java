package androidx.compose.p004ui.input.pointer;

import androidx.compose.p004ui.layout.LayoutCoordinates;
import androidx.compose.p004ui.node.PointerInputModifierNode;
import androidx.compose.runtime.collection.MutableVector;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes.dex */
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
    public final void m4012addHitPathKNwqfcY(long j, @NotNull List<? extends PointerInputModifierNode> list) {
        Node node;
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
                    Node[] content = children.getContent();
                    int i2 = 0;
                    do {
                        node = content[i2];
                        if (Intrinsics.areEqual(node.getPointerInputNode(), pointerInputModifierNode)) {
                            break;
                        } else {
                            i2++;
                        }
                    } while (i2 < size2);
                }
                node = null;
                Node node2 = node;
                if (node2 != null) {
                    node2.markIsIn();
                    if (!node2.getPointerIds().contains(PointerId.m4063boximpl(j))) {
                        node2.getPointerIds().add(PointerId.m4063boximpl(j));
                    }
                    nodeParent = node2;
                } else {
                    z = false;
                }
            }
            Node node3 = new Node(pointerInputModifierNode);
            node3.getPointerIds().add(PointerId.m4063boximpl(j));
            nodeParent.getChildren().add(node3);
            nodeParent = node3;
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
