package okhttp3;

import javax.annotation.Nullable;
import okio.ByteString;
import tb.s96;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public interface WebSocket {

    /* compiled from: Taobao */
    public interface Factory {
        WebSocket newWebSocket(n nVar, s96 s96Var);
    }

    void cancel();

    boolean close(int i, @Nullable String str);

    long queueSize();

    n request();

    boolean send(String str);

    boolean send(ByteString byteString);
}
