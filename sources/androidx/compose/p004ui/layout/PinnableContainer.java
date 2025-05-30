package androidx.compose.p004ui.layout;

import androidx.compose.runtime.Stable;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@Stable
/* loaded from: classes2.dex */
public interface PinnableContainer {

    /* compiled from: Taobao */
    public interface PinnedHandle {
        void unpin();
    }

    @NotNull
    PinnedHandle pin();
}
