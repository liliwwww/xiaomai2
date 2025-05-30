package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.text.selection.Selection;
import androidx.compose.p004ui.geometry.Offset;
import androidx.compose.p004ui.geometry.Rect;
import androidx.compose.p004ui.text.TextLayoutResult;
import androidx.compose.p004ui.text.TextRange;
import androidx.compose.p004ui.text.TextRangeKt;
import androidx.compose.p004ui.unit.IntSize;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public final class MultiWidgetSelectionDelegateKt {
    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getAssembledSelectionInfo-vJH6DeI, reason: not valid java name */
    public static final Selection m1829getAssembledSelectionInfovJH6DeI(long j, boolean z, long j2, TextLayoutResult textLayoutResult) {
        return new Selection(new Selection.AnchorInfo(textLayoutResult.getBidiRunDirection(TextRange.m4749getStartimpl(j)), TextRange.m4749getStartimpl(j), j2), new Selection.AnchorInfo(textLayoutResult.getBidiRunDirection(Math.max(TextRange.m4744getEndimpl(j) - 1, 0)), TextRange.m4744getEndimpl(j), j2), z);
    }

    /* renamed from: getOffsetForPosition-0AR0LA0, reason: not valid java name */
    public static final int m1830getOffsetForPosition0AR0LA0(@NotNull TextLayoutResult textLayoutResult, @NotNull Rect rect, long j) {
        Intrinsics.checkNotNullParameter(textLayoutResult, "textLayoutResult");
        Intrinsics.checkNotNullParameter(rect, "bounds");
        int length = textLayoutResult.getLayoutInput().getText().length();
        if (rect.m2582containsk4lQ0M(j)) {
            return RangesKt.coerceIn(textLayoutResult.m4723getOffsetForPositionk4lQ0M(j), 0, length);
        }
        if (SelectionMode.Vertical.mo1884compare3MmeM6k$foundation_release(j, rect) < 0) {
            return 0;
        }
        return length;
    }

    @NotNull
    /* renamed from: getTextSelectionInfo-yM0VcXU, reason: not valid java name */
    public static final Pair<Selection, Boolean> m1831getTextSelectionInfoyM0VcXU(@NotNull TextLayoutResult textLayoutResult, long j, long j2, @Nullable Offset offset, long j3, @NotNull SelectionAdjustment selectionAdjustment, @Nullable Selection selection, boolean z) {
        Intrinsics.checkNotNullParameter(textLayoutResult, "textLayoutResult");
        Intrinsics.checkNotNullParameter(selectionAdjustment, "adjustment");
        Rect rect = new Rect(0.0f, 0.0f, IntSize.m5376getWidthimpl(textLayoutResult.m4724getSizeYbymL2g()), IntSize.m5375getHeightimpl(textLayoutResult.m4724getSizeYbymL2g()));
        if (!SelectionMode.Vertical.m1885isSelected2x9bVx0$foundation_release(rect, j, j2)) {
            return new Pair<>((Object) null, Boolean.FALSE);
        }
        int m1830getOffsetForPosition0AR0LA0 = m1830getOffsetForPosition0AR0LA0(textLayoutResult, rect, j);
        int m1830getOffsetForPosition0AR0LA02 = m1830getOffsetForPosition0AR0LA0(textLayoutResult, rect, j2);
        int m1830getOffsetForPosition0AR0LA03 = offset != null ? m1830getOffsetForPosition0AR0LA0(textLayoutResult, rect, offset.m2566unboximpl()) : -1;
        long mo1834adjustZXO7KMw = selectionAdjustment.mo1834adjustZXO7KMw(textLayoutResult, TextRangeKt.TextRange(m1830getOffsetForPosition0AR0LA0, m1830getOffsetForPosition0AR0LA02), m1830getOffsetForPosition0AR0LA03, z, selection != null ? TextRange.m4737boximpl(selection.m1833toTextRanged9O1mEE()) : null);
        Selection m1829getAssembledSelectionInfovJH6DeI = m1829getAssembledSelectionInfovJH6DeI(mo1834adjustZXO7KMw, TextRange.m4748getReversedimpl(mo1834adjustZXO7KMw), j3, textLayoutResult);
        boolean z2 = true;
        boolean z3 = !Intrinsics.areEqual(m1829getAssembledSelectionInfovJH6DeI, selection);
        if (!(!z ? m1830getOffsetForPosition0AR0LA02 == m1830getOffsetForPosition0AR0LA03 : m1830getOffsetForPosition0AR0LA0 == m1830getOffsetForPosition0AR0LA03) && !z3) {
            z2 = false;
        }
        return new Pair<>(m1829getAssembledSelectionInfovJH6DeI, Boolean.valueOf(z2));
    }
}
