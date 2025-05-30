package okhttp3.internal.p011ws;

import okio.Buffer;

/* compiled from: Taobao */
/* renamed from: okhttp3.internal.ws.a */
/* loaded from: classes2.dex */
public final class C1468a {
    /* renamed from: a */
    static String m762a(int i) {
        if (i < 1000 || i >= 5000) {
            return "Code must be in range [1000,5000): " + i;
        }
        if ((i < 1004 || i > 1006) && (i < 1012 || i > 2999)) {
            return null;
        }
        return "Code " + i + " is reserved and may not be used.";
    }

    /* renamed from: b */
    static void m763b(Buffer.c cVar, byte[] bArr) {
        int length = bArr.length;
        int i = 0;
        do {
            byte[] bArr2 = cVar.e;
            int i2 = cVar.f;
            int i3 = cVar.g;
            while (i2 < i3) {
                int i4 = i % length;
                bArr2[i2] = (byte) (bArr2[i2] ^ bArr[i4]);
                i2++;
                i = i4 + 1;
            }
        } while (cVar.a() != -1);
    }

    /* renamed from: c */
    static void m764c(int i) {
        String m762a = m762a(i);
        if (m762a != null) {
            throw new IllegalArgumentException(m762a);
        }
    }
}
