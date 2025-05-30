package okhttp3;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import javax.annotation.Nullable;
import javax.net.ssl.SSLSocket;
import okhttp3.internal.C1421a;

/* compiled from: Taobao */
/* renamed from: okhttp3.f */
/* loaded from: classes2.dex */
public final class C1417f {
    public static final C1417f CLEARTEXT;
    public static final C1417f COMPATIBLE_TLS;
    public static final C1417f MODERN_TLS;
    public static final C1417f RESTRICTED_TLS;

    /* renamed from: e */
    private static final C1415d[] f545e;

    /* renamed from: f */
    private static final C1415d[] f546f;

    /* renamed from: a */
    final boolean f547a;

    /* renamed from: b */
    final boolean f548b;

    /* renamed from: c */
    @Nullable
    final String[] f549c;

    /* renamed from: d */
    @Nullable
    final String[] f550d;

    static {
        C1415d c1415d = C1415d.TLS_AES_128_GCM_SHA256;
        C1415d c1415d2 = C1415d.TLS_AES_256_GCM_SHA384;
        C1415d c1415d3 = C1415d.TLS_CHACHA20_POLY1305_SHA256;
        C1415d c1415d4 = C1415d.TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256;
        C1415d c1415d5 = C1415d.TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256;
        C1415d c1415d6 = C1415d.TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384;
        C1415d c1415d7 = C1415d.TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384;
        C1415d c1415d8 = C1415d.TLS_ECDHE_ECDSA_WITH_CHACHA20_POLY1305_SHA256;
        C1415d c1415d9 = C1415d.TLS_ECDHE_RSA_WITH_CHACHA20_POLY1305_SHA256;
        C1415d[] c1415dArr = {c1415d, c1415d2, c1415d3, c1415d4, c1415d5, c1415d6, c1415d7, c1415d8, c1415d9};
        f545e = c1415dArr;
        C1415d[] c1415dArr2 = {c1415d, c1415d2, c1415d3, c1415d4, c1415d5, c1415d6, c1415d7, c1415d8, c1415d9, C1415d.TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA, C1415d.TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA, C1415d.TLS_RSA_WITH_AES_128_GCM_SHA256, C1415d.TLS_RSA_WITH_AES_256_GCM_SHA384, C1415d.TLS_RSA_WITH_AES_128_CBC_SHA, C1415d.TLS_RSA_WITH_AES_256_CBC_SHA, C1415d.TLS_RSA_WITH_3DES_EDE_CBC_SHA};
        f546f = c1415dArr2;
        a m430c = new a(true).m430c(c1415dArr);
        TlsVersion tlsVersion = TlsVersion.TLS_1_3;
        TlsVersion tlsVersion2 = TlsVersion.TLS_1_2;
        RESTRICTED_TLS = m430c.m433f(tlsVersion, tlsVersion2).m431d(true).m428a();
        MODERN_TLS = new a(true).m430c(c1415dArr2).m433f(tlsVersion, tlsVersion2).m431d(true).m428a();
        COMPATIBLE_TLS = new a(true).m430c(c1415dArr2).m433f(tlsVersion, tlsVersion2, TlsVersion.TLS_1_1, TlsVersion.TLS_1_0).m431d(true).m428a();
        CLEARTEXT = new a(false).m428a();
    }

    C1417f(a aVar) {
        this.f547a = aVar.f551a;
        this.f549c = aVar.f552b;
        this.f550d = aVar.f553c;
        this.f548b = aVar.f554d;
    }

    /* renamed from: e */
    private C1417f m421e(SSLSocket sSLSocket, boolean z) {
        String[] m489z = this.f549c != null ? C1421a.m489z(C1415d.f541b, sSLSocket.getEnabledCipherSuites(), this.f549c) : sSLSocket.getEnabledCipherSuites();
        String[] m489z2 = this.f550d != null ? C1421a.m489z(C1421a.NATURAL_ORDER, sSLSocket.getEnabledProtocols(), this.f550d) : sSLSocket.getEnabledProtocols();
        String[] supportedCipherSuites = sSLSocket.getSupportedCipherSuites();
        int m486w = C1421a.m486w(C1415d.f541b, supportedCipherSuites, "TLS_FALLBACK_SCSV");
        if (z && m486w != -1) {
            m489z = C1421a.m472i(m489z, supportedCipherSuites[m486w]);
        }
        return new a(this).m429b(m489z).m432e(m489z2).m428a();
    }

    /* renamed from: a */
    void m422a(SSLSocket sSLSocket, boolean z) {
        C1417f m421e = m421e(sSLSocket, z);
        String[] strArr = m421e.f550d;
        if (strArr != null) {
            sSLSocket.setEnabledProtocols(strArr);
        }
        String[] strArr2 = m421e.f549c;
        if (strArr2 != null) {
            sSLSocket.setEnabledCipherSuites(strArr2);
        }
    }

