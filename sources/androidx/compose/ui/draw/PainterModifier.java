package androidx.compose.ui.draw;

import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.LayoutModifier;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.ScaleFactorKt;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.platform.InspectorValueInfo;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSizeKt;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.l3;
import tb.mt2;
import tb.nt2;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
final class PainterModifier extends InspectorValueInfo implements DrawModifier, LayoutModifier {

    @NotNull
    private final Alignment alignment;
    private final float alpha;

    @Nullable
    private final ColorFilter colorFilter;

    @NotNull
    private final ContentScale contentScale;

    @NotNull
    private final Painter painter;
    private final boolean sizeToIntrinsics;

    public /* synthetic */ PainterModifier(Painter painter, boolean z, Alignment alignment, ContentScale contentScale, float f, ColorFilter colorFilter, Function1 function1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(painter, z, (i & 4) != 0 ? Alignment.Companion.getCenter() : alignment, (i & 8) != 0 ? ContentScale.Companion.getInside() : contentScale, (i & 16) != 0 ? 1.0f : f, (i & 32) != 0 ? null : colorFilter, function1);
    }

    /* renamed from: calculateScaledSize-E7KxVPU, reason: not valid java name */
    private final long m820calculateScaledSizeE7KxVPU(long j) {
        if (!getUseIntrinsicSize()) {
            return j;
        }
        long Size = SizeKt.Size(!m822hasSpecifiedAndFiniteWidthuvyYCjk(this.painter.mo1353getIntrinsicSizeNHjbRc()) ? Size.m903getWidthimpl(j) : Size.m903getWidthimpl(this.painter.mo1353getIntrinsicSizeNHjbRc()), !m821hasSpecifiedAndFiniteHeightuvyYCjk(this.painter.mo1353getIntrinsicSizeNHjbRc()) ? Size.m900getHeightimpl(j) : Size.m900getHeightimpl(this.painter.mo1353getIntrinsicSizeNHjbRc()));
        if (!(Size.m903getWidthimpl(j) == 0.0f)) {
            if (!(Size.m900getHeightimpl(j) == 0.0f)) {
                return ScaleFactorKt.times-UQTWf7w(Size, this.contentScale.mo1512computeScaleFactorH7hwNQA(Size, j));
            }
        }
        return Size.Companion.m912getZeroNHjbRc();
    }

