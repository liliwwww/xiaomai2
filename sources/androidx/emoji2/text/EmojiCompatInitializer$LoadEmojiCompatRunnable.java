package androidx.emoji2.text;

import androidx.core.os.TraceCompat;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
class EmojiCompatInitializer$LoadEmojiCompatRunnable implements Runnable {
    EmojiCompatInitializer$LoadEmojiCompatRunnable() {
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            TraceCompat.beginSection("EmojiCompat.EmojiCompatInitializer.run");
            if (EmojiCompat.isConfigured()) {
                EmojiCompat.get().load();
            }
        } finally {
            TraceCompat.endSection();
        }
    }
}
