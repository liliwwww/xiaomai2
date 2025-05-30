package okhttp3.internal.connection;

import java.io.IOException;
import java.net.ProtocolException;
import java.net.SocketException;
import javax.annotation.Nullable;
import okhttp3.AbstractC1477q;
import okhttp3.C1474n;
import okhttp3.C1476p;
import okhttp3.Call;
import okhttp3.EventListener;
import okhttp3.internal.http.ExchangeCodec;
import okhttp3.internal.p011ws.RealWebSocket;
import okio.Buffer;
import okio.Sink;
import okio.Source;
import tb.q92;
import tb.s84;

/* compiled from: Taobao */
/* renamed from: okhttp3.internal.connection.c */
/* loaded from: classes2.dex */
public final class C1427c {

    /* renamed from: a */
    final C1433i f596a;

    /* renamed from: b */
    final Call f597b;

    /* renamed from: c */
    final EventListener f598c;

    /* renamed from: d */
    final C1428d f599d;

    /* renamed from: e */
    final ExchangeCodec f600e;

    /* renamed from: f */
    private boolean f601f;

    /* compiled from: Taobao */
    /* renamed from: okhttp3.internal.connection.c$a */
    /* loaded from: classes.dex */
    private final class a extends okio.c {

        /* renamed from: a */
        private boolean f602a;

        /* renamed from: b */
        private long f603b;

        /* renamed from: c */
        private long f604c;

        /* renamed from: d */
        private boolean f605d;

        a(Sink sink, long j) {
            super(sink);
            this.f603b = j;
        }

        @Nullable
        /* renamed from: a */
        private IOException m523a(@Nullable IOException iOException) {
            if (this.f602a) {
                return iOException;
            }
            this.f602a = true;
            return C1427c.this.m505a(this.f604c, false, true, iOException);
        }

        public void close() throws IOException {
            if (this.f605d) {
                return;
            }
            this.f605d = true;
            long j = this.f603b;
            if (j != -1 && this.f604c != j) {
                throw new ProtocolException("unexpected end of stream");
            }
            try {
                super.close();
                m523a(null);
            } catch (IOException e) {
                throw m523a(e);
            }
        }

        public void flush() throws IOException {
            try {
                super.flush();
            } catch (IOException e) {
                throw m523a(e);
            }
        }

        public void write(Buffer buffer, long j) throws IOException {
            if (this.f605d) {
                throw new IllegalStateException("closed");
            }
            long j2 = this.f603b;
            if (j2 == -1 || this.f604c + j <= j2) {
                try {
                    super.write(buffer, j);
                    this.f604c += j;
                    return;
                } catch (IOException e) {
                    throw m523a(e);
                }
            }
            throw new ProtocolException("expected " + this.f603b + " bytes but received " + (this.f604c + j));
        }
    }

    /* compiled from: Taobao */
    /* renamed from: okhttp3.internal.connection.c$b */
    /* loaded from: classes.dex */
    final class b extends okio.d {

        /* renamed from: a */
        private final long f607a;

        /* renamed from: b */
        private long f608b;

        /* renamed from: c */
        private boolean f609c;

        /* renamed from: d */
        private boolean f610d;

        b(Source source, long j) {
            super(source);
            this.f607a = j;
            if (j == 0) {
                m524a(null);
            }
        }

        @Nullable
        /* renamed from: a */
        IOException m524a(@Nullable IOException iOException) {
            if (this.f609c) {
                return iOException;
            }
            this.f609c = true;
            return C1427c.this.m505a(this.f608b, true, false, iOException);
        }

        public void close() throws IOException {
            if (this.f610d) {
                return;
            }
            this.f610d = true;
            try {
                super.close();
                m524a(null);
            } catch (IOException e) {
                throw m524a(e);
            }
        }

        public long read(Buffer buffer, long j) throws IOException {
            if (this.f610d) {
                throw new IllegalStateException("closed");
            }
            try {
                long read = delegate().read(buffer, j);
                if (read == -1) {
                    m524a(null);
                    return -1L;
                }
                long j2 = this.f608b + read;
                long j3 = this.f607a;
                if (j3 != -1 && j2 > j3) {
                    throw new ProtocolException("expected " + this.f607a + " bytes but received " + j2);
                }
                this.f608b = j2;
                if (j2 == j3) {
                    m524a(null);
                }
                return read;
            } catch (IOException e) {
                throw m524a(e);
            }
        }
    }

