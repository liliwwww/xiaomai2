package okhttp3.internal.p011ws;

import android.taobao.windvane.monitor.WVPackageMonitorInterface;
import java.io.Closeable;
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
import okhttp3.C1474n;
import okhttp3.C1476p;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.EventListener;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.WebSocket;
import okhttp3.internal.C1421a;
import okhttp3.internal.connection.C1427c;
import okhttp3.internal.p011ws.WebSocketReader;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;
import okio.h;
import tb.q92;
import tb.s96;
import tb.z84;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public final class RealWebSocket implements WebSocket, WebSocketReader.FrameCallback {

    /* renamed from: x */
    private static final List<Protocol> f818x = Collections.singletonList(Protocol.HTTP_1_1);

    /* renamed from: a */
    private final C1474n f819a;

    /* renamed from: b */
    final s96 f820b;

    /* renamed from: c */
    private final Random f821c;

    /* renamed from: d */
    private final long f822d;

    /* renamed from: e */
    private final String f823e;

    /* renamed from: f */
    private Call f824f;

    /* renamed from: g */
    private final Runnable f825g;

    /* renamed from: h */
    private WebSocketReader f826h;

    /* renamed from: i */
    private C1469b f827i;

    /* renamed from: j */
    private ScheduledExecutorService f828j;

    /* renamed from: k */
    private AbstractC1467d f829k;

    /* renamed from: n */
    private long f832n;

    /* renamed from: o */
    private boolean f833o;

    /* renamed from: p */
    private ScheduledFuture<?> f834p;

    /* renamed from: r */
    private String f836r;

    /* renamed from: s */
    private boolean f837s;

    /* renamed from: t */
    private int f838t;

    /* renamed from: u */
    private int f839u;

    /* renamed from: v */
    private int f840v;

    /* renamed from: w */
    private boolean f841w;

    /* renamed from: l */
    private final ArrayDeque<ByteString> f830l = new ArrayDeque<>();

    /* renamed from: m */
    private final ArrayDeque<Object> f831m = new ArrayDeque<>();

    /* renamed from: q */
    private int f835q = -1;

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
            RealWebSocket.this.m761k();
        }
    }

    /* compiled from: Taobao */
    /* renamed from: okhttp3.internal.ws.RealWebSocket$a */
    /* loaded from: classes2.dex */
    class C1464a implements Callback {

        /* renamed from: a */
        final /* synthetic */ C1474n f842a;

        C1464a(C1474n c1474n) {
            this.f842a = c1474n;
        }

        @Override // okhttp3.Callback
        public void onFailure(Call call, IOException iOException) {
            RealWebSocket.this.m758e(iOException, null);
        }

        @Override // okhttp3.Callback
        public void onResponse(Call call, C1476p c1476p) {
            C1427c f = q92.a.f(c1476p);
            try {
                RealWebSocket.this.m755b(c1476p, f);
                try {
                    RealWebSocket.this.m759f("OkHttp WebSocket " + this.f842a.m858h().m806A(), f.m513i());
                    s96 s96Var = RealWebSocket.this.f820b;
                    throw null;
                } catch (Exception e) {
                    RealWebSocket.this.m758e(e, null);
                }
            } catch (IOException e2) {
                if (f != null) {
                    f.m521q();
                }
                RealWebSocket.this.m758e(e2, c1476p);
                C1421a.m470g(c1476p);
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: okhttp3.internal.ws.RealWebSocket$b */
    /* loaded from: classes2.dex */
    static final class C1465b {

        /* renamed from: a */
        final int f844a;

        /* renamed from: b */
        final ByteString f845b;

        /* renamed from: c */
        final long f846c;

        C1465b(int i, ByteString byteString, long j) {
            this.f844a = i;
            this.f845b = byteString;
            this.f846c = j;
        }
    }

    /* compiled from: Taobao */
    /* renamed from: okhttp3.internal.ws.RealWebSocket$c */
    /* loaded from: classes2.dex */
    static final class C1466c {

        /* renamed from: a */
        final int f847a;

        /* renamed from: b */
        final ByteString f848b;

        C1466c(int i, ByteString byteString) {
            this.f847a = i;
            this.f848b = byteString;
        }
    }

    /* compiled from: Taobao */
    /* renamed from: okhttp3.internal.ws.RealWebSocket$d */
    /* loaded from: classes2.dex */
    public static abstract class AbstractC1467d implements Closeable {

        /* renamed from: a */
        public final boolean f849a;

        /* renamed from: b */
        public final BufferedSource f850b;

        /* renamed from: c */
        public final BufferedSink f851c;

        public AbstractC1467d(boolean z, BufferedSource bufferedSource, BufferedSink bufferedSink) {
            this.f849a = z;
            this.f850b = bufferedSource;
            this.f851c = bufferedSink;
        }
    }

    public RealWebSocket(C1474n c1474n, s96 s96Var, Random random, long j) {
        if (!"GET".equals(c1474n.m856f())) {
            throw new IllegalArgumentException("Request must be GET: " + c1474n.m856f());
        }
        this.f819a = c1474n;
        this.f821c = random;
        this.f822d = j;
        byte[] bArr = new byte[16];
        random.nextBytes(bArr);
        this.f823e = ByteString.of(bArr).base64();
        this.f825g = new z84(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g */
    public /* synthetic */ void m752g() {
        do {
            try {
            } catch (IOException e) {
                m758e(e, null);
                return;
            }
        } while (m760j());
    }

    /* renamed from: h */
    private void m753h() {
        ScheduledExecutorService scheduledExecutorService = this.f828j;
        if (scheduledExecutorService != null) {
            scheduledExecutorService.execute(this.f825g);
        }
    }

    /* renamed from: i */
    private synchronized boolean m754i(ByteString byteString, int i) {
        if (!this.f837s && !this.f833o) {
            if (this.f832n + byteString.size() > 16777216) {
                close(1001, null);
                return false;
            }
            this.f832n += byteString.size();
            this.f831m.add(new C1466c(i, byteString));
            m753h();
            return true;
        }
        return false;
    }

    /* renamed from: b */
    void m755b(C1476p c1476p, @Nullable C1427c c1427c) throws IOException {
        if (c1476p.m875e() != 101) {
            throw new ProtocolException("Expected HTTP 101 response but was '" + c1476p.m875e() + " " + c1476p.m880k() + "'");
        }
        String m877g = c1476p.m877g("Connection");
        if (!"Upgrade".equalsIgnoreCase(m877g)) {
            throw new ProtocolException("Expected 'Connection' header value 'Upgrade' but was '" + m877g + "'");
        }
        String m877g2 = c1476p.m877g("Upgrade");
        if (!"websocket".equalsIgnoreCase(m877g2)) {
            throw new ProtocolException("Expected 'Upgrade' header value 'websocket' but was '" + m877g2 + "'");
        }
        String m877g3 = c1476p.m877g("Sec-WebSocket-Accept");
        String base64 = ByteString.encodeUtf8(this.f823e + "258EAFA5-E914-47DA-95CA-C5AB0DC85B11").sha1().base64();
        if (base64.equals(m877g3)) {
            if (c1427c == null) {
                throw new ProtocolException("Web Socket exchange missing: bad interceptor?");
            }
            return;
        }
        throw new ProtocolException("Expected 'Sec-WebSocket-Accept' header value '" + base64 + "' but was '" + m877g3 + "'");
    }

    /* renamed from: c */
    synchronized boolean m756c(int i, String str, long j) {
        C1468a.m764c(i);
        ByteString byteString = null;
        if (str != null) {
            byteString = ByteString.encodeUtf8(str);
            if (byteString.size() > 123) {
                throw new IllegalArgumentException("reason.size() > 123: " + str);
            }
        }
        if (!this.f837s && !this.f833o) {
            this.f833o = true;
            this.f831m.add(new C1465b(i, byteString, j));
            m753h();
            return true;
        }
        return false;
    }

    @Override // okhttp3.WebSocket
    public void cancel() {
        this.f824f.cancel();
    }

    @Override // okhttp3.WebSocket
    public boolean close(int i, String str) {
        return m756c(i, str, 60000L);
    }

    /* renamed from: d */
    public void m757d(OkHttpClient okHttpClient) {
        OkHttpClient m382b = okHttpClient.newBuilder().m387g(EventListener.NONE).m389i(f818x).m382b();
        C1474n m859a = this.f819a.m857g().m861c("Upgrade", "websocket").m861c("Connection", "Upgrade").m861c("Sec-WebSocket-Key", this.f823e).m861c("Sec-WebSocket-Version", WVPackageMonitorInterface.MAPPING_URL_NULL_FAILED).m859a();
        Call h = q92.a.h(m382b, m859a);
        this.f824f = h;
        h.enqueue(new C1464a(m859a));
    }

    /* renamed from: e */
    public void m758e(Exception exc, @Nullable C1476p c1476p) {
        synchronized (this) {
            if (this.f837s) {
                return;
            }
            this.f837s = true;
            AbstractC1467d abstractC1467d = this.f829k;
            this.f829k = null;
            ScheduledFuture<?> scheduledFuture = this.f834p;
            if (scheduledFuture != null) {
                scheduledFuture.cancel(false);
            }
            ScheduledExecutorService scheduledExecutorService = this.f828j;
            if (scheduledExecutorService != null) {
                scheduledExecutorService.shutdown();
            }
            try {
                throw null;
            } catch (Throwable th) {
                C1421a.m470g(abstractC1467d);
                throw th;
            }
        }
    }

    /* renamed from: f */
    public void m759f(String str, AbstractC1467d abstractC1467d) throws IOException {
        synchronized (this) {
            this.f829k = abstractC1467d;
            this.f827i = new C1469b(abstractC1467d.f849a, abstractC1467d.f851c, this.f821c);
            ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1, C1421a.m459I(str, false));
            this.f828j = scheduledThreadPoolExecutor;
            if (this.f822d != 0) {
                PingRunnable pingRunnable = new PingRunnable();
                long j = this.f822d;
                scheduledThreadPoolExecutor.scheduleAtFixedRate(pingRunnable, j, j, TimeUnit.MILLISECONDS);
            }
            if (!this.f831m.isEmpty()) {
                m753h();
            }
        }
        this.f826h = new WebSocketReader(abstractC1467d.f849a, abstractC1467d.f850b, this);
    }

    /* renamed from: j */
    boolean m760j() throws IOException {
        AbstractC1467d abstractC1467d;
        Object obj;
        synchronized (this) {
            if (this.f837s) {
                return false;
            }
            C1469b c1469b = this.f827i;
            ByteString poll = this.f830l.poll();
            if (poll == null) {
                obj = this.f831m.poll();
                if (obj instanceof C1465b) {
                    if (this.f835q != -1) {
                        abstractC1467d = this.f829k;
                        this.f829k = null;
                        this.f828j.shutdown();
                    } else {
                        this.f834p = this.f828j.schedule(new CancelRunnable(), ((C1465b) obj).f846c, TimeUnit.MILLISECONDS);
                    }
                } else if (obj == null) {
                    return false;
                }
                abstractC1467d = null;
            } else {
                abstractC1467d = null;
                obj = null;
            }
            try {
                if (poll != null) {
                    c1469b.m770f(poll);
                } else if (obj instanceof C1466c) {
                    ByteString byteString = ((C1466c) obj).f848b;
                    BufferedSink b = h.b(c1469b.m766a(((C1466c) obj).f847a, byteString.size()));
                    b.write(byteString);
                    b.close();
                    synchronized (this) {
                        this.f832n -= byteString.size();
                    }
                } else {
                    if (!(obj instanceof C1465b)) {
                        throw new AssertionError();
                    }
                    C1465b c1465b = (C1465b) obj;
                    c1469b.m767b(c1465b.f844a, c1465b.f845b);
                    if (abstractC1467d != null) {
                        throw null;
                    }
                }
                return true;
            } finally {
                C1421a.m470g(abstractC1467d);
            }
        }
    }

    /* renamed from: k */
    void m761k() {
        synchronized (this) {
            if (this.f837s) {
                return;
            }
            C1469b c1469b = this.f827i;
            int i = this.f841w ? this.f838t : -1;
            this.f838t++;
            this.f841w = true;
            if (i == -1) {
                try {
                    c1469b.m769e(ByteString.EMPTY);
                    return;
                } catch (IOException e) {
                    m758e(e, null);
                    return;
                }
            }
            m758e(new SocketTimeoutException("sent ping but didn't receive pong within " + this.f822d + "ms (after " + (i - 1) + " successful ping/pongs)"), null);
        }
    }

    @Override // okhttp3.internal.ws.WebSocketReader.FrameCallback
    public void onReadClose(int i, String str) {
        AbstractC1467d abstractC1467d;
        if (i == -1) {
            throw new IllegalArgumentException();
        }
        synchronized (this) {
            if (this.f835q != -1) {
                throw new IllegalStateException("already closed");
            }
            this.f835q = i;
            this.f836r = str;
            if (this.f833o && this.f831m.isEmpty()) {
                abstractC1467d = this.f829k;
                this.f829k = null;
                ScheduledFuture<?> scheduledFuture = this.f834p;
                if (scheduledFuture != null) {
                    scheduledFuture.cancel(false);
                }
                this.f828j.shutdown();
            } else {
                abstractC1467d = null;
            }
        }
        try {
            throw null;
        } catch (Throwable th) {
            C1421a.m470g(abstractC1467d);
            throw th;
        }
    }

    @Override // okhttp3.internal.ws.WebSocketReader.FrameCallback
    public void onReadMessage(String str) throws IOException {
        throw null;
    }

    @Override // okhttp3.internal.ws.WebSocketReader.FrameCallback
    public synchronized void onReadPing(ByteString byteString) {
        if (!this.f837s && (!this.f833o || !this.f831m.isEmpty())) {
            this.f830l.add(byteString);
            m753h();
            this.f839u++;
        }
    }

    @Override // okhttp3.internal.ws.WebSocketReader.FrameCallback
    public synchronized void onReadPong(ByteString byteString) {
        this.f840v++;
        this.f841w = false;
    }

    @Override // okhttp3.WebSocket
    public synchronized long queueSize() {
        return this.f832n;
    }

    @Override // okhttp3.WebSocket
    public C1474n request() {
        return this.f819a;
    }

    @Override // okhttp3.WebSocket
    public boolean send(String str) {
        Objects.requireNonNull(str, "text == null");
        return m754i(ByteString.encodeUtf8(str), 1);
    }

    @Override // okhttp3.internal.ws.WebSocketReader.FrameCallback
    public void onReadMessage(ByteString byteString) throws IOException {
        throw null;
    }

    @Override // okhttp3.WebSocket
    public boolean send(ByteString byteString) {
        Objects.requireNonNull(byteString, "bytes == null");
        return m754i(byteString, 2);
    }
}
