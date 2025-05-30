package androidx.compose.foundation.layout;

import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.unit.Dp;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* renamed from: androidx.compose.foundation.layout.PaddingKt$absolutePadding-qDBjuR0$$inlined$debugInspectorInfo$1, reason: invalid class name */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class PaddingKt$absolutePaddingqDBjuR0$$inlined$debugInspectorInfo$1 extends Lambda implements Function1<InspectorInfo, Unit> {
    final /* synthetic */ float $bottom$inlined;
    final /* synthetic */ float $left$inlined;
    final /* synthetic */ float $right$inlined;
    final /* synthetic */ float $top$inlined;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PaddingKt$absolutePaddingqDBjuR0$$inlined$debugInspectorInfo$1(float f, float f2, float f3, float f4) {
        super(1);
        this.$left$inlined = f;
        this.$top$inlined = f2;
        this.$right$inlined = f3;
        this.$bottom$inlined = f4;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((InspectorInfo) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull InspectorInfo inspectorInfo) {
        Intrinsics.checkNotNullParameter(inspectorInfo, "$this$null");
        inspectorInfo.setName("absolutePadding");
        inspectorInfo.getProperties().set("left", Dp.m2140boximpl(this.$left$inlined));
        inspectorInfo.getProperties().set("top", Dp.m2140boximpl(this.$top$inlined));
        inspectorInfo.getProperties().set("right", Dp.m2140boximpl(this.$right$inlined));
        inspectorInfo.getProperties().set("bottom", Dp.m2140boximpl(this.$bottom$inlined));
    }
}
