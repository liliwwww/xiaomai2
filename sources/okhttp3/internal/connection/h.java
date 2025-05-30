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
import okhttp3.Call;
import okhttp3.EventListener;
import okhttp3.l;
import okhttp3.r;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class h {
    private final okhttp3.a a;
    private final g b;
    private final Call c;
    private final EventListener d;
    private int f;
    private List<Proxy> e = Collections.emptyList();
    private List<InetSocketAddress> g = Collections.emptyList();
    private final List<r> h = new ArrayList();

    /* compiled from: Taobao */
    public static final class a {
        private final List<r> a;
        private int b = 0;

        a(List<r> list) {
            this.a = list;
        }

        public List<r> a() {
            return new ArrayList(this.a);
        }

        public boolean b() {
            return this.b < this.a.size();
        }

        public r c() {
            if (!b()) {
                throw new NoSuchElementException();
            }
            List<r> list = this.a;
            int i = this.b;
            this.b = i + 1;
            return list.get(i);
        }
    }

    h(okhttp3.a aVar, g gVar, Call call, EventListener eventListener) {
        this.a = aVar;
        this.b = gVar;
        this.c = call;
        this.d = eventListener;
        g(aVar.l(), aVar.g());
    }

    static String a(InetSocketAddress inetSocketAddress) {
        InetAddress address = inetSocketAddress.getAddress();
        return address == null ? inetSocketAddress.getHostName() : address.getHostAddress();
    }

    private boolean c() {
        return this.f < this.e.size();
    }

    private Proxy e() throws IOException {
        if (c()) {
            List<Proxy> list = this.e;
            int i = this.f;
            this.f = i + 1;
            Proxy proxy = list.get(i);
            f(proxy);
            return proxy;
        }
        throw new SocketException("No route to " + this.a.l().m() + "; exhausted proxy configurations: " + this.e);
    }

    private void f(Proxy proxy) throws IOException {
        String m;
        int x;
        this.g = new ArrayList();
        if (proxy.type() == Proxy.Type.DIRECT || proxy.type() == Proxy.Type.SOCKS) {
            m = this.a.l().m();
            x = this.a.l().x();
        } else {
            SocketAddress address = proxy.address();
            if (!(address instanceof InetSocketAddress)) {
                throw new IllegalArgumentException("Proxy.address() is not an InetSocketAddress: " + address.getClass());
            }
            InetSocketAddress inetSocketAddress = (InetSocketAddress) address;
            m = a(inetSocketAddress);
            x = inetSocketAddress.getPort();
        }
        if (x < 1 || x > 65535) {
            throw new SocketException("No route to " + m + ":" + x + "; port is out of range");
        }
        if (proxy.type() == Proxy.Type.SOCKS) {
            this.g.add(InetSocketAddress.createUnresolved(m, x));
            return;
        }
        this.d.k(this.c, m);
        List<InetAddress> lookup = this.a.c().lookup(m);
        if (lookup.isEmpty()) {
            throw new UnknownHostException(this.a.c() + " returned no addresses for " + m);
        }
        this.d.j(this.c, m, lookup);
        int size = lookup.size();
        for (int i = 0; i < size; i++) {
            this.g.add(new InetSocketAddress(lookup.get(i), x));
        }
    }

    private void g(l lVar, Proxy proxy) {
        if (proxy != null) {
            this.e = Collections.singletonList(proxy);
        } else {
            List<Proxy> select = this.a.i().select(lVar.D());
            this.e = (select == null || select.isEmpty()) ? okhttp3.internal.a.u(Proxy.NO_PROXY) : okhttp3.internal.a.t(select);
        }
        this.f = 0;
    }

    public boolean b() {
        return c() || !this.h.isEmpty();
    }

    public a d() throws IOException {
        if (!b()) {
            throw new NoSuchElementException();
        }
        ArrayList arrayList = new ArrayList();
        while (c()) {
            Proxy e = e();
            int size = this.g.size();
            for (int i = 0; i < size; i++) {
                r rVar = new r(this.a, e, this.g.get(i));
                if (this.b.c(rVar)) {
                    this.h.add(rVar);
                } else {
                    arrayList.add(rVar);
                }
            }
            if (!arrayList.isEmpty()) {
                break;
            }
        }
        if (arrayList.isEmpty()) {
            arrayList.addAll(this.h);
            this.h.clear();
        }
        return new a(arrayList);
    }
}
