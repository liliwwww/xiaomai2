package com.ali.mobisecenhance;

import android.app.Application;
import android.app.Instrumentation;
import android.content.Context;
import android.content.pm.ProviderInfo;
import com.ali.mobisecenhance.p009ld.RecordLog;
import com.j2c.enhance.SoLoad992979061;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class Init {
    private static final String TAG;
    private static final RecordLog logger;
    protected long mBeginTime;
    protected String mNewApplicationName;
    protected ClassLoader mNewClassLoader;
    protected Application mOldApplication;
    protected ClassLoader mOldClassLoader;
    protected String mPackageName;
    protected List<ProviderInfo> mProviders = new ArrayList();
    protected Instrumentation mTargetAppInstrumentation;
    protected Context mZumaAppContext;
    protected Instrumentation mZumaInstrumentation;

    protected native void replaceActivityThreadInstrumentation() throws Exception;

    protected native void replaceApplication(Application application) throws Exception;

    protected native Instrumentation replaceInstrumentation(Instrumentation instrumentation, ClassLoader classLoader);

    protected native void setOuterContext(Application application) throws Exception;

    static {
        SoLoad992979061.loadJ2CSo("cn.damai_shell_alijtca_plus", Init.class);
        TAG = Init.class.getSimpleName();
        logger = new RecordLog();
    }
}
