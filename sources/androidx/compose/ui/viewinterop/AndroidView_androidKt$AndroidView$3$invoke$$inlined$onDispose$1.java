package androidx.compose.ui.viewinterop;

import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.saveable.SaveableStateRegistry;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class AndroidView_androidKt$AndroidView$3$invoke$$inlined$onDispose$1 implements DisposableEffectResult {
    final /* synthetic */ SaveableStateRegistry.Entry $entry$inlined;

    public AndroidView_androidKt$AndroidView$3$invoke$$inlined$onDispose$1(SaveableStateRegistry.Entry entry) {
        this.$entry$inlined = entry;
    }

    @Override // androidx.compose.runtime.DisposableEffectResult
    public void dispose() {
        this.$entry$inlined.unregister();
    }
}
