package androidx.compose.runtime.snapshots;

import androidx.compose.runtime.InternalComposeApi;
import androidx.compose.runtime.SnapshotThreadLocal;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.PublishedApi;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class Snapshot$Companion {
    private Snapshot$Companion() {
    }

    public /* synthetic */ Snapshot$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Object observe$default(Snapshot$Companion snapshot$Companion, Function1 function1, Function1 function12, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            function1 = null;
        }
        if ((i & 2) != 0) {
            function12 = null;
        }
        return snapshot$Companion.observe(function1, function12, function0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MutableSnapshot takeMutableSnapshot$default(Snapshot$Companion snapshot$Companion, Function1 function1, Function1 function12, int i, Object obj) {
        if ((i & 1) != 0) {
            function1 = null;
        }
        if ((i & 2) != 0) {
            function12 = null;
        }
        return snapshot$Companion.takeMutableSnapshot(function1, function12);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Snapshot takeSnapshot$default(Snapshot$Companion snapshot$Companion, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            function1 = null;
        }
        return snapshot$Companion.takeSnapshot(function1);
    }

    @PublishedApi
    @NotNull
    public final Snapshot createNonObservableSnapshot() {
        SnapshotThreadLocal snapshotThreadLocal;
        snapshotThreadLocal = SnapshotKt.threadSnapshot;
        return SnapshotKt.createTransparentSnapshotWithNoParentReadObserver$default((Snapshot) snapshotThreadLocal.get(), null, false, 6, null);
    }

    @NotNull
    public final Snapshot getCurrent() {
        return SnapshotKt.currentSnapshot();
    }

    public final <T> T global(@NotNull Function0<? extends T> function0) {
        Intrinsics.checkNotNullParameter(function0, "block");
        Snapshot removeCurrent = removeCurrent();
        T t = (T) function0.invoke();
        Snapshot.Companion.restoreCurrent(removeCurrent);
        return t;
    }

    public final void notifyObjectsInitialized() {
        SnapshotKt.currentSnapshot().notifyObjectsInitialized$runtime_release();
    }

    public final <T> T observe(@Nullable Function1<Object, Unit> function1, @Nullable Function1<Object, Unit> function12, @NotNull Function0<? extends T> function0) {
        SnapshotThreadLocal snapshotThreadLocal;
        Snapshot transparentObserverMutableSnapshot;
        Intrinsics.checkNotNullParameter(function0, "block");
        if (function1 == null && function12 == null) {
            return (T) function0.invoke();
        }
        snapshotThreadLocal = SnapshotKt.threadSnapshot;
        MutableSnapshot mutableSnapshot = (Snapshot) snapshotThreadLocal.get();
        if (mutableSnapshot == null || (mutableSnapshot instanceof MutableSnapshot)) {
            transparentObserverMutableSnapshot = new TransparentObserverMutableSnapshot(mutableSnapshot instanceof MutableSnapshot ? mutableSnapshot : null, function1, function12, true, false);
        } else {
            if (function1 == null) {
                return (T) function0.invoke();
            }
            transparentObserverMutableSnapshot = mutableSnapshot.takeNestedSnapshot(function1);
        }
        try {
            Snapshot makeCurrent = transparentObserverMutableSnapshot.makeCurrent();
            try {
                return (T) function0.invoke();
            } finally {
                transparentObserverMutableSnapshot.restoreCurrent(makeCurrent);
            }
        } finally {
            transparentObserverMutableSnapshot.dispose();
        }
    }

    @InternalComposeApi
    public final int openSnapshotCount() {
        SnapshotIdSet snapshotIdSet;
        snapshotIdSet = SnapshotKt.openSnapshots;
        return CollectionsKt.toList(snapshotIdSet).size();
    }

    @NotNull
    public final ObserverHandle registerApplyObserver(@NotNull final Function2<? super Set<? extends Object>, ? super Snapshot, Unit> function2) {
        Function1 function1;
        List list;
        Intrinsics.checkNotNullParameter(function2, "observer");
        function1 = SnapshotKt.emptyLambda;
        SnapshotKt.advanceGlobalSnapshot(function1);
        synchronized (SnapshotKt.getLock()) {
            list = SnapshotKt.applyObservers;
            list.add(function2);
        }
        return new ObserverHandle() { // from class: androidx.compose.runtime.snapshots.Snapshot$Companion$registerApplyObserver$2
            @Override // androidx.compose.runtime.snapshots.ObserverHandle
            public final void dispose() {
                List list2;
                Function2<Set<? extends Object>, Snapshot, Unit> function22 = function2;
                synchronized (SnapshotKt.getLock()) {
                    list2 = SnapshotKt.applyObservers;
                    list2.remove(function22);
                    Unit unit = Unit.INSTANCE;
                }
            }
        };
    }

    @NotNull
    public final ObserverHandle registerGlobalWriteObserver(@NotNull final Function1<Object, Unit> function1) {
        List list;
        Intrinsics.checkNotNullParameter(function1, "observer");
        synchronized (SnapshotKt.getLock()) {
            list = SnapshotKt.globalWriteObservers;
            list.add(function1);
        }
        SnapshotKt.advanceGlobalSnapshot();
        return new ObserverHandle() { // from class: androidx.compose.runtime.snapshots.Snapshot$Companion$registerGlobalWriteObserver$2
            @Override // androidx.compose.runtime.snapshots.ObserverHandle
            public final void dispose() {
                List list2;
                Function1<Object, Unit> function12 = function1;
                synchronized (SnapshotKt.getLock()) {
                    list2 = SnapshotKt.globalWriteObservers;
                    list2.remove(function12);
                }
                SnapshotKt.advanceGlobalSnapshot();
            }
        };
    }

    @PublishedApi
    @Nullable
    public final Snapshot removeCurrent() {
        SnapshotThreadLocal snapshotThreadLocal;
        SnapshotThreadLocal snapshotThreadLocal2;
        snapshotThreadLocal = SnapshotKt.threadSnapshot;
        Snapshot snapshot = (Snapshot) snapshotThreadLocal.get();
        if (snapshot != null) {
            snapshotThreadLocal2 = SnapshotKt.threadSnapshot;
            snapshotThreadLocal2.set((Object) null);
        }
        return snapshot;
    }

    @PublishedApi
    public final void restoreCurrent(@Nullable Snapshot snapshot) {
        SnapshotThreadLocal snapshotThreadLocal;
        if (snapshot != null) {
            snapshotThreadLocal = SnapshotKt.threadSnapshot;
            snapshotThreadLocal.set(snapshot);
        }
    }

    public final void sendApplyNotifications() {
        AtomicReference atomicReference;
        boolean z;
        synchronized (SnapshotKt.getLock()) {
            atomicReference = SnapshotKt.currentGlobalSnapshot;
            z = false;
            if (((GlobalSnapshot) atomicReference.get()).getModified$runtime_release() != null) {
                if (!r1.isEmpty()) {
                    z = true;
                }
            }
        }
        if (z) {
            SnapshotKt.advanceGlobalSnapshot();
        }
    }

    @NotNull
    public final MutableSnapshot takeMutableSnapshot(@Nullable Function1<Object, Unit> function1, @Nullable Function1<Object, Unit> function12) {
        MutableSnapshot takeNestedMutableSnapshot;
        MutableSnapshot currentSnapshot = SnapshotKt.currentSnapshot();
        MutableSnapshot mutableSnapshot = currentSnapshot instanceof MutableSnapshot ? currentSnapshot : null;
        if (mutableSnapshot == null || (takeNestedMutableSnapshot = mutableSnapshot.takeNestedMutableSnapshot(function1, function12)) == null) {
            throw new IllegalStateException("Cannot create a mutable snapshot of an read-only snapshot".toString());
        }
        return takeNestedMutableSnapshot;
    }

    @NotNull
    public final Snapshot takeSnapshot(@Nullable Function1<Object, Unit> function1) {
        return SnapshotKt.currentSnapshot().takeNestedSnapshot(function1);
    }

    public final <R> R withMutableSnapshot(@NotNull Function0<? extends R> function0) {
        Intrinsics.checkNotNullParameter(function0, "block");
        MutableSnapshot takeMutableSnapshot$default = takeMutableSnapshot$default(this, null, null, 3, null);
        try {
            Snapshot makeCurrent = takeMutableSnapshot$default.makeCurrent();
            try {
                R r = (R) function0.invoke();
                InlineMarker.finallyStart(1);
                takeMutableSnapshot$default.restoreCurrent(makeCurrent);
                InlineMarker.finallyEnd(1);
                takeMutableSnapshot$default.apply().check();
                return r;
            } catch (Throwable th) {
                InlineMarker.finallyStart(1);
                takeMutableSnapshot$default.restoreCurrent(makeCurrent);
                InlineMarker.finallyEnd(1);
                throw th;
            }
        } finally {
            InlineMarker.finallyStart(1);
            takeMutableSnapshot$default.dispose();
            InlineMarker.finallyEnd(1);
        }
    }

    public final <T> T withoutReadObservation(@NotNull Function0<? extends T> function0) {
        Intrinsics.checkNotNullParameter(function0, "block");
        Snapshot createNonObservableSnapshot = createNonObservableSnapshot();
        try {
            Snapshot makeCurrent = createNonObservableSnapshot.makeCurrent();
            try {
                return (T) function0.invoke();
            } finally {
                InlineMarker.finallyStart(1);
                createNonObservableSnapshot.restoreCurrent(makeCurrent);
                InlineMarker.finallyEnd(1);
            }
        } finally {
            InlineMarker.finallyStart(1);
            createNonObservableSnapshot.dispose();
            InlineMarker.finallyEnd(1);
        }
    }
}
