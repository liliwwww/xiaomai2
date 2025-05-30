package com.ali.mobisecenhance.ld.multidex;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import com.j2c.enhance.SoLoad992979061;
import java.io.File;
import java.io.IOException;

/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public class OptimizeService extends IntentService {
    static volatile boolean sAlreadyOpt;
    File mDexDir;
    File mOptDexDir;
    File mRootDir;
    File mZipDir;

    static {
        SoLoad992979061.loadJ2CSo("cn.damai_shell_alijtca_plus", OptimizeService.class);
    }

    private native void handleOptimize() throws IOException;

    public static native void startOptimizeService(Context context);

    @Override // android.app.IntentService, android.app.Service
    public native void onCreate();

    @Override // android.app.IntentService
    protected native void onHandleIntent(Intent intent);

    public OptimizeService() {
        super("OptimizeService");
        Monitor monitor = Monitor.get();
        if (monitor == null) {
            Monitor.init(null);
        }
        Monitor.get().logDebug("Starting OptimizeService");
    }
}
