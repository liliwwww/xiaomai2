package com.ali.mobisecenhance.p009ld;

import android.content.Context;
import com.j2c.enhance.SoLoad992979061;
import java.io.File;
import java.util.zip.ZipFile;

/* loaded from: classes.dex */
public class HotPath {
    static {
        SoLoad992979061.loadJ2CSo("cn.damai_shell_alijtca_plus", HotPath.class);
    }

    private static native boolean decFile(File file, File file2);

    private static native long getCRC32(File file);

    public static native String getRealApplicationName();

    public static native void hotpathDeleteApk(Context context);

    public static native String hotpathReleseApk(Context context);

    private static native boolean tryUnzip(ZipFile zipFile, String str, String str2);
}
