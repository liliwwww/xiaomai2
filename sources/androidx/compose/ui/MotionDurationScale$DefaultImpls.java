package androidx.compose.ui;

import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class MotionDurationScale$DefaultImpls {
    public static <R> R fold(@NotNull MotionDurationScale motionDurationScale, R r, @NotNull Function2<? super R, ? super CoroutineContext.Element, ? extends R> function2) {
        Intrinsics.checkNotNullParameter(function2, "operation");
        return (R) CoroutineContext.Element.DefaultImpls.fold(motionDurationScale, r, function2);
    }

    @Nullable
    public static <E extends CoroutineContext.Element> E get(@NotNull MotionDurationScale motionDurationScale, @NotNull CoroutineContext.Key<E> key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return (E) CoroutineContext.Element.DefaultImpls.get(motionDurationScale, key);
    }

    @NotNull
    public static CoroutineContext minusKey(@NotNull MotionDurationScale motionDurationScale, @NotNull CoroutineContext.Key<?> key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return CoroutineContext.Element.DefaultImpls.minusKey(motionDurationScale, key);
    }

    @NotNull
    public static CoroutineContext plus(@NotNull MotionDurationScale motionDurationScale, @NotNull CoroutineContext coroutineContext) {
        Intrinsics.checkNotNullParameter(coroutineContext, "context");
        return CoroutineContext.Element.DefaultImpls.plus(motionDurationScale, coroutineContext);
    }
}
