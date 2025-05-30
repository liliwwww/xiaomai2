package androidx.compose.animation;

import androidx.compose.ui.layout.IntrinsicMeasurable;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class AnimatedContentMeasurePolicy$maxIntrinsicWidth$1 extends Lambda implements Function1<IntrinsicMeasurable, Integer> {
    final /* synthetic */ int $height;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AnimatedContentMeasurePolicy$maxIntrinsicWidth$1(int i) {
        super(1);
        this.$height = i;
    }

    @NotNull
    public final Integer invoke(@NotNull IntrinsicMeasurable intrinsicMeasurable) {
        Intrinsics.checkNotNullParameter(intrinsicMeasurable, "it");
        return Integer.valueOf(intrinsicMeasurable.maxIntrinsicWidth(this.$height));
    }
}
