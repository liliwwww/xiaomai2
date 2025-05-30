package androidx.compose.ui.input.rotary;

import androidx.compose.ui.ExperimentalComposeUiApi;
import androidx.compose.ui.node.DelegatableNode;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@ExperimentalComposeUiApi
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public interface RotaryInputModifierNode extends DelegatableNode {
    boolean onPreRotaryScrollEvent(@NotNull RotaryScrollEvent rotaryScrollEvent);

    boolean onRotaryScrollEvent(@NotNull RotaryScrollEvent rotaryScrollEvent);
}
