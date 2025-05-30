package androidx.activity.compose;

import androidx.compose.runtime.DisposableEffectResult;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class ActivityResultRegistryKt$rememberLauncherForActivityResult$1$invoke$$inlined$onDispose$1 implements DisposableEffectResult {
    final /* synthetic */ ActivityResultLauncherHolder $realLauncher$inlined;

    public ActivityResultRegistryKt$rememberLauncherForActivityResult$1$invoke$$inlined$onDispose$1(ActivityResultLauncherHolder activityResultLauncherHolder) {
        this.$realLauncher$inlined = activityResultLauncherHolder;
    }

    @Override // androidx.compose.runtime.DisposableEffectResult
    public void dispose() {
        this.$realLauncher$inlined.unregister();
    }
}
