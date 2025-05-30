package androidx.compose.foundation.layout;

import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.LayoutModifier;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.MeasureScope$CC;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.Placeable$PlacementScope;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.IntOffset;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
interface IntrinsicSizeModifier extends LayoutModifier {

    /* compiled from: Taobao */
    /* renamed from: androidx.compose.foundation.layout.IntrinsicSizeModifier$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static boolean a(IntrinsicSizeModifier intrinsicSizeModifier) {
            return true;
        }

        public static int b(@NotNull IntrinsicSizeModifier _this, @NotNull IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
            Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
            Intrinsics.checkNotNullParameter(intrinsicMeasurable, "measurable");
            return intrinsicMeasurable.maxIntrinsicHeight(i);
        }

        public static int c(@NotNull IntrinsicSizeModifier _this, @NotNull IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
            Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
            Intrinsics.checkNotNullParameter(intrinsicMeasurable, "measurable");
            return intrinsicMeasurable.maxIntrinsicWidth(i);
        }

        @NotNull
        public static MeasureResult d(@NotNull IntrinsicSizeModifier _this, @NotNull MeasureScope measureScope, Measurable measurable, long j) {
            Intrinsics.checkNotNullParameter(measureScope, "$this$measure");
            Intrinsics.checkNotNullParameter(measurable, "measurable");
            long mo319calculateContentConstraintsl58MMJ0 = _this.mo319calculateContentConstraintsl58MMJ0(measureScope, measurable, j);
            if (_this.getEnforceIncoming()) {
                mo319calculateContentConstraintsl58MMJ0 = ConstraintsKt.constrain-N9IONVI(j, mo319calculateContentConstraintsl58MMJ0);
            }
            final Placeable placeable = measurable.measure-BRTryo0(mo319calculateContentConstraintsl58MMJ0);
            return MeasureScope$CC.p(measureScope, placeable.getWidth(), placeable.getHeight(), null, new Function1<Placeable$PlacementScope, Unit>() { // from class: androidx.compose.foundation.layout.IntrinsicSizeModifier$measure$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((Placeable$PlacementScope) obj);
                    return Unit.INSTANCE;
                }

                public final void invoke(@NotNull Placeable$PlacementScope placeable$PlacementScope) {
                    Intrinsics.checkNotNullParameter(placeable$PlacementScope, "$this$layout");
                    Placeable$PlacementScope.m2069placeRelative70tqf50$default(placeable$PlacementScope, placeable, IntOffset.Companion.m2653getZeronOccac(), 0.0f, 2, null);
                }
            }, 4, null);
        }

        public static int e(@NotNull IntrinsicSizeModifier _this, @NotNull IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
            Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
            Intrinsics.checkNotNullParameter(intrinsicMeasurable, "measurable");
            return intrinsicMeasurable.minIntrinsicHeight(i);
        }

        public static int f(@NotNull IntrinsicSizeModifier _this, @NotNull IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
            Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
            Intrinsics.checkNotNullParameter(intrinsicMeasurable, "measurable");
            return intrinsicMeasurable.minIntrinsicWidth(i);
        }
    }

    /* renamed from: calculateContentConstraints-l58MMJ0, reason: not valid java name */
    long mo319calculateContentConstraintsl58MMJ0(@NotNull MeasureScope measureScope, @NotNull Measurable measurable, long j);

    boolean getEnforceIncoming();

    @Override // androidx.compose.ui.layout.LayoutModifier
    int maxIntrinsicHeight(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull IntrinsicMeasurable intrinsicMeasurable, int i);

    @Override // androidx.compose.ui.layout.LayoutModifier
    int maxIntrinsicWidth(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull IntrinsicMeasurable intrinsicMeasurable, int i);

    @Override // androidx.compose.ui.layout.LayoutModifier
    @NotNull
    /* renamed from: measure-3p2s80s */
    MeasureResult mo49measure3p2s80s(@NotNull MeasureScope measureScope, @NotNull Measurable measurable, long j);

    @Override // androidx.compose.ui.layout.LayoutModifier
    int minIntrinsicHeight(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull IntrinsicMeasurable intrinsicMeasurable, int i);

    @Override // androidx.compose.ui.layout.LayoutModifier
    int minIntrinsicWidth(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull IntrinsicMeasurable intrinsicMeasurable, int i);
}
