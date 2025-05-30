package androidx.compose.runtime;

import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.runtime.snapshots.SnapshotKt;
import androidx.compose.runtime.snapshots.SnapshotMutableState;
import androidx.compose.runtime.snapshots.StateObject;
import androidx.compose.runtime.snapshots.StateRecord;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public class SnapshotMutableStateImpl<T> implements StateObject, SnapshotMutableState<T> {

    @NotNull
    private StateStateRecord<T> next;

    @NotNull
    private final SnapshotMutationPolicy<T> policy;

    /* compiled from: Taobao */
    private static final class StateStateRecord<T> extends StateRecord {
        private T value;

        public StateStateRecord(T t) {
            this.value = t;
        }

        public void assign(@NotNull StateRecord stateRecord) {
            Intrinsics.checkNotNullParameter(stateRecord, "value");
            this.value = ((StateStateRecord) stateRecord).value;
        }

        @NotNull
        public StateRecord create() {
            return new StateStateRecord(this.value);
        }

        public final T getValue() {
            return this.value;
        }

        public final void setValue(T t) {
            this.value = t;
        }
    }

    public SnapshotMutableStateImpl(T t, @NotNull SnapshotMutationPolicy<T> snapshotMutationPolicy) {
        Intrinsics.checkNotNullParameter(snapshotMutationPolicy, "policy");
        this.policy = snapshotMutationPolicy;
        this.next = new StateStateRecord<>(t);
    }

    public static /* synthetic */ void getDebuggerDisplayValue$annotations() {
    }

    public static /* synthetic */ void getValue$annotations() {
    }

    public T component1() {
        return getValue();
    }

    @NotNull
    public Function1<T, Unit> component2() {
        return new component2.1(this);
    }

    @JvmName(name = "getDebuggerDisplayValue")
    public final T getDebuggerDisplayValue() {
        return (T) ((StateStateRecord) SnapshotKt.current(this.next)).getValue();
    }

    @Override // androidx.compose.runtime.snapshots.StateObject
    @NotNull
    public StateRecord getFirstStateRecord() {
        return this.next;
    }

    @NotNull
    public SnapshotMutationPolicy<T> getPolicy() {
        return this.policy;
    }

    public T getValue() {
        return (T) ((StateStateRecord) SnapshotKt.readable(this.next, this)).getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.compose.runtime.snapshots.StateObject
    @Nullable
    public StateRecord mergeRecords(@NotNull StateRecord stateRecord, @NotNull StateRecord stateRecord2, @NotNull StateRecord stateRecord3) {
        Intrinsics.checkNotNullParameter(stateRecord, "previous");
        Intrinsics.checkNotNullParameter(stateRecord2, "current");
        Intrinsics.checkNotNullParameter(stateRecord3, "applied");
        StateStateRecord stateStateRecord = (StateStateRecord) stateRecord;
        StateStateRecord stateStateRecord2 = (StateStateRecord) stateRecord2;
        StateStateRecord stateStateRecord3 = (StateStateRecord) stateRecord3;
        if (getPolicy().equivalent(stateStateRecord2.getValue(), stateStateRecord3.getValue())) {
            return stateRecord2;
        }
        Object merge = getPolicy().merge(stateStateRecord.getValue(), stateStateRecord2.getValue(), stateStateRecord3.getValue());
        if (merge == null) {
            return null;
        }
        StateRecord create = stateStateRecord3.create();
        Intrinsics.checkNotNull(create, "null cannot be cast to non-null type androidx.compose.runtime.SnapshotMutableStateImpl.StateStateRecord<T of androidx.compose.runtime.SnapshotMutableStateImpl.mergeRecords$lambda$2>");
        ((StateStateRecord) create).setValue(merge);
        return create;
    }

    @Override // androidx.compose.runtime.snapshots.StateObject
    public void prependStateRecord(@NotNull StateRecord stateRecord) {
        Intrinsics.checkNotNullParameter(stateRecord, "value");
        this.next = (StateStateRecord) stateRecord;
    }

    public void setValue(T t) {
        Snapshot current;
        StateStateRecord stateStateRecord = (StateStateRecord) SnapshotKt.current(this.next);
        if (getPolicy().equivalent(stateStateRecord.getValue(), t)) {
            return;
        }
        StateStateRecord<T> stateStateRecord2 = this.next;
        SnapshotKt.getSnapshotInitializer();
        synchronized (SnapshotKt.getLock()) {
            current = Snapshot.Companion.getCurrent();
            ((StateStateRecord) SnapshotKt.overwritableRecord(stateStateRecord2, this, current, stateStateRecord)).setValue(t);
            Unit unit = Unit.INSTANCE;
        }
        SnapshotKt.notifyWrite(current, this);
    }

    @NotNull
    public String toString() {
        return "MutableState(value=" + ((StateStateRecord) SnapshotKt.current(this.next)).getValue() + ")@" + hashCode();
    }
}
