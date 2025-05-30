package androidx.compose.runtime;

import androidx.compose.runtime.collection.IdentityArrayMap;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.runtime.snapshots.SnapshotKt;
import androidx.compose.runtime.snapshots.StateObject;
import androidx.compose.runtime.snapshots.StateRecord;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k65;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
final class DerivedSnapshotState<T> implements StateObject, DerivedState<T> {

    @NotNull
    private final Function0<T> calculation;

    @NotNull
    private ResultRecord<T> first;

    @Nullable
    private final SnapshotMutationPolicy<T> policy;

    /* compiled from: Taobao */
    @StabilityInferred(parameters = 0)
    public static final class ResultRecord<T> extends StateRecord {

        @Nullable
        private IdentityArrayMap<StateObject, Integer> dependencies;

        @Nullable
        private Object result = Unset;
        private int resultHash;

        @NotNull
        public static final Companion Companion = new Companion(null);
        public static final int $stable = 8;

        @NotNull
        private static final Object Unset = new Object();

        /* compiled from: Taobao */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            @NotNull
            public final Object getUnset() {
                return ResultRecord.Unset;
            }
        }

        @Override // androidx.compose.runtime.snapshots.StateRecord
        public void assign(@NotNull StateRecord stateRecord) {
            Intrinsics.checkNotNullParameter(stateRecord, "value");
            ResultRecord resultRecord = (ResultRecord) stateRecord;
            this.dependencies = resultRecord.dependencies;
            this.result = resultRecord.result;
            this.resultHash = resultRecord.resultHash;
        }

        @Override // androidx.compose.runtime.snapshots.StateRecord
        @NotNull
        public StateRecord create() {
            return new ResultRecord();
        }

        @Nullable
        public final IdentityArrayMap<StateObject, Integer> getDependencies() {
            return this.dependencies;
        }

        @Nullable
        public final Object getResult() {
            return this.result;
        }

        public final int getResultHash() {
            return this.resultHash;
        }

        public final boolean isValid(@NotNull DerivedState<?> derivedState, @NotNull Snapshot snapshot) {
            Intrinsics.checkNotNullParameter(derivedState, "derivedState");
            Intrinsics.checkNotNullParameter(snapshot, "snapshot");
            return this.result != Unset && this.resultHash == readableHash(derivedState, snapshot);
        }

        public final int readableHash(@NotNull DerivedState<?> derivedState, @NotNull Snapshot snapshot) {
            IdentityArrayMap<StateObject, Integer> identityArrayMap;
            Intrinsics.checkNotNullParameter(derivedState, "derivedState");
            Intrinsics.checkNotNullParameter(snapshot, "snapshot");
            synchronized (SnapshotKt.getLock()) {
                identityArrayMap = this.dependencies;
            }
            int i = 7;
            if (identityArrayMap != null) {
                MutableVector mutableVector = (MutableVector) SnapshotStateKt__DerivedStateKt.derivedStateObservers.get();
                int i2 = 0;
                if (mutableVector == null) {
                    mutableVector = new MutableVector(new Pair[0], 0);
                }
                int size = mutableVector.getSize();
                if (size > 0) {
                    Object[] content = mutableVector.getContent();
                    int i3 = 0;
                    do {
                        ((Function1) ((Pair) content[i3]).component1()).invoke(derivedState);
                        i3++;
                    } while (i3 < size);
                }
                try {
                    int size$runtime_release = identityArrayMap.getSize$runtime_release();
                    for (int i4 = 0; i4 < size$runtime_release; i4++) {
                        Object obj = identityArrayMap.getKeys$runtime_release()[i4];
                        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type Key of androidx.compose.runtime.collection.IdentityArrayMap");
                        StateObject stateObject = (StateObject) obj;
                        if (((Number) identityArrayMap.getValues$runtime_release()[i4]).intValue() == 1) {
                            StateRecord current = stateObject instanceof DerivedSnapshotState ? ((DerivedSnapshotState) stateObject).current(snapshot) : SnapshotKt.current(stateObject.getFirstStateRecord(), snapshot);
                            i = (((i * 31) + ActualJvm_jvmKt.identityHashCode(current)) * 31) + current.getSnapshotId$runtime_release();
                        }
                    }
                    Unit unit = Unit.INSTANCE;
                    int size2 = mutableVector.getSize();
                    if (size2 > 0) {
                        Object[] content2 = mutableVector.getContent();
                        do {
                            ((Function1) ((Pair) content2[i2]).component2()).invoke(derivedState);
                            i2++;
                        } while (i2 < size2);
                    }
                } catch (Throwable th) {
                    int size3 = mutableVector.getSize();
                    if (size3 > 0) {
                        Object[] content3 = mutableVector.getContent();
                        do {
                            ((Function1) ((Pair) content3[i2]).component2()).invoke(derivedState);
                            i2++;
                        } while (i2 < size3);
                    }
                    throw th;
                }
            }
            return i;
        }

