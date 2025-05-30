package androidx.compose.runtime.saveable;

import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class ListSaverKt {
    @NotNull
    public static final <Original, Saveable> Saver<Original, Object> listSaver(@NotNull Function2<? super SaverScope, ? super Original, ? extends List<? extends Saveable>> function2, @NotNull Function1<? super List<? extends Saveable>, ? extends Original> function1) {
        Intrinsics.checkNotNullParameter(function2, "save");
        Intrinsics.checkNotNullParameter(function1, "restore");
        return SaverKt.Saver(new listSaver.1(function2), (Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(function1, 1));
    }
}
