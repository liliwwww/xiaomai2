package androidx.compose.p004ui.window;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import androidx.annotation.VisibleForTesting;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@VisibleForTesting(otherwise = 2)
/* loaded from: classes.dex */
public interface PopupLayoutHelper {
    void getWindowVisibleDisplayFrame(@NotNull View view, @NotNull Rect rect);

    void setGestureExclusionRects(@NotNull View view, int i, int i2);

    void updateViewLayout(@NotNull WindowManager windowManager, @NotNull View view, @NotNull ViewGroup.LayoutParams layoutParams);
}
