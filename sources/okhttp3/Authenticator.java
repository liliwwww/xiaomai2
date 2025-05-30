package okhttp3;

import java.io.IOException;
import javax.annotation.Nullable;
import tb.kd;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public interface Authenticator {
    public static final Authenticator NONE = kd.a;

    @Nullable
    n authenticate(@Nullable r rVar, p pVar) throws IOException;
}
