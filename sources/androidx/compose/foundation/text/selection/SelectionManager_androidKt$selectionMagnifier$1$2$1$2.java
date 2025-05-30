package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.text.selection.SelectionManager_androidKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DpSize;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class SelectionManager_androidKt$selectionMagnifier$1$2$1$2 extends Lambda implements Function1<DpSize, Unit> {
    final /* synthetic */ Density $density;
    final /* synthetic */ MutableState<IntSize> $magnifierSize$delegate;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SelectionManager_androidKt$selectionMagnifier$1$2$1$2(Density density, MutableState<IntSize> mutableState) {
        super(1);
        this.$density = density;
        this.$magnifierSize$delegate = mutableState;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        m641invokeEaSLcWc(((DpSize) obj).unbox-impl());
        return Unit.INSTANCE;
    }

    /* renamed from: invoke-EaSLcWc, reason: not valid java name */
    public final void m641invokeEaSLcWc(long j) {
        MutableState<IntSize> mutableState = this.$magnifierSize$delegate;
        Density density = this.$density;
        SelectionManager_androidKt.selectionMagnifier.1.access$invoke$lambda$2(mutableState, IntSizeKt.IntSize(density.roundToPx-0680j_4(DpSize.getWidth-D9Ej5fM(j)), density.roundToPx-0680j_4(DpSize.getHeight-D9Ej5fM(j))));
    }
}
