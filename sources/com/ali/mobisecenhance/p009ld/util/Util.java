package com.ali.mobisecenhance.p009ld.util;

import android.app.Activity;
import com.ali.mobisecenhance.p009ld.RecordLog;
import com.j2c.enhance.SoLoad992979061;
import dalvik.system.DexFile;
import dalvik.system.PathClassLoader;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;
import java.util.zip.ZipFile;

/* loaded from: classes.dex */
public class Util {
    private static final String TAG;
    private static final RecordLog log;

    public static native DexFile addDexFileToDexPathList(String str, String str2, ClassLoader classLoader);

    public static native void addDexFileToDexPathList(DexFile dexFile, ClassLoader classLoader);

    private static native void addObjToArrayField(Object obj, String str, Object obj2) throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException;

    public static native Activity copyActivityInfo(Activity activity, Activity activity2);

    public static native void copyFileUsingFileStreams(File file, File file2) throws IOException;

    public static native PathClassLoader copyLoaderInfo(PathClassLoader pathClassLoader, ClassLoader classLoader);

    public static native boolean fileCheck(ZipFile zipFile, String str, String str2);

    private static native List<Field> getAllFields(Class<?> cls);

    private static native List<Field> getAllFields(Class<?> cls, Class<?> cls2);

    public static native long getCRC32(File file);

    private static native Field getField(Class<?> cls, Object obj, String str) throws NoSuchFieldException;

    public static native Field getFieldByReflect(String str, String str2);

    public static native String getFileMD5s(File file, int i);

    public static native Method getMethodByReflect(String str, String str2);

    private static native Object makeDexElement(DexFile dexFile);

    public static native String readTxtFile(File file);

    public static native byte[] toByteArray(File file);

    public static native boolean tryUnzip(ZipFile zipFile, String str, String str2);

    public static native boolean tryUnzipAndDec(ZipFile zipFile, String str, String str2);

    public static native void writeTxtFile(File file, String str);

    static {
        SoLoad992979061.loadJ2CSo("cn.damai_shell_alijtca_plus", Util.class);
        TAG = Util.class.getSimpleName();
        log = new RecordLog();
    }
}
