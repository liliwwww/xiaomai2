package androidx.emoji2.text;

import android.view.inputmethod.EditorInfo;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.emoji2.text.EmojiCompat;

/* JADX INFO: Access modifiers changed from: private */
/* compiled from: Taobao */
@RequiresApi(19)
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class EmojiCompat$CompatInternal19 extends EmojiCompat$CompatInternal {
    private volatile MetadataRepo mMetadataRepo;
    private volatile EmojiProcessor mProcessor;

    EmojiCompat$CompatInternal19(EmojiCompat emojiCompat) {
        super(emojiCompat);
    }

    @Override // androidx.emoji2.text.EmojiCompat$CompatInternal
    String getAssetSignature() {
        String sourceSha = this.mMetadataRepo.getMetadataList().sourceSha();
        return sourceSha == null ? "" : sourceSha;
    }

    @Override // androidx.emoji2.text.EmojiCompat$CompatInternal
    int getEmojiEnd(@NonNull CharSequence charSequence, int i) {
        return this.mProcessor.getEmojiEnd(charSequence, i);
    }

    @Override // androidx.emoji2.text.EmojiCompat$CompatInternal
    public int getEmojiMatch(CharSequence charSequence, int i) {
        return this.mProcessor.getEmojiMatch(charSequence, i);
    }

    @Override // androidx.emoji2.text.EmojiCompat$CompatInternal
    int getEmojiStart(@NonNull CharSequence charSequence, int i) {
        return this.mProcessor.getEmojiStart(charSequence, i);
    }

    @Override // androidx.emoji2.text.EmojiCompat$CompatInternal
    boolean hasEmojiGlyph(@NonNull CharSequence charSequence) {
        return this.mProcessor.getEmojiMatch(charSequence) == 1;
    }

    @Override // androidx.emoji2.text.EmojiCompat$CompatInternal
    void loadMetadata() {
        try {
            this.mEmojiCompat.mMetadataLoader.load(new 1(this));
        } catch (Throwable th) {
            this.mEmojiCompat.onMetadataLoadFailed(th);
        }
    }

    void onMetadataLoadSuccess(@NonNull MetadataRepo metadataRepo) {
        if (metadataRepo == null) {
            this.mEmojiCompat.onMetadataLoadFailed(new IllegalArgumentException("metadataRepo cannot be null"));
            return;
        }
        this.mMetadataRepo = metadataRepo;
        MetadataRepo metadataRepo2 = this.mMetadataRepo;
        EmojiCompat.SpanFactory access$000 = EmojiCompat.access$000(this.mEmojiCompat);
        EmojiCompat.GlyphChecker access$100 = EmojiCompat.access$100(this.mEmojiCompat);
        EmojiCompat emojiCompat = this.mEmojiCompat;
        this.mProcessor = new EmojiProcessor(metadataRepo2, access$000, access$100, emojiCompat.mUseEmojiAsDefaultStyle, emojiCompat.mEmojiAsDefaultStyleExceptions, EmojiExclusions.getEmojiExclusions());
        this.mEmojiCompat.onMetadataLoadSuccess();
    }

    @Override // androidx.emoji2.text.EmojiCompat$CompatInternal
    CharSequence process(@NonNull CharSequence charSequence, int i, int i2, int i3, boolean z) {
        return this.mProcessor.process(charSequence, i, i2, i3, z);
    }

    @Override // androidx.emoji2.text.EmojiCompat$CompatInternal
    void updateEditorInfoAttrs(@NonNull EditorInfo editorInfo) {
        editorInfo.extras.putInt("android.support.text.emoji.emojiCompat_metadataVersion", this.mMetadataRepo.getMetadataVersion());
        editorInfo.extras.putBoolean("android.support.text.emoji.emojiCompat_replaceAll", this.mEmojiCompat.mReplaceAll);
    }

    @Override // androidx.emoji2.text.EmojiCompat$CompatInternal
    boolean hasEmojiGlyph(@NonNull CharSequence charSequence, int i) {
        return this.mProcessor.getEmojiMatch(charSequence, i) == 1;
    }
}
