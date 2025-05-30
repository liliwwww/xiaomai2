package androidx.compose.runtime.snapshots;

import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.KotlinNothingValueException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class TransparentObserverMutableSnapshot extends MutableSnapshot {
    private final boolean mergeParentObservers;
    private final boolean ownsPreviousSnapshot;

    @Nullable
    private final MutableSnapshot previousSnapshot;

    @Nullable
    private final Function1<Object, Unit> specifiedReadObserver;

    @Nullable
    private final Function1<Object, Unit> specifiedWriteObserver;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public TransparentObserverMutableSnapshot(@org.jetbrains.annotations.Nullable androidx.compose.runtime.snapshots.MutableSnapshot r5, @org.jetbrains.annotations.Nullable kotlin.jvm.functions.Function1<java.lang.Object, kotlin.Unit> r6, @org.jetbrains.annotations.Nullable kotlin.jvm.functions.Function1<java.lang.Object, kotlin.Unit> r7, boolean r8, boolean r9) {
        /*
            r4 = this;
            androidx.compose.runtime.snapshots.SnapshotIdSet$Companion r0 = androidx.compose.runtime.snapshots.SnapshotIdSet.Companion
            androidx.compose.runtime.snapshots.SnapshotIdSet r0 = r0.getEMPTY()
            if (r5 == 0) goto Le
            kotlin.jvm.functions.Function1 r1 = r5.getReadObserver$runtime_release()
            if (r1 != 0) goto L1c
        Le:
            java.util.concurrent.atomic.AtomicReference r1 = androidx.compose.runtime.snapshots.SnapshotKt.access$getCurrentGlobalSnapshot$p()
            java.lang.Object r1 = r1.get()
            androidx.compose.runtime.snapshots.GlobalSnapshot r1 = (androidx.compose.runtime.snapshots.GlobalSnapshot) r1
            kotlin.jvm.functions.Function1 r1 = r1.getReadObserver$runtime_release()
        L1c:
            kotlin.jvm.functions.Function1 r1 = androidx.compose.runtime.snapshots.SnapshotKt.access$mergedReadObserver(r6, r1, r8)
            if (r5 == 0) goto L28
            kotlin.jvm.functions.Function1 r2 = r5.getWriteObserver$runtime_release()
            if (r2 != 0) goto L36
        L28:
            java.util.concurrent.atomic.AtomicReference r2 = androidx.compose.runtime.snapshots.SnapshotKt.access$getCurrentGlobalSnapshot$p()
            java.lang.Object r2 = r2.get()
            androidx.compose.runtime.snapshots.GlobalSnapshot r2 = (androidx.compose.runtime.snapshots.GlobalSnapshot) r2
            kotlin.jvm.functions.Function1 r2 = r2.getWriteObserver$runtime_release()
        L36:
            kotlin.jvm.functions.Function1 r2 = androidx.compose.runtime.snapshots.SnapshotKt.access$mergedWriteObserver(r7, r2)
            r3 = 0
            r4.<init>(r3, r0, r1, r2)
            r4.previousSnapshot = r5
            r4.specifiedReadObserver = r6
            r4.specifiedWriteObserver = r7
            r4.mergeParentObservers = r8
            r4.ownsPreviousSnapshot = r9
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.snapshots.TransparentObserverMutableSnapshot.<init>(androidx.compose.runtime.snapshots.MutableSnapshot, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, boolean, boolean):void");
    }

    private final MutableSnapshot getCurrentSnapshot() {
        AtomicReference atomicReference;
        MutableSnapshot mutableSnapshot = this.previousSnapshot;
        if (mutableSnapshot != null) {
            return mutableSnapshot;
        }
        atomicReference = SnapshotKt.currentGlobalSnapshot;
        Object obj = atomicReference.get();
        Intrinsics.checkNotNullExpressionValue(obj, "currentGlobalSnapshot.get()");
        return (MutableSnapshot) obj;
    }

    @NotNull
    public SnapshotApplyResult apply() {
        return getCurrentSnapshot().apply();
    }

    public void dispose() {
        MutableSnapshot mutableSnapshot;
        setDisposed$runtime_release(true);
        if (!this.ownsPreviousSnapshot || (mutableSnapshot = this.previousSnapshot) == null) {
            return;
        }
        mutableSnapshot.dispose();
    }

    public int getId() {
        return getCurrentSnapshot().getId();
    }

    @NotNull
    public SnapshotIdSet getInvalid$runtime_release() {
        return getCurrentSnapshot().getInvalid$runtime_release();
    }

    @Nullable
    public Set<StateObject> getModified$runtime_release() {
        return getCurrentSnapshot().getModified$runtime_release();
    }

    public boolean getReadOnly() {
        return getCurrentSnapshot().getReadOnly();
    }

    @Nullable
    public final Function1<Object, Unit> getSpecifiedReadObserver$runtime_release() {
        return this.specifiedReadObserver;
    }

    @Nullable
    public final Function1<Object, Unit> getSpecifiedWriteObserver$runtime_release() {
        return this.specifiedWriteObserver;
    }

    public boolean hasPendingChanges() {
        return getCurrentSnapshot().hasPendingChanges();
    }

    public void notifyObjectsInitialized$runtime_release() {
        getCurrentSnapshot().notifyObjectsInitialized$runtime_release();
    }

    public void recordModified$runtime_release(@NotNull StateObject stateObject) {
        Intrinsics.checkNotNullParameter(stateObject, "state");
        getCurrentSnapshot().recordModified$runtime_release(stateObject);
    }

    public void setId$runtime_release(int i) {
        SnapshotStateMapKt.unsupported();
        throw new KotlinNothingValueException();
    }

    public void setInvalid$runtime_release(@NotNull SnapshotIdSet snapshotIdSet) {
        Intrinsics.checkNotNullParameter(snapshotIdSet, "value");
        SnapshotStateMapKt.unsupported();
        throw new KotlinNothingValueException();
    }

    public void setModified(@Nullable Set<StateObject> set) {
        SnapshotStateMapKt.unsupported();
        throw new KotlinNothingValueException();
    }

    @NotNull
    public MutableSnapshot takeNestedMutableSnapshot(@Nullable Function1<Object, Unit> function1, @Nullable Function1<Object, Unit> function12) {
        Function1 mergedWriteObserver;
        Function1 mergedReadObserver$default = SnapshotKt.mergedReadObserver$default(function1, getReadObserver$runtime_release(), false, 4, null);
        mergedWriteObserver = SnapshotKt.mergedWriteObserver(function12, getWriteObserver$runtime_release());
        return !this.mergeParentObservers ? new TransparentObserverMutableSnapshot(getCurrentSnapshot().takeNestedMutableSnapshot((Function1) null, mergedWriteObserver), mergedReadObserver$default, mergedWriteObserver, false, true) : getCurrentSnapshot().takeNestedMutableSnapshot(mergedReadObserver$default, mergedWriteObserver);
    }

    @NotNull
    public Snapshot takeNestedSnapshot(@Nullable Function1<Object, Unit> function1) {
        Snapshot createTransparentSnapshotWithNoParentReadObserver;
        Function1 mergedReadObserver$default = SnapshotKt.mergedReadObserver$default(function1, getReadObserver$runtime_release(), false, 4, null);
        if (this.mergeParentObservers) {
            return getCurrentSnapshot().takeNestedSnapshot(mergedReadObserver$default);
        }
        createTransparentSnapshotWithNoParentReadObserver = SnapshotKt.createTransparentSnapshotWithNoParentReadObserver(getCurrentSnapshot().takeNestedSnapshot((Function1) null), mergedReadObserver$default, true);
        return createTransparentSnapshotWithNoParentReadObserver;
    }

    @NotNull
    /* renamed from: nestedActivated$runtime_release, reason: merged with bridge method [inline-methods] */
    public Void m932nestedActivated$runtime_release(@NotNull Snapshot snapshot) {
        Intrinsics.checkNotNullParameter(snapshot, "snapshot");
        SnapshotStateMapKt.unsupported();
        throw new KotlinNothingValueException();
    }

    @NotNull
    /* renamed from: nestedDeactivated$runtime_release, reason: merged with bridge method [inline-methods] */
    public Void m933nestedDeactivated$runtime_release(@NotNull Snapshot snapshot) {
        Intrinsics.checkNotNullParameter(snapshot, "snapshot");
        SnapshotStateMapKt.unsupported();
        throw new KotlinNothingValueException();
    }
}
