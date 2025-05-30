package androidx.compose.foundation;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Outline;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class ClipScrollableContainerKt {

    @NotNull
    private static final Modifier HorizontalScrollableClipModifier;
    private static final float MaxSupportedElevation = Dp.m2142constructorimpl(30);

    @NotNull
    private static final Modifier VerticalScrollableClipModifier;

    static {
        Modifier.Companion companion = Modifier.Companion;
        HorizontalScrollableClipModifier = ClipKt.clip(companion, new Shape() { // from class: androidx.compose.foundation.ClipScrollableContainerKt$HorizontalScrollableClipModifier$1
            @Override // androidx.compose.ui.graphics.Shape
            @NotNull
            /* renamed from: createOutline-Pq9zytI, reason: not valid java name */
            public Outline mo130createOutlinePq9zytI(long j, @NotNull LayoutDirection layoutDirection, @NotNull Density density) {
                Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
                Intrinsics.checkNotNullParameter(density, "density");
                float mo319roundToPx0680j_4 = density.mo319roundToPx0680j_4(ClipScrollableContainerKt.getMaxSupportedElevation());
                return new Outline.Rectangle(new Rect(0.0f, -mo319roundToPx0680j_4, Size.m903getWidthimpl(j), Size.m900getHeightimpl(j) + mo319roundToPx0680j_4));
            }
        });
        VerticalScrollableClipModifier = ClipKt.clip(companion, new VerticalScrollableClipModifier.1());
    }

    @NotNull
    public static final Modifier clipScrollableContainer(@NotNull Modifier modifier, @NotNull Orientation orientation) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(orientation, "orientation");
        return modifier.then(orientation == Orientation.Vertical ? VerticalScrollableClipModifier : HorizontalScrollableClipModifier);
    }

    public static final float getMaxSupportedElevation() {
        return MaxSupportedElevation;
    }
}
