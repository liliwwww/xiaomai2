package androidx.compose.material.internal;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.IntRectKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.math.MathKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class ExposedDropdownMenuPopupKt$ExposedDropdownMenuPopup$5 extends Lambda implements Function1<LayoutCoordinates, Unit> {
    final /* synthetic */ PopupLayout $popupLayout;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ExposedDropdownMenuPopupKt$ExposedDropdownMenuPopup$5(PopupLayout popupLayout) {
        super(1);
        this.$popupLayout = popupLayout;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((LayoutCoordinates) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull LayoutCoordinates layoutCoordinates) {
        Intrinsics.checkNotNullParameter(layoutCoordinates, "childCoordinates");
        LayoutCoordinates parentLayoutCoordinates = layoutCoordinates.getParentLayoutCoordinates();
        Intrinsics.checkNotNull(parentLayoutCoordinates);
        long j = parentLayoutCoordinates.getSize-YbymL2g();
        long positionInWindow = LayoutCoordinatesKt.positionInWindow(parentLayoutCoordinates);
        this.$popupLayout.setParentBounds(IntRectKt.m2675IntRectVbeCjmY(IntOffsetKt.IntOffset(MathKt.roundToInt(Offset.getX-impl(positionInWindow)), MathKt.roundToInt(Offset.getY-impl(positionInWindow))), j));
        this.$popupLayout.updatePosition();
    }
}
