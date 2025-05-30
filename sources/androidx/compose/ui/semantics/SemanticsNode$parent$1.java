package androidx.compose.ui.semantics;

import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.SemanticsModifierNode;
import androidx.compose.ui.node.SemanticsModifierNodeKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
final class SemanticsNode$parent$1 extends Lambda implements Function1<LayoutNode, Boolean> {
    public static final SemanticsNode$parent$1 INSTANCE = new SemanticsNode$parent$1();

    SemanticsNode$parent$1() {
        super(1);
    }

    @NotNull
    public final Boolean invoke(@NotNull LayoutNode layoutNode) {
        SemanticsConfiguration collapsedSemanticsConfiguration;
        Intrinsics.checkNotNullParameter(layoutNode, "it");
        SemanticsModifierNode outerSemantics = SemanticsNodeKt.getOuterSemantics(layoutNode);
        return Boolean.valueOf((outerSemantics == null || (collapsedSemanticsConfiguration = SemanticsModifierNodeKt.collapsedSemanticsConfiguration(outerSemantics)) == null || !collapsedSemanticsConfiguration.isMergingSemanticsOfDescendants()) ? false : true);
    }
}
