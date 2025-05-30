package androidx.compose.ui.text.input;

import android.view.inputmethod.EditorInfo;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.input.ImeAction;
import androidx.compose.ui.text.input.KeyboardCapitalization;
import androidx.compose.ui.text.input.KeyboardType;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.inputmethod.EditorInfoCompat;
import androidx.emoji2.text.EmojiCompat;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class TextInputServiceAndroid_androidKt {

    @NotNull
    private static final String DEBUG_CLASS = "TextInputServiceAndroid";

    private static final boolean hasFlag(int i, int i2) {
        return (i & i2) == i2;
    }

    public static final void update(@NotNull EditorInfo editorInfo, @NotNull ImeOptions imeOptions, @NotNull TextFieldValue textFieldValue) {
        Intrinsics.checkNotNullParameter(editorInfo, "<this>");
        Intrinsics.checkNotNullParameter(imeOptions, "imeOptions");
        Intrinsics.checkNotNullParameter(textFieldValue, "textFieldValue");
        int m1970getImeActioneUduSuo = imeOptions.m1970getImeActioneUduSuo();
        ImeAction.Companion companion = ImeAction.Companion;
        int i = 6;
        if (ImeAction.m1947equalsimpl0(m1970getImeActioneUduSuo, companion.m1959getDefaulteUduSuo())) {
            if (!imeOptions.getSingleLine()) {
                i = 0;
            }
        } else if (ImeAction.m1947equalsimpl0(m1970getImeActioneUduSuo, companion.m1963getNoneeUduSuo())) {
            i = 1;
        } else if (ImeAction.m1947equalsimpl0(m1970getImeActioneUduSuo, companion.m1961getGoeUduSuo())) {
            i = 2;
        } else if (ImeAction.m1947equalsimpl0(m1970getImeActioneUduSuo, companion.m1962getNexteUduSuo())) {
            i = 5;
        } else if (ImeAction.m1947equalsimpl0(m1970getImeActioneUduSuo, companion.m1964getPreviouseUduSuo())) {
            i = 7;
        } else if (ImeAction.m1947equalsimpl0(m1970getImeActioneUduSuo, companion.m1965getSearcheUduSuo())) {
            i = 3;
        } else if (ImeAction.m1947equalsimpl0(m1970getImeActioneUduSuo, companion.m1966getSendeUduSuo())) {
            i = 4;
        } else if (!ImeAction.m1947equalsimpl0(m1970getImeActioneUduSuo, companion.m1960getDoneeUduSuo())) {
            throw new IllegalStateException("invalid ImeAction".toString());
        }
        editorInfo.imeOptions = i;
        int m1971getKeyboardTypePjHm6EE = imeOptions.m1971getKeyboardTypePjHm6EE();
        KeyboardType.Companion companion2 = KeyboardType.Companion;
        if (KeyboardType.m1976equalsimpl0(m1971getKeyboardTypePjHm6EE, companion2.getText-PjHm6EE())) {
            editorInfo.inputType = 1;
        } else if (KeyboardType.m1976equalsimpl0(m1971getKeyboardTypePjHm6EE, companion2.getAscii-PjHm6EE())) {
            editorInfo.inputType = 1;
            editorInfo.imeOptions |= Integer.MIN_VALUE;
        } else if (KeyboardType.m1976equalsimpl0(m1971getKeyboardTypePjHm6EE, companion2.getNumber-PjHm6EE())) {
            editorInfo.inputType = 2;
        } else if (KeyboardType.m1976equalsimpl0(m1971getKeyboardTypePjHm6EE, companion2.getPhone-PjHm6EE())) {
            editorInfo.inputType = 3;
        } else if (KeyboardType.m1976equalsimpl0(m1971getKeyboardTypePjHm6EE, companion2.getUri-PjHm6EE())) {
            editorInfo.inputType = 17;
        } else if (KeyboardType.m1976equalsimpl0(m1971getKeyboardTypePjHm6EE, companion2.getEmail-PjHm6EE())) {
            editorInfo.inputType = 33;
        } else if (KeyboardType.m1976equalsimpl0(m1971getKeyboardTypePjHm6EE, companion2.getPassword-PjHm6EE())) {
            editorInfo.inputType = 129;
        } else if (KeyboardType.m1976equalsimpl0(m1971getKeyboardTypePjHm6EE, companion2.getNumberPassword-PjHm6EE())) {
            editorInfo.inputType = 18;
        } else {
            if (!KeyboardType.m1976equalsimpl0(m1971getKeyboardTypePjHm6EE, companion2.getDecimal-PjHm6EE())) {
                throw new IllegalStateException("Invalid Keyboard Type".toString());
            }
            editorInfo.inputType = 8194;
        }
        if (!imeOptions.getSingleLine() && hasFlag(editorInfo.inputType, 1)) {
            editorInfo.inputType |= AccessibilityNodeInfoCompat.ACTION_SET_SELECTION;
            if (ImeAction.m1947equalsimpl0(imeOptions.m1970getImeActioneUduSuo(), companion.m1959getDefaulteUduSuo())) {
                editorInfo.imeOptions |= 1073741824;
            }
        }
        if (hasFlag(editorInfo.inputType, 1)) {
            int m1969getCapitalizationIUNYP9k = imeOptions.m1969getCapitalizationIUNYP9k();
            KeyboardCapitalization.Companion companion3 = KeyboardCapitalization.Companion;
            if (KeyboardCapitalization.equals-impl0(m1969getCapitalizationIUNYP9k, companion3.getCharacters-IUNYP9k())) {
                editorInfo.inputType |= 4096;
            } else if (KeyboardCapitalization.equals-impl0(m1969getCapitalizationIUNYP9k, companion3.getWords-IUNYP9k())) {
                editorInfo.inputType |= 8192;
            } else if (KeyboardCapitalization.equals-impl0(m1969getCapitalizationIUNYP9k, companion3.getSentences-IUNYP9k())) {
                editorInfo.inputType |= AccessibilityNodeInfoCompat.ACTION_COPY;
            }
            if (imeOptions.getAutoCorrect()) {
                editorInfo.inputType |= AccessibilityNodeInfoCompat.ACTION_PASTE;
            }
        }
        editorInfo.initialSelStart = TextRange.getStart-impl(textFieldValue.m1985getSelectiond9O1mEE());
        editorInfo.initialSelEnd = TextRange.getEnd-impl(textFieldValue.m1985getSelectiond9O1mEE());
        EditorInfoCompat.setInitialSurroundingText(editorInfo, textFieldValue.getText());
        editorInfo.imeOptions |= 33554432;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateWithEmojiCompat(EditorInfo editorInfo) {
        if (EmojiCompat.isConfigured()) {
            EmojiCompat.get().updateEditorInfo(editorInfo);
        }
    }
}
