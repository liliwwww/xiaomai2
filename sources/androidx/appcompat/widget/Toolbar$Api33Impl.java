package androidx.appcompat.widget;

import android.view.View;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.util.Objects;
import tb.r43;

/* compiled from: Taobao */
@RequiresApi(33)
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
class Toolbar$Api33Impl {
    private Toolbar$Api33Impl() {
    }

    @Nullable
    @DoNotInline
    static OnBackInvokedDispatcher findOnBackInvokedDispatcher(@NonNull View view) {
        return view.findOnBackInvokedDispatcher();
    }

    @NonNull
    @DoNotInline
    static OnBackInvokedCallback newOnBackInvokedCallback(@NonNull Runnable runnable) {
        Objects.requireNonNull(runnable);
        return new r43(runnable);
    }

    @DoNotInline
    static void tryRegisterOnBackInvokedCallback(@NonNull Object obj, @NonNull Object obj2) {
        ((OnBackInvokedDispatcher) obj).registerOnBackInvokedCallback(1000000, (OnBackInvokedCallback) obj2);
    }

    @DoNotInline
    static void tryUnregisterOnBackInvokedCallback(@NonNull Object obj, @NonNull Object obj2) {
        ((OnBackInvokedDispatcher) obj).unregisterOnBackInvokedCallback((OnBackInvokedCallback) obj2);
    }
}
