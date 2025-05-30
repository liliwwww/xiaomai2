package okhttp3.internal.connection;

import java.util.LinkedHashSet;
import java.util.Set;
import okhttp3.r;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class g {
    private final Set<r> a = new LinkedHashSet();

    g() {
    }

    public synchronized void a(r rVar) {
        this.a.remove(rVar);
    }

    public synchronized void b(r rVar) {
        this.a.add(rVar);
    }

    public synchronized boolean c(r rVar) {
        return this.a.contains(rVar);
    }
}
