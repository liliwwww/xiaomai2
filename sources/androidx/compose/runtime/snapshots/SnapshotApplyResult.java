package androidx.compose.runtime.snapshots;

import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@StabilityInferred(parameters = 0)
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public abstract class SnapshotApplyResult {
    public static final int $stable = 0;

    /* compiled from: Taobao */
    @StabilityInferred(parameters = 0)
    public static final class Success extends SnapshotApplyResult {
        public static final int $stable = 0;

        @NotNull
        public static final Success INSTANCE = new Success();

        private Success() {
            super(null);
        }

        @Override // androidx.compose.runtime.snapshots.SnapshotApplyResult
        public void check() {
        }

        @Override // androidx.compose.runtime.snapshots.SnapshotApplyResult
        public boolean getSucceeded() {
            return true;
        }
    }

    private SnapshotApplyResult() {
    }

    public /* synthetic */ SnapshotApplyResult(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public abstract void check();

    public abstract boolean getSucceeded();
}
