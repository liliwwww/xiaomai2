package okhttp3;

import java.io.Closeable;
import javax.annotation.Nullable;
import okhttp3.C1471k;
import okhttp3.internal.connection.C1427c;
import tb.cp;

/* compiled from: Taobao */
/* renamed from: okhttp3.p */
/* loaded from: classes2.dex */
public final class C1476p implements Closeable {

    /* renamed from: a */
    final C1474n f925a;

    /* renamed from: b */
    final Protocol f926b;

    /* renamed from: c */
    final int f927c;

    /* renamed from: d */
    final String f928d;

    /* renamed from: e */
    @Nullable
    final C1470j f929e;

    /* renamed from: f */
    final C1471k f930f;

    /* renamed from: g */
    @Nullable
    final AbstractC1477q f931g;

    /* renamed from: h */
    @Nullable
    final C1476p f932h;

    /* renamed from: i */
    @Nullable
    final C1476p f933i;

    /* renamed from: j */
    @Nullable
    final C1476p f934j;

    /* renamed from: k */
    final long f935k;

    /* renamed from: l */
    final long f936l;

    /* renamed from: m */
    @Nullable
    final C1427c f937m;

    /* renamed from: n */
    @Nullable
    private volatile cp f938n;

    C1476p(a aVar) {
        this.f925a = aVar.f939a;
        this.f926b = aVar.f940b;
        this.f927c = aVar.f941c;
        this.f928d = aVar.f942d;
        this.f929e = aVar.f943e;
        this.f930f = aVar.f944f.m789e();
        this.f931g = aVar.f945g;
        this.f932h = aVar.f946h;
        this.f933i = aVar.f947i;
        this.f934j = aVar.f948j;
        this.f935k = aVar.f949k;
        this.f936l = aVar.f950l;
        this.f937m = aVar.f951m;
    }

    @Nullable
    /* renamed from: a */
    public AbstractC1477q m873a() {
        return this.f931g;
    }

    /* renamed from: c */
    public cp m874c() {
        cp cpVar = this.f938n;
        if (cpVar != null) {
            return cpVar;
        }
        cp k = cp.k(this.f930f);
        this.f938n = k;
        return k;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        AbstractC1477q abstractC1477q = this.f931g;
        if (abstractC1477q == null) {
            throw new IllegalStateException("response is not eligible for a body and must not be closed");
        }
        abstractC1477q.close();
    }

    /* renamed from: e */
    public int m875e() {
        return this.f927c;
    }

    @Nullable
    /* renamed from: f */
    public C1470j m876f() {
        return this.f929e;
    }

    @Nullable
    /* renamed from: g */
    public String m877g(String str) {
        return m878h(str, null);
    }

    @Nullable
    /* renamed from: h */
    public String m878h(String str, @Nullable String str2) {
        String m779c = this.f930f.m779c(str);
        return m779c != null ? m779c : str2;
    }

    public boolean isSuccessful() {
        int i = this.f927c;
        return i >= 200 && i < 300;
    }

    /* renamed from: j */
    public C1471k m879j() {
        return this.f930f;
    }

    /* renamed from: k */
    public String m880k() {
        return this.f928d;
    }

    /* renamed from: l */
    public a m881l() {
        return new a(this);
    }

    @Nullable
    /* renamed from: m */
    public C1476p m882m() {
        return this.f934j;
    }

    /* renamed from: n */
    public long m883n() {
        return this.f936l;
    }

    /* renamed from: o */
    public C1474n m884o() {
        return this.f925a;
    }

    /* renamed from: p */
    public long m885p() {
        return this.f935k;
    }

    public String toString() {
        return "Response{protocol=" + this.f926b + ", code=" + this.f927c + ", message=" + this.f928d + ", url=" + this.f925a.m858h() + '}';
    }

    /* compiled from: Taobao */
    /* renamed from: okhttp3.p$a */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a */
        @Nullable
        C1474n f939a;

        /* renamed from: b */
        @Nullable
        Protocol f940b;

        /* renamed from: c */
        int f941c;

        /* renamed from: d */
        String f942d;

        /* renamed from: e */
        @Nullable
        C1470j f943e;

        /* renamed from: f */
        C1471k.a f944f;

        /* renamed from: g */
        @Nullable
        AbstractC1477q f945g;

        /* renamed from: h */
        @Nullable
        C1476p f946h;

