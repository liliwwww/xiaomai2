package androidx.compose.foundation.text;

import androidx.compose.ui.text.TextLayoutResult;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class TextController$createSemanticsModifierFor$1$1 extends Lambda implements Function1<List<TextLayoutResult>, Boolean> {
    final /* synthetic */ TextController this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    TextController$createSemanticsModifierFor$1$1(TextController textController) {
        super(1);
        this.this$0 = textController;
    }

    @NotNull
    public final Boolean invoke(@NotNull List<TextLayoutResult> list) {
        boolean z;
        Intrinsics.checkNotNullParameter(list, "it");
        if (this.this$0.getState().getLayoutResult() != null) {
            TextLayoutResult layoutResult = this.this$0.getState().getLayoutResult();
            Intrinsics.checkNotNull(layoutResult);
            list.add(layoutResult);
            z = true;
        } else {
            z = false;
        }
        return Boolean.valueOf(z);
    }
}
