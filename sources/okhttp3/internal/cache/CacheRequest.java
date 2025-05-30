package okhttp3.internal.cache;

import java.io.IOException;
import okio.Sink;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public interface CacheRequest {
    void abort();

    Sink body() throws IOException;
}
