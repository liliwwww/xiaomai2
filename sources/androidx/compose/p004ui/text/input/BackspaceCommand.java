package androidx.compose.p004ui.text.input;

import androidx.compose.p004ui.text.JvmCharHelpers_androidKt;
import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@StabilityInferred(parameters = 0)
/* loaded from: classes.dex */
public final class BackspaceCommand implements EditCommand {
    public static final int $stable = 0;

    @Override // androidx.compose.p004ui.text.input.EditCommand
    public void applyTo(@NotNull EditingBuffer editingBuffer) {
        Intrinsics.checkNotNullParameter(editingBuffer, "buffer");
        if (editingBuffer.hasComposition$ui_text_release()) {
            editingBuffer.delete$ui_text_release(editingBuffer.getCompositionStart$ui_text_release(), editingBuffer.getCompositionEnd$ui_text_release());
            return;
        }
        if (editingBuffer.getCursor$ui_text_release() != -1) {
            if (editingBuffer.getCursor$ui_text_release() == 0) {
                return;
            }
            editingBuffer.delete$ui_text_release(JvmCharHelpers_androidKt.findPrecedingBreak(editingBuffer.toString(), editingBuffer.getCursor$ui_text_release()), editingBuffer.getCursor$ui_text_release());
        } else {
            int selectionStart$ui_text_release = editingBuffer.getSelectionStart$ui_text_release();
            int selectionEnd$ui_text_release = editingBuffer.getSelectionEnd$ui_text_release();
            editingBuffer.setCursor$ui_text_release(editingBuffer.getSelectionStart$ui_text_release());
            editingBuffer.delete$ui_text_release(selectionStart$ui_text_release, selectionEnd$ui_text_release);
        }
    }

    public boolean equals(@Nullable Object obj) {
        return obj instanceof BackspaceCommand;
    }

    public int hashCode() {
        return Reflection.getOrCreateKotlinClass(BackspaceCommand.class).hashCode();
    }

    @NotNull
    public String toString() {
        return "BackspaceCommand()";
    }
}
