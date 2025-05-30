package okhttp3.internal.http;

import java.io.IOException;
import java.util.List;
import okhttp3.CookieJar;
import okhttp3.Interceptor;
import okhttp3.n;
import okhttp3.o;
import okhttp3.p;
import okio.f;
import okio.h;
import tb.e42;
import tb.mo2;
import tb.rz5;
import tb.s84;
import tb.y70;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class a implements Interceptor {
    private final CookieJar a;

    public a(CookieJar cookieJar) {
        this.a = cookieJar;
    }

    private String a(List<y70> list) {
        StringBuilder sb = new StringBuilder();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                sb.append("; ");
            }
            y70 y70Var = list.get(i);
            sb.append(y70Var.c());
            sb.append('=');
            sb.append(y70Var.k());
        }
        return sb.toString();
    }

    @Override // okhttp3.Interceptor
    public p intercept(Interceptor.Chain chain) throws IOException {
        n request = chain.request();
        n.a g = request.g();
        o a = request.a();
        if (a != null) {
            mo2 b = a.b();
            if (b != null) {
                g.c("Content-Type", b.toString());
            }
            long a2 = a.a();
            if (a2 != -1) {
                g.c("Content-Length", Long.toString(a2));
                g.g("Transfer-Encoding");
            } else {
                g.c("Transfer-Encoding", "chunked");
                g.g("Content-Length");
            }
        }
        boolean z = false;
        if (request.c("Host") == null) {
            g.c("Host", okhttp3.internal.a.s(request.h(), false));
        }
        if (request.c("Connection") == null) {
            g.c("Connection", "Keep-Alive");
        }
        if (request.c("Accept-Encoding") == null && request.c("Range") == null) {
            z = true;
            g.c("Accept-Encoding", "gzip");
        }
        List<y70> loadForRequest = this.a.loadForRequest(request.h());
        if (!loadForRequest.isEmpty()) {
            g.c("Cookie", a(loadForRequest));
        }
        if (request.c("User-Agent") == null) {
            g.c("User-Agent", rz5.a());
        }
        p proceed = chain.proceed(g.a());
        e42.e(this.a, request.h(), proceed.j());
        p.a q = proceed.l().q(request);
        if (z && "gzip".equalsIgnoreCase(proceed.g("Content-Encoding")) && e42.c(proceed)) {
            f fVar = new f(proceed.a().m());
            q.j(proceed.j().f().f("Content-Encoding").f("Content-Length").e());
            q.b(new s84(proceed.g("Content-Type"), -1L, h.c(fVar)));
        }
        return q.c();
    }
}
