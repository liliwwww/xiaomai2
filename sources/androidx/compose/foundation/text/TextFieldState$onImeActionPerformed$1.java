package androidx.compose.foundation.text;

import androidx.compose.ui.text.input.ImeAction;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class TextFieldState$onImeActionPerformed$1 extends Lambda implements Function1<ImeAction, Unit> {
    final /* synthetic */ TextFieldState this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    TextFieldState$onImeActionPerformed$1(TextFieldState textFieldState) {
        super(1);
        this.this$0 = textFieldState;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        m582invokeKlQnJC8(((ImeAction) obj).unbox-impl());
        return Unit.INSTANCE;
    }

    /* renamed from: invoke-KlQnJC8, reason: not valid java name */
    public final void m582invokeKlQnJC8(int i) {
        TextFieldState.access$getKeyboardActionRunner$p(this.this$0).runAction-KlQnJC8(i);
    }
}
