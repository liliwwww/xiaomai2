package com.ali.mobisecenhance.ld.multidex;

import com.j2c.enhance.SoLoad992979061;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
class Locker {
    private FileLock cacheLock;
    private FileChannel lockChannel;
    private File lockFile;
    private RandomAccessFile lockRaf;

    static {
        SoLoad992979061.loadJ2CSo("cn.damai_shell_alijtca_plus", Locker.class);
    }

    native void close();

    native void lock() throws IOException;

    native boolean test() throws IOException;

    Locker(File lockFile) {
        this.lockFile = lockFile;
    }
}
