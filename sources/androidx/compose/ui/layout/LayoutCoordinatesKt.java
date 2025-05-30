package androidx.compose.ui.layout;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.node.NodeCoordinator;
import androidx.compose.ui.unit.IntSize;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;
import tb.dd2;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class LayoutCoordinatesKt {
    @NotNull
    public static final Rect boundsInParent(@NotNull LayoutCoordinates layoutCoordinates) {
        Rect c;
        Intrinsics.checkNotNullParameter(layoutCoordinates, "<this>");
        LayoutCoordinates parentLayoutCoordinates = layoutCoordinates.getParentLayoutCoordinates();
        return (parentLayoutCoordinates == null || (c = dd2.c(parentLayoutCoordinates, layoutCoordinates, false, 2, (Object) null)) == null) ? new Rect(0.0f, 0.0f, IntSize.m2685getWidthimpl(layoutCoordinates.getSize-YbymL2g()), IntSize.m2684getHeightimpl(layoutCoordinates.getSize-YbymL2g())) : c;
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
        float m2685getWidthimpl = IntSize.m2685getWidthimpl(findRootCoordinates.getSize-YbymL2g());
        float m2684getHeightimpl = IntSize.m2684getHeightimpl(findRootCoordinates.getSize-YbymL2g());
        float coerceIn = RangesKt.coerceIn(boundsInRoot.getLeft(), 0.0f, m2685getWidthimpl);
        float coerceIn2 = RangesKt.coerceIn(boundsInRoot.getTop(), 0.0f, m2684getHeightimpl);
        float coerceIn3 = RangesKt.coerceIn(boundsInRoot.getRight(), 0.0f, m2685getWidthimpl);
        float coerceIn4 = RangesKt.coerceIn(boundsInRoot.getBottom(), 0.0f, m2684getHeightimpl);
        if (!(coerceIn == coerceIn3)) {
            if (!(coerceIn2 == coerceIn4)) {
                long j = findRootCoordinates.localToWindow-MK-Hz9U(OffsetKt.Offset(coerceIn, coerceIn2));
                long j2 = findRootCoordinates.localToWindow-MK-Hz9U(OffsetKt.Offset(coerceIn3, coerceIn2));
                long j3 = findRootCoordinates.localToWindow-MK-Hz9U(OffsetKt.Offset(coerceIn3, coerceIn4));
                long j4 = findRootCoordinates.localToWindow-MK-Hz9U(OffsetKt.Offset(coerceIn, coerceIn4));
                return new Rect(ComparisonsKt.minOf(Offset.getX-impl(j), new float[]{Offset.getX-impl(j2), Offset.getX-impl(j4), Offset.getX-impl(j3)}), ComparisonsKt.minOf(Offset.getY-impl(j), new float[]{Offset.getY-impl(j2), Offset.getY-impl(j4), Offset.getY-impl(j3)}), ComparisonsKt.maxOf(Offset.getX-impl(j), new float[]{Offset.getX-impl(j2), Offset.getX-impl(j4), Offset.getX-impl(j3)}), ComparisonsKt.maxOf(Offset.getY-impl(j), new float[]{Offset.getY-impl(j2), Offset.getY-impl(j4), Offset.getY-impl(j3)}));
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
        return parentLayoutCoordinates != null ? parentLayoutCoordinates.localPositionOf-R5De75A(layoutCoordinates, Offset.Companion.m1024getZeroF1C5BW0()) : Offset.Companion.m1024getZeroF1C5BW0();
    }

    public static final long positionInRoot(@NotNull LayoutCoordinates layoutCoordinates) {
        Intrinsics.checkNotNullParameter(layoutCoordinates, "<this>");
        return layoutCoordinates.localToRoot-MK-Hz9U(Offset.Companion.m1024getZeroF1C5BW0());
    }

    public static final long positionInWindow(@NotNull LayoutCoordinates layoutCoordinates) {
        Intrinsics.checkNotNullParameter(layoutCoordinates, "<this>");
        return layoutCoordinates.localToWindow-MK-Hz9U(Offset.Companion.m1024getZeroF1C5BW0());
    }
}
