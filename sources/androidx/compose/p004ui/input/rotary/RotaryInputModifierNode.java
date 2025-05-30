package androidx.compose.p004ui.input.rotary;

import androidx.compose.p004ui.ExperimentalComposeUiApi;
import androidx.compose.p004ui.node.DelegatableNode;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@ExperimentalComposeUiApi
/* loaded from: classes.dex */
public interface RotaryInputModifierNode extends DelegatableNode {
    boolean onPreRotaryScrollEvent(@NotNull RotaryScrollEvent rotaryScrollEvent);

    boolean onRotaryScrollEvent(@NotNull RotaryScrollEvent rotaryScrollEvent);
}
