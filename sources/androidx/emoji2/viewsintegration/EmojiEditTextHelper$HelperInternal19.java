package androidx.emoji2.viewsintegration;

import android.text.method.KeyListener;
import android.text.method.NumberKeyListener;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.emoji2.viewsintegration.EmojiEditTextHelper;

/* JADX INFO: Access modifiers changed from: private */
/* compiled from: Taobao */
@RequiresApi(19)
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public class EmojiEditTextHelper$HelperInternal19 extends EmojiEditTextHelper.HelperInternal {
    private final EditText mEditText;
    private final EmojiTextWatcher mTextWatcher;

    EmojiEditTextHelper$HelperInternal19(@NonNull EditText editText, boolean z) {
        this.mEditText = editText;
        EmojiTextWatcher emojiTextWatcher = new EmojiTextWatcher(editText, z);
        this.mTextWatcher = emojiTextWatcher;
        editText.addTextChangedListener(emojiTextWatcher);
        editText.setEditableFactory(EmojiEditableFactory.getInstance());
    }

    KeyListener getKeyListener(@Nullable KeyListener keyListener) {
        if (keyListener instanceof EmojiKeyListener) {
            return keyListener;
        }
        if (keyListener == null) {
            return null;
        }
        return keyListener instanceof NumberKeyListener ? keyListener : new EmojiKeyListener(keyListener);
    }

    boolean isEnabled() {
        return this.mTextWatcher.isEnabled();
    }

    InputConnection onCreateInputConnection(@NonNull InputConnection inputConnection, @NonNull EditorInfo editorInfo) {
        return inputConnection instanceof EmojiInputConnection ? inputConnection : new EmojiInputConnection(this.mEditText, inputConnection, editorInfo);
    }

    void setEmojiReplaceStrategy(int i) {
        this.mTextWatcher.setEmojiReplaceStrategy(i);
    }

    void setEnabled(boolean z) {
        this.mTextWatcher.setEnabled(z);
    }

    void setMaxEmojiCount(int i) {
        this.mTextWatcher.setMaxEmojiCount(i);
    }
}
