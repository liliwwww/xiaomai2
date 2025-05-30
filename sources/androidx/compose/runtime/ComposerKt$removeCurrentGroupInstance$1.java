package androidx.compose.runtime;

import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
final class ComposerKt$removeCurrentGroupInstance$1 extends Lambda implements Function3<Applier<?>, SlotWriter, RememberManager, Unit> {
    public static final ComposerKt$removeCurrentGroupInstance$1 INSTANCE = new ComposerKt$removeCurrentGroupInstance$1();

    ComposerKt$removeCurrentGroupInstance$1() {
        super(3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        invoke((Applier<?>) obj, (SlotWriter) obj2, (RememberManager) obj3);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull Applier<?> applier, @NotNull SlotWriter slotWriter, @NotNull RememberManager rememberManager) {
        Intrinsics.checkNotNullParameter(applier, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(slotWriter, "slots");
        Intrinsics.checkNotNullParameter(rememberManager, "rememberManager");
        ComposerKt.removeCurrentGroup(slotWriter, rememberManager);
    }
}
