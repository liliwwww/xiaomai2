package androidx.core.content;

import android.content.Context;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import java.io.File;

/* compiled from: Taobao */
@RequiresApi(24)
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
class ContextCompat$Api24Impl {
    private ContextCompat$Api24Impl() {
    }

    @DoNotInline
    static Context createDeviceProtectedStorageContext(Context context) {
        return context.createDeviceProtectedStorageContext();
    }

    @DoNotInline
    static File getDataDir(Context context) {
        return context.getDataDir();
    }

    @DoNotInline
    static boolean isDeviceProtectedStorage(Context context) {
        return context.isDeviceProtectedStorage();
    }
}
