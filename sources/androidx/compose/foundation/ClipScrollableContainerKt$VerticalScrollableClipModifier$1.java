package androidx.compose.foundation;

import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Outline;
import androidx.compose.ui.graphics.Outline$Rectangle;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class ClipScrollableContainerKt$VerticalScrollableClipModifier$1 implements Shape {
    ClipScrollableContainerKt$VerticalScrollableClipModifier$1() {
    }

    @NotNull
    /* renamed from: createOutline-Pq9zytI, reason: not valid java name */
    public Outline m150createOutlinePq9zytI(long j, @NotNull LayoutDirection layoutDirection, @NotNull Density density) {
        Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
        Intrinsics.checkNotNullParameter(density, "density");
        float f = density.roundToPx-0680j_4(ClipScrollableContainerKt.getMaxSupportedElevation());
        return new Outline$Rectangle(new Rect(-f, 0.0f, Size.getWidth-impl(j) + f, Size.getHeight-impl(j)));
    }
}
