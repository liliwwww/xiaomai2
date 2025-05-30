package androidx.compose.runtime.snapshots;

import java.util.Set;
import kotlin.KotlinNothingValueException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class TransparentObserverSnapshot extends Snapshot {
    private final boolean mergeParentObservers;
    private final boolean ownsPreviousSnapshot;

    @Nullable
    private final Snapshot previousSnapshot;

    @Nullable
    private final Function1<Object, Unit> readObserver;

    @NotNull
    private final Snapshot root;

    @Nullable
    private final Function1<Object, Unit> writeObserver;

    public TransparentObserverSnapshot(@Nullable Snapshot snapshot, @Nullable Function1<Object, Unit> function1, boolean z, boolean z2) {
        super(0, SnapshotIdSet.Companion.getEMPTY(), null);
        Function1<Object, Unit> readObserver$runtime_release;
        this.previousSnapshot = snapshot;
        this.mergeParentObservers = z;
        this.ownsPreviousSnapshot = z2;
        this.readObserver = SnapshotKt.access$mergedReadObserver(function1, (snapshot == null || (readObserver$runtime_release = snapshot.getReadObserver$runtime_release()) == null) ? ((GlobalSnapshot) SnapshotKt.access$getCurrentGlobalSnapshot$p().get()).getReadObserver$runtime_release() : readObserver$runtime_release, z);
        this.root = this;
    }

    private final Snapshot getCurrentSnapshot() {
        Snapshot snapshot = this.previousSnapshot;
        if (snapshot != null) {
            return snapshot;
        }
        Object obj = SnapshotKt.access$getCurrentGlobalSnapshot$p().get();
        Intrinsics.checkNotNullExpressionValue(obj, "currentGlobalSnapshot.get()");
        return (Snapshot) obj;
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public void dispose() {
        Snapshot snapshot;
        setDisposed$runtime_release(true);
        if (!this.ownsPreviousSnapshot || (snapshot = this.previousSnapshot) == null) {
            return;
        }
        snapshot.dispose();
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public int getId() {
        return getCurrentSnapshot().getId();
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    @NotNull
    public SnapshotIdSet getInvalid$runtime_release() {
        return getCurrentSnapshot().getInvalid$runtime_release();
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    @Nullable
    public Set<StateObject> getModified$runtime_release() {
        return getCurrentSnapshot().getModified$runtime_release();
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    @Nullable
    public Function1<Object, Unit> getReadObserver$runtime_release() {
        return this.readObserver;
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public boolean getReadOnly() {
        return getCurrentSnapshot().getReadOnly();
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    @NotNull
    public Snapshot getRoot() {
        return this.root;
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    @Nullable
    public Function1<Object, Unit> getWriteObserver$runtime_release() {
        return this.writeObserver;
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public boolean hasPendingChanges() {
        return getCurrentSnapshot().hasPendingChanges();
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public void notifyObjectsInitialized$runtime_release() {
        getCurrentSnapshot().notifyObjectsInitialized$runtime_release();
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    /* renamed from: recordModified$runtime_release */
    public void mo799recordModified$runtime_release(@NotNull StateObject stateObject) {
        Intrinsics.checkNotNullParameter(stateObject, "state");
        getCurrentSnapshot().mo799recordModified$runtime_release(stateObject);
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public void setId$runtime_release(int i) {
        SnapshotStateMapKt.unsupported();
        throw new KotlinNothingValueException();
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public void setInvalid$runtime_release(@NotNull SnapshotIdSet snapshotIdSet) {
        Intrinsics.checkNotNullParameter(snapshotIdSet, "value");
        SnapshotStateMapKt.unsupported();
        throw new KotlinNothingValueException();
    }

    public void setModified(@Nullable Set<StateObject> set) {
        SnapshotStateMapKt.unsupported();
        throw new KotlinNothingValueException();
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    @NotNull
    public Snapshot takeNestedSnapshot(@Nullable Function1<Object, Unit> function1) {
        Function1<Object, Unit> mergedReadObserver$default = SnapshotKt.mergedReadObserver$default(function1, getReadObserver$runtime_release(), false, 4, (Object) null);
        return !this.mergeParentObservers ? SnapshotKt.access$createTransparentSnapshotWithNoParentReadObserver(getCurrentSnapshot().takeNestedSnapshot(null), mergedReadObserver$default, true) : getCurrentSnapshot().takeNestedSnapshot(mergedReadObserver$default);
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    @NotNull
    /* renamed from: nestedActivated$runtime_release, reason: merged with bridge method [inline-methods] */
    public Void mo797nestedActivated$runtime_release(@NotNull Snapshot snapshot) {
        Intrinsics.checkNotNullParameter(snapshot, "snapshot");
        SnapshotStateMapKt.unsupported();
        throw new KotlinNothingValueException();
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    @NotNull
    /* renamed from: nestedDeactivated$runtime_release, reason: merged with bridge method [inline-methods] */
    public Void mo798nestedDeactivated$runtime_release(@NotNull Snapshot snapshot) {
        Intrinsics.checkNotNullParameter(snapshot, "snapshot");
        SnapshotStateMapKt.unsupported();
        throw new KotlinNothingValueException();
    }
}
