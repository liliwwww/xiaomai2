package com.ali.mobisecenhance.p009ld.multidex;

import android.content.SharedPreferences;
import com.ali.mobisecenhance.p009ld.multidex.DexLoader;
import com.j2c.enhance.SoLoad992979061;
import dalvik.system.DexFile;
import java.io.File;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* loaded from: classes.dex */
abstract class DexHolder {
    File mFile;

    abstract StoreInfo getInfo();

    abstract Object toDexFile();

    abstract DexHolder toFasterHolder(SharedPreferences sharedPreferences);

    DexHolder() {
    }

    protected Object toDexListElement(DexLoader.ElementConstructor elementConstructor) throws Exception {
        Object dexFile = toDexFile();
        if (dexFile == null) {
            return null;
        }
        return elementConstructor.newInstance(this.mFile, dexFile);
    }

    private static void putTypeInfo(SharedPreferences.Editor editor, int secondaryNumber, int type) {
        Monitor.get().logDebug(String.format("putTypeInfo %d Type %d", Integer.valueOf(secondaryNumber), Integer.valueOf(type)));
        editor.putInt(Constants.KEY_DEX_OBJ_TYPE + secondaryNumber, type);
    }

    private static void putZipOptInfo(SharedPreferences.Editor editor, int secondaryNumber, File zipFile) throws IOException {
        long checkSum = Utility.doZipCheckSum(zipFile);
        editor.putLong(Constants.KEY_DEX_CHECKSUM + secondaryNumber, checkSum);
        long time = zipFile.lastModified();
        editor.putLong(Constants.KEY_DEX_TIME + secondaryNumber, time);
        Monitor.get().logInfo("Put z key " + Constants.KEY_DEX_CHECKSUM + Constants.KEY_DEX_TIME + secondaryNumber + " checksum=" + checkSum + ", time=" + time);
    }

    private static void putDexFileInfo(SharedPreferences.Editor editor, int secondaryNumber, File file) throws IOException {
        long checkSum = Utility.doFileCheckSum(file);
        editor.putLong(Constants.KEY_DEX_CHECKSUM + secondaryNumber, checkSum);
        long time = file.lastModified();
        editor.putLong(Constants.KEY_DEX_TIME + secondaryNumber, time);
        Monitor.get().logInfo("Put f key " + Constants.KEY_DEX_CHECKSUM + Constants.KEY_DEX_TIME + secondaryNumber + " checksum=" + checkSum + ", time=" + time);
    }

    private static void putDexOptInfo(SharedPreferences.Editor editor, int secondaryNumber, File optFile) throws IOException {
        long checkSum = optFile.length();
        editor.putLong(Constants.KEY_ODEX_CHECKSUM + secondaryNumber, checkSum);
        long time = optFile.lastModified();
        editor.putLong(Constants.KEY_ODEX_TIME + secondaryNumber, time);
        Monitor.get().logInfo("Put o key " + Constants.KEY_ODEX_CHECKSUM + Constants.KEY_ODEX_TIME + secondaryNumber + " checksum=" + checkSum + ", time=" + time);
    }

    static DexHolder obtainValidDexBuffer(SharedPreferences preferences, int secondaryNumber, File validDexFile, File optDexFile) throws IOException {
        SharedPreferences.Editor editor = preferences.edit();
        putTypeInfo(editor, secondaryNumber, 1);
        putDexFileInfo(editor, secondaryNumber, validDexFile);
        editor.commit();
        return new DexBuffer(secondaryNumber, validDexFile, optDexFile);
    }

    static DexHolder obtainValidForceDexOpt(SharedPreferences preferences, int secondaryNumber, File dexFile, File optDexFile, ZipFile apkZipFile, ZipEntry dexFileEntry) throws IOException {
        File validDexFile = Utility.obtainEntryFileInZip(apkZipFile, dexFileEntry, dexFile);
        SharedPreferences.Editor editor = preferences.edit();
        putTypeInfo(editor, secondaryNumber, 2);
        putDexFileInfo(editor, secondaryNumber, validDexFile);
        editor.commit();
        return new DexOpt(secondaryNumber, validDexFile, optDexFile, true);
    }

    static DexHolder obtainValidDexOpt(SharedPreferences preferences, int secondaryNumber, File validDexFile, File optDexFile) throws IOException {
        SharedPreferences.Editor editor = preferences.edit();
        putTypeInfo(editor, secondaryNumber, 2);
        putDexOptInfo(editor, secondaryNumber, optDexFile);
        editor.commit();
        return new DexOpt(secondaryNumber, validDexFile, optDexFile, false);
    }

