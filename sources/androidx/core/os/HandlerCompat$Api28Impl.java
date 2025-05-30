package androidx.core.os;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.RequiresApi;

/* JADX INFO: Access modifiers changed from: private */
/* compiled from: Taobao */
@RequiresApi(28)
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public class HandlerCompat$Api28Impl {
    private HandlerCompat$Api28Impl() {
    }

    public static Handler createAsync(Looper looper) {
        return Handler.createAsync(looper);
    }

    public static boolean postDelayed(Handler handler, Runnable runnable, Object obj, long j) {
        return handler.postDelayed(runnable, obj, j);
    }

    public static Handler createAsync(Looper looper, Handler.Callback callback) {
        return Handler.createAsync(looper, callback);
    }
}
