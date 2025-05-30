package androidx.compose.material;

import androidx.compose.ui.layout.AlignmentLineKt;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.MeasureScope$CC;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Dp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tb.on2;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class ListItemKt$BaselinesOffsetColumn$1 implements MeasurePolicy {
    final /* synthetic */ List<Dp> $offsets;

    ListItemKt$BaselinesOffsetColumn$1(List<Dp> list) {
        this.$offsets = list;
    }

    public /* synthetic */ int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i) {
        return on2.a(this, intrinsicMeasureScope, list, i);
    }

    public /* synthetic */ int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i) {
        return on2.b(this, intrinsicMeasureScope, list, i);
    }

    @NotNull
    /* renamed from: measure-3p2s80s, reason: not valid java name */
    public final MeasureResult m768measure3p2s80s(@NotNull MeasureScope measureScope, @NotNull List<? extends Measurable> list, long j) {
        int i;
        Intrinsics.checkNotNullParameter(measureScope, "$this$Layout");
        Intrinsics.checkNotNullParameter(list, "measurables");
        long j2 = Constraints.copy-Zbe2FdA$default(j, 0, 0, 0, Integer.MAX_VALUE, 3, (Object) null);
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((Measurable) it.next()).measure-BRTryo0(j2));
        }
        Iterator it2 = arrayList.iterator();
        int i2 = 0;
        while (it2.hasNext()) {
            i2 = Math.max(i2, ((Placeable) it2.next()).getWidth());
        }
        int size = arrayList.size();
        Integer[] numArr = new Integer[size];
        for (int i3 = 0; i3 < size; i3++) {
            numArr[i3] = 0;
        }
        List<Dp> list2 = this.$offsets;
        int size2 = arrayList.size();
        int i4 = 0;
        for (int i5 = 0; i5 < size2; i5++) {
            Placeable placeable = (Placeable) arrayList.get(i5);
            if (i5 > 0) {
                int i6 = i5 - 1;
                i = ((Placeable) arrayList.get(i6)).getHeight() - ((Placeable) arrayList.get(i6)).get(AlignmentLineKt.getLastBaseline());
            } else {
                i = 0;
            }
            int max = Math.max(0, (measureScope.roundToPx-0680j_4(list2.get(i5).unbox-impl()) - placeable.get(AlignmentLineKt.getFirstBaseline())) - i);
            numArr[i5] = Integer.valueOf(max + i4);
            i4 += max + placeable.getHeight();
        }
        return MeasureScope$CC.p(measureScope, i2, i4, null, new measure.2(arrayList, numArr), 4, null);
    }

    public /* synthetic */ int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i) {
        return on2.c(this, intrinsicMeasureScope, list, i);
    }

    public /* synthetic */ int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i) {
        return on2.d(this, intrinsicMeasureScope, list, i);
    }
}
