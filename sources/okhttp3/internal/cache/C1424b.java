package okhttp3.internal.cache;

import android.taobao.windvane.connect.HttpConnector;
import android.taobao.windvane.packageapp.zipapp.utils.ZipAppConstants;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import okhttp3.C1471k;
import okhttp3.C1474n;
import okhttp3.C1476p;
import tb.a42;
import tb.cp;
import tb.e42;
import tb.q92;

/* compiled from: Taobao */
/* renamed from: okhttp3.internal.cache.b */
/* loaded from: classes.dex */
public final class C1424b {

    /* renamed from: a */
    @Nullable
    public final C1474n f578a;

    /* renamed from: b */
    @Nullable
    public final C1476p f579b;

    /* compiled from: Taobao */
    /* renamed from: okhttp3.internal.cache.b$a */
    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: a */
        final long f580a;

        /* renamed from: b */
        final C1474n f581b;

        /* renamed from: c */
        final C1476p f582c;

        /* renamed from: d */
        private Date f583d;

        /* renamed from: e */
        private String f584e;

        /* renamed from: f */
        private Date f585f;

        /* renamed from: g */
        private String f586g;

        /* renamed from: h */
        private Date f587h;

        /* renamed from: i */
        private long f588i;

        /* renamed from: j */
        private long f589j;

        /* renamed from: k */
        private String f590k;

        /* renamed from: l */
        private int f591l;

        public a(long j, C1474n c1474n, C1476p c1476p) {
            this.f591l = -1;
            this.f580a = j;
            this.f581b = c1474n;
            this.f582c = c1476p;
            if (c1476p != null) {
                this.f588i = c1476p.m885p();
                this.f589j = c1476p.m883n();
                C1471k m879j = c1476p.m879j();
                int m782h = m879j.m782h();
                for (int i = 0; i < m782h; i++) {
                    String m780e = m879j.m780e(i);
                    String m783i = m879j.m783i(i);
                    if ("Date".equalsIgnoreCase(m780e)) {
                        this.f583d = a42.b(m783i);
                        this.f584e = m783i;
                    } else if ("Expires".equalsIgnoreCase(m780e)) {
                        this.f587h = a42.b(m783i);
                    } else if ("Last-Modified".equalsIgnoreCase(m780e)) {
                        this.f585f = a42.b(m783i);
                        this.f586g = m783i;
                    } else if ("ETag".equalsIgnoreCase(m780e)) {
                        this.f590k = m783i;
                    } else if ("Age".equalsIgnoreCase(m780e)) {
                        this.f591l = e42.d(m783i, -1);
                    }
                }
            }
        }

        /* renamed from: a */
        private long m496a() {
            Date date = this.f583d;
            long max = date != null ? Math.max(0L, this.f589j - date.getTime()) : 0L;
            int i = this.f591l;
            if (i != -1) {
                max = Math.max(max, TimeUnit.SECONDS.toMillis(i));
            }
            long j = this.f589j;
            return max + (j - this.f588i) + (this.f580a - j);
        }

        /* renamed from: b */
        private long m497b() {
            if (this.f582c.m874c().d() != -1) {
                return TimeUnit.SECONDS.toMillis(r0.d());
            }
            if (this.f587h != null) {
                Date date = this.f583d;
                long time = this.f587h.getTime() - (date != null ? date.getTime() : this.f589j);
                if (time > 0) {
                    return time;
                }
                return 0L;
            }
            if (this.f585f == null || this.f582c.m884o().m858h().m821y() != null) {
                return 0L;
            }
            Date date2 = this.f583d;
            long time2 = (date2 != null ? date2.getTime() : this.f588i) - this.f585f.getTime();
            if (time2 > 0) {
                return time2 / 10;
            }
            return 0L;
        }

