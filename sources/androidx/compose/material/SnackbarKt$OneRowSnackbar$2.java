package androidx.compose.material;

import androidx.compose.ui.layout.AlignmentLineKt;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;
import tb.on2;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
final class SnackbarKt$OneRowSnackbar$2 implements MeasurePolicy {
    final /* synthetic */ String $actionTag;
    final /* synthetic */ String $textTag;

    SnackbarKt$OneRowSnackbar$2(String str, String str2) {
        this.$actionTag = str;
        this.$textTag = str2;
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public /* synthetic */ int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i) {
        return on2.a(this, intrinsicMeasureScope, list, i);
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public /* synthetic */ int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i) {
        return on2.b(this, intrinsicMeasureScope, list, i);
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    @NotNull
    /* renamed from: measure-3p2s80s */
    public final MeasureResult mo16measure3p2s80s(@NotNull MeasureScope measureScope, @NotNull List<? extends Measurable> list, long j) {
        int max;
        int i;
        int height;
        Intrinsics.checkNotNullParameter(measureScope, "$this$Layout");
        Intrinsics.checkNotNullParameter(list, "measurables");
        String str = this.$actionTag;
        for (Measurable measurable : list) {
            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable), str)) {
                Placeable mo1521measureBRTryo0 = measurable.mo1521measureBRTryo0(j);
                int coerceAtLeast = RangesKt.coerceAtLeast((Constraints.m2122getMaxWidthimpl(j) - mo1521measureBRTryo0.getWidth()) - measureScope.mo319roundToPx0680j_4(SnackbarKt.access$getTextEndExtraSpacing$p()), Constraints.m2124getMinWidthimpl(j));
                String str2 = this.$textTag;
                for (Measurable measurable2 : list) {
                    if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable2), str2)) {
                        Placeable mo1521measureBRTryo02 = measurable2.mo1521measureBRTryo0(Constraints.m2113copyZbe2FdA$default(j, 0, coerceAtLeast, 0, 0, 9, null));
                        int i2 = mo1521measureBRTryo02.get(AlignmentLineKt.getFirstBaseline());
                        if (!(i2 != Integer.MIN_VALUE)) {
                            throw new IllegalArgumentException("No baselines for text".toString());
                        }
                        int i3 = mo1521measureBRTryo02.get(AlignmentLineKt.getLastBaseline());
                        if (!(i3 != Integer.MIN_VALUE)) {
                            throw new IllegalArgumentException("No baselines for text".toString());
                        }
                        boolean z = i2 == i3;
                        int m2122getMaxWidthimpl = Constraints.m2122getMaxWidthimpl(j) - mo1521measureBRTryo0.getWidth();
                        if (z) {
                            int max2 = Math.max(measureScope.mo319roundToPx0680j_4(SnackbarKt.access$getSnackbarMinHeightOneLine$p()), mo1521measureBRTryo0.getHeight());
                            int height2 = (max2 - mo1521measureBRTryo02.getHeight()) / 2;
                            int i4 = mo1521measureBRTryo0.get(AlignmentLineKt.getFirstBaseline());
                            int i5 = i4 != Integer.MIN_VALUE ? (i2 + height2) - i4 : 0;
                            max = max2;
                            height = i5;
                            i = height2;
                        } else {
                            int mo319roundToPx0680j_4 = measureScope.mo319roundToPx0680j_4(SnackbarKt.access$getHeightToFirstLine$p()) - i2;
                            max = Math.max(measureScope.mo319roundToPx0680j_4(SnackbarKt.access$getSnackbarMinHeightTwoLines$p()), mo1521measureBRTryo02.getHeight() + mo319roundToPx0680j_4);
                            i = mo319roundToPx0680j_4;
                            height = (max - mo1521measureBRTryo0.getHeight()) / 2;
                        }
                        return MeasureScope.-CC.p(measureScope, Constraints.m2122getMaxWidthimpl(j), max, (Map) null, new measure.4(mo1521measureBRTryo02, i, mo1521measureBRTryo0, m2122getMaxWidthimpl, height), 4, (Object) null);
                    }
                }
                throw new NoSuchElementException("Collection contains no element matching the predicate.");
            }
        }
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public /* synthetic */ int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i) {
        return on2.c(this, intrinsicMeasureScope, list, i);
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public /* synthetic */ int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i) {
        return on2.d(this, intrinsicMeasureScope, list, i);
    }
}
