package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.FocusableKt;
import androidx.compose.foundation.gestures.ForEachGestureKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.text.Handle;
import androidx.compose.foundation.text.TextDragObserver;
import androidx.compose.foundation.text.selection.Selection;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusChangedModifierKt;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.focus.FocusRequesterModifierKt;
import androidx.compose.ui.focus.FocusState;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Offset$Companion;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.hapticfeedback.HapticFeedback;
import androidx.compose.ui.hapticfeedback.HapticFeedbackType;
import androidx.compose.ui.input.key.KeyEvent;
import androidx.compose.ui.input.key.KeyInputModifierKt;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.layout.OnGloballyPositionedModifierKt;
import androidx.compose.ui.platform.ClipboardManager;
import androidx.compose.ui.platform.TextToolbar;
import androidx.compose.ui.platform.TextToolbarStatus;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextRange;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.xh5;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class SelectionManager {

    @NotNull
    private final MutableState<Selection> _selection;

    @Nullable
    private ClipboardManager clipboardManager;

    @Nullable
    private LayoutCoordinates containerLayoutCoordinates;

    @NotNull
    private final MutableState currentDragPosition$delegate;

    @NotNull
    private final MutableState dragBeginPosition$delegate;

    @NotNull
    private final MutableState dragTotalDistance$delegate;

    @NotNull
    private final MutableState draggingHandle$delegate;

    @NotNull
    private final MutableState endHandlePosition$delegate;

    @NotNull
    private FocusRequester focusRequester;

    @Nullable
    private HapticFeedback hapticFeedBack;

    @NotNull
    private final MutableState hasFocus$delegate;

    @NotNull
    private Function1<? super Selection, Unit> onSelectionChange;

    @Nullable
    private Offset previousPosition;

    @NotNull
    private final SelectionRegistrarImpl selectionRegistrar;

    @NotNull
    private final MutableState startHandlePosition$delegate;

    @Nullable
    private TextToolbar textToolbar;
    private boolean touchMode;

    public SelectionManager(@NotNull SelectionRegistrarImpl selectionRegistrarImpl) {
        MutableState<Selection> mutableStateOf$default;
        MutableState mutableStateOf$default2;
        MutableState mutableStateOf$default3;
        MutableState mutableStateOf$default4;
        MutableState mutableStateOf$default5;
        MutableState mutableStateOf$default6;
        MutableState mutableStateOf$default7;
        MutableState mutableStateOf$default8;
        Intrinsics.checkNotNullParameter(selectionRegistrarImpl, "selectionRegistrar");
        this.selectionRegistrar = selectionRegistrarImpl;
        mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this._selection = mutableStateOf$default;
        this.touchMode = true;
        this.onSelectionChange = onSelectionChange.1.INSTANCE;
        this.focusRequester = new FocusRequester();
        mutableStateOf$default2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
        this.hasFocus$delegate = mutableStateOf$default2;
        Offset$Companion offset$Companion = Offset.Companion;
        mutableStateOf$default3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Offset.box-impl(offset$Companion.m1024getZeroF1C5BW0()), null, 2, null);
        this.dragBeginPosition$delegate = mutableStateOf$default3;
        mutableStateOf$default4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Offset.box-impl(offset$Companion.m1024getZeroF1C5BW0()), null, 2, null);
        this.dragTotalDistance$delegate = mutableStateOf$default4;
        mutableStateOf$default5 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this.startHandlePosition$delegate = mutableStateOf$default5;
        mutableStateOf$default6 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this.endHandlePosition$delegate = mutableStateOf$default6;
        mutableStateOf$default7 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this.draggingHandle$delegate = mutableStateOf$default7;
        mutableStateOf$default8 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this.currentDragPosition$delegate = mutableStateOf$default8;
        selectionRegistrarImpl.setOnPositionChangeCallback$foundation_release(new Function1<Long, Unit>() { // from class: androidx.compose.foundation.text.selection.SelectionManager.1
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke(((Number) obj).longValue());
                return Unit.INSTANCE;
            }

            public final void invoke(long j) {
                Selection.AnchorInfo end;
                Selection.AnchorInfo start;
                Selection selection = SelectionManager.this.getSelection();
                if (!((selection == null || (start = selection.getStart()) == null || j != start.getSelectableId()) ? false : true)) {
                    Selection selection2 = SelectionManager.this.getSelection();
                    if (!((selection2 == null || (end = selection2.getEnd()) == null || j != end.getSelectableId()) ? false : true)) {
                        return;
                    }
                }
                SelectionManager.this.updateHandleOffsets();
                SelectionManager.this.updateSelectionToolbarPosition();
            }
        });
        selectionRegistrarImpl.setOnSelectionUpdateStartCallback$foundation_release(new Function3<LayoutCoordinates, Offset, SelectionAdjustment, Unit>() { // from class: androidx.compose.foundation.text.selection.SelectionManager.2
            {
                super(3);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                m633invoked4ec7I((LayoutCoordinates) obj, ((Offset) obj2).unbox-impl(), (SelectionAdjustment) obj3);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke-d-4ec7I, reason: not valid java name */
            public final void m633invoked4ec7I(@NotNull LayoutCoordinates layoutCoordinates, long j, @NotNull SelectionAdjustment selectionAdjustment) {
                Intrinsics.checkNotNullParameter(layoutCoordinates, "layoutCoordinates");
                Intrinsics.checkNotNullParameter(selectionAdjustment, "selectionMode");
                Offset m618convertToContainerCoordinatesQ7Q5hAU = SelectionManager.this.m618convertToContainerCoordinatesQ7Q5hAU(layoutCoordinates, j);
                if (m618convertToContainerCoordinatesQ7Q5hAU != null) {
                    SelectionManager.this.m624startSelection9KIMszo(m618convertToContainerCoordinatesQ7Q5hAU.unbox-impl(), false, selectionAdjustment);
                    SelectionManager.this.getFocusRequester().requestFocus();
                    SelectionManager.this.hideSelectionToolbar$foundation_release();
                }
            }
        });
        selectionRegistrarImpl.setOnSelectionUpdateSelectAll$foundation_release(new Function1<Long, Unit>() { // from class: androidx.compose.foundation.text.selection.SelectionManager.3
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke(((Number) obj).longValue());
                return Unit.INSTANCE;
            }

            public final void invoke(long j) {
                SelectionManager selectionManager = SelectionManager.this;
                Pair<Selection, Map<Long, Selection>> selectAll$foundation_release = selectionManager.selectAll$foundation_release(j, selectionManager.getSelection());
                Selection selection = (Selection) selectAll$foundation_release.component1();
                Map<Long, Selection> map = (Map) selectAll$foundation_release.component2();
                if (!Intrinsics.areEqual(selection, SelectionManager.this.getSelection())) {
                    SelectionManager.this.selectionRegistrar.setSubselections(map);
                    SelectionManager.this.getOnSelectionChange().invoke(selection);
                }
                SelectionManager.this.getFocusRequester().requestFocus();
                SelectionManager.this.hideSelectionToolbar$foundation_release();
            }
        });
        selectionRegistrarImpl.setOnSelectionUpdateCallback$foundation_release(new Function5<LayoutCoordinates, Offset, Offset, Boolean, SelectionAdjustment, Boolean>() { // from class: androidx.compose.foundation.text.selection.SelectionManager.4
            {
                super(5);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
                return m634invoke5iVPX68((LayoutCoordinates) obj, ((Offset) obj2).unbox-impl(), ((Offset) obj3).unbox-impl(), ((Boolean) obj4).booleanValue(), (SelectionAdjustment) obj5);
            }

            @NotNull
            /* renamed from: invoke-5iVPX68, reason: not valid java name */
            public final Boolean m634invoke5iVPX68(@NotNull LayoutCoordinates layoutCoordinates, long j, long j2, boolean z, @NotNull SelectionAdjustment selectionAdjustment) {
                Intrinsics.checkNotNullParameter(layoutCoordinates, "layoutCoordinates");
                Intrinsics.checkNotNullParameter(selectionAdjustment, "selectionMode");
                return Boolean.valueOf(SelectionManager.this.m632updateSelectionRHHTvR4$foundation_release(SelectionManager.this.m618convertToContainerCoordinatesQ7Q5hAU(layoutCoordinates, j), SelectionManager.this.m618convertToContainerCoordinatesQ7Q5hAU(layoutCoordinates, j2), z, selectionAdjustment));
            }
        });
        selectionRegistrarImpl.setOnSelectionUpdateEndCallback$foundation_release(new Function0<Unit>() { // from class: androidx.compose.foundation.text.selection.SelectionManager.5
            {
                super(0);
            }

            public /* bridge */ /* synthetic */ Object invoke() {
                m635invoke();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m635invoke() {
                SelectionManager.this.showSelectionToolbar$foundation_release();
                SelectionManager.this.setDraggingHandle(null);
                SelectionManager.this.m619setCurrentDragPosition_kEHs6E(null);
            }
        });
        selectionRegistrarImpl.setOnSelectableChangeCallback$foundation_release(new Function1<Long, Unit>() { // from class: androidx.compose.foundation.text.selection.SelectionManager.6
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke(((Number) obj).longValue());
                return Unit.INSTANCE;
            }

            public final void invoke(long j) {
                if (SelectionManager.this.selectionRegistrar.getSubselections().containsKey(Long.valueOf(j))) {
                    SelectionManager.this.onRelease();
                    SelectionManager.this.setSelection(null);
                }
            }
        });
        selectionRegistrarImpl.setAfterSelectableUnsubscribe$foundation_release(new Function1<Long, Unit>() { // from class: androidx.compose.foundation.text.selection.SelectionManager.7
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke(((Number) obj).longValue());
                return Unit.INSTANCE;
            }

            public final void invoke(long j) {
                Selection.AnchorInfo end;
                Selection.AnchorInfo start;
                Selection selection = SelectionManager.this.getSelection();
                if (!((selection == null || (start = selection.getStart()) == null || j != start.getSelectableId()) ? false : true)) {
                    Selection selection2 = SelectionManager.this.getSelection();
                    if (!((selection2 == null || (end = selection2.getEnd()) == null || j != end.getSelectableId()) ? false : true)) {
                        return;
                    }
                }
                SelectionManager.this.m623setStartHandlePosition_kEHs6E(null);
                SelectionManager.this.m622setEndHandlePosition_kEHs6E(null);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: convertToContainerCoordinates-Q7Q5hAU, reason: not valid java name */
    public final Offset m618convertToContainerCoordinatesQ7Q5hAU(LayoutCoordinates layoutCoordinates, long j) {
        LayoutCoordinates layoutCoordinates2 = this.containerLayoutCoordinates;
        if (layoutCoordinates2 == null || !layoutCoordinates2.isAttached()) {
            return null;
        }
        return Offset.box-impl(requireContainerCoordinates$foundation_release().localPositionOf-R5De75A(layoutCoordinates, j));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object detectNonConsumingTap(PointerInputScope pointerInputScope, Function1<? super Offset, Unit> function1, Continuation<? super Unit> continuation) {
        Object awaitEachGesture = ForEachGestureKt.awaitEachGesture(pointerInputScope, new SelectionManager$detectNonConsumingTap$2(function1, null), continuation);
        return awaitEachGesture == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? awaitEachGesture : Unit.INSTANCE;
    }

    private final Rect getContentRect() {
        LayoutCoordinates layoutCoordinates;
        LayoutCoordinates layoutCoordinates2;
        Selection selection = getSelection();
        if (selection == null) {
            return Rect.Companion.getZero();
        }
        Selectable anchorSelectable$foundation_release = getAnchorSelectable$foundation_release(selection.getStart());
        Selectable anchorSelectable$foundation_release2 = getAnchorSelectable$foundation_release(selection.getEnd());
        if (anchorSelectable$foundation_release == null || (layoutCoordinates = anchorSelectable$foundation_release.getLayoutCoordinates()) == null) {
            return Rect.Companion.getZero();
        }
        if (anchorSelectable$foundation_release2 == null || (layoutCoordinates2 = anchorSelectable$foundation_release2.getLayoutCoordinates()) == null) {
            return Rect.Companion.getZero();
        }
        LayoutCoordinates layoutCoordinates3 = this.containerLayoutCoordinates;
        if (layoutCoordinates3 == null || !layoutCoordinates3.isAttached()) {
            return Rect.Companion.getZero();
        }
        long j = layoutCoordinates3.localPositionOf-R5De75A(layoutCoordinates, anchorSelectable$foundation_release.mo591getHandlePositiondBAh8RU(selection, true));
        long j2 = layoutCoordinates3.localPositionOf-R5De75A(layoutCoordinates2, anchorSelectable$foundation_release2.mo591getHandlePositiondBAh8RU(selection, false));
        long j3 = layoutCoordinates3.localToRoot-MK-Hz9U(j);
        long j4 = layoutCoordinates3.localToRoot-MK-Hz9U(j2);
        return new Rect(Math.min(Offset.getX-impl(j3), Offset.getX-impl(j4)), Math.min(Offset.getY-impl(layoutCoordinates3.localToRoot-MK-Hz9U(layoutCoordinates3.localPositionOf-R5De75A(layoutCoordinates, OffsetKt.Offset(0.0f, anchorSelectable$foundation_release.getBoundingBox(selection.getStart().getOffset()).getTop())))), Offset.getY-impl(layoutCoordinates3.localToRoot-MK-Hz9U(layoutCoordinates3.localPositionOf-R5De75A(layoutCoordinates2, OffsetKt.Offset(0.0f, anchorSelectable$foundation_release2.getBoundingBox(selection.getEnd().getOffset()).getTop()))))), Math.max(Offset.getX-impl(j3), Offset.getX-impl(j4)), Math.max(Offset.getY-impl(j3), Offset.getY-impl(j4)) + ((float) (SelectionHandlesKt.getHandleHeight() * 4.0d)));
    }

    private final boolean getShouldShowMagnifier() {
        return getDraggingHandle() != null;
    }

    private final Modifier onClearSelectionRequested(Modifier modifier, Function0<Unit> function0) {
        return getHasFocus() ? SuspendingPointerInputFilterKt.pointerInput(modifier, Unit.INSTANCE, new SelectionManager$onClearSelectionRequested$1(this, function0, null)) : modifier;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setCurrentDragPosition-_kEHs6E, reason: not valid java name */
    public final void m619setCurrentDragPosition_kEHs6E(Offset offset) {
        this.currentDragPosition$delegate.setValue(offset);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setDragBeginPosition-k-4lQ0M, reason: not valid java name */
    public final void m620setDragBeginPositionk4lQ0M(long j) {
        this.dragBeginPosition$delegate.setValue(Offset.box-impl(j));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setDragTotalDistance-k-4lQ0M, reason: not valid java name */
    public final void m621setDragTotalDistancek4lQ0M(long j) {
        this.dragTotalDistance$delegate.setValue(Offset.box-impl(j));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setDraggingHandle(Handle handle) {
        this.draggingHandle$delegate.setValue(handle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setEndHandlePosition-_kEHs6E, reason: not valid java name */
    public final void m622setEndHandlePosition_kEHs6E(Offset offset) {
        this.endHandlePosition$delegate.setValue(offset);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setStartHandlePosition-_kEHs6E, reason: not valid java name */
    public final void m623setStartHandlePosition_kEHs6E(Offset offset) {
        this.startHandlePosition$delegate.setValue(offset);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: startSelection-9KIMszo, reason: not valid java name */
    public final void m624startSelection9KIMszo(long j, boolean z, SelectionAdjustment selectionAdjustment) {
        m631updateSelection3R_tFg$foundation_release(j, j, null, z, selectionAdjustment);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateHandleOffsets() {
        Selection.AnchorInfo end;
        Selection.AnchorInfo start;
        Selection selection = getSelection();
        LayoutCoordinates layoutCoordinates = this.containerLayoutCoordinates;
        Selectable anchorSelectable$foundation_release = (selection == null || (start = selection.getStart()) == null) ? null : getAnchorSelectable$foundation_release(start);
        Selectable anchorSelectable$foundation_release2 = (selection == null || (end = selection.getEnd()) == null) ? null : getAnchorSelectable$foundation_release(end);
        LayoutCoordinates layoutCoordinates2 = anchorSelectable$foundation_release != null ? anchorSelectable$foundation_release.getLayoutCoordinates() : null;
        LayoutCoordinates layoutCoordinates3 = anchorSelectable$foundation_release2 != null ? anchorSelectable$foundation_release2.getLayoutCoordinates() : null;
        if (selection == null || layoutCoordinates == null || !layoutCoordinates.isAttached() || layoutCoordinates2 == null || layoutCoordinates3 == null) {
            m623setStartHandlePosition_kEHs6E(null);
            m622setEndHandlePosition_kEHs6E(null);
            return;
        }
        long j = layoutCoordinates.localPositionOf-R5De75A(layoutCoordinates2, anchorSelectable$foundation_release.mo591getHandlePositiondBAh8RU(selection, true));
        long j2 = layoutCoordinates.localPositionOf-R5De75A(layoutCoordinates3, anchorSelectable$foundation_release2.mo591getHandlePositiondBAh8RU(selection, false));
        Rect visibleBounds = SelectionManagerKt.visibleBounds(layoutCoordinates);
        m623setStartHandlePosition_kEHs6E(SelectionManagerKt.containsInclusive-Uv8p0NA(visibleBounds, j) ? Offset.box-impl(j) : null);
        m622setEndHandlePosition_kEHs6E(SelectionManagerKt.containsInclusive-Uv8p0NA(visibleBounds, j2) ? Offset.box-impl(j2) : null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateSelectionToolbarPosition() {
        if (getHasFocus()) {
            TextToolbar textToolbar = this.textToolbar;
            if ((textToolbar != null ? textToolbar.getStatus() : null) == TextToolbarStatus.Shown) {
                showSelectionToolbar$foundation_release();
            }
        }
    }

    /* renamed from: contextMenuOpenAdjustment-k-4lQ0M, reason: not valid java name */
    public final void m625contextMenuOpenAdjustmentk4lQ0M(long j) {
        Selection selection = getSelection();
        if (selection != null ? TextRange.m2324getCollapsedimpl(selection.m599toTextRanged9O1mEE()) : true) {
            m624startSelection9KIMszo(j, true, SelectionAdjustment.Companion.getWord());
        }
    }

    public final void copy$foundation_release() {
        ClipboardManager clipboardManager;
        AnnotatedString selectedText$foundation_release = getSelectedText$foundation_release();
        if (selectedText$foundation_release == null || (clipboardManager = this.clipboardManager) == null) {
            return;
        }
        clipboardManager.setText(selectedText$foundation_release);
    }

    @Nullable
    public final Selectable getAnchorSelectable$foundation_release(@NotNull Selection.AnchorInfo anchorInfo) {
        Intrinsics.checkNotNullParameter(anchorInfo, "anchor");
        return this.selectionRegistrar.getSelectableMap$foundation_release().get(Long.valueOf(anchorInfo.getSelectableId()));
    }

    @Nullable
    public final ClipboardManager getClipboardManager() {
        return this.clipboardManager;
    }

    @Nullable
    public final LayoutCoordinates getContainerLayoutCoordinates() {
        return this.containerLayoutCoordinates;
    }

    @Nullable
    /* renamed from: getCurrentDragPosition-_m7T9-E, reason: not valid java name */
    public final Offset m626getCurrentDragPosition_m7T9E() {
        return (Offset) this.currentDragPosition$delegate.getValue();
    }

    /* renamed from: getDragBeginPosition-F1C5BW0$foundation_release, reason: not valid java name */
    public final long m627getDragBeginPositionF1C5BW0$foundation_release() {
        return ((Offset) this.dragBeginPosition$delegate.getValue()).unbox-impl();
    }

    /* renamed from: getDragTotalDistance-F1C5BW0$foundation_release, reason: not valid java name */
    public final long m628getDragTotalDistanceF1C5BW0$foundation_release() {
        return ((Offset) this.dragTotalDistance$delegate.getValue()).unbox-impl();
    }

    @Nullable
    public final Handle getDraggingHandle() {
        return (Handle) this.draggingHandle$delegate.getValue();
    }

    @Nullable
    /* renamed from: getEndHandlePosition-_m7T9-E, reason: not valid java name */
    public final Offset m629getEndHandlePosition_m7T9E() {
        return (Offset) this.endHandlePosition$delegate.getValue();
    }

    @NotNull
    public final FocusRequester getFocusRequester() {
        return this.focusRequester;
    }

    @Nullable
    public final HapticFeedback getHapticFeedBack() {
        return this.hapticFeedBack;
    }

    public final boolean getHasFocus() {
        return ((Boolean) this.hasFocus$delegate.getValue()).booleanValue();
    }

    @NotNull
    public final Modifier getModifier() {
        Modifier modifier = Modifier.Companion;
        Modifier onKeyEvent = KeyInputModifierKt.onKeyEvent(FocusableKt.focusable$default(FocusChangedModifierKt.onFocusChanged(FocusRequesterModifierKt.focusRequester(OnGloballyPositionedModifierKt.onGloballyPositioned(onClearSelectionRequested(modifier, new Function0<Unit>() { // from class: androidx.compose.foundation.text.selection.SelectionManager$modifier$1
            {
                super(0);
            }

            public /* bridge */ /* synthetic */ Object invoke() {
                m636invoke();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m636invoke() {
                SelectionManager.this.onRelease();
            }
        }), new Function1<LayoutCoordinates, Unit>() { // from class: androidx.compose.foundation.text.selection.SelectionManager$modifier$2
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((LayoutCoordinates) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull LayoutCoordinates layoutCoordinates) {
                Intrinsics.checkNotNullParameter(layoutCoordinates, "it");
                SelectionManager.this.setContainerLayoutCoordinates(layoutCoordinates);
            }
        }), this.focusRequester), new Function1<FocusState, Unit>() { // from class: androidx.compose.foundation.text.selection.SelectionManager$modifier$3
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((FocusState) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull FocusState focusState) {
                Intrinsics.checkNotNullParameter(focusState, "focusState");
                if (!focusState.isFocused() && SelectionManager.this.getHasFocus()) {
                    SelectionManager.this.onRelease();
                }
                SelectionManager.this.setHasFocus(focusState.isFocused());
            }
        }), false, (MutableInteractionSource) null, 3, (Object) null), new Function1<KeyEvent, Boolean>() { // from class: androidx.compose.foundation.text.selection.SelectionManager$modifier$4
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return m637invokeZmokQxo(((KeyEvent) obj).m1942unboximpl());
            }

            @NotNull
            /* renamed from: invoke-ZmokQxo, reason: not valid java name */
            public final Boolean m637invokeZmokQxo(@NotNull android.view.KeyEvent keyEvent) {
                boolean z;
                Intrinsics.checkNotNullParameter(keyEvent, "it");
                if (SelectionManager_androidKt.m639isCopyKeyEventZmokQxo(keyEvent)) {
                    SelectionManager.this.copy$foundation_release();
                    z = true;
                } else {
                    z = false;
                }
                return Boolean.valueOf(z);
            }
        });
        if (getShouldShowMagnifier()) {
            modifier = SelectionManager_androidKt.selectionMagnifier(modifier, this);
        }
        return onKeyEvent.then(modifier);
    }

    @NotNull
    public final Function1<Selection, Unit> getOnSelectionChange() {
        return this.onSelectionChange;
    }

    @Nullable
    public final AnnotatedString getSelectedText$foundation_release() {
        AnnotatedString plus;
        List<Selectable> sort = this.selectionRegistrar.sort(requireContainerCoordinates$foundation_release());
        Selection selection = getSelection();
        AnnotatedString annotatedString = null;
        if (selection == null) {
            return null;
        }
        int size = sort.size();
        for (int i = 0; i < size; i++) {
            Selectable selectable = sort.get(i);
            if (selectable.getSelectableId() == selection.getStart().getSelectableId() || selectable.getSelectableId() == selection.getEnd().getSelectableId() || annotatedString != null) {
                AnnotatedString currentSelectedText = SelectionManagerKt.getCurrentSelectedText(selectable, selection);
                if (annotatedString != null && (plus = annotatedString.plus(currentSelectedText)) != null) {
                    currentSelectedText = plus;
                }
                if ((selectable.getSelectableId() == selection.getEnd().getSelectableId() && !selection.getHandlesCrossed()) || (selectable.getSelectableId() == selection.getStart().getSelectableId() && selection.getHandlesCrossed())) {
                    return currentSelectedText;
                }
                annotatedString = currentSelectedText;
            }
        }
        return annotatedString;
    }

    @Nullable
    public final Selection getSelection() {
        return (Selection) this._selection.getValue();
    }

    @Nullable
    /* renamed from: getStartHandlePosition-_m7T9-E, reason: not valid java name */
    public final Offset m630getStartHandlePosition_m7T9E() {
        return (Offset) this.startHandlePosition$delegate.getValue();
    }

    @Nullable
    public final TextToolbar getTextToolbar() {
        return this.textToolbar;
    }

    public final boolean getTouchMode() {
        return this.touchMode;
    }

    @NotNull
    public final TextDragObserver handleDragObserver(boolean z) {
        return new handleDragObserver.1(this, z);
    }

    public final void hideSelectionToolbar$foundation_release() {
        TextToolbar textToolbar;
        if (getHasFocus()) {
            TextToolbar textToolbar2 = this.textToolbar;
            if ((textToolbar2 != null ? textToolbar2.getStatus() : null) != TextToolbarStatus.Shown || (textToolbar = this.textToolbar) == null) {
                return;
            }
            textToolbar.hide();
        }
    }

    public final void onRelease() {
        this.selectionRegistrar.setSubselections(MapsKt.emptyMap());
        hideSelectionToolbar$foundation_release();
        if (getSelection() != null) {
            this.onSelectionChange.invoke((Object) null);
            HapticFeedback hapticFeedback = this.hapticFeedBack;
            if (hapticFeedback != null) {
                hapticFeedback.mo1348performHapticFeedbackCdsT49E(HapticFeedbackType.Companion.m1350getTextHandleMove5zf0vsI());
            }
        }
    }

    @NotNull
    public final LayoutCoordinates requireContainerCoordinates$foundation_release() {
        LayoutCoordinates layoutCoordinates = this.containerLayoutCoordinates;
        if (!(layoutCoordinates != null)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        if (layoutCoordinates.isAttached()) {
            return layoutCoordinates;
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    @NotNull
    public final Pair<Selection, Map<Long, Selection>> selectAll$foundation_release(long j, @Nullable Selection selection) {
        HapticFeedback hapticFeedback;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        List<Selectable> sort = this.selectionRegistrar.sort(requireContainerCoordinates$foundation_release());
        int size = sort.size();
        Selection selection2 = null;
        for (int i = 0; i < size; i++) {
            Selectable selectable = sort.get(i);
            Selection selectAllSelection = selectable.getSelectableId() == j ? selectable.getSelectAllSelection() : null;
            if (selectAllSelection != null) {
                linkedHashMap.put(Long.valueOf(selectable.getSelectableId()), selectAllSelection);
            }
            selection2 = SelectionManagerKt.merge(selection2, selectAllSelection);
        }
        if (!Intrinsics.areEqual(selection2, selection) && (hapticFeedback = this.hapticFeedBack) != null) {
            hapticFeedback.mo1348performHapticFeedbackCdsT49E(HapticFeedbackType.Companion.m1350getTextHandleMove5zf0vsI());
        }
        return new Pair<>(selection2, linkedHashMap);
    }

    public final void setClipboardManager(@Nullable ClipboardManager clipboardManager) {
        this.clipboardManager = clipboardManager;
    }

    public final void setContainerLayoutCoordinates(@Nullable LayoutCoordinates layoutCoordinates) {
        this.containerLayoutCoordinates = layoutCoordinates;
        if (!getHasFocus() || getSelection() == null) {
            return;
        }
        Offset offset = layoutCoordinates != null ? Offset.box-impl(LayoutCoordinatesKt.positionInWindow(layoutCoordinates)) : null;
        if (Intrinsics.areEqual(this.previousPosition, offset)) {
            return;
        }
        this.previousPosition = offset;
        updateHandleOffsets();
        updateSelectionToolbarPosition();
    }

    public final void setFocusRequester(@NotNull FocusRequester focusRequester) {
        Intrinsics.checkNotNullParameter(focusRequester, "<set-?>");
        this.focusRequester = focusRequester;
    }

    public final void setHapticFeedBack(@Nullable HapticFeedback hapticFeedback) {
        this.hapticFeedBack = hapticFeedback;
    }

    public final void setHasFocus(boolean z) {
        this.hasFocus$delegate.setValue(Boolean.valueOf(z));
    }

    public final void setOnSelectionChange(@NotNull Function1<? super Selection, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "<set-?>");
        this.onSelectionChange = function1;
    }

    public final void setSelection(@Nullable Selection selection) {
        this._selection.setValue(selection);
        if (selection != null) {
            updateHandleOffsets();
        }
    }

    public final void setTextToolbar(@Nullable TextToolbar textToolbar) {
        this.textToolbar = textToolbar;
    }

    public final void setTouchMode(boolean z) {
        this.touchMode = z;
    }

    public final void showSelectionToolbar$foundation_release() {
        TextToolbar textToolbar;
        if (!getHasFocus() || getSelection() == null || (textToolbar = this.textToolbar) == null) {
            return;
        }
        xh5.a(textToolbar, getContentRect(), new showSelectionToolbar.1.1(this), (Function0) null, (Function0) null, (Function0) null, 28, (Object) null);
    }

    /* renamed from: updateSelection-3R_-tFg$foundation_release, reason: not valid java name */
    public final boolean m631updateSelection3R_tFg$foundation_release(long j, long j2, @Nullable Offset offset, boolean z, @NotNull SelectionAdjustment selectionAdjustment) {
        Intrinsics.checkNotNullParameter(selectionAdjustment, "adjustment");
        setDraggingHandle(z ? Handle.SelectionStart : Handle.SelectionEnd);
        m619setCurrentDragPosition_kEHs6E(z ? Offset.box-impl(j) : Offset.box-impl(j2));
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        List<Selectable> sort = this.selectionRegistrar.sort(requireContainerCoordinates$foundation_release());
        int size = sort.size();
        Selection selection = null;
        int i = 0;
        boolean z2 = false;
        while (i < size) {
            Selectable selectable = sort.get(i);
            int i2 = i;
            Selection selection2 = selection;
            Pair<Selection, Boolean> mo593updateSelectionqCDeeow = selectable.mo593updateSelectionqCDeeow(j, j2, offset, z, requireContainerCoordinates$foundation_release(), selectionAdjustment, this.selectionRegistrar.getSubselections().get(Long.valueOf(selectable.getSelectableId())));
            Selection selection3 = (Selection) mo593updateSelectionqCDeeow.component1();
            z2 = z2 || ((Boolean) mo593updateSelectionqCDeeow.component2()).booleanValue();
            if (selection3 != null) {
                linkedHashMap.put(Long.valueOf(selectable.getSelectableId()), selection3);
            }
            selection = SelectionManagerKt.merge(selection2, selection3);
            i = i2 + 1;
        }
        Selection selection4 = selection;
        if (!Intrinsics.areEqual(selection4, getSelection())) {
            HapticFeedback hapticFeedback = this.hapticFeedBack;
            if (hapticFeedback != null) {
                hapticFeedback.mo1348performHapticFeedbackCdsT49E(HapticFeedbackType.Companion.m1350getTextHandleMove5zf0vsI());
            }
            this.selectionRegistrar.setSubselections(linkedHashMap);
            this.onSelectionChange.invoke(selection4);
        }
        return z2;
    }

    /* renamed from: updateSelection-RHHTvR4$foundation_release, reason: not valid java name */
    public final boolean m632updateSelectionRHHTvR4$foundation_release(@Nullable Offset offset, @Nullable Offset offset2, boolean z, @NotNull SelectionAdjustment selectionAdjustment) {
        Selection selection;
        Offset m618convertToContainerCoordinatesQ7Q5hAU;
        Intrinsics.checkNotNullParameter(selectionAdjustment, "adjustment");
        if (offset == null || (selection = getSelection()) == null) {
            return false;
        }
        Selectable selectable = this.selectionRegistrar.getSelectableMap$foundation_release().get(Long.valueOf(z ? selection.getEnd().getSelectableId() : selection.getStart().getSelectableId()));
        if (selectable == null) {
            m618convertToContainerCoordinatesQ7Q5hAU = null;
        } else {
            LayoutCoordinates layoutCoordinates = selectable.getLayoutCoordinates();
            Intrinsics.checkNotNull(layoutCoordinates);
            m618convertToContainerCoordinatesQ7Q5hAU = m618convertToContainerCoordinatesQ7Q5hAU(layoutCoordinates, SelectionHandlesKt.getAdjustedCoordinates-k-4lQ0M(selectable.mo591getHandlePositiondBAh8RU(selection, !z)));
        }
        if (m618convertToContainerCoordinatesQ7Q5hAU == null) {
            return false;
        }
        long j = m618convertToContainerCoordinatesQ7Q5hAU.unbox-impl();
        long j2 = z ? offset.unbox-impl() : j;
        if (!z) {
            j = offset.unbox-impl();
        }
        return m631updateSelection3R_tFg$foundation_release(j2, j, offset2, z, selectionAdjustment);
    }
}
