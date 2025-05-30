package androidx.compose.foundation;

import androidx.compose.runtime.Immutable;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.unit.Dp;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@Immutable
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class BorderStroke {

    @NotNull
    private final Brush brush;
    private final float width;

    private BorderStroke(float f, Brush brush) {
        this.width = f;
        this.brush = brush;
    }

    public /* synthetic */ BorderStroke(float f, Brush brush, DefaultConstructorMarker defaultConstructorMarker) {
        this(f, brush);
    }

    /* renamed from: copy-D5KLDUw$default, reason: not valid java name */
    public static /* synthetic */ BorderStroke m124copyD5KLDUw$default(BorderStroke borderStroke, float f, Brush brush, int i, Object obj) {
        if ((i & 1) != 0) {
            f = borderStroke.width;
        }
        if ((i & 2) != 0) {
            brush = borderStroke.brush;
        }
        return borderStroke.m125copyD5KLDUw(f, brush);
    }

    @NotNull
    /* renamed from: copy-D5KLDUw, reason: not valid java name */
    public final BorderStroke m125copyD5KLDUw(float f, @NotNull Brush brush) {
        Intrinsics.checkNotNullParameter(brush, "brush");
        return new BorderStroke(f, brush, null);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BorderStroke)) {
            return false;
        }
        BorderStroke borderStroke = (BorderStroke) obj;
        return Dp.equals-impl0(this.width, borderStroke.width) && Intrinsics.areEqual(this.brush, borderStroke.brush);
    }

    @NotNull
    public final Brush getBrush() {
        return this.brush;
    }

    /* renamed from: getWidth-D9Ej5fM, reason: not valid java name */
    public final float m126getWidthD9Ej5fM() {
        return this.width;
    }

    public int hashCode() {
        return (Dp.hashCode-impl(this.width) * 31) + this.brush.hashCode();
    }

    @NotNull
    public String toString() {
        return "BorderStroke(width=" + ((Object) Dp.toString-impl(this.width)) + ", brush=" + this.brush + ')';
    }
}
