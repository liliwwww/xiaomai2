package androidx.multidex;

import android.util.Log;
import dalvik.system.DexFile;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.zip.ZipFile;

/* JADX INFO: Access modifiers changed from: private */
/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class MultiDex$V14 {
    private static final int EXTRACTED_SUFFIX_LENGTH = 4;
    private final ElementConstructor elementConstructor;

    /* compiled from: Taobao */
    private static class ICSElementConstructor implements ElementConstructor {
        private final Constructor<?> elementConstructor;

        ICSElementConstructor(Class<?> cls) throws SecurityException, NoSuchMethodException {
            Constructor<?> constructor = cls.getConstructor(File.class, ZipFile.class, DexFile.class);
            this.elementConstructor = constructor;
            constructor.setAccessible(true);
        }

        public Object newInstance(File file, DexFile dexFile) throws IllegalArgumentException, InstantiationException, IllegalAccessException, InvocationTargetException, IOException {
            return this.elementConstructor.newInstance(file, new ZipFile(file), dexFile);
        }
    }

    /* compiled from: Taobao */
    private static class JBMR11ElementConstructor implements ElementConstructor {
        private final Constructor<?> elementConstructor;

        JBMR11ElementConstructor(Class<?> cls) throws SecurityException, NoSuchMethodException {
            Constructor<?> constructor = cls.getConstructor(File.class, File.class, DexFile.class);
            this.elementConstructor = constructor;
            constructor.setAccessible(true);
        }

        public Object newInstance(File file, DexFile dexFile) throws IllegalArgumentException, InstantiationException, IllegalAccessException, InvocationTargetException {
            return this.elementConstructor.newInstance(file, file, dexFile);
        }
    }

    /* compiled from: Taobao */
    private static class JBMR2ElementConstructor implements ElementConstructor {
        private final Constructor<?> elementConstructor;

        JBMR2ElementConstructor(Class<?> cls) throws SecurityException, NoSuchMethodException {
            Constructor<?> constructor = cls.getConstructor(File.class, Boolean.TYPE, File.class, DexFile.class);
            this.elementConstructor = constructor;
            constructor.setAccessible(true);
        }

        public Object newInstance(File file, DexFile dexFile) throws IllegalArgumentException, InstantiationException, IllegalAccessException, InvocationTargetException {
            return this.elementConstructor.newInstance(file, Boolean.FALSE, file, dexFile);
        }
    }

    private MultiDex$V14() throws ClassNotFoundException, SecurityException, NoSuchMethodException {
        ElementConstructor jBMR2ElementConstructor;
        Class<?> cls = Class.forName("dalvik.system.DexPathList$Element");
        try {
            try {
                jBMR2ElementConstructor = new ICSElementConstructor(cls);
            } catch (NoSuchMethodException unused) {
                jBMR2ElementConstructor = new JBMR11ElementConstructor(cls);
            }
        } catch (NoSuchMethodException unused2) {
            jBMR2ElementConstructor = new JBMR2ElementConstructor(cls);
        }
        this.elementConstructor = jBMR2ElementConstructor;
    }

    static void install(ClassLoader classLoader, List<? extends File> list) throws IOException, SecurityException, IllegalArgumentException, ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchFieldException {
        Object obj = MultiDex.access$000(classLoader, "pathList").get(classLoader);
        Object[] makeDexElements = new MultiDex$V14().makeDexElements(list);
        try {
            MultiDex.access$100(obj, "dexElements", makeDexElements);
        } catch (NoSuchFieldException e) {
            Log.w("MultiDex", "Failed find field 'dexElements' attempting 'pathElements'", e);
            MultiDex.access$100(obj, "pathElements", makeDexElements);
        }
    }

    private Object[] makeDexElements(List<? extends File> list) throws IOException, SecurityException, IllegalArgumentException, InstantiationException, IllegalAccessException, InvocationTargetException {
        int size = list.size();
        Object[] objArr = new Object[size];
        for (int i = 0; i < size; i++) {
            File file = list.get(i);
            objArr[i] = this.elementConstructor.newInstance(file, DexFile.loadDex(file.getPath(), optimizedPathFor(file), 0));
        }
        return objArr;
    }

    private static String optimizedPathFor(File file) {
        File parentFile = file.getParentFile();
        String name = file.getName();
        return new File(parentFile, name.substring(0, name.length() - EXTRACTED_SUFFIX_LENGTH) + ".dex").getPath();
    }
}
