package androidx.core.provider;

import android.net.Uri;
import android.support.v4.media.session.PlaybackStateCompat;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.annotation.RestrictTo$Scope;
import androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat;
import androidx.core.util.Preconditions;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public class FontsContractCompat$FontInfo {
    private final boolean mItalic;
    private final int mResultCode;
    private final int mTtcIndex;
    private final Uri mUri;
    private final int mWeight;

    @RestrictTo({RestrictTo$Scope.LIBRARY_GROUP_PREFIX})
    @Deprecated
    public FontsContractCompat$FontInfo(@NonNull Uri uri, @IntRange(from = 0) int i, @IntRange(from = 1, to = 1000) int i2, boolean z, int i3) {
        this.mUri = (Uri) Preconditions.checkNotNull(uri);
        this.mTtcIndex = i;
        this.mWeight = i2;
        this.mItalic = z;
        this.mResultCode = i3;
    }

    static FontsContractCompat$FontInfo create(@NonNull Uri uri, @IntRange(from = 0) int i, @IntRange(from = 1, to = 1000) int i2, boolean z, int i3) {
        return new FontsContractCompat$FontInfo(uri, i, i2, z, i3);
    }

    public int getResultCode() {
        return this.mResultCode;
    }

    @IntRange(from = 0)
    public int getTtcIndex() {
        return this.mTtcIndex;
    }

    @NonNull
    public Uri getUri() {
        return this.mUri;
    }

    @IntRange(from = PlaybackStateCompat.ACTION_STOP, to = AndroidComposeViewAccessibilityDelegateCompat.TextTraversedEventTimeoutMillis)
    public int getWeight() {
        return this.mWeight;
    }

    public boolean isItalic() {
        return this.mItalic;
    }
}