    static ZipOpt obtainValidZipDex(SharedPreferences preferences, int secondaryNumber, File validZipFile, File validZipOptFile, ZipFile apkZipFile, ZipEntry dexFileEntry) throws IOException {
        Utility.obtainZipForEntryFileInZip(apkZipFile, dexFileEntry, validZipFile);
        SharedPreferences.Editor editor = preferences.edit();
        putTypeInfo(editor, secondaryNumber, 3);
        putZipOptInfo(editor, secondaryNumber, validZipFile);
        editor.commit();
        return new ZipOpt(secondaryNumber, validZipFile, validZipOptFile);
    }

    static class ZipOpt extends DexHolder {
        private int mIndex;
        private File mOptFile;

        static {
            SoLoad992979061.loadJ2CSo("cn.damai_shell_alijtca_plus", ZipOpt.class);
        }

        @Override // com.ali.mobisecenhance.p009ld.multidex.DexHolder
        public native StoreInfo getInfo();

        @Override // com.ali.mobisecenhance.p009ld.multidex.DexHolder
        public native Object toDexFile();

        @Override // com.ali.mobisecenhance.p009ld.multidex.DexHolder
        public native DexHolder toFasterHolder(SharedPreferences sharedPreferences);

        public native String toString();

        ZipOpt(int index, File file, File optFile) {
            this.mIndex = index;
            this.mFile = file;
            this.mOptFile = optFile;
        }
    }

    static class DexOpt extends DexHolder {
        private boolean mForceOpt;
        private int mIndex;
        private File mOptFile;

        static {
            SoLoad992979061.loadJ2CSo("cn.damai_shell_alijtca_plus", DexOpt.class);
        }

        @Override // com.ali.mobisecenhance.p009ld.multidex.DexHolder
        public native StoreInfo getInfo();

        @Override // com.ali.mobisecenhance.p009ld.multidex.DexHolder
        public native DexHolder toFasterHolder(SharedPreferences sharedPreferences);

        public native String toString();

        DexOpt(int index, File file, File optFile, boolean forceOpt) {
            this.mIndex = index;
            this.mFile = file;
            this.mOptFile = optFile;
            this.mForceOpt = forceOpt;
        }

        @Override // com.ali.mobisecenhance.p009ld.multidex.DexHolder
        public Object toDexFile() {
            try {
                return DexFile.loadDex(this.mFile.getPath(), this.mOptFile.getPath(), 0);
            } catch (IOException e1) {
                Monitor.get().logError("Fail to load dex file first time", e1);
                try {
                    if (this.mForceOpt) {
                        return DexFile.loadDex(this.mFile.getPath(), this.mOptFile.getPath(), 0);
                    }
                    return BoostNative.loadDirectDex(this.mFile.getPath(), null);
                } catch (IOException e2) {
                    Monitor.get().logError("Fail to load dex file", e2);
                    throw new RuntimeException(e2);
                }
            }
        }
    }

    static class DexBuffer extends DexHolder {
        private int mIndex;
        private File mOptFile;

        static {
            SoLoad992979061.loadJ2CSo("cn.damai_shell_alijtca_plus", DexBuffer.class);
        }

        @Override // com.ali.mobisecenhance.p009ld.multidex.DexHolder
        public native StoreInfo getInfo();

        @Override // com.ali.mobisecenhance.p009ld.multidex.DexHolder
        public native Object toDexFile();

        @Override // com.ali.mobisecenhance.p009ld.multidex.DexHolder
        public native DexHolder toFasterHolder(SharedPreferences sharedPreferences);

        public native String toString();

        DexBuffer(int index, File file, File optFile) {
            this.mIndex = index;
            this.mFile = file;
            this.mOptFile = optFile;
        }
    }

    static class ApkBuffer extends DexHolder {
        private byte[] mBytes;
        private int mIndex;
        private File mOptFile;

        static {
            SoLoad992979061.loadJ2CSo("cn.damai_shell_alijtca_plus", ApkBuffer.class);
        }

        @Override // com.ali.mobisecenhance.p009ld.multidex.DexHolder
        public native StoreInfo getInfo();

        @Override // com.ali.mobisecenhance.p009ld.multidex.DexHolder
        public native Object toDexFile();

        @Override // com.ali.mobisecenhance.p009ld.multidex.DexHolder
        public native Object toDexListElement(DexLoader.ElementConstructor elementConstructor) throws Exception;

        @Override // com.ali.mobisecenhance.p009ld.multidex.DexHolder
        public native DexHolder toFasterHolder(SharedPreferences sharedPreferences);

        public native String toString();

        ApkBuffer(int index, byte[] bytes, File file, File optFile) {
            this.mIndex = index;
            this.mBytes = bytes;
            this.mFile = file;
            this.mOptFile = optFile;
        }
    }

    class StoreInfo {
        File file;
        int index;
        int type;

        StoreInfo(int type, int index, File file) {
            this.type = type;
            this.index = index;
            this.file = file;
        }
    }
}
