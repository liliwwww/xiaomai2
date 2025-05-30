package androidx.compose.ui.tooling.data;

import androidx.compose.runtime.internal.StabilityInferred;
import java.util.LinkedHashMap;
import java.util.Map;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@StabilityInferred(parameters = 0)
@UiToolingDataApi
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class ContextCache {
    public static final int $stable = 8;

    @NotNull
    private final Map<String, Object> contexts = new LinkedHashMap();

    public final void clear() {
        this.contexts.clear();
    }

    @NotNull
    public final Map<String, Object> getContexts$ui_tooling_data_release() {
        return this.contexts;
    }
}
