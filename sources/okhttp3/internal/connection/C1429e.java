package okhttp3.internal.connection;

import android.taobao.windvane.util.NetWork;
import androidx.core.location.LocationRequestCompat;
import java.io.IOException;
import java.lang.ref.Reference;
import java.net.ConnectException;
import java.net.Proxy;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import okhttp3.C1412a;
import okhttp3.C1414c;
import okhttp3.C1417f;
import okhttp3.C1470j;
import okhttp3.C1472l;
import okhttp3.C1474n;
import okhttp3.C1476p;
import okhttp3.C1478r;
import okhttp3.Call;
import okhttp3.Connection;
import okhttp3.EventListener;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.internal.C1421a;
import okhttp3.internal.http.ExchangeCodec;
import okhttp3.internal.http2.C1456d;
import okhttp3.internal.http2.C1457e;
import okhttp3.internal.http2.ConnectionShutdownException;
import okhttp3.internal.http2.ErrorCode;
import okhttp3.internal.http2.Http2Connection;
import okhttp3.internal.http2.StreamResetException;
import okhttp3.internal.p011ws.RealWebSocket;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.o;
import tb.iv3;
import tb.n43;
import tb.q92;
import tb.rz5;
import tb.z32;

/* compiled from: Taobao */
/* renamed from: okhttp3.internal.connection.e */
/* loaded from: classes2.dex */
public final class C1429e extends Http2Connection.AbstractC1450b implements Connection {

    /* renamed from: a */
    public final C1430f f622a;

    /* renamed from: b */
    private final C1478r f623b;

    /* renamed from: c */
    private Socket f624c;

    /* renamed from: d */
    private Socket f625d;

    /* renamed from: e */
    private C1470j f626e;

    /* renamed from: f */
    private Protocol f627f;

    /* renamed from: g */
    private Http2Connection f628g;

    /* renamed from: h */
    private BufferedSource f629h;

    /* renamed from: i */
    private BufferedSink f630i;

    /* renamed from: j */
    boolean f631j;

    /* renamed from: k */
    int f632k;

    /* renamed from: l */
    int f633l;

    /* renamed from: m */
    private int f634m;

    /* renamed from: n */
    private int f635n = 1;

    /* renamed from: o */
    final List<Reference<C1433i>> f636o = new ArrayList();

    /* renamed from: p */
    long f637p = LocationRequestCompat.PASSIVE_INTERVAL;

    /* compiled from: Taobao */
    /* renamed from: okhttp3.internal.connection.e$a */
    /* loaded from: classes.dex */
    class a extends RealWebSocket.AbstractC1467d {

        /* renamed from: d */
        final /* synthetic */ C1427c f638d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(C1429e c1429e, boolean z, BufferedSource bufferedSource, BufferedSink bufferedSink, C1427c c1427c) {
            super(z, bufferedSource, bufferedSink);
            this.f638d = c1427c;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            this.f638d.m505a(-1L, true, true, null);
        }
    }

    public C1429e(C1430f c1430f, C1478r c1478r) {
        this.f622a = c1430f;
        this.f623b = c1478r;
    }

    /* renamed from: e */
    private void m533e(int i, int i2, Call call, EventListener eventListener) throws IOException {
        Proxy m915b = this.f623b.m915b();
        this.f624c = (m915b.type() == Proxy.Type.DIRECT || m915b.type() == Proxy.Type.HTTP) ? this.f623b.m914a().m402j().createSocket() : new Socket(m915b);
        eventListener.m355g(call, this.f623b.m917d(), m915b);
        this.f624c.setSoTimeout(i2);
        try {
            iv3.j().h(this.f624c, this.f623b.m917d(), i);
            try {
                this.f629h = okio.h.c(okio.h.l(this.f624c));
                this.f630i = okio.h.b(okio.h.h(this.f624c));
            } catch (NullPointerException e) {
                if ("throw with null exception".equals(e.getMessage())) {
                    throw new IOException(e);
                }
            }
        } catch (ConnectException e2) {
            ConnectException connectException = new ConnectException("Failed to connect to " + this.f623b.m917d());
            connectException.initCause(e2);
            throw connectException;
        }
    }

