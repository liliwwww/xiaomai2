package com.ali.mobisecenhance.p009ld.multidex;

import android.content.Context;
import com.j2c.enhance.SoLoad992979061;
import java.io.File;

/* loaded from: classes.dex */
public class BoostMultiDex {
    static {
        SoLoad992979061.loadJ2CSo("cn.damai_shell_alijtca_plus", BoostMultiDex.class);
    }

    public static native Result install(Context context, File file, ClassLoader classLoader, Monitor monitor);

    public static native boolean isOptimizeProcess(String str);

    private static native boolean isVMCapable(String str);
}
