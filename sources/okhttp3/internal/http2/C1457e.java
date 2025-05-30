package okhttp3.internal.http2;

import android.support.v4.media.session.PlaybackStateCompat;
import android.taobao.windvane.extra.p002uc.preRender.BasePreInitManager;
import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Objects;
import javax.annotation.Nullable;
import okhttp3.C1471k;
import okhttp3.internal.C1421a;
import okio.AsyncTimeout;
import okio.Buffer;
import okio.BufferedSource;
import okio.Sink;
import okio.Source;
import okio.o;

/* compiled from: Taobao */
/* renamed from: okhttp3.internal.http2.e */
/* loaded from: classes.dex */
public final class C1457e {

    /* renamed from: a */
    long f768a = 0;

    /* renamed from: b */
    long f769b;

    /* renamed from: c */
    final int f770c;

    /* renamed from: d */
    final Http2Connection f771d;

    /* renamed from: e */
    private final Deque<C1471k> f772e;

    /* renamed from: f */
    private boolean f773f;

    /* renamed from: g */
    private final b f774g;

    /* renamed from: h */
    final a f775h;

    /* renamed from: i */
    final c f776i;

    /* renamed from: j */
    final c f777j;

    /* renamed from: k */
    @Nullable
    ErrorCode f778k;

    /* renamed from: l */
    @Nullable
    IOException f779l;

    /* compiled from: Taobao */
    /* renamed from: okhttp3.internal.http2.e$a */
    /* loaded from: classes2.dex */
    final class a implements Sink {

        /* renamed from: a */
        private final Buffer f780a = new Buffer();

        /* renamed from: b */
        private C1471k f781b;

        /* renamed from: c */
        boolean f782c;

        /* renamed from: d */
        boolean f783d;

        a() {
        }

