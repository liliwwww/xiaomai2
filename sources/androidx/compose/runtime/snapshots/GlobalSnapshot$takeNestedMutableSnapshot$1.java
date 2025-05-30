package androidx.compose.runtime.snapshots;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
final class GlobalSnapshot$takeNestedMutableSnapshot$1 extends Lambda implements Function1<SnapshotIdSet, MutableSnapshot> {
    final /* synthetic */ Function1<Object, Unit> $readObserver;
    final /* synthetic */ Function1<Object, Unit> $writeObserver;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    GlobalSnapshot$takeNestedMutableSnapshot$1(Function1<Object, Unit> function1, Function1<Object, Unit> function12) {
        super(1);
        this.$readObserver = function1;
        this.$writeObserver = function12;
    }

    @NotNull
    public final MutableSnapshot invoke(@NotNull SnapshotIdSet snapshotIdSet) {
        int access$getNextSnapshotId$p;
        Intrinsics.checkNotNullParameter(snapshotIdSet, "invalid");
        synchronized (SnapshotKt.getLock()) {
            access$getNextSnapshotId$p = SnapshotKt.access$getNextSnapshotId$p();
            SnapshotKt.access$setNextSnapshotId$p(access$getNextSnapshotId$p + 1);
        }
        return new MutableSnapshot(access$getNextSnapshotId$p, snapshotIdSet, this.$readObserver, this.$writeObserver);
    }
}
