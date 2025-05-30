package com.ali.mobisecenhance.ld.multidex;

import com.j2c.enhance.SoLoad992979061;

/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
final class BoostNative {
    private static volatile boolean alreadyInit;
    private static boolean supportFastLoadDex;

    static {
        SoLoad992979061.loadJ2CSo("cn.damai_shell_alijtca_plus", BoostNative.class);
    }

    private static native void checkSupportFastLoad(Result result);

    private static native boolean initialize(int i, Class<RuntimeException> cls);

    static native synchronized boolean isSupportFastLoad();

    static native Object loadDirectDex(String str, byte[] bArr);

    static native boolean makeOptDexFile(String str, String str2);

    static native long obtainCheckSum(String str);

    static native void recoverAction();

    BoostNative() {
    }
}
