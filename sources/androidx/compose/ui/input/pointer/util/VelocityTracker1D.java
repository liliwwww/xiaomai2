package androidx.compose.ui.input.pointer.util;

import java.util.ArrayList;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class VelocityTracker1D {
    private final boolean differentialDataPoints;
    private int index;
    private final int minSampleSize;

    @NotNull
    private final DataPointAtTime[] samples;

    @NotNull
    private final Strategy strategy;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public VelocityTracker1D() {
        /*
            r3 = this;
            r0 = 0
            r1 = 0
            r2 = 3
            r3.<init>(r0, r1, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.input.pointer.util.VelocityTracker1D.<init>():void");
    }

    public VelocityTracker1D(boolean z, @NotNull Strategy strategy) {
        Intrinsics.checkNotNullParameter(strategy, "strategy");
        this.differentialDataPoints = z;
        this.strategy = strategy;
        if (z && strategy.equals(Strategy.Lsq2)) {
            throw new IllegalStateException("Lsq2 not (yet) supported for differential axes");
        }
        int i = WhenMappings.$EnumSwitchMapping$0[strategy.ordinal()];
        int i2 = 2;
        if (i != 1) {
            if (i != 2) {
                throw new NoWhenBranchMatchedException();
            }
            i2 = 3;
        }
        this.minSampleSize = i2;
        DataPointAtTime[] dataPointAtTimeArr = new DataPointAtTime[20];
        for (int i3 = 0; i3 < 20; i3++) {
            dataPointAtTimeArr[i3] = null;
        }
        this.samples = dataPointAtTimeArr;
    }

    private final float calculateLeastSquaresVelocity(List<Float> list, List<Float> list2) {
        try {
            return ((Number) VelocityTrackerKt.polyFitLeastSquares(list2, list, 2).get(1)).floatValue();
        } catch (IllegalArgumentException unused) {
            return 0.0f;
        }
    }

    public final void addDataPoint(long j, float f) {
        int i = (this.index + 1) % 20;
        this.index = i;
        VelocityTrackerKt.access$set(this.samples, i, j, f);
    }

    public final float calculateVelocity() {
        float access$calculateImpulseVelocity;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        int i = this.index;
        DataPointAtTime dataPointAtTime = this.samples[i];
        if (dataPointAtTime == null) {
            return 0.0f;
        }
        int i2 = 0;
        DataPointAtTime dataPointAtTime2 = dataPointAtTime;
        while (true) {
            DataPointAtTime dataPointAtTime3 = this.samples[i];
            if (dataPointAtTime3 != null) {
                float time = dataPointAtTime.getTime() - dataPointAtTime3.getTime();
                float abs = Math.abs(dataPointAtTime3.getTime() - dataPointAtTime2.getTime());
                if (time > 100.0f || abs > 40.0f) {
                    break;
                }
                arrayList.add(Float.valueOf(dataPointAtTime3.getDataPoint()));
                arrayList2.add(Float.valueOf(-time));
                if (i == 0) {
                    i = 20;
                }
                i--;
                i2++;
                if (i2 >= 20) {
                    break;
                }
                dataPointAtTime2 = dataPointAtTime3;
            } else {
                break;
            }
        }
        if (i2 < this.minSampleSize) {
            return 0.0f;
        }
        int i3 = WhenMappings.$EnumSwitchMapping$0[this.strategy.ordinal()];
        if (i3 == 1) {
            access$calculateImpulseVelocity = VelocityTrackerKt.access$calculateImpulseVelocity(arrayList, arrayList2, this.differentialDataPoints);
        } else {
            if (i3 != 2) {
                throw new NoWhenBranchMatchedException();
            }
            access$calculateImpulseVelocity = calculateLeastSquaresVelocity(arrayList, arrayList2);
        }
        return access$calculateImpulseVelocity * 1000;
    }

    public final void resetTracking() {
        ArraysKt.fill$default(this.samples, (Object) null, 0, 0, 6, (Object) null);
        this.index = 0;
    }
}
