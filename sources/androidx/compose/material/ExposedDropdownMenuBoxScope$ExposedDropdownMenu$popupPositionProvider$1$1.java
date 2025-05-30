package androidx.compose.material;

import androidx.compose.runtime.MutableState;
import androidx.compose.ui.graphics.TransformOrigin;
import androidx.compose.ui.unit.IntRect;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class ExposedDropdownMenuBoxScope$ExposedDropdownMenu$popupPositionProvider$1$1 extends Lambda implements Function2<IntRect, IntRect, Unit> {
    final /* synthetic */ MutableState<TransformOrigin> $transformOriginState;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ExposedDropdownMenuBoxScope$ExposedDropdownMenu$popupPositionProvider$1$1(MutableState<TransformOrigin> mutableState) {
        super(2);
        this.$transformOriginState = mutableState;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((IntRect) obj, (IntRect) obj2);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull IntRect intRect, @NotNull IntRect intRect2) {
        Intrinsics.checkNotNullParameter(intRect, "parentBounds");
        Intrinsics.checkNotNullParameter(intRect2, "menuBounds");
        this.$transformOriginState.setValue(TransformOrigin.box-impl(MenuKt.calculateTransformOrigin(intRect, intRect2)));
    }
}
