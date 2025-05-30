package androidx.compose.runtime.saveable;

import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public final class ListSaverKt {
    @NotNull
    public static final <Original, Saveable> Saver<Original, Object> listSaver(@NotNull final Function2<? super SaverScope, ? super Original, ? extends List<? extends Saveable>> function2, @NotNull Function1<? super List<? extends Saveable>, ? extends Original> function1) {
        Intrinsics.checkNotNullParameter(function2, "save");
        Intrinsics.checkNotNullParameter(function1, "restore");
        return SaverKt.Saver(new Function2<SaverScope, Original, Object>() { // from class: androidx.compose.runtime.saveable.ListSaverKt$listSaver$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            /* JADX WARN: Multi-variable type inference failed */
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                return invoke((SaverScope) obj, (SaverScope) obj2);
            }

            @Nullable
            public final Object invoke(@NotNull SaverScope saverScope, Original original) {
                Intrinsics.checkNotNullParameter(saverScope, "$this$Saver");
                List list = (List) function2.invoke(saverScope, original);
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
        }, (Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(function1, 1));
    }
}
