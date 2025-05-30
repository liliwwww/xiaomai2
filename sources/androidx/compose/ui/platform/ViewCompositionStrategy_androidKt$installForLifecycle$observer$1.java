package androidx.compose.ui.platform;

import androidx.core.app.NotificationCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
final class ViewCompositionStrategy_androidKt$installForLifecycle$observer$1 implements LifecycleEventObserver {
    final /* synthetic */ AbstractComposeView $view;

    ViewCompositionStrategy_androidKt$installForLifecycle$observer$1(AbstractComposeView abstractComposeView) {
        this.$view = abstractComposeView;
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    public final void onStateChanged(@NotNull LifecycleOwner lifecycleOwner, @NotNull Lifecycle.Event event) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(event, NotificationCompat.CATEGORY_EVENT);
        if (event == Lifecycle.Event.ON_DESTROY) {
            this.$view.disposeComposition();
        }
    }
}
