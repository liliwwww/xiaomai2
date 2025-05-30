package okhttp3.internal.http;

import java.io.IOException;
import java.util.List;
import okhttp3.AbstractC1475o;
import okhttp3.C1474n;
import okhttp3.C1476p;
import okhttp3.CookieJar;
import okhttp3.Interceptor;
import okhttp3.internal.C1421a;
import okio.f;
import okio.h;
import tb.e42;
import tb.mo2;
import tb.rz5;
import tb.s84;
import tb.y70;

/* compiled from: Taobao */
/* renamed from: okhttp3.internal.http.a */
/* loaded from: classes2.dex */
public final class C1434a implements Interceptor {

    /* renamed from: a */
    private final CookieJar f674a;

    public C1434a(CookieJar cookieJar) {
        this.f674a = cookieJar;
    }

    /* renamed from: a */
    private String m592a(List<y70> list) {
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
    public C1476p intercept(Interceptor.Chain chain) throws IOException {
        C1474n request = chain.request();
        C1474n.a m857g = request.m857g();
        AbstractC1475o m851a = request.m851a();
        if (m851a != null) {
            mo2 mo447b = m851a.mo447b();
            if (mo447b != null) {
                m857g.m861c("Content-Type", mo447b.toString());
            }
            long mo446a = m851a.mo446a();
            if (mo446a != -1) {
                m857g.m861c("Content-Length", Long.toString(mo446a));
                m857g.m865g("Transfer-Encoding");
            } else {
                m857g.m861c("Transfer-Encoding", "chunked");
                m857g.m865g("Content-Length");
            }
        }
        boolean z = false;
        if (request.m853c("Host") == null) {
            m857g.m861c("Host", C1421a.m482s(request.m858h(), false));
        }
        if (request.m853c("Connection") == null) {
            m857g.m861c("Connection", "Keep-Alive");
        }
        if (request.m853c("Accept-Encoding") == null && request.m853c("Range") == null) {
            z = true;
            m857g.m861c("Accept-Encoding", "gzip");
        }
        List<y70> loadForRequest = this.f674a.loadForRequest(request.m858h());
        if (!loadForRequest.isEmpty()) {
            m857g.m861c("Cookie", m592a(loadForRequest));
        }
        if (request.m853c("User-Agent") == null) {
            m857g.m861c("User-Agent", rz5.a());
        }
        C1476p proceed = chain.proceed(m857g.m859a());
        e42.e(this.f674a, request.m858h(), proceed.m879j());
        C1476p.a m902q = proceed.m881l().m902q(request);
        if (z && "gzip".equalsIgnoreCase(proceed.m877g("Content-Encoding")) && e42.c(proceed)) {
            f fVar = new f(proceed.m873a().mo912m());
            m902q.m895j(proceed.m879j().m781f().m790f("Content-Encoding").m790f("Content-Length").m789e());
            m902q.m889b(new s84(proceed.m877g("Content-Type"), -1L, h.c(fVar)));
        }
        return m902q.m890c();
    }
}
