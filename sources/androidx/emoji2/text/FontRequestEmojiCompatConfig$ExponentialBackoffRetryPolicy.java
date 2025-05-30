package androidx.emoji2.text;

import android.os.SystemClock;
import androidx.emoji2.text.FontRequestEmojiCompatConfig;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public class FontRequestEmojiCompatConfig$ExponentialBackoffRetryPolicy extends FontRequestEmojiCompatConfig.RetryPolicy {
    private long mRetryOrigin;
    private final long mTotalMs;

    public FontRequestEmojiCompatConfig$ExponentialBackoffRetryPolicy(long j) {
        this.mTotalMs = j;
    }

    public long getRetryDelay() {
        if (this.mRetryOrigin == 0) {
            this.mRetryOrigin = SystemClock.uptimeMillis();
            return 0L;
        }
        long uptimeMillis = SystemClock.uptimeMillis() - this.mRetryOrigin;
        if (uptimeMillis > this.mTotalMs) {
            return -1L;
        }
        return Math.min(Math.max(uptimeMillis, 1000L), this.mTotalMs - uptimeMillis);
    }
}
