package com.ali.mobisecenhance.ld.multidex;

import android.content.Context;
import android.content.SharedPreferences;
import com.j2c.enhance.SoLoad992979061;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Random;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
class DexInstallProcessor {
    private boolean mDoCheckSum;
    private SharedPreferences mPreferences;

    static {
        SoLoad992979061.loadJ2CSo("cn.damai_shell_alijtca_plus", DexInstallProcessor.class);
    }

    private native boolean checkFileValid(int i, String str, String str2, File file, boolean z);

    private native File getValidDexFile(File file, int i) throws IOException;

    private native File getValidOptDexFile(File file, int i) throws IOException;

    private native void installSecondaryDexes(ClassLoader classLoader, List<DexHolder> list) throws Exception;

    private native boolean isZipFileValid(File file, int i);

    private native DexHolder obtainDexHolder(int i, File file, File file2, File file3, File file4) throws IOException;

    private native List<DexHolder> obtainDexObjectList(File file, File file2, File file3, File file4, File file5, Result result) throws IOException;

    private native byte[] obtainEntryBytesInApk(ZipFile zipFile, ZipEntry zipEntry) throws IOException;

    private native File obtainEntryFileInApk(ZipFile zipFile, ZipEntry zipEntry, File file) throws IOException;

    native void doInstallation(Context context, File file, ClassLoader classLoader, Result result) throws Exception;

    native void doInstallationInOptProcess(Context context, ClassLoader classLoader, File file) throws Exception;

    DexInstallProcessor() {
        Random random = new Random();
        this.mDoCheckSum = random.nextInt(3) == 0;
        Monitor.get().logInfo("Do checksum " + this.mDoCheckSum);
    }

    /* renamed from: com.ali.mobisecenhance.ld.multidex.DexInstallProcessor$1, reason: invalid class name */
    class AnonymousClass1 implements Runnable {
        final /* synthetic */ Context val$mainContext;

        static {
            SoLoad992979061.loadJ2CSo("cn.damai_shell_alijtca_plus", AnonymousClass1.class);
        }

        @Override // java.lang.Runnable
        public native void run();

        AnonymousClass1(Context context) {
            this.val$mainContext = context;
        }
    }
}
