package androidx.compose.foundation.layout;

import androidx.compose.p004ui.Modifier;
import androidx.compose.p004ui.layout.C0790a;
import androidx.compose.p004ui.layout.IntrinsicMeasurable;
import androidx.compose.p004ui.layout.IntrinsicMeasureScope;
import androidx.compose.p004ui.layout.LayoutModifier;
import androidx.compose.p004ui.layout.Measurable;
import androidx.compose.p004ui.layout.MeasureResult;
import androidx.compose.p004ui.layout.MeasureScope;
import androidx.compose.p004ui.layout.Placeable;
import androidx.compose.p004ui.platform.InspectorInfo;
import androidx.compose.p004ui.platform.InspectorValueInfo;
import androidx.compose.p004ui.unit.C0856Dp;
import androidx.compose.p004ui.unit.ConstraintsKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.l3;
import tb.mt2;
import tb.nt2;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
final class PaddingModifier extends InspectorValueInfo implements LayoutModifier {
    private final float bottom;
    private final float end;
    private final boolean rtlAware;
    private final float start;
    private final float top;

    private PaddingModifier(float f, float f2, float f3, float f4, boolean z, Function1<? super InspectorInfo, Unit> function1) {
        super(function1);
        this.start = f;
        this.top = f2;
        this.end = f3;
        this.bottom = f4;
        this.rtlAware = z;
        if (!((f >= 0.0f || C0856Dp.m5221equalsimpl0(f, C0856Dp.Companion.m5236getUnspecifiedD9Ej5fM())) && (f2 >= 0.0f || C0856Dp.m5221equalsimpl0(f2, C0856Dp.Companion.m5236getUnspecifiedD9Ej5fM())) && ((f3 >= 0.0f || C0856Dp.m5221equalsimpl0(f3, C0856Dp.Companion.m5236getUnspecifiedD9Ej5fM())) && (f4 >= 0.0f || C0856Dp.m5221equalsimpl0(f4, C0856Dp.Companion.m5236getUnspecifiedD9Ej5fM()))))) {
            throw new IllegalArgumentException("Padding must be non-negative".toString());
        }
    }

    public /* synthetic */ PaddingModifier(float f, float f2, float f3, float f4, boolean z, Function1 function1, DefaultConstructorMarker defaultConstructorMarker) {
        this(f, f2, f3, f4, z, function1);
    }

    @Override // androidx.compose.ui.Modifier.Element, androidx.compose.p004ui.Modifier
    public /* synthetic */ boolean all(Function1 function1) {
        return nt2.a(this, function1);
    }

    @Override // androidx.compose.ui.Modifier.Element, androidx.compose.p004ui.Modifier
    public /* synthetic */ boolean any(Function1 function1) {
        return nt2.b(this, function1);
    }

    public boolean equals(@Nullable Object obj) {
        PaddingModifier paddingModifier = obj instanceof PaddingModifier ? (PaddingModifier) obj : null;
        return paddingModifier != null && C0856Dp.m5221equalsimpl0(this.start, paddingModifier.start) && C0856Dp.m5221equalsimpl0(this.top, paddingModifier.top) && C0856Dp.m5221equalsimpl0(this.end, paddingModifier.end) && C0856Dp.m5221equalsimpl0(this.bottom, paddingModifier.bottom) && this.rtlAware == paddingModifier.rtlAware;
    }

    @Override // androidx.compose.ui.Modifier.Element, androidx.compose.p004ui.Modifier
    public /* synthetic */ Object foldIn(Object obj, Function2 function2) {
        return nt2.c(this, obj, function2);
    }

    @Override // androidx.compose.ui.Modifier.Element, androidx.compose.p004ui.Modifier
    public /* synthetic */ Object foldOut(Object obj, Function2 function2) {
        return nt2.d(this, obj, function2);
    }

    /* renamed from: getBottom-D9Ej5fM, reason: not valid java name */
    public final float m1399getBottomD9Ej5fM() {
        return this.bottom;
    }

    /* renamed from: getEnd-D9Ej5fM, reason: not valid java name */
    public final float m1400getEndD9Ej5fM() {
        return this.end;
    }

    public final boolean getRtlAware() {
        return this.rtlAware;
    }

    /* renamed from: getStart-D9Ej5fM, reason: not valid java name */
    public final float m1401getStartD9Ej5fM() {
        return this.start;
    }

