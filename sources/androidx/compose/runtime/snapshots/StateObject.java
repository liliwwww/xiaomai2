package androidx.compose.runtime.snapshots;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public interface StateObject {
    @NotNull
    StateRecord getFirstStateRecord();

    @Nullable
    StateRecord mergeRecords(@NotNull StateRecord stateRecord, @NotNull StateRecord stateRecord2, @NotNull StateRecord stateRecord3);

    void prependStateRecord(@NotNull StateRecord stateRecord);
}
