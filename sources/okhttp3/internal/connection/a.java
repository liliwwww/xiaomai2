package okhttp3.internal.connection;

import java.io.IOException;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.n;
import okhttp3.p;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class a implements Interceptor {
    public a(OkHttpClient okHttpClient) {
    }

    @Override // okhttp3.Interceptor
    public p intercept(Interceptor.Chain chain) throws IOException {
        okhttp3.internal.http.c cVar = (okhttp3.internal.http.c) chain;
        n request = cVar.request();
        i c = cVar.c();
        return cVar.b(request, c, c.k(chain, !request.f().equals("GET")));
    }
}
