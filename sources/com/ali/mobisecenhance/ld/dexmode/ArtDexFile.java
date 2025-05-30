package com.ali.mobisecenhance.ld.dexmode;

import com.ali.mobisecenhance.ld.RecordLog;
import com.j2c.enhance.SoLoad992979061;
import dalvik.system.DexFile;

/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public class ArtDexFile {
    private static final String TAG;
    private static final RecordLog log;
    private String mFileName;
    private String mFileName1;

    native DexFile genDexFile();

    static {
        SoLoad992979061.loadJ2CSo("cn.damai_shell_alijtca_plus", ArtDexFile.class);
        TAG = ArtDexFile.class.getSimpleName();
        log = new RecordLog();
    }

    ArtDexFile(String dexFile) {
        this.mFileName = dexFile;
    }
}
