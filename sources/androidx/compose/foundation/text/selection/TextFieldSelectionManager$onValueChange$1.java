package androidx.compose.foundation.text.selection;

import androidx.compose.ui.text.input.TextFieldValue;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class TextFieldSelectionManager$onValueChange$1 extends Lambda implements Function1<TextFieldValue, Unit> {
    public static final TextFieldSelectionManager$onValueChange$1 INSTANCE = new TextFieldSelectionManager$onValueChange$1();

    TextFieldSelectionManager$onValueChange$1() {
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((TextFieldValue) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull TextFieldValue textFieldValue) {
        Intrinsics.checkNotNullParameter(textFieldValue, "it");
    }
}
