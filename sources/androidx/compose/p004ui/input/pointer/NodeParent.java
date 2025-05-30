package androidx.compose.p004ui.input.pointer;

import androidx.compose.p004ui.layout.LayoutCoordinates;
import androidx.compose.p004ui.node.PointerInputModifierNodeKt;
import androidx.compose.runtime.collection.MutableVector;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class NodeParent {

    @NotNull
    private final MutableVector<Node> children = new MutableVector<>(new Node[16], 0);

    public boolean buildCache(@NotNull Map<PointerId, PointerInputChange> map, @NotNull LayoutCoordinates layoutCoordinates, @NotNull InternalPointerEvent internalPointerEvent, boolean z) {
        Intrinsics.checkNotNullParameter(map, "changes");
        Intrinsics.checkNotNullParameter(layoutCoordinates, "parentCoordinates");
        Intrinsics.checkNotNullParameter(internalPointerEvent, "internalPointerEvent");
        MutableVector<Node> mutableVector = this.children;
        int size = mutableVector.getSize();
        if (size <= 0) {
            return false;
        }
        Node[] content = mutableVector.getContent();
        int i = 0;
        boolean z2 = false;
        do {
            z2 = content[i].buildCache(map, layoutCoordinates, internalPointerEvent, z) || z2;
            i++;
        } while (i < size);
        return z2;
    }

    public void cleanUpHits(@NotNull InternalPointerEvent internalPointerEvent) {
        Intrinsics.checkNotNullParameter(internalPointerEvent, "internalPointerEvent");
        int size = this.children.getSize();
        while (true) {
            size--;
            if (-1 >= size) {
                return;
            }
            if (this.children.getContent()[size].getPointerIds().isEmpty()) {
                this.children.removeAt(size);
            }
        }
    }

    public final void clear() {
        this.children.clear();
    }

    public void dispatchCancel() {
        MutableVector<Node> mutableVector = this.children;
        int size = mutableVector.getSize();
        if (size > 0) {
            int i = 0;
            Node[] content = mutableVector.getContent();
            do {
                content[i].dispatchCancel();
                i++;
            } while (i < size);
        }
    }

    public boolean dispatchFinalEventPass(@NotNull InternalPointerEvent internalPointerEvent) {
        Intrinsics.checkNotNullParameter(internalPointerEvent, "internalPointerEvent");
        MutableVector<Node> mutableVector = this.children;
        int size = mutableVector.getSize();
        boolean z = false;
        if (size > 0) {
            Node[] content = mutableVector.getContent();
            int i = 0;
            boolean z2 = false;
            do {
                z2 = content[i].dispatchFinalEventPass(internalPointerEvent) || z2;
                i++;
            } while (i < size);
            z = z2;
        }
        cleanUpHits(internalPointerEvent);
        return z;
    }

    public boolean dispatchMainEventPass(@NotNull Map<PointerId, PointerInputChange> map, @NotNull LayoutCoordinates layoutCoordinates, @NotNull InternalPointerEvent internalPointerEvent, boolean z) {
        Intrinsics.checkNotNullParameter(map, "changes");
        Intrinsics.checkNotNullParameter(layoutCoordinates, "parentCoordinates");
        Intrinsics.checkNotNullParameter(internalPointerEvent, "internalPointerEvent");
        MutableVector<Node> mutableVector = this.children;
        int size = mutableVector.getSize();
        if (size <= 0) {
            return false;
        }
        Node[] content = mutableVector.getContent();
        int i = 0;
        boolean z2 = false;
        do {
            z2 = content[i].dispatchMainEventPass(map, layoutCoordinates, internalPointerEvent, z) || z2;
            i++;
        } while (i < size);
        return z2;
    }

    @NotNull
    public final MutableVector<Node> getChildren() {
        return this.children;
    }

    public final void removeDetachedPointerInputFilters() {
        int i = 0;
        while (i < this.children.getSize()) {
            Node node = this.children.getContent()[i];
            if (PointerInputModifierNodeKt.isAttached(node.getPointerInputNode())) {
                i++;
                node.removeDetachedPointerInputFilters();
            } else {
                this.children.removeAt(i);
                node.dispatchCancel();
            }
        }
    }
}
