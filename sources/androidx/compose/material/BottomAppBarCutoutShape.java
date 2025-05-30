package androidx.compose.material;

import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.Outline;
import androidx.compose.ui.graphics.OutlineKt;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.PathOperation;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
final class BottomAppBarCutoutShape implements Shape {

    @NotNull
    private final Shape cutoutShape;

    @NotNull
    private final FabPlacement fabPlacement;

    public BottomAppBarCutoutShape(@NotNull Shape shape, @NotNull FabPlacement fabPlacement) {
        Intrinsics.checkNotNullParameter(shape, "cutoutShape");
        Intrinsics.checkNotNullParameter(fabPlacement, "fabPlacement");
        this.cutoutShape = shape;
        this.fabPlacement = fabPlacement;
    }

    private final void addCutoutShape(Path path, LayoutDirection layoutDirection, Density density) {
        float mo321toPx0680j_4 = density.mo321toPx0680j_4(AppBarKt.access$getBottomAppBarCutoutOffset$p());
        float f = 2 * mo321toPx0680j_4;
        long Size = SizeKt.Size(this.fabPlacement.getWidth() + f, this.fabPlacement.getHeight() + f);
        float left = this.fabPlacement.getLeft() - mo321toPx0680j_4;
        float m903getWidthimpl = left + Size.m903getWidthimpl(Size);
        float m900getHeightimpl = Size.m900getHeightimpl(Size) / 2.0f;
        OutlineKt.addOutline(path, this.cutoutShape.mo130createOutlinePq9zytI(Size, layoutDirection, density));
        path.translate-k-4lQ0M(OffsetKt.Offset(left, -m900getHeightimpl));
        if (Intrinsics.areEqual(this.cutoutShape, RoundedCornerShapeKt.getCircleShape())) {
            addRoundedEdges(path, left, m903getWidthimpl, m900getHeightimpl, density.mo321toPx0680j_4(AppBarKt.access$getBottomAppBarRoundedEdgeRadius$p()), 0.0f);
        }
    }

    private final void addRoundedEdges(Path path, float f, float f2, float f3, float f4, float f5) {
        float f6 = -((float) Math.sqrt((f3 * f3) - (f5 * f5)));
        float f7 = f3 + f6;
        float f8 = f + f7;
        float f9 = f2 - f7;
        Pair calculateRoundedEdgeIntercept = AppBarKt.calculateRoundedEdgeIntercept(f6 - 1.0f, f5, f3);
        float floatValue = ((Number) calculateRoundedEdgeIntercept.component1()).floatValue() + f3;
        float floatValue2 = ((Number) calculateRoundedEdgeIntercept.component2()).floatValue() - f5;
        path.moveTo(f8 - f4, 0.0f);
        path.quadraticBezierTo(f8 - 1.0f, 0.0f, f + floatValue, floatValue2);
        path.lineTo(f2 - floatValue, floatValue2);
        path.quadraticBezierTo(f9 + 1.0f, 0.0f, f4 + f9, 0.0f);
        path.close();
    }

    public static /* synthetic */ BottomAppBarCutoutShape copy$default(BottomAppBarCutoutShape bottomAppBarCutoutShape, Shape shape, FabPlacement fabPlacement, int i, Object obj) {
        if ((i & 1) != 0) {
            shape = bottomAppBarCutoutShape.cutoutShape;
        }
        if ((i & 2) != 0) {
            fabPlacement = bottomAppBarCutoutShape.fabPlacement;
        }
        return bottomAppBarCutoutShape.copy(shape, fabPlacement);
    }

    @NotNull
    public final Shape component1() {
        return this.cutoutShape;
    }

    @NotNull
    public final FabPlacement component2() {
        return this.fabPlacement;
    }

    @NotNull
    public final BottomAppBarCutoutShape copy(@NotNull Shape shape, @NotNull FabPlacement fabPlacement) {
        Intrinsics.checkNotNullParameter(shape, "cutoutShape");
        Intrinsics.checkNotNullParameter(fabPlacement, "fabPlacement");
        return new BottomAppBarCutoutShape(shape, fabPlacement);
    }

    @Override // androidx.compose.ui.graphics.Shape
    @NotNull
    /* renamed from: createOutline-Pq9zytI */
    public Outline mo130createOutlinePq9zytI(long j, @NotNull LayoutDirection layoutDirection, @NotNull Density density) {
        Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
        Intrinsics.checkNotNullParameter(density, "density");
        Path Path = AndroidPath_androidKt.Path();
        Path.addRect(new Rect(0.0f, 0.0f, Size.m903getWidthimpl(j), Size.m900getHeightimpl(j)));
        Path Path2 = AndroidPath_androidKt.Path();
        addCutoutShape(Path2, layoutDirection, density);
        Path2.op-N5in7k0(Path, Path2, PathOperation.Companion.m1184getDifferenceb3I0S0c());
        return new Outline.Generic(Path2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BottomAppBarCutoutShape)) {
            return false;
        }
        BottomAppBarCutoutShape bottomAppBarCutoutShape = (BottomAppBarCutoutShape) obj;
        return Intrinsics.areEqual(this.cutoutShape, bottomAppBarCutoutShape.cutoutShape) && Intrinsics.areEqual(this.fabPlacement, bottomAppBarCutoutShape.fabPlacement);
    }

    @NotNull
    public final Shape getCutoutShape() {
        return this.cutoutShape;
    }

    @NotNull
    public final FabPlacement getFabPlacement() {
        return this.fabPlacement;
    }

    public int hashCode() {
        return (this.cutoutShape.hashCode() * 31) + this.fabPlacement.hashCode();
    }

    @NotNull
    public String toString() {
        return "BottomAppBarCutoutShape(cutoutShape=" + this.cutoutShape + ", fabPlacement=" + this.fabPlacement + ')';
    }
}
