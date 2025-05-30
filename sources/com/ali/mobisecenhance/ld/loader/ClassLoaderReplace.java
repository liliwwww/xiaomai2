package com.ali.mobisecenhance.ld.loader;

import android.content.Context;
import com.ali.mobisecenhance.ld.RecordLog;
import com.j2c.enhance.SoLoad992979061;

/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public class ClassLoaderReplace {
    private static final String TAG;
    private static final RecordLog log;

    private native void replaceApplicationLoadersMLoaders(ClassLoader classLoader, ClassLoader classLoader2);

    private native void replaceApplicationMLoadedApk(String str, ClassLoader classLoader);

    private native void replaceClassloader(String str, Context context, ClassLoader classLoader, ClassLoader classLoader2) throws Exception;

    private native void replaceContext(Context context, ClassLoader classLoader);

    private native void replaceLoadedApkMApplication(String str, ClassLoader classLoader);

    static {
        SoLoad992979061.loadJ2CSo("cn.damai_shell_alijtca_plus", ClassLoaderReplace.class);
        TAG = ClassLoaderReplace.class.getSimpleName();
        log = new RecordLog();
    }

    public ClassLoaderReplace(Context context, ClassLoader oldClassLoader, ClassLoader newClassLoader) {
        if (oldClassLoader == newClassLoader) {
            log.v(TAG, "the classloader is same...");
            return;
        }
        log.v(TAG, "need replace classloader...");
        try {
            replaceClassloader(context.getPackageName(), context, oldClassLoader, newClassLoader);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
