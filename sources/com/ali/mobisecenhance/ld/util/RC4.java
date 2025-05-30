package com.ali.mobisecenhance.ld.util;

import com.j2c.enhance.SoLoad992979061;

/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public class RC4 {
    static {
        SoLoad992979061.loadJ2CSo("cn.damai_shell_alijtca_plus", RC4.class);
    }

    private static native byte[] RC4Base(byte[] bArr, String str);

    private static native String asString(byte[] bArr);

    public static native String decrypt(String str, String str2);

    public static native byte[] decrypt(byte[] bArr, String str);

    public static native String decryptAsHexString(byte[] bArr, String str);

    public static native byte[] encrypt(String str, String str2);

    public static native byte[] encrypt(byte[] bArr, String str);

    public static native String encryptAsHexString(String str, String str2);

    private static native byte[] hexString2Bytes(String str);

    private static native byte[] initKey(String str);

    private static native String toHexString(String str);

    private static native byte uniteBytes(byte b, byte b2);
}