    /* renamed from: f */
    private void m534f(C1426b c1426b) throws IOException {
        C1412a m914a = this.f623b.m914a();
        SSLSocket sSLSocket = null;
        try {
            try {
                SSLSocket sSLSocket2 = (SSLSocket) m914a.m403k().createSocket(this.f624c, m914a.m404l().m816m(), m914a.m404l().m820x(), true);
                try {
                    C1417f m503a = c1426b.m503a(sSLSocket2);
                    if (m503a.m426f()) {
                        iv3.j().g(sSLSocket2, m914a.m404l().m816m(), m914a.m398f());
                    }
                    sSLSocket2.startHandshake();
                    SSLSession session = sSLSocket2.getSession();
                    C1470j m771b = C1470j.m771b(session);
                    if (m914a.m397e().verify(m914a.m404l().m816m(), session)) {
                        m914a.m393a().m410a(m914a.m404l().m816m(), m771b.m774d());
                        String l = m503a.m426f() ? iv3.j().l(sSLSocket2) : null;
                        this.f625d = sSLSocket2;
                        this.f629h = okio.h.c(okio.h.l(sSLSocket2));
                        this.f630i = okio.h.b(okio.h.h(this.f625d));
                        this.f626e = m771b;
                        this.f627f = l != null ? Protocol.get(l) : Protocol.HTTP_1_1;
                        iv3.j().a(sSLSocket2);
                        return;
                    }
                    List<Certificate> m774d = m771b.m774d();
                    if (m774d.isEmpty()) {
                        throw new SSLPeerUnverifiedException("Hostname " + m914a.m404l().m816m() + " not verified (no certificates)");
                    }
                    X509Certificate x509Certificate = (X509Certificate) m774d.get(0);
                    throw new SSLPeerUnverifiedException("Hostname " + m914a.m404l().m816m() + " not verified:\n    certificate: " + C1414c.m407c(x509Certificate) + "\n    DN: " + x509Certificate.getSubjectDN().getName() + "\n    subjectAltNames: " + n43.a(x509Certificate));
                } catch (AssertionError e) {
                    e = e;
                    if (!C1421a.m451A(e)) {
                        throw e;
                    }
                    throw new IOException(e);
                } catch (Throwable th) {
                    th = th;
                    sSLSocket = sSLSocket2;
                    if (sSLSocket != null) {
                        iv3.j().a(sSLSocket);
                    }
                    C1421a.m471h(sSLSocket);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (AssertionError e2) {
            e = e2;
        }
    }

    /* renamed from: g */
    private void m535g(int i, int i2, int i3, Call call, EventListener eventListener) throws IOException {
        C1474n m537i = m537i();
        C1472l m858h = m537i.m858h();
        for (int i4 = 0; i4 < 21; i4++) {
            m533e(i, i2, call, eventListener);
            m537i = m536h(i2, i3, m537i, m858h);
            if (m537i == null) {
                return;
            }
            C1421a.m471h(this.f624c);
            this.f624c = null;
            this.f630i = null;
            this.f629h = null;
            eventListener.m353e(call, this.f623b.m917d(), this.f623b.m915b(), null);
        }
    }

    /* renamed from: h */
    private C1474n m536h(int i, int i2, C1474n c1474n, C1472l c1472l) throws IOException {
        String str = "CONNECT " + C1421a.m482s(c1472l, true) + " HTTP/1.1";
        while (true) {
            z32 z32Var = new z32((OkHttpClient) null, (C1429e) null, this.f629h, this.f630i);
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            this.f629h.timeout().timeout(i, timeUnit);
            this.f630i.timeout().timeout(i2, timeUnit);
            z32Var.t(c1474n.m854d(), str);
            z32Var.finishRequest();
            C1476p m890c = z32Var.readResponseHeaders(false).m902q(c1474n).m890c();
            z32Var.s(m890c);
            int m875e = m890c.m875e();
            if (m875e == 200) {
                if (this.f629h.getBuffer().exhausted() && this.f630i.buffer().exhausted()) {
                    return null;
                }
                throw new IOException("TLS tunnel buffered too many bytes!");
            }
            if (m875e != 407) {
                throw new IOException("Unexpected response code for CONNECT: " + m890c.m875e());
            }
            C1474n authenticate = this.f623b.m914a().m400h().authenticate(this.f623b, m890c);
            if (authenticate == null) {
                throw new IOException("Failed to authenticate with proxy");
            }
            if ("close".equalsIgnoreCase(m890c.m877g("Connection"))) {
                return authenticate;
            }
            c1474n = authenticate;
        }
    }

    /* renamed from: i */
    private C1474n m537i() throws IOException {
        C1474n m859a = new C1474n.a().m867i(this.f623b.m914a().m404l()).m863e("CONNECT", null).m861c("Host", C1421a.m482s(this.f623b.m914a().m404l(), true)).m861c("Proxy-Connection", "Keep-Alive").m861c("User-Agent", rz5.a()).m859a();
        C1474n authenticate = this.f623b.m914a().m400h().authenticate(this.f623b, new C1476p.a().m902q(m859a).m900o(Protocol.HTTP_1_1).m892g(407).m897l("Preemptive Authenticate").m889b(C1421a.EMPTY_RESPONSE).m903r(-1L).m901p(-1L).m894i("Proxy-Authenticate", "OkHttp-Preemptive").m890c());
        return authenticate != null ? authenticate : m859a;
    }

    /* renamed from: j */
    private void m538j(C1426b c1426b, int i, Call call, EventListener eventListener) throws IOException {
        if (this.f623b.m914a().m403k() != null) {
            eventListener.m371y(call);
            m534f(c1426b);
            eventListener.m370x(call, this.f626e);
            if (this.f627f == Protocol.HTTP_2) {
                m540r(i);
                return;
            }
            return;
        }
        List<Protocol> m398f = this.f623b.m914a().m398f();
        Protocol protocol = Protocol.H2_PRIOR_KNOWLEDGE;
        if (!m398f.contains(protocol)) {
            this.f625d = this.f624c;
            this.f627f = Protocol.HTTP_1_1;
        } else {
            this.f625d = this.f624c;
            this.f627f = protocol;
            m540r(i);
        }
    }

    /* renamed from: q */
    private boolean m539q(List<C1478r> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            C1478r c1478r = list.get(i);
            if (c1478r.m915b().type() == Proxy.Type.DIRECT && this.f623b.m915b().type() == Proxy.Type.DIRECT && this.f623b.m917d().equals(c1478r.m917d())) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: r */
    private void m540r(int i) throws IOException {
        this.f625d.setSoTimeout(0);
        Http2Connection m638a = new Http2Connection.C1449a(true).m641d(this.f625d, this.f623b.m914a().m404l().m816m(), this.f629h, this.f630i).m639b(this).m640c(i).m638a();
        this.f628g = m638a;
        m638a.m619D();
    }

    @Override // okhttp3.internal.http2.Http2Connection.AbstractC1450b
    /* renamed from: a */
    public void mo541a(Http2Connection http2Connection) {
        synchronized (this.f622a) {
            this.f635n = http2Connection.m631r();
        }
    }

    @Override // okhttp3.internal.http2.Http2Connection.AbstractC1450b
    /* renamed from: b */
    public void mo542b(C1457e c1457e) throws IOException {
        c1457e.m695d(ErrorCode.REFUSED_STREAM, null);
    }

    /* renamed from: c */
    public void m543c() {
        C1421a.m471h(this.f624c);
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00f4 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x013a  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0142 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0135  */
    /* renamed from: d */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void m544d(int r17, int r18, int r19, int r20, boolean r21, okhttp3.Call r22, okhttp3.EventListener r23) {
        /*
            Method dump skipped, instructions count: 344
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.connection.C1429e.m544d(int, int, int, int, boolean, okhttp3.Call, okhttp3.EventListener):void");
    }

    @Override // okhttp3.Connection
    public C1470j handshake() {
        return this.f626e;
    }

    /* renamed from: k */
    boolean m545k(C1412a c1412a, @Nullable List<C1478r> list) {
        if (this.f636o.size() >= this.f635n || this.f631j || !q92.a.e(this.f623b.m914a(), c1412a)) {
            return false;
        }
        if (c1412a.m404l().m816m().equals(route().m914a().m404l().m816m())) {
            return true;
        }
        if (this.f628g == null || list == null || !m539q(list) || c1412a.m397e() != n43.INSTANCE || !m551s(c1412a.m404l())) {
            return false;
        }
        try {
            c1412a.m393a().m410a(c1412a.m404l().m816m(), handshake().m774d());
            return true;
        } catch (SSLPeerUnverifiedException unused) {
            return false;
        }
    }

    /* renamed from: l */
    public boolean m546l(boolean z) {
        if (this.f625d.isClosed() || this.f625d.isInputShutdown() || this.f625d.isOutputShutdown()) {
            return false;
        }
        Http2Connection http2Connection = this.f628g;
        if (http2Connection != null) {
            return http2Connection.m630q(System.nanoTime());
        }
        if (z) {
            try {
                int soTimeout = this.f625d.getSoTimeout();
                try {
                    this.f625d.setSoTimeout(1);
                    return !this.f629h.exhausted();
                } finally {
                    this.f625d.setSoTimeout(soTimeout);
                }
            } catch (SocketTimeoutException unused) {
            } catch (IOException unused2) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: m */
    public boolean m547m() {
        return this.f628g != null;
    }

    /* renamed from: n */
    ExchangeCodec m548n(OkHttpClient okHttpClient, Interceptor.Chain chain) throws SocketException {
        if (this.f628g != null) {
            return new C1456d(okHttpClient, this, chain, this.f628g);
        }
        this.f625d.setSoTimeout(chain.readTimeoutMillis());
        o timeout = this.f629h.timeout();
        long readTimeoutMillis = chain.readTimeoutMillis();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        timeout.timeout(readTimeoutMillis, timeUnit);
        this.f630i.timeout().timeout(chain.writeTimeoutMillis(), timeUnit);
        return new z32(okHttpClient, this, this.f629h, this.f630i);
    }

    /* renamed from: o */
    RealWebSocket.AbstractC1467d m549o(C1427c c1427c) throws SocketException {
        this.f625d.setSoTimeout(0);
        m550p();
        return new a(this, true, this.f629h, this.f630i, c1427c);
    }

    /* renamed from: p */
    public void m550p() {
        synchronized (this.f622a) {
            this.f631j = true;
        }
    }

    @Override // okhttp3.Connection
    public Protocol protocol() {
        return this.f627f;
    }

    @Override // okhttp3.Connection
    public C1478r route() {
        return this.f623b;
    }

    /* renamed from: s */
    public boolean m551s(C1472l c1472l) {
        if (c1472l.m820x() != this.f623b.m914a().m404l().m820x()) {
            return false;
        }
        if (c1472l.m816m().equals(this.f623b.m914a().m404l().m816m())) {
            return true;
        }
        return this.f626e != null && n43.INSTANCE.c(c1472l.m816m(), (X509Certificate) this.f626e.m774d().get(0));
    }

    @Override // okhttp3.Connection
    public Socket socket() {
        return this.f625d;
    }

    /* renamed from: t */
    void m552t(@Nullable IOException iOException) {
        synchronized (this.f622a) {
            if (iOException instanceof StreamResetException) {
                ErrorCode errorCode = ((StreamResetException) iOException).errorCode;
                if (errorCode == ErrorCode.REFUSED_STREAM) {
                    int i = this.f634m + 1;
                    this.f634m = i;
                    if (i > 1) {
                        this.f631j = true;
                        this.f632k++;
                    }
                } else if (errorCode != ErrorCode.CANCEL) {
                    this.f631j = true;
                    this.f632k++;
                }
            } else if (!m547m() || (iOException instanceof ConnectionShutdownException)) {
                this.f631j = true;
                if (this.f633l == 0) {
                    if (iOException != null) {
                        this.f622a.m557c(this.f623b, iOException);
                    }
                    this.f632k++;
                }
            }
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Connection{");
        sb.append(this.f623b.m914a().m404l().m816m());
        sb.append(":");
        sb.append(this.f623b.m914a().m404l().m820x());
        sb.append(", proxy=");
        sb.append(this.f623b.m915b());
        sb.append(" hostAddress=");
        sb.append(this.f623b.m917d());
        sb.append(" cipherSuite=");
        C1470j c1470j = this.f626e;
        sb.append(c1470j != null ? c1470j.m773a() : NetWork.CONN_TYPE_NONE);
        sb.append(" protocol=");
        sb.append(this.f627f);
        sb.append('}');
        return sb.toString();
    }
}
