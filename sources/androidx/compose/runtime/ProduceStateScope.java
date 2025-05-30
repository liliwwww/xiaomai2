package androidx.compose.runtime;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public interface ProduceStateScope<T> extends MutableState<T>, CoroutineScope {
    @Nullable
    Object awaitDispose(@NotNull Function0<Unit> function0, @NotNull Continuation<?> continuation);
}
