package androidx.compose.ui.platform;

import android.view.View;
import androidx.compose.runtime.Recomposer;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class WindowRecomposer_androidKt$createLifecycleAwareWindowRecomposer$1 implements View.OnAttachStateChangeListener {
    final /* synthetic */ Recomposer $recomposer;
    final /* synthetic */ View $this_createLifecycleAwareWindowRecomposer;

    WindowRecomposer_androidKt$createLifecycleAwareWindowRecomposer$1(View view, Recomposer recomposer) {
        this.$this_createLifecycleAwareWindowRecomposer = view;
        this.$recomposer = recomposer;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "v");
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "v");
        this.$this_createLifecycleAwareWindowRecomposer.removeOnAttachStateChangeListener(this);
        this.$recomposer.cancel();
    }
}
