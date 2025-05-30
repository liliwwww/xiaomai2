package androidx.compose.foundation.layout;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.LayoutModifier;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.a;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.platform.InspectorValueInfo;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Dp;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.mt2;
import tb.nt2;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
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

    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ boolean all(Function1 function1) {
        return nt2.a(this, function1);
    }

    /* JADX WARN: Multi-variable type inference failed */
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

    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ Object foldIn(Object obj, Function2 function2) {
        return nt2.c(this, obj, function2);
    }

    /* JADX WARN: Multi-variable type inference failed */
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

    public /* synthetic */ int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        return a.a(this, intrinsicMeasureScope, intrinsicMeasurable, i);
    }

    public /* synthetic */ int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        return a.b(this, intrinsicMeasureScope, intrinsicMeasurable, i);
    }

    @NotNull
    /* renamed from: measure-3p2s80s, reason: not valid java name */
    public MeasureResult m228measure3p2s80s(@NotNull MeasureScope measureScope, @NotNull Measurable measurable, long j) {
        Intrinsics.checkNotNullParameter(measureScope, "$this$measure");
        Intrinsics.checkNotNullParameter(measurable, "measurable");
        boolean z = false;
        float f = 0;
        if (Dp.m2141compareTo0680j_4(this.paddingValues.mo217calculateLeftPaddingu2uoSUM(measureScope.getLayoutDirection()), Dp.m2142constructorimpl(f)) >= 0 && Dp.m2141compareTo0680j_4(this.paddingValues.mo219calculateTopPaddingD9Ej5fM(), Dp.m2142constructorimpl(f)) >= 0 && Dp.m2141compareTo0680j_4(this.paddingValues.mo218calculateRightPaddingu2uoSUM(measureScope.getLayoutDirection()), Dp.m2142constructorimpl(f)) >= 0 && Dp.m2141compareTo0680j_4(this.paddingValues.mo216calculateBottomPaddingD9Ej5fM(), Dp.m2142constructorimpl(f)) >= 0) {
            z = true;
        }
        if (!z) {
            throw new IllegalArgumentException("Padding must be non-negative".toString());
        }
        int mo319roundToPx0680j_4 = measureScope.mo319roundToPx0680j_4(this.paddingValues.mo217calculateLeftPaddingu2uoSUM(measureScope.getLayoutDirection())) + measureScope.mo319roundToPx0680j_4(this.paddingValues.mo218calculateRightPaddingu2uoSUM(measureScope.getLayoutDirection()));
        int mo319roundToPx0680j_42 = measureScope.mo319roundToPx0680j_4(this.paddingValues.mo219calculateTopPaddingD9Ej5fM()) + measureScope.mo319roundToPx0680j_4(this.paddingValues.mo216calculateBottomPaddingD9Ej5fM());
        Placeable mo1521measureBRTryo0 = measurable.mo1521measureBRTryo0(ConstraintsKt.m2138offsetNN6EwU(j, -mo319roundToPx0680j_4, -mo319roundToPx0680j_42));
        return MeasureScope.-CC.p(measureScope, ConstraintsKt.m2136constrainWidthK40F9xA(j, mo1521measureBRTryo0.getWidth() + mo319roundToPx0680j_4), ConstraintsKt.m2135constrainHeightK40F9xA(j, mo1521measureBRTryo0.getHeight() + mo319roundToPx0680j_42), (Map) null, new measure.2(mo1521measureBRTryo0, measureScope, this), 4, (Object) null);
    }

    public /* synthetic */ int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        return a.c(this, intrinsicMeasureScope, intrinsicMeasurable, i);
    }

    public /* synthetic */ int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        return a.d(this, intrinsicMeasureScope, intrinsicMeasurable, i);
    }

    public /* synthetic */ Modifier then(Modifier modifier) {
        return mt2.a(this, modifier);
    }
}
