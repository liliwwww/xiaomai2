package androidx.compose.p004ui.platform;

import androidx.compose.p004ui.ExperimentalComposeUiApi;
import androidx.compose.runtime.Stable;
import kotlin.Deprecated;
import kotlin.ReplaceWith;

/* compiled from: Taobao */
@Stable
@ExperimentalComposeUiApi
/* loaded from: classes.dex */
public interface SoftwareKeyboardController {
    void hide();

    @Deprecated(message = "Use hide instead.", replaceWith = @ReplaceWith(expression = "hide()", imports = {}))
    void hideSoftwareKeyboard();

    void show();

    @Deprecated(message = "Use show instead.", replaceWith = @ReplaceWith(expression = "show()", imports = {}))
    void showSoftwareKeyboard();
}
