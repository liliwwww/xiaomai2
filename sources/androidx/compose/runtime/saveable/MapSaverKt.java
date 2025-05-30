package androidx.compose.runtime.saveable;

import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class MapSaverKt {
    @NotNull
    public static final <T> Saver<T, Object> mapSaver(@NotNull Function2<? super SaverScope, ? super T, ? extends Map<String, ? extends Object>> function2, @NotNull Function1<? super Map<String, ? extends Object>, ? extends T> function1) {
        Intrinsics.checkNotNullParameter(function2, "save");
        Intrinsics.checkNotNullParameter(function1, "restore");
        return ListSaverKt.listSaver(new mapSaver.1(function2), new mapSaver.2(function1));
    }
}
