package androidx.compose.ui.platform;

import androidx.compose.runtime.DisposableEffectResult;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class AndroidCompositionLocals_androidKt$ProvideAndroidCompositionLocals$2$invoke$$inlined$onDispose$1 implements DisposableEffectResult {
    final /* synthetic */ DisposableSaveableStateRegistry $saveableStateRegistry$inlined;

    public AndroidCompositionLocals_androidKt$ProvideAndroidCompositionLocals$2$invoke$$inlined$onDispose$1(DisposableSaveableStateRegistry disposableSaveableStateRegistry) {
        this.$saveableStateRegistry$inlined = disposableSaveableStateRegistry;
    }

    public void dispose() {
        this.$saveableStateRegistry$inlined.dispose();
    }
}
