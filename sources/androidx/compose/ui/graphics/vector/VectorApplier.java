package androidx.compose.ui.graphics.vector;

import androidx.compose.runtime.AbstractApplier;
import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@StabilityInferred(parameters = 0)
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class VectorApplier extends AbstractApplier<VNode> {
    public static final int $stable = 0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VectorApplier(@NotNull VNode vNode) {
        super(vNode);
        Intrinsics.checkNotNullParameter(vNode, "root");
    }

    private final GroupComponent asGroup(VNode vNode) {
        if (vNode instanceof GroupComponent) {
            return (GroupComponent) vNode;
        }
        throw new IllegalStateException("Cannot only insert VNode into Group".toString());
    }

    public void insertBottomUp(int i, @NotNull VNode vNode) {
        Intrinsics.checkNotNullParameter(vNode, "instance");
    }

    public void move(int i, int i2, int i3) {
        asGroup((VNode) getCurrent()).move(i, i2, i3);
    }

    protected void onClear() {
        GroupComponent asGroup = asGroup((VNode) getRoot());
        asGroup.remove(0, asGroup.getNumChildren());
    }

    public void remove(int i, int i2) {
        asGroup((VNode) getCurrent()).remove(i, i2);
    }

    public void insertTopDown(int i, @NotNull VNode vNode) {
        Intrinsics.checkNotNullParameter(vNode, "instance");
        asGroup((VNode) getCurrent()).insertAt(i, vNode);
    }
}
