package androidx.compose.p004ui.text.input;

import android.graphics.Matrix;
import android.view.inputmethod.CursorAnchorInfo;
import androidx.compose.p004ui.geometry.Rect;
import androidx.compose.p004ui.text.TextLayoutResult;
import androidx.compose.p004ui.text.TextRange;
import androidx.compose.p004ui.text.style.ResolvedTextDirection;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public final class CursorAnchorInfoBuilderKt {
    @NotNull
    public static final CursorAnchorInfo build(@NotNull CursorAnchorInfo.Builder builder, @NotNull TextFieldValue textFieldValue, @NotNull TextLayoutResult textLayoutResult, @NotNull Matrix matrix) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        Intrinsics.checkNotNullParameter(textFieldValue, "textFieldValue");
        Intrinsics.checkNotNullParameter(textLayoutResult, "textLayoutResult");
        Intrinsics.checkNotNullParameter(matrix, "matrix");
        builder.reset();
        builder.setMatrix(matrix);
        int m4747getMinimpl = TextRange.m4747getMinimpl(textFieldValue.m4956getSelectiond9O1mEE());
        builder.setSelectionRange(m4747getMinimpl, TextRange.m4746getMaximpl(textFieldValue.m4956getSelectiond9O1mEE()));
        setInsertionMarker(builder, m4747getMinimpl, textLayoutResult);
        TextRange m4955getCompositionMzsxiRA = textFieldValue.m4955getCompositionMzsxiRA();
        int m4747getMinimpl2 = m4955getCompositionMzsxiRA != null ? TextRange.m4747getMinimpl(m4955getCompositionMzsxiRA.m4753unboximpl()) : -1;
        TextRange m4955getCompositionMzsxiRA2 = textFieldValue.m4955getCompositionMzsxiRA();
        int m4746getMaximpl = m4955getCompositionMzsxiRA2 != null ? TextRange.m4746getMaximpl(m4955getCompositionMzsxiRA2.m4753unboximpl()) : -1;
        boolean z = false;
        if (m4747getMinimpl2 >= 0 && m4747getMinimpl2 < m4746getMaximpl) {
            z = true;
        }
        if (z) {
            builder.setComposingText(m4747getMinimpl2, textFieldValue.getText().subSequence(m4747getMinimpl2, m4746getMaximpl));
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
