package okhttp3.internal.connection;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import okhttp3.C1412a;
import okhttp3.C1472l;
import okhttp3.C1478r;
import okhttp3.Call;
import okhttp3.EventListener;
import okhttp3.internal.C1421a;

/* compiled from: Taobao */
/* renamed from: okhttp3.internal.connection.h */
/* loaded from: classes2.dex */
final class C1432h {

    /* renamed from: a */
    private final C1412a f647a;

    /* renamed from: b */
    private final C1431g f648b;

    /* renamed from: c */
    private final Call f649c;

    /* renamed from: d */
    private final EventListener f650d;

    /* renamed from: f */
    private int f652f;

    /* renamed from: e */
    private List<Proxy> f651e = Collections.emptyList();

    /* renamed from: g */
    private List<InetSocketAddress> f653g = Collections.emptyList();

    /* renamed from: h */
    private final List<C1478r> f654h = new ArrayList();

    /* compiled from: Taobao */
    /* renamed from: okhttp3.internal.connection.h$a */
    public static final class a {

        /* renamed from: a */
        private final List<C1478r> f655a;

        /* renamed from: b */
        private int f656b = 0;

        a(List<C1478r> list) {
            this.f655a = list;
        }

        /* renamed from: a */
        public List<C1478r> m571a() {
            return new ArrayList(this.f655a);
        }

        /* renamed from: b */
        public boolean m572b() {
            return this.f656b < this.f655a.size();
        }

        /* renamed from: c */
        public C1478r m573c() {
            if (!m572b()) {
                throw new NoSuchElementException();
            }
            List<C1478r> list = this.f655a;
            int i = this.f656b;
            this.f656b = i + 1;
            return list.get(i);
        }
    }

    C1432h(C1412a c1412a, C1431g c1431g, Call call, EventListener eventListener) {
        this.f647a = c1412a;
        this.f648b = c1431g;
        this.f649c = call;
        this.f650d = eventListener;
        m568g(c1412a.m404l(), c1412a.m399g());
    }

    /* renamed from: a */
    static String m564a(InetSocketAddress inetSocketAddress) {
        InetAddress address = inetSocketAddress.getAddress();
        return address == null ? inetSocketAddress.getHostName() : address.getHostAddress();
    }

    /* renamed from: c */
    private boolean m565c() {
        return this.f652f < this.f651e.size();
    }

    /* renamed from: e */
    private Proxy m566e() throws IOException {
        if (m565c()) {
            List<Proxy> list = this.f651e;
            int i = this.f652f;
            this.f652f = i + 1;
            Proxy proxy = list.get(i);
            m567f(proxy);
            return proxy;
        }
        throw new SocketException("No route to " + this.f647a.m404l().m816m() + "; exhausted proxy configurations: " + this.f651e);
    }

    /* renamed from: f */
    private void m567f(Proxy proxy) throws IOException {
        String m816m;
        int m820x;
        this.f653g = new ArrayList();
        if (proxy.type() == Proxy.Type.DIRECT || proxy.type() == Proxy.Type.SOCKS) {
            m816m = this.f647a.m404l().m816m();
            m820x = this.f647a.m404l().m820x();
        } else {
            SocketAddress address = proxy.address();
            if (!(address instanceof InetSocketAddress)) {
                throw new IllegalArgumentException("Proxy.address() is not an InetSocketAddress: " + address.getClass());
            }
            InetSocketAddress inetSocketAddress = (InetSocketAddress) address;
            m816m = m564a(inetSocketAddress);
            m820x = inetSocketAddress.getPort();
        }
        if (m820x < 1 || m820x > 65535) {
            throw new SocketException("No route to " + m816m + ":" + m820x + "; port is out of range");
        }
        if (proxy.type() == Proxy.Type.SOCKS) {
            this.f653g.add(InetSocketAddress.createUnresolved(m816m, m820x));
            return;
        }
        this.f650d.m359k(this.f649c, m816m);
        List<InetAddress> lookup = this.f647a.m395c().lookup(m816m);
        if (lookup.isEmpty()) {
            throw new UnknownHostException(this.f647a.m395c() + " returned no addresses for " + m816m);
        }
        this.f650d.m358j(this.f649c, m816m, lookup);
        int size = lookup.size();
        for (int i = 0; i < size; i++) {
            this.f653g.add(new InetSocketAddress(lookup.get(i), m820x));
        }
    }

    /* renamed from: g */
    private void m568g(C1472l c1472l, Proxy proxy) {
        if (proxy != null) {
            this.f651e = Collections.singletonList(proxy);
        } else {
            List<Proxy> select = this.f647a.m401i().select(c1472l.m809D());
            this.f651e = (select == null || select.isEmpty()) ? C1421a.m484u(Proxy.NO_PROXY) : C1421a.m483t(select);
        }
        this.f652f = 0;
    }

    /* renamed from: b */
    public boolean m569b() {
        return m565c() || !this.f654h.isEmpty();
    }

    /* renamed from: d */
    public a m570d() throws IOException {
        if (!m569b()) {
            throw new NoSuchElementException();
        }
        ArrayList arrayList = new ArrayList();
        while (m565c()) {
            Proxy m566e = m566e();
            int size = this.f653g.size();
            for (int i = 0; i < size; i++) {
                C1478r c1478r = new C1478r(this.f647a, m566e, this.f653g.get(i));
                if (this.f648b.m563c(c1478r)) {
                    this.f654h.add(c1478r);
                } else {
                    arrayList.add(c1478r);
                }
            }
            if (!arrayList.isEmpty()) {
                break;
            }
        }
        if (arrayList.isEmpty()) {
            arrayList.addAll(this.f654h);
            this.f654h.clear();
        }
        return new a(arrayList);
    }
}
