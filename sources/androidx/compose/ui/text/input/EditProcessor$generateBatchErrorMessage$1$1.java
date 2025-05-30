package androidx.compose.ui.text.input;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
final class EditProcessor$generateBatchErrorMessage$1$1 extends Lambda implements Function1<EditCommand, CharSequence> {
    final /* synthetic */ EditCommand $failedCommand;
    final /* synthetic */ EditProcessor this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    EditProcessor$generateBatchErrorMessage$1$1(EditCommand editCommand, EditProcessor editProcessor) {
        super(1);
        this.$failedCommand = editCommand;
        this.this$0 = editProcessor;
    }

    @NotNull
    public final CharSequence invoke(@NotNull EditCommand editCommand) {
        Intrinsics.checkNotNullParameter(editCommand, "it");
        return (this.$failedCommand == editCommand ? " > " : "   ") + EditProcessor.access$toStringForLog(this.this$0, editCommand);
    }
}
