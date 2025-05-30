package com.ali.mobisecenhance.p009ld.loader;

import com.j2c.enhance.SoLoad992979061;
import dalvik.system.PathClassLoader;

/* loaded from: classes.dex */
public class RepairClassLoader extends PathClassLoader {
    static {
        SoLoad992979061.loadJ2CSo("cn.damai_shell_alijtca_plus", RepairClassLoader.class);
    }

    @Override // dalvik.system.BaseDexClassLoader, java.lang.ClassLoader
    protected native Class<?> findClass(String str) throws ClassNotFoundException;

    @Override // java.lang.ClassLoader
    public native Class<?> loadClass(String str) throws ClassNotFoundException;

    @Override // java.lang.ClassLoader
    protected native Class<?> loadClass(String str, boolean z) throws ClassNotFoundException;

    public RepairClassLoader(String dexPath, String nativeLibPath, ClassLoader parent) {
        super(dexPath, nativeLibPath, parent);
    }

    public RepairClassLoader(String dexPath, ClassLoader parent) {
        super(dexPath, parent);
    }
}
