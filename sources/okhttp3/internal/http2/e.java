package okhttp3.internal.http2;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Objects;
import javax.annotation.Nullable;
import okhttp3.k;
import okio.BufferedSource;
import okio.Sink;
import okio.Source;
import okio.o;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class e {
    long a = 0;
    long b;
    final int c;
    final Http2Connection d;
    private final Deque<k> e;
    private boolean f;
    private final b g;
    final a h;
    final c i;
    final c j;

    @Nullable
    ErrorCode k;

    @Nullable
    IOException l;

    e(int i, Http2Connection http2Connection, boolean z, boolean z2, @Nullable k kVar) {
        ArrayDeque arrayDeque = new ArrayDeque();
        this.e = arrayDeque;
        this.i = new c(this);
        this.j = new c(this);
        Objects.requireNonNull(http2Connection, "connection == null");
        this.c = i;
        this.d = http2Connection;
        this.b = http2Connection.t.d();
        b bVar = new b(this, http2Connection.s.d());
        this.g = bVar;
        a aVar = new a(this);
        this.h = aVar;
        bVar.f = z2;
        aVar.d = z;
        if (kVar != null) {
            arrayDeque.add(kVar);
        }
        if (j() && kVar != null) {
            throw new IllegalStateException("locally-initiated streams shouldn't have headers yet");
        }
        if (!j() && kVar == null) {
            throw new IllegalStateException("remotely-initiated streams should have headers");
        }
    }

    private boolean e(ErrorCode errorCode, @Nullable IOException iOException) {
        synchronized (this) {
            if (this.k != null) {
                return false;
            }
            if (this.g.f && this.h.d) {
                return false;
            }
            this.k = errorCode;
            this.l = iOException;
            notifyAll();
            this.d.A(this.c);
            return true;
        }
    }

    void a(long j) {
        this.b += j;
        if (j > 0) {
            notifyAll();
        }
    }

    void b() throws IOException {
        boolean z;
        boolean k;
        synchronized (this) {
            b bVar = this.g;
            if (!bVar.f && bVar.e) {
                a aVar = this.h;
                if (aVar.d || aVar.c) {
                    z = true;
                    k = k();
                }
            }
            z = false;
            k = k();
        }
        if (z) {
            d(ErrorCode.CANCEL, null);
        } else {
            if (k) {
                return;
            }
            this.d.A(this.c);
        }
    }

    void c() throws IOException {
        a aVar = this.h;
        if (aVar.c) {
            throw new IOException("stream closed");
        }
        if (aVar.d) {
            throw new IOException("stream finished");
        }
        if (this.k != null) {
            IOException iOException = this.l;
            if (iOException == null) {
                throw new StreamResetException(this.k);
            }
        }
    }

    public void d(ErrorCode errorCode, @Nullable IOException iOException) throws IOException {
        if (e(errorCode, iOException)) {
            this.d.J(this.c, errorCode);
        }
    }

    public void f(ErrorCode errorCode) {
        if (e(errorCode, null)) {
            this.d.K(this.c, errorCode);
        }
    }

    public int g() {
        return this.c;
    }

    public Sink h() {
        synchronized (this) {
            if (!this.f && !j()) {
                throw new IllegalStateException("reply before requesting the sink");
            }
        }
        return this.h;
    }

    public Source i() {
        return this.g;
    }

    public boolean j() {
        return this.d.a == ((this.c & 1) == 1);
    }

    public synchronized boolean k() {
        if (this.k != null) {
            return false;
        }
        b bVar = this.g;
        if (bVar.f || bVar.e) {
            a aVar = this.h;
            if (aVar.d || aVar.c) {
                if (this.f) {
                    return false;
                }
            }
        }
        return true;
    }

    public o l() {
        return this.i;
    }

    void m(BufferedSource bufferedSource, int i) throws IOException {
        this.g.e(bufferedSource, i);
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0018 A[Catch: all -> 0x002e, TryCatch #0 {, blocks: (B:3:0x0001, B:7:0x0009, B:9:0x0018, B:10:0x001c, B:11:0x0023, B:18:0x000f), top: B:2:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    void n(okhttp3.k r3, boolean r4) {
        /*
            r2 = this;
            monitor-enter(r2)
            boolean r0 = r2.f     // Catch: java.lang.Throwable -> L2e
            r1 = 1
            if (r0 == 0) goto Lf
            if (r4 != 0) goto L9
            goto Lf
        L9:
            okhttp3.internal.http2.e$b r0 = r2.g     // Catch: java.lang.Throwable -> L2e
            okhttp3.internal.http2.e.b.d(r0, r3)     // Catch: java.lang.Throwable -> L2e
            goto L16
        Lf:
            r2.f = r1     // Catch: java.lang.Throwable -> L2e
            java.util.Deque<okhttp3.k> r0 = r2.e     // Catch: java.lang.Throwable -> L2e
            r0.add(r3)     // Catch: java.lang.Throwable -> L2e
        L16:
            if (r4 == 0) goto L1c
            okhttp3.internal.http2.e$b r3 = r2.g     // Catch: java.lang.Throwable -> L2e
            r3.f = r1     // Catch: java.lang.Throwable -> L2e
        L1c:
            boolean r3 = r2.k()     // Catch: java.lang.Throwable -> L2e
            r2.notifyAll()     // Catch: java.lang.Throwable -> L2e
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L2e
            if (r3 != 0) goto L2d
            okhttp3.internal.http2.Http2Connection r3 = r2.d
            int r4 = r2.c
            r3.A(r4)
        L2d:
            return
        L2e:
            r3 = move-exception
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L2e
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http2.e.n(okhttp3.k, boolean):void");
    }

    synchronized void o(ErrorCode errorCode) {
        if (this.k == null) {
            this.k = errorCode;
            notifyAll();
        }
    }

    public synchronized k p() throws IOException {
        this.i.enter();
        while (this.e.isEmpty() && this.k == null) {
            try {
                r();
            } catch (Throwable th) {
                this.i.exitAndThrowIfTimedOut();
                throw th;
            }
        }
        this.i.exitAndThrowIfTimedOut();
        if (this.e.isEmpty()) {
            IOException iOException = this.l;
            if (iOException != null) {
                throw iOException;
            }
            throw new StreamResetException(this.k);
        }
        return this.e.removeFirst();
    }

    public synchronized k q() throws IOException {
        if (this.k != null) {
            IOException iOException = this.l;
            if (iOException != null) {
                throw iOException;
            }
            throw new StreamResetException(this.k);
        }
        b bVar = this.g;
        if (!bVar.f || !b.a(bVar).exhausted() || !b.b(this.g).exhausted()) {
            throw new IllegalStateException("too early; can't read the trailers yet");
        }
        return b.c(this.g) != null ? b.c(this.g) : okhttp3.internal.a.EMPTY_HEADERS;
    }

    void r() throws InterruptedIOException {
        try {
            wait();
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            throw new InterruptedIOException();
        }
    }

    public o s() {
        return this.j;
    }
}
