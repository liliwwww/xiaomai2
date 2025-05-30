package androidx.emoji2.text.flatbuffer;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
class Utf8$DecodeUtil {
    Utf8$DecodeUtil() {
    }

    static void handleFourBytes(byte b, byte b2, byte b3, byte b4, char[] cArr, int i) throws IllegalArgumentException {
        if (isNotTrailingByte(b2) || (((b << 28) + (b2 + 112)) >> 30) != 0 || isNotTrailingByte(b3) || isNotTrailingByte(b4)) {
            throw new IllegalArgumentException("Invalid UTF-8");
        }
        int trailingByteValue = ((b & 7) << 18) | (trailingByteValue(b2) << 12) | (trailingByteValue(b3) << 6) | trailingByteValue(b4);
        cArr[i] = highSurrogate(trailingByteValue);
        cArr[i + 1] = lowSurrogate(trailingByteValue);
    }

    static void handleOneByte(byte b, char[] cArr, int i) {
        cArr[i] = (char) b;
    }

    static void handleThreeBytes(byte b, byte b2, byte b3, char[] cArr, int i) throws IllegalArgumentException {
        if (isNotTrailingByte(b2) || ((b == -32 && b2 < -96) || ((b == -19 && b2 >= -96) || isNotTrailingByte(b3)))) {
            throw new IllegalArgumentException("Invalid UTF-8");
        }
        cArr[i] = (char) (((b & 15) << 12) | (trailingByteValue(b2) << 6) | trailingByteValue(b3));
    }

    static void handleTwoBytes(byte b, byte b2, char[] cArr, int i) throws IllegalArgumentException {
        if (b < -62) {
            throw new IllegalArgumentException("Invalid UTF-8: Illegal leading byte in 2 bytes utf");
        }
        if (isNotTrailingByte(b2)) {
            throw new IllegalArgumentException("Invalid UTF-8: Illegal trailing byte in 2 bytes utf");
        }
        cArr[i] = (char) (((b & 31) << 6) | trailingByteValue(b2));
    }

    private static char highSurrogate(int i) {
        return (char) ((i >>> 10) + 55232);
    }

    private static boolean isNotTrailingByte(byte b) {
        return b > -65;
    }

    static boolean isOneByte(byte b) {
        return b >= 0;
    }

    static boolean isThreeBytes(byte b) {
        return b < -16;
    }

    static boolean isTwoBytes(byte b) {
        return b < -32;
    }

    private static char lowSurrogate(int i) {
        return (char) ((i & 1023) + 56320);
    }

    private static int trailingByteValue(byte b) {
        return b & 63;
    }
}
