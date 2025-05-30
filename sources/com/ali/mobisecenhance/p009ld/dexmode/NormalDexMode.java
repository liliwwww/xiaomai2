package com.ali.mobisecenhance.p009ld.dexmode;

import android.app.Application;
import android.content.Context;
import com.ali.mobisecenhance.p009ld.ConfigInfo;
import com.ali.mobisecenhance.p009ld.RecordLog;
import com.ali.mobisecenhance.p009ld.loader.LoaderEngine;
import com.ali.mobisecenhance.p009ld.loader.LoaderInfo;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes.dex */
public abstract class NormalDexMode extends DexMode {
    private static final String TAG = NormalDexMode.class.getSimpleName();
    private static final RecordLog logger = new RecordLog();

    public NormalDexMode(Application app, Context context, String baseDir, String dex2oatDir, ConfigInfo configs, boolean isMainProcess, long begin) {
        super(app, context, baseDir, dex2oatDir, configs, isMainProcess, begin);
    }

    protected void NormalStartUp(LoaderEngine engine) throws IOException {
        LoaderInfo loaderInfo = engine.createRepairClassLoader(this.mContext, false);
        if (loaderInfo != null) {
            try {
                this.mMiniInit = engine.loadSpeedInit(loaderInfo, this.begin);
                logger.m346v(TAG, "enterAppInit mMiniInit is " + this.mMiniInit);
            } catch (ClassNotFoundException | IllegalAccessException | IllegalArgumentException | InstantiationException | NoSuchMethodException | SecurityException | InvocationTargetException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.ali.mobisecenhance.p009ld.dexmode.DexMode
    public Runnable getMiniInitClz() {
        return this.mMiniInit;
    }
}
