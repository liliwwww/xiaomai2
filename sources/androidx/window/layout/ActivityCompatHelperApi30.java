package androidx.window.layout;

import android.app.Activity;
import android.graphics.Rect;
import androidx.annotation.RequiresApi;
import com.alibaba.wireless.security.aopsdk.replace.android.view.WindowMetrics;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@RequiresApi(30)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\t"}, d2 = {"Landroidx/window/layout/ActivityCompatHelperApi30;", "", "Landroid/app/Activity;", "activity", "Landroid/graphics/Rect;", "currentWindowBounds", "maximumWindowBounds", "<init>", "()V", "window_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class ActivityCompatHelperApi30 {

    @NotNull
    public static final ActivityCompatHelperApi30 INSTANCE = new ActivityCompatHelperApi30();

    private ActivityCompatHelperApi30() {
    }

    @NotNull
    public final Rect currentWindowBounds(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Rect bounds = WindowMetrics.getBounds(activity.getWindowManager().getCurrentWindowMetrics());
        Intrinsics.checkNotNullExpressionValue(bounds, "activity.windowManager.currentWindowMetrics.bounds");
        return bounds;
    }

    @NotNull
    public final Rect maximumWindowBounds(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Rect bounds = WindowMetrics.getBounds(activity.getWindowManager().getMaximumWindowMetrics());
        Intrinsics.checkNotNullExpressionValue(bounds, "activity.windowManager.maximumWindowMetrics.bounds");
        return bounds;
    }
}
