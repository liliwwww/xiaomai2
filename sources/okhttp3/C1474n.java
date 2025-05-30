package okhttp3;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import javax.annotation.Nullable;
import okhttp3.C1471k;
import okhttp3.internal.C1421a;
import tb.cp;
import tb.h42;

/* compiled from: Taobao */
/* renamed from: okhttp3.n */
/* loaded from: classes2.dex */
public final class C1474n {

    /* renamed from: a */
    final C1472l f910a;

    /* renamed from: b */
    final String f911b;

    /* renamed from: c */
    final C1471k f912c;

    /* renamed from: d */
    @Nullable
    final AbstractC1475o f913d;

    /* renamed from: e */
    final Map<Class<?>, Object> f914e;

    /* renamed from: f */
    @Nullable
    private volatile cp f915f;

    C1474n(a aVar) {
        this.f910a = aVar.f916a;
        this.f911b = aVar.f917b;
        this.f912c = aVar.f918c.m789e();
        this.f913d = aVar.f919d;
        this.f914e = C1421a.m485v(aVar.f920e);
    }

    @Nullable
    /* renamed from: a */
    public AbstractC1475o m851a() {
        return this.f913d;
    }

    /* renamed from: b */
    public cp m852b() {
        cp cpVar = this.f915f;
        if (cpVar != null) {
            return cpVar;
        }
        cp k = cp.k(this.f912c);
        this.f915f = k;
        return k;
    }

    @Nullable
    /* renamed from: c */
    public String m853c(String str) {
        return this.f912c.m779c(str);
    }

    /* renamed from: d */
    public C1471k m854d() {
        return this.f912c;
    }

    /* renamed from: e */
    public boolean m855e() {
        return this.f910a.m817n();
    }

    /* renamed from: f */
    public String m856f() {
        return this.f911b;
    }

    /* renamed from: g */
    public a m857g() {
        return new a(this);
    }

    /* renamed from: h */
    public C1472l m858h() {
        return this.f910a;
    }

    public String toString() {
        return "Request{method=" + this.f911b + ", url=" + this.f910a + ", tags=" + this.f914e + '}';
    }

    /* compiled from: Taobao */
    /* renamed from: okhttp3.n$a */
    public static class a {

        /* renamed from: a */
        @Nullable
        C1472l f916a;

        /* renamed from: b */
        String f917b;

        /* renamed from: c */
        C1471k.a f918c;

        /* renamed from: d */
        @Nullable
        AbstractC1475o f919d;

        /* renamed from: e */
        Map<Class<?>, Object> f920e;

        public a() {
            this.f920e = Collections.emptyMap();
            this.f917b = "GET";
            this.f918c = new C1471k.a();
        }

        /* renamed from: a */
        public C1474n m859a() {
            if (this.f916a != null) {
                return new C1474n(this);
            }
            throw new IllegalStateException("url == null");
        }

        /* renamed from: b */
        public a m860b() {
            return m863e("GET", null);
        }

        /* renamed from: c */
        public a m861c(String str, String str2) {
            this.f918c.m791g(str, str2);
            return this;
        }

        /* renamed from: d */
        public a m862d(C1471k c1471k) {
            this.f918c = c1471k.m781f();
            return this;
        }

        /* renamed from: e */
        public a m863e(String str, @Nullable AbstractC1475o abstractC1475o) {
            Objects.requireNonNull(str, "method == null");
            if (str.length() == 0) {
                throw new IllegalArgumentException("method.length() == 0");
            }
            if (abstractC1475o != null && !h42.b(str)) {
                throw new IllegalArgumentException("method " + str + " must not have a request body.");
            }
            if (abstractC1475o != null || !h42.e(str)) {
                this.f917b = str;
                this.f919d = abstractC1475o;
                return this;
            }
            throw new IllegalArgumentException("method " + str + " must have a request body.");
        }

        /* renamed from: f */
        public a m864f(AbstractC1475o abstractC1475o) {
            return m863e("POST", abstractC1475o);
        }

        /* renamed from: g */
        public a m865g(String str) {
            this.f918c.m790f(str);
            return this;
        }

        /* renamed from: h */
        public a m866h(String str) {
            Objects.requireNonNull(str, "url == null");
            if (str.regionMatches(true, 0, "ws:", 0, 3)) {
                str = "http:" + str.substring(3);
            } else if (str.regionMatches(true, 0, "wss:", 0, 4)) {
                str = "https:" + str.substring(4);
            }
            return m867i(C1472l.m797l(str));
        }

        /* renamed from: i */
        public a m867i(C1472l c1472l) {
            Objects.requireNonNull(c1472l, "url == null");
            this.f916a = c1472l;
            return this;
        }

        a(C1474n c1474n) {
            Map<Class<?>, Object> linkedHashMap;
            this.f920e = Collections.emptyMap();
            this.f916a = c1474n.f910a;
            this.f917b = c1474n.f911b;
            this.f919d = c1474n.f913d;
            if (c1474n.f914e.isEmpty()) {
                linkedHashMap = Collections.emptyMap();
            } else {
                linkedHashMap = new LinkedHashMap<>(c1474n.f914e);
            }
            this.f920e = linkedHashMap;
            this.f918c = c1474n.f912c.m781f();
        }
    }
}
