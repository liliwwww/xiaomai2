package androidx.compose.foundation;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.interaction.PressInteraction$Cancel;
import androidx.compose.foundation.interaction.PressInteraction$Press;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.MutableState;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class ClickableKt$combinedClickable$4$1$1$invoke$$inlined$onDispose$1 implements DisposableEffectResult {
    final /* synthetic */ MutableInteractionSource $interactionSource$inlined;
    final /* synthetic */ MutableState $pressedInteraction$inlined;

    public ClickableKt$combinedClickable$4$1$1$invoke$$inlined$onDispose$1(MutableState mutableState, MutableInteractionSource mutableInteractionSource) {
        this.$pressedInteraction$inlined = mutableState;
        this.$interactionSource$inlined = mutableInteractionSource;
    }

    public void dispose() {
        PressInteraction$Press pressInteraction$Press = (PressInteraction$Press) this.$pressedInteraction$inlined.getValue();
        if (pressInteraction$Press != null) {
            this.$interactionSource$inlined.tryEmit(new PressInteraction$Cancel(pressInteraction$Press));
            this.$pressedInteraction$inlined.setValue((Object) null);
        }
    }
}
