package androidx.compose.ui.text.input;

import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@StabilityInferred(parameters = 0)
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class DeleteAllCommand implements EditCommand {
    public static final int $stable = 0;

    public void applyTo(@NotNull EditingBuffer editingBuffer) {
        Intrinsics.checkNotNullParameter(editingBuffer, "buffer");
        editingBuffer.replace$ui_text_release(0, editingBuffer.getLength$ui_text_release(), "");
    }

    public boolean equals(@Nullable Object obj) {
        return obj instanceof DeleteAllCommand;
    }

    public int hashCode() {
        return Reflection.getOrCreateKotlinClass(DeleteAllCommand.class).hashCode();
    }

    @NotNull
    public String toString() {
        return "DeleteAllCommand()";
    }
}
