package androidx.compose.foundation.text;

import androidx.compose.foundation.text.selection.SelectionRegistrar;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.layout.AlignmentLineKt;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.IntSize;
import java.util.ArrayList;
import java.util.List;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class TextController$measurePolicy$1 implements MeasurePolicy {
    final /* synthetic */ TextController this$0;

    TextController$measurePolicy$1(TextController textController) {
        this.this$0 = textController;
    }

    public int maxIntrinsicHeight(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull List<? extends IntrinsicMeasurable> list, int i) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        Intrinsics.checkNotNullParameter(list, "measurables");
        return IntSize.m2684getHeightimpl(TextDelegate.m569layoutNN6EwU$default(this.this$0.getState().getTextDelegate(), ConstraintsKt.Constraints(0, i, 0, Integer.MAX_VALUE), intrinsicMeasureScope.getLayoutDirection(), null, 4, null).getSize-YbymL2g());
    }

    public int maxIntrinsicWidth(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull List<? extends IntrinsicMeasurable> list, int i) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        Intrinsics.checkNotNullParameter(list, "measurables");
        this.this$0.getState().getTextDelegate().layoutIntrinsics(intrinsicMeasureScope.getLayoutDirection());
        return this.this$0.getState().getTextDelegate().getMaxIntrinsicWidth();
    }

    @NotNull
    /* renamed from: measure-3p2s80s, reason: not valid java name */
    public MeasureResult m564measure3p2s80s(@NotNull MeasureScope measureScope, @NotNull List<? extends Measurable> list, long j) {
        int i;
        Pair pair;
        SelectionRegistrar access$getSelectionRegistrar$p;
        Intrinsics.checkNotNullParameter(measureScope, "$this$measure");
        Intrinsics.checkNotNullParameter(list, "measurables");
        this.this$0.getState().getLayoutInvalidation();
        TextLayoutResult layoutResult = this.this$0.getState().getLayoutResult();
        TextLayoutResult m572layoutNN6EwU = this.this$0.getState().getTextDelegate().m572layoutNN6EwU(j, measureScope.getLayoutDirection(), layoutResult);
        if (!Intrinsics.areEqual(layoutResult, m572layoutNN6EwU)) {
            this.this$0.getState().getOnTextLayout().invoke(m572layoutNN6EwU);
            if (layoutResult != null) {
                TextController textController = this.this$0;
                if (!Intrinsics.areEqual(layoutResult.getLayoutInput().getText(), m572layoutNN6EwU.getLayoutInput().getText()) && (access$getSelectionRegistrar$p = TextController.access$getSelectionRegistrar$p(textController)) != null) {
                    access$getSelectionRegistrar$p.notifySelectableChange(textController.getState().getSelectableId());
                }
            }
        }
        this.this$0.getState().setLayoutResult(m572layoutNN6EwU);
        if (!(list.size() >= m572layoutNN6EwU.getPlaceholderRects().size())) {
            throw new IllegalStateException("Check failed.".toString());
        }
        List placeholderRects = m572layoutNN6EwU.getPlaceholderRects();
        ArrayList arrayList = new ArrayList(placeholderRects.size());
        int size = placeholderRects.size();
        int i2 = 0;
        while (i2 < size) {
            Rect rect = (Rect) placeholderRects.get(i2);
            if (rect != null) {
                i = size;
                pair = new Pair(list.get(i2).measure-BRTryo0(ConstraintsKt.Constraints$default(0, (int) Math.floor(rect.getWidth()), 0, (int) Math.floor(rect.getHeight()), 5, (Object) null)), IntOffset.m2634boximpl(IntOffsetKt.IntOffset(MathKt.roundToInt(rect.getLeft()), MathKt.roundToInt(rect.getTop()))));
            } else {
                i = size;
                pair = null;
            }
            if (pair != null) {
                arrayList.add(pair);
            }
            i2++;
            size = i;
        }
        return measureScope.layout(IntSize.m2685getWidthimpl(m572layoutNN6EwU.getSize-YbymL2g()), IntSize.m2684getHeightimpl(m572layoutNN6EwU.getSize-YbymL2g()), MapsKt.mapOf(new Pair[]{TuplesKt.to(AlignmentLineKt.getFirstBaseline(), Integer.valueOf(MathKt.roundToInt(m572layoutNN6EwU.getFirstBaseline()))), TuplesKt.to(AlignmentLineKt.getLastBaseline(), Integer.valueOf(MathKt.roundToInt(m572layoutNN6EwU.getLastBaseline())))}), new measure.2(arrayList));
    }

    public int minIntrinsicHeight(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull List<? extends IntrinsicMeasurable> list, int i) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        Intrinsics.checkNotNullParameter(list, "measurables");
        return IntSize.m2684getHeightimpl(TextDelegate.m569layoutNN6EwU$default(this.this$0.getState().getTextDelegate(), ConstraintsKt.Constraints(0, i, 0, Integer.MAX_VALUE), intrinsicMeasureScope.getLayoutDirection(), null, 4, null).getSize-YbymL2g());
    }

    public int minIntrinsicWidth(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull List<? extends IntrinsicMeasurable> list, int i) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        Intrinsics.checkNotNullParameter(list, "measurables");
        this.this$0.getState().getTextDelegate().layoutIntrinsics(intrinsicMeasureScope.getLayoutDirection());
        return this.this$0.getState().getTextDelegate().getMinIntrinsicWidth();
    }
}
