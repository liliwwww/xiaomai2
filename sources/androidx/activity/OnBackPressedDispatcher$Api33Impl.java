package androidx.activity;

import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import java.util.Objects;
import tb.r43;

/* compiled from: Taobao */
@RequiresApi(33)
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
class OnBackPressedDispatcher$Api33Impl {
    private OnBackPressedDispatcher$Api33Impl() {
    }

    @DoNotInline
    static OnBackInvokedCallback createOnBackInvokedCallback(Runnable runnable) {
        Objects.requireNonNull(runnable);
        return new r43(runnable);
    }

    @DoNotInline
    static void registerOnBackInvokedCallback(Object obj, int i, Object obj2) {
        ((OnBackInvokedDispatcher) obj).registerOnBackInvokedCallback(i, (OnBackInvokedCallback) obj2);
    }

    @DoNotInline
    static void unregisterOnBackInvokedCallback(Object obj, Object obj2) {
        ((OnBackInvokedDispatcher) obj).unregisterOnBackInvokedCallback((OnBackInvokedCallback) obj2);
    }
}
