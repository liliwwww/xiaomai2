package androidx.compose.p004ui.text.input;

import androidx.compose.p004ui.text.AnnotatedString;
import androidx.compose.p004ui.text.AnnotatedStringKt;
import androidx.compose.p004ui.text.TextRange;
import androidx.compose.runtime.internal.StabilityInferred;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@StabilityInferred(parameters = 0)
/* loaded from: classes2.dex */
public final class EditProcessor {
    public static final int $stable = 8;

    @NotNull
    private TextFieldValue mBufferState = new TextFieldValue(AnnotatedStringKt.emptyAnnotatedString(), TextRange.Companion.m4754getZerod9O1mEE(), (TextRange) null, (DefaultConstructorMarker) null);

    @NotNull
    private EditingBuffer mBuffer = new EditingBuffer(this.mBufferState.getAnnotatedString(), this.mBufferState.m4956getSelectiond9O1mEE(), (DefaultConstructorMarker) null);

    private final String generateBatchErrorMessage(List<? extends EditCommand> list, final EditCommand editCommand) {
        StringBuilder sb = new StringBuilder();
        sb.append("Error while applying EditCommand batch to buffer (length=" + this.mBuffer.getLength$ui_text_release() + ", composition=" + this.mBuffer.m4877getCompositionMzsxiRA$ui_text_release() + ", selection=" + ((Object) TextRange.m4752toStringimpl(this.mBuffer.m4878getSelectiond9O1mEE$ui_text_release())) + "):");
        Intrinsics.checkNotNullExpressionValue(sb, "append(value)");
        sb.append('\n');
        Intrinsics.checkNotNullExpressionValue(sb, "append('\\n')");
        CollectionsKt.joinTo$default(list, sb, "\n", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new Function1<EditCommand, CharSequence>() { // from class: androidx.compose.ui.text.input.EditProcessor$generateBatchErrorMessage$1$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @NotNull
            public final CharSequence invoke(@NotNull EditCommand editCommand2) {
                String stringForLog;
                Intrinsics.checkNotNullParameter(editCommand2, "it");
                String str = EditCommand.this == editCommand2 ? " > " : "   ";
                StringBuilder sb2 = new StringBuilder();
                sb2.append(str);
                stringForLog = this.toStringForLog(editCommand2);
                sb2.append(stringForLog);
                return sb2.toString();
            }
        }, 60, (Object) null);
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String toStringForLog(EditCommand editCommand) {
        if (editCommand instanceof CommitTextCommand) {
            StringBuilder sb = new StringBuilder();
            sb.append("CommitTextCommand(text.length=");
            CommitTextCommand commitTextCommand = (CommitTextCommand) editCommand;
            sb.append(commitTextCommand.getText().length());
            sb.append(", newCursorPosition=");
            sb.append(commitTextCommand.getNewCursorPosition());
            sb.append(')');
            return sb.toString();
        }
        if (editCommand instanceof SetComposingTextCommand) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("SetComposingTextCommand(text.length=");
            SetComposingTextCommand setComposingTextCommand = (SetComposingTextCommand) editCommand;
            sb2.append(setComposingTextCommand.getText().length());
            sb2.append(", newCursorPosition=");
            sb2.append(setComposingTextCommand.getNewCursorPosition());
            sb2.append(')');
            return sb2.toString();
        }
        if (!(editCommand instanceof SetComposingRegionCommand) && !(editCommand instanceof DeleteSurroundingTextCommand) && !(editCommand instanceof DeleteSurroundingTextInCodePointsCommand) && !(editCommand instanceof SetSelectionCommand) && !(editCommand instanceof FinishComposingTextCommand) && !(editCommand instanceof BackspaceCommand) && !(editCommand instanceof MoveCursorCommand) && !(editCommand instanceof DeleteAllCommand)) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("Unknown EditCommand: ");
            String simpleName = Reflection.getOrCreateKotlinClass(editCommand.getClass()).getSimpleName();
            if (simpleName == null) {
                simpleName = "{anonymous EditCommand}";
            }
            sb3.append(simpleName);
            return sb3.toString();
        }
        return editCommand.toString();
    }

    @NotNull
    public final TextFieldValue apply(@NotNull List<? extends EditCommand> list) {
        Intrinsics.checkNotNullParameter(list, "editCommands");
        int i = 0;
        EditCommand editCommand = null;
        try {
            int size = list.size();
            while (i < size) {
                EditCommand editCommand2 = list.get(i);
                try {
                    editCommand2.applyTo(this.mBuffer);
                    i++;
                    editCommand = editCommand2;
                } catch (Exception e) {
                    e = e;
                    editCommand = editCommand2;
                    throw new RuntimeException(generateBatchErrorMessage(list, editCommand), e);
                }
            }
            TextFieldValue textFieldValue = new TextFieldValue(this.mBuffer.toAnnotatedString$ui_text_release(), this.mBuffer.m4878getSelectiond9O1mEE$ui_text_release(), this.mBuffer.m4877getCompositionMzsxiRA$ui_text_release(), (DefaultConstructorMarker) null);
            this.mBufferState = textFieldValue;
            return textFieldValue;
        } catch (Exception e2) {
            e = e2;
        }
    }

    @NotNull
    public final EditingBuffer getMBuffer$ui_text_release() {
        return this.mBuffer;
    }

    @NotNull
    public final TextFieldValue getMBufferState$ui_text_release() {
        return this.mBufferState;
    }

    public final void reset(@NotNull TextFieldValue textFieldValue, @Nullable TextInputSession textInputSession) {
        Intrinsics.checkNotNullParameter(textFieldValue, "value");
        boolean z = true;
        boolean z2 = !Intrinsics.areEqual(textFieldValue.m4955getCompositionMzsxiRA(), this.mBuffer.m4877getCompositionMzsxiRA$ui_text_release());
        boolean z3 = false;
        if (!Intrinsics.areEqual(this.mBufferState.getAnnotatedString(), textFieldValue.getAnnotatedString())) {
            this.mBuffer = new EditingBuffer(textFieldValue.getAnnotatedString(), textFieldValue.m4956getSelectiond9O1mEE(), (DefaultConstructorMarker) null);
        } else if (TextRange.m4742equalsimpl0(this.mBufferState.m4956getSelectiond9O1mEE(), textFieldValue.m4956getSelectiond9O1mEE())) {
            z = false;
        } else {
            this.mBuffer.setSelection$ui_text_release(TextRange.m4747getMinimpl(textFieldValue.m4956getSelectiond9O1mEE()), TextRange.m4746getMaximpl(textFieldValue.m4956getSelectiond9O1mEE()));
            z = false;
            z3 = true;
        }
        if (textFieldValue.m4955getCompositionMzsxiRA() == null) {
            this.mBuffer.commitComposition$ui_text_release();
        } else if (!TextRange.m4743getCollapsedimpl(textFieldValue.m4955getCompositionMzsxiRA().m4753unboximpl())) {
            this.mBuffer.setComposition$ui_text_release(TextRange.m4747getMinimpl(textFieldValue.m4955getCompositionMzsxiRA().m4753unboximpl()), TextRange.m4746getMaximpl(textFieldValue.m4955getCompositionMzsxiRA().m4753unboximpl()));
        }
        if (z || (!z3 && z2)) {
            this.mBuffer.commitComposition$ui_text_release();
            textFieldValue = TextFieldValue.m4951copy3r_uNRQ$default(textFieldValue, (AnnotatedString) null, 0L, (TextRange) null, 3, (Object) null);
        }
        TextFieldValue textFieldValue2 = this.mBufferState;
        this.mBufferState = textFieldValue;
        if (textInputSession != null) {
            textInputSession.updateState(textFieldValue2, textFieldValue);
        }
    }

    @NotNull
    public final TextFieldValue toTextFieldValue() {
        return this.mBufferState;
    }
}
