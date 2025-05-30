package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.text.selection.SelectionAdjustment;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class SelectionAdjustment$Companion$Word$1 implements SelectionAdjustment {
    SelectionAdjustment$Companion$Word$1() {
    }

    @Override // androidx.compose.foundation.text.selection.SelectionAdjustment
    /* renamed from: adjust-ZXO7KMw */
    public long mo463adjustZXO7KMw(@NotNull TextLayoutResult textLayoutResult, long j, int i, boolean z, @Nullable TextRange textRange) {
        Intrinsics.checkNotNullParameter(textLayoutResult, "textLayoutResult");
        return SelectionAdjustment.Companion.access$adjustByBoundary--Dv-ylE(SelectionAdjustment.Companion.$$INSTANCE, textLayoutResult, j, new SelectionAdjustment$Companion$Word$1$adjust$1(textLayoutResult));
    }
}
