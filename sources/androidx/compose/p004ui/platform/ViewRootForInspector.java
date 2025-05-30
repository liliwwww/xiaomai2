package androidx.compose.p004ui.platform;

import android.view.View;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.r56;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public interface ViewRootForInspector {

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public static final class DefaultImpls {
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

    @Nullable
    AbstractComposeView getSubCompositionView();

    @Nullable
    View getViewRoot();
}