        /* renamed from: i */
        @Nullable
        C1476p f947i;

        /* renamed from: j */
        @Nullable
        C1476p f948j;

        /* renamed from: k */
        long f949k;

        /* renamed from: l */
        long f950l;

        /* renamed from: m */
        @Nullable
        C1427c f951m;

        public a() {
            this.f941c = -1;
            this.f944f = new C1471k.a();
        }

        /* renamed from: e */
        private void m886e(C1476p c1476p) {
            if (c1476p.f931g != null) {
                throw new IllegalArgumentException("priorResponse.body != null");
            }
        }

        /* renamed from: f */
        private void m887f(String str, C1476p c1476p) {
            if (c1476p.f931g != null) {
                throw new IllegalArgumentException(str + ".body != null");
            }
            if (c1476p.f932h != null) {
                throw new IllegalArgumentException(str + ".networkResponse != null");
            }
            if (c1476p.f933i != null) {
                throw new IllegalArgumentException(str + ".cacheResponse != null");
            }
            if (c1476p.f934j == null) {
                return;
            }
            throw new IllegalArgumentException(str + ".priorResponse != null");
        }

        /* renamed from: a */
        public a m888a(String str, String str2) {
            this.f944f.m785a(str, str2);
            return this;
        }

        /* renamed from: b */
        public a m889b(@Nullable AbstractC1477q abstractC1477q) {
            this.f945g = abstractC1477q;
            return this;
        }

        /* renamed from: c */
        public C1476p m890c() {
            if (this.f939a == null) {
                throw new IllegalStateException("request == null");
            }
            if (this.f940b == null) {
                throw new IllegalStateException("protocol == null");
            }
            if (this.f941c >= 0) {
                if (this.f942d != null) {
                    return new C1476p(this);
                }
                throw new IllegalStateException("message == null");
            }
            throw new IllegalStateException("code < 0: " + this.f941c);
        }

        /* renamed from: d */
        public a m891d(@Nullable C1476p c1476p) {
            if (c1476p != null) {
                m887f("cacheResponse", c1476p);
            }
            this.f947i = c1476p;
            return this;
        }

        /* renamed from: g */
        public a m892g(int i) {
            this.f941c = i;
            return this;
        }

        /* renamed from: h */
        public a m893h(@Nullable C1470j c1470j) {
            this.f943e = c1470j;
            return this;
        }

        /* renamed from: i */
        public a m894i(String str, String str2) {
            this.f944f.m791g(str, str2);
            return this;
        }

        /* renamed from: j */
        public a m895j(C1471k c1471k) {
            this.f944f = c1471k.m781f();
            return this;
        }

        /* renamed from: k */
        void m896k(C1427c c1427c) {
            this.f951m = c1427c;
        }

        /* renamed from: l */
        public a m897l(String str) {
            this.f942d = str;
            return this;
        }

        /* renamed from: m */
        public a m898m(@Nullable C1476p c1476p) {
            if (c1476p != null) {
                m887f("networkResponse", c1476p);
            }
            this.f946h = c1476p;
            return this;
        }

        /* renamed from: n */
        public a m899n(@Nullable C1476p c1476p) {
            if (c1476p != null) {
                m886e(c1476p);
            }
            this.f948j = c1476p;
            return this;
        }

        /* renamed from: o */
        public a m900o(Protocol protocol) {
            this.f940b = protocol;
            return this;
        }

        /* renamed from: p */
        public a m901p(long j) {
            this.f950l = j;
            return this;
        }

        /* renamed from: q */
        public a m902q(C1474n c1474n) {
            this.f939a = c1474n;
            return this;
        }

        /* renamed from: r */
        public a m903r(long j) {
            this.f949k = j;
            return this;
        }

        a(C1476p c1476p) {
            this.f941c = -1;
            this.f939a = c1476p.f925a;
            this.f940b = c1476p.f926b;
            this.f941c = c1476p.f927c;
            this.f942d = c1476p.f928d;
            this.f943e = c1476p.f929e;
            this.f944f = c1476p.f930f.m781f();
            this.f945g = c1476p.f931g;
            this.f946h = c1476p.f932h;
            this.f947i = c1476p.f933i;
            this.f948j = c1476p.f934j;
            this.f949k = c1476p.f935k;
            this.f950l = c1476p.f936l;
            this.f951m = c1476p.f937m;
        }
    }
}
