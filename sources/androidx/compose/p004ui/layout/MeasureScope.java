package androidx.compose.p004ui.layout;

import androidx.compose.p004ui.geometry.Rect;
import androidx.compose.p004ui.layout.Placeable;
import androidx.compose.p004ui.node.LayoutNodeLayoutDelegate;
import androidx.compose.p004ui.node.LookaheadCapablePlaceable;
import androidx.compose.p004ui.unit.DpRect;
import androidx.compose.p004ui.unit.LayoutDirection;
import androidx.compose.runtime.Stable;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tb.jw0;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public interface MeasureScope extends IntrinsicMeasureScope {

    /* compiled from: Taobao */
    /* renamed from: androidx.compose.ui.layout.MeasureScope$-CC, reason: invalid class name */
    /* loaded from: classes2.dex */
    public final /* synthetic */ class CC {
        @NotNull
        /* renamed from: a */
        public static MeasureResult m125a(final MeasureScope _this, final int i, @NotNull final int i2, @NotNull final Map map, final Function1 function1) {
            Intrinsics.checkNotNullParameter(map, "alignmentLines");
            Intrinsics.checkNotNullParameter(function1, "placementBlock");
            return new MeasureResult(i, i2, map, _this, function1) { // from class: androidx.compose.ui.layout.MeasureScope$layout$1
                final /* synthetic */ Function1<Placeable.PlacementScope, Unit> $placementBlock;
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

                @Override // androidx.compose.p004ui.layout.MeasureResult
                @NotNull
                public Map<AlignmentLine, Integer> getAlignmentLines() {
                    return this.alignmentLines;
                }

                @Override // androidx.compose.p004ui.layout.MeasureResult
                public int getHeight() {
                    return this.height;
                }

                @Override // androidx.compose.p004ui.layout.MeasureResult
                public int getWidth() {
                    return this.width;
                }

                @Override // androidx.compose.p004ui.layout.MeasureResult
                public void placeChildren() {
                    Placeable.PlacementScope.Companion companion = Placeable.PlacementScope.Companion;
                    int i3 = this.$width;
                    LayoutDirection layoutDirection = this.this$0.getLayoutDirection();
                    MeasureScope measureScope = this.this$0;
                    LookaheadCapablePlaceable lookaheadCapablePlaceable = measureScope instanceof LookaheadCapablePlaceable ? (LookaheadCapablePlaceable) measureScope : null;
                    Function1<Placeable.PlacementScope, Unit> function12 = this.$placementBlock;
                    LayoutCoordinates layoutCoordinates = Placeable.PlacementScope._coordinates;
                    int parentWidth = companion.getParentWidth();
                    LayoutDirection parentLayoutDirection = companion.getParentLayoutDirection();
                    LayoutNodeLayoutDelegate layoutNodeLayoutDelegate = Placeable.PlacementScope.layoutDelegate;
                    Placeable.PlacementScope.parentWidth = i3;
                    Placeable.PlacementScope.parentLayoutDirection = layoutDirection;
                    boolean configureForPlacingForAlignment = companion.configureForPlacingForAlignment(lookaheadCapablePlaceable);
                    function12.invoke(companion);
                    if (lookaheadCapablePlaceable != null) {
                        lookaheadCapablePlaceable.setPlacingForAlignment$ui_release(configureForPlacingForAlignment);
                    }
                    Placeable.PlacementScope.parentWidth = parentWidth;
                    Placeable.PlacementScope.parentLayoutDirection = parentLayoutDirection;
                    Placeable.PlacementScope._coordinates = layoutCoordinates;
                    Placeable.PlacementScope.layoutDelegate = layoutNodeLayoutDelegate;
                }
            };
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* renamed from: p */
        public static /* synthetic */ MeasureResult m140p(MeasureScope measureScope, int i, int i2, Map map, Function1 function1, int i3, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: layout");
            }
            if ((i3 & 4) != 0) {
                map = MapsKt.emptyMap();
            }
            return measureScope.layout(i, i2, map, function1);
        }
    }

    /* compiled from: Taobao */
    public static final class DefaultImpls {
        @Deprecated
        @NotNull
        public static MeasureResult layout(@NotNull MeasureScope measureScope, int i, int i2, @NotNull Map<AlignmentLine, Integer> map, @NotNull Function1<? super Placeable.PlacementScope, Unit> function1) {
            Intrinsics.checkNotNullParameter(map, "alignmentLines");
            Intrinsics.checkNotNullParameter(function1, "placementBlock");
            return CC.m125a(measureScope, i, i2, map, function1);
        }

        @Stable
        @Deprecated
        /* renamed from: roundToPx--R2X_6o, reason: not valid java name */
        public static int m4202roundToPxR2X_6o(@NotNull MeasureScope measureScope, long j) {
            return jw0.a(measureScope, j);
        }

        @Stable
        @Deprecated
        /* renamed from: roundToPx-0680j_4, reason: not valid java name */
        public static int m4203roundToPx0680j_4(@NotNull MeasureScope measureScope, float f) {
            return jw0.b(measureScope, f);
        }

        @Stable
        @Deprecated
        /* renamed from: toDp-GaN1DYA, reason: not valid java name */
        public static float m4204toDpGaN1DYA(@NotNull MeasureScope measureScope, long j) {
            return jw0.c(measureScope, j);
        }

        @Stable
        @Deprecated
        /* renamed from: toDp-u2uoSUM, reason: not valid java name */
        public static float m4205toDpu2uoSUM(@NotNull MeasureScope measureScope, float f) {
            return jw0.d(measureScope, f);
        }

        @Stable
        @Deprecated
        /* renamed from: toDpSize-k-rfVVM, reason: not valid java name */
        public static long m4207toDpSizekrfVVM(@NotNull MeasureScope measureScope, long j) {
            return jw0.f(measureScope, j);
        }

        @Stable
        @Deprecated
        /* renamed from: toPx--R2X_6o, reason: not valid java name */
        public static float m4208toPxR2X_6o(@NotNull MeasureScope measureScope, long j) {
            return jw0.g(measureScope, j);
        }

        @Stable
        @Deprecated
        /* renamed from: toPx-0680j_4, reason: not valid java name */
        public static float m4209toPx0680j_4(@NotNull MeasureScope measureScope, float f) {
            return jw0.h(measureScope, f);
        }

        @Stable
        @Deprecated
        @NotNull
        public static Rect toRect(@NotNull MeasureScope measureScope, @NotNull DpRect dpRect) {
            Intrinsics.checkNotNullParameter(dpRect, "$receiver");
            return jw0.i(measureScope, dpRect);
        }

        @Stable
        @Deprecated
        /* renamed from: toSize-XkaWNTQ, reason: not valid java name */
        public static long m4210toSizeXkaWNTQ(@NotNull MeasureScope measureScope, long j) {
            return jw0.j(measureScope, j);
        }

        @Stable
        @Deprecated
        /* renamed from: toSp-0xMU5do, reason: not valid java name */
        public static long m4211toSp0xMU5do(@NotNull MeasureScope measureScope, float f) {
            return jw0.k(measureScope, f);
        }

        @Stable
        @Deprecated
        /* renamed from: toSp-kPz2Gy4, reason: not valid java name */
        public static long m4212toSpkPz2Gy4(@NotNull MeasureScope measureScope, float f) {
            return jw0.l(measureScope, f);
        }

        @Stable
        @Deprecated
        /* renamed from: toDp-u2uoSUM, reason: not valid java name */
        public static float m4206toDpu2uoSUM(@NotNull MeasureScope measureScope, int i) {
            return jw0.e(measureScope, i);
        }

        @Stable
        @Deprecated
        /* renamed from: toSp-kPz2Gy4, reason: not valid java name */
        public static long m4213toSpkPz2Gy4(@NotNull MeasureScope measureScope, int i) {
            return jw0.m(measureScope, i);
        }
    }

    @NotNull
    MeasureResult layout(int i, int i2, @NotNull Map<AlignmentLine, Integer> map, @NotNull Function1<? super Placeable.PlacementScope, Unit> function1);
}
