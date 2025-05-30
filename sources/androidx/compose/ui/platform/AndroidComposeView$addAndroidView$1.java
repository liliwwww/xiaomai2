package androidx.compose.ui.platform;

import android.view.View;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.SemanticsModifierNode;
import androidx.compose.ui.semantics.SemanticsNode;
import androidx.compose.ui.semantics.SemanticsNodeKt;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class AndroidComposeView$addAndroidView$1 extends AccessibilityDelegateCompat {
    final /* synthetic */ LayoutNode $layoutNode;
    final /* synthetic */ AndroidComposeView $thisView;
    final /* synthetic */ AndroidComposeView this$0;

    AndroidComposeView$addAndroidView$1(LayoutNode layoutNode, AndroidComposeView androidComposeView, AndroidComposeView androidComposeView2) {
        this.$layoutNode = layoutNode;
        this.this$0 = androidComposeView;
        this.$thisView = androidComposeView2;
    }

    public void onInitializeAccessibilityNodeInfo(@NotNull View view, @NotNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        Intrinsics.checkNotNullParameter(view, "host");
        Intrinsics.checkNotNullParameter(accessibilityNodeInfoCompat, "info");
        super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
        SemanticsModifierNode outerSemantics = SemanticsNodeKt.getOuterSemantics(this.$layoutNode);
        Intrinsics.checkNotNull(outerSemantics);
        SemanticsNode parent = new SemanticsNode(outerSemantics, false, null, 4, null).getParent();
        Intrinsics.checkNotNull(parent);
        int id = parent.getId();
        if (id == this.this$0.getSemanticsOwner().getUnmergedRootSemanticsNode().getId()) {
            id = -1;
        }
        accessibilityNodeInfoCompat.setParent(this.$thisView, id);
    }
}
