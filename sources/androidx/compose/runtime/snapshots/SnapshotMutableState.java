package androidx.compose.runtime.snapshots;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public interface SnapshotMutableState<T> extends MutableState<T> {
    @NotNull
    SnapshotMutationPolicy<T> getPolicy();
}
