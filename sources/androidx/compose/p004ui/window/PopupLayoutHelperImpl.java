package androidx.compose.p004ui.window;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
class PopupLayoutHelperImpl implements PopupLayoutHelper {
    @Override // androidx.compose.p004ui.window.PopupLayoutHelper
    public void getWindowVisibleDisplayFrame(@NotNull View view, @NotNull Rect rect) {
        Intrinsics.checkNotNullParameter(view, "composeView");
        Intrinsics.checkNotNullParameter(rect, "outRect");
        view.getWindowVisibleDisplayFrame(rect);
    }

    @Override // androidx.compose.p004ui.window.PopupLayoutHelper
    public void setGestureExclusionRects(@NotNull View view, int i, int i2) {
        Intrinsics.checkNotNullParameter(view, "composeView");
    }

    @Override // androidx.compose.p004ui.window.PopupLayoutHelper
    public void updateViewLayout(@NotNull WindowManager windowManager, @NotNull View view, @NotNull ViewGroup.LayoutParams layoutParams) {
        Intrinsics.checkNotNullParameter(windowManager, "windowManager");
        Intrinsics.checkNotNullParameter(view, "popupView");
        Intrinsics.checkNotNullParameter(layoutParams, "params");
        windowManager.updateViewLayout(view, layoutParams);
    }
}
