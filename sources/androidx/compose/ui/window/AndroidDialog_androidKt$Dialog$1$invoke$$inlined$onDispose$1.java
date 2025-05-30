package androidx.compose.ui.window;

import androidx.compose.runtime.DisposableEffectResult;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class AndroidDialog_androidKt$Dialog$1$invoke$$inlined$onDispose$1 implements DisposableEffectResult {
    final /* synthetic */ DialogWrapper $dialog$inlined;

    public AndroidDialog_androidKt$Dialog$1$invoke$$inlined$onDispose$1(DialogWrapper dialogWrapper) {
        this.$dialog$inlined = dialogWrapper;
    }

    @Override // androidx.compose.runtime.DisposableEffectResult
    public void dispose() {
        this.$dialog$inlined.dismiss();
        this.$dialog$inlined.disposeComposition();
    }
}
