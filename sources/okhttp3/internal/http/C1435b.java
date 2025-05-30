package okhttp3.internal.http;

import java.io.IOException;
import java.net.ProtocolException;
import okhttp3.C1474n;
import okhttp3.C1476p;
import okhttp3.Interceptor;
import okhttp3.internal.C1421a;
import okhttp3.internal.connection.C1427c;
import okio.BufferedSink;
import okio.h;
import tb.h42;

/* compiled from: Taobao */
/* renamed from: okhttp3.internal.http.b */
/* loaded from: classes2.dex */
public final class C1435b implements Interceptor {

    /* renamed from: a */
    private final boolean f675a;

    public C1435b(boolean z) {
        this.f675a = z;
    }

    @Override // okhttp3.Interceptor
    public C1476p intercept(Interceptor.Chain chain) throws IOException {
        boolean z;
        C1436c c1436c = (C1436c) chain;
        C1427c m593a = c1436c.m593a();
        C1474n request = c1436c.request();
        long currentTimeMillis = System.currentTimeMillis();
        m593a.m522r(request);
        C1476p.a aVar = null;
        if (!h42.b(request.m856f()) || request.m851a() == null) {
            m593a.m515k();
            z = false;
        } else {
            if ("100-continue".equalsIgnoreCase(request.m853c("Expect"))) {
                m593a.m511g();
                m593a.m519o();
                aVar = m593a.m517m(true);
                z = true;
            } else {
                z = false;
            }
            if (aVar != null) {
                m593a.m515k();
                if (!m593a.m507c().m547m()) {
                    m593a.m514j();
                }
            } else if (request.m851a().m871f()) {
                m593a.m511g();
                request.m851a().mo448h(h.b(m593a.m508d(request, true)));
            } else {
                BufferedSink b = h.b(m593a.m508d(request, false));
                request.m851a().mo448h(b);
                b.close();
            }
        }
        if (request.m851a() == null || !request.m851a().m871f()) {
            m593a.m510f();
        }
        if (!z) {
            m593a.m519o();
        }
        if (aVar == null) {
            aVar = m593a.m517m(false);
        }
        C1476p m890c = aVar.m902q(request).m893h(m593a.m507c().handshake()).m903r(currentTimeMillis).m901p(System.currentTimeMillis()).m890c();
        int m875e = m890c.m875e();
        if (m875e == 100) {
            m890c = m593a.m517m(false).m902q(request).m893h(m593a.m507c().handshake()).m903r(currentTimeMillis).m901p(System.currentTimeMillis()).m890c();
            m875e = m890c.m875e();
        }
        m593a.m518n(m890c);
        C1476p m890c2 = (this.f675a && m875e == 101) ? m890c.m881l().m889b(C1421a.EMPTY_RESPONSE).m890c() : m890c.m881l().m889b(m593a.m516l(m890c)).m890c();
        if ("close".equalsIgnoreCase(m890c2.m884o().m853c("Connection")) || "close".equalsIgnoreCase(m890c2.m877g("Connection"))) {
            m593a.m514j();
        }
        if ((m875e != 204 && m875e != 205) || m890c2.m873a().mo910g() <= 0) {
            return m890c2;
        }
        throw new ProtocolException("HTTP " + m875e + " had non-zero Content-Length: " + m890c2.m873a().mo910g());
    }
}
