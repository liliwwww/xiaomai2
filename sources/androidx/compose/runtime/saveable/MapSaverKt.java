package androidx.compose.runtime.saveable;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public final class MapSaverKt {
    @NotNull
    public static final <T> Saver<T, Object> mapSaver(@NotNull final Function2<? super SaverScope, ? super T, ? extends Map<String, ? extends Object>> function2, @NotNull final Function1<? super Map<String, ? extends Object>, ? extends T> function1) {
        Intrinsics.checkNotNullParameter(function2, "save");
        Intrinsics.checkNotNullParameter(function1, "restore");
        return ListSaverKt.listSaver(new Function2<SaverScope, T, List<? extends Object>>() { // from class: androidx.compose.runtime.saveable.MapSaverKt$mapSaver$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            /* JADX WARN: Multi-variable type inference failed */
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                return invoke((SaverScope) obj, (SaverScope) obj2);
            }

            @NotNull
            public final List<Object> invoke(@NotNull SaverScope saverScope, T t) {
                Intrinsics.checkNotNullParameter(saverScope, "$this$listSaver");
                ArrayList arrayList = new ArrayList();
                for (Map.Entry entry : ((Map) function2.invoke(saverScope, t)).entrySet()) {
                    arrayList.add(entry.getKey());
                    arrayList.add(entry.getValue());
                }
                return arrayList;
            }
        }, new Function1<List<? extends Object>, T>() { // from class: androidx.compose.runtime.saveable.MapSaverKt$mapSaver$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Nullable
            public final T invoke(@NotNull List<? extends Object> list) {
                Intrinsics.checkNotNullParameter(list, "list");
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                if (!(list.size() % 2 == 0)) {
                    throw new IllegalStateException("Check failed.".toString());
                }
                for (int i = 0; i < list.size(); i += 2) {
                    Object obj = list.get(i);
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                    linkedHashMap.put((String) obj, list.get(i + 1));
                }
                return (T) function1.invoke(linkedHashMap);
            }
        });
    }
}
