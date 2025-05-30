package androidx.lifecycle;

import androidx.core.app.NotificationCompat;
import androidx.lifecycle.Lifecycle;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class CompositeGeneratedAdaptersObserver implements LifecycleEventObserver {

    @NotNull
    private final GeneratedAdapter[] generatedAdapters;

    public CompositeGeneratedAdaptersObserver(@NotNull GeneratedAdapter[] generatedAdapterArr) {
        Intrinsics.checkNotNullParameter(generatedAdapterArr, "generatedAdapters");
        this.generatedAdapters = generatedAdapterArr;
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    public void onStateChanged(@NotNull LifecycleOwner lifecycleOwner, @NotNull Lifecycle.Event event) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "source");
        Intrinsics.checkNotNullParameter(event, NotificationCompat.CATEGORY_EVENT);
        MethodCallsLogger methodCallsLogger = new MethodCallsLogger();
        for (GeneratedAdapter generatedAdapter : this.generatedAdapters) {
            generatedAdapter.callMethods(lifecycleOwner, event, false, methodCallsLogger);
        }
        for (GeneratedAdapter generatedAdapter2 : this.generatedAdapters) {
            generatedAdapter2.callMethods(lifecycleOwner, event, true, methodCallsLogger);
        }
    }
}
