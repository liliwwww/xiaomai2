package androidx.compose.ui.node;

import androidx.compose.runtime.AbstractApplier;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tb.ka;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class UiApplier extends AbstractApplier<LayoutNode> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UiApplier(@NotNull LayoutNode layoutNode) {
        super(layoutNode);
        Intrinsics.checkNotNullParameter(layoutNode, "root");
    }

    public void insertTopDown(int i, @NotNull LayoutNode layoutNode) {
        Intrinsics.checkNotNullParameter(layoutNode, "instance");
    }

    public void move(int i, int i2, int i3) {
        ((LayoutNode) getCurrent()).move$ui_release(i, i2, i3);
    }

    protected void onClear() {
        ((LayoutNode) getRoot()).removeAll$ui_release();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onEndChanges() {
        ka.b(this);
        Owner owner$ui_release = ((LayoutNode) getRoot()).getOwner$ui_release();
        if (owner$ui_release != null) {
            owner$ui_release.onEndApplyChanges();
        }
    }

    public void remove(int i, int i2) {
        ((LayoutNode) getCurrent()).removeAt$ui_release(i, i2);
    }

    public void insertBottomUp(int i, @NotNull LayoutNode layoutNode) {
        Intrinsics.checkNotNullParameter(layoutNode, "instance");
        ((LayoutNode) getCurrent()).insertAt$ui_release(i, layoutNode);
    }
}
