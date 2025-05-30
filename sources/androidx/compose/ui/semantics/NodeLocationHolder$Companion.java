package androidx.compose.ui.semantics;

import androidx.compose.ui.semantics.NodeLocationHolder;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class NodeLocationHolder$Companion {
    private NodeLocationHolder$Companion() {
    }

    public /* synthetic */ NodeLocationHolder$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @NotNull
    public final NodeLocationHolder.ComparisonStrategy getComparisonStrategy$ui_release() {
        return NodeLocationHolder.access$getComparisonStrategy$cp();
    }

    public final void setComparisonStrategy$ui_release(@NotNull NodeLocationHolder.ComparisonStrategy comparisonStrategy) {
        Intrinsics.checkNotNullParameter(comparisonStrategy, "<set-?>");
        NodeLocationHolder.access$setComparisonStrategy$cp(comparisonStrategy);
    }
}
