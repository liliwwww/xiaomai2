package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.text.Handle;
import androidx.compose.foundation.text.TextDragObserver;
import androidx.compose.foundation.text.TextFieldState;
import androidx.compose.foundation.text.TextLayoutResultProxy;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.hapticfeedback.HapticFeedback;
import androidx.compose.ui.hapticfeedback.HapticFeedbackType;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import androidx.compose.ui.text.input.OffsetMapping;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class TextFieldSelectionManager$cursorDragObserver$1 implements TextDragObserver {
    final /* synthetic */ TextFieldSelectionManager this$0;

    TextFieldSelectionManager$cursorDragObserver$1(TextFieldSelectionManager textFieldSelectionManager) {
        this.this$0 = textFieldSelectionManager;
    }

    public void onCancel() {
    }

    /* renamed from: onDown-k-4lQ0M, reason: not valid java name */
    public void m646onDownk4lQ0M(long j) {
        TextFieldSelectionManager.access$setDraggingHandle(this.this$0, Handle.Cursor);
        TextFieldSelectionManager textFieldSelectionManager = this.this$0;
        TextFieldSelectionManager.access$setCurrentDragPosition-_kEHs6E(textFieldSelectionManager, Offset.box-impl(SelectionHandlesKt.getAdjustedCoordinates-k-4lQ0M(textFieldSelectionManager.getHandlePosition-tuRUvjQ$foundation_release(true))));
    }

    /* renamed from: onDrag-k-4lQ0M, reason: not valid java name */
    public void m647onDragk4lQ0M(long j) {
        TextLayoutResultProxy layoutResult;
        TextLayoutResult value;
        TextFieldSelectionManager textFieldSelectionManager = this.this$0;
        TextFieldSelectionManager.access$setDragTotalDistance$p(textFieldSelectionManager, Offset.plus-MK-Hz9U(TextFieldSelectionManager.access$getDragTotalDistance$p(textFieldSelectionManager), j));
        TextFieldState state$foundation_release = this.this$0.getState$foundation_release();
        if (state$foundation_release == null || (layoutResult = state$foundation_release.getLayoutResult()) == null || (value = layoutResult.getValue()) == null) {
            return;
        }
        TextFieldSelectionManager textFieldSelectionManager2 = this.this$0;
        TextFieldSelectionManager.access$setCurrentDragPosition-_kEHs6E(textFieldSelectionManager2, Offset.box-impl(Offset.plus-MK-Hz9U(TextFieldSelectionManager.access$getDragBeginPosition$p(textFieldSelectionManager2), TextFieldSelectionManager.access$getDragTotalDistance$p(textFieldSelectionManager2))));
        OffsetMapping offsetMapping$foundation_release = textFieldSelectionManager2.getOffsetMapping$foundation_release();
        Offset offset = textFieldSelectionManager2.getCurrentDragPosition-_m7T9-E();
        Intrinsics.checkNotNull(offset);
        int transformedToOriginal = offsetMapping$foundation_release.transformedToOriginal(value.getOffsetForPosition-k-4lQ0M(offset.unbox-impl()));
        long TextRange = TextRangeKt.TextRange(transformedToOriginal, transformedToOriginal);
        if (TextRange.m2323equalsimpl0(TextRange, textFieldSelectionManager2.getValue$foundation_release().getSelection-d9O1mEE())) {
            return;
        }
        HapticFeedback hapticFeedBack = textFieldSelectionManager2.getHapticFeedBack();
        if (hapticFeedBack != null) {
            hapticFeedBack.mo1348performHapticFeedbackCdsT49E(HapticFeedbackType.Companion.m1350getTextHandleMove5zf0vsI());
        }
        textFieldSelectionManager2.getOnValueChange$foundation_release().invoke(TextFieldSelectionManager.access$createTextFieldValue-FDrldGo(textFieldSelectionManager2, textFieldSelectionManager2.getValue$foundation_release().getAnnotatedString(), TextRange));
    }

    /* renamed from: onStart-k-4lQ0M, reason: not valid java name */
    public void m648onStartk4lQ0M(long j) {
        TextFieldSelectionManager textFieldSelectionManager = this.this$0;
        TextFieldSelectionManager.access$setDragBeginPosition$p(textFieldSelectionManager, SelectionHandlesKt.getAdjustedCoordinates-k-4lQ0M(textFieldSelectionManager.getHandlePosition-tuRUvjQ$foundation_release(true)));
        TextFieldSelectionManager textFieldSelectionManager2 = this.this$0;
        TextFieldSelectionManager.access$setCurrentDragPosition-_kEHs6E(textFieldSelectionManager2, Offset.box-impl(TextFieldSelectionManager.access$getDragBeginPosition$p(textFieldSelectionManager2)));
        TextFieldSelectionManager.access$setDragTotalDistance$p(this.this$0, Offset.Companion.m1024getZeroF1C5BW0());
        TextFieldSelectionManager.access$setDraggingHandle(this.this$0, Handle.Cursor);
    }

    public void onStop() {
        TextFieldSelectionManager.access$setDraggingHandle(this.this$0, (Handle) null);
        TextFieldSelectionManager.access$setCurrentDragPosition-_kEHs6E(this.this$0, (Offset) null);
    }

    public void onUp() {
        TextFieldSelectionManager.access$setDraggingHandle(this.this$0, (Handle) null);
        TextFieldSelectionManager.access$setCurrentDragPosition-_kEHs6E(this.this$0, (Offset) null);
    }
}
