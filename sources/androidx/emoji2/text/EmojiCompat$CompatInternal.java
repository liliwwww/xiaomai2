package androidx.emoji2.text;

import android.view.inputmethod.EditorInfo;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;

/* JADX INFO: Access modifiers changed from: private */
/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public class EmojiCompat$CompatInternal {
    final EmojiCompat mEmojiCompat;

    EmojiCompat$CompatInternal(EmojiCompat emojiCompat) {
        this.mEmojiCompat = emojiCompat;
    }

    String getAssetSignature() {
        return "";
    }

    int getEmojiEnd(@NonNull CharSequence charSequence, @IntRange(from = 0) int i) {
        return -1;
    }

    public int getEmojiMatch(CharSequence charSequence, int i) {
        return 0;
    }

    int getEmojiStart(@NonNull CharSequence charSequence, @IntRange(from = 0) int i) {
        return -1;
    }

    boolean hasEmojiGlyph(@NonNull CharSequence charSequence) {
        return false;
    }

    boolean hasEmojiGlyph(@NonNull CharSequence charSequence, int i) {
        return false;
    }

    void loadMetadata() {
        this.mEmojiCompat.onMetadataLoadSuccess();
    }

    CharSequence process(@NonNull CharSequence charSequence, @IntRange(from = 0) int i, @IntRange(from = 0) int i2, @IntRange(from = 0) int i3, boolean z) {
        return charSequence;
    }

    void updateEditorInfoAttrs(@NonNull EditorInfo editorInfo) {
    }
}
