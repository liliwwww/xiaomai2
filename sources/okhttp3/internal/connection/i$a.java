package okhttp3.internal.connection;

import okio.AsyncTimeout;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
class i$a extends AsyncTimeout {
    final /* synthetic */ i a;

    i$a(i iVar) {
        this.a = iVar;
    }

    protected void timedOut() {
        this.a.d();
    }
}
