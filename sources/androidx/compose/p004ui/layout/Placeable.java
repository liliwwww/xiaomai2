package androidx.compose.p004ui.layout;

import androidx.compose.p004ui.ExperimentalComposeUiApi;
import androidx.compose.p004ui.graphics.GraphicsLayerScope;
import androidx.compose.p004ui.node.LayoutNodeLayoutDelegate;
import androidx.compose.p004ui.node.LookaheadCapablePlaceable;
import androidx.compose.p004ui.unit.Constraints;
import androidx.compose.p004ui.unit.IntOffset;
import androidx.compose.p004ui.unit.IntOffsetKt;
import androidx.compose.p004ui.unit.IntSize;
import androidx.compose.p004ui.unit.IntSizeKt;
import androidx.compose.p004ui.unit.LayoutDirection;
import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.pn2;

/* compiled from: Taobao */
@StabilityInferred(parameters = 0)
/* loaded from: classes.dex */
public abstract class Placeable implements Measured {
    public static final int $stable = 8;
    private int height;
    private long measuredSize = IntSizeKt.IntSize(0, 0);
    private long measurementConstraints;
    private int width;

    /* compiled from: Taobao */
    @StabilityInferred(parameters = 0)
    /* loaded from: classes2.dex */
    public static abstract class PlacementScope {
        public static final int $stable = 0;

        @Nullable
        private static LayoutCoordinates _coordinates;

        @Nullable
        private static LayoutNodeLayoutDelegate layoutDelegate;
        private static int parentWidth;

        @NotNull
        public static final Companion Companion = new Companion(null);

        @NotNull
        private static LayoutDirection parentLayoutDirection = LayoutDirection.Ltr;

        /* compiled from: Taobao */
        /* loaded from: classes.dex */
        public static final class Companion extends PlacementScope {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final boolean configureForPlacingForAlignment(LookaheadCapablePlaceable lookaheadCapablePlaceable) {
                boolean z = false;
                if (lookaheadCapablePlaceable == null) {
                    PlacementScope._coordinates = null;
                    PlacementScope.layoutDelegate = null;
                    return false;
                }
                boolean isPlacingForAlignment$ui_release = lookaheadCapablePlaceable.isPlacingForAlignment$ui_release();
                LookaheadCapablePlaceable parent = lookaheadCapablePlaceable.getParent();
                if (parent != null && parent.isPlacingForAlignment$ui_release()) {
                    z = true;
                }
                if (z) {
                    lookaheadCapablePlaceable.setPlacingForAlignment$ui_release(true);
                }
                PlacementScope.layoutDelegate = lookaheadCapablePlaceable.getLayoutNode().getLayoutDelegate$ui_release();
                if (lookaheadCapablePlaceable.isPlacingForAlignment$ui_release() || lookaheadCapablePlaceable.isShallowPlacing$ui_release()) {
                    PlacementScope._coordinates = null;
                } else {
                    PlacementScope._coordinates = lookaheadCapablePlaceable.getCoordinates();
                }
                return isPlacingForAlignment$ui_release;
            }

            @ExperimentalComposeUiApi
            public static /* synthetic */ void getCoordinates$annotations() {
            }

            public final void executeWithRtlMirroringValues(int i, @NotNull LayoutDirection layoutDirection, @Nullable LookaheadCapablePlaceable lookaheadCapablePlaceable, @NotNull Function1<? super PlacementScope, Unit> function1) {
                Intrinsics.checkNotNullParameter(layoutDirection, "parentLayoutDirection");
                Intrinsics.checkNotNullParameter(function1, "block");
                LayoutCoordinates layoutCoordinates = PlacementScope._coordinates;
                Companion companion = PlacementScope.Companion;
                int parentWidth = companion.getParentWidth();
                LayoutDirection parentLayoutDirection = companion.getParentLayoutDirection();
                LayoutNodeLayoutDelegate layoutNodeLayoutDelegate = PlacementScope.layoutDelegate;
                PlacementScope.parentWidth = i;
                PlacementScope.parentLayoutDirection = layoutDirection;
                boolean configureForPlacingForAlignment = configureForPlacingForAlignment(lookaheadCapablePlaceable);
                function1.invoke(this);
                if (lookaheadCapablePlaceable != null) {
                    lookaheadCapablePlaceable.setPlacingForAlignment$ui_release(configureForPlacingForAlignment);
                }
                PlacementScope.parentWidth = parentWidth;
                PlacementScope.parentLayoutDirection = parentLayoutDirection;
                PlacementScope._coordinates = layoutCoordinates;
                PlacementScope.layoutDelegate = layoutNodeLayoutDelegate;
            }

