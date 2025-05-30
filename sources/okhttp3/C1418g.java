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
import okhttp3.internal.C1421a;

/* compiled from: Taobao */
/* renamed from: okhttp3.g */
/* loaded from: classes2.dex */
public final class C1418g {

    /* renamed from: c */
    @Nullable
    private Runnable f557c;

    /* renamed from: d */
    @Nullable
    private ExecutorService f558d;

    /* renamed from: a */
    private int f555a = 64;

    /* renamed from: b */
    private int f556b = 5;

    /* renamed from: e */
    private final Deque<RealCall.AsyncCall> f559e = new ArrayDeque();

    /* renamed from: f */
    private final Deque<RealCall.AsyncCall> f560f = new ArrayDeque();

    /* renamed from: g */
    private final Deque<RealCall> f561g = new ArrayDeque();

    @Nullable
    /* renamed from: d */
    private RealCall.AsyncCall m434d(String str) {
        for (RealCall.AsyncCall asyncCall : this.f560f) {
            if (asyncCall.host().equals(str)) {
                return asyncCall;
            }
        }
        for (RealCall.AsyncCall asyncCall2 : this.f559e) {
            if (asyncCall2.host().equals(str)) {
                return asyncCall2;
            }
        }
        return null;
    }

    /* renamed from: e */
    private <T> void m435e(Deque<T> deque, T t) {
        Runnable runnable;
        synchronized (this) {
            if (!deque.remove(t)) {
                throw new AssertionError("Call wasn't in-flight!");
            }
            runnable = this.f557c;
        }
        if (m436h() || runnable == null) {
            return;
        }
        runnable.run();
    }

    /* renamed from: h */
    private boolean m436h() {
        int i;
        boolean z;
        ArrayList arrayList = new ArrayList();
        synchronized (this) {
            Iterator<RealCall.AsyncCall> it = this.f559e.iterator();
            while (it.hasNext()) {
                RealCall.AsyncCall next = it.next();
                if (this.f560f.size() >= this.f555a) {
                    break;
                }
                if (next.callsPerHost().get() < this.f556b) {
                    it.remove();
                    next.callsPerHost().incrementAndGet();
                    arrayList.add(next);
                    this.f560f.add(next);
                }
            }
            z = m442i() > 0;
        }
        int size = arrayList.size();
        for (i = 0; i < size; i++) {
            ((RealCall.AsyncCall) arrayList.get(i)).executeOn(m439c());
        }
        return z;
    }

    /* renamed from: a */
    void m437a(RealCall.AsyncCall asyncCall) {
        RealCall.AsyncCall m434d;
        synchronized (this) {
            this.f559e.add(asyncCall);
            if (!asyncCall.get().forWebSocket && (m434d = m434d(asyncCall.host())) != null) {
                asyncCall.reuseCallsPerHostFrom(m434d);
            }
        }
        m436h();
    }

    /* renamed from: b */
    synchronized void m438b(RealCall realCall) {
        this.f561g.add(realCall);
    }

    /* renamed from: c */
    public synchronized ExecutorService m439c() {
        if (this.f558d == null) {
            this.f558d = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue(), C1421a.m459I("OkHttp Dispatcher", false));
        }
        return this.f558d;
    }

    /* renamed from: f */
    void m440f(RealCall.AsyncCall asyncCall) {
        asyncCall.callsPerHost().decrementAndGet();
        m435e(this.f560f, asyncCall);
    }

    /* renamed from: g */
    void m441g(RealCall realCall) {
        m435e(this.f561g, realCall);
    }

    /* renamed from: i */
    public synchronized int m442i() {
        return this.f560f.size() + this.f561g.size();
    }
}
