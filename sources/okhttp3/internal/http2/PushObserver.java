package okhttp3.internal.http2;

import java.io.IOException;
import java.util.List;
import okio.BufferedSource;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public interface PushObserver {
    public static final PushObserver CANCEL = new a();

    boolean onData(int i, BufferedSource bufferedSource, int i2, boolean z) throws IOException;

    boolean onHeaders(int i, List<a> list, boolean z);

    boolean onRequest(int i, List<a> list);

    void onReset(int i, ErrorCode errorCode);
}
