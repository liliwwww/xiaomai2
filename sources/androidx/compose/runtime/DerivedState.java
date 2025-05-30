package androidx.compose.runtime;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public interface DerivedState<T> extends State<T> {
    T getCurrentValue();

    @NotNull
    Object[] getDependencies();

    @Nullable
    SnapshotMutationPolicy<T> getPolicy();
}
