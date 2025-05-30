package androidx.emoji2.text;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.WorkerThread;
import androidx.emoji2.text.EmojiCompat;
import java.util.concurrent.ThreadPoolExecutor;

/* compiled from: Taobao */
@RequiresApi(19)
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
class EmojiCompatInitializer$BackgroundDefaultLoader implements EmojiCompat.MetadataRepoLoader {
    private final Context mContext;

    EmojiCompatInitializer$BackgroundDefaultLoader(Context context) {
        this.mContext = context.getApplicationContext();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @WorkerThread
    /* renamed from: doLoad, reason: merged with bridge method [inline-methods] */
    public void lambda$load$0(@NonNull final EmojiCompat$MetadataRepoLoaderCallback emojiCompat$MetadataRepoLoaderCallback, @NonNull final ThreadPoolExecutor threadPoolExecutor) {
        try {
            FontRequestEmojiCompatConfig create = DefaultEmojiCompatConfig.create(this.mContext);
            if (create == null) {
                throw new RuntimeException("EmojiCompat font provider not available on this device.");
            }
            create.setLoadingExecutor(threadPoolExecutor);
            create.getMetadataRepoLoader().load(new EmojiCompat$MetadataRepoLoaderCallback() { // from class: androidx.emoji2.text.EmojiCompatInitializer$BackgroundDefaultLoader.1
                @Override // androidx.emoji2.text.EmojiCompat$MetadataRepoLoaderCallback
                public void onFailed(@Nullable Throwable th) {
                    try {
                        emojiCompat$MetadataRepoLoaderCallback.onFailed(th);
                    } finally {
                        threadPoolExecutor.shutdown();
                    }
                }

                @Override // androidx.emoji2.text.EmojiCompat$MetadataRepoLoaderCallback
                public void onLoaded(@NonNull MetadataRepo metadataRepo) {
                    try {
                        emojiCompat$MetadataRepoLoaderCallback.onLoaded(metadataRepo);
                    } finally {
                        threadPoolExecutor.shutdown();
                    }
                }
            });
        } catch (Throwable th) {
            emojiCompat$MetadataRepoLoaderCallback.onFailed(th);
            threadPoolExecutor.shutdown();
        }
    }

    public void load(@NonNull final EmojiCompat$MetadataRepoLoaderCallback emojiCompat$MetadataRepoLoaderCallback) {
        final ThreadPoolExecutor createBackgroundPriorityExecutor = ConcurrencyHelpers.createBackgroundPriorityExecutor("EmojiCompatInitializer");
        createBackgroundPriorityExecutor.execute(new Runnable() { // from class: androidx.emoji2.text.b
            @Override // java.lang.Runnable
            public final void run() {
                EmojiCompatInitializer$BackgroundDefaultLoader.this.lambda$load$0(emojiCompat$MetadataRepoLoaderCallback, createBackgroundPriorityExecutor);
            }
        });
    }
}
