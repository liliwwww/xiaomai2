package okhttp3.internal.http;

import java.io.IOException;
import javax.annotation.Nullable;
import okhttp3.C1471k;
import okhttp3.C1474n;
import okhttp3.C1476p;
import okhttp3.internal.connection.C1429e;
import okio.Sink;
import okio.Source;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public interface ExchangeCodec {
    public static final int DISCARD_STREAM_TIMEOUT_MILLIS = 100;

    void cancel();

    C1429e connection();

    Sink createRequestBody(C1474n c1474n, long j) throws IOException;

    void finishRequest() throws IOException;

    void flushRequest() throws IOException;

    Source openResponseBodySource(C1476p c1476p) throws IOException;

    @Nullable
    C1476p.a readResponseHeaders(boolean z) throws IOException;

    long reportedContentLength(C1476p c1476p) throws IOException;

    C1471k trailers() throws IOException;

    void writeRequestHeaders(C1474n c1474n) throws IOException;
}
