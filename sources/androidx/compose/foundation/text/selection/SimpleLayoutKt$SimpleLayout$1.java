package androidx.compose.foundation.text.selection;

import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.MeasureScope$CC;
import androidx.compose.ui.layout.Placeable;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tb.on2;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class SimpleLayoutKt$SimpleLayout$1 implements MeasurePolicy {
    public static final SimpleLayoutKt$SimpleLayout$1 INSTANCE = new SimpleLayoutKt$SimpleLayout$1();

    SimpleLayoutKt$SimpleLayout$1() {
    }

    public /* synthetic */ int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i) {
        return on2.a(this, intrinsicMeasureScope, list, i);
    }

    public /* synthetic */ int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i) {
        return on2.b(this, intrinsicMeasureScope, list, i);
    }

    @NotNull
    /* renamed from: measure-3p2s80s, reason: not valid java name */
    public final MeasureResult m645measure3p2s80s(@NotNull MeasureScope measureScope, @NotNull List<? extends Measurable> list, long j) {
        Intrinsics.checkNotNullParameter(measureScope, "$this$Layout");
        Intrinsics.checkNotNullParameter(list, "measurables");
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        Integer num = 0;
        for (int i = 0; i < size; i++) {
            arrayList.add(list.get(i).measure-BRTryo0(j));
        }
        int size2 = arrayList.size();
        Integer num2 = num;
        for (int i2 = 0; i2 < size2; i2++) {
            num2 = Integer.valueOf(Math.max(num2.intValue(), ((Placeable) arrayList.get(i2)).getWidth()));
        }
        int intValue = num2.intValue();
        int size3 = arrayList.size();
        for (int i3 = 0; i3 < size3; i3++) {
            num = Integer.valueOf(Math.max(num.intValue(), ((Placeable) arrayList.get(i3)).getHeight()));
        }
        return MeasureScope$CC.p(measureScope, intValue, num.intValue(), null, new measure.1(arrayList), 4, null);
    }

    public /* synthetic */ int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i) {
        return on2.c(this, intrinsicMeasureScope, list, i);
    }

    public /* synthetic */ int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i) {
        return on2.d(this, intrinsicMeasureScope, list, i);
    }
}
