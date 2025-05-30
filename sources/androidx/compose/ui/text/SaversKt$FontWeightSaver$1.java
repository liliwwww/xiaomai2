package androidx.compose.ui.text;

import androidx.compose.runtime.saveable.SaverScope;
import androidx.compose.ui.text.font.FontWeight;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
final class SaversKt$FontWeightSaver$1 extends Lambda implements Function2<SaverScope, FontWeight, Object> {
    public static final SaversKt$FontWeightSaver$1 INSTANCE = new SaversKt$FontWeightSaver$1();

    SaversKt$FontWeightSaver$1() {
        super(2);
    }

    @Nullable
    public final Object invoke(@NotNull SaverScope saverScope, @NotNull FontWeight fontWeight) {
        Intrinsics.checkNotNullParameter(saverScope, "$this$Saver");
        Intrinsics.checkNotNullParameter(fontWeight, "it");
        return Integer.valueOf(fontWeight.getWeight());
    }
}
