package androidx.compose.foundation.gestures;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.PointerInputScope;
import java.util.List;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class TransformGestureDetectorKt {
    /* renamed from: angle-k-4lQ0M, reason: not valid java name */
    private static final float m180anglek4lQ0M(long j) {
        if (Offset.m848getXimpl(j) == 0.0f) {
            if (Offset.m849getYimpl(j) == 0.0f) {
                return 0.0f;
            }
        }
        return ((-((float) Math.atan2(Offset.m848getXimpl(j), Offset.m849getYimpl(j)))) * 180.0f) / 3.1415927f;
    }

    public static final long calculateCentroid(@NotNull PointerEvent pointerEvent, boolean z) {
        Intrinsics.checkNotNullParameter(pointerEvent, "<this>");
        long j = Offset.Companion.getZero-F1C5BW0();
        List changes = pointerEvent.getChanges();
        int size = changes.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            PointerInputChange pointerInputChange = (PointerInputChange) changes.get(i2);
            if (pointerInputChange.getPressed() && pointerInputChange.getPreviousPressed()) {
                j = Offset.m853plusMKHz9U(j, z ? pointerInputChange.m1465getPositionF1C5BW0() : pointerInputChange.m1466getPreviousPositionF1C5BW0());
                i++;
            }
        }
        return i == 0 ? Offset.Companion.getUnspecified-F1C5BW0() : Offset.m843divtuRUvjQ(j, i);
    }

    public static /* synthetic */ long calculateCentroid$default(PointerEvent pointerEvent, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        return calculateCentroid(pointerEvent, z);
    }

    public static final float calculateCentroidSize(@NotNull PointerEvent pointerEvent, boolean z) {
        Intrinsics.checkNotNullParameter(pointerEvent, "<this>");
        long calculateCentroid = calculateCentroid(pointerEvent, z);
        float f = 0.0f;
        if (Offset.m845equalsimpl0(calculateCentroid, Offset.Companion.getUnspecified-F1C5BW0())) {
            return 0.0f;
        }
        List changes = pointerEvent.getChanges();
        int size = changes.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            PointerInputChange pointerInputChange = (PointerInputChange) changes.get(i2);
            if (pointerInputChange.getPressed() && pointerInputChange.getPreviousPressed()) {
                f += Offset.m846getDistanceimpl(Offset.m852minusMKHz9U(z ? pointerInputChange.m1465getPositionF1C5BW0() : pointerInputChange.m1466getPreviousPositionF1C5BW0(), calculateCentroid));
                i++;
            }
        }
        return f / i;
    }

    public static /* synthetic */ float calculateCentroidSize$default(PointerEvent pointerEvent, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        return calculateCentroidSize(pointerEvent, z);
    }

    public static final long calculatePan(@NotNull PointerEvent pointerEvent) {
        Intrinsics.checkNotNullParameter(pointerEvent, "<this>");
        long calculateCentroid = calculateCentroid(pointerEvent, true);
        Offset.Companion companion = Offset.Companion;
        return Offset.m845equalsimpl0(calculateCentroid, companion.getUnspecified-F1C5BW0()) ? companion.getZero-F1C5BW0() : Offset.m852minusMKHz9U(calculateCentroid, calculateCentroid(pointerEvent, false));
    }

    public static final float calculateRotation(@NotNull PointerEvent pointerEvent) {
        Intrinsics.checkNotNullParameter(pointerEvent, "<this>");
        List changes = pointerEvent.getChanges();
        int size = changes.size();
        int i = 0;
        int i2 = 0;
        while (true) {
            int i3 = 1;
            if (i >= size) {
                break;
            }
            PointerInputChange pointerInputChange = (PointerInputChange) changes.get(i);
            if (!pointerInputChange.getPreviousPressed() || !pointerInputChange.getPressed()) {
                i3 = 0;
            }
            i2 += i3;
            i++;
        }
        float f = 0.0f;
        if (i2 < 2) {
            return 0.0f;
        }
        long calculateCentroid = calculateCentroid(pointerEvent, true);
        long calculateCentroid2 = calculateCentroid(pointerEvent, false);
        List changes2 = pointerEvent.getChanges();
        int size2 = changes2.size();
        int i4 = 0;
        float f2 = 0.0f;
        float f3 = 0.0f;
        while (i4 < size2) {
            PointerInputChange pointerInputChange2 = (PointerInputChange) changes2.get(i4);
            if (pointerInputChange2.getPressed() && pointerInputChange2.getPreviousPressed()) {
                long m1465getPositionF1C5BW0 = pointerInputChange2.m1465getPositionF1C5BW0();
                long m852minusMKHz9U = Offset.m852minusMKHz9U(pointerInputChange2.m1466getPreviousPositionF1C5BW0(), calculateCentroid2);
                long m852minusMKHz9U2 = Offset.m852minusMKHz9U(m1465getPositionF1C5BW0, calculateCentroid);
                float m180anglek4lQ0M = m180anglek4lQ0M(m852minusMKHz9U2) - m180anglek4lQ0M(m852minusMKHz9U);
                float m846getDistanceimpl = Offset.m846getDistanceimpl(Offset.m853plusMKHz9U(m852minusMKHz9U2, m852minusMKHz9U)) / 2.0f;
                if (m180anglek4lQ0M > 180.0f) {
                    m180anglek4lQ0M -= 360.0f;
                } else if (m180anglek4lQ0M < -180.0f) {
                    m180anglek4lQ0M += 360.0f;
                }
                f3 += m180anglek4lQ0M * m846getDistanceimpl;
                f2 += m846getDistanceimpl;
            }
            i4++;
            f = 0.0f;
        }
        return (f2 > f ? 1 : (f2 == f ? 0 : -1)) == 0 ? f : f3 / f2;
    }

    public static final float calculateZoom(@NotNull PointerEvent pointerEvent) {
        Intrinsics.checkNotNullParameter(pointerEvent, "<this>");
        float calculateCentroidSize = calculateCentroidSize(pointerEvent, true);
        float calculateCentroidSize2 = calculateCentroidSize(pointerEvent, false);
        if (calculateCentroidSize == 0.0f) {
            return 1.0f;
        }
        if (calculateCentroidSize2 == 0.0f) {
            return 1.0f;
        }
        return calculateCentroidSize / calculateCentroidSize2;
    }

    @Nullable
    public static final Object detectTransformGestures(@NotNull PointerInputScope pointerInputScope, boolean z, @NotNull Function4<? super Offset, ? super Offset, ? super Float, ? super Float, Unit> function4, @NotNull Continuation<? super Unit> continuation) {
        Object awaitEachGesture = ForEachGestureKt.awaitEachGesture(pointerInputScope, new TransformGestureDetectorKt$detectTransformGestures$2(z, function4, null), continuation);
        return awaitEachGesture == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? awaitEachGesture : Unit.INSTANCE;
    }

    public static /* synthetic */ Object detectTransformGestures$default(PointerInputScope pointerInputScope, boolean z, Function4 function4, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        return detectTransformGestures(pointerInputScope, z, function4, continuation);
    }
}