            @Override // androidx.compose.ui.layout.Placeable.PlacementScope
            @Nullable
            public LayoutCoordinates getCoordinates() {
                LayoutNodeLayoutDelegate layoutNodeLayoutDelegate = PlacementScope.layoutDelegate;
                if (layoutNodeLayoutDelegate != null) {
                    layoutNodeLayoutDelegate.setCoordinatesAccessedDuringPlacement(true);
                }
                return PlacementScope._coordinates;
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.compose.ui.layout.Placeable.PlacementScope
            @NotNull
            public LayoutDirection getParentLayoutDirection() {
                return PlacementScope.parentLayoutDirection;
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.compose.ui.layout.Placeable.PlacementScope
            public int getParentWidth() {
                return PlacementScope.parentWidth;
            }
        }

        @ExperimentalComposeUiApi
        public static /* synthetic */ void getCoordinates$annotations() {
        }

        public static /* synthetic */ void place$default(PlacementScope placementScope, Placeable placeable, int i, int i2, float f, int i3, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: place");
            }
            if ((i3 & 4) != 0) {
                f = 0.0f;
            }
            placementScope.place(placeable, i, i2, f);
        }

        /* renamed from: place-70tqf50$default, reason: not valid java name */
        public static /* synthetic */ void m4223place70tqf50$default(PlacementScope placementScope, Placeable placeable, long j, float f, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: place-70tqf50");
            }
            if ((i & 2) != 0) {
                f = 0.0f;
            }
            placementScope.m4227place70tqf50(placeable, j, f);
        }

        public static /* synthetic */ void placeRelative$default(PlacementScope placementScope, Placeable placeable, int i, int i2, float f, int i3, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: placeRelative");
            }
            if ((i3 & 4) != 0) {
                f = 0.0f;
            }
            placementScope.placeRelative(placeable, i, i2, f);
        }

