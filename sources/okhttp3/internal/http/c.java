package okhttp3.internal.http;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import okhttp3.Call;
import okhttp3.Connection;
import okhttp3.Interceptor;
import okhttp3.internal.connection.i;
import okhttp3.n;
import okhttp3.p;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class c implements Interceptor.Chain {
    private final List<Interceptor> a;
    private final i b;

    @Nullable
    private final okhttp3.internal.connection.c c;
    private final int d;
    private final n e;
    private final Call f;
    private final int g;
    private final int h;
    private final int i;
    private int j;

    public c(List<Interceptor> list, i iVar, @Nullable okhttp3.internal.connection.c cVar, int i, n nVar, Call call, int i2, int i3, int i4) {
        this.a = list;
        this.b = iVar;
        this.c = cVar;
        this.d = i;
        this.e = nVar;
        this.f = call;
        this.g = i2;
        this.h = i3;
        this.i = i4;
    }

    public okhttp3.internal.connection.c a() {
        okhttp3.internal.connection.c cVar = this.c;
        if (cVar != null) {
            return cVar;
        }
        throw new IllegalStateException();
    }

    public p b(n nVar, i iVar, @Nullable okhttp3.internal.connection.c cVar) throws IOException {
        if (this.d >= this.a.size()) {
            throw new AssertionError();
        }
        this.j++;
        okhttp3.internal.connection.c cVar2 = this.c;
        if (cVar2 != null && !cVar2.c().s(nVar.h())) {
            throw new IllegalStateException("network interceptor " + this.a.get(this.d - 1) + " must retain the same host and port");
        }
        if (this.c != null && this.j > 1) {
            throw new IllegalStateException("network interceptor " + this.a.get(this.d - 1) + " must call proceed() exactly once");
        }
        c cVar3 = new c(this.a, iVar, cVar, this.d + 1, nVar, this.f, this.g, this.h, this.i);
        Interceptor interceptor = this.a.get(this.d);
        p intercept = interceptor.intercept(cVar3);
        if (cVar != null && this.d + 1 < this.a.size() && cVar3.j != 1) {
            throw new IllegalStateException("network interceptor " + interceptor + " must call proceed() exactly once");
        }
        if (intercept == null) {
            throw new NullPointerException("interceptor " + interceptor + " returned null");
        }
        if (intercept.a() != null) {
            return intercept;
        }
        throw new IllegalStateException("interceptor " + interceptor + " returned a response with no body");
    }

    public i c() {
        return this.b;
    }

    @Override // okhttp3.Interceptor.Chain
    public Call call() {
        return this.f;
    }

    @Override // okhttp3.Interceptor.Chain
    public int connectTimeoutMillis() {
        return this.g;
    }

    @Override // okhttp3.Interceptor.Chain
    @Nullable
    public Connection connection() {
        okhttp3.internal.connection.c cVar = this.c;
        if (cVar != null) {
            return cVar.c();
        }
        return null;
    }

    @Override // okhttp3.Interceptor.Chain
    public p proceed(n nVar) throws IOException {
        return b(nVar, this.b, this.c);
    }

    @Override // okhttp3.Interceptor.Chain
    public int readTimeoutMillis() {
        return this.h;
    }

    @Override // okhttp3.Interceptor.Chain
    public n request() {
        return this.e;
    }

    @Override // okhttp3.Interceptor.Chain
    public Interceptor.Chain withConnectTimeout(int i, TimeUnit timeUnit) {
        return new c(this.a, this.b, this.c, this.d, this.e, this.f, okhttp3.internal.a.e("timeout", i, timeUnit), this.h, this.i);
    }

    @Override // okhttp3.Interceptor.Chain
    public Interceptor.Chain withReadTimeout(int i, TimeUnit timeUnit) {
        return new c(this.a, this.b, this.c, this.d, this.e, this.f, this.g, okhttp3.internal.a.e("timeout", i, timeUnit), this.i);
    }

    @Override // okhttp3.Interceptor.Chain
    public Interceptor.Chain withWriteTimeout(int i, TimeUnit timeUnit) {
        return new c(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, okhttp3.internal.a.e("timeout", i, timeUnit));
    }

    @Override // okhttp3.Interceptor.Chain
    public int writeTimeoutMillis() {
        return this.i;
    }
}
