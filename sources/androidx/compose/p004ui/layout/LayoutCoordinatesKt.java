package androidx.compose.p004ui.layout;

import androidx.compose.p004ui.geometry.Offset;
import androidx.compose.p004ui.geometry.OffsetKt;
import androidx.compose.p004ui.geometry.Rect;
import androidx.compose.p004ui.node.NodeCoordinator;
import androidx.compose.p004ui.unit.IntSize;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;
import tb.dd2;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public final class LayoutCoordinatesKt {
    @NotNull
    public static final Rect boundsInParent(@NotNull LayoutCoordinates layoutCoordinates) {
        Rect c;
        Intrinsics.checkNotNullParameter(layoutCoordinates, "<this>");
        LayoutCoordinates parentLayoutCoordinates = layoutCoordinates.getParentLayoutCoordinates();
        return (parentLayoutCoordinates == null || (c = dd2.c(parentLayoutCoordinates, layoutCoordinates, false, 2, (Object) null)) == null) ? new Rect(0.0f, 0.0f, IntSize.m5376getWidthimpl(layoutCoordinates.mo4191getSizeYbymL2g()), IntSize.m5375getHeightimpl(layoutCoordinates.mo4191getSizeYbymL2g())) : c;
    }

    @NotNull
    public static final Rect boundsInRoot(@NotNull LayoutCoordinates layoutCoordinates) {
        Intrinsics.checkNotNullParameter(layoutCoordinates, "<this>");
        return dd2.c(findRootCoordinates(layoutCoordinates), layoutCoordinates, false, 2, (Object) null);
    }

    @NotNull
    public static final Rect boundsInWindow(@NotNull LayoutCoordinates layoutCoordinates) {
        Intrinsics.checkNotNullParameter(layoutCoordinates, "<this>");
        LayoutCoordinates findRootCoordinates = findRootCoordinates(layoutCoordinates);
        Rect boundsInRoot = boundsInRoot(layoutCoordinates);
        float m5376getWidthimpl = IntSize.m5376getWidthimpl(findRootCoordinates.mo4191getSizeYbymL2g());
        float m5375getHeightimpl = IntSize.m5375getHeightimpl(findRootCoordinates.mo4191getSizeYbymL2g());
        float coerceIn = RangesKt.coerceIn(boundsInRoot.getLeft(), 0.0f, m5376getWidthimpl);
        float coerceIn2 = RangesKt.coerceIn(boundsInRoot.getTop(), 0.0f, m5375getHeightimpl);
        float coerceIn3 = RangesKt.coerceIn(boundsInRoot.getRight(), 0.0f, m5376getWidthimpl);
        float coerceIn4 = RangesKt.coerceIn(boundsInRoot.getBottom(), 0.0f, m5375getHeightimpl);
        if (!(coerceIn == coerceIn3)) {
            if (!(coerceIn2 == coerceIn4)) {
                long mo4194localToWindowMKHz9U = findRootCoordinates.mo4194localToWindowMKHz9U(OffsetKt.Offset(coerceIn, coerceIn2));
                long mo4194localToWindowMKHz9U2 = findRootCoordinates.mo4194localToWindowMKHz9U(OffsetKt.Offset(coerceIn3, coerceIn2));
                long mo4194localToWindowMKHz9U3 = findRootCoordinates.mo4194localToWindowMKHz9U(OffsetKt.Offset(coerceIn3, coerceIn4));
                long mo4194localToWindowMKHz9U4 = findRootCoordinates.mo4194localToWindowMKHz9U(OffsetKt.Offset(coerceIn, coerceIn4));
                return new Rect(ComparisonsKt.minOf(Offset.m2556getXimpl(mo4194localToWindowMKHz9U), new float[]{Offset.m2556getXimpl(mo4194localToWindowMKHz9U2), Offset.m2556getXimpl(mo4194localToWindowMKHz9U4), Offset.m2556getXimpl(mo4194localToWindowMKHz9U3)}), ComparisonsKt.minOf(Offset.m2557getYimpl(mo4194localToWindowMKHz9U), new float[]{Offset.m2557getYimpl(mo4194localToWindowMKHz9U2), Offset.m2557getYimpl(mo4194localToWindowMKHz9U4), Offset.m2557getYimpl(mo4194localToWindowMKHz9U3)}), ComparisonsKt.maxOf(Offset.m2556getXimpl(mo4194localToWindowMKHz9U), new float[]{Offset.m2556getXimpl(mo4194localToWindowMKHz9U2), Offset.m2556getXimpl(mo4194localToWindowMKHz9U4), Offset.m2556getXimpl(mo4194localToWindowMKHz9U3)}), ComparisonsKt.maxOf(Offset.m2557getYimpl(mo4194localToWindowMKHz9U), new float[]{Offset.m2557getYimpl(mo4194localToWindowMKHz9U2), Offset.m2557getYimpl(mo4194localToWindowMKHz9U4), Offset.m2557getYimpl(mo4194localToWindowMKHz9U3)}));
            }
        }
        return Rect.Companion.getZero();
    }

    @NotNull
    public static final LayoutCoordinates findRootCoordinates(@NotNull LayoutCoordinates layoutCoordinates) {
        LayoutCoordinates layoutCoordinates2;
        Intrinsics.checkNotNullParameter(layoutCoordinates, "<this>");
        LayoutCoordinates parentLayoutCoordinates = layoutCoordinates.getParentLayoutCoordinates();
        while (true) {
            LayoutCoordinates layoutCoordinates3 = parentLayoutCoordinates;
            layoutCoordinates2 = layoutCoordinates;
            layoutCoordinates = layoutCoordinates3;
            if (layoutCoordinates == null) {
                break;
            }
            parentLayoutCoordinates = layoutCoordinates.getParentLayoutCoordinates();
        }
        NodeCoordinator nodeCoordinator = layoutCoordinates2 instanceof NodeCoordinator ? (NodeCoordinator) layoutCoordinates2 : null;
        if (nodeCoordinator == null) {
            return layoutCoordinates2;
        }
        NodeCoordinator wrappedBy$ui_release = nodeCoordinator.getWrappedBy$ui_release();
        while (true) {
            NodeCoordinator nodeCoordinator2 = wrappedBy$ui_release;
            NodeCoordinator nodeCoordinator3 = nodeCoordinator;
            nodeCoordinator = nodeCoordinator2;
            if (nodeCoordinator == null) {
                return nodeCoordinator3;
            }
            wrappedBy$ui_release = nodeCoordinator.getWrappedBy$ui_release();
        }
    }

    public static final long positionInParent(@NotNull LayoutCoordinates layoutCoordinates) {
        Intrinsics.checkNotNullParameter(layoutCoordinates, "<this>");
        LayoutCoordinates parentLayoutCoordinates = layoutCoordinates.getParentLayoutCoordinates();
        return parentLayoutCoordinates != null ? parentLayoutCoordinates.mo4192localPositionOfR5De75A(layoutCoordinates, Offset.Companion.m2572getZeroF1C5BW0()) : Offset.Companion.m2572getZeroF1C5BW0();
    }

    public static final long positionInRoot(@NotNull LayoutCoordinates layoutCoordinates) {
        Intrinsics.checkNotNullParameter(layoutCoordinates, "<this>");
        return layoutCoordinates.mo4193localToRootMKHz9U(Offset.Companion.m2572getZeroF1C5BW0());
    }

    public static final long positionInWindow(@NotNull LayoutCoordinates layoutCoordinates) {
        Intrinsics.checkNotNullParameter(layoutCoordinates, "<this>");
        return layoutCoordinates.mo4194localToWindowMKHz9U(Offset.Companion.m2572getZeroF1C5BW0());
    }
}
