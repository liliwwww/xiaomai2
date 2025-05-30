package androidx.compose.p004ui.node;

import androidx.compose.p004ui.ExperimentalComposeUiApi;
import androidx.compose.p004ui.graphics.GraphicsLayerScope;
import androidx.compose.p004ui.layout.AlignmentLine;
import androidx.compose.p004ui.layout.IntrinsicMeasurable;
import androidx.compose.p004ui.layout.IntrinsicMeasureScope;
import androidx.compose.p004ui.layout.IntrinsicsMeasureScope;
import androidx.compose.p004ui.layout.Measurable;
import androidx.compose.p004ui.layout.Placeable;
import androidx.compose.p004ui.unit.Constraints;
import androidx.compose.p004ui.unit.ConstraintsKt;
import androidx.compose.p004ui.unit.IntSizeKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@ExperimentalComposeUiApi
/* loaded from: classes.dex */
final class NodeMeasuringIntrinsics {

    @NotNull
    public static final NodeMeasuringIntrinsics INSTANCE = new NodeMeasuringIntrinsics();

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    private static final class DefaultIntrinsicMeasurable implements Measurable {

        @NotNull
        private final IntrinsicMeasurable measurable;

        @NotNull
        private final IntrinsicMinMax minMax;

        @NotNull
        private final IntrinsicWidthHeight widthHeight;

        public DefaultIntrinsicMeasurable(@NotNull IntrinsicMeasurable intrinsicMeasurable, @NotNull IntrinsicMinMax intrinsicMinMax, @NotNull IntrinsicWidthHeight intrinsicWidthHeight) {
            Intrinsics.checkNotNullParameter(intrinsicMeasurable, "measurable");
            Intrinsics.checkNotNullParameter(intrinsicMinMax, "minMax");
            Intrinsics.checkNotNullParameter(intrinsicWidthHeight, "widthHeight");
            this.measurable = intrinsicMeasurable;
            this.minMax = intrinsicMinMax;
            this.widthHeight = intrinsicWidthHeight;
        }

        @NotNull
        public final IntrinsicMeasurable getMeasurable() {
            return this.measurable;
        }

        @NotNull
        public final IntrinsicMinMax getMinMax() {
            return this.minMax;
        }

        @Override // androidx.compose.p004ui.layout.IntrinsicMeasurable
        @Nullable
        public Object getParentData() {
            return this.measurable.getParentData();
        }

        @NotNull
        public final IntrinsicWidthHeight getWidthHeight() {
            return this.widthHeight;
        }

        @Override // androidx.compose.p004ui.layout.IntrinsicMeasurable
        public int maxIntrinsicHeight(int i) {
            return this.measurable.maxIntrinsicHeight(i);
        }

        @Override // androidx.compose.p004ui.layout.IntrinsicMeasurable
        public int maxIntrinsicWidth(int i) {
            return this.measurable.maxIntrinsicWidth(i);
        }

        @Override // androidx.compose.p004ui.layout.Measurable
        @NotNull
        /* renamed from: measure-BRTryo0 */
        public Placeable mo4187measureBRTryo0(long j) {
            if (this.widthHeight == IntrinsicWidthHeight.Width) {
                return new EmptyPlaceable(this.minMax == IntrinsicMinMax.Max ? this.measurable.maxIntrinsicWidth(Constraints.m5183getMaxHeightimpl(j)) : this.measurable.minIntrinsicWidth(Constraints.m5183getMaxHeightimpl(j)), Constraints.m5183getMaxHeightimpl(j));
            }
            return new EmptyPlaceable(Constraints.m5184getMaxWidthimpl(j), this.minMax == IntrinsicMinMax.Max ? this.measurable.maxIntrinsicHeight(Constraints.m5184getMaxWidthimpl(j)) : this.measurable.minIntrinsicHeight(Constraints.m5184getMaxWidthimpl(j)));
        }

        @Override // androidx.compose.p004ui.layout.IntrinsicMeasurable
        public int minIntrinsicHeight(int i) {
            return this.measurable.minIntrinsicHeight(i);
        }

        @Override // androidx.compose.p004ui.layout.IntrinsicMeasurable
        public int minIntrinsicWidth(int i) {
            return this.measurable.minIntrinsicWidth(i);
        }
    }

