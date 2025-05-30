package com.ali.mobisecenhance.ld.loader;

import com.j2c.enhance.SoLoad992979061;

/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public class LoaderInfo {
    private boolean isOatMode;
    private ClassLoader originalClassloader;

    static {
        SoLoad992979061.loadJ2CSo("cn.damai_shell_alijtca_plus", LoaderInfo.class);
    }

    public native ClassLoader getOriginalClassloader();

    public native boolean isOatMode();

    LoaderInfo(ClassLoader oldClassLoader, boolean oatmode) {
        this.originalClassloader = oldClassLoader;
        this.isOatMode = oatmode;
    }
}
