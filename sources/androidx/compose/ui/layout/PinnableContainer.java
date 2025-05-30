package androidx.compose.ui.layout;

import androidx.compose.runtime.Stable;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@Stable
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public interface PinnableContainer {

    /* compiled from: Taobao */
    public interface PinnedHandle {
        void unpin();
    }

    @NotNull
    PinnedHandle pin();
}
