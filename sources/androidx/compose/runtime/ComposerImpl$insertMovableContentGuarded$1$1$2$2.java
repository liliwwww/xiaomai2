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
final class ComposerImpl$insertMovableContentGuarded$1$1$2$2 extends Lambda implements Function3<Applier<?>, SlotWriter, RememberManager, Unit> {
    final /* synthetic */ Ref.IntRef $effectiveNodeIndex;
    final /* synthetic */ List<Function3<Applier<?>, SlotWriter, RememberManager, Unit>> $offsetChanges;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ComposerImpl$insertMovableContentGuarded$1$1$2$2(Ref.IntRef intRef, List<Function3<Applier<?>, SlotWriter, RememberManager, Unit>> list) {
        super(3);
        this.$effectiveNodeIndex = intRef;
        this.$offsetChanges = list;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        invoke((Applier<?>) obj, (SlotWriter) obj2, (RememberManager) obj3);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull Applier<?> applier, @NotNull SlotWriter slotWriter, @NotNull RememberManager rememberManager) {
        Intrinsics.checkNotNullParameter(applier, "applier");
        Intrinsics.checkNotNullParameter(slotWriter, "slots");
        Intrinsics.checkNotNullParameter(rememberManager, "rememberManager");
        int i = this.$effectiveNodeIndex.element;
        if (i > 0) {
            applier = new OffsetApplier<>(applier, i);
        }
        List<Function3<Applier<?>, SlotWriter, RememberManager, Unit>> list = this.$offsetChanges;
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            list.get(i2).invoke(applier, slotWriter, rememberManager);
        }
    }
}
