package okhttp3.internal.http2;

import android.taobao.windvane.util.WVConstants;
import java.io.IOException;
import okhttp3.internal.C1421a;
import okio.ByteString;

/* compiled from: Taobao */
/* renamed from: okhttp3.internal.http2.c */
/* loaded from: classes.dex */
public final class C1455c {

    /* renamed from: a */
    static final ByteString f756a = ByteString.encodeUtf8("PRI * HTTP/2.0\r\n\r\nSM\r\n\r\n");

    /* renamed from: b */
    private static final String[] f757b = {WVConstants.INTENT_EXTRA_DATA, "HEADERS", "PRIORITY", "RST_STREAM", "SETTINGS", "PUSH_PROMISE", "PING", "GOAWAY", "WINDOW_UPDATE", "CONTINUATION"};

    /* renamed from: c */
    static final String[] f758c = new String[64];

    /* renamed from: d */
    static final String[] f759d = new String[256];

    static {
        int i = 0;
        int i2 = 0;
        while (true) {
            String[] strArr = f759d;
            if (i2 >= strArr.length) {
                break;
            }
            strArr[i2] = C1421a.m480q("%8s", Integer.toBinaryString(i2)).replace(' ', '0');
            i2++;
        }
        String[] strArr2 = f758c;
        strArr2[0] = "";
        strArr2[1] = "END_STREAM";
        int[] iArr = {1};
        strArr2[8] = "PADDED";
        for (int i3 = 0; i3 < 1; i3++) {
            int i4 = iArr[i3];
            String[] strArr3 = f758c;
            strArr3[i4 | 8] = strArr3[i4] + "|PADDED";
        }
        String[] strArr4 = f758c;
        strArr4[4] = "END_HEADERS";
        strArr4[32] = "PRIORITY";
        strArr4[36] = "END_HEADERS|PRIORITY";
        int[] iArr2 = {4, 32, 36};
        for (int i5 = 0; i5 < 3; i5++) {
            int i6 = iArr2[i5];
            for (int i7 = 0; i7 < 1; i7++) {
                int i8 = iArr[i7];
                String[] strArr5 = f758c;
                int i9 = i8 | i6;
                strArr5[i9] = strArr5[i8] + '|' + strArr5[i6];
                strArr5[i9 | 8] = strArr5[i8] + '|' + strArr5[i6] + "|PADDED";
            }
        }
        while (true) {
            String[] strArr6 = f758c;
            if (i >= strArr6.length) {
                return;
            }
            if (strArr6[i] == null) {
                strArr6[i] = f759d[i];
            }
            i++;
        }
    }

    private C1455c() {
    }

    /* renamed from: a */
    static String m685a(byte b, byte b2) {
        if (b2 == 0) {
            return "";
        }
        if (b != 2 && b != 3) {
            if (b == 4 || b == 6) {
                return b2 == 1 ? "ACK" : f759d[b2];
            }
            if (b != 7 && b != 8) {
                String[] strArr = f758c;
                String str = b2 < strArr.length ? strArr[b2] : f759d[b2];
                return (b != 5 || (b2 & 4) == 0) ? (b != 0 || (b2 & 32) == 0) ? str : str.replace("PRIORITY", "COMPRESSED") : str.replace("HEADERS", "PUSH_PROMISE");
            }
        }
        return f759d[b2];
    }

    /* renamed from: b */
    static String m686b(boolean z, int i, int i2, byte b, byte b2) {
        String[] strArr = f757b;
        String m480q = b < strArr.length ? strArr[b] : C1421a.m480q("0x%02x", Byte.valueOf(b));
        String m685a = m685a(b, b2);
        Object[] objArr = new Object[5];
        objArr[0] = z ? "<<" : ">>";
        objArr[1] = Integer.valueOf(i);
        objArr[2] = Integer.valueOf(i2);
        objArr[3] = m480q;
        objArr[4] = m685a;
        return C1421a.m480q("%s 0x%08x %5d %-13s %s", objArr);
    }

    /* renamed from: c */
    static IllegalArgumentException m687c(String str, Object... objArr) {
        throw new IllegalArgumentException(C1421a.m480q(str, objArr));
    }

    /* renamed from: d */
    static IOException m688d(String str, Object... objArr) throws IOException {
        throw new IOException(C1421a.m480q(str, objArr));
    }
}
