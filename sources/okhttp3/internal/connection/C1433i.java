package okhttp3.internal.connection;

import android.taobao.windvane.extra.p002uc.preRender.BasePreInitManager;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.lang.ref.WeakReference;
import java.net.Socket;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import okhttp3.C1412a;
import okhttp3.C1414c;
import okhttp3.C1472l;
import okhttp3.C1474n;
import okhttp3.Call;
import okhttp3.EventListener;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.internal.C1421a;
import okio.AsyncTimeout;
import okio.o;
import tb.iv3;
import tb.q92;

/* compiled from: Taobao */
/* renamed from: okhttp3.internal.connection.i */
/* loaded from: classes2.dex */
public final class C1433i {

    /* renamed from: a */
    private final OkHttpClient f657a;

    /* renamed from: b */
    private final C1430f f658b;

    /* renamed from: c */
    private final Call f659c;

    /* renamed from: d */
    private final EventListener f660d;

    /* renamed from: e */
    private final AsyncTimeout f661e;

    /* renamed from: f */
    @Nullable
    private Object f662f;

    /* renamed from: g */
    private C1474n f663g;

    /* renamed from: h */
    private C1428d f664h;

    /* renamed from: i */
    public C1429e f665i;

    /* renamed from: j */
    @Nullable
    private C1427c f666j;

    /* renamed from: k */
    private boolean f667k;

    /* renamed from: l */
    private boolean f668l;

    /* renamed from: m */
    private boolean f669m;

    /* renamed from: n */
    private boolean f670n;

    /* renamed from: o */
    private boolean f671o;

    /* compiled from: Taobao */
    /* renamed from: okhttp3.internal.connection.i$a */
    /* loaded from: classes.dex */
    class a extends AsyncTimeout {
        a() {
        }

        protected void timedOut() {
            C1433i.this.m580d();
        }
    }

    /* compiled from: Taobao */
    /* renamed from: okhttp3.internal.connection.i$b */
    /* loaded from: classes.dex */
    static final class b extends WeakReference<C1433i> {

        /* renamed from: a */
        final Object f673a;

        b(C1433i c1433i, Object obj) {
            super(c1433i);
            this.f673a = obj;
        }
    }

    public C1433i(OkHttpClient okHttpClient, Call call) {
        a aVar = new a();
        this.f661e = aVar;
        this.f657a = okHttpClient;
        this.f658b = q92.a.i(okHttpClient.connectionPool());
        this.f659c = call;
        this.f660d = okHttpClient.eventListenerFactory().create(call);
        aVar.timeout(okHttpClient.callTimeoutMillis(), TimeUnit.MILLISECONDS);
    }

    /* renamed from: e */
    private C1412a m574e(C1472l c1472l) {
        SSLSocketFactory sSLSocketFactory;
        HostnameVerifier hostnameVerifier;
        C1414c c1414c;
        if (c1472l.m817n()) {
            SSLSocketFactory sslSocketFactory = this.f657a.sslSocketFactory();
            hostnameVerifier = this.f657a.hostnameVerifier();
            sSLSocketFactory = sslSocketFactory;
            c1414c = this.f657a.certificatePinner();
        } else {
            sSLSocketFactory = null;
            hostnameVerifier = null;
            c1414c = null;
        }
        return new C1412a(c1472l.m816m(), c1472l.m820x(), this.f657a.dns(), this.f657a.socketFactory(), sSLSocketFactory, hostnameVerifier, c1414c, this.f657a.proxyAuthenticator(), this.f657a.proxy(), this.f657a.protocols(), this.f657a.connectionSpecs(), this.f657a.proxySelector());
    }

    @Nullable
    /* renamed from: j */
    private IOException m575j(@Nullable IOException iOException, boolean z) {
        C1429e c1429e;
        Socket m588n;
        boolean z2;
        synchronized (this.f658b) {
            if (z) {
                if (this.f666j != null) {
                    throw new IllegalStateException("cannot release connection while it is in use");
                }
            }
            c1429e = this.f665i;
            m588n = (c1429e != null && this.f666j == null && (z || this.f671o)) ? m588n() : null;
            if (this.f665i != null) {
                c1429e = null;
            }
            z2 = this.f671o && this.f666j == null;
        }
        C1421a.m471h(m588n);
        if (c1429e != null) {
            this.f660d.m357i(this.f659c, c1429e);
        }
        if (z2) {
            boolean z3 = iOException != null;
            iOException = m576r(iOException);
            if (z3) {
                this.f660d.m351c(this.f659c, iOException);
            } else {
                this.f660d.m350b(this.f659c);
            }
        }
        return iOException;
    }

    @Nullable
    /* renamed from: r */
    private IOException m576r(@Nullable IOException iOException) {
        if (this.f670n || !this.f661e.exit()) {
            return iOException;
        }
        InterruptedIOException interruptedIOException = new InterruptedIOException(BasePreInitManager.TIMEOUT);
        if (iOException != null) {
            interruptedIOException.initCause(iOException);
        }
        return interruptedIOException;
    }

