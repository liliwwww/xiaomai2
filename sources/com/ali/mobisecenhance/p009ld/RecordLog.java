package com.ali.mobisecenhance.p009ld;

import com.j2c.enhance.SoLoad992979061;

/* loaded from: classes.dex */
public class RecordLog {
    private static final String TAG;

    private native String getResult(String str, String str2);

    public static native void initRecordFile();

    private native void record(String str, String str2);

    /* renamed from: e */
    public native int m345e(String str, String str2, String str3);

    protected native String getConfig();

    /* renamed from: v */
    public native int m346v(String str, String str2);

    static {
        SoLoad992979061.loadJ2CSo("cn.damai_shell_alijtca_plus", RecordLog.class);
        TAG = RecordLog.class.getSimpleName();
    }
}
