package androidx.compose.ui.node;

import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LookaheadLayoutCoordinatesImpl;
import androidx.compose.ui.layout.LookaheadScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.Placeable$PlacementScope;
import androidx.compose.ui.node.LayoutNodeLayoutDelegate;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public abstract class LookaheadDelegate extends LookaheadCapablePlaceable implements Measurable {

    @Nullable
    private MeasureResult _measureResult;

    @NotNull
    private final Map<AlignmentLine, Integer> cachedAlignmentLinesMap;

    @NotNull
    private final NodeCoordinator coordinator;

    @NotNull
    private final LookaheadLayoutCoordinatesImpl lookaheadLayoutCoordinates;

    @NotNull
    private final LookaheadScope lookaheadScope;

    @Nullable
    private Map<AlignmentLine, Integer> oldAlignmentLines;
    private long position;

    public LookaheadDelegate(@NotNull NodeCoordinator nodeCoordinator, @NotNull LookaheadScope lookaheadScope) {
        Intrinsics.checkNotNullParameter(nodeCoordinator, "coordinator");
        Intrinsics.checkNotNullParameter(lookaheadScope, "lookaheadScope");
        this.coordinator = nodeCoordinator;
        this.lookaheadScope = lookaheadScope;
        this.position = IntOffset.Companion.m2653getZeronOccac();
        this.lookaheadLayoutCoordinates = new LookaheadLayoutCoordinatesImpl(this);
        this.cachedAlignmentLinesMap = new LinkedHashMap();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void set_measureResult(MeasureResult measureResult) {
        Unit unit;
        if (measureResult != null) {
            setMeasuredSize-ozmzZPI(IntSizeKt.IntSize(measureResult.getWidth(), measureResult.getHeight()));
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            setMeasuredSize-ozmzZPI(IntSize.Companion.m2690getZeroYbymL2g());
        }
        if (!Intrinsics.areEqual(this._measureResult, measureResult) && measureResult != null) {
            Map<AlignmentLine, Integer> map = this.oldAlignmentLines;
            if ((!(map == null || map.isEmpty()) || (!measureResult.getAlignmentLines().isEmpty())) && !Intrinsics.areEqual(measureResult.getAlignmentLines(), this.oldAlignmentLines)) {
                getAlignmentLinesOwner().getAlignmentLines().onAlignmentsChanged();
                Map map2 = this.oldAlignmentLines;
                if (map2 == null) {
                    map2 = new LinkedHashMap();
                    this.oldAlignmentLines = map2;
                }
                map2.clear();
                map2.putAll(measureResult.getAlignmentLines());
            }
        }
        this._measureResult = measureResult;
    }

    @NotNull
    public AlignmentLinesOwner getAlignmentLinesOwner() {
        AlignmentLinesOwner lookaheadAlignmentLinesOwner$ui_release = this.coordinator.getLayoutNode().getLayoutDelegate$ui_release().getLookaheadAlignmentLinesOwner$ui_release();
        Intrinsics.checkNotNull(lookaheadAlignmentLinesOwner$ui_release);
        return lookaheadAlignmentLinesOwner$ui_release;
    }

    public final int getCachedAlignmentLine$ui_release(@NotNull AlignmentLine alignmentLine) {
        Intrinsics.checkNotNullParameter(alignmentLine, "alignmentLine");
        Integer num = this.cachedAlignmentLinesMap.get(alignmentLine);
        if (num != null) {
            return num.intValue();
        }
        return Integer.MIN_VALUE;
    }

    @NotNull
    protected final Map<AlignmentLine, Integer> getCachedAlignmentLinesMap() {
        return this.cachedAlignmentLinesMap;
    }

    @Nullable
    public LookaheadCapablePlaceable getChild() {
        NodeCoordinator wrapped$ui_release = this.coordinator.getWrapped$ui_release();
        if (wrapped$ui_release != null) {
            return wrapped$ui_release.getLookaheadDelegate$ui_release();
        }
        return null;
    }

    @NotNull
    public LayoutCoordinates getCoordinates() {
        return this.lookaheadLayoutCoordinates;
    }

    @NotNull
    public final NodeCoordinator getCoordinator() {
        return this.coordinator;
    }

    public float getDensity() {
        return this.coordinator.getDensity();
    }

    public float getFontScale() {
        return this.coordinator.getFontScale();
    }

    public boolean getHasMeasureResult() {
        return this._measureResult != null;
    }

    @NotNull
    public LayoutDirection getLayoutDirection() {
        return this.coordinator.getLayoutDirection();
    }

    @NotNull
    public LayoutNode getLayoutNode() {
        return this.coordinator.getLayoutNode();
    }

    @NotNull
    public final LookaheadLayoutCoordinatesImpl getLookaheadLayoutCoordinates() {
        return this.lookaheadLayoutCoordinates;
    }

    @NotNull
    public final LookaheadScope getLookaheadScope() {
        return this.lookaheadScope;
    }

    @NotNull
    public MeasureResult getMeasureResult$ui_release() {
        MeasureResult measureResult = this._measureResult;
        if (measureResult != null) {
            return measureResult;
        }
        throw new IllegalStateException("LookaheadDelegate has not been measured yet when measureResult is requested.".toString());
    }

    @Nullable
    public LookaheadCapablePlaceable getParent() {
        NodeCoordinator wrappedBy$ui_release = this.coordinator.getWrappedBy$ui_release();
        if (wrappedBy$ui_release != null) {
            return wrappedBy$ui_release.getLookaheadDelegate$ui_release();
        }
        return null;
    }

    @Nullable
    public Object getParentData() {
        return this.coordinator.getParentData();
    }

    /* renamed from: getPosition-nOcc-ac, reason: not valid java name */
    public long m2159getPositionnOccac() {
        return this.position;
    }

    public int maxIntrinsicHeight(int i) {
        NodeCoordinator wrapped$ui_release = this.coordinator.getWrapped$ui_release();
        Intrinsics.checkNotNull(wrapped$ui_release);
        LookaheadDelegate lookaheadDelegate$ui_release = wrapped$ui_release.getLookaheadDelegate$ui_release();
        Intrinsics.checkNotNull(lookaheadDelegate$ui_release);
        return lookaheadDelegate$ui_release.maxIntrinsicHeight(i);
    }

    public int maxIntrinsicWidth(int i) {
        NodeCoordinator wrapped$ui_release = this.coordinator.getWrapped$ui_release();
        Intrinsics.checkNotNull(wrapped$ui_release);
        LookaheadDelegate lookaheadDelegate$ui_release = wrapped$ui_release.getLookaheadDelegate$ui_release();
        Intrinsics.checkNotNull(lookaheadDelegate$ui_release);
        return lookaheadDelegate$ui_release.maxIntrinsicWidth(i);
    }

    public int minIntrinsicHeight(int i) {
        NodeCoordinator wrapped$ui_release = this.coordinator.getWrapped$ui_release();
        Intrinsics.checkNotNull(wrapped$ui_release);
        LookaheadDelegate lookaheadDelegate$ui_release = wrapped$ui_release.getLookaheadDelegate$ui_release();
        Intrinsics.checkNotNull(lookaheadDelegate$ui_release);
        return lookaheadDelegate$ui_release.minIntrinsicHeight(i);
    }

    public int minIntrinsicWidth(int i) {
        NodeCoordinator wrapped$ui_release = this.coordinator.getWrapped$ui_release();
        Intrinsics.checkNotNull(wrapped$ui_release);
        LookaheadDelegate lookaheadDelegate$ui_release = wrapped$ui_release.getLookaheadDelegate$ui_release();
        Intrinsics.checkNotNull(lookaheadDelegate$ui_release);
        return lookaheadDelegate$ui_release.minIntrinsicWidth(i);
    }

    @NotNull
    /* renamed from: performingMeasure-K40F9xA, reason: not valid java name */
    public final Placeable m2160performingMeasureK40F9xA(long j, @NotNull Function0<? extends MeasureResult> function0) {
        Intrinsics.checkNotNullParameter(function0, "block");
        setMeasurementConstraints-BRTryo0(j);
        set_measureResult((MeasureResult) function0.invoke());
        return this;
    }

    /* renamed from: placeAt-f8xVGno, reason: not valid java name */
    protected final void m2161placeAtf8xVGno(long j, float f, @Nullable Function1<? super GraphicsLayerScope, Unit> function1) {
        if (!IntOffset.m2642equalsimpl0(m2159getPositionnOccac(), j)) {
            m2163setPositiongyyYBs(j);
            LayoutNodeLayoutDelegate.LookaheadPassDelegate lookaheadPassDelegate$ui_release = getLayoutNode().getLayoutDelegate$ui_release().getLookaheadPassDelegate$ui_release();
            if (lookaheadPassDelegate$ui_release != null) {
                lookaheadPassDelegate$ui_release.notifyChildrenUsingCoordinatesWhilePlacing();
            }
            invalidateAlignmentLinesFromPositionChange(this.coordinator);
        }
        if (isShallowPlacing$ui_release()) {
            return;
        }
        placeChildren();
    }

    protected void placeChildren() {
        LayoutCoordinates layoutCoordinates;
        LayoutNodeLayoutDelegate layoutNodeLayoutDelegate;
        Placeable$PlacementScope.Companion companion = Placeable$PlacementScope.Companion;
        int width = getMeasureResult$ui_release().getWidth();
        LayoutDirection layoutDirection = this.coordinator.getLayoutDirection();
        layoutCoordinates = Placeable$PlacementScope._coordinates;
        int access$getParentWidth = Placeable$PlacementScope.Companion.access$getParentWidth(companion);
        LayoutDirection access$getParentLayoutDirection = Placeable$PlacementScope.Companion.access$getParentLayoutDirection(companion);
        layoutNodeLayoutDelegate = Placeable$PlacementScope.layoutDelegate;
        Placeable$PlacementScope.parentWidth = width;
        Placeable$PlacementScope.parentLayoutDirection = layoutDirection;
        boolean access$configureForPlacingForAlignment = Placeable$PlacementScope.Companion.access$configureForPlacingForAlignment(companion, this);
        getMeasureResult$ui_release().placeChildren();
        setPlacingForAlignment$ui_release(access$configureForPlacingForAlignment);
        Placeable$PlacementScope.parentWidth = access$getParentWidth;
        Placeable$PlacementScope.parentLayoutDirection = access$getParentLayoutDirection;
        Placeable$PlacementScope._coordinates = layoutCoordinates;
        Placeable$PlacementScope.layoutDelegate = layoutNodeLayoutDelegate;
    }

    /* renamed from: positionIn-Bjo55l4$ui_release, reason: not valid java name */
    public final long m2162positionInBjo55l4$ui_release(@NotNull LookaheadDelegate lookaheadDelegate) {
        Intrinsics.checkNotNullParameter(lookaheadDelegate, "ancestor");
        long m2653getZeronOccac = IntOffset.Companion.m2653getZeronOccac();
        LookaheadDelegate lookaheadDelegate2 = this;
        while (!Intrinsics.areEqual(lookaheadDelegate2, lookaheadDelegate)) {
            long m2159getPositionnOccac = lookaheadDelegate2.m2159getPositionnOccac();
            m2653getZeronOccac = IntOffsetKt.IntOffset(IntOffset.m2643getXimpl(m2653getZeronOccac) + IntOffset.m2643getXimpl(m2159getPositionnOccac), IntOffset.m2644getYimpl(m2653getZeronOccac) + IntOffset.m2644getYimpl(m2159getPositionnOccac));
            NodeCoordinator wrappedBy$ui_release = lookaheadDelegate2.coordinator.getWrappedBy$ui_release();
            Intrinsics.checkNotNull(wrappedBy$ui_release);
            lookaheadDelegate2 = wrappedBy$ui_release.getLookaheadDelegate$ui_release();
            Intrinsics.checkNotNull(lookaheadDelegate2);
        }
        return m2653getZeronOccac;
    }

    public void replace$ui_release() {
        m2161placeAtf8xVGno(m2159getPositionnOccac(), 0.0f, null);
    }

    /* renamed from: setPosition--gyyYBs, reason: not valid java name */
    public void m2163setPositiongyyYBs(long j) {
        this.position = j;
    }
}
