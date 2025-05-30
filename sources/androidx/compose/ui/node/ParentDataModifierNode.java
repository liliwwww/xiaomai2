package androidx.compose.ui.node;

import androidx.compose.ui.ExperimentalComposeUiApi;
import androidx.compose.ui.unit.Density;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@ExperimentalComposeUiApi
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public interface ParentDataModifierNode extends DelegatableNode {
    @Nullable
    Object modifyParentData(@NotNull Density density, @Nullable Object obj);
}
