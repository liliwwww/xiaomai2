package androidx.compose.runtime.snapshots;

import androidx.compose.runtime.State;
import androidx.compose.runtime.snapshots.SnapshotStateObserver;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
final class SnapshotStateObserver$ObservedScopeMap$derivedStateExitObserver$1 extends Lambda implements Function1<State<?>, Unit> {
    final /* synthetic */ SnapshotStateObserver.ObservedScopeMap this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SnapshotStateObserver$ObservedScopeMap$derivedStateExitObserver$1(SnapshotStateObserver.ObservedScopeMap observedScopeMap) {
        super(1);
        this.this$0 = observedScopeMap;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((State<?>) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull State<?> state) {
        Intrinsics.checkNotNullParameter(state, "it");
        SnapshotStateObserver.ObservedScopeMap.access$setDeriveStateScopeCount$p(this.this$0, SnapshotStateObserver.ObservedScopeMap.access$getDeriveStateScopeCount$p(r2) - 1);
    }
}
