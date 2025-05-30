package androidx.compose.foundation;

import androidx.compose.foundation.HoverableKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.MutableState;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class HoverableKt$hoverable$2$1$1$invoke$$inlined$onDispose$1 implements DisposableEffectResult {
    final /* synthetic */ MutableState $hoverInteraction$delegate$inlined;
    final /* synthetic */ MutableInteractionSource $interactionSource$inlined;

    public HoverableKt$hoverable$2$1$1$invoke$$inlined$onDispose$1(MutableState mutableState, MutableInteractionSource mutableInteractionSource) {
        this.$hoverInteraction$delegate$inlined = mutableState;
        this.$interactionSource$inlined = mutableInteractionSource;
    }

    @Override // androidx.compose.runtime.DisposableEffectResult
    public void dispose() {
        HoverableKt.hoverable.2.access$invoke$tryEmitExit(this.$hoverInteraction$delegate$inlined, this.$interactionSource$inlined);
    }
}
