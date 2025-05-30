package com.ali.mobisecenhance;

import android.app.Application;
import android.content.Context;
import com.ali.mobisecenhance.p009ld.RecordLog;
import com.j2c.enhance.SoLoad992979061;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes.dex */
public class SpeedInit extends Init implements Runnable {
    private static final String TAG;
    private static final RecordLog logger;
    private final boolean mUseNewClassLoader = false;

    private native void installContentProviders(Object obj, Object obj2, Application application) throws NoSuchFieldException, IllegalAccessException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException;

    private native void reallyRun() throws Exception;

    @Override // java.lang.Runnable
    public native void run();

    static {
        SoLoad992979061.loadJ2CSo("cn.damai_shell_alijtca_plus", SpeedInit.class);
        TAG = SpeedInit.class.getSimpleName();
        logger = new RecordLog();
    }

    public SpeedInit(Application oldApplication, Context context, String applicationName, ClassLoader oldClassLoader, ClassLoader newMiniClassLoader, long beginTime) throws Exception {
        this.mBeginTime = beginTime;
        this.mOldApplication = oldApplication;
        this.mZumaAppContext = context;
        this.mOldClassLoader = oldClassLoader;
        this.mNewClassLoader = newMiniClassLoader;
        this.mNewApplicationName = applicationName;
        this.mPackageName = this.mZumaAppContext.getPackageName();
        replaceActivityThreadInstrumentation();
    }
}
