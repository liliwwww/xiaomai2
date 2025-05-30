package androidx.compose.foundation.lazy;

import androidx.compose.foundation.gestures.Orientation;
import org.jetbrains.annotations.NotNull;
import tb.ld2;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class LazyListLayoutInfo$DefaultImpls {
    @Deprecated
    public static int getAfterContentPadding(@NotNull LazyListLayoutInfo lazyListLayoutInfo) {
        return ld2.f(lazyListLayoutInfo);
    }

    @Deprecated
    public static int getBeforeContentPadding(@NotNull LazyListLayoutInfo lazyListLayoutInfo) {
        return ld2.g(lazyListLayoutInfo);
    }

    @Deprecated
    @NotNull
    public static Orientation getOrientation(@NotNull LazyListLayoutInfo lazyListLayoutInfo) {
        return ld2.h(lazyListLayoutInfo);
    }

    @Deprecated
    public static boolean getReverseLayout(@NotNull LazyListLayoutInfo lazyListLayoutInfo) {
        return ld2.i(lazyListLayoutInfo);
    }

    @Deprecated
    /* renamed from: getViewportSize-YbymL2g, reason: not valid java name */
    public static long m430getViewportSizeYbymL2g(@NotNull LazyListLayoutInfo lazyListLayoutInfo) {
        return ld2.j(lazyListLayoutInfo);
    }
}
