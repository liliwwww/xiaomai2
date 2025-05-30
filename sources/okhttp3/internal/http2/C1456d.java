package okhttp3.internal.http2;

import java.io.IOException;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import okhttp3.C1471k;
import okhttp3.C1474n;
import okhttp3.C1476p;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.internal.C1421a;
import okhttp3.internal.connection.C1429e;
import okhttp3.internal.http.C1438e;
import okhttp3.internal.http.ExchangeCodec;
import okio.Sink;
import okio.Source;
import okio.o;
import tb.e42;
import tb.lb4;
import tb.q92;

/* compiled from: Taobao */
/* renamed from: okhttp3.internal.http2.d */
/* loaded from: classes.dex */
public final class C1456d implements ExchangeCodec {

    /* renamed from: g */
    private static final List<String> f760g = C1421a.m484u("connection", "host", "keep-alive", "proxy-connection", "te", "transfer-encoding", "encoding", "upgrade", C1453a.TARGET_METHOD_UTF8, C1453a.TARGET_PATH_UTF8, C1453a.TARGET_SCHEME_UTF8, C1453a.TARGET_AUTHORITY_UTF8);

    /* renamed from: h */
    private static final List<String> f761h = C1421a.m484u("connection", "host", "keep-alive", "proxy-connection", "te", "transfer-encoding", "encoding", "upgrade");

    /* renamed from: a */
    private final Interceptor.Chain f762a;

    /* renamed from: b */
    private final C1429e f763b;

    /* renamed from: c */
    private final Http2Connection f764c;

    /* renamed from: d */
    private volatile C1457e f765d;

    /* renamed from: e */
    private final Protocol f766e;

    /* renamed from: f */
    private volatile boolean f767f;

    public C1456d(OkHttpClient okHttpClient, C1429e c1429e, Interceptor.Chain chain, Http2Connection http2Connection) {
        this.f763b = c1429e;
        this.f762a = chain;
        this.f764c = http2Connection;
        List<Protocol> protocols = okHttpClient.protocols();
        Protocol protocol = Protocol.H2_PRIOR_KNOWLEDGE;
        this.f766e = protocols.contains(protocol) ? protocol : Protocol.HTTP_2;
    }

    /* renamed from: a */
    public static List<C1453a> m689a(C1474n c1474n) {
        C1471k m854d = c1474n.m854d();
        ArrayList arrayList = new ArrayList(m854d.m782h() + 4);
        arrayList.add(new C1453a(C1453a.TARGET_METHOD, c1474n.m856f()));
        arrayList.add(new C1453a(C1453a.TARGET_PATH, lb4.c(c1474n.m858h())));
        String m853c = c1474n.m853c("Host");
        if (m853c != null) {
            arrayList.add(new C1453a(C1453a.TARGET_AUTHORITY, m853c));
        }
        arrayList.add(new C1453a(C1453a.TARGET_SCHEME, c1474n.m858h().m808C()));
        int m782h = m854d.m782h();
        for (int i = 0; i < m782h; i++) {
            String lowerCase = m854d.m780e(i).toLowerCase(Locale.US);
            if (!f760g.contains(lowerCase) || (lowerCase.equals("te") && m854d.m783i(i).equals("trailers"))) {
                arrayList.add(new C1453a(lowerCase, m854d.m783i(i)));
            }
        }
        return arrayList;
    }

    /* renamed from: b */
    public static C1476p.a m690b(C1471k c1471k, Protocol protocol) throws IOException {
        C1471k.a aVar = new C1471k.a();
        int m782h = c1471k.m782h();
        C1438e c1438e = null;
        for (int i = 0; i < m782h; i++) {
            String m780e = c1471k.m780e(i);
            String m783i = c1471k.m783i(i);
            if (m780e.equals(C1453a.RESPONSE_STATUS_UTF8)) {
                c1438e = C1438e.m601a("HTTP/1.1 " + m783i);
            } else if (!f761h.contains(m780e)) {
                q92.a.b(aVar, m780e, m783i);
            }
        }
        if (c1438e != null) {
            return new C1476p.a().m900o(protocol).m892g(c1438e.f688b).m897l(c1438e.f689c).m895j(aVar.m789e());
        }
        throw new ProtocolException("Expected ':status' header not present");
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public void cancel() {
        this.f767f = true;
        if (this.f765d != null) {
            this.f765d.m696f(ErrorCode.CANCEL);
        }
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public C1429e connection() {
        return this.f763b;
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public Sink createRequestBody(C1474n c1474n, long j) {
        return this.f765d.m698h();
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public void finishRequest() throws IOException {
        this.f765d.m698h().close();
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public void flushRequest() throws IOException {
        this.f764c.flush();
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public Source openResponseBodySource(C1476p c1476p) {
        return this.f765d.m699i();
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public C1476p.a readResponseHeaders(boolean z) throws IOException {
        C1476p.a m690b = m690b(this.f765d.m706p(), this.f766e);
        if (z && q92.a.d(m690b) == 100) {
            return null;
        }
        return m690b;
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public long reportedContentLength(C1476p c1476p) {
        return e42.b(c1476p);
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public C1471k trailers() throws IOException {
        return this.f765d.m707q();
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public void writeRequestHeaders(C1474n c1474n) throws IOException {
        if (this.f765d != null) {
            return;
        }
        this.f765d = this.f764c.m632t(m689a(c1474n), c1474n.m851a() != null);
        if (this.f767f) {
            this.f765d.m696f(ErrorCode.CANCEL);
            throw new IOException("Canceled");
        }
        o m702l = this.f765d.m702l();
        long readTimeoutMillis = this.f762a.readTimeoutMillis();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        m702l.timeout(readTimeoutMillis, timeUnit);
        this.f765d.m709s().timeout(this.f762a.writeTimeoutMillis(), timeUnit);
    }
}
