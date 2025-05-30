package com.ali.mobisecenhance.p009ld;

import android.content.Context;
import com.j2c.enhance.SoLoad992979061;

/* loaded from: classes.dex */
public class AppInit {
    private static final String TAG;
    public static String baseDir;
    public static String dex2oatDirPath;
    private static final RecordLog log;

    public static native boolean delAllFiles(String str);

    private static native void delFolder(String str);

    public static native void init(Context context, ConfigInfo configInfo);

    private static native boolean isUpdate(String str, ConfigInfo configInfo);

    static {
        SoLoad992979061.loadJ2CSo("cn.damai_shell_alijtca_plus", AppInit.class);
        TAG = AppInit.class.getSimpleName();
        log = new RecordLog();
        baseDir = null;
        dex2oatDirPath = null;
    }
}
