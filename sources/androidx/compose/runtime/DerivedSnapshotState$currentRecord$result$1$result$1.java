package androidx.compose.runtime;

import androidx.compose.runtime.collection.IdentityArrayMap;
import androidx.compose.runtime.snapshots.StateObject;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class DerivedSnapshotState$currentRecord$result$1$result$1 extends Lambda implements Function1<Object, Unit> {
    final /* synthetic */ int $nestedCalculationLevel;
    final /* synthetic */ IdentityArrayMap<StateObject, Integer> $newDependencies;
    final /* synthetic */ DerivedSnapshotState<T> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DerivedSnapshotState$currentRecord$result$1$result$1(DerivedSnapshotState<T> derivedSnapshotState, IdentityArrayMap<StateObject, Integer> identityArrayMap, int i) {
        super(1);
        this.this$0 = derivedSnapshotState;
        this.$newDependencies = identityArrayMap;
        this.$nestedCalculationLevel = i;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        m903invoke(obj);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: collision with other method in class */
    public final void m903invoke(@NotNull Object obj) {
        Intrinsics.checkNotNullParameter(obj, "it");
        if (obj == this.this$0) {
            throw new IllegalStateException("A derived state calculation cannot read itself".toString());
        }
        if (obj instanceof StateObject) {
            Object obj2 = SnapshotStateKt__DerivedStateKt.access$getCalculationBlockNestedLevel$p().get();
            Intrinsics.checkNotNull(obj2);
            int intValue = ((Number) obj2).intValue();
            IdentityArrayMap<StateObject, Integer> identityArrayMap = this.$newDependencies;
            int i = intValue - this.$nestedCalculationLevel;
            Integer num = (Integer) identityArrayMap.get(obj);
            identityArrayMap.set(obj, Integer.valueOf(Math.min(i, num != null ? num.intValue() : Integer.MAX_VALUE)));
        }
    }
}
