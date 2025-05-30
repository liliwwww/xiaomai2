package androidx.core.view;

import android.view.Window;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;

/* compiled from: Taobao */
@RequiresApi(28)
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
class WindowCompat$Api28Impl {
    private WindowCompat$Api28Impl() {
    }

    @DoNotInline
    static <T> T requireViewById(Window window, int i) {
        return (T) window.requireViewById(i);
    }
}
