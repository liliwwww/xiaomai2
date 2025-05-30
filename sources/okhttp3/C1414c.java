package okhttp3;

import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import javax.annotation.Nullable;
import javax.net.ssl.SSLPeerUnverifiedException;
import okhttp3.internal.tls.AbstractC1463b;
import okio.ByteString;

/* compiled from: Taobao */
/* renamed from: okhttp3.c */
/* loaded from: classes2.dex */
public final class C1414c {
    public static final C1414c DEFAULT = new a().m413a();

    /* renamed from: a */
    private final Set<b> f534a;

    /* renamed from: b */
    @Nullable
    private final AbstractC1463b f535b;

    /* compiled from: Taobao */
    /* renamed from: okhttp3.c$a */
    public static final class a {

        /* renamed from: a */
        private final List<b> f536a = new ArrayList();

        /* renamed from: a */
        public C1414c m413a() {
            return new C1414c(new LinkedHashSet(this.f536a), null);
        }
    }

    /* compiled from: Taobao */
    /* renamed from: okhttp3.c$b */
    static final class b {

        /* renamed from: a */
        final String f537a;

        /* renamed from: b */
        final String f538b;

        /* renamed from: c */
        final String f539c;

        /* renamed from: d */
        final ByteString f540d;

        /* renamed from: a */
        boolean m414a(String str) {
            if (!this.f537a.startsWith("*.")) {
                return str.equals(this.f538b);
            }
            int indexOf = str.indexOf(46);
            if ((str.length() - indexOf) - 1 == this.f538b.length()) {
                String str2 = this.f538b;
                if (str.regionMatches(false, indexOf + 1, str2, 0, str2.length())) {
                    return true;
                }
            }
            return false;
        }

        public boolean equals(Object obj) {
            if (obj instanceof b) {
                b bVar = (b) obj;
                if (this.f537a.equals(bVar.f537a) && this.f539c.equals(bVar.f539c) && this.f540d.equals(bVar.f540d)) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            return ((((527 + this.f537a.hashCode()) * 31) + this.f539c.hashCode()) * 31) + this.f540d.hashCode();
        }

        public String toString() {
            return this.f539c + this.f540d.base64();
        }
    }

    C1414c(Set<b> set, @Nullable AbstractC1463b abstractC1463b) {
        this.f534a = set;
        this.f535b = abstractC1463b;
    }

    /* renamed from: c */
    public static String m407c(Certificate certificate) {
        if (!(certificate instanceof X509Certificate)) {
            throw new IllegalArgumentException("Certificate pinning requires X509 certificates");
        }
        return "sha256/" + m409e((X509Certificate) certificate).base64();
    }

    /* renamed from: d */
    static ByteString m408d(X509Certificate x509Certificate) {
        return ByteString.of(x509Certificate.getPublicKey().getEncoded()).sha1();
    }

    /* renamed from: e */
    static ByteString m409e(X509Certificate x509Certificate) {
        return ByteString.of(x509Certificate.getPublicKey().getEncoded()).sha256();
    }

    /* renamed from: a */
    public void m410a(String str, List<Certificate> list) throws SSLPeerUnverifiedException {
        List<b> m411b = m411b(str);
        if (m411b.isEmpty()) {
            return;
        }
        AbstractC1463b abstractC1463b = this.f535b;
        if (abstractC1463b != null) {
            list = abstractC1463b.mo749a(list, str);
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            X509Certificate x509Certificate = (X509Certificate) list.get(i);
            int size2 = m411b.size();
            ByteString byteString = null;
            ByteString byteString2 = null;
            for (int i2 = 0; i2 < size2; i2++) {
                b bVar = m411b.get(i2);
                if (bVar.f539c.equals("sha256/")) {
                    if (byteString == null) {
                        byteString = m409e(x509Certificate);
                    }
                    if (bVar.f540d.equals(byteString)) {
                        return;
                    }
                } else {
                    if (!bVar.f539c.equals("sha1/")) {
                        throw new AssertionError("unsupported hashAlgorithm: " + bVar.f539c);
                    }
                    if (byteString2 == null) {
                        byteString2 = m408d(x509Certificate);
                    }
                    if (bVar.f540d.equals(byteString2)) {
                        return;
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Certificate pinning failure!");
        sb.append("\n  Peer certificate chain:");
        int size3 = list.size();
        for (int i3 = 0; i3 < size3; i3++) {
            X509Certificate x509Certificate2 = (X509Certificate) list.get(i3);
            sb.append("\n    ");
            sb.append(m407c(x509Certificate2));
            sb.append(": ");
            sb.append(x509Certificate2.getSubjectDN().getName());
        }
        sb.append("\n  Pinned certificates for ");
        sb.append(str);
        sb.append(":");
        int size4 = m411b.size();
        for (int i4 = 0; i4 < size4; i4++) {
            b bVar2 = m411b.get(i4);
            sb.append("\n    ");
            sb.append(bVar2);
        }
        throw new SSLPeerUnverifiedException(sb.toString());
    }

    /* renamed from: b */
    List<b> m411b(String str) {
        List<b> emptyList = Collections.emptyList();
        for (b bVar : this.f534a) {
            if (bVar.m414a(str)) {
                if (emptyList.isEmpty()) {
                    emptyList = new ArrayList<>();
                }
                emptyList.add(bVar);
            }
        }
        return emptyList;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof C1414c) {
            C1414c c1414c = (C1414c) obj;
            if (Objects.equals(this.f535b, c1414c.f535b) && this.f534a.equals(c1414c.f534a)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: f */
    C1414c m412f(@Nullable AbstractC1463b abstractC1463b) {
        return Objects.equals(this.f535b, abstractC1463b) ? this : new C1414c(this.f534a, abstractC1463b);
    }

    public int hashCode() {
        return (Objects.hashCode(this.f535b) * 31) + this.f534a.hashCode();
    }
}
