package androidx.compose.ui.platform;

import androidx.compose.ui.platform.ViewCompositionStrategy;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class ViewCompositionStrategy$Companion {
    static final /* synthetic */ ViewCompositionStrategy$Companion $$INSTANCE = new ViewCompositionStrategy$Companion();

    private ViewCompositionStrategy$Companion() {
    }

    @NotNull
    public final ViewCompositionStrategy getDefault() {
        return ViewCompositionStrategy.DisposeOnDetachedFromWindowOrReleasedFromPool.INSTANCE;
    }
}
