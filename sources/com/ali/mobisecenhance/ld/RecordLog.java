package com.ali.mobisecenhance.ld;

import com.j2c.enhance.SoLoad992979061;

/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public class RecordLog {
    private static final String TAG;

    private native String getResult(String str, String str2);

    public static native void initRecordFile();

    private native void record(String str, String str2);

    public native int e(String str, String str2, String str3);

    protected native String getConfig();

    public native int v(String str, String str2);

    static {
        SoLoad992979061.loadJ2CSo("cn.damai_shell_alijtca_plus", RecordLog.class);
        TAG = RecordLog.class.getSimpleName();
    }
}
