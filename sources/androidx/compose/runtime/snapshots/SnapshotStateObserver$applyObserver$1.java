package androidx.compose.runtime.snapshots;

import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class SnapshotStateObserver$applyObserver$1 extends Lambda implements Function2<Set<? extends Object>, Snapshot, Unit> {
    final /* synthetic */ SnapshotStateObserver this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SnapshotStateObserver$applyObserver$1(SnapshotStateObserver snapshotStateObserver) {
        super(2);
        this.this$0 = snapshotStateObserver;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Set<? extends Object>) obj, (Snapshot) obj2);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull Set<? extends Object> set, @NotNull Snapshot snapshot) {
        Intrinsics.checkNotNullParameter(set, "applied");
        Intrinsics.checkNotNullParameter(snapshot, "<anonymous parameter 1>");
        SnapshotStateObserver.access$addChanges(this.this$0, set);
        if (SnapshotStateObserver.access$drainChanges(this.this$0)) {
            SnapshotStateObserver.access$sendNotifications(this.this$0);
        }
    }
}
