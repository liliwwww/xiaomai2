package okhttp3;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.List;
import javax.annotation.Nullable;
import tb.ba1;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public abstract class EventListener {
    public static final EventListener NONE = new C1409a();

    /* compiled from: Taobao */
    public interface Factory {
        EventListener create(Call call);
    }

    /* compiled from: Taobao */
    /* renamed from: okhttp3.EventListener$a */
    class C1409a extends EventListener {
        C1409a() {
        }
    }

    /* renamed from: l */
    static Factory m348l(EventListener eventListener) {
        return new ba1(eventListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m */
    public static /* synthetic */ EventListener m349m(EventListener eventListener, Call call) {
        return eventListener;
    }

    /* renamed from: b */
    public void m350b(Call call) {
    }

    /* renamed from: c */
    public void m351c(Call call, IOException iOException) {
    }

    /* renamed from: d */
    public void m352d(Call call) {
    }

    /* renamed from: e */
    public void m353e(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, @Nullable Protocol protocol) {
    }

    /* renamed from: f */
    public void m354f(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, @Nullable Protocol protocol, IOException iOException) {
    }

    /* renamed from: g */
    public void m355g(Call call, InetSocketAddress inetSocketAddress, Proxy proxy) {
    }

    /* renamed from: h */
    public void m356h(Call call, Connection connection) {
    }

    /* renamed from: i */
    public void m357i(Call call, Connection connection) {
    }

    /* renamed from: j */
    public void m358j(Call call, String str, List<InetAddress> list) {
    }

    /* renamed from: k */
    public void m359k(Call call, String str) {
    }

    /* renamed from: n */
    public void m360n(Call call, long j) {
    }

    /* renamed from: o */
    public void m361o(Call call) {
    }

    /* renamed from: p */
    public void m362p(Call call, IOException iOException) {
    }

    /* renamed from: q */
    public void m363q(Call call, C1474n c1474n) {
    }

    /* renamed from: r */
    public void m364r(Call call) {
    }

    /* renamed from: s */
    public void m365s(Call call, long j) {
    }

    /* renamed from: t */
    public void m366t(Call call) {
    }

    /* renamed from: u */
    public void m367u(Call call, IOException iOException) {
    }

    /* renamed from: v */
    public void m368v(Call call, C1476p c1476p) {
    }

    /* renamed from: w */
    public void m369w(Call call) {
    }

    /* renamed from: x */
    public void m370x(Call call, @Nullable C1470j c1470j) {
    }

    /* renamed from: y */
    public void m371y(Call call) {
    }
}
