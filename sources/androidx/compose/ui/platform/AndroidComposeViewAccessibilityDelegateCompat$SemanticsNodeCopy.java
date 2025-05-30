package androidx.compose.ui.platform;

import androidx.annotation.VisibleForTesting;
import androidx.compose.ui.semantics.SemanticsConfiguration;
import androidx.compose.ui.semantics.SemanticsNode;
import androidx.compose.ui.semantics.SemanticsProperties;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@VisibleForTesting
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class AndroidComposeViewAccessibilityDelegateCompat$SemanticsNodeCopy {

    @NotNull
    private final Set<Integer> children;

    @NotNull
    private final SemanticsNode semanticsNode;

    @NotNull
    private final SemanticsConfiguration unmergedConfig;

    public AndroidComposeViewAccessibilityDelegateCompat$SemanticsNodeCopy(@NotNull SemanticsNode semanticsNode, @NotNull Map<Integer, SemanticsNodeWithAdjustedBounds> map) {
        Intrinsics.checkNotNullParameter(semanticsNode, "semanticsNode");
        Intrinsics.checkNotNullParameter(map, "currentSemanticsNodes");
        this.semanticsNode = semanticsNode;
        this.unmergedConfig = semanticsNode.getUnmergedConfig$ui_release();
        this.children = new LinkedHashSet();
        List<SemanticsNode> replacedChildren$ui_release = semanticsNode.getReplacedChildren$ui_release();
        int size = replacedChildren$ui_release.size();
        for (int i = 0; i < size; i++) {
            SemanticsNode semanticsNode2 = replacedChildren$ui_release.get(i);
            if (map.containsKey(Integer.valueOf(semanticsNode2.getId()))) {
                this.children.add(Integer.valueOf(semanticsNode2.getId()));
            }
        }
    }

    @NotNull
    public final Set<Integer> getChildren() {
        return this.children;
    }

    @NotNull
    public final SemanticsNode getSemanticsNode() {
        return this.semanticsNode;
    }

    @NotNull
    public final SemanticsConfiguration getUnmergedConfig() {
        return this.unmergedConfig;
    }

    public final boolean hasPaneTitle() {
        return this.unmergedConfig.contains(SemanticsProperties.INSTANCE.getPaneTitle());
    }
}
