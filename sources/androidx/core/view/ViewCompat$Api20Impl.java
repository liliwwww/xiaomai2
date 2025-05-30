package androidx.core.view;

import android.view.View;
import android.view.WindowInsets;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;

/* compiled from: Taobao */
@RequiresApi(20)
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
class ViewCompat$Api20Impl {
    private ViewCompat$Api20Impl() {
    }

    @DoNotInline
    static WindowInsets dispatchApplyWindowInsets(View view, WindowInsets windowInsets) {
        return view.dispatchApplyWindowInsets(windowInsets);
    }

    @DoNotInline
    static WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
        return view.onApplyWindowInsets(windowInsets);
    }

    @DoNotInline
    static void requestApplyInsets(View view) {
        view.requestApplyInsets();
    }
}
