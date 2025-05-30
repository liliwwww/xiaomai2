package com.ali.mobisecenhance.p009ld.multidex;

import com.j2c.enhance.SoLoad992979061;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class Result {
    private static Result result;
    public File dataDir;
    public File dexDir;
    public Throwable fatalThrowable;
    public long freeSpaceAfter;
    public long freeSpaceBefore;
    public boolean isYunOS;
    public boolean modified;
    public File optDexDir;
    public File rootDir;
    public boolean supportFastLoadDex;
    public String vmLibName;
    public File zipDir;
    public List<Throwable> unFatalThrowable = new ArrayList();
    public List<String> dexInfoList = new ArrayList();

    public static native Result get();

    public native void addDexInfo(String str);

    public native void addUnFatalThrowable(Throwable th);

    public native void setDirs(File file, File file2, File file3, File file4, File file5);

    public native void setFatalThrowable(Throwable th);

    static {
        SoLoad992979061.loadJ2CSo("cn.damai_shell_alijtca_plus", Result.class);
        result = new Result();
    }

    private Result() {
    }
}
