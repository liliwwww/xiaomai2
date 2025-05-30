package androidx.compose.ui.platform;

import android.taobao.windvane.connect.api.ApiConstants;
import android.view.View;
import androidx.customview.poolingcontainer.PoolingContainer;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class ViewCompositionStrategy$DisposeOnDetachedFromWindowOrReleasedFromPool$installFor$listener$1 implements View.OnAttachStateChangeListener {
    final /* synthetic */ AbstractComposeView $view;

    ViewCompositionStrategy$DisposeOnDetachedFromWindowOrReleasedFromPool$installFor$listener$1(AbstractComposeView abstractComposeView) {
        this.$view = abstractComposeView;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, ApiConstants.V);
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, ApiConstants.V);
        if (PoolingContainer.isWithinPoolingContainer(this.$view)) {
            return;
        }
        this.$view.disposeComposition();
    }
}
