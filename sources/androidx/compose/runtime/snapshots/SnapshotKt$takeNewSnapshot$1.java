package androidx.compose.runtime.snapshots;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
final class SnapshotKt$takeNewSnapshot$1<T> extends Lambda implements Function1<SnapshotIdSet, T> {
    final /* synthetic */ Function1<SnapshotIdSet, T> $block;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SnapshotKt$takeNewSnapshot$1(Function1<? super SnapshotIdSet, ? extends T> function1) {
        super(1);
        this.$block = function1;
    }

    /* JADX WARN: Incorrect return type in method signature: (Landroidx/compose/runtime/snapshots/SnapshotIdSet;)TT; */
    @NotNull
    public final Snapshot invoke(@NotNull SnapshotIdSet snapshotIdSet) {
        Intrinsics.checkNotNullParameter(snapshotIdSet, "invalid");
        Snapshot snapshot = (Snapshot) this.$block.invoke(snapshotIdSet);
        synchronized (SnapshotKt.getLock()) {
            SnapshotKt.access$setOpenSnapshots$p(SnapshotKt.access$getOpenSnapshots$p().set(snapshot.getId()));
            Unit unit = Unit.INSTANCE;
        }
        return snapshot;
    }
}
