package androidx.core.content.res;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class FontResourcesParserCompat$FontFileResourceEntry {

    @NonNull
    private final String mFileName;
    private final boolean mItalic;
    private final int mResourceId;
    private final int mTtcIndex;
    private final String mVariationSettings;
    private final int mWeight;

    public FontResourcesParserCompat$FontFileResourceEntry(@NonNull String str, int i, boolean z, @Nullable String str2, int i2, int i3) {
        this.mFileName = str;
        this.mWeight = i;
        this.mItalic = z;
        this.mVariationSettings = str2;
        this.mTtcIndex = i2;
        this.mResourceId = i3;
    }

    @NonNull
    public String getFileName() {
        return this.mFileName;
    }

    public int getResourceId() {
        return this.mResourceId;
    }

    public int getTtcIndex() {
        return this.mTtcIndex;
    }

    @Nullable
    public String getVariationSettings() {
        return this.mVariationSettings;
    }

    public int getWeight() {
        return this.mWeight;
    }

    public boolean isItalic() {
        return this.mItalic;
    }
}
