package androidx.compose.foundation.gestures;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class DragGestureDetectorKt$HorizontalPointerDirectionConfig$1 implements PointerDirectionConfig {
    DragGestureDetectorKt$HorizontalPointerDirectionConfig$1() {
    }

    /* renamed from: crossAxisDelta-k-4lQ0M, reason: not valid java name */
    public float m166crossAxisDeltak4lQ0M(long j) {
        return Offset.m849getYimpl(j);
    }

    /* renamed from: mainAxisDelta-k-4lQ0M, reason: not valid java name */
    public float m167mainAxisDeltak4lQ0M(long j) {
        return Offset.m848getXimpl(j);
    }

    /* renamed from: offsetFromChanges-dBAh8RU, reason: not valid java name */
    public long m168offsetFromChangesdBAh8RU(float f, float f2) {
        return OffsetKt.Offset(f, f2);
    }
}
