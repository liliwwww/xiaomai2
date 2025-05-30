package okhttp3.internal.connection;

import java.io.IOException;
import java.net.Socket;
import java.util.List;
import okhttp3.C1412a;
import okhttp3.C1478r;
import okhttp3.Call;
import okhttp3.EventListener;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.internal.C1421a;
import okhttp3.internal.connection.C1432h;
import okhttp3.internal.http.ExchangeCodec;

/* compiled from: Taobao */
/* renamed from: okhttp3.internal.connection.d */
/* loaded from: classes2.dex */
final class C1428d {

    /* renamed from: a */
    private final C1433i f612a;

    /* renamed from: b */
    private final C1412a f613b;

    /* renamed from: c */
    private final C1430f f614c;

    /* renamed from: d */
    private final Call f615d;

    /* renamed from: e */
    private final EventListener f616e;

    /* renamed from: f */
    private C1432h.a f617f;

    /* renamed from: g */
    private final C1432h f618g;

    /* renamed from: h */
    private C1429e f619h;

    /* renamed from: i */
    private boolean f620i;

    /* renamed from: j */
    private C1478r f621j;

    C1428d(C1433i c1433i, C1430f c1430f, C1412a c1412a, Call call, EventListener eventListener) {
        this.f612a = c1433i;
        this.f614c = c1430f;
        this.f613b = c1412a;
        this.f615d = call;
        this.f616e = eventListener;
        this.f618g = new C1432h(c1412a, c1430f.f644e, call, eventListener);
    }

    /* renamed from: c */
    private C1429e m525c(int i, int i2, int i3, int i4, boolean z) throws IOException {
        C1429e c1429e;
        Socket socket;
        Socket m588n;
        C1429e c1429e2;
        C1478r c1478r;
        boolean z2;
        boolean z3;
        List<C1478r> list;
        C1432h.a aVar;
        synchronized (this.f614c) {
            if (this.f612a.m584i()) {
                throw new IOException("Canceled");
            }
            this.f620i = false;
            C1433i c1433i = this.f612a;
            c1429e = c1433i.f665i;
            socket = null;
            m588n = (c1429e == null || !c1429e.f631j) ? null : c1433i.m588n();
            C1433i c1433i2 = this.f612a;
            c1429e2 = c1433i2.f665i;
            if (c1429e2 != null) {
                c1429e = null;
            } else {
                c1429e2 = null;
            }
            if (c1429e2 == null) {
                if (this.f614c.m560h(this.f613b, c1433i2, null, false)) {
                    c1429e2 = this.f612a.f665i;
                    c1478r = null;
                    z2 = true;
                } else {
                    c1478r = this.f621j;
                    if (c1478r != null) {
                        this.f621j = null;
                    } else if (m527g()) {
                        c1478r = this.f612a.f665i.route();
                    }
                    z2 = false;
                }
            }
            c1478r = null;
            z2 = false;
        }
        C1421a.m471h(m588n);
        if (c1429e != null) {
            this.f616e.m357i(this.f615d, c1429e);
        }
        if (z2) {
            this.f616e.m356h(this.f615d, c1429e2);
        }
        if (c1429e2 != null) {
            return c1429e2;
        }
        if (c1478r != null || ((aVar = this.f617f) != null && aVar.m572b())) {
            z3 = false;
        } else {
            this.f617f = this.f618g.m570d();
            z3 = true;
        }
        synchronized (this.f614c) {
            if (this.f612a.m584i()) {
                throw new IOException("Canceled");
            }
            if (z3) {
                list = this.f617f.m571a();
                if (this.f614c.m560h(this.f613b, this.f612a, list, false)) {
                    c1429e2 = this.f612a.f665i;
                    z2 = true;
                }
            } else {
                list = null;
            }
            if (!z2) {
                if (c1478r == null) {
                    c1478r = this.f617f.m573c();
                }
                c1429e2 = new C1429e(this.f614c, c1478r);
                this.f619h = c1429e2;
            }
        }
        if (z2) {
            this.f616e.m356h(this.f615d, c1429e2);
            return c1429e2;
        }
        c1429e2.m544d(i, i2, i3, i4, z, this.f615d, this.f616e);
        this.f614c.f644e.m561a(c1429e2.route());
        synchronized (this.f614c) {
            this.f619h = null;
            if (this.f614c.m560h(this.f613b, this.f612a, list, true)) {
                c1429e2.f631j = true;
                socket = c1429e2.socket();
                c1429e2 = this.f612a.f665i;
                this.f621j = c1478r;
            } else {
                this.f614c.m559g(c1429e2);
                this.f612a.m577a(c1429e2);
            }
        }
        C1421a.m471h(socket);
        this.f616e.m356h(this.f615d, c1429e2);
        return c1429e2;
    }

    /* renamed from: d */
    private C1429e m526d(int i, int i2, int i3, int i4, boolean z, boolean z2) throws IOException {
        while (true) {
            C1429e m525c = m525c(i, i2, i3, i4, z);
            synchronized (this.f614c) {
                if (m525c.f633l == 0 && !m525c.m547m()) {
                    return m525c;
                }
                if (m525c.m546l(z2)) {
                    return m525c;
                }
                m525c.m550p();
            }
        }
    }

    /* renamed from: g */
    private boolean m527g() {
        C1429e c1429e = this.f612a.f665i;
        return c1429e != null && c1429e.f632k == 0 && C1421a.m455E(c1429e.route().m914a().m404l(), this.f613b.m404l());
    }

    /* renamed from: a */
    C1429e m528a() {
        return this.f619h;
    }

    /* renamed from: b */
    public ExchangeCodec m529b(OkHttpClient okHttpClient, Interceptor.Chain chain, boolean z) {
        try {
            return m526d(chain.connectTimeoutMillis(), chain.readTimeoutMillis(), chain.writeTimeoutMillis(), okHttpClient.pingIntervalMillis(), okHttpClient.retryOnConnectionFailure(), z).m548n(okHttpClient, chain);
        } catch (IOException e) {
            m532h();
            throw new RouteException(e);
        } catch (RouteException e2) {
            m532h();
            throw e2;
        }
    }

    /* renamed from: e */
    boolean m530e() {
        synchronized (this.f614c) {
            boolean z = true;
            if (this.f621j != null) {
                return true;
            }
            if (m527g()) {
                this.f621j = this.f612a.f665i.route();
                return true;
            }
            C1432h.a aVar = this.f617f;
            if ((aVar == null || !aVar.m572b()) && !this.f618g.m569b()) {
                z = false;
            }
            return z;
        }
    }

    /* renamed from: f */
    boolean m531f() {
        boolean z;
        synchronized (this.f614c) {
            z = this.f620i;
        }
        return z;
    }

    /* renamed from: h */
    void m532h() {
        synchronized (this.f614c) {
            this.f620i = true;
        }
    }
}
