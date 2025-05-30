package androidx.compose.p004ui.node;

import androidx.compose.p004ui.ExperimentalComposeUiApi;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public final class DrawModifierNodeKt {
    @ExperimentalComposeUiApi
    public static final void invalidateDraw(@NotNull DrawModifierNode drawModifierNode) {
        Intrinsics.checkNotNullParameter(drawModifierNode, "<this>");
        if (drawModifierNode.getNode().isAttached()) {
            DelegatableNodeKt.m4288requireCoordinator64DMado(drawModifierNode, NodeKind.m4398constructorimpl(1)).invalidateLayer();
        }
    }
}
