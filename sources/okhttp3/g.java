package okhttp3;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import okhttp3.RealCall;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class g {

    @Nullable
    private Runnable c;

    @Nullable
    private ExecutorService d;
    private int a = 64;
    private int b = 5;
    private final Deque<RealCall.AsyncCall> e = new ArrayDeque();
    private final Deque<RealCall.AsyncCall> f = new ArrayDeque();
    private final Deque<RealCall> g = new ArrayDeque();

    @Nullable
    private RealCall.AsyncCall d(String str) {
        for (RealCall.AsyncCall asyncCall : this.f) {
            if (asyncCall.host().equals(str)) {
                return asyncCall;
            }
        }
        for (RealCall.AsyncCall asyncCall2 : this.e) {
            if (asyncCall2.host().equals(str)) {
                return asyncCall2;
            }
        }
        return null;
    }

    private <T> void e(Deque<T> deque, T t) {
        Runnable runnable;
        synchronized (this) {
            if (!deque.remove(t)) {
                throw new AssertionError("Call wasn't in-flight!");
            }
            runnable = this.c;
        }
        if (h() || runnable == null) {
            return;
        }
        runnable.run();
    }

    private boolean h() {
        int i;
        boolean z;
        ArrayList arrayList = new ArrayList();
        synchronized (this) {
            Iterator<RealCall.AsyncCall> it = this.e.iterator();
            while (it.hasNext()) {
                RealCall.AsyncCall next = it.next();
                if (this.f.size() >= this.a) {
                    break;
                }
                if (next.callsPerHost().get() < this.b) {
                    it.remove();
                    next.callsPerHost().incrementAndGet();
                    arrayList.add(next);
                    this.f.add(next);
                }
            }
            z = i() > 0;
        }
        int size = arrayList.size();
        for (i = 0; i < size; i++) {
            ((RealCall.AsyncCall) arrayList.get(i)).executeOn(c());
        }
        return z;
    }

    void a(RealCall.AsyncCall asyncCall) {
        RealCall.AsyncCall d;
        synchronized (this) {
            this.e.add(asyncCall);
            if (!asyncCall.get().forWebSocket && (d = d(asyncCall.host())) != null) {
                asyncCall.reuseCallsPerHostFrom(d);
            }
        }
        h();
    }

    synchronized void b(RealCall realCall) {
        this.g.add(realCall);
    }

    public synchronized ExecutorService c() {
        if (this.d == null) {
            this.d = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue(), okhttp3.internal.a.I("OkHttp Dispatcher", false));
        }
        return this.d;
    }

    void f(RealCall.AsyncCall asyncCall) {
        asyncCall.callsPerHost().decrementAndGet();
        e(this.f, asyncCall);
    }

    void g(RealCall realCall) {
        e(this.g, realCall);
    }

    public synchronized int i() {
        return this.f.size() + this.g.size();
    }
}
