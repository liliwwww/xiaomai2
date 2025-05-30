package androidx.compose.p004ui.node;

import androidx.compose.p004ui.layout.LayoutCoordinates;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public final class PointerInputModifierNodeKt {
    @NotNull
    public static final LayoutCoordinates getLayoutCoordinates(@NotNull PointerInputModifierNode pointerInputModifierNode) {
        Intrinsics.checkNotNullParameter(pointerInputModifierNode, "<this>");
        return DelegatableNodeKt.m4288requireCoordinator64DMado(pointerInputModifierNode, NodeKind.m4398constructorimpl(16));
    }

    public static /* synthetic */ void getLayoutCoordinates$annotations(PointerInputModifierNode pointerInputModifierNode) {
    }

    public static final boolean isAttached(@NotNull PointerInputModifierNode pointerInputModifierNode) {
        Intrinsics.checkNotNullParameter(pointerInputModifierNode, "<this>");
        return pointerInputModifierNode.getNode().isAttached();
    }

    public static /* synthetic */ void isAttached$annotations(PointerInputModifierNode pointerInputModifierNode) {
    }
}
