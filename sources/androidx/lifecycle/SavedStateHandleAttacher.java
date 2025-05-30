package androidx.lifecycle;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class SavedStateHandleAttacher implements LifecycleEventObserver {

    @NotNull
    private final SavedStateHandlesProvider provider;

    public SavedStateHandleAttacher(@NotNull SavedStateHandlesProvider savedStateHandlesProvider) {
        Intrinsics.checkNotNullParameter(savedStateHandlesProvider, "provider");
        this.provider = savedStateHandlesProvider;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onStateChanged(@NotNull LifecycleOwner lifecycleOwner, @NotNull Lifecycle$Event lifecycle$Event) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "source");
        Intrinsics.checkNotNullParameter(lifecycle$Event, "event");
        if (lifecycle$Event == Lifecycle$Event.ON_CREATE) {
            lifecycleOwner.getLifecycle().removeObserver(this);
            this.provider.performRestore();
        } else {
            throw new IllegalStateException(("Next event must be ON_CREATE, it was " + lifecycle$Event).toString());
        }
    }
}
