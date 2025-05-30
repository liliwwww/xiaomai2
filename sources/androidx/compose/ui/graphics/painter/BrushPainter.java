package androidx.compose.ui.graphics.painter;

import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.w51;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
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

    protected boolean applyAlpha(float f) {
        this.alpha = f;
        return true;
    }

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

    /* renamed from: getIntrinsicSize-NH-jbRc, reason: not valid java name */
    public long m1320getIntrinsicSizeNHjbRc() {
        return this.brush.m1045getIntrinsicSizeNHjbRc();
    }

    public int hashCode() {
        return this.brush.hashCode();
    }

    protected void onDraw(@NotNull DrawScope drawScope) {
        Intrinsics.checkNotNullParameter(drawScope, "<this>");
        w51.J(drawScope, this.brush, 0L, 0L, this.alpha, (DrawStyle) null, this.colorFilter, 0, 86, (Object) null);
    }

    @NotNull
    public String toString() {
        return "BrushPainter(brush=" + this.brush + ')';
    }
}
