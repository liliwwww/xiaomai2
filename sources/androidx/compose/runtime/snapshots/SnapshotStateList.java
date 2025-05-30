package androidx.compose.runtime.snapshots;

import androidx.compose.runtime.Stable;
import androidx.compose.runtime.external.kotlinx.collections.immutable.ExtensionsKt;
import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableList;
import org.jetbrains.annotations.NotNull;
import tb.k65;

/* compiled from: Taobao */
@Stable
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class SnapshotStateList<T> implements List<T>, StateObject, KMutableList {

    @NotNull
    private StateRecord firstStateRecord = new StateListStateRecord(ExtensionsKt.persistentListOf());

    private final boolean conditionalUpdate(Function1<? super PersistentList<? extends T>, ? extends PersistentList<? extends T>> function1) {
        int modification$runtime_release;
        PersistentList list$runtime_release;
        boolean z;
        Snapshot current;
        do {
            synchronized (SnapshotStateListKt.access$getSync$p()) {
                try {
                    StateListStateRecord firstStateRecord = getFirstStateRecord();
                    Intrinsics.checkNotNull(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
                    StateListStateRecord current2 = SnapshotKt.current(firstStateRecord);
                    modification$runtime_release = current2.getModification$runtime_release();
                    list$runtime_release = current2.getList$runtime_release();
                    Unit unit = Unit.INSTANCE;
                    InlineMarker.finallyStart(1);
                } catch (Throwable th) {
                    InlineMarker.finallyStart(1);
                    InlineMarker.finallyEnd(1);
                    throw th;
                }
            }
            InlineMarker.finallyEnd(1);
            Intrinsics.checkNotNull(list$runtime_release);
            PersistentList persistentList = (PersistentList) function1.invoke(list$runtime_release);
            z = false;
            if (Intrinsics.areEqual(persistentList, list$runtime_release)) {
                return false;
            }
            synchronized (SnapshotStateListKt.access$getSync$p()) {
                try {
                    StateListStateRecord firstStateRecord2 = getFirstStateRecord();
                    Intrinsics.checkNotNull(firstStateRecord2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
                    StateListStateRecord stateListStateRecord = firstStateRecord2;
                    SnapshotKt.getSnapshotInitializer();
                    synchronized (SnapshotKt.getLock()) {
                        try {
                            current = Snapshot.Companion.getCurrent();
                            StateListStateRecord writableRecord = SnapshotKt.writableRecord(stateListStateRecord, this, current);
                            if (writableRecord.getModification$runtime_release() == modification$runtime_release) {
                                writableRecord.setList$runtime_release(persistentList);
                                writableRecord.setModification$runtime_release(writableRecord.getModification$runtime_release() + 1);
                                z = true;
                            }
                            InlineMarker.finallyStart(1);
                        } catch (Throwable th2) {
                            InlineMarker.finallyStart(1);
                            InlineMarker.finallyEnd(1);
                            throw th2;
                        }
                    }
                    InlineMarker.finallyEnd(1);
                    SnapshotKt.notifyWrite(current, this);
                    InlineMarker.finallyStart(1);
                } catch (Throwable th3) {
                    InlineMarker.finallyStart(1);
                    InlineMarker.finallyEnd(1);
                    throw th3;
                }
            }
            InlineMarker.finallyEnd(1);
        } while (!z);
        return true;
    }

    public static /* synthetic */ void getDebuggerDisplayValue$annotations() {
    }

    public static /* synthetic */ void getReadable$runtime_release$annotations() {
    }

    private final <R> R mutate(Function1<? super List<T>, ? extends R> function1) {
        int modification$runtime_release;
        PersistentList list$runtime_release;
        R r;
        Snapshot current;
        boolean z;
        do {
            synchronized (SnapshotStateListKt.access$getSync$p()) {
                try {
                    StateListStateRecord firstStateRecord = getFirstStateRecord();
                    Intrinsics.checkNotNull(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
                    StateListStateRecord current2 = SnapshotKt.current(firstStateRecord);
                    modification$runtime_release = current2.getModification$runtime_release();
                    list$runtime_release = current2.getList$runtime_release();
                    Unit unit = Unit.INSTANCE;
                    InlineMarker.finallyStart(1);
                } catch (Throwable th) {
                    InlineMarker.finallyStart(1);
                    InlineMarker.finallyEnd(1);
                    throw th;
                }
            }
            InlineMarker.finallyEnd(1);
            Intrinsics.checkNotNull(list$runtime_release);
            PersistentList.Builder builder = list$runtime_release.builder();
            r = (R) function1.invoke(builder);
            PersistentList build = builder.build();
            if (Intrinsics.areEqual(build, list$runtime_release)) {
                break;
            }
            synchronized (SnapshotStateListKt.access$getSync$p()) {
                try {
                    StateListStateRecord firstStateRecord2 = getFirstStateRecord();
                    Intrinsics.checkNotNull(firstStateRecord2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
                    StateListStateRecord stateListStateRecord = firstStateRecord2;
                    SnapshotKt.getSnapshotInitializer();
                    synchronized (SnapshotKt.getLock()) {
                        try {
                            current = Snapshot.Companion.getCurrent();
                            StateListStateRecord writableRecord = SnapshotKt.writableRecord(stateListStateRecord, this, current);
                            if (writableRecord.getModification$runtime_release() == modification$runtime_release) {
                                writableRecord.setList$runtime_release(build);
                                writableRecord.setModification$runtime_release(writableRecord.getModification$runtime_release() + 1);
                                z = true;
                            } else {
                                z = false;
                            }
                            InlineMarker.finallyStart(1);
                        } finally {
                        }
                    }
                    InlineMarker.finallyEnd(1);
                    SnapshotKt.notifyWrite(current, this);
                    InlineMarker.finallyStart(1);
                } catch (Throwable th2) {
                    InlineMarker.finallyStart(1);
                    InlineMarker.finallyEnd(1);
                    throw th2;
                }
            }
            InlineMarker.finallyEnd(1);
        } while (!z);
        return r;
    }

    private final boolean mutateBoolean(Function1<? super List<T>, Boolean> function1) {
        int modification$runtime_release;
        PersistentList list$runtime_release;
        Object invoke;
        Snapshot current;
        boolean z;
        do {
            synchronized (SnapshotStateListKt.access$getSync$p()) {
                StateListStateRecord firstStateRecord = getFirstStateRecord();
                Intrinsics.checkNotNull(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
                StateListStateRecord current2 = SnapshotKt.current(firstStateRecord);
                modification$runtime_release = current2.getModification$runtime_release();
                list$runtime_release = current2.getList$runtime_release();
                Unit unit = Unit.INSTANCE;
            }
            Intrinsics.checkNotNull(list$runtime_release);
            PersistentList.Builder builder = list$runtime_release.builder();
            invoke = function1.invoke(builder);
            PersistentList build = builder.build();
            if (Intrinsics.areEqual(build, list$runtime_release)) {
                break;
            }
            synchronized (SnapshotStateListKt.access$getSync$p()) {
                StateListStateRecord firstStateRecord2 = getFirstStateRecord();
                Intrinsics.checkNotNull(firstStateRecord2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
                StateListStateRecord stateListStateRecord = firstStateRecord2;
                SnapshotKt.getSnapshotInitializer();
                synchronized (SnapshotKt.getLock()) {
                    current = Snapshot.Companion.getCurrent();
                    StateListStateRecord writableRecord = SnapshotKt.writableRecord(stateListStateRecord, this, current);
                    z = true;
                    if (writableRecord.getModification$runtime_release() == modification$runtime_release) {
                        writableRecord.setList$runtime_release(build);
                        writableRecord.setModification$runtime_release(writableRecord.getModification$runtime_release() + 1);
                    } else {
                        z = false;
                    }
                }
                SnapshotKt.notifyWrite(current, this);
            }
        } while (!z);
        return ((Boolean) invoke).booleanValue();
    }

    private final void update(Function1<? super PersistentList<? extends T>, ? extends PersistentList<? extends T>> function1) {
        int modification$runtime_release;
        PersistentList list$runtime_release;
        Snapshot current;
        boolean z;
        do {
            synchronized (SnapshotStateListKt.access$getSync$p()) {
                try {
                    StateListStateRecord firstStateRecord = getFirstStateRecord();
                    Intrinsics.checkNotNull(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
                    StateListStateRecord current2 = SnapshotKt.current(firstStateRecord);
                    modification$runtime_release = current2.getModification$runtime_release();
                    list$runtime_release = current2.getList$runtime_release();
                    Unit unit = Unit.INSTANCE;
                    InlineMarker.finallyStart(1);
                } catch (Throwable th) {
                    InlineMarker.finallyStart(1);
                    InlineMarker.finallyEnd(1);
                    throw th;
                }
            }
            InlineMarker.finallyEnd(1);
            Intrinsics.checkNotNull(list$runtime_release);
            PersistentList persistentList = (PersistentList) function1.invoke(list$runtime_release);
            if (Intrinsics.areEqual(persistentList, list$runtime_release)) {
                return;
            }
            synchronized (SnapshotStateListKt.access$getSync$p()) {
                try {
                    StateListStateRecord firstStateRecord2 = getFirstStateRecord();
                    Intrinsics.checkNotNull(firstStateRecord2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
                    StateListStateRecord stateListStateRecord = firstStateRecord2;
                    SnapshotKt.getSnapshotInitializer();
                    synchronized (SnapshotKt.getLock()) {
                        try {
                            current = Snapshot.Companion.getCurrent();
                            StateListStateRecord writableRecord = SnapshotKt.writableRecord(stateListStateRecord, this, current);
                            if (writableRecord.getModification$runtime_release() == modification$runtime_release) {
                                writableRecord.setList$runtime_release(persistentList);
                                writableRecord.setModification$runtime_release(writableRecord.getModification$runtime_release() + 1);
                                z = true;
                            } else {
                                z = false;
                            }
                            InlineMarker.finallyStart(1);
                        } catch (Throwable th2) {
                            InlineMarker.finallyStart(1);
                            InlineMarker.finallyEnd(1);
                            throw th2;
                        }
                    }
                    InlineMarker.finallyEnd(1);
                    SnapshotKt.notifyWrite(current, this);
                    InlineMarker.finallyStart(1);
                } catch (Throwable th3) {
                    InlineMarker.finallyStart(1);
                    InlineMarker.finallyEnd(1);
                    throw th3;
                }
            }
            InlineMarker.finallyEnd(1);
        } while (!z);
    }

    private final <R> R withCurrent(Function1<? super StateListStateRecord<T>, ? extends R> function1) {
        StateListStateRecord firstStateRecord = getFirstStateRecord();
        Intrinsics.checkNotNull(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
        return (R) function1.invoke(SnapshotKt.current(firstStateRecord));
    }

    private final <R> R writable(Function1<? super StateListStateRecord<T>, ? extends R> function1) {
        Snapshot current;
        R r;
        StateListStateRecord firstStateRecord = getFirstStateRecord();
        Intrinsics.checkNotNull(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
        StateListStateRecord stateListStateRecord = firstStateRecord;
        SnapshotKt.getSnapshotInitializer();
        synchronized (SnapshotKt.getLock()) {
            try {
                current = Snapshot.Companion.getCurrent();
                r = (R) function1.invoke(SnapshotKt.writableRecord(stateListStateRecord, this, current));
                InlineMarker.finallyStart(1);
            } catch (Throwable th) {
                InlineMarker.finallyStart(1);
                InlineMarker.finallyEnd(1);
                throw th;
            }
        }
        InlineMarker.finallyEnd(1);
        SnapshotKt.notifyWrite(current, this);
        return r;
    }

    @Override // java.util.List, java.util.Collection
    public boolean add(T t) {
        int modification$runtime_release;
        PersistentList list$runtime_release;
        boolean z;
        Snapshot current;
        do {
            synchronized (SnapshotStateListKt.access$getSync$p()) {
                StateListStateRecord firstStateRecord = getFirstStateRecord();
                Intrinsics.checkNotNull(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
                StateListStateRecord current2 = SnapshotKt.current(firstStateRecord);
                modification$runtime_release = current2.getModification$runtime_release();
                list$runtime_release = current2.getList$runtime_release();
                Unit unit = Unit.INSTANCE;
            }
            Intrinsics.checkNotNull(list$runtime_release);
            PersistentList add = list$runtime_release.add((PersistentList) t);
            z = false;
            if (Intrinsics.areEqual(add, list$runtime_release)) {
                return false;
            }
            synchronized (SnapshotStateListKt.access$getSync$p()) {
                StateListStateRecord firstStateRecord2 = getFirstStateRecord();
                Intrinsics.checkNotNull(firstStateRecord2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
                StateListStateRecord stateListStateRecord = firstStateRecord2;
                SnapshotKt.getSnapshotInitializer();
                synchronized (SnapshotKt.getLock()) {
                    current = Snapshot.Companion.getCurrent();
                    StateListStateRecord writableRecord = SnapshotKt.writableRecord(stateListStateRecord, this, current);
                    if (writableRecord.getModification$runtime_release() == modification$runtime_release) {
                        writableRecord.setList$runtime_release(add);
                        writableRecord.setModification$runtime_release(writableRecord.getModification$runtime_release() + 1);
                        z = true;
                    }
                }
                SnapshotKt.notifyWrite(current, this);
            }
        } while (!z);
        return true;
    }

    @Override // java.util.List
    public boolean addAll(final int i, @NotNull final Collection<? extends T> collection) {
        Intrinsics.checkNotNullParameter(collection, "elements");
        return mutateBoolean(new Function1<List<T>, Boolean>() { // from class: androidx.compose.runtime.snapshots.SnapshotStateList$addAll$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @NotNull
            public final Boolean invoke(@NotNull List<T> list) {
                Intrinsics.checkNotNullParameter(list, "it");
                return Boolean.valueOf(list.addAll(i, collection));
            }
        });
    }

    @Override // java.util.List, java.util.Collection
    public void clear() {
        Snapshot current;
        synchronized (SnapshotStateListKt.access$getSync$p()) {
            StateListStateRecord firstStateRecord = getFirstStateRecord();
            Intrinsics.checkNotNull(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
            StateListStateRecord stateListStateRecord = firstStateRecord;
            SnapshotKt.getSnapshotInitializer();
            synchronized (SnapshotKt.getLock()) {
                current = Snapshot.Companion.getCurrent();
                StateListStateRecord writableRecord = SnapshotKt.writableRecord(stateListStateRecord, this, current);
                writableRecord.setList$runtime_release(ExtensionsKt.persistentListOf());
                writableRecord.setModification$runtime_release(writableRecord.getModification$runtime_release() + 1);
            }
            SnapshotKt.notifyWrite(current, this);
        }
    }

    @Override // java.util.List, java.util.Collection
    public boolean contains(Object obj) {
        return getReadable$runtime_release().getList$runtime_release().contains(obj);
    }

    @Override // java.util.List, java.util.Collection
    public boolean containsAll(@NotNull Collection<? extends Object> collection) {
        Intrinsics.checkNotNullParameter(collection, "elements");
        return getReadable$runtime_release().getList$runtime_release().containsAll(collection);
    }

    @Override // java.util.List
    public T get(int i) {
        return (T) getReadable$runtime_release().getList$runtime_release().get(i);
    }

    @JvmName(name = "getDebuggerDisplayValue")
    @NotNull
    public final List<T> getDebuggerDisplayValue() {
        StateListStateRecord firstStateRecord = getFirstStateRecord();
        Intrinsics.checkNotNull(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
        return (List<T>) SnapshotKt.current(firstStateRecord).getList$runtime_release();
    }

    @Override // androidx.compose.runtime.snapshots.StateObject
    @NotNull
    public StateRecord getFirstStateRecord() {
        return this.firstStateRecord;
    }

    public final int getModification$runtime_release() {
        StateListStateRecord firstStateRecord = getFirstStateRecord();
        Intrinsics.checkNotNull(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
        return SnapshotKt.current(firstStateRecord).getModification$runtime_release();
    }

    @NotNull
    public final StateListStateRecord<T> getReadable$runtime_release() {
        StateListStateRecord firstStateRecord = getFirstStateRecord();
        Intrinsics.checkNotNull(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
        return SnapshotKt.readable(firstStateRecord, this);
    }

    public int getSize() {
        return getReadable$runtime_release().getList$runtime_release().size();
    }

    @Override // java.util.List
    public int indexOf(Object obj) {
        return getReadable$runtime_release().getList$runtime_release().indexOf(obj);
    }

    @Override // java.util.List, java.util.Collection
    public boolean isEmpty() {
        return getReadable$runtime_release().getList$runtime_release().isEmpty();
    }

    @Override // java.util.List, java.util.Collection, java.lang.Iterable
    @NotNull
    public Iterator<T> iterator() {
        return listIterator();
    }

    @Override // java.util.List
    public int lastIndexOf(Object obj) {
        return getReadable$runtime_release().getList$runtime_release().lastIndexOf(obj);
    }

    @Override // java.util.List
    @NotNull
    public ListIterator<T> listIterator() {
        return new StateListIterator(this, 0);
    }

    @Override // androidx.compose.runtime.snapshots.StateObject
    public /* synthetic */ StateRecord mergeRecords(StateRecord stateRecord, StateRecord stateRecord2, StateRecord stateRecord3) {
        return k65.a(this, stateRecord, stateRecord2, stateRecord3);
    }

    @Override // androidx.compose.runtime.snapshots.StateObject
    public void prependStateRecord(@NotNull StateRecord stateRecord) {
        Intrinsics.checkNotNullParameter(stateRecord, "value");
        stateRecord.setNext$runtime_release(getFirstStateRecord());
        this.firstStateRecord = (StateListStateRecord) stateRecord;
    }

    @Override // java.util.List
    public final /* bridge */ T remove(int i) {
        return removeAt(i);
    }

    @Override // java.util.List, java.util.Collection
    public boolean removeAll(@NotNull Collection<? extends Object> collection) {
        int modification$runtime_release;
        PersistentList list$runtime_release;
        boolean z;
        Snapshot current;
        Intrinsics.checkNotNullParameter(collection, "elements");
        do {
            synchronized (SnapshotStateListKt.access$getSync$p()) {
                StateListStateRecord firstStateRecord = getFirstStateRecord();
                Intrinsics.checkNotNull(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
                StateListStateRecord current2 = SnapshotKt.current(firstStateRecord);
                modification$runtime_release = current2.getModification$runtime_release();
                list$runtime_release = current2.getList$runtime_release();
                Unit unit = Unit.INSTANCE;
            }
            Intrinsics.checkNotNull(list$runtime_release);
            PersistentList removeAll = list$runtime_release.removeAll((Collection) collection);
            z = false;
            if (Intrinsics.areEqual(removeAll, list$runtime_release)) {
                return false;
            }
            synchronized (SnapshotStateListKt.access$getSync$p()) {
                StateListStateRecord firstStateRecord2 = getFirstStateRecord();
                Intrinsics.checkNotNull(firstStateRecord2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
                StateListStateRecord stateListStateRecord = firstStateRecord2;
                SnapshotKt.getSnapshotInitializer();
                synchronized (SnapshotKt.getLock()) {
                    current = Snapshot.Companion.getCurrent();
                    StateListStateRecord writableRecord = SnapshotKt.writableRecord(stateListStateRecord, this, current);
                    if (writableRecord.getModification$runtime_release() == modification$runtime_release) {
                        writableRecord.setList$runtime_release(removeAll);
                        writableRecord.setModification$runtime_release(writableRecord.getModification$runtime_release() + 1);
                        z = true;
                    }
                }
                SnapshotKt.notifyWrite(current, this);
            }
        } while (!z);
        return true;
    }

    public T removeAt(int i) {
        int modification$runtime_release;
        PersistentList list$runtime_release;
        Snapshot current;
        boolean z;
        T t = get(i);
        do {
            synchronized (SnapshotStateListKt.access$getSync$p()) {
                StateListStateRecord firstStateRecord = getFirstStateRecord();
                Intrinsics.checkNotNull(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
                StateListStateRecord current2 = SnapshotKt.current(firstStateRecord);
                modification$runtime_release = current2.getModification$runtime_release();
                list$runtime_release = current2.getList$runtime_release();
                Unit unit = Unit.INSTANCE;
            }
            Intrinsics.checkNotNull(list$runtime_release);
            PersistentList removeAt = list$runtime_release.removeAt(i);
            if (Intrinsics.areEqual(removeAt, list$runtime_release)) {
                break;
            }
            synchronized (SnapshotStateListKt.access$getSync$p()) {
                StateListStateRecord firstStateRecord2 = getFirstStateRecord();
                Intrinsics.checkNotNull(firstStateRecord2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
                StateListStateRecord stateListStateRecord = firstStateRecord2;
                SnapshotKt.getSnapshotInitializer();
                synchronized (SnapshotKt.getLock()) {
                    current = Snapshot.Companion.getCurrent();
                    StateListStateRecord writableRecord = SnapshotKt.writableRecord(stateListStateRecord, this, current);
                    z = true;
                    if (writableRecord.getModification$runtime_release() == modification$runtime_release) {
                        writableRecord.setList$runtime_release(removeAt);
                        writableRecord.setModification$runtime_release(writableRecord.getModification$runtime_release() + 1);
                    } else {
                        z = false;
                    }
                }
                SnapshotKt.notifyWrite(current, this);
            }
        } while (!z);
        return t;
    }

    public final void removeRange(int i, int i2) {
        int modification$runtime_release;
        PersistentList list$runtime_release;
        Snapshot current;
        boolean z;
        do {
            synchronized (SnapshotStateListKt.access$getSync$p()) {
                StateListStateRecord firstStateRecord = getFirstStateRecord();
                Intrinsics.checkNotNull(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
                StateListStateRecord current2 = SnapshotKt.current(firstStateRecord);
                modification$runtime_release = current2.getModification$runtime_release();
                list$runtime_release = current2.getList$runtime_release();
                Unit unit = Unit.INSTANCE;
            }
            Intrinsics.checkNotNull(list$runtime_release);
            PersistentList.Builder builder = list$runtime_release.builder();
            builder.subList(i, i2).clear();
            PersistentList build = builder.build();
            if (Intrinsics.areEqual(build, list$runtime_release)) {
                return;
            }
            synchronized (SnapshotStateListKt.access$getSync$p()) {
                StateListStateRecord firstStateRecord2 = getFirstStateRecord();
                Intrinsics.checkNotNull(firstStateRecord2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
                StateListStateRecord stateListStateRecord = firstStateRecord2;
                SnapshotKt.getSnapshotInitializer();
                synchronized (SnapshotKt.getLock()) {
                    current = Snapshot.Companion.getCurrent();
                    StateListStateRecord writableRecord = SnapshotKt.writableRecord(stateListStateRecord, this, current);
                    z = true;
                    if (writableRecord.getModification$runtime_release() == modification$runtime_release) {
                        writableRecord.setList$runtime_release(build);
                        writableRecord.setModification$runtime_release(writableRecord.getModification$runtime_release() + 1);
                    } else {
                        z = false;
                    }
                }
                SnapshotKt.notifyWrite(current, this);
            }
        } while (!z);
    }

    @Override // java.util.List, java.util.Collection
    public boolean retainAll(@NotNull final Collection<? extends Object> collection) {
        Intrinsics.checkNotNullParameter(collection, "elements");
        return mutateBoolean(new Function1<List<T>, Boolean>() { // from class: androidx.compose.runtime.snapshots.SnapshotStateList$retainAll$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @NotNull
            public final Boolean invoke(@NotNull List<T> list) {
                Intrinsics.checkNotNullParameter(list, "it");
                return Boolean.valueOf(list.retainAll(collection));
            }
        });
    }

    public final int retainAllInRange$runtime_release(@NotNull Collection<? extends T> collection, int i, int i2) {
        int modification$runtime_release;
        PersistentList list$runtime_release;
        Snapshot current;
        boolean z;
        Intrinsics.checkNotNullParameter(collection, "elements");
        int size = size();
        do {
            synchronized (SnapshotStateListKt.access$getSync$p()) {
                StateListStateRecord firstStateRecord = getFirstStateRecord();
                Intrinsics.checkNotNull(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
                StateListStateRecord current2 = SnapshotKt.current(firstStateRecord);
                modification$runtime_release = current2.getModification$runtime_release();
                list$runtime_release = current2.getList$runtime_release();
                Unit unit = Unit.INSTANCE;
            }
            Intrinsics.checkNotNull(list$runtime_release);
            PersistentList.Builder builder = list$runtime_release.builder();
            builder.subList(i, i2).retainAll(collection);
            PersistentList build = builder.build();
            if (Intrinsics.areEqual(build, list$runtime_release)) {
                break;
            }
            synchronized (SnapshotStateListKt.access$getSync$p()) {
                StateListStateRecord firstStateRecord2 = getFirstStateRecord();
                Intrinsics.checkNotNull(firstStateRecord2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
                StateListStateRecord stateListStateRecord = firstStateRecord2;
                SnapshotKt.getSnapshotInitializer();
                synchronized (SnapshotKt.getLock()) {
                    current = Snapshot.Companion.getCurrent();
                    StateListStateRecord writableRecord = SnapshotKt.writableRecord(stateListStateRecord, this, current);
                    z = true;
                    if (writableRecord.getModification$runtime_release() == modification$runtime_release) {
                        writableRecord.setList$runtime_release(build);
                        writableRecord.setModification$runtime_release(writableRecord.getModification$runtime_release() + 1);
                    } else {
                        z = false;
                    }
                }
                SnapshotKt.notifyWrite(current, this);
            }
        } while (!z);
        return size - size();
    }

    @Override // java.util.List
    public T set(int i, T t) {
        int modification$runtime_release;
        PersistentList list$runtime_release;
        Snapshot current;
        boolean z;
        T t2 = get(i);
        do {
            synchronized (SnapshotStateListKt.access$getSync$p()) {
                StateListStateRecord firstStateRecord = getFirstStateRecord();
                Intrinsics.checkNotNull(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
                StateListStateRecord current2 = SnapshotKt.current(firstStateRecord);
                modification$runtime_release = current2.getModification$runtime_release();
                list$runtime_release = current2.getList$runtime_release();
                Unit unit = Unit.INSTANCE;
            }
            Intrinsics.checkNotNull(list$runtime_release);
            PersistentList persistentList = list$runtime_release.set(i, t);
            if (Intrinsics.areEqual(persistentList, list$runtime_release)) {
                break;
            }
            synchronized (SnapshotStateListKt.access$getSync$p()) {
                StateListStateRecord firstStateRecord2 = getFirstStateRecord();
                Intrinsics.checkNotNull(firstStateRecord2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
                StateListStateRecord stateListStateRecord = firstStateRecord2;
                SnapshotKt.getSnapshotInitializer();
                synchronized (SnapshotKt.getLock()) {
                    current = Snapshot.Companion.getCurrent();
                    StateListStateRecord writableRecord = SnapshotKt.writableRecord(stateListStateRecord, this, current);
                    z = true;
                    if (writableRecord.getModification$runtime_release() == modification$runtime_release) {
                        writableRecord.setList$runtime_release(persistentList);
                        writableRecord.setModification$runtime_release(writableRecord.getModification$runtime_release() + 1);
                    } else {
                        z = false;
                    }
                }
                SnapshotKt.notifyWrite(current, this);
            }
        } while (!z);
        return t2;
    }

    @Override // java.util.List, java.util.Collection
    public final /* bridge */ int size() {
        return getSize();
    }

    @Override // java.util.List
    @NotNull
    public List<T> subList(int i, int i2) {
        if ((i >= 0 && i <= i2) && i2 <= size()) {
            return new SubList(this, i, i2);
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    @Override // java.util.List, java.util.Collection
    public Object[] toArray() {
        return CollectionToArray.toArray(this);
    }

    @Override // java.util.List, java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "array");
        return (T[]) CollectionToArray.toArray(this, tArr);
    }

    @NotNull
    public final List<T> toList() {
        return (List<T>) getReadable$runtime_release().getList$runtime_release();
    }

    @Override // java.util.List, java.util.Collection
    public boolean addAll(@NotNull Collection<? extends T> collection) {
        int modification$runtime_release;
        PersistentList list$runtime_release;
        boolean z;
        Snapshot current;
        Intrinsics.checkNotNullParameter(collection, "elements");
        do {
            synchronized (SnapshotStateListKt.access$getSync$p()) {
                StateListStateRecord firstStateRecord = getFirstStateRecord();
                Intrinsics.checkNotNull(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
                StateListStateRecord current2 = SnapshotKt.current(firstStateRecord);
                modification$runtime_release = current2.getModification$runtime_release();
                list$runtime_release = current2.getList$runtime_release();
                Unit unit = Unit.INSTANCE;
            }
            Intrinsics.checkNotNull(list$runtime_release);
            PersistentList addAll = list$runtime_release.addAll((Collection) collection);
            z = false;
            if (Intrinsics.areEqual(addAll, list$runtime_release)) {
                return false;
            }
            synchronized (SnapshotStateListKt.access$getSync$p()) {
                StateListStateRecord firstStateRecord2 = getFirstStateRecord();
                Intrinsics.checkNotNull(firstStateRecord2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
                StateListStateRecord stateListStateRecord = firstStateRecord2;
                SnapshotKt.getSnapshotInitializer();
                synchronized (SnapshotKt.getLock()) {
                    current = Snapshot.Companion.getCurrent();
                    StateListStateRecord writableRecord = SnapshotKt.writableRecord(stateListStateRecord, this, current);
                    if (writableRecord.getModification$runtime_release() == modification$runtime_release) {
                        writableRecord.setList$runtime_release(addAll);
                        writableRecord.setModification$runtime_release(writableRecord.getModification$runtime_release() + 1);
                        z = true;
                    }
                }
                SnapshotKt.notifyWrite(current, this);
            }
        } while (!z);
        return true;
    }

    @Override // java.util.List
    @NotNull
    public ListIterator<T> listIterator(int i) {
        return new StateListIterator(this, i);
    }

    @Override // java.util.List, java.util.Collection
    public boolean remove(Object obj) {
        int modification$runtime_release;
        PersistentList list$runtime_release;
        boolean z;
        Snapshot current;
        do {
            synchronized (SnapshotStateListKt.access$getSync$p()) {
                StateListStateRecord firstStateRecord = getFirstStateRecord();
                Intrinsics.checkNotNull(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
                StateListStateRecord current2 = SnapshotKt.current(firstStateRecord);
                modification$runtime_release = current2.getModification$runtime_release();
                list$runtime_release = current2.getList$runtime_release();
                Unit unit = Unit.INSTANCE;
            }
            Intrinsics.checkNotNull(list$runtime_release);
            PersistentList remove = list$runtime_release.remove((PersistentList) obj);
            z = false;
            if (Intrinsics.areEqual(remove, list$runtime_release)) {
                return false;
            }
            synchronized (SnapshotStateListKt.access$getSync$p()) {
                StateListStateRecord firstStateRecord2 = getFirstStateRecord();
                Intrinsics.checkNotNull(firstStateRecord2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
                StateListStateRecord stateListStateRecord = firstStateRecord2;
                SnapshotKt.getSnapshotInitializer();
                synchronized (SnapshotKt.getLock()) {
                    current = Snapshot.Companion.getCurrent();
                    StateListStateRecord writableRecord = SnapshotKt.writableRecord(stateListStateRecord, this, current);
                    if (writableRecord.getModification$runtime_release() == modification$runtime_release) {
                        writableRecord.setList$runtime_release(remove);
                        writableRecord.setModification$runtime_release(writableRecord.getModification$runtime_release() + 1);
                        z = true;
                    }
                }
                SnapshotKt.notifyWrite(current, this);
            }
        } while (!z);
        return true;
    }

    @Override // java.util.List
    public void add(int i, T t) {
        int modification$runtime_release;
        PersistentList list$runtime_release;
        Snapshot current;
        boolean z;
        do {
            synchronized (SnapshotStateListKt.access$getSync$p()) {
                StateListStateRecord firstStateRecord = getFirstStateRecord();
                Intrinsics.checkNotNull(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
                StateListStateRecord current2 = SnapshotKt.current(firstStateRecord);
                modification$runtime_release = current2.getModification$runtime_release();
                list$runtime_release = current2.getList$runtime_release();
                Unit unit = Unit.INSTANCE;
            }
            Intrinsics.checkNotNull(list$runtime_release);
            PersistentList add = list$runtime_release.add(i, t);
            if (Intrinsics.areEqual(add, list$runtime_release)) {
                return;
            }
            synchronized (SnapshotStateListKt.access$getSync$p()) {
                StateListStateRecord firstStateRecord2 = getFirstStateRecord();
                Intrinsics.checkNotNull(firstStateRecord2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
                StateListStateRecord stateListStateRecord = firstStateRecord2;
                SnapshotKt.getSnapshotInitializer();
                synchronized (SnapshotKt.getLock()) {
                    current = Snapshot.Companion.getCurrent();
                    StateListStateRecord writableRecord = SnapshotKt.writableRecord(stateListStateRecord, this, current);
                    z = true;
                    if (writableRecord.getModification$runtime_release() == modification$runtime_release) {
                        writableRecord.setList$runtime_release(add);
                        writableRecord.setModification$runtime_release(writableRecord.getModification$runtime_release() + 1);
                    } else {
                        z = false;
                    }
                }
                SnapshotKt.notifyWrite(current, this);
            }
        } while (!z);
    }
}
