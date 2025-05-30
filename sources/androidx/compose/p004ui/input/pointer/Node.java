package androidx.compose.p004ui.input.pointer;

import androidx.compose.p004ui.geometry.Offset;
import androidx.compose.p004ui.layout.LayoutCoordinates;
import androidx.compose.p004ui.node.PointerInputModifierNode;
import androidx.compose.p004ui.node.PointerInputModifierNodeKt;
import androidx.compose.runtime.collection.MutableVector;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public final class Node extends NodeParent {

    @Nullable
    private LayoutCoordinates coordinates;
    private boolean hasExited;
    private boolean isIn;

    @Nullable
    private PointerEvent pointerEvent;

    @NotNull
    private final MutableVector<PointerId> pointerIds;

    @NotNull
    private final PointerInputModifierNode pointerInputNode;

    @NotNull
    private final Map<PointerId, PointerInputChange> relevantChanges;
    private boolean wasIn;

    public Node(@NotNull PointerInputModifierNode pointerInputModifierNode) {
        Intrinsics.checkNotNullParameter(pointerInputModifierNode, "pointerInputNode");
        this.pointerInputNode = pointerInputModifierNode;
        this.pointerIds = new MutableVector<>(new PointerId[16], 0);
        this.relevantChanges = new LinkedHashMap();
        this.isIn = true;
        this.hasExited = true;
    }

    private final void clearCache() {
        this.relevantChanges.clear();
        this.coordinates = null;
    }

    private final boolean dispatchIfNeeded(Function0<Unit> function0) {
        if (this.relevantChanges.isEmpty() || !PointerInputModifierNodeKt.isAttached(this.pointerInputNode)) {
            return false;
        }
        function0.invoke();
        return true;
    }

    private final boolean hasPositionChanged(PointerEvent pointerEvent, PointerEvent pointerEvent2) {
        if (pointerEvent == null || pointerEvent.getChanges().size() != pointerEvent2.getChanges().size()) {
            return true;
        }
        int size = pointerEvent2.getChanges().size();
        for (int i = 0; i < size; i++) {
            if (!Offset.m2553equalsimpl0(pointerEvent.getChanges().get(i).m4081getPositionF1C5BW0(), pointerEvent2.getChanges().get(i).m4081getPositionF1C5BW0())) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x017e  */
    @Override // androidx.compose.p004ui.input.pointer.NodeParent
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean buildCache(@org.jetbrains.annotations.NotNull java.util.Map<androidx.compose.p004ui.input.pointer.PointerId, androidx.compose.p004ui.input.pointer.PointerInputChange> r31, @org.jetbrains.annotations.NotNull androidx.compose.p004ui.layout.LayoutCoordinates r32, @org.jetbrains.annotations.NotNull androidx.compose.p004ui.input.pointer.InternalPointerEvent r33, boolean r34) {
        /*
            Method dump skipped, instructions count: 541
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.p004ui.input.pointer.Node.buildCache(java.util.Map, androidx.compose.ui.layout.LayoutCoordinates, androidx.compose.ui.input.pointer.InternalPointerEvent, boolean):boolean");
    }

    @Override // androidx.compose.p004ui.input.pointer.NodeParent
    public void cleanUpHits(@NotNull InternalPointerEvent internalPointerEvent) {
        Intrinsics.checkNotNullParameter(internalPointerEvent, "internalPointerEvent");
        super.cleanUpHits(internalPointerEvent);
        PointerEvent pointerEvent = this.pointerEvent;
        if (pointerEvent == null) {
            return;
        }
        this.wasIn = this.isIn;
        List<PointerInputChange> changes = pointerEvent.getChanges();
        int size = changes.size();
        for (int i = 0; i < size; i++) {
            PointerInputChange pointerInputChange = changes.get(i);
            if ((pointerInputChange.getPressed() || (internalPointerEvent.m4013issuesEnterExitEvent0FcD4WY(pointerInputChange.m4080getIdJ3iCeTQ()) && this.isIn)) ? false : true) {
                this.pointerIds.remove(PointerId.m4063boximpl(pointerInputChange.m4080getIdJ3iCeTQ()));
            }
        }
        this.isIn = false;
        this.hasExited = PointerEventType.m4033equalsimpl0(pointerEvent.m4026getType7fucELk(), PointerEventType.Companion.m4038getExit7fucELk());
    }

    @Override // androidx.compose.p004ui.input.pointer.NodeParent
    public void dispatchCancel() {
        MutableVector<Node> children = getChildren();
        int size = children.getSize();
        if (size > 0) {
            int i = 0;
            Node[] content = children.getContent();
            do {
                content[i].dispatchCancel();
                i++;
            } while (i < size);
        }
        this.pointerInputNode.onCancelPointerInput();
    }

    @Override // androidx.compose.p004ui.input.pointer.NodeParent
    public boolean dispatchFinalEventPass(@NotNull InternalPointerEvent internalPointerEvent) {
        MutableVector<Node> children;
        int size;
        Intrinsics.checkNotNullParameter(internalPointerEvent, "internalPointerEvent");
        boolean z = true;
        int i = 0;
        if (!this.relevantChanges.isEmpty() && PointerInputModifierNodeKt.isAttached(this.pointerInputNode)) {
            PointerEvent pointerEvent = this.pointerEvent;
            Intrinsics.checkNotNull(pointerEvent);
            LayoutCoordinates layoutCoordinates = this.coordinates;
            Intrinsics.checkNotNull(layoutCoordinates);
            this.pointerInputNode.mo4265onPointerEventH0pRuoY(pointerEvent, PointerEventPass.Final, layoutCoordinates.mo4191getSizeYbymL2g());
            if (PointerInputModifierNodeKt.isAttached(this.pointerInputNode) && (size = (children = getChildren()).getSize()) > 0) {
                Node[] content = children.getContent();
                do {
                    content[i].dispatchFinalEventPass(internalPointerEvent);
                    i++;
                } while (i < size);
            }
        } else {
            z = false;
        }
        cleanUpHits(internalPointerEvent);
        clearCache();
        return z;
    }

    @Override // androidx.compose.p004ui.input.pointer.NodeParent
    public boolean dispatchMainEventPass(@NotNull Map<PointerId, PointerInputChange> map, @NotNull LayoutCoordinates layoutCoordinates, @NotNull InternalPointerEvent internalPointerEvent, boolean z) {
        MutableVector<Node> children;
        int size;
        Intrinsics.checkNotNullParameter(map, "changes");
        Intrinsics.checkNotNullParameter(layoutCoordinates, "parentCoordinates");
        Intrinsics.checkNotNullParameter(internalPointerEvent, "internalPointerEvent");
        int i = 0;
        if (this.relevantChanges.isEmpty() || !PointerInputModifierNodeKt.isAttached(this.pointerInputNode)) {
            return false;
        }
        PointerEvent pointerEvent = this.pointerEvent;
        Intrinsics.checkNotNull(pointerEvent);
        LayoutCoordinates layoutCoordinates2 = this.coordinates;
        Intrinsics.checkNotNull(layoutCoordinates2);
        long mo4191getSizeYbymL2g = layoutCoordinates2.mo4191getSizeYbymL2g();
        this.pointerInputNode.mo4265onPointerEventH0pRuoY(pointerEvent, PointerEventPass.Initial, mo4191getSizeYbymL2g);
        if (PointerInputModifierNodeKt.isAttached(this.pointerInputNode) && (size = (children = getChildren()).getSize()) > 0) {
            Node[] content = children.getContent();
            do {
                Node node = content[i];
                Map<PointerId, PointerInputChange> map2 = this.relevantChanges;
                LayoutCoordinates layoutCoordinates3 = this.coordinates;
                Intrinsics.checkNotNull(layoutCoordinates3);
                node.dispatchMainEventPass(map2, layoutCoordinates3, internalPointerEvent, z);
                i++;
            } while (i < size);
        }
        if (!PointerInputModifierNodeKt.isAttached(this.pointerInputNode)) {
            return true;
        }
        this.pointerInputNode.mo4265onPointerEventH0pRuoY(pointerEvent, PointerEventPass.Main, mo4191getSizeYbymL2g);
        return true;
    }

    @NotNull
    public final MutableVector<PointerId> getPointerIds() {
        return this.pointerIds;
    }

    @NotNull
    public final PointerInputModifierNode getPointerInputNode() {
        return this.pointerInputNode;
    }

    public final void markIsIn() {
        this.isIn = true;
    }

    @NotNull
    public String toString() {
        return "Node(pointerInputFilter=" + this.pointerInputNode + ", children=" + getChildren() + ", pointerIds=" + this.pointerIds + ')';
    }
}
