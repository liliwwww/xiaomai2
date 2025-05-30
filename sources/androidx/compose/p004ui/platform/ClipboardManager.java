package androidx.compose.p004ui.platform;

import androidx.compose.p004ui.text.AnnotatedString;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public interface ClipboardManager {
    @Nullable
    AnnotatedString getText();

    boolean hasText();

    void setText(@NotNull AnnotatedString annotatedString);
}
