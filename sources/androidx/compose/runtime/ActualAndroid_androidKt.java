package androidx.compose.runtime;

import android.util.Log;
import androidx.compose.runtime.snapshots.SnapshotMutableState;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class ActualAndroid_androidKt {

    @NotNull
    private static final Lazy DefaultMonotonicFrameClock$delegate = LazyKt.lazy(DefaultMonotonicFrameClock.2.INSTANCE);
    private static final boolean DisallowDefaultMonotonicFrameClock = false;

    @NotNull
    private static final String LogTag = "ComposeInternal";

    @NotNull
    public static final <T> SnapshotMutableState<T> createSnapshotMutableState(T t, @NotNull SnapshotMutationPolicy<T> snapshotMutationPolicy) {
        Intrinsics.checkNotNullParameter(snapshotMutationPolicy, "policy");
        return new ParcelableSnapshotMutableState(t, snapshotMutationPolicy);
    }

    @NotNull
    public static final MonotonicFrameClock getDefaultMonotonicFrameClock() {
        return (MonotonicFrameClock) DefaultMonotonicFrameClock$delegate.getValue();
    }

    @Deprecated(message = "MonotonicFrameClocks are not globally applicable across platforms. Use an appropriate local clock.")
    public static /* synthetic */ void getDefaultMonotonicFrameClock$annotations() {
    }

    public static final void logError(@NotNull String str, @NotNull Throwable th) {
        Intrinsics.checkNotNullParameter(str, "message");
        Intrinsics.checkNotNullParameter(th, "e");
        Log.e(LogTag, str, th);
    }
}
