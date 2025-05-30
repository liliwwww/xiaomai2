package androidx.compose.p004ui.input.pointer.util;

import androidx.compose.p004ui.geometry.Offset;
import androidx.compose.p004ui.input.pointer.HistoricalChange;
import androidx.compose.p004ui.input.pointer.PointerEventKt;
import androidx.compose.p004ui.input.pointer.PointerInputChange;
import androidx.core.app.NotificationCompat;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public final class VelocityTrackerKt {
    private static final int AssumePointerMoveStoppedMilliseconds = 40;
    private static final float DefaultWeight = 1.0f;
    private static final int HistorySize = 20;
    private static final int HorizonMilliseconds = 100;

    public static final void addPointerInputChange(@NotNull VelocityTracker velocityTracker, @NotNull PointerInputChange pointerInputChange) {
        Intrinsics.checkNotNullParameter(velocityTracker, "<this>");
        Intrinsics.checkNotNullParameter(pointerInputChange, NotificationCompat.CATEGORY_EVENT);
        if (PointerEventKt.changedToDownIgnoreConsumed(pointerInputChange)) {
            velocityTracker.m4162setCurrentPointerPositionAccumulatork4lQ0M$ui_release(pointerInputChange.m4081getPositionF1C5BW0());
            velocityTracker.resetTracking();
        }
        long m4082getPreviousPositionF1C5BW0 = pointerInputChange.m4082getPreviousPositionF1C5BW0();
        List<HistoricalChange> historical = pointerInputChange.getHistorical();
        int i = 0;
        int size = historical.size();
        while (i < size) {
            HistoricalChange historicalChange = historical.get(i);
            long m2560minusMKHz9U = Offset.m2560minusMKHz9U(historicalChange.m4011getPositionF1C5BW0(), m4082getPreviousPositionF1C5BW0);
            long m4011getPositionF1C5BW0 = historicalChange.m4011getPositionF1C5BW0();
            velocityTracker.m4162setCurrentPointerPositionAccumulatork4lQ0M$ui_release(Offset.m2561plusMKHz9U(velocityTracker.m4161getCurrentPointerPositionAccumulatorF1C5BW0$ui_release(), m2560minusMKHz9U));
            velocityTracker.m4159addPositionUv8p0NA(historicalChange.getUptimeMillis(), velocityTracker.m4161getCurrentPointerPositionAccumulatorF1C5BW0$ui_release());
            i++;
            m4082getPreviousPositionF1C5BW0 = m4011getPositionF1C5BW0;
        }
        velocityTracker.m4162setCurrentPointerPositionAccumulatork4lQ0M$ui_release(Offset.m2561plusMKHz9U(velocityTracker.m4161getCurrentPointerPositionAccumulatorF1C5BW0$ui_release(), Offset.m2560minusMKHz9U(pointerInputChange.m4081getPositionF1C5BW0(), m4082getPreviousPositionF1C5BW0)));
        velocityTracker.m4159addPositionUv8p0NA(pointerInputChange.getUptimeMillis(), velocityTracker.m4161getCurrentPointerPositionAccumulatorF1C5BW0$ui_release());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float calculateImpulseVelocity(List<Float> list, List<Float> list2, boolean z) {
        int size = list.size();
        float f = 0.0f;
        if (size < 2) {
            return 0.0f;
        }
        if (size == 2) {
            if (list2.get(0).floatValue() == list2.get(1).floatValue()) {
                return 0.0f;
            }
            return (z ? list.get(0).floatValue() : list.get(0).floatValue() - list.get(1).floatValue()) / (list2.get(0).floatValue() - list2.get(1).floatValue());
        }
        int i = size - 1;
        for (int i2 = i; i2 > 0; i2--) {
            int i3 = i2 - 1;
            if (!(list2.get(i2).floatValue() == list2.get(i3).floatValue())) {
                float kineticEnergyToVelocity = kineticEnergyToVelocity(f);
                float floatValue = (z ? -list.get(i3).floatValue() : list.get(i2).floatValue() - list.get(i3).floatValue()) / (list2.get(i2).floatValue() - list2.get(i3).floatValue());
                f += (floatValue - kineticEnergyToVelocity) * Math.abs(floatValue);
                if (i2 == i) {
                    f *= 0.5f;
                }
            }
        }
        return kineticEnergyToVelocity(f);
    }

    private static final float kineticEnergyToVelocity(float f) {
        return Math.signum(f) * ((float) Math.sqrt(2 * Math.abs(f)));
    }

    @NotNull
    public static final List<Float> polyFitLeastSquares(@NotNull List<Float> list, @NotNull List<Float> list2, int i) {
        Intrinsics.checkNotNullParameter(list, "x");
        Intrinsics.checkNotNullParameter(list2, "y");
        if (i < 1) {
            throw new IllegalArgumentException("The degree must be at positive integer");
        }
        if (list.size() != list2.size()) {
            throw new IllegalArgumentException("x and y must be the same length");
        }
        if (list.isEmpty()) {
            throw new IllegalArgumentException("At least one point must be provided");
        }
        int size = i >= list.size() ? list.size() - 1 : i;
        int i2 = i + 1;
        ArrayList arrayList = new ArrayList(i2);
        for (int i3 = 0; i3 < i2; i3++) {
            arrayList.add(Float.valueOf(0.0f));
        }
        int size2 = list.size();
        int i4 = size + 1;
        Matrix matrix = new Matrix(i4, size2);
        for (int i5 = 0; i5 < size2; i5++) {
            matrix.set(0, i5, 1.0f);
            for (int i6 = 1; i6 < i4; i6++) {
                matrix.set(i6, i5, matrix.get(i6 - 1, i5) * list.get(i5).floatValue());
            }
        }
        Matrix matrix2 = new Matrix(i4, size2);
        Matrix matrix3 = new Matrix(i4, i4);
        int i7 = 0;
        while (i7 < i4) {
            for (int i8 = 0; i8 < size2; i8++) {
                matrix2.set(i7, i8, matrix.get(i7, i8));
            }
            for (int i9 = 0; i9 < i7; i9++) {
                float times = matrix2.getRow(i7).times(matrix2.getRow(i9));
                for (int i10 = 0; i10 < size2; i10++) {
                    matrix2.set(i7, i10, matrix2.get(i7, i10) - (matrix2.get(i9, i10) * times));
                }
            }
            float norm = matrix2.getRow(i7).norm();
            if (norm < 1.0E-6d) {
                throw new IllegalArgumentException("Vectors are linearly dependent or zero so no solution. TODO(shepshapard), actually determine what this means");
            }
            float f = 1.0f / norm;
            for (int i11 = 0; i11 < size2; i11++) {
                matrix2.set(i7, i11, matrix2.get(i7, i11) * f);
            }
            int i12 = 0;
            while (i12 < i4) {
                matrix3.set(i7, i12, i12 < i7 ? 0.0f : matrix2.getRow(i7).times(matrix.getRow(i12)));
                i12++;
            }
            i7++;
        }
        Vector vector = new Vector(size2);
        for (int i13 = 0; i13 < size2; i13++) {
            vector.set(i13, list2.get(i13).floatValue() * 1.0f);
        }
        int i14 = i4 - 1;
        for (int i15 = i14; -1 < i15; i15--) {
            arrayList.set(i15, Float.valueOf(matrix2.getRow(i15).times(vector)));
            int i16 = i15 + 1;
            if (i16 <= i14) {
                int i17 = i14;
                while (true) {
                    arrayList.set(i15, Float.valueOf(((Number) arrayList.get(i15)).floatValue() - (matrix3.get(i15, i17) * ((Number) arrayList.get(i17)).floatValue())));
                    if (i17 != i16) {
                        i17--;
                    }
                }
            }
            arrayList.set(i15, Float.valueOf(((Number) arrayList.get(i15)).floatValue() / matrix3.get(i15, i15)));
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void set(DataPointAtTime[] dataPointAtTimeArr, int i, long j, float f) {
        DataPointAtTime dataPointAtTime = dataPointAtTimeArr[i];
        if (dataPointAtTime == null) {
            dataPointAtTimeArr[i] = new DataPointAtTime(j, f);
        } else {
            dataPointAtTime.setTime(j);
            dataPointAtTime.setDataPoint(f);
        }
    }
}
