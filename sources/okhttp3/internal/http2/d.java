package okhttp3.internal.http2;

import java.io.IOException;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.internal.http.ExchangeCodec;
import okhttp3.k;
import okhttp3.k$a;
import okhttp3.n;
import okhttp3.p;
import okhttp3.p$a;
import okio.Sink;
import okio.Source;
import okio.o;
import tb.e42;
import tb.lb4;
import tb.q92;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class d implements ExchangeCodec {
    private static final List<String> g = okhttp3.internal.a.u(new String[]{"connection", "host", "keep-alive", "proxy-connection", "te", "transfer-encoding", "encoding", "upgrade", a.TARGET_METHOD_UTF8, a.TARGET_PATH_UTF8, a.TARGET_SCHEME_UTF8, a.TARGET_AUTHORITY_UTF8});
    private static final List<String> h = okhttp3.internal.a.u(new String[]{"connection", "host", "keep-alive", "proxy-connection", "te", "transfer-encoding", "encoding", "upgrade"});
    private final Interceptor.Chain a;
    private final okhttp3.internal.connection.e b;
    private final Http2Connection c;
    private volatile e d;
    private final Protocol e;
    private volatile boolean f;

    public d(OkHttpClient okHttpClient, okhttp3.internal.connection.e eVar, Interceptor.Chain chain, Http2Connection http2Connection) {
        this.b = eVar;
        this.a = chain;
        this.c = http2Connection;
        List protocols = okHttpClient.protocols();
        Protocol protocol = Protocol.H2_PRIOR_KNOWLEDGE;
        this.e = protocols.contains(protocol) ? protocol : Protocol.HTTP_2;
    }

    public static List<a> a(n nVar) {
        k d = nVar.d();
        ArrayList arrayList = new ArrayList(d.h() + 4);
        arrayList.add(new a(a.TARGET_METHOD, nVar.f()));
        arrayList.add(new a(a.TARGET_PATH, lb4.c(nVar.h())));
        String c = nVar.c("Host");
        if (c != null) {
            arrayList.add(new a(a.TARGET_AUTHORITY, c));
        }
        arrayList.add(new a(a.TARGET_SCHEME, nVar.h().C()));
        int h2 = d.h();
        for (int i = 0; i < h2; i++) {
            String lowerCase = d.e(i).toLowerCase(Locale.US);
            if (!g.contains(lowerCase) || (lowerCase.equals("te") && d.i(i).equals("trailers"))) {
                arrayList.add(new a(lowerCase, d.i(i)));
            }
        }
        return arrayList;
    }

    public static p$a b(k kVar, Protocol protocol) throws IOException {
        k$a k_a = new k$a();
        int h2 = kVar.h();
        okhttp3.internal.http.e eVar = null;
        for (int i = 0; i < h2; i++) {
            String e = kVar.e(i);
            String i2 = kVar.i(i);
            if (e.equals(a.RESPONSE_STATUS_UTF8)) {
                eVar = okhttp3.internal.http.e.a("HTTP/1.1 " + i2);
            } else if (!h.contains(e)) {
                q92.a.b(k_a, e, i2);
            }
        }
        if (eVar != null) {
            return new p$a().o(protocol).g(eVar.b).l(eVar.c).j(k_a.e());
        }
        throw new ProtocolException("Expected ':status' header not present");
    }

    public void cancel() {
        this.f = true;
        if (this.d != null) {
            this.d.f(ErrorCode.CANCEL);
        }
    }

    public okhttp3.internal.connection.e connection() {
        return this.b;
    }

    public Sink createRequestBody(n nVar, long j) {
        return this.d.h();
    }

    public void finishRequest() throws IOException {
        this.d.h().close();
    }

    public void flushRequest() throws IOException {
        this.c.flush();
    }

    public Source openResponseBodySource(p pVar) {
        return this.d.i();
    }

    public p$a readResponseHeaders(boolean z) throws IOException {
        p$a b = b(this.d.p(), this.e);
        if (z && q92.a.d(b) == 100) {
            return null;
        }
        return b;
    }

    public long reportedContentLength(p pVar) {
        return e42.b(pVar);
    }

    public k trailers() throws IOException {
        return this.d.q();
    }

    public void writeRequestHeaders(n nVar) throws IOException {
        if (this.d != null) {
            return;
        }
        this.d = this.c.t(a(nVar), nVar.a() != null);
        if (this.f) {
            this.d.f(ErrorCode.CANCEL);
            throw new IOException("Canceled");
        }
        o l = this.d.l();
        long readTimeoutMillis = this.a.readTimeoutMillis();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        l.timeout(readTimeoutMillis, timeUnit);
        this.d.s().timeout(this.a.writeTimeoutMillis(), timeUnit);
    }
}
