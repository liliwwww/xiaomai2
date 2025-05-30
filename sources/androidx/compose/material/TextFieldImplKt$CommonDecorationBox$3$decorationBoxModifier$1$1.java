package androidx.compose.material;

import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
final class TextFieldImplKt$CommonDecorationBox$3$decorationBoxModifier$1$1 extends Lambda implements Function1<SemanticsPropertyReceiver, Unit> {
    final /* synthetic */ String $defaultErrorMessage;
    final /* synthetic */ boolean $isError;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    TextFieldImplKt$CommonDecorationBox$3$decorationBoxModifier$1$1(boolean z, String str) {
        super(1);
        this.$isError = z;
        this.$defaultErrorMessage = str;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((SemanticsPropertyReceiver) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull SemanticsPropertyReceiver semanticsPropertyReceiver) {
        Intrinsics.checkNotNullParameter(semanticsPropertyReceiver, "$this$semantics");
        if (this.$isError) {
            SemanticsPropertiesKt.error(semanticsPropertyReceiver, this.$defaultErrorMessage);
        }
    }
}
