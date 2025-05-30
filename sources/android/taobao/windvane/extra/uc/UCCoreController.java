package android.taobao.windvane.extra.uc;

import android.taobao.windvane.fullspan.SpanWrapper;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public class UCCoreController {
    private static final String TAG = "UCCoreController";
    private static final AtomicBoolean sRegisteredThreadANRCallback = new AtomicBoolean(false);

    public static void registerThreadANRCallback(SpanWrapper spanWrapper) {
        if (sRegisteredThreadANRCallback.compareAndSet(false, true)) {
            spanWrapper.log("registerThreadANRCallback");
            new 1(spanWrapper);
        }
    }
}
