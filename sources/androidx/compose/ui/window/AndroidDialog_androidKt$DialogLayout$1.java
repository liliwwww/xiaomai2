package androidx.compose.ui.window;

import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.MeasureScope$CC;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tb.on2;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class AndroidDialog_androidKt$DialogLayout$1 implements MeasurePolicy {
    public static final AndroidDialog_androidKt$DialogLayout$1 INSTANCE = new AndroidDialog_androidKt$DialogLayout$1();

    AndroidDialog_androidKt$DialogLayout$1() {
    }

    public /* synthetic */ int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i) {
        return on2.a(this, intrinsicMeasureScope, list, i);
    }

    public /* synthetic */ int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i) {
        return on2.b(this, intrinsicMeasureScope, list, i);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v14, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r13v15 */
    /* JADX WARN: Type inference failed for: r13v17 */
    /* JADX WARN: Type inference failed for: r13v18 */
    /* JADX WARN: Type inference failed for: r13v23 */
    @NotNull
    /* renamed from: measure-3p2s80s, reason: not valid java name */
    public final MeasureResult m2726measure3p2s80s(@NotNull MeasureScope measureScope, @NotNull List<? extends Measurable> list, long j) {
        Object obj;
        Intrinsics.checkNotNullParameter(measureScope, "$this$Layout");
        Intrinsics.checkNotNullParameter(list, "measurables");
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        for (int i = 0; i < size; i++) {
            arrayList.add(list.get(i).measure-BRTryo0(j));
        }
        Placeable placeable = null;
        int i2 = 1;
        if (arrayList.isEmpty()) {
            obj = null;
        } else {
            obj = arrayList.get(0);
            int width = ((Placeable) obj).getWidth();
            int lastIndex = CollectionsKt.getLastIndex(arrayList);
            if (1 <= lastIndex) {
                int i3 = 1;
                while (true) {
                    Object obj2 = arrayList.get(i3);
                    int width2 = ((Placeable) obj2).getWidth();
                    if (width < width2) {
                        obj = obj2;
                        width = width2;
                    }
                    if (i3 == lastIndex) {
                        break;
                    }
                    i3++;
                }
            }
        }
        Placeable placeable2 = (Placeable) obj;
        int width3 = placeable2 != null ? placeable2.getWidth() : Constraints.getMinWidth-impl(j);
        if (!arrayList.isEmpty()) {
            ?? r13 = arrayList.get(0);
            int height = ((Placeable) r13).getHeight();
            int lastIndex2 = CollectionsKt.getLastIndex(arrayList);
            boolean z = r13;
            if (1 <= lastIndex2) {
                while (true) {
                    Object obj3 = arrayList.get(i2);
                    int height2 = ((Placeable) obj3).getHeight();
                    r13 = z;
                    if (height < height2) {
                        r13 = obj3;
                        height = height2;
                    }
                    if (i2 == lastIndex2) {
                        break;
                    }
                    i2++;
                    z = r13;
                }
            }
            placeable = r13;
        }
        Placeable placeable3 = placeable;
        return MeasureScope$CC.p(measureScope, width3, placeable3 != null ? placeable3.getHeight() : Constraints.getMinHeight-impl(j), null, new measure.1(arrayList), 4, null);
    }

    public /* synthetic */ int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i) {
        return on2.c(this, intrinsicMeasureScope, list, i);
    }

    public /* synthetic */ int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i) {
        return on2.d(this, intrinsicMeasureScope, list, i);
    }
}
