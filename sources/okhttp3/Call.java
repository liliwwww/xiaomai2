package okhttp3;

import java.io.IOException;
import okio.o;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public interface Call extends Cloneable {

    /* compiled from: Taobao */
    public interface Factory {
        Call newCall(n nVar);
    }

    void cancel();

    Call clone();

    void enqueue(Callback callback);

    p execute() throws IOException;

    boolean isCanceled();

    boolean isExecuted();

    n request();

    o timeout();
}
