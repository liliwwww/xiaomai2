package androidx.multidex;

import dalvik.system.DexFile;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.List;
import java.util.ListIterator;
import java.util.zip.ZipFile;

/* JADX INFO: Access modifiers changed from: private */
/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class MultiDex$V4 {
    private MultiDex$V4() {
    }

    static void install(ClassLoader classLoader, List<? extends File> list) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, IOException {
        int size = list.size();
        Field access$000 = MultiDex.access$000(classLoader, "path");
        StringBuilder sb = new StringBuilder((String) access$000.get(classLoader));
        String[] strArr = new String[size];
        File[] fileArr = new File[size];
        ZipFile[] zipFileArr = new ZipFile[size];
        DexFile[] dexFileArr = new DexFile[size];
        ListIterator<? extends File> listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            File next = listIterator.next();
            String absolutePath = next.getAbsolutePath();
            sb.append(':');
            sb.append(absolutePath);
            int previousIndex = listIterator.previousIndex();
            strArr[previousIndex] = absolutePath;
            fileArr[previousIndex] = next;
            zipFileArr[previousIndex] = new ZipFile(next);
            dexFileArr[previousIndex] = DexFile.loadDex(absolutePath, absolutePath + ".dex", 0);
        }
        access$000.set(classLoader, sb.toString());
        MultiDex.access$100(classLoader, "mPaths", strArr);
        MultiDex.access$100(classLoader, "mFiles", fileArr);
        MultiDex.access$100(classLoader, "mZips", zipFileArr);
        MultiDex.access$100(classLoader, "mDexs", dexFileArr);
    }
}
