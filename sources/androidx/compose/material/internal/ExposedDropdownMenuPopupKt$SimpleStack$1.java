package androidx.compose.material.internal;

import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.MeasureScope$CC;
import androidx.compose.ui.layout.Placeable;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tb.on2;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class ExposedDropdownMenuPopupKt$SimpleStack$1 implements MeasurePolicy {
    public static final ExposedDropdownMenuPopupKt$SimpleStack$1 INSTANCE = new ExposedDropdownMenuPopupKt$SimpleStack$1();

    public /* synthetic */ int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i) {
        return on2.a(this, intrinsicMeasureScope, list, i);
    }

    public /* synthetic */ int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i) {
        return on2.b(this, intrinsicMeasureScope, list, i);
    }

    @NotNull
    /* renamed from: measure-3p2s80s, reason: not valid java name */
    public final MeasureResult m885measure3p2s80s(@NotNull MeasureScope measureScope, @NotNull List<? extends Measurable> list, long j) {
        int i;
        int i2;
        Intrinsics.checkNotNullParameter(measureScope, "$this$Layout");
        Intrinsics.checkNotNullParameter(list, "measurables");
        int size = list.size();
        if (size == 0) {
            return MeasureScope$CC.p(measureScope, 0, 0, null, measure.1.INSTANCE, 4, null);
        }
        int i3 = 0;
        if (size == 1) {
            Placeable placeable = list.get(0).measure-BRTryo0(j);
            return MeasureScope$CC.p(measureScope, placeable.getWidth(), placeable.getHeight(), null, new measure.2(placeable), 4, null);
        }
        ArrayList arrayList = new ArrayList(list.size());
        int size2 = list.size();
        for (int i4 = 0; i4 < size2; i4++) {
            arrayList.add(list.get(i4).measure-BRTryo0(j));
        }
        int lastIndex = CollectionsKt.getLastIndex(arrayList);
        if (lastIndex >= 0) {
            int i5 = 0;
            int i6 = 0;
            while (true) {
                Placeable placeable2 = (Placeable) arrayList.get(i3);
                i5 = Math.max(i5, placeable2.getWidth());
                i6 = Math.max(i6, placeable2.getHeight());
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
            i = i5;
            i2 = i6;
        } else {
            i = 0;
            i2 = 0;
        }
        return MeasureScope$CC.p(measureScope, i, i2, null, new measure.3(arrayList), 4, null);
    }

    public /* synthetic */ int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i) {
        return on2.c(this, intrinsicMeasureScope, list, i);
    }

    public /* synthetic */ int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i) {
        return on2.d(this, intrinsicMeasureScope, list, i);
    }
}
