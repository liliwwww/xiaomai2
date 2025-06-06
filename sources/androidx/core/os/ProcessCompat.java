package androidx.core.os;

import android.annotation.SuppressLint;
import android.os.Build;
import androidx.annotation.RequiresApi;
import java.lang.reflect.Method;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class ProcessCompat {

    /* compiled from: Taobao */
    @RequiresApi(16)
    static class Api16Impl {
        private static Method sMethodUserIdIsAppMethod;
        private static boolean sResolved;
        private static final Object sResolvedLock = new Object();

        private Api16Impl() {
        }

        @SuppressLint({"PrivateApi"})
        static boolean isApplicationUid(int i) {
            try {
                synchronized (sResolvedLock) {
                    if (!sResolved) {
                        sResolved = true;
                        sMethodUserIdIsAppMethod = Class.forName("android.os.UserId").getDeclaredMethod("isApp", Integer.TYPE);
                    }
                }
                Method method = sMethodUserIdIsAppMethod;
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

    private ProcessCompat() {
    }

    public static boolean isApplicationUid(int i) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 24) {
            return Api24Impl.isApplicationUid(i);
        }
        if (i2 >= 17) {
            return Api17Impl.isApplicationUid(i);
        }
        if (i2 == 16) {
            return Api16Impl.isApplicationUid(i);
        }
        return true;
    }
}
