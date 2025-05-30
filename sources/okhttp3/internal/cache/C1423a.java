package okhttp3.internal.cache;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import okhttp3.C1471k;
import okhttp3.C1474n;
import okhttp3.C1476p;
import okhttp3.Interceptor;
import okhttp3.Protocol;
import okhttp3.internal.C1421a;
import okhttp3.internal.cache.C1424b;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.Sink;
import okio.Source;
import okio.h;
import okio.o;
import tb.e42;
import tb.h42;
import tb.q92;
import tb.s84;

/* compiled from: Taobao */
/* renamed from: okhttp3.internal.cache.a */
/* loaded from: classes.dex */
public final class C1423a implements Interceptor {

    /* renamed from: a */
    @Nullable
    final InternalCache f573a;

    /* compiled from: Taobao */
    /* renamed from: okhttp3.internal.cache.a$a */
    class a implements Source {

        /* renamed from: a */
        boolean f574a;

        /* renamed from: b */
        final /* synthetic */ BufferedSource f575b;

        /* renamed from: c */
        final /* synthetic */ CacheRequest f576c;

        /* renamed from: d */
        final /* synthetic */ BufferedSink f577d;

        a(C1423a c1423a, BufferedSource bufferedSource, CacheRequest cacheRequest, BufferedSink bufferedSink) {
            this.f575b = bufferedSource;
            this.f576c = cacheRequest;
            this.f577d = bufferedSink;
        }

        public void close() throws IOException {
            if (!this.f574a && !C1421a.m479p(this, 100, TimeUnit.MILLISECONDS)) {
                this.f574a = true;
                this.f576c.abort();
            }
            this.f575b.close();
        }

        public long read(Buffer buffer, long j) throws IOException {
            try {
                long read = this.f575b.read(buffer, j);
                if (read != -1) {
                    buffer.copyTo(this.f577d.buffer(), buffer.size() - read, read);
                    this.f577d.emitCompleteSegments();
                    return read;
                }
                if (!this.f574a) {
                    this.f574a = true;
                    this.f577d.close();
                }
                return -1L;
            } catch (IOException e) {
                if (!this.f574a) {
                    this.f574a = true;
                    this.f576c.abort();
                }
                throw e;
            }
        }

        public o timeout() {
            return this.f575b.timeout();
        }
    }

    public C1423a(@Nullable InternalCache internalCache) {
        this.f573a = internalCache;
    }

    /* renamed from: a */
    private C1476p m490a(CacheRequest cacheRequest, C1476p c1476p) throws IOException {
        Sink body;
        if (cacheRequest == null || (body = cacheRequest.body()) == null) {
            return c1476p;
        }
        return c1476p.m881l().m889b(new s84(c1476p.m877g("Content-Type"), c1476p.m873a().mo910g(), h.c(new a(this, c1476p.m873a().mo912m(), cacheRequest, h.b(body))))).m890c();
    }

    /* renamed from: b */
    private static C1471k m491b(C1471k c1471k, C1471k c1471k2) {
        C1471k.a aVar = new C1471k.a();
        int m782h = c1471k.m782h();
        for (int i = 0; i < m782h; i++) {
            String m780e = c1471k.m780e(i);
            String m783i = c1471k.m783i(i);
            if ((!"Warning".equalsIgnoreCase(m780e) || !m783i.startsWith("1")) && (m492c(m780e) || !m493d(m780e) || c1471k2.m779c(m780e) == null)) {
                q92.a.b(aVar, m780e, m783i);
            }
        }
        int m782h2 = c1471k2.m782h();
        for (int i2 = 0; i2 < m782h2; i2++) {
            String m780e2 = c1471k2.m780e(i2);
            if (!m492c(m780e2) && m493d(m780e2)) {
                q92.a.b(aVar, m780e2, c1471k2.m783i(i2));
            }
        }
        return aVar.m789e();
    }

    /* renamed from: c */
    static boolean m492c(String str) {
        return "Content-Length".equalsIgnoreCase(str) || "Content-Encoding".equalsIgnoreCase(str) || "Content-Type".equalsIgnoreCase(str);
    }

    /* renamed from: d */
    static boolean m493d(String str) {
        return ("Connection".equalsIgnoreCase(str) || "Keep-Alive".equalsIgnoreCase(str) || "Proxy-Authenticate".equalsIgnoreCase(str) || "Proxy-Authorization".equalsIgnoreCase(str) || "TE".equalsIgnoreCase(str) || "Trailers".equalsIgnoreCase(str) || "Transfer-Encoding".equalsIgnoreCase(str) || "Upgrade".equalsIgnoreCase(str)) ? false : true;
    }

    /* renamed from: e */
    private static C1476p m494e(C1476p c1476p) {
        return (c1476p == null || c1476p.m873a() == null) ? c1476p : c1476p.m881l().m889b(null).m890c();
    }

    @Override // okhttp3.Interceptor
    public C1476p intercept(Interceptor.Chain chain) throws IOException {
        InternalCache internalCache = this.f573a;
        C1476p c1476p = internalCache != null ? internalCache.get(chain.request()) : null;
        C1424b m501c = new C1424b.a(System.currentTimeMillis(), chain.request(), c1476p).m501c();
        C1474n c1474n = m501c.f578a;
        C1476p c1476p2 = m501c.f579b;
        InternalCache internalCache2 = this.f573a;
        if (internalCache2 != null) {
            internalCache2.trackResponse(m501c);
        }
        if (c1476p != null && c1476p2 == null) {
            C1421a.m470g(c1476p.m873a());
        }
        if (c1474n == null && c1476p2 == null) {
            return new C1476p.a().m902q(chain.request()).m900o(Protocol.HTTP_1_1).m892g(TypedValues.PositionType.TYPE_PERCENT_HEIGHT).m897l("Unsatisfiable Request (only-if-cached)").m889b(C1421a.EMPTY_RESPONSE).m903r(-1L).m901p(System.currentTimeMillis()).m890c();
        }
        if (c1474n == null) {
            return c1476p2.m881l().m891d(m494e(c1476p2)).m890c();
        }
        try {
            C1476p proceed = chain.proceed(c1474n);
            if (proceed == null && c1476p != null) {
            }
            if (c1476p2 != null) {
                if (proceed.m875e() == 304) {
                    C1476p m890c = c1476p2.m881l().m895j(m491b(c1476p2.m879j(), proceed.m879j())).m903r(proceed.m885p()).m901p(proceed.m883n()).m891d(m494e(c1476p2)).m898m(m494e(proceed)).m890c();
                    proceed.m873a().close();
                    this.f573a.trackConditionalCacheHit();
                    this.f573a.update(c1476p2, m890c);
                    return m890c;
                }
                C1421a.m470g(c1476p2.m873a());
            }
            C1476p m890c2 = proceed.m881l().m891d(m494e(c1476p2)).m898m(m494e(proceed)).m890c();
            if (this.f573a != null) {
                if (e42.c(m890c2) && C1424b.m495a(m890c2, c1474n)) {
                    return m490a(this.f573a.put(m890c2), m890c2);
                }
                if (h42.a(c1474n.m856f())) {
                    try {
                        this.f573a.remove(c1474n);
                    } catch (IOException unused) {
                    }
                }
            }
            return m890c2;
        } finally {
            if (c1476p != null) {
                C1421a.m470g(c1476p.m873a());
            }
        }
    }
}
