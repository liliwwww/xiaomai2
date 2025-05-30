package androidx.compose.foundation.layout;

import androidx.compose.p004ui.layout.Measurable;
import androidx.compose.p004ui.layout.MeasureScope;
import androidx.compose.p004ui.layout.Placeable;
import androidx.compose.p004ui.unit.Density;
import androidx.compose.p004ui.unit.LayoutDirection;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.IntIterator;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public final class RowColumnMeasurementHelper {

    @NotNull
    private final Function5<Integer, int[], LayoutDirection, Density, int[], Unit> arrangement;
    private final float arrangementSpacing;

    @NotNull
    private final CrossAxisAlignment crossAxisAlignment;

    @NotNull
    private final SizeMode crossAxisSize;

    @NotNull
    private final List<Measurable> measurables;

    @NotNull
    private final LayoutOrientation orientation;

    @NotNull
    private final Placeable[] placeables;

    @NotNull
    private final RowColumnParentData[] rowColumnParentData;

    /* JADX WARN: Multi-variable type inference failed */
    private RowColumnMeasurementHelper(LayoutOrientation layoutOrientation, Function5<? super Integer, ? super int[], ? super LayoutDirection, ? super Density, ? super int[], Unit> function5, float f, SizeMode sizeMode, CrossAxisAlignment crossAxisAlignment, List<? extends Measurable> list, Placeable[] placeableArr) {
        this.orientation = layoutOrientation;
        this.arrangement = function5;
        this.arrangementSpacing = f;
        this.crossAxisSize = sizeMode;
        this.crossAxisAlignment = crossAxisAlignment;
        this.measurables = list;
        this.placeables = placeableArr;
        int size = list.size();
        RowColumnParentData[] rowColumnParentDataArr = new RowColumnParentData[size];
        for (int i = 0; i < size; i++) {
            rowColumnParentDataArr[i] = RowColumnImplKt.getRowColumnParentData(this.measurables.get(i));
        }
        this.rowColumnParentData = rowColumnParentDataArr;
    }

    public /* synthetic */ RowColumnMeasurementHelper(LayoutOrientation layoutOrientation, Function5 function5, float f, SizeMode sizeMode, CrossAxisAlignment crossAxisAlignment, List list, Placeable[] placeableArr, DefaultConstructorMarker defaultConstructorMarker) {
        this(layoutOrientation, function5, f, sizeMode, crossAxisAlignment, list, placeableArr);
    }

    private final int getCrossAxisPosition(Placeable placeable, RowColumnParentData rowColumnParentData, int i, LayoutDirection layoutDirection, int i2) {
        CrossAxisAlignment crossAxisAlignment;
        if (rowColumnParentData == null || (crossAxisAlignment = rowColumnParentData.getCrossAxisAlignment()) == null) {
            crossAxisAlignment = this.crossAxisAlignment;
        }
        int crossAxisSize = i - crossAxisSize(placeable);
        if (this.orientation == LayoutOrientation.Horizontal) {
            layoutDirection = LayoutDirection.Ltr;
        }
        return crossAxisAlignment.align$foundation_layout_release(crossAxisSize, layoutDirection, placeable, i2);
    }

    private final int[] mainAxisPositions(int i, int[] iArr, int[] iArr2, MeasureScope measureScope) {
        this.arrangement.invoke(Integer.valueOf(i), iArr, measureScope.getLayoutDirection(), measureScope, iArr2);
        return iArr2;
    }

    public final int crossAxisSize(@NotNull Placeable placeable) {
        Intrinsics.checkNotNullParameter(placeable, "<this>");
        return this.orientation == LayoutOrientation.Horizontal ? placeable.getHeight() : placeable.getWidth();
    }

    @NotNull
    public final Function5<Integer, int[], LayoutDirection, Density, int[], Unit> getArrangement() {
        return this.arrangement;
    }

    /* renamed from: getArrangementSpacing-D9Ej5fM, reason: not valid java name */
    public final float m1416getArrangementSpacingD9Ej5fM() {
        return this.arrangementSpacing;
    }

    @NotNull
    public final CrossAxisAlignment getCrossAxisAlignment() {
        return this.crossAxisAlignment;
    }

    @NotNull
    public final SizeMode getCrossAxisSize() {
        return this.crossAxisSize;
    }

    @NotNull
    public final List<Measurable> getMeasurables() {
        return this.measurables;
    }

    @NotNull
    public final LayoutOrientation getOrientation() {
        return this.orientation;
    }

    @NotNull
    public final Placeable[] getPlaceables() {
        return this.placeables;
    }

    public final int mainAxisSize(@NotNull Placeable placeable) {
        Intrinsics.checkNotNullParameter(placeable, "<this>");
        return this.orientation == LayoutOrientation.Horizontal ? placeable.getWidth() : placeable.getHeight();
    }

    @NotNull
    /* renamed from: measureWithoutPlacing-_EkL_-Y, reason: not valid java name */
    public final RowColumnMeasureHelperResult m1417measureWithoutPlacing_EkL_Y(@NotNull MeasureScope measureScope, long j, int i, int i2) {
        int i3;
        int coerceAtMost;
        float f;
        float f2;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        Intrinsics.checkNotNullParameter(measureScope, "measureScope");
        OrientationIndependentConstraints orientationIndependentConstraints = new OrientationIndependentConstraints(j, this.orientation, null);
        int mo1277roundToPx0680j_4 = measureScope.mo1277roundToPx0680j_4(this.arrangementSpacing);
        int i11 = i2 - i;
        int i12 = i;
        int i13 = 0;
        int i14 = 0;
        int i15 = 0;
        float f3 = 0.0f;
        int i16 = 0;
        boolean z = false;
        while (i12 < i2) {
            Measurable measurable = this.measurables.get(i12);
            RowColumnParentData rowColumnParentData = this.rowColumnParentData[i12];
            float weight = RowColumnImplKt.getWeight(rowColumnParentData);
            if (weight > 0.0f) {
                f3 += weight;
                i15++;
                i10 = i12;
            } else {
                int mainAxisMax = orientationIndependentConstraints.getMainAxisMax();
                Placeable placeable = this.placeables[i12];
                if (placeable == null) {
                    i8 = mainAxisMax;
                    i9 = i14;
                    i10 = i12;
                    placeable = measurable.mo4187measureBRTryo0(OrientationIndependentConstraints.copy$default(orientationIndependentConstraints, 0, mainAxisMax == Integer.MAX_VALUE ? Integer.MAX_VALUE : mainAxisMax - i16, 0, 0, 8, null).m1386toBoxConstraintsOenEA2s(this.orientation));
                } else {
                    i8 = mainAxisMax;
                    i9 = i14;
                    i10 = i12;
                }
                int min = Math.min(mo1277roundToPx0680j_4, (i8 - i16) - mainAxisSize(placeable));
                i16 += mainAxisSize(placeable) + min;
                i14 = Math.max(i9, crossAxisSize(placeable));
                z = z || RowColumnImplKt.isRelative(rowColumnParentData);
                this.placeables[i10] = placeable;
                i13 = min;
            }
            i12 = i10 + 1;
        }
        int i17 = i14;
        if (i15 == 0) {
            i16 -= i13;
            i3 = i17;
            coerceAtMost = 0;
        } else {
            int i18 = mo1277roundToPx0680j_4 * (i15 - 1);
            int mainAxisMin = (((f3 <= 0.0f || orientationIndependentConstraints.getMainAxisMax() == Integer.MAX_VALUE) ? orientationIndependentConstraints.getMainAxisMin() : orientationIndependentConstraints.getMainAxisMax()) - i16) - i18;
            float f4 = 0;
            float f5 = f3 > f4 ? mainAxisMin / f3 : 0.0f;
            IntIterator it = RangesKt.until(i, i2).iterator();
            int i19 = 0;
            while (it.hasNext()) {
                i19 += MathKt.roundToInt(RowColumnImplKt.getWeight(this.rowColumnParentData[it.nextInt()]) * f5);
            }
            int i20 = mainAxisMin - i19;
            int i21 = i;
            i3 = i17;
            int i22 = 0;
            while (i21 < i2) {
                if (this.placeables[i21] == null) {
                    Measurable measurable2 = this.measurables.get(i21);
                    RowColumnParentData rowColumnParentData2 = this.rowColumnParentData[i21];
                    float weight2 = RowColumnImplKt.getWeight(rowColumnParentData2);
                    if (!(weight2 > f4)) {
                        throw new IllegalStateException("All weights <= 0 should have placeables".toString());
                    }
                    int sign = MathKt.getSign(i20);
                    int i23 = i20 - sign;
                    int max = Math.max(0, MathKt.roundToInt(weight2 * f5) + sign);
                    if (RowColumnImplKt.getFill(rowColumnParentData2)) {
                        i4 = i23;
                        if (max != Integer.MAX_VALUE) {
                            f = f4;
                            i5 = max;
                            f2 = f5;
                            Placeable mo4187measureBRTryo0 = measurable2.mo4187measureBRTryo0(new OrientationIndependentConstraints(i5, max, 0, orientationIndependentConstraints.getCrossAxisMax()).m1386toBoxConstraintsOenEA2s(this.orientation));
                            i22 += mainAxisSize(mo4187measureBRTryo0);
                            i3 = Math.max(i3, crossAxisSize(mo4187measureBRTryo0));
                            boolean z2 = !z || RowColumnImplKt.isRelative(rowColumnParentData2);
                            this.placeables[i21] = mo4187measureBRTryo0;
                            z = z2;
                            i20 = i4;
                        }
                    } else {
                        i4 = i23;
                    }
                    f = f4;
                    i5 = 0;
                    f2 = f5;
                    Placeable mo4187measureBRTryo02 = measurable2.mo4187measureBRTryo0(new OrientationIndependentConstraints(i5, max, 0, orientationIndependentConstraints.getCrossAxisMax()).m1386toBoxConstraintsOenEA2s(this.orientation));
                    i22 += mainAxisSize(mo4187measureBRTryo02);
                    i3 = Math.max(i3, crossAxisSize(mo4187measureBRTryo02));
                    if (z) {
                    }
                    this.placeables[i21] = mo4187measureBRTryo02;
                    z = z2;
                    i20 = i4;
                } else {
                    f = f4;
                    f2 = f5;
                }
                i21++;
                f4 = f;
                f5 = f2;
            }
            coerceAtMost = RangesKt.coerceAtMost(i22 + i18, orientationIndependentConstraints.getMainAxisMax() - i16);
        }
        if (z) {
            int i24 = 0;
            i6 = 0;
            for (int i25 = i; i25 < i2; i25++) {
                Placeable placeable2 = this.placeables[i25];
                Intrinsics.checkNotNull(placeable2);
                CrossAxisAlignment crossAxisAlignment = RowColumnImplKt.getCrossAxisAlignment(this.rowColumnParentData[i25]);
                Integer calculateAlignmentLinePosition$foundation_layout_release = crossAxisAlignment != null ? crossAxisAlignment.calculateAlignmentLinePosition$foundation_layout_release(placeable2) : null;
                if (calculateAlignmentLinePosition$foundation_layout_release != null) {
                    int intValue = calculateAlignmentLinePosition$foundation_layout_release.intValue();
                    if (intValue == Integer.MIN_VALUE) {
                        intValue = 0;
                    }
                    i24 = Math.max(i24, intValue);
                    int crossAxisSize = crossAxisSize(placeable2);
                    int intValue2 = calculateAlignmentLinePosition$foundation_layout_release.intValue();
                    if (intValue2 == Integer.MIN_VALUE) {
                        intValue2 = crossAxisSize(placeable2);
                    }
                    i6 = Math.max(i6, crossAxisSize - intValue2);
                }
            }
            i7 = i24;
        } else {
            i6 = 0;
            i7 = 0;
        }
        int max2 = Math.max(i16 + coerceAtMost, orientationIndependentConstraints.getMainAxisMin());
        int max3 = (orientationIndependentConstraints.getCrossAxisMax() == Integer.MAX_VALUE || this.crossAxisSize != SizeMode.Expand) ? Math.max(i3, Math.max(orientationIndependentConstraints.getCrossAxisMin(), i6 + i7)) : orientationIndependentConstraints.getCrossAxisMax();
        int[] iArr = new int[i11];
        for (int i26 = 0; i26 < i11; i26++) {
            iArr[i26] = 0;
        }
        int[] iArr2 = new int[i11];
        for (int i27 = 0; i27 < i11; i27++) {
            Placeable placeable3 = this.placeables[i27 + i];
            Intrinsics.checkNotNull(placeable3);
            iArr2[i27] = mainAxisSize(placeable3);
        }
        return new RowColumnMeasureHelperResult(max3, max2, i, i2, i7, mainAxisPositions(max2, iArr2, iArr, measureScope));
    }

    public final void placeHelper(@NotNull Placeable.PlacementScope placementScope, @NotNull RowColumnMeasureHelperResult rowColumnMeasureHelperResult, int i, @NotNull LayoutDirection layoutDirection) {
        Intrinsics.checkNotNullParameter(placementScope, "placeableScope");
        Intrinsics.checkNotNullParameter(rowColumnMeasureHelperResult, "measureResult");
        Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
        int endIndex = rowColumnMeasureHelperResult.getEndIndex();
        for (int startIndex = rowColumnMeasureHelperResult.getStartIndex(); startIndex < endIndex; startIndex++) {
            Placeable placeable = this.placeables[startIndex];
            Intrinsics.checkNotNull(placeable);
            int[] mainAxisPositions = rowColumnMeasureHelperResult.getMainAxisPositions();
            Object parentData = this.measurables.get(startIndex).getParentData();
            int crossAxisPosition = getCrossAxisPosition(placeable, parentData instanceof RowColumnParentData ? (RowColumnParentData) parentData : null, rowColumnMeasureHelperResult.getCrossAxisSize(), layoutDirection, rowColumnMeasureHelperResult.getBeforeCrossAxisAlignmentLine()) + i;
            if (this.orientation == LayoutOrientation.Horizontal) {
                Placeable.PlacementScope.place$default(placementScope, placeable, mainAxisPositions[startIndex - rowColumnMeasureHelperResult.getStartIndex()], crossAxisPosition, 0.0f, 4, null);
            } else {
                Placeable.PlacementScope.place$default(placementScope, placeable, crossAxisPosition, mainAxisPositions[startIndex - rowColumnMeasureHelperResult.getStartIndex()], 0.0f, 4, null);
            }
        }
    }
}