    /* compiled from: Taobao */
    private static final class EmptyPlaceable extends Placeable {
        public EmptyPlaceable(int i, int i2) {
            m4221setMeasuredSizeozmzZPI(IntSizeKt.IntSize(i, i2));
        }

        @Override // androidx.compose.p004ui.layout.Measured
        public int get(@NotNull AlignmentLine alignmentLine) {
            Intrinsics.checkNotNullParameter(alignmentLine, "alignmentLine");
            return Integer.MIN_VALUE;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // androidx.compose.p004ui.layout.Placeable
        /* renamed from: placeAt-f8xVGno */
        public void mo4188placeAtf8xVGno(long j, float f, @Nullable Function1<? super GraphicsLayerScope, Unit> function1) {
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    private enum IntrinsicMinMax {
        Min,
        Max
    }

    /* compiled from: Taobao */
    private enum IntrinsicWidthHeight {
        Width,
        Height
    }

    private NodeMeasuringIntrinsics() {
    }

    public final int maxHeight$ui_release(@NotNull LayoutModifierNode layoutModifierNode, @NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull IntrinsicMeasurable intrinsicMeasurable, int i) {
        Intrinsics.checkNotNullParameter(layoutModifierNode, "node");
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "instrinsicMeasureScope");
        Intrinsics.checkNotNullParameter(intrinsicMeasurable, "intrinsicMeasurable");
        return layoutModifierNode.mo4264measure3p2s80s(new IntrinsicsMeasureScope(intrinsicMeasureScope, intrinsicMeasureScope.getLayoutDirection()), new DefaultIntrinsicMeasurable(intrinsicMeasurable, IntrinsicMinMax.Max, IntrinsicWidthHeight.Height), ConstraintsKt.Constraints$default(0, i, 0, 0, 13, null)).getHeight();
    }

    public final int maxWidth$ui_release(@NotNull LayoutModifierNode layoutModifierNode, @NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull IntrinsicMeasurable intrinsicMeasurable, int i) {
        Intrinsics.checkNotNullParameter(layoutModifierNode, "node");
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "instrinsicMeasureScope");
        Intrinsics.checkNotNullParameter(intrinsicMeasurable, "intrinsicMeasurable");
        return layoutModifierNode.mo4264measure3p2s80s(new IntrinsicsMeasureScope(intrinsicMeasureScope, intrinsicMeasureScope.getLayoutDirection()), new DefaultIntrinsicMeasurable(intrinsicMeasurable, IntrinsicMinMax.Max, IntrinsicWidthHeight.Width), ConstraintsKt.Constraints$default(0, 0, 0, i, 7, null)).getWidth();
    }

    public final int minHeight$ui_release(@NotNull LayoutModifierNode layoutModifierNode, @NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull IntrinsicMeasurable intrinsicMeasurable, int i) {
        Intrinsics.checkNotNullParameter(layoutModifierNode, "node");
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "instrinsicMeasureScope");
        Intrinsics.checkNotNullParameter(intrinsicMeasurable, "intrinsicMeasurable");
        return layoutModifierNode.mo4264measure3p2s80s(new IntrinsicsMeasureScope(intrinsicMeasureScope, intrinsicMeasureScope.getLayoutDirection()), new DefaultIntrinsicMeasurable(intrinsicMeasurable, IntrinsicMinMax.Min, IntrinsicWidthHeight.Height), ConstraintsKt.Constraints$default(0, i, 0, 0, 13, null)).getHeight();
    }

    public final int minWidth$ui_release(@NotNull LayoutModifierNode layoutModifierNode, @NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull IntrinsicMeasurable intrinsicMeasurable, int i) {
        Intrinsics.checkNotNullParameter(layoutModifierNode, "node");
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "instrinsicMeasureScope");
        Intrinsics.checkNotNullParameter(intrinsicMeasurable, "intrinsicMeasurable");
        return layoutModifierNode.mo4264measure3p2s80s(new IntrinsicsMeasureScope(intrinsicMeasureScope, intrinsicMeasureScope.getLayoutDirection()), new DefaultIntrinsicMeasurable(intrinsicMeasurable, IntrinsicMinMax.Min, IntrinsicWidthHeight.Width), ConstraintsKt.Constraints$default(0, 0, 0, i, 7, null)).getWidth();
    }
}
