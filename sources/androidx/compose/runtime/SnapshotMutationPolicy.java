package androidx.compose.runtime;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.j25;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public interface SnapshotMutationPolicy<T> {

    /* compiled from: Taobao */
    public static final class DefaultImpls {
        @Deprecated
        @Nullable
        public static <T> T merge(@NotNull SnapshotMutationPolicy<T> snapshotMutationPolicy, T t, T t2, T t3) {
            return (T) j25.b(snapshotMutationPolicy, t, t2, t3);
        }
    }

    boolean equivalent(T t, T t2);

    @Nullable
    T merge(T t, T t2, T t3);
}
