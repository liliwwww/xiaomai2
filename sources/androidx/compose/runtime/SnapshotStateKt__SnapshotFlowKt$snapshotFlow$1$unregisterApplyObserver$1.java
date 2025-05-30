package androidx.compose.runtime;

import androidx.compose.runtime.snapshots.Snapshot;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.channels.Channel;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
final class SnapshotStateKt__SnapshotFlowKt$snapshotFlow$1$unregisterApplyObserver$1 extends Lambda implements Function2<Set<? extends Object>, Snapshot, Unit> {
    final /* synthetic */ Channel<Set<Object>> $appliedChanges;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SnapshotStateKt__SnapshotFlowKt$snapshotFlow$1$unregisterApplyObserver$1(Channel<Set<Object>> channel) {
        super(2);
        this.$appliedChanges = channel;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Set<? extends Object>) obj, (Snapshot) obj2);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull Set<? extends Object> set, @NotNull Snapshot snapshot) {
        Intrinsics.checkNotNullParameter(set, "changed");
        Intrinsics.checkNotNullParameter(snapshot, "<anonymous parameter 1>");
        this.$appliedChanges.trySend-JP2dKIU(set);
    }
}
