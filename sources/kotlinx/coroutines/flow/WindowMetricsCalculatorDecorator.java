package kotlinx.coroutines.flow;

import androidx.annotation.RestrictTo;
import androidx.window.core.ExperimentalWindowApi;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@ExperimentalWindowApi
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H'¨\u0006\u0005"}, d2 = {"Landroidx/window/layout/WindowMetricsCalculatorDecorator;", "", "Landroidx/window/layout/WindowMetricsCalculator;", "calculator", "decorate", "window_release"}, k = 1, mv = {1, 5, 1})
@RestrictTo({RestrictTo.Scope.TESTS})
/* loaded from: classes.dex */
public interface WindowMetricsCalculatorDecorator {
    @ExperimentalWindowApi
    @RestrictTo({RestrictTo.Scope.TESTS})
    @NotNull
    WindowMetricsCalculator decorate(@NotNull WindowMetricsCalculator calculator);
}
