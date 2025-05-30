package androidx.compose.foundation.text;

import androidx.compose.foundation.text.selection.Selectable;
import androidx.compose.p004ui.geometry.Offset;
import androidx.compose.p004ui.graphics.Color;
import androidx.compose.p004ui.layout.LayoutCoordinates;
import androidx.compose.p004ui.text.TextLayoutResult;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public final class TextState {

    @NotNull
    private final MutableState drawScopeInvalidation$delegate;

    @Nullable
    private LayoutCoordinates layoutCoordinates;

    @NotNull
    private final MutableState layoutInvalidation$delegate;

    @Nullable
    private TextLayoutResult layoutResult;

    @NotNull
    private Function1<? super TextLayoutResult, Unit> onTextLayout;
    private long previousGlobalPosition;

    @Nullable
    private Selectable selectable;
    private final long selectableId;
    private long selectionBackgroundColor;

    @NotNull
    private TextDelegate textDelegate;

    public TextState(@NotNull TextDelegate textDelegate, long j) {
        Intrinsics.checkNotNullParameter(textDelegate, "textDelegate");
        this.selectableId = j;
        this.onTextLayout = new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.foundation.text.TextState$onTextLayout$1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((TextLayoutResult) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull TextLayoutResult textLayoutResult) {
                Intrinsics.checkNotNullParameter(textLayoutResult, "it");
            }
        };
        this.textDelegate = textDelegate;
        this.previousGlobalPosition = Offset.Companion.m2572getZeroF1C5BW0();
        this.selectionBackgroundColor = Color.Companion.m2823getUnspecified0d7_KjU();
        Unit unit = Unit.INSTANCE;
        this.drawScopeInvalidation$delegate = SnapshotStateKt.mutableStateOf(unit, SnapshotStateKt.neverEqualPolicy());
        this.layoutInvalidation$delegate = SnapshotStateKt.mutableStateOf(unit, SnapshotStateKt.neverEqualPolicy());
    }

    private final void setDrawScopeInvalidation(Unit unit) {
        this.drawScopeInvalidation$delegate.setValue(unit);
    }

    private final void setLayoutInvalidation(Unit unit) {
        this.layoutInvalidation$delegate.setValue(unit);
    }

    @NotNull
    public final Unit getDrawScopeInvalidation() {
        this.drawScopeInvalidation$delegate.getValue();
        return Unit.INSTANCE;
    }

    @Nullable
    public final LayoutCoordinates getLayoutCoordinates() {
        return this.layoutCoordinates;
    }

    @NotNull
    public final Unit getLayoutInvalidation() {
        this.layoutInvalidation$delegate.getValue();
        return Unit.INSTANCE;
    }

    @Nullable
    public final TextLayoutResult getLayoutResult() {
        return this.layoutResult;
    }

    @NotNull
    public final Function1<TextLayoutResult, Unit> getOnTextLayout() {
        return this.onTextLayout;
    }

    /* renamed from: getPreviousGlobalPosition-F1C5BW0, reason: not valid java name */
    public final long m1815getPreviousGlobalPositionF1C5BW0() {
        return this.previousGlobalPosition;
    }

    @Nullable
    public final Selectable getSelectable() {
        return this.selectable;
    }

    public final long getSelectableId() {
        return this.selectableId;
    }

    /* renamed from: getSelectionBackgroundColor-0d7_KjU, reason: not valid java name */
    public final long m1816getSelectionBackgroundColor0d7_KjU() {
        return this.selectionBackgroundColor;
    }

    @NotNull
    public final TextDelegate getTextDelegate() {
        return this.textDelegate;
    }

    public final void setLayoutCoordinates(@Nullable LayoutCoordinates layoutCoordinates) {
        this.layoutCoordinates = layoutCoordinates;
    }

    public final void setLayoutResult(@Nullable TextLayoutResult textLayoutResult) {
        setDrawScopeInvalidation(Unit.INSTANCE);
        this.layoutResult = textLayoutResult;
    }

    public final void setOnTextLayout(@NotNull Function1<? super TextLayoutResult, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "<set-?>");
        this.onTextLayout = function1;
    }

    /* renamed from: setPreviousGlobalPosition-k-4lQ0M, reason: not valid java name */
    public final void m1817setPreviousGlobalPositionk4lQ0M(long j) {
        this.previousGlobalPosition = j;
    }

    public final void setSelectable(@Nullable Selectable selectable) {
        this.selectable = selectable;
    }

    /* renamed from: setSelectionBackgroundColor-8_81llA, reason: not valid java name */
    public final void m1818setSelectionBackgroundColor8_81llA(long j) {
        this.selectionBackgroundColor = j;
    }

    public final void setTextDelegate(@NotNull TextDelegate textDelegate) {
        Intrinsics.checkNotNullParameter(textDelegate, "value");
        setLayoutInvalidation(Unit.INSTANCE);
        this.textDelegate = textDelegate;
    }
}
