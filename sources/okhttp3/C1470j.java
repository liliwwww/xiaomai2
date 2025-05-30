package okhttp3;

import android.taobao.windvane.connect.HttpRequest;
import java.io.IOException;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.annotation.Nullable;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import okhttp3.internal.C1421a;

/* compiled from: Taobao */
/* renamed from: okhttp3.j */
/* loaded from: classes2.dex */
public final class C1470j {

    /* renamed from: a */
    private final TlsVersion f874a;

    /* renamed from: b */
    private final C1415d f875b;

    /* renamed from: c */
    private final List<Certificate> f876c;

    /* renamed from: d */
    private final List<Certificate> f877d;

    private C1470j(TlsVersion tlsVersion, C1415d c1415d, List<Certificate> list, List<Certificate> list2) {
        this.f874a = tlsVersion;
        this.f875b = c1415d;
        this.f876c = list;
        this.f877d = list2;
    }

    /* renamed from: b */
    public static C1470j m771b(SSLSession sSLSession) throws IOException {
        Certificate[] certificateArr;
        String cipherSuite = sSLSession.getCipherSuite();
        if (cipherSuite == null) {
            throw new IllegalStateException("cipherSuite == null");
        }
        if ("SSL_NULL_WITH_NULL_NULL".equals(cipherSuite)) {
            throw new IOException("cipherSuite == SSL_NULL_WITH_NULL_NULL");
        }
        C1415d m416b = C1415d.m416b(cipherSuite);
        String protocol = sSLSession.getProtocol();
        if (protocol == null) {
            throw new IllegalStateException("tlsVersion == null");
        }
        if (HttpRequest.DEFAULT_HTTPS_ERROR_NONE.equals(protocol)) {
            throw new IOException("tlsVersion == NONE");
        }
        TlsVersion forJavaName = TlsVersion.forJavaName(protocol);
        try {
            certificateArr = sSLSession.getPeerCertificates();
        } catch (SSLPeerUnverifiedException unused) {
            certificateArr = null;
        }
        List m484u = certificateArr != null ? C1421a.m484u(certificateArr) : Collections.emptyList();
        Certificate[] localCertificates = sSLSession.getLocalCertificates();
        return new C1470j(forJavaName, m416b, m484u, localCertificates != null ? C1421a.m484u(localCertificates) : Collections.emptyList());
    }

    /* renamed from: c */
    private List<String> m772c(List<Certificate> list) {
        ArrayList arrayList = new ArrayList();
        for (Certificate certificate : list) {
            if (certificate instanceof X509Certificate) {
                arrayList.add(String.valueOf(((X509Certificate) certificate).getSubjectDN()));
            } else {
                arrayList.add(certificate.getType());
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    public C1415d m773a() {
        return this.f875b;
    }

    /* renamed from: d */
    public List<Certificate> m774d() {
        return this.f876c;
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof C1470j)) {
            return false;
        }
        C1470j c1470j = (C1470j) obj;
        return this.f874a.equals(c1470j.f874a) && this.f875b.equals(c1470j.f875b) && this.f876c.equals(c1470j.f876c) && this.f877d.equals(c1470j.f877d);
    }

    public int hashCode() {
        return ((((((527 + this.f874a.hashCode()) * 31) + this.f875b.hashCode()) * 31) + this.f876c.hashCode()) * 31) + this.f877d.hashCode();
    }

    public String toString() {
        return "Handshake{tlsVersion=" + this.f874a + " cipherSuite=" + this.f875b + " peerCertificates=" + m772c(this.f876c) + " localCertificates=" + m772c(this.f877d) + '}';
    }
}
