package androidx.compose.foundation.layout;

import androidx.compose.ui.layout.IntrinsicMeasurable;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
final class IntrinsicMeasureBlocks$VerticalMaxHeight$1$2 extends Lambda implements Function2<IntrinsicMeasurable, Integer, Integer> {
    public static final IntrinsicMeasureBlocks$VerticalMaxHeight$1$2 INSTANCE = new IntrinsicMeasureBlocks$VerticalMaxHeight$1$2();

    IntrinsicMeasureBlocks$VerticalMaxHeight$1$2() {
        super(2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return invoke((IntrinsicMeasurable) obj, ((Number) obj2).intValue());
    }

    @NotNull
    public final Integer invoke(@NotNull IntrinsicMeasurable intrinsicMeasurable, int i) {
        Intrinsics.checkNotNullParameter(intrinsicMeasurable, "$this$intrinsicSize");
        return Integer.valueOf(intrinsicMeasurable.maxIntrinsicWidth(i));
    }
}
