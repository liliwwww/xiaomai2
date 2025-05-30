package androidx.compose.runtime.saveable;

import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Add missing generic type declarations: [Original] */
/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
final class ListSaverKt$listSaver$1<Original> extends Lambda implements Function2<SaverScope, Original, Object> {
    final /* synthetic */ Function2<SaverScope, Original, List<Saveable>> $save;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ListSaverKt$listSaver$1(Function2<? super SaverScope, ? super Original, ? extends List<? extends Saveable>> function2) {
        super(2);
        this.$save = function2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return invoke((SaverScope) obj, (SaverScope) obj2);
    }

    @Nullable
    public final Object invoke(@NotNull SaverScope saverScope, Original original) {
        Intrinsics.checkNotNullParameter(saverScope, "$this$Saver");
        List list = (List) this.$save.invoke(saverScope, original);
        int size = list.size();
        for (int i = 0; i < size; i++) {
            Object obj = list.get(i);
            if (obj != null && !saverScope.canBeSaved(obj)) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
        }
        if (!list.isEmpty()) {
            return new ArrayList(list);
        }
        return null;
    }
}
