package android.taobao.windvane.extra;

import android.os.Handler;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public interface WVIAdapter {
    public static final int NOTIFY_FAIL = 0;
    public static final int NOTIFY_SUCCESS = 1;

    Map<String, String> getLoginInfo(Handler handler);

    long getTimestamp();

    void login(Handler handler);
}
