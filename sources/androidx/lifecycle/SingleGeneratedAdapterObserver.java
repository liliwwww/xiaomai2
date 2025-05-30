package androidx.lifecycle;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class SingleGeneratedAdapterObserver implements LifecycleEventObserver {

    @NotNull
    private final GeneratedAdapter generatedAdapter;

    public SingleGeneratedAdapterObserver(@NotNull GeneratedAdapter generatedAdapter) {
        Intrinsics.checkNotNullParameter(generatedAdapter, "generatedAdapter");
        this.generatedAdapter = generatedAdapter;
    }

    public void onStateChanged(@NotNull LifecycleOwner lifecycleOwner, @NotNull Lifecycle$Event lifecycle$Event) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "source");
        Intrinsics.checkNotNullParameter(lifecycle$Event, "event");
        this.generatedAdapter.callMethods(lifecycleOwner, lifecycle$Event, false, (MethodCallsLogger) null);
        this.generatedAdapter.callMethods(lifecycleOwner, lifecycle$Event, true, (MethodCallsLogger) null);
    }
}
