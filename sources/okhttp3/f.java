package okhttp3;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import javax.annotation.Nullable;
import javax.net.ssl.SSLSocket;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class f {
    public static final f CLEARTEXT;
    public static final f COMPATIBLE_TLS;
    public static final f MODERN_TLS;
    public static final f RESTRICTED_TLS;
    private static final d[] e;
    private static final d[] f;
    final boolean a;
    final boolean b;

    @Nullable
    final String[] c;

    @Nullable
    final String[] d;

    static {
        d dVar = d.TLS_AES_128_GCM_SHA256;
        d dVar2 = d.TLS_AES_256_GCM_SHA384;
        d dVar3 = d.TLS_CHACHA20_POLY1305_SHA256;
        d dVar4 = d.TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256;
        d dVar5 = d.TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256;
        d dVar6 = d.TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384;
        d dVar7 = d.TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384;
        d dVar8 = d.TLS_ECDHE_ECDSA_WITH_CHACHA20_POLY1305_SHA256;
        d dVar9 = d.TLS_ECDHE_RSA_WITH_CHACHA20_POLY1305_SHA256;
        d[] dVarArr = {dVar, dVar2, dVar3, dVar4, dVar5, dVar6, dVar7, dVar8, dVar9};
        e = dVarArr;
        d[] dVarArr2 = {dVar, dVar2, dVar3, dVar4, dVar5, dVar6, dVar7, dVar8, dVar9, d.TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA, d.TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA, d.TLS_RSA_WITH_AES_128_GCM_SHA256, d.TLS_RSA_WITH_AES_256_GCM_SHA384, d.TLS_RSA_WITH_AES_128_CBC_SHA, d.TLS_RSA_WITH_AES_256_CBC_SHA, d.TLS_RSA_WITH_3DES_EDE_CBC_SHA};
        f = dVarArr2;
        a c = new a(true).c(dVarArr);
        TlsVersion tlsVersion = TlsVersion.TLS_1_3;
        TlsVersion tlsVersion2 = TlsVersion.TLS_1_2;
        RESTRICTED_TLS = c.f(new TlsVersion[]{tlsVersion, tlsVersion2}).d(true).a();
        MODERN_TLS = new a(true).c(dVarArr2).f(new TlsVersion[]{tlsVersion, tlsVersion2}).d(true).a();
        COMPATIBLE_TLS = new a(true).c(dVarArr2).f(new TlsVersion[]{tlsVersion, tlsVersion2, TlsVersion.TLS_1_1, TlsVersion.TLS_1_0}).d(true).a();
        CLEARTEXT = new a(false).a();
    }

    f(a aVar) {
        this.a = aVar.a;
        this.c = aVar.b;
        this.d = aVar.c;
        this.b = aVar.d;
    }

    private f e(SSLSocket sSLSocket, boolean z) {
        String[] z2 = this.c != null ? okhttp3.internal.a.z(d.b, sSLSocket.getEnabledCipherSuites(), this.c) : sSLSocket.getEnabledCipherSuites();
        String[] z3 = this.d != null ? okhttp3.internal.a.z(okhttp3.internal.a.NATURAL_ORDER, sSLSocket.getEnabledProtocols(), this.d) : sSLSocket.getEnabledProtocols();
        String[] supportedCipherSuites = sSLSocket.getSupportedCipherSuites();
        int w = okhttp3.internal.a.w(d.b, supportedCipherSuites, "TLS_FALLBACK_SCSV");
        if (z && w != -1) {
            z2 = okhttp3.internal.a.i(z2, supportedCipherSuites[w]);
        }
        return new a(this).b(z2).e(z3).a();
    }

    void a(SSLSocket sSLSocket, boolean z) {
        f e2 = e(sSLSocket, z);
        String[] strArr = e2.d;
        if (strArr != null) {
            sSLSocket.setEnabledProtocols(strArr);
        }
        String[] strArr2 = e2.c;
        if (strArr2 != null) {
            sSLSocket.setEnabledCipherSuites(strArr2);
        }
    }

    @Nullable
    public List<d> b() {
        String[] strArr = this.c;
        if (strArr != null) {
            return d.c(strArr);
        }
        return null;
    }

    public boolean c(SSLSocket sSLSocket) {
        if (!this.a) {
            return false;
        }
        String[] strArr = this.d;
        if (strArr != null && !okhttp3.internal.a.C(okhttp3.internal.a.NATURAL_ORDER, strArr, sSLSocket.getEnabledProtocols())) {
            return false;
        }
        String[] strArr2 = this.c;
        return strArr2 == null || okhttp3.internal.a.C(d.b, strArr2, sSLSocket.getEnabledCipherSuites());
    }

    public boolean d() {
        return this.a;
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof f)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        f fVar = (f) obj;
        boolean z = this.a;
        if (z != fVar.a) {
            return false;
        }
        return !z || (Arrays.equals(this.c, fVar.c) && Arrays.equals(this.d, fVar.d) && this.b == fVar.b);
    }

    public boolean f() {
        return this.b;
    }

    @Nullable
    public List<TlsVersion> g() {
        String[] strArr = this.d;
        if (strArr != null) {
            return TlsVersion.forJavaNames(strArr);
        }
        return null;
    }

    public int hashCode() {
        if (this.a) {
            return ((((527 + Arrays.hashCode(this.c)) * 31) + Arrays.hashCode(this.d)) * 31) + (!this.b ? 1 : 0);
        }
        return 17;
    }

    public String toString() {
        if (!this.a) {
            return "ConnectionSpec()";
        }
        return "ConnectionSpec(cipherSuites=" + Objects.toString(b(), "[all enabled]") + ", tlsVersions=" + Objects.toString(g(), "[all enabled]") + ", supportsTlsExtensions=" + this.b + ")";
    }
}
