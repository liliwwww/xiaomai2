package com.ali.mobisecenhance.p009ld;

import android.app.Application;
import android.content.Context;
import com.ali.mobisecenhance.p009ld.dexmode.DexMode;
import com.j2c.enhance.SoLoad992979061;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

/* loaded from: classes.dex */
public class BridgeAppMini extends Application {
    private static final String TAG;
    private static final RecordLog log;
    private FileChannel channel;
    private FileLock lock;
    private ConfigInfo mConfigInfo;
    private DexMode mDexMode;
    private boolean mMainProcess = true;
    private Runnable mWorker;
    private String runMode;

    private native void appInitInShellDexMode(Context context, long j);

    private native void checkLockFile();

    private native void checkMainProcess(String str, Context context);

    private native boolean createLockFile();

    private native boolean deleteLockFile();

    private native String getProcessNameCompat();

    @Override // android.content.ContextWrapper
    protected native void attachBaseContext(Context context);

    public native void cleanup();

    protected native String getConfig();

    protected native String getDigestHash();

    protected native String getProviders();

    @Override // android.app.Application
    public native void onCreate();

    native void printClassLoader();

    static {
        SoLoad992979061.loadJ2CSo("cn.damai_shell_alijtca_plus", BridgeAppMini.class);
        TAG = BridgeAppMini.class.getSimpleName();
        log = new RecordLog();
    }
}
