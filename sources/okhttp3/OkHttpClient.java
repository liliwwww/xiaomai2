package okhttp3;

import java.net.Proxy;
import java.net.ProxySelector;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import okhttp3.Call;
import okhttp3.EventListener;
import okhttp3.WebSocket;
import okhttp3.internal.cache.InternalCache;
import okhttp3.internal.ws.RealWebSocket;
import okhttp3.k;
import okhttp3.p;
import tb.ap;
import tb.iv3;
import tb.n43;
import tb.q92;
import tb.r33;
import tb.s96;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public class OkHttpClient implements Cloneable, Call.Factory, WebSocket.Factory {
    final Authenticator authenticator;

    @Nullable
    final ap cache;
    final int callTimeout;
    final okhttp3.internal.tls.b certificateChainCleaner;
    final c certificatePinner;
    final int connectTimeout;
    final e connectionPool;
    final List<f> connectionSpecs;
    final CookieJar cookieJar;
    final g dispatcher;
    final Dns dns;
    final EventListener.Factory eventListenerFactory;
    final boolean followRedirects;
    final boolean followSslRedirects;
    final HostnameVerifier hostnameVerifier;
    final List<Interceptor> interceptors;

    @Nullable
    final InternalCache internalCache;
    final List<Interceptor> networkInterceptors;
    final int pingInterval;
    final List<Protocol> protocols;

    @Nullable
    final Proxy proxy;
    final Authenticator proxyAuthenticator;
    final ProxySelector proxySelector;
    final int readTimeout;
    final boolean retryOnConnectionFailure;
    final SocketFactory socketFactory;
    final SSLSocketFactory sslSocketFactory;
    final int writeTimeout;
    static final List<Protocol> DEFAULT_PROTOCOLS = okhttp3.internal.a.u(Protocol.HTTP_2, Protocol.HTTP_1_1);
    static final List<f> DEFAULT_CONNECTION_SPECS = okhttp3.internal.a.u(f.MODERN_TLS, f.CLEARTEXT);

    /* compiled from: Taobao */
    class a extends q92 {
        a() {
        }

        public void a(k.a aVar, String str) {
            aVar.b(str);
        }

        public void b(k.a aVar, String str, String str2) {
            aVar.c(str, str2);
        }

        public void c(f fVar, SSLSocket sSLSocket, boolean z) {
            fVar.a(sSLSocket, z);
        }

        public int d(p.a aVar) {
            return aVar.c;
        }

        public boolean e(okhttp3.a aVar, okhttp3.a aVar2) {
            return aVar.d(aVar2);
        }

        @Nullable
        public okhttp3.internal.connection.c f(p pVar) {
            return pVar.m;
        }

        public void g(p.a aVar, okhttp3.internal.connection.c cVar) {
            aVar.k(cVar);
        }

        public Call h(OkHttpClient okHttpClient, n nVar) {
            return RealCall.newRealCall(okHttpClient, nVar, true);
        }

        public okhttp3.internal.connection.f i(e eVar) {
            return eVar.a;
        }
    }

    static {
        q92.a = new a();
    }

    public OkHttpClient() {
        this(new b());
    }

    private static SSLSocketFactory newSslSocketFactory(X509TrustManager x509TrustManager) {
        try {
            SSLContext k = iv3.j().k();
            k.init(null, new TrustManager[]{x509TrustManager}, null);
            return k.getSocketFactory();
        } catch (GeneralSecurityException e) {
            throw new AssertionError("No System TLS", e);
        }
    }

    public Authenticator authenticator() {
        return this.authenticator;
    }

    @Nullable
    public ap cache() {
        return this.cache;
    }

    public int callTimeoutMillis() {
        return this.callTimeout;
    }

    public c certificatePinner() {
        return this.certificatePinner;
    }

    public int connectTimeoutMillis() {
        return this.connectTimeout;
    }

    public e connectionPool() {
        return this.connectionPool;
    }

    public List<f> connectionSpecs() {
        return this.connectionSpecs;
    }

    public CookieJar cookieJar() {
        return this.cookieJar;
    }

    public g dispatcher() {
        return this.dispatcher;
    }

    public Dns dns() {
        return this.dns;
    }

    public EventListener.Factory eventListenerFactory() {
        return this.eventListenerFactory;
    }

    public boolean followRedirects() {
        return this.followRedirects;
    }

    public boolean followSslRedirects() {
        return this.followSslRedirects;
    }

    public HostnameVerifier hostnameVerifier() {
        return this.hostnameVerifier;
    }

    public List<Interceptor> interceptors() {
        return this.interceptors;
    }

    @Nullable
    InternalCache internalCache() {
        return this.internalCache;
    }

    public List<Interceptor> networkInterceptors() {
        return this.networkInterceptors;
    }

    public b newBuilder() {
        return new b(this);
    }

    public Call newCall(n nVar) {
        return RealCall.newRealCall(this, nVar, false);
    }

    @Override // okhttp3.WebSocket.Factory
    public WebSocket newWebSocket(n nVar, s96 s96Var) {
        RealWebSocket realWebSocket = new RealWebSocket(nVar, s96Var, new Random(), this.pingInterval);
        realWebSocket.d(this);
        return realWebSocket;
    }

    public int pingIntervalMillis() {
        return this.pingInterval;
    }

    public List<Protocol> protocols() {
        return this.protocols;
    }

    @Nullable
    public Proxy proxy() {
        return this.proxy;
    }

    public Authenticator proxyAuthenticator() {
        return this.proxyAuthenticator;
    }

    public ProxySelector proxySelector() {
        return this.proxySelector;
    }

    public int readTimeoutMillis() {
        return this.readTimeout;
    }

    public boolean retryOnConnectionFailure() {
        return this.retryOnConnectionFailure;
    }

    public SocketFactory socketFactory() {
        return this.socketFactory;
    }

    public SSLSocketFactory sslSocketFactory() {
        return this.sslSocketFactory;
    }

    public int writeTimeoutMillis() {
        return this.writeTimeout;
    }

    OkHttpClient(b bVar) {
        boolean z;
        this.dispatcher = bVar.a;
        this.proxy = bVar.b;
        this.protocols = bVar.c;
        List<f> list = bVar.d;
        this.connectionSpecs = list;
        this.interceptors = okhttp3.internal.a.t(bVar.e);
        this.networkInterceptors = okhttp3.internal.a.t(bVar.f);
        this.eventListenerFactory = bVar.g;
        this.proxySelector = bVar.h;
        this.cookieJar = bVar.i;
        this.internalCache = bVar.j;
        this.socketFactory = bVar.k;
        Iterator<f> it = list.iterator();
        loop0: while (true) {
            while (it.hasNext()) {
                z = z || it.next().d();
            }
        }
        SSLSocketFactory sSLSocketFactory = bVar.l;
        if (sSLSocketFactory == null && z) {
            X509TrustManager D = okhttp3.internal.a.D();
            this.sslSocketFactory = newSslSocketFactory(D);
            this.certificateChainCleaner = okhttp3.internal.tls.b.b(D);
        } else {
            this.sslSocketFactory = sSLSocketFactory;
            this.certificateChainCleaner = bVar.m;
        }
        if (this.sslSocketFactory != null) {
            iv3.j().f(this.sslSocketFactory);
        }
        this.hostnameVerifier = bVar.n;
        this.certificatePinner = bVar.o.f(this.certificateChainCleaner);
        this.proxyAuthenticator = bVar.p;
        this.authenticator = bVar.q;
        this.connectionPool = bVar.r;
        this.dns = bVar.s;
        this.followSslRedirects = bVar.t;
        this.followRedirects = bVar.u;
        this.retryOnConnectionFailure = bVar.v;
        this.callTimeout = bVar.w;
        this.connectTimeout = bVar.x;
        this.readTimeout = bVar.y;
        this.writeTimeout = bVar.z;
        this.pingInterval = bVar.A;
        if (this.interceptors.contains(null)) {
            throw new IllegalStateException("Null interceptor: " + this.interceptors);
        }
        if (this.networkInterceptors.contains(null)) {
            throw new IllegalStateException("Null network interceptor: " + this.networkInterceptors);
        }
    }

    /* compiled from: Taobao */
    public static final class b {
        int A;
        g a;

        @Nullable
        Proxy b;
        List<Protocol> c;
        List<f> d;
        final List<Interceptor> e;
        final List<Interceptor> f;
        EventListener.Factory g;
        ProxySelector h;
        CookieJar i;

        @Nullable
        InternalCache j;
        SocketFactory k;

        @Nullable
        SSLSocketFactory l;

        @Nullable
        okhttp3.internal.tls.b m;
        HostnameVerifier n;
        c o;
        Authenticator p;
        Authenticator q;
        e r;
        Dns s;
        boolean t;
        boolean u;
        boolean v;
        int w;
        int x;
        int y;
        int z;

        public b() {
            this.e = new ArrayList();
            this.f = new ArrayList();
            this.a = new g();
            this.c = OkHttpClient.DEFAULT_PROTOCOLS;
            this.d = OkHttpClient.DEFAULT_CONNECTION_SPECS;
            this.g = EventListener.l(EventListener.NONE);
            ProxySelector proxySelector = ProxySelector.getDefault();
            this.h = proxySelector;
            if (proxySelector == null) {
                this.h = new r33();
            }
            this.i = CookieJar.NO_COOKIES;
            this.k = SocketFactory.getDefault();
            this.n = n43.INSTANCE;
            this.o = c.DEFAULT;
            Authenticator authenticator = Authenticator.NONE;
            this.p = authenticator;
            this.q = authenticator;
            this.r = new e();
            this.s = Dns.SYSTEM;
            this.t = true;
            this.u = true;
            this.v = true;
            this.w = 0;
            this.x = 10000;
            this.y = 10000;
            this.z = 10000;
            this.A = 0;
        }

        public b a(Interceptor interceptor) {
            if (interceptor == null) {
                throw new IllegalArgumentException("interceptor == null");
            }
            this.e.add(interceptor);
            return this;
        }

        public OkHttpClient b() {
            return new OkHttpClient(this);
        }

        public b c(@Nullable ap apVar) {
            this.j = null;
            return this;
        }

        public b d(long j, TimeUnit timeUnit) {
            this.x = okhttp3.internal.a.e("timeout", j, timeUnit);
            return this;
        }

        public b e(List<f> list) {
            this.d = okhttp3.internal.a.t(list);
            return this;
        }

        public b f(Dns dns) {
            Objects.requireNonNull(dns, "dns == null");
            this.s = dns;
            return this;
        }

        public b g(EventListener eventListener) {
            Objects.requireNonNull(eventListener, "eventListener == null");
            this.g = EventListener.l(eventListener);
            return this;
        }

        public b h(HostnameVerifier hostnameVerifier) {
            Objects.requireNonNull(hostnameVerifier, "hostnameVerifier == null");
            this.n = hostnameVerifier;
            return this;
        }

        public b i(List<Protocol> list) {
            ArrayList arrayList = new ArrayList(list);
            Protocol protocol = Protocol.H2_PRIOR_KNOWLEDGE;
            if (!arrayList.contains(protocol) && !arrayList.contains(Protocol.HTTP_1_1)) {
                throw new IllegalArgumentException("protocols must contain h2_prior_knowledge or http/1.1: " + arrayList);
            }
            if (arrayList.contains(protocol) && arrayList.size() > 1) {
                throw new IllegalArgumentException("protocols containing h2_prior_knowledge cannot use other protocols: " + arrayList);
            }
            if (arrayList.contains(Protocol.HTTP_1_0)) {
                throw new IllegalArgumentException("protocols must not contain http/1.0: " + arrayList);
            }
            if (arrayList.contains(null)) {
                throw new IllegalArgumentException("protocols must not contain null");
            }
            arrayList.remove(Protocol.SPDY_3);
            this.c = Collections.unmodifiableList(arrayList);
            return this;
        }

        public b j(long j, TimeUnit timeUnit) {
            this.y = okhttp3.internal.a.e("timeout", j, timeUnit);
            return this;
        }

        public b k(SSLSocketFactory sSLSocketFactory, X509TrustManager x509TrustManager) {
            Objects.requireNonNull(sSLSocketFactory, "sslSocketFactory == null");
            Objects.requireNonNull(x509TrustManager, "trustManager == null");
            this.l = sSLSocketFactory;
            this.m = okhttp3.internal.tls.b.b(x509TrustManager);
            return this;
        }

        public b l(long j, TimeUnit timeUnit) {
            this.z = okhttp3.internal.a.e("timeout", j, timeUnit);
            return this;
        }

        b(OkHttpClient okHttpClient) {
            ArrayList arrayList = new ArrayList();
            this.e = arrayList;
            ArrayList arrayList2 = new ArrayList();
            this.f = arrayList2;
            this.a = okHttpClient.dispatcher;
            this.b = okHttpClient.proxy;
            this.c = okHttpClient.protocols;
            this.d = okHttpClient.connectionSpecs;
            arrayList.addAll(okHttpClient.interceptors);
            arrayList2.addAll(okHttpClient.networkInterceptors);
            this.g = okHttpClient.eventListenerFactory;
            this.h = okHttpClient.proxySelector;
            this.i = okHttpClient.cookieJar;
            this.j = okHttpClient.internalCache;
            this.k = okHttpClient.socketFactory;
            this.l = okHttpClient.sslSocketFactory;
            this.m = okHttpClient.certificateChainCleaner;
            this.n = okHttpClient.hostnameVerifier;
            this.o = okHttpClient.certificatePinner;
            this.p = okHttpClient.proxyAuthenticator;
            this.q = okHttpClient.authenticator;
            this.r = okHttpClient.connectionPool;
            this.s = okHttpClient.dns;
            this.t = okHttpClient.followSslRedirects;
            this.u = okHttpClient.followRedirects;
            this.v = okHttpClient.retryOnConnectionFailure;
            this.w = okHttpClient.callTimeout;
            this.x = okHttpClient.connectTimeout;
            this.y = okHttpClient.readTimeout;
            this.z = okHttpClient.writeTimeout;
            this.A = okHttpClient.pingInterval;
        }
    }
}
