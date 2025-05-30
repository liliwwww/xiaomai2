package okhttp3.internal.http2;

import android.taobao.windvane.connect.HttpConnector;
import android.taobao.windvane.runtimepermission.PermissionChecker;
import android.taobao.windvane.util.WVNativeCallbackUtil;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;
import okio.Source;

/* compiled from: Taobao */
/* renamed from: okhttp3.internal.http2.b */
/* loaded from: classes.dex */
final class C1454b {

    /* renamed from: a */
    static final C1453a[] f737a;

    /* renamed from: b */
    static final Map<ByteString, Integer> f738b;

    /* compiled from: Taobao */
    /* renamed from: okhttp3.internal.http2.b$a */
    static final class a {

        /* renamed from: a */
        private final List<C1453a> f739a;

        /* renamed from: b */
        private final BufferedSource f740b;

        /* renamed from: c */
        private final int f741c;

        /* renamed from: d */
        private int f742d;

        /* renamed from: e */
        C1453a[] f743e;

        /* renamed from: f */
        int f744f;

        /* renamed from: g */
        int f745g;

        /* renamed from: h */
        int f746h;

        a(int i, Source source) {
            this(i, i, source);
        }

        /* renamed from: a */
        private void m660a() {
            int i = this.f742d;
            int i2 = this.f746h;
            if (i < i2) {
                if (i == 0) {
                    m661b();
                } else {
                    m663d(i2 - i);
                }
            }
        }

        /* renamed from: b */
        private void m661b() {
            Arrays.fill(this.f743e, (Object) null);
            this.f744f = this.f743e.length - 1;
            this.f745g = 0;
            this.f746h = 0;
        }

        /* renamed from: c */
        private int m662c(int i) {
            return this.f744f + 1 + i;
        }

        /* renamed from: d */
        private int m663d(int i) {
            int i2;
            int i3 = 0;
            if (i > 0) {
                int length = this.f743e.length;
                while (true) {
                    length--;
                    i2 = this.f744f;
                    if (length < i2 || i <= 0) {
                        break;
                    }
                    C1453a[] c1453aArr = this.f743e;
                    i -= c1453aArr[length].f736c;
                    this.f746h -= c1453aArr[length].f736c;
                    this.f745g--;
                    i3++;
                }
                C1453a[] c1453aArr2 = this.f743e;
                System.arraycopy(c1453aArr2, i2 + 1, c1453aArr2, i2 + 1 + i3, this.f745g);
                this.f744f += i3;
            }
            return i3;
        }

        /* renamed from: f */
        private ByteString m664f(int i) throws IOException {
            if (m666h(i)) {
                return C1454b.f737a[i].f734a;
            }
            int m662c = m662c(i - C1454b.f737a.length);
            if (m662c >= 0) {
                C1453a[] c1453aArr = this.f743e;
                if (m662c < c1453aArr.length) {
                    return c1453aArr[m662c].f734a;
                }
            }
            throw new IOException("Header index too large " + (i + 1));
        }

        /* renamed from: g */
        private void m665g(int i, C1453a c1453a) {
            this.f739a.add(c1453a);
            int i2 = c1453a.f736c;
            if (i != -1) {
                i2 -= this.f743e[m662c(i)].f736c;
            }
            int i3 = this.f742d;
            if (i2 > i3) {
                m661b();
                return;
            }
            int m663d = m663d((this.f746h + i2) - i3);
            if (i == -1) {
                int i4 = this.f745g + 1;
                C1453a[] c1453aArr = this.f743e;
                if (i4 > c1453aArr.length) {
                    C1453a[] c1453aArr2 = new C1453a[c1453aArr.length * 2];
                    System.arraycopy(c1453aArr, 0, c1453aArr2, c1453aArr.length, c1453aArr.length);
                    this.f744f = this.f743e.length - 1;
                    this.f743e = c1453aArr2;
                }
                int i5 = this.f744f;
                this.f744f = i5 - 1;
                this.f743e[i5] = c1453a;
                this.f745g++;
            } else {
                this.f743e[i + m662c(i) + m663d] = c1453a;
            }
            this.f746h += i2;
        }

        /* renamed from: h */
        private boolean m666h(int i) {
            return i >= 0 && i <= C1454b.f737a.length - 1;
        }

        /* renamed from: i */
        private int m667i() throws IOException {
            return this.f740b.readByte() & 255;
        }

        /* renamed from: l */
        private void m668l(int i) throws IOException {
            if (m666h(i)) {
                this.f739a.add(C1454b.f737a[i]);
                return;
            }
            int m662c = m662c(i - C1454b.f737a.length);
            if (m662c >= 0) {
                C1453a[] c1453aArr = this.f743e;
                if (m662c < c1453aArr.length) {
                    this.f739a.add(c1453aArr[m662c]);
                    return;
                }
            }
            throw new IOException("Header index too large " + (i + 1));
        }

