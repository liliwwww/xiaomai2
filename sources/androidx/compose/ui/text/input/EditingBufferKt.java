package androidx.compose.ui.text.input;

import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class EditingBufferKt {
    /* renamed from: updateRangeAfterDelete-pWDy79M, reason: not valid java name */
    public static final long m2423updateRangeAfterDeletepWDy79M(long j, long j2) {
        int m2326getLengthimpl;
        int m2328getMinimpl = TextRange.m2328getMinimpl(j);
        int m2327getMaximpl = TextRange.m2327getMaximpl(j);
        if (TextRange.m2332intersects5zctL8(j2, j)) {
            if (TextRange.m2320contains5zctL8(j2, j)) {
                m2328getMinimpl = TextRange.m2328getMinimpl(j2);
                m2327getMaximpl = m2328getMinimpl;
            } else {
                if (TextRange.m2320contains5zctL8(j, j2)) {
                    m2326getLengthimpl = TextRange.m2326getLengthimpl(j2);
                } else if (TextRange.m2321containsimpl(j2, m2328getMinimpl)) {
                    m2328getMinimpl = TextRange.m2328getMinimpl(j2);
                    m2326getLengthimpl = TextRange.m2326getLengthimpl(j2);
                } else {
                    m2327getMaximpl = TextRange.m2328getMinimpl(j2);
                }
                m2327getMaximpl -= m2326getLengthimpl;
            }
        } else if (m2327getMaximpl > TextRange.m2328getMinimpl(j2)) {
            m2328getMinimpl -= TextRange.m2326getLengthimpl(j2);
            m2326getLengthimpl = TextRange.m2326getLengthimpl(j2);
            m2327getMaximpl -= m2326getLengthimpl;
        }
        return TextRangeKt.TextRange(m2328getMinimpl, m2327getMaximpl);
    }
}
