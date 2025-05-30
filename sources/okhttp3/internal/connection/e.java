package okhttp3.internal.connection;

import android.taobao.windvane.util.NetWork;
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
import okhttp3.Call;
import okhttp3.Connection;
import okhttp3.EventListener;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.internal.http.ExchangeCodec;
import okhttp3.internal.http2.ConnectionShutdownException;
import okhttp3.internal.http2.ErrorCode;
import okhttp3.internal.http2.Http2Connection;
import okhttp3.internal.http2.Http2Connection$b;
import okhttp3.internal.http2.StreamResetException;
import okhttp3.internal.ws.RealWebSocket$d;
import okhttp3.j;
import okhttp3.l;
import okhttp3.n;
import okhttp3.p;
import okhttp3.r;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.o;
import tb.iv3;
import tb.n43;
import tb.q92;
import tb.rz5;
import tb.z32;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class e extends Http2Connection$b implements Connection {
    public final f a;
    private final r b;
    private Socket c;
    private Socket d;
    private j e;
    private Protocol f;
    private Http2Connection g;
    private BufferedSource h;
    private BufferedSink i;
    boolean j;
    int k;
    int l;
    private int m;
    private int n = 1;
    final List<Reference<i>> o = new ArrayList();
    long p = Long.MAX_VALUE;

    public e(f fVar, r rVar) {
        this.a = fVar;
        this.b = rVar;
    }

    private void e(int i, int i2, Call call, EventListener eventListener) throws IOException {
        Proxy b = this.b.b();
        this.c = (b.type() == Proxy.Type.DIRECT || b.type() == Proxy.Type.HTTP) ? this.b.a().j().createSocket() : new Socket(b);
        eventListener.g(call, this.b.d(), b);
        this.c.setSoTimeout(i2);
        try {
            iv3.j().h(this.c, this.b.d(), i);
            try {
                this.h = okio.h.c(okio.h.l(this.c));
                this.i = okio.h.b(okio.h.h(this.c));
            } catch (NullPointerException e) {
                if ("throw with null exception".equals(e.getMessage())) {
                    throw new IOException(e);
                }
            }
        } catch (ConnectException e2) {
            ConnectException connectException = new ConnectException("Failed to connect to " + this.b.d());
            connectException.initCause(e2);
            throw connectException;
        }
    }

    private void f(b bVar) throws IOException {
        SSLSocket sSLSocket;
        okhttp3.a a = this.b.a();
        SSLSocket sSLSocket2 = null;
        try {
            try {
                sSLSocket = (SSLSocket) a.k().createSocket(this.c, a.l().m(), a.l().x(), true);
            } catch (AssertionError e) {
                e = e;
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            okhttp3.f a2 = bVar.a(sSLSocket);
            if (a2.f()) {
                iv3.j().g(sSLSocket, a.l().m(), a.f());
            }
            sSLSocket.startHandshake();
            SSLSession session = sSLSocket.getSession();
            j b = j.b(session);
            if (a.e().verify(a.l().m(), session)) {
                a.a().a(a.l().m(), b.d());
                String l = a2.f() ? iv3.j().l(sSLSocket) : null;
                this.d = sSLSocket;
                this.h = okio.h.c(okio.h.l(sSLSocket));
                this.i = okio.h.b(okio.h.h(this.d));
                this.e = b;
                this.f = l != null ? Protocol.get(l) : Protocol.HTTP_1_1;
                iv3.j().a(sSLSocket);
                return;
            }
            List<Certificate> d = b.d();
            if (d.isEmpty()) {
                throw new SSLPeerUnverifiedException("Hostname " + a.l().m() + " not verified (no certificates)");
            }
            X509Certificate x509Certificate = (X509Certificate) d.get(0);
            throw new SSLPeerUnverifiedException("Hostname " + a.l().m() + " not verified:\n    certificate: " + okhttp3.c.c(x509Certificate) + "\n    DN: " + x509Certificate.getSubjectDN().getName() + "\n    subjectAltNames: " + n43.a(x509Certificate));
        } catch (AssertionError e2) {
            e = e2;
            if (!okhttp3.internal.a.A(e)) {
                throw e;
            }
            throw new IOException(e);
        } catch (Throwable th2) {
            th = th2;
            sSLSocket2 = sSLSocket;
            if (sSLSocket2 != null) {
                iv3.j().a(sSLSocket2);
            }
            okhttp3.internal.a.h(sSLSocket2);
            throw th;
        }
    }

    private void g(int i, int i2, int i3, Call call, EventListener eventListener) throws IOException {
        n i4 = i();
        l h = i4.h();
        for (int i5 = 0; i5 < 21; i5++) {
            e(i, i2, call, eventListener);
            i4 = h(i2, i3, i4, h);
            if (i4 == null) {
                return;
            }
            okhttp3.internal.a.h(this.c);
            this.c = null;
            this.i = null;
            this.h = null;
            eventListener.e(call, this.b.d(), this.b.b(), null);
        }
    }

    private n h(int i, int i2, n nVar, l lVar) throws IOException {
        String str = "CONNECT " + okhttp3.internal.a.s(lVar, true) + " HTTP/1.1";
        while (true) {
            z32 z32Var = new z32((OkHttpClient) null, (e) null, this.h, this.i);
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            this.h.timeout().timeout(i, timeUnit);
            this.i.timeout().timeout(i2, timeUnit);
            z32Var.t(nVar.d(), str);
            z32Var.finishRequest();
            p c = z32Var.readResponseHeaders(false).q(nVar).c();
            z32Var.s(c);
            int e = c.e();
            if (e == 200) {
                if (this.h.getBuffer().exhausted() && this.i.buffer().exhausted()) {
                    return null;
                }
                throw new IOException("TLS tunnel buffered too many bytes!");
            }
            if (e != 407) {
                throw new IOException("Unexpected response code for CONNECT: " + c.e());
            }
            n authenticate = this.b.a().h().authenticate(this.b, c);
            if (authenticate == null) {
                throw new IOException("Failed to authenticate with proxy");
            }
            if ("close".equalsIgnoreCase(c.g("Connection"))) {
                return authenticate;
            }
            nVar = authenticate;
        }
    }

    private n i() throws IOException {
        n a = new n.a().i(this.b.a().l()).e("CONNECT", null).c("Host", okhttp3.internal.a.s(this.b.a().l(), true)).c("Proxy-Connection", "Keep-Alive").c("User-Agent", rz5.a()).a();
        n authenticate = this.b.a().h().authenticate(this.b, new p.a().q(a).o(Protocol.HTTP_1_1).g(407).l("Preemptive Authenticate").b(okhttp3.internal.a.EMPTY_RESPONSE).r(-1L).p(-1L).i("Proxy-Authenticate", "OkHttp-Preemptive").c());
        return authenticate != null ? authenticate : a;
    }

    private void j(b bVar, int i, Call call, EventListener eventListener) throws IOException {
        if (this.b.a().k() != null) {
            eventListener.y(call);
            f(bVar);
            eventListener.x(call, this.e);
            if (this.f == Protocol.HTTP_2) {
                r(i);
                return;
            }
            return;
        }
        List<Protocol> f = this.b.a().f();
        Protocol protocol = Protocol.H2_PRIOR_KNOWLEDGE;
        if (!f.contains(protocol)) {
            this.d = this.c;
            this.f = Protocol.HTTP_1_1;
        } else {
            this.d = this.c;
            this.f = protocol;
            r(i);
        }
    }

    private boolean q(List<r> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            r rVar = list.get(i);
            if (rVar.b().type() == Proxy.Type.DIRECT && this.b.b().type() == Proxy.Type.DIRECT && this.b.d().equals(rVar.d())) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [okhttp3.internal.http2.Http2Connection$a] */
    private void r(int i) throws IOException {
        this.d.setSoTimeout(0);
        final boolean z = true;
        Http2Connection a = new Object(z) { // from class: okhttp3.internal.http2.Http2Connection$a
            Socket a;
            String b;
            BufferedSource c;
            BufferedSink d;
            Http2Connection$b e = Http2Connection$b.REFUSE_INCOMING_STREAMS;
            PushObserver f = PushObserver.CANCEL;
            boolean g;
            int h;

            {
                this.g = z;
            }

            public Http2Connection a() {
                return new Http2Connection(this);
            }

            public Http2Connection$a b(Http2Connection$b http2Connection$b) {
                this.e = http2Connection$b;
                return this;
            }

            public Http2Connection$a c(int i2) {
                this.h = i2;
                return this;
            }

            public Http2Connection$a d(Socket socket, String str, BufferedSource bufferedSource, BufferedSink bufferedSink) {
                this.a = socket;
                this.b = str;
                this.c = bufferedSource;
                this.d = bufferedSink;
                return this;
            }
        }.d(this.d, this.b.a().l().m(), this.h, this.i).b(this).c(i).a();
        this.g = a;
        a.D();
    }

    @Override // okhttp3.internal.http2.Http2Connection$b
    public void a(Http2Connection http2Connection) {
        synchronized (this.a) {
            this.n = http2Connection.r();
        }
    }

    @Override // okhttp3.internal.http2.Http2Connection$b
    public void b(okhttp3.internal.http2.e eVar) throws IOException {
        eVar.d(ErrorCode.REFUSED_STREAM, (IOException) null);
    }

    public void c() {
        okhttp3.internal.a.h(this.c);
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00f4 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x013a  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0142 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0135  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void d(int r17, int r18, int r19, int r20, boolean r21, okhttp3.Call r22, okhttp3.EventListener r23) {
        /*
            Method dump skipped, instructions count: 344
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.connection.e.d(int, int, int, int, boolean, okhttp3.Call, okhttp3.EventListener):void");
    }

    public j handshake() {
        return this.e;
    }

    boolean k(okhttp3.a aVar, @Nullable List<r> list) {
        if (this.o.size() >= this.n || this.j || !q92.a.e(this.b.a(), aVar)) {
            return false;
        }
        if (aVar.l().m().equals(route().a().l().m())) {
            return true;
        }
        if (this.g == null || list == null || !q(list) || aVar.e() != n43.INSTANCE || !s(aVar.l())) {
            return false;
        }
        try {
            aVar.a().a(aVar.l().m(), handshake().d());
            return true;
        } catch (SSLPeerUnverifiedException unused) {
            return false;
        }
    }

    public boolean l(boolean z) {
        if (this.d.isClosed() || this.d.isInputShutdown() || this.d.isOutputShutdown()) {
            return false;
        }
        Http2Connection http2Connection = this.g;
        if (http2Connection != null) {
            return http2Connection.q(System.nanoTime());
        }
        if (z) {
            try {
                int soTimeout = this.d.getSoTimeout();
                try {
                    this.d.setSoTimeout(1);
                    return !this.h.exhausted();
                } finally {
                    this.d.setSoTimeout(soTimeout);
                }
            } catch (SocketTimeoutException unused) {
            } catch (IOException unused2) {
                return false;
            }
        }
        return true;
    }

    public boolean m() {
        return this.g != null;
    }

    ExchangeCodec n(OkHttpClient okHttpClient, Interceptor.Chain chain) throws SocketException {
        if (this.g != null) {
            return new okhttp3.internal.http2.d(okHttpClient, this, chain, this.g);
        }
        this.d.setSoTimeout(chain.readTimeoutMillis());
        o timeout = this.h.timeout();
        long readTimeoutMillis = chain.readTimeoutMillis();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        timeout.timeout(readTimeoutMillis, timeUnit);
        this.i.timeout().timeout(chain.writeTimeoutMillis(), timeUnit);
        return new z32(okHttpClient, this, this.h, this.i);
    }

    RealWebSocket$d o(c cVar) throws SocketException {
        this.d.setSoTimeout(0);
        p();
        return new a(this, true, this.h, this.i, cVar);
    }

    public void p() {
        synchronized (this.a) {
            this.j = true;
        }
    }

    public Protocol protocol() {
        return this.f;
    }

    public r route() {
        return this.b;
    }

    public boolean s(l lVar) {
        if (lVar.x() != this.b.a().l().x()) {
            return false;
        }
        if (lVar.m().equals(this.b.a().l().m())) {
            return true;
        }
        return this.e != null && n43.INSTANCE.c(lVar.m(), (X509Certificate) this.e.d().get(0));
    }

    public Socket socket() {
        return this.d;
    }

    void t(@Nullable IOException iOException) {
        synchronized (this.a) {
            if (iOException instanceof StreamResetException) {
                ErrorCode errorCode = ((StreamResetException) iOException).errorCode;
                if (errorCode == ErrorCode.REFUSED_STREAM) {
                    int i = this.m + 1;
                    this.m = i;
                    if (i > 1) {
                        this.j = true;
                        this.k++;
                    }
                } else if (errorCode != ErrorCode.CANCEL) {
                    this.j = true;
                    this.k++;
                }
            } else if (!m() || (iOException instanceof ConnectionShutdownException)) {
                this.j = true;
                if (this.l == 0) {
                    if (iOException != null) {
                        this.a.c(this.b, iOException);
                    }
                    this.k++;
                }
            }
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Connection{");
        sb.append(this.b.a().l().m());
        sb.append(":");
        sb.append(this.b.a().l().x());
        sb.append(", proxy=");
        sb.append(this.b.b());
        sb.append(" hostAddress=");
        sb.append(this.b.d());
        sb.append(" cipherSuite=");
        j jVar = this.e;
        sb.append(jVar != null ? jVar.a() : NetWork.CONN_TYPE_NONE);
        sb.append(" protocol=");
        sb.append(this.f);
        sb.append('}');
        return sb.toString();
    }
}
