package androidx.compose.foundation.text;

import androidx.compose.p004ui.geometry.Offset;
import androidx.compose.p004ui.geometry.OffsetKt;
import androidx.compose.p004ui.geometry.Rect;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public final class TextLayoutResultProxyKt {
    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: coerceIn-3MmeM6k, reason: not valid java name */
    public static final long m1814coerceIn3MmeM6k(long j, Rect rect) {
        return OffsetKt.Offset(Offset.m2556getXimpl(j) < rect.getLeft() ? rect.getLeft() : Offset.m2556getXimpl(j) > rect.getRight() ? rect.getRight() : Offset.m2556getXimpl(j), Offset.m2557getYimpl(j) < rect.getTop() ? rect.getTop() : Offset.m2557getYimpl(j) > rect.getBottom() ? rect.getBottom() : Offset.m2557getYimpl(j));
    }
}
