package androidx.compose.foundation;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.interaction.PressInteraction;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.MutableState;
import java.util.Iterator;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class ClickableKt$PressedInteractionSourceDisposableEffect$1$invoke$$inlined$onDispose$1 implements DisposableEffectResult {
    final /* synthetic */ Map $currentKeyPressInteractions$inlined;
    final /* synthetic */ MutableInteractionSource $interactionSource$inlined;
    final /* synthetic */ MutableState $pressedInteraction$inlined;

    public ClickableKt$PressedInteractionSourceDisposableEffect$1$invoke$$inlined$onDispose$1(MutableState mutableState, Map map, MutableInteractionSource mutableInteractionSource) {
        this.$pressedInteraction$inlined = mutableState;
        this.$currentKeyPressInteractions$inlined = map;
        this.$interactionSource$inlined = mutableInteractionSource;
    }

    @Override // androidx.compose.runtime.DisposableEffectResult
    public void dispose() {
        PressInteraction.Press press = (PressInteraction.Press) this.$pressedInteraction$inlined.getValue();
        if (press != null) {
            this.$interactionSource$inlined.tryEmit(new PressInteraction.Cancel(press));
            this.$pressedInteraction$inlined.setValue(null);
        }
        Iterator it = this.$currentKeyPressInteractions$inlined.values().iterator();
        while (it.hasNext()) {
            this.$interactionSource$inlined.tryEmit(new PressInteraction.Cancel((PressInteraction.Press) it.next()));
        }
        this.$currentKeyPressInteractions$inlined.clear();
    }
}
