package androidx.compose.p004ui.input.pointer.util;

import androidx.compose.p004ui.geometry.Offset;
import androidx.compose.p004ui.unit.VelocityKt;
import androidx.compose.runtime.internal.StabilityInferred;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@StabilityInferred(parameters = 0)
/* loaded from: classes.dex */
public final class VelocityTracker {
    public static final int $stable = 8;

    @NotNull
    private final VelocityTracker1D xVelocityTracker = new VelocityTracker1D(false, null, 3, null);

    @NotNull
    private final VelocityTracker1D yVelocityTracker = new VelocityTracker1D(false, null, 3, null);
    private long currentPointerPositionAccumulator = Offset.Companion.m2572getZeroF1C5BW0();

    /* renamed from: addPosition-Uv8p0NA, reason: not valid java name */
    public final void m4159addPositionUv8p0NA(long j, long j2) {
        this.xVelocityTracker.addDataPoint(j, Offset.m2556getXimpl(j2));
        this.yVelocityTracker.addDataPoint(j, Offset.m2557getYimpl(j2));
    }

    /* renamed from: calculateVelocity-9UxMQ8M, reason: not valid java name */
    public final long m4160calculateVelocity9UxMQ8M() {
        return VelocityKt.Velocity(this.xVelocityTracker.calculateVelocity(), this.yVelocityTracker.calculateVelocity());
    }

    /* renamed from: getCurrentPointerPositionAccumulator-F1C5BW0$ui_release, reason: not valid java name */
    public final long m4161getCurrentPointerPositionAccumulatorF1C5BW0$ui_release() {
        return this.currentPointerPositionAccumulator;
    }

    public final void resetTracking() {
        this.xVelocityTracker.resetTracking();
        this.yVelocityTracker.resetTracking();
    }

    /* renamed from: setCurrentPointerPositionAccumulator-k-4lQ0M$ui_release, reason: not valid java name */
    public final void m4162setCurrentPointerPositionAccumulatork4lQ0M$ui_release(long j) {
        this.currentPointerPositionAccumulator = j;
    }
}
