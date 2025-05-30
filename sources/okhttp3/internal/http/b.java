package okhttp3.internal.http;

import java.io.IOException;
import java.net.ProtocolException;
import okhttp3.Interceptor;
import okhttp3.n;
import okhttp3.p;
import okio.BufferedSink;
import okio.h;
import tb.h42;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class b implements Interceptor {
    private final boolean a;

    public b(boolean z) {
        this.a = z;
    }

    @Override // okhttp3.Interceptor
    public p intercept(Interceptor.Chain chain) throws IOException {
        boolean z;
        c cVar = (c) chain;
        okhttp3.internal.connection.c a = cVar.a();
        n request = cVar.request();
        long currentTimeMillis = System.currentTimeMillis();
        a.r(request);
        p.a aVar = null;
        if (!h42.b(request.f()) || request.a() == null) {
            a.k();
            z = false;
        } else {
            if ("100-continue".equalsIgnoreCase(request.c("Expect"))) {
                a.g();
                a.o();
                aVar = a.m(true);
                z = true;
            } else {
                z = false;
            }
            if (aVar != null) {
                a.k();
                if (!a.c().m()) {
                    a.j();
                }
            } else if (request.a().f()) {
                a.g();
                request.a().h(h.b(a.d(request, true)));
            } else {
                BufferedSink b = h.b(a.d(request, false));
                request.a().h(b);
                b.close();
            }
        }
        if (request.a() == null || !request.a().f()) {
            a.f();
        }
        if (!z) {
            a.o();
        }
        if (aVar == null) {
            aVar = a.m(false);
        }
        p c = aVar.q(request).h(a.c().handshake()).r(currentTimeMillis).p(System.currentTimeMillis()).c();
        int e = c.e();
        if (e == 100) {
            c = a.m(false).q(request).h(a.c().handshake()).r(currentTimeMillis).p(System.currentTimeMillis()).c();
            e = c.e();
        }
        a.n(c);
        p c2 = (this.a && e == 101) ? c.l().b(okhttp3.internal.a.EMPTY_RESPONSE).c() : c.l().b(a.l(c)).c();
        if ("close".equalsIgnoreCase(c2.o().c("Connection")) || "close".equalsIgnoreCase(c2.g("Connection"))) {
            a.j();
        }
        if ((e != 204 && e != 205) || c2.a().g() <= 0) {
            return c2;
        }
        throw new ProtocolException("HTTP " + e + " had non-zero Content-Length: " + c2.a().g());
    }
}
