package okhttp3;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicInteger;
import okhttp3.internal.NamedRunnable;
import tb.iv3;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class RealCall implements Call {
    final OkHttpClient client;
    private boolean executed;
    final boolean forWebSocket;
    final n originalRequest;
    private okhttp3.internal.connection.i transmitter;

    /* compiled from: Taobao */
    final class AsyncCall extends NamedRunnable {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private volatile AtomicInteger callsPerHost;
        private final Callback responseCallback;

        AsyncCall(Callback callback) {
            super("OkHttp %s", RealCall.this.redactedUrl());
            this.callsPerHost = new AtomicInteger(0);
            this.responseCallback = callback;
        }

        AtomicInteger callsPerHost() {
            return this.callsPerHost;
        }

        @Override // okhttp3.internal.NamedRunnable
        protected void execute() {
            Throwable th;
            boolean z;
            IOException e;
            RealCall.this.transmitter.q();
            try {
                try {
                    z = true;
                    try {
                        this.responseCallback.onResponse(RealCall.this, RealCall.this.getResponseWithInterceptorChain());
                    } catch (IOException e2) {
                        e = e2;
                        if (z) {
                            iv3.j().p(4, "Callback failure for " + RealCall.this.toLoggableString(), e);
                        } else {
                            this.responseCallback.onFailure(RealCall.this, e);
                        }
                        RealCall.this.client.dispatcher().f(this);
                    } catch (Throwable th2) {
                        th = th2;
                        RealCall.this.cancel();
                        if (!z) {
                            IOException iOException = new IOException("canceled due to " + th);
                            iOException.addSuppressed(th);
                            this.responseCallback.onFailure(RealCall.this, iOException);
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    RealCall.this.client.dispatcher().f(this);
                    throw th3;
                }
            } catch (IOException e3) {
                e = e3;
                z = false;
            } catch (Throwable th4) {
                th = th4;
                z = false;
            }
            RealCall.this.client.dispatcher().f(this);
        }

        void executeOn(ExecutorService executorService) {
            try {
                try {
                    executorService.execute(this);
                } catch (RejectedExecutionException e) {
                    InterruptedIOException interruptedIOException = new InterruptedIOException("executor rejected");
                    interruptedIOException.initCause(e);
                    RealCall.this.transmitter.l(interruptedIOException);
                    this.responseCallback.onFailure(RealCall.this, interruptedIOException);
                    RealCall.this.client.dispatcher().f(this);
                }
            } catch (Throwable th) {
                RealCall.this.client.dispatcher().f(this);
                throw th;
            }
        }

        RealCall get() {
            return RealCall.this;
        }

        String host() {
            return RealCall.this.originalRequest.h().m();
        }

        n request() {
            return RealCall.this.originalRequest;
        }

        void reuseCallsPerHostFrom(AsyncCall asyncCall) {
            this.callsPerHost = asyncCall.callsPerHost;
        }
    }

    private RealCall(OkHttpClient okHttpClient, n nVar, boolean z) {
        this.client = okHttpClient;
        this.originalRequest = nVar;
        this.forWebSocket = z;
    }

    static RealCall newRealCall(OkHttpClient okHttpClient, n nVar, boolean z) {
        RealCall realCall = new RealCall(okHttpClient, nVar, z);
        realCall.transmitter = new okhttp3.internal.connection.i(okHttpClient, realCall);
        return realCall;
    }

    public void cancel() {
        this.transmitter.d();
    }

    public void enqueue(Callback callback) {
        synchronized (this) {
            if (this.executed) {
                throw new IllegalStateException("Already Executed");
            }
            this.executed = true;
        }
        this.transmitter.b();
        this.client.dispatcher().a(new AsyncCall(callback));
    }

    public p execute() throws IOException {
        synchronized (this) {
            if (this.executed) {
                throw new IllegalStateException("Already Executed");
            }
            this.executed = true;
        }
        this.transmitter.q();
        this.transmitter.b();
        try {
            this.client.dispatcher().b(this);
            return getResponseWithInterceptorChain();
        } finally {
            this.client.dispatcher().g(this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x00a5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    okhttp3.p getResponseWithInterceptorChain() throws java.io.IOException {
        /*
            r11 = this;
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            okhttp3.OkHttpClient r0 = r11.client
            java.util.List r0 = r0.interceptors()
            r1.addAll(r0)
            okhttp3.internal.http.d r0 = new okhttp3.internal.http.d
            okhttp3.OkHttpClient r2 = r11.client
            r0.<init>(r2)
            r1.add(r0)
            okhttp3.internal.http.a r0 = new okhttp3.internal.http.a
            okhttp3.OkHttpClient r2 = r11.client
            okhttp3.CookieJar r2 = r2.cookieJar()
            r0.<init>(r2)
            r1.add(r0)
            okhttp3.internal.cache.a r0 = new okhttp3.internal.cache.a
            okhttp3.OkHttpClient r2 = r11.client
            okhttp3.internal.cache.InternalCache r2 = r2.internalCache()
            r0.<init>(r2)
            r1.add(r0)
            okhttp3.internal.connection.a r0 = new okhttp3.internal.connection.a
            okhttp3.OkHttpClient r2 = r11.client
            r0.<init>(r2)
            r1.add(r0)
            boolean r0 = r11.forWebSocket
            if (r0 != 0) goto L4b
            okhttp3.OkHttpClient r0 = r11.client
            java.util.List r0 = r0.networkInterceptors()
            r1.addAll(r0)
        L4b:
            okhttp3.internal.http.b r0 = new okhttp3.internal.http.b
            boolean r2 = r11.forWebSocket
            r0.<init>(r2)
            r1.add(r0)
            okhttp3.internal.http.c r10 = new okhttp3.internal.http.c
            okhttp3.internal.connection.i r2 = r11.transmitter
            r3 = 0
            r4 = 0
            okhttp3.n r5 = r11.originalRequest
            okhttp3.OkHttpClient r0 = r11.client
            int r7 = r0.connectTimeoutMillis()
            okhttp3.OkHttpClient r0 = r11.client
            int r8 = r0.readTimeoutMillis()
            okhttp3.OkHttpClient r0 = r11.client
            int r9 = r0.writeTimeoutMillis()
            r0 = r10
            r6 = r11
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9)
            r0 = 0
            r1 = 0
            okhttp3.n r2 = r11.originalRequest     // Catch: java.lang.Throwable -> L95 java.io.IOException -> L97
            okhttp3.p r2 = r10.proceed(r2)     // Catch: java.lang.Throwable -> L95 java.io.IOException -> L97
            okhttp3.internal.connection.i r3 = r11.transmitter     // Catch: java.lang.Throwable -> L95 java.io.IOException -> L97
            boolean r3 = r3.i()     // Catch: java.lang.Throwable -> L95 java.io.IOException -> L97
            if (r3 != 0) goto L8a
            okhttp3.internal.connection.i r0 = r11.transmitter
            r0.l(r1)
            return r2
        L8a:
            okhttp3.internal.a.g(r2)     // Catch: java.lang.Throwable -> L95 java.io.IOException -> L97
            java.io.IOException r2 = new java.io.IOException     // Catch: java.lang.Throwable -> L95 java.io.IOException -> L97
            java.lang.String r3 = "Canceled"
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L95 java.io.IOException -> L97
            throw r2     // Catch: java.lang.Throwable -> L95 java.io.IOException -> L97
        L95:
            r2 = move-exception
            goto La3
        L97:
            r0 = move-exception
            r2 = 1
            okhttp3.internal.connection.i r3 = r11.transmitter     // Catch: java.lang.Throwable -> La0
            java.io.IOException r0 = r3.l(r0)     // Catch: java.lang.Throwable -> La0
            throw r0     // Catch: java.lang.Throwable -> La0
        La0:
            r0 = move-exception
            r2 = r0
            r0 = 1
        La3:
            if (r0 != 0) goto Laa
            okhttp3.internal.connection.i r0 = r11.transmitter
            r0.l(r1)
        Laa:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.RealCall.getResponseWithInterceptorChain():okhttp3.p");
    }

    public boolean isCanceled() {
        return this.transmitter.i();
    }

    public synchronized boolean isExecuted() {
        return this.executed;
    }

    String redactedUrl() {
        return this.originalRequest.h().A();
    }

    public n request() {
        return this.originalRequest;
    }

    public okio.o timeout() {
        return this.transmitter.o();
    }

    String toLoggableString() {
        StringBuilder sb = new StringBuilder();
        sb.append(isCanceled() ? "canceled " : "");
        sb.append(this.forWebSocket ? "web socket" : "call");
        sb.append(" to ");
        sb.append(redactedUrl());
        return sb.toString();
    }

    /* renamed from: clone, reason: collision with other method in class and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public RealCall m2822clone() {
        return newRealCall(this.client, this.originalRequest, this.forWebSocket);
    }
}
