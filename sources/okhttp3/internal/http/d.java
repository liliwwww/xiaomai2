package okhttp3.internal.http;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.SocketTimeoutException;
import java.security.cert.CertificateException;
import javax.annotation.Nullable;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.internal.connection.RouteException;
import okhttp3.internal.connection.i;
import okhttp3.internal.http2.ConnectionShutdownException;
import okhttp3.l;
import okhttp3.n;
import okhttp3.o;
import okhttp3.p;
import okhttp3.q;
import okhttp3.r;
import tb.h42;
import tb.q92;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class d implements Interceptor {
    private final OkHttpClient a;

    public d(OkHttpClient okHttpClient) {
        this.a = okHttpClient;
    }

    private n a(p pVar, @Nullable r rVar) throws IOException {
        String g;
        l B;
        if (pVar == null) {
            throw new IllegalStateException();
        }
        int e = pVar.e();
        String f = pVar.o().f();
        if (e == 307 || e == 308) {
            if (!f.equals("GET") && !f.equals("HEAD")) {
                return null;
            }
        } else {
            if (e == 401) {
                return this.a.authenticator().authenticate(rVar, pVar);
            }
            if (e == 503) {
                if ((pVar.m() == null || pVar.m().e() != 503) && e(pVar, Integer.MAX_VALUE) == 0) {
                    return pVar.o();
                }
                return null;
            }
            if (e == 407) {
                if ((rVar != null ? rVar.b() : this.a.proxy()).type() == Proxy.Type.HTTP) {
                    return this.a.proxyAuthenticator().authenticate(rVar, pVar);
                }
                throw new ProtocolException("Received HTTP_PROXY_AUTH (407) code while not using proxy");
            }
            if (e == 408) {
                if (!this.a.retryOnConnectionFailure()) {
                    return null;
                }
                o a = pVar.o().a();
                if (a != null && a.g()) {
                    return null;
                }
                if ((pVar.m() == null || pVar.m().e() != 408) && e(pVar, 0) <= 0) {
                    return pVar.o();
                }
                return null;
            }
            switch (e) {
                case 300:
                case 301:
                case 302:
                case 303:
                    break;
                default:
                    return null;
            }
        }
        if (!this.a.followRedirects() || (g = pVar.g("Location")) == null || (B = pVar.o().h().B(g)) == null) {
            return null;
        }
        if (!B.C().equals(pVar.o().h().C()) && !this.a.followSslRedirects()) {
            return null;
        }
        n.a g2 = pVar.o().g();
        if (h42.b(f)) {
            boolean d = h42.d(f);
            if (h42.c(f)) {
                g2.e("GET", null);
            } else {
                g2.e(f, d ? pVar.o().a() : null);
            }
            if (!d) {
                g2.g("Transfer-Encoding");
                g2.g("Content-Length");
                g2.g("Content-Type");
            }
        }
        if (!okhttp3.internal.a.E(pVar.o().h(), B)) {
            g2.g("Authorization");
        }
        return g2.i(B).a();
    }

    private boolean b(IOException iOException, boolean z) {
        if (iOException instanceof ProtocolException) {
            return false;
        }
        return iOException instanceof InterruptedIOException ? (iOException instanceof SocketTimeoutException) && !z : (((iOException instanceof SSLHandshakeException) && (iOException.getCause() instanceof CertificateException)) || (iOException instanceof SSLPeerUnverifiedException)) ? false : true;
    }

    private boolean c(IOException iOException, i iVar, boolean z, n nVar) {
        if (this.a.retryOnConnectionFailure()) {
            return !(z && d(iOException, nVar)) && b(iOException, z) && iVar.c();
        }
        return false;
    }

    private boolean d(IOException iOException, n nVar) {
        o a = nVar.a();
        return (a != null && a.g()) || (iOException instanceof FileNotFoundException);
    }

    private int e(p pVar, int i) {
        String g = pVar.g("Retry-After");
        if (g == null) {
            return i;
        }
        if (g.matches("\\d+")) {
            return Integer.valueOf(g).intValue();
        }
        return Integer.MAX_VALUE;
    }

    @Override // okhttp3.Interceptor
    public p intercept(Interceptor.Chain chain) throws IOException {
        okhttp3.internal.connection.c f;
        n a;
        n request = chain.request();
        c cVar = (c) chain;
        i c = cVar.c();
        p pVar = null;
        int i = 0;
        while (true) {
            c.m(request);
            if (c.i()) {
                throw new IOException("Canceled");
            }
            try {
                try {
                    p b = cVar.b(request, c, null);
                    if (pVar != null) {
                        b = b.l().n(pVar.l().b((q) null).c()).c();
                    }
                    pVar = b;
                    f = q92.a.f(pVar);
                    a = a(pVar, f != null ? f.c().route() : null);
                } catch (IOException e) {
                    if (!c(e, c, !(e instanceof ConnectionShutdownException), request)) {
                        throw e;
                    }
                } catch (RouteException e2) {
                    if (!c(e2.getLastConnectException(), c, false, request)) {
                        throw e2.getFirstConnectException();
                    }
                }
                if (a == null) {
                    if (f != null && f.h()) {
                        c.p();
                    }
                    return pVar;
                }
                o a2 = a.a();
                if (a2 != null && a2.g()) {
                    return pVar;
                }
                okhttp3.internal.a.g(pVar.a());
                if (c.h()) {
                    f.e();
                }
                i++;
                if (i > 20) {
                    throw new ProtocolException("Too many follow-up requests: " + i);
                }
                request = a;
            } finally {
                c.f();
            }
        }
    }
}
