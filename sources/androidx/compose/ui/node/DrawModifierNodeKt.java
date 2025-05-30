package androidx.compose.ui.node;

import androidx.compose.ui.ExperimentalComposeUiApi;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class DrawModifierNodeKt {
    @ExperimentalComposeUiApi
    public static final void invalidateDraw(@NotNull DrawModifierNode drawModifierNode) {
        Intrinsics.checkNotNullParameter(drawModifierNode, "<this>");
        if (drawModifierNode.getNode().isAttached()) {
            DelegatableNodeKt.m1600requireCoordinator64DMado(drawModifierNode, NodeKind.m1660constructorimpl(1)).invalidateLayer();
        }
    }
}
