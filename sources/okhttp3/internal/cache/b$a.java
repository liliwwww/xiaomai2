package okhttp3.internal.cache;

import android.taobao.windvane.connect.HttpConnector;
import android.taobao.windvane.packageapp.zipapp.utils.ZipAppConstants;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import okhttp3.k;
import okhttp3.n;
import okhttp3.p;
import tb.a42;
import tb.cp;
import tb.e42;
import tb.q92;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public class b$a {
    final long a;
    final n b;
    final p c;
    private Date d;
    private String e;
    private Date f;
    private String g;
    private Date h;
    private long i;
    private long j;
    private String k;
    private int l;

    public b$a(long j, n nVar, p pVar) {
        this.l = -1;
        this.a = j;
        this.b = nVar;
        this.c = pVar;
        if (pVar != null) {
            this.i = pVar.p();
            this.j = pVar.n();
            k j2 = pVar.j();
            int h = j2.h();
            for (int i = 0; i < h; i++) {
                String e = j2.e(i);
                String i2 = j2.i(i);
                if ("Date".equalsIgnoreCase(e)) {
                    this.d = a42.b(i2);
                    this.e = i2;
                } else if ("Expires".equalsIgnoreCase(e)) {
                    this.h = a42.b(i2);
                } else if ("Last-Modified".equalsIgnoreCase(e)) {
                    this.f = a42.b(i2);
                    this.g = i2;
                } else if ("ETag".equalsIgnoreCase(e)) {
                    this.k = i2;
                } else if ("Age".equalsIgnoreCase(e)) {
                    this.l = e42.d(i2, -1);
                }
            }
        }
    }

    private long a() {
        Date date = this.d;
        long max = date != null ? Math.max(0L, this.j - date.getTime()) : 0L;
        int i = this.l;
        if (i != -1) {
            max = Math.max(max, TimeUnit.SECONDS.toMillis(i));
        }
        long j = this.j;
        return max + (j - this.i) + (this.a - j);
    }

    private long b() {
        if (this.c.c().d() != -1) {
            return TimeUnit.SECONDS.toMillis(r0.d());
        }
        if (this.h != null) {
            Date date = this.d;
            long time = this.h.getTime() - (date != null ? date.getTime() : this.j);
            if (time > 0) {
                return time;
            }
            return 0L;
        }
        if (this.f == null || this.c.o().h().y() != null) {
            return 0L;
        }
        Date date2 = this.d;
        long time2 = (date2 != null ? date2.getTime() : this.i) - this.f.getTime();
        if (time2 > 0) {
            return time2 / 10;
        }
        return 0L;
    }

    private b d() {
        if (this.c == null) {
            return new b(this.b, (p) null);
        }
        if (this.b.e() && this.c.f() == null) {
            return new b(this.b, (p) null);
        }
        if (!b.a(this.c, this.b)) {
            return new b(this.b, (p) null);
        }
        cp b = this.b.b();
        if (b.h() || e(this.b)) {
            return new b(this.b, (p) null);
        }
        cp c = this.c.c();
        long a = a();
        long b2 = b();
        if (b.d() != -1) {
            b2 = Math.min(b2, TimeUnit.SECONDS.toMillis(b.d()));
        }
        long j = 0;
        long millis = b.f() != -1 ? TimeUnit.SECONDS.toMillis(b.f()) : 0L;
        if (!c.g() && b.e() != -1) {
            j = TimeUnit.SECONDS.toMillis(b.e());
        }
        if (!c.h()) {
            long j2 = millis + a;
            if (j2 < j + b2) {
                p.a l = this.c.l();
                if (j2 >= b2) {
                    l.a("Warning", "110 HttpURLConnection \"Response is stale\"");
                }
                if (a > ZipAppConstants.UPDATEGROUPID_AGE && f()) {
                    l.a("Warning", "113 HttpURLConnection \"Heuristic expiration\"");
                }
                return new b((n) null, l.c());
            }
        }
        String str = this.k;
        String str2 = HttpConnector.IF_MODIFY_SINCE;
        if (str != null) {
            str2 = HttpConnector.IF_NONE_MATCH;
        } else if (this.f != null) {
            str = this.g;
        } else {
            if (this.d == null) {
                return new b(this.b, (p) null);
            }
            str = this.e;
        }
        k.a f = this.b.d().f();
        q92.a.b(f, str2, str);
        return new b(this.b.g().d(f.e()).a(), this.c);
    }

    private static boolean e(n nVar) {
        return (nVar.c(HttpConnector.IF_MODIFY_SINCE) == null && nVar.c(HttpConnector.IF_NONE_MATCH) == null) ? false : true;
    }

    private boolean f() {
        return this.c.c().d() == -1 && this.h == null;
    }

    public b c() {
        b d = d();
        return (d.a == null || !this.b.b().j()) ? d : new b((n) null, (p) null);
    }
}
