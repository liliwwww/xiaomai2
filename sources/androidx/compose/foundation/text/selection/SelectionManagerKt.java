package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.text.Handle;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RectKt;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.unit.IntSize;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class SelectionManagerKt {
    /* renamed from: calculateSelectionMagnifierCenterAndroid-O0kMr_c, reason: not valid java name */
    public static final long m470calculateSelectionMagnifierCenterAndroidO0kMr_c(@NotNull SelectionManager selectionManager, long j) {
        Intrinsics.checkNotNullParameter(selectionManager, "manager");
        Selection selection = selectionManager.getSelection();
        if (selection == null) {
            return Offset.Companion.getUnspecified-F1C5BW0();
        }
        Handle draggingHandle = selectionManager.getDraggingHandle();
        int i = draggingHandle == null ? -1 : WhenMappings.$EnumSwitchMapping$0[draggingHandle.ordinal()];
        if (i == -1) {
            return Offset.Companion.getUnspecified-F1C5BW0();
        }
        if (i == 1) {
            return calculateSelectionMagnifierCenterAndroid_O0kMr_c$getMagnifierCenter(selectionManager, j, selection.getStart(), true);
        }
        if (i == 2) {
            return calculateSelectionMagnifierCenterAndroid_O0kMr_c$getMagnifierCenter(selectionManager, j, selection.getEnd(), false);
        }
        if (i != 3) {
            throw new NoWhenBranchMatchedException();
        }
        throw new IllegalStateException("SelectionContainer does not support cursor".toString());
    }

    private static final long calculateSelectionMagnifierCenterAndroid_O0kMr_c$getMagnifierCenter(SelectionManager selectionManager, long j, Selection$AnchorInfo selection$AnchorInfo, boolean z) {
        LayoutCoordinates containerLayoutCoordinates;
        LayoutCoordinates layoutCoordinates;
        Selectable anchorSelectable$foundation_release = selectionManager.getAnchorSelectable$foundation_release(selection$AnchorInfo);
        if (anchorSelectable$foundation_release != null && (containerLayoutCoordinates = selectionManager.getContainerLayoutCoordinates()) != null && (layoutCoordinates = anchorSelectable$foundation_release.getLayoutCoordinates()) != null) {
            int offset = selection$AnchorInfo.getOffset();
            if (!z) {
                offset--;
            }
            Offset offset2 = selectionManager.getCurrentDragPosition-_m7T9-E();
            Intrinsics.checkNotNull(offset2);
            float m848getXimpl = Offset.m848getXimpl(layoutCoordinates.mo1523localPositionOfR5De75A(containerLayoutCoordinates, offset2.m858unboximpl()));
            long j2 = anchorSelectable$foundation_release.getRangeOfLineContaining--jx7JFs(offset);
            Rect boundingBox = anchorSelectable$foundation_release.getBoundingBox(TextRange.getMin-impl(j2));
            Rect boundingBox2 = anchorSelectable$foundation_release.getBoundingBox(RangesKt.coerceAtLeast(TextRange.getMax-impl(j2) - 1, TextRange.getMin-impl(j2)));
            float coerceIn = RangesKt.coerceIn(m848getXimpl, Math.min(boundingBox.getLeft(), boundingBox2.getLeft()), Math.max(boundingBox.getRight(), boundingBox2.getRight()));
            return Math.abs(m848getXimpl - coerceIn) > ((float) (IntSize.getWidth-impl(j) / 2)) ? Offset.Companion.getUnspecified-F1C5BW0() : containerLayoutCoordinates.mo1523localPositionOfR5De75A(layoutCoordinates, OffsetKt.Offset(coerceIn, Offset.m849getYimpl(anchorSelectable$foundation_release.getBoundingBox(offset).m864getCenterF1C5BW0())));
        }
        return Offset.Companion.getUnspecified-F1C5BW0();
    }

    /* renamed from: containsInclusive-Uv8p0NA, reason: not valid java name */
    public static final boolean m471containsInclusiveUv8p0NA(@NotNull Rect rect, long j) {
        Intrinsics.checkNotNullParameter(rect, "$this$containsInclusive");
        float left = rect.getLeft();
        float right = rect.getRight();
        float m848getXimpl = Offset.m848getXimpl(j);
        if (left <= m848getXimpl && m848getXimpl <= right) {
            float top = rect.getTop();
            float bottom = rect.getBottom();
            float m849getYimpl = Offset.m849getYimpl(j);
            if (top <= m849getYimpl && m849getYimpl <= bottom) {
                return true;
            }
        }
        return false;
    }

    @NotNull
    public static final AnnotatedString getCurrentSelectedText(@NotNull Selectable selectable, @NotNull Selection selection) {
        Intrinsics.checkNotNullParameter(selectable, "selectable");
        Intrinsics.checkNotNullParameter(selection, "selection");
        AnnotatedString text = selectable.getText();
        return (selectable.getSelectableId() == selection.getStart().getSelectableId() || selectable.getSelectableId() == selection.getEnd().getSelectableId()) ? (selectable.getSelectableId() == selection.getStart().getSelectableId() && selectable.getSelectableId() == selection.getEnd().getSelectableId()) ? selection.getHandlesCrossed() ? text.subSequence(selection.getEnd().getOffset(), selection.getStart().getOffset()) : text.subSequence(selection.getStart().getOffset(), selection.getEnd().getOffset()) : selectable.getSelectableId() == selection.getStart().getSelectableId() ? selection.getHandlesCrossed() ? text.subSequence(0, selection.getStart().getOffset()) : text.subSequence(selection.getStart().getOffset(), text.length()) : selection.getHandlesCrossed() ? text.subSequence(selection.getEnd().getOffset(), text.length()) : text.subSequence(0, selection.getEnd().getOffset()) : text;
    }

    @Nullable
    public static final Selection merge(@Nullable Selection selection, @Nullable Selection selection2) {
        Selection merge;
        return (selection == null || (merge = selection.merge(selection2)) == null) ? selection2 : merge;
    }

    @NotNull
    public static final Rect visibleBounds(@NotNull LayoutCoordinates layoutCoordinates) {
        Intrinsics.checkNotNullParameter(layoutCoordinates, "<this>");
        Rect boundsInWindow = LayoutCoordinatesKt.boundsInWindow(layoutCoordinates);
        return RectKt.m872Rect0a9Yr6o(layoutCoordinates.mo1527windowToLocalMKHz9U(boundsInWindow.m869getTopLeftF1C5BW0()), layoutCoordinates.mo1527windowToLocalMKHz9U(boundsInWindow.m863getBottomRightF1C5BW0()));
    }
}
