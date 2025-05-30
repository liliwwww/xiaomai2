package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.text.TextFieldState;
import androidx.compose.foundation.text.TextLayoutResultProxy;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.input.TextFieldValue;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class TextFieldSelectionManager$mouseSelectionObserver$1 implements MouseSelectionObserver {
    final /* synthetic */ TextFieldSelectionManager this$0;

    TextFieldSelectionManager$mouseSelectionObserver$1(TextFieldSelectionManager textFieldSelectionManager) {
        this.this$0 = textFieldSelectionManager;
    }

    @Override // androidx.compose.foundation.text.selection.MouseSelectionObserver
    /* renamed from: onDrag-3MmeM6k */
    public boolean mo565onDrag3MmeM6k(long j, @NotNull SelectionAdjustment selectionAdjustment) {
        TextFieldState state$foundation_release;
        TextLayoutResultProxy layoutResult;
        Intrinsics.checkNotNullParameter(selectionAdjustment, "adjustment");
        if ((this.this$0.getValue$foundation_release().getText().length() == 0) || (state$foundation_release = this.this$0.getState$foundation_release()) == null || (layoutResult = state$foundation_release.getLayoutResult()) == null) {
            return false;
        }
        TextFieldSelectionManager textFieldSelectionManager = this.this$0;
        int i = layoutResult.getOffsetForPosition-3MmeM6k(j, false);
        TextFieldValue value$foundation_release = textFieldSelectionManager.getValue$foundation_release();
        Integer access$getDragBeginOffsetInText$p = TextFieldSelectionManager.access$getDragBeginOffsetInText$p(textFieldSelectionManager);
        Intrinsics.checkNotNull(access$getDragBeginOffsetInText$p);
        TextFieldSelectionManager.access$updateSelection(textFieldSelectionManager, value$foundation_release, access$getDragBeginOffsetInText$p.intValue(), i, false, selectionAdjustment);
        return true;
    }

    @Override // androidx.compose.foundation.text.selection.MouseSelectionObserver
    /* renamed from: onExtend-k-4lQ0M */
    public boolean mo566onExtendk4lQ0M(long j) {
        TextLayoutResultProxy layoutResult;
        TextFieldState state$foundation_release = this.this$0.getState$foundation_release();
        if (state$foundation_release == null || (layoutResult = state$foundation_release.getLayoutResult()) == null) {
            return false;
        }
        TextFieldSelectionManager textFieldSelectionManager = this.this$0;
        TextFieldSelectionManager.access$updateSelection(textFieldSelectionManager, textFieldSelectionManager.getValue$foundation_release(), textFieldSelectionManager.getOffsetMapping$foundation_release().originalToTransformed(TextRange.m2330getStartimpl(textFieldSelectionManager.getValue$foundation_release().getSelection-d9O1mEE())), TextLayoutResultProxy.getOffsetForPosition-3MmeM6k$default(layoutResult, j, false, 2, (Object) null), false, SelectionAdjustment.Companion.getNone());
        return true;
    }

    @Override // androidx.compose.foundation.text.selection.MouseSelectionObserver
    /* renamed from: onExtendDrag-k-4lQ0M */
    public boolean mo567onExtendDragk4lQ0M(long j) {
        TextFieldState state$foundation_release;
        TextLayoutResultProxy layoutResult;
        if ((this.this$0.getValue$foundation_release().getText().length() == 0) || (state$foundation_release = this.this$0.getState$foundation_release()) == null || (layoutResult = state$foundation_release.getLayoutResult()) == null) {
            return false;
        }
        TextFieldSelectionManager textFieldSelectionManager = this.this$0;
        TextFieldSelectionManager.access$updateSelection(textFieldSelectionManager, textFieldSelectionManager.getValue$foundation_release(), textFieldSelectionManager.getOffsetMapping$foundation_release().originalToTransformed(TextRange.m2330getStartimpl(textFieldSelectionManager.getValue$foundation_release().getSelection-d9O1mEE())), layoutResult.getOffsetForPosition-3MmeM6k(j, false), false, SelectionAdjustment.Companion.getNone());
        return true;
    }

    @Override // androidx.compose.foundation.text.selection.MouseSelectionObserver
    /* renamed from: onStart-3MmeM6k */
    public boolean mo568onStart3MmeM6k(long j, @NotNull SelectionAdjustment selectionAdjustment) {
        TextLayoutResultProxy layoutResult;
        Intrinsics.checkNotNullParameter(selectionAdjustment, "adjustment");
        FocusRequester focusRequester = this.this$0.getFocusRequester();
        if (focusRequester != null) {
            focusRequester.requestFocus();
        }
        TextFieldSelectionManager.access$setDragBeginPosition$p(this.this$0, j);
        TextFieldState state$foundation_release = this.this$0.getState$foundation_release();
        if (state$foundation_release == null || (layoutResult = state$foundation_release.getLayoutResult()) == null) {
            return false;
        }
        TextFieldSelectionManager textFieldSelectionManager = this.this$0;
        TextFieldSelectionManager.access$setDragBeginOffsetInText$p(textFieldSelectionManager, Integer.valueOf(TextLayoutResultProxy.getOffsetForPosition-3MmeM6k$default(layoutResult, j, false, 2, (Object) null)));
        int i = TextLayoutResultProxy.getOffsetForPosition-3MmeM6k$default(layoutResult, TextFieldSelectionManager.access$getDragBeginPosition$p(textFieldSelectionManager), false, 2, (Object) null);
        TextFieldSelectionManager.access$updateSelection(textFieldSelectionManager, textFieldSelectionManager.getValue$foundation_release(), i, i, false, selectionAdjustment);
        return true;
    }
}
