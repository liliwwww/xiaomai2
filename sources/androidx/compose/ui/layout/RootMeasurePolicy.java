package androidx.compose.ui.layout;

import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class RootMeasurePolicy extends LayoutNode.NoIntrinsicsMeasurePolicy {

    @NotNull
    public static final RootMeasurePolicy INSTANCE = new RootMeasurePolicy();

    private RootMeasurePolicy() {
        super("Undefined intrinsics block and it is required");
    }

    @NotNull
    /* renamed from: measure-3p2s80s, reason: not valid java name */
    public MeasureResult m2078measure3p2s80s(@NotNull MeasureScope measureScope, @NotNull List<? extends Measurable> list, long j) {
        Intrinsics.checkNotNullParameter(measureScope, "$this$measure");
        Intrinsics.checkNotNullParameter(list, "measurables");
        if (list.isEmpty()) {
            return MeasureScope$CC.p(measureScope, Constraints.getMinWidth-impl(j), Constraints.getMinHeight-impl(j), null, measure.1.INSTANCE, 4, null);
        }
        if (list.size() == 1) {
            Placeable placeable = list.get(0).measure-BRTryo0(j);
            return MeasureScope$CC.p(measureScope, ConstraintsKt.constrainWidth-K40F9xA(j, placeable.getWidth()), ConstraintsKt.constrainHeight-K40F9xA(j, placeable.getHeight()), null, new measure.2(placeable), 4, null);
        }
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        for (int i = 0; i < size; i++) {
            arrayList.add(list.get(i).measure-BRTryo0(j));
        }
        int size2 = arrayList.size();
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < size2; i4++) {
            Placeable placeable2 = (Placeable) arrayList.get(i4);
            i2 = Math.max(placeable2.getWidth(), i2);
            i3 = Math.max(placeable2.getHeight(), i3);
        }
        return MeasureScope$CC.p(measureScope, ConstraintsKt.constrainWidth-K40F9xA(j, i2), ConstraintsKt.constrainHeight-K40F9xA(j, i3), null, new measure.4(arrayList), 4, null);
    }
}
