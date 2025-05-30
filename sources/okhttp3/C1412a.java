package okhttp3;

import java.net.Proxy;
import java.net.ProxySelector;
import java.util.List;
import java.util.Objects;
import javax.annotation.Nullable;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import okhttp3.C1472l;
import okhttp3.internal.C1421a;

/* compiled from: Taobao */
/* renamed from: okhttp3.a */
/* loaded from: classes2.dex */
public final class C1412a {

    /* renamed from: a */
    final C1472l f523a;

    /* renamed from: b */
    final Dns f524b;

    /* renamed from: c */
    final SocketFactory f525c;

    /* renamed from: d */
    final Authenticator f526d;

    /* renamed from: e */
    final List<Protocol> f527e;

    /* renamed from: f */
    final List<C1417f> f528f;

    /* renamed from: g */
    final ProxySelector f529g;

    /* renamed from: h */
    @Nullable
    final Proxy f530h;

    /* renamed from: i */
    @Nullable
    final SSLSocketFactory f531i;

    /* renamed from: j */
    @Nullable
    final HostnameVerifier f532j;

    /* renamed from: k */
    @Nullable
    final C1414c f533k;

    public C1412a(String str, int i, Dns dns, SocketFactory socketFactory, @Nullable SSLSocketFactory sSLSocketFactory, @Nullable HostnameVerifier hostnameVerifier, @Nullable C1414c c1414c, Authenticator authenticator, @Nullable Proxy proxy, List<Protocol> list, List<C1417f> list2, ProxySelector proxySelector) {
        this.f523a = new C1472l.a().m840q(sSLSocketFactory != null ? "https" : "http").m835e(str).m838l(i).m832a();
        Objects.requireNonNull(dns, "dns == null");
        this.f524b = dns;
        Objects.requireNonNull(socketFactory, "socketFactory == null");
        this.f525c = socketFactory;
        Objects.requireNonNull(authenticator, "proxyAuthenticator == null");
        this.f526d = authenticator;
        Objects.requireNonNull(list, "protocols == null");
        this.f527e = C1421a.m483t(list);
        Objects.requireNonNull(list2, "connectionSpecs == null");
        this.f528f = C1421a.m483t(list2);
        Objects.requireNonNull(proxySelector, "proxySelector == null");
        this.f529g = proxySelector;
        this.f530h = proxy;
        this.f531i = sSLSocketFactory;
        this.f532j = hostnameVerifier;
        this.f533k = c1414c;
    }

    @Nullable
    /* renamed from: a */
    public C1414c m393a() {
        return this.f533k;
    }

    /* renamed from: b */
    public List<C1417f> m394b() {
        return this.f528f;
    }

    /* renamed from: c */
    public Dns m395c() {
        return this.f524b;
    }

    /* renamed from: d */
    boolean m396d(C1412a c1412a) {
        return this.f524b.equals(c1412a.f524b) && this.f526d.equals(c1412a.f526d) && this.f527e.equals(c1412a.f527e) && this.f528f.equals(c1412a.f528f) && this.f529g.equals(c1412a.f529g) && Objects.equals(this.f530h, c1412a.f530h) && Objects.equals(this.f531i, c1412a.f531i) && Objects.equals(this.f532j, c1412a.f532j) && Objects.equals(this.f533k, c1412a.f533k) && m404l().m820x() == c1412a.m404l().m820x();
    }

    @Nullable
    /* renamed from: e */
    public HostnameVerifier m397e() {
        return this.f532j;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj instanceof C1412a) {
            C1412a c1412a = (C1412a) obj;
            if (this.f523a.equals(c1412a.f523a) && m396d(c1412a)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: f */
    public List<Protocol> m398f() {
        return this.f527e;
    }

    @Nullable
    /* renamed from: g */
    public Proxy m399g() {
        return this.f530h;
    }

    /* renamed from: h */
    public Authenticator m400h() {
        return this.f526d;
    }

    public int hashCode() {
        return ((((((((((((((((((527 + this.f523a.hashCode()) * 31) + this.f524b.hashCode()) * 31) + this.f526d.hashCode()) * 31) + this.f527e.hashCode()) * 31) + this.f528f.hashCode()) * 31) + this.f529g.hashCode()) * 31) + Objects.hashCode(this.f530h)) * 31) + Objects.hashCode(this.f531i)) * 31) + Objects.hashCode(this.f532j)) * 31) + Objects.hashCode(this.f533k);
    }

    /* renamed from: i */
    public ProxySelector m401i() {
        return this.f529g;
    }

    /* renamed from: j */
    public SocketFactory m402j() {
        return this.f525c;
    }

    @Nullable
    /* renamed from: k */
    public SSLSocketFactory m403k() {
        return this.f531i;
    }

    /* renamed from: l */
    public C1472l m404l() {
        return this.f523a;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Address{");
        sb.append(this.f523a.m816m());
        sb.append(":");
        sb.append(this.f523a.m820x());
        if (this.f530h != null) {
            sb.append(", proxy=");
            sb.append(this.f530h);
        } else {
            sb.append(", proxySelector=");
            sb.append(this.f529g);
        }
        sb.append("}");
        return sb.toString();
    }
}
