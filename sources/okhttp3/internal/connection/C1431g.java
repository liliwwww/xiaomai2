package okhttp3.internal.connection;

import java.util.LinkedHashSet;
import java.util.Set;
import okhttp3.C1478r;

/* compiled from: Taobao */
/* renamed from: okhttp3.internal.connection.g */
/* loaded from: classes2.dex */
final class C1431g {

    /* renamed from: a */
    private final Set<C1478r> f646a = new LinkedHashSet();

    C1431g() {
    }

    /* renamed from: a */
    public synchronized void m561a(C1478r c1478r) {
        this.f646a.remove(c1478r);
    }

    /* renamed from: b */
    public synchronized void m562b(C1478r c1478r) {
        this.f646a.add(c1478r);
    }

    /* renamed from: c */
    public synchronized boolean m563c(C1478r c1478r) {
        return this.f646a.contains(c1478r);
    }
}
