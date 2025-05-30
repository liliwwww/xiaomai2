package androidx.compose.runtime.snapshots;

import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@StabilityInferred(parameters = 0)
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class SnapshotApplyResult$Failure extends SnapshotApplyResult {
    public static final int $stable = 8;

    @NotNull
    private final Snapshot snapshot;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SnapshotApplyResult$Failure(@NotNull Snapshot snapshot) {
        super((DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(snapshot, "snapshot");
        this.snapshot = snapshot;
    }

    public void check() {
        this.snapshot.dispose();
        throw new SnapshotApplyConflictException(this.snapshot);
    }

    @NotNull
    public final Snapshot getSnapshot() {
        return this.snapshot;
    }

    public boolean getSucceeded() {
        return false;
    }
}
