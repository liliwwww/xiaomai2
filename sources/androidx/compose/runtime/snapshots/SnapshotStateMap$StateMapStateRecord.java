package androidx.compose.runtime.snapshots;

import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class SnapshotStateMap$StateMapStateRecord<K, V> extends StateRecord {

    @NotNull
    private PersistentMap<K, ? extends V> map;
    private int modification;

    public SnapshotStateMap$StateMapStateRecord(@NotNull PersistentMap<K, ? extends V> persistentMap) {
        Intrinsics.checkNotNullParameter(persistentMap, "map");
        this.map = persistentMap;
    }

    public void assign(@NotNull StateRecord stateRecord) {
        Object obj;
        Intrinsics.checkNotNullParameter(stateRecord, "value");
        SnapshotStateMap$StateMapStateRecord snapshotStateMap$StateMapStateRecord = (SnapshotStateMap$StateMapStateRecord) stateRecord;
        obj = SnapshotStateMapKt.sync;
        synchronized (obj) {
            this.map = snapshotStateMap$StateMapStateRecord.map;
            this.modification = snapshotStateMap$StateMapStateRecord.modification;
            Unit unit = Unit.INSTANCE;
        }
    }

    @NotNull
    public StateRecord create() {
        return new SnapshotStateMap$StateMapStateRecord(this.map);
    }

    @NotNull
    public final PersistentMap<K, V> getMap$runtime_release() {
        return this.map;
    }

    public final int getModification$runtime_release() {
        return this.modification;
    }

    public final void setMap$runtime_release(@NotNull PersistentMap<K, ? extends V> persistentMap) {
        Intrinsics.checkNotNullParameter(persistentMap, "<set-?>");
        this.map = persistentMap;
    }

    public final void setModification$runtime_release(int i) {
        this.modification = i;
    }
}
