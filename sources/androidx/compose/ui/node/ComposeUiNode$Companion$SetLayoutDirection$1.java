package androidx.compose.ui.node;

import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class ComposeUiNode$Companion$SetLayoutDirection$1 extends Lambda implements Function2<ComposeUiNode, LayoutDirection, Unit> {
    public static final ComposeUiNode$Companion$SetLayoutDirection$1 INSTANCE = new ComposeUiNode$Companion$SetLayoutDirection$1();

    ComposeUiNode$Companion$SetLayoutDirection$1() {
        super(2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((ComposeUiNode) obj, (LayoutDirection) obj2);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull ComposeUiNode composeUiNode, @NotNull LayoutDirection layoutDirection) {
        Intrinsics.checkNotNullParameter(composeUiNode, "$this$null");
        Intrinsics.checkNotNullParameter(layoutDirection, "it");
        composeUiNode.setLayoutDirection(layoutDirection);
    }
}
