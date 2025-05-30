package androidx.compose.foundation.layout;

import androidx.compose.p004ui.Modifier;
import androidx.compose.p004ui.layout.IntrinsicMeasurable;
import androidx.compose.p004ui.layout.IntrinsicMeasureScope;
import androidx.compose.p004ui.layout.LayoutModifier;
import androidx.compose.p004ui.layout.Measurable;
import androidx.compose.p004ui.layout.MeasureResult;
import androidx.compose.p004ui.layout.MeasureScope;
import androidx.compose.p004ui.layout.Placeable;
import androidx.compose.p004ui.platform.InspectorInfo;
import androidx.compose.p004ui.platform.InspectorValueInfo;
import androidx.compose.p004ui.unit.Constraints;
import androidx.compose.p004ui.unit.ConstraintsKt;
import androidx.compose.p004ui.unit.IntSize;
import androidx.compose.p004ui.unit.IntSizeKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.l3;
import tb.mt2;
import tb.nt2;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
final class AspectRatioModifier extends InspectorValueInfo implements LayoutModifier {
    private final float aspectRatio;
    private final boolean matchHeightConstraintsFirst;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AspectRatioModifier(float f, boolean z, @NotNull Function1<? super InspectorInfo, Unit> function1) {
        super(function1);
        Intrinsics.checkNotNullParameter(function1, "inspectorInfo");
        this.aspectRatio = f;
        this.matchHeightConstraintsFirst = z;
        if (f > ((float) 0)) {
            return;
        }
        throw new IllegalArgumentException(("aspectRatio " + f + " must be > 0").toString());
    }

