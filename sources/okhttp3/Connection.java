package okhttp3;

import java.net.Socket;
import javax.annotation.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public interface Connection {
    @Nullable
    j handshake();

    Protocol protocol();

    r route();

    Socket socket();
}
