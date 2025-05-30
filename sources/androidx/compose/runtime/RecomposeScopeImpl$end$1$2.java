package androidx.compose.runtime;

import androidx.compose.runtime.collection.IdentityArrayIntMap;
import androidx.compose.runtime.collection.IdentityArrayMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class RecomposeScopeImpl$end$1$2 extends Lambda implements Function1<Composition, Unit> {
    final /* synthetic */ IdentityArrayIntMap $instances;
    final /* synthetic */ int $token;
    final /* synthetic */ RecomposeScopeImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    RecomposeScopeImpl$end$1$2(RecomposeScopeImpl recomposeScopeImpl, int i, IdentityArrayIntMap identityArrayIntMap) {
        super(1);
        this.this$0 = recomposeScopeImpl;
        this.$token = i;
        this.$instances = identityArrayIntMap;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Composition) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull Composition composition) {
        Intrinsics.checkNotNullParameter(composition, "composition");
        if (RecomposeScopeImpl.access$getCurrentToken$p(this.this$0) == this.$token && Intrinsics.areEqual(this.$instances, RecomposeScopeImpl.access$getTrackedInstances$p(this.this$0)) && (composition instanceof CompositionImpl)) {
            IdentityArrayIntMap identityArrayIntMap = this.$instances;
            int i = this.$token;
            RecomposeScopeImpl recomposeScopeImpl = this.this$0;
            int size = identityArrayIntMap.getSize();
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                Object obj = identityArrayIntMap.getKeys()[i3];
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Any");
                int i4 = identityArrayIntMap.getValues()[i3];
                boolean z = i4 != i;
                if (z) {
                    CompositionImpl compositionImpl = (CompositionImpl) composition;
                    compositionImpl.removeObservation$runtime_release(obj, recomposeScopeImpl);
                    DerivedState<?> derivedState = obj instanceof DerivedState ? (DerivedState) obj : null;
                    if (derivedState != null) {
                        compositionImpl.removeDerivedStateObservation$runtime_release(derivedState);
                        IdentityArrayMap access$getTrackedDependencies$p = RecomposeScopeImpl.access$getTrackedDependencies$p(recomposeScopeImpl);
                        if (access$getTrackedDependencies$p != null) {
                            access$getTrackedDependencies$p.remove(derivedState);
                            if (access$getTrackedDependencies$p.getSize$runtime_release() == 0) {
                                RecomposeScopeImpl.access$setTrackedDependencies$p(recomposeScopeImpl, (IdentityArrayMap) null);
                            }
                        }
                    }
                }
                if (!z) {
                    if (i2 != i3) {
                        identityArrayIntMap.getKeys()[i2] = obj;
                        identityArrayIntMap.getValues()[i2] = i4;
                    }
                    i2++;
                }
            }
            int size2 = identityArrayIntMap.getSize();
            for (int i5 = i2; i5 < size2; i5++) {
                identityArrayIntMap.getKeys()[i5] = null;
            }
            identityArrayIntMap.setSize(i2);
            if (this.$instances.getSize() == 0) {
                RecomposeScopeImpl.access$setTrackedInstances$p(this.this$0, (IdentityArrayIntMap) null);
            }
        }
    }
}
