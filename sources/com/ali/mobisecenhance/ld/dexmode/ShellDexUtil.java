package com.ali.mobisecenhance.ld.dexmode;

import android.content.Context;
import com.ali.mobisecenhance.ld.ConfigInfo;
import com.ali.mobisecenhance.ld.RecordLog;
import com.j2c.enhance.SoLoad992979061;
import dalvik.system.BaseDexClassLoader;
import java.lang.reflect.Field;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public class ShellDexUtil {
    private static String DEX2OATSTRFLAG;
    private static final String TAG;
    private static final RecordLog log;
    private ConfigInfo mConfigs;
    private Context mContext;
    private ArrayList<Integer> mDexFileCookies = new ArrayList<>();
    private String mDexFilesDir;
    private String mShellDexFile;
    private String mShellDexOutput;

    private native boolean checkFile(String str);

    /* JADX INFO: Access modifiers changed from: private */
    public native boolean createFile(String str);

    private native void extractFolder(String str, List<ByteBuffer> list);

    private native BaseDexClassLoader generateArtClassLoaderFromApk(ClassLoader classLoader);

    private native Field getField(Class cls, String str) throws NoSuchFieldException;

    public native BaseDexClassLoader generateClassLoader();

    public native int[] getCookies();

    static {
        SoLoad992979061.loadJ2CSo("cn.damai_shell_alijtca_plus", ShellDexUtil.class);
        TAG = ShellDexUtil.class.getSimpleName();
        log = new RecordLog();
        DEX2OATSTRFLAG = "alidex2oat";
    }

    public ShellDexUtil(Context context, String dexFileDir, String dexOatDir, ConfigInfo configs) {
        this.mContext = context;
        this.mConfigs = configs;
        this.mDexFilesDir = dexFileDir;
        this.mDexFilesDir = dexOatDir;
    }

    /* renamed from: com.ali.mobisecenhance.ld.dexmode.ShellDexUtil$1, reason: invalid class name */
    class AnonymousClass1 implements Runnable {
        final /* synthetic */ String val$apkPath;

        static {
            SoLoad992979061.loadJ2CSo("cn.damai_shell_alijtca_plus", AnonymousClass1.class);
        }

        @Override // java.lang.Runnable
        public native void run();

        AnonymousClass1(String str) {
            this.val$apkPath = str;
        }
    }
}
