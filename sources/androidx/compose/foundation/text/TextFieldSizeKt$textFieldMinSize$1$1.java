package androidx.compose.foundation.text;

import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.MeasureScope$CC;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.Placeable$PlacementScope;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.IntSize;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class TextFieldSizeKt$textFieldMinSize$1$1 extends Lambda implements Function3<MeasureScope, Measurable, Constraints, MeasureResult> {
    final /* synthetic */ TextFieldSize $minSizeState;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    TextFieldSizeKt$textFieldMinSize$1$1(TextFieldSize textFieldSize) {
        super(3);
        this.$minSizeState = textFieldSize;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return m581invoke3p2s80s((MeasureScope) obj, (Measurable) obj2, ((Constraints) obj3).unbox-impl());
    }

    @NotNull
    /* renamed from: invoke-3p2s80s, reason: not valid java name */
    public final MeasureResult m581invoke3p2s80s(@NotNull MeasureScope measureScope, @NotNull Measurable measurable, long j) {
        Intrinsics.checkNotNullParameter(measureScope, "$this$layout");
        Intrinsics.checkNotNullParameter(measurable, "measurable");
        SizeKt.m359defaultMinSizeVpY3zN4$default(Modifier.Companion, 0.0f, 0.0f, 3, null);
        long j2 = this.$minSizeState.getMinSize-YbymL2g();
        final Placeable placeable = measurable.measure-BRTryo0(Constraints.copy-Zbe2FdA$default(j, RangesKt.coerceIn(IntSize.m2685getWidthimpl(j2), Constraints.getMinWidth-impl(j), Constraints.getMaxWidth-impl(j)), 0, RangesKt.coerceIn(IntSize.m2684getHeightimpl(j2), Constraints.getMinHeight-impl(j), Constraints.getMaxHeight-impl(j)), 0, 10, (Object) null));
        return MeasureScope$CC.p(measureScope, placeable.getWidth(), placeable.getHeight(), null, new Function1<Placeable$PlacementScope, Unit>() { // from class: androidx.compose.foundation.text.TextFieldSizeKt$textFieldMinSize$1$1.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Placeable$PlacementScope) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull Placeable$PlacementScope placeable$PlacementScope) {
                Intrinsics.checkNotNullParameter(placeable$PlacementScope, "$this$layout");
                Placeable$PlacementScope.placeRelative$default(placeable$PlacementScope, placeable, 0, 0, 0.0f, 4, null);
            }
        }, 4, null);
    }
}