    private final boolean getUseIntrinsicSize() {
        if (this.sizeToIntrinsics) {
            if (this.painter.mo1353getIntrinsicSizeNHjbRc() != Size.Companion.m911getUnspecifiedNHjbRc()) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: hasSpecifiedAndFiniteHeight-uvyYCjk, reason: not valid java name */
    private final boolean m821hasSpecifiedAndFiniteHeightuvyYCjk(long j) {
        if (!Size.m899equalsimpl0(j, Size.Companion.m911getUnspecifiedNHjbRc())) {
            float m900getHeightimpl = Size.m900getHeightimpl(j);
            if ((Float.isInfinite(m900getHeightimpl) || Float.isNaN(m900getHeightimpl)) ? false : true) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: hasSpecifiedAndFiniteWidth-uvyYCjk, reason: not valid java name */
    private final boolean m822hasSpecifiedAndFiniteWidthuvyYCjk(long j) {
        if (!Size.m899equalsimpl0(j, Size.Companion.m911getUnspecifiedNHjbRc())) {
            float m903getWidthimpl = Size.m903getWidthimpl(j);
            if ((Float.isInfinite(m903getWidthimpl) || Float.isNaN(m903getWidthimpl)) ? false : true) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: modifyConstraints-ZezNO4M, reason: not valid java name */
    private final long m823modifyConstraintsZezNO4M(long j) {
        boolean z = Constraints.m2118getHasBoundedWidthimpl(j) && Constraints.m2117getHasBoundedHeightimpl(j);
        boolean z2 = Constraints.m2120getHasFixedWidthimpl(j) && Constraints.m2119getHasFixedHeightimpl(j);
        if ((!getUseIntrinsicSize() && z) || z2) {
            return Constraints.m2113copyZbe2FdA$default(j, Constraints.m2122getMaxWidthimpl(j), 0, Constraints.m2121getMaxHeightimpl(j), 0, 10, null);
        }
        long mo1353getIntrinsicSizeNHjbRc = this.painter.mo1353getIntrinsicSizeNHjbRc();
        long m820calculateScaledSizeE7KxVPU = m820calculateScaledSizeE7KxVPU(SizeKt.Size(ConstraintsKt.m2136constrainWidthK40F9xA(j, m822hasSpecifiedAndFiniteWidthuvyYCjk(mo1353getIntrinsicSizeNHjbRc) ? MathKt.roundToInt(Size.m903getWidthimpl(mo1353getIntrinsicSizeNHjbRc)) : Constraints.m2124getMinWidthimpl(j)), ConstraintsKt.m2135constrainHeightK40F9xA(j, m821hasSpecifiedAndFiniteHeightuvyYCjk(mo1353getIntrinsicSizeNHjbRc) ? MathKt.roundToInt(Size.m900getHeightimpl(mo1353getIntrinsicSizeNHjbRc)) : Constraints.m2123getMinHeightimpl(j))));
        return Constraints.m2113copyZbe2FdA$default(j, ConstraintsKt.m2136constrainWidthK40F9xA(j, MathKt.roundToInt(Size.m903getWidthimpl(m820calculateScaledSizeE7KxVPU))), 0, ConstraintsKt.m2135constrainHeightK40F9xA(j, MathKt.roundToInt(Size.m900getHeightimpl(m820calculateScaledSizeE7KxVPU))), 0, 10, null);
    }

    @Override // androidx.compose.ui.Modifier$Element
    public /* synthetic */ boolean all(Function1 function1) {
        return nt2.a(this, function1);
    }

    @Override // androidx.compose.ui.Modifier$Element
    public /* synthetic */ boolean any(Function1 function1) {
        return nt2.b(this, function1);
    }

    @Override // androidx.compose.ui.draw.DrawModifier
    public void draw(@NotNull ContentDrawScope contentDrawScope) {
        long m912getZeroNHjbRc;
        Intrinsics.checkNotNullParameter(contentDrawScope, "<this>");
        long mo1353getIntrinsicSizeNHjbRc = this.painter.mo1353getIntrinsicSizeNHjbRc();
        long Size = SizeKt.Size(m822hasSpecifiedAndFiniteWidthuvyYCjk(mo1353getIntrinsicSizeNHjbRc) ? Size.m903getWidthimpl(mo1353getIntrinsicSizeNHjbRc) : Size.m903getWidthimpl(contentDrawScope.mo1321getSizeNHjbRc()), m821hasSpecifiedAndFiniteHeightuvyYCjk(mo1353getIntrinsicSizeNHjbRc) ? Size.m900getHeightimpl(mo1353getIntrinsicSizeNHjbRc) : Size.m900getHeightimpl(contentDrawScope.mo1321getSizeNHjbRc()));
        if (!(Size.m903getWidthimpl(contentDrawScope.mo1321getSizeNHjbRc()) == 0.0f)) {
            if (!(Size.m900getHeightimpl(contentDrawScope.mo1321getSizeNHjbRc()) == 0.0f)) {
                m912getZeroNHjbRc = ScaleFactorKt.times-UQTWf7w(Size, this.contentScale.mo1512computeScaleFactorH7hwNQA(Size, contentDrawScope.mo1321getSizeNHjbRc()));
                long j = m912getZeroNHjbRc;
                long j2 = this.alignment.align-KFBX0sM(IntSizeKt.IntSize(MathKt.roundToInt(Size.m903getWidthimpl(j)), MathKt.roundToInt(Size.m900getHeightimpl(j))), IntSizeKt.IntSize(MathKt.roundToInt(Size.m903getWidthimpl(contentDrawScope.mo1321getSizeNHjbRc())), MathKt.roundToInt(Size.m900getHeightimpl(contentDrawScope.mo1321getSizeNHjbRc()))), contentDrawScope.getLayoutDirection());
                float f = IntOffset.getX-impl(j2);
                float f2 = IntOffset.getY-impl(j2);
                contentDrawScope.getDrawContext().getTransform().translate(f, f2);
                this.painter.m1355drawx_KDEd0(contentDrawScope, j, this.alpha, this.colorFilter);
                contentDrawScope.getDrawContext().getTransform().translate(-f, -f2);
                contentDrawScope.drawContent();
            }
        }
        m912getZeroNHjbRc = Size.Companion.m912getZeroNHjbRc();
        long j3 = m912getZeroNHjbRc;
        long j22 = this.alignment.align-KFBX0sM(IntSizeKt.IntSize(MathKt.roundToInt(Size.m903getWidthimpl(j3)), MathKt.roundToInt(Size.m900getHeightimpl(j3))), IntSizeKt.IntSize(MathKt.roundToInt(Size.m903getWidthimpl(contentDrawScope.mo1321getSizeNHjbRc())), MathKt.roundToInt(Size.m900getHeightimpl(contentDrawScope.mo1321getSizeNHjbRc()))), contentDrawScope.getLayoutDirection());
        float f3 = IntOffset.getX-impl(j22);
        float f22 = IntOffset.getY-impl(j22);
        contentDrawScope.getDrawContext().getTransform().translate(f3, f22);
        this.painter.m1355drawx_KDEd0(contentDrawScope, j3, this.alpha, this.colorFilter);
        contentDrawScope.getDrawContext().getTransform().translate(-f3, -f22);
        contentDrawScope.drawContent();
    }

    public boolean equals(@Nullable Object obj) {
        PainterModifier painterModifier = obj instanceof PainterModifier ? (PainterModifier) obj : null;
        if (painterModifier != null && Intrinsics.areEqual(this.painter, painterModifier.painter) && this.sizeToIntrinsics == painterModifier.sizeToIntrinsics && Intrinsics.areEqual(this.alignment, painterModifier.alignment) && Intrinsics.areEqual(this.contentScale, painterModifier.contentScale)) {
            return ((this.alpha > painterModifier.alpha ? 1 : (this.alpha == painterModifier.alpha ? 0 : -1)) == 0) && Intrinsics.areEqual(this.colorFilter, painterModifier.colorFilter);
        }
        return false;
    }

    @Override // androidx.compose.ui.Modifier$Element
    public /* synthetic */ Object foldIn(Object obj, Function2 function2) {
        return nt2.c(this, obj, function2);
    }

    @Override // androidx.compose.ui.Modifier$Element
    public /* synthetic */ Object foldOut(Object obj, Function2 function2) {
        return nt2.d(this, obj, function2);
    }

    @NotNull
    public final Alignment getAlignment() {
        return this.alignment;
    }

    public final float getAlpha() {
        return this.alpha;
    }

    @Nullable
    public final ColorFilter getColorFilter() {
        return this.colorFilter;
    }

    @NotNull
    public final ContentScale getContentScale() {
        return this.contentScale;
    }

    @NotNull
    public final Painter getPainter() {
        return this.painter;
    }

    public final boolean getSizeToIntrinsics() {
        return this.sizeToIntrinsics;
    }

    public int hashCode() {
        int hashCode = ((((((((this.painter.hashCode() * 31) + l3.a(this.sizeToIntrinsics)) * 31) + this.alignment.hashCode()) * 31) + this.contentScale.hashCode()) * 31) + Float.floatToIntBits(this.alpha)) * 31;
        ColorFilter colorFilter = this.colorFilter;
        return hashCode + (colorFilter != null ? colorFilter.hashCode() : 0);
    }

    public int maxIntrinsicHeight(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull IntrinsicMeasurable intrinsicMeasurable, int i) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        Intrinsics.checkNotNullParameter(intrinsicMeasurable, "measurable");
        if (!getUseIntrinsicSize()) {
            return intrinsicMeasurable.maxIntrinsicHeight(i);
        }
        long m823modifyConstraintsZezNO4M = m823modifyConstraintsZezNO4M(ConstraintsKt.Constraints$default(0, i, 0, 0, 13, null));
        return Math.max(Constraints.m2123getMinHeightimpl(m823modifyConstraintsZezNO4M), intrinsicMeasurable.maxIntrinsicHeight(i));
    }

    public int maxIntrinsicWidth(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull IntrinsicMeasurable intrinsicMeasurable, int i) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        Intrinsics.checkNotNullParameter(intrinsicMeasurable, "measurable");
        if (!getUseIntrinsicSize()) {
            return intrinsicMeasurable.maxIntrinsicWidth(i);
        }
        long m823modifyConstraintsZezNO4M = m823modifyConstraintsZezNO4M(ConstraintsKt.Constraints$default(0, 0, 0, i, 7, null));
        return Math.max(Constraints.m2124getMinWidthimpl(m823modifyConstraintsZezNO4M), intrinsicMeasurable.maxIntrinsicWidth(i));
    }

    @NotNull
    /* renamed from: measure-3p2s80s, reason: not valid java name */
    public MeasureResult m824measure3p2s80s(@NotNull MeasureScope measureScope, @NotNull Measurable measurable, long j) {
        Intrinsics.checkNotNullParameter(measureScope, "$this$measure");
        Intrinsics.checkNotNullParameter(measurable, "measurable");
        final Placeable mo1521measureBRTryo0 = measurable.mo1521measureBRTryo0(m823modifyConstraintsZezNO4M(j));
        return MeasureScope.-CC.p(measureScope, mo1521measureBRTryo0.getWidth(), mo1521measureBRTryo0.getHeight(), (Map) null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.ui.draw.PainterModifier$measure$1
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Placeable.PlacementScope) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull Placeable.PlacementScope placementScope) {
                Intrinsics.checkNotNullParameter(placementScope, "$this$layout");
                Placeable.PlacementScope.placeRelative$default(placementScope, Placeable.this, 0, 0, 0.0f, 4, (Object) null);
            }
        }, 4, (Object) null);
    }

    public int minIntrinsicHeight(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull IntrinsicMeasurable intrinsicMeasurable, int i) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        Intrinsics.checkNotNullParameter(intrinsicMeasurable, "measurable");
        if (!getUseIntrinsicSize()) {
            return intrinsicMeasurable.minIntrinsicHeight(i);
        }
        long m823modifyConstraintsZezNO4M = m823modifyConstraintsZezNO4M(ConstraintsKt.Constraints$default(0, i, 0, 0, 13, null));
        return Math.max(Constraints.m2123getMinHeightimpl(m823modifyConstraintsZezNO4M), intrinsicMeasurable.minIntrinsicHeight(i));
    }

