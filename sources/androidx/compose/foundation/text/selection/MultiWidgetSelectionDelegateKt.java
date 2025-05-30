package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.text.selection.Selection;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import androidx.compose.ui.unit.IntSize;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class MultiWidgetSelectionDelegateKt {
    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getAssembledSelectionInfo-vJH6DeI, reason: not valid java name */
    public static final Selection m595getAssembledSelectionInfovJH6DeI(long j, boolean z, long j2, TextLayoutResult textLayoutResult) {
        return new Selection(new Selection.AnchorInfo(textLayoutResult.getBidiRunDirection(TextRange.m2330getStartimpl(j)), TextRange.m2330getStartimpl(j), j2), new Selection.AnchorInfo(textLayoutResult.getBidiRunDirection(Math.max(TextRange.m2325getEndimpl(j) - 1, 0)), TextRange.m2325getEndimpl(j), j2), z);
    }

    /* renamed from: getOffsetForPosition-0AR0LA0, reason: not valid java name */
    public static final int m596getOffsetForPosition0AR0LA0(@NotNull TextLayoutResult textLayoutResult, @NotNull Rect rect, long j) {
        Intrinsics.checkNotNullParameter(textLayoutResult, "textLayoutResult");
        Intrinsics.checkNotNullParameter(rect, "bounds");
        int length = textLayoutResult.getLayoutInput().getText().length();
        if (rect.contains-k-4lQ0M(j)) {
            return RangesKt.coerceIn(textLayoutResult.getOffsetForPosition-k-4lQ0M(j), 0, length);
        }
        if (SelectionMode.Vertical.compare-3MmeM6k$foundation_release(j, rect) < 0) {
            return 0;
        }
        return length;
    }

    @NotNull
    /* renamed from: getTextSelectionInfo-yM0VcXU, reason: not valid java name */
    public static final Pair<Selection, Boolean> m597getTextSelectionInfoyM0VcXU(@NotNull TextLayoutResult textLayoutResult, long j, long j2, @Nullable Offset offset, long j3, @NotNull SelectionAdjustment selectionAdjustment, @Nullable Selection selection, boolean z) {
        Intrinsics.checkNotNullParameter(textLayoutResult, "textLayoutResult");
        Intrinsics.checkNotNullParameter(selectionAdjustment, "adjustment");
        Rect rect = new Rect(0.0f, 0.0f, IntSize.m2685getWidthimpl(textLayoutResult.getSize-YbymL2g()), IntSize.m2684getHeightimpl(textLayoutResult.getSize-YbymL2g()));
        if (!SelectionMode.Vertical.isSelected-2x9bVx0$foundation_release(rect, j, j2)) {
            return new Pair<>((Object) null, Boolean.FALSE);
        }
        int m596getOffsetForPosition0AR0LA0 = m596getOffsetForPosition0AR0LA0(textLayoutResult, rect, j);
        int m596getOffsetForPosition0AR0LA02 = m596getOffsetForPosition0AR0LA0(textLayoutResult, rect, j2);
        int m596getOffsetForPosition0AR0LA03 = offset != null ? m596getOffsetForPosition0AR0LA0(textLayoutResult, rect, offset.unbox-impl()) : -1;
        long j4 = selectionAdjustment.adjust-ZXO7KMw(textLayoutResult, TextRangeKt.TextRange(m596getOffsetForPosition0AR0LA0, m596getOffsetForPosition0AR0LA02), m596getOffsetForPosition0AR0LA03, z, selection != null ? TextRange.m2318boximpl(selection.m599toTextRanged9O1mEE()) : null);
        Selection m595getAssembledSelectionInfovJH6DeI = m595getAssembledSelectionInfovJH6DeI(j4, TextRange.m2329getReversedimpl(j4), j3, textLayoutResult);
        boolean z2 = true;
        boolean z3 = !Intrinsics.areEqual(m595getAssembledSelectionInfovJH6DeI, selection);
        if (!(!z ? m596getOffsetForPosition0AR0LA02 == m596getOffsetForPosition0AR0LA03 : m596getOffsetForPosition0AR0LA0 == m596getOffsetForPosition0AR0LA03) && !z3) {
            z2 = false;
        }
        return new Pair<>(m595getAssembledSelectionInfovJH6DeI, Boolean.valueOf(z2));
    }
}
