package androidx.compose.foundation.layout;

import androidx.compose.ui.layout.IntrinsicMeasurable;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
final class FlowLayoutKt$flowMeasurePolicy$1$minMainAxisIntrinsicItemSize$1 extends Lambda implements Function3<IntrinsicMeasurable, Integer, Integer, Integer> {
    public static final FlowLayoutKt$flowMeasurePolicy$1$minMainAxisIntrinsicItemSize$1 INSTANCE = new FlowLayoutKt$flowMeasurePolicy$1$minMainAxisIntrinsicItemSize$1();

    FlowLayoutKt$flowMeasurePolicy$1$minMainAxisIntrinsicItemSize$1() {
        super(3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return invoke((IntrinsicMeasurable) obj, ((Number) obj2).intValue(), ((Number) obj3).intValue());
    }

    @NotNull
    public final Integer invoke(@NotNull IntrinsicMeasurable intrinsicMeasurable, int i, int i2) {
        Intrinsics.checkNotNullParameter(intrinsicMeasurable, "$this$null");
        return Integer.valueOf(intrinsicMeasurable.minIntrinsicWidth(i2));
    }
}
