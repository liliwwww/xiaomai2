package okhttp3;

import java.util.concurrent.TimeUnit;
import okhttp3.internal.connection.C1430f;

/* compiled from: Taobao */
/* renamed from: okhttp3.e */
/* loaded from: classes2.dex */
public final class C1416e {

    /* renamed from: a */
    final C1430f f544a;

    public C1416e() {
        this(5, 5L, TimeUnit.MINUTES);
    }

    public C1416e(int i, long j, TimeUnit timeUnit) {
        this.f544a = new C1430f(i, j, timeUnit);
    }
}
