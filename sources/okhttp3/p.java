package okhttp3;

import java.io.Closeable;
import javax.annotation.Nullable;
import tb.cp;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class p implements Closeable {
    final n a;
    final Protocol b;
    final int c;
    final String d;

    @Nullable
    final j e;
    final k f;

    @Nullable
    final q g;

    @Nullable
    final p h;

    @Nullable
    final p i;

    @Nullable
    final p j;
    final long k;
    final long l;

    @Nullable
    final okhttp3.internal.connection.c m;

    @Nullable
    private volatile cp n;

    p(a aVar) {
        this.a = aVar.a;
        this.b = aVar.b;
        this.c = aVar.c;
        this.d = aVar.d;
        this.e = aVar.e;
        this.f = aVar.f.e();
        this.g = aVar.g;
        this.h = aVar.h;
        this.i = aVar.i;
        this.j = aVar.j;
        this.k = aVar.k;
        this.l = aVar.l;
        this.m = aVar.m;
    }

    @Nullable
    public q a() {
        return this.g;
    }

    public cp c() {
        cp cpVar = this.n;
        if (cpVar != null) {
            return cpVar;
        }
        cp k = cp.k(this.f);
        this.n = k;
        return k;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        q qVar = this.g;
        if (qVar == null) {
            throw new IllegalStateException("response is not eligible for a body and must not be closed");
        }
        qVar.close();
    }

    public int e() {
        return this.c;
    }

    @Nullable
    public j f() {
        return this.e;
    }

    @Nullable
    public String g(String str) {
        return h(str, null);
    }

    @Nullable
    public String h(String str, @Nullable String str2) {
        String c = this.f.c(str);
        return c != null ? c : str2;
    }

    public boolean isSuccessful() {
        int i = this.c;
        return i >= 200 && i < 300;
    }

    public k j() {
        return this.f;
    }

    public String k() {
        return this.d;
    }

    public a l() {
        return new a(this);
    }

    @Nullable
    public p m() {
        return this.j;
    }

    public long n() {
        return this.l;
    }

    public n o() {
        return this.a;
    }

    public long p() {
        return this.k;
    }

    public String toString() {
        return "Response{protocol=" + this.b + ", code=" + this.c + ", message=" + this.d + ", url=" + this.a.h() + '}';
    }
}
