package androidx.emoji2.text;

import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;
import androidx.emoji2.text.FontRequestEmojiCompatConfig;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
class FontRequestEmojiCompatConfig$FontRequestMetadataLoader$1 extends ContentObserver {
    final /* synthetic */ FontRequestEmojiCompatConfig.FontRequestMetadataLoader this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    FontRequestEmojiCompatConfig$FontRequestMetadataLoader$1(FontRequestEmojiCompatConfig.FontRequestMetadataLoader fontRequestMetadataLoader, Handler handler) {
        super(handler);
        this.this$0 = fontRequestMetadataLoader;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z, Uri uri) {
        this.this$0.loadInternal();
    }
}
