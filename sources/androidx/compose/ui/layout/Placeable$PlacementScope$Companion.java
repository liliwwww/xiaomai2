package androidx.compose.ui.layout;

import androidx.compose.ui.ExperimentalComposeUiApi;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.LayoutNodeLayoutDelegate;
import androidx.compose.ui.node.LookaheadCapablePlaceable;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class Placeable$PlacementScope$Companion extends Placeable.PlacementScope {
    private Placeable$PlacementScope$Companion() {
    }

    public /* synthetic */ Placeable$PlacementScope$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean configureForPlacingForAlignment(LookaheadCapablePlaceable lookaheadCapablePlaceable) {
        boolean z = false;
        if (lookaheadCapablePlaceable == null) {
            Placeable.PlacementScope.access$set_coordinates$cp((LayoutCoordinates) null);
            Placeable.PlacementScope.access$setLayoutDelegate$cp((LayoutNodeLayoutDelegate) null);
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
        Placeable.PlacementScope.access$setLayoutDelegate$cp(lookaheadCapablePlaceable.getLayoutNode().getLayoutDelegate$ui_release());
        if (lookaheadCapablePlaceable.isPlacingForAlignment$ui_release() || lookaheadCapablePlaceable.isShallowPlacing$ui_release()) {
            Placeable.PlacementScope.access$set_coordinates$cp((LayoutCoordinates) null);
        } else {
            Placeable.PlacementScope.access$set_coordinates$cp(lookaheadCapablePlaceable.getCoordinates());
        }
        return isPlacingForAlignment$ui_release;
    }

    @ExperimentalComposeUiApi
    public static /* synthetic */ void getCoordinates$annotations() {
    }

    public final void executeWithRtlMirroringValues(int i, @NotNull LayoutDirection layoutDirection, @Nullable LookaheadCapablePlaceable lookaheadCapablePlaceable, @NotNull Function1<? super Placeable.PlacementScope, Unit> function1) {
        Intrinsics.checkNotNullParameter(layoutDirection, "parentLayoutDirection");
        Intrinsics.checkNotNullParameter(function1, "block");
        LayoutCoordinates access$get_coordinates$cp = Placeable.PlacementScope.access$get_coordinates$cp();
        Placeable$PlacementScope$Companion placeable$PlacementScope$Companion = Placeable.PlacementScope.Companion;
        int parentWidth = placeable$PlacementScope$Companion.getParentWidth();
        LayoutDirection parentLayoutDirection = placeable$PlacementScope$Companion.getParentLayoutDirection();
        LayoutNodeLayoutDelegate access$getLayoutDelegate$cp = Placeable.PlacementScope.access$getLayoutDelegate$cp();
        Placeable.PlacementScope.access$setParentWidth$cp(i);
        Placeable.PlacementScope.access$setParentLayoutDirection$cp(layoutDirection);
        boolean configureForPlacingForAlignment = configureForPlacingForAlignment(lookaheadCapablePlaceable);
        function1.invoke(this);
        if (lookaheadCapablePlaceable != null) {
            lookaheadCapablePlaceable.setPlacingForAlignment$ui_release(configureForPlacingForAlignment);
        }
        Placeable.PlacementScope.access$setParentWidth$cp(parentWidth);
        Placeable.PlacementScope.access$setParentLayoutDirection$cp(parentLayoutDirection);
        Placeable.PlacementScope.access$set_coordinates$cp(access$get_coordinates$cp);
        Placeable.PlacementScope.access$setLayoutDelegate$cp(access$getLayoutDelegate$cp);
    }

    @Nullable
    public LayoutCoordinates getCoordinates() {
        LayoutNodeLayoutDelegate access$getLayoutDelegate$cp = Placeable.PlacementScope.access$getLayoutDelegate$cp();
        if (access$getLayoutDelegate$cp != null) {
            access$getLayoutDelegate$cp.setCoordinatesAccessedDuringPlacement(true);
        }
        return Placeable.PlacementScope.access$get_coordinates$cp();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public LayoutDirection getParentLayoutDirection() {
        return Placeable.PlacementScope.access$getParentLayoutDirection$cp();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int getParentWidth() {
        return Placeable.PlacementScope.access$getParentWidth$cp();
    }
}