    public C1427c(C1433i c1433i, Call call, EventListener eventListener, C1428d c1428d, ExchangeCodec exchangeCodec) {
        this.f596a = c1433i;
        this.f597b = call;
        this.f598c = eventListener;
        this.f599d = c1428d;
        this.f600e = exchangeCodec;
    }

    @Nullable
    /* renamed from: a */
    IOException m505a(long j, boolean z, boolean z2, @Nullable IOException iOException) {
        if (iOException != null) {
            m520p(iOException);
        }
        if (z2) {
            if (iOException != null) {
                this.f598c.m362p(this.f597b, iOException);
            } else {
                this.f598c.m360n(this.f597b, j);
            }
        }
        if (z) {
            if (iOException != null) {
                this.f598c.m367u(this.f597b, iOException);
            } else {
                this.f598c.m365s(this.f597b, j);
            }
        }
        return this.f596a.m582g(this, z2, z, iOException);
    }

    /* renamed from: b */
    public void m506b() {
        this.f600e.cancel();
    }

    /* renamed from: c */
    public C1429e m507c() {
        return this.f600e.connection();
    }

    /* renamed from: d */
    public Sink m508d(C1474n c1474n, boolean z) throws IOException {
        this.f601f = z;
        long mo446a = c1474n.m851a().mo446a();
        this.f598c.m361o(this.f597b);
        return new a(this.f600e.createRequestBody(c1474n, mo446a), mo446a);
    }

    /* renamed from: e */
    public void m509e() {
        this.f600e.cancel();
        this.f596a.m582g(this, true, true, null);
    }

    /* renamed from: f */
    public void m510f() throws IOException {
        try {
            this.f600e.finishRequest();
        } catch (IOException e) {
            this.f598c.m362p(this.f597b, e);
            m520p(e);
            throw e;
        }
    }

    /* renamed from: g */
    public void m511g() throws IOException {
        try {
            this.f600e.flushRequest();
        } catch (IOException e) {
            this.f598c.m362p(this.f597b, e);
            m520p(e);
            throw e;
        }
    }

    /* renamed from: h */
    public boolean m512h() {
        return this.f601f;
    }

    /* renamed from: i */
    public RealWebSocket.AbstractC1467d m513i() throws SocketException {
        this.f596a.m590p();
        return this.f600e.connection().m549o(this);
    }

    /* renamed from: j */
    public void m514j() {
        this.f600e.connection().m550p();
    }

    /* renamed from: k */
    public void m515k() {
        this.f596a.m582g(this, true, false, null);
    }

    /* renamed from: l */
    public AbstractC1477q m516l(C1476p c1476p) throws IOException {
        try {
            this.f598c.m366t(this.f597b);
            String m877g = c1476p.m877g("Content-Type");
            long reportedContentLength = this.f600e.reportedContentLength(c1476p);
            return new s84(m877g, reportedContentLength, okio.h.c(new b(this.f600e.openResponseBodySource(c1476p), reportedContentLength)));
        } catch (IOException e) {
            this.f598c.m367u(this.f597b, e);
            m520p(e);
            throw e;
        }
    }

    @Nullable
    /* renamed from: m */
    public C1476p.a m517m(boolean z) throws IOException {
        try {
            C1476p.a readResponseHeaders = this.f600e.readResponseHeaders(z);
            if (readResponseHeaders != null) {
                q92.a.g(readResponseHeaders, this);
            }
            return readResponseHeaders;
        } catch (IOException e) {
            this.f598c.m367u(this.f597b, e);
            m520p(e);
            throw e;
        }
    }

    /* renamed from: n */
    public void m518n(C1476p c1476p) {
        this.f598c.m368v(this.f597b, c1476p);
    }

    /* renamed from: o */
    public void m519o() {
        this.f598c.m369w(this.f597b);
    }

    /* renamed from: p */
    void m520p(IOException iOException) {
        this.f599d.m532h();
        this.f600e.connection().m552t(iOException);
    }

    /* renamed from: q */
    public void m521q() {
        m505a(-1L, true, true, null);
    }

    /* renamed from: r */
    public void m522r(C1474n c1474n) throws IOException {
        try {
            this.f598c.m364r(this.f597b);
            this.f600e.writeRequestHeaders(c1474n);
            this.f598c.m363q(this.f597b, c1474n);
        } catch (IOException e) {
            this.f598c.m362p(this.f597b, e);
            m520p(e);
            throw e;
        }
    }
}
