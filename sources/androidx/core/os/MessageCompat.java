package androidx.core.os;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Message;
import androidx.annotation.NonNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class MessageCompat {
    private static boolean sTryIsAsynchronous = true;
    private static boolean sTrySetAsynchronous = true;

    private MessageCompat() {
    }

    @SuppressLint({"NewApi"})
    public static boolean isAsynchronous(@NonNull Message message) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 22) {
            return Api22Impl.isAsynchronous(message);
        }
        if (sTryIsAsynchronous && i >= 16) {
            try {
                return Api22Impl.isAsynchronous(message);
            } catch (NoSuchMethodError unused) {
                sTryIsAsynchronous = false;
            }
        }
        return false;
    }

    @SuppressLint({"NewApi"})
    public static void setAsynchronous(@NonNull Message message, boolean z) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 22) {
            Api22Impl.setAsynchronous(message, z);
        } else {
            if (!sTrySetAsynchronous || i < 16) {
                return;
            }
            try {
                Api22Impl.setAsynchronous(message, z);
            } catch (NoSuchMethodError unused) {
                sTrySetAsynchronous = false;
            }
        }
    }
}