    @Nullable
    /* renamed from: b */
    public List<C1415d> m423b() {
        String[] strArr = this.f549c;
        if (strArr != null) {
            return C1415d.m417c(strArr);
        }
        return null;
    }

    /* renamed from: c */
    public boolean m424c(SSLSocket sSLSocket) {
        if (!this.f547a) {
            return false;
        }
        String[] strArr = this.f550d;
        if (strArr != null && !C1421a.m453C(C1421a.NATURAL_ORDER, strArr, sSLSocket.getEnabledProtocols())) {
            return false;
        }
        String[] strArr2 = this.f549c;
        return strArr2 == null || C1421a.m453C(C1415d.f541b, strArr2, sSLSocket.getEnabledCipherSuites());
    }

    /* renamed from: d */
    public boolean m425d() {
        return this.f547a;
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof C1417f)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        C1417f c1417f = (C1417f) obj;
        boolean z = this.f547a;
        if (z != c1417f.f547a) {
            return false;
        }
        return !z || (Arrays.equals(this.f549c, c1417f.f549c) && Arrays.equals(this.f550d, c1417f.f550d) && this.f548b == c1417f.f548b);
    }

    /* renamed from: f */
    public boolean m426f() {
        return this.f548b;
    }

    @Nullable
    /* renamed from: g */
    public List<TlsVersion> m427g() {
        String[] strArr = this.f550d;
        if (strArr != null) {
            return TlsVersion.forJavaNames(strArr);
        }
        return null;
    }

    public int hashCode() {
        if (this.f547a) {
            return ((((527 + Arrays.hashCode(this.f549c)) * 31) + Arrays.hashCode(this.f550d)) * 31) + (!this.f548b ? 1 : 0);
        }
        return 17;
    }

    public String toString() {
        if (!this.f547a) {
            return "ConnectionSpec()";
        }
        return "ConnectionSpec(cipherSuites=" + Objects.toString(m423b(), "[all enabled]") + ", tlsVersions=" + Objects.toString(m427g(), "[all enabled]") + ", supportsTlsExtensions=" + this.f548b + ")";
    }

    /* compiled from: Taobao */
    /* renamed from: okhttp3.f$a */
    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a */
        boolean f551a;

        /* renamed from: b */
        @Nullable
        String[] f552b;

        /* renamed from: c */
        @Nullable
        String[] f553c;

        /* renamed from: d */
        boolean f554d;

        a(boolean z) {
            this.f551a = z;
        }

        /* renamed from: a */
        public C1417f m428a() {
            return new C1417f(this);
        }

        /* renamed from: b */
        public a m429b(String... strArr) {
            if (!this.f551a) {
                throw new IllegalStateException("no cipher suites for cleartext connections");
            }
            if (strArr.length == 0) {
                throw new IllegalArgumentException("At least one cipher suite is required");
            }
            this.f552b = (String[]) strArr.clone();
            return this;
        }

        /* renamed from: c */
        public a m430c(C1415d... c1415dArr) {
            if (!this.f551a) {
                throw new IllegalStateException("no cipher suites for cleartext connections");
            }
            String[] strArr = new String[c1415dArr.length];
            for (int i = 0; i < c1415dArr.length; i++) {
                strArr[i] = c1415dArr[i].f543a;
            }
            return m429b(strArr);
        }

        /* renamed from: d */
        public a m431d(boolean z) {
            if (!this.f551a) {
                throw new IllegalStateException("no TLS extensions for cleartext connections");
            }
            this.f554d = z;
            return this;
        }

        /* renamed from: e */
        public a m432e(String... strArr) {
            if (!this.f551a) {
                throw new IllegalStateException("no TLS versions for cleartext connections");
            }
            if (strArr.length == 0) {
                throw new IllegalArgumentException("At least one TLS version is required");
            }
            this.f553c = (String[]) strArr.clone();
            return this;
        }

        /* renamed from: f */
        public a m433f(TlsVersion... tlsVersionArr) {
            if (!this.f551a) {
                throw new IllegalStateException("no TLS versions for cleartext connections");
            }
            String[] strArr = new String[tlsVersionArr.length];
            for (int i = 0; i < tlsVersionArr.length; i++) {
                strArr[i] = tlsVersionArr[i].javaName;
            }
            return m432e(strArr);
        }

        public a(C1417f c1417f) {
            this.f551a = c1417f.f547a;
            this.f552b = c1417f.f549c;
            this.f553c = c1417f.f550d;
            this.f554d = c1417f.f548b;
        }
    }
}
