package okhttp3;

import java.net.Proxy;
import java.net.ProxySelector;
import java.util.List;
import java.util.Objects;
import javax.annotation.Nullable;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import okhttp3.l;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class a {
    final l a;
    final Dns b;
    final SocketFactory c;
    final Authenticator d;
    final List<Protocol> e;
    final List<f> f;
    final ProxySelector g;

    @Nullable
    final Proxy h;

    @Nullable
    final SSLSocketFactory i;

    @Nullable
    final HostnameVerifier j;

    @Nullable
    final c k;

    public a(String str, int i, Dns dns, SocketFactory socketFactory, @Nullable SSLSocketFactory sSLSocketFactory, @Nullable HostnameVerifier hostnameVerifier, @Nullable c cVar, Authenticator authenticator, @Nullable Proxy proxy, List<Protocol> list, List<f> list2, ProxySelector proxySelector) {
        this.a = new l.a().q(sSLSocketFactory != null ? "https" : "http").e(str).l(i).a();
        Objects.requireNonNull(dns, "dns == null");
        this.b = dns;
        Objects.requireNonNull(socketFactory, "socketFactory == null");
        this.c = socketFactory;
        Objects.requireNonNull(authenticator, "proxyAuthenticator == null");
        this.d = authenticator;
        Objects.requireNonNull(list, "protocols == null");
        this.e = okhttp3.internal.a.t(list);
        Objects.requireNonNull(list2, "connectionSpecs == null");
        this.f = okhttp3.internal.a.t(list2);
        Objects.requireNonNull(proxySelector, "proxySelector == null");
        this.g = proxySelector;
        this.h = proxy;
        this.i = sSLSocketFactory;
        this.j = hostnameVerifier;
        this.k = cVar;
    }

    @Nullable
    public c a() {
        return this.k;
    }

    public List<f> b() {
        return this.f;
    }

    public Dns c() {
        return this.b;
    }

    boolean d(a aVar) {
        return this.b.equals(aVar.b) && this.d.equals(aVar.d) && this.e.equals(aVar.e) && this.f.equals(aVar.f) && this.g.equals(aVar.g) && Objects.equals(this.h, aVar.h) && Objects.equals(this.i, aVar.i) && Objects.equals(this.j, aVar.j) && Objects.equals(this.k, aVar.k) && l().x() == aVar.l().x();
    }

    @Nullable
    public HostnameVerifier e() {
        return this.j;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj instanceof a) {
            a aVar = (a) obj;
            if (this.a.equals(aVar.a) && d(aVar)) {
                return true;
            }
        }
        return false;
    }

    public List<Protocol> f() {
        return this.e;
    }

    @Nullable
    public Proxy g() {
        return this.h;
    }

    public Authenticator h() {
        return this.d;
    }

    public int hashCode() {
        return ((((((((((((((((((527 + this.a.hashCode()) * 31) + this.b.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31) + this.f.hashCode()) * 31) + this.g.hashCode()) * 31) + Objects.hashCode(this.h)) * 31) + Objects.hashCode(this.i)) * 31) + Objects.hashCode(this.j)) * 31) + Objects.hashCode(this.k);
    }

    public ProxySelector i() {
        return this.g;
    }

    public SocketFactory j() {
        return this.c;
    }

    @Nullable
    public SSLSocketFactory k() {
        return this.i;
    }

    public l l() {
        return this.a;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Address{");
        sb.append(this.a.m());
        sb.append(":");
        sb.append(this.a.x());
        if (this.h != null) {
            sb.append(", proxy=");
            sb.append(this.h);
        } else {
            sb.append(", proxySelector=");
            sb.append(this.g);
        }
        sb.append("}");
        return sb.toString();
    }
}
