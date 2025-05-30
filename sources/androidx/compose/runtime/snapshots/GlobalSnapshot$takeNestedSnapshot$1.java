package androidx.compose.runtime.snapshots;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
final class GlobalSnapshot$takeNestedSnapshot$1 extends Lambda implements Function1<SnapshotIdSet, ReadonlySnapshot> {
    final /* synthetic */ Function1<Object, Unit> $readObserver;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    GlobalSnapshot$takeNestedSnapshot$1(Function1<Object, Unit> function1) {
        super(1);
        this.$readObserver = function1;
    }

    @NotNull
    public final ReadonlySnapshot invoke(@NotNull SnapshotIdSet snapshotIdSet) {
        int access$getNextSnapshotId$p;
        Intrinsics.checkNotNullParameter(snapshotIdSet, "invalid");
        synchronized (SnapshotKt.getLock()) {
            access$getNextSnapshotId$p = SnapshotKt.access$getNextSnapshotId$p();
            SnapshotKt.access$setNextSnapshotId$p(access$getNextSnapshotId$p + 1);
        }
        return new ReadonlySnapshot(access$getNextSnapshotId$p, snapshotIdSet, this.$readObserver);
    }
}
