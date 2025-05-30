package androidx.compose.ui.node;

import androidx.compose.ui.platform.ViewConfiguration;
import java.util.Comparator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class LayoutNode$Companion {
    private LayoutNode$Companion() {
    }

    public /* synthetic */ LayoutNode$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @NotNull
    public final Function0<LayoutNode> getConstructor$ui_release() {
        return LayoutNode.access$getConstructor$cp();
    }

    @NotNull
    public final ViewConfiguration getDummyViewConfiguration$ui_release() {
        return LayoutNode.access$getDummyViewConfiguration$cp();
    }

    @NotNull
    public final Comparator<LayoutNode> getZComparator$ui_release() {
        return LayoutNode.access$getZComparator$cp();
    }
}
