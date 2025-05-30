package androidx.compose.p004ui.text.input;

import android.view.inputmethod.ExtractedText;
import androidx.compose.p004ui.text.TextRange;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public final class InputState_androidKt {
    @NotNull
    public static final ExtractedText toExtractedText(@NotNull TextFieldValue textFieldValue) {
        Intrinsics.checkNotNullParameter(textFieldValue, "<this>");
        ExtractedText extractedText = new ExtractedText();
        extractedText.text = textFieldValue.getText();
        extractedText.startOffset = 0;
        extractedText.partialEndOffset = textFieldValue.getText().length();
        extractedText.partialStartOffset = -1;
        extractedText.selectionStart = TextRange.m4747getMinimpl(textFieldValue.m4956getSelectiond9O1mEE());
        extractedText.selectionEnd = TextRange.m4746getMaximpl(textFieldValue.m4956getSelectiond9O1mEE());
        extractedText.flags = !StringsKt.contains$default(textFieldValue.getText(), '\n', false, 2, (Object) null) ? 1 : 0;
        return extractedText;
    }
}