    /* renamed from: a */
    void m577a(C1429e c1429e) {
        if (this.f665i != null) {
            throw new IllegalStateException();
        }
        this.f665i = c1429e;
        c1429e.f636o.add(new b(this, this.f662f));
    }

    /* renamed from: b */
    public void m578b() {
        this.f662f = iv3.j().m("response.body().close()");
        this.f660d.m352d(this.f659c);
    }

    /* renamed from: c */
    public boolean m579c() {
        return this.f664h.m531f() && this.f664h.m530e();
    }

    /* renamed from: d */
    public void m580d() {
        C1427c c1427c;
        C1429e m528a;
        synchronized (this.f658b) {
            this.f669m = true;
            c1427c = this.f666j;
            C1428d c1428d = this.f664h;
            m528a = (c1428d == null || c1428d.m528a() == null) ? this.f665i : this.f664h.m528a();
        }
        if (c1427c != null) {
            c1427c.m506b();
        } else if (m528a != null) {
            m528a.m543c();
        }
    }

    /* renamed from: f */
    public void m581f() {
        synchronized (this.f658b) {
            if (this.f671o) {
                throw new IllegalStateException();
            }
            this.f666j = null;
        }
    }

    @Nullable
    /* renamed from: g */
    IOException m582g(C1427c c1427c, boolean z, boolean z2, @Nullable IOException iOException) {
        boolean z3;
        synchronized (this.f658b) {
            C1427c c1427c2 = this.f666j;
            if (c1427c != c1427c2) {
                return iOException;
            }
            boolean z4 = true;
            if (z) {
                z3 = !this.f667k;
                this.f667k = true;
            } else {
                z3 = false;
            }
            if (z2) {
                if (!this.f668l) {
                    z3 = true;
                }
                this.f668l = true;
            }
            if (this.f667k && this.f668l && z3) {
                c1427c2.m507c().f633l++;
                this.f666j = null;
            } else {
                z4 = false;
            }
            return z4 ? m575j(iOException, false) : iOException;
        }
    }

    /* renamed from: h */
    public boolean m583h() {
        boolean z;
        synchronized (this.f658b) {
            z = this.f666j != null;
        }
        return z;
    }

    /* renamed from: i */
    public boolean m584i() {
        boolean z;
        synchronized (this.f658b) {
            z = this.f669m;
        }
        return z;
    }

    /* renamed from: k */
    C1427c m585k(Interceptor.Chain chain, boolean z) {
        synchronized (this.f658b) {
            if (this.f671o) {
                throw new IllegalStateException("released");
            }
            if (this.f666j != null) {
                throw new IllegalStateException("cannot make a new request because the previous response is still open: please call response.close()");
            }
        }
        C1427c c1427c = new C1427c(this, this.f659c, this.f660d, this.f664h, this.f664h.m529b(this.f657a, chain, z));
        synchronized (this.f658b) {
            this.f666j = c1427c;
            this.f667k = false;
            this.f668l = false;
        }
        return c1427c;
    }

    @Nullable
    /* renamed from: l */
    public IOException m586l(@Nullable IOException iOException) {
        synchronized (this.f658b) {
            this.f671o = true;
        }
        return m575j(iOException, false);
    }

    /* renamed from: m */
    public void m587m(C1474n c1474n) {
        C1474n c1474n2 = this.f663g;
        if (c1474n2 != null) {
            if (C1421a.m455E(c1474n2.m858h(), c1474n.m858h()) && this.f664h.m530e()) {
                return;
            }
            if (this.f666j != null) {
                throw new IllegalStateException();
            }
            if (this.f664h != null) {
                m575j(null, true);
                this.f664h = null;
            }
        }
        this.f663g = c1474n;
        this.f664h = new C1428d(this, this.f658b, m574e(c1474n.m858h()), this.f659c, this.f660d);
    }

    @Nullable
    /* renamed from: n */
    Socket m588n() {
        int i = 0;
        int size = this.f665i.f636o.size();
        while (true) {
            if (i >= size) {
                i = -1;
                break;
            }
            if (this.f665i.f636o.get(i).get() == this) {
                break;
            }
            i++;
        }
        if (i == -1) {
            throw new IllegalStateException();
        }
        C1429e c1429e = this.f665i;
        c1429e.f636o.remove(i);
        this.f665i = null;
        if (!c1429e.f636o.isEmpty()) {
            return null;
        }
        c1429e.f637p = System.nanoTime();
        if (this.f658b.m558d(c1429e)) {
            return c1429e.socket();
        }
        return null;
    }

    /* renamed from: o */
    public o m589o() {
        return this.f661e;
    }

    /* renamed from: p */
    public void m590p() {
        if (this.f670n) {
            throw new IllegalStateException();
        }
        this.f670n = true;
        this.f661e.exit();
    }

    /* renamed from: q */
    public void m591q() {
        this.f661e.enter();
    }
}
