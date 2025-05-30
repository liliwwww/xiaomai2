package okhttp3.internal.connection;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.Socket;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import okhttp3.Call;
import okhttp3.EventListener;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.l;
import okhttp3.n;
import okio.AsyncTimeout;
import okio.o;
import tb.iv3;
import tb.q92;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class i {
    private final OkHttpClient a;
    private final f b;
    private final Call c;
    private final EventListener d;
    private final AsyncTimeout e;

    @Nullable
    private Object f;
    private n g;
    private d h;
    public e i;

    @Nullable
    private c j;
    private boolean k;
    private boolean l;
    private boolean m;
    private boolean n;
    private boolean o;

    public i(OkHttpClient okHttpClient, Call call) {
        a aVar = new a(this);
        this.e = aVar;
        this.a = okHttpClient;
        this.b = q92.a.i(okHttpClient.connectionPool());
        this.c = call;
        this.d = okHttpClient.eventListenerFactory().create(call);
        aVar.timeout(okHttpClient.callTimeoutMillis(), TimeUnit.MILLISECONDS);
    }

    private okhttp3.a e(l lVar) {
        SSLSocketFactory sSLSocketFactory;
        HostnameVerifier hostnameVerifier;
        okhttp3.c cVar;
        if (lVar.n()) {
            SSLSocketFactory sslSocketFactory = this.a.sslSocketFactory();
            hostnameVerifier = this.a.hostnameVerifier();
            sSLSocketFactory = sslSocketFactory;
            cVar = this.a.certificatePinner();
        } else {
            sSLSocketFactory = null;
            hostnameVerifier = null;
            cVar = null;
        }
        return new okhttp3.a(lVar.m(), lVar.x(), this.a.dns(), this.a.socketFactory(), sSLSocketFactory, hostnameVerifier, cVar, this.a.proxyAuthenticator(), this.a.proxy(), this.a.protocols(), this.a.connectionSpecs(), this.a.proxySelector());
    }

    @Nullable
    private IOException j(@Nullable IOException iOException, boolean z) {
        e eVar;
        Socket n;
        boolean z2;
        synchronized (this.b) {
            if (z) {
                if (this.j != null) {
                    throw new IllegalStateException("cannot release connection while it is in use");
                }
            }
            eVar = this.i;
            n = (eVar != null && this.j == null && (z || this.o)) ? n() : null;
            if (this.i != null) {
                eVar = null;
            }
            z2 = this.o && this.j == null;
        }
        okhttp3.internal.a.h(n);
        if (eVar != null) {
            this.d.i(this.c, eVar);
        }
        if (z2) {
            boolean z3 = iOException != null;
            iOException = r(iOException);
            if (z3) {
                this.d.c(this.c, iOException);
            } else {
                this.d.b(this.c);
            }
        }
        return iOException;
    }

    @Nullable
    private IOException r(@Nullable IOException iOException) {
        if (this.n || !this.e.exit()) {
            return iOException;
        }
        InterruptedIOException interruptedIOException = new InterruptedIOException("timeout");
        if (iOException != null) {
            interruptedIOException.initCause(iOException);
        }
        return interruptedIOException;
    }

    void a(e eVar) {
        if (this.i != null) {
            throw new IllegalStateException();
        }
        this.i = eVar;
        eVar.o.add(new b(this, this.f));
    }

    public void b() {
        this.f = iv3.j().m("response.body().close()");
        this.d.d(this.c);
    }

    public boolean c() {
        return this.h.f() && this.h.e();
    }

    public void d() {
        c cVar;
        e a;
        synchronized (this.b) {
            this.m = true;
            cVar = this.j;
            d dVar = this.h;
            a = (dVar == null || dVar.a() == null) ? this.i : this.h.a();
        }
        if (cVar != null) {
            cVar.b();
        } else if (a != null) {
            a.c();
        }
    }

    public void f() {
        synchronized (this.b) {
            if (this.o) {
                throw new IllegalStateException();
            }
            this.j = null;
        }
    }

    @Nullable
    IOException g(c cVar, boolean z, boolean z2, @Nullable IOException iOException) {
        boolean z3;
        synchronized (this.b) {
            c cVar2 = this.j;
            if (cVar != cVar2) {
                return iOException;
            }
            boolean z4 = true;
            if (z) {
                z3 = !this.k;
                this.k = true;
            } else {
                z3 = false;
            }
            if (z2) {
                if (!this.l) {
                    z3 = true;
                }
                this.l = true;
            }
            if (this.k && this.l && z3) {
                cVar2.c().l++;
                this.j = null;
            } else {
                z4 = false;
            }
            return z4 ? j(iOException, false) : iOException;
        }
    }

    public boolean h() {
        boolean z;
        synchronized (this.b) {
            z = this.j != null;
        }
        return z;
    }

    public boolean i() {
        boolean z;
        synchronized (this.b) {
            z = this.m;
        }
        return z;
    }

    c k(Interceptor.Chain chain, boolean z) {
        synchronized (this.b) {
            if (this.o) {
                throw new IllegalStateException("released");
            }
            if (this.j != null) {
                throw new IllegalStateException("cannot make a new request because the previous response is still open: please call response.close()");
            }
        }
        c cVar = new c(this, this.c, this.d, this.h, this.h.b(this.a, chain, z));
        synchronized (this.b) {
            this.j = cVar;
            this.k = false;
            this.l = false;
        }
        return cVar;
    }

    @Nullable
    public IOException l(@Nullable IOException iOException) {
        synchronized (this.b) {
            this.o = true;
        }
        return j(iOException, false);
    }

    public void m(n nVar) {
        n nVar2 = this.g;
        if (nVar2 != null) {
            if (okhttp3.internal.a.E(nVar2.h(), nVar.h()) && this.h.e()) {
                return;
            }
            if (this.j != null) {
                throw new IllegalStateException();
            }
            if (this.h != null) {
                j(null, true);
                this.h = null;
            }
        }
        this.g = nVar;
        this.h = new d(this, this.b, e(nVar.h()), this.c, this.d);
    }

    @Nullable
    Socket n() {
        int i = 0;
        int size = this.i.o.size();
        while (true) {
            if (i >= size) {
                i = -1;
                break;
            }
            if (this.i.o.get(i).get() == this) {
                break;
            }
            i++;
        }
        if (i == -1) {
            throw new IllegalStateException();
        }
        e eVar = this.i;
        eVar.o.remove(i);
        this.i = null;
        if (!eVar.o.isEmpty()) {
            return null;
        }
        eVar.p = System.nanoTime();
        if (this.b.d(eVar)) {
            return eVar.socket();
        }
        return null;
    }

    public o o() {
        return this.e;
    }

    public void p() {
        if (this.n) {
            throw new IllegalStateException();
        }
        this.n = true;
        this.e.exit();
    }

    public void q() {
        this.e.enter();
    }
}
