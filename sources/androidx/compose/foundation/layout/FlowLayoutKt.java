package androidx.compose.foundation.layout;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.p004ui.Alignment;
import androidx.compose.p004ui.layout.IntrinsicMeasurable;
import androidx.compose.p004ui.layout.IntrinsicMeasureScope;
import androidx.compose.p004ui.layout.Measurable;
import androidx.compose.p004ui.layout.MeasurePolicy;
import androidx.compose.p004ui.layout.MeasureResult;
import androidx.compose.p004ui.layout.MeasureScope;
import androidx.compose.p004ui.layout.Placeable;
import androidx.compose.p004ui.unit.ConstraintsKt;
import androidx.compose.p004ui.unit.Density;
import androidx.compose.p004ui.unit.LayoutDirection;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.collection.MutableVector;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public final class FlowLayoutKt {

    @NotNull
    private static final Function4<Integer, int[], MeasureScope, int[], Unit> crossAxisRowArrangement = new Function4<Integer, int[], MeasureScope, int[], Unit>() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$crossAxisRowArrangement$1
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
            invoke(((Number) obj).intValue(), (int[]) obj2, (MeasureScope) obj3, (int[]) obj4);
            return Unit.INSTANCE;
        }

        public final void invoke(int i, @NotNull int[] iArr, @NotNull MeasureScope measureScope, @NotNull int[] iArr2) {
            Intrinsics.checkNotNullParameter(iArr, "size");
            Intrinsics.checkNotNullParameter(measureScope, "measureScope");
            Intrinsics.checkNotNullParameter(iArr2, "outPosition");
            Arrangement.INSTANCE.getTop().arrange(measureScope, i, iArr, iArr2);
        }
    };

    @NotNull
    private static final Function4<Integer, int[], MeasureScope, int[], Unit> crossAxisColumnArrangement = new Function4<Integer, int[], MeasureScope, int[], Unit>() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$crossAxisColumnArrangement$1
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
            invoke(((Number) obj).intValue(), (int[]) obj2, (MeasureScope) obj3, (int[]) obj4);
            return Unit.INSTANCE;
        }

        public final void invoke(int i, @NotNull int[] iArr, @NotNull MeasureScope measureScope, @NotNull int[] iArr2) {
            Intrinsics.checkNotNullParameter(iArr, "size");
            Intrinsics.checkNotNullParameter(measureScope, "measureScope");
            Intrinsics.checkNotNullParameter(iArr2, "outPosition");
            Arrangement.INSTANCE.getStart().arrange(measureScope, i, iArr, measureScope.getLayoutDirection(), iArr2);
        }
    };

    /* JADX WARN: Removed duplicated region for block: B:10:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x01d4  */
    /* JADX WARN: Removed duplicated region for block: B:29:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0139  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0145  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x019a  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x01c6  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0149  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0053  */
    @androidx.compose.runtime.Composable
    @androidx.compose.foundation.layout.ExperimentalLayoutApi
    @androidx.compose.runtime.ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void FlowColumn(@org.jetbrains.annotations.Nullable androidx.compose.p004ui.Modifier r16, @org.jetbrains.annotations.Nullable androidx.compose.foundation.layout.Arrangement.Vertical r17, @org.jetbrains.annotations.Nullable androidx.compose.ui.Alignment.Horizontal r18, int r19, @org.jetbrains.annotations.NotNull final kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.ColumnScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r20, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r21, final int r22, final int r23) {
        /*
            Method dump skipped, instructions count: 486
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.layout.FlowLayoutKt.FlowColumn(androidx.compose.ui.Modifier, androidx.compose.foundation.layout.Arrangement$Vertical, androidx.compose.ui.Alignment$Horizontal, int, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x01d4  */
    /* JADX WARN: Removed duplicated region for block: B:29:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0139  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0145  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x019a  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x01c6  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0149  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0053  */
    @androidx.compose.runtime.Composable
    @androidx.compose.foundation.layout.ExperimentalLayoutApi
    @androidx.compose.runtime.ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void FlowRow(@org.jetbrains.annotations.Nullable androidx.compose.p004ui.Modifier r16, @org.jetbrains.annotations.Nullable androidx.compose.foundation.layout.Arrangement.Horizontal r17, @org.jetbrains.annotations.Nullable androidx.compose.ui.Alignment.Vertical r18, int r19, @org.jetbrains.annotations.NotNull final kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.RowScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r20, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r21, final int r22, final int r23) {
        /*
            Method dump skipped, instructions count: 486
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.layout.FlowLayoutKt.FlowRow(androidx.compose.ui.Modifier, androidx.compose.foundation.layout.Arrangement$Horizontal, androidx.compose.ui.Alignment$Vertical, int, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    @NotNull
    public static final FlowResult breakDownItems(@NotNull MeasureScope measureScope, @NotNull RowColumnMeasurementHelper rowColumnMeasurementHelper, @NotNull LayoutOrientation layoutOrientation, @NotNull OrientationIndependentConstraints orientationIndependentConstraints, int i) {
        Intrinsics.checkNotNullParameter(measureScope, "<this>");
        Intrinsics.checkNotNullParameter(rowColumnMeasurementHelper, "measureHelper");
        Intrinsics.checkNotNullParameter(layoutOrientation, "orientation");
        Intrinsics.checkNotNullParameter(orientationIndependentConstraints, "constraints");
        MutableVector mutableVector = new MutableVector(new RowColumnMeasureHelperResult[16], 0);
        int mainAxisMax = orientationIndependentConstraints.getMainAxisMax();
        int mainAxisMin = orientationIndependentConstraints.getMainAxisMin();
        int crossAxisMax = orientationIndependentConstraints.getCrossAxisMax();
        List<Measurable> measurables = rowColumnMeasurementHelper.getMeasurables();
        final Placeable[] placeables = rowColumnMeasurementHelper.getPlaceables();
        int ceil = (int) Math.ceil(measureScope.mo1283toPx0680j_4(rowColumnMeasurementHelper.m1416getArrangementSpacingD9Ej5fM()));
        OrientationIndependentConstraints orientationIndependentConstraints2 = new OrientationIndependentConstraints(mainAxisMin, mainAxisMax, 0, crossAxisMax);
        Measurable measurable = (Measurable) CollectionsKt.getOrNull(measurables, 0);
        Integer valueOf = measurable != null ? Integer.valueOf(measureAndCache(measurable, orientationIndependentConstraints2, layoutOrientation, new Function1<Placeable, Unit>() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$breakDownItems$nextSize$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Placeable) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@Nullable Placeable placeable) {
                placeables[0] = placeable;
            }
        })) : null;
        Integer[] numArr = new Integer[measurables.size()];
        int size = measurables.size();
        int i2 = mainAxisMax;
        final int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        while (i3 < size) {
            Intrinsics.checkNotNull(valueOf);
            int intValue = valueOf.intValue();
            int i7 = i4 + intValue;
            i2 -= intValue;
            int i8 = i3 + 1;
            int i9 = mainAxisMax;
            Measurable measurable2 = (Measurable) CollectionsKt.getOrNull(measurables, i8);
            Integer valueOf2 = measurable2 != null ? Integer.valueOf(measureAndCache(measurable2, orientationIndependentConstraints2, layoutOrientation, new Function1<Placeable, Unit>() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$breakDownItems$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((Placeable) obj);
                    return Unit.INSTANCE;
                }

                public final void invoke(@Nullable Placeable placeable) {
                    placeables[i3 + 1] = placeable;
                }
            }) + ceil) : null;
            if (i8 < measurables.size() && i8 - i5 < i) {
                if (i2 - (valueOf2 != null ? valueOf2.intValue() : 0) >= 0) {
                    i4 = i7;
                    i3 = i8;
                    valueOf = valueOf2;
                    mainAxisMax = i9;
                }
            }
            int max = Math.max(mainAxisMin, i7);
            numArr[i6] = Integer.valueOf(i8);
            i6++;
            valueOf2 = valueOf2 != null ? Integer.valueOf(valueOf2.intValue() - ceil) : null;
            mainAxisMin = max;
            i5 = i8;
            i2 = i9;
            i4 = 0;
            i3 = i8;
            valueOf = valueOf2;
            mainAxisMax = i9;
        }
        long m1386toBoxConstraintsOenEA2s = OrientationIndependentConstraints.copy$default(orientationIndependentConstraints2, mainAxisMin, 0, 0, 0, 14, null).m1386toBoxConstraintsOenEA2s(layoutOrientation);
        Integer num = (Integer) ArraysKt.getOrNull(numArr, 0);
        int i10 = mainAxisMin;
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        while (num != null) {
            RowColumnMeasureHelperResult m1417measureWithoutPlacing_EkL_Y = rowColumnMeasurementHelper.m1417measureWithoutPlacing_EkL_Y(measureScope, m1386toBoxConstraintsOenEA2s, i11, num.intValue());
            i12 += m1417measureWithoutPlacing_EkL_Y.getCrossAxisSize();
            i10 = Math.max(i10, m1417measureWithoutPlacing_EkL_Y.getMainAxisSize());
            mutableVector.add(m1417measureWithoutPlacing_EkL_Y);
            i11 = num.intValue();
            i13++;
            num = (Integer) ArraysKt.getOrNull(numArr, i13);
        }
        return new FlowResult(Math.max(i10, orientationIndependentConstraints.getMainAxisMin()), Math.max(i12, orientationIndependentConstraints.getCrossAxisMin()), mutableVector);
    }

    @Composable
    private static final MeasurePolicy columnMeasurementHelper(Arrangement.Vertical vertical, Alignment.Horizontal horizontal, int i, Composer composer, int i2, int i3) {
        composer.startReplaceableGroup(-2013098357);
        if ((i3 & 1) != 0) {
            vertical = Arrangement.INSTANCE.getTop();
        }
        if ((i3 & 2) != 0) {
            horizontal = Alignment.Companion.getStart();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2013098357, i2, -1, "androidx.compose.foundation.layout.columnMeasurementHelper (FlowLayout.kt:179)");
        }
        Function5<Integer, int[], LayoutDirection, Density, int[], Unit> mainAxisColumnArrangement = mainAxisColumnArrangement(vertical, composer, i2 & 14);
        composer.startReplaceableGroup(1157296644);
        boolean changed = composer.changed(horizontal);
        Object rememberedValue = composer.rememberedValue();
        if (changed || rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = CrossAxisAlignment.Companion.horizontal$foundation_layout_release(horizontal);
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        CrossAxisAlignment crossAxisAlignment = (CrossAxisAlignment) rememberedValue;
        Integer valueOf = Integer.valueOf(i);
        composer.startReplaceableGroup(1618982084);
        boolean changed2 = composer.changed(horizontal) | composer.changed(vertical) | composer.changed(valueOf);
        Object rememberedValue2 = composer.rememberedValue();
        if (changed2 || rememberedValue2 == Composer.Companion.getEmpty()) {
            rememberedValue2 = m1373flowMeasurePolicy942rkJo(LayoutOrientation.Vertical, mainAxisColumnArrangement, vertical.mo1347getSpacingD9Ej5fM(), SizeMode.Wrap, crossAxisAlignment, crossAxisColumnArrangement, i);
            composer.updateRememberedValue(rememberedValue2);
        }
        composer.endReplaceableGroup();
        MeasurePolicy measurePolicy = (MeasurePolicy) rememberedValue2;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return measurePolicy;
    }

    public static final int crossAxisMin(@NotNull Measurable measurable, @NotNull LayoutOrientation layoutOrientation, int i) {
        Intrinsics.checkNotNullParameter(measurable, "<this>");
        Intrinsics.checkNotNullParameter(layoutOrientation, "orientation");
        return layoutOrientation == LayoutOrientation.Horizontal ? measurable.minIntrinsicHeight(i) : measurable.minIntrinsicWidth(i);
    }

    public static final int crossAxisSize(@NotNull Placeable placeable, @NotNull LayoutOrientation layoutOrientation) {
        Intrinsics.checkNotNullParameter(placeable, "<this>");
        Intrinsics.checkNotNullParameter(layoutOrientation, "orientation");
        return layoutOrientation == LayoutOrientation.Horizontal ? placeable.getHeight() : placeable.getWidth();
    }

    /* renamed from: flowMeasurePolicy-942rkJo, reason: not valid java name */
    private static final MeasurePolicy m1373flowMeasurePolicy942rkJo(final LayoutOrientation layoutOrientation, final Function5<? super Integer, ? super int[], ? super LayoutDirection, ? super Density, ? super int[], Unit> function5, final float f, final SizeMode sizeMode, final CrossAxisAlignment crossAxisAlignment, final Function4<? super Integer, ? super int[], ? super MeasureScope, ? super int[], Unit> function4, final int i) {
        return new MeasurePolicy(function5, f, sizeMode, crossAxisAlignment, i, function4) { // from class: androidx.compose.foundation.layout.FlowLayoutKt$flowMeasurePolicy$1
            final /* synthetic */ float $arrangementSpacing;
            final /* synthetic */ CrossAxisAlignment $crossAxisAlignment;
            final /* synthetic */ Function4<Integer, int[], MeasureScope, int[], Unit> $crossAxisArrangement;
            final /* synthetic */ SizeMode $crossAxisSize;
            final /* synthetic */ Function5<Integer, int[], LayoutDirection, Density, int[], Unit> $mainAxisArrangement;
            final /* synthetic */ int $maxItemsInMainAxis;

            @NotNull
            private final Function3<IntrinsicMeasurable, Integer, Integer, Integer> maxCrossAxisIntrinsicItemSize;

            @NotNull
            private final Function3<IntrinsicMeasurable, Integer, Integer, Integer> maxMainAxisIntrinsicItemSize;

            @NotNull
            private final Function3<IntrinsicMeasurable, Integer, Integer, Integer> minCrossAxisIntrinsicItemSize;

            @NotNull
            private final Function3<IntrinsicMeasurable, Integer, Integer, Integer> minMainAxisIntrinsicItemSize;

            /* JADX WARN: Multi-variable type inference failed */
            {
                this.$mainAxisArrangement = function5;
                this.$arrangementSpacing = f;
                this.$crossAxisSize = sizeMode;
                this.$crossAxisAlignment = crossAxisAlignment;
                this.$maxItemsInMainAxis = i;
                this.$crossAxisArrangement = function4;
                LayoutOrientation layoutOrientation2 = LayoutOrientation.Horizontal;
                this.maxMainAxisIntrinsicItemSize = LayoutOrientation.this == layoutOrientation2 ? new Function3<IntrinsicMeasurable, Integer, Integer, Integer>() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$flowMeasurePolicy$1$maxMainAxisIntrinsicItemSize$1
                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                        return invoke((IntrinsicMeasurable) obj, ((Number) obj2).intValue(), ((Number) obj3).intValue());
                    }

                    @NotNull
                    public final Integer invoke(@NotNull IntrinsicMeasurable intrinsicMeasurable, int i2, int i3) {
                        Intrinsics.checkNotNullParameter(intrinsicMeasurable, "$this$null");
                        return Integer.valueOf(intrinsicMeasurable.maxIntrinsicWidth(i3));
                    }
                } : new Function3<IntrinsicMeasurable, Integer, Integer, Integer>() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$flowMeasurePolicy$1$maxMainAxisIntrinsicItemSize$2
                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                        return invoke((IntrinsicMeasurable) obj, ((Number) obj2).intValue(), ((Number) obj3).intValue());
                    }

                    @NotNull
                    public final Integer invoke(@NotNull IntrinsicMeasurable intrinsicMeasurable, int i2, int i3) {
                        Intrinsics.checkNotNullParameter(intrinsicMeasurable, "$this$null");
                        return Integer.valueOf(intrinsicMeasurable.maxIntrinsicHeight(i3));
                    }
                };
                this.maxCrossAxisIntrinsicItemSize = LayoutOrientation.this == layoutOrientation2 ? new Function3<IntrinsicMeasurable, Integer, Integer, Integer>() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$flowMeasurePolicy$1$maxCrossAxisIntrinsicItemSize$1
                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                        return invoke((IntrinsicMeasurable) obj, ((Number) obj2).intValue(), ((Number) obj3).intValue());
                    }

                    @NotNull
                    public final Integer invoke(@NotNull IntrinsicMeasurable intrinsicMeasurable, int i2, int i3) {
                        Intrinsics.checkNotNullParameter(intrinsicMeasurable, "$this$null");
                        return Integer.valueOf(intrinsicMeasurable.maxIntrinsicHeight(i3));
                    }
                } : new Function3<IntrinsicMeasurable, Integer, Integer, Integer>() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$flowMeasurePolicy$1$maxCrossAxisIntrinsicItemSize$2
                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                        return invoke((IntrinsicMeasurable) obj, ((Number) obj2).intValue(), ((Number) obj3).intValue());
                    }

                    @NotNull
                    public final Integer invoke(@NotNull IntrinsicMeasurable intrinsicMeasurable, int i2, int i3) {
                        Intrinsics.checkNotNullParameter(intrinsicMeasurable, "$this$null");
                        return Integer.valueOf(intrinsicMeasurable.maxIntrinsicWidth(i3));
                    }
                };
                this.minCrossAxisIntrinsicItemSize = LayoutOrientation.this == layoutOrientation2 ? new Function3<IntrinsicMeasurable, Integer, Integer, Integer>() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$flowMeasurePolicy$1$minCrossAxisIntrinsicItemSize$1
                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                        return invoke((IntrinsicMeasurable) obj, ((Number) obj2).intValue(), ((Number) obj3).intValue());
                    }

                    @NotNull
                    public final Integer invoke(@NotNull IntrinsicMeasurable intrinsicMeasurable, int i2, int i3) {
                        Intrinsics.checkNotNullParameter(intrinsicMeasurable, "$this$null");
                        return Integer.valueOf(intrinsicMeasurable.minIntrinsicHeight(i3));
                    }
                } : new Function3<IntrinsicMeasurable, Integer, Integer, Integer>() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$flowMeasurePolicy$1$minCrossAxisIntrinsicItemSize$2
                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                        return invoke((IntrinsicMeasurable) obj, ((Number) obj2).intValue(), ((Number) obj3).intValue());
                    }

                    @NotNull
                    public final Integer invoke(@NotNull IntrinsicMeasurable intrinsicMeasurable, int i2, int i3) {
                        Intrinsics.checkNotNullParameter(intrinsicMeasurable, "$this$null");
                        return Integer.valueOf(intrinsicMeasurable.minIntrinsicWidth(i3));
                    }
                };
                this.minMainAxisIntrinsicItemSize = LayoutOrientation.this == layoutOrientation2 ? new Function3<IntrinsicMeasurable, Integer, Integer, Integer>() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$flowMeasurePolicy$1$minMainAxisIntrinsicItemSize$1
                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                        return invoke((IntrinsicMeasurable) obj, ((Number) obj2).intValue(), ((Number) obj3).intValue());
                    }

                    @NotNull
                    public final Integer invoke(@NotNull IntrinsicMeasurable intrinsicMeasurable, int i2, int i3) {
                        Intrinsics.checkNotNullParameter(intrinsicMeasurable, "$this$null");
                        return Integer.valueOf(intrinsicMeasurable.minIntrinsicWidth(i3));
                    }
                } : new Function3<IntrinsicMeasurable, Integer, Integer, Integer>() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$flowMeasurePolicy$1$minMainAxisIntrinsicItemSize$2
                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                        return invoke((IntrinsicMeasurable) obj, ((Number) obj2).intValue(), ((Number) obj3).intValue());
                    }

                    @NotNull
                    public final Integer invoke(@NotNull IntrinsicMeasurable intrinsicMeasurable, int i2, int i3) {
                        Intrinsics.checkNotNullParameter(intrinsicMeasurable, "$this$null");
                        return Integer.valueOf(intrinsicMeasurable.minIntrinsicHeight(i3));
                    }
                };
            }

            @NotNull
            public final Function3<IntrinsicMeasurable, Integer, Integer, Integer> getMaxCrossAxisIntrinsicItemSize() {
                return this.maxCrossAxisIntrinsicItemSize;
            }

            @NotNull
            public final Function3<IntrinsicMeasurable, Integer, Integer, Integer> getMaxMainAxisIntrinsicItemSize() {
                return this.maxMainAxisIntrinsicItemSize;
            }

            @NotNull
            public final Function3<IntrinsicMeasurable, Integer, Integer, Integer> getMinCrossAxisIntrinsicItemSize() {
                return this.minCrossAxisIntrinsicItemSize;
            }

            @NotNull
            public final Function3<IntrinsicMeasurable, Integer, Integer, Integer> getMinMainAxisIntrinsicItemSize() {
                return this.minMainAxisIntrinsicItemSize;
            }

            public final int intrinsicCrossAxisSize(@NotNull List<? extends IntrinsicMeasurable> list, int i2, int i3) {
                int intrinsicCrossAxisSize;
                Intrinsics.checkNotNullParameter(list, "measurables");
                intrinsicCrossAxisSize = FlowLayoutKt.intrinsicCrossAxisSize((List<? extends IntrinsicMeasurable>) list, (Function3<? super IntrinsicMeasurable, ? super Integer, ? super Integer, Integer>) this.minMainAxisIntrinsicItemSize, (Function3<? super IntrinsicMeasurable, ? super Integer, ? super Integer, Integer>) this.minCrossAxisIntrinsicItemSize, i2, i3, this.$maxItemsInMainAxis);
                return intrinsicCrossAxisSize;
            }

            @Override // androidx.compose.p004ui.layout.MeasurePolicy
            public int maxIntrinsicHeight(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull List<? extends IntrinsicMeasurable> list, int i2) {
                Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
                Intrinsics.checkNotNullParameter(list, "measurables");
                return LayoutOrientation.this == LayoutOrientation.Horizontal ? intrinsicCrossAxisSize(list, i2, intrinsicMeasureScope.mo1277roundToPx0680j_4(this.$arrangementSpacing)) : maxIntrinsicMainAxisSize(list, i2, intrinsicMeasureScope.mo1277roundToPx0680j_4(this.$arrangementSpacing));
            }

            public final int maxIntrinsicMainAxisSize(@NotNull List<? extends IntrinsicMeasurable> list, int i2, int i3) {
                int maxIntrinsicMainAxisSize;
                Intrinsics.checkNotNullParameter(list, "measurables");
                maxIntrinsicMainAxisSize = FlowLayoutKt.maxIntrinsicMainAxisSize(list, this.maxMainAxisIntrinsicItemSize, i2, i3, this.$maxItemsInMainAxis);
                return maxIntrinsicMainAxisSize;
            }

            @Override // androidx.compose.p004ui.layout.MeasurePolicy
            public int maxIntrinsicWidth(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull List<? extends IntrinsicMeasurable> list, int i2) {
                Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
                Intrinsics.checkNotNullParameter(list, "measurables");
                return LayoutOrientation.this == LayoutOrientation.Horizontal ? maxIntrinsicMainAxisSize(list, i2, intrinsicMeasureScope.mo1277roundToPx0680j_4(this.$arrangementSpacing)) : intrinsicCrossAxisSize(list, i2, intrinsicMeasureScope.mo1277roundToPx0680j_4(this.$arrangementSpacing));
            }

            @Override // androidx.compose.p004ui.layout.MeasurePolicy
            @NotNull
            /* renamed from: measure-3p2s80s */
            public MeasureResult mo944measure3p2s80s(@NotNull final MeasureScope measureScope, @NotNull List<? extends Measurable> list, long j) {
                int crossAxisTotalSize;
                int mainAxisTotalSize;
                Intrinsics.checkNotNullParameter(measureScope, "$this$measure");
                Intrinsics.checkNotNullParameter(list, "measurables");
                final RowColumnMeasurementHelper rowColumnMeasurementHelper = new RowColumnMeasurementHelper(LayoutOrientation.this, this.$mainAxisArrangement, this.$arrangementSpacing, this.$crossAxisSize, this.$crossAxisAlignment, list, new Placeable[list.size()], null);
                final FlowResult breakDownItems = FlowLayoutKt.breakDownItems(measureScope, rowColumnMeasurementHelper, LayoutOrientation.this, new OrientationIndependentConstraints(j, LayoutOrientation.this, null), this.$maxItemsInMainAxis);
                int crossAxisTotalSize2 = breakDownItems.getCrossAxisTotalSize();
                MutableVector<RowColumnMeasureHelperResult> items = breakDownItems.getItems();
                int size = items.getSize();
                int[] iArr = new int[size];
                for (int i2 = 0; i2 < size; i2++) {
                    iArr[i2] = items.getContent()[i2].getCrossAxisSize();
                }
                final int[] iArr2 = new int[size];
                this.$crossAxisArrangement.invoke(Integer.valueOf(crossAxisTotalSize2), iArr, measureScope, iArr2);
                if (LayoutOrientation.this == LayoutOrientation.Horizontal) {
                    crossAxisTotalSize = breakDownItems.getMainAxisTotalSize();
                    mainAxisTotalSize = breakDownItems.getCrossAxisTotalSize();
                } else {
                    crossAxisTotalSize = breakDownItems.getCrossAxisTotalSize();
                    mainAxisTotalSize = breakDownItems.getMainAxisTotalSize();
                }
                return MeasureScope.CC.m140p(measureScope, ConstraintsKt.m5198constrainWidthK40F9xA(j, crossAxisTotalSize), ConstraintsKt.m5197constrainHeightK40F9xA(j, mainAxisTotalSize), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$flowMeasurePolicy$1$measure$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke((Placeable.PlacementScope) obj);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(@NotNull Placeable.PlacementScope placementScope) {
                        Intrinsics.checkNotNullParameter(placementScope, "$this$layout");
                        MutableVector<RowColumnMeasureHelperResult> items2 = FlowResult.this.getItems();
                        RowColumnMeasurementHelper rowColumnMeasurementHelper2 = rowColumnMeasurementHelper;
                        int[] iArr3 = iArr2;
                        MeasureScope measureScope2 = measureScope;
                        int size2 = items2.getSize();
                        if (size2 > 0) {
                            int i3 = 0;
                            RowColumnMeasureHelperResult[] content = items2.getContent();
                            do {
                                rowColumnMeasurementHelper2.placeHelper(placementScope, content[i3], iArr3[i3], measureScope2.getLayoutDirection());
                                i3++;
                            } while (i3 < size2);
                        }
                    }
                }, 4, null);
            }

            @Override // androidx.compose.p004ui.layout.MeasurePolicy
            public int minIntrinsicHeight(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull List<? extends IntrinsicMeasurable> list, int i2) {
                Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
                Intrinsics.checkNotNullParameter(list, "measurables");
                return LayoutOrientation.this == LayoutOrientation.Horizontal ? intrinsicCrossAxisSize(list, i2, intrinsicMeasureScope.mo1277roundToPx0680j_4(this.$arrangementSpacing)) : minIntrinsicMainAxisSize(list, i2, intrinsicMeasureScope.mo1277roundToPx0680j_4(this.$arrangementSpacing));
            }

            public final int minIntrinsicMainAxisSize(@NotNull List<? extends IntrinsicMeasurable> list, int i2, int i3) {
                int minIntrinsicMainAxisSize;
                Intrinsics.checkNotNullParameter(list, "measurables");
                minIntrinsicMainAxisSize = FlowLayoutKt.minIntrinsicMainAxisSize(list, this.minMainAxisIntrinsicItemSize, this.minCrossAxisIntrinsicItemSize, i2, i3, this.$maxItemsInMainAxis);
                return minIntrinsicMainAxisSize;
            }

            @Override // androidx.compose.p004ui.layout.MeasurePolicy
            public int minIntrinsicWidth(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull List<? extends IntrinsicMeasurable> list, int i2) {
                Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
                Intrinsics.checkNotNullParameter(list, "measurables");
                return LayoutOrientation.this == LayoutOrientation.Horizontal ? minIntrinsicMainAxisSize(list, i2, intrinsicMeasureScope.mo1277roundToPx0680j_4(this.$arrangementSpacing)) : intrinsicCrossAxisSize(list, i2, intrinsicMeasureScope.mo1277roundToPx0680j_4(this.$arrangementSpacing));
            }
        };
    }

    private static final int intrinsicCrossAxisSize(List<? extends IntrinsicMeasurable> list, final int[] iArr, final int[] iArr2, int i, int i2, int i3) {
        return intrinsicCrossAxisSize(list, new Function3<IntrinsicMeasurable, Integer, Integer, Integer>() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$intrinsicCrossAxisSize$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                return invoke((IntrinsicMeasurable) obj, ((Number) obj2).intValue(), ((Number) obj3).intValue());
            }

            @NotNull
            public final Integer invoke(@NotNull IntrinsicMeasurable intrinsicMeasurable, int i4, int i5) {
                Intrinsics.checkNotNullParameter(intrinsicMeasurable, "$this$intrinsicCrossAxisSize");
                return Integer.valueOf(iArr[i4]);
            }
        }, new Function3<IntrinsicMeasurable, Integer, Integer, Integer>() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$intrinsicCrossAxisSize$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                return invoke((IntrinsicMeasurable) obj, ((Number) obj2).intValue(), ((Number) obj3).intValue());
            }

            @NotNull
            public final Integer invoke(@NotNull IntrinsicMeasurable intrinsicMeasurable, int i4, int i5) {
                Intrinsics.checkNotNullParameter(intrinsicMeasurable, "$this$intrinsicCrossAxisSize");
                return Integer.valueOf(iArr2[i4]);
            }
        }, i, i2, i3);
    }

    @Composable
    private static final Function5<Integer, int[], LayoutDirection, Density, int[], Unit> mainAxisColumnArrangement(final Arrangement.Vertical vertical, Composer composer, int i) {
        composer.startReplaceableGroup(-1642644113);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1642644113, i, -1, "androidx.compose.foundation.layout.mainAxisColumnArrangement (FlowLayout.kt:132)");
        }
        boolean changed = composer.changed(vertical);
        Object rememberedValue = composer.rememberedValue();
        if (changed || rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = new Function5<Integer, int[], LayoutDirection, Density, int[], Unit>() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$mainAxisColumnArrangement$1$1
                {
                    super(5);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
                    invoke(((Number) obj).intValue(), (int[]) obj2, (LayoutDirection) obj3, (Density) obj4, (int[]) obj5);
                    return Unit.INSTANCE;
                }

                public final void invoke(int i2, @NotNull int[] iArr, @NotNull LayoutDirection layoutDirection, @NotNull Density density, @NotNull int[] iArr2) {
                    Intrinsics.checkNotNullParameter(iArr, "size");
                    Intrinsics.checkNotNullParameter(layoutDirection, "<anonymous parameter 2>");
                    Intrinsics.checkNotNullParameter(density, "density");
                    Intrinsics.checkNotNullParameter(iArr2, "outPosition");
                    Arrangement.Vertical.this.arrange(density, i2, iArr, iArr2);
                }
            };
            composer.updateRememberedValue(rememberedValue);
        }
        Function5<Integer, int[], LayoutDirection, Density, int[], Unit> function5 = (Function5) rememberedValue;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return function5;
    }

    public static final int mainAxisMin(@NotNull Measurable measurable, @NotNull LayoutOrientation layoutOrientation, int i) {
        Intrinsics.checkNotNullParameter(measurable, "<this>");
        Intrinsics.checkNotNullParameter(layoutOrientation, "orientation");
        return layoutOrientation == LayoutOrientation.Horizontal ? measurable.minIntrinsicWidth(i) : measurable.minIntrinsicHeight(i);
    }

    @Composable
    private static final Function5<Integer, int[], LayoutDirection, Density, int[], Unit> mainAxisRowArrangement(final Arrangement.Horizontal horizontal, Composer composer, int i) {
        composer.startReplaceableGroup(746410833);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(746410833, i, -1, "androidx.compose.foundation.layout.mainAxisRowArrangement (FlowLayout.kt:121)");
        }
        boolean changed = composer.changed(horizontal);
        Object rememberedValue = composer.rememberedValue();
        if (changed || rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = new Function5<Integer, int[], LayoutDirection, Density, int[], Unit>() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$mainAxisRowArrangement$1$1
                {
                    super(5);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
                    invoke(((Number) obj).intValue(), (int[]) obj2, (LayoutDirection) obj3, (Density) obj4, (int[]) obj5);
                    return Unit.INSTANCE;
                }

                public final void invoke(int i2, @NotNull int[] iArr, @NotNull LayoutDirection layoutDirection, @NotNull Density density, @NotNull int[] iArr2) {
                    Intrinsics.checkNotNullParameter(iArr, "size");
                    Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
                    Intrinsics.checkNotNullParameter(density, "density");
                    Intrinsics.checkNotNullParameter(iArr2, "outPosition");
                    Arrangement.Horizontal.this.arrange(density, i2, iArr, layoutDirection, iArr2);
                }
            };
            composer.updateRememberedValue(rememberedValue);
        }
        Function5<Integer, int[], LayoutDirection, Density, int[], Unit> function5 = (Function5) rememberedValue;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return function5;
    }

    public static final int mainAxisSize(@NotNull Placeable placeable, @NotNull LayoutOrientation layoutOrientation) {
        Intrinsics.checkNotNullParameter(placeable, "<this>");
        Intrinsics.checkNotNullParameter(layoutOrientation, "orientation");
        return layoutOrientation == LayoutOrientation.Horizontal ? placeable.getWidth() : placeable.getHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int maxIntrinsicMainAxisSize(List<? extends IntrinsicMeasurable> list, Function3<? super IntrinsicMeasurable, ? super Integer, ? super Integer, Integer> function3, int i, int i2, int i3) {
        int size = list.size();
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        while (i4 < size) {
            int intValue = ((Number) function3.invoke(list.get(i4), Integer.valueOf(i4), Integer.valueOf(i))).intValue() + i2;
            int i8 = i4 + 1;
            if (i8 - i6 == i3 || i8 == list.size()) {
                i5 = Math.max(i5, i7 + intValue);
                i6 = i4;
                i7 = 0;
            } else {
                i7 += intValue;
            }
            i4 = i8;
        }
        return i5;
    }

    private static final int measureAndCache(Measurable measurable, OrientationIndependentConstraints orientationIndependentConstraints, LayoutOrientation layoutOrientation, Function1<? super Placeable, Unit> function1) {
        if (!(RowColumnImplKt.getWeight(RowColumnImplKt.getRowColumnParentData(measurable)) == 0.0f)) {
            return mainAxisMin(measurable, layoutOrientation, Integer.MAX_VALUE);
        }
        Placeable mo4187measureBRTryo0 = measurable.mo4187measureBRTryo0(OrientationIndependentConstraints.copy$default(orientationIndependentConstraints, 0, 0, 0, 0, 14, null).m1386toBoxConstraintsOenEA2s(layoutOrientation));
        function1.invoke(mo4187measureBRTryo0);
        return mainAxisSize(mo4187measureBRTryo0, layoutOrientation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int minIntrinsicMainAxisSize(List<? extends IntrinsicMeasurable> list, Function3<? super IntrinsicMeasurable, ? super Integer, ? super Integer, Integer> function3, Function3<? super IntrinsicMeasurable, ? super Integer, ? super Integer, Integer> function32, int i, int i2, int i3) {
        int size = list.size();
        int[] iArr = new int[size];
        for (int i4 = 0; i4 < size; i4++) {
            iArr[i4] = 0;
        }
        int size2 = list.size();
        int[] iArr2 = new int[size2];
        for (int i5 = 0; i5 < size2; i5++) {
            iArr2[i5] = 0;
        }
        int size3 = list.size();
        for (int i6 = 0; i6 < size3; i6++) {
            IntrinsicMeasurable intrinsicMeasurable = list.get(i6);
            int intValue = ((Number) function3.invoke(intrinsicMeasurable, Integer.valueOf(i6), Integer.valueOf(i))).intValue();
            iArr[i6] = intValue;
            iArr2[i6] = ((Number) function32.invoke(intrinsicMeasurable, Integer.valueOf(i6), Integer.valueOf(intValue))).intValue();
        }
        int sum = ArraysKt.sum(iArr);
        int i7 = 1;
        if (size2 == 0) {
            throw new NoSuchElementException();
        }
        int i8 = iArr2[0];
        int lastIndex = ArraysKt.getLastIndex(iArr2);
        if (1 <= lastIndex) {
            int i9 = 1;
            while (true) {
                int i10 = iArr2[i9];
                if (i8 < i10) {
                    i8 = i10;
                }
                if (i9 == lastIndex) {
                    break;
                }
                i9++;
            }
        }
        if (size == 0) {
            throw new NoSuchElementException();
        }
        int i11 = iArr[0];
        int lastIndex2 = ArraysKt.getLastIndex(iArr);
        if (1 <= lastIndex2) {
            while (true) {
                int i12 = iArr[i7];
                if (i11 < i12) {
                    i11 = i12;
                }
                if (i7 == lastIndex2) {
                    break;
                }
                i7++;
            }
        }
        int i13 = sum;
        while (i11 < sum && i8 != i) {
            i13 = (i11 + sum) / 2;
            i8 = intrinsicCrossAxisSize(list, iArr, iArr2, i13, i2, i3);
            if (i8 == i) {
                return i13;
            }
            if (i8 > i) {
                i11 = i13 + 1;
            } else {
                sum = i13 - 1;
            }
        }
        return i13;
    }

    @Composable
    private static final MeasurePolicy rowMeasurementHelper(Arrangement.Horizontal horizontal, Alignment.Vertical vertical, int i, Composer composer, int i2, int i3) {
        composer.startReplaceableGroup(1479255111);
        if ((i3 & 1) != 0) {
            horizontal = Arrangement.INSTANCE.getEnd();
        }
        if ((i3 & 2) != 0) {
            vertical = Alignment.Companion.getTop();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1479255111, i2, -1, "androidx.compose.foundation.layout.rowMeasurementHelper (FlowLayout.kt:156)");
        }
        Function5<Integer, int[], LayoutDirection, Density, int[], Unit> mainAxisRowArrangement = mainAxisRowArrangement(horizontal, composer, i2 & 14);
        composer.startReplaceableGroup(1157296644);
        boolean changed = composer.changed(vertical);
        Object rememberedValue = composer.rememberedValue();
        if (changed || rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = CrossAxisAlignment.Companion.vertical$foundation_layout_release(vertical);
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        CrossAxisAlignment crossAxisAlignment = (CrossAxisAlignment) rememberedValue;
        Integer valueOf = Integer.valueOf(i);
        composer.startReplaceableGroup(1618982084);
        boolean changed2 = composer.changed(vertical) | composer.changed(horizontal) | composer.changed(valueOf);
        Object rememberedValue2 = composer.rememberedValue();
        if (changed2 || rememberedValue2 == Composer.Companion.getEmpty()) {
            rememberedValue2 = m1373flowMeasurePolicy942rkJo(LayoutOrientation.Horizontal, mainAxisRowArrangement, horizontal.mo1347getSpacingD9Ej5fM(), SizeMode.Wrap, crossAxisAlignment, crossAxisRowArrangement, i);
            composer.updateRememberedValue(rememberedValue2);
        }
        composer.endReplaceableGroup();
        MeasurePolicy measurePolicy = (MeasurePolicy) rememberedValue2;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return measurePolicy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int intrinsicCrossAxisSize(List<? extends IntrinsicMeasurable> list, Function3<? super IntrinsicMeasurable, ? super Integer, ? super Integer, Integer> function3, Function3<? super IntrinsicMeasurable, ? super Integer, ? super Integer, Integer> function32, int i, int i2, int i3) {
        if (list.isEmpty()) {
            return 0;
        }
        Object orNull = CollectionsKt.getOrNull(list, 0);
        IntrinsicMeasurable intrinsicMeasurable = (IntrinsicMeasurable) orNull;
        int intValue = intrinsicMeasurable != null ? ((Number) function32.invoke(intrinsicMeasurable, 0, Integer.valueOf(i))).intValue() : 0;
        int intValue2 = intrinsicMeasurable != null ? ((Number) function3.invoke(intrinsicMeasurable, 0, Integer.valueOf(intValue))).intValue() : 0;
        int size = list.size();
        int i4 = i;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        while (i5 < size) {
            list.get(i5);
            Intrinsics.checkNotNull(orNull);
            i4 -= intValue2;
            int max = Math.max(i7, intValue);
            i5++;
            Object orNull2 = CollectionsKt.getOrNull(list, i5);
            IntrinsicMeasurable intrinsicMeasurable2 = (IntrinsicMeasurable) orNull2;
            int intValue3 = intrinsicMeasurable2 != null ? ((Number) function32.invoke(intrinsicMeasurable2, Integer.valueOf(i5), Integer.valueOf(i))).intValue() : 0;
            int intValue4 = intrinsicMeasurable2 != null ? ((Number) function3.invoke(intrinsicMeasurable2, Integer.valueOf(i5), Integer.valueOf(intValue3))).intValue() + i2 : 0;
            if (i4 >= 0 && i5 != list.size()) {
                if (i5 - i8 != i3 && i4 - intValue4 >= 0) {
                    int i9 = intValue3;
                    i7 = max;
                    orNull = orNull2;
                    intValue2 = intValue4;
                    intValue = i9;
                }
            }
            i6 += max;
            intValue4 -= i2;
            i4 = i;
            i8 = i5;
            max = 0;
            int i92 = intValue3;
            i7 = max;
            orNull = orNull2;
            intValue2 = intValue4;
            intValue = i92;
        }
        return i6;
    }
}