    /* renamed from: getTop-D9Ej5fM, reason: not valid java name */
    public final float m1402getTopD9Ej5fM() {
        return this.top;
    }

    public int hashCode() {
        return (((((((C0856Dp.m5222hashCodeimpl(this.start) * 31) + C0856Dp.m5222hashCodeimpl(this.top)) * 31) + C0856Dp.m5222hashCodeimpl(this.end)) * 31) + C0856Dp.m5222hashCodeimpl(this.bottom)) * 31) + l3.a(this.rtlAware);
    }

    @Override // androidx.compose.p004ui.layout.LayoutModifier
    public /* synthetic */ int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        return C0790a.m141a(this, intrinsicMeasureScope, intrinsicMeasurable, i);
    }

    @Override // androidx.compose.p004ui.layout.LayoutModifier
    public /* synthetic */ int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        return C0790a.m142b(this, intrinsicMeasureScope, intrinsicMeasurable, i);
    }

    @Override // androidx.compose.p004ui.layout.LayoutModifier
    @NotNull
    /* renamed from: measure-3p2s80s */
    public MeasureResult mo959measure3p2s80s(@NotNull final MeasureScope measureScope, @NotNull Measurable measurable, long j) {
        Intrinsics.checkNotNullParameter(measureScope, "$this$measure");
        Intrinsics.checkNotNullParameter(measurable, "measurable");
        int mo1277roundToPx0680j_4 = measureScope.mo1277roundToPx0680j_4(this.start) + measureScope.mo1277roundToPx0680j_4(this.end);
        int mo1277roundToPx0680j_42 = measureScope.mo1277roundToPx0680j_4(this.top) + measureScope.mo1277roundToPx0680j_4(this.bottom);
        final Placeable mo4187measureBRTryo0 = measurable.mo4187measureBRTryo0(ConstraintsKt.m5200offsetNN6EwU(j, -mo1277roundToPx0680j_4, -mo1277roundToPx0680j_42));
        return MeasureScope.CC.m140p(measureScope, ConstraintsKt.m5198constrainWidthK40F9xA(j, mo4187measureBRTryo0.getWidth() + mo1277roundToPx0680j_4), ConstraintsKt.m5197constrainHeightK40F9xA(j, mo4187measureBRTryo0.getHeight() + mo1277roundToPx0680j_42), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.layout.PaddingModifier$measure$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Placeable.PlacementScope) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull Placeable.PlacementScope placementScope) {
                Intrinsics.checkNotNullParameter(placementScope, "$this$layout");
                if (PaddingModifier.this.getRtlAware()) {
                    Placeable.PlacementScope.placeRelative$default(placementScope, mo4187measureBRTryo0, measureScope.mo1277roundToPx0680j_4(PaddingModifier.this.m1401getStartD9Ej5fM()), measureScope.mo1277roundToPx0680j_4(PaddingModifier.this.m1402getTopD9Ej5fM()), 0.0f, 4, null);
                } else {
                    Placeable.PlacementScope.place$default(placementScope, mo4187measureBRTryo0, measureScope.mo1277roundToPx0680j_4(PaddingModifier.this.m1401getStartD9Ej5fM()), measureScope.mo1277roundToPx0680j_4(PaddingModifier.this.m1402getTopD9Ej5fM()), 0.0f, 4, null);
                }
            }
        }, 4, null);
    }

    @Override // androidx.compose.p004ui.layout.LayoutModifier
    public /* synthetic */ int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        return C0790a.m143c(this, intrinsicMeasureScope, intrinsicMeasurable, i);
    }

    @Override // androidx.compose.p004ui.layout.LayoutModifier
    public /* synthetic */ int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        return C0790a.m144d(this, intrinsicMeasureScope, intrinsicMeasurable, i);
    }

    @Override // androidx.compose.p004ui.Modifier
    public /* synthetic */ Modifier then(Modifier modifier) {
        return mt2.a(this, modifier);
    }

    public /* synthetic */ PaddingModifier(float f, float f2, float f3, float f4, boolean z, Function1 function1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? C0856Dp.m5216constructorimpl(0) : f, (i & 2) != 0 ? C0856Dp.m5216constructorimpl(0) : f2, (i & 4) != 0 ? C0856Dp.m5216constructorimpl(0) : f3, (i & 8) != 0 ? C0856Dp.m5216constructorimpl(0) : f4, z, function1, null);
    }
}
