package androidx.emoji2.text;

import android.text.TextUtils;
import androidx.annotation.NonNull;

/* JADX INFO: Access modifiers changed from: private */
/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public class EmojiProcessor$MarkExclusionCallback implements EmojiProcessor$EmojiProcessCallback<EmojiProcessor$MarkExclusionCallback> {
    private final String mExclusion;

    EmojiProcessor$MarkExclusionCallback(String str) {
        this.mExclusion = str;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.emoji2.text.EmojiProcessor$EmojiProcessCallback
    public EmojiProcessor$MarkExclusionCallback getResult() {
        return this;
    }

    @Override // androidx.emoji2.text.EmojiProcessor$EmojiProcessCallback
    public boolean handleEmoji(@NonNull CharSequence charSequence, int i, int i2, TypefaceEmojiRasterizer typefaceEmojiRasterizer) {
        if (!TextUtils.equals(charSequence.subSequence(i, i2), this.mExclusion)) {
            return true;
        }
        typefaceEmojiRasterizer.setExclusion(true);
        return false;
    }
}
