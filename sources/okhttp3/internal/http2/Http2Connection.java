package okhttp3.internal.http2;

import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.inputmethod.EditorInfoCompat;
import java.io.Closeable;
import java.io.IOException;
import java.net.Socket;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import okhttp3.internal.NamedRunnable;
import okhttp3.internal.http2.Http2Reader;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;
import tb.iv3;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class Http2Connection implements Closeable {
    private static final ExecutorService y = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), okhttp3.internal.a.I("OkHttp Http2Connection", true));
    final boolean a;
    final b b;
    final String d;
    int e;
    int f;
    private boolean g;
    private final ScheduledExecutorService h;
    private final ExecutorService i;
    final PushObserver j;
    long r;
    final h t;
    final Socket u;
    final f v;
    final ReaderRunnable w;
    final Set<Integer> x;
    final Map<Integer, e> c = new LinkedHashMap();
    private long k = 0;
    private long l = 0;
    private long m = 0;
    private long n = 0;
    private long o = 0;
    private long p = 0;
    long q = 0;
    h s = new h();

    /* compiled from: Taobao */
    final class IntervalPingRunnable extends NamedRunnable {
        IntervalPingRunnable() {
            super("OkHttp %s ping", new Object[]{Http2Connection.this.d});
        }

        public void execute() {
            boolean z;
            synchronized (Http2Connection.this) {
                if (Http2Connection.this.l < Http2Connection.this.k) {
                    z = true;
                } else {
                    Http2Connection.e(Http2Connection.this);
                    z = false;
                }
            }
            if (z) {
                Http2Connection.this.o(null);
            } else {
                Http2Connection.this.I(false, 1, 0);
            }
        }
    }

    /* compiled from: Taobao */
    class ReaderRunnable extends NamedRunnable implements Http2Reader.Handler {
        final Http2Reader reader;

        ReaderRunnable(Http2Reader http2Reader) {
            super("OkHttp %s", new Object[]{Http2Connection.this.d});
            this.reader = http2Reader;
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void ackSettings() {
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void alternateService(int i, String str, ByteString byteString, String str2, int i2, long j) {
        }

        void applyAndAckSettings(boolean z, h hVar) {
            e[] eVarArr;
            long j;
            synchronized (Http2Connection.this.v) {
                synchronized (Http2Connection.this) {
                    int d = Http2Connection.this.t.d();
                    if (z) {
                        Http2Connection.this.t.a();
                    }
                    Http2Connection.this.t.h(hVar);
                    int d2 = Http2Connection.this.t.d();
                    eVarArr = null;
                    if (d2 == -1 || d2 == d) {
                        j = 0;
                    } else {
                        j = d2 - d;
                        if (!Http2Connection.this.c.isEmpty()) {
                            eVarArr = (e[]) Http2Connection.this.c.values().toArray(new e[Http2Connection.this.c.size()]);
                        }
                    }
                }
                try {
                    Http2Connection http2Connection = Http2Connection.this;
                    http2Connection.v.a(http2Connection.t);
                } catch (IOException e) {
                    Http2Connection.this.o(e);
                }
            }
            if (eVarArr != null) {
                for (e eVar : eVarArr) {
                    synchronized (eVar) {
                        eVar.a(j);
                    }
                }
            }
            Http2Connection.y.execute(new NamedRunnable("OkHttp %s settings", Http2Connection.this.d) { // from class: okhttp3.internal.http2.Http2Connection.ReaderRunnable.3
                public void execute() {
                    Http2Connection http2Connection2 = Http2Connection.this;
                    http2Connection2.b.a(http2Connection2);
                }
            });
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void data(boolean z, int i, BufferedSource bufferedSource, int i2) throws IOException {
            if (Http2Connection.this.z(i)) {
                Http2Connection.this.u(i, bufferedSource, i2, z);
                return;
            }
            e p = Http2Connection.this.p(i);
            if (p == null) {
                Http2Connection.this.K(i, ErrorCode.PROTOCOL_ERROR);
                long j = i2;
                Http2Connection.this.F(j);
                bufferedSource.skip(j);
                return;
            }
            p.m(bufferedSource, i2);
            if (z) {
                p.n(okhttp3.internal.a.EMPTY_HEADERS, true);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v0, types: [okhttp3.internal.http2.ErrorCode] */
        /* JADX WARN: Type inference failed for: r0v3 */
        /* JADX WARN: Type inference failed for: r0v5, types: [java.io.Closeable, okhttp3.internal.http2.Http2Reader] */
        protected void execute() {
            ErrorCode errorCode;
            ErrorCode errorCode2 = ErrorCode.INTERNAL_ERROR;
            IOException e = null;
            try {
                try {
                    this.reader.c(this);
                    while (this.reader.b(false, this)) {
                    }
                    ErrorCode errorCode3 = ErrorCode.NO_ERROR;
                    try {
                        Http2Connection.this.n(errorCode3, ErrorCode.CANCEL, null);
                        errorCode = errorCode3;
                    } catch (IOException e2) {
                        e = e2;
                        ErrorCode errorCode4 = ErrorCode.PROTOCOL_ERROR;
                        Http2Connection http2Connection = Http2Connection.this;
                        http2Connection.n(errorCode4, errorCode4, e);
                        errorCode = http2Connection;
                        errorCode2 = this.reader;
                        okhttp3.internal.a.g((Closeable) errorCode2);
                    }
                } catch (Throwable th) {
                    th = th;
                    Http2Connection.this.n(errorCode, errorCode2, e);
                    okhttp3.internal.a.g(this.reader);
                    throw th;
                }
            } catch (IOException e3) {
                e = e3;
            } catch (Throwable th2) {
                th = th2;
                errorCode = errorCode2;
                Http2Connection.this.n(errorCode, errorCode2, e);
                okhttp3.internal.a.g(this.reader);
                throw th;
            }
            errorCode2 = this.reader;
            okhttp3.internal.a.g((Closeable) errorCode2);
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void goAway(int i, ErrorCode errorCode, ByteString byteString) {
            e[] eVarArr;
            byteString.size();
            synchronized (Http2Connection.this) {
                eVarArr = (e[]) Http2Connection.this.c.values().toArray(new e[Http2Connection.this.c.size()]);
                Http2Connection.this.g = true;
            }
            for (e eVar : eVarArr) {
                if (eVar.g() > i && eVar.j()) {
                    eVar.o(ErrorCode.REFUSED_STREAM);
                    Http2Connection.this.A(eVar.g());
                }
            }
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void headers(boolean z, int i, int i2, List<a> list) {
            if (Http2Connection.this.z(i)) {
                Http2Connection.this.w(i, list, z);
                return;
            }
            synchronized (Http2Connection.this) {
                e p = Http2Connection.this.p(i);
                if (p != null) {
                    p.n(okhttp3.internal.a.K(list), z);
                    return;
                }
                if (Http2Connection.this.g) {
                    return;
                }
                Http2Connection http2Connection = Http2Connection.this;
                if (i <= http2Connection.e) {
                    return;
                }
                if (i % 2 == http2Connection.f % 2) {
                    return;
                }
                final e eVar = new e(i, Http2Connection.this, false, z, okhttp3.internal.a.K(list));
                Http2Connection http2Connection2 = Http2Connection.this;
                http2Connection2.e = i;
                http2Connection2.c.put(Integer.valueOf(i), eVar);
                Http2Connection.y.execute(new NamedRunnable("OkHttp %s stream %d", new Object[]{Http2Connection.this.d, Integer.valueOf(i)}) { // from class: okhttp3.internal.http2.Http2Connection.ReaderRunnable.1
                    public void execute() {
                        try {
                            Http2Connection.this.b.b(eVar);
                        } catch (IOException e) {
                            iv3.j().p(4, "Http2Connection.Listener failure for " + Http2Connection.this.d, e);
                            try {
                                eVar.d(ErrorCode.PROTOCOL_ERROR, e);
                            } catch (IOException unused) {
                            }
                        }
                    }
                });
            }
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void ping(boolean z, int i, int i2) {
            if (!z) {
                try {
                    Http2Connection.this.h.execute(new PingRunnable(Http2Connection.this, true, i, i2));
                    return;
                } catch (RejectedExecutionException unused) {
                    return;
                }
            }
            synchronized (Http2Connection.this) {
                try {
                    if (i == 1) {
                        Http2Connection.c(Http2Connection.this);
                    } else if (i == 2) {
                        Http2Connection.l(Http2Connection.this);
                    } else if (i == 3) {
                        Http2Connection.m(Http2Connection.this);
                        Http2Connection.this.notifyAll();
                    }
                } finally {
                }
            }
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void priority(int i, int i2, int i3, boolean z) {
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void pushPromise(int i, int i2, List<a> list) {
            Http2Connection.this.x(i2, list);
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void rstStream(int i, ErrorCode errorCode) {
            if (Http2Connection.this.z(i)) {
                Http2Connection.this.y(i, errorCode);
                return;
            }
            e A = Http2Connection.this.A(i);
            if (A != null) {
                A.o(errorCode);
            }
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void settings(final boolean z, final h hVar) {
            try {
                Http2Connection.this.h.execute(new NamedRunnable("OkHttp %s ACK Settings", new Object[]{Http2Connection.this.d}) { // from class: okhttp3.internal.http2.Http2Connection.ReaderRunnable.2
                    public void execute() {
                        ReaderRunnable.this.applyAndAckSettings(z, hVar);
                    }
                });
            } catch (RejectedExecutionException unused) {
            }
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void windowUpdate(int i, long j) {
            if (i == 0) {
                synchronized (Http2Connection.this) {
                    Http2Connection http2Connection = Http2Connection.this;
                    http2Connection.r += j;
                    http2Connection.notifyAll();
                }
                return;
            }
            e p = Http2Connection.this.p(i);
            if (p != null) {
                synchronized (p) {
                    p.a(j);
                }
            }
        }
    }

    Http2Connection(a aVar) {
        h hVar = new h();
        this.t = hVar;
        this.x = new LinkedHashSet();
        this.j = aVar.f;
        boolean z = aVar.g;
        this.a = z;
        this.b = aVar.e;
        int i = z ? 1 : 2;
        this.f = i;
        if (z) {
            this.f = i + 2;
        }
        if (z) {
            this.s.i(7, EditorInfoCompat.IME_FLAG_NO_PERSONALIZED_LEARNING);
        }
        String str = aVar.b;
        this.d = str;
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1, okhttp3.internal.a.I(okhttp3.internal.a.q("OkHttp %s Writer", new Object[]{str}), false));
        this.h = scheduledThreadPoolExecutor;
        if (aVar.h != 0) {
            NamedRunnable intervalPingRunnable = new IntervalPingRunnable();
            int i2 = aVar.h;
            scheduledThreadPoolExecutor.scheduleAtFixedRate(intervalPingRunnable, i2, i2, TimeUnit.MILLISECONDS);
        }
        this.i = new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), okhttp3.internal.a.I(okhttp3.internal.a.q("OkHttp %s Push Observer", new Object[]{str}), true));
        hVar.i(7, 65535);
        hVar.i(5, AccessibilityNodeInfoCompat.ACTION_COPY);
        this.r = hVar.d();
        this.u = aVar.a;
        this.v = new f(aVar.d, z);
        this.w = new ReaderRunnable(new Http2Reader(aVar.c, z));
    }

    static /* synthetic */ long c(Http2Connection http2Connection) {
        long j = http2Connection.l;
        http2Connection.l = 1 + j;
        return j;
    }

    static /* synthetic */ long e(Http2Connection http2Connection) {
        long j = http2Connection.k;
        http2Connection.k = 1 + j;
        return j;
    }

    static /* synthetic */ long l(Http2Connection http2Connection) {
        long j = http2Connection.n;
        http2Connection.n = 1 + j;
        return j;
    }

    static /* synthetic */ long m(Http2Connection http2Connection) {
        long j = http2Connection.o;
        http2Connection.o = 1 + j;
        return j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(@Nullable IOException iOException) {
        ErrorCode errorCode = ErrorCode.PROTOCOL_ERROR;
        n(errorCode, errorCode, iOException);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0041 A[Catch: all -> 0x0073, TryCatch #0 {, blocks: (B:6:0x0007, B:8:0x000e, B:9:0x0013, B:11:0x0017, B:13:0x0029, B:15:0x0031, B:19:0x003b, B:21:0x0041, B:22:0x004a, B:36:0x006d, B:37:0x0072), top: B:5:0x0007, outer: #1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private okhttp3.internal.http2.e s(int r11, java.util.List<okhttp3.internal.http2.a> r12, boolean r13) throws java.io.IOException {
        /*
            r10 = this;
            r6 = r13 ^ 1
            r4 = 0
            okhttp3.internal.http2.f r7 = r10.v
            monitor-enter(r7)
            monitor-enter(r10)     // Catch: java.lang.Throwable -> L76
            int r0 = r10.f     // Catch: java.lang.Throwable -> L73
            r1 = 1073741823(0x3fffffff, float:1.9999999)
            if (r0 <= r1) goto L13
            okhttp3.internal.http2.ErrorCode r0 = okhttp3.internal.http2.ErrorCode.REFUSED_STREAM     // Catch: java.lang.Throwable -> L73
            r10.C(r0)     // Catch: java.lang.Throwable -> L73
        L13:
            boolean r0 = r10.g     // Catch: java.lang.Throwable -> L73
            if (r0 != 0) goto L6d
            int r8 = r10.f     // Catch: java.lang.Throwable -> L73
            int r0 = r8 + 2
            r10.f = r0     // Catch: java.lang.Throwable -> L73
            okhttp3.internal.http2.e r9 = new okhttp3.internal.http2.e     // Catch: java.lang.Throwable -> L73
            r5 = 0
            r0 = r9
            r1 = r8
            r2 = r10
            r3 = r6
            r0.<init>(r1, r2, r3, r4, r5)     // Catch: java.lang.Throwable -> L73
            if (r13 == 0) goto L3a
            long r0 = r10.r     // Catch: java.lang.Throwable -> L73
            r2 = 0
            int r13 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r13 == 0) goto L3a
            long r0 = r9.b     // Catch: java.lang.Throwable -> L73
            int r13 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r13 != 0) goto L38
            goto L3a
        L38:
            r13 = 0
            goto L3b
        L3a:
            r13 = 1
        L3b:
            boolean r0 = r9.k()     // Catch: java.lang.Throwable -> L73
            if (r0 == 0) goto L4a
            java.util.Map<java.lang.Integer, okhttp3.internal.http2.e> r0 = r10.c     // Catch: java.lang.Throwable -> L73
            java.lang.Integer r1 = java.lang.Integer.valueOf(r8)     // Catch: java.lang.Throwable -> L73
            r0.put(r1, r9)     // Catch: java.lang.Throwable -> L73
        L4a:
            monitor-exit(r10)     // Catch: java.lang.Throwable -> L73
            if (r11 != 0) goto L53
            okhttp3.internal.http2.f r11 = r10.v     // Catch: java.lang.Throwable -> L76
            r11.e(r6, r8, r12)     // Catch: java.lang.Throwable -> L76
            goto L5c
        L53:
            boolean r0 = r10.a     // Catch: java.lang.Throwable -> L76
            if (r0 != 0) goto L65
            okhttp3.internal.http2.f r0 = r10.v     // Catch: java.lang.Throwable -> L76
            r0.pushPromise(r11, r8, r12)     // Catch: java.lang.Throwable -> L76
        L5c:
            monitor-exit(r7)     // Catch: java.lang.Throwable -> L76
            if (r13 == 0) goto L64
            okhttp3.internal.http2.f r11 = r10.v
            r11.flush()
        L64:
            return r9
        L65:
            java.lang.IllegalArgumentException r11 = new java.lang.IllegalArgumentException     // Catch: java.lang.Throwable -> L76
            java.lang.String r12 = "client streams shouldn't have associated stream IDs"
            r11.<init>(r12)     // Catch: java.lang.Throwable -> L76
            throw r11     // Catch: java.lang.Throwable -> L76
        L6d:
            okhttp3.internal.http2.ConnectionShutdownException r11 = new okhttp3.internal.http2.ConnectionShutdownException     // Catch: java.lang.Throwable -> L73
            r11.<init>()     // Catch: java.lang.Throwable -> L73
            throw r11     // Catch: java.lang.Throwable -> L73
        L73:
            r11 = move-exception
            monitor-exit(r10)     // Catch: java.lang.Throwable -> L73
            throw r11     // Catch: java.lang.Throwable -> L76
        L76:
            r11 = move-exception
            monitor-exit(r7)     // Catch: java.lang.Throwable -> L76
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http2.Http2Connection.s(int, java.util.List, boolean):okhttp3.internal.http2.e");
    }

    private synchronized void v(NamedRunnable namedRunnable) {
        if (!this.g) {
            this.i.execute(namedRunnable);
        }
    }

    synchronized e A(int i) {
        e remove;
        remove = this.c.remove(Integer.valueOf(i));
        notifyAll();
        return remove;
    }

    void B() {
        synchronized (this) {
            long j = this.n;
            long j2 = this.m;
            if (j < j2) {
                return;
            }
            this.m = j2 + 1;
            this.p = System.nanoTime() + 1000000000;
            try {
                this.h.execute(new 3(this, "OkHttp %s ping", new Object[]{this.d}));
            } catch (RejectedExecutionException unused) {
            }
        }
    }

    public void C(ErrorCode errorCode) throws IOException {
        synchronized (this.v) {
            synchronized (this) {
                if (this.g) {
                    return;
                }
                this.g = true;
                this.v.d(this.e, errorCode, okhttp3.internal.a.EMPTY_BYTE_ARRAY);
            }
        }
    }

    public void D() throws IOException {
        E(true);
    }

    void E(boolean z) throws IOException {
        if (z) {
            this.v.connectionPreface();
            this.v.g(this.s);
            if (this.s.d() != 65535) {
                this.v.windowUpdate(0, r6 - 65535);
            }
        }
        new Thread((Runnable) this.w).start();
    }

    synchronized void F(long j) {
        long j2 = this.q + j;
        this.q = j2;
        if (j2 >= this.s.d() / 2) {
            L(0, this.q);
            this.q = 0L;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0030, code lost:
    
        r3 = java.lang.Math.min((int) java.lang.Math.min(r12, r3), r8.v.maxDataLength());
        r6 = r3;
        r8.r -= r6;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void G(int r9, boolean r10, okio.Buffer r11, long r12) throws java.io.IOException {
        /*
            r8 = this;
            r0 = 0
            r1 = 0
            int r3 = (r12 > r1 ? 1 : (r12 == r1 ? 0 : -1))
            if (r3 != 0) goto Ld
            okhttp3.internal.http2.f r12 = r8.v
            r12.data(r10, r9, r11, r0)
            return
        Ld:
            int r3 = (r12 > r1 ? 1 : (r12 == r1 ? 0 : -1))
            if (r3 <= 0) goto L67
            monitor-enter(r8)
        L12:
            long r3 = r8.r     // Catch: java.lang.Throwable -> L56 java.lang.InterruptedException -> L58
            int r5 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r5 > 0) goto L30
            java.util.Map<java.lang.Integer, okhttp3.internal.http2.e> r3 = r8.c     // Catch: java.lang.Throwable -> L56 java.lang.InterruptedException -> L58
            java.lang.Integer r4 = java.lang.Integer.valueOf(r9)     // Catch: java.lang.Throwable -> L56 java.lang.InterruptedException -> L58
            boolean r3 = r3.containsKey(r4)     // Catch: java.lang.Throwable -> L56 java.lang.InterruptedException -> L58
            if (r3 == 0) goto L28
            r8.wait()     // Catch: java.lang.Throwable -> L56 java.lang.InterruptedException -> L58
            goto L12
        L28:
            java.io.IOException r9 = new java.io.IOException     // Catch: java.lang.Throwable -> L56 java.lang.InterruptedException -> L58
            java.lang.String r10 = "stream closed"
            r9.<init>(r10)     // Catch: java.lang.Throwable -> L56 java.lang.InterruptedException -> L58
            throw r9     // Catch: java.lang.Throwable -> L56 java.lang.InterruptedException -> L58
        L30:
            long r3 = java.lang.Math.min(r12, r3)     // Catch: java.lang.Throwable -> L56
            int r4 = (int) r3     // Catch: java.lang.Throwable -> L56
            okhttp3.internal.http2.f r3 = r8.v     // Catch: java.lang.Throwable -> L56
            int r3 = r3.maxDataLength()     // Catch: java.lang.Throwable -> L56
            int r3 = java.lang.Math.min(r4, r3)     // Catch: java.lang.Throwable -> L56
            long r4 = r8.r     // Catch: java.lang.Throwable -> L56
            long r6 = (long) r3     // Catch: java.lang.Throwable -> L56
            long r4 = r4 - r6
            r8.r = r4     // Catch: java.lang.Throwable -> L56
            monitor-exit(r8)     // Catch: java.lang.Throwable -> L56
            long r12 = r12 - r6
            okhttp3.internal.http2.f r4 = r8.v
            if (r10 == 0) goto L51
            int r5 = (r12 > r1 ? 1 : (r12 == r1 ? 0 : -1))
            if (r5 != 0) goto L51
            r5 = 1
            goto L52
        L51:
            r5 = 0
        L52:
            r4.data(r5, r9, r11, r3)
            goto Ld
        L56:
            r9 = move-exception
            goto L65
        L58:
            java.lang.Thread r9 = java.lang.Thread.currentThread()     // Catch: java.lang.Throwable -> L56
            r9.interrupt()     // Catch: java.lang.Throwable -> L56
            java.io.InterruptedIOException r9 = new java.io.InterruptedIOException     // Catch: java.lang.Throwable -> L56
            r9.<init>()     // Catch: java.lang.Throwable -> L56
            throw r9     // Catch: java.lang.Throwable -> L56
        L65:
            monitor-exit(r8)     // Catch: java.lang.Throwable -> L56
            throw r9
        L67:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http2.Http2Connection.G(int, boolean, okio.Buffer, long):void");
    }

    void H(int i, boolean z, List<a> list) throws IOException {
        this.v.e(z, i, list);
    }

    void I(boolean z, int i, int i2) {
        try {
            this.v.ping(z, i, i2);
        } catch (IOException e) {
            o(e);
        }
    }

    void J(int i, ErrorCode errorCode) throws IOException {
        this.v.f(i, errorCode);
    }

    void K(int i, ErrorCode errorCode) {
        try {
            this.h.execute(new 1(this, "OkHttp %s stream %d", new Object[]{this.d, Integer.valueOf(i)}, i, errorCode));
        } catch (RejectedExecutionException unused) {
        }
    }

    void L(int i, long j) {
        try {
            this.h.execute(new 2(this, "OkHttp Window Update %s stream %d", new Object[]{this.d, Integer.valueOf(i)}, i, j));
        } catch (RejectedExecutionException unused) {
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        n(ErrorCode.NO_ERROR, ErrorCode.CANCEL, null);
    }

    public void flush() throws IOException {
        this.v.flush();
    }

    void n(ErrorCode errorCode, ErrorCode errorCode2, @Nullable IOException iOException) {
        try {
            C(errorCode);
        } catch (IOException unused) {
        }
        e[] eVarArr = null;
        synchronized (this) {
            if (!this.c.isEmpty()) {
                eVarArr = (e[]) this.c.values().toArray(new e[this.c.size()]);
                this.c.clear();
            }
        }
        if (eVarArr != null) {
            for (e eVar : eVarArr) {
                try {
                    eVar.d(errorCode2, iOException);
                } catch (IOException unused2) {
                }
            }
        }
        try {
            this.v.close();
        } catch (IOException unused3) {
        }
        try {
            this.u.close();
        } catch (IOException unused4) {
        }
        this.h.shutdown();
        this.i.shutdown();
    }

    synchronized e p(int i) {
        return this.c.get(Integer.valueOf(i));
    }

    public synchronized boolean q(long j) {
        if (this.g) {
            return false;
        }
        if (this.n < this.m) {
            if (j >= this.p) {
                return false;
            }
        }
        return true;
    }

    public synchronized int r() {
        return this.t.e(Integer.MAX_VALUE);
    }

    public e t(List<a> list, boolean z) throws IOException {
        return s(0, list, z);
    }

    void u(int i, BufferedSource bufferedSource, int i2, boolean z) throws IOException {
        Buffer buffer = new Buffer();
        long j = i2;
        bufferedSource.require(j);
        bufferedSource.read(buffer, j);
        if (buffer.size() == j) {
            v(new 6(this, "OkHttp %s Push Data[%s]", new Object[]{this.d, Integer.valueOf(i)}, i, buffer, i2, z));
            return;
        }
        throw new IOException(buffer.size() + " != " + i2);
    }

    void w(int i, List<a> list, boolean z) {
        try {
            v(new 5(this, "OkHttp %s Push Headers[%s]", new Object[]{this.d, Integer.valueOf(i)}, i, list, z));
        } catch (RejectedExecutionException unused) {
        }
    }

    void x(int i, List<a> list) {
        synchronized (this) {
            if (this.x.contains(Integer.valueOf(i))) {
                K(i, ErrorCode.PROTOCOL_ERROR);
                return;
            }
            this.x.add(Integer.valueOf(i));
            try {
                v(new 4(this, "OkHttp %s Push Request[%s]", new Object[]{this.d, Integer.valueOf(i)}, i, list));
            } catch (RejectedExecutionException unused) {
            }
        }
    }

    void y(int i, ErrorCode errorCode) {
        v(new 7(this, "OkHttp %s Push Reset[%s]", new Object[]{this.d, Integer.valueOf(i)}, i, errorCode));
    }

    boolean z(int i) {
        return i != 0 && (i & 1) == 0;
    }
}
