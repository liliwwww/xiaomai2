package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.text.Handle;
import androidx.compose.foundation.text.TextDragObserver;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.layout.LayoutCoordinates;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class SelectionManager$handleDragObserver$1 implements TextDragObserver {
    final /* synthetic */ boolean $isStartHandle;
    final /* synthetic */ SelectionManager this$0;

    SelectionManager$handleDragObserver$1(SelectionManager selectionManager, boolean z) {
        this.this$0 = selectionManager;
        this.$isStartHandle = z;
    }

    @Override // androidx.compose.foundation.text.TextDragObserver
    public void onCancel() {
        this.this$0.showSelectionToolbar$foundation_release();
        SelectionManager.access$setDraggingHandle(this.this$0, (Handle) null);
        SelectionManager.access$setCurrentDragPosition-_kEHs6E(this.this$0, (Offset) null);
    }

    @Override // androidx.compose.foundation.text.TextDragObserver
    /* renamed from: onDown-k-4lQ0M */
    public void mo434onDownk4lQ0M(long j) {
        LayoutCoordinates layoutCoordinates;
        Selection selection = this.this$0.getSelection();
        if (selection == null) {
            return;
        }
        Selectable anchorSelectable$foundation_release = this.this$0.getAnchorSelectable$foundation_release(this.$isStartHandle ? selection.getStart() : selection.getEnd());
        if (anchorSelectable$foundation_release == null || (layoutCoordinates = anchorSelectable$foundation_release.getLayoutCoordinates()) == null) {
            return;
        }
        long m465getAdjustedCoordinatesk4lQ0M = SelectionHandlesKt.m465getAdjustedCoordinatesk4lQ0M(anchorSelectable$foundation_release.getHandlePosition-dBAh8RU(selection, this.$isStartHandle));
        SelectionManager selectionManager = this.this$0;
        SelectionManager.access$setCurrentDragPosition-_kEHs6E(selectionManager, Offset.m837boximpl(selectionManager.requireContainerCoordinates$foundation_release().mo1523localPositionOfR5De75A(layoutCoordinates, m465getAdjustedCoordinatesk4lQ0M)));
        SelectionManager.access$setDraggingHandle(this.this$0, this.$isStartHandle ? Handle.SelectionStart : Handle.SelectionEnd);
    }

    @Override // androidx.compose.foundation.text.TextDragObserver
    /* renamed from: onDrag-k-4lQ0M */
    public void mo435onDragk4lQ0M(long j) {
        SelectionManager selectionManager = this.this$0;
        SelectionManager.access$setDragTotalDistance-k-4lQ0M(selectionManager, Offset.m853plusMKHz9U(selectionManager.getDragTotalDistance-F1C5BW0$foundation_release(), j));
        long m853plusMKHz9U = Offset.m853plusMKHz9U(this.this$0.getDragBeginPosition-F1C5BW0$foundation_release(), this.this$0.getDragTotalDistance-F1C5BW0$foundation_release());
        if (this.this$0.updateSelection-RHHTvR4$foundation_release(Offset.m837boximpl(m853plusMKHz9U), Offset.m837boximpl(this.this$0.getDragBeginPosition-F1C5BW0$foundation_release()), this.$isStartHandle, SelectionAdjustment.Companion.getCharacterWithWordAccelerate())) {
            SelectionManager.access$setDragBeginPosition-k-4lQ0M(this.this$0, m853plusMKHz9U);
            SelectionManager.access$setDragTotalDistance-k-4lQ0M(this.this$0, Offset.Companion.getZero-F1C5BW0());
        }
    }

    @Override // androidx.compose.foundation.text.TextDragObserver
    /* renamed from: onStart-k-4lQ0M */
    public void mo436onStartk4lQ0M(long j) {
        LayoutCoordinates layoutCoordinates;
        long j2;
        this.this$0.hideSelectionToolbar$foundation_release();
        Selection selection = this.this$0.getSelection();
        Intrinsics.checkNotNull(selection);
        Selectable selectable = (Selectable) SelectionManager.access$getSelectionRegistrar$p(this.this$0).getSelectableMap$foundation_release().get(Long.valueOf(selection.getStart().getSelectableId()));
        Selectable selectable2 = (Selectable) SelectionManager.access$getSelectionRegistrar$p(this.this$0).getSelectableMap$foundation_release().get(Long.valueOf(selection.getEnd().getSelectableId()));
        if (this.$isStartHandle) {
            layoutCoordinates = selectable != null ? selectable.getLayoutCoordinates() : null;
            Intrinsics.checkNotNull(layoutCoordinates);
        } else {
            layoutCoordinates = selectable2 != null ? selectable2.getLayoutCoordinates() : null;
            Intrinsics.checkNotNull(layoutCoordinates);
        }
        if (this.$isStartHandle) {
            Intrinsics.checkNotNull(selectable);
            j2 = selectable.getHandlePosition-dBAh8RU(selection, true);
        } else {
            Intrinsics.checkNotNull(selectable2);
            j2 = selectable2.getHandlePosition-dBAh8RU(selection, false);
        }
        long m465getAdjustedCoordinatesk4lQ0M = SelectionHandlesKt.m465getAdjustedCoordinatesk4lQ0M(j2);
        SelectionManager selectionManager = this.this$0;
        SelectionManager.access$setDragBeginPosition-k-4lQ0M(selectionManager, selectionManager.requireContainerCoordinates$foundation_release().mo1523localPositionOfR5De75A(layoutCoordinates, m465getAdjustedCoordinatesk4lQ0M));
        SelectionManager.access$setDragTotalDistance-k-4lQ0M(this.this$0, Offset.Companion.getZero-F1C5BW0());
    }

    @Override // androidx.compose.foundation.text.TextDragObserver
    public void onStop() {
        this.this$0.showSelectionToolbar$foundation_release();
        SelectionManager.access$setDraggingHandle(this.this$0, (Handle) null);
        SelectionManager.access$setCurrentDragPosition-_kEHs6E(this.this$0, (Offset) null);
    }

    @Override // androidx.compose.foundation.text.TextDragObserver
    public void onUp() {
        SelectionManager.access$setDraggingHandle(this.this$0, (Handle) null);
        SelectionManager.access$setCurrentDragPosition-_kEHs6E(this.this$0, (Offset) null);
    }
}
