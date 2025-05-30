package androidx.compose.runtime;

import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class ComposerImpl$insertMovableContentGuarded$1$1$3 extends Lambda implements Function3<Applier<?>, SlotWriter, RememberManager, Unit> {
    final /* synthetic */ Ref.IntRef $effectiveNodeIndex;
    final /* synthetic */ List<Object> $nodesToInsert;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ComposerImpl$insertMovableContentGuarded$1$1$3(Ref.IntRef intRef, List<? extends Object> list) {
        super(3);
        this.$effectiveNodeIndex = intRef;
        this.$nodesToInsert = list;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        invoke((Applier<?>) obj, (SlotWriter) obj2, (RememberManager) obj3);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull Applier<?> applier, @NotNull SlotWriter slotWriter, @NotNull RememberManager rememberManager) {
        Intrinsics.checkNotNullParameter(applier, "applier");
        Intrinsics.checkNotNullParameter(slotWriter, "<anonymous parameter 1>");
        Intrinsics.checkNotNullParameter(rememberManager, "<anonymous parameter 2>");
        int i = this.$effectiveNodeIndex.element;
        List<Object> list = this.$nodesToInsert;
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            Object obj = list.get(i2);
            int i3 = i + i2;
            applier.insertBottomUp(i3, obj);
            applier.insertTopDown(i3, obj);
        }
    }
}
