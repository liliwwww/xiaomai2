package okhttp3.internal.connection;

import java.io.IOException;
import java.net.SocketException;
import javax.annotation.Nullable;
import okhttp3.Call;
import okhttp3.EventListener;
import okhttp3.internal.http.ExchangeCodec;
import okhttp3.internal.ws.RealWebSocket$d;
import okhttp3.n;
import okhttp3.p;
import okhttp3.q;
import okio.Sink;
import tb.q92;
import tb.s84;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class c {
    final i a;
    final Call b;
    final EventListener c;
    final d d;
    final ExchangeCodec e;
    private boolean f;

    public c(i iVar, Call call, EventListener eventListener, d dVar, ExchangeCodec exchangeCodec) {
        this.a = iVar;
        this.b = call;
        this.c = eventListener;
        this.d = dVar;
        this.e = exchangeCodec;
    }

    @Nullable
    IOException a(long j, boolean z, boolean z2, @Nullable IOException iOException) {
        if (iOException != null) {
            p(iOException);
        }
        if (z2) {
            if (iOException != null) {
                this.c.p(this.b, iOException);
            } else {
                this.c.n(this.b, j);
            }
        }
        if (z) {
            if (iOException != null) {
                this.c.u(this.b, iOException);
            } else {
                this.c.s(this.b, j);
            }
        }
        return this.a.g(this, z2, z, iOException);
    }

    public void b() {
        this.e.cancel();
    }

    public e c() {
        return this.e.connection();
    }

    public Sink d(n nVar, boolean z) throws IOException {
        this.f = z;
        long a = nVar.a().a();
        this.c.o(this.b);
        return new a(this, this.e.createRequestBody(nVar, a), a);
    }

    public void e() {
        this.e.cancel();
        this.a.g(this, true, true, null);
    }

    public void f() throws IOException {
        try {
            this.e.finishRequest();
        } catch (IOException e) {
            this.c.p(this.b, e);
            p(e);
            throw e;
        }
    }

    public void g() throws IOException {
        try {
            this.e.flushRequest();
        } catch (IOException e) {
            this.c.p(this.b, e);
            p(e);
            throw e;
        }
    }

    public boolean h() {
        return this.f;
    }

    public RealWebSocket$d i() throws SocketException {
        this.a.p();
        return this.e.connection().o(this);
    }

    public void j() {
        this.e.connection().p();
    }

    public void k() {
        this.a.g(this, true, false, null);
    }

    public q l(p pVar) throws IOException {
        try {
            this.c.t(this.b);
            String g = pVar.g("Content-Type");
            long reportedContentLength = this.e.reportedContentLength(pVar);
            return new s84(g, reportedContentLength, okio.h.c(new b(this, this.e.openResponseBodySource(pVar), reportedContentLength)));
        } catch (IOException e) {
            this.c.u(this.b, e);
            p(e);
            throw e;
        }
    }

    @Nullable
    public p.a m(boolean z) throws IOException {
        try {
            p.a readResponseHeaders = this.e.readResponseHeaders(z);
            if (readResponseHeaders != null) {
                q92.a.g(readResponseHeaders, this);
            }
            return readResponseHeaders;
        } catch (IOException e) {
            this.c.u(this.b, e);
            p(e);
            throw e;
        }
    }

    public void n(p pVar) {
        this.c.v(this.b, pVar);
    }

    public void o() {
        this.c.w(this.b);
    }

    void p(IOException iOException) {
        this.d.h();
        this.e.connection().t(iOException);
    }

    public void q() {
        a(-1L, true, true, null);
    }

    public void r(n nVar) throws IOException {
        try {
            this.c.r(this.b);
            this.e.writeRequestHeaders(nVar);
            this.c.q(this.b, nVar);
        } catch (IOException e) {
            this.c.p(this.b, e);
            p(e);
            throw e;
        }
    }
}
