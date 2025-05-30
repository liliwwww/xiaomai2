package androidx.compose.ui.text.android.style;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.Layout;
import android.text.style.LeadingMarginSpan;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.text.android.InternalPlatformTextApi;
import androidx.compose.ui.text.android.TextLayoutKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@StabilityInferred(parameters = 0)
@InternalPlatformTextApi
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class IndentationFixSpan implements LeadingMarginSpan {
    public static final int $stable = 0;

    @Override // android.text.style.LeadingMarginSpan
    public void drawLeadingMargin(@Nullable Canvas canvas, @Nullable Paint paint, int i, int i2, int i3, int i4, int i5, @Nullable CharSequence charSequence, int i6, int i7, boolean z, @Nullable Layout layout) {
        if (layout == null || paint == null) {
            return;
        }
        int lineForOffset = layout.getLineForOffset(i6);
        if (lineForOffset == layout.getLineCount() - 1 && TextLayoutKt.isLineEllipsized(layout, lineForOffset)) {
            float ellipsizedLeftPadding = IndentationFixSpanKt.getEllipsizedLeftPadding(layout, lineForOffset, paint) + IndentationFixSpanKt.getEllipsizedRightPadding(layout, lineForOffset, paint);
            if (ellipsizedLeftPadding == 0.0f) {
                return;
            }
            Intrinsics.checkNotNull(canvas);
            canvas.translate(ellipsizedLeftPadding, 0.0f);
        }
    }

    @Override // android.text.style.LeadingMarginSpan
    public int getLeadingMargin(boolean z) {
        return 0;
    }
}
