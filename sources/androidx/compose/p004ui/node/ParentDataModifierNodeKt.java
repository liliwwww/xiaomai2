package androidx.compose.p004ui.node;

import androidx.compose.p004ui.ExperimentalComposeUiApi;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public final class ParentDataModifierNodeKt {
    @ExperimentalComposeUiApi
    public static final void invalidateParentData(@NotNull ParentDataModifierNode parentDataModifierNode) {
        Intrinsics.checkNotNullParameter(parentDataModifierNode, "<this>");
        DelegatableNodeKt.requireLayoutNode(parentDataModifierNode).invalidateParentData$ui_release();
    }
}
