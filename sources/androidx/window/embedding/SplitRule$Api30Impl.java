package androidx.window.embedding;

import android.graphics.Rect;
import android.view.WindowMetrics;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@RequiresApi(30)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¨\u0006\b"}, d2 = {"Landroidx/window/embedding/SplitRule$Api30Impl;", "", "Landroid/view/WindowMetrics;", "windowMetrics", "Landroid/graphics/Rect;", "getBounds", "<init>", "()V", "window_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class SplitRule$Api30Impl {

    @NotNull
    public static final SplitRule$Api30Impl INSTANCE = new SplitRule$Api30Impl();

    private SplitRule$Api30Impl() {
    }

    @DoNotInline
    @NotNull
    public final Rect getBounds(@NotNull WindowMetrics windowMetrics) {
        Intrinsics.checkNotNullParameter(windowMetrics, "windowMetrics");
        Rect bounds = com.alibaba.wireless.security.aopsdk.replace.android.view.WindowMetrics.getBounds(windowMetrics);
        Intrinsics.checkNotNullExpressionValue(bounds, "windowMetrics.bounds");
        return bounds;
    }
}
