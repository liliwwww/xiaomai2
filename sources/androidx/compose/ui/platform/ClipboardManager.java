package androidx.compose.ui.platform;

import androidx.compose.ui.text.AnnotatedString;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public interface ClipboardManager {
    @Nullable
    AnnotatedString getText();

    boolean hasText();

    void setText(@NotNull AnnotatedString annotatedString);
}
