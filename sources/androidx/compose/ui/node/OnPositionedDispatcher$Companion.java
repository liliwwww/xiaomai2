package androidx.compose.ui.node;

import java.util.Comparator;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class OnPositionedDispatcher$Companion {

    /* compiled from: Taobao */
    private static final class DepthComparator implements Comparator<LayoutNode> {

        @NotNull
        public static final DepthComparator INSTANCE = new DepthComparator();

        private DepthComparator() {
        }

        @Override // java.util.Comparator
        public int compare(@NotNull LayoutNode layoutNode, @NotNull LayoutNode layoutNode2) {
            Intrinsics.checkNotNullParameter(layoutNode, "a");
            Intrinsics.checkNotNullParameter(layoutNode2, "b");
            int compare = Intrinsics.compare(layoutNode2.getDepth$ui_release(), layoutNode.getDepth$ui_release());
            return compare != 0 ? compare : Intrinsics.compare(layoutNode.hashCode(), layoutNode2.hashCode());
        }
    }

    private OnPositionedDispatcher$Companion() {
    }

    public /* synthetic */ OnPositionedDispatcher$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
