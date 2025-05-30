package androidx.compose.material;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.layout.AlignmentLineKt;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.MeasureScope$CC;
import androidx.compose.ui.layout.Measured;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.Placeable$PlacementScope;
import androidx.compose.ui.unit.Constraints;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tb.on2;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class TabKt$TabBaselineLayout$2 implements MeasurePolicy {
    final /* synthetic */ Function2<Composer, Integer, Unit> $icon;
    final /* synthetic */ Function2<Composer, Integer, Unit> $text;

    TabKt$TabBaselineLayout$2(Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22) {
        this.$text = function2;
        this.$icon = function22;
    }

    public /* synthetic */ int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i) {
        return on2.a(this, intrinsicMeasureScope, list, i);
    }

    public /* synthetic */ int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i) {
        return on2.b(this, intrinsicMeasureScope, list, i);
    }

    @NotNull
    /* renamed from: measure-3p2s80s, reason: not valid java name */
    public final MeasureResult m841measure3p2s80s(@NotNull final MeasureScope measureScope, @NotNull List<? extends Measurable> list, long j) {
        Measured measured;
        final Placeable placeable;
        Intrinsics.checkNotNullParameter(measureScope, "$this$Layout");
        Intrinsics.checkNotNullParameter(list, "measurables");
        if (this.$text != null) {
            for (Measurable measurable : list) {
                if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable), "text")) {
                    measured = measurable.measure-BRTryo0(Constraints.copy-Zbe2FdA$default(j, 0, 0, 0, 0, 11, (Object) null));
                }
            }
            throw new NoSuchElementException("Collection contains no element matching the predicate.");
        }
        measured = null;
        if (this.$icon != null) {
            for (Measurable measurable2 : list) {
                if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable2), "icon")) {
                    placeable = measurable2.measure-BRTryo0(j);
                }
            }
            throw new NoSuchElementException("Collection contains no element matching the predicate.");
        }
        placeable = null;
        final int max = Math.max(measured != null ? measured.getWidth() : 0, placeable != null ? placeable.getWidth() : 0);
        final int i = measureScope.roundToPx-0680j_4((measured == null || placeable == null) ? TabKt.access$getSmallTabHeight$p() : TabKt.access$getLargeTabHeight$p());
        final Integer valueOf = measured != null ? Integer.valueOf(measured.get(AlignmentLineKt.getFirstBaseline())) : null;
        final Integer valueOf2 = measured != null ? Integer.valueOf(measured.get(AlignmentLineKt.getLastBaseline())) : null;
        final Measured measured2 = measured;
        return MeasureScope$CC.p(measureScope, max, i, null, new Function1<Placeable$PlacementScope, Unit>() { // from class: androidx.compose.material.TabKt$TabBaselineLayout$2$measure$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Placeable$PlacementScope) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull Placeable$PlacementScope placeable$PlacementScope) {
                Placeable placeable2;
                Intrinsics.checkNotNullParameter(placeable$PlacementScope, "$this$layout");
                Placeable placeable3 = measured2;
                if (placeable3 == null || (placeable2 = placeable) == null) {
                    if (placeable3 != null) {
                        TabKt.access$placeTextOrIcon(placeable$PlacementScope, placeable3, i);
                        return;
                    }
                    Placeable placeable4 = placeable;
                    if (placeable4 != null) {
                        TabKt.access$placeTextOrIcon(placeable$PlacementScope, placeable4, i);
                        return;
                    }
                    return;
                }
                MeasureScope measureScope2 = measureScope;
                int i2 = max;
                int i3 = i;
                Integer num = valueOf;
                Intrinsics.checkNotNull(num);
                int intValue = num.intValue();
                Integer num2 = valueOf2;
                Intrinsics.checkNotNull(num2);
                TabKt.access$placeTextAndIcon(placeable$PlacementScope, measureScope2, placeable3, placeable2, i2, i3, intValue, num2.intValue());
            }
        }, 4, null);
    }

    public /* synthetic */ int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i) {
        return on2.c(this, intrinsicMeasureScope, list, i);
    }

    public /* synthetic */ int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i) {
        return on2.d(this, intrinsicMeasureScope, list, i);
    }
}
