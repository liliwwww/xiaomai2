package okhttp3.internal.http2;

import java.io.IOException;
import java.util.List;
import okio.BufferedSource;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
class PushObserver$a implements PushObserver {
    PushObserver$a() {
    }

    public boolean onData(int i, BufferedSource bufferedSource, int i2, boolean z) throws IOException {
        bufferedSource.skip(i2);
        return true;
    }

    public boolean onHeaders(int i, List<a> list, boolean z) {
        return true;
    }

    public boolean onRequest(int i, List<a> list) {
        return true;
    }

    public void onReset(int i, ErrorCode errorCode) {
    }
}
