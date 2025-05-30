package androidx.emoji2.text.flatbuffer;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
class FlexBuffers$Unsigned {
    FlexBuffers$Unsigned() {
    }

    static int byteToUnsignedInt(byte b) {
        return b & 255;
    }

    static long intToUnsignedLong(int i) {
        return i & 4294967295L;
    }

    static int shortToUnsignedInt(short s) {
        return s & 65535;
    }
}