    /* renamed from: findSize-ToXhtMw, reason: not valid java name */
    private final long m1355findSizeToXhtMw(long j) {
        if (this.matchHeightConstraintsFirst) {
            long m1357tryMaxHeightJN0ABg$default = m1357tryMaxHeightJN0ABg$default(this, j, false, 1, null);
            IntSize.Companion companion = IntSize.Companion;
            if (!IntSize.m5374equalsimpl0(m1357tryMaxHeightJN0ABg$default, companion.m5381getZeroYbymL2g())) {
                return m1357tryMaxHeightJN0ABg$default;
            }
            long m1359tryMaxWidthJN0ABg$default = m1359tryMaxWidthJN0ABg$default(this, j, false, 1, null);
            if (!IntSize.m5374equalsimpl0(m1359tryMaxWidthJN0ABg$default, companion.m5381getZeroYbymL2g())) {
                return m1359tryMaxWidthJN0ABg$default;
            }
            long m1361tryMinHeightJN0ABg$default = m1361tryMinHeightJN0ABg$default(this, j, false, 1, null);
            if (!IntSize.m5374equalsimpl0(m1361tryMinHeightJN0ABg$default, companion.m5381getZeroYbymL2g())) {
                return m1361tryMinHeightJN0ABg$default;
            }
            long m1363tryMinWidthJN0ABg$default = m1363tryMinWidthJN0ABg$default(this, j, false, 1, null);
            if (!IntSize.m5374equalsimpl0(m1363tryMinWidthJN0ABg$default, companion.m5381getZeroYbymL2g())) {
                return m1363tryMinWidthJN0ABg$default;
            }
            long m1356tryMaxHeightJN0ABg = m1356tryMaxHeightJN0ABg(j, false);
            if (!IntSize.m5374equalsimpl0(m1356tryMaxHeightJN0ABg, companion.m5381getZeroYbymL2g())) {
                return m1356tryMaxHeightJN0ABg;
            }
            long m1358tryMaxWidthJN0ABg = m1358tryMaxWidthJN0ABg(j, false);
            if (!IntSize.m5374equalsimpl0(m1358tryMaxWidthJN0ABg, companion.m5381getZeroYbymL2g())) {
                return m1358tryMaxWidthJN0ABg;
            }
            long m1360tryMinHeightJN0ABg = m1360tryMinHeightJN0ABg(j, false);
            if (!IntSize.m5374equalsimpl0(m1360tryMinHeightJN0ABg, companion.m5381getZeroYbymL2g())) {
                return m1360tryMinHeightJN0ABg;
            }
            long m1362tryMinWidthJN0ABg = m1362tryMinWidthJN0ABg(j, false);
            if (!IntSize.m5374equalsimpl0(m1362tryMinWidthJN0ABg, companion.m5381getZeroYbymL2g())) {
                return m1362tryMinWidthJN0ABg;
            }
        } else {
            long m1359tryMaxWidthJN0ABg$default2 = m1359tryMaxWidthJN0ABg$default(this, j, false, 1, null);
            IntSize.Companion companion2 = IntSize.Companion;
            if (!IntSize.m5374equalsimpl0(m1359tryMaxWidthJN0ABg$default2, companion2.m5381getZeroYbymL2g())) {
                return m1359tryMaxWidthJN0ABg$default2;
            }
            long m1357tryMaxHeightJN0ABg$default2 = m1357tryMaxHeightJN0ABg$default(this, j, false, 1, null);
            if (!IntSize.m5374equalsimpl0(m1357tryMaxHeightJN0ABg$default2, companion2.m5381getZeroYbymL2g())) {
                return m1357tryMaxHeightJN0ABg$default2;
            }
            long m1363tryMinWidthJN0ABg$default2 = m1363tryMinWidthJN0ABg$default(this, j, false, 1, null);
            if (!IntSize.m5374equalsimpl0(m1363tryMinWidthJN0ABg$default2, companion2.m5381getZeroYbymL2g())) {
                return m1363tryMinWidthJN0ABg$default2;
            }
            long m1361tryMinHeightJN0ABg$default2 = m1361tryMinHeightJN0ABg$default(this, j, false, 1, null);
            if (!IntSize.m5374equalsimpl0(m1361tryMinHeightJN0ABg$default2, companion2.m5381getZeroYbymL2g())) {
                return m1361tryMinHeightJN0ABg$default2;
            }
            long m1358tryMaxWidthJN0ABg2 = m1358tryMaxWidthJN0ABg(j, false);
            if (!IntSize.m5374equalsimpl0(m1358tryMaxWidthJN0ABg2, companion2.m5381getZeroYbymL2g())) {
                return m1358tryMaxWidthJN0ABg2;
            }
            long m1356tryMaxHeightJN0ABg2 = m1356tryMaxHeightJN0ABg(j, false);
            if (!IntSize.m5374equalsimpl0(m1356tryMaxHeightJN0ABg2, companion2.m5381getZeroYbymL2g())) {
                return m1356tryMaxHeightJN0ABg2;
            }
            long m1362tryMinWidthJN0ABg2 = m1362tryMinWidthJN0ABg(j, false);
            if (!IntSize.m5374equalsimpl0(m1362tryMinWidthJN0ABg2, companion2.m5381getZeroYbymL2g())) {
                return m1362tryMinWidthJN0ABg2;
            }
            long m1360tryMinHeightJN0ABg2 = m1360tryMinHeightJN0ABg(j, false);
            if (!IntSize.m5374equalsimpl0(m1360tryMinHeightJN0ABg2, companion2.m5381getZeroYbymL2g())) {
                return m1360tryMinHeightJN0ABg2;
            }
        }
        return IntSize.Companion.m5381getZeroYbymL2g();
    }

    /* renamed from: tryMaxHeight-JN-0ABg, reason: not valid java name */
    private final long m1356tryMaxHeightJN0ABg(long j, boolean z) {
        int roundToInt;
        int m5183getMaxHeightimpl = Constraints.m5183getMaxHeightimpl(j);
        if (m5183getMaxHeightimpl != Integer.MAX_VALUE && (roundToInt = MathKt.roundToInt(m5183getMaxHeightimpl * this.aspectRatio)) > 0) {
            long IntSize = IntSizeKt.IntSize(roundToInt, m5183getMaxHeightimpl);
            if (!z || ConstraintsKt.m5199isSatisfiedBy4WqzIAM(j, IntSize)) {
                return IntSize;
            }
        }
        return IntSize.Companion.m5381getZeroYbymL2g();
    }

