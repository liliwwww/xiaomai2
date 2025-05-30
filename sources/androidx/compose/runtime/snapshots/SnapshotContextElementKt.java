package androidx.compose.runtime.snapshots;

import androidx.compose.runtime.ExperimentalComposeApi;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public final class SnapshotContextElementKt {
    @ExperimentalComposeApi
    @NotNull
    public static final SnapshotContextElement asContextElement(@NotNull Snapshot snapshot) {
        Intrinsics.checkNotNullParameter(snapshot, "<this>");
        return new SnapshotContextElementImpl(snapshot);
    }
}
