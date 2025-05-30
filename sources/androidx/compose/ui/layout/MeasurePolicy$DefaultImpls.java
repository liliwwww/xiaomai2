package androidx.compose.ui.layout;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tb.on2;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class MeasurePolicy$DefaultImpls {
    @Deprecated
    public static int maxIntrinsicHeight(@NotNull MeasurePolicy measurePolicy, @NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull List<? extends IntrinsicMeasurable> list, int i) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "$receiver");
        Intrinsics.checkNotNullParameter(list, "measurables");
        return on2.e(measurePolicy, intrinsicMeasureScope, list, i);
    }

    @Deprecated
    public static int maxIntrinsicWidth(@NotNull MeasurePolicy measurePolicy, @NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull List<? extends IntrinsicMeasurable> list, int i) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "$receiver");
        Intrinsics.checkNotNullParameter(list, "measurables");
        return on2.f(measurePolicy, intrinsicMeasureScope, list, i);
    }

    @Deprecated
    public static int minIntrinsicHeight(@NotNull MeasurePolicy measurePolicy, @NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull List<? extends IntrinsicMeasurable> list, int i) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "$receiver");
        Intrinsics.checkNotNullParameter(list, "measurables");
        return on2.g(measurePolicy, intrinsicMeasureScope, list, i);
    }

    @Deprecated
    public static int minIntrinsicWidth(@NotNull MeasurePolicy measurePolicy, @NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull List<? extends IntrinsicMeasurable> list, int i) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "$receiver");
        Intrinsics.checkNotNullParameter(list, "measurables");
        return on2.h(measurePolicy, intrinsicMeasureScope, list, i);
    }
}
