package okhttp3.internal.http;

import android.taobao.windvane.extra.p002uc.preRender.BasePreInitManager;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import okhttp3.C1474n;
import okhttp3.C1476p;
import okhttp3.Call;
import okhttp3.Connection;
import okhttp3.Interceptor;
import okhttp3.internal.C1421a;
import okhttp3.internal.connection.C1427c;
import okhttp3.internal.connection.C1433i;

/* compiled from: Taobao */
/* renamed from: okhttp3.internal.http.c */
/* loaded from: classes2.dex */
public final class C1436c implements Interceptor.Chain {

    /* renamed from: a */
    private final List<Interceptor> f676a;

    /* renamed from: b */
    private final C1433i f677b;

    /* renamed from: c */
    @Nullable
    private final C1427c f678c;

    /* renamed from: d */
    private final int f679d;

    /* renamed from: e */
    private final C1474n f680e;

    /* renamed from: f */
    private final Call f681f;

    /* renamed from: g */
    private final int f682g;

    /* renamed from: h */
    private final int f683h;

    /* renamed from: i */
    private final int f684i;

    /* renamed from: j */
    private int f685j;

    public C1436c(List<Interceptor> list, C1433i c1433i, @Nullable C1427c c1427c, int i, C1474n c1474n, Call call, int i2, int i3, int i4) {
        this.f676a = list;
        this.f677b = c1433i;
        this.f678c = c1427c;
        this.f679d = i;
        this.f680e = c1474n;
        this.f681f = call;
        this.f682g = i2;
        this.f683h = i3;
        this.f684i = i4;
    }

    /* renamed from: a */
    public C1427c m593a() {
        C1427c c1427c = this.f678c;
        if (c1427c != null) {
            return c1427c;
        }
        throw new IllegalStateException();
    }

    /* renamed from: b */
    public C1476p m594b(C1474n c1474n, C1433i c1433i, @Nullable C1427c c1427c) throws IOException {
        if (this.f679d >= this.f676a.size()) {
            throw new AssertionError();
        }
        this.f685j++;
        C1427c c1427c2 = this.f678c;
        if (c1427c2 != null && !c1427c2.m507c().m551s(c1474n.m858h())) {
            throw new IllegalStateException("network interceptor " + this.f676a.get(this.f679d - 1) + " must retain the same host and port");
        }
        if (this.f678c != null && this.f685j > 1) {
            throw new IllegalStateException("network interceptor " + this.f676a.get(this.f679d - 1) + " must call proceed() exactly once");
        }
        C1436c c1436c = new C1436c(this.f676a, c1433i, c1427c, this.f679d + 1, c1474n, this.f681f, this.f682g, this.f683h, this.f684i);
        Interceptor interceptor = this.f676a.get(this.f679d);
        C1476p intercept = interceptor.intercept(c1436c);
        if (c1427c != null && this.f679d + 1 < this.f676a.size() && c1436c.f685j != 1) {
            throw new IllegalStateException("network interceptor " + interceptor + " must call proceed() exactly once");
        }
        if (intercept == null) {
            throw new NullPointerException("interceptor " + interceptor + " returned null");
        }
        if (intercept.m873a() != null) {
            return intercept;
        }
        throw new IllegalStateException("interceptor " + interceptor + " returned a response with no body");
    }

    /* renamed from: c */
    public C1433i m595c() {
        return this.f677b;
    }

    @Override // okhttp3.Interceptor.Chain
    public Call call() {
        return this.f681f;
    }

    @Override // okhttp3.Interceptor.Chain
    public int connectTimeoutMillis() {
        return this.f682g;
    }

    @Override // okhttp3.Interceptor.Chain
    @Nullable
    public Connection connection() {
        C1427c c1427c = this.f678c;
        if (c1427c != null) {
            return c1427c.m507c();
        }
        return null;
    }

    @Override // okhttp3.Interceptor.Chain
    public C1476p proceed(C1474n c1474n) throws IOException {
        return m594b(c1474n, this.f677b, this.f678c);
    }

    @Override // okhttp3.Interceptor.Chain
    public int readTimeoutMillis() {
        return this.f683h;
    }

    @Override // okhttp3.Interceptor.Chain
    public C1474n request() {
        return this.f680e;
    }

    @Override // okhttp3.Interceptor.Chain
    public Interceptor.Chain withConnectTimeout(int i, TimeUnit timeUnit) {
        return new C1436c(this.f676a, this.f677b, this.f678c, this.f679d, this.f680e, this.f681f, C1421a.m468e(BasePreInitManager.TIMEOUT, i, timeUnit), this.f683h, this.f684i);
    }

    @Override // okhttp3.Interceptor.Chain
    public Interceptor.Chain withReadTimeout(int i, TimeUnit timeUnit) {
        return new C1436c(this.f676a, this.f677b, this.f678c, this.f679d, this.f680e, this.f681f, this.f682g, C1421a.m468e(BasePreInitManager.TIMEOUT, i, timeUnit), this.f684i);
    }

    @Override // okhttp3.Interceptor.Chain
    public Interceptor.Chain withWriteTimeout(int i, TimeUnit timeUnit) {
        return new C1436c(this.f676a, this.f677b, this.f678c, this.f679d, this.f680e, this.f681f, this.f682g, this.f683h, C1421a.m468e(BasePreInitManager.TIMEOUT, i, timeUnit));
    }

    @Override // okhttp3.Interceptor.Chain
    public int writeTimeoutMillis() {
        return this.f684i;
    }
}
