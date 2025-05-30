package androidx.compose.foundation.layout;

import androidx.compose.runtime.DisposableEffectResult;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class WindowInsetsConnection_androidKt$rememberWindowInsetsConnection$1$invoke$$inlined$onDispose$1 implements DisposableEffectResult {
    final /* synthetic */ WindowInsetsNestedScrollConnection $connection$inlined;

    public WindowInsetsConnection_androidKt$rememberWindowInsetsConnection$1$invoke$$inlined$onDispose$1(WindowInsetsNestedScrollConnection windowInsetsNestedScrollConnection) {
        this.$connection$inlined = windowInsetsNestedScrollConnection;
    }

    @Override // androidx.compose.runtime.DisposableEffectResult
    public void dispose() {
        this.$connection$inlined.dispose();
    }
}
