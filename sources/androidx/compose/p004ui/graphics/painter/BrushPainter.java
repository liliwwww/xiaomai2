package androidx.compose.p004ui.graphics.painter;

import androidx.compose.p004ui.graphics.Brush;
import androidx.compose.p004ui.graphics.ColorFilter;
import androidx.compose.p004ui.graphics.drawscope.DrawScope;
import androidx.compose.p004ui.graphics.drawscope.DrawStyle;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.w51;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public final class BrushPainter extends Painter {
    private float alpha;

    @NotNull
    private final Brush brush;

    @Nullable
    private ColorFilter colorFilter;

    public BrushPainter(@NotNull Brush brush) {
        Intrinsics.checkNotNullParameter(brush, "brush");
        this.brush = brush;
        this.alpha = 1.0f;
    }

    @Override // androidx.compose.p004ui.graphics.painter.Painter
    protected boolean applyAlpha(float f) {
        this.alpha = f;
        return true;
    }

    @Override // androidx.compose.p004ui.graphics.painter.Painter
    protected boolean applyColorFilter(@Nullable ColorFilter colorFilter) {
        this.colorFilter = colorFilter;
        return true;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof BrushPainter) && Intrinsics.areEqual(this.brush, ((BrushPainter) obj).brush);
    }

    @NotNull
    public final Brush getBrush() {
        return this.brush;
    }

    @Override // androidx.compose.p004ui.graphics.painter.Painter
    /* renamed from: getIntrinsicSize-NH-jbRc */
    public long mo3298getIntrinsicSizeNHjbRc() {
        return this.brush.mo2741getIntrinsicSizeNHjbRc();
    }

    public int hashCode() {
        return this.brush.hashCode();
    }

    @Override // androidx.compose.p004ui.graphics.painter.Painter
    protected void onDraw(@NotNull DrawScope drawScope) {
        Intrinsics.checkNotNullParameter(drawScope, "<this>");
        w51.J(drawScope, this.brush, 0L, 0L, this.alpha, (DrawStyle) null, this.colorFilter, 0, 86, (Object) null);
    }

    @NotNull
    public String toString() {
        return "BrushPainter(brush=" + this.brush + ')';
    }
}
