package androidx.compose.runtime;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.hu2;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public interface MonotonicFrameClock extends CoroutineContext.Element {

    @NotNull
    public static final Key Key = Key.$$INSTANCE;

    /* compiled from: Taobao */
    public static final class DefaultImpls {
        public static <R> R fold(@NotNull MonotonicFrameClock monotonicFrameClock, R r, @NotNull Function2<? super R, ? super CoroutineContext.Element, ? extends R> function2) {
            Intrinsics.checkNotNullParameter(function2, "operation");
            return (R) CoroutineContext.Element.DefaultImpls.fold(monotonicFrameClock, r, function2);
        }

        @Nullable
        public static <E extends CoroutineContext.Element> E get(@NotNull MonotonicFrameClock monotonicFrameClock, @NotNull CoroutineContext.Key<E> key) {
            Intrinsics.checkNotNullParameter(key, "key");
            return (E) CoroutineContext.Element.DefaultImpls.get(monotonicFrameClock, key);
        }

        @Deprecated
        @NotNull
        public static CoroutineContext.Key<?> getKey(@NotNull MonotonicFrameClock monotonicFrameClock) {
            return hu2.b(monotonicFrameClock);
        }

        @NotNull
        public static CoroutineContext minusKey(@NotNull MonotonicFrameClock monotonicFrameClock, @NotNull CoroutineContext.Key<?> key) {
            Intrinsics.checkNotNullParameter(key, "key");
            return CoroutineContext.Element.DefaultImpls.minusKey(monotonicFrameClock, key);
        }

        @NotNull
        public static CoroutineContext plus(@NotNull MonotonicFrameClock monotonicFrameClock, @NotNull CoroutineContext coroutineContext) {
            Intrinsics.checkNotNullParameter(coroutineContext, "context");
            return CoroutineContext.Element.DefaultImpls.plus(monotonicFrameClock, coroutineContext);
        }
    }

    /* compiled from: Taobao */
    public static final class Key implements CoroutineContext.Key<MonotonicFrameClock> {
        static final /* synthetic */ Key $$INSTANCE = new Key();

        private Key() {
        }
    }

    @NotNull
    CoroutineContext.Key<?> getKey();

    @Nullable
    <R> Object withFrameNanos(@NotNull Function1<? super Long, ? extends R> function1, @NotNull Continuation<? super R> continuation);
}
