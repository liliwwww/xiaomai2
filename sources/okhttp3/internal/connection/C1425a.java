package okhttp3.internal.connection;

import java.io.IOException;
import okhttp3.C1474n;
import okhttp3.C1476p;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.internal.http.C1436c;

/* compiled from: Taobao */
/* renamed from: okhttp3.internal.connection.a */
/* loaded from: classes2.dex */
public final class C1425a implements Interceptor {
    public C1425a(OkHttpClient okHttpClient) {
    }

    @Override // okhttp3.Interceptor
    public C1476p intercept(Interceptor.Chain chain) throws IOException {
        C1436c c1436c = (C1436c) chain;
        C1474n request = c1436c.request();
        C1433i m595c = c1436c.m595c();
        return c1436c.m594b(request, m595c, m595c.m585k(chain, !request.m856f().equals("GET")));
    }
}
