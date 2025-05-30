package okhttp3.internal.connection;

import androidx.compose.animation.core.AnimationKt;
import java.io.IOException;
import java.lang.ref.Reference;
import java.net.Proxy;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import okhttp3.C1412a;
import okhttp3.C1478r;
import okhttp3.internal.C1421a;
import okhttp3.internal.connection.C1433i;
import tb.iv3;
import tb.r84;

/* compiled from: Taobao */
/* renamed from: okhttp3.internal.connection.f */
/* loaded from: classes2.dex */
public final class C1430f {

    /* renamed from: g */
    private static final Executor f639g = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), C1421a.m459I("OkHttp ConnectionPool", true));

    /* renamed from: a */
    private final int f640a;

    /* renamed from: b */
    private final long f641b;

    /* renamed from: c */
    private final Runnable f642c = new r84(this);

    /* renamed from: d */
    private final Deque<C1429e> f643d = new ArrayDeque();

    /* renamed from: e */
    final C1431g f644e = new C1431g();

    /* renamed from: f */
    boolean f645f;

    public C1430f(int i, long j, TimeUnit timeUnit) {
        this.f640a = i;
        this.f641b = timeUnit.toNanos(j);
        if (j > 0) {
            return;
        }
        throw new IllegalArgumentException("keepAliveDuration <= 0: " + j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public /* synthetic */ void m554e() {
        while (true) {
            long m556b = m556b(System.nanoTime());
            if (m556b == -1) {
                return;
            }
            if (m556b > 0) {
                long j = m556b / AnimationKt.MillisToNanos;
                long j2 = m556b - (AnimationKt.MillisToNanos * j);
                synchronized (this) {
                    try {
                        wait(j, (int) j2);
                    } catch (InterruptedException unused) {
                    }
                }
            }
        }
    }

    /* renamed from: f */
    private int m555f(C1429e c1429e, long j) {
        List<Reference<C1433i>> list = c1429e.f636o;
        int i = 0;
        while (i < list.size()) {
            Reference<C1433i> reference = list.get(i);
            if (reference.get() != null) {
                i++;
            } else {
                iv3.j().q("A connection to " + c1429e.route().m914a().m404l() + " was leaked. Did you forget to close a response body?", ((C1433i.b) reference).f673a);
                list.remove(i);
                c1429e.f631j = true;
                if (list.isEmpty()) {
                    c1429e.f637p = j - this.f641b;
                    return 0;
                }
            }
        }
        return list.size();
    }

    /* renamed from: b */
    long m556b(long j) {
        synchronized (this) {
            C1429e c1429e = null;
            long j2 = Long.MIN_VALUE;
            int i = 0;
            int i2 = 0;
            for (C1429e c1429e2 : this.f643d) {
                if (m555f(c1429e2, j) > 0) {
                    i2++;
                } else {
                    i++;
                    long j3 = j - c1429e2.f637p;
                    if (j3 > j2) {
                        c1429e = c1429e2;
                        j2 = j3;
                    }
                }
            }
            long j4 = this.f641b;
            if (j2 < j4 && i <= this.f640a) {
                if (i > 0) {
                    return j4 - j2;
                }
                if (i2 > 0) {
                    return j4;
                }
                this.f645f = false;
                return -1L;
            }
            this.f643d.remove(c1429e);
            C1421a.m471h(c1429e.socket());
            return 0L;
        }
    }

    /* renamed from: c */
    public void m557c(C1478r c1478r, IOException iOException) {
        if (c1478r.m915b().type() != Proxy.Type.DIRECT) {
            C1412a m914a = c1478r.m914a();
            m914a.m401i().connectFailed(m914a.m404l().m809D(), c1478r.m915b().address(), iOException);
        }
        this.f644e.m562b(c1478r);
    }

    /* renamed from: d */
    boolean m558d(C1429e c1429e) {
        if (c1429e.f631j || this.f640a == 0) {
            this.f643d.remove(c1429e);
            return true;
        }
        notifyAll();
        return false;
    }

    /* renamed from: g */
    void m559g(C1429e c1429e) {
        if (!this.f645f) {
            this.f645f = true;
            f639g.execute(this.f642c);
        }
        this.f643d.add(c1429e);
    }

    /* renamed from: h */
    boolean m560h(C1412a c1412a, C1433i c1433i, @Nullable List<C1478r> list, boolean z) {
        for (C1429e c1429e : this.f643d) {
            if (!z || c1429e.m547m()) {
                if (c1429e.m545k(c1412a, list)) {
                    c1433i.m577a(c1429e);
                    return true;
                }
            }
        }
        return false;
    }
}
