package com.ali.mobisecenhance.p009ld.dexmode;

import android.app.Application;
import android.content.Context;
import android.support.v4.media.session.PlaybackStateCompat;
import com.ali.mobisecenhance.p009ld.ConfigInfo;
import com.ali.mobisecenhance.p009ld.RecordLog;
import com.j2c.enhance.SoLoad992979061;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/* loaded from: classes.dex */
public class ShellDexMode extends NormalDexMode {
    private static final String TAG;
    public static volatile boolean firstRelease;
    private static final RecordLog logger;

    private native void deleteApk();

    private native String extractRealFile(String str, String str2);

    public static native synchronized boolean isFirstRelease();

    public static native synchronized void setFirstRelease(boolean z);

    @Override // com.ali.mobisecenhance.p009ld.dexmode.DexMode
    public native void beginHardWork();

    @Override // com.ali.mobisecenhance.p009ld.dexmode.DexMode
    public native void cleanup();

    protected native void extractApk() throws IOException;

    static {
        SoLoad992979061.loadJ2CSo("cn.damai_shell_alijtca_plus", ShellDexMode.class);
        TAG = ShellDexMode.class.getSimpleName();
        logger = new RecordLog();
        firstRelease = true;
    }

    public ShellDexMode(Application app, Context context, String baseDir, String dex2oatDir, ConfigInfo configs, boolean isMainProcess, long begin) {
        super(app, context, baseDir, dex2oatDir, configs, isMainProcess, begin);
    }

    public void decodeFile(File src, File out) {
        FileInputStream fis;
        Throwable th;
        byte[] originalBuffer;
        long originalBytesRemain;
        Throwable th2;
        byte[] encodeBuffer;
        int i;
        long size = src.length();
        long offset = 0;
        long length = PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
        if (size > PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID) {
            offset = size - PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
        } else {
            length = size;
        }
        try {
            try {
                fis = new FileInputStream(src);
            } catch (Exception e) {
                e = e;
                e.printStackTrace();
            }
        } catch (Exception e2) {
            e = e2;
        }
        try {
            try {
                originalBuffer = new byte[8192];
                if (!out.exists()) {
                    try {
                        out.createNewFile();
                    } catch (Throwable th3) {
                        th = th3;
                        try {
                            throw th;
                        } finally {
                        }
                    }
                }
                originalBytesRemain = offset;
            } catch (Throwable th4) {
                th = th4;
            }
            try {
                FileOutputStream fos = new FileOutputStream(out);
                while (true) {
                    try {
                        try {
                            byte[] originalBuffer2 = originalBuffer;
                            long bytesRead = fis.read(originalBuffer, 0, originalBytesRemain < PlaybackStateCompat.ACTION_PLAY_FROM_URI ? (int) originalBytesRemain : 8192);
                            if (bytesRead <= 0) {
                                break;
                            }
                            long size2 = size;
                            try {
                                fos.write(originalBuffer2, 0, (int) bytesRead);
                                originalBytesRemain -= bytesRead;
                                originalBuffer = originalBuffer2;
                                size = size2;
                            } catch (Throwable th5) {
                                th2 = th5;
                            }
                        } catch (Throwable th6) {
                            th2 = th6;
                        }
                        try {
                            throw th2;
                        } finally {
                        }
                    } catch (Throwable th7) {
                        th = th7;
                    }
                }
                try {
                    encodeBuffer = new byte[(int) length];
                    fis.read(encodeBuffer);
                    i = 0;
                } catch (Throwable th8) {
                    th2 = th8;
                }
                while (true) {
                    long offset2 = offset;
                    long offset3 = i;
                    if (offset3 < length) {
                        try {
                            encodeBuffer[i] = (byte) (encodeBuffer[i] ^ ((byte) i));
                            i++;
                            offset = offset2;
                        } catch (Throwable th9) {
                            th2 = th9;
                        }
                    } else {
                        try {
                            fos.write(encodeBuffer);
                            try {
                                fos.close();
                                RecordLog recordLog = logger;
                                String str = TAG;
                                StringBuilder sb = new StringBuilder();
                                sb.append("after release dex ");
                                sb.append(src.getName());
                                sb.append(" length ");
                                long length2 = src.length();
                                sb.append(length2);
                                sb.append(" to ");
                                sb.append(out.getName());
                                sb.append(" length ");
                                sb.append(out.length());
                                recordLog.m346v(str, sb.toString());
                                fis.close();
                                return;
                            } catch (Throwable th10) {
                                th = th10;
                                throw th;
                            }
                        } catch (Throwable th11) {
                            th2 = th11;
                        }
                    }
                    throw th2;
                }
            } catch (Throwable th12) {
                th = th12;
                th = th;
                throw th;
            }
        } catch (Exception e3) {
            e = e3;
            e.printStackTrace();
        }
    }
}
