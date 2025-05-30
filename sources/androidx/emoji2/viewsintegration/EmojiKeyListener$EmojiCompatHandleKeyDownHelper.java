package androidx.emoji2.viewsintegration;

import android.text.Editable;
import android.view.KeyEvent;
import androidx.annotation.NonNull;
import androidx.emoji2.text.EmojiCompat;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public class EmojiKeyListener$EmojiCompatHandleKeyDownHelper {
    public boolean handleKeyDown(@NonNull Editable editable, int i, @NonNull KeyEvent keyEvent) {
        return EmojiCompat.handleOnKeyDown(editable, i, keyEvent);
    }
}
