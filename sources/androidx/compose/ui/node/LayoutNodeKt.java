package androidx.compose.ui.node;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class LayoutNodeKt {
    private static final boolean DebugChanges = false;

    public static final void add(@NotNull LayoutNode layoutNode, @NotNull LayoutNode layoutNode2) {
        Intrinsics.checkNotNullParameter(layoutNode, "<this>");
        Intrinsics.checkNotNullParameter(layoutNode2, "child");
        layoutNode.insertAt$ui_release(layoutNode.getChildren$ui_release().size(), layoutNode2);
    }

    @NotNull
    public static final Owner requireOwner(@NotNull LayoutNode layoutNode) {
        Intrinsics.checkNotNullParameter(layoutNode, "<this>");
        Owner owner$ui_release = layoutNode.getOwner$ui_release();
        if (owner$ui_release != null) {
            return owner$ui_release;
        }
        throw new IllegalStateException("LayoutNode should be attached to an owner".toString());
    }
}
