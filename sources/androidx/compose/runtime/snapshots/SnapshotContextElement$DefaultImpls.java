package androidx.compose.runtime.snapshots;

import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class SnapshotContextElement$DefaultImpls {
    public static <R> R fold(@NotNull SnapshotContextElement snapshotContextElement, R r, @NotNull Function2<? super R, ? super CoroutineContext.Element, ? extends R> function2) {
        Intrinsics.checkNotNullParameter(function2, "operation");
        return (R) CoroutineContext.Element.DefaultImpls.fold(snapshotContextElement, r, function2);
    }

    @Nullable
    public static <E extends CoroutineContext.Element> E get(@NotNull SnapshotContextElement snapshotContextElement, @NotNull CoroutineContext.Key<E> key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return (E) CoroutineContext.Element.DefaultImpls.get(snapshotContextElement, key);
    }

    @NotNull
    public static CoroutineContext minusKey(@NotNull SnapshotContextElement snapshotContextElement, @NotNull CoroutineContext.Key<?> key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return CoroutineContext.Element.DefaultImpls.minusKey(snapshotContextElement, key);
    }

    @NotNull
    public static CoroutineContext plus(@NotNull SnapshotContextElement snapshotContextElement, @NotNull CoroutineContext coroutineContext) {
        Intrinsics.checkNotNullParameter(coroutineContext, "context");
        return CoroutineContext.Element.DefaultImpls.plus(snapshotContextElement, coroutineContext);
    }
}
