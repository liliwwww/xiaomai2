package androidx.activity;

import android.app.Activity;
import android.window.OnBackInvokedDispatcher;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;

/* compiled from: Taobao */
@RequiresApi(33)
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
class ComponentActivity$Api33Impl {
    private ComponentActivity$Api33Impl() {
    }

    @DoNotInline
    static OnBackInvokedDispatcher getOnBackInvokedDispatcher(Activity activity) {
        return activity.getOnBackInvokedDispatcher();
    }
}
