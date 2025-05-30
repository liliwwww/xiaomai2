package androidx.emoji2.text;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.emoji2.text.EmojiCompat;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
class EmojiCompat$CompatInternal19$1 extends EmojiCompat.MetadataRepoLoaderCallback {
    final /* synthetic */ EmojiCompat.CompatInternal19 this$0;

    EmojiCompat$CompatInternal19$1(EmojiCompat.CompatInternal19 compatInternal19) {
        this.this$0 = compatInternal19;
    }

    public void onFailed(@Nullable Throwable th) {
        ((EmojiCompat.CompatInternal) this.this$0).mEmojiCompat.onMetadataLoadFailed(th);
    }

    public void onLoaded(@NonNull MetadataRepo metadataRepo) {
        this.this$0.onMetadataLoadSuccess(metadataRepo);
    }
}
