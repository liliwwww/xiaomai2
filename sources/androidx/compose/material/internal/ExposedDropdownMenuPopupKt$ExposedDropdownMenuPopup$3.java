package androidx.compose.material.internal;

import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.ui.window.PopupPositionProvider;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class ExposedDropdownMenuPopupKt$ExposedDropdownMenuPopup$3 extends Lambda implements Function1<DisposableEffectScope, DisposableEffectResult> {
    final /* synthetic */ PopupLayout $popupLayout;
    final /* synthetic */ PopupPositionProvider $popupPositionProvider;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ExposedDropdownMenuPopupKt$ExposedDropdownMenuPopup$3(PopupLayout popupLayout, PopupPositionProvider popupPositionProvider) {
        super(1);
        this.$popupLayout = popupLayout;
        this.$popupPositionProvider = popupPositionProvider;
    }

    @NotNull
    public final DisposableEffectResult invoke(@NotNull DisposableEffectScope disposableEffectScope) {
        Intrinsics.checkNotNullParameter(disposableEffectScope, "$this$DisposableEffect");
        this.$popupLayout.setPositionProvider(this.$popupPositionProvider);
        this.$popupLayout.updatePosition();
        return new DisposableEffectResult() { // from class: androidx.compose.material.internal.ExposedDropdownMenuPopupKt$ExposedDropdownMenuPopup$3$invoke$$inlined$onDispose$1
            public void dispose() {
            }
        };
    }
}
