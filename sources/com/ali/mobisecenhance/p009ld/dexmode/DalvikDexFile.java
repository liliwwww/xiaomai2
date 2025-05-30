package com.ali.mobisecenhance.p009ld.dexmode;

import com.ali.mobisecenhance.p009ld.RecordLog;
import com.j2c.enhance.SoLoad992979061;
import dalvik.system.DexFile;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public class DalvikDexFile {
    private static final String TAG;
    private static final RecordLog log;
    private Field cookie;
    private Field fileName;
    private int mCookie;
    private Method mDefineClass;
    private byte[] mFileByte;
    private String mFileName;
    private Method mOpenDexFile;
    private String mShellDexFile;
    private String mShellDexOutput;
    private DexFile shellDexFile;

    private native DexFile getDexFile(DexFile dexFile, Field field, Field field2, int i, String str);

    private native Method getOpenDexFile();

    private native Method getOpenDexFileByReflect() throws ClassNotFoundException;

    private native Method getOpenDexFileByShellDex() throws IOException;

    private native int invokeOpenDexFile(Method method, byte[] bArr);

    native DexFile genDexFile();

    public native int getCookie();

    public native int getDexFileSize();

    static {
        SoLoad992979061.loadJ2CSo("cn.damai_shell_alijtca_plus", DalvikDexFile.class);
        log = new RecordLog();
        TAG = DalvikDexFile.class.getSimpleName();
    }

    DalvikDexFile(String dexFile, String shellDexFile, String shelldexOutput) {
        this.mFileName = dexFile;
        this.mShellDexFile = shellDexFile;
        this.mShellDexOutput = shelldexOutput;
    }
}
