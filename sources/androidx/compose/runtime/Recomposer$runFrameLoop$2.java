package androidx.compose.runtime;

import androidx.compose.runtime.collection.IdentityArraySet;
import androidx.compose.runtime.snapshots.Snapshot;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CancellableContinuation;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class Recomposer$runFrameLoop$2 extends Lambda implements Function1<Long, CancellableContinuation<? super Unit>> {
    final /* synthetic */ ProduceFrameSignal $frameSignal;
    final /* synthetic */ List<ControlledComposition> $toApply;
    final /* synthetic */ List<ControlledComposition> $toRecompose;
    final /* synthetic */ Recomposer this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    Recomposer$runFrameLoop$2(Recomposer recomposer, List<ControlledComposition> list, List<ControlledComposition> list2, ProduceFrameSignal produceFrameSignal) {
        super(1);
        this.this$0 = recomposer;
        this.$toRecompose = list;
        this.$toApply = list2;
        this.$frameSignal = produceFrameSignal;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return invoke(((Number) obj).longValue());
    }

    @Nullable
    public final CancellableContinuation<Unit> invoke(long j) {
        Object beginSection;
        int i;
        CancellableContinuation<Unit> access$deriveStateLocked;
        if (Recomposer.access$getBroadcastFrameClock$p(this.this$0).getHasAwaiters()) {
            Recomposer recomposer = this.this$0;
            Trace trace = Trace.INSTANCE;
            beginSection = trace.beginSection("Recomposer:animation");
            try {
                Recomposer.access$getBroadcastFrameClock$p(recomposer).sendFrame(j);
                Snapshot.Companion.sendApplyNotifications();
                Unit unit = Unit.INSTANCE;
                trace.endSection(beginSection);
            } finally {
            }
        }
        Recomposer recomposer2 = this.this$0;
        List<ControlledComposition> list = this.$toRecompose;
        List<ControlledComposition> list2 = this.$toApply;
        ProduceFrameSignal produceFrameSignal = this.$frameSignal;
        beginSection = Trace.INSTANCE.beginSection("Recomposer:recompose");
        try {
            synchronized (Recomposer.access$getStateLock$p(recomposer2)) {
                Recomposer.access$recordComposerModificationsLocked(recomposer2);
                List access$getCompositionsAwaitingApply$p = Recomposer.access$getCompositionsAwaitingApply$p(recomposer2);
                int size = access$getCompositionsAwaitingApply$p.size();
                for (int i2 = 0; i2 < size; i2++) {
                    list2.add((ControlledComposition) access$getCompositionsAwaitingApply$p.get(i2));
                }
                Recomposer.access$getCompositionsAwaitingApply$p(recomposer2).clear();
                List access$getCompositionInvalidations$p = Recomposer.access$getCompositionInvalidations$p(recomposer2);
                int size2 = access$getCompositionInvalidations$p.size();
                for (int i3 = 0; i3 < size2; i3++) {
                    list.add((ControlledComposition) access$getCompositionInvalidations$p.get(i3));
                }
                Recomposer.access$getCompositionInvalidations$p(recomposer2).clear();
                produceFrameSignal.takeFrameRequestLocked();
                Unit unit2 = Unit.INSTANCE;
            }
            IdentityArraySet identityArraySet = new IdentityArraySet();
            try {
                int size3 = list.size();
                for (int i4 = 0; i4 < size3; i4++) {
                    ControlledComposition access$performRecompose = Recomposer.access$performRecompose(recomposer2, list.get(i4), identityArraySet);
                    if (access$performRecompose != null) {
                        list2.add(access$performRecompose);
                    }
                }
                list.clear();
                if (!list2.isEmpty()) {
                    Recomposer.access$setChangeCount$p(recomposer2, recomposer2.getChangeCount() + 1);
                }
                try {
                    int size4 = list2.size();
                    for (i = 0; i < size4; i++) {
                        list2.get(i).applyChanges();
                    }
                    list2.clear();
                    synchronized (Recomposer.access$getStateLock$p(recomposer2)) {
                        access$deriveStateLocked = Recomposer.access$deriveStateLocked(recomposer2);
                    }
                    return access$deriveStateLocked;
                } catch (Throwable th) {
                    list2.clear();
                    throw th;
                }
            } catch (Throwable th2) {
                list.clear();
                throw th2;
            }
        } finally {
        }
    }
}
