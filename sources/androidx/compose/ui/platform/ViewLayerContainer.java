package androidx.compose.ui.platform;

import android.content.Context;
import android.graphics.Canvas;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class ViewLayerContainer extends DrawChildContainer {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ViewLayerContainer(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // androidx.compose.ui.platform.DrawChildContainer, android.view.ViewGroup, android.view.View
    protected void dispatchDraw(@NotNull Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
    }

    protected final void dispatchGetDisplayList() {
    }
}
