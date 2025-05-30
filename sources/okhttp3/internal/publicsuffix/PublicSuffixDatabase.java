package okhttp3.internal.publicsuffix;

import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.net.IDN;
import java.nio.charset.StandardCharsets;
import java.util.Objects;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import okio.BufferedSource;
import okio.f;
import okio.h;
import tb.iv3;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public final class PublicSuffixDatabase {
    public static final String PUBLIC_SUFFIX_RESOURCE = "publicsuffixes.gz";

    /* renamed from: e */
    private static final byte[] f809e = {42};

    /* renamed from: f */
    private static final String[] f810f = new String[0];

    /* renamed from: g */
    private static final String[] f811g = {"*"};

    /* renamed from: h */
    private static final PublicSuffixDatabase f812h = new PublicSuffixDatabase();

    /* renamed from: a */
    private final AtomicBoolean f813a = new AtomicBoolean(false);

    /* renamed from: b */
    private final CountDownLatch f814b = new CountDownLatch(1);

    /* renamed from: c */
    private byte[] f815c;

    /* renamed from: d */
    private byte[] f816d;

    /* renamed from: a */
    private static String m742a(byte[] bArr, byte[][] bArr2, int i) {
        int i2;
        boolean z;
        int i3;
        int i4;
        int length = bArr.length;
        int i5 = 0;
        while (i5 < length) {
            int i6 = (i5 + length) / 2;
            while (i6 > -1 && bArr[i6] != 10) {
                i6--;
            }
            int i7 = i6 + 1;
            int i8 = 1;
            while (true) {
                i2 = i7 + i8;
                if (bArr[i2] == 10) {
                    break;
                }
                i8++;
            }
            int i9 = i2 - i7;
            int i10 = i;
            boolean z2 = false;
            int i11 = 0;
            int i12 = 0;
            while (true) {
                if (z2) {
                    i3 = 46;
                    z = false;
                } else {
                    z = z2;
                    i3 = bArr2[i10][i11] & 255;
                }
                i4 = i3 - (bArr[i7 + i12] & 255);
                if (i4 == 0) {
                    i12++;
                    i11++;
                    if (i12 == i9) {
                        break;
                    }
                    if (bArr2[i10].length != i11) {
                        z2 = z;
                    } else {
                        if (i10 == bArr2.length - 1) {
                            break;
                        }
                        i10++;
                        z2 = true;
                        i11 = -1;
                    }
                } else {
                    break;
                }
            }
            if (i4 >= 0) {
                if (i4 <= 0) {
                    int i13 = i9 - i12;
                    int length2 = bArr2[i10].length - i11;
                    while (true) {
                        i10++;
                        if (i10 >= bArr2.length) {
                            break;
                        }
                        length2 += bArr2[i10].length;
                    }
                    if (length2 >= i13) {
                        if (length2 <= i13) {
                            return new String(bArr, i7, i9, StandardCharsets.UTF_8);
                        }
                    }
                }
                i5 = i2 + 1;
            }
            length = i7 - 1;
        }
        return null;
    }

    /* renamed from: b */
    private String[] m743b(String[] strArr) {
        String str;
        String str2;
        String str3;
        int i = 0;
        if (this.f813a.get() || !this.f813a.compareAndSet(false, true)) {
            try {
                this.f814b.await();
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
        } else {
            m746f();
        }
        synchronized (this) {
            if (this.f815c == null) {
                throw new IllegalStateException("Unable to load publicsuffixes.gz resource from the classpath.");
            }
        }
        int length = strArr.length;
        byte[][] bArr = new byte[length][];
        for (int i2 = 0; i2 < strArr.length; i2++) {
            bArr[i2] = strArr[i2].getBytes(StandardCharsets.UTF_8);
        }
        int i3 = 0;
        while (true) {
            str = null;
            if (i3 >= length) {
                str2 = null;
                break;
            }
            str2 = m742a(this.f815c, bArr, i3);
            if (str2 != null) {
                break;
            }
            i3++;
        }
        if (length > 1) {
            byte[][] bArr2 = (byte[][]) bArr.clone();
            for (int i4 = 0; i4 < bArr2.length - 1; i4++) {
                bArr2[i4] = f809e;
                str3 = m742a(this.f815c, bArr2, i4);
                if (str3 != null) {
                    break;
                }
            }
        }
        str3 = null;
        if (str3 != null) {
            while (true) {
                if (i >= length - 1) {
                    break;
                }
                String m742a = m742a(this.f816d, bArr, i);
                if (m742a != null) {
                    str = m742a;
                    break;
                }
                i++;
            }
        }
        if (str != null) {
            return ("!" + str).split("\\.");
        }
        if (str2 == null && str3 == null) {
            return f811g;
        }
        String[] split = str2 != null ? str2.split("\\.") : f810f;
        String[] split2 = str3 != null ? str3.split("\\.") : f810f;
        return split.length > split2.length ? split : split2;
    }

    /* renamed from: c */
    public static PublicSuffixDatabase m744c() {
        return f812h;
    }

    /* renamed from: e */
    private void m745e() throws IOException {
        InputStream resourceAsStream = PublicSuffixDatabase.class.getResourceAsStream(PUBLIC_SUFFIX_RESOURCE);
        if (resourceAsStream == null) {
            return;
        }
        BufferedSource c = h.c(new f(h.j(resourceAsStream)));
        try {
            byte[] bArr = new byte[c.readInt()];
            c.readFully(bArr);
            byte[] bArr2 = new byte[c.readInt()];
            c.readFully(bArr2);
            c.close();
            synchronized (this) {
                this.f815c = bArr;
                this.f816d = bArr2;
            }
            this.f814b.countDown();
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                if (c != null) {
                    try {
                        c.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                }
                throw th2;
            }
        }
    }

    /* renamed from: f */
    private void m746f() {
        boolean z = false;
        while (true) {
            try {
                try {
                    m745e();
                    break;
                } catch (InterruptedIOException unused) {
                    Thread.interrupted();
                    z = true;
                } catch (IOException e) {
                    iv3.j().p(5, "Failed to read public suffix list", e);
                    if (z) {
                        Thread.currentThread().interrupt();
                        return;
                    }
                    return;
                }
            } catch (Throwable th) {
                if (z) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (z) {
            Thread.currentThread().interrupt();
        }
    }

    /* renamed from: d */
    public String m747d(String str) {
        int length;
        int length2;
        Objects.requireNonNull(str, "domain == null");
        String[] split = IDN.toUnicode(str).split("\\.");
        String[] m743b = m743b(split);
        if (split.length == m743b.length && m743b[0].charAt(0) != '!') {
            return null;
        }
        if (m743b[0].charAt(0) == '!') {
            length = split.length;
            length2 = m743b.length;
        } else {
            length = split.length;
            length2 = m743b.length + 1;
        }
        StringBuilder sb = new StringBuilder();
        String[] split2 = str.split("\\.");
        for (int i = length - length2; i < split2.length; i++) {
            sb.append(split2[i]);
            sb.append('.');
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
}
