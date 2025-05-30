package androidx.compose.foundation.text.selection;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import kotlin.Pair;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class MultiWidgetSelectionDelegate implements Selectable {

    @NotNull
    private final Function0<LayoutCoordinates> coordinatesCallback;

    @NotNull
    private final Function0<TextLayoutResult> layoutResultCallback;
    private final long selectableId;

    public MultiWidgetSelectionDelegate(long j, @NotNull Function0<? extends LayoutCoordinates> function0, @NotNull Function0<TextLayoutResult> function02) {
        Intrinsics.checkNotNullParameter(function0, "coordinatesCallback");
        Intrinsics.checkNotNullParameter(function02, "layoutResultCallback");
        this.selectableId = j;
        this.coordinatesCallback = function0;
        this.layoutResultCallback = function02;
    }

    @Override // androidx.compose.foundation.text.selection.Selectable
    @NotNull
    public Rect getBoundingBox(int i) {
        TextLayoutResult textLayoutResult = (TextLayoutResult) this.layoutResultCallback.invoke();
        if (textLayoutResult == null) {
            return Rect.Companion.getZero();
        }
        int length = textLayoutResult.getLayoutInput().getText().length();
        return length < 1 ? Rect.Companion.getZero() : textLayoutResult.getBoundingBox(RangesKt.coerceIn(i, 0, length - 1));
    }

    @Override // androidx.compose.foundation.text.selection.Selectable
    /* renamed from: getHandlePosition-dBAh8RU, reason: not valid java name */
    public long mo591getHandlePositiondBAh8RU(@NotNull Selection selection, boolean z) {
        TextLayoutResult textLayoutResult;
        Intrinsics.checkNotNullParameter(selection, "selection");
        if ((z && selection.getStart().getSelectableId() != getSelectableId()) || (!z && selection.getEnd().getSelectableId() != getSelectableId())) {
            return Offset.Companion.m1024getZeroF1C5BW0();
        }
        if (getLayoutCoordinates() != null && (textLayoutResult = (TextLayoutResult) this.layoutResultCallback.invoke()) != null) {
            return TextSelectionDelegateKt.getSelectionHandleCoordinates(textLayoutResult, (z ? selection.getStart() : selection.getEnd()).getOffset(), z, selection.getHandlesCrossed());
        }
        return Offset.Companion.m1024getZeroF1C5BW0();
    }

    @Override // androidx.compose.foundation.text.selection.Selectable
    @Nullable
    public LayoutCoordinates getLayoutCoordinates() {
        LayoutCoordinates layoutCoordinates = (LayoutCoordinates) this.coordinatesCallback.invoke();
        if (layoutCoordinates == null || !layoutCoordinates.isAttached()) {
            return null;
        }
        return layoutCoordinates;
    }

    @Override // androidx.compose.foundation.text.selection.Selectable
    /* renamed from: getRangeOfLineContaining--jx7JFs, reason: not valid java name */
    public long mo592getRangeOfLineContainingjx7JFs(int i) {
        TextLayoutResult textLayoutResult = (TextLayoutResult) this.layoutResultCallback.invoke();
        if (textLayoutResult == null) {
            return TextRange.Companion.getZero-d9O1mEE();
        }
        int length = textLayoutResult.getLayoutInput().getText().length();
        if (length < 1) {
            return TextRange.Companion.getZero-d9O1mEE();
        }
        int lineForOffset = textLayoutResult.getLineForOffset(RangesKt.coerceIn(i, 0, length - 1));
        return TextRangeKt.TextRange(textLayoutResult.getLineStart(lineForOffset), textLayoutResult.getLineEnd(lineForOffset, true));
    }

    @Override // androidx.compose.foundation.text.selection.Selectable
    @Nullable
    public Selection getSelectAllSelection() {
        Selection m595getAssembledSelectionInfovJH6DeI;
        TextLayoutResult textLayoutResult = (TextLayoutResult) this.layoutResultCallback.invoke();
        if (textLayoutResult == null) {
            return null;
        }
        m595getAssembledSelectionInfovJH6DeI = MultiWidgetSelectionDelegateKt.m595getAssembledSelectionInfovJH6DeI(TextRangeKt.TextRange(0, textLayoutResult.getLayoutInput().getText().length()), false, getSelectableId(), textLayoutResult);
        return m595getAssembledSelectionInfovJH6DeI;
    }

    @Override // androidx.compose.foundation.text.selection.Selectable
    public long getSelectableId() {
        return this.selectableId;
    }

    @Override // androidx.compose.foundation.text.selection.Selectable
    @NotNull
    public AnnotatedString getText() {
        TextLayoutResult textLayoutResult = (TextLayoutResult) this.layoutResultCallback.invoke();
        return textLayoutResult == null ? new AnnotatedString("", null, null, 6, null) : textLayoutResult.getLayoutInput().getText();
    }

    @Override // androidx.compose.foundation.text.selection.Selectable
    @NotNull
    /* renamed from: updateSelection-qCDeeow, reason: not valid java name */
    public Pair<Selection, Boolean> mo593updateSelectionqCDeeow(long j, long j2, @Nullable Offset offset, boolean z, @NotNull LayoutCoordinates layoutCoordinates, @NotNull SelectionAdjustment selectionAdjustment, @Nullable Selection selection) {
        TextLayoutResult textLayoutResult;
        Intrinsics.checkNotNullParameter(layoutCoordinates, "containerLayoutCoordinates");
        Intrinsics.checkNotNullParameter(selectionAdjustment, "adjustment");
        if (!(selection == null || (getSelectableId() == selection.getStart().getSelectableId() && getSelectableId() == selection.getEnd().getSelectableId()))) {
            throw new IllegalArgumentException("The given previousSelection doesn't belong to this selectable.".toString());
        }
        LayoutCoordinates layoutCoordinates2 = getLayoutCoordinates();
        if (layoutCoordinates2 != null && (textLayoutResult = (TextLayoutResult) this.layoutResultCallback.invoke()) != null) {
            long j3 = layoutCoordinates.localPositionOf-R5De75A(layoutCoordinates2, Offset.Companion.m1024getZeroF1C5BW0());
            return MultiWidgetSelectionDelegateKt.m597getTextSelectionInfoyM0VcXU(textLayoutResult, Offset.minus-MK-Hz9U(j, j3), Offset.minus-MK-Hz9U(j2, j3), offset != null ? Offset.box-impl(Offset.minus-MK-Hz9U(offset.unbox-impl(), j3)) : null, getSelectableId(), selectionAdjustment, selection, z);
        }
        return new Pair<>((Object) null, Boolean.FALSE);
    }
}
