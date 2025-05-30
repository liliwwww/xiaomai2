package androidx.compose.p004ui.text.input;

import androidx.compose.p004ui.geometry.Rect;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public interface PlatformTextInputService {
    void hideSoftwareKeyboard();

    @Deprecated(message = "This method should not be called, used BringIntoViewRequester instead.")
    void notifyFocusedRect(@NotNull Rect rect);

    void showSoftwareKeyboard();

    void startInput(@NotNull TextFieldValue textFieldValue, @NotNull ImeOptions imeOptions, @NotNull Function1<? super List<? extends EditCommand>, Unit> function1, @NotNull Function1<? super ImeAction, Unit> function12);

    void stopInput();

    void updateState(@Nullable TextFieldValue textFieldValue, @NotNull TextFieldValue textFieldValue2);
}
