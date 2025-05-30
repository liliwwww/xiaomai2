package androidx.compose.ui.platform;

import android.content.Context;
import androidx.compose.runtime.DisposableEffectResult;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class AndroidCompositionLocals_androidKt$obtainImageVectorCache$1$invoke$$inlined$onDispose$1 implements DisposableEffectResult {
    final /* synthetic */ AndroidCompositionLocals_androidKt$obtainImageVectorCache$callbacks$1$1 $callbacks$inlined;
    final /* synthetic */ Context $context$inlined;

    public AndroidCompositionLocals_androidKt$obtainImageVectorCache$1$invoke$$inlined$onDispose$1(Context context, AndroidCompositionLocals_androidKt$obtainImageVectorCache$callbacks$1$1 androidCompositionLocals_androidKt$obtainImageVectorCache$callbacks$1$1) {
        this.$context$inlined = context;
        this.$callbacks$inlined = androidCompositionLocals_androidKt$obtainImageVectorCache$callbacks$1$1;
    }

    public void dispose() {
        this.$context$inlined.getApplicationContext().unregisterComponentCallbacks(this.$callbacks$inlined);
    }
}
