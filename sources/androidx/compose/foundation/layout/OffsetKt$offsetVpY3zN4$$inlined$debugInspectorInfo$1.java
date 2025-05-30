package androidx.compose.foundation.layout;

import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.unit.Dp;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* renamed from: androidx.compose.foundation.layout.OffsetKt$offset-VpY3zN4$$inlined$debugInspectorInfo$1, reason: invalid class name */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class OffsetKt$offsetVpY3zN4$$inlined$debugInspectorInfo$1 extends Lambda implements Function1<InspectorInfo, Unit> {
    final /* synthetic */ float $x$inlined;
    final /* synthetic */ float $y$inlined;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OffsetKt$offsetVpY3zN4$$inlined$debugInspectorInfo$1(float f, float f2) {
        super(1);
        this.$x$inlined = f;
        this.$y$inlined = f2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((InspectorInfo) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull InspectorInfo inspectorInfo) {
        Intrinsics.checkNotNullParameter(inspectorInfo, "$this$null");
        inspectorInfo.setName("offset");
        inspectorInfo.getProperties().set("x", Dp.m2140boximpl(this.$x$inlined));
        inspectorInfo.getProperties().set("y", Dp.m2140boximpl(this.$y$inlined));
    }
}