        /* renamed from: n */
        private void m669n(int i) throws IOException {
            m665g(-1, new C1453a(m664f(i), m674j()));
        }

        /* renamed from: o */
        private void m670o() throws IOException {
            m665g(-1, new C1453a(C1454b.m658a(m674j()), m674j()));
        }

        /* renamed from: p */
        private void m671p(int i) throws IOException {
            this.f739a.add(new C1453a(m664f(i), m674j()));
        }

        /* renamed from: q */
        private void m672q() throws IOException {
            this.f739a.add(new C1453a(C1454b.m658a(m674j()), m674j()));
        }

        /* renamed from: e */
        public List<C1453a> m673e() {
            ArrayList arrayList = new ArrayList(this.f739a);
            this.f739a.clear();
            return arrayList;
        }

        /* renamed from: j */
        ByteString m674j() throws IOException {
            int m667i = m667i();
            boolean z = (m667i & 128) == 128;
            int m676m = m676m(m667i, 127);
            return z ? ByteString.of(C1459g.m728f().m729c(this.f740b.readByteArray(m676m))) : this.f740b.readByteString(m676m);
        }

        /* renamed from: k */
        void m675k() throws IOException {
            while (!this.f740b.exhausted()) {
                int readByte = this.f740b.readByte() & 255;
                if (readByte == 128) {
                    throw new IOException("index == 0");
                }
                if ((readByte & 128) == 128) {
                    m668l(m676m(readByte, 127) - 1);
                } else if (readByte == 64) {
                    m670o();
                } else if ((readByte & 64) == 64) {
                    m669n(m676m(readByte, 63) - 1);
                } else if ((readByte & 32) == 32) {
                    int m676m = m676m(readByte, 31);
                    this.f742d = m676m;
                    if (m676m < 0 || m676m > this.f741c) {
                        throw new IOException("Invalid dynamic table size update " + this.f742d);
                    }
                    m660a();
                } else if (readByte == 16 || readByte == 0) {
                    m672q();
                } else {
                    m671p(m676m(readByte, 15) - 1);
                }
            }
        }

        /* renamed from: m */
        int m676m(int i, int i2) throws IOException {
            int i3 = i & i2;
            if (i3 < i2) {
                return i3;
            }
            int i4 = 0;
            while (true) {
                int m667i = m667i();
                if ((m667i & 128) == 0) {
                    return i2 + (m667i << i4);
                }
                i2 += (m667i & 127) << i4;
                i4 += 7;
            }
        }

        a(int i, int i2, Source source) {
            this.f739a = new ArrayList();
            this.f743e = new C1453a[8];
            this.f744f = r0.length - 1;
            this.f745g = 0;
            this.f746h = 0;
            this.f741c = i;
            this.f742d = i2;
            this.f740b = okio.h.c(source);
        }
    }

    /* compiled from: Taobao */
    /* renamed from: okhttp3.internal.http2.b$b */
    static final class b {

        /* renamed from: a */
        private final Buffer f747a;

        /* renamed from: b */
        private final boolean f748b;

        /* renamed from: c */
        private int f749c;

        /* renamed from: d */
        private boolean f750d;

        /* renamed from: e */
        int f751e;

        /* renamed from: f */
        C1453a[] f752f;

        /* renamed from: g */
        int f753g;

        /* renamed from: h */
        int f754h;

        /* renamed from: i */
        int f755i;

        b(Buffer buffer) {
            this(4096, true, buffer);
        }

        /* renamed from: a */
        private void m677a() {
            int i = this.f751e;
            int i2 = this.f755i;
            if (i < i2) {
                if (i == 0) {
                    m678b();
                } else {
                    m679c(i2 - i);
                }
            }
        }

        /* renamed from: b */
        private void m678b() {
            Arrays.fill(this.f752f, (Object) null);
            this.f753g = this.f752f.length - 1;
            this.f754h = 0;
            this.f755i = 0;
        }

        /* renamed from: c */
        private int m679c(int i) {
            int i2;
            int i3 = 0;
            if (i > 0) {
                int length = this.f752f.length;
                while (true) {
                    length--;
                    i2 = this.f753g;
                    if (length < i2 || i <= 0) {
                        break;
                    }
                    C1453a[] c1453aArr = this.f752f;
                    i -= c1453aArr[length].f736c;
                    this.f755i -= c1453aArr[length].f736c;
                    this.f754h--;
                    i3++;
                }
                C1453a[] c1453aArr2 = this.f752f;
                System.arraycopy(c1453aArr2, i2 + 1, c1453aArr2, i2 + 1 + i3, this.f754h);
                C1453a[] c1453aArr3 = this.f752f;
                int i4 = this.f753g;
                Arrays.fill(c1453aArr3, i4 + 1, i4 + 1 + i3, (Object) null);
                this.f753g += i3;
            }
            return i3;
        }

