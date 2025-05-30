package kotlinx.coroutines.flow;

import android.graphics.Rect;
import androidx.annotation.RestrictTo;
import androidx.annotation.RestrictTo$Scope;
import androidx.window.core.Bounds;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0000\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u0010\u0010\u0011B\u0011\b\u0017\u0012\u0006\u0010\u000f\u001a\u00020\f¢\u0006\u0004\b\u0010\u0010\u0012J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0013\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\b\u001a\u00020\u0007H\u0016R\u0016\u0010\n\u001a\u00020\t8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0013\u0010\u000f\u001a\u00020\f8F@\u0006¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e¨\u0006\u0013"}, d2 = {"Landroidx/window/layout/WindowMetrics;", "", "", "toString", "other", "", "equals", "", "hashCode", "Landroidx/window/core/Bounds;", "_bounds", "Landroidx/window/core/Bounds;", "Landroid/graphics/Rect;", "getBounds", "()Landroid/graphics/Rect;", "bounds", "<init>", "(Landroidx/window/core/Bounds;)V", "(Landroid/graphics/Rect;)V", "window_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class WindowMetrics {

    @NotNull
    private final Bounds _bounds;

    public WindowMetrics(@NotNull Bounds bounds) {
        Intrinsics.checkNotNullParameter(bounds, "_bounds");
        this._bounds = bounds;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || !Intrinsics.areEqual(WindowMetrics.class, other.getClass())) {
            return false;
        }
        return Intrinsics.areEqual(this._bounds, ((WindowMetrics) other)._bounds);
    }

    @NotNull
    public final Rect getBounds() {
        return this._bounds.toRect();
    }

    public int hashCode() {
        return this._bounds.hashCode();
    }

    @NotNull
    public String toString() {
        return "WindowMetrics { bounds: " + getBounds() + " }";
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @RestrictTo({RestrictTo$Scope.TESTS})
    public WindowMetrics(@NotNull Rect rect) {
        this(new Bounds(rect));
        Intrinsics.checkNotNullParameter(rect, "bounds");
    }
}
