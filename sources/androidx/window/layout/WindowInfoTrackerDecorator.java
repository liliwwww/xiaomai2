package androidx.window.layout;

import androidx.annotation.RestrictTo;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H'¨\u0006\u0005"}, d2 = {"Landroidx/window/layout/WindowInfoTrackerDecorator;", "", "Landroidx/window/layout/WindowInfoTracker;", "tracker", "decorate", "window_release"}, k = 1, mv = {1, 5, 1})
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public interface WindowInfoTrackerDecorator {
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @NotNull
    WindowInfoTracker decorate(@NotNull WindowInfoTracker tracker);
}
