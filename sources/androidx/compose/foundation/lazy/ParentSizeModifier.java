package androidx.compose.foundation.lazy;

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
import androidx.compose.p004ui.unit.Constraints;
import androidx.compose.p004ui.unit.ConstraintsKt;
import androidx.compose.runtime.State;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.mt2;
import tb.nt2;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
final class ParentSizeModifier extends InspectorValueInfo implements LayoutModifier {
    private final float fraction;

    @Nullable
    private final State<Integer> heightState;

    @Nullable
    private final State<Integer> widthState;

    public /* synthetic */ ParentSizeModifier(float f, Function1 function1, State state, State state2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(f, function1, (i & 4) != 0 ? null : state, (i & 8) != 0 ? null : state2);
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
        if (!(obj instanceof ParentSizeModifier)) {
            return false;
        }
        ParentSizeModifier parentSizeModifier = (ParentSizeModifier) obj;
        if (Intrinsics.areEqual(this.widthState, parentSizeModifier.widthState) && Intrinsics.areEqual(this.heightState, parentSizeModifier.heightState)) {
            if (this.fraction == parentSizeModifier.fraction) {
                return true;
            }
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

    public final float getFraction() {
        return this.fraction;
    }

    @Nullable
    public final State<Integer> getHeightState() {
        return this.heightState;
    }

    @Nullable
    public final State<Integer> getWidthState() {
        return this.widthState;
    }

    public int hashCode() {
        State<Integer> state = this.widthState;
        int hashCode = (state != null ? state.hashCode() : 0) * 31;
        State<Integer> state2 = this.heightState;
        return ((hashCode + (state2 != null ? state2.hashCode() : 0)) * 31) + Float.floatToIntBits(this.fraction);
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
    public MeasureResult mo959measure3p2s80s(@NotNull MeasureScope measureScope, @NotNull Measurable measurable, long j) {
        Intrinsics.checkNotNullParameter(measureScope, "$this$measure");
        Intrinsics.checkNotNullParameter(measurable, "measurable");
        State<Integer> state = this.widthState;
        int roundToInt = (state == null || state.getValue().intValue() == Integer.MAX_VALUE) ? Integer.MAX_VALUE : MathKt.roundToInt(this.widthState.getValue().floatValue() * this.fraction);
        State<Integer> state2 = this.heightState;
        int roundToInt2 = (state2 == null || state2.getValue().intValue() == Integer.MAX_VALUE) ? Integer.MAX_VALUE : MathKt.roundToInt(this.heightState.getValue().floatValue() * this.fraction);
        int m5186getMinWidthimpl = roundToInt != Integer.MAX_VALUE ? roundToInt : Constraints.m5186getMinWidthimpl(j);
        int m5185getMinHeightimpl = roundToInt2 != Integer.MAX_VALUE ? roundToInt2 : Constraints.m5185getMinHeightimpl(j);
        if (roundToInt == Integer.MAX_VALUE) {
            roundToInt = Constraints.m5184getMaxWidthimpl(j);
        }
        if (roundToInt2 == Integer.MAX_VALUE) {
            roundToInt2 = Constraints.m5183getMaxHeightimpl(j);
        }
        final Placeable mo4187measureBRTryo0 = measurable.mo4187measureBRTryo0(ConstraintsKt.Constraints(m5186getMinWidthimpl, roundToInt, m5185getMinHeightimpl, roundToInt2));
        return MeasureScope.CC.m140p(measureScope, mo4187measureBRTryo0.getWidth(), mo4187measureBRTryo0.getHeight(), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.lazy.ParentSizeModifier$measure$1
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Placeable.PlacementScope) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull Placeable.PlacementScope placementScope) {
                Intrinsics.checkNotNullParameter(placementScope, "$this$layout");
                Placeable.PlacementScope.place$default(placementScope, Placeable.this, 0, 0, 0.0f, 4, null);
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

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ParentSizeModifier(float f, @NotNull Function1<? super InspectorInfo, Unit> function1, @Nullable State<Integer> state, @Nullable State<Integer> state2) {
        super(function1);
        Intrinsics.checkNotNullParameter(function1, "inspectorInfo");
        this.fraction = f;
        this.widthState = state;
        this.heightState = state2;
    }
}
