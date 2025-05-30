package com.ali.mobisecenhance.ld.multidex;

import android.content.SharedPreferences;
import com.j2c.enhance.SoLoad992979061;
import dalvik.system.DexFile;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipFile;

/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
abstract class DexLoader {
    ElementConstructor mElementConstructor;

    interface ElementConstructor {
        Object newInstance(File file, Object obj) throws IllegalArgumentException, InstantiationException, IllegalAccessException, InvocationTargetException, IOException;
    }

    DexLoader() {
    }

    static DexLoader create(int sdkInt) {
        if (sdkInt >= 19) {
            return new V19();
        }
        if (sdkInt >= 14) {
            return new V14();
        }
        throw new UnsupportedOperationException("only support SDK_INT >= 14, give up when < 14");
    }

    void install(ClassLoader loader, List<DexHolder> dexHolderList, SharedPreferences preferences) throws Exception {
        Field pathListField = Utility.findFieldRecursively(loader.getClass(), "pathList");
        Object dexPathList = pathListField.get(loader);
        Object[] elements = makeDexElements(dexHolderList, preferences);
        Utility.expandFieldArray(dexPathList, "dexElements", elements);
    }

    void install(ClassLoader loader, List<DexHolder> dexHolderList) throws Exception {
        Field pathListField = Utility.findFieldRecursively(loader.getClass(), "pathList");
        Object dexPathList = pathListField.get(loader);
        ArrayList<Object> elements = new ArrayList<>();
        for (int i = 0; i < dexHolderList.size(); i++) {
            DexHolder dexHolder = dexHolderList.get(i);
            elements.add(dexHolder.toDexListElement(this.mElementConstructor));
            Monitor.get().logInfo("Install holder: " + dexHolder.getClass().getName() + ", index " + i);
        }
        Utility.expandFieldArray(dexPathList, "dexElements", elements.toArray());
    }

    private Object[] makeDexElements(List<DexHolder> dexHolderList, SharedPreferences preferences) throws Exception {
        ArrayList<Object> elements = new ArrayList<>();
        for (int i = 0; i < dexHolderList.size(); i++) {
            DexHolder dexHolder = dexHolderList.get(i);
            Object element = dexHolder.toDexListElement(this.mElementConstructor);
            while (element == null && dexHolder != null) {
                Monitor.get().logWarning("Load faster dex in holder " + dexHolder.toString());
                dexHolder = dexHolder.toFasterHolder(preferences);
                if (dexHolder != null) {
                    element = dexHolder.toDexListElement(this.mElementConstructor);
                }
            }
            if (element != null) {
                Monitor.get().logInfo("Load dex in holder " + dexHolder.toString());
                dexHolderList.set(i, dexHolder);
                elements.add(element);
                String dexInfo = dexHolder.toString();
                Result.get().addDexInfo(dexInfo);
                Monitor.get().logInfo("Add info: " + dexInfo);
            } else {
                throw new RuntimeException("Fail to load dex, index is " + i);
            }
        }
        return elements.toArray();
    }

    private static class V19 extends DexLoader {
        private V19() {
            try {
                Class<?> elementClass = Class.forName("dalvik.system.DexPathList$Element");
                this.mElementConstructor = new KKElementConstructor(elementClass);
            } catch (Throwable tr) {
                Monitor.get().logError("fail to get Element constructor", tr);
            }
        }
    }

    private static class V14 extends DexLoader {
        private V14() {
            ElementConstructor constructor = null;
            try {
                Class<?> elementClass = Class.forName("dalvik.system.DexPathList$Element");
                try {
                    constructor = new ICSElementConstructor(elementClass);
                } catch (Exception e) {
                }
                if (constructor == null) {
                    try {
                        constructor = new JBMR11ElementConstructor(elementClass);
                    } catch (Exception e2) {
                    }
                }
                if (constructor == null) {
                    try {
                        constructor = new JBMR2ElementConstructor(elementClass);
                    } catch (Exception e3) {
                    }
                }
                this.mElementConstructor = constructor;
            } catch (Exception e4) {
                Monitor.get().logError("can not find DexPathList$Element", e4);
            }
        }
    }

    private static class ICSElementConstructor implements ElementConstructor {
        private final Constructor<?> mConstructor;

        static {
            SoLoad992979061.loadJ2CSo("cn.damai_shell_alijtca_plus", ICSElementConstructor.class);
        }

        @Override // com.ali.mobisecenhance.ld.multidex.DexLoader.ElementConstructor
        public native Object newInstance(File file, Object obj) throws IllegalArgumentException, InstantiationException, IllegalAccessException, InvocationTargetException, IOException;

        ICSElementConstructor(Class<?> elementClass) throws SecurityException, NoSuchMethodException {
            this.mConstructor = elementClass.getConstructor(File.class, ZipFile.class, DexFile.class);
            this.mConstructor.setAccessible(true);
        }
    }

    private static class JBMR11ElementConstructor implements ElementConstructor {
        private final Constructor<?> mConstructor;

        static {
            SoLoad992979061.loadJ2CSo("cn.damai_shell_alijtca_plus", JBMR11ElementConstructor.class);
        }

        @Override // com.ali.mobisecenhance.ld.multidex.DexLoader.ElementConstructor
        public native Object newInstance(File file, Object obj) throws IllegalArgumentException, InstantiationException, IllegalAccessException, InvocationTargetException;

        JBMR11ElementConstructor(Class<?> elementClass) throws SecurityException, NoSuchMethodException {
            this.mConstructor = elementClass.getConstructor(File.class, File.class, DexFile.class);
            this.mConstructor.setAccessible(true);
        }
    }

    private static class JBMR2ElementConstructor implements ElementConstructor {
        private final Constructor<?> mConstructor;

        static {
            SoLoad992979061.loadJ2CSo("cn.damai_shell_alijtca_plus", JBMR2ElementConstructor.class);
        }

        @Override // com.ali.mobisecenhance.ld.multidex.DexLoader.ElementConstructor
        public native Object newInstance(File file, Object obj) throws IllegalArgumentException, InstantiationException, IllegalAccessException, InvocationTargetException;

        JBMR2ElementConstructor(Class<?> elementClass) throws SecurityException, NoSuchMethodException {
            this.mConstructor = elementClass.getConstructor(File.class, Boolean.TYPE, File.class, DexFile.class);
            this.mConstructor.setAccessible(true);
        }
    }

    private static class KKElementConstructor implements ElementConstructor {
        private final Constructor<?> mConstructor;

        static {
            SoLoad992979061.loadJ2CSo("cn.damai_shell_alijtca_plus", KKElementConstructor.class);
        }

        @Override // com.ali.mobisecenhance.ld.multidex.DexLoader.ElementConstructor
        public native Object newInstance(File file, Object obj) throws IllegalArgumentException, InstantiationException, IllegalAccessException, InvocationTargetException, IOException;

        KKElementConstructor(Class<?> elementClass) throws SecurityException, NoSuchMethodException {
            this.mConstructor = Utility.findConstructor(elementClass, File.class, Boolean.TYPE, File.class, DexFile.class);
            this.mConstructor.setAccessible(true);
        }
    }
}
