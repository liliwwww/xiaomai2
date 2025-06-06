package androidx.compose.animation.core;

import androidx.compose.runtime.MonotonicFrameClockKt;
import androidx.compose.ui.platform.InfiniteAnimationPolicy;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class InfiniteAnimationPolicyKt {
    @Nullable
    public static final <R> Object withInfiniteAnimationFrameMillis(@NotNull Function1<? super Long, ? extends R> function1, @NotNull Continuation<? super R> continuation) {
        return withInfiniteAnimationFrameNanos(new InfiniteAnimationPolicyKt$withInfiniteAnimationFrameMillis$2(function1), continuation);
    }

    private static final <R> Object withInfiniteAnimationFrameMillis$$forInline(Function1<? super Long, ? extends R> function1, Continuation<? super R> continuation) {
        InfiniteAnimationPolicyKt$withInfiniteAnimationFrameMillis$2 infiniteAnimationPolicyKt$withInfiniteAnimationFrameMillis$2 = new InfiniteAnimationPolicyKt$withInfiniteAnimationFrameMillis$2(function1);
        InlineMarker.mark(0);
        Object withInfiniteAnimationFrameNanos = withInfiniteAnimationFrameNanos(infiniteAnimationPolicyKt$withInfiniteAnimationFrameMillis$2, continuation);
        InlineMarker.mark(1);
        return withInfiniteAnimationFrameNanos;
    }

    @Nullable
    public static final <R> Object withInfiniteAnimationFrameNanos(@NotNull Function1<? super Long, ? extends R> function1, @NotNull Continuation<? super R> continuation) {
        InfiniteAnimationPolicy infiniteAnimationPolicy = continuation.getContext().get(InfiniteAnimationPolicy.Key);
        return infiniteAnimationPolicy == null ? MonotonicFrameClockKt.withFrameNanos(function1, continuation) : infiniteAnimationPolicy.onInfiniteOperation(new withInfiniteAnimationFrameNanos.2(function1, (Continuation) null), continuation);
    }
}
