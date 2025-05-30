package androidx.compose.foundation.layout;

import androidx.compose.p004ui.layout.IntrinsicMeasurable;
import androidx.compose.p004ui.layout.IntrinsicMeasureScope;
import androidx.compose.p004ui.layout.LayoutModifier;
import androidx.compose.p004ui.layout.Measurable;
import androidx.compose.p004ui.layout.MeasureResult;
import androidx.compose.p004ui.layout.MeasureScope;
import androidx.compose.p004ui.layout.Placeable;
import androidx.compose.p004ui.unit.ConstraintsKt;
import androidx.compose.p004ui.unit.IntOffset;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
interface IntrinsicSizeModifier extends LayoutModifier {

    /* compiled from: Taobao */
    /* renamed from: androidx.compose.foundation.layout.IntrinsicSizeModifier$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        /* renamed from: a */
        public static boolean m57a(IntrinsicSizeModifier intrinsicSizeModifier) {
            return true;
        }

        /* renamed from: b */
        public static int m58b(@NotNull IntrinsicSizeModifier _this, @NotNull IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
            Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
            Intrinsics.checkNotNullParameter(intrinsicMeasurable, "measurable");
            return intrinsicMeasurable.maxIntrinsicHeight(i);
        }

        /* renamed from: c */
        public static int m59c(@NotNull IntrinsicSizeModifier _this, @NotNull IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
            Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
            Intrinsics.checkNotNullParameter(intrinsicMeasurable, "measurable");
            return intrinsicMeasurable.maxIntrinsicWidth(i);
        }

        @NotNull
        /* renamed from: d */
        public static MeasureResult m60d(@NotNull IntrinsicSizeModifier _this, @NotNull MeasureScope measureScope, Measurable measurable, long j) {
            Intrinsics.checkNotNullParameter(measureScope, "$this$measure");
            Intrinsics.checkNotNullParameter(measurable, "measurable");
            long mo1378calculateContentConstraintsl58MMJ0 = _this.mo1378calculateContentConstraintsl58MMJ0(measureScope, measurable, j);
            if (_this.getEnforceIncoming()) {
                mo1378calculateContentConstraintsl58MMJ0 = ConstraintsKt.m5196constrainN9IONVI(j, mo1378calculateContentConstraintsl58MMJ0);
            }
            final Placeable mo4187measureBRTryo0 = measurable.mo4187measureBRTryo0(mo1378calculateContentConstraintsl58MMJ0);
            return MeasureScope.CC.m140p(measureScope, mo4187measureBRTryo0.getWidth(), mo4187measureBRTryo0.getHeight(), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.layout.IntrinsicSizeModifier$measure$1
                {
                    super(1);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((Placeable.PlacementScope) obj);
                    return Unit.INSTANCE;
                }

                public final void invoke(@NotNull Placeable.PlacementScope placementScope) {
                    Intrinsics.checkNotNullParameter(placementScope, "$this$layout");
                    Placeable.PlacementScope.m4224placeRelative70tqf50$default(placementScope, Placeable.this, IntOffset.Companion.m5344getZeronOccac(), 0.0f, 2, null);
                }
            }, 4, null);
        }

        /* renamed from: e */
        public static int m61e(@NotNull IntrinsicSizeModifier _this, @NotNull IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
            Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
            Intrinsics.checkNotNullParameter(intrinsicMeasurable, "measurable");
            return intrinsicMeasurable.minIntrinsicHeight(i);
        }

        /* renamed from: f */
        public static int m62f(@NotNull IntrinsicSizeModifier _this, @NotNull IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
            Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
            Intrinsics.checkNotNullParameter(intrinsicMeasurable, "measurable");
            return intrinsicMeasurable.minIntrinsicWidth(i);
        }
    }

    /* renamed from: calculateContentConstraints-l58MMJ0, reason: not valid java name */
    long mo1378calculateContentConstraintsl58MMJ0(@NotNull MeasureScope measureScope, @NotNull Measurable measurable, long j);

    boolean getEnforceIncoming();

    @Override // androidx.compose.p004ui.layout.LayoutModifier
    int maxIntrinsicHeight(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull IntrinsicMeasurable intrinsicMeasurable, int i);

    @Override // androidx.compose.p004ui.layout.LayoutModifier
    int maxIntrinsicWidth(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull IntrinsicMeasurable intrinsicMeasurable, int i);

    @Override // androidx.compose.p004ui.layout.LayoutModifier
    @NotNull
    /* renamed from: measure-3p2s80s */
    MeasureResult mo959measure3p2s80s(@NotNull MeasureScope measureScope, @NotNull Measurable measurable, long j);

    @Override // androidx.compose.p004ui.layout.LayoutModifier
    int minIntrinsicHeight(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull IntrinsicMeasurable intrinsicMeasurable, int i);

    @Override // androidx.compose.p004ui.layout.LayoutModifier
    int minIntrinsicWidth(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull IntrinsicMeasurable intrinsicMeasurable, int i);
}
