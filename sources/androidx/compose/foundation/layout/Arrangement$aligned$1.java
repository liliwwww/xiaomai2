package androidx.compose.foundation.layout;

import androidx.compose.ui.Alignment;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class Arrangement$aligned$1 extends Lambda implements Function2<Integer, LayoutDirection, Integer> {
    final /* synthetic */ Alignment.Horizontal $alignment;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    Arrangement$aligned$1(Alignment.Horizontal horizontal) {
        super(2);
        this.$alignment = horizontal;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return invoke(((Number) obj).intValue(), (LayoutDirection) obj2);
    }

    @NotNull
    public final Integer invoke(int i, @NotNull LayoutDirection layoutDirection) {
        Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
        return Integer.valueOf(this.$alignment.align(0, i, layoutDirection));
    }
}
