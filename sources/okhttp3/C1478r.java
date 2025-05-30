package okhttp3;

import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.Objects;
import javax.annotation.Nullable;

/* compiled from: Taobao */
/* renamed from: okhttp3.r */
/* loaded from: classes2.dex */
public final class C1478r {

    /* renamed from: a */
    final C1412a f955a;

    /* renamed from: b */
    final Proxy f956b;

    /* renamed from: c */
    final InetSocketAddress f957c;

    public C1478r(C1412a c1412a, Proxy proxy, InetSocketAddress inetSocketAddress) {
        Objects.requireNonNull(c1412a, "address == null");
        Objects.requireNonNull(proxy, "proxy == null");
        Objects.requireNonNull(inetSocketAddress, "inetSocketAddress == null");
        this.f955a = c1412a;
        this.f956b = proxy;
        this.f957c = inetSocketAddress;
    }

    /* renamed from: a */
    public C1412a m914a() {
        return this.f955a;
    }

    /* renamed from: b */
    public Proxy m915b() {
        return this.f956b;
    }

    /* renamed from: c */
    public boolean m916c() {
        return this.f955a.f531i != null && this.f956b.type() == Proxy.Type.HTTP;
    }

    /* renamed from: d */
    public InetSocketAddress m917d() {
        return this.f957c;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj instanceof C1478r) {
            C1478r c1478r = (C1478r) obj;
            if (c1478r.f955a.equals(this.f955a) && c1478r.f956b.equals(this.f956b) && c1478r.f957c.equals(this.f957c)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((((527 + this.f955a.hashCode()) * 31) + this.f956b.hashCode()) * 31) + this.f957c.hashCode();
    }

    public String toString() {
        return "Route{" + this.f957c + "}";
    }
}
