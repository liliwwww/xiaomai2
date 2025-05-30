package androidx.compose.runtime.saveable;

import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.saveable.SaveableStateRegistry;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class RememberSaveableKt$rememberSaveable$1$invoke$$inlined$onDispose$1 implements DisposableEffectResult {
    final /* synthetic */ SaveableStateRegistry.Entry $entry$inlined;

    public RememberSaveableKt$rememberSaveable$1$invoke$$inlined$onDispose$1(SaveableStateRegistry.Entry entry) {
        this.$entry$inlined = entry;
    }

    @Override // androidx.compose.runtime.DisposableEffectResult
    public void dispose() {
        this.$entry$inlined.unregister();
    }
}
