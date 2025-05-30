package androidx.compose.foundation;

import androidx.compose.foundation.MagnifierKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class MagnifierKt$magnifier$4$2$1 extends Lambda implements Function1<LayoutCoordinates, Unit> {
    final /* synthetic */ MutableState<Offset> $anchorPositionInRoot$delegate;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    MagnifierKt$magnifier$4$2$1(MutableState<Offset> mutableState) {
        super(1);
        this.$anchorPositionInRoot$delegate = mutableState;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((LayoutCoordinates) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull LayoutCoordinates layoutCoordinates) {
        Intrinsics.checkNotNullParameter(layoutCoordinates, "it");
        MagnifierKt.magnifier.4.access$invoke$lambda$2(this.$anchorPositionInRoot$delegate, LayoutCoordinatesKt.positionInRoot(layoutCoordinates));
    }
}
