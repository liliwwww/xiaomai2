package androidx.compose.foundation;

import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.ui.platform.InspectorInfo;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class ScrollKt$scroll$$inlined$debugInspectorInfo$1 extends Lambda implements Function1<InspectorInfo, Unit> {
    final /* synthetic */ FlingBehavior $flingBehavior$inlined;
    final /* synthetic */ boolean $isScrollable$inlined;
    final /* synthetic */ boolean $isVertical$inlined;
    final /* synthetic */ boolean $reverseScrolling$inlined;
    final /* synthetic */ ScrollState $state$inlined;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ScrollKt$scroll$$inlined$debugInspectorInfo$1(ScrollState scrollState, boolean z, FlingBehavior flingBehavior, boolean z2, boolean z3) {
        super(1);
        this.$state$inlined = scrollState;
        this.$reverseScrolling$inlined = z;
        this.$flingBehavior$inlined = flingBehavior;
        this.$isScrollable$inlined = z2;
        this.$isVertical$inlined = z3;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((InspectorInfo) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull InspectorInfo inspectorInfo) {
        Intrinsics.checkNotNullParameter(inspectorInfo, "$this$null");
        inspectorInfo.setName("scroll");
        inspectorInfo.getProperties().set("state", this.$state$inlined);
        inspectorInfo.getProperties().set("reverseScrolling", Boolean.valueOf(this.$reverseScrolling$inlined));
        inspectorInfo.getProperties().set("flingBehavior", this.$flingBehavior$inlined);
        inspectorInfo.getProperties().set("isScrollable", Boolean.valueOf(this.$isScrollable$inlined));
        inspectorInfo.getProperties().set("isVertical", Boolean.valueOf(this.$isVertical$inlined));
    }
}
