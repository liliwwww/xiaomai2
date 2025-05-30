package okhttp3;

import java.io.IOException;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public interface Callback {
    void onFailure(Call call, IOException iOException);

    void onResponse(Call call, C1476p c1476p) throws IOException;
}
