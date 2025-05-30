package androidx.compose.ui.platform;

import androidx.compose.ui.ExperimentalComposeUiApi;
import androidx.compose.ui.text.input.TextInputService;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tb.d35;

/* compiled from: Taobao */
@ExperimentalComposeUiApi
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
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

    public void hide() {
        this.textInputService.hideSoftwareKeyboard();
    }

    public /* synthetic */ void hideSoftwareKeyboard() {
        d35.a(this);
    }

    public void show() {
        this.textInputService.showSoftwareKeyboard();
    }

    public /* synthetic */ void showSoftwareKeyboard() {
        d35.b(this);
    }
}
