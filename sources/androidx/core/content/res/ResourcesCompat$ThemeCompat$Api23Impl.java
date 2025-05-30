package androidx.core.content.res;

import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* compiled from: Taobao */
@RequiresApi(23)
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
class ResourcesCompat$ThemeCompat$Api23Impl {
    private static Method sRebaseMethod;
    private static boolean sRebaseMethodFetched;
    private static final Object sRebaseMethodLock = new Object();

    private ResourcesCompat$ThemeCompat$Api23Impl() {
    }

    @SuppressLint({"BanUncheckedReflection"})
    static void rebase(@NonNull Resources.Theme theme) {
        synchronized (sRebaseMethodLock) {
            if (!sRebaseMethodFetched) {
                try {
                    Method declaredMethod = Resources.Theme.class.getDeclaredMethod("rebase", new Class[0]);
                    sRebaseMethod = declaredMethod;
                    declaredMethod.setAccessible(true);
                } catch (NoSuchMethodException e) {
                    Log.i("ResourcesCompat", "Failed to retrieve rebase() method", e);
                }
                sRebaseMethodFetched = true;
            }
            Method method = sRebaseMethod;
            if (method != null) {
                try {
                    method.invoke(theme, new Object[0]);
                } catch (IllegalAccessException | InvocationTargetException e2) {
                    Log.i("ResourcesCompat", "Failed to invoke rebase() method via reflection", e2);
                    sRebaseMethod = null;
                }
            }
        }
    }
}
