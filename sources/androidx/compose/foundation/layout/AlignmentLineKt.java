package androidx.compose.foundation.layout;

import androidx.compose.p004ui.Modifier;
import androidx.compose.p004ui.layout.AlignmentLine;
import androidx.compose.p004ui.layout.HorizontalAlignmentLine;
import androidx.compose.p004ui.layout.Measurable;
import androidx.compose.p004ui.layout.MeasureResult;
import androidx.compose.p004ui.layout.MeasureScope;
import androidx.compose.p004ui.layout.Placeable;
import androidx.compose.p004ui.platform.InspectableValueKt;
import androidx.compose.p004ui.platform.InspectorInfo;
import androidx.compose.p004ui.unit.C0856Dp;
import androidx.compose.p004ui.unit.Constraints;
import androidx.compose.p004ui.unit.TextUnit;
import androidx.compose.p004ui.unit.TextUnitKt;
import androidx.compose.runtime.Stable;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public final class AlignmentLineKt {
    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: alignmentLineOffsetMeasure-tjqqzMA, reason: not valid java name */
    public static final MeasureResult m1318alignmentLineOffsetMeasuretjqqzMA(MeasureScope measureScope, final AlignmentLine alignmentLine, final float f, float f2, Measurable measurable, long j) {
        final Placeable mo4187measureBRTryo0 = measurable.mo4187measureBRTryo0(getHorizontal(alignmentLine) ? Constraints.m5175copyZbe2FdA$default(j, 0, 0, 0, 0, 11, null) : Constraints.m5175copyZbe2FdA$default(j, 0, 0, 0, 0, 14, null));
        int i = mo4187measureBRTryo0.get(alignmentLine);
        if (i == Integer.MIN_VALUE) {
            i = 0;
        }
        int height = getHorizontal(alignmentLine) ? mo4187measureBRTryo0.getHeight() : mo4187measureBRTryo0.getWidth();
        int m5183getMaxHeightimpl = getHorizontal(alignmentLine) ? Constraints.m5183getMaxHeightimpl(j) : Constraints.m5184getMaxWidthimpl(j);
        C0856Dp.Companion companion = C0856Dp.Companion;
        int i2 = m5183getMaxHeightimpl - height;
        final int coerceIn = RangesKt.coerceIn((!C0856Dp.m5221equalsimpl0(f, companion.m5236getUnspecifiedD9Ej5fM()) ? measureScope.mo1277roundToPx0680j_4(f) : 0) - i, 0, i2);
        final int coerceIn2 = RangesKt.coerceIn(((!C0856Dp.m5221equalsimpl0(f2, companion.m5236getUnspecifiedD9Ej5fM()) ? measureScope.mo1277roundToPx0680j_4(f2) : 0) - height) + i, 0, i2 - coerceIn);
        final int width = getHorizontal(alignmentLine) ? mo4187measureBRTryo0.getWidth() : Math.max(mo4187measureBRTryo0.getWidth() + coerceIn + coerceIn2, Constraints.m5186getMinWidthimpl(j));
        final int max = getHorizontal(alignmentLine) ? Math.max(mo4187measureBRTryo0.getHeight() + coerceIn + coerceIn2, Constraints.m5185getMinHeightimpl(j)) : mo4187measureBRTryo0.getHeight();
        return MeasureScope.CC.m140p(measureScope, width, max, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.layout.AlignmentLineKt$alignmentLineOffsetMeasure$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Placeable.PlacementScope) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull Placeable.PlacementScope placementScope) {
                boolean horizontal;
                int width2;
                boolean horizontal2;
                int height2;
                Intrinsics.checkNotNullParameter(placementScope, "$this$layout");
                horizontal = AlignmentLineKt.getHorizontal(AlignmentLine.this);
                if (horizontal) {
                    width2 = 0;
                } else {
                    width2 = !C0856Dp.m5221equalsimpl0(f, C0856Dp.Companion.m5236getUnspecifiedD9Ej5fM()) ? coerceIn : (width - coerceIn2) - mo4187measureBRTryo0.getWidth();
                }
                horizontal2 = AlignmentLineKt.getHorizontal(AlignmentLine.this);
                if (horizontal2) {
                    height2 = !C0856Dp.m5221equalsimpl0(f, C0856Dp.Companion.m5236getUnspecifiedD9Ej5fM()) ? coerceIn : (max - coerceIn2) - mo4187measureBRTryo0.getHeight();
                } else {
                    height2 = 0;
                }
                Placeable.PlacementScope.placeRelative$default(placementScope, mo4187measureBRTryo0, width2, height2, 0.0f, 4, null);
            }
        }, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean getHorizontal(AlignmentLine alignmentLine) {
        return alignmentLine instanceof HorizontalAlignmentLine;
    }

    @Stable
    @NotNull
    /* renamed from: paddingFrom-4j6BHR0, reason: not valid java name */
    public static final Modifier m1319paddingFrom4j6BHR0(@NotNull Modifier modifier, @NotNull final AlignmentLine alignmentLine, final float f, final float f2) {
        Intrinsics.checkNotNullParameter(modifier, "$this$paddingFrom");
        Intrinsics.checkNotNullParameter(alignmentLine, "alignmentLine");
        return modifier.then(new AlignmentLineOffsetDp(alignmentLine, f, f2, InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.foundation.layout.AlignmentLineKt$paddingFrom-4j6BHR0$$inlined$debugInspectorInfo$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((InspectorInfo) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull InspectorInfo inspectorInfo) {
                Intrinsics.checkNotNullParameter(inspectorInfo, "$this$null");
                inspectorInfo.setName("paddingFrom");
                inspectorInfo.getProperties().set("alignmentLine", AlignmentLine.this);
                inspectorInfo.getProperties().set("before", C0856Dp.m5214boximpl(f));
                inspectorInfo.getProperties().set("after", C0856Dp.m5214boximpl(f2));
            }
        } : InspectableValueKt.getNoInspectorInfo(), null));
    }

    /* renamed from: paddingFrom-4j6BHR0$default, reason: not valid java name */
    public static /* synthetic */ Modifier m1320paddingFrom4j6BHR0$default(Modifier modifier, AlignmentLine alignmentLine, float f, float f2, int i, Object obj) {
        if ((i & 2) != 0) {
            f = C0856Dp.Companion.m5236getUnspecifiedD9Ej5fM();
        }
        if ((i & 4) != 0) {
            f2 = C0856Dp.Companion.m5236getUnspecifiedD9Ej5fM();
        }
        return m1319paddingFrom4j6BHR0(modifier, alignmentLine, f, f2);
    }

    @Stable
    @NotNull
    /* renamed from: paddingFrom-Y_r0B1c, reason: not valid java name */
    public static final Modifier m1321paddingFromY_r0B1c(@NotNull Modifier modifier, @NotNull final AlignmentLine alignmentLine, final long j, final long j2) {
        Intrinsics.checkNotNullParameter(modifier, "$this$paddingFrom");
        Intrinsics.checkNotNullParameter(alignmentLine, "alignmentLine");
        return modifier.then(new AlignmentLineOffsetTextUnit(alignmentLine, j, j2, InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.foundation.layout.AlignmentLineKt$paddingFrom-Y_r0B1c$$inlined$debugInspectorInfo$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((InspectorInfo) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull InspectorInfo inspectorInfo) {
                Intrinsics.checkNotNullParameter(inspectorInfo, "$this$null");
                inspectorInfo.setName("paddingFrom");
                inspectorInfo.getProperties().set("alignmentLine", AlignmentLine.this);
                inspectorInfo.getProperties().set("before", TextUnit.m5387boximpl(j));
                inspectorInfo.getProperties().set("after", TextUnit.m5387boximpl(j2));
            }
        } : InspectableValueKt.getNoInspectorInfo(), null));
    }

    /* renamed from: paddingFrom-Y_r0B1c$default, reason: not valid java name */
    public static /* synthetic */ Modifier m1322paddingFromY_r0B1c$default(Modifier modifier, AlignmentLine alignmentLine, long j, long j2, int i, Object obj) {
        if ((i & 2) != 0) {
            j = TextUnit.Companion.m5408getUnspecifiedXSAIIZE();
        }
        long j3 = j;
        if ((i & 4) != 0) {
            j2 = TextUnit.Companion.m5408getUnspecifiedXSAIIZE();
        }
        return m1321paddingFromY_r0B1c(modifier, alignmentLine, j3, j2);
    }

    @Stable
    @NotNull
    /* renamed from: paddingFromBaseline-VpY3zN4, reason: not valid java name */
    public static final Modifier m1323paddingFromBaselineVpY3zN4(@NotNull Modifier modifier, float f, float f2) {
        Intrinsics.checkNotNullParameter(modifier, "$this$paddingFromBaseline");
        C0856Dp.Companion companion = C0856Dp.Companion;
        return modifier.then(!C0856Dp.m5221equalsimpl0(f2, companion.m5236getUnspecifiedD9Ej5fM()) ? m1320paddingFrom4j6BHR0$default(modifier, androidx.compose.p004ui.layout.AlignmentLineKt.getLastBaseline(), 0.0f, f2, 2, null) : Modifier.Companion).then(!C0856Dp.m5221equalsimpl0(f, companion.m5236getUnspecifiedD9Ej5fM()) ? m1320paddingFrom4j6BHR0$default(modifier, androidx.compose.p004ui.layout.AlignmentLineKt.getFirstBaseline(), f, 0.0f, 4, null) : Modifier.Companion);
    }

    /* renamed from: paddingFromBaseline-VpY3zN4$default, reason: not valid java name */
    public static /* synthetic */ Modifier m1324paddingFromBaselineVpY3zN4$default(Modifier modifier, float f, float f2, int i, Object obj) {
        if ((i & 1) != 0) {
            f = C0856Dp.Companion.m5236getUnspecifiedD9Ej5fM();
        }
        if ((i & 2) != 0) {
            f2 = C0856Dp.Companion.m5236getUnspecifiedD9Ej5fM();
        }
        return m1323paddingFromBaselineVpY3zN4(modifier, f, f2);
    }

    @Stable
    @NotNull
    /* renamed from: paddingFromBaseline-wCyjxdI, reason: not valid java name */
    public static final Modifier m1325paddingFromBaselinewCyjxdI(@NotNull Modifier modifier, long j, long j2) {
        Intrinsics.checkNotNullParameter(modifier, "$this$paddingFromBaseline");
        return modifier.then(!TextUnitKt.m5415isUnspecifiedR2X_6o(j2) ? m1322paddingFromY_r0B1c$default(modifier, androidx.compose.p004ui.layout.AlignmentLineKt.getLastBaseline(), 0L, j2, 2, null) : Modifier.Companion).then(!TextUnitKt.m5415isUnspecifiedR2X_6o(j) ? m1322paddingFromY_r0B1c$default(modifier, androidx.compose.p004ui.layout.AlignmentLineKt.getFirstBaseline(), j, 0L, 4, null) : Modifier.Companion);
    }

    /* renamed from: paddingFromBaseline-wCyjxdI$default, reason: not valid java name */
    public static /* synthetic */ Modifier m1326paddingFromBaselinewCyjxdI$default(Modifier modifier, long j, long j2, int i, Object obj) {
        if ((i & 1) != 0) {
            j = TextUnit.Companion.m5408getUnspecifiedXSAIIZE();
        }
        if ((i & 2) != 0) {
            j2 = TextUnit.Companion.m5408getUnspecifiedXSAIIZE();
        }
        return m1325paddingFromBaselinewCyjxdI(modifier, j, j2);
    }
}
