package androidx.core.os;

import android.annotation.SuppressLint;
import android.os.UserHandle;
import androidx.annotation.RequiresApi;
import java.lang.reflect.Method;

/* compiled from: Taobao */
@RequiresApi(17)
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
class ProcessCompat$Api17Impl {
    private static Method sMethodUserHandleIsAppMethod;
    private static boolean sResolved;
    private static final Object sResolvedLock = new Object();

    private ProcessCompat$Api17Impl() {
    }

    @SuppressLint({"DiscouragedPrivateApi"})
    static boolean isApplicationUid(int i) {
        try {
            synchronized (sResolvedLock) {
                if (!sResolved) {
                    sResolved = true;
                    sMethodUserHandleIsAppMethod = UserHandle.class.getDeclaredMethod("isApp", Integer.TYPE);
                }
            }
            Method method = sMethodUserHandleIsAppMethod;
            if (method != null) {
                Boolean bool = (Boolean) method.invoke(null, Integer.valueOf(i));
                if (bool != null) {
                    return bool.booleanValue();
                }
                throw new NullPointerException();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }
}
