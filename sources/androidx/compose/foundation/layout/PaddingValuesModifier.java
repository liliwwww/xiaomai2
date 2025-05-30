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
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.mt2;
import tb.nt2;

/* compiled from: Taobao */
/* loaded from: classes.dex */
final class PaddingValuesModifier extends InspectorValueInfo implements LayoutModifier {

    @NotNull
    private final PaddingValues paddingValues;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PaddingValuesModifier(@NotNull PaddingValues paddingValues, @NotNull Function1<? super InspectorInfo, Unit> function1) {
        super(function1);
        Intrinsics.checkNotNullParameter(paddingValues, "paddingValues");
        Intrinsics.checkNotNullParameter(function1, "inspectorInfo");
        this.paddingValues = paddingValues;
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
        PaddingValuesModifier paddingValuesModifier = obj instanceof PaddingValuesModifier ? (PaddingValuesModifier) obj : null;
        if (paddingValuesModifier == null) {
            return false;
        }
        return Intrinsics.areEqual(this.paddingValues, paddingValuesModifier.paddingValues);
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
    public final PaddingValues getPaddingValues() {
        return this.paddingValues;
    }

    public int hashCode() {
        return this.paddingValues.hashCode();
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
        boolean z = false;
        float f = 0;
        if (C0856Dp.m5215compareTo0680j_4(this.paddingValues.mo1375calculateLeftPaddingu2uoSUM(measureScope.getLayoutDirection()), C0856Dp.m5216constructorimpl(f)) >= 0 && C0856Dp.m5215compareTo0680j_4(this.paddingValues.mo1377calculateTopPaddingD9Ej5fM(), C0856Dp.m5216constructorimpl(f)) >= 0 && C0856Dp.m5215compareTo0680j_4(this.paddingValues.mo1376calculateRightPaddingu2uoSUM(measureScope.getLayoutDirection()), C0856Dp.m5216constructorimpl(f)) >= 0 && C0856Dp.m5215compareTo0680j_4(this.paddingValues.mo1374calculateBottomPaddingD9Ej5fM(), C0856Dp.m5216constructorimpl(f)) >= 0) {
            z = true;
        }
        if (!z) {
            throw new IllegalArgumentException("Padding must be non-negative".toString());
        }
        int mo1277roundToPx0680j_4 = measureScope.mo1277roundToPx0680j_4(this.paddingValues.mo1375calculateLeftPaddingu2uoSUM(measureScope.getLayoutDirection())) + measureScope.mo1277roundToPx0680j_4(this.paddingValues.mo1376calculateRightPaddingu2uoSUM(measureScope.getLayoutDirection()));
        int mo1277roundToPx0680j_42 = measureScope.mo1277roundToPx0680j_4(this.paddingValues.mo1377calculateTopPaddingD9Ej5fM()) + measureScope.mo1277roundToPx0680j_4(this.paddingValues.mo1374calculateBottomPaddingD9Ej5fM());
        final Placeable mo4187measureBRTryo0 = measurable.mo4187measureBRTryo0(ConstraintsKt.m5200offsetNN6EwU(j, -mo1277roundToPx0680j_4, -mo1277roundToPx0680j_42));
        return MeasureScope.CC.m140p(measureScope, ConstraintsKt.m5198constrainWidthK40F9xA(j, mo4187measureBRTryo0.getWidth() + mo1277roundToPx0680j_4), ConstraintsKt.m5197constrainHeightK40F9xA(j, mo4187measureBRTryo0.getHeight() + mo1277roundToPx0680j_42), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.layout.PaddingValuesModifier$measure$2
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
                Placeable.PlacementScope.place$default(placementScope, Placeable.this, measureScope.mo1277roundToPx0680j_4(this.getPaddingValues().mo1375calculateLeftPaddingu2uoSUM(measureScope.getLayoutDirection())), measureScope.mo1277roundToPx0680j_4(this.getPaddingValues().mo1377calculateTopPaddingD9Ej5fM()), 0.0f, 4, null);
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
}
