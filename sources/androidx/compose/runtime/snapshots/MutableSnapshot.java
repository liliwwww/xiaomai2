package androidx.compose.runtime.snapshots;

import androidx.compose.runtime.internal.StabilityInferred;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@StabilityInferred(parameters = 0)
/* loaded from: classes.dex */
public class MutableSnapshot extends Snapshot {
    public static final int $stable = 8;
    private boolean applied;

    @Nullable
    private Set<StateObject> modified;

    @NotNull
    private SnapshotIdSet previousIds;

    @NotNull
    private int[] previousPinnedSnapshots;

    @Nullable
    private final Function1<Object, Unit> readObserver;
    private int snapshots;

    @Nullable
    private final Function1<Object, Unit> writeObserver;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MutableSnapshot(int i, @NotNull SnapshotIdSet snapshotIdSet, @Nullable Function1<Object, Unit> function1, @Nullable Function1<Object, Unit> function12) {
        super(i, snapshotIdSet, null);
        Intrinsics.checkNotNullParameter(snapshotIdSet, "invalid");
        this.readObserver = function1;
        this.writeObserver = function12;
        this.previousIds = SnapshotIdSet.Companion.getEMPTY();
        this.previousPinnedSnapshots = new int[0];
        this.snapshots = 1;
    }

    private final void abandon() {
        Set<StateObject> modified$runtime_release = getModified$runtime_release();
        if (modified$runtime_release != null) {
            validateNotApplied$runtime_release();
            setModified(null);
            int id = getId();
            Iterator<StateObject> it = modified$runtime_release.iterator();
            while (it.hasNext()) {
                for (StateRecord firstStateRecord = it.next().getFirstStateRecord(); firstStateRecord != null; firstStateRecord = firstStateRecord.getNext$runtime_release()) {
                    if (firstStateRecord.getSnapshotId$runtime_release() == id || CollectionsKt.contains(this.previousIds, Integer.valueOf(firstStateRecord.getSnapshotId$runtime_release()))) {
                        firstStateRecord.setSnapshotId$runtime_release(0);
                    }
                }
            }
        }
        closeAndReleasePinning$runtime_release();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MutableSnapshot takeNestedMutableSnapshot$default(MutableSnapshot mutableSnapshot, Function1 function1, Function1 function12, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: takeNestedMutableSnapshot");
        }
        if ((i & 1) != 0) {
            function1 = null;
        }
        if ((i & 2) != 0) {
            function12 = null;
        }
        return mutableSnapshot.takeNestedMutableSnapshot(function1, function12);
    }

