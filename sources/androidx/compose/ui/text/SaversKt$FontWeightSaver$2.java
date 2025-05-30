package androidx.compose.ui.text;

import androidx.compose.ui.text.font.FontWeight;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
final class SaversKt$FontWeightSaver$2 extends Lambda implements Function1<Object, FontWeight> {
    public static final SaversKt$FontWeightSaver$2 INSTANCE = new SaversKt$FontWeightSaver$2();

    SaversKt$FontWeightSaver$2() {
        super(1);
    }

    @Nullable
    /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
    public final FontWeight m1875invoke(@NotNull Object obj) {
        Intrinsics.checkNotNullParameter(obj, "it");
        return new FontWeight(((Integer) obj).intValue());
    }
}
