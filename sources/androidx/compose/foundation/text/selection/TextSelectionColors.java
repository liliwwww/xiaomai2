package androidx.compose.foundation.text.selection;

import androidx.compose.runtime.Immutable;
import androidx.compose.ui.graphics.Color;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@Immutable
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class TextSelectionColors {
    private final long backgroundColor;
    private final long handleColor;

    private TextSelectionColors(long j, long j2) {
        this.handleColor = j;
        this.backgroundColor = j2;
    }

    public /* synthetic */ TextSelectionColors(long j, long j2, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TextSelectionColors)) {
            return false;
        }
        TextSelectionColors textSelectionColors = (TextSelectionColors) obj;
        return Color.m1051equalsimpl0(this.handleColor, textSelectionColors.handleColor) && Color.m1051equalsimpl0(this.backgroundColor, textSelectionColors.backgroundColor);
    }

    /* renamed from: getBackgroundColor-0d7_KjU, reason: not valid java name */
    public final long m492getBackgroundColor0d7_KjU() {
        return this.backgroundColor;
    }

    /* renamed from: getHandleColor-0d7_KjU, reason: not valid java name */
    public final long m493getHandleColor0d7_KjU() {
        return this.handleColor;
    }

    public int hashCode() {
        return (Color.m1057hashCodeimpl(this.handleColor) * 31) + Color.m1057hashCodeimpl(this.backgroundColor);
    }

    @NotNull
    public String toString() {
        return "SelectionColors(selectionHandleColor=" + ((Object) Color.m1058toStringimpl(this.handleColor)) + ", selectionBackgroundColor=" + ((Object) Color.m1058toStringimpl(this.backgroundColor)) + ')';
    }
}