    public final <T> T advance$runtime_release(@NotNull Function0<? extends T> function0) {
        int i;
        SnapshotIdSet snapshotIdSet;
        Intrinsics.checkNotNullParameter(function0, "block");
        recordPrevious$runtime_release(getId());
        T t = (T) function0.invoke();
        if (!getApplied$runtime_release() && !getDisposed$runtime_release()) {
            int id = getId();
            synchronized (SnapshotKt.getLock()) {
                try {
                    i = SnapshotKt.nextSnapshotId;
                    SnapshotKt.nextSnapshotId = i + 1;
                    setId$runtime_release(i);
                    snapshotIdSet = SnapshotKt.openSnapshots;
                    SnapshotKt.openSnapshots = snapshotIdSet.set(getId());
                    Unit unit = Unit.INSTANCE;
                    InlineMarker.finallyStart(1);
                } catch (Throwable th) {
                    InlineMarker.finallyStart(1);
                    InlineMarker.finallyEnd(1);
                    throw th;
                }
            }
            InlineMarker.finallyEnd(1);
            setInvalid$runtime_release(SnapshotKt.addRange(getInvalid$runtime_release(), id + 1, getId()));
        }
        return t;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x00ef A[LOOP:0: B:24:0x00ed->B:25:0x00ef, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x010a A[LOOP:1: B:31:0x0108->B:32:0x010a, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x011b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @org.jetbrains.annotations.NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public androidx.compose.runtime.snapshots.SnapshotApplyResult apply() {
        /*
            Method dump skipped, instructions count: 298
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.snapshots.MutableSnapshot.apply():androidx.compose.runtime.snapshots.SnapshotApplyResult");
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public void closeLocked$runtime_release() {
        SnapshotIdSet snapshotIdSet;
        snapshotIdSet = SnapshotKt.openSnapshots;
        SnapshotKt.openSnapshots = snapshotIdSet.clear(getId()).andNot(this.previousIds);
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public void dispose() {
        if (getDisposed$runtime_release()) {
            return;
        }
        super.dispose();
        mo2439nestedDeactivated$runtime_release(this);
    }

    public final boolean getApplied$runtime_release() {
        return this.applied;
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    @Nullable
    public Set<StateObject> getModified$runtime_release() {
        return this.modified;
    }

    @NotNull
    public final SnapshotIdSet getPreviousIds$runtime_release() {
        return this.previousIds;
    }

    @NotNull
    public final int[] getPreviousPinnedSnapshots$runtime_release() {
        return this.previousPinnedSnapshots;
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    @Nullable
    public Function1<Object, Unit> getReadObserver$runtime_release() {
        return this.readObserver;
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public boolean getReadOnly() {
        return false;
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    @NotNull
    public Snapshot getRoot() {
        return this;
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    @Nullable
    public Function1<Object, Unit> getWriteObserver$runtime_release() {
        return this.writeObserver;
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public boolean hasPendingChanges() {
        Set<StateObject> modified$runtime_release = getModified$runtime_release();
        return modified$runtime_release != null && (modified$runtime_release.isEmpty() ^ true);
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x003b, code lost:
    
        r8 = androidx.compose.runtime.snapshots.SnapshotKt.readable(r6, getId(), r0);
     */
    @org.jetbrains.annotations.NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final androidx.compose.runtime.snapshots.SnapshotApplyResult innerApplyLocked$runtime_release(int r12, @org.jetbrains.annotations.Nullable java.util.Map<androidx.compose.runtime.snapshots.StateRecord, ? extends androidx.compose.runtime.snapshots.StateRecord> r13, @org.jetbrains.annotations.NotNull androidx.compose.runtime.snapshots.SnapshotIdSet r14) {
        /*
            r11 = this;
            java.lang.String r0 = "invalidSnapshots"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
            androidx.compose.runtime.snapshots.SnapshotIdSet r0 = r11.getInvalid$runtime_release()
            int r1 = r11.getId()
            androidx.compose.runtime.snapshots.SnapshotIdSet r0 = r0.set(r1)
            androidx.compose.runtime.snapshots.SnapshotIdSet r1 = r11.previousIds
            androidx.compose.runtime.snapshots.SnapshotIdSet r0 = r0.m88or(r1)
            java.util.Set r1 = r11.getModified$runtime_release()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1)
            java.util.Iterator r2 = r1.iterator()
            r3 = 0
            r4 = r3
        L24:
            boolean r5 = r2.hasNext()
            if (r5 == 0) goto Lc1
            java.lang.Object r5 = r2.next()
            androidx.compose.runtime.snapshots.StateObject r5 = (androidx.compose.runtime.snapshots.StateObject) r5
            androidx.compose.runtime.snapshots.StateRecord r6 = r5.getFirstStateRecord()
            androidx.compose.runtime.snapshots.StateRecord r7 = androidx.compose.runtime.snapshots.SnapshotKt.access$readable(r6, r12, r14)
            if (r7 != 0) goto L3b
            goto L24
        L3b:
            int r8 = r11.getId()
            androidx.compose.runtime.snapshots.StateRecord r8 = androidx.compose.runtime.snapshots.SnapshotKt.access$readable(r6, r8, r0)
            if (r8 != 0) goto L46
            goto L24
        L46:
            boolean r9 = kotlin.jvm.internal.Intrinsics.areEqual(r7, r8)
            if (r9 != 0) goto L24
            int r9 = r11.getId()
            androidx.compose.runtime.snapshots.SnapshotIdSet r10 = r11.getInvalid$runtime_release()
            androidx.compose.runtime.snapshots.StateRecord r6 = androidx.compose.runtime.snapshots.SnapshotKt.access$readable(r6, r9, r10)
            if (r6 == 0) goto Lb8
            if (r13 == 0) goto L64
            java.lang.Object r9 = r13.get(r7)
            androidx.compose.runtime.snapshots.StateRecord r9 = (androidx.compose.runtime.snapshots.StateRecord) r9
            if (r9 != 0) goto L68
        L64:
            androidx.compose.runtime.snapshots.StateRecord r9 = r5.mergeRecords(r8, r7, r6)
        L68:
            if (r9 != 0) goto L70
            androidx.compose.runtime.snapshots.SnapshotApplyResult$Failure r12 = new androidx.compose.runtime.snapshots.SnapshotApplyResult$Failure
            r12.<init>(r11)
            return r12
        L70:
            boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual(r9, r6)
            if (r6 != 0) goto L24
            boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual(r9, r7)
            if (r6 == 0) goto L99
            if (r3 != 0) goto L83
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
        L83:
            androidx.compose.runtime.snapshots.StateRecord r6 = r7.create()
            kotlin.Pair r6 = kotlin.TuplesKt.to(r5, r6)
            r3.add(r6)
            if (r4 != 0) goto L95
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
        L95:
            r4.add(r5)
            goto L24
        L99:
            if (r3 != 0) goto La0
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
        La0:
            boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual(r9, r8)
            if (r6 != 0) goto Lab
            kotlin.Pair r5 = kotlin.TuplesKt.to(r5, r9)
            goto Lb3
        Lab:
            androidx.compose.runtime.snapshots.StateRecord r6 = r8.create()
            kotlin.Pair r5 = kotlin.TuplesKt.to(r5, r6)
        Lb3:
            r3.add(r5)
            goto L24
        Lb8:
            androidx.compose.runtime.snapshots.SnapshotKt.access$readError()
            kotlin.KotlinNothingValueException r12 = new kotlin.KotlinNothingValueException
            r12.<init>()
            throw r12
        Lc1:
            if (r3 == 0) goto Lfe
            r11.advance$runtime_release()
            r12 = 0
            int r13 = r3.size()
        Lcb:
            if (r12 >= r13) goto Lfe
            java.lang.Object r14 = r3.get(r12)
            kotlin.Pair r14 = (kotlin.Pair) r14
            java.lang.Object r0 = r14.component1()
            androidx.compose.runtime.snapshots.StateObject r0 = (androidx.compose.runtime.snapshots.StateObject) r0
            java.lang.Object r14 = r14.component2()
            androidx.compose.runtime.snapshots.StateRecord r14 = (androidx.compose.runtime.snapshots.StateRecord) r14
            int r2 = r11.getId()
            r14.setSnapshotId$runtime_release(r2)
            java.lang.Object r2 = androidx.compose.runtime.snapshots.SnapshotKt.getLock()
            monitor-enter(r2)
            androidx.compose.runtime.snapshots.StateRecord r5 = r0.getFirstStateRecord()     // Catch: java.lang.Throwable -> Lfb
            r14.setNext$runtime_release(r5)     // Catch: java.lang.Throwable -> Lfb
            r0.prependStateRecord(r14)     // Catch: java.lang.Throwable -> Lfb
            kotlin.Unit r14 = kotlin.Unit.INSTANCE     // Catch: java.lang.Throwable -> Lfb
            monitor-exit(r2)
            int r12 = r12 + 1
            goto Lcb
        Lfb:
            r12 = move-exception
            monitor-exit(r2)
            throw r12
        Lfe:
            if (r4 == 0) goto L103
            r1.removeAll(r4)
        L103:
            androidx.compose.runtime.snapshots.SnapshotApplyResult$Success r12 = androidx.compose.runtime.snapshots.SnapshotApplyResult.Success.INSTANCE
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.snapshots.MutableSnapshot.innerApplyLocked$runtime_release(int, java.util.Map, androidx.compose.runtime.snapshots.SnapshotIdSet):androidx.compose.runtime.snapshots.SnapshotApplyResult");
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    /* renamed from: nestedActivated$runtime_release */
    public void mo2438nestedActivated$runtime_release(@NotNull Snapshot snapshot) {
        Intrinsics.checkNotNullParameter(snapshot, "snapshot");
        this.snapshots++;
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    /* renamed from: nestedDeactivated$runtime_release */
    public void mo2439nestedDeactivated$runtime_release(@NotNull Snapshot snapshot) {
        Intrinsics.checkNotNullParameter(snapshot, "snapshot");
        int i = this.snapshots;
        if (!(i > 0)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        int i2 = i - 1;
        this.snapshots = i2;
        if (i2 != 0 || this.applied) {
            return;
        }
        abandon();
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public void notifyObjectsInitialized$runtime_release() {
        if (this.applied || getDisposed$runtime_release()) {
            return;
        }
        advance$runtime_release();
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    /* renamed from: recordModified$runtime_release */
    public void mo2441recordModified$runtime_release(@NotNull StateObject stateObject) {
        Intrinsics.checkNotNullParameter(stateObject, "state");
        Set<StateObject> modified$runtime_release = getModified$runtime_release();
        if (modified$runtime_release == null) {
            modified$runtime_release = new HashSet<>();
            setModified(modified$runtime_release);
        }
        modified$runtime_release.add(stateObject);
    }

    public final void recordPrevious$runtime_release(int i) {
        synchronized (SnapshotKt.getLock()) {
            this.previousIds = this.previousIds.set(i);
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void recordPreviousList$runtime_release(@NotNull SnapshotIdSet snapshotIdSet) {
        Intrinsics.checkNotNullParameter(snapshotIdSet, "snapshots");
        synchronized (SnapshotKt.getLock()) {
            this.previousIds = this.previousIds.m88or(snapshotIdSet);
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void recordPreviousPinnedSnapshot$runtime_release(int i) {
        if (i >= 0) {
            this.previousPinnedSnapshots = ArraysKt.plus(this.previousPinnedSnapshots, i);
        }
    }

    public final void recordPreviousPinnedSnapshots$runtime_release(@NotNull int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "handles");
        if (iArr.length == 0) {
            return;
        }
        int[] iArr2 = this.previousPinnedSnapshots;
        if (iArr2.length == 0) {
            this.previousPinnedSnapshots = iArr;
        } else {
            this.previousPinnedSnapshots = ArraysKt.plus(iArr2, iArr);
        }
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public void releasePinnedSnapshotsForCloseLocked$runtime_release() {
        releasePreviouslyPinnedSnapshotsLocked$runtime_release();
        super.releasePinnedSnapshotsForCloseLocked$runtime_release();
    }

    public final void releasePreviouslyPinnedSnapshotsLocked$runtime_release() {
        int length = this.previousPinnedSnapshots.length;
        for (int i = 0; i < length; i++) {
            SnapshotKt.releasePinningLocked(this.previousPinnedSnapshots[i]);
        }
    }

    public final void setApplied$runtime_release(boolean z) {
        this.applied = z;
    }

    public void setModified(@Nullable Set<StateObject> set) {
        this.modified = set;
    }

    public final void setPreviousIds$runtime_release(@NotNull SnapshotIdSet snapshotIdSet) {
        Intrinsics.checkNotNullParameter(snapshotIdSet, "<set-?>");
        this.previousIds = snapshotIdSet;
    }

    public final void setPreviousPinnedSnapshots$runtime_release(@NotNull int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "<set-?>");
        this.previousPinnedSnapshots = iArr;
    }

    @NotNull
    public MutableSnapshot takeNestedMutableSnapshot(@Nullable Function1<Object, Unit> function1, @Nullable Function1<Object, Unit> function12) {
        int i;
        SnapshotIdSet snapshotIdSet;
        NestedMutableSnapshot nestedMutableSnapshot;
        Function1 mergedWriteObserver;
        int i2;
        SnapshotIdSet snapshotIdSet2;
        validateNotDisposed$runtime_release();
        validateNotAppliedOrPinned$runtime_release();
        recordPrevious$runtime_release(getId());
        synchronized (SnapshotKt.getLock()) {
            i = SnapshotKt.nextSnapshotId;
            SnapshotKt.nextSnapshotId = i + 1;
            snapshotIdSet = SnapshotKt.openSnapshots;
            SnapshotKt.openSnapshots = snapshotIdSet.set(i);
            SnapshotIdSet invalid$runtime_release = getInvalid$runtime_release();
            setInvalid$runtime_release(invalid$runtime_release.set(i));
            SnapshotIdSet addRange = SnapshotKt.addRange(invalid$runtime_release, getId() + 1, i);
            Function1 mergedReadObserver$default = SnapshotKt.mergedReadObserver$default(function1, getReadObserver$runtime_release(), false, 4, null);
            mergedWriteObserver = SnapshotKt.mergedWriteObserver(function12, getWriteObserver$runtime_release());
            nestedMutableSnapshot = new NestedMutableSnapshot(i, addRange, mergedReadObserver$default, mergedWriteObserver, this);
        }
        if (!getApplied$runtime_release() && !getDisposed$runtime_release()) {
            int id = getId();
            synchronized (SnapshotKt.getLock()) {
                i2 = SnapshotKt.nextSnapshotId;
                SnapshotKt.nextSnapshotId = i2 + 1;
                setId$runtime_release(i2);
                snapshotIdSet2 = SnapshotKt.openSnapshots;
                SnapshotKt.openSnapshots = snapshotIdSet2.set(getId());
                Unit unit = Unit.INSTANCE;
            }
            setInvalid$runtime_release(SnapshotKt.addRange(getInvalid$runtime_release(), id + 1, getId()));
        }
        return nestedMutableSnapshot;
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    @NotNull
    public Snapshot takeNestedSnapshot(@Nullable Function1<Object, Unit> function1) {
        int i;
        SnapshotIdSet snapshotIdSet;
        NestedReadonlySnapshot nestedReadonlySnapshot;
        int i2;
        SnapshotIdSet snapshotIdSet2;
        validateNotDisposed$runtime_release();
        validateNotAppliedOrPinned$runtime_release();
        int id = getId();
        recordPrevious$runtime_release(getId());
        synchronized (SnapshotKt.getLock()) {
            i = SnapshotKt.nextSnapshotId;
            SnapshotKt.nextSnapshotId = i + 1;
            snapshotIdSet = SnapshotKt.openSnapshots;
            SnapshotKt.openSnapshots = snapshotIdSet.set(i);
            nestedReadonlySnapshot = new NestedReadonlySnapshot(i, SnapshotKt.addRange(getInvalid$runtime_release(), id + 1, i), function1, this);
        }
        if (!getApplied$runtime_release() && !getDisposed$runtime_release()) {
            int id2 = getId();
            synchronized (SnapshotKt.getLock()) {
                i2 = SnapshotKt.nextSnapshotId;
                SnapshotKt.nextSnapshotId = i2 + 1;
                setId$runtime_release(i2);
                snapshotIdSet2 = SnapshotKt.openSnapshots;
                SnapshotKt.openSnapshots = snapshotIdSet2.set(getId());
                Unit unit = Unit.INSTANCE;
            }
            setInvalid$runtime_release(SnapshotKt.addRange(getInvalid$runtime_release(), id2 + 1, getId()));
        }
        return nestedReadonlySnapshot;
    }

    public final void validateNotApplied$runtime_release() {
        if (!(!this.applied)) {
            throw new IllegalStateException("Unsupported operation on a snapshot that has been applied".toString());
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x000f, code lost:
    
        if ((((androidx.compose.runtime.snapshots.Snapshot) r3).pinningTrackingHandle >= 0) != false) goto L9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void validateNotAppliedOrPinned$runtime_release() {
        /*
            r3 = this;
            boolean r0 = r3.applied
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L11
            int r0 = androidx.compose.runtime.snapshots.Snapshot.access$getPinningTrackingHandle$p(r3)
            if (r0 < 0) goto Le
            r0 = 1
            goto Lf
        Le:
            r0 = 0
        Lf:
            if (r0 == 0) goto L12
        L11:
            r1 = 1
        L12:
            if (r1 == 0) goto L15
            return
        L15:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "Unsupported operation on a disposed or applied snapshot"
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.snapshots.MutableSnapshot.validateNotAppliedOrPinned$runtime_release():void");
    }

    public final void advance$runtime_release() {
        int i;
        SnapshotIdSet snapshotIdSet;
        recordPrevious$runtime_release(getId());
        Unit unit = Unit.INSTANCE;
        if (getApplied$runtime_release() || getDisposed$runtime_release()) {
            return;
        }
        int id = getId();
        synchronized (SnapshotKt.getLock()) {
            i = SnapshotKt.nextSnapshotId;
            SnapshotKt.nextSnapshotId = i + 1;
            setId$runtime_release(i);
            snapshotIdSet = SnapshotKt.openSnapshots;
            SnapshotKt.openSnapshots = snapshotIdSet.set(getId());
        }
        setInvalid$runtime_release(SnapshotKt.addRange(getInvalid$runtime_release(), id + 1, getId()));
    }
}
