package androidx.compose.foundation.lazy;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.ui.layout.PinnableContainer;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
final class LazyListPinnableItem implements LazyListPinnedItem, PinnableContainer.PinnedHandle, PinnableContainer {

    @NotNull
    private final MutableState _parentPinnableContainer$delegate;

    @NotNull
    private final MutableState index$delegate;

    @NotNull
    private final MutableState parentHandle$delegate;

    @NotNull
    private final MutableState pinsCount$delegate;

    @NotNull
    private final LazyListState state;

    public LazyListPinnableItem(@NotNull LazyListState lazyListState) {
        Intrinsics.checkNotNullParameter(lazyListState, "state");
        this.state = lazyListState;
        this.index$delegate = SnapshotStateKt.mutableStateOf$default(-1, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.pinsCount$delegate = SnapshotStateKt.mutableStateOf$default(0, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.parentHandle$delegate = SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
        this._parentPinnableContainer$delegate = SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
    }

    private final PinnableContainer.PinnedHandle getParentHandle() {
        return (PinnableContainer.PinnedHandle) this.parentHandle$delegate.getValue();
    }

    private final int getPinsCount() {
        return ((Number) this.pinsCount$delegate.getValue()).intValue();
    }

    private final PinnableContainer get_parentPinnableContainer() {
        return (PinnableContainer) this._parentPinnableContainer$delegate.getValue();
    }

    private final void setParentHandle(PinnableContainer.PinnedHandle pinnedHandle) {
        this.parentHandle$delegate.setValue(pinnedHandle);
    }

    private final void setPinsCount(int i) {
        this.pinsCount$delegate.setValue(Integer.valueOf(i));
    }

    private final void set_parentPinnableContainer(PinnableContainer pinnableContainer) {
        this._parentPinnableContainer$delegate.setValue(pinnableContainer);
    }

    public int getIndex() {
        return ((Number) this.index$delegate.getValue()).intValue();
    }

    @Nullable
    public final PinnableContainer getParentPinnableContainer() {
        return get_parentPinnableContainer();
    }

    public final void onDisposed() {
        int pinsCount = getPinsCount();
        for (int i = 0; i < pinsCount; i++) {
            unpin();
        }
    }

    @NotNull
    public PinnableContainer.PinnedHandle pin() {
        if (getPinsCount() == 0) {
            this.state.getPinnedItems$foundation_release().add(this);
            PinnableContainer parentPinnableContainer = getParentPinnableContainer();
            setParentHandle(parentPinnableContainer != null ? parentPinnableContainer.pin() : null);
        }
        setPinsCount(getPinsCount() + 1);
        return this;
    }

    public void setIndex(int i) {
        this.index$delegate.setValue(Integer.valueOf(i));
    }

    public final void setParentPinnableContainer(@Nullable PinnableContainer pinnableContainer) {
        Snapshot createNonObservableSnapshot = Snapshot.Companion.createNonObservableSnapshot();
        try {
            Snapshot makeCurrent = createNonObservableSnapshot.makeCurrent();
            try {
                if (pinnableContainer != get_parentPinnableContainer()) {
                    set_parentPinnableContainer(pinnableContainer);
                    if (getPinsCount() > 0) {
                        PinnableContainer.PinnedHandle parentHandle = getParentHandle();
                        if (parentHandle != null) {
                            parentHandle.unpin();
                        }
                        setParentHandle(pinnableContainer != null ? pinnableContainer.pin() : null);
                    }
                }
                Unit unit = Unit.INSTANCE;
            } finally {
                createNonObservableSnapshot.restoreCurrent(makeCurrent);
            }
        } finally {
            createNonObservableSnapshot.dispose();
        }
    }

    public void unpin() {
        if (!(getPinsCount() > 0)) {
            throw new IllegalStateException("Unpin should only be called once".toString());
        }
        setPinsCount(getPinsCount() - 1);
        if (getPinsCount() == 0) {
            this.state.getPinnedItems$foundation_release().remove(this);
            PinnableContainer.PinnedHandle parentHandle = getParentHandle();
            if (parentHandle != null) {
                parentHandle.unpin();
            }
            setParentHandle(null);
        }
    }
}