    public int minIntrinsicWidth(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull IntrinsicMeasurable intrinsicMeasurable, int i) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        Intrinsics.checkNotNullParameter(intrinsicMeasurable, "measurable");
        if (!getUseIntrinsicSize()) {
            return intrinsicMeasurable.minIntrinsicWidth(i);
        }
        long m823modifyConstraintsZezNO4M = m823modifyConstraintsZezNO4M(ConstraintsKt.Constraints$default(0, 0, 0, i, 7, null));
        return Math.max(Constraints.m2124getMinWidthimpl(m823modifyConstraintsZezNO4M), intrinsicMeasurable.minIntrinsicWidth(i));
    }

    public /* synthetic */ Modifier then(Modifier modifier) {
        return mt2.a(this, modifier);
    }

    @NotNull
    public String toString() {
        return "PainterModifier(painter=" + this.painter + ", sizeToIntrinsics=" + this.sizeToIntrinsics + ", alignment=" + this.alignment + ", alpha=" + this.alpha + ", colorFilter=" + this.colorFilter + ')';
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PainterModifier(@NotNull Painter painter, boolean z, @NotNull Alignment alignment, @NotNull ContentScale contentScale, float f, @Nullable ColorFilter colorFilter, @NotNull Function1<? super InspectorInfo, Unit> function1) {
        super(function1);
        Intrinsics.checkNotNullParameter(painter, "painter");
        Intrinsics.checkNotNullParameter(alignment, "alignment");
        Intrinsics.checkNotNullParameter(contentScale, "contentScale");
        Intrinsics.checkNotNullParameter(function1, "inspectorInfo");
        this.painter = painter;
        this.sizeToIntrinsics = z;
        this.alignment = alignment;
        this.contentScale = contentScale;
        this.alpha = f;
        this.colorFilter = colorFilter;
    }
}