        /* renamed from: d */
        private C1424b m498d() {
            if (this.f582c == null) {
                return new C1424b(this.f581b, null);
            }
            if (this.f581b.m855e() && this.f582c.m876f() == null) {
                return new C1424b(this.f581b, null);
            }
            if (!C1424b.m495a(this.f582c, this.f581b)) {
                return new C1424b(this.f581b, null);
            }
            cp m852b = this.f581b.m852b();
            if (m852b.h() || m499e(this.f581b)) {
                return new C1424b(this.f581b, null);
            }
            cp m874c = this.f582c.m874c();
            long m496a = m496a();
            long m497b = m497b();
            if (m852b.d() != -1) {
                m497b = Math.min(m497b, TimeUnit.SECONDS.toMillis(m852b.d()));
            }
            long j = 0;
            long millis = m852b.f() != -1 ? TimeUnit.SECONDS.toMillis(m852b.f()) : 0L;
            if (!m874c.g() && m852b.e() != -1) {
                j = TimeUnit.SECONDS.toMillis(m852b.e());
            }
            if (!m874c.h()) {
                long j2 = millis + m496a;
                if (j2 < j + m497b) {
                    C1476p.a m881l = this.f582c.m881l();
                    if (j2 >= m497b) {
                        m881l.m888a("Warning", "110 HttpURLConnection \"Response is stale\"");
                    }
                    if (m496a > ZipAppConstants.UPDATEGROUPID_AGE && m500f()) {
                        m881l.m888a("Warning", "113 HttpURLConnection \"Heuristic expiration\"");
                    }
                    return new C1424b(null, m881l.m890c());
                }
            }
            String str = this.f590k;
            String str2 = HttpConnector.IF_MODIFY_SINCE;
            if (str != null) {
                str2 = HttpConnector.IF_NONE_MATCH;
            } else if (this.f585f != null) {
                str = this.f586g;
            } else {
                if (this.f583d == null) {
                    return new C1424b(this.f581b, null);
                }
                str = this.f584e;
            }
            C1471k.a m781f = this.f581b.m854d().m781f();
            q92.a.b(m781f, str2, str);
            return new C1424b(this.f581b.m857g().m862d(m781f.m789e()).m859a(), this.f582c);
        }

        /* renamed from: e */
        private static boolean m499e(C1474n c1474n) {
            return (c1474n.m853c(HttpConnector.IF_MODIFY_SINCE) == null && c1474n.m853c(HttpConnector.IF_NONE_MATCH) == null) ? false : true;
        }

        /* renamed from: f */
        private boolean m500f() {
            return this.f582c.m874c().d() == -1 && this.f587h == null;
        }

        /* renamed from: c */
        public C1424b m501c() {
            C1424b m498d = m498d();
            return (m498d.f578a == null || !this.f581b.m852b().j()) ? m498d : new C1424b(null, null);
        }
    }

    C1424b(C1474n c1474n, C1476p c1476p) {
        this.f578a = c1474n;
        this.f579b = c1476p;
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0056, code lost:
    
        if (r3.m874c().b() == false) goto L33;
     */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean m495a(okhttp3.C1476p r3, okhttp3.C1474n r4) {
        /*
            int r0 = r3.m875e()
            r1 = 200(0xc8, float:2.8E-43)
            r2 = 0
            if (r0 == r1) goto L5a
            r1 = 410(0x19a, float:5.75E-43)
            if (r0 == r1) goto L5a
            r1 = 414(0x19e, float:5.8E-43)
            if (r0 == r1) goto L5a
            r1 = 501(0x1f5, float:7.02E-43)
            if (r0 == r1) goto L5a
            r1 = 203(0xcb, float:2.84E-43)
            if (r0 == r1) goto L5a
            r1 = 204(0xcc, float:2.86E-43)
            if (r0 == r1) goto L5a
            r1 = 307(0x133, float:4.3E-43)
            if (r0 == r1) goto L31
            r1 = 308(0x134, float:4.32E-43)
            if (r0 == r1) goto L5a
            r1 = 404(0x194, float:5.66E-43)
            if (r0 == r1) goto L5a
            r1 = 405(0x195, float:5.68E-43)
            if (r0 == r1) goto L5a
            switch(r0) {
                case 300: goto L5a;
                case 301: goto L5a;
                case 302: goto L31;
                default: goto L30;
            }
        L30:
            goto L59
        L31:
            java.lang.String r0 = "Expires"
            java.lang.String r0 = r3.m877g(r0)
            if (r0 != 0) goto L5a
            tb.cp r0 = r3.m874c()
            int r0 = r0.d()
            r1 = -1
            if (r0 != r1) goto L5a
            tb.cp r0 = r3.m874c()
            boolean r0 = r0.c()
            if (r0 != 0) goto L5a
            tb.cp r0 = r3.m874c()
            boolean r0 = r0.b()
            if (r0 == 0) goto L59
            goto L5a
        L59:
            return r2
        L5a:
            tb.cp r3 = r3.m874c()
            boolean r3 = r3.i()
            if (r3 != 0) goto L6f
            tb.cp r3 = r4.m852b()
            boolean r3 = r3.i()
            if (r3 != 0) goto L6f
            r2 = 1
        L6f:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.cache.C1424b.m495a(okhttp3.p, okhttp3.n):boolean");
    }
}