    /* renamed from: tryMaxHeight-JN-0ABg$default, reason: not valid java name */
    static /* synthetic */ long m1357tryMaxHeightJN0ABg$default(AspectRatioModifier aspectRatioModifier, long j, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        return aspectRatioModifier.m1356tryMaxHeightJN0ABg(j, z);
    }

    /* renamed from: tryMaxWidth-JN-0ABg, reason: not valid java name */
    private final long m1358tryMaxWidthJN0ABg(long j, boolean z) {
        int roundToInt;
        int m5184getMaxWidthimpl = Constraints.m5184getMaxWidthimpl(j);
        if (m5184getMaxWidthimpl != Integer.MAX_VALUE && (roundToInt = MathKt.roundToInt(m5184getMaxWidthimpl / this.aspectRatio)) > 0) {
            long IntSize = IntSizeKt.IntSize(m5184getMaxWidthimpl, roundToInt);
            if (!z || ConstraintsKt.m5199isSatisfiedBy4WqzIAM(j, IntSize)) {
                return IntSize;
            }
        }
        return IntSize.Companion.m5381getZeroYbymL2g();
    }

    /* renamed from: tryMaxWidth-JN-0ABg$default, reason: not valid java name */
    static /* synthetic */ long m1359tryMaxWidthJN0ABg$default(AspectRatioModifier aspectRatioModifier, long j, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        return aspectRatioModifier.m1358tryMaxWidthJN0ABg(j, z);
    }

    /* renamed from: tryMinHeight-JN-0ABg, reason: not valid java name */
    private final long m1360tryMinHeightJN0ABg(long j, boolean z) {
        int m5185getMinHeightimpl = Constraints.m5185getMinHeightimpl(j);
        int roundToInt = MathKt.roundToInt(m5185getMinHeightimpl * this.aspectRatio);
        if (roundToInt > 0) {
            long IntSize = IntSizeKt.IntSize(roundToInt, m5185getMinHeightimpl);
            if (!z || ConstraintsKt.m5199isSatisfiedBy4WqzIAM(j, IntSize)) {
                return IntSize;
            }
        }
        return IntSize.Companion.m5381getZeroYbymL2g();
    }

    /* renamed from: tryMinHeight-JN-0ABg$default, reason: not valid java name */
    static /* synthetic */ long m1361tryMinHeightJN0ABg$default(AspectRatioModifier aspectRatioModifier, long j, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        return aspectRatioModifier.m1360tryMinHeightJN0ABg(j, z);
    }

    /* renamed from: tryMinWidth-JN-0ABg, reason: not valid java name */
    private final long m1362tryMinWidthJN0ABg(long j, boolean z) {
        int m5186getMinWidthimpl = Constraints.m5186getMinWidthimpl(j);
        int roundToInt = MathKt.roundToInt(m5186getMinWidthimpl / this.aspectRatio);
        if (roundToInt > 0) {
            long IntSize = IntSizeKt.IntSize(m5186getMinWidthimpl, roundToInt);
            if (!z || ConstraintsKt.m5199isSatisfiedBy4WqzIAM(j, IntSize)) {
                return IntSize;
            }
        }
        return IntSize.Companion.m5381getZeroYbymL2g();
    }

    /* renamed from: tryMinWidth-JN-0ABg$default, reason: not valid java name */
    static /* synthetic */ long m1363tryMinWidthJN0ABg$default(AspectRatioModifier aspectRatioModifier, long j, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        return aspectRatioModifier.m1362tryMinWidthJN0ABg(j, z);
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
        if (this == obj) {
            return true;
        }
        AspectRatioModifier aspectRatioModifier = obj instanceof AspectRatioModifier ? (AspectRatioModifier) obj : null;
        if (aspectRatioModifier == null) {
            return false;
        }
        return ((this.aspectRatio > aspectRatioModifier.aspectRatio ? 1 : (this.aspectRatio == aspectRatioModifier.aspectRatio ? 0 : -1)) == 0) && this.matchHeightConstraintsFirst == ((AspectRatioModifier) obj).matchHeightConstraintsFirst;
    }

