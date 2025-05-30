package com.ali.mobisecenhance.p009ld.dexmode;

import android.app.Application;
import android.content.Context;
import com.ali.mobisecenhance.p009ld.ConfigInfo;
import com.ali.mobisecenhance.p009ld.RecordLog;

/* loaded from: classes.dex */
public abstract class DexMode {
    private static final String TAG = DexMode.class.getSimpleName();
    private static final RecordLog log = new RecordLog();
    protected long begin;
    protected boolean isMainProcess;
    protected String mBaseDir;
    protected ConfigInfo mConfigs;
    protected Context mContext;
    protected String mDex2OatDir;
    protected String mHookSoFile;
    protected Application mOldApplication;
    protected String mZumaDataFile;
    protected String mDexFilesDir = null;
    protected Runnable mMiniInit = null;

    public abstract void beginHardWork();

    public abstract void cleanup();

    public abstract Runnable getMiniInitClz();

    public DexMode(Application app, Context context, String baseDir, String dex2oatDir, ConfigInfo configs, boolean isMainProcess, long begin) {
        this.mContext = context;
        this.mOldApplication = app;
        this.mBaseDir = baseDir;
        this.mDex2OatDir = dex2oatDir;
        this.mConfigs = configs;
        this.begin = begin;
        this.isMainProcess = isMainProcess;
    }

    public static DexMode getDexModeInstance(Application app, Context context, String baseDir, String dex2oatDir, ConfigInfo configs, boolean isMainProcess, long begin) {
        return new ShellDexMode(app, context, baseDir, dex2oatDir, configs, isMainProcess, begin);
    }
}
