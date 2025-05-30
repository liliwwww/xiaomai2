package androidx.compose.foundation.layout;

import androidx.compose.ui.layout.IntrinsicMeasurable;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class IntrinsicMeasureBlocks$VerticalMinHeight$1$1 extends Lambda implements Function2<IntrinsicMeasurable, Integer, Integer> {
    public static final IntrinsicMeasureBlocks$VerticalMinHeight$1$1 INSTANCE = new IntrinsicMeasureBlocks$VerticalMinHeight$1$1();

    IntrinsicMeasureBlocks$VerticalMinHeight$1$1() {
        super(2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return invoke((IntrinsicMeasurable) obj, ((Number) obj2).intValue());
    }

    @NotNull
    public final Integer invoke(@NotNull IntrinsicMeasurable intrinsicMeasurable, int i) {
        Intrinsics.checkNotNullParameter(intrinsicMeasurable, "$this$intrinsicSize");
        return Integer.valueOf(intrinsicMeasurable.minIntrinsicHeight(i));
    }
}
