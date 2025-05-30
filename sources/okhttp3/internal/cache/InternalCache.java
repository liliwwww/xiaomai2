package okhttp3.internal.cache;

import java.io.IOException;
import javax.annotation.Nullable;
import okhttp3.C1474n;
import okhttp3.C1476p;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public interface InternalCache {
    @Nullable
    C1476p get(C1474n c1474n) throws IOException;

    @Nullable
    CacheRequest put(C1476p c1476p) throws IOException;

    void remove(C1474n c1474n) throws IOException;

    void trackConditionalCacheHit();

    void trackResponse(C1424b c1424b);

    void update(C1476p c1476p, C1476p c1476p2);
}