        /* renamed from: d */
        private void m680d(C1453a c1453a) {
            int i = c1453a.f736c;
            int i2 = this.f751e;
            if (i > i2) {
                m678b();
                return;
            }
            m679c((this.f755i + i) - i2);
            int i3 = this.f754h + 1;
            C1453a[] c1453aArr = this.f752f;
            if (i3 > c1453aArr.length) {
                C1453a[] c1453aArr2 = new C1453a[c1453aArr.length * 2];
                System.arraycopy(c1453aArr, 0, c1453aArr2, c1453aArr.length, c1453aArr.length);
                this.f753g = this.f752f.length - 1;
                this.f752f = c1453aArr2;
            }
            int i4 = this.f753g;
            this.f753g = i4 - 1;
            this.f752f[i4] = c1453a;
            this.f754h++;
            this.f755i += i;
        }

        /* renamed from: e */
        void m681e(int i) {
            int min = Math.min(i, 16384);
            int i2 = this.f751e;
            if (i2 == min) {
                return;
            }
            if (min < i2) {
                this.f749c = Math.min(this.f749c, min);
            }
            this.f750d = true;
            this.f751e = min;
            m677a();
        }

        /* renamed from: f */
        void m682f(ByteString byteString) throws IOException {
            if (!this.f748b || C1459g.m728f().m731e(byteString) >= byteString.size()) {
                m684h(byteString.size(), 127, 0);
                this.f747a.write(byteString);
                return;
            }
            BufferedSink buffer = new Buffer();
            C1459g.m728f().m730d(byteString, buffer);
            ByteString readByteString = buffer.readByteString();
            m684h(readByteString.size(), 127, 128);
            this.f747a.write(readByteString);
        }

        /* renamed from: g */
        void m683g(List<C1453a> list) throws IOException {
            int i;
            int i2;
            if (this.f750d) {
                int i3 = this.f749c;
                if (i3 < this.f751e) {
                    m684h(i3, 31, 32);
                }
                this.f750d = false;
                this.f749c = Integer.MAX_VALUE;
                m684h(this.f751e, 31, 32);
            }
            int size = list.size();
            for (int i4 = 0; i4 < size; i4++) {
                C1453a c1453a = list.get(i4);
                ByteString asciiLowercase = c1453a.f734a.toAsciiLowercase();
                ByteString byteString = c1453a.f735b;
                Integer num = C1454b.f738b.get(asciiLowercase);
                if (num != null) {
                    i = num.intValue() + 1;
                    if (i > 1 && i < 8) {
                        C1453a[] c1453aArr = C1454b.f737a;
                        if (Objects.equals(c1453aArr[i - 1].f735b, byteString)) {
                            i2 = i;
                        } else if (Objects.equals(c1453aArr[i].f735b, byteString)) {
                            i2 = i;
                            i++;
                        }
                    }
                    i2 = i;
                    i = -1;
                } else {
                    i = -1;
                    i2 = -1;
                }
                if (i == -1) {
                    int i5 = this.f753g + 1;
                    int length = this.f752f.length;
                    while (true) {
                        if (i5 >= length) {
                            break;
                        }
                        if (Objects.equals(this.f752f[i5].f734a, asciiLowercase)) {
                            if (Objects.equals(this.f752f[i5].f735b, byteString)) {
                                i = C1454b.f737a.length + (i5 - this.f753g);
                                break;
                            } else if (i2 == -1) {
                                i2 = (i5 - this.f753g) + C1454b.f737a.length;
                            }
                        }
                        i5++;
                    }
                }
                if (i != -1) {
                    m684h(i, 127, 128);
                } else if (i2 == -1) {
                    this.f747a.writeByte(64);
                    m682f(asciiLowercase);
                    m682f(byteString);
                    m680d(c1453a);
                } else if (!asciiLowercase.startsWith(C1453a.PSEUDO_PREFIX) || C1453a.TARGET_AUTHORITY.equals(asciiLowercase)) {
                    m684h(i2, 63, 64);
                    m682f(byteString);
                    m680d(c1453a);
                } else {
                    m684h(i2, 15, 0);
                    m682f(byteString);
                }
            }
        }

