package androidx.compose.ui.layout;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.ExperimentalComposeUiApi;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.node.LayoutNodeLayoutDelegate;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@StabilityInferred(parameters = 0)
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public abstract class Placeable$PlacementScope {
    public static final int $stable = 0;

    @Nullable
    private static LayoutCoordinates _coordinates;

    @Nullable
    private static LayoutNodeLayoutDelegate layoutDelegate;
    private static int parentWidth;

    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    @NotNull
    private static LayoutDirection parentLayoutDirection = LayoutDirection.Ltr;

    @ExperimentalComposeUiApi
    public static /* synthetic */ void getCoordinates$annotations() {
    }

    public static /* synthetic */ void place$default(Placeable$PlacementScope placeable$PlacementScope, Placeable placeable, int i, int i2, float f, int i3, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: place");
        }
        if ((i3 & 4) != 0) {
            f = 0.0f;
        }
        placeable$PlacementScope.place(placeable, i, i2, f);
    }

    /* renamed from: place-70tqf50$default, reason: not valid java name */
    public static /* synthetic */ void m2068place70tqf50$default(Placeable$PlacementScope placeable$PlacementScope, Placeable placeable, long j, float f, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: place-70tqf50");
        }
        if ((i & 2) != 0) {
            f = 0.0f;
        }
        placeable$PlacementScope.m2072place70tqf50(placeable, j, f);
    }

    public static /* synthetic */ void placeRelative$default(Placeable$PlacementScope placeable$PlacementScope, Placeable placeable, int i, int i2, float f, int i3, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: placeRelative");
        }
        if ((i3 & 4) != 0) {
            f = 0.0f;
        }
        placeable$PlacementScope.placeRelative(placeable, i, i2, f);
    }

    /* renamed from: placeRelative-70tqf50$default, reason: not valid java name */
    public static /* synthetic */ void m2069placeRelative70tqf50$default(Placeable$PlacementScope placeable$PlacementScope, Placeable placeable, long j, float f, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: placeRelative-70tqf50");
        }
        if ((i & 2) != 0) {
            f = 0.0f;
        }
        placeable$PlacementScope.m2075placeRelative70tqf50(placeable, j, f);
    }

    public static /* synthetic */ void placeRelativeWithLayer$default(Placeable$PlacementScope placeable$PlacementScope, Placeable placeable, int i, int i2, float f, Function1 function1, int i3, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: placeRelativeWithLayer");
        }
        float f2 = (i3 & 4) != 0 ? 0.0f : f;
        if ((i3 & 8) != 0) {
            function1 = PlaceableKt.access$getDefaultLayerBlock$p();
        }
        placeable$PlacementScope.placeRelativeWithLayer(placeable, i, i2, f2, function1);
    }

    /* renamed from: placeRelativeWithLayer-aW-9-wM$default, reason: not valid java name */
    public static /* synthetic */ void m2070placeRelativeWithLayeraW9wM$default(Placeable$PlacementScope placeable$PlacementScope, Placeable placeable, long j, float f, Function1 function1, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: placeRelativeWithLayer-aW-9-wM");
        }
        float f2 = (i & 2) != 0 ? 0.0f : f;
        if ((i & 4) != 0) {
            function1 = PlaceableKt.access$getDefaultLayerBlock$p();
        }
        placeable$PlacementScope.m2076placeRelativeWithLayeraW9wM(placeable, j, f2, function1);
    }

    public static /* synthetic */ void placeWithLayer$default(Placeable$PlacementScope placeable$PlacementScope, Placeable placeable, int i, int i2, float f, Function1 function1, int i3, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: placeWithLayer");
        }
        float f2 = (i3 & 4) != 0 ? 0.0f : f;
        if ((i3 & 8) != 0) {
            function1 = PlaceableKt.access$getDefaultLayerBlock$p();
        }
        placeable$PlacementScope.placeWithLayer(placeable, i, i2, f2, function1);
    }

    /* renamed from: placeWithLayer-aW-9-wM$default, reason: not valid java name */
    public static /* synthetic */ void m2071placeWithLayeraW9wM$default(Placeable$PlacementScope placeable$PlacementScope, Placeable placeable, long j, float f, Function1 function1, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: placeWithLayer-aW-9-wM");
        }
        float f2 = (i & 2) != 0 ? 0.0f : f;
        if ((i & 4) != 0) {
            function1 = PlaceableKt.access$getDefaultLayerBlock$p();
        }
        placeable$PlacementScope.m2077placeWithLayeraW9wM(placeable, j, f2, function1);
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
        long j = Placeable.access$getApparentToRealOffset-nOcc-ac(placeable);
        Placeable.access$placeAt-f8xVGno(placeable, IntOffsetKt.IntOffset(IntOffset.m2643getXimpl(IntOffset) + IntOffset.m2643getXimpl(j), IntOffset.m2644getYimpl(IntOffset) + IntOffset.m2644getYimpl(j)), f, (Function1) null);
    }

    /* renamed from: place-70tqf50, reason: not valid java name */
    public final void m2072place70tqf50(@NotNull Placeable placeable, long j, float f) {
        Intrinsics.checkNotNullParameter(placeable, "$this$place");
        long j2 = Placeable.access$getApparentToRealOffset-nOcc-ac(placeable);
        Placeable.access$placeAt-f8xVGno(placeable, IntOffsetKt.IntOffset(IntOffset.m2643getXimpl(j) + IntOffset.m2643getXimpl(j2), IntOffset.m2644getYimpl(j) + IntOffset.m2644getYimpl(j2)), f, (Function1) null);
    }

    /* renamed from: placeApparentToRealOffset-aW-9-wM$ui_release, reason: not valid java name */
    public final void m2073placeApparentToRealOffsetaW9wM$ui_release(@NotNull Placeable placeable, long j, float f, @Nullable Function1<? super GraphicsLayerScope, Unit> function1) {
        Intrinsics.checkNotNullParameter(placeable, "$this$placeApparentToRealOffset");
        long j2 = Placeable.access$getApparentToRealOffset-nOcc-ac(placeable);
        Placeable.access$placeAt-f8xVGno(placeable, IntOffsetKt.IntOffset(IntOffset.m2643getXimpl(j) + IntOffset.m2643getXimpl(j2), IntOffset.m2644getYimpl(j) + IntOffset.m2644getYimpl(j2)), f, function1);
    }

    /* renamed from: placeAutoMirrored-aW-9-wM$ui_release, reason: not valid java name */
    public final void m2074placeAutoMirroredaW9wM$ui_release(@NotNull Placeable placeable, long j, float f, @Nullable Function1<? super GraphicsLayerScope, Unit> function1) {
        Intrinsics.checkNotNullParameter(placeable, "$this$placeAutoMirrored");
        if (getParentLayoutDirection() == LayoutDirection.Ltr || getParentWidth() == 0) {
            long j2 = Placeable.access$getApparentToRealOffset-nOcc-ac(placeable);
            Placeable.access$placeAt-f8xVGno(placeable, IntOffsetKt.IntOffset(IntOffset.m2643getXimpl(j) + IntOffset.m2643getXimpl(j2), IntOffset.m2644getYimpl(j) + IntOffset.m2644getYimpl(j2)), f, function1);
        } else {
            long IntOffset = IntOffsetKt.IntOffset((getParentWidth() - placeable.getWidth()) - IntOffset.m2643getXimpl(j), IntOffset.m2644getYimpl(j));
            long j3 = Placeable.access$getApparentToRealOffset-nOcc-ac(placeable);
            Placeable.access$placeAt-f8xVGno(placeable, IntOffsetKt.IntOffset(IntOffset.m2643getXimpl(IntOffset) + IntOffset.m2643getXimpl(j3), IntOffset.m2644getYimpl(IntOffset) + IntOffset.m2644getYimpl(j3)), f, function1);
        }
    }

    public final void placeRelative(@NotNull Placeable placeable, int i, int i2, float f) {
        Intrinsics.checkNotNullParameter(placeable, "<this>");
        long IntOffset = IntOffsetKt.IntOffset(i, i2);
        if (getParentLayoutDirection() == LayoutDirection.Ltr || getParentWidth() == 0) {
            long j = Placeable.access$getApparentToRealOffset-nOcc-ac(placeable);
            Placeable.access$placeAt-f8xVGno(placeable, IntOffsetKt.IntOffset(IntOffset.m2643getXimpl(IntOffset) + IntOffset.m2643getXimpl(j), IntOffset.m2644getYimpl(IntOffset) + IntOffset.m2644getYimpl(j)), f, (Function1) null);
        } else {
            long IntOffset2 = IntOffsetKt.IntOffset((getParentWidth() - placeable.getWidth()) - IntOffset.m2643getXimpl(IntOffset), IntOffset.m2644getYimpl(IntOffset));
            long j2 = Placeable.access$getApparentToRealOffset-nOcc-ac(placeable);
            Placeable.access$placeAt-f8xVGno(placeable, IntOffsetKt.IntOffset(IntOffset.m2643getXimpl(IntOffset2) + IntOffset.m2643getXimpl(j2), IntOffset.m2644getYimpl(IntOffset2) + IntOffset.m2644getYimpl(j2)), f, (Function1) null);
        }
    }

    /* renamed from: placeRelative-70tqf50, reason: not valid java name */
    public final void m2075placeRelative70tqf50(@NotNull Placeable placeable, long j, float f) {
        Intrinsics.checkNotNullParameter(placeable, "$this$placeRelative");
        if (getParentLayoutDirection() == LayoutDirection.Ltr || getParentWidth() == 0) {
            long j2 = Placeable.access$getApparentToRealOffset-nOcc-ac(placeable);
            Placeable.access$placeAt-f8xVGno(placeable, IntOffsetKt.IntOffset(IntOffset.m2643getXimpl(j) + IntOffset.m2643getXimpl(j2), IntOffset.m2644getYimpl(j) + IntOffset.m2644getYimpl(j2)), f, (Function1) null);
        } else {
            long IntOffset = IntOffsetKt.IntOffset((getParentWidth() - placeable.getWidth()) - IntOffset.m2643getXimpl(j), IntOffset.m2644getYimpl(j));
            long j3 = Placeable.access$getApparentToRealOffset-nOcc-ac(placeable);
            Placeable.access$placeAt-f8xVGno(placeable, IntOffsetKt.IntOffset(IntOffset.m2643getXimpl(IntOffset) + IntOffset.m2643getXimpl(j3), IntOffset.m2644getYimpl(IntOffset) + IntOffset.m2644getYimpl(j3)), f, (Function1) null);
        }
    }

    public final void placeRelativeWithLayer(@NotNull Placeable placeable, int i, int i2, float f, @NotNull Function1<? super GraphicsLayerScope, Unit> function1) {
        Intrinsics.checkNotNullParameter(placeable, "<this>");
        Intrinsics.checkNotNullParameter(function1, "layerBlock");
        long IntOffset = IntOffsetKt.IntOffset(i, i2);
        if (getParentLayoutDirection() == LayoutDirection.Ltr || getParentWidth() == 0) {
            long j = Placeable.access$getApparentToRealOffset-nOcc-ac(placeable);
            Placeable.access$placeAt-f8xVGno(placeable, IntOffsetKt.IntOffset(IntOffset.m2643getXimpl(IntOffset) + IntOffset.m2643getXimpl(j), IntOffset.m2644getYimpl(IntOffset) + IntOffset.m2644getYimpl(j)), f, function1);
        } else {
            long IntOffset2 = IntOffsetKt.IntOffset((getParentWidth() - placeable.getWidth()) - IntOffset.m2643getXimpl(IntOffset), IntOffset.m2644getYimpl(IntOffset));
            long j2 = Placeable.access$getApparentToRealOffset-nOcc-ac(placeable);
            Placeable.access$placeAt-f8xVGno(placeable, IntOffsetKt.IntOffset(IntOffset.m2643getXimpl(IntOffset2) + IntOffset.m2643getXimpl(j2), IntOffset.m2644getYimpl(IntOffset2) + IntOffset.m2644getYimpl(j2)), f, function1);
        }
    }

    /* renamed from: placeRelativeWithLayer-aW-9-wM, reason: not valid java name */
    public final void m2076placeRelativeWithLayeraW9wM(@NotNull Placeable placeable, long j, float f, @NotNull Function1<? super GraphicsLayerScope, Unit> function1) {
        Intrinsics.checkNotNullParameter(placeable, "$this$placeRelativeWithLayer");
        Intrinsics.checkNotNullParameter(function1, "layerBlock");
        if (getParentLayoutDirection() == LayoutDirection.Ltr || getParentWidth() == 0) {
            long j2 = Placeable.access$getApparentToRealOffset-nOcc-ac(placeable);
            Placeable.access$placeAt-f8xVGno(placeable, IntOffsetKt.IntOffset(IntOffset.m2643getXimpl(j) + IntOffset.m2643getXimpl(j2), IntOffset.m2644getYimpl(j) + IntOffset.m2644getYimpl(j2)), f, function1);
        } else {
            long IntOffset = IntOffsetKt.IntOffset((getParentWidth() - placeable.getWidth()) - IntOffset.m2643getXimpl(j), IntOffset.m2644getYimpl(j));
            long j3 = Placeable.access$getApparentToRealOffset-nOcc-ac(placeable);
            Placeable.access$placeAt-f8xVGno(placeable, IntOffsetKt.IntOffset(IntOffset.m2643getXimpl(IntOffset) + IntOffset.m2643getXimpl(j3), IntOffset.m2644getYimpl(IntOffset) + IntOffset.m2644getYimpl(j3)), f, function1);
        }
    }

    public final void placeWithLayer(@NotNull Placeable placeable, int i, int i2, float f, @NotNull Function1<? super GraphicsLayerScope, Unit> function1) {
        Intrinsics.checkNotNullParameter(placeable, "<this>");
        Intrinsics.checkNotNullParameter(function1, "layerBlock");
        long IntOffset = IntOffsetKt.IntOffset(i, i2);
        long j = Placeable.access$getApparentToRealOffset-nOcc-ac(placeable);
        Placeable.access$placeAt-f8xVGno(placeable, IntOffsetKt.IntOffset(IntOffset.m2643getXimpl(IntOffset) + IntOffset.m2643getXimpl(j), IntOffset.m2644getYimpl(IntOffset) + IntOffset.m2644getYimpl(j)), f, function1);
    }

    /* renamed from: placeWithLayer-aW-9-wM, reason: not valid java name */
    public final void m2077placeWithLayeraW9wM(@NotNull Placeable placeable, long j, float f, @NotNull Function1<? super GraphicsLayerScope, Unit> function1) {
        Intrinsics.checkNotNullParameter(placeable, "$this$placeWithLayer");
        Intrinsics.checkNotNullParameter(function1, "layerBlock");
        long j2 = Placeable.access$getApparentToRealOffset-nOcc-ac(placeable);
        Placeable.access$placeAt-f8xVGno(placeable, IntOffsetKt.IntOffset(IntOffset.m2643getXimpl(j) + IntOffset.m2643getXimpl(j2), IntOffset.m2644getYimpl(j) + IntOffset.m2644getYimpl(j2)), f, function1);
    }
}
