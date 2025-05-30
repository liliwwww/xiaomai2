package androidx.compose.runtime.snapshots;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public final class NestedMutableSnapshot extends MutableSnapshot {
    private boolean deactivated;

    @NotNull
    private final MutableSnapshot parent;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NestedMutableSnapshot(int i, @NotNull SnapshotIdSet snapshotIdSet, @Nullable Function1<Object, Unit> function1, @Nullable Function1<Object, Unit> function12, @NotNull MutableSnapshot mutableSnapshot) {
        super(i, snapshotIdSet, function1, function12);
        Intrinsics.checkNotNullParameter(snapshotIdSet, "invalid");
        Intrinsics.checkNotNullParameter(mutableSnapshot, "parent");
        this.parent = mutableSnapshot;
        mutableSnapshot.mo2438nestedActivated$runtime_release(this);
    }

    private final void deactivate() {
        if (this.deactivated) {
            return;
        }
        this.deactivated = true;
        this.parent.mo2439nestedDeactivated$runtime_release(this);
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0074 A[Catch: all -> 0x00bb, TryCatch #0 {, blocks: (B:11:0x002d, B:13:0x0032, B:16:0x0039, B:21:0x0053, B:23:0x005b, B:24:0x0065, B:25:0x006c, B:27:0x0074, B:28:0x0079, B:33:0x0069), top: B:10:0x002d }] */
    @Override // androidx.compose.runtime.snapshots.MutableSnapshot
    @org.jetbrains.annotations.NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public androidx.compose.runtime.snapshots.SnapshotApplyResult apply() {
        /*
            r6 = this;
            androidx.compose.runtime.snapshots.MutableSnapshot r0 = r6.parent
            boolean r0 = r0.getApplied$runtime_release()
            if (r0 != 0) goto Lbe
            androidx.compose.runtime.snapshots.MutableSnapshot r0 = r6.parent
            boolean r0 = r0.getDisposed$runtime_release()
            if (r0 == 0) goto L12
            goto Lbe
        L12:
            java.util.Set r0 = r6.getModified$runtime_release()
            int r1 = r6.getId()
            if (r0 == 0) goto L27
            androidx.compose.runtime.snapshots.MutableSnapshot r2 = r6.parent
            androidx.compose.runtime.snapshots.SnapshotIdSet r3 = r2.getInvalid$runtime_release()
            java.util.Map r2 = androidx.compose.runtime.snapshots.SnapshotKt.access$optimisticMerges(r2, r6, r3)
            goto L28
        L27:
            r2 = 0
        L28:
            java.lang.Object r3 = androidx.compose.runtime.snapshots.SnapshotKt.getLock()
            monitor-enter(r3)
            androidx.compose.runtime.snapshots.SnapshotKt.access$validateOpen(r6)     // Catch: java.lang.Throwable -> Lbb
            if (r0 == 0) goto L69
            int r4 = r0.size()     // Catch: java.lang.Throwable -> Lbb
            if (r4 != 0) goto L39
            goto L69
        L39:
            androidx.compose.runtime.snapshots.MutableSnapshot r4 = r6.parent     // Catch: java.lang.Throwable -> Lbb
            int r4 = r4.getId()     // Catch: java.lang.Throwable -> Lbb
            androidx.compose.runtime.snapshots.MutableSnapshot r5 = r6.parent     // Catch: java.lang.Throwable -> Lbb
            androidx.compose.runtime.snapshots.SnapshotIdSet r5 = r5.getInvalid$runtime_release()     // Catch: java.lang.Throwable -> Lbb
            androidx.compose.runtime.snapshots.SnapshotApplyResult r2 = r6.innerApplyLocked$runtime_release(r4, r2, r5)     // Catch: java.lang.Throwable -> Lbb
            androidx.compose.runtime.snapshots.SnapshotApplyResult$Success r4 = androidx.compose.runtime.snapshots.SnapshotApplyResult.Success.INSTANCE     // Catch: java.lang.Throwable -> Lbb
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual(r2, r4)     // Catch: java.lang.Throwable -> Lbb
            if (r4 != 0) goto L53
            monitor-exit(r3)
            return r2
        L53:
            androidx.compose.runtime.snapshots.MutableSnapshot r2 = r6.parent     // Catch: java.lang.Throwable -> Lbb
            java.util.Set r2 = r2.getModified$runtime_release()     // Catch: java.lang.Throwable -> Lbb
            if (r2 != 0) goto L65
            java.util.HashSet r2 = new java.util.HashSet     // Catch: java.lang.Throwable -> Lbb
            r2.<init>()     // Catch: java.lang.Throwable -> Lbb
            androidx.compose.runtime.snapshots.MutableSnapshot r4 = r6.parent     // Catch: java.lang.Throwable -> Lbb
            r4.setModified(r2)     // Catch: java.lang.Throwable -> Lbb
        L65:
            r2.addAll(r0)     // Catch: java.lang.Throwable -> Lbb
            goto L6c
        L69:
            r6.closeAndReleasePinning$runtime_release()     // Catch: java.lang.Throwable -> Lbb
        L6c:
            androidx.compose.runtime.snapshots.MutableSnapshot r0 = r6.parent     // Catch: java.lang.Throwable -> Lbb
            int r0 = r0.getId()     // Catch: java.lang.Throwable -> Lbb
            if (r0 >= r1) goto L79
            androidx.compose.runtime.snapshots.MutableSnapshot r0 = r6.parent     // Catch: java.lang.Throwable -> Lbb
            r0.advance$runtime_release()     // Catch: java.lang.Throwable -> Lbb
        L79:
            androidx.compose.runtime.snapshots.MutableSnapshot r0 = r6.parent     // Catch: java.lang.Throwable -> Lbb
            androidx.compose.runtime.snapshots.SnapshotIdSet r2 = r0.getInvalid$runtime_release()     // Catch: java.lang.Throwable -> Lbb
            androidx.compose.runtime.snapshots.SnapshotIdSet r2 = r2.clear(r1)     // Catch: java.lang.Throwable -> Lbb
            androidx.compose.runtime.snapshots.SnapshotIdSet r4 = r6.getPreviousIds$runtime_release()     // Catch: java.lang.Throwable -> Lbb
            androidx.compose.runtime.snapshots.SnapshotIdSet r2 = r2.andNot(r4)     // Catch: java.lang.Throwable -> Lbb
            r0.setInvalid$runtime_release(r2)     // Catch: java.lang.Throwable -> Lbb
            androidx.compose.runtime.snapshots.MutableSnapshot r0 = r6.parent     // Catch: java.lang.Throwable -> Lbb
            r0.recordPrevious$runtime_release(r1)     // Catch: java.lang.Throwable -> Lbb
            androidx.compose.runtime.snapshots.MutableSnapshot r0 = r6.parent     // Catch: java.lang.Throwable -> Lbb
            int r1 = r6.takeoverPinnedSnapshot$runtime_release()     // Catch: java.lang.Throwable -> Lbb
            r0.recordPreviousPinnedSnapshot$runtime_release(r1)     // Catch: java.lang.Throwable -> Lbb
            androidx.compose.runtime.snapshots.MutableSnapshot r0 = r6.parent     // Catch: java.lang.Throwable -> Lbb
            androidx.compose.runtime.snapshots.SnapshotIdSet r1 = r6.getPreviousIds$runtime_release()     // Catch: java.lang.Throwable -> Lbb
            r0.recordPreviousList$runtime_release(r1)     // Catch: java.lang.Throwable -> Lbb
            androidx.compose.runtime.snapshots.MutableSnapshot r0 = r6.parent     // Catch: java.lang.Throwable -> Lbb
            int[] r1 = r6.getPreviousPinnedSnapshots$runtime_release()     // Catch: java.lang.Throwable -> Lbb
            r0.recordPreviousPinnedSnapshots$runtime_release(r1)     // Catch: java.lang.Throwable -> Lbb
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch: java.lang.Throwable -> Lbb
            monitor-exit(r3)
            r0 = 1
            r6.setApplied$runtime_release(r0)
            r6.deactivate()
            androidx.compose.runtime.snapshots.SnapshotApplyResult$Success r0 = androidx.compose.runtime.snapshots.SnapshotApplyResult.Success.INSTANCE
            return r0
        Lbb:
            r0 = move-exception
            monitor-exit(r3)
            throw r0
        Lbe:
            androidx.compose.runtime.snapshots.SnapshotApplyResult$Failure r0 = new androidx.compose.runtime.snapshots.SnapshotApplyResult$Failure
            r0.<init>(r6)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.snapshots.NestedMutableSnapshot.apply():androidx.compose.runtime.snapshots.SnapshotApplyResult");
    }

    @Override // androidx.compose.runtime.snapshots.MutableSnapshot, androidx.compose.runtime.snapshots.Snapshot
    public void dispose() {
        if (getDisposed$runtime_release()) {
            return;
        }
        super.dispose();
        deactivate();
    }

    @NotNull
    public final MutableSnapshot getParent() {
        return this.parent;
    }

    @Override // androidx.compose.runtime.snapshots.MutableSnapshot, androidx.compose.runtime.snapshots.Snapshot
    @NotNull
    public Snapshot getRoot() {
        return this.parent.getRoot();
    }
}
