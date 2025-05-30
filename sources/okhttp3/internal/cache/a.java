package okhttp3.internal.cache;

import androidx.constraintlayout.core.motion.utils.TypedValues$PositionType;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import okhttp3.Interceptor;
import okhttp3.Protocol;
import okhttp3.internal.cache.b;
import okhttp3.k;
import okhttp3.k$a;
import okhttp3.n;
import okhttp3.p;
import okhttp3.p$a;
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
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class a implements Interceptor {

    @Nullable
    final InternalCache a;

    /* compiled from: Taobao */
    /* renamed from: okhttp3.internal.cache.a$a, reason: collision with other inner class name */
    class C0008a implements Source {
        boolean a;
        final /* synthetic */ BufferedSource b;
        final /* synthetic */ CacheRequest c;
        final /* synthetic */ BufferedSink d;

        C0008a(a aVar, BufferedSource bufferedSource, CacheRequest cacheRequest, BufferedSink bufferedSink) {
            this.b = bufferedSource;
            this.c = cacheRequest;
            this.d = bufferedSink;
        }

        public void close() throws IOException {
            if (!this.a && !okhttp3.internal.a.p(this, 100, TimeUnit.MILLISECONDS)) {
                this.a = true;
                this.c.abort();
            }
            this.b.close();
        }

        public long read(Buffer buffer, long j) throws IOException {
            try {
                long read = this.b.read(buffer, j);
                if (read != -1) {
                    buffer.copyTo(this.d.buffer(), buffer.size() - read, read);
                    this.d.emitCompleteSegments();
                    return read;
                }
                if (!this.a) {
                    this.a = true;
                    this.d.close();
                }
                return -1L;
            } catch (IOException e) {
                if (!this.a) {
                    this.a = true;
                    this.c.abort();
                }
                throw e;
            }
        }

        public o timeout() {
            return this.b.timeout();
        }
    }

    public a(@Nullable InternalCache internalCache) {
        this.a = internalCache;
    }

    private p a(CacheRequest cacheRequest, p pVar) throws IOException {
        Sink body;
        if (cacheRequest == null || (body = cacheRequest.body()) == null) {
            return pVar;
        }
        return pVar.l().b(new s84(pVar.g("Content-Type"), pVar.a().g(), h.c(new C0008a(this, pVar.a().m(), cacheRequest, h.b(body))))).c();
    }

    private static k b(k kVar, k kVar2) {
        k$a k_a = new k$a();
        int h = kVar.h();
        for (int i = 0; i < h; i++) {
            String e = kVar.e(i);
            String i2 = kVar.i(i);
            if ((!"Warning".equalsIgnoreCase(e) || !i2.startsWith("1")) && (c(e) || !d(e) || kVar2.c(e) == null)) {
                q92.a.b(k_a, e, i2);
            }
        }
        int h2 = kVar2.h();
        for (int i3 = 0; i3 < h2; i3++) {
            String e2 = kVar2.e(i3);
            if (!c(e2) && d(e2)) {
                q92.a.b(k_a, e2, kVar2.i(i3));
            }
        }
        return k_a.e();
    }

    static boolean c(String str) {
        return "Content-Length".equalsIgnoreCase(str) || "Content-Encoding".equalsIgnoreCase(str) || "Content-Type".equalsIgnoreCase(str);
    }

    static boolean d(String str) {
        return ("Connection".equalsIgnoreCase(str) || "Keep-Alive".equalsIgnoreCase(str) || "Proxy-Authenticate".equalsIgnoreCase(str) || "Proxy-Authorization".equalsIgnoreCase(str) || "TE".equalsIgnoreCase(str) || "Trailers".equalsIgnoreCase(str) || "Transfer-Encoding".equalsIgnoreCase(str) || "Upgrade".equalsIgnoreCase(str)) ? false : true;
    }

    private static p e(p pVar) {
        return (pVar == null || pVar.a() == null) ? pVar : pVar.l().b(null).c();
    }

    public p intercept(Interceptor.Chain chain) throws IOException {
        InternalCache internalCache = this.a;
        p pVar = internalCache != null ? internalCache.get(chain.request()) : null;
        b c = new b.a(System.currentTimeMillis(), chain.request(), pVar).c();
        n nVar = c.a;
        p pVar2 = c.b;
        InternalCache internalCache2 = this.a;
        if (internalCache2 != null) {
            internalCache2.trackResponse(c);
        }
        if (pVar != null && pVar2 == null) {
            okhttp3.internal.a.g(pVar.a());
        }
        if (nVar == null && pVar2 == null) {
            return new p$a().q(chain.request()).o(Protocol.HTTP_1_1).g(TypedValues$PositionType.TYPE_PERCENT_HEIGHT).l("Unsatisfiable Request (only-if-cached)").b(okhttp3.internal.a.EMPTY_RESPONSE).r(-1L).p(System.currentTimeMillis()).c();
        }
        if (nVar == null) {
            return pVar2.l().d(e(pVar2)).c();
        }
        try {
            p proceed = chain.proceed(nVar);
            if (proceed == null && pVar != null) {
            }
            if (pVar2 != null) {
                if (proceed.e() == 304) {
                    p c2 = pVar2.l().j(b(pVar2.j(), proceed.j())).r(proceed.p()).p(proceed.n()).d(e(pVar2)).m(e(proceed)).c();
                    proceed.a().close();
                    this.a.trackConditionalCacheHit();
                    this.a.update(pVar2, c2);
                    return c2;
                }
                okhttp3.internal.a.g(pVar2.a());
            }
            p c3 = proceed.l().d(e(pVar2)).m(e(proceed)).c();
            if (this.a != null) {
                if (e42.c(c3) && b.a(c3, nVar)) {
                    return a(this.a.put(c3), c3);
                }
                if (h42.a(nVar.f())) {
                    try {
                        this.a.remove(nVar);
                    } catch (IOException unused) {
                    }
                }
            }
            return c3;
        } finally {
            if (pVar != null) {
                okhttp3.internal.a.g(pVar.a());
            }
        }
    }
}
