package androidx.compose.foundation.layout;

import androidx.compose.ui.layout.IntrinsicMeasurable;
import java.util.List;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class IntrinsicMeasureBlocks$VerticalMaxWidth$1 extends Lambda implements Function3<List<? extends IntrinsicMeasurable>, Integer, Integer, Integer> {
    public static final IntrinsicMeasureBlocks$VerticalMaxWidth$1 INSTANCE = new IntrinsicMeasureBlocks$VerticalMaxWidth$1();

    IntrinsicMeasureBlocks$VerticalMaxWidth$1() {
        super(3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return invoke((List<? extends IntrinsicMeasurable>) obj, ((Number) obj2).intValue(), ((Number) obj3).intValue());
    }

    @NotNull
    public final Integer invoke(@NotNull List<? extends IntrinsicMeasurable> list, int i, int i2) {
        int intrinsicSize;
        Intrinsics.checkNotNullParameter(list, "measurables");
        intrinsicSize = RowColumnImplKt.intrinsicSize(list, 1.INSTANCE, 2.INSTANCE, i, i2, LayoutOrientation.Vertical, LayoutOrientation.Horizontal);
        return Integer.valueOf(intrinsicSize);
    }
}
