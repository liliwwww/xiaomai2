package androidx.compose.foundation.text.selection;

import androidx.compose.p004ui.geometry.OffsetKt;
import androidx.compose.p004ui.text.TextLayoutResult;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public final class TextSelectionDelegateKt {
    public static final float getHorizontalPosition(@NotNull TextLayoutResult textLayoutResult, int i, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(textLayoutResult, "<this>");
        return textLayoutResult.getHorizontalPosition(i, textLayoutResult.getBidiRunDirection(((!z || z2) && (z || !z2)) ? Math.max(i + (-1), 0) : i) == textLayoutResult.getParagraphDirection(i));
    }

    public static final long getSelectionHandleCoordinates(@NotNull TextLayoutResult textLayoutResult, int i, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(textLayoutResult, "textLayoutResult");
        return OffsetKt.Offset(getHorizontalPosition(textLayoutResult, i, z, z2), textLayoutResult.getLineBottom(textLayoutResult.getLineForOffset(i)));
    }
}
