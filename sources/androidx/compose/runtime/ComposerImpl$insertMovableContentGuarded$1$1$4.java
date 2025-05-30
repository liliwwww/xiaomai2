package androidx.compose.runtime;

import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class ComposerImpl$insertMovableContentGuarded$1$1$4 extends Lambda implements Function3<Applier<?>, SlotWriter, RememberManager, Unit> {
    final /* synthetic */ MovableContentStateReference $from;
    final /* synthetic */ MovableContentState $resolvedState;
    final /* synthetic */ MovableContentStateReference $to;
    final /* synthetic */ ComposerImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ComposerImpl$insertMovableContentGuarded$1$1$4(MovableContentState movableContentState, ComposerImpl composerImpl, MovableContentStateReference movableContentStateReference, MovableContentStateReference movableContentStateReference2) {
        super(3);
        this.$resolvedState = movableContentState;
        this.this$0 = composerImpl;
        this.$from = movableContentStateReference;
        this.$to = movableContentStateReference2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        invoke((Applier<?>) obj, (SlotWriter) obj2, (RememberManager) obj3);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull Applier<?> applier, @NotNull SlotWriter slotWriter, @NotNull RememberManager rememberManager) {
        Intrinsics.checkNotNullParameter(applier, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(slotWriter, "slots");
        Intrinsics.checkNotNullParameter(rememberManager, "<anonymous parameter 2>");
        MovableContentState movableContentState = this.$resolvedState;
        if (movableContentState == null && (movableContentState = ComposerImpl.access$getParentContext$p(this.this$0).movableContentStateResolve$runtime_release(this.$from)) == null) {
            ComposerKt.composeRuntimeError("Could not resolve state for movable content");
            throw new KotlinNothingValueException();
        }
        List moveIntoGroupFrom = slotWriter.moveIntoGroupFrom(1, movableContentState.getSlotTable$runtime_release(), 2);
        if (!moveIntoGroupFrom.isEmpty()) {
            ControlledComposition composition$runtime_release = this.$to.getComposition$runtime_release();
            Intrinsics.checkNotNull(composition$runtime_release, "null cannot be cast to non-null type androidx.compose.runtime.CompositionImpl");
            CompositionImpl compositionImpl = (CompositionImpl) composition$runtime_release;
            int size = moveIntoGroupFrom.size();
            for (int i = 0; i < size; i++) {
                Object slot = slotWriter.slot((Anchor) moveIntoGroupFrom.get(i), 0);
                RecomposeScopeImpl recomposeScopeImpl = slot instanceof RecomposeScopeImpl ? (RecomposeScopeImpl) slot : null;
                if (recomposeScopeImpl != null) {
                    recomposeScopeImpl.adoptedBy(compositionImpl);
                }
            }
        }
    }
}