    @Override // androidx.compose.ui.Modifier.Element, androidx.compose.p004ui.Modifier
    public /* synthetic */ Object foldIn(Object obj, Function2 function2) {
        return nt2.c(this, obj, function2);
    }

    @Override // androidx.compose.ui.Modifier.Element, androidx.compose.p004ui.Modifier
    public /* synthetic */ Object foldOut(Object obj, Function2 function2) {
        return nt2.d(this, obj, function2);
    }

    public final float getAspectRatio() {
        return this.aspectRatio;
    }

    public final boolean getMatchHeightConstraintsFirst() {
        return this.matchHeightConstraintsFirst;
    }

    public int hashCode() {
        return (Float.floatToIntBits(this.aspectRatio) * 31) + l3.a(this.matchHeightConstraintsFirst);
    }

    @Override // androidx.compose.p004ui.layout.LayoutModifier
    public int maxIntrinsicHeight(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull IntrinsicMeasurable intrinsicMeasurable, int i) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        Intrinsics.checkNotNullParameter(intrinsicMeasurable, "measurable");
        return i != Integer.MAX_VALUE ? MathKt.roundToInt(i / this.aspectRatio) : intrinsicMeasurable.maxIntrinsicHeight(i);
    }

    @Override // androidx.compose.p004ui.layout.LayoutModifier
    public int maxIntrinsicWidth(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull IntrinsicMeasurable intrinsicMeasurable, int i) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        Intrinsics.checkNotNullParameter(intrinsicMeasurable, "measurable");
        return i != Integer.MAX_VALUE ? MathKt.roundToInt(i * this.aspectRatio) : intrinsicMeasurable.maxIntrinsicWidth(i);
    }

    @Override // androidx.compose.p004ui.layout.LayoutModifier
    @NotNull
    /* renamed from: measure-3p2s80s */
    public MeasureResult mo959measure3p2s80s(@NotNull MeasureScope measureScope, @NotNull Measurable measurable, long j) {
        Intrinsics.checkNotNullParameter(measureScope, "$this$measure");
        Intrinsics.checkNotNullParameter(measurable, "measurable");
        long m1355findSizeToXhtMw = m1355findSizeToXhtMw(j);
        if (!IntSize.m5374equalsimpl0(m1355findSizeToXhtMw, IntSize.Companion.m5381getZeroYbymL2g())) {
            j = Constraints.Companion.m5192fixedJhjzzOo(IntSize.m5376getWidthimpl(m1355findSizeToXhtMw), IntSize.m5375getHeightimpl(m1355findSizeToXhtMw));
        }
        final Placeable mo4187measureBRTryo0 = measurable.mo4187measureBRTryo0(j);
        return MeasureScope.CC.m140p(measureScope, mo4187measureBRTryo0.getWidth(), mo4187measureBRTryo0.getHeight(), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.layout.AspectRatioModifier$measure$1
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
        return i != Integer.MAX_VALUE ? MathKt.roundToInt(i / this.aspectRatio) : intrinsicMeasurable.minIntrinsicHeight(i);
    }

    @Override // androidx.compose.p004ui.layout.LayoutModifier
    public int minIntrinsicWidth(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull IntrinsicMeasurable intrinsicMeasurable, int i) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        Intrinsics.checkNotNullParameter(intrinsicMeasurable, "measurable");
        return i != Integer.MAX_VALUE ? MathKt.roundToInt(i * this.aspectRatio) : intrinsicMeasurable.minIntrinsicWidth(i);
    }

    @Override // androidx.compose.p004ui.Modifier
    public /* synthetic */ Modifier then(Modifier modifier) {
        return mt2.a(this, modifier);
    }

    @NotNull
    public String toString() {
        return "AspectRatioModifier(aspectRatio=" + this.aspectRatio + ')';
    }
}
