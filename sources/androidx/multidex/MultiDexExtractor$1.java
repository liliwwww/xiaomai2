package androidx.multidex;

import java.io.File;
import java.io.FileFilter;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
class MultiDexExtractor$1 implements FileFilter {
    final /* synthetic */ MultiDexExtractor this$0;

    MultiDexExtractor$1(MultiDexExtractor multiDexExtractor) {
        this.this$0 = multiDexExtractor;
    }

    @Override // java.io.FileFilter
    public boolean accept(File file) {
        return !file.getName().equals("MultiDex.lock");
    }
}
