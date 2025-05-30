package okhttp3.internal.connection;

import java.io.IOException;
import okhttp3.internal.ws.RealWebSocket;
import okio.BufferedSink;
import okio.BufferedSource;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
class e$a extends RealWebSocket.d {
    final /* synthetic */ c d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    e$a(e eVar, boolean z, BufferedSource bufferedSource, BufferedSink bufferedSink, c cVar) {
        super(z, bufferedSource, bufferedSink);
        this.d = cVar;
    }

    public void close() throws IOException {
        this.d.a(-1L, true, true, (IOException) null);
    }
}
