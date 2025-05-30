package androidx.compose.ui.platform;

import android.view.View;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.r56;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class ViewRootForInspector$DefaultImpls {
    @Deprecated
    @Nullable
    public static AbstractComposeView getSubCompositionView(@NotNull ViewRootForInspector viewRootForInspector) {
        return r56.c(viewRootForInspector);
    }

    @Deprecated
    @Nullable
    public static View getViewRoot(@NotNull ViewRootForInspector viewRootForInspector) {
        return r56.d(viewRootForInspector);
    }
}
