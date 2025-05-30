package androidx.compose.p004ui.node;

import androidx.compose.p004ui.ExperimentalComposeUiApi;
import androidx.compose.p004ui.unit.Density;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@ExperimentalComposeUiApi
/* loaded from: classes.dex */
public interface ParentDataModifierNode extends DelegatableNode {
    @Nullable
    Object modifyParentData(@NotNull Density density, @Nullable Object obj);
}
