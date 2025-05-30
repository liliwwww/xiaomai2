package androidx.core.content;

import android.content.Context;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;

/* compiled from: Taobao */
@RequiresApi(23)
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
class ContextCompat$Api23Impl {
    private ContextCompat$Api23Impl() {
    }

    @DoNotInline
    static int getColor(Context context, int i) {
        return context.getColor(i);
    }

    @DoNotInline
    static <T> T getSystemService(Context context, Class<T> cls) {
        return (T) context.getSystemService(cls);
    }

    @DoNotInline
    static String getSystemServiceName(Context context, Class<?> cls) {
        return context.getSystemServiceName(cls);
    }
}
