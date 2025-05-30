package androidx.compose.ui.layout;

import androidx.compose.ui.layout.Placeable$PlacementScope;
import androidx.compose.ui.node.LayoutNodeLayoutDelegate;
import androidx.compose.ui.node.LookaheadCapablePlaceable;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* renamed from: androidx.compose.ui.layout.MeasureScope$-CC, reason: invalid class name */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final /* synthetic */ class MeasureScope$CC {
    @NotNull
    public static MeasureResult a(final MeasureScope _this, final int i, @NotNull final int i2, @NotNull final Map map, final Function1 function1) {
        Intrinsics.checkNotNullParameter(map, "alignmentLines");
        Intrinsics.checkNotNullParameter(function1, "placementBlock");
        return new MeasureResult(i, i2, map, _this, function1) { // from class: androidx.compose.ui.layout.MeasureScope$layout$1
            final /* synthetic */ Function1<Placeable$PlacementScope, Unit> $placementBlock;
            final /* synthetic */ int $width;

            @NotNull
            private final Map<AlignmentLine, Integer> alignmentLines;
            private final int height;
            final /* synthetic */ MeasureScope this$0;
            private final int width;

            /* JADX WARN: Multi-variable type inference failed */
            {
                this.$width = i;
                this.this$0 = _this;
                this.$placementBlock = function1;
                this.width = i;
                this.height = i2;
                this.alignmentLines = map;
            }

            @Override // androidx.compose.ui.layout.MeasureResult
            @NotNull
            public Map<AlignmentLine, Integer> getAlignmentLines() {
                return this.alignmentLines;
            }

            @Override // androidx.compose.ui.layout.MeasureResult
            public int getHeight() {
                return this.height;
            }

            @Override // androidx.compose.ui.layout.MeasureResult
            public int getWidth() {
                return this.width;
            }

            @Override // androidx.compose.ui.layout.MeasureResult
            public void placeChildren() {
                LayoutCoordinates layoutCoordinates;
                LayoutNodeLayoutDelegate layoutNodeLayoutDelegate;
                Placeable$PlacementScope.Companion companion = Placeable$PlacementScope.Companion;
                int i3 = this.$width;
                LayoutDirection layoutDirection = this.this$0.getLayoutDirection();
                LookaheadCapablePlaceable lookaheadCapablePlaceable = this.this$0;
                LookaheadCapablePlaceable lookaheadCapablePlaceable2 = lookaheadCapablePlaceable instanceof LookaheadCapablePlaceable ? lookaheadCapablePlaceable : null;
                Function1<Placeable$PlacementScope, Unit> function12 = this.$placementBlock;
                layoutCoordinates = Placeable$PlacementScope._coordinates;
                int access$getParentWidth = Placeable$PlacementScope.Companion.access$getParentWidth(companion);
                LayoutDirection access$getParentLayoutDirection = Placeable$PlacementScope.Companion.access$getParentLayoutDirection(companion);
                layoutNodeLayoutDelegate = Placeable$PlacementScope.layoutDelegate;
                Placeable$PlacementScope.parentWidth = i3;
                Placeable$PlacementScope.parentLayoutDirection = layoutDirection;
                boolean access$configureForPlacingForAlignment = Placeable$PlacementScope.Companion.access$configureForPlacingForAlignment(companion, lookaheadCapablePlaceable2);
                function12.invoke(companion);
                if (lookaheadCapablePlaceable2 != null) {
                    lookaheadCapablePlaceable2.setPlacingForAlignment$ui_release(access$configureForPlacingForAlignment);
                }
                Placeable$PlacementScope.parentWidth = access$getParentWidth;
                Placeable$PlacementScope.parentLayoutDirection = access$getParentLayoutDirection;
                Placeable$PlacementScope._coordinates = layoutCoordinates;
                Placeable$PlacementScope.layoutDelegate = layoutNodeLayoutDelegate;
            }
        };
    }

    public static /* synthetic */ MeasureResult p(MeasureScope measureScope, int i, int i2, Map map, Function1 function1, int i3, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: layout");
        }
        if ((i3 & 4) != 0) {
            map = MapsKt.emptyMap();
        }
        return measureScope.layout(i, i2, map, function1);
    }
}
