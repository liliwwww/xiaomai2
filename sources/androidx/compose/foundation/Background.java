package androidx.compose.foundation;

import androidx.compose.p004ui.Modifier;
import androidx.compose.p004ui.draw.DrawModifier;
import androidx.compose.p004ui.geometry.Size;
import androidx.compose.p004ui.graphics.Brush;
import androidx.compose.p004ui.graphics.Color;
import androidx.compose.p004ui.graphics.ColorFilter;
import androidx.compose.p004ui.graphics.Outline;
import androidx.compose.p004ui.graphics.OutlineKt;
import androidx.compose.p004ui.graphics.RectangleShapeKt;
import androidx.compose.p004ui.graphics.Shape;
import androidx.compose.p004ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.p004ui.graphics.drawscope.DrawScope;
import androidx.compose.p004ui.graphics.drawscope.DrawStyle;
import androidx.compose.p004ui.graphics.drawscope.Fill;
import androidx.compose.p004ui.platform.InspectorInfo;
import androidx.compose.p004ui.platform.InspectorValueInfo;
import androidx.compose.p004ui.unit.LayoutDirection;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.mt2;
import tb.nt2;
import tb.w51;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
final class Background extends InspectorValueInfo implements DrawModifier {
    private final float alpha;

    @Nullable
    private final Brush brush;

    @Nullable
    private final Color color;

    @Nullable
    private LayoutDirection lastLayoutDirection;

    @Nullable
    private Outline lastOutline;

    @Nullable
    private Size lastSize;

    @NotNull
    private final Shape shape;

    public /* synthetic */ Background(Color color, Brush brush, float f, Shape shape, Function1 function1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : color, (i & 2) != 0 ? null : brush, (i & 4) != 0 ? 1.0f : f, shape, function1, null);
    }

    public /* synthetic */ Background(Color color, Brush brush, float f, Shape shape, Function1 function1, DefaultConstructorMarker defaultConstructorMarker) {
        this(color, brush, f, shape, function1);
    }

    private final void drawOutline(ContentDrawScope contentDrawScope) {
        Outline mo1164createOutlinePq9zytI;
        if (Size.m2620equalsimpl(contentDrawScope.mo3205getSizeNHjbRc(), this.lastSize) && contentDrawScope.getLayoutDirection() == this.lastLayoutDirection) {
            mo1164createOutlinePq9zytI = this.lastOutline;
            Intrinsics.checkNotNull(mo1164createOutlinePq9zytI);
        } else {
            mo1164createOutlinePq9zytI = this.shape.mo1164createOutlinePq9zytI(contentDrawScope.mo3205getSizeNHjbRc(), contentDrawScope.getLayoutDirection(), contentDrawScope);
        }
        Color color = this.color;
        if (color != null) {
            color.m2797unboximpl();
            OutlineKt.m3009drawOutlinewDX37Ww(contentDrawScope, mo1164createOutlinePq9zytI, this.color.m2797unboximpl(), (r17 & 4) != 0 ? 1.0f : 0.0f, (r17 & 8) != 0 ? Fill.INSTANCE : null, (r17 & 16) != 0 ? null : null, (r17 & 32) != 0 ? DrawScope.Companion.m3235getDefaultBlendMode0nO6VwU() : 0);
        }
        Brush brush = this.brush;
        if (brush != null) {
            OutlineKt.m3008drawOutlinehn5TExg$default(contentDrawScope, mo1164createOutlinePq9zytI, brush, this.alpha, null, null, 0, 56, null);
        }
        this.lastOutline = mo1164createOutlinePq9zytI;
        this.lastSize = Size.m2613boximpl(contentDrawScope.mo3205getSizeNHjbRc());
        this.lastLayoutDirection = contentDrawScope.getLayoutDirection();
    }

    private final void drawRect(ContentDrawScope contentDrawScope) {
        Color color = this.color;
        if (color != null) {
            w51.K(contentDrawScope, color.m2797unboximpl(), 0L, 0L, 0.0f, (DrawStyle) null, (ColorFilter) null, 0, 126, (Object) null);
        }
        Brush brush = this.brush;
        if (brush != null) {
            w51.J(contentDrawScope, brush, 0L, 0L, this.alpha, (DrawStyle) null, (ColorFilter) null, 0, 118, (Object) null);
        }
    }

    @Override // androidx.compose.ui.Modifier.Element, androidx.compose.p004ui.Modifier
    public /* synthetic */ boolean all(Function1 function1) {
        return nt2.a(this, function1);
    }

    @Override // androidx.compose.ui.Modifier.Element, androidx.compose.p004ui.Modifier
    public /* synthetic */ boolean any(Function1 function1) {
        return nt2.b(this, function1);
    }

    @Override // androidx.compose.p004ui.draw.DrawModifier
    public void draw(@NotNull ContentDrawScope contentDrawScope) {
        Intrinsics.checkNotNullParameter(contentDrawScope, "<this>");
        if (this.shape == RectangleShapeKt.getRectangleShape()) {
            drawRect(contentDrawScope);
        } else {
            drawOutline(contentDrawScope);
        }
        contentDrawScope.drawContent();
    }

    public boolean equals(@Nullable Object obj) {
        Background background = obj instanceof Background ? (Background) obj : null;
        if (background != null && Intrinsics.areEqual(this.color, background.color) && Intrinsics.areEqual(this.brush, background.brush)) {
            return ((this.alpha > background.alpha ? 1 : (this.alpha == background.alpha ? 0 : -1)) == 0) && Intrinsics.areEqual(this.shape, background.shape);
        }
        return false;
    }

    @Override // androidx.compose.ui.Modifier.Element, androidx.compose.p004ui.Modifier
    public /* synthetic */ Object foldIn(Object obj, Function2 function2) {
        return nt2.c(this, obj, function2);
    }

    @Override // androidx.compose.ui.Modifier.Element, androidx.compose.p004ui.Modifier
    public /* synthetic */ Object foldOut(Object obj, Function2 function2) {
        return nt2.d(this, obj, function2);
    }

    public int hashCode() {
        Color color = this.color;
        int m2794hashCodeimpl = (color != null ? Color.m2794hashCodeimpl(color.m2797unboximpl()) : 0) * 31;
        Brush brush = this.brush;
        return ((((m2794hashCodeimpl + (brush != null ? brush.hashCode() : 0)) * 31) + Float.floatToIntBits(this.alpha)) * 31) + this.shape.hashCode();
    }

    @Override // androidx.compose.p004ui.Modifier
    public /* synthetic */ Modifier then(Modifier modifier) {
        return mt2.a(this, modifier);
    }

    @NotNull
    public String toString() {
        return "Background(color=" + this.color + ", brush=" + this.brush + ", alpha = " + this.alpha + ", shape=" + this.shape + ')';
    }

    private Background(Color color, Brush brush, float f, Shape shape, Function1<? super InspectorInfo, Unit> function1) {
        super(function1);
        this.color = color;
        this.brush = brush;
        this.alpha = f;
        this.shape = shape;
    }
}
