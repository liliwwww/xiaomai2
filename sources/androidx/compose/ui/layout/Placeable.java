package androidx.compose.ui.layout;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.Nullable;
import tb.pn2;

/* compiled from: Taobao */
@StabilityInferred(parameters = 0)
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public abstract class Placeable implements Measured {
    public static final int $stable = 8;
    private int height;
    private long measuredSize = IntSizeKt.IntSize(0, 0);
    private long measurementConstraints;
    private int width;

    public Placeable() {
        long j;
        j = PlaceableKt.DefaultConstraints;
        this.measurementConstraints = j;
    }

    private final void recalculateWidthAndHeight() {
        this.width = RangesKt.coerceIn(IntSize.getWidth-impl(this.measuredSize), Constraints.m2124getMinWidthimpl(this.measurementConstraints), Constraints.m2122getMaxWidthimpl(this.measurementConstraints));
        this.height = RangesKt.coerceIn(IntSize.getHeight-impl(this.measuredSize), Constraints.m2123getMinHeightimpl(this.measurementConstraints), Constraints.m2121getMaxHeightimpl(this.measurementConstraints));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: getApparentToRealOffset-nOcc-ac, reason: not valid java name */
    public final long m1563getApparentToRealOffsetnOccac() {
        return IntOffsetKt.IntOffset((this.width - IntSize.getWidth-impl(this.measuredSize)) / 2, (this.height - IntSize.getHeight-impl(this.measuredSize)) / 2);
    }

    public final int getHeight() {
        return this.height;
    }

    public int getMeasuredHeight() {
        return IntSize.getHeight-impl(this.measuredSize);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: getMeasuredSize-YbymL2g, reason: not valid java name */
    public final long m1564getMeasuredSizeYbymL2g() {
        return this.measuredSize;
    }

    public int getMeasuredWidth() {
        return IntSize.getWidth-impl(this.measuredSize);
    }

    /* renamed from: getMeasurementConstraints-msEJaDk, reason: not valid java name */
    protected final long m1565getMeasurementConstraintsmsEJaDk() {
        return this.measurementConstraints;
    }

    public /* synthetic */ Object getParentData() {
        return pn2.a(this);
    }

    public final int getWidth() {
        return this.width;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: placeAt-f8xVGno */
    public abstract void mo1558placeAtf8xVGno(long j, float f, @Nullable Function1<? super GraphicsLayerScope, Unit> function1);

    /* renamed from: setMeasuredSize-ozmzZPI, reason: not valid java name */
    protected final void m1566setMeasuredSizeozmzZPI(long j) {
        if (IntSize.equals-impl0(this.measuredSize, j)) {
            return;
        }
        this.measuredSize = j;
        recalculateWidthAndHeight();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: setMeasurementConstraints-BRTryo0, reason: not valid java name */
    public final void m1567setMeasurementConstraintsBRTryo0(long j) {
        if (Constraints.m2115equalsimpl0(this.measurementConstraints, j)) {
            return;
        }
        this.measurementConstraints = j;
        recalculateWidthAndHeight();
    }
}
