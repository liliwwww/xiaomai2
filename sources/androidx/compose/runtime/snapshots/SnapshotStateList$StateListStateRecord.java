package androidx.compose.runtime.snapshots;

import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class SnapshotStateList$StateListStateRecord<T> extends StateRecord {

    @NotNull
    private PersistentList<? extends T> list;
    private int modification;

    public SnapshotStateList$StateListStateRecord(@NotNull PersistentList<? extends T> persistentList) {
        Intrinsics.checkNotNullParameter(persistentList, "list");
        this.list = persistentList;
    }

    @Override // androidx.compose.runtime.snapshots.StateRecord
    public void assign(@NotNull StateRecord stateRecord) {
        Object obj;
        Intrinsics.checkNotNullParameter(stateRecord, "value");
        obj = SnapshotStateListKt.sync;
        synchronized (obj) {
            this.list = ((SnapshotStateList$StateListStateRecord) stateRecord).list;
            this.modification = ((SnapshotStateList$StateListStateRecord) stateRecord).modification;
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // androidx.compose.runtime.snapshots.StateRecord
    @NotNull
    public StateRecord create() {
        return new SnapshotStateList$StateListStateRecord(this.list);
    }

    @NotNull
    public final PersistentList<T> getList$runtime_release() {
        return this.list;
    }

    public final int getModification$runtime_release() {
        return this.modification;
    }

    public final void setList$runtime_release(@NotNull PersistentList<? extends T> persistentList) {
        Intrinsics.checkNotNullParameter(persistentList, "<set-?>");
        this.list = persistentList;
    }

    public final void setModification$runtime_release(int i) {
        this.modification = i;
    }
}
