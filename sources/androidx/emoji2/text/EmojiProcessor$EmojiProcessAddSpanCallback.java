package androidx.emoji2.text;

import android.text.Spannable;
import android.text.SpannableString;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.emoji2.text.EmojiCompat;

/* JADX INFO: Access modifiers changed from: private */
/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public class EmojiProcessor$EmojiProcessAddSpanCallback implements EmojiProcessor$EmojiProcessCallback<UnprecomputeTextOnModificationSpannable> {
    private final EmojiCompat.SpanFactory mSpanFactory;

    @Nullable
    public UnprecomputeTextOnModificationSpannable spannable;

    EmojiProcessor$EmojiProcessAddSpanCallback(@Nullable UnprecomputeTextOnModificationSpannable unprecomputeTextOnModificationSpannable, EmojiCompat.SpanFactory spanFactory) {
        this.spannable = unprecomputeTextOnModificationSpannable;
        this.mSpanFactory = spanFactory;
    }

    @Override // androidx.emoji2.text.EmojiProcessor$EmojiProcessCallback
    public boolean handleEmoji(@NonNull CharSequence charSequence, int i, int i2, TypefaceEmojiRasterizer typefaceEmojiRasterizer) {
        if (typefaceEmojiRasterizer.isPreferredSystemRender()) {
            return true;
        }
        if (this.spannable == null) {
            this.spannable = new UnprecomputeTextOnModificationSpannable(charSequence instanceof Spannable ? (Spannable) charSequence : new SpannableString(charSequence));
        }
        this.spannable.setSpan(this.mSpanFactory.createSpan(typefaceEmojiRasterizer), i, i2, 33);
        return true;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.emoji2.text.EmojiProcessor$EmojiProcessCallback
    public UnprecomputeTextOnModificationSpannable getResult() {
        return this.spannable;
    }
}
