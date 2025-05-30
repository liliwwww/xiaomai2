package androidx.compose.p004ui.text.input;

import androidx.compose.p004ui.text.TextRange;
import androidx.compose.p004ui.text.TextRangeKt;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public final class EditingBufferKt {
    /* renamed from: updateRangeAfterDelete-pWDy79M, reason: not valid java name */
    public static final long m4879updateRangeAfterDeletepWDy79M(long j, long j2) {
        int m4745getLengthimpl;
        int m4747getMinimpl = TextRange.m4747getMinimpl(j);
        int m4746getMaximpl = TextRange.m4746getMaximpl(j);
        if (TextRange.m4751intersects5zctL8(j2, j)) {
            if (TextRange.m4739contains5zctL8(j2, j)) {
                m4747getMinimpl = TextRange.m4747getMinimpl(j2);
                m4746getMaximpl = m4747getMinimpl;
            } else {
                if (TextRange.m4739contains5zctL8(j, j2)) {
                    m4745getLengthimpl = TextRange.m4745getLengthimpl(j2);
                } else if (TextRange.m4740containsimpl(j2, m4747getMinimpl)) {
                    m4747getMinimpl = TextRange.m4747getMinimpl(j2);
                    m4745getLengthimpl = TextRange.m4745getLengthimpl(j2);
                } else {
                    m4746getMaximpl = TextRange.m4747getMinimpl(j2);
                }
                m4746getMaximpl -= m4745getLengthimpl;
            }
        } else if (m4746getMaximpl > TextRange.m4747getMinimpl(j2)) {
            m4747getMinimpl -= TextRange.m4745getLengthimpl(j2);
            m4745getLengthimpl = TextRange.m4745getLengthimpl(j2);
            m4746getMaximpl -= m4745getLengthimpl;
        }
        return TextRangeKt.TextRange(m4747getMinimpl, m4746getMaximpl);
    }
}
