package androidx.compose.foundation.text.selection;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class SelectionMode$Horizontal extends SelectionMode {
    SelectionMode$Horizontal(String str, int i) {
        super(str, i, (DefaultConstructorMarker) null);
    }

    /* renamed from: compare-3MmeM6k$foundation_release, reason: not valid java name */
    public int m642compare3MmeM6k$foundation_release(long j, @NotNull Rect rect) {
        Intrinsics.checkNotNullParameter(rect, "bounds");
        if (rect.contains-k-4lQ0M(j)) {
            return 0;
        }
        if (Offset.getX-impl(j) < rect.getLeft()) {
            return -1;
        }
        return (Offset.getY-impl(j) >= rect.getTop() || Offset.getX-impl(j) >= rect.getRight()) ? 1 : -1;
    }
}
