package androidx.compose.foundation.text;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Rect;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class TextLayoutResultProxyKt {
    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: coerceIn-3MmeM6k, reason: not valid java name */
    public static final long m584coerceIn3MmeM6k(long j, Rect rect) {
        return OffsetKt.Offset(Offset.getX-impl(j) < rect.getLeft() ? rect.getLeft() : Offset.getX-impl(j) > rect.getRight() ? rect.getRight() : Offset.getX-impl(j), Offset.getY-impl(j) < rect.getTop() ? rect.getTop() : Offset.getY-impl(j) > rect.getBottom() ? rect.getBottom() : Offset.getY-impl(j));
    }
}
