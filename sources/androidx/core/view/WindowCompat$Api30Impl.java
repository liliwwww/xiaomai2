package androidx.core.view;

import android.view.Window;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

/* compiled from: Taobao */
@RequiresApi(30)
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
class WindowCompat$Api30Impl {
    private WindowCompat$Api30Impl() {
    }

    @DoNotInline
    static void setDecorFitsSystemWindows(@NonNull Window window, boolean z) {
        window.setDecorFitsSystemWindows(z);
    }
}
