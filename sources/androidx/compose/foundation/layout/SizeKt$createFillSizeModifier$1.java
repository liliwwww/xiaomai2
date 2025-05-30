package androidx.compose.foundation.layout;

import androidx.compose.ui.platform.InspectorInfo;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
final class SizeKt$createFillSizeModifier$1 extends Lambda implements Function1<InspectorInfo, Unit> {
    final /* synthetic */ float $fraction;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SizeKt$createFillSizeModifier$1(float f) {
        super(1);
        this.$fraction = f;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((InspectorInfo) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull InspectorInfo inspectorInfo) {
        Intrinsics.checkNotNullParameter(inspectorInfo, "$this$$receiver");
        inspectorInfo.setName("fillMaxSize");
        inspectorInfo.getProperties().set("fraction", Float.valueOf(this.$fraction));
    }
}
