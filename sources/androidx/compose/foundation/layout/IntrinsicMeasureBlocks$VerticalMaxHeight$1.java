package androidx.compose.foundation.layout;

import androidx.compose.ui.layout.IntrinsicMeasurable;
import java.util.List;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class IntrinsicMeasureBlocks$VerticalMaxHeight$1 extends Lambda implements Function3<List<? extends IntrinsicMeasurable>, Integer, Integer, Integer> {
    public static final IntrinsicMeasureBlocks$VerticalMaxHeight$1 INSTANCE = new IntrinsicMeasureBlocks$VerticalMaxHeight$1();

    IntrinsicMeasureBlocks$VerticalMaxHeight$1() {
        super(3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return invoke((List<? extends IntrinsicMeasurable>) obj, ((Number) obj2).intValue(), ((Number) obj3).intValue());
    }

    @NotNull
    public final Integer invoke(@NotNull List<? extends IntrinsicMeasurable> list, int i, int i2) {
        int intrinsicSize;
        Intrinsics.checkNotNullParameter(list, "measurables");
        1 r2 = 1.INSTANCE;
        2 r3 = 2.INSTANCE;
        LayoutOrientation layoutOrientation = LayoutOrientation.Vertical;
        intrinsicSize = RowColumnImplKt.intrinsicSize(list, r2, r3, i, i2, layoutOrientation, layoutOrientation);
        return Integer.valueOf(intrinsicSize);
    }
}
