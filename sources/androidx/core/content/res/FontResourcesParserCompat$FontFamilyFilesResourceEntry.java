package androidx.core.content.res;

import androidx.annotation.NonNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class FontResourcesParserCompat$FontFamilyFilesResourceEntry implements FontResourcesParserCompat$FamilyResourceEntry {

    @NonNull
    private final FontResourcesParserCompat$FontFileResourceEntry[] mEntries;

    public FontResourcesParserCompat$FontFamilyFilesResourceEntry(@NonNull FontResourcesParserCompat$FontFileResourceEntry[] fontResourcesParserCompat$FontFileResourceEntryArr) {
        this.mEntries = fontResourcesParserCompat$FontFileResourceEntryArr;
    }

    @NonNull
    public FontResourcesParserCompat$FontFileResourceEntry[] getEntries() {
        return this.mEntries;
    }
}
