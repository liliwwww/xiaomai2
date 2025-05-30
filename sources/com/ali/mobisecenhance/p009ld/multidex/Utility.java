package com.ali.mobisecenhance.p009ld.multidex;

import android.content.Context;
import com.j2c.enhance.SoLoad992979061;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* loaded from: classes.dex */
public class Utility {
    static {
        SoLoad992979061.loadJ2CSo("cn.damai_shell_alijtca_plus", Utility.class);
    }

    static native void clearDirFiles(File file);

    static native void closeQuietly(Closeable closeable);

    static native long doFileCheckSum(File file) throws IOException;

    static native long doZipCheckSum(File file) throws IOException;

    static native File ensureDirCreated(File file, String str) throws IOException;

    static native void expandFieldArray(Object obj, String str, Object[] objArr) throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException;

    static native Constructor findConstructor(Class<?> cls, Class<?>... clsArr) throws NoSuchMethodException;

    static native Field findField(Class<?> cls, String str) throws NoSuchFieldException;

    static native Field findFieldRecursively(Class<?> cls, String str) throws NoSuchFieldException;

    static native Method findMethod(Class<?> cls, String str, Class<?>... clsArr) throws NoSuchMethodException;

    static native Method findMethodRecursively(Class<?> cls, String str, Class<?>... clsArr) throws NoSuchMethodException;

    public static native String getCurProcessName();

    static native boolean isBetterUseApkBuf();

    public static native boolean isMainProcess(Context context);

    static native boolean isOptimizeProcess(String str);

    static native void mkdirChecked(File file) throws IOException;

    static native byte[] obtainBytesFromInputStream(InputStream inputStream) throws IOException;

    static native byte[] obtainBytesInFile(File file);

    static native byte[] obtainEntryBytesInZip(ZipFile zipFile, ZipEntry zipEntry) throws IOException;

    static native File obtainEntryFileFromInputStream(InputStream inputStream, File file) throws IOException;

    static native File obtainEntryFileInZip(ZipFile zipFile, ZipEntry zipEntry, File file) throws IOException;

    static native void obtainZipForEntryFileInZip(ZipFile zipFile, ZipEntry zipEntry, File file) throws IOException;

    static native boolean storeBytesToFile(byte[] bArr, File file);
}
