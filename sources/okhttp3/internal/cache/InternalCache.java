package okhttp3.internal.cache;

import java.io.IOException;
import javax.annotation.Nullable;
import okhttp3.n;
import okhttp3.p;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public interface InternalCache {
    @Nullable
    p get(n nVar) throws IOException;

    @Nullable
    CacheRequest put(p pVar) throws IOException;

    void remove(n nVar) throws IOException;

    void trackConditionalCacheHit();

    void trackResponse(b bVar);

    void update(p pVar, p pVar2);
}
