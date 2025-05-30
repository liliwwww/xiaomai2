package okhttp3.internal.http2;

import java.io.IOException;
import java.net.SocketTimeoutException;
import okio.AsyncTimeout;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
class e$c extends AsyncTimeout {
    final /* synthetic */ e a;

    e$c(e eVar) {
        this.a = eVar;
    }

    public void exitAndThrowIfTimedOut() throws IOException {
        if (exit()) {
            throw newTimeoutException(null);
        }
    }

    protected IOException newTimeoutException(IOException iOException) {
        SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
        if (iOException != null) {
            socketTimeoutException.initCause(iOException);
        }
        return socketTimeoutException;
    }

    protected void timedOut() {
        this.a.f(ErrorCode.CANCEL);
        this.a.d.B();
    }
}
