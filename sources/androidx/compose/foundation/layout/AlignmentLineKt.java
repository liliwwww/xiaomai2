package androidx.compose.foundation.layout;

import androidx.compose.foundation.layout.AlignmentLineKt$paddingFrom-4j6BHR0$;
import androidx.compose.foundation.layout.AlignmentLineKt$paddingFrom-Y_r0B1c$;
import androidx.compose.runtime.Stable;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.layout.HorizontalAlignmentLine;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.MeasureScope$CC;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class AlignmentLineKt {
    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: alignmentLineOffsetMeasure-tjqqzMA, reason: not valid java name */
    public static final MeasureResult m263alignmentLineOffsetMeasuretjqqzMA(MeasureScope measureScope, AlignmentLine alignmentLine, float f, float f2, Measurable measurable, long j) {
        Placeable placeable = measurable.measure-BRTryo0(getHorizontal(alignmentLine) ? Constraints.copy-Zbe2FdA$default(j, 0, 0, 0, 0, 11, (Object) null) : Constraints.copy-Zbe2FdA$default(j, 0, 0, 0, 0, 14, (Object) null));
        int i = placeable.get(alignmentLine);
        if (i == Integer.MIN_VALUE) {
            i = 0;
        }
        int height = getHorizontal(alignmentLine) ? placeable.getHeight() : placeable.getWidth();
        int i2 = getHorizontal(alignmentLine) ? Constraints.getMaxHeight-impl(j) : Constraints.getMaxWidth-impl(j);
        Dp.Companion companion = Dp.Companion;
        int i3 = i2 - height;
        int coerceIn = RangesKt.coerceIn((!Dp.equals-impl0(f, companion.getUnspecified-D9Ej5fM()) ? measureScope.roundToPx-0680j_4(f) : 0) - i, 0, i3);
        int coerceIn2 = RangesKt.coerceIn(((!Dp.equals-impl0(f2, companion.getUnspecified-D9Ej5fM()) ? measureScope.roundToPx-0680j_4(f2) : 0) - height) + i, 0, i3 - coerceIn);
        int width = getHorizontal(alignmentLine) ? placeable.getWidth() : Math.max(placeable.getWidth() + coerceIn + coerceIn2, Constraints.getMinWidth-impl(j));
        int max = getHorizontal(alignmentLine) ? Math.max(placeable.getHeight() + coerceIn + coerceIn2, Constraints.getMinHeight-impl(j)) : placeable.getHeight();
        return MeasureScope$CC.p(measureScope, width, max, null, new alignmentLineOffsetMeasure.1(alignmentLine, f, coerceIn, width, coerceIn2, placeable, max), 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean getHorizontal(AlignmentLine alignmentLine) {
        return alignmentLine instanceof HorizontalAlignmentLine;
    }

    @Stable
    @NotNull
    /* renamed from: paddingFrom-4j6BHR0, reason: not valid java name */
    public static final Modifier m264paddingFrom4j6BHR0(@NotNull Modifier modifier, @NotNull AlignmentLine alignmentLine, float f, float f2) {
        Intrinsics.checkNotNullParameter(modifier, "$this$paddingFrom");
        Intrinsics.checkNotNullParameter(alignmentLine, "alignmentLine");
        return modifier.then(new AlignmentLineOffsetDp(alignmentLine, f, f2, InspectableValueKt.isDebugInspectorInfoEnabled() ? new AlignmentLineKt$paddingFrom-4j6BHR0$.inlined.debugInspectorInfo.1(alignmentLine, f, f2) : InspectableValueKt.getNoInspectorInfo(), null));
    }

    /* renamed from: paddingFrom-4j6BHR0$default, reason: not valid java name */
    public static /* synthetic */ Modifier m265paddingFrom4j6BHR0$default(Modifier modifier, AlignmentLine alignmentLine, float f, float f2, int i, Object obj) {
        if ((i & 2) != 0) {
            f = Dp.Companion.getUnspecified-D9Ej5fM();
        }
        if ((i & 4) != 0) {
            f2 = Dp.Companion.getUnspecified-D9Ej5fM();
        }
        return m264paddingFrom4j6BHR0(modifier, alignmentLine, f, f2);
    }

    @Stable
    @NotNull
    /* renamed from: paddingFrom-Y_r0B1c, reason: not valid java name */
    public static final Modifier m266paddingFromY_r0B1c(@NotNull Modifier modifier, @NotNull AlignmentLine alignmentLine, long j, long j2) {
        Intrinsics.checkNotNullParameter(modifier, "$this$paddingFrom");
        Intrinsics.checkNotNullParameter(alignmentLine, "alignmentLine");
        return modifier.then(new AlignmentLineOffsetTextUnit(alignmentLine, j, j2, InspectableValueKt.isDebugInspectorInfoEnabled() ? new AlignmentLineKt$paddingFrom-Y_r0B1c$.inlined.debugInspectorInfo.1(alignmentLine, j, j2) : InspectableValueKt.getNoInspectorInfo(), (DefaultConstructorMarker) null));
    }

    /* renamed from: paddingFrom-Y_r0B1c$default, reason: not valid java name */
    public static /* synthetic */ Modifier m267paddingFromY_r0B1c$default(Modifier modifier, AlignmentLine alignmentLine, long j, long j2, int i, Object obj) {
        if ((i & 2) != 0) {
            j = TextUnit.Companion.getUnspecified-XSAIIZE();
        }
        long j3 = j;
        if ((i & 4) != 0) {
            j2 = TextUnit.Companion.getUnspecified-XSAIIZE();
        }
        return m266paddingFromY_r0B1c(modifier, alignmentLine, j3, j2);
    }

    @Stable
    @NotNull
    /* renamed from: paddingFromBaseline-VpY3zN4, reason: not valid java name */
    public static final Modifier m268paddingFromBaselineVpY3zN4(@NotNull Modifier modifier, float f, float f2) {
        Intrinsics.checkNotNullParameter(modifier, "$this$paddingFromBaseline");
        Dp.Companion companion = Dp.Companion;
        return modifier.then(!Dp.equals-impl0(f2, companion.getUnspecified-D9Ej5fM()) ? m265paddingFrom4j6BHR0$default(modifier, androidx.compose.ui.layout.AlignmentLineKt.getLastBaseline(), 0.0f, f2, 2, null) : Modifier.Companion).then(!Dp.equals-impl0(f, companion.getUnspecified-D9Ej5fM()) ? m265paddingFrom4j6BHR0$default(modifier, androidx.compose.ui.layout.AlignmentLineKt.getFirstBaseline(), f, 0.0f, 4, null) : Modifier.Companion);
    }

    /* renamed from: paddingFromBaseline-VpY3zN4$default, reason: not valid java name */
    public static /* synthetic */ Modifier m269paddingFromBaselineVpY3zN4$default(Modifier modifier, float f, float f2, int i, Object obj) {
        if ((i & 1) != 0) {
            f = Dp.Companion.getUnspecified-D9Ej5fM();
        }
        if ((i & 2) != 0) {
            f2 = Dp.Companion.getUnspecified-D9Ej5fM();
        }
        return m268paddingFromBaselineVpY3zN4(modifier, f, f2);
    }

    @Stable
    @NotNull
    /* renamed from: paddingFromBaseline-wCyjxdI, reason: not valid java name */
    public static final Modifier m270paddingFromBaselinewCyjxdI(@NotNull Modifier modifier, long j, long j2) {
        Intrinsics.checkNotNullParameter(modifier, "$this$paddingFromBaseline");
        return modifier.then(!TextUnitKt.isUnspecified--R2X_6o(j2) ? m267paddingFromY_r0B1c$default(modifier, androidx.compose.ui.layout.AlignmentLineKt.getLastBaseline(), 0L, j2, 2, null) : Modifier.Companion).then(!TextUnitKt.isUnspecified--R2X_6o(j) ? m267paddingFromY_r0B1c$default(modifier, androidx.compose.ui.layout.AlignmentLineKt.getFirstBaseline(), j, 0L, 4, null) : Modifier.Companion);
    }

    /* renamed from: paddingFromBaseline-wCyjxdI$default, reason: not valid java name */
    public static /* synthetic */ Modifier m271paddingFromBaselinewCyjxdI$default(Modifier modifier, long j, long j2, int i, Object obj) {
        if ((i & 1) != 0) {
            j = TextUnit.Companion.getUnspecified-XSAIIZE();
        }
        if ((i & 2) != 0) {
            j2 = TextUnit.Companion.getUnspecified-XSAIIZE();
        }
        return m270paddingFromBaselinewCyjxdI(modifier, j, j2);
    }
}
