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
import okhttp3.AbstractC1475o;
import okhttp3.C1472l;
import okhttp3.C1474n;
import okhttp3.C1476p;
import okhttp3.C1478r;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.internal.C1421a;
import okhttp3.internal.connection.C1427c;
import okhttp3.internal.connection.C1433i;
import okhttp3.internal.connection.RouteException;
import okhttp3.internal.http2.ConnectionShutdownException;
import tb.h42;
import tb.q92;

/* compiled from: Taobao */
/* renamed from: okhttp3.internal.http.d */
/* loaded from: classes2.dex */
public final class C1437d implements Interceptor {

    /* renamed from: a */
    private final OkHttpClient f686a;

    public C1437d(OkHttpClient okHttpClient) {
        this.f686a = okHttpClient;
    }

    /* renamed from: a */
    private C1474n m596a(C1476p c1476p, @Nullable C1478r c1478r) throws IOException {
        String m877g;
        C1472l m807B;
        if (c1476p == null) {
            throw new IllegalStateException();
        }
        int m875e = c1476p.m875e();
        String m856f = c1476p.m884o().m856f();
        if (m875e == 307 || m875e == 308) {
            if (!m856f.equals("GET") && !m856f.equals("HEAD")) {
                return null;
            }
        } else {
            if (m875e == 401) {
                return this.f686a.authenticator().authenticate(c1478r, c1476p);
            }
            if (m875e == 503) {
                if ((c1476p.m882m() == null || c1476p.m882m().m875e() != 503) && m600e(c1476p, Integer.MAX_VALUE) == 0) {
                    return c1476p.m884o();
                }
                return null;
            }
            if (m875e == 407) {
                if ((c1478r != null ? c1478r.m915b() : this.f686a.proxy()).type() == Proxy.Type.HTTP) {
                    return this.f686a.proxyAuthenticator().authenticate(c1478r, c1476p);
                }
                throw new ProtocolException("Received HTTP_PROXY_AUTH (407) code while not using proxy");
            }
            if (m875e == 408) {
                if (!this.f686a.retryOnConnectionFailure()) {
                    return null;
                }
                AbstractC1475o m851a = c1476p.m884o().m851a();
                if (m851a != null && m851a.m872g()) {
                    return null;
                }
                if ((c1476p.m882m() == null || c1476p.m882m().m875e() != 408) && m600e(c1476p, 0) <= 0) {
                    return c1476p.m884o();
                }
                return null;
            }
            switch (m875e) {
                case 300:
                case 301:
                case 302:
                case 303:
                    break;
                default:
                    return null;
            }
        }
        if (!this.f686a.followRedirects() || (m877g = c1476p.m877g("Location")) == null || (m807B = c1476p.m884o().m858h().m807B(m877g)) == null) {
            return null;
        }
        if (!m807B.m808C().equals(c1476p.m884o().m858h().m808C()) && !this.f686a.followSslRedirects()) {
            return null;
        }
        C1474n.a m857g = c1476p.m884o().m857g();
        if (h42.b(m856f)) {
            boolean d = h42.d(m856f);
            if (h42.c(m856f)) {
                m857g.m863e("GET", null);
            } else {
                m857g.m863e(m856f, d ? c1476p.m884o().m851a() : null);
            }
            if (!d) {
                m857g.m865g("Transfer-Encoding");
                m857g.m865g("Content-Length");
                m857g.m865g("Content-Type");
            }
        }
        if (!C1421a.m455E(c1476p.m884o().m858h(), m807B)) {
            m857g.m865g("Authorization");
        }
        return m857g.m867i(m807B).m859a();
    }

    /* renamed from: b */
    private boolean m597b(IOException iOException, boolean z) {
        if (iOException instanceof ProtocolException) {
            return false;
        }
        return iOException instanceof InterruptedIOException ? (iOException instanceof SocketTimeoutException) && !z : (((iOException instanceof SSLHandshakeException) && (iOException.getCause() instanceof CertificateException)) || (iOException instanceof SSLPeerUnverifiedException)) ? false : true;
    }

    /* renamed from: c */
    private boolean m598c(IOException iOException, C1433i c1433i, boolean z, C1474n c1474n) {
        if (this.f686a.retryOnConnectionFailure()) {
            return !(z && m599d(iOException, c1474n)) && m597b(iOException, z) && c1433i.m579c();
        }
        return false;
    }

    /* renamed from: d */
    private boolean m599d(IOException iOException, C1474n c1474n) {
        AbstractC1475o m851a = c1474n.m851a();
        return (m851a != null && m851a.m872g()) || (iOException instanceof FileNotFoundException);
    }

    /* renamed from: e */
    private int m600e(C1476p c1476p, int i) {
        String m877g = c1476p.m877g("Retry-After");
        if (m877g == null) {
            return i;
        }
        if (m877g.matches("\\d+")) {
            return Integer.valueOf(m877g).intValue();
        }
        return Integer.MAX_VALUE;
    }

    @Override // okhttp3.Interceptor
    public C1476p intercept(Interceptor.Chain chain) throws IOException {
        C1427c f;
        C1474n m596a;
        C1474n request = chain.request();
        C1436c c1436c = (C1436c) chain;
        C1433i m595c = c1436c.m595c();
        C1476p c1476p = null;
        int i = 0;
        while (true) {
            m595c.m587m(request);
            if (m595c.m584i()) {
                throw new IOException("Canceled");
            }
            try {
                try {
                    C1476p m594b = c1436c.m594b(request, m595c, null);
                    if (c1476p != null) {
                        m594b = m594b.m881l().m899n(c1476p.m881l().m889b(null).m890c()).m890c();
                    }
                    c1476p = m594b;
                    f = q92.a.f(c1476p);
                    m596a = m596a(c1476p, f != null ? f.m507c().route() : null);
                } catch (IOException e) {
                    if (!m598c(e, m595c, !(e instanceof ConnectionShutdownException), request)) {
                        throw e;
                    }
                } catch (RouteException e2) {
                    if (!m598c(e2.getLastConnectException(), m595c, false, request)) {
                        throw e2.getFirstConnectException();
                    }
                }
                if (m596a == null) {
                    if (f != null && f.m512h()) {
                        m595c.m590p();
                    }
                    return c1476p;
                }
                AbstractC1475o m851a = m596a.m851a();
                if (m851a != null && m851a.m872g()) {
                    return c1476p;
                }
                C1421a.m470g(c1476p.m873a());
                if (m595c.m583h()) {
                    f.m509e();
                }
                i++;
                if (i > 20) {
                    throw new ProtocolException("Too many follow-up requests: " + i);
                }
                request = m596a;
            } finally {
                m595c.m581f();
            }
        }
    }
}
