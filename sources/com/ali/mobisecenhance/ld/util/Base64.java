package com.ali.mobisecenhance.ld.util;

import com.j2c.enhance.SoLoad992979061;
import java.io.IOException;
import java.io.OutputStream;

/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public class Base64 {
    private static final char[] legalChars;

    private static native int decode(char c);

    private static native void decode(String str, OutputStream outputStream) throws IOException;

    public static native byte[] decode(String str);

    public static native String encode(byte[] bArr);

    static {
        SoLoad992979061.loadJ2CSo("cn.damai_shell_alijtca_plus", Base64.class);
        legalChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".toCharArray();
    }
}