        public final void setDependencies(@Nullable IdentityArrayMap<StateObject, Integer> identityArrayMap) {
            this.dependencies = identityArrayMap;
        }

        public final void setResult(@Nullable Object obj) {
            this.result = obj;
        }

        public final void setResultHash(int i) {
            this.resultHash = i;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public DerivedSnapshotState(@NotNull Function0<? extends T> function0, @Nullable SnapshotMutationPolicy<T> snapshotMutationPolicy) {
        Intrinsics.checkNotNullParameter(function0, "calculation");
        this.calculation = function0;
        this.policy = snapshotMutationPolicy;
        this.first = new ResultRecord<>();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final ResultRecord<T> currentRecord(ResultRecord<T> resultRecord, Snapshot snapshot, boolean z, Function0<? extends T> function0) {
        SnapshotThreadLocal snapshotThreadLocal;
        SnapshotThreadLocal snapshotThreadLocal2;
        SnapshotThreadLocal snapshotThreadLocal3;
        Snapshot.Companion companion;
        SnapshotThreadLocal snapshotThreadLocal4;
        SnapshotThreadLocal snapshotThreadLocal5;
        SnapshotThreadLocal snapshotThreadLocal6;
        int i = 1;
        int i2 = 0;
        if (resultRecord.isValid(this, snapshot)) {
            if (z) {
                MutableVector mutableVector = (MutableVector) SnapshotStateKt__DerivedStateKt.derivedStateObservers.get();
                if (mutableVector == null) {
                    mutableVector = new MutableVector(new Pair[0], 0);
                }
                int size = mutableVector.getSize();
                if (size > 0) {
                    Object[] content = mutableVector.getContent();
                    int i3 = 0;
                    do {
                        ((Function1) ((Pair) content[i3]).component1()).invoke(this);
                        i3++;
                    } while (i3 < size);
                }
                try {
                    IdentityArrayMap<StateObject, Integer> dependencies = resultRecord.getDependencies();
                    snapshotThreadLocal4 = SnapshotStateKt__DerivedStateKt.calculationBlockNestedLevel;
                    Integer num = (Integer) snapshotThreadLocal4.get();
                    int intValue = num != null ? num.intValue() : 0;
                    if (dependencies != null) {
                        int size$runtime_release = dependencies.getSize$runtime_release();
                        for (int i4 = 0; i4 < size$runtime_release; i4++) {
                            Object obj = dependencies.getKeys$runtime_release()[i4];
                            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type Key of androidx.compose.runtime.collection.IdentityArrayMap");
                            int intValue2 = ((Number) dependencies.getValues$runtime_release()[i4]).intValue();
                            StateObject stateObject = (StateObject) obj;
                            snapshotThreadLocal6 = SnapshotStateKt__DerivedStateKt.calculationBlockNestedLevel;
                            snapshotThreadLocal6.set(Integer.valueOf(intValue2 + intValue));
                            Function1<Object, Unit> readObserver$runtime_release = snapshot.getReadObserver$runtime_release();
                            if (readObserver$runtime_release != null) {
                                readObserver$runtime_release.invoke(stateObject);
                            }
                        }
                    }
                    snapshotThreadLocal5 = SnapshotStateKt__DerivedStateKt.calculationBlockNestedLevel;
                    snapshotThreadLocal5.set(Integer.valueOf(intValue));
                    Unit unit = Unit.INSTANCE;
                    int size2 = mutableVector.getSize();
                    if (size2 > 0) {
                        Object[] content2 = mutableVector.getContent();
                        do {
                            ((Function1) ((Pair) content2[i2]).component2()).invoke(this);
                            i2++;
                        } while (i2 < size2);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return resultRecord;
        }
        snapshotThreadLocal = SnapshotStateKt__DerivedStateKt.calculationBlockNestedLevel;
        Integer num2 = (Integer) snapshotThreadLocal.get();
        int intValue3 = num2 != null ? num2.intValue() : 0;
        IdentityArrayMap<StateObject, Integer> identityArrayMap = new IdentityArrayMap<>(0, 1, null);
        MutableVector mutableVector2 = (MutableVector) SnapshotStateKt__DerivedStateKt.derivedStateObservers.get();
        if (mutableVector2 == null) {
            mutableVector2 = new MutableVector(new Pair[0], 0);
        }
        int size3 = mutableVector2.getSize();
        if (size3 > 0) {
            Object[] content3 = mutableVector2.getContent();
            int i5 = 0;
            do {
                ((Function1) ((Pair) content3[i5]).component1()).invoke(this);
                i5++;
            } while (i5 < size3);
        }
        try {
            snapshotThreadLocal2 = SnapshotStateKt__DerivedStateKt.calculationBlockNestedLevel;
            snapshotThreadLocal2.set(Integer.valueOf(intValue3 + 1));
            Object observe = Snapshot.Companion.observe(new currentRecord.result.1.result.1(this, identityArrayMap, intValue3), (Function1) null, function0);
            snapshotThreadLocal3 = SnapshotStateKt__DerivedStateKt.calculationBlockNestedLevel;
            snapshotThreadLocal3.set(Integer.valueOf(intValue3));
            int size4 = mutableVector2.getSize();
            if (size4 > 0) {
                Object[] content4 = mutableVector2.getContent();
                int i6 = 0;
                do {
                    ((Function1) ((Pair) content4[i6]).component2()).invoke(this);
                    i6++;
                } while (i6 < size4);
            }
            synchronized (SnapshotKt.getLock()) {
                companion = Snapshot.Companion;
                Snapshot current = companion.getCurrent();
                if (resultRecord.getResult() != ResultRecord.Companion.getUnset()) {
                    SnapshotMutationPolicy<T> policy = getPolicy();
                    if (policy == 0 || !policy.equivalent(observe, resultRecord.getResult())) {
                        i = 0;
                    }
                    if (i != 0) {
                        resultRecord.setDependencies(identityArrayMap);
                        resultRecord.setResultHash(resultRecord.readableHash(this, current));
                    }
                }
                resultRecord = (ResultRecord) SnapshotKt.newWritableRecord(this.first, this, current);
                resultRecord.setDependencies(identityArrayMap);
                resultRecord.setResultHash(resultRecord.readableHash(this, current));
                resultRecord.setResult(observe);
            }
            if (intValue3 == 0) {
                companion.notifyObjectsInitialized();
            }
            return resultRecord;
        } finally {
            int size5 = mutableVector2.getSize();
            if (size5 > 0) {
                Object[] content5 = mutableVector2.getContent();
                do {
                    ((Function1) ((Pair) content5[i2]).component2()).invoke(this);
                    i2++;
                } while (i2 < size5);
            }
        }
    }

    private final String displayValue() {
        ResultRecord resultRecord = (ResultRecord) SnapshotKt.current(this.first);
        return resultRecord.isValid(this, Snapshot.Companion.getCurrent()) ? String.valueOf(resultRecord.getResult()) : "<Not calculated>";
    }

    public static /* synthetic */ void getDebuggerDisplayValue$annotations() {
    }

    @NotNull
    public final StateRecord current(@NotNull Snapshot snapshot) {
        Intrinsics.checkNotNullParameter(snapshot, "snapshot");
        return currentRecord((ResultRecord) SnapshotKt.current(this.first, snapshot), snapshot, false, this.calculation);
    }

    public T getCurrentValue() {
        return (T) currentRecord((ResultRecord) SnapshotKt.current(this.first), Snapshot.Companion.getCurrent(), false, this.calculation).getResult();
    }

    @JvmName(name = "getDebuggerDisplayValue")
    @Nullable
    public final T getDebuggerDisplayValue() {
        ResultRecord resultRecord = (ResultRecord) SnapshotKt.current(this.first);
        if (resultRecord.isValid(this, Snapshot.Companion.getCurrent())) {
            return (T) resultRecord.getResult();
        }
        return null;
    }

    @NotNull
    public Object[] getDependencies() {
        Object[] keys$runtime_release;
        IdentityArrayMap<StateObject, Integer> dependencies = currentRecord((ResultRecord) SnapshotKt.current(this.first), Snapshot.Companion.getCurrent(), false, this.calculation).getDependencies();
        return (dependencies == null || (keys$runtime_release = dependencies.getKeys$runtime_release()) == null) ? new Object[0] : keys$runtime_release;
    }

    @NotNull
    public StateRecord getFirstStateRecord() {
        return this.first;
    }

    @Nullable
    public SnapshotMutationPolicy<T> getPolicy() {
        return this.policy;
    }

    public T getValue() {
        Snapshot.Companion companion = Snapshot.Companion;
        Function1<Object, Unit> readObserver$runtime_release = companion.getCurrent().getReadObserver$runtime_release();
        if (readObserver$runtime_release != null) {
            readObserver$runtime_release.invoke(this);
        }
        return (T) currentRecord((ResultRecord) SnapshotKt.current(this.first), companion.getCurrent(), true, this.calculation).getResult();
    }

    public /* synthetic */ StateRecord mergeRecords(StateRecord stateRecord, StateRecord stateRecord2, StateRecord stateRecord3) {
        return k65.a(this, stateRecord, stateRecord2, stateRecord3);
    }

    public void prependStateRecord(@NotNull StateRecord stateRecord) {
        Intrinsics.checkNotNullParameter(stateRecord, "value");
        this.first = (ResultRecord) stateRecord;
    }

    @NotNull
    public String toString() {
        return "DerivedState(value=" + displayValue() + ")@" + hashCode();
    }
}
