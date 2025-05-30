package okhttp3.internal.ws;

import android.taobao.windvane.service.WVEventId;
import java.io.IOException;
import java.net.ProtocolException;
import java.net.SocketTimeoutException;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import okhttp3.Call;
import okhttp3.EventListener;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.WebSocket;
import okhttp3.internal.a;
import okhttp3.internal.connection.c;
import okhttp3.internal.ws.WebSocketReader;
import okhttp3.n;
import okhttp3.p;
import okio.BufferedSink;
import okio.ByteString;
import okio.h;
import tb.q92;
import tb.s96;
import tb.z84;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class RealWebSocket implements WebSocket, WebSocketReader.FrameCallback {
    private static final List<Protocol> x = Collections.singletonList(Protocol.HTTP_1_1);
    private final n a;
    final s96 b;
    private final Random c;
    private final long d;
    private final String e;
    private Call f;
    private final Runnable g;
    private WebSocketReader h;
    private b i;
    private ScheduledExecutorService j;
    private d k;
    private long n;
    private boolean o;
    private ScheduledFuture<?> p;
    private String r;
    private boolean s;
    private int t;
    private int u;
    private int v;
    private boolean w;
    private final ArrayDeque<ByteString> l = new ArrayDeque<>();
    private final ArrayDeque<Object> m = new ArrayDeque<>();
    private int q = -1;

    /* compiled from: Taobao */
    final class CancelRunnable implements Runnable {
        CancelRunnable() {
        }

        @Override // java.lang.Runnable
        public void run() {
            RealWebSocket.this.cancel();
        }
    }

    /* compiled from: Taobao */
    private final class PingRunnable implements Runnable {
        PingRunnable() {
        }

        @Override // java.lang.Runnable
        public void run() {
            RealWebSocket.this.k();
        }
    }

    public RealWebSocket(n nVar, s96 s96Var, Random random, long j) {
        if (!"GET".equals(nVar.f())) {
            throw new IllegalArgumentException("Request must be GET: " + nVar.f());
        }
        this.a = nVar;
        this.c = random;
        this.d = j;
        byte[] bArr = new byte[16];
        random.nextBytes(bArr);
        this.e = ByteString.of(bArr).base64();
        this.g = new z84(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g() {
        do {
            try {
            } catch (IOException e) {
                e(e, null);
                return;
            }
        } while (j());
    }

    private void h() {
        ScheduledExecutorService scheduledExecutorService = this.j;
        if (scheduledExecutorService != null) {
            scheduledExecutorService.execute(this.g);
        }
    }

    private synchronized boolean i(ByteString byteString, int i) {
        if (!this.s && !this.o) {
            if (this.n + byteString.size() > 16777216) {
                close(WVEventId.PAGE_Started, null);
                return false;
            }
            this.n += byteString.size();
            this.m.add(new c(i, byteString));
            h();
            return true;
        }
        return false;
    }

    void b(p pVar, @Nullable c cVar) throws IOException {
        if (pVar.e() != 101) {
            throw new ProtocolException("Expected HTTP 101 response but was '" + pVar.e() + " " + pVar.k() + "'");
        }
        String g = pVar.g("Connection");
        if (!"Upgrade".equalsIgnoreCase(g)) {
            throw new ProtocolException("Expected 'Connection' header value 'Upgrade' but was '" + g + "'");
        }
        String g2 = pVar.g("Upgrade");
        if (!"websocket".equalsIgnoreCase(g2)) {
            throw new ProtocolException("Expected 'Upgrade' header value 'websocket' but was '" + g2 + "'");
        }
        String g3 = pVar.g("Sec-WebSocket-Accept");
        String base64 = ByteString.encodeUtf8(this.e + "258EAFA5-E914-47DA-95CA-C5AB0DC85B11").sha1().base64();
        if (base64.equals(g3)) {
            if (cVar == null) {
                throw new ProtocolException("Web Socket exchange missing: bad interceptor?");
            }
            return;
        }
        throw new ProtocolException("Expected 'Sec-WebSocket-Accept' header value '" + base64 + "' but was '" + g3 + "'");
    }

    synchronized boolean c(int i, String str, long j) {
        a.c(i);
        ByteString byteString = null;
        if (str != null) {
            byteString = ByteString.encodeUtf8(str);
            if (byteString.size() > 123) {
                throw new IllegalArgumentException("reason.size() > 123: " + str);
            }
        }
        if (!this.s && !this.o) {
            this.o = true;
            this.m.add(new b(i, byteString, j));
            h();
            return true;
        }
        return false;
    }

    public void cancel() {
        this.f.cancel();
    }

    public boolean close(int i, String str) {
        return c(i, str, 60000L);
    }

    public void d(OkHttpClient okHttpClient) {
        OkHttpClient b = okHttpClient.newBuilder().g(EventListener.NONE).i(x).b();
        n a = this.a.g().c("Upgrade", "websocket").c("Connection", "Upgrade").c("Sec-WebSocket-Key", this.e).c("Sec-WebSocket-Version", "13").a();
        Call h = q92.a.h(b, a);
        this.f = h;
        h.enqueue(new a(this, a));
    }

    public void e(Exception exc, @Nullable p pVar) {
        synchronized (this) {
            if (this.s) {
                return;
            }
            this.s = true;
            d dVar = this.k;
            this.k = null;
            ScheduledFuture<?> scheduledFuture = this.p;
            if (scheduledFuture != null) {
                scheduledFuture.cancel(false);
            }
            ScheduledExecutorService scheduledExecutorService = this.j;
            if (scheduledExecutorService != null) {
                scheduledExecutorService.shutdown();
            }
            try {
                throw null;
            } catch (Throwable th) {
                a.g(dVar);
                throw th;
            }
        }
    }

    public void f(String str, d dVar) throws IOException {
        synchronized (this) {
            this.k = dVar;
            this.i = new b(dVar.a, dVar.c, this.c);
            ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1, a.I(str, false));
            this.j = scheduledThreadPoolExecutor;
            if (this.d != 0) {
                PingRunnable pingRunnable = new PingRunnable();
                long j = this.d;
                scheduledThreadPoolExecutor.scheduleAtFixedRate(pingRunnable, j, j, TimeUnit.MILLISECONDS);
            }
            if (!this.m.isEmpty()) {
                h();
            }
        }
        this.h = new WebSocketReader(dVar.a, dVar.b, this);
    }

    boolean j() throws IOException {
        d dVar;
        Object obj;
        synchronized (this) {
            if (this.s) {
                return false;
            }
            b bVar = this.i;
            ByteString poll = this.l.poll();
            if (poll == null) {
                obj = this.m.poll();
                if (obj instanceof b) {
                    if (this.q != -1) {
                        dVar = this.k;
                        this.k = null;
                        this.j.shutdown();
                    } else {
                        this.p = this.j.schedule(new CancelRunnable(), ((b) obj).c, TimeUnit.MILLISECONDS);
                    }
                } else if (obj == null) {
                    return false;
                }
                dVar = null;
            } else {
                dVar = null;
                obj = null;
            }
            try {
                if (poll != null) {
                    bVar.f(poll);
                } else if (obj instanceof c) {
                    ByteString byteString = ((c) obj).b;
                    BufferedSink b = h.b(bVar.a(((c) obj).a, byteString.size()));
                    b.write(byteString);
                    b.close();
                    synchronized (this) {
                        this.n -= byteString.size();
                    }
                } else {
                    if (!(obj instanceof b)) {
                        throw new AssertionError();
                    }
                    b bVar2 = (b) obj;
                    bVar.b(bVar2.a, bVar2.b);
                    if (dVar != null) {
                        throw null;
                    }
                }
                return true;
            } finally {
                a.g(dVar);
            }
        }
    }

    void k() {
        synchronized (this) {
            if (this.s) {
                return;
            }
            b bVar = this.i;
            int i = this.w ? this.t : -1;
            this.t++;
            this.w = true;
            if (i == -1) {
                try {
                    bVar.e(ByteString.EMPTY);
                    return;
                } catch (IOException e) {
                    e(e, null);
                    return;
                }
            }
            e(new SocketTimeoutException("sent ping but didn't receive pong within " + this.d + "ms (after " + (i - 1) + " successful ping/pongs)"), null);
        }
    }

    @Override // okhttp3.internal.ws.WebSocketReader.FrameCallback
    public void onReadClose(int i, String str) {
        d dVar;
        if (i == -1) {
            throw new IllegalArgumentException();
        }
        synchronized (this) {
            if (this.q != -1) {
                throw new IllegalStateException("already closed");
            }
            this.q = i;
            this.r = str;
            if (this.o && this.m.isEmpty()) {
                dVar = this.k;
                this.k = null;
                ScheduledFuture<?> scheduledFuture = this.p;
                if (scheduledFuture != null) {
                    scheduledFuture.cancel(false);
                }
                this.j.shutdown();
            } else {
                dVar = null;
            }
        }
        try {
            throw null;
        } catch (Throwable th) {
            a.g(dVar);
            throw th;
        }
    }

    @Override // okhttp3.internal.ws.WebSocketReader.FrameCallback
    public void onReadMessage(String str) throws IOException {
        throw null;
    }

    @Override // okhttp3.internal.ws.WebSocketReader.FrameCallback
    public synchronized void onReadPing(ByteString byteString) {
        if (!this.s && (!this.o || !this.m.isEmpty())) {
            this.l.add(byteString);
            h();
            this.u++;
        }
    }

    @Override // okhttp3.internal.ws.WebSocketReader.FrameCallback
    public synchronized void onReadPong(ByteString byteString) {
        this.v++;
        this.w = false;
    }

    public synchronized long queueSize() {
        return this.n;
    }

    public n request() {
        return this.a;
    }

    public boolean send(String str) {
        Objects.requireNonNull(str, "text == null");
        return i(ByteString.encodeUtf8(str), 1);
    }

    @Override // okhttp3.internal.ws.WebSocketReader.FrameCallback
    public void onReadMessage(ByteString byteString) throws IOException {
        throw null;
    }

    public boolean send(ByteString byteString) {
        Objects.requireNonNull(byteString, "bytes == null");
        return i(byteString, 2);
    }
}
