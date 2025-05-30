package okhttp3;

import javax.annotation.Nullable;
import okhttp3.internal.connection.c;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public class p$a {

    @Nullable
    n a;

    @Nullable
    Protocol b;
    int c;
    String d;

    @Nullable
    j e;
    k$a f;

    @Nullable
    q g;

    @Nullable
    p h;

    @Nullable
    p i;

    @Nullable
    p j;
    long k;
    long l;

    @Nullable
    c m;

    public p$a() {
        this.c = -1;
        this.f = new k$a();
    }

    private void e(p pVar) {
        if (pVar.g != null) {
            throw new IllegalArgumentException("priorResponse.body != null");
        }
    }

    private void f(String str, p pVar) {
        if (pVar.g != null) {
            throw new IllegalArgumentException(str + ".body != null");
        }
        if (pVar.h != null) {
            throw new IllegalArgumentException(str + ".networkResponse != null");
        }
        if (pVar.i != null) {
            throw new IllegalArgumentException(str + ".cacheResponse != null");
        }
        if (pVar.j == null) {
            return;
        }
        throw new IllegalArgumentException(str + ".priorResponse != null");
    }

    public p$a a(String str, String str2) {
        this.f.a(str, str2);
        return this;
    }

    public p$a b(@Nullable q qVar) {
        this.g = qVar;
        return this;
    }

    public p c() {
        if (this.a == null) {
            throw new IllegalStateException("request == null");
        }
        if (this.b == null) {
            throw new IllegalStateException("protocol == null");
        }
        if (this.c >= 0) {
            if (this.d != null) {
                return new p(this);
            }
            throw new IllegalStateException("message == null");
        }
        throw new IllegalStateException("code < 0: " + this.c);
    }

    public p$a d(@Nullable p pVar) {
        if (pVar != null) {
            f("cacheResponse", pVar);
        }
        this.i = pVar;
        return this;
    }

    public p$a g(int i) {
        this.c = i;
        return this;
    }

    public p$a h(@Nullable j jVar) {
        this.e = jVar;
        return this;
    }

    public p$a i(String str, String str2) {
        this.f.g(str, str2);
        return this;
    }

    public p$a j(k kVar) {
        this.f = kVar.f();
        return this;
    }

    void k(c cVar) {
        this.m = cVar;
    }

    public p$a l(String str) {
        this.d = str;
        return this;
    }

    public p$a m(@Nullable p pVar) {
        if (pVar != null) {
            f("networkResponse", pVar);
        }
        this.h = pVar;
        return this;
    }

    public p$a n(@Nullable p pVar) {
        if (pVar != null) {
            e(pVar);
        }
        this.j = pVar;
        return this;
    }

    public p$a o(Protocol protocol) {
        this.b = protocol;
        return this;
    }

    public p$a p(long j) {
        this.l = j;
        return this;
    }

    public p$a q(n nVar) {
        this.a = nVar;
        return this;
    }

    public p$a r(long j) {
        this.k = j;
        return this;
    }

    p$a(p pVar) {
        this.c = -1;
        this.a = pVar.a;
        this.b = pVar.b;
        this.c = pVar.c;
        this.d = pVar.d;
        this.e = pVar.e;
        this.f = pVar.f.f();
        this.g = pVar.g;
        this.h = pVar.h;
        this.i = pVar.i;
        this.j = pVar.j;
        this.k = pVar.k;
        this.l = pVar.l;
        this.m = pVar.m;
    }
}
