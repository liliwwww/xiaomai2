package androidx.core.widget;

import android.os.Build;
import android.view.View;
import android.widget.PopupMenu;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class PopupMenuCompat {
    private PopupMenuCompat() {
    }

    @Nullable
    public static View.OnTouchListener getDragToOpenListener(@NonNull Object obj) {
        if (Build.VERSION.SDK_INT >= 19) {
            return Api19Impl.getDragToOpenListener((PopupMenu) obj);
        }
        return null;
    }
}
