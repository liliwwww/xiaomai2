package okhttp3;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public interface Interceptor {

    /* compiled from: Taobao */
    public interface Chain {
        Call call();

        int connectTimeoutMillis();

        @Nullable
        Connection connection();

        p proceed(n nVar) throws IOException;

        int readTimeoutMillis();

        n request();

        Chain withConnectTimeout(int i, TimeUnit timeUnit);

        Chain withReadTimeout(int i, TimeUnit timeUnit);

        Chain withWriteTimeout(int i, TimeUnit timeUnit);

        int writeTimeoutMillis();
    }

    p intercept(Chain chain) throws IOException;
}
