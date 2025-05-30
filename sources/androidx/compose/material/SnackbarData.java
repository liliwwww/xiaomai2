package androidx.compose.material;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public interface SnackbarData {
    void dismiss();

    @Nullable
    String getActionLabel();

    @NotNull
    SnackbarDuration getDuration();

    @NotNull
    String getMessage();

    void performAction();
}
