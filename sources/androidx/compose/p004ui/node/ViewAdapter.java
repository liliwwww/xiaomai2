package androidx.compose.p004ui.node;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.RestrictTo;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes2.dex */
public interface ViewAdapter {
    void didInsert(@NotNull View view, @NotNull ViewGroup viewGroup);

    void didUpdate(@NotNull View view, @NotNull ViewGroup viewGroup);

    int getId();

    void willInsert(@NotNull View view, @NotNull ViewGroup viewGroup);
}
