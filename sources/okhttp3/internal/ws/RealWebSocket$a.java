package okhttp3.internal.ws;

import java.io.IOException;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.internal.connection.c;
import okhttp3.n;
import okhttp3.p;
import tb.q92;
import tb.s96;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
class RealWebSocket$a implements Callback {
    final /* synthetic */ n a;
    final /* synthetic */ RealWebSocket b;

    RealWebSocket$a(RealWebSocket realWebSocket, n nVar) {
        this.b = realWebSocket;
        this.a = nVar;
    }

    @Override // okhttp3.Callback
    public void onFailure(Call call, IOException iOException) {
        this.b.e(iOException, (p) null);
    }

    @Override // okhttp3.Callback
    public void onResponse(Call call, p pVar) {
        c f = q92.a.f(pVar);
        try {
            this.b.b(pVar, f);
            try {
                this.b.f("OkHttp WebSocket " + this.a.h().A(), f.i());
                s96 s96Var = this.b.b;
                throw null;
            } catch (Exception e) {
                this.b.e(e, (p) null);
            }
        } catch (IOException e2) {
            if (f != null) {
                f.q();
            }
            this.b.e(e2, pVar);
            okhttp3.internal.a.g(pVar);
        }
    }
}
