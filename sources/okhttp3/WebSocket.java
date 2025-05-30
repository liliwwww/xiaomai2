package okhttp3;

import javax.annotation.Nullable;
import okio.ByteString;
import tb.s96;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public interface WebSocket {

    /* compiled from: Taobao */
    public interface Factory {
        WebSocket newWebSocket(C1474n c1474n, s96 s96Var);
    }

    void cancel();

    boolean close(int i, @Nullable String str);

    long queueSize();

    C1474n request();

    boolean send(String str);

    boolean send(ByteString byteString);
}
