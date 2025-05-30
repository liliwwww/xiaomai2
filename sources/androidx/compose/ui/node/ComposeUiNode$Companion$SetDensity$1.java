package androidx.compose.ui.node;

import androidx.compose.ui.unit.Density;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class ComposeUiNode$Companion$SetDensity$1 extends Lambda implements Function2<ComposeUiNode, Density, Unit> {
    public static final ComposeUiNode$Companion$SetDensity$1 INSTANCE = new ComposeUiNode$Companion$SetDensity$1();

    ComposeUiNode$Companion$SetDensity$1() {
        super(2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((ComposeUiNode) obj, (Density) obj2);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull ComposeUiNode composeUiNode, @NotNull Density density) {
        Intrinsics.checkNotNullParameter(composeUiNode, "$this$null");
        Intrinsics.checkNotNullParameter(density, "it");
        composeUiNode.setDensity(density);
    }
}
