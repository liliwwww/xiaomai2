package okhttp3.internal.http;

import java.io.IOException;
import javax.annotation.Nullable;
import okhttp3.internal.connection.e;
import okhttp3.k;
import okhttp3.n;
import okhttp3.p;
import okio.Sink;
import okio.Source;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public interface ExchangeCodec {
    public static final int DISCARD_STREAM_TIMEOUT_MILLIS = 100;

    void cancel();

    e connection();

    Sink createRequestBody(n nVar, long j) throws IOException;

    void finishRequest() throws IOException;

    void flushRequest() throws IOException;

    Source openResponseBodySource(p pVar) throws IOException;

    @Nullable
    p.a readResponseHeaders(boolean z) throws IOException;

    long reportedContentLength(p pVar) throws IOException;

    k trailers() throws IOException;

    void writeRequestHeaders(n nVar) throws IOException;
}