        /* renamed from: h */
        void m684h(int i, int i2, int i3) {
            if (i < i2) {
                this.f747a.writeByte(i | i3);
                return;
            }
            this.f747a.writeByte(i3 | i2);
            int i4 = i - i2;
            while (i4 >= 128) {
                this.f747a.writeByte(128 | (i4 & 127));
                i4 >>>= 7;
            }
            this.f747a.writeByte(i4);
        }

        b(int i, boolean z, Buffer buffer) {
            this.f749c = Integer.MAX_VALUE;
            this.f752f = new C1453a[8];
            this.f753g = r0.length - 1;
            this.f754h = 0;
            this.f755i = 0;
            this.f751e = i;
            this.f748b = z;
            this.f747a = buffer;
        }
    }

    static {
        ByteString byteString = C1453a.TARGET_METHOD;
        ByteString byteString2 = C1453a.TARGET_PATH;
        ByteString byteString3 = C1453a.TARGET_SCHEME;
        ByteString byteString4 = C1453a.RESPONSE_STATUS;
        f737a = new C1453a[]{new C1453a(C1453a.TARGET_AUTHORITY, ""), new C1453a(byteString, "GET"), new C1453a(byteString, "POST"), new C1453a(byteString2, WVNativeCallbackUtil.SEPERATER), new C1453a(byteString2, "/index.html"), new C1453a(byteString3, "http"), new C1453a(byteString3, "https"), new C1453a(byteString4, "200"), new C1453a(byteString4, "204"), new C1453a(byteString4, "206"), new C1453a(byteString4, "304"), new C1453a(byteString4, "400"), new C1453a(byteString4, "404"), new C1453a(byteString4, "500"), new C1453a("accept-charset", ""), new C1453a("accept-encoding", "gzip, deflate"), new C1453a("accept-language", ""), new C1453a("accept-ranges", ""), new C1453a("accept", ""), new C1453a("access-control-allow-origin", ""), new C1453a("age", ""), new C1453a(PermissionChecker.PERMISSION_ALLOW, ""), new C1453a("authorization", ""), new C1453a(HttpConnector.CACHE_CONTROL, ""), new C1453a("content-disposition", ""), new C1453a("content-encoding", ""), new C1453a("content-language", ""), new C1453a(HttpConnector.CONTENT_LENGTH, ""), new C1453a("content-location", ""), new C1453a("content-range", ""), new C1453a(HttpConnector.CONTENT_TYPE, ""), new C1453a("cookie", ""), new C1453a(HttpConnector.DATE, ""), new C1453a(HttpConnector.ETAG, ""), new C1453a("expect", ""), new C1453a(HttpConnector.EXPIRES, ""), new C1453a(TypedValues.TransitionType.S_FROM, ""), new C1453a("host", ""), new C1453a("if-match", ""), new C1453a("if-modified-since", ""), new C1453a("if-none-match", ""), new C1453a("if-range", ""), new C1453a("if-unmodified-since", ""), new C1453a(HttpConnector.LAST_MODIFIED, ""), new C1453a("link", ""), new C1453a(HttpConnector.REDIRECT_LOCATION, ""), new C1453a("max-forwards", ""), new C1453a("proxy-authenticate", ""), new C1453a("proxy-authorization", ""), new C1453a("range", ""), new C1453a("referer", ""), new C1453a("refresh", ""), new C1453a("retry-after", ""), new C1453a("server", ""), new C1453a("set-cookie", ""), new C1453a("strict-transport-security", ""), new C1453a("transfer-encoding", ""), new C1453a("user-agent", ""), new C1453a("vary", ""), new C1453a("via", ""), new C1453a("www-authenticate", "")};
        f738b = m659b();
    }

    /* renamed from: a */
    static ByteString m658a(ByteString byteString) throws IOException {
        int size = byteString.size();
        for (int i = 0; i < size; i++) {
            byte b2 = byteString.getByte(i);
            if (b2 >= 65 && b2 <= 90) {
                throw new IOException("PROTOCOL_ERROR response malformed: mixed case name: " + byteString.utf8());
            }
        }
        return byteString;
    }

    /* renamed from: b */
    private static Map<ByteString, Integer> m659b() {
        LinkedHashMap linkedHashMap = new LinkedHashMap(f737a.length);
        int i = 0;
        while (true) {
            C1453a[] c1453aArr = f737a;
            if (i >= c1453aArr.length) {
                return Collections.unmodifiableMap(linkedHashMap);
            }
            if (!linkedHashMap.containsKey(c1453aArr[i].f734a)) {
                linkedHashMap.put(c1453aArr[i].f734a, Integer.valueOf(i));
            }
            i++;
        }
    }
}
