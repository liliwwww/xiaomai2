package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.text.Handle;
import androidx.compose.foundation.text.selection.Selection;
import androidx.compose.p004ui.geometry.Offset;
import androidx.compose.p004ui.geometry.OffsetKt;
import androidx.compose.p004ui.geometry.Rect;
import androidx.compose.p004ui.geometry.RectKt;
import androidx.compose.p004ui.layout.LayoutCoordinates;
import androidx.compose.p004ui.layout.LayoutCoordinatesKt;
import androidx.compose.p004ui.text.AnnotatedString;
import androidx.compose.p004ui.text.TextRange;
import androidx.compose.p004ui.unit.IntSize;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public final class SelectionManagerKt {

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Handle.values().length];
            try {
                iArr[Handle.SelectionStart.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Handle.SelectionEnd.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Handle.Cursor.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* renamed from: calculateSelectionMagnifierCenterAndroid-O0kMr_c, reason: not valid java name */
    public static final long m1878calculateSelectionMagnifierCenterAndroidO0kMr_c(@NotNull SelectionManager selectionManager, long j) {
        Intrinsics.checkNotNullParameter(selectionManager, "manager");
        Selection selection = selectionManager.getSelection();
        if (selection == null) {
            return Offset.Companion.m2571getUnspecifiedF1C5BW0();
        }
        Handle draggingHandle = selectionManager.getDraggingHandle();
        int i = draggingHandle == null ? -1 : WhenMappings.$EnumSwitchMapping$0[draggingHandle.ordinal()];
        if (i == -1) {
            return Offset.Companion.m2571getUnspecifiedF1C5BW0();
        }
        if (i == 1) {
            return m80xeba096cb(selectionManager, j, selection.getStart(), true);
        }
        if (i == 2) {
            return m80xeba096cb(selectionManager, j, selection.getEnd(), false);
        }
        if (i != 3) {
            throw new NoWhenBranchMatchedException();
        }
        throw new IllegalStateException("SelectionContainer does not support cursor".toString());
    }

    /* renamed from: calculateSelectionMagnifierCenterAndroid_O0kMr_c$getMagnifierCenter */
    private static final long m80xeba096cb(SelectionManager selectionManager, long j, Selection.AnchorInfo anchorInfo, boolean z) {
        LayoutCoordinates containerLayoutCoordinates;
        LayoutCoordinates layoutCoordinates;
        Selectable anchorSelectable$foundation_release = selectionManager.getAnchorSelectable$foundation_release(anchorInfo);
        if (anchorSelectable$foundation_release != null && (containerLayoutCoordinates = selectionManager.getContainerLayoutCoordinates()) != null && (layoutCoordinates = anchorSelectable$foundation_release.getLayoutCoordinates()) != null) {
            int offset = anchorInfo.getOffset();
            if (!z) {
                offset--;
            }
            Offset m1864getCurrentDragPosition_m7T9E = selectionManager.m1864getCurrentDragPosition_m7T9E();
            Intrinsics.checkNotNull(m1864getCurrentDragPosition_m7T9E);
            float m2556getXimpl = Offset.m2556getXimpl(layoutCoordinates.mo4192localPositionOfR5De75A(containerLayoutCoordinates, m1864getCurrentDragPosition_m7T9E.m2566unboximpl()));
            long mo1826getRangeOfLineContainingjx7JFs = anchorSelectable$foundation_release.mo1826getRangeOfLineContainingjx7JFs(offset);
            Rect boundingBox = anchorSelectable$foundation_release.getBoundingBox(TextRange.m4747getMinimpl(mo1826getRangeOfLineContainingjx7JFs));
            Rect boundingBox2 = anchorSelectable$foundation_release.getBoundingBox(RangesKt.coerceAtLeast(TextRange.m4746getMaximpl(mo1826getRangeOfLineContainingjx7JFs) - 1, TextRange.m4747getMinimpl(mo1826getRangeOfLineContainingjx7JFs)));
            float coerceIn = RangesKt.coerceIn(m2556getXimpl, Math.min(boundingBox.getLeft(), boundingBox2.getLeft()), Math.max(boundingBox.getRight(), boundingBox2.getRight()));
            return Math.abs(m2556getXimpl - coerceIn) > ((float) (IntSize.m5376getWidthimpl(j) / 2)) ? Offset.Companion.m2571getUnspecifiedF1C5BW0() : containerLayoutCoordinates.mo4192localPositionOfR5De75A(layoutCoordinates, OffsetKt.Offset(coerceIn, Offset.m2557getYimpl(anchorSelectable$foundation_release.getBoundingBox(offset).m2586getCenterF1C5BW0())));
        }
        return Offset.Companion.m2571getUnspecifiedF1C5BW0();
    }

    /* renamed from: containsInclusive-Uv8p0NA, reason: not valid java name */
    public static final boolean m1879containsInclusiveUv8p0NA(@NotNull Rect rect, long j) {
        Intrinsics.checkNotNullParameter(rect, "$this$containsInclusive");
        float left = rect.getLeft();
        float right = rect.getRight();
        float m2556getXimpl = Offset.m2556getXimpl(j);
        if (left <= m2556getXimpl && m2556getXimpl <= right) {
            float top = rect.getTop();
            float bottom = rect.getBottom();
            float m2557getYimpl = Offset.m2557getYimpl(j);
            if (top <= m2557getYimpl && m2557getYimpl <= bottom) {
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
        return RectKt.m2594Rect0a9Yr6o(layoutCoordinates.mo4196windowToLocalMKHz9U(boundsInWindow.m2591getTopLeftF1C5BW0()), layoutCoordinates.mo4196windowToLocalMKHz9U(boundsInWindow.m2585getBottomRightF1C5BW0()));
    }
}
