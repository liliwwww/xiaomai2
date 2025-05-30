package androidx.compose.ui.node;

import androidx.compose.ui.platform.ViewConfiguration;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class ComposeUiNode$Companion$SetViewConfiguration$1 extends Lambda implements Function2<ComposeUiNode, ViewConfiguration, Unit> {
    public static final ComposeUiNode$Companion$SetViewConfiguration$1 INSTANCE = new ComposeUiNode$Companion$SetViewConfiguration$1();

    ComposeUiNode$Companion$SetViewConfiguration$1() {
        super(2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((ComposeUiNode) obj, (ViewConfiguration) obj2);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull ComposeUiNode composeUiNode, @NotNull ViewConfiguration viewConfiguration) {
        Intrinsics.checkNotNullParameter(composeUiNode, "$this$null");
        Intrinsics.checkNotNullParameter(viewConfiguration, "it");
        composeUiNode.setViewConfiguration(viewConfiguration);
    }
}
