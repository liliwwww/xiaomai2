package androidx.core.os;

import android.os.Build;
import android.os.Environment;
import android.util.Log;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import java.io.File;
import java.io.IOException;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class EnvironmentCompat {
    public static final String MEDIA_UNKNOWN = "unknown";
    private static final String TAG = "EnvironmentCompat";

    /* compiled from: Taobao */
    @RequiresApi(19)
    static class Api19Impl {
        private Api19Impl() {
        }

        @DoNotInline
        static String getStorageState(File file) {
            return Environment.getStorageState(file);
        }
    }

    private EnvironmentCompat() {
    }

    @NonNull
    public static String getStorageState(@NonNull File file) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 21) {
            return Api21Impl.getExternalStorageState(file);
        }
        if (i >= 19) {
            return Api19Impl.getStorageState(file);
        }
        try {
            return file.getCanonicalPath().startsWith(Environment.getExternalStorageDirectory().getCanonicalPath()) ? Environment.getExternalStorageState() : MEDIA_UNKNOWN;
        } catch (IOException e) {
            Log.w(TAG, "Failed to resolve canonical path: " + e);
            return MEDIA_UNKNOWN;
        }
    }
}
