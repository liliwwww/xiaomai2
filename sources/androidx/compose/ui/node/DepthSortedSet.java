package androidx.compose.ui.node;

import java.util.Comparator;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class DepthSortedSet {

    @NotNull
    private final Comparator<LayoutNode> DepthComparator;
    private final boolean extraAssertions;

    @NotNull
    private final Lazy mapOfOriginalDepth$delegate;

    @NotNull
    private final TreeSet<LayoutNode> set;

    public DepthSortedSet() {
        this(false, 1, null);
    }

    public DepthSortedSet(boolean z) {
        this.extraAssertions = z;
        this.mapOfOriginalDepth$delegate = LazyKt.lazy(LazyThreadSafetyMode.NONE, mapOfOriginalDepth.2.INSTANCE);
        Comparator<LayoutNode> comparator = new Comparator<LayoutNode>() { // from class: androidx.compose.ui.node.DepthSortedSet$DepthComparator$1
            @Override // java.util.Comparator
            public int compare(@NotNull LayoutNode layoutNode, @NotNull LayoutNode layoutNode2) {
                Intrinsics.checkNotNullParameter(layoutNode, "l1");
                Intrinsics.checkNotNullParameter(layoutNode2, "l2");
                int compare = Intrinsics.compare(layoutNode.getDepth$ui_release(), layoutNode2.getDepth$ui_release());
                return compare != 0 ? compare : Intrinsics.compare(layoutNode.hashCode(), layoutNode2.hashCode());
            }
        };
        this.DepthComparator = comparator;
        this.set = new TreeSet<>(comparator);
    }

    private final Map<LayoutNode, Integer> getMapOfOriginalDepth() {
        return (Map) this.mapOfOriginalDepth$delegate.getValue();
    }

    public final void add(@NotNull LayoutNode layoutNode) {
        Intrinsics.checkNotNullParameter(layoutNode, "node");
        if (!layoutNode.isAttached()) {
            throw new IllegalStateException("Check failed.".toString());
        }
        if (this.extraAssertions) {
            Integer num = getMapOfOriginalDepth().get(layoutNode);
            if (num == null) {
                getMapOfOriginalDepth().put(layoutNode, Integer.valueOf(layoutNode.getDepth$ui_release()));
            } else {
                if (!(num.intValue() == layoutNode.getDepth$ui_release())) {
                    throw new IllegalStateException("Check failed.".toString());
                }
            }
        }
        this.set.add(layoutNode);
    }

    public final boolean contains(@NotNull LayoutNode layoutNode) {
        Intrinsics.checkNotNullParameter(layoutNode, "node");
        boolean contains = this.set.contains(layoutNode);
        if (this.extraAssertions) {
            if (!(contains == getMapOfOriginalDepth().containsKey(layoutNode))) {
                throw new IllegalStateException("Check failed.".toString());
            }
        }
        return contains;
    }

    public final boolean isEmpty() {
        return this.set.isEmpty();
    }

    public final boolean isNotEmpty() {
        return !isEmpty();
    }

    @NotNull
    public final LayoutNode pop() {
        LayoutNode first = this.set.first();
        Intrinsics.checkNotNullExpressionValue(first, "node");
        remove(first);
        return first;
    }

    public final void popEach(@NotNull Function1<? super LayoutNode, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "block");
        while (!isEmpty()) {
            function1.invoke(pop());
        }
    }

    public final boolean remove(@NotNull LayoutNode layoutNode) {
        Intrinsics.checkNotNullParameter(layoutNode, "node");
        if (!layoutNode.isAttached()) {
            throw new IllegalStateException("Check failed.".toString());
        }
        boolean remove = this.set.remove(layoutNode);
        if (this.extraAssertions) {
            Integer remove2 = getMapOfOriginalDepth().remove(layoutNode);
            if (remove) {
                if (!(remove2 != null && remove2.intValue() == layoutNode.getDepth$ui_release())) {
                    throw new IllegalStateException("Check failed.".toString());
                }
            } else {
                if (!(remove2 == null)) {
                    throw new IllegalStateException("Check failed.".toString());
                }
            }
        }
        return remove;
    }

    @NotNull
    public String toString() {
        String treeSet = this.set.toString();
        Intrinsics.checkNotNullExpressionValue(treeSet, "set.toString()");
        return treeSet;
    }

    public /* synthetic */ DepthSortedSet(boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? true : z);
    }
}
