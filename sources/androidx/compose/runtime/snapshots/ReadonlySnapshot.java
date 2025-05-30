package androidx.compose.runtime.snapshots;

import java.util.HashSet;
import kotlin.KotlinNothingValueException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class ReadonlySnapshot extends Snapshot {

    @Nullable
    private final Function1<Object, Unit> readObserver;
    private int snapshots;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReadonlySnapshot(int i, @NotNull SnapshotIdSet snapshotIdSet, @Nullable Function1<Object, Unit> function1) {
        super(i, snapshotIdSet, null);
        Intrinsics.checkNotNullParameter(snapshotIdSet, "invalid");
        this.readObserver = function1;
        this.snapshots = 1;
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public void dispose() {
        if (getDisposed$runtime_release()) {
            return;
        }
        mo798nestedDeactivated$runtime_release(this);
        super.dispose();
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    @Nullable
    public HashSet<StateObject> getModified$runtime_release() {
        return null;
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    @Nullable
    public Function1<Object, Unit> getReadObserver$runtime_release() {
        return this.readObserver;
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public boolean getReadOnly() {
        return true;
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    @NotNull
    public Snapshot getRoot() {
        return this;
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    @Nullable
    public Function1<Object, Unit> getWriteObserver$runtime_release() {
        return null;
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public boolean hasPendingChanges() {
        return false;
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    /* renamed from: nestedActivated$runtime_release */
    public void mo797nestedActivated$runtime_release(@NotNull Snapshot snapshot) {
        Intrinsics.checkNotNullParameter(snapshot, "snapshot");
        this.snapshots++;
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    /* renamed from: nestedDeactivated$runtime_release */
    public void mo798nestedDeactivated$runtime_release(@NotNull Snapshot snapshot) {
        Intrinsics.checkNotNullParameter(snapshot, "snapshot");
        int i = this.snapshots - 1;
        this.snapshots = i;
        if (i == 0) {
            closeAndReleasePinning$runtime_release();
        }
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public void notifyObjectsInitialized$runtime_release() {
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    /* renamed from: recordModified$runtime_release */
    public void mo799recordModified$runtime_release(@NotNull StateObject stateObject) {
        Intrinsics.checkNotNullParameter(stateObject, "state");
        SnapshotKt.access$reportReadonlySnapshotWrite();
        throw new KotlinNothingValueException();
    }

    public void setModified(@Nullable HashSet<StateObject> hashSet) {
        SnapshotStateMapKt.unsupported();
        throw new KotlinNothingValueException();
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    @NotNull
    public Snapshot takeNestedSnapshot(@Nullable Function1<Object, Unit> function1) {
        SnapshotKt.access$validateOpen(this);
        return new NestedReadonlySnapshot(getId(), getInvalid$runtime_release(), function1, this);
    }
}
