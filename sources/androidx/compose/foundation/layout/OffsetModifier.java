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
/* loaded from: classes.dex */
final class OffsetModifier extends InspectorValueInfo implements LayoutModifier {
    private final boolean rtlAware;

    /* renamed from: x */
    private final float f82x;

    /* renamed from: y */
    private final float f83y;

    private OffsetModifier(float f, float f2, boolean z, Function1<? super InspectorInfo, Unit> function1) {
        super(function1);
        this.f82x = f;
        this.f83y = f2;
        this.rtlAware = z;
    }

    public /* synthetic */ OffsetModifier(float f, float f2, boolean z, Function1 function1, DefaultConstructorMarker defaultConstructorMarker) {
        this(f, f2, z, function1);
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
        OffsetModifier offsetModifier = obj instanceof OffsetModifier ? (OffsetModifier) obj : null;
        return offsetModifier != null && C0856Dp.m5221equalsimpl0(this.f82x, offsetModifier.f82x) && C0856Dp.m5221equalsimpl0(this.f83y, offsetModifier.f83y) && this.rtlAware == offsetModifier.rtlAware;
    }

    @Override // androidx.compose.ui.Modifier.Element, androidx.compose.p004ui.Modifier
    public /* synthetic */ Object foldIn(Object obj, Function2 function2) {
        return nt2.c(this, obj, function2);
    }

    @Override // androidx.compose.ui.Modifier.Element, androidx.compose.p004ui.Modifier
    public /* synthetic */ Object foldOut(Object obj, Function2 function2) {
        return nt2.d(this, obj, function2);
    }

    public final boolean getRtlAware() {
        return this.rtlAware;
    }

    /* renamed from: getX-D9Ej5fM, reason: not valid java name */
    public final float m1384getXD9Ej5fM() {
        return this.f82x;
    }

    /* renamed from: getY-D9Ej5fM, reason: not valid java name */
    public final float m1385getYD9Ej5fM() {
        return this.f83y;
    }

    public int hashCode() {
        return (((C0856Dp.m5222hashCodeimpl(this.f82x) * 31) + C0856Dp.m5222hashCodeimpl(this.f83y)) * 31) + l3.a(this.rtlAware);
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
        final Placeable mo4187measureBRTryo0 = measurable.mo4187measureBRTryo0(j);
        return MeasureScope.CC.m140p(measureScope, mo4187measureBRTryo0.getWidth(), mo4187measureBRTryo0.getHeight(), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.layout.OffsetModifier$measure$1
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
                if (OffsetModifier.this.getRtlAware()) {
                    Placeable.PlacementScope.placeRelative$default(placementScope, mo4187measureBRTryo0, measureScope.mo1277roundToPx0680j_4(OffsetModifier.this.m1384getXD9Ej5fM()), measureScope.mo1277roundToPx0680j_4(OffsetModifier.this.m1385getYD9Ej5fM()), 0.0f, 4, null);
                } else {
                    Placeable.PlacementScope.place$default(placementScope, mo4187measureBRTryo0, measureScope.mo1277roundToPx0680j_4(OffsetModifier.this.m1384getXD9Ej5fM()), measureScope.mo1277roundToPx0680j_4(OffsetModifier.this.m1385getYD9Ej5fM()), 0.0f, 4, null);
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

    @NotNull
    public String toString() {
        return "OffsetModifier(x=" + ((Object) C0856Dp.m5227toStringimpl(this.f82x)) + ", y=" + ((Object) C0856Dp.m5227toStringimpl(this.f83y)) + ", rtlAware=" + this.rtlAware + ')';
    }
}
