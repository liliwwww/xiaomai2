package androidx.compose.runtime;

import kotlin.KotlinNothingValueException;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
final class ComposerImpl$deactivateToEndGroup$2$1 extends Lambda implements Function3<Applier<?>, SlotWriter, RememberManager, Unit> {
    final /* synthetic */ Object $data;
    final /* synthetic */ int $group;
    final /* synthetic */ int $index;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ComposerImpl$deactivateToEndGroup$2$1(Object obj, int i, int i2) {
        super(3);
        this.$data = obj;
        this.$group = i;
        this.$index = i2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        invoke((Applier<?>) obj, (SlotWriter) obj2, (RememberManager) obj3);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull Applier<?> applier, @NotNull SlotWriter slotWriter, @NotNull RememberManager rememberManager) {
        Intrinsics.checkNotNullParameter(applier, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(slotWriter, "slots");
        Intrinsics.checkNotNullParameter(rememberManager, "rememberManager");
        if (!Intrinsics.areEqual(this.$data, slotWriter.slot(this.$group, this.$index))) {
            ComposerKt.composeRuntimeError("Slot table is out of sync".toString());
            throw new KotlinNothingValueException();
        }
        rememberManager.forgetting((RememberObserver) this.$data);
        slotWriter.set(this.$index, Composer.Companion.getEmpty());
    }
}
