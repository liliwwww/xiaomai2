package androidx.compose.ui.text.input;

import android.graphics.Matrix;
import android.view.inputmethod.CursorAnchorInfo;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.style.ResolvedTextDirection;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class CursorAnchorInfoBuilderKt {
    @NotNull
    public static final CursorAnchorInfo build(@NotNull CursorAnchorInfo.Builder builder, @NotNull TextFieldValue textFieldValue, @NotNull TextLayoutResult textLayoutResult, @NotNull Matrix matrix) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        Intrinsics.checkNotNullParameter(textFieldValue, "textFieldValue");
        Intrinsics.checkNotNullParameter(textLayoutResult, "textLayoutResult");
        Intrinsics.checkNotNullParameter(matrix, "matrix");
        builder.reset();
        builder.setMatrix(matrix);
        int m2328getMinimpl = TextRange.m2328getMinimpl(textFieldValue.getSelection-d9O1mEE());
        builder.setSelectionRange(m2328getMinimpl, TextRange.m2327getMaximpl(textFieldValue.getSelection-d9O1mEE()));
        setInsertionMarker(builder, m2328getMinimpl, textLayoutResult);
        TextRange textRange = textFieldValue.getComposition-MzsxiRA();
        int m2328getMinimpl2 = textRange != null ? TextRange.m2328getMinimpl(textRange.m2334unboximpl()) : -1;
        TextRange textRange2 = textFieldValue.getComposition-MzsxiRA();
        int m2327getMaximpl = textRange2 != null ? TextRange.m2327getMaximpl(textRange2.m2334unboximpl()) : -1;
        boolean z = false;
        if (m2328getMinimpl2 >= 0 && m2328getMinimpl2 < m2327getMaximpl) {
            z = true;
        }
        if (z) {
            builder.setComposingText(m2328getMinimpl2, textFieldValue.getText().subSequence(m2328getMinimpl2, m2327getMaximpl));
        }
        CursorAnchorInfo build = builder.build();
        Intrinsics.checkNotNullExpressionValue(build, "build()");
        return build;
    }

    private static final CursorAnchorInfo.Builder setInsertionMarker(CursorAnchorInfo.Builder builder, int i, TextLayoutResult textLayoutResult) {
        if (i < 0) {
            return builder;
        }
        Rect cursorRect = textLayoutResult.getCursorRect(i);
        builder.setInsertionMarkerLocation(cursorRect.getLeft(), cursorRect.getTop(), cursorRect.getBottom(), cursorRect.getBottom(), textLayoutResult.getBidiRunDirection(i) == ResolvedTextDirection.Rtl ? 4 : 0);
        return builder;
    }
}
