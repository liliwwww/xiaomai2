package okhttp3.internal.http2;

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
import okhttp3.internal.C1421a;
import okhttp3.internal.NamedRunnable;
import okhttp3.internal.http2.Http2Reader;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;
import tb.iv3;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public final class Http2Connection implements Closeable {

    /* renamed from: y */
    private static final ExecutorService f690y = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), C1421a.m459I("OkHttp Http2Connection", true));

    /* renamed from: a */
    final boolean f691a;

    /* renamed from: b */
    final AbstractC1450b f692b;

    /* renamed from: d */
    final String f694d;

    /* renamed from: e */
    int f695e;

    /* renamed from: f */
    int f696f;

    /* renamed from: g */
    private boolean f697g;

    /* renamed from: h */
    private final ScheduledExecutorService f698h;

    /* renamed from: i */
    private final ExecutorService f699i;

    /* renamed from: j */
    final PushObserver f700j;

    /* renamed from: r */
    long f708r;

    /* renamed from: t */
    final C1460h f710t;

    /* renamed from: u */
    final Socket f711u;

    /* renamed from: v */
    final C1458f f712v;

    /* renamed from: w */
    final ReaderRunnable f713w;

    /* renamed from: x */
    final Set<Integer> f714x;

    /* renamed from: c */
    final Map<Integer, C1457e> f693c = new LinkedHashMap();

    /* renamed from: k */
    private long f701k = 0;

    /* renamed from: l */
    private long f702l = 0;

    /* renamed from: m */
    private long f703m = 0;

    /* renamed from: n */
    private long f704n = 0;

    /* renamed from: o */
    private long f705o = 0;

    /* renamed from: p */
    private long f706p = 0;

    /* renamed from: q */
    long f707q = 0;

    /* renamed from: s */
    C1460h f709s = new C1460h();

    /* compiled from: Taobao */
    final class IntervalPingRunnable extends NamedRunnable {
        IntervalPingRunnable() {
            super("OkHttp %s ping", Http2Connection.this.f694d);
        }

        @Override // okhttp3.internal.NamedRunnable
        public void execute() {
            boolean z;
            synchronized (Http2Connection.this) {
                if (Http2Connection.this.f702l < Http2Connection.this.f701k) {
                    z = true;
                } else {
                    Http2Connection.m606e(Http2Connection.this);
                    z = false;
                }
            }
            if (z) {
                Http2Connection.this.m613o(null);
            } else {
                Http2Connection.this.m624I(false, 1, 0);
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    final class PingRunnable extends NamedRunnable {
        final int payload1;
        final int payload2;
        final boolean reply;

        PingRunnable(boolean z, int i, int i2) {
            super("OkHttp %s ping %08x%08x", Http2Connection.this.f694d, Integer.valueOf(i), Integer.valueOf(i2));
            this.reply = z;
            this.payload1 = i;
            this.payload2 = i2;
        }

        @Override // okhttp3.internal.NamedRunnable
        public void execute() {
            Http2Connection.this.m624I(this.reply, this.payload1, this.payload2);
        }
    }

    /* compiled from: Taobao */
    class ReaderRunnable extends NamedRunnable implements Http2Reader.Handler {
        final Http2Reader reader;

        ReaderRunnable(Http2Reader http2Reader) {
            super("OkHttp %s", Http2Connection.this.f694d);
            this.reader = http2Reader;
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void ackSettings() {
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void alternateService(int i, String str, ByteString byteString, String str2, int i2, long j) {
        }

        void applyAndAckSettings(boolean z, C1460h c1460h) {
            C1457e[] c1457eArr;
            long j;
            synchronized (Http2Connection.this.f712v) {
                synchronized (Http2Connection.this) {
                    int m735d = Http2Connection.this.f710t.m735d();
                    if (z) {
                        Http2Connection.this.f710t.m732a();
                    }
                    Http2Connection.this.f710t.m739h(c1460h);
                    int m735d2 = Http2Connection.this.f710t.m735d();
                    c1457eArr = null;
                    if (m735d2 == -1 || m735d2 == m735d) {
                        j = 0;
                    } else {
                        j = m735d2 - m735d;
                        if (!Http2Connection.this.f693c.isEmpty()) {
                            c1457eArr = (C1457e[]) Http2Connection.this.f693c.values().toArray(new C1457e[Http2Connection.this.f693c.size()]);
                        }
                    }
                }
                try {
                    Http2Connection http2Connection = Http2Connection.this;
                    http2Connection.f712v.m719a(http2Connection.f710t);
                } catch (IOException e) {
                    Http2Connection.this.m613o(e);
                }
            }
            if (c1457eArr != null) {
                for (C1457e c1457e : c1457eArr) {
                    synchronized (c1457e) {
                        c1457e.m692a(j);
                    }
                }
            }
            Http2Connection.f690y.execute(new NamedRunnable("OkHttp %s settings", Http2Connection.this.f694d) { // from class: okhttp3.internal.http2.Http2Connection.ReaderRunnable.3
                @Override // okhttp3.internal.NamedRunnable
                public void execute() {
                    Http2Connection http2Connection2 = Http2Connection.this;
                    http2Connection2.f692b.mo541a(http2Connection2);
                }
            });
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void data(boolean z, int i, BufferedSource bufferedSource, int i2) throws IOException {
            if (Http2Connection.this.m637z(i)) {
                Http2Connection.this.m633u(i, bufferedSource, i2, z);
                return;
            }
            C1457e m629p = Http2Connection.this.m629p(i);
            if (m629p == null) {
                Http2Connection.this.m626K(i, ErrorCode.PROTOCOL_ERROR);
                long j = i2;
                Http2Connection.this.m621F(j);
                bufferedSource.skip(j);
                return;
            }
            m629p.m703m(bufferedSource, i2);
            if (z) {
                m629p.m704n(C1421a.EMPTY_HEADERS, true);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v0, types: [okhttp3.internal.http2.ErrorCode] */
        /* JADX WARN: Type inference failed for: r0v3 */
        /* JADX WARN: Type inference failed for: r0v5, types: [java.io.Closeable, okhttp3.internal.http2.Http2Reader] */
        @Override // okhttp3.internal.NamedRunnable
        protected void execute() {
            ErrorCode errorCode;
            ErrorCode errorCode2;
            ErrorCode errorCode3 = ErrorCode.INTERNAL_ERROR;
            IOException e = null;
            try {
                try {
                    this.reader.m656c(this);
                    while (this.reader.m655b(false, this)) {
                    }
                    errorCode2 = ErrorCode.NO_ERROR;
                } catch (IOException e2) {
                    e = e2;
                } catch (Throwable th) {
                    th = th;
                    errorCode = errorCode3;
                    Http2Connection.this.m628n(errorCode, errorCode3, e);
                    C1421a.m470g(this.reader);
                    throw th;
                }
                try {
                    Http2Connection.this.m628n(errorCode2, ErrorCode.CANCEL, null);
                    errorCode = errorCode2;
                } catch (IOException e3) {
                    e = e3;
                    ErrorCode errorCode4 = ErrorCode.PROTOCOL_ERROR;
                    Http2Connection http2Connection = Http2Connection.this;
                    http2Connection.m628n(errorCode4, errorCode4, e);
                    errorCode = http2Connection;
                    errorCode3 = this.reader;
                    C1421a.m470g(errorCode3);
                }
                errorCode3 = this.reader;
                C1421a.m470g(errorCode3);
            } catch (Throwable th2) {
                th = th2;
                Http2Connection.this.m628n(errorCode, errorCode3, e);
                C1421a.m470g(this.reader);
                throw th;
            }
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void goAway(int i, ErrorCode errorCode, ByteString byteString) {
            C1457e[] c1457eArr;
            byteString.size();
            synchronized (Http2Connection.this) {
                c1457eArr = (C1457e[]) Http2Connection.this.f693c.values().toArray(new C1457e[Http2Connection.this.f693c.size()]);
                Http2Connection.this.f697g = true;
            }
            for (C1457e c1457e : c1457eArr) {
                if (c1457e.m697g() > i && c1457e.m700j()) {
                    c1457e.m705o(ErrorCode.REFUSED_STREAM);
                    Http2Connection.this.m616A(c1457e.m697g());
                }
            }
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void headers(boolean z, int i, int i2, List<C1453a> list) {
            if (Http2Connection.this.m637z(i)) {
                Http2Connection.this.m634w(i, list, z);
                return;
            }
            synchronized (Http2Connection.this) {
                C1457e m629p = Http2Connection.this.m629p(i);
                if (m629p != null) {
                    m629p.m704n(C1421a.m461K(list), z);
                    return;
                }
                if (Http2Connection.this.f697g) {
                    return;
                }
                Http2Connection http2Connection = Http2Connection.this;
                if (i <= http2Connection.f695e) {
                    return;
                }
                if (i % 2 == http2Connection.f696f % 2) {
                    return;
                }
                final C1457e c1457e = new C1457e(i, Http2Connection.this, false, z, C1421a.m461K(list));
                Http2Connection http2Connection2 = Http2Connection.this;
                http2Connection2.f695e = i;
                http2Connection2.f693c.put(Integer.valueOf(i), c1457e);
                Http2Connection.f690y.execute(new NamedRunnable("OkHttp %s stream %d", new Object[]{Http2Connection.this.f694d, Integer.valueOf(i)}) { // from class: okhttp3.internal.http2.Http2Connection.ReaderRunnable.1
                    @Override // okhttp3.internal.NamedRunnable
                    public void execute() {
                        try {
                            Http2Connection.this.f692b.mo542b(c1457e);
                        } catch (IOException e) {
                            iv3.j().p(4, "Http2Connection.Listener failure for " + Http2Connection.this.f694d, e);
                            try {
                                c1457e.m695d(ErrorCode.PROTOCOL_ERROR, e);
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
                    Http2Connection.this.f698h.execute(Http2Connection.this.new PingRunnable(true, i, i2));
                    return;
                } catch (RejectedExecutionException unused) {
                    return;
                }
            }
            synchronized (Http2Connection.this) {
                try {
                    if (i == 1) {
                        Http2Connection.m604c(Http2Connection.this);
                    } else if (i == 2) {
                        Http2Connection.m611l(Http2Connection.this);
                    } else if (i == 3) {
                        Http2Connection.m612m(Http2Connection.this);
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
        public void pushPromise(int i, int i2, List<C1453a> list) {
            Http2Connection.this.m635x(i2, list);
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void rstStream(int i, ErrorCode errorCode) {
            if (Http2Connection.this.m637z(i)) {
                Http2Connection.this.m636y(i, errorCode);
                return;
            }
            C1457e m616A = Http2Connection.this.m616A(i);
            if (m616A != null) {
                m616A.m705o(errorCode);
            }
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void settings(final boolean z, final C1460h c1460h) {
            try {
                Http2Connection.this.f698h.execute(new NamedRunnable("OkHttp %s ACK Settings", new Object[]{Http2Connection.this.f694d}) { // from class: okhttp3.internal.http2.Http2Connection.ReaderRunnable.2
                    @Override // okhttp3.internal.NamedRunnable
                    public void execute() {
                        ReaderRunnable.this.applyAndAckSettings(z, c1460h);
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
                    http2Connection.f708r += j;
                    http2Connection.notifyAll();
                }
                return;
            }
            C1457e m629p = Http2Connection.this.m629p(i);
            if (m629p != null) {
                synchronized (m629p) {
                    m629p.m692a(j);
                }
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: okhttp3.internal.http2.Http2Connection$a */
    /* loaded from: classes2.dex */
    public static class C1449a {

        /* renamed from: a */
        Socket f715a;

        /* renamed from: b */
        String f716b;

        /* renamed from: c */
        BufferedSource f717c;

        /* renamed from: d */
        BufferedSink f718d;

        /* renamed from: e */
        AbstractC1450b f719e = AbstractC1450b.REFUSE_INCOMING_STREAMS;

        /* renamed from: f */
        PushObserver f720f = PushObserver.CANCEL;

        /* renamed from: g */
        boolean f721g;

        /* renamed from: h */
        int f722h;

        public C1449a(boolean z) {
            this.f721g = z;
        }

        /* renamed from: a */
        public Http2Connection m638a() {
            return new Http2Connection(this);
        }

        /* renamed from: b */
        public C1449a m639b(AbstractC1450b abstractC1450b) {
            this.f719e = abstractC1450b;
            return this;
        }

        /* renamed from: c */
        public C1449a m640c(int i) {
            this.f722h = i;
            return this;
        }

        /* renamed from: d */
        public C1449a m641d(Socket socket, String str, BufferedSource bufferedSource, BufferedSink bufferedSink) {
            this.f715a = socket;
            this.f716b = str;
            this.f717c = bufferedSource;
            this.f718d = bufferedSink;
            return this;
        }
    }

    /* compiled from: Taobao */
    /* renamed from: okhttp3.internal.http2.Http2Connection$b */
    /* loaded from: classes2.dex */
    public static abstract class AbstractC1450b {
        public static final AbstractC1450b REFUSE_INCOMING_STREAMS = new a();

        /* compiled from: Taobao */
        /* renamed from: okhttp3.internal.http2.Http2Connection$b$a */
        class a extends AbstractC1450b {
            a() {
            }

            @Override // okhttp3.internal.http2.Http2Connection.AbstractC1450b
            /* renamed from: b */
            public void mo542b(C1457e c1457e) throws IOException {
                c1457e.m695d(ErrorCode.REFUSED_STREAM, null);
            }
        }

        /* renamed from: a */
        public void mo541a(Http2Connection http2Connection) {
        }

        /* renamed from: b */
        public abstract void mo542b(C1457e c1457e) throws IOException;
    }

    Http2Connection(C1449a c1449a) {
        C1460h c1460h = new C1460h();
        this.f710t = c1460h;
        this.f714x = new LinkedHashSet();
        this.f700j = c1449a.f720f;
        boolean z = c1449a.f721g;
        this.f691a = z;
        this.f692b = c1449a.f719e;
        int i = z ? 1 : 2;
        this.f696f = i;
        if (z) {
            this.f696f = i + 2;
        }
        if (z) {
            this.f709s.m740i(7, 16777216);
        }
        String str = c1449a.f716b;
        this.f694d = str;
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1, C1421a.m459I(C1421a.m480q("OkHttp %s Writer", str), false));
        this.f698h = scheduledThreadPoolExecutor;
        if (c1449a.f722h != 0) {
            IntervalPingRunnable intervalPingRunnable = new IntervalPingRunnable();
            int i2 = c1449a.f722h;
            scheduledThreadPoolExecutor.scheduleAtFixedRate(intervalPingRunnable, i2, i2, TimeUnit.MILLISECONDS);
        }
        this.f699i = new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), C1421a.m459I(C1421a.m480q("OkHttp %s Push Observer", str), true));
        c1460h.m740i(7, 65535);
        c1460h.m740i(5, 16384);
        this.f708r = c1460h.m735d();
        this.f711u = c1449a.f715a;
        this.f712v = new C1458f(c1449a.f718d, z);
        this.f713w = new ReaderRunnable(new Http2Reader(c1449a.f717c, z));
    }

    /* renamed from: c */
    static /* synthetic */ long m604c(Http2Connection http2Connection) {
        long j = http2Connection.f702l;
        http2Connection.f702l = 1 + j;
        return j;
    }

    /* renamed from: e */
    static /* synthetic */ long m606e(Http2Connection http2Connection) {
        long j = http2Connection.f701k;
        http2Connection.f701k = 1 + j;
        return j;
    }

    /* renamed from: l */
    static /* synthetic */ long m611l(Http2Connection http2Connection) {
        long j = http2Connection.f704n;
        http2Connection.f704n = 1 + j;
        return j;
    }

    /* renamed from: m */
    static /* synthetic */ long m612m(Http2Connection http2Connection) {
        long j = http2Connection.f705o;
        http2Connection.f705o = 1 + j;
        return j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: o */
    public void m613o(@Nullable IOException iOException) {
        ErrorCode errorCode = ErrorCode.PROTOCOL_ERROR;
        m628n(errorCode, errorCode, iOException);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0041 A[Catch: all -> 0x0073, TryCatch #0 {, blocks: (B:6:0x0007, B:8:0x000e, B:9:0x0013, B:11:0x0017, B:13:0x0029, B:15:0x0031, B:19:0x003b, B:21:0x0041, B:22:0x004a, B:36:0x006d, B:37:0x0072), top: B:5:0x0007, outer: #1 }] */
    /* renamed from: s */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private okhttp3.internal.http2.C1457e m614s(int r11, java.util.List<okhttp3.internal.http2.C1453a> r12, boolean r13) throws java.io.IOException {
        /*
            r10 = this;
            r6 = r13 ^ 1
            r4 = 0
            okhttp3.internal.http2.f r7 = r10.f712v
            monitor-enter(r7)
            monitor-enter(r10)     // Catch: java.lang.Throwable -> L76
            int r0 = r10.f696f     // Catch: java.lang.Throwable -> L73
            r1 = 1073741823(0x3fffffff, float:1.9999999)
            if (r0 <= r1) goto L13
            okhttp3.internal.http2.ErrorCode r0 = okhttp3.internal.http2.ErrorCode.REFUSED_STREAM     // Catch: java.lang.Throwable -> L73
            r10.m618C(r0)     // Catch: java.lang.Throwable -> L73
        L13:
            boolean r0 = r10.f697g     // Catch: java.lang.Throwable -> L73
            if (r0 != 0) goto L6d
            int r8 = r10.f696f     // Catch: java.lang.Throwable -> L73
            int r0 = r8 + 2
            r10.f696f = r0     // Catch: java.lang.Throwable -> L73
            okhttp3.internal.http2.e r9 = new okhttp3.internal.http2.e     // Catch: java.lang.Throwable -> L73
            r5 = 0
            r0 = r9
            r1 = r8
            r2 = r10
            r3 = r6
            r0.<init>(r1, r2, r3, r4, r5)     // Catch: java.lang.Throwable -> L73
            if (r13 == 0) goto L3a
            long r0 = r10.f708r     // Catch: java.lang.Throwable -> L73
            r2 = 0
            int r13 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r13 == 0) goto L3a
            long r0 = r9.f769b     // Catch: java.lang.Throwable -> L73
            int r13 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r13 != 0) goto L38
            goto L3a
        L38:
            r13 = 0
            goto L3b
        L3a:
            r13 = 1
        L3b:
            boolean r0 = r9.m701k()     // Catch: java.lang.Throwable -> L73
            if (r0 == 0) goto L4a
            java.util.Map<java.lang.Integer, okhttp3.internal.http2.e> r0 = r10.f693c     // Catch: java.lang.Throwable -> L73
            java.lang.Integer r1 = java.lang.Integer.valueOf(r8)     // Catch: java.lang.Throwable -> L73
            r0.put(r1, r9)     // Catch: java.lang.Throwable -> L73
        L4a:
            monitor-exit(r10)     // Catch: java.lang.Throwable -> L73
            if (r11 != 0) goto L53
            okhttp3.internal.http2.f r11 = r10.f712v     // Catch: java.lang.Throwable -> L76
            r11.m723e(r6, r8, r12)     // Catch: java.lang.Throwable -> L76
            goto L5c
        L53:
            boolean r0 = r10.f691a     // Catch: java.lang.Throwable -> L76
            if (r0 != 0) goto L65
            okhttp3.internal.http2.f r0 = r10.f712v     // Catch: java.lang.Throwable -> L76
            r0.pushPromise(r11, r8, r12)     // Catch: java.lang.Throwable -> L76
        L5c:
            monitor-exit(r7)     // Catch: java.lang.Throwable -> L76
            if (r13 == 0) goto L64
            okhttp3.internal.http2.f r11 = r10.f712v
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
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http2.Http2Connection.m614s(int, java.util.List, boolean):okhttp3.internal.http2.e");
    }

    /* renamed from: v */
    private synchronized void m615v(NamedRunnable namedRunnable) {
        if (!this.f697g) {
            this.f699i.execute(namedRunnable);
        }
    }

    /* renamed from: A */
    synchronized C1457e m616A(int i) {
        C1457e remove;
        remove = this.f693c.remove(Integer.valueOf(i));
        notifyAll();
        return remove;
    }

    /* renamed from: B */
    void m617B() {
        synchronized (this) {
            long j = this.f704n;
            long j2 = this.f703m;
            if (j < j2) {
                return;
            }
            this.f703m = j2 + 1;
            this.f706p = System.nanoTime() + 1000000000;
            try {
                this.f698h.execute(new NamedRunnable("OkHttp %s ping", this.f694d) { // from class: okhttp3.internal.http2.Http2Connection.3
                    @Override // okhttp3.internal.NamedRunnable
                    public void execute() {
                        Http2Connection.this.m624I(false, 2, 0);
                    }
                });
            } catch (RejectedExecutionException unused) {
            }
        }
    }

    /* renamed from: C */
    public void m618C(ErrorCode errorCode) throws IOException {
        synchronized (this.f712v) {
            synchronized (this) {
                if (this.f697g) {
                    return;
                }
                this.f697g = true;
                this.f712v.m722d(this.f695e, errorCode, C1421a.EMPTY_BYTE_ARRAY);
            }
        }
    }

    /* renamed from: D */
    public void m619D() throws IOException {
        m620E(true);
    }

    /* renamed from: E */
    void m620E(boolean z) throws IOException {
        if (z) {
            this.f712v.connectionPreface();
            this.f712v.m725g(this.f709s);
            if (this.f709s.m735d() != 65535) {
                this.f712v.windowUpdate(0, r6 - 65535);
            }
        }
        new Thread(this.f713w).start();
    }

    /* renamed from: F */
    synchronized void m621F(long j) {
        long j2 = this.f707q + j;
        this.f707q = j2;
        if (j2 >= this.f709s.m735d() / 2) {
            m627L(0, this.f707q);
            this.f707q = 0L;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0030, code lost:
    
        r3 = java.lang.Math.min((int) java.lang.Math.min(r12, r3), r8.f712v.maxDataLength());
        r6 = r3;
        r8.f708r -= r6;
     */
    /* renamed from: G */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void m622G(int r9, boolean r10, okio.Buffer r11, long r12) throws java.io.IOException {
        /*
            r8 = this;
            r0 = 0
            r1 = 0
            int r3 = (r12 > r1 ? 1 : (r12 == r1 ? 0 : -1))
            if (r3 != 0) goto Ld
            okhttp3.internal.http2.f r12 = r8.f712v
            r12.data(r10, r9, r11, r0)
            return
        Ld:
            int r3 = (r12 > r1 ? 1 : (r12 == r1 ? 0 : -1))
            if (r3 <= 0) goto L67
            monitor-enter(r8)
        L12:
            long r3 = r8.f708r     // Catch: java.lang.Throwable -> L56 java.lang.InterruptedException -> L58
            int r5 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r5 > 0) goto L30
            java.util.Map<java.lang.Integer, okhttp3.internal.http2.e> r3 = r8.f693c     // Catch: java.lang.Throwable -> L56 java.lang.InterruptedException -> L58
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
            okhttp3.internal.http2.f r3 = r8.f712v     // Catch: java.lang.Throwable -> L56
            int r3 = r3.maxDataLength()     // Catch: java.lang.Throwable -> L56
            int r3 = java.lang.Math.min(r4, r3)     // Catch: java.lang.Throwable -> L56
            long r4 = r8.f708r     // Catch: java.lang.Throwable -> L56
            long r6 = (long) r3     // Catch: java.lang.Throwable -> L56
            long r4 = r4 - r6
            r8.f708r = r4     // Catch: java.lang.Throwable -> L56
            monitor-exit(r8)     // Catch: java.lang.Throwable -> L56
            long r12 = r12 - r6
            okhttp3.internal.http2.f r4 = r8.f712v
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
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http2.Http2Connection.m622G(int, boolean, okio.Buffer, long):void");
    }

    /* renamed from: H */
    void m623H(int i, boolean z, List<C1453a> list) throws IOException {
        this.f712v.m723e(z, i, list);
    }

    /* renamed from: I */
    void m624I(boolean z, int i, int i2) {
        try {
            this.f712v.ping(z, i, i2);
        } catch (IOException e) {
            m613o(e);
        }
    }

    /* renamed from: J */
    void m625J(int i, ErrorCode errorCode) throws IOException {
        this.f712v.m724f(i, errorCode);
    }

    /* renamed from: K */
    void m626K(final int i, final ErrorCode errorCode) {
        try {
            this.f698h.execute(new NamedRunnable("OkHttp %s stream %d", new Object[]{this.f694d, Integer.valueOf(i)}) { // from class: okhttp3.internal.http2.Http2Connection.1
                @Override // okhttp3.internal.NamedRunnable
                public void execute() {
                    try {
                        Http2Connection.this.m625J(i, errorCode);
                    } catch (IOException e) {
                        Http2Connection.this.m613o(e);
                    }
                }
            });
        } catch (RejectedExecutionException unused) {
        }
    }

    /* renamed from: L */
    void m627L(final int i, final long j) {
        try {
            this.f698h.execute(new NamedRunnable("OkHttp Window Update %s stream %d", new Object[]{this.f694d, Integer.valueOf(i)}) { // from class: okhttp3.internal.http2.Http2Connection.2
                @Override // okhttp3.internal.NamedRunnable
                public void execute() {
                    try {
                        Http2Connection.this.f712v.windowUpdate(i, j);
                    } catch (IOException e) {
                        Http2Connection.this.m613o(e);
                    }
                }
            });
        } catch (RejectedExecutionException unused) {
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        m628n(ErrorCode.NO_ERROR, ErrorCode.CANCEL, null);
    }

    public void flush() throws IOException {
        this.f712v.flush();
    }

    /* renamed from: n */
    void m628n(ErrorCode errorCode, ErrorCode errorCode2, @Nullable IOException iOException) {
        try {
            m618C(errorCode);
        } catch (IOException unused) {
        }
        C1457e[] c1457eArr = null;
        synchronized (this) {
            if (!this.f693c.isEmpty()) {
                c1457eArr = (C1457e[]) this.f693c.values().toArray(new C1457e[this.f693c.size()]);
                this.f693c.clear();
            }
        }
        if (c1457eArr != null) {
            for (C1457e c1457e : c1457eArr) {
                try {
                    c1457e.m695d(errorCode2, iOException);
                } catch (IOException unused2) {
                }
            }
        }
        try {
            this.f712v.close();
        } catch (IOException unused3) {
        }
        try {
            this.f711u.close();
        } catch (IOException unused4) {
        }
        this.f698h.shutdown();
        this.f699i.shutdown();
    }

    /* renamed from: p */
    synchronized C1457e m629p(int i) {
        return this.f693c.get(Integer.valueOf(i));
    }

    /* renamed from: q */
    public synchronized boolean m630q(long j) {
        if (this.f697g) {
            return false;
        }
        if (this.f704n < this.f703m) {
            if (j >= this.f706p) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: r */
    public synchronized int m631r() {
        return this.f710t.m736e(Integer.MAX_VALUE);
    }

    /* renamed from: t */
    public C1457e m632t(List<C1453a> list, boolean z) throws IOException {
        return m614s(0, list, z);
    }

    /* renamed from: u */
    void m633u(final int i, BufferedSource bufferedSource, final int i2, final boolean z) throws IOException {
        final Buffer buffer = new Buffer();
        long j = i2;
        bufferedSource.require(j);
        bufferedSource.read(buffer, j);
        if (buffer.size() == j) {
            m615v(new NamedRunnable("OkHttp %s Push Data[%s]", new Object[]{this.f694d, Integer.valueOf(i)}) { // from class: okhttp3.internal.http2.Http2Connection.6
                @Override // okhttp3.internal.NamedRunnable
                public void execute() {
                    try {
                        boolean onData = Http2Connection.this.f700j.onData(i, buffer, i2, z);
                        if (onData) {
                            Http2Connection.this.f712v.m724f(i, ErrorCode.CANCEL);
                        }
                        if (onData || z) {
                            synchronized (Http2Connection.this) {
                                Http2Connection.this.f714x.remove(Integer.valueOf(i));
                            }
                        }
                    } catch (IOException unused) {
                    }
                }
            });
            return;
        }
        throw new IOException(buffer.size() + " != " + i2);
    }

    /* renamed from: w */
    void m634w(final int i, final List<C1453a> list, final boolean z) {
        try {
            m615v(new NamedRunnable("OkHttp %s Push Headers[%s]", new Object[]{this.f694d, Integer.valueOf(i)}) { // from class: okhttp3.internal.http2.Http2Connection.5
                @Override // okhttp3.internal.NamedRunnable
                public void execute() {
                    boolean onHeaders = Http2Connection.this.f700j.onHeaders(i, list, z);
                    if (onHeaders) {
                        try {
                            Http2Connection.this.f712v.m724f(i, ErrorCode.CANCEL);
                        } catch (IOException unused) {
                            return;
                        }
                    }
                    if (onHeaders || z) {
                        synchronized (Http2Connection.this) {
                            Http2Connection.this.f714x.remove(Integer.valueOf(i));
                        }
                    }
                }
            });
        } catch (RejectedExecutionException unused) {
        }
    }

    /* renamed from: x */
    void m635x(final int i, final List<C1453a> list) {
        synchronized (this) {
            if (this.f714x.contains(Integer.valueOf(i))) {
                m626K(i, ErrorCode.PROTOCOL_ERROR);
                return;
            }
            this.f714x.add(Integer.valueOf(i));
            try {
                m615v(new NamedRunnable("OkHttp %s Push Request[%s]", new Object[]{this.f694d, Integer.valueOf(i)}) { // from class: okhttp3.internal.http2.Http2Connection.4
                    @Override // okhttp3.internal.NamedRunnable
                    public void execute() {
                        if (Http2Connection.this.f700j.onRequest(i, list)) {
                            try {
                                Http2Connection.this.f712v.m724f(i, ErrorCode.CANCEL);
                                synchronized (Http2Connection.this) {
                                    Http2Connection.this.f714x.remove(Integer.valueOf(i));
                                }
                            } catch (IOException unused) {
                            }
                        }
                    }
                });
            } catch (RejectedExecutionException unused) {
            }
        }
    }

    /* renamed from: y */
    void m636y(final int i, final ErrorCode errorCode) {
        m615v(new NamedRunnable("OkHttp %s Push Reset[%s]", new Object[]{this.f694d, Integer.valueOf(i)}) { // from class: okhttp3.internal.http2.Http2Connection.7
            @Override // okhttp3.internal.NamedRunnable
            public void execute() {
                Http2Connection.this.f700j.onReset(i, errorCode);
                synchronized (Http2Connection.this) {
                    Http2Connection.this.f714x.remove(Integer.valueOf(i));
                }
            }
        });
    }

    /* renamed from: z */
    boolean m637z(int i) {
        return i != 0 && (i & 1) == 0;
    }
}
