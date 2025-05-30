package androidx.compose.p004ui.platform;

import androidx.compose.p004ui.ExperimentalComposeUiApi;
import androidx.compose.p004ui.text.input.TextInputService;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tb.d35;

/* compiled from: Taobao */
@ExperimentalComposeUiApi
/* loaded from: classes2.dex */
final class DelegatingSoftwareKeyboardController implements SoftwareKeyboardController {

    @NotNull
    private final TextInputService textInputService;

    public DelegatingSoftwareKeyboardController(@NotNull TextInputService textInputService) {
        Intrinsics.checkNotNullParameter(textInputService, "textInputService");
        this.textInputService = textInputService;
    }

    @NotNull
    public final TextInputService getTextInputService() {
        return this.textInputService;
    }

    @Override // androidx.compose.p004ui.platform.SoftwareKeyboardController
    public void hide() {
        this.textInputService.hideSoftwareKeyboard();
    }

    @Override // androidx.compose.p004ui.platform.SoftwareKeyboardController
    public /* synthetic */ void hideSoftwareKeyboard() {
        d35.a(this);
    }

    @Override // androidx.compose.p004ui.platform.SoftwareKeyboardController
    public void show() {
        this.textInputService.showSoftwareKeyboard();
    }

    @Override // androidx.compose.p004ui.platform.SoftwareKeyboardController
    public /* synthetic */ void showSoftwareKeyboard() {
        d35.b(this);
    }
}