        /* renamed from: placeRelative-70tqf50$default, reason: not valid java name */
        public static /* synthetic */ void m4224placeRelative70tqf50$default(PlacementScope placementScope, Placeable placeable, long j, float f, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: placeRelative-70tqf50");
            }
            if ((i & 2) != 0) {
                f = 0.0f;
            }
            placementScope.m4230placeRelative70tqf50(placeable, j, f);
        }

        public static /* synthetic */ void placeRelativeWithLayer$default(PlacementScope placementScope, Placeable placeable, int i, int i2, float f, Function1 function1, int i3, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: placeRelativeWithLayer");
            }
            float f2 = (i3 & 4) != 0 ? 0.0f : f;
            if ((i3 & 8) != 0) {
                function1 = PlaceableKt.DefaultLayerBlock;
            }
            placementScope.placeRelativeWithLayer(placeable, i, i2, f2, function1);
        }

        /* renamed from: placeRelativeWithLayer-aW-9-wM$default, reason: not valid java name */
        public static /* synthetic */ void m4225placeRelativeWithLayeraW9wM$default(PlacementScope placementScope, Placeable placeable, long j, float f, Function1 function1, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: placeRelativeWithLayer-aW-9-wM");
            }
            float f2 = (i & 2) != 0 ? 0.0f : f;
            if ((i & 4) != 0) {
                function1 = PlaceableKt.DefaultLayerBlock;
            }
            placementScope.m4231placeRelativeWithLayeraW9wM(placeable, j, f2, function1);
        }

        public static /* synthetic */ void placeWithLayer$default(PlacementScope placementScope, Placeable placeable, int i, int i2, float f, Function1 function1, int i3, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: placeWithLayer");
            }
            float f2 = (i3 & 4) != 0 ? 0.0f : f;
            if ((i3 & 8) != 0) {
                function1 = PlaceableKt.DefaultLayerBlock;
            }
            placementScope.placeWithLayer(placeable, i, i2, f2, function1);
        }

        /* renamed from: placeWithLayer-aW-9-wM$default, reason: not valid java name */
        public static /* synthetic */ void m4226placeWithLayeraW9wM$default(PlacementScope placementScope, Placeable placeable, long j, float f, Function1 function1, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: placeWithLayer-aW-9-wM");
            }
            float f2 = (i & 2) != 0 ? 0.0f : f;
            if ((i & 4) != 0) {
                function1 = PlaceableKt.DefaultLayerBlock;
            }
            placementScope.m4232placeWithLayeraW9wM(placeable, j, f2, function1);
        }

        @ExperimentalComposeUiApi
        @Nullable
        public LayoutCoordinates getCoordinates() {
            return null;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @NotNull
        public abstract LayoutDirection getParentLayoutDirection();

        /* JADX INFO: Access modifiers changed from: protected */
        public abstract int getParentWidth();

        public final void place(@NotNull Placeable placeable, int i, int i2, float f) {
            Intrinsics.checkNotNullParameter(placeable, "<this>");
            long IntOffset = IntOffsetKt.IntOffset(i, i2);
            long m4218getApparentToRealOffsetnOccac = placeable.m4218getApparentToRealOffsetnOccac();
            placeable.mo4188placeAtf8xVGno(IntOffsetKt.IntOffset(IntOffset.m5334getXimpl(IntOffset) + IntOffset.m5334getXimpl(m4218getApparentToRealOffsetnOccac), IntOffset.m5335getYimpl(IntOffset) + IntOffset.m5335getYimpl(m4218getApparentToRealOffsetnOccac)), f, null);
        }

        /* renamed from: place-70tqf50, reason: not valid java name */
        public final void m4227place70tqf50(@NotNull Placeable placeable, long j, float f) {
            Intrinsics.checkNotNullParameter(placeable, "$this$place");
            long m4218getApparentToRealOffsetnOccac = placeable.m4218getApparentToRealOffsetnOccac();
            placeable.mo4188placeAtf8xVGno(IntOffsetKt.IntOffset(IntOffset.m5334getXimpl(j) + IntOffset.m5334getXimpl(m4218getApparentToRealOffsetnOccac), IntOffset.m5335getYimpl(j) + IntOffset.m5335getYimpl(m4218getApparentToRealOffsetnOccac)), f, null);
        }

        /* renamed from: placeApparentToRealOffset-aW-9-wM$ui_release, reason: not valid java name */
        public final void m4228placeApparentToRealOffsetaW9wM$ui_release(@NotNull Placeable placeable, long j, float f, @Nullable Function1<? super GraphicsLayerScope, Unit> function1) {
            Intrinsics.checkNotNullParameter(placeable, "$this$placeApparentToRealOffset");
            long m4218getApparentToRealOffsetnOccac = placeable.m4218getApparentToRealOffsetnOccac();
            placeable.mo4188placeAtf8xVGno(IntOffsetKt.IntOffset(IntOffset.m5334getXimpl(j) + IntOffset.m5334getXimpl(m4218getApparentToRealOffsetnOccac), IntOffset.m5335getYimpl(j) + IntOffset.m5335getYimpl(m4218getApparentToRealOffsetnOccac)), f, function1);
        }

        /* renamed from: placeAutoMirrored-aW-9-wM$ui_release, reason: not valid java name */
        public final void m4229placeAutoMirroredaW9wM$ui_release(@NotNull Placeable placeable, long j, float f, @Nullable Function1<? super GraphicsLayerScope, Unit> function1) {
            Intrinsics.checkNotNullParameter(placeable, "$this$placeAutoMirrored");
            if (getParentLayoutDirection() == LayoutDirection.Ltr || getParentWidth() == 0) {
                long m4218getApparentToRealOffsetnOccac = placeable.m4218getApparentToRealOffsetnOccac();
                placeable.mo4188placeAtf8xVGno(IntOffsetKt.IntOffset(IntOffset.m5334getXimpl(j) + IntOffset.m5334getXimpl(m4218getApparentToRealOffsetnOccac), IntOffset.m5335getYimpl(j) + IntOffset.m5335getYimpl(m4218getApparentToRealOffsetnOccac)), f, function1);
            } else {
                long IntOffset = IntOffsetKt.IntOffset((getParentWidth() - placeable.getWidth()) - IntOffset.m5334getXimpl(j), IntOffset.m5335getYimpl(j));
                long m4218getApparentToRealOffsetnOccac2 = placeable.m4218getApparentToRealOffsetnOccac();
                placeable.mo4188placeAtf8xVGno(IntOffsetKt.IntOffset(IntOffset.m5334getXimpl(IntOffset) + IntOffset.m5334getXimpl(m4218getApparentToRealOffsetnOccac2), IntOffset.m5335getYimpl(IntOffset) + IntOffset.m5335getYimpl(m4218getApparentToRealOffsetnOccac2)), f, function1);
            }
        }

        public final void placeRelative(@NotNull Placeable placeable, int i, int i2, float f) {
            Intrinsics.checkNotNullParameter(placeable, "<this>");
            long IntOffset = IntOffsetKt.IntOffset(i, i2);
            if (getParentLayoutDirection() == LayoutDirection.Ltr || getParentWidth() == 0) {
                long m4218getApparentToRealOffsetnOccac = placeable.m4218getApparentToRealOffsetnOccac();
                placeable.mo4188placeAtf8xVGno(IntOffsetKt.IntOffset(IntOffset.m5334getXimpl(IntOffset) + IntOffset.m5334getXimpl(m4218getApparentToRealOffsetnOccac), IntOffset.m5335getYimpl(IntOffset) + IntOffset.m5335getYimpl(m4218getApparentToRealOffsetnOccac)), f, null);
            } else {
                long IntOffset2 = IntOffsetKt.IntOffset((getParentWidth() - placeable.getWidth()) - IntOffset.m5334getXimpl(IntOffset), IntOffset.m5335getYimpl(IntOffset));
                long m4218getApparentToRealOffsetnOccac2 = placeable.m4218getApparentToRealOffsetnOccac();
                placeable.mo4188placeAtf8xVGno(IntOffsetKt.IntOffset(IntOffset.m5334getXimpl(IntOffset2) + IntOffset.m5334getXimpl(m4218getApparentToRealOffsetnOccac2), IntOffset.m5335getYimpl(IntOffset2) + IntOffset.m5335getYimpl(m4218getApparentToRealOffsetnOccac2)), f, null);
            }
        }

        /* renamed from: placeRelative-70tqf50, reason: not valid java name */
        public final void m4230placeRelative70tqf50(@NotNull Placeable placeable, long j, float f) {
            Intrinsics.checkNotNullParameter(placeable, "$this$placeRelative");
            if (getParentLayoutDirection() == LayoutDirection.Ltr || getParentWidth() == 0) {
                long m4218getApparentToRealOffsetnOccac = placeable.m4218getApparentToRealOffsetnOccac();
                placeable.mo4188placeAtf8xVGno(IntOffsetKt.IntOffset(IntOffset.m5334getXimpl(j) + IntOffset.m5334getXimpl(m4218getApparentToRealOffsetnOccac), IntOffset.m5335getYimpl(j) + IntOffset.m5335getYimpl(m4218getApparentToRealOffsetnOccac)), f, null);
            } else {
                long IntOffset = IntOffsetKt.IntOffset((getParentWidth() - placeable.getWidth()) - IntOffset.m5334getXimpl(j), IntOffset.m5335getYimpl(j));
                long m4218getApparentToRealOffsetnOccac2 = placeable.m4218getApparentToRealOffsetnOccac();
                placeable.mo4188placeAtf8xVGno(IntOffsetKt.IntOffset(IntOffset.m5334getXimpl(IntOffset) + IntOffset.m5334getXimpl(m4218getApparentToRealOffsetnOccac2), IntOffset.m5335getYimpl(IntOffset) + IntOffset.m5335getYimpl(m4218getApparentToRealOffsetnOccac2)), f, null);
            }
        }

        public final void placeRelativeWithLayer(@NotNull Placeable placeable, int i, int i2, float f, @NotNull Function1<? super GraphicsLayerScope, Unit> function1) {
            Intrinsics.checkNotNullParameter(placeable, "<this>");
            Intrinsics.checkNotNullParameter(function1, "layerBlock");
            long IntOffset = IntOffsetKt.IntOffset(i, i2);
            if (getParentLayoutDirection() == LayoutDirection.Ltr || getParentWidth() == 0) {
                long m4218getApparentToRealOffsetnOccac = placeable.m4218getApparentToRealOffsetnOccac();
                placeable.mo4188placeAtf8xVGno(IntOffsetKt.IntOffset(IntOffset.m5334getXimpl(IntOffset) + IntOffset.m5334getXimpl(m4218getApparentToRealOffsetnOccac), IntOffset.m5335getYimpl(IntOffset) + IntOffset.m5335getYimpl(m4218getApparentToRealOffsetnOccac)), f, function1);
            } else {
                long IntOffset2 = IntOffsetKt.IntOffset((getParentWidth() - placeable.getWidth()) - IntOffset.m5334getXimpl(IntOffset), IntOffset.m5335getYimpl(IntOffset));
                long m4218getApparentToRealOffsetnOccac2 = placeable.m4218getApparentToRealOffsetnOccac();
                placeable.mo4188placeAtf8xVGno(IntOffsetKt.IntOffset(IntOffset.m5334getXimpl(IntOffset2) + IntOffset.m5334getXimpl(m4218getApparentToRealOffsetnOccac2), IntOffset.m5335getYimpl(IntOffset2) + IntOffset.m5335getYimpl(m4218getApparentToRealOffsetnOccac2)), f, function1);
            }
        }

        /* renamed from: placeRelativeWithLayer-aW-9-wM, reason: not valid java name */
        public final void m4231placeRelativeWithLayeraW9wM(@NotNull Placeable placeable, long j, float f, @NotNull Function1<? super GraphicsLayerScope, Unit> function1) {
            Intrinsics.checkNotNullParameter(placeable, "$this$placeRelativeWithLayer");
            Intrinsics.checkNotNullParameter(function1, "layerBlock");
            if (getParentLayoutDirection() == LayoutDirection.Ltr || getParentWidth() == 0) {
                long m4218getApparentToRealOffsetnOccac = placeable.m4218getApparentToRealOffsetnOccac();
                placeable.mo4188placeAtf8xVGno(IntOffsetKt.IntOffset(IntOffset.m5334getXimpl(j) + IntOffset.m5334getXimpl(m4218getApparentToRealOffsetnOccac), IntOffset.m5335getYimpl(j) + IntOffset.m5335getYimpl(m4218getApparentToRealOffsetnOccac)), f, function1);
            } else {
                long IntOffset = IntOffsetKt.IntOffset((getParentWidth() - placeable.getWidth()) - IntOffset.m5334getXimpl(j), IntOffset.m5335getYimpl(j));
                long m4218getApparentToRealOffsetnOccac2 = placeable.m4218getApparentToRealOffsetnOccac();
                placeable.mo4188placeAtf8xVGno(IntOffsetKt.IntOffset(IntOffset.m5334getXimpl(IntOffset) + IntOffset.m5334getXimpl(m4218getApparentToRealOffsetnOccac2), IntOffset.m5335getYimpl(IntOffset) + IntOffset.m5335getYimpl(m4218getApparentToRealOffsetnOccac2)), f, function1);
            }
        }

        public final void placeWithLayer(@NotNull Placeable placeable, int i, int i2, float f, @NotNull Function1<? super GraphicsLayerScope, Unit> function1) {
            Intrinsics.checkNotNullParameter(placeable, "<this>");
            Intrinsics.checkNotNullParameter(function1, "layerBlock");
            long IntOffset = IntOffsetKt.IntOffset(i, i2);
            long m4218getApparentToRealOffsetnOccac = placeable.m4218getApparentToRealOffsetnOccac();
            placeable.mo4188placeAtf8xVGno(IntOffsetKt.IntOffset(IntOffset.m5334getXimpl(IntOffset) + IntOffset.m5334getXimpl(m4218getApparentToRealOffsetnOccac), IntOffset.m5335getYimpl(IntOffset) + IntOffset.m5335getYimpl(m4218getApparentToRealOffsetnOccac)), f, function1);
        }

        /* renamed from: placeWithLayer-aW-9-wM, reason: not valid java name */
        public final void m4232placeWithLayeraW9wM(@NotNull Placeable placeable, long j, float f, @NotNull Function1<? super GraphicsLayerScope, Unit> function1) {
            Intrinsics.checkNotNullParameter(placeable, "$this$placeWithLayer");
            Intrinsics.checkNotNullParameter(function1, "layerBlock");
            long m4218getApparentToRealOffsetnOccac = placeable.m4218getApparentToRealOffsetnOccac();
            placeable.mo4188placeAtf8xVGno(IntOffsetKt.IntOffset(IntOffset.m5334getXimpl(j) + IntOffset.m5334getXimpl(m4218getApparentToRealOffsetnOccac), IntOffset.m5335getYimpl(j) + IntOffset.m5335getYimpl(m4218getApparentToRealOffsetnOccac)), f, function1);
        }
    }

    public Placeable() {
        long j;
        j = PlaceableKt.DefaultConstraints;
        this.measurementConstraints = j;
    }

    private final void recalculateWidthAndHeight() {
        this.width = RangesKt.coerceIn(IntSize.m5376getWidthimpl(this.measuredSize), Constraints.m5186getMinWidthimpl(this.measurementConstraints), Constraints.m5184getMaxWidthimpl(this.measurementConstraints));
        this.height = RangesKt.coerceIn(IntSize.m5375getHeightimpl(this.measuredSize), Constraints.m5185getMinHeightimpl(this.measurementConstraints), Constraints.m5183getMaxHeightimpl(this.measurementConstraints));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: getApparentToRealOffset-nOcc-ac, reason: not valid java name */
    public final long m4218getApparentToRealOffsetnOccac() {
        return IntOffsetKt.IntOffset((this.width - IntSize.m5376getWidthimpl(this.measuredSize)) / 2, (this.height - IntSize.m5375getHeightimpl(this.measuredSize)) / 2);
    }

    public final int getHeight() {
        return this.height;
    }

    @Override // androidx.compose.p004ui.layout.Measured
    public int getMeasuredHeight() {
        return IntSize.m5375getHeightimpl(this.measuredSize);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: getMeasuredSize-YbymL2g, reason: not valid java name */
    public final long m4219getMeasuredSizeYbymL2g() {
        return this.measuredSize;
    }

    @Override // androidx.compose.p004ui.layout.Measured
    public int getMeasuredWidth() {
        return IntSize.m5376getWidthimpl(this.measuredSize);
    }

    /* renamed from: getMeasurementConstraints-msEJaDk, reason: not valid java name */
    protected final long m4220getMeasurementConstraintsmsEJaDk() {
        return this.measurementConstraints;
    }

    @Override // androidx.compose.p004ui.layout.Measured
    public /* synthetic */ Object getParentData() {
        return pn2.a(this);
    }

    public final int getWidth() {
        return this.width;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: placeAt-f8xVGno */
    public abstract void mo4188placeAtf8xVGno(long j, float f, @Nullable Function1<? super GraphicsLayerScope, Unit> function1);

    /* renamed from: setMeasuredSize-ozmzZPI, reason: not valid java name */
    protected final void m4221setMeasuredSizeozmzZPI(long j) {
        if (IntSize.m5374equalsimpl0(this.measuredSize, j)) {
            return;
        }
        this.measuredSize = j;
        recalculateWidthAndHeight();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: setMeasurementConstraints-BRTryo0, reason: not valid java name */
    public final void m4222setMeasurementConstraintsBRTryo0(long j) {
        if (Constraints.m5177equalsimpl0(this.measurementConstraints, j)) {
            return;
        }
        this.measurementConstraints = j;
        recalculateWidthAndHeight();
    }
}
