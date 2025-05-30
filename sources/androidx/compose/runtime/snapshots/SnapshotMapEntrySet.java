package androidx.compose.runtime.snapshots;

import androidx.compose.runtime.external.kotlinx.collections.immutable.ImmutableSet;
import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap;
import androidx.compose.runtime.snapshots.SnapshotStateMap;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.KotlinNothingValueException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
final class SnapshotMapEntrySet<K, V> extends SnapshotMapSet<K, V, Map.Entry<K, V>> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SnapshotMapEntrySet(@NotNull SnapshotStateMap<K, V> snapshotStateMap) {
        super(snapshotStateMap);
        Intrinsics.checkNotNullParameter(snapshotStateMap, "map");
    }

    public /* bridge */ /* synthetic */ boolean add(Object obj) {
        return ((Boolean) add((Map.Entry) obj)).booleanValue();
    }

    /* renamed from: addAll, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ boolean m802addAll(Collection collection) {
        return ((Boolean) addAll(collection)).booleanValue();
    }

    public final /* bridge */ boolean contains(Object obj) {
        if (TypeIntrinsics.isMutableMapEntry(obj)) {
            return contains((Map.Entry) obj);
        }
        return false;
    }

    public boolean containsAll(@NotNull Collection<? extends Object> collection) {
        Intrinsics.checkNotNullParameter(collection, "elements");
        if (collection.isEmpty()) {
            return true;
        }
        Iterator<T> it = collection.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    @NotNull
    public Iterator<Map.Entry<K, V>> iterator() {
        return new StateMapMutableEntriesIterator(getMap(), ((ImmutableSet) getMap().getReadable$runtime_release().getMap$runtime_release().entrySet()).iterator());
    }

    public final /* bridge */ boolean remove(Object obj) {
        if (TypeIntrinsics.isMutableMapEntry(obj)) {
            return remove((Map.Entry) obj);
        }
        return false;
    }

    public boolean removeAll(@NotNull Collection<? extends Object> collection) {
        boolean z;
        Intrinsics.checkNotNullParameter(collection, "elements");
        Iterator<? extends Object> it = collection.iterator();
        while (true) {
            while (it.hasNext()) {
                z = getMap().remove(((Map.Entry) it.next()).getKey()) != null || z;
            }
            return z;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean retainAll(@NotNull Collection<? extends Object> collection) {
        PersistentMap map$runtime_release;
        int modification$runtime_release;
        boolean z;
        Snapshot current;
        Intrinsics.checkNotNullParameter(collection, "elements");
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(collection, 10)), 16));
        Iterator<T> it = collection.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Pair pair = TuplesKt.to(entry.getKey(), entry.getValue());
            linkedHashMap.put(pair.getFirst(), pair.getSecond());
        }
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
            for (Map.Entry<K, V> entry2 : map.entrySet()) {
                if ((linkedHashMap.containsKey(entry2.getKey()) && Intrinsics.areEqual(linkedHashMap.get(entry2.getKey()), entry2.getValue())) ? false : true) {
                    builder.remove(entry2.getKey());
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
    public Void add(@NotNull Map.Entry<K, V> entry) {
        Intrinsics.checkNotNullParameter(entry, "element");
        SnapshotStateMapKt.unsupported();
        throw new KotlinNothingValueException();
    }

    @NotNull
    public Void addAll(@NotNull Collection<? extends Map.Entry<K, V>> collection) {
        Intrinsics.checkNotNullParameter(collection, "elements");
        SnapshotStateMapKt.unsupported();
        throw new KotlinNothingValueException();
    }

    public boolean contains(@NotNull Map.Entry<K, V> entry) {
        Intrinsics.checkNotNullParameter(entry, "element");
        return Intrinsics.areEqual(getMap().get(entry.getKey()), entry.getValue());
    }

    public boolean remove(@NotNull Map.Entry<K, V> entry) {
        Intrinsics.checkNotNullParameter(entry, "element");
        return getMap().remove(entry.getKey()) != null;
    }
}
