package androidx.compose.foundation.text.selection;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public abstract class SelectionMode {
    public static final SelectionMode Vertical = new SelectionMode("Vertical", 0) { // from class: androidx.compose.foundation.text.selection.SelectionMode.Vertical
        {
            DefaultConstructorMarker defaultConstructorMarker = null;
        }

        @Override // androidx.compose.foundation.text.selection.SelectionMode
        /* renamed from: compare-3MmeM6k$foundation_release */
        public int mo473compare3MmeM6k$foundation_release(long j, @NotNull Rect rect) {
            Intrinsics.checkNotNullParameter(rect, "bounds");
            if (rect.m860containsk4lQ0M(j)) {
                return 0;
            }
            if (Offset.m849getYimpl(j) < rect.getTop()) {
                return -1;
            }
            return (Offset.m848getXimpl(j) >= rect.getLeft() || Offset.m849getYimpl(j) >= rect.getBottom()) ? 1 : -1;
        }
    };
    public static final SelectionMode Horizontal = new Horizontal("Horizontal", 1);
    private static final /* synthetic */ SelectionMode[] $VALUES = $values();

    private static final /* synthetic */ SelectionMode[] $values() {
        return new SelectionMode[]{Vertical, Horizontal};
    }

    private SelectionMode(String str, int i) {
    }

    public /* synthetic */ SelectionMode(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, i);
    }

    public static SelectionMode valueOf(String str) {
        return (SelectionMode) Enum.valueOf(SelectionMode.class, str);
    }

    public static SelectionMode[] values() {
        return (SelectionMode[]) $VALUES.clone();
    }

    /* renamed from: compare-3MmeM6k$foundation_release, reason: not valid java name */
    public abstract int mo473compare3MmeM6k$foundation_release(long j, @NotNull Rect rect);

    /* renamed from: isSelected-2x9bVx0$foundation_release, reason: not valid java name */
    public final boolean m474isSelected2x9bVx0$foundation_release(@NotNull Rect rect, long j, long j2) {
        Intrinsics.checkNotNullParameter(rect, "bounds");
        if (rect.m860containsk4lQ0M(j) || rect.m860containsk4lQ0M(j2)) {
            return true;
        }
        return (mo473compare3MmeM6k$foundation_release(j, rect) > 0) ^ (mo473compare3MmeM6k$foundation_release(j2, rect) > 0);
    }
}
