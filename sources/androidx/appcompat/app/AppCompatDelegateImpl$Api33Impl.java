package androidx.appcompat.app;

import android.app.Activity;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import java.util.Objects;

/* compiled from: Taobao */
@RequiresApi(33)
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
class AppCompatDelegateImpl$Api33Impl {
    private AppCompatDelegateImpl$Api33Impl() {
    }

    @DoNotInline
    static OnBackInvokedDispatcher getOnBackInvokedDispatcher(Activity activity) {
        return activity.getOnBackInvokedDispatcher();
    }

    @DoNotInline
    static OnBackInvokedCallback registerOnBackPressedCallback(Object obj, final AppCompatDelegateImpl appCompatDelegateImpl) {
        Objects.requireNonNull(appCompatDelegateImpl);
        OnBackInvokedCallback onBackInvokedCallback = new OnBackInvokedCallback() { // from class: androidx.appcompat.app.a
            @Override // android.window.OnBackInvokedCallback
            public final void onBackInvoked() {
                appCompatDelegateImpl.onBackPressed();
            }
        };
        ((OnBackInvokedDispatcher) obj).registerOnBackInvokedCallback(1000000, onBackInvokedCallback);
        return onBackInvokedCallback;
    }

    @DoNotInline
    static void unregisterOnBackInvokedCallback(Object obj, Object obj2) {
        ((OnBackInvokedDispatcher) obj).unregisterOnBackInvokedCallback((OnBackInvokedCallback) obj2);
    }
}
