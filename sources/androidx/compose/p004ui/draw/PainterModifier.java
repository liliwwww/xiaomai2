package androidx.compose.p004ui.draw;

import androidx.compose.p004ui.Alignment;
import androidx.compose.p004ui.Modifier;
import androidx.compose.p004ui.geometry.Size;
import androidx.compose.p004ui.geometry.SizeKt;
import androidx.compose.p004ui.graphics.ColorFilter;
import androidx.compose.p004ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.p004ui.graphics.painter.Painter;
import androidx.compose.p004ui.layout.ContentScale;
import androidx.compose.p004ui.layout.IntrinsicMeasurable;
import androidx.compose.p004ui.layout.IntrinsicMeasureScope;
import androidx.compose.p004ui.layout.LayoutModifier;
import androidx.compose.p004ui.layout.Measurable;
import androidx.compose.p004ui.layout.MeasureResult;
import androidx.compose.p004ui.layout.MeasureScope;
import androidx.compose.p004ui.layout.Placeable;
import androidx.compose.p004ui.layout.ScaleFactorKt;
import androidx.compose.p004ui.platform.InspectorInfo;
import androidx.compose.p004ui.platform.InspectorValueInfo;
import androidx.compose.p004ui.unit.Constraints;
import androidx.compose.p004ui.unit.ConstraintsKt;
import androidx.compose.p004ui.unit.IntOffset;
import androidx.compose.p004ui.unit.IntSizeKt;
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
/* loaded from: classes.dex */
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
    private final long m2467calculateScaledSizeE7KxVPU(long j) {
        if (!getUseIntrinsicSize()) {
            return j;
        }
        long Size = SizeKt.Size(!m2469hasSpecifiedAndFiniteWidthuvyYCjk(this.painter.mo3298getIntrinsicSizeNHjbRc()) ? Size.m2625getWidthimpl(j) : Size.m2625getWidthimpl(this.painter.mo3298getIntrinsicSizeNHjbRc()), !m2468hasSpecifiedAndFiniteHeightuvyYCjk(this.painter.mo3298getIntrinsicSizeNHjbRc()) ? Size.m2622getHeightimpl(j) : Size.m2622getHeightimpl(this.painter.mo3298getIntrinsicSizeNHjbRc()));
        if (!(Size.m2625getWidthimpl(j) == 0.0f)) {
            if (!(Size.m2622getHeightimpl(j) == 0.0f)) {
                return ScaleFactorKt.m4257timesUQTWf7w(Size, this.contentScale.mo4178computeScaleFactorH7hwNQA(Size, j));
            }
        }
        return Size.Companion.m2634getZeroNHjbRc();
    }

    private final boolean getUseIntrinsicSize() {
        if (this.sizeToIntrinsics) {
            if (this.painter.mo3298getIntrinsicSizeNHjbRc() != Size.Companion.m2633getUnspecifiedNHjbRc()) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: hasSpecifiedAndFiniteHeight-uvyYCjk, reason: not valid java name */
    private final boolean m2468hasSpecifiedAndFiniteHeightuvyYCjk(long j) {
        if (!Size.m2621equalsimpl0(j, Size.Companion.m2633getUnspecifiedNHjbRc())) {
            float m2622getHeightimpl = Size.m2622getHeightimpl(j);
            if ((Float.isInfinite(m2622getHeightimpl) || Float.isNaN(m2622getHeightimpl)) ? false : true) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: hasSpecifiedAndFiniteWidth-uvyYCjk, reason: not valid java name */
    private final boolean m2469hasSpecifiedAndFiniteWidthuvyYCjk(long j) {
        if (!Size.m2621equalsimpl0(j, Size.Companion.m2633getUnspecifiedNHjbRc())) {
            float m2625getWidthimpl = Size.m2625getWidthimpl(j);
            if ((Float.isInfinite(m2625getWidthimpl) || Float.isNaN(m2625getWidthimpl)) ? false : true) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: modifyConstraints-ZezNO4M, reason: not valid java name */
    private final long m2470modifyConstraintsZezNO4M(long j) {
        boolean z = Constraints.m5180getHasBoundedWidthimpl(j) && Constraints.m5179getHasBoundedHeightimpl(j);
        boolean z2 = Constraints.m5182getHasFixedWidthimpl(j) && Constraints.m5181getHasFixedHeightimpl(j);
        if ((!getUseIntrinsicSize() && z) || z2) {
            return Constraints.m5175copyZbe2FdA$default(j, Constraints.m5184getMaxWidthimpl(j), 0, Constraints.m5183getMaxHeightimpl(j), 0, 10, null);
        }
        long mo3298getIntrinsicSizeNHjbRc = this.painter.mo3298getIntrinsicSizeNHjbRc();
        long m2467calculateScaledSizeE7KxVPU = m2467calculateScaledSizeE7KxVPU(SizeKt.Size(ConstraintsKt.m5198constrainWidthK40F9xA(j, m2469hasSpecifiedAndFiniteWidthuvyYCjk(mo3298getIntrinsicSizeNHjbRc) ? MathKt.roundToInt(Size.m2625getWidthimpl(mo3298getIntrinsicSizeNHjbRc)) : Constraints.m5186getMinWidthimpl(j)), ConstraintsKt.m5197constrainHeightK40F9xA(j, m2468hasSpecifiedAndFiniteHeightuvyYCjk(mo3298getIntrinsicSizeNHjbRc) ? MathKt.roundToInt(Size.m2622getHeightimpl(mo3298getIntrinsicSizeNHjbRc)) : Constraints.m5185getMinHeightimpl(j))));
        return Constraints.m5175copyZbe2FdA$default(j, ConstraintsKt.m5198constrainWidthK40F9xA(j, MathKt.roundToInt(Size.m2625getWidthimpl(m2467calculateScaledSizeE7KxVPU))), 0, ConstraintsKt.m5197constrainHeightK40F9xA(j, MathKt.roundToInt(Size.m2622getHeightimpl(m2467calculateScaledSizeE7KxVPU))), 0, 10, null);
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
        long m2634getZeroNHjbRc;
        Intrinsics.checkNotNullParameter(contentDrawScope, "<this>");
        long mo3298getIntrinsicSizeNHjbRc = this.painter.mo3298getIntrinsicSizeNHjbRc();
        long Size = SizeKt.Size(m2469hasSpecifiedAndFiniteWidthuvyYCjk(mo3298getIntrinsicSizeNHjbRc) ? Size.m2625getWidthimpl(mo3298getIntrinsicSizeNHjbRc) : Size.m2625getWidthimpl(contentDrawScope.mo3205getSizeNHjbRc()), m2468hasSpecifiedAndFiniteHeightuvyYCjk(mo3298getIntrinsicSizeNHjbRc) ? Size.m2622getHeightimpl(mo3298getIntrinsicSizeNHjbRc) : Size.m2622getHeightimpl(contentDrawScope.mo3205getSizeNHjbRc()));
        if (!(Size.m2625getWidthimpl(contentDrawScope.mo3205getSizeNHjbRc()) == 0.0f)) {
            if (!(Size.m2622getHeightimpl(contentDrawScope.mo3205getSizeNHjbRc()) == 0.0f)) {
                m2634getZeroNHjbRc = ScaleFactorKt.m4257timesUQTWf7w(Size, this.contentScale.mo4178computeScaleFactorH7hwNQA(Size, contentDrawScope.mo3205getSizeNHjbRc()));
                long j = m2634getZeroNHjbRc;
                long mo2450alignKFBX0sM = this.alignment.mo2450alignKFBX0sM(IntSizeKt.IntSize(MathKt.roundToInt(Size.m2625getWidthimpl(j)), MathKt.roundToInt(Size.m2622getHeightimpl(j))), IntSizeKt.IntSize(MathKt.roundToInt(Size.m2625getWidthimpl(contentDrawScope.mo3205getSizeNHjbRc())), MathKt.roundToInt(Size.m2622getHeightimpl(contentDrawScope.mo3205getSizeNHjbRc()))), contentDrawScope.getLayoutDirection());
                float m5334getXimpl = IntOffset.m5334getXimpl(mo2450alignKFBX0sM);
                float m5335getYimpl = IntOffset.m5335getYimpl(mo2450alignKFBX0sM);
                contentDrawScope.getDrawContext().getTransform().translate(m5334getXimpl, m5335getYimpl);
                this.painter.m3304drawx_KDEd0(contentDrawScope, j, this.alpha, this.colorFilter);
                contentDrawScope.getDrawContext().getTransform().translate(-m5334getXimpl, -m5335getYimpl);
                contentDrawScope.drawContent();
            }
        }
        m2634getZeroNHjbRc = Size.Companion.m2634getZeroNHjbRc();
        long j2 = m2634getZeroNHjbRc;
        long mo2450alignKFBX0sM2 = this.alignment.mo2450alignKFBX0sM(IntSizeKt.IntSize(MathKt.roundToInt(Size.m2625getWidthimpl(j2)), MathKt.roundToInt(Size.m2622getHeightimpl(j2))), IntSizeKt.IntSize(MathKt.roundToInt(Size.m2625getWidthimpl(contentDrawScope.mo3205getSizeNHjbRc())), MathKt.roundToInt(Size.m2622getHeightimpl(contentDrawScope.mo3205getSizeNHjbRc()))), contentDrawScope.getLayoutDirection());
        float m5334getXimpl2 = IntOffset.m5334getXimpl(mo2450alignKFBX0sM2);
        float m5335getYimpl2 = IntOffset.m5335getYimpl(mo2450alignKFBX0sM2);
        contentDrawScope.getDrawContext().getTransform().translate(m5334getXimpl2, m5335getYimpl2);
        this.painter.m3304drawx_KDEd0(contentDrawScope, j2, this.alpha, this.colorFilter);
        contentDrawScope.getDrawContext().getTransform().translate(-m5334getXimpl2, -m5335getYimpl2);
        contentDrawScope.drawContent();
    }

    public boolean equals(@Nullable Object obj) {
        PainterModifier painterModifier = obj instanceof PainterModifier ? (PainterModifier) obj : null;
        if (painterModifier != null && Intrinsics.areEqual(this.painter, painterModifier.painter) && this.sizeToIntrinsics == painterModifier.sizeToIntrinsics && Intrinsics.areEqual(this.alignment, painterModifier.alignment) && Intrinsics.areEqual(this.contentScale, painterModifier.contentScale)) {
            return ((this.alpha > painterModifier.alpha ? 1 : (this.alpha == painterModifier.alpha ? 0 : -1)) == 0) && Intrinsics.areEqual(this.colorFilter, painterModifier.colorFilter);
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

    @Override // androidx.compose.p004ui.layout.LayoutModifier
    public int maxIntrinsicHeight(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull IntrinsicMeasurable intrinsicMeasurable, int i) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        Intrinsics.checkNotNullParameter(intrinsicMeasurable, "measurable");
        if (!getUseIntrinsicSize()) {
            return intrinsicMeasurable.maxIntrinsicHeight(i);
        }
        long m2470modifyConstraintsZezNO4M = m2470modifyConstraintsZezNO4M(ConstraintsKt.Constraints$default(0, i, 0, 0, 13, null));
        return Math.max(Constraints.m5185getMinHeightimpl(m2470modifyConstraintsZezNO4M), intrinsicMeasurable.maxIntrinsicHeight(i));
    }

    @Override // androidx.compose.p004ui.layout.LayoutModifier
    public int maxIntrinsicWidth(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull IntrinsicMeasurable intrinsicMeasurable, int i) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        Intrinsics.checkNotNullParameter(intrinsicMeasurable, "measurable");
        if (!getUseIntrinsicSize()) {
            return intrinsicMeasurable.maxIntrinsicWidth(i);
        }
        long m2470modifyConstraintsZezNO4M = m2470modifyConstraintsZezNO4M(ConstraintsKt.Constraints$default(0, 0, 0, i, 7, null));
        return Math.max(Constraints.m5186getMinWidthimpl(m2470modifyConstraintsZezNO4M), intrinsicMeasurable.maxIntrinsicWidth(i));
    }

    @Override // androidx.compose.p004ui.layout.LayoutModifier
    @NotNull
    /* renamed from: measure-3p2s80s */
    public MeasureResult mo959measure3p2s80s(@NotNull MeasureScope measureScope, @NotNull Measurable measurable, long j) {
        Intrinsics.checkNotNullParameter(measureScope, "$this$measure");
        Intrinsics.checkNotNullParameter(measurable, "measurable");
        final Placeable mo4187measureBRTryo0 = measurable.mo4187measureBRTryo0(m2470modifyConstraintsZezNO4M(j));
        return MeasureScope.CC.m140p(measureScope, mo4187measureBRTryo0.getWidth(), mo4187measureBRTryo0.getHeight(), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.ui.draw.PainterModifier$measure$1
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Placeable.PlacementScope) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull Placeable.PlacementScope placementScope) {
                Intrinsics.checkNotNullParameter(placementScope, "$this$layout");
                Placeable.PlacementScope.placeRelative$default(placementScope, Placeable.this, 0, 0, 0.0f, 4, null);
            }
        }, 4, null);
    }

    @Override // androidx.compose.p004ui.layout.LayoutModifier
    public int minIntrinsicHeight(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull IntrinsicMeasurable intrinsicMeasurable, int i) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        Intrinsics.checkNotNullParameter(intrinsicMeasurable, "measurable");
        if (!getUseIntrinsicSize()) {
            return intrinsicMeasurable.minIntrinsicHeight(i);
        }
        long m2470modifyConstraintsZezNO4M = m2470modifyConstraintsZezNO4M(ConstraintsKt.Constraints$default(0, i, 0, 0, 13, null));
        return Math.max(Constraints.m5185getMinHeightimpl(m2470modifyConstraintsZezNO4M), intrinsicMeasurable.minIntrinsicHeight(i));
    }

    @Override // androidx.compose.p004ui.layout.LayoutModifier
    public int minIntrinsicWidth(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull IntrinsicMeasurable intrinsicMeasurable, int i) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        Intrinsics.checkNotNullParameter(intrinsicMeasurable, "measurable");
        if (!getUseIntrinsicSize()) {
            return intrinsicMeasurable.minIntrinsicWidth(i);
        }
        long m2470modifyConstraintsZezNO4M = m2470modifyConstraintsZezNO4M(ConstraintsKt.Constraints$default(0, 0, 0, i, 7, null));
        return Math.max(Constraints.m5186getMinWidthimpl(m2470modifyConstraintsZezNO4M), intrinsicMeasurable.minIntrinsicWidth(i));
    }

    @Override // androidx.compose.p004ui.Modifier
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
