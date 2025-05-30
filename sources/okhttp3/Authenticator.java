package okhttp3;

import java.io.IOException;
import javax.annotation.Nullable;
import tb.kd;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public interface Authenticator {
    public static final Authenticator NONE = kd.a;

    @Nullable
    C1474n authenticate(@Nullable C1478r c1478r, C1476p c1476p) throws IOException;
}
