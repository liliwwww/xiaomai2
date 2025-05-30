package androidx.compose.foundation.text.selection;

import androidx.compose.runtime.DisposableEffectResult;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class SelectionContainerKt$SelectionContainer$4$invoke$$inlined$onDispose$1 implements DisposableEffectResult {
    final /* synthetic */ SelectionManager $manager$inlined;

    public SelectionContainerKt$SelectionContainer$4$invoke$$inlined$onDispose$1(SelectionManager selectionManager) {
        this.$manager$inlined = selectionManager;
    }

    public void dispose() {
        this.$manager$inlined.hideSelectionToolbar$foundation_release();
    }
}
