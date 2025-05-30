package androidx.compose.ui.window;

import android.graphics.Rect;
import android.view.View;
import androidx.annotation.RequiresApi;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@RequiresApi(29)
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class PopupLayoutHelperImpl29 extends PopupLayoutHelperImpl {
    @Override // androidx.compose.ui.window.PopupLayoutHelperImpl
    public void setGestureExclusionRects(@NotNull View view, int i, int i2) {
        Intrinsics.checkNotNullParameter(view, "composeView");
        view.setSystemGestureExclusionRects(CollectionsKt.mutableListOf(new Rect[]{new Rect(0, 0, i, i2)}));
    }
}
