package androidx.compose.foundation.text.selection;

import androidx.compose.p004ui.geometry.Offset;
import androidx.compose.p004ui.geometry.Rect;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public enum SelectionMode {
    Vertical { // from class: androidx.compose.foundation.text.selection.SelectionMode.Vertical
        @Override // androidx.compose.foundation.text.selection.SelectionMode
        /* renamed from: compare-3MmeM6k$foundation_release */
        public int mo1884compare3MmeM6k$foundation_release(long j, @NotNull Rect rect) {
            Intrinsics.checkNotNullParameter(rect, "bounds");
            if (rect.m2582containsk4lQ0M(j)) {
                return 0;
            }
            if (Offset.m2557getYimpl(j) < rect.getTop()) {
                return -1;
            }
            return (Offset.m2556getXimpl(j) >= rect.getLeft() || Offset.m2557getYimpl(j) >= rect.getBottom()) ? 1 : -1;
        }
    },
    Horizontal { // from class: androidx.compose.foundation.text.selection.SelectionMode.Horizontal
        @Override // androidx.compose.foundation.text.selection.SelectionMode
        /* renamed from: compare-3MmeM6k$foundation_release */
        public int mo1884compare3MmeM6k$foundation_release(long j, @NotNull Rect rect) {
            Intrinsics.checkNotNullParameter(rect, "bounds");
            if (rect.m2582containsk4lQ0M(j)) {
                return 0;
            }
            if (Offset.m2556getXimpl(j) < rect.getLeft()) {
                return -1;
            }
            return (Offset.m2557getYimpl(j) >= rect.getTop() || Offset.m2556getXimpl(j) >= rect.getRight()) ? 1 : -1;
        }
    };

    /* synthetic */ SelectionMode(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* renamed from: compare-3MmeM6k$foundation_release, reason: not valid java name */
    public abstract int mo1884compare3MmeM6k$foundation_release(long j, @NotNull Rect rect);

    /* renamed from: isSelected-2x9bVx0$foundation_release, reason: not valid java name */
    public final boolean m1885isSelected2x9bVx0$foundation_release(@NotNull Rect rect, long j, long j2) {
        Intrinsics.checkNotNullParameter(rect, "bounds");
        if (rect.m2582containsk4lQ0M(j) || rect.m2582containsk4lQ0M(j2)) {
            return true;
        }
        return (mo1884compare3MmeM6k$foundation_release(j, rect) > 0) ^ (mo1884compare3MmeM6k$foundation_release(j2, rect) > 0);
    }
}
