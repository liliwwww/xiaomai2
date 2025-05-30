package androidx.customview.poolingcontainer;

import java.util.ArrayList;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
final class PoolingContainerListenerHolder {

    @NotNull
    private final ArrayList<PoolingContainerListener> listeners = new ArrayList<>();

    public final void addListener(@NotNull PoolingContainerListener poolingContainerListener) {
        Intrinsics.checkNotNullParameter(poolingContainerListener, "listener");
        this.listeners.add(poolingContainerListener);
    }

    public final void onRelease() {
        for (int lastIndex = CollectionsKt.getLastIndex(this.listeners); -1 < lastIndex; lastIndex--) {
            this.listeners.get(lastIndex).onRelease();
        }
    }

    public final void removeListener(@NotNull PoolingContainerListener poolingContainerListener) {
        Intrinsics.checkNotNullParameter(poolingContainerListener, "listener");
        this.listeners.remove(poolingContainerListener);
    }
}
