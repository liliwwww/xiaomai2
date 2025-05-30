package androidx.compose.ui.layout;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.node.LookaheadDelegate;
import androidx.compose.ui.node.NodeCoordinator;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class LookaheadLayoutCoordinatesImpl implements LookaheadLayoutCoordinates {

    @NotNull
    private final LookaheadDelegate lookaheadDelegate;

    public LookaheadLayoutCoordinatesImpl(@NotNull LookaheadDelegate lookaheadDelegate) {
        Intrinsics.checkNotNullParameter(lookaheadDelegate, "lookaheadDelegate");
        this.lookaheadDelegate = lookaheadDelegate;
    }

    public int get(@NotNull AlignmentLine alignmentLine) {
        Intrinsics.checkNotNullParameter(alignmentLine, "alignmentLine");
        return getCoordinator().get(alignmentLine);
    }

    @NotNull
    public final NodeCoordinator getCoordinator() {
        return this.lookaheadDelegate.getCoordinator();
    }

    @NotNull
    public final LookaheadDelegate getLookaheadDelegate() {
        return this.lookaheadDelegate;
    }

    @Nullable
    public LayoutCoordinates getParentCoordinates() {
        return getCoordinator().getParentCoordinates();
    }

    @Nullable
    public LayoutCoordinates getParentLayoutCoordinates() {
        return getCoordinator().getParentLayoutCoordinates();
    }

    @NotNull
    public Set<AlignmentLine> getProvidedAlignmentLines() {
        return getCoordinator().getProvidedAlignmentLines();
    }

    /* renamed from: getSize-YbymL2g, reason: not valid java name */
    public long m2057getSizeYbymL2g() {
        return getCoordinator().getSize-YbymL2g();
    }

    public boolean isAttached() {
        return getCoordinator().isAttached();
    }

    @NotNull
    public Rect localBoundingBoxOf(@NotNull LayoutCoordinates layoutCoordinates, boolean z) {
        Intrinsics.checkNotNullParameter(layoutCoordinates, "sourceCoordinates");
        return getCoordinator().localBoundingBoxOf(layoutCoordinates, z);
    }

    /* renamed from: localLookaheadPositionOf-R5De75A, reason: not valid java name */
    public long m2058localLookaheadPositionOfR5De75A(@NotNull LookaheadLayoutCoordinates lookaheadLayoutCoordinates, long j) {
        Intrinsics.checkNotNullParameter(lookaheadLayoutCoordinates, "sourceCoordinates");
        LookaheadDelegate lookaheadDelegate = ((LookaheadLayoutCoordinatesImpl) lookaheadLayoutCoordinates).lookaheadDelegate;
        LookaheadDelegate lookaheadDelegate$ui_release = getCoordinator().findCommonAncestor$ui_release(lookaheadDelegate.getCoordinator()).getLookaheadDelegate$ui_release();
        if (lookaheadDelegate$ui_release != null) {
            long m2162positionInBjo55l4$ui_release = lookaheadDelegate.m2162positionInBjo55l4$ui_release(lookaheadDelegate$ui_release);
            long IntOffset = IntOffsetKt.IntOffset(MathKt.roundToInt(Offset.getX-impl(j)), MathKt.roundToInt(Offset.getY-impl(j)));
            long IntOffset2 = IntOffsetKt.IntOffset(IntOffset.m2643getXimpl(m2162positionInBjo55l4$ui_release) + IntOffset.m2643getXimpl(IntOffset), IntOffset.m2644getYimpl(m2162positionInBjo55l4$ui_release) + IntOffset.m2644getYimpl(IntOffset));
            long m2162positionInBjo55l4$ui_release2 = this.lookaheadDelegate.m2162positionInBjo55l4$ui_release(lookaheadDelegate$ui_release);
            long IntOffset3 = IntOffsetKt.IntOffset(IntOffset.m2643getXimpl(IntOffset2) - IntOffset.m2643getXimpl(m2162positionInBjo55l4$ui_release2), IntOffset.m2644getYimpl(IntOffset2) - IntOffset.m2644getYimpl(m2162positionInBjo55l4$ui_release2));
            return OffsetKt.Offset(IntOffset.m2643getXimpl(IntOffset3), IntOffset.m2644getYimpl(IntOffset3));
        }
        LookaheadDelegate access$getRootLookaheadDelegate = LookaheadLayoutCoordinatesKt.access$getRootLookaheadDelegate(lookaheadDelegate);
        long m2162positionInBjo55l4$ui_release3 = lookaheadDelegate.m2162positionInBjo55l4$ui_release(access$getRootLookaheadDelegate);
        long m2159getPositionnOccac = access$getRootLookaheadDelegate.m2159getPositionnOccac();
        long IntOffset4 = IntOffsetKt.IntOffset(IntOffset.m2643getXimpl(m2162positionInBjo55l4$ui_release3) + IntOffset.m2643getXimpl(m2159getPositionnOccac), IntOffset.m2644getYimpl(m2162positionInBjo55l4$ui_release3) + IntOffset.m2644getYimpl(m2159getPositionnOccac));
        long IntOffset5 = IntOffsetKt.IntOffset(MathKt.roundToInt(Offset.getX-impl(j)), MathKt.roundToInt(Offset.getY-impl(j)));
        long IntOffset6 = IntOffsetKt.IntOffset(IntOffset.m2643getXimpl(IntOffset4) + IntOffset.m2643getXimpl(IntOffset5), IntOffset.m2644getYimpl(IntOffset4) + IntOffset.m2644getYimpl(IntOffset5));
        LookaheadDelegate lookaheadDelegate2 = this.lookaheadDelegate;
        long m2162positionInBjo55l4$ui_release4 = lookaheadDelegate2.m2162positionInBjo55l4$ui_release(LookaheadLayoutCoordinatesKt.access$getRootLookaheadDelegate(lookaheadDelegate2));
        long m2159getPositionnOccac2 = LookaheadLayoutCoordinatesKt.access$getRootLookaheadDelegate(lookaheadDelegate2).m2159getPositionnOccac();
        long IntOffset7 = IntOffsetKt.IntOffset(IntOffset.m2643getXimpl(m2162positionInBjo55l4$ui_release4) + IntOffset.m2643getXimpl(m2159getPositionnOccac2), IntOffset.m2644getYimpl(m2162positionInBjo55l4$ui_release4) + IntOffset.m2644getYimpl(m2159getPositionnOccac2));
        long IntOffset8 = IntOffsetKt.IntOffset(IntOffset.m2643getXimpl(IntOffset6) - IntOffset.m2643getXimpl(IntOffset7), IntOffset.m2644getYimpl(IntOffset6) - IntOffset.m2644getYimpl(IntOffset7));
        NodeCoordinator wrappedBy$ui_release = LookaheadLayoutCoordinatesKt.access$getRootLookaheadDelegate(this.lookaheadDelegate).getCoordinator().getWrappedBy$ui_release();
        Intrinsics.checkNotNull(wrappedBy$ui_release);
        NodeCoordinator wrappedBy$ui_release2 = access$getRootLookaheadDelegate.getCoordinator().getWrappedBy$ui_release();
        Intrinsics.checkNotNull(wrappedBy$ui_release2);
        return wrappedBy$ui_release.localPositionOf-R5De75A(wrappedBy$ui_release2, OffsetKt.Offset(IntOffset.m2643getXimpl(IntOffset8), IntOffset.m2644getYimpl(IntOffset8)));
    }

    /* renamed from: localPositionOf-R5De75A, reason: not valid java name */
    public long m2059localPositionOfR5De75A(@NotNull LayoutCoordinates layoutCoordinates, long j) {
        Intrinsics.checkNotNullParameter(layoutCoordinates, "sourceCoordinates");
        return getCoordinator().localPositionOf-R5De75A(layoutCoordinates, j);
    }

    /* renamed from: localToRoot-MK-Hz9U, reason: not valid java name */
    public long m2060localToRootMKHz9U(long j) {
        return getCoordinator().localToRoot-MK-Hz9U(j);
    }

    /* renamed from: localToWindow-MK-Hz9U, reason: not valid java name */
    public long m2061localToWindowMKHz9U(long j) {
        return getCoordinator().localToWindow-MK-Hz9U(j);
    }

    /* renamed from: transformFrom-EL8BTi8, reason: not valid java name */
    public void m2062transformFromEL8BTi8(@NotNull LayoutCoordinates layoutCoordinates, @NotNull float[] fArr) {
        Intrinsics.checkNotNullParameter(layoutCoordinates, "sourceCoordinates");
        Intrinsics.checkNotNullParameter(fArr, "matrix");
        getCoordinator().transformFrom-EL8BTi8(layoutCoordinates, fArr);
    }

    /* renamed from: windowToLocal-MK-Hz9U, reason: not valid java name */
    public long m2063windowToLocalMKHz9U(long j) {
        return getCoordinator().windowToLocal-MK-Hz9U(j);
    }
}
