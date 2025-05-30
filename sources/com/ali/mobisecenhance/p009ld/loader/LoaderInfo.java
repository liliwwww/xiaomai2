package com.ali.mobisecenhance.p009ld.loader;

import com.j2c.enhance.SoLoad992979061;

/* loaded from: classes.dex */
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
