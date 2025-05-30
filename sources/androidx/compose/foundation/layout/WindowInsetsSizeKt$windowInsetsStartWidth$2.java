package androidx.compose.foundation.layout;

import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class WindowInsetsSizeKt$windowInsetsStartWidth$2 extends Lambda implements Function3<WindowInsets, LayoutDirection, Density, Integer> {
    public static final WindowInsetsSizeKt$windowInsetsStartWidth$2 INSTANCE = new WindowInsetsSizeKt$windowInsetsStartWidth$2();

    WindowInsetsSizeKt$windowInsetsStartWidth$2() {
        super(3);
    }

    @NotNull
    public final Integer invoke(@NotNull WindowInsets windowInsets, @NotNull LayoutDirection layoutDirection, @NotNull Density density) {
        Intrinsics.checkNotNullParameter(windowInsets, "$this$$receiver");
        Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
        Intrinsics.checkNotNullParameter(density, "density");
        return Integer.valueOf(layoutDirection == LayoutDirection.Ltr ? windowInsets.getLeft(density, layoutDirection) : windowInsets.getRight(density, layoutDirection));
    }
}
