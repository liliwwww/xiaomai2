package androidx.compose.p004ui.text.input;

import android.view.inputmethod.EditorInfo;
import androidx.compose.p004ui.text.TextRange;
import androidx.compose.p004ui.text.input.ImeAction;
import androidx.compose.p004ui.text.input.KeyboardCapitalization;
import androidx.compose.p004ui.text.input.KeyboardType;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import androidx.core.view.inputmethod.EditorInfoCompat;
import androidx.emoji2.text.EmojiCompat;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes.dex */
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
        int m4906getImeActioneUduSuo = imeOptions.m4906getImeActioneUduSuo();
        ImeAction.Companion companion = ImeAction.Companion;
        int i = 6;
        if (ImeAction.m4883equalsimpl0(m4906getImeActioneUduSuo, companion.m4895getDefaulteUduSuo())) {
            if (!imeOptions.getSingleLine()) {
                i = 0;
            }
        } else if (ImeAction.m4883equalsimpl0(m4906getImeActioneUduSuo, companion.m4899getNoneeUduSuo())) {
            i = 1;
        } else if (ImeAction.m4883equalsimpl0(m4906getImeActioneUduSuo, companion.m4897getGoeUduSuo())) {
            i = 2;
        } else if (ImeAction.m4883equalsimpl0(m4906getImeActioneUduSuo, companion.m4898getNexteUduSuo())) {
            i = 5;
        } else if (ImeAction.m4883equalsimpl0(m4906getImeActioneUduSuo, companion.m4900getPreviouseUduSuo())) {
            i = 7;
        } else if (ImeAction.m4883equalsimpl0(m4906getImeActioneUduSuo, companion.m4901getSearcheUduSuo())) {
            i = 3;
        } else if (ImeAction.m4883equalsimpl0(m4906getImeActioneUduSuo, companion.m4902getSendeUduSuo())) {
            i = 4;
        } else if (!ImeAction.m4883equalsimpl0(m4906getImeActioneUduSuo, companion.m4896getDoneeUduSuo())) {
            throw new IllegalStateException("invalid ImeAction".toString());
        }
        editorInfo.imeOptions = i;
        int m4907getKeyboardTypePjHm6EE = imeOptions.m4907getKeyboardTypePjHm6EE();
        KeyboardType.Companion companion2 = KeyboardType.Companion;
        if (KeyboardType.m4929equalsimpl0(m4907getKeyboardTypePjHm6EE, companion2.m4949getTextPjHm6EE())) {
            editorInfo.inputType = 1;
        } else if (KeyboardType.m4929equalsimpl0(m4907getKeyboardTypePjHm6EE, companion2.m4942getAsciiPjHm6EE())) {
            editorInfo.inputType = 1;
            editorInfo.imeOptions |= Integer.MIN_VALUE;
        } else if (KeyboardType.m4929equalsimpl0(m4907getKeyboardTypePjHm6EE, companion2.m4945getNumberPjHm6EE())) {
            editorInfo.inputType = 2;
        } else if (KeyboardType.m4929equalsimpl0(m4907getKeyboardTypePjHm6EE, companion2.m4948getPhonePjHm6EE())) {
            editorInfo.inputType = 3;
        } else if (KeyboardType.m4929equalsimpl0(m4907getKeyboardTypePjHm6EE, companion2.m4950getUriPjHm6EE())) {
            editorInfo.inputType = 17;
        } else if (KeyboardType.m4929equalsimpl0(m4907getKeyboardTypePjHm6EE, companion2.m4944getEmailPjHm6EE())) {
            editorInfo.inputType = 33;
        } else if (KeyboardType.m4929equalsimpl0(m4907getKeyboardTypePjHm6EE, companion2.m4947getPasswordPjHm6EE())) {
            editorInfo.inputType = 129;
        } else if (KeyboardType.m4929equalsimpl0(m4907getKeyboardTypePjHm6EE, companion2.m4946getNumberPasswordPjHm6EE())) {
            editorInfo.inputType = 18;
        } else {
            if (!KeyboardType.m4929equalsimpl0(m4907getKeyboardTypePjHm6EE, companion2.m4943getDecimalPjHm6EE())) {
                throw new IllegalStateException("Invalid Keyboard Type".toString());
            }
            editorInfo.inputType = 8194;
        }
        if (!imeOptions.getSingleLine() && hasFlag(editorInfo.inputType, 1)) {
            editorInfo.inputType |= 131072;
            if (ImeAction.m4883equalsimpl0(imeOptions.m4906getImeActioneUduSuo(), companion.m4895getDefaulteUduSuo())) {
                editorInfo.imeOptions |= BasicMeasure.EXACTLY;
            }
        }
        if (hasFlag(editorInfo.inputType, 1)) {
            int m4905getCapitalizationIUNYP9k = imeOptions.m4905getCapitalizationIUNYP9k();
            KeyboardCapitalization.Companion companion3 = KeyboardCapitalization.Companion;
            if (KeyboardCapitalization.m4914equalsimpl0(m4905getCapitalizationIUNYP9k, companion3.m4922getCharactersIUNYP9k())) {
                editorInfo.inputType |= 4096;
            } else if (KeyboardCapitalization.m4914equalsimpl0(m4905getCapitalizationIUNYP9k, companion3.m4925getWordsIUNYP9k())) {
                editorInfo.inputType |= 8192;
            } else if (KeyboardCapitalization.m4914equalsimpl0(m4905getCapitalizationIUNYP9k, companion3.m4924getSentencesIUNYP9k())) {
                editorInfo.inputType |= 16384;
            }
            if (imeOptions.getAutoCorrect()) {
                editorInfo.inputType |= 32768;
            }
        }
        editorInfo.initialSelStart = TextRange.m4749getStartimpl(textFieldValue.m4956getSelectiond9O1mEE());
        editorInfo.initialSelEnd = TextRange.m4744getEndimpl(textFieldValue.m4956getSelectiond9O1mEE());
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
