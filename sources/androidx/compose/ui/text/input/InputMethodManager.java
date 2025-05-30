package androidx.compose.ui.text.input;

import android.view.inputmethod.ExtractedText;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public interface InputMethodManager {
    void hideSoftInput();

    void restartInput();

    void showSoftInput();

    void updateExtractedText(int i, @NotNull ExtractedText extractedText);

    void updateSelection(int i, int i2, int i3, int i4);
}
