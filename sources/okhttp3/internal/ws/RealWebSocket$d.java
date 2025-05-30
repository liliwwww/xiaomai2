package okhttp3.internal.ws;

import java.io.Closeable;
import okio.BufferedSink;
import okio.BufferedSource;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public abstract class RealWebSocket$d implements Closeable {
    public final boolean a;
    public final BufferedSource b;
    public final BufferedSink c;

    public RealWebSocket$d(boolean z, BufferedSource bufferedSource, BufferedSink bufferedSink) {
        this.a = z;
        this.b = bufferedSource;
        this.c = bufferedSink;
    }
}
