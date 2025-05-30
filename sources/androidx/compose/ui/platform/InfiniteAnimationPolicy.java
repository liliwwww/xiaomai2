package androidx.compose.ui.platform;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public interface InfiniteAnimationPolicy extends CoroutineContext.Element {

    @NotNull
    public static final Key Key = Key.$$INSTANCE;

    @NotNull
    CoroutineContext.Key<?> getKey();

    @Nullable
    <R> Object onInfiniteOperation(@NotNull Function1<? super Continuation<? super R>, ? extends Object> function1, @NotNull Continuation<? super R> continuation);
}
