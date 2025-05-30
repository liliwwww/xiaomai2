package androidx.compose.p004ui.node;

import androidx.compose.runtime.AbstractApplier;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tb.ka;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public final class UiApplier extends AbstractApplier<LayoutNode> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UiApplier(@NotNull LayoutNode layoutNode) {
        super(layoutNode);
        Intrinsics.checkNotNullParameter(layoutNode, "root");
    }

    @Override // androidx.compose.runtime.Applier
    public void insertTopDown(int i, @NotNull LayoutNode layoutNode) {
        Intrinsics.checkNotNullParameter(layoutNode, "instance");
    }

    @Override // androidx.compose.runtime.Applier
    public void move(int i, int i2, int i3) {
        getCurrent().move$ui_release(i, i2, i3);
    }

    @Override // androidx.compose.runtime.AbstractApplier
    protected void onClear() {
        getRoot().removeAll$ui_release();
    }

    @Override // androidx.compose.runtime.AbstractApplier, androidx.compose.runtime.Applier
    public void onEndChanges() {
        ka.b(this);
        Owner owner$ui_release = getRoot().getOwner$ui_release();
        if (owner$ui_release != null) {
            owner$ui_release.onEndApplyChanges();
        }
    }

    @Override // androidx.compose.runtime.Applier
    public void remove(int i, int i2) {
        getCurrent().removeAt$ui_release(i, i2);
    }

    @Override // androidx.compose.runtime.Applier
    public void insertBottomUp(int i, @NotNull LayoutNode layoutNode) {
        Intrinsics.checkNotNullParameter(layoutNode, "instance");
        getCurrent().insertAt$ui_release(i, layoutNode);
    }
}
