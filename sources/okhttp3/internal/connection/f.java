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
import okhttp3.internal.connection.i;
import okhttp3.r;
import tb.iv3;
import tb.r84;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class f {
    private static final Executor g = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), okhttp3.internal.a.I("OkHttp ConnectionPool", true));
    private final int a;
    private final long b;
    private final Runnable c = new r84(this);
    private final Deque<e> d = new ArrayDeque();
    final g e = new g();
    boolean f;

    public f(int i, long j, TimeUnit timeUnit) {
        this.a = i;
        this.b = timeUnit.toNanos(j);
        if (j > 0) {
            return;
        }
        throw new IllegalArgumentException("keepAliveDuration <= 0: " + j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e() {
        while (true) {
            long b = b(System.nanoTime());
            if (b == -1) {
                return;
            }
            if (b > 0) {
                long j = b / AnimationKt.MillisToNanos;
                long j2 = b - (AnimationKt.MillisToNanos * j);
                synchronized (this) {
                    try {
                        wait(j, (int) j2);
                    } catch (InterruptedException unused) {
                    }
                }
            }
        }
    }

    private int f(e eVar, long j) {
        List<Reference<i>> list = eVar.o;
        int i = 0;
        while (i < list.size()) {
            i.b bVar = (Reference) list.get(i);
            if (bVar.get() != null) {
                i++;
            } else {
                iv3.j().q("A connection to " + eVar.route().a().l() + " was leaked. Did you forget to close a response body?", bVar.a);
                list.remove(i);
                eVar.j = true;
                if (list.isEmpty()) {
                    eVar.p = j - this.b;
                    return 0;
                }
            }
        }
        return list.size();
    }

    long b(long j) {
        synchronized (this) {
            e eVar = null;
            long j2 = Long.MIN_VALUE;
            int i = 0;
            int i2 = 0;
            for (e eVar2 : this.d) {
                if (f(eVar2, j) > 0) {
                    i2++;
                } else {
                    i++;
                    long j3 = j - eVar2.p;
                    if (j3 > j2) {
                        eVar = eVar2;
                        j2 = j3;
                    }
                }
            }
            long j4 = this.b;
            if (j2 < j4 && i <= this.a) {
                if (i > 0) {
                    return j4 - j2;
                }
                if (i2 > 0) {
                    return j4;
                }
                this.f = false;
                return -1L;
            }
            this.d.remove(eVar);
            okhttp3.internal.a.h(eVar.socket());
            return 0L;
        }
    }

    public void c(r rVar, IOException iOException) {
        if (rVar.b().type() != Proxy.Type.DIRECT) {
            okhttp3.a a = rVar.a();
            a.i().connectFailed(a.l().D(), rVar.b().address(), iOException);
        }
        this.e.b(rVar);
    }

    boolean d(e eVar) {
        if (eVar.j || this.a == 0) {
            this.d.remove(eVar);
            return true;
        }
        notifyAll();
        return false;
    }

    void g(e eVar) {
        if (!this.f) {
            this.f = true;
            g.execute(this.c);
        }
        this.d.add(eVar);
    }

    boolean h(okhttp3.a aVar, i iVar, @Nullable List<r> list, boolean z) {
        for (e eVar : this.d) {
            if (!z || eVar.m()) {
                if (eVar.k(aVar, list)) {
                    iVar.a(eVar);
                    return true;
                }
            }
        }
        return false;
    }
}
