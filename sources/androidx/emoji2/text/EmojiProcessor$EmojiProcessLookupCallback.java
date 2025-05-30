package androidx.emoji2.text;

import androidx.annotation.NonNull;

/* JADX INFO: Access modifiers changed from: private */
/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public class EmojiProcessor$EmojiProcessLookupCallback implements EmojiProcessor$EmojiProcessCallback<EmojiProcessor$EmojiProcessLookupCallback> {
    private final int mOffset;
    public int start = -1;
    public int end = -1;

    EmojiProcessor$EmojiProcessLookupCallback(int i) {
        this.mOffset = i;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.emoji2.text.EmojiProcessor$EmojiProcessCallback
    public EmojiProcessor$EmojiProcessLookupCallback getResult() {
        return this;
    }

    @Override // androidx.emoji2.text.EmojiProcessor$EmojiProcessCallback
    public boolean handleEmoji(@NonNull CharSequence charSequence, int i, int i2, TypefaceEmojiRasterizer typefaceEmojiRasterizer) {
        int i3 = this.mOffset;
        if (i > i3 || i3 >= i2) {
            return i2 <= i3;
        }
        this.start = i;
        this.end = i2;
        return false;
    }
}
