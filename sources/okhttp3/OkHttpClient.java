package okhttp3;

import android.media.IVivoSpatializer;
import android.taobao.windvane.extra.p002uc.preRender.BasePreInitManager;
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
import okhttp3.C1471k;
import okhttp3.C1476p;
import okhttp3.Call;
import okhttp3.EventListener;
import okhttp3.WebSocket;
import okhttp3.internal.C1421a;
import okhttp3.internal.cache.InternalCache;
import okhttp3.internal.connection.C1427c;
import okhttp3.internal.connection.C1430f;
import okhttp3.internal.p011ws.RealWebSocket;
import okhttp3.internal.tls.AbstractC1463b;
import tb.ap;
import tb.iv3;
import tb.n43;
import tb.q92;
import tb.r33;
import tb.s96;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class OkHttpClient implements Cloneable, Call.Factory, WebSocket.Factory {
    final Authenticator authenticator;

    @Nullable
    final ap cache;
    final int callTimeout;
    final AbstractC1463b certificateChainCleaner;
    final C1414c certificatePinner;
    final int connectTimeout;
    final C1416e connectionPool;
    final List<C1417f> connectionSpecs;
    final CookieJar cookieJar;
    final C1418g dispatcher;
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
    static final List<Protocol> DEFAULT_PROTOCOLS = C1421a.m484u(Protocol.HTTP_2, Protocol.HTTP_1_1);
    static final List<C1417f> DEFAULT_CONNECTION_SPECS = C1421a.m484u(C1417f.MODERN_TLS, C1417f.CLEARTEXT);

    /* compiled from: Taobao */
    /* renamed from: okhttp3.OkHttpClient$a */
    class C1410a extends q92 {
        C1410a() {
        }

        /* renamed from: a */
        public void m372a(C1471k.a aVar, String str) {
            aVar.m786b(str);
        }

        /* renamed from: b */
        public void m373b(C1471k.a aVar, String str, String str2) {
            aVar.m787c(str, str2);
        }

        /* renamed from: c */
        public void m374c(C1417f c1417f, SSLSocket sSLSocket, boolean z) {
            c1417f.m422a(sSLSocket, z);
        }

        /* renamed from: d */
        public int m375d(C1476p.a aVar) {
            return aVar.f941c;
        }

        /* renamed from: e */
        public boolean m376e(C1412a c1412a, C1412a c1412a2) {
            return c1412a.m396d(c1412a2);
        }

        @Nullable
        /* renamed from: f */
        public C1427c m377f(C1476p c1476p) {
            return c1476p.f937m;
        }

        /* renamed from: g */
        public void m378g(C1476p.a aVar, C1427c c1427c) {
            aVar.m896k(c1427c);
        }

        /* renamed from: h */
        public Call m379h(OkHttpClient okHttpClient, C1474n c1474n) {
            return RealCall.newRealCall(okHttpClient, c1474n, true);
        }

        /* renamed from: i */
        public C1430f m380i(C1416e c1416e) {
            return c1416e.f544a;
        }
    }

    static {
        q92.a = new C1410a();
    }

    public OkHttpClient() {
        this(new C1411b());
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

    public C1414c certificatePinner() {
        return this.certificatePinner;
    }

    public int connectTimeoutMillis() {
        return this.connectTimeout;
    }

    public C1416e connectionPool() {
        return this.connectionPool;
    }

    public List<C1417f> connectionSpecs() {
        return this.connectionSpecs;
    }

    public CookieJar cookieJar() {
        return this.cookieJar;
    }

    public C1418g dispatcher() {
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

    public C1411b newBuilder() {
        return new C1411b(this);
    }

    @Override // okhttp3.Call.Factory
    public Call newCall(C1474n c1474n) {
        return RealCall.newRealCall(this, c1474n, false);
    }

    @Override // okhttp3.WebSocket.Factory
    public WebSocket newWebSocket(C1474n c1474n, s96 s96Var) {
        RealWebSocket realWebSocket = new RealWebSocket(c1474n, s96Var, new Random(), this.pingInterval);
        realWebSocket.m757d(this);
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

    OkHttpClient(C1411b c1411b) {
        boolean z;
        this.dispatcher = c1411b.f497a;
        this.proxy = c1411b.f498b;
        this.protocols = c1411b.f499c;
        List<C1417f> list = c1411b.f500d;
        this.connectionSpecs = list;
        this.interceptors = C1421a.m483t(c1411b.f501e);
        this.networkInterceptors = C1421a.m483t(c1411b.f502f);
        this.eventListenerFactory = c1411b.f503g;
        this.proxySelector = c1411b.f504h;
        this.cookieJar = c1411b.f505i;
        this.internalCache = c1411b.f506j;
        this.socketFactory = c1411b.f507k;
        Iterator<C1417f> it = list.iterator();
        loop0: while (true) {
            while (it.hasNext()) {
                z = z || it.next().m425d();
            }
        }
        SSLSocketFactory sSLSocketFactory = c1411b.f508l;
        if (sSLSocketFactory == null && z) {
            X509TrustManager m454D = C1421a.m454D();
            this.sslSocketFactory = newSslSocketFactory(m454D);
            this.certificateChainCleaner = AbstractC1463b.m750b(m454D);
        } else {
            this.sslSocketFactory = sSLSocketFactory;
            this.certificateChainCleaner = c1411b.f509m;
        }
        if (this.sslSocketFactory != null) {
            iv3.j().f(this.sslSocketFactory);
        }
        this.hostnameVerifier = c1411b.f510n;
        this.certificatePinner = c1411b.f511o.m412f(this.certificateChainCleaner);
        this.proxyAuthenticator = c1411b.f512p;
        this.authenticator = c1411b.f513q;
        this.connectionPool = c1411b.f514r;
        this.dns = c1411b.f515s;
        this.followSslRedirects = c1411b.f516t;
        this.followRedirects = c1411b.f517u;
        this.retryOnConnectionFailure = c1411b.f518v;
        this.callTimeout = c1411b.f519w;
        this.connectTimeout = c1411b.f520x;
        this.readTimeout = c1411b.f521y;
        this.writeTimeout = c1411b.f522z;
        this.pingInterval = c1411b.f496A;
        if (this.interceptors.contains(null)) {
            throw new IllegalStateException("Null interceptor: " + this.interceptors);
        }
        if (this.networkInterceptors.contains(null)) {
            throw new IllegalStateException("Null network interceptor: " + this.networkInterceptors);
        }
    }

    /* compiled from: Taobao */
    /* renamed from: okhttp3.OkHttpClient$b */
    public static final class C1411b {

        /* renamed from: A */
        int f496A;

        /* renamed from: a */
        C1418g f497a;

        /* renamed from: b */
        @Nullable
        Proxy f498b;

        /* renamed from: c */
        List<Protocol> f499c;

        /* renamed from: d */
        List<C1417f> f500d;

        /* renamed from: e */
        final List<Interceptor> f501e;

        /* renamed from: f */
        final List<Interceptor> f502f;

        /* renamed from: g */
        EventListener.Factory f503g;

        /* renamed from: h */
        ProxySelector f504h;

        /* renamed from: i */
        CookieJar f505i;

        /* renamed from: j */
        @Nullable
        InternalCache f506j;

        /* renamed from: k */
        SocketFactory f507k;

        /* renamed from: l */
        @Nullable
        SSLSocketFactory f508l;

        /* renamed from: m */
        @Nullable
        AbstractC1463b f509m;

        /* renamed from: n */
        HostnameVerifier f510n;

        /* renamed from: o */
        C1414c f511o;

        /* renamed from: p */
        Authenticator f512p;

        /* renamed from: q */
        Authenticator f513q;

        /* renamed from: r */
        C1416e f514r;

        /* renamed from: s */
        Dns f515s;

        /* renamed from: t */
        boolean f516t;

        /* renamed from: u */
        boolean f517u;

        /* renamed from: v */
        boolean f518v;

        /* renamed from: w */
        int f519w;

        /* renamed from: x */
        int f520x;

        /* renamed from: y */
        int f521y;

        /* renamed from: z */
        int f522z;

        public C1411b() {
            this.f501e = new ArrayList();
            this.f502f = new ArrayList();
            this.f497a = new C1418g();
            this.f499c = OkHttpClient.DEFAULT_PROTOCOLS;
            this.f500d = OkHttpClient.DEFAULT_CONNECTION_SPECS;
            this.f503g = EventListener.m348l(EventListener.NONE);
            ProxySelector proxySelector = ProxySelector.getDefault();
            this.f504h = proxySelector;
            if (proxySelector == null) {
                this.f504h = new r33();
            }
            this.f505i = CookieJar.NO_COOKIES;
            this.f507k = SocketFactory.getDefault();
            this.f510n = n43.INSTANCE;
            this.f511o = C1414c.DEFAULT;
            Authenticator authenticator = Authenticator.NONE;
            this.f512p = authenticator;
            this.f513q = authenticator;
            this.f514r = new C1416e();
            this.f515s = Dns.SYSTEM;
            this.f516t = true;
            this.f517u = true;
            this.f518v = true;
            this.f519w = 0;
            this.f520x = IVivoSpatializer.V_SDK_MIN_VERSION;
            this.f521y = IVivoSpatializer.V_SDK_MIN_VERSION;
            this.f522z = IVivoSpatializer.V_SDK_MIN_VERSION;
            this.f496A = 0;
        }

        /* renamed from: a */
        public C1411b m381a(Interceptor interceptor) {
            if (interceptor == null) {
                throw new IllegalArgumentException("interceptor == null");
            }
            this.f501e.add(interceptor);
            return this;
        }

        /* renamed from: b */
        public OkHttpClient m382b() {
            return new OkHttpClient(this);
        }

        /* renamed from: c */
        public C1411b m383c(@Nullable ap apVar) {
            this.f506j = null;
            return this;
        }

        /* renamed from: d */
        public C1411b m384d(long j, TimeUnit timeUnit) {
            this.f520x = C1421a.m468e(BasePreInitManager.TIMEOUT, j, timeUnit);
            return this;
        }

        /* renamed from: e */
        public C1411b m385e(List<C1417f> list) {
            this.f500d = C1421a.m483t(list);
            return this;
        }

        /* renamed from: f */
        public C1411b m386f(Dns dns) {
            Objects.requireNonNull(dns, "dns == null");
            this.f515s = dns;
            return this;
        }

        /* renamed from: g */
        public C1411b m387g(EventListener eventListener) {
            Objects.requireNonNull(eventListener, "eventListener == null");
            this.f503g = EventListener.m348l(eventListener);
            return this;
        }

        /* renamed from: h */
        public C1411b m388h(HostnameVerifier hostnameVerifier) {
            Objects.requireNonNull(hostnameVerifier, "hostnameVerifier == null");
            this.f510n = hostnameVerifier;
            return this;
        }

        /* renamed from: i */
        public C1411b m389i(List<Protocol> list) {
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
            this.f499c = Collections.unmodifiableList(arrayList);
            return this;
        }

        /* renamed from: j */
        public C1411b m390j(long j, TimeUnit timeUnit) {
            this.f521y = C1421a.m468e(BasePreInitManager.TIMEOUT, j, timeUnit);
            return this;
        }

        /* renamed from: k */
        public C1411b m391k(SSLSocketFactory sSLSocketFactory, X509TrustManager x509TrustManager) {
            Objects.requireNonNull(sSLSocketFactory, "sslSocketFactory == null");
            Objects.requireNonNull(x509TrustManager, "trustManager == null");
            this.f508l = sSLSocketFactory;
            this.f509m = AbstractC1463b.m750b(x509TrustManager);
            return this;
        }

        /* renamed from: l */
        public C1411b m392l(long j, TimeUnit timeUnit) {
            this.f522z = C1421a.m468e(BasePreInitManager.TIMEOUT, j, timeUnit);
            return this;
        }

        C1411b(OkHttpClient okHttpClient) {
            ArrayList arrayList = new ArrayList();
            this.f501e = arrayList;
            ArrayList arrayList2 = new ArrayList();
            this.f502f = arrayList2;
            this.f497a = okHttpClient.dispatcher;
            this.f498b = okHttpClient.proxy;
            this.f499c = okHttpClient.protocols;
            this.f500d = okHttpClient.connectionSpecs;
            arrayList.addAll(okHttpClient.interceptors);
            arrayList2.addAll(okHttpClient.networkInterceptors);
            this.f503g = okHttpClient.eventListenerFactory;
            this.f504h = okHttpClient.proxySelector;
            this.f505i = okHttpClient.cookieJar;
            this.f506j = okHttpClient.internalCache;
            this.f507k = okHttpClient.socketFactory;
            this.f508l = okHttpClient.sslSocketFactory;
            this.f509m = okHttpClient.certificateChainCleaner;
            this.f510n = okHttpClient.hostnameVerifier;
            this.f511o = okHttpClient.certificatePinner;
            this.f512p = okHttpClient.proxyAuthenticator;
            this.f513q = okHttpClient.authenticator;
            this.f514r = okHttpClient.connectionPool;
            this.f515s = okHttpClient.dns;
            this.f516t = okHttpClient.followSslRedirects;
            this.f517u = okHttpClient.followRedirects;
            this.f518v = okHttpClient.retryOnConnectionFailure;
            this.f519w = okHttpClient.callTimeout;
            this.f520x = okHttpClient.connectTimeout;
            this.f521y = okHttpClient.readTimeout;
            this.f522z = okHttpClient.writeTimeout;
            this.f496A = okHttpClient.pingInterval;
        }
    }
}
