package okhttp3;

import java.net.Socket;
import javax.annotation.Nullable;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public interface Connection {
    @Nullable
    C1470j handshake();

    Protocol protocol();

    C1478r route();

    Socket socket();
}
