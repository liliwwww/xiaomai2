package androidx.compose.runtime.snapshots;

import androidx.compose.runtime.external.kotlinx.collections.immutable.ImmutableSet;
import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap;
import androidx.compose.runtime.snapshots.SnapshotStateMap;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.KotlinNothingValueException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
final class SnapshotMapValueSet<K, V> extends SnapshotMapSet<K, V, V> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SnapshotMapValueSet(@NotNull SnapshotStateMap<K, V> snapshotStateMap) {
        super(snapshotStateMap);
        Intrinsics.checkNotNullParameter(snapshotStateMap, "map");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: add, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ boolean m806add(Object obj) {
        return ((Boolean) add((SnapshotMapValueSet<K, V>) obj)).booleanValue();
    }

    /* renamed from: addAll, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ boolean m807addAll(Collection collection) {
        return ((Boolean) addAll(collection)).booleanValue();
    }

    public boolean contains(Object obj) {
        return getMap().containsValue(obj);
    }

    public boolean containsAll(@NotNull Collection<? extends Object> collection) {
        Intrinsics.checkNotNullParameter(collection, "elements");
        if (collection.isEmpty()) {
            return true;
        }
        Iterator<T> it = collection.iterator();
        while (it.hasNext()) {
            if (!getMap().containsValue(it.next())) {
                return false;
            }
        }
        return true;
    }

    public boolean remove(Object obj) {
        return getMap().removeValue$runtime_release(obj);
    }

    public boolean removeAll(@NotNull Collection<? extends Object> collection) {
        PersistentMap map$runtime_release;
        int modification$runtime_release;
        boolean z;
        Snapshot current;
        Intrinsics.checkNotNullParameter(collection, "elements");
        Set set = CollectionsKt.toSet(collection);
        SnapshotStateMap map = getMap();
        boolean z2 = false;
        do {
            synchronized (SnapshotStateMapKt.access$getSync$p()) {
                SnapshotStateMap.StateMapStateRecord firstStateRecord = map.getFirstStateRecord();
                Intrinsics.checkNotNull(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord<K of androidx.compose.runtime.snapshots.SnapshotStateMap, V of androidx.compose.runtime.snapshots.SnapshotStateMap>");
                SnapshotStateMap.StateMapStateRecord current2 = SnapshotKt.current(firstStateRecord);
                map$runtime_release = current2.getMap$runtime_release();
                modification$runtime_release = current2.getModification$runtime_release();
                Unit unit = Unit.INSTANCE;
            }
            Intrinsics.checkNotNull(map$runtime_release);
            PersistentMap.Builder builder = map$runtime_release.builder();
            z = true;
            for (Map.Entry<K, V> entry : map.entrySet()) {
                if (set.contains(entry.getValue())) {
                    builder.remove(entry.getKey());
                    z2 = true;
                }
            }
            Unit unit2 = Unit.INSTANCE;
            PersistentMap build = builder.build();
            if (Intrinsics.areEqual(build, map$runtime_release)) {
                break;
            }
            synchronized (SnapshotStateMapKt.access$getSync$p()) {
                SnapshotStateMap.StateMapStateRecord firstStateRecord2 = map.getFirstStateRecord();
                Intrinsics.checkNotNull(firstStateRecord2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord<K of androidx.compose.runtime.snapshots.SnapshotStateMap, V of androidx.compose.runtime.snapshots.SnapshotStateMap>");
                SnapshotStateMap.StateMapStateRecord stateMapStateRecord = firstStateRecord2;
                SnapshotKt.getSnapshotInitializer();
                synchronized (SnapshotKt.getLock()) {
                    current = Snapshot.Companion.getCurrent();
                    SnapshotStateMap.StateMapStateRecord writableRecord = SnapshotKt.writableRecord(stateMapStateRecord, map, current);
                    if (writableRecord.getModification$runtime_release() == modification$runtime_release) {
                        writableRecord.setMap$runtime_release(build);
                        writableRecord.setModification$runtime_release(writableRecord.getModification$runtime_release() + 1);
                    } else {
                        z = false;
                    }
                }
                SnapshotKt.notifyWrite(current, map);
            }
        } while (!z);
        return z2;
    }

    public boolean retainAll(@NotNull Collection<? extends Object> collection) {
        PersistentMap map$runtime_release;
        int modification$runtime_release;
        boolean z;
        Snapshot current;
        Intrinsics.checkNotNullParameter(collection, "elements");
        Set set = CollectionsKt.toSet(collection);
        SnapshotStateMap map = getMap();
        boolean z2 = false;
        do {
            synchronized (SnapshotStateMapKt.access$getSync$p()) {
                SnapshotStateMap.StateMapStateRecord firstStateRecord = map.getFirstStateRecord();
                Intrinsics.checkNotNull(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord<K of androidx.compose.runtime.snapshots.SnapshotStateMap, V of androidx.compose.runtime.snapshots.SnapshotStateMap>");
                SnapshotStateMap.StateMapStateRecord current2 = SnapshotKt.current(firstStateRecord);
                map$runtime_release = current2.getMap$runtime_release();
                modification$runtime_release = current2.getModification$runtime_release();
                Unit unit = Unit.INSTANCE;
            }
            Intrinsics.checkNotNull(map$runtime_release);
            PersistentMap.Builder builder = map$runtime_release.builder();
            z = true;
            for (Map.Entry<K, V> entry : map.entrySet()) {
                if (!set.contains(entry.getValue())) {
                    builder.remove(entry.getKey());
                    z2 = true;
                }
            }
            Unit unit2 = Unit.INSTANCE;
            PersistentMap build = builder.build();
            if (Intrinsics.areEqual(build, map$runtime_release)) {
                break;
            }
            synchronized (SnapshotStateMapKt.access$getSync$p()) {
                SnapshotStateMap.StateMapStateRecord firstStateRecord2 = map.getFirstStateRecord();
                Intrinsics.checkNotNull(firstStateRecord2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord<K of androidx.compose.runtime.snapshots.SnapshotStateMap, V of androidx.compose.runtime.snapshots.SnapshotStateMap>");
                SnapshotStateMap.StateMapStateRecord stateMapStateRecord = firstStateRecord2;
                SnapshotKt.getSnapshotInitializer();
                synchronized (SnapshotKt.getLock()) {
                    current = Snapshot.Companion.getCurrent();
                    SnapshotStateMap.StateMapStateRecord writableRecord = SnapshotKt.writableRecord(stateMapStateRecord, map, current);
                    if (writableRecord.getModification$runtime_release() == modification$runtime_release) {
                        writableRecord.setMap$runtime_release(build);
                        writableRecord.setModification$runtime_release(writableRecord.getModification$runtime_release() + 1);
                    } else {
                        z = false;
                    }
                }
                SnapshotKt.notifyWrite(current, map);
            }
        } while (!z);
        return z2;
    }

    @NotNull
    public Void add(V v) {
        SnapshotStateMapKt.unsupported();
        throw new KotlinNothingValueException();
    }

    @NotNull
    public Void addAll(@NotNull Collection<? extends V> collection) {
        Intrinsics.checkNotNullParameter(collection, "elements");
        SnapshotStateMapKt.unsupported();
        throw new KotlinNothingValueException();
    }

    @NotNull
    /* renamed from: iterator, reason: merged with bridge method [inline-methods] */
    public StateMapMutableValuesIterator<K, V> m808iterator() {
        return new StateMapMutableValuesIterator<>(getMap(), ((ImmutableSet) getMap().getReadable$runtime_release().getMap$runtime_release().entrySet()).iterator());
    }
}
