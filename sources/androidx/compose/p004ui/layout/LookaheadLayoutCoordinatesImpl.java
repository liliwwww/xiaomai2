package androidx.compose.p004ui.layout;

import androidx.compose.p004ui.geometry.Offset;
import androidx.compose.p004ui.geometry.OffsetKt;
import androidx.compose.p004ui.geometry.Rect;
import androidx.compose.p004ui.node.LookaheadDelegate;
import androidx.compose.p004ui.node.NodeCoordinator;
import androidx.compose.p004ui.unit.IntOffset;
import androidx.compose.p004ui.unit.IntOffsetKt;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public final class LookaheadLayoutCoordinatesImpl implements LookaheadLayoutCoordinates {

    @NotNull
    private final LookaheadDelegate lookaheadDelegate;

    public LookaheadLayoutCoordinatesImpl(@NotNull LookaheadDelegate lookaheadDelegate) {
        Intrinsics.checkNotNullParameter(lookaheadDelegate, "lookaheadDelegate");
        this.lookaheadDelegate = lookaheadDelegate;
    }

    @Override // androidx.compose.p004ui.layout.LayoutCoordinates
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

    @Override // androidx.compose.p004ui.layout.LayoutCoordinates
    @Nullable
    public LayoutCoordinates getParentCoordinates() {
        return getCoordinator().getParentCoordinates();
    }

    @Override // androidx.compose.p004ui.layout.LayoutCoordinates
    @Nullable
    public LayoutCoordinates getParentLayoutCoordinates() {
        return getCoordinator().getParentLayoutCoordinates();
    }

    @Override // androidx.compose.p004ui.layout.LayoutCoordinates
    @NotNull
    public Set<AlignmentLine> getProvidedAlignmentLines() {
        return getCoordinator().getProvidedAlignmentLines();
    }

    @Override // androidx.compose.p004ui.layout.LayoutCoordinates
    /* renamed from: getSize-YbymL2g */
    public long mo4191getSizeYbymL2g() {
        return getCoordinator().mo4191getSizeYbymL2g();
    }

    @Override // androidx.compose.p004ui.layout.LayoutCoordinates
    public boolean isAttached() {
        return getCoordinator().isAttached();
    }

    @Override // androidx.compose.p004ui.layout.LayoutCoordinates
    @NotNull
    public Rect localBoundingBoxOf(@NotNull LayoutCoordinates layoutCoordinates, boolean z) {
        Intrinsics.checkNotNullParameter(layoutCoordinates, "sourceCoordinates");
        return getCoordinator().localBoundingBoxOf(layoutCoordinates, z);
    }

    @Override // androidx.compose.p004ui.layout.LookaheadLayoutCoordinates
    /* renamed from: localLookaheadPositionOf-R5De75A */
    public long mo4200localLookaheadPositionOfR5De75A(@NotNull LookaheadLayoutCoordinates lookaheadLayoutCoordinates, long j) {
        LookaheadDelegate rootLookaheadDelegate;
        LookaheadDelegate rootLookaheadDelegate2;
        LookaheadDelegate rootLookaheadDelegate3;
        LookaheadDelegate rootLookaheadDelegate4;
        Intrinsics.checkNotNullParameter(lookaheadLayoutCoordinates, "sourceCoordinates");
        LookaheadDelegate lookaheadDelegate = ((LookaheadLayoutCoordinatesImpl) lookaheadLayoutCoordinates).lookaheadDelegate;
        LookaheadDelegate lookaheadDelegate$ui_release = getCoordinator().findCommonAncestor$ui_release(lookaheadDelegate.getCoordinator()).getLookaheadDelegate$ui_release();
        if (lookaheadDelegate$ui_release != null) {
            long m4345positionInBjo55l4$ui_release = lookaheadDelegate.m4345positionInBjo55l4$ui_release(lookaheadDelegate$ui_release);
            long IntOffset = IntOffsetKt.IntOffset(MathKt.roundToInt(Offset.m2556getXimpl(j)), MathKt.roundToInt(Offset.m2557getYimpl(j)));
            long IntOffset2 = IntOffsetKt.IntOffset(IntOffset.m5334getXimpl(m4345positionInBjo55l4$ui_release) + IntOffset.m5334getXimpl(IntOffset), IntOffset.m5335getYimpl(m4345positionInBjo55l4$ui_release) + IntOffset.m5335getYimpl(IntOffset));
            long m4345positionInBjo55l4$ui_release2 = this.lookaheadDelegate.m4345positionInBjo55l4$ui_release(lookaheadDelegate$ui_release);
            long IntOffset3 = IntOffsetKt.IntOffset(IntOffset.m5334getXimpl(IntOffset2) - IntOffset.m5334getXimpl(m4345positionInBjo55l4$ui_release2), IntOffset.m5335getYimpl(IntOffset2) - IntOffset.m5335getYimpl(m4345positionInBjo55l4$ui_release2));
            return OffsetKt.Offset(IntOffset.m5334getXimpl(IntOffset3), IntOffset.m5335getYimpl(IntOffset3));
        }
        rootLookaheadDelegate = LookaheadLayoutCoordinatesKt.getRootLookaheadDelegate(lookaheadDelegate);
        long m4345positionInBjo55l4$ui_release3 = lookaheadDelegate.m4345positionInBjo55l4$ui_release(rootLookaheadDelegate);
        long mo4342getPositionnOccac = rootLookaheadDelegate.mo4342getPositionnOccac();
        long IntOffset4 = IntOffsetKt.IntOffset(IntOffset.m5334getXimpl(m4345positionInBjo55l4$ui_release3) + IntOffset.m5334getXimpl(mo4342getPositionnOccac), IntOffset.m5335getYimpl(m4345positionInBjo55l4$ui_release3) + IntOffset.m5335getYimpl(mo4342getPositionnOccac));
        long IntOffset5 = IntOffsetKt.IntOffset(MathKt.roundToInt(Offset.m2556getXimpl(j)), MathKt.roundToInt(Offset.m2557getYimpl(j)));
        long IntOffset6 = IntOffsetKt.IntOffset(IntOffset.m5334getXimpl(IntOffset4) + IntOffset.m5334getXimpl(IntOffset5), IntOffset.m5335getYimpl(IntOffset4) + IntOffset.m5335getYimpl(IntOffset5));
        LookaheadDelegate lookaheadDelegate2 = this.lookaheadDelegate;
        rootLookaheadDelegate2 = LookaheadLayoutCoordinatesKt.getRootLookaheadDelegate(lookaheadDelegate2);
        long m4345positionInBjo55l4$ui_release4 = lookaheadDelegate2.m4345positionInBjo55l4$ui_release(rootLookaheadDelegate2);
        rootLookaheadDelegate3 = LookaheadLayoutCoordinatesKt.getRootLookaheadDelegate(lookaheadDelegate2);
        long mo4342getPositionnOccac2 = rootLookaheadDelegate3.mo4342getPositionnOccac();
        long IntOffset7 = IntOffsetKt.IntOffset(IntOffset.m5334getXimpl(m4345positionInBjo55l4$ui_release4) + IntOffset.m5334getXimpl(mo4342getPositionnOccac2), IntOffset.m5335getYimpl(m4345positionInBjo55l4$ui_release4) + IntOffset.m5335getYimpl(mo4342getPositionnOccac2));
        long IntOffset8 = IntOffsetKt.IntOffset(IntOffset.m5334getXimpl(IntOffset6) - IntOffset.m5334getXimpl(IntOffset7), IntOffset.m5335getYimpl(IntOffset6) - IntOffset.m5335getYimpl(IntOffset7));
        rootLookaheadDelegate4 = LookaheadLayoutCoordinatesKt.getRootLookaheadDelegate(this.lookaheadDelegate);
        NodeCoordinator wrappedBy$ui_release = rootLookaheadDelegate4.getCoordinator().getWrappedBy$ui_release();
        Intrinsics.checkNotNull(wrappedBy$ui_release);
        NodeCoordinator wrappedBy$ui_release2 = rootLookaheadDelegate.getCoordinator().getWrappedBy$ui_release();
        Intrinsics.checkNotNull(wrappedBy$ui_release2);
        return wrappedBy$ui_release.mo4192localPositionOfR5De75A(wrappedBy$ui_release2, OffsetKt.Offset(IntOffset.m5334getXimpl(IntOffset8), IntOffset.m5335getYimpl(IntOffset8)));
    }

    @Override // androidx.compose.p004ui.layout.LayoutCoordinates
    /* renamed from: localPositionOf-R5De75A */
    public long mo4192localPositionOfR5De75A(@NotNull LayoutCoordinates layoutCoordinates, long j) {
        Intrinsics.checkNotNullParameter(layoutCoordinates, "sourceCoordinates");
        return getCoordinator().mo4192localPositionOfR5De75A(layoutCoordinates, j);
    }

    @Override // androidx.compose.p004ui.layout.LayoutCoordinates
    /* renamed from: localToRoot-MK-Hz9U */
    public long mo4193localToRootMKHz9U(long j) {
        return getCoordinator().mo4193localToRootMKHz9U(j);
    }

    @Override // androidx.compose.p004ui.layout.LayoutCoordinates
    /* renamed from: localToWindow-MK-Hz9U */
    public long mo4194localToWindowMKHz9U(long j) {
        return getCoordinator().mo4194localToWindowMKHz9U(j);
    }

    @Override // androidx.compose.p004ui.layout.LayoutCoordinates
    /* renamed from: transformFrom-EL8BTi8 */
    public void mo4195transformFromEL8BTi8(@NotNull LayoutCoordinates layoutCoordinates, @NotNull float[] fArr) {
        Intrinsics.checkNotNullParameter(layoutCoordinates, "sourceCoordinates");
        Intrinsics.checkNotNullParameter(fArr, "matrix");
        getCoordinator().mo4195transformFromEL8BTi8(layoutCoordinates, fArr);
    }

    @Override // androidx.compose.p004ui.layout.LayoutCoordinates
    /* renamed from: windowToLocal-MK-Hz9U */
    public long mo4196windowToLocalMKHz9U(long j) {
        return getCoordinator().mo4196windowToLocalMKHz9U(j);
    }
}
