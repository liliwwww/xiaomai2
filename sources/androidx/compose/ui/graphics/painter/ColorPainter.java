package androidx.compose.ui.graphics.painter;

import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.w51;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class ColorPainter extends Painter {
    private float alpha;
    private final long color;

    @Nullable
    private ColorFilter colorFilter;
    private final long intrinsicSize;

    private ColorPainter(long j) {
        this.color = j;
        this.alpha = 1.0f;
        this.intrinsicSize = Size.Companion.m911getUnspecifiedNHjbRc();
    }

    public /* synthetic */ ColorPainter(long j, DefaultConstructorMarker defaultConstructorMarker) {
        this(j);
    }

    @Override // androidx.compose.ui.graphics.painter.Painter
    protected boolean applyAlpha(float f) {
        this.alpha = f;
        return true;
    }

    @Override // androidx.compose.ui.graphics.painter.Painter
    protected boolean applyColorFilter(@Nullable ColorFilter colorFilter) {
        this.colorFilter = colorFilter;
        return true;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ColorPainter) && Color.m1051equalsimpl0(this.color, ((ColorPainter) obj).color);
    }

    /* renamed from: getColor-0d7_KjU, reason: not valid java name */
    public final long m1352getColor0d7_KjU() {
        return this.color;
    }

    @Override // androidx.compose.ui.graphics.painter.Painter
    /* renamed from: getIntrinsicSize-NH-jbRc, reason: not valid java name */
    public long mo1353getIntrinsicSizeNHjbRc() {
        return this.intrinsicSize;
    }

    public int hashCode() {
        return Color.m1057hashCodeimpl(this.color);
    }

    @Override // androidx.compose.ui.graphics.painter.Painter
    protected void onDraw(@NotNull DrawScope drawScope) {
        Intrinsics.checkNotNullParameter(drawScope, "<this>");
        w51.K(drawScope, this.color, 0L, 0L, this.alpha, (DrawStyle) null, this.colorFilter, 0, 86, (Object) null);
    }

    @NotNull
    public String toString() {
        return "ColorPainter(color=" + ((Object) Color.m1058toStringimpl(this.color)) + ')';
    }
}
