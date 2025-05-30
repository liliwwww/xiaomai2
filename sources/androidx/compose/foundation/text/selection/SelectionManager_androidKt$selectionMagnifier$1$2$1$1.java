package androidx.compose.foundation.text.selection;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.unit.Density;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class SelectionManager_androidKt$selectionMagnifier$1$2$1$1 extends Lambda implements Function1<Density, Offset> {
    final /* synthetic */ Function0<Offset> $center;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SelectionManager_androidKt$selectionMagnifier$1$2$1$1(Function0<Offset> function0) {
        super(1);
        this.$center = function0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return Offset.box-impl(m640invoketuRUvjQ((Density) obj));
    }

    /* renamed from: invoke-tuRUvjQ, reason: not valid java name */
    public final long m640invoketuRUvjQ(@NotNull Density density) {
        Intrinsics.checkNotNullParameter(density, "$this$magnifier");
        return ((Offset) this.$center.invoke()).unbox-impl();
    }
}
