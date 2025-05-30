package androidx.compose.foundation.text;

import androidx.compose.runtime.DisposableEffectResult;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class CoreTextFieldKt$CoreTextField$2$invoke$$inlined$onDispose$1 implements DisposableEffectResult {
    final /* synthetic */ TextFieldState $state$inlined;

    public CoreTextFieldKt$CoreTextField$2$invoke$$inlined$onDispose$1(TextFieldState textFieldState) {
        this.$state$inlined = textFieldState;
    }

    public void dispose() {
        if (this.$state$inlined.getHasFocus()) {
            CoreTextFieldKt.access$onBlur(this.$state$inlined);
        }
    }
}
