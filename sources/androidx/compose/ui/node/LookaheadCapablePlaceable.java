package androidx.compose.ui.node;

import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.VerticalAlignmentLine;
import androidx.compose.ui.unit.DpRect;
import androidx.compose.ui.unit.IntOffset;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.jw0;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public abstract class LookaheadCapablePlaceable extends Placeable implements MeasureScopeWithLayoutNode {
    private boolean isPlacingForAlignment;
    private boolean isShallowPlacing;

    public abstract int calculateAlignmentLine(@NotNull AlignmentLine alignmentLine);

    public final int get(@NotNull AlignmentLine alignmentLine) {
        int calculateAlignmentLine;
        Intrinsics.checkNotNullParameter(alignmentLine, "alignmentLine");
        if (getHasMeasureResult() && (calculateAlignmentLine = calculateAlignmentLine(alignmentLine)) != Integer.MIN_VALUE) {
            return calculateAlignmentLine + (alignmentLine instanceof VerticalAlignmentLine ? IntOffset.getX-impl(m1563getApparentToRealOffsetnOccac()) : IntOffset.getY-impl(m1563getApparentToRealOffsetnOccac()));
        }
        return Integer.MIN_VALUE;
    }

    @NotNull
    public abstract AlignmentLinesOwner getAlignmentLinesOwner();

    @Nullable
    public abstract LookaheadCapablePlaceable getChild();

    @NotNull
    public abstract LayoutCoordinates getCoordinates();

    public abstract boolean getHasMeasureResult();

    @Override // androidx.compose.ui.node.MeasureScopeWithLayoutNode
    @NotNull
    public abstract LayoutNode getLayoutNode();

    @NotNull
    public abstract MeasureResult getMeasureResult$ui_release();

    @Nullable
    public abstract LookaheadCapablePlaceable getParent();

    /* renamed from: getPosition-nOcc-ac, reason: not valid java name */
    public abstract long mo1615getPositionnOccac();

    protected final void invalidateAlignmentLinesFromPositionChange(@NotNull NodeCoordinator nodeCoordinator) {
        AlignmentLines alignmentLines;
        Intrinsics.checkNotNullParameter(nodeCoordinator, "<this>");
        NodeCoordinator wrapped$ui_release = nodeCoordinator.getWrapped$ui_release();
        if (!Intrinsics.areEqual(wrapped$ui_release != null ? wrapped$ui_release.getLayoutNode() : null, nodeCoordinator.getLayoutNode())) {
            nodeCoordinator.getAlignmentLinesOwner().getAlignmentLines().onAlignmentsChanged();
            return;
        }
        AlignmentLinesOwner parentAlignmentLinesOwner = nodeCoordinator.getAlignmentLinesOwner().getParentAlignmentLinesOwner();
        if (parentAlignmentLinesOwner == null || (alignmentLines = parentAlignmentLinesOwner.getAlignmentLines()) == null) {
            return;
        }
        alignmentLines.onAlignmentsChanged();
    }

    public final boolean isPlacingForAlignment$ui_release() {
        return this.isPlacingForAlignment;
    }

    public final boolean isShallowPlacing$ui_release() {
        return this.isShallowPlacing;
    }

    @Override // androidx.compose.ui.layout.MeasureScope
    public /* synthetic */ MeasureResult layout(int i, int i2, Map map, Function1 function1) {
        return MeasureScope.-CC.a(this, i, i2, map, function1);
    }

    public abstract void replace$ui_release();

    @Override // androidx.compose.ui.unit.Density
    /* renamed from: roundToPx--R2X_6o */
    public /* synthetic */ int mo318roundToPxR2X_6o(long j) {
        return jw0.a(this, j);
    }

    @Override // androidx.compose.ui.unit.Density
    /* renamed from: roundToPx-0680j_4 */
    public /* synthetic */ int mo319roundToPx0680j_4(float f) {
        return jw0.b(this, f);
    }

    public final void setPlacingForAlignment$ui_release(boolean z) {
        this.isPlacingForAlignment = z;
    }

    public final void setShallowPlacing$ui_release(boolean z) {
        this.isShallowPlacing = z;
    }

    @Override // androidx.compose.ui.unit.Density
    /* renamed from: toDp-GaN1DYA */
    public /* synthetic */ float mo310toDpGaN1DYA(long j) {
        return jw0.c(this, j);
    }

    @Override // androidx.compose.ui.unit.Density
    /* renamed from: toDp-u2uoSUM */
    public /* synthetic */ float mo311toDpu2uoSUM(float f) {
        return jw0.d(this, f);
    }

    @Override // androidx.compose.ui.unit.Density
    /* renamed from: toDp-u2uoSUM */
    public /* synthetic */ float mo312toDpu2uoSUM(int i) {
        return jw0.e(this, i);
    }

    @Override // androidx.compose.ui.unit.Density
    /* renamed from: toDpSize-k-rfVVM */
    public /* synthetic */ long mo313toDpSizekrfVVM(long j) {
        return jw0.f(this, j);
    }

    @Override // androidx.compose.ui.unit.Density
    /* renamed from: toPx--R2X_6o */
    public /* synthetic */ float mo320toPxR2X_6o(long j) {
        return jw0.g(this, j);
    }

    @Override // androidx.compose.ui.unit.Density
    /* renamed from: toPx-0680j_4 */
    public /* synthetic */ float mo321toPx0680j_4(float f) {
        return jw0.h(this, f);
    }

    @Override // androidx.compose.ui.unit.Density
    public /* synthetic */ Rect toRect(DpRect dpRect) {
        return jw0.i(this, dpRect);
    }

    @Override // androidx.compose.ui.unit.Density
    /* renamed from: toSize-XkaWNTQ */
    public /* synthetic */ long mo314toSizeXkaWNTQ(long j) {
        return jw0.j(this, j);
    }

    @Override // androidx.compose.ui.unit.Density
    /* renamed from: toSp-0xMU5do */
    public /* synthetic */ long mo315toSp0xMU5do(float f) {
        return jw0.k(this, f);
    }

    @Override // androidx.compose.ui.unit.Density
    /* renamed from: toSp-kPz2Gy4 */
    public /* synthetic */ long mo316toSpkPz2Gy4(float f) {
        return jw0.l(this, f);
    }

    @Override // androidx.compose.ui.unit.Density
    /* renamed from: toSp-kPz2Gy4 */
    public /* synthetic */ long mo317toSpkPz2Gy4(int i) {
        return jw0.m(this, i);
    }
}
