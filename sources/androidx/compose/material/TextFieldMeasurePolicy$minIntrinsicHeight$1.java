package androidx.compose.material;

import androidx.compose.ui.layout.IntrinsicMeasurable;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class TextFieldMeasurePolicy$minIntrinsicHeight$1 extends Lambda implements Function2<IntrinsicMeasurable, Integer, Integer> {
    public static final TextFieldMeasurePolicy$minIntrinsicHeight$1 INSTANCE = new TextFieldMeasurePolicy$minIntrinsicHeight$1();

    TextFieldMeasurePolicy$minIntrinsicHeight$1() {
        super(2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return invoke((IntrinsicMeasurable) obj, ((Number) obj2).intValue());
    }

    @NotNull
    public final Integer invoke(@NotNull IntrinsicMeasurable intrinsicMeasurable, int i) {
        Intrinsics.checkNotNullParameter(intrinsicMeasurable, "intrinsicMeasurable");
        return Integer.valueOf(intrinsicMeasurable.minIntrinsicHeight(i));
    }
}
