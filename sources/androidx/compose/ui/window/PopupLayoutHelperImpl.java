package androidx.compose.ui.window;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
class PopupLayoutHelperImpl implements PopupLayoutHelper {
    public void getWindowVisibleDisplayFrame(@NotNull View view, @NotNull Rect rect) {
        Intrinsics.checkNotNullParameter(view, "composeView");
        Intrinsics.checkNotNullParameter(rect, "outRect");
        view.getWindowVisibleDisplayFrame(rect);
    }

    public void setGestureExclusionRects(@NotNull View view, int i, int i2) {
        Intrinsics.checkNotNullParameter(view, "composeView");
    }

    public void updateViewLayout(@NotNull WindowManager windowManager, @NotNull View view, @NotNull ViewGroup.LayoutParams layoutParams) {
        Intrinsics.checkNotNullParameter(windowManager, "windowManager");
        Intrinsics.checkNotNullParameter(view, "popupView");
        Intrinsics.checkNotNullParameter(layoutParams, "params");
        windowManager.updateViewLayout(view, layoutParams);
    }
}
