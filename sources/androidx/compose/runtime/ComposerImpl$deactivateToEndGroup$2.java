package androidx.compose.runtime;

import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class ComposerImpl$deactivateToEndGroup$2 extends Lambda implements Function2<Integer, Object, Unit> {
    final /* synthetic */ int $group;
    final /* synthetic */ ComposerImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ComposerImpl$deactivateToEndGroup$2(ComposerImpl composerImpl, int i) {
        super(2);
        this.this$0 = composerImpl;
        this.$group = i;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke(((Number) obj).intValue(), obj2);
        return Unit.INSTANCE;
    }

    public final void invoke(int i, @Nullable Object obj) {
        if (obj instanceof RememberObserver) {
            ComposerImpl.access$getReader$p(this.this$0).reposition(this.$group);
            ComposerImpl.recordSlotTableOperation$default(this.this$0, false, new 1(obj, this.$group, i), 1, (Object) null);
        } else if (obj instanceof RecomposeScopeImpl) {
            RecomposeScopeImpl recomposeScopeImpl = (RecomposeScopeImpl) obj;
            CompositionImpl composition = recomposeScopeImpl.getComposition();
            if (composition != null) {
                composition.setPendingInvalidScopes$runtime_release(true);
                recomposeScopeImpl.release();
            }
            ComposerImpl.access$getReader$p(this.this$0).reposition(this.$group);
            ComposerImpl.recordSlotTableOperation$default(this.this$0, false, new 2(obj, this.$group, i), 1, (Object) null);
        }
    }
}
