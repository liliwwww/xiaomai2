package okhttp3;

import java.util.concurrent.TimeUnit;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class e {
    final okhttp3.internal.connection.f a;

    public e() {
        this(5, 5L, TimeUnit.MINUTES);
    }

    public e(int i, long j, TimeUnit timeUnit) {
        this.a = new okhttp3.internal.connection.f(i, j, timeUnit);
    }
}
