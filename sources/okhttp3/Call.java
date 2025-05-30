package okhttp3;

import java.io.IOException;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public interface Call extends Cloneable {

    /* compiled from: Taobao */
    public interface Factory {
        Call newCall(C1474n c1474n);
    }

    void cancel();

    Call clone();

    void enqueue(Callback callback);

    C1476p execute() throws IOException;

    boolean isCanceled();

    boolean isExecuted();

    C1474n request();

    okio.o timeout();
}
