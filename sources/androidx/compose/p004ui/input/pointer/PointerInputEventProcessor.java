package androidx.compose.p004ui.input.pointer;

import androidx.compose.p004ui.node.HitTestResult;
import androidx.compose.p004ui.node.LayoutNode;
import androidx.compose.p004ui.node.PointerInputModifierNode;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public final class PointerInputEventProcessor {

    @NotNull
    private final HitPathTracker hitPathTracker;

    @NotNull
    private final HitTestResult<PointerInputModifierNode> hitResult;
    private boolean isProcessing;

    @NotNull
    private final PointerInputChangeEventProducer pointerInputChangeEventProducer;

    @NotNull
    private final LayoutNode root;

    public PointerInputEventProcessor(@NotNull LayoutNode layoutNode) {
        Intrinsics.checkNotNullParameter(layoutNode, "root");
        this.root = layoutNode;
        this.hitPathTracker = new HitPathTracker(layoutNode.getCoordinates());
        this.pointerInputChangeEventProducer = new PointerInputChangeEventProducer();
        this.hitResult = new HitTestResult<>();
    }

    /* renamed from: process-BIzXfog$default, reason: not valid java name */
    public static /* synthetic */ int m4099processBIzXfog$default(PointerInputEventProcessor pointerInputEventProcessor, PointerInputEvent pointerInputEvent, PositionCalculator positionCalculator, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = true;
        }
        return pointerInputEventProcessor.m4100processBIzXfog(pointerInputEvent, positionCalculator, z);
    }

    @NotNull
    public final LayoutNode getRoot() {
        return this.root;
    }

    /* JADX WARN: Removed duplicated region for block: B:72:0x005b A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:74:? A[LOOP:2: B:62:0x003d->B:74:?, LOOP_END, SYNTHETIC] */
    /* renamed from: process-BIzXfog, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int m4100processBIzXfog(@org.jetbrains.annotations.NotNull androidx.compose.p004ui.input.pointer.PointerInputEvent r18, @org.jetbrains.annotations.NotNull androidx.compose.p004ui.input.pointer.PositionCalculator r19, boolean r20) {
        /*
            Method dump skipped, instructions count: 269
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.p004ui.input.pointer.PointerInputEventProcessor.m4100processBIzXfog(androidx.compose.ui.input.pointer.PointerInputEvent, androidx.compose.ui.input.pointer.PositionCalculator, boolean):int");
    }

    public final void processCancel() {
        if (this.isProcessing) {
            return;
        }
        this.pointerInputChangeEventProducer.clear();
        this.hitPathTracker.processCancel();
    }
}
