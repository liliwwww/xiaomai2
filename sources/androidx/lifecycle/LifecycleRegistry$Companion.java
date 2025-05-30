package androidx.lifecycle;

import androidx.annotation.VisibleForTesting;
import androidx.lifecycle.Lifecycle;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class LifecycleRegistry$Companion {
    private LifecycleRegistry$Companion() {
    }

    public /* synthetic */ LifecycleRegistry$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @JvmStatic
    @VisibleForTesting
    @NotNull
    public final LifecycleRegistry createUnsafe(@NotNull LifecycleOwner lifecycleOwner) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "owner");
        return new LifecycleRegistry(lifecycleOwner, false, (DefaultConstructorMarker) null);
    }

    @JvmStatic
    @NotNull
    public final Lifecycle.State min$lifecycle_runtime_release(@NotNull Lifecycle.State state, @Nullable Lifecycle.State state2) {
        Intrinsics.checkNotNullParameter(state, "state1");
        return (state2 == null || state2.compareTo(state) >= 0) ? state : state2;
    }
}
