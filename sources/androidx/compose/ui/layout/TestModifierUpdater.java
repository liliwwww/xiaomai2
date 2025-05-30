package androidx.compose.ui.layout;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.LayoutNode;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@StabilityInferred(parameters = 0)
@Deprecated(level = DeprecationLevel.ERROR, message = "It is a test API, do not use it in the real applications")
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class TestModifierUpdater {
    public static final int $stable = 8;

    @NotNull
    private final LayoutNode node;

    public TestModifierUpdater(@NotNull LayoutNode layoutNode) {
        Intrinsics.checkNotNullParameter(layoutNode, "node");
        this.node = layoutNode;
    }

    public final void updateModifier(@NotNull Modifier modifier) {
        Intrinsics.checkNotNullParameter(modifier, "modifier");
        this.node.setModifier(modifier);
    }
}
