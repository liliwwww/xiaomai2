package okhttp3.internal.http2;

import java.io.EOFException;
import java.io.IOException;
import okhttp3.k;
import okio.Buffer;
import okio.BufferedSource;
import okio.Source;
import okio.o;

/* JADX INFO: Access modifiers changed from: private */
/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class e$b implements Source {
    private final Buffer a = new Buffer();
    private final Buffer b = new Buffer();
    private final long c;
    private k d;
    boolean e;
    boolean f;
    final /* synthetic */ e g;

    e$b(e eVar, long j) {
        this.g = eVar;
        this.c = j;
    }

    private void f(long j) {
        this.g.d.F(j);
    }

    public void close() throws IOException {
        long size;
        synchronized (this.g) {
            this.e = true;
            size = this.b.size();
            this.b.clear();
            this.g.notifyAll();
        }
        if (size > 0) {
            f(size);
        }
        this.g.b();
    }

    void e(BufferedSource bufferedSource, long j) throws IOException {
        boolean z;
        boolean z2;
        boolean z3;
        long j2;
        while (j > 0) {
            synchronized (this.g) {
                z = this.f;
                z2 = true;
                z3 = this.b.size() + j > this.c;
            }
            if (z3) {
                bufferedSource.skip(j);
                this.g.f(ErrorCode.FLOW_CONTROL_ERROR);
                return;
            }
            if (z) {
                bufferedSource.skip(j);
                return;
            }
            long read = bufferedSource.read(this.a, j);
            if (read == -1) {
                throw new EOFException();
            }
            j -= read;
            synchronized (this.g) {
                if (this.e) {
                    j2 = this.a.size();
                    this.a.clear();
                } else {
                    if (this.b.size() != 0) {
                        z2 = false;
                    }
                    this.b.writeAll(this.a);
                    if (z2) {
                        this.g.notifyAll();
                    }
                    j2 = 0;
                }
            }
            if (j2 > 0) {
                f(j2);
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
        To view partially-correct add '--show-bad-code' argument
    */
    public long read(okio.Buffer r11, long r12) throws java.io.IOException {
        /*
            r10 = this;
            r0 = 0
            int r2 = (r12 > r0 ? 1 : (r12 == r0 ? 0 : -1))
            if (r2 < 0) goto La8
        L6:
            r2 = 0
            okhttp3.internal.http2.e r3 = r10.g
            monitor-enter(r3)
            okhttp3.internal.http2.e r4 = r10.g     // Catch: java.lang.Throwable -> La5
            okhttp3.internal.http2.e$c r4 = r4.i     // Catch: java.lang.Throwable -> La5
            r4.enter()     // Catch: java.lang.Throwable -> La5
            okhttp3.internal.http2.e r4 = r10.g     // Catch: java.lang.Throwable -> L9c
            okhttp3.internal.http2.ErrorCode r5 = r4.k     // Catch: java.lang.Throwable -> L9c
            if (r5 == 0) goto L25
            java.io.IOException r2 = r4.l     // Catch: java.lang.Throwable -> L9c
            if (r2 == 0) goto L1c
            goto L25
        L1c:
            okhttp3.internal.http2.StreamResetException r2 = new okhttp3.internal.http2.StreamResetException     // Catch: java.lang.Throwable -> L9c
            okhttp3.internal.http2.e r4 = r10.g     // Catch: java.lang.Throwable -> L9c
            okhttp3.internal.http2.ErrorCode r4 = r4.k     // Catch: java.lang.Throwable -> L9c
            r2.<init>(r4)     // Catch: java.lang.Throwable -> L9c
        L25:
            boolean r4 = r10.e     // Catch: java.lang.Throwable -> L9c
            if (r4 != 0) goto L94
            okio.Buffer r4 = r10.b     // Catch: java.lang.Throwable -> L9c
            long r4 = r4.size()     // Catch: java.lang.Throwable -> L9c
            r6 = -1
            int r8 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
            if (r8 <= 0) goto L6b
            okio.Buffer r4 = r10.b     // Catch: java.lang.Throwable -> L9c
            long r8 = r4.size()     // Catch: java.lang.Throwable -> L9c
            long r12 = java.lang.Math.min(r12, r8)     // Catch: java.lang.Throwable -> L9c
            long r11 = r4.read(r11, r12)     // Catch: java.lang.Throwable -> L9c
            okhttp3.internal.http2.e r13 = r10.g     // Catch: java.lang.Throwable -> L9c
            long r4 = r13.a     // Catch: java.lang.Throwable -> L9c
            long r4 = r4 + r11
            r13.a = r4     // Catch: java.lang.Throwable -> L9c
            if (r2 != 0) goto L80
            okhttp3.internal.http2.Http2Connection r13 = r13.d     // Catch: java.lang.Throwable -> L9c
            okhttp3.internal.http2.h r13 = r13.s     // Catch: java.lang.Throwable -> L9c
            int r13 = r13.d()     // Catch: java.lang.Throwable -> L9c
            int r13 = r13 / 2
            long r8 = (long) r13     // Catch: java.lang.Throwable -> L9c
            int r13 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1))
            if (r13 < 0) goto L80
            okhttp3.internal.http2.e r13 = r10.g     // Catch: java.lang.Throwable -> L9c
            okhttp3.internal.http2.Http2Connection r4 = r13.d     // Catch: java.lang.Throwable -> L9c
            int r5 = r13.c     // Catch: java.lang.Throwable -> L9c
            long r8 = r13.a     // Catch: java.lang.Throwable -> L9c
            r4.L(r5, r8)     // Catch: java.lang.Throwable -> L9c
            okhttp3.internal.http2.e r13 = r10.g     // Catch: java.lang.Throwable -> L9c
            r13.a = r0     // Catch: java.lang.Throwable -> L9c
            goto L80
        L6b:
            boolean r4 = r10.f     // Catch: java.lang.Throwable -> L9c
            if (r4 != 0) goto L7f
            if (r2 != 0) goto L7f
            okhttp3.internal.http2.e r2 = r10.g     // Catch: java.lang.Throwable -> L9c
            r2.r()     // Catch: java.lang.Throwable -> L9c
            okhttp3.internal.http2.e r2 = r10.g     // Catch: java.lang.Throwable -> La5
            okhttp3.internal.http2.e$c r2 = r2.i     // Catch: java.lang.Throwable -> La5
            r2.exitAndThrowIfTimedOut()     // Catch: java.lang.Throwable -> La5
            monitor-exit(r3)     // Catch: java.lang.Throwable -> La5
            goto L6
        L7f:
            r11 = r6
        L80:
            okhttp3.internal.http2.e r13 = r10.g     // Catch: java.lang.Throwable -> La5
            okhttp3.internal.http2.e$c r13 = r13.i     // Catch: java.lang.Throwable -> La5
            r13.exitAndThrowIfTimedOut()     // Catch: java.lang.Throwable -> La5
            monitor-exit(r3)     // Catch: java.lang.Throwable -> La5
            int r13 = (r11 > r6 ? 1 : (r11 == r6 ? 0 : -1))
            if (r13 == 0) goto L90
            r10.f(r11)
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
            okhttp3.internal.http2.e r12 = r10.g     // Catch: java.lang.Throwable -> La5
            okhttp3.internal.http2.e$c r12 = r12.i     // Catch: java.lang.Throwable -> La5
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
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http2.e$b.read(okio.Buffer, long):long");
    }

    public o timeout() {
        return this.g.i;
    }
}
