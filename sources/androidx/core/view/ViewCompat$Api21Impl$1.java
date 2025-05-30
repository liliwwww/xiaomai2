package androidx.core.view;

import android.os.Build;
import android.view.View;
import android.view.WindowInsets;
import androidx.core.view.ViewCompat;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
class ViewCompat$Api21Impl$1 implements View.OnApplyWindowInsetsListener {
    WindowInsetsCompat mLastInsets = null;
    final /* synthetic */ OnApplyWindowInsetsListener val$listener;
    final /* synthetic */ View val$v;

    ViewCompat$Api21Impl$1(View view, OnApplyWindowInsetsListener onApplyWindowInsetsListener) {
        this.val$v = view;
        this.val$listener = onApplyWindowInsetsListener;
    }

    @Override // android.view.View.OnApplyWindowInsetsListener
    public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
        WindowInsetsCompat windowInsetsCompat = WindowInsetsCompat.toWindowInsetsCompat(windowInsets, view);
        int i = Build.VERSION.SDK_INT;
        if (i < 30) {
            ViewCompat.Api21Impl.callCompatInsetAnimationCallback(windowInsets, this.val$v);
            if (windowInsetsCompat.equals(this.mLastInsets)) {
                return this.val$listener.onApplyWindowInsets(view, windowInsetsCompat).toWindowInsets();
            }
        }
        this.mLastInsets = windowInsetsCompat;
        WindowInsetsCompat onApplyWindowInsets = this.val$listener.onApplyWindowInsets(view, windowInsetsCompat);
        if (i >= 30) {
            return onApplyWindowInsets.toWindowInsets();
        }
        ViewCompat.requestApplyInsets(view);
        return onApplyWindowInsets.toWindowInsets();
    }
}
