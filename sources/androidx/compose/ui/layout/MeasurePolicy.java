package androidx.compose.ui.layout;

import androidx.compose.runtime.Stable;
import java.util.List;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@Stable
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public interface MeasurePolicy {
    int maxIntrinsicHeight(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull List<? extends IntrinsicMeasurable> list, int i);

    int maxIntrinsicWidth(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull List<? extends IntrinsicMeasurable> list, int i);

    @NotNull
    /* renamed from: measure-3p2s80s */
    MeasureResult mo16measure3p2s80s(@NotNull MeasureScope measureScope, @NotNull List<? extends Measurable> list, long j);

    int minIntrinsicHeight(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull List<? extends IntrinsicMeasurable> list, int i);

    int minIntrinsicWidth(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull List<? extends IntrinsicMeasurable> list, int i);
}
