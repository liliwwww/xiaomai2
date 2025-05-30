package androidx.compose.ui.input.pointer.util;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.unit.VelocityKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@StabilityInferred(parameters = 0)
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class VelocityTracker {
    public static final int $stable = 8;

    @NotNull
    private final VelocityTracker1D xVelocityTracker = new VelocityTracker1D(false, (VelocityTracker1D$Strategy) null, 3, (DefaultConstructorMarker) null);

    @NotNull
    private final VelocityTracker1D yVelocityTracker = new VelocityTracker1D(false, (VelocityTracker1D$Strategy) null, 3, (DefaultConstructorMarker) null);
    private long currentPointerPositionAccumulator = Offset.Companion.getZero-F1C5BW0();

    /* renamed from: addPosition-Uv8p0NA, reason: not valid java name */
    public final void m1500addPositionUv8p0NA(long j, long j2) {
        this.xVelocityTracker.addDataPoint(j, Offset.m848getXimpl(j2));
        this.yVelocityTracker.addDataPoint(j, Offset.m849getYimpl(j2));
    }

    /* renamed from: calculateVelocity-9UxMQ8M, reason: not valid java name */
    public final long m1501calculateVelocity9UxMQ8M() {
        return VelocityKt.Velocity(this.xVelocityTracker.calculateVelocity(), this.yVelocityTracker.calculateVelocity());
    }

    /* renamed from: getCurrentPointerPositionAccumulator-F1C5BW0$ui_release, reason: not valid java name */
    public final long m1502getCurrentPointerPositionAccumulatorF1C5BW0$ui_release() {
        return this.currentPointerPositionAccumulator;
    }

    public final void resetTracking() {
        this.xVelocityTracker.resetTracking();
        this.yVelocityTracker.resetTracking();
    }

    /* renamed from: setCurrentPointerPositionAccumulator-k-4lQ0M$ui_release, reason: not valid java name */
    public final void m1503setCurrentPointerPositionAccumulatork4lQ0M$ui_release(long j) {
        this.currentPointerPositionAccumulator = j;
    }
}
