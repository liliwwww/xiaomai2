package androidx.compose.runtime.tooling;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public interface CompositionGroup extends CompositionData {
    @NotNull
    Iterable<Object> getData();

    int getGroupSize();

    @Nullable
    Object getIdentity();

    @NotNull
    Object getKey();

    @Nullable
    Object getNode();

    int getSlotsSize();

    @Nullable
    String getSourceInfo();
}
