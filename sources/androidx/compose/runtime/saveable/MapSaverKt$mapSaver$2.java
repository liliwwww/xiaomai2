package androidx.compose.runtime.saveable;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class MapSaverKt$mapSaver$2<T> extends Lambda implements Function1<List<? extends Object>, T> {
    final /* synthetic */ Function1<Map<String, ? extends Object>, T> $restore;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    MapSaverKt$mapSaver$2(Function1<? super Map<String, ? extends Object>, ? extends T> function1) {
        super(1);
        this.$restore = function1;
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
        return (T) this.$restore.invoke(linkedHashMap);
    }
}
