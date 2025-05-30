package androidx.compose.runtime.snapshots;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k65;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public interface StateObject {

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public static final class DefaultImpls {
        @Deprecated
        @Nullable
        public static StateRecord mergeRecords(@NotNull StateObject stateObject, @NotNull StateRecord stateRecord, @NotNull StateRecord stateRecord2, @NotNull StateRecord stateRecord3) {
            Intrinsics.checkNotNullParameter(stateRecord, "previous");
            Intrinsics.checkNotNullParameter(stateRecord2, "current");
            Intrinsics.checkNotNullParameter(stateRecord3, "applied");
            return k65.b(stateObject, stateRecord, stateRecord2, stateRecord3);
        }
    }

    @NotNull
    StateRecord getFirstStateRecord();

    @Nullable
    StateRecord mergeRecords(@NotNull StateRecord stateRecord, @NotNull StateRecord stateRecord2, @NotNull StateRecord stateRecord3);

    void prependStateRecord(@NotNull StateRecord stateRecord);
}
