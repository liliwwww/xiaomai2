package androidx.compose.animation.core;

import androidx.compose.runtime.Composer;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
final class Transition$updateTarget$2 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ S $targetState;
    final /* synthetic */ Transition<S> $tmp0_rcvr;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    Transition$updateTarget$2(Transition<S> transition, S s, int i) {
        super(2);
        this.$tmp0_rcvr = transition;
        this.$targetState = s;
        this.$$changed = i;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i) {
        this.$tmp0_rcvr.updateTarget$animation_core_release(this.$targetState, composer, this.$$changed | 1);
    }
}
