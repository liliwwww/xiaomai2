package androidx.compose.foundation.text.selection;

import androidx.compose.p004ui.geometry.Offset;
import androidx.compose.p004ui.geometry.Rect;
import androidx.compose.p004ui.layout.LayoutCoordinates;
import androidx.compose.p004ui.text.AnnotatedString;
import androidx.compose.p004ui.text.TextLayoutResult;
import androidx.compose.p004ui.text.TextRange;
import androidx.compose.p004ui.text.TextRangeKt;
import kotlin.Pair;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public final class MultiWidgetSelectionDelegate implements Selectable {

    @NotNull
    private final Function0<LayoutCoordinates> coordinatesCallback;

    @NotNull
    private final Function0<TextLayoutResult> layoutResultCallback;
    private final long selectableId;

    /* JADX WARN: Multi-variable type inference failed */
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
    public long mo1825getHandlePositiondBAh8RU(@NotNull Selection selection, boolean z) {
        TextLayoutResult textLayoutResult;
        Intrinsics.checkNotNullParameter(selection, "selection");
        if ((z && selection.getStart().getSelectableId() != getSelectableId()) || (!z && selection.getEnd().getSelectableId() != getSelectableId())) {
            return Offset.Companion.m2572getZeroF1C5BW0();
        }
        if (getLayoutCoordinates() != null && (textLayoutResult = (TextLayoutResult) this.layoutResultCallback.invoke()) != null) {
            return TextSelectionDelegateKt.getSelectionHandleCoordinates(textLayoutResult, (z ? selection.getStart() : selection.getEnd()).getOffset(), z, selection.getHandlesCrossed());
        }
        return Offset.Companion.m2572getZeroF1C5BW0();
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
    public long mo1826getRangeOfLineContainingjx7JFs(int i) {
        TextLayoutResult textLayoutResult = (TextLayoutResult) this.layoutResultCallback.invoke();
        if (textLayoutResult == null) {
            return TextRange.Companion.m4754getZerod9O1mEE();
        }
        int length = textLayoutResult.getLayoutInput().getText().length();
        if (length < 1) {
            return TextRange.Companion.m4754getZerod9O1mEE();
        }
        int lineForOffset = textLayoutResult.getLineForOffset(RangesKt.coerceIn(i, 0, length - 1));
        return TextRangeKt.TextRange(textLayoutResult.getLineStart(lineForOffset), textLayoutResult.getLineEnd(lineForOffset, true));
    }

    @Override // androidx.compose.foundation.text.selection.Selectable
    @Nullable
    public Selection getSelectAllSelection() {
        Selection m1829getAssembledSelectionInfovJH6DeI;
        TextLayoutResult textLayoutResult = (TextLayoutResult) this.layoutResultCallback.invoke();
        if (textLayoutResult == null) {
            return null;
        }
        m1829getAssembledSelectionInfovJH6DeI = MultiWidgetSelectionDelegateKt.m1829getAssembledSelectionInfovJH6DeI(TextRangeKt.TextRange(0, textLayoutResult.getLayoutInput().getText().length()), false, getSelectableId(), textLayoutResult);
        return m1829getAssembledSelectionInfovJH6DeI;
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
    public Pair<Selection, Boolean> mo1827updateSelectionqCDeeow(long j, long j2, @Nullable Offset offset, boolean z, @NotNull LayoutCoordinates layoutCoordinates, @NotNull SelectionAdjustment selectionAdjustment, @Nullable Selection selection) {
        TextLayoutResult textLayoutResult;
        Intrinsics.checkNotNullParameter(layoutCoordinates, "containerLayoutCoordinates");
        Intrinsics.checkNotNullParameter(selectionAdjustment, "adjustment");
        if (!(selection == null || (getSelectableId() == selection.getStart().getSelectableId() && getSelectableId() == selection.getEnd().getSelectableId()))) {
            throw new IllegalArgumentException("The given previousSelection doesn't belong to this selectable.".toString());
        }
        LayoutCoordinates layoutCoordinates2 = getLayoutCoordinates();
        if (layoutCoordinates2 != null && (textLayoutResult = (TextLayoutResult) this.layoutResultCallback.invoke()) != null) {
            long mo4192localPositionOfR5De75A = layoutCoordinates.mo4192localPositionOfR5De75A(layoutCoordinates2, Offset.Companion.m2572getZeroF1C5BW0());
            return MultiWidgetSelectionDelegateKt.m1831getTextSelectionInfoyM0VcXU(textLayoutResult, Offset.m2560minusMKHz9U(j, mo4192localPositionOfR5De75A), Offset.m2560minusMKHz9U(j2, mo4192localPositionOfR5De75A), offset != null ? Offset.m2545boximpl(Offset.m2560minusMKHz9U(offset.m2566unboximpl(), mo4192localPositionOfR5De75A)) : null, getSelectableId(), selectionAdjustment, selection, z);
        }
        return new Pair<>((Object) null, Boolean.FALSE);
    }
}