        /* renamed from: a */
        private void m710a(boolean z) throws IOException {
            C1457e c1457e;
            long min;
            C1457e c1457e2;
            boolean z2;
            synchronized (C1457e.this) {
                C1457e.this.f777j.enter();
                while (true) {
                    try {
                        c1457e = C1457e.this;
                        if (c1457e.f769b > 0 || this.f783d || this.f782c || c1457e.f778k != null) {
                            break;
                        } else {
                            c1457e.m708r();
                        }
                    } finally {
                        C1457e.this.f777j.exitAndThrowIfTimedOut();
                    }
                }
                c1457e.f777j.exitAndThrowIfTimedOut();
                C1457e.this.m694c();
                min = Math.min(C1457e.this.f769b, this.f780a.size());
                c1457e2 = C1457e.this;
                c1457e2.f769b -= min;
            }
            c1457e2.f777j.enter();
            if (z) {
                try {
                    if (min == this.f780a.size()) {
                        z2 = true;
                        C1457e c1457e3 = C1457e.this;
                        c1457e3.f771d.m622G(c1457e3.f770c, z2, this.f780a, min);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            z2 = false;
            C1457e c1457e32 = C1457e.this;
            c1457e32.f771d.m622G(c1457e32.f770c, z2, this.f780a, min);
        }

        public void close() throws IOException {
            synchronized (C1457e.this) {
                if (this.f782c) {
                    return;
                }
                if (!C1457e.this.f775h.f783d) {
                    boolean z = this.f780a.size() > 0;
                    if (this.f781b != null) {
                        while (this.f780a.size() > 0) {
                            m710a(false);
                        }
                        C1457e c1457e = C1457e.this;
                        c1457e.f771d.m623H(c1457e.f770c, true, C1421a.m460J(this.f781b));
                    } else if (z) {
                        while (this.f780a.size() > 0) {
                            m710a(true);
                        }
                    } else {
                        C1457e c1457e2 = C1457e.this;
                        c1457e2.f771d.m622G(c1457e2.f770c, true, null, 0L);
                    }
                }
                synchronized (C1457e.this) {
                    this.f782c = true;
                }
                C1457e.this.f771d.flush();
                C1457e.this.m693b();
            }
        }

        public void flush() throws IOException {
            synchronized (C1457e.this) {
                C1457e.this.m694c();
            }
            while (this.f780a.size() > 0) {
                m710a(false);
                C1457e.this.f771d.flush();
            }
        }

        public o timeout() {
            return C1457e.this.f777j;
        }

        public void write(Buffer buffer, long j) throws IOException {
            this.f780a.write(buffer, j);
            while (this.f780a.size() >= PlaybackStateCompat.ACTION_PREPARE) {
                m710a(false);
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: okhttp3.internal.http2.e$b */
    /* loaded from: classes2.dex */
    private final class b implements Source {

        /* renamed from: a */
        private final Buffer f785a = new Buffer();

        /* renamed from: b */
        private final Buffer f786b = new Buffer();

        /* renamed from: c */
        private final long f787c;

        /* renamed from: d */
        private C1471k f788d;

        /* renamed from: e */
        boolean f789e;

        /* renamed from: f */
        boolean f790f;

        b(long j) {
            this.f787c = j;
        }

        /* renamed from: f */
        private void m715f(long j) {
            C1457e.this.f771d.m621F(j);
        }

        public void close() throws IOException {
            long size;
            synchronized (C1457e.this) {
                this.f789e = true;
                size = this.f786b.size();
                this.f786b.clear();
                C1457e.this.notifyAll();
            }
            if (size > 0) {
                m715f(size);
            }
            C1457e.this.m693b();
        }

        /* renamed from: e */
        void m716e(BufferedSource bufferedSource, long j) throws IOException {
            boolean z;
            boolean z2;
            boolean z3;
            long j2;
            while (j > 0) {
                synchronized (C1457e.this) {
                    z = this.f790f;
                    z2 = true;
                    z3 = this.f786b.size() + j > this.f787c;
                }
                if (z3) {
                    bufferedSource.skip(j);
                    C1457e.this.m696f(ErrorCode.FLOW_CONTROL_ERROR);
                    return;
                }
                if (z) {
                    bufferedSource.skip(j);
                    return;
                }
                long read = bufferedSource.read(this.f785a, j);
                if (read == -1) {
                    throw new EOFException();
                }
                j -= read;
                synchronized (C1457e.this) {
                    if (this.f789e) {
                        j2 = this.f785a.size();
                        this.f785a.clear();
                    } else {
                        if (this.f786b.size() != 0) {
                            z2 = false;
                        }
                        this.f786b.writeAll(this.f785a);
                        if (z2) {
                            C1457e.this.notifyAll();
                        }
                        j2 = 0;
                    }
                }
                if (j2 > 0) {
                    m715f(j2);
                }
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:26:0x007f, code lost:
        
            r11 = -1;
         */
        /* JADX WARN: Removed duplicated region for block: B:31:0x008c  */
        /* JADX WARN: Removed duplicated region for block: B:34:0x0090  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public long read(okio.Buffer r11, long r12) throws java.io.IOException {
            /*
                r10 = this;
                r0 = 0
                int r2 = (r12 > r0 ? 1 : (r12 == r0 ? 0 : -1))
                if (r2 < 0) goto La8
            L6:
                r2 = 0
                okhttp3.internal.http2.e r3 = okhttp3.internal.http2.C1457e.this
                monitor-enter(r3)
                okhttp3.internal.http2.e r4 = okhttp3.internal.http2.C1457e.this     // Catch: java.lang.Throwable -> La5
                okhttp3.internal.http2.e$c r4 = r4.f776i     // Catch: java.lang.Throwable -> La5
                r4.enter()     // Catch: java.lang.Throwable -> La5
                okhttp3.internal.http2.e r4 = okhttp3.internal.http2.C1457e.this     // Catch: java.lang.Throwable -> L9c
                okhttp3.internal.http2.ErrorCode r5 = r4.f778k     // Catch: java.lang.Throwable -> L9c
                if (r5 == 0) goto L25
                java.io.IOException r2 = r4.f779l     // Catch: java.lang.Throwable -> L9c
                if (r2 == 0) goto L1c
                goto L25
            L1c:
                okhttp3.internal.http2.StreamResetException r2 = new okhttp3.internal.http2.StreamResetException     // Catch: java.lang.Throwable -> L9c
                okhttp3.internal.http2.e r4 = okhttp3.internal.http2.C1457e.this     // Catch: java.lang.Throwable -> L9c
                okhttp3.internal.http2.ErrorCode r4 = r4.f778k     // Catch: java.lang.Throwable -> L9c
                r2.<init>(r4)     // Catch: java.lang.Throwable -> L9c
            L25:
                boolean r4 = r10.f789e     // Catch: java.lang.Throwable -> L9c
                if (r4 != 0) goto L94
                okio.Buffer r4 = r10.f786b     // Catch: java.lang.Throwable -> L9c
                long r4 = r4.size()     // Catch: java.lang.Throwable -> L9c
                r6 = -1
                int r8 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
                if (r8 <= 0) goto L6b
                okio.Buffer r4 = r10.f786b     // Catch: java.lang.Throwable -> L9c
                long r8 = r4.size()     // Catch: java.lang.Throwable -> L9c
                long r12 = java.lang.Math.min(r12, r8)     // Catch: java.lang.Throwable -> L9c
                long r11 = r4.read(r11, r12)     // Catch: java.lang.Throwable -> L9c
                okhttp3.internal.http2.e r13 = okhttp3.internal.http2.C1457e.this     // Catch: java.lang.Throwable -> L9c
                long r4 = r13.f768a     // Catch: java.lang.Throwable -> L9c
                long r4 = r4 + r11
                r13.f768a = r4     // Catch: java.lang.Throwable -> L9c
                if (r2 != 0) goto L80
                okhttp3.internal.http2.Http2Connection r13 = r13.f771d     // Catch: java.lang.Throwable -> L9c
                okhttp3.internal.http2.h r13 = r13.f709s     // Catch: java.lang.Throwable -> L9c
                int r13 = r13.m735d()     // Catch: java.lang.Throwable -> L9c
                int r13 = r13 / 2
                long r8 = (long) r13     // Catch: java.lang.Throwable -> L9c
                int r13 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1))
                if (r13 < 0) goto L80
                okhttp3.internal.http2.e r13 = okhttp3.internal.http2.C1457e.this     // Catch: java.lang.Throwable -> L9c
                okhttp3.internal.http2.Http2Connection r4 = r13.f771d     // Catch: java.lang.Throwable -> L9c
                int r5 = r13.f770c     // Catch: java.lang.Throwable -> L9c
                long r8 = r13.f768a     // Catch: java.lang.Throwable -> L9c
                r4.m627L(r5, r8)     // Catch: java.lang.Throwable -> L9c
                okhttp3.internal.http2.e r13 = okhttp3.internal.http2.C1457e.this     // Catch: java.lang.Throwable -> L9c
                r13.f768a = r0     // Catch: java.lang.Throwable -> L9c
                goto L80
            L6b:
                boolean r4 = r10.f790f     // Catch: java.lang.Throwable -> L9c
                if (r4 != 0) goto L7f
                if (r2 != 0) goto L7f
                okhttp3.internal.http2.e r2 = okhttp3.internal.http2.C1457e.this     // Catch: java.lang.Throwable -> L9c
                r2.m708r()     // Catch: java.lang.Throwable -> L9c
                okhttp3.internal.http2.e r2 = okhttp3.internal.http2.C1457e.this     // Catch: java.lang.Throwable -> La5
                okhttp3.internal.http2.e$c r2 = r2.f776i     // Catch: java.lang.Throwable -> La5
                r2.exitAndThrowIfTimedOut()     // Catch: java.lang.Throwable -> La5
                monitor-exit(r3)     // Catch: java.lang.Throwable -> La5
                goto L6
            L7f:
                r11 = r6
            L80:
                okhttp3.internal.http2.e r13 = okhttp3.internal.http2.C1457e.this     // Catch: java.lang.Throwable -> La5
                okhttp3.internal.http2.e$c r13 = r13.f776i     // Catch: java.lang.Throwable -> La5
                r13.exitAndThrowIfTimedOut()     // Catch: java.lang.Throwable -> La5
                monitor-exit(r3)     // Catch: java.lang.Throwable -> La5
                int r13 = (r11 > r6 ? 1 : (r11 == r6 ? 0 : -1))
                if (r13 == 0) goto L90
                r10.m715f(r11)
                return r11
            L90:
                if (r2 != 0) goto L93
                return r6
            L93:
                throw r2
            L94:
                java.io.IOException r11 = new java.io.IOException     // Catch: java.lang.Throwable -> L9c
                java.lang.String r12 = "stream closed"
                r11.<init>(r12)     // Catch: java.lang.Throwable -> L9c
                throw r11     // Catch: java.lang.Throwable -> L9c
            L9c:
                r11 = move-exception
                okhttp3.internal.http2.e r12 = okhttp3.internal.http2.C1457e.this     // Catch: java.lang.Throwable -> La5
                okhttp3.internal.http2.e$c r12 = r12.f776i     // Catch: java.lang.Throwable -> La5
                r12.exitAndThrowIfTimedOut()     // Catch: java.lang.Throwable -> La5
                throw r11     // Catch: java.lang.Throwable -> La5
            La5:
                r11 = move-exception
                monitor-exit(r3)     // Catch: java.lang.Throwable -> La5
                throw r11
            La8:
                java.lang.IllegalArgumentException r11 = new java.lang.IllegalArgumentException
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r1 = "byteCount < 0: "
                r0.append(r1)
                r0.append(r12)
                java.lang.String r12 = r0.toString()
                r11.<init>(r12)
                throw r11
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http2.C1457e.b.read(okio.Buffer, long):long");
        }

        public o timeout() {
            return C1457e.this.f776i;
        }
    }

    /* compiled from: Taobao */
    /* renamed from: okhttp3.internal.http2.e$c */
    /* loaded from: classes2.dex */
    class c extends AsyncTimeout {
        c() {
        }

        public void exitAndThrowIfTimedOut() throws IOException {
            if (exit()) {
                throw newTimeoutException(null);
            }
        }

        protected IOException newTimeoutException(IOException iOException) {
            SocketTimeoutException socketTimeoutException = new SocketTimeoutException(BasePreInitManager.TIMEOUT);
            if (iOException != null) {
                socketTimeoutException.initCause(iOException);
            }
            return socketTimeoutException;
        }

        protected void timedOut() {
            C1457e.this.m696f(ErrorCode.CANCEL);
            C1457e.this.f771d.m617B();
        }
    }

    C1457e(int i, Http2Connection http2Connection, boolean z, boolean z2, @Nullable C1471k c1471k) {
        ArrayDeque arrayDeque = new ArrayDeque();
        this.f772e = arrayDeque;
        this.f776i = new c();
        this.f777j = new c();
        Objects.requireNonNull(http2Connection, "connection == null");
        this.f770c = i;
        this.f771d = http2Connection;
        this.f769b = http2Connection.f710t.m735d();
        b bVar = new b(http2Connection.f709s.m735d());
        this.f774g = bVar;
        a aVar = new a();
        this.f775h = aVar;
        bVar.f790f = z2;
        aVar.f783d = z;
        if (c1471k != null) {
            arrayDeque.add(c1471k);
        }
        if (m700j() && c1471k != null) {
            throw new IllegalStateException("locally-initiated streams shouldn't have headers yet");
        }
        if (!m700j() && c1471k == null) {
            throw new IllegalStateException("remotely-initiated streams should have headers");
        }
    }

    /* renamed from: e */
    private boolean m691e(ErrorCode errorCode, @Nullable IOException iOException) {
        synchronized (this) {
            if (this.f778k != null) {
                return false;
            }
            if (this.f774g.f790f && this.f775h.f783d) {
                return false;
            }
            this.f778k = errorCode;
            this.f779l = iOException;
            notifyAll();
            this.f771d.m616A(this.f770c);
            return true;
        }
    }

    /* renamed from: a */
    void m692a(long j) {
        this.f769b += j;
        if (j > 0) {
            notifyAll();
        }
    }

    /* renamed from: b */
    void m693b() throws IOException {
        boolean z;
        boolean m701k;
        synchronized (this) {
            b bVar = this.f774g;
            if (!bVar.f790f && bVar.f789e) {
                a aVar = this.f775h;
                if (aVar.f783d || aVar.f782c) {
                    z = true;
                    m701k = m701k();
                }
            }
            z = false;
            m701k = m701k();
        }
        if (z) {
            m695d(ErrorCode.CANCEL, null);
        } else {
            if (m701k) {
                return;
            }
            this.f771d.m616A(this.f770c);
        }
    }

    /* renamed from: c */
    void m694c() throws IOException {
        a aVar = this.f775h;
        if (aVar.f782c) {
            throw new IOException("stream closed");
        }
        if (aVar.f783d) {
            throw new IOException("stream finished");
        }
        if (this.f778k != null) {
            IOException iOException = this.f779l;
            if (iOException == null) {
                throw new StreamResetException(this.f778k);
            }
        }
    }

    /* renamed from: d */
    public void m695d(ErrorCode errorCode, @Nullable IOException iOException) throws IOException {
        if (m691e(errorCode, iOException)) {
            this.f771d.m625J(this.f770c, errorCode);
        }
    }

    /* renamed from: f */
    public void m696f(ErrorCode errorCode) {
        if (m691e(errorCode, null)) {
            this.f771d.m626K(this.f770c, errorCode);
        }
    }

    /* renamed from: g */
    public int m697g() {
        return this.f770c;
    }

    /* renamed from: h */
    public Sink m698h() {
        synchronized (this) {
            if (!this.f773f && !m700j()) {
                throw new IllegalStateException("reply before requesting the sink");
            }
        }
        return this.f775h;
    }

    /* renamed from: i */
    public Source m699i() {
        return this.f774g;
    }

    /* renamed from: j */
    public boolean m700j() {
        return this.f771d.f691a == ((this.f770c & 1) == 1);
    }

    /* renamed from: k */
    public synchronized boolean m701k() {
        if (this.f778k != null) {
            return false;
        }
        b bVar = this.f774g;
        if (bVar.f790f || bVar.f789e) {
            a aVar = this.f775h;
            if (aVar.f783d || aVar.f782c) {
                if (this.f773f) {
                    return false;
                }
            }
        }
        return true;
    }

    /* renamed from: l */
    public o m702l() {
        return this.f776i;
    }

    /* renamed from: m */
    void m703m(BufferedSource bufferedSource, int i) throws IOException {
        this.f774g.m716e(bufferedSource, i);
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0018 A[Catch: all -> 0x002e, TryCatch #0 {, blocks: (B:3:0x0001, B:7:0x0009, B:9:0x0018, B:10:0x001c, B:11:0x0023, B:18:0x000f), top: B:2:0x0001 }] */
    /* renamed from: n */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    void m704n(okhttp3.C1471k r3, boolean r4) {
        /*
            r2 = this;
            monitor-enter(r2)
            boolean r0 = r2.f773f     // Catch: java.lang.Throwable -> L2e
            r1 = 1
            if (r0 == 0) goto Lf
            if (r4 != 0) goto L9
            goto Lf
        L9:
            okhttp3.internal.http2.e$b r0 = r2.f774g     // Catch: java.lang.Throwable -> L2e
            okhttp3.internal.http2.C1457e.b.m714d(r0, r3)     // Catch: java.lang.Throwable -> L2e
            goto L16
        Lf:
            r2.f773f = r1     // Catch: java.lang.Throwable -> L2e
            java.util.Deque<okhttp3.k> r0 = r2.f772e     // Catch: java.lang.Throwable -> L2e
            r0.add(r3)     // Catch: java.lang.Throwable -> L2e
        L16:
            if (r4 == 0) goto L1c
            okhttp3.internal.http2.e$b r3 = r2.f774g     // Catch: java.lang.Throwable -> L2e
            r3.f790f = r1     // Catch: java.lang.Throwable -> L2e
        L1c:
            boolean r3 = r2.m701k()     // Catch: java.lang.Throwable -> L2e
            r2.notifyAll()     // Catch: java.lang.Throwable -> L2e
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L2e
            if (r3 != 0) goto L2d
            okhttp3.internal.http2.Http2Connection r3 = r2.f771d
            int r4 = r2.f770c
            r3.m616A(r4)
        L2d:
            return
        L2e:
            r3 = move-exception
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L2e
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http2.C1457e.m704n(okhttp3.k, boolean):void");
    }

    /* renamed from: o */
    synchronized void m705o(ErrorCode errorCode) {
        if (this.f778k == null) {
            this.f778k = errorCode;
            notifyAll();
        }
    }

    /* renamed from: p */
    public synchronized C1471k m706p() throws IOException {
        this.f776i.enter();
        while (this.f772e.isEmpty() && this.f778k == null) {
            try {
                m708r();
            } catch (Throwable th) {
                this.f776i.exitAndThrowIfTimedOut();
                throw th;
            }
        }
        this.f776i.exitAndThrowIfTimedOut();
        if (this.f772e.isEmpty()) {
            IOException iOException = this.f779l;
            if (iOException != null) {
                throw iOException;
            }
            throw new StreamResetException(this.f778k);
        }
        return this.f772e.removeFirst();
    }

    /* renamed from: q */
    public synchronized C1471k m707q() throws IOException {
        if (this.f778k != null) {
            IOException iOException = this.f779l;
            if (iOException != null) {
                throw iOException;
            }
            throw new StreamResetException(this.f778k);
        }
        b bVar = this.f774g;
        if (!bVar.f790f || !bVar.f785a.exhausted() || !this.f774g.f786b.exhausted()) {
            throw new IllegalStateException("too early; can't read the trailers yet");
        }
        return this.f774g.f788d != null ? this.f774g.f788d : C1421a.EMPTY_HEADERS;
    }

    /* renamed from: r */
    void m708r() throws InterruptedIOException {
        try {
            wait();
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            throw new InterruptedIOException();
        }
    }

    /* renamed from: s */
    public o m709s() {
        return this.f777j;
    }
}
