package okhttp3;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import javax.annotation.Nullable;
import okhttp3.k;
import tb.cp;
import tb.h42;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class n {
    final l a;
    final String b;
    final k c;

    @Nullable
    final o d;
    final Map<Class<?>, Object> e;

    @Nullable
    private volatile cp f;

    n(a aVar) {
        this.a = aVar.a;
        this.b = aVar.b;
        this.c = aVar.c.e();
        this.d = aVar.d;
        this.e = okhttp3.internal.a.v(aVar.e);
    }

    @Nullable
    public o a() {
        return this.d;
    }

    public cp b() {
        cp cpVar = this.f;
        if (cpVar != null) {
            return cpVar;
        }
        cp k = cp.k(this.c);
        this.f = k;
        return k;
    }

    @Nullable
    public String c(String str) {
        return this.c.c(str);
    }

    public k d() {
        return this.c;
    }

    public boolean e() {
        return this.a.n();
    }

    public String f() {
        return this.b;
    }

    public a g() {
        return new a(this);
    }

    public l h() {
        return this.a;
    }

    public String toString() {
        return "Request{method=" + this.b + ", url=" + this.a + ", tags=" + this.e + '}';
    }

    /* compiled from: Taobao */
    public static class a {

        @Nullable
        l a;
        String b;
        k.a c;

        @Nullable
        o d;
        Map<Class<?>, Object> e;

        public a() {
            this.e = Collections.emptyMap();
            this.b = "GET";
            this.c = new k.a();
        }

        public n a() {
            if (this.a != null) {
                return new n(this);
            }
            throw new IllegalStateException("url == null");
        }

        public a b() {
            return e("GET", null);
        }

        public a c(String str, String str2) {
            this.c.g(str, str2);
            return this;
        }

        public a d(k kVar) {
            this.c = kVar.f();
            return this;
        }

        public a e(String str, @Nullable o oVar) {
            Objects.requireNonNull(str, "method == null");
            if (str.length() == 0) {
                throw new IllegalArgumentException("method.length() == 0");
            }
            if (oVar != null && !h42.b(str)) {
                throw new IllegalArgumentException("method " + str + " must not have a request body.");
            }
            if (oVar != null || !h42.e(str)) {
                this.b = str;
                this.d = oVar;
                return this;
            }
            throw new IllegalArgumentException("method " + str + " must have a request body.");
        }

        public a f(o oVar) {
            return e("POST", oVar);
        }

        public a g(String str) {
            this.c.f(str);
            return this;
        }

        public a h(String str) {
            Objects.requireNonNull(str, "url == null");
            if (str.regionMatches(true, 0, "ws:", 0, 3)) {
                str = "http:" + str.substring(3);
            } else if (str.regionMatches(true, 0, "wss:", 0, 4)) {
                str = "https:" + str.substring(4);
            }
            return i(l.l(str));
        }

        public a i(l lVar) {
            Objects.requireNonNull(lVar, "url == null");
            this.a = lVar;
            return this;
        }

        a(n nVar) {
            Map<Class<?>, Object> linkedHashMap;
            this.e = Collections.emptyMap();
            this.a = nVar.a;
            this.b = nVar.b;
            this.d = nVar.d;
            if (nVar.e.isEmpty()) {
                linkedHashMap = Collections.emptyMap();
            } else {
                linkedHashMap = new LinkedHashMap<>(nVar.e);
            }
            this.e = linkedHashMap;
            this.c = nVar.c.f();
        }
    }
}
