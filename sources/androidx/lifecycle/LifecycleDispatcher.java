package androidx.lifecycle;

import android.app.Application;
import android.content.Context;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
class LifecycleDispatcher {
    private static AtomicBoolean sInitialized = new AtomicBoolean(false);

    private LifecycleDispatcher() {
    }

    static void init(Context context) {
        if (sInitialized.getAndSet(true)) {
            return;
        }
        ((Application) context.getApplicationContext()).registerActivityLifecycleCallbacks(new DispatcherActivityCallback());
    }
}
