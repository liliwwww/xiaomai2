package androidx.compose.runtime.tooling;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public interface CompositionData {
    @Nullable
    CompositionGroup find(@NotNull Object obj);

    @NotNull
    Iterable<CompositionGroup> getCompositionGroups();

    boolean isEmpty();
}
