package androidx.compose.ui.autofill;

import androidx.compose.ui.ExperimentalComposeUiApi;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@ExperimentalComposeUiApi
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public interface Autofill {
    void cancelAutofillForNode(@NotNull AutofillNode autofillNode);

    void requestAutofillForNode(@NotNull AutofillNode autofillNode);
}
