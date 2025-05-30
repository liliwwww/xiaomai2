package androidx.compose.ui.node;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class OwnerSnapshotObserver$onCommitAffectingLayout$1 extends Lambda implements Function1<LayoutNode, Unit> {
    public static final OwnerSnapshotObserver$onCommitAffectingLayout$1 INSTANCE = new OwnerSnapshotObserver$onCommitAffectingLayout$1();

    OwnerSnapshotObserver$onCommitAffectingLayout$1() {
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((LayoutNode) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull LayoutNode layoutNode) {
        Intrinsics.checkNotNullParameter(layoutNode, "layoutNode");
        if (layoutNode.isValid()) {
            LayoutNode.requestRelayout$ui_release$default(layoutNode, false, 1, null);
        }
    }
}
