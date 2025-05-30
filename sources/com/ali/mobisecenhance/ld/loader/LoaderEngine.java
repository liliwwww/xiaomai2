package com.ali.mobisecenhance.ld.loader;

import android.app.Application;
import android.content.Context;
import com.ali.mobisecenhance.ld.ConfigInfo;
import com.ali.mobisecenhance.ld.RecordLog;
import com.j2c.enhance.SoLoad992979061;
import java.lang.reflect.InvocationTargetException;

/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public class LoaderEngine {
    private static final String TAG;
    private static final RecordLog log;
    protected ConfigInfo mConfigs;
    private Context mContext;
    protected String mDex2oatDir;
    protected String mDexFilesDir;
    protected Application mOldApplication;

    public native LoaderInfo createRepairClassLoader(Context context, boolean z);

    protected native Runnable enterAppInit(Class<?> cls, ClassLoader classLoader, long j) throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException;

    public native Runnable loadSpeedInit(LoaderInfo loaderInfo, long j) throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException;

    static {
        SoLoad992979061.loadJ2CSo("cn.damai_shell_alijtca_plus", LoaderEngine.class);
        log = new RecordLog();
        TAG = LoaderEngine.class.getSimpleName();
    }

    public LoaderEngine(Application app, Context context, ConfigInfo configs, String basedir, String dexFilesDir, String dex2oatDir) {
        this.mDexFilesDir = null;
        this.mDex2oatDir = null;
        this.mDex2oatDir = dex2oatDir;
        this.mDexFilesDir = dexFilesDir;
        this.mContext = context;
        this.mOldApplication = app;
        this.mConfigs = configs;
    }
}
