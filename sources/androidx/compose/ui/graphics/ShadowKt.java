package androidx.compose.ui.graphics;

import androidx.compose.runtime.Stable;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.util.MathHelpersKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class ShadowKt {
    @Stable
    @NotNull
    public static final Shadow lerp(@NotNull Shadow shadow, @NotNull Shadow shadow2, float f) {
        Intrinsics.checkNotNullParameter(shadow, "start");
        Intrinsics.checkNotNullParameter(shadow2, "stop");
        return new Shadow(ColorKt.m1071lerpjxsXWHM(shadow.m1229getColor0d7_KjU(), shadow2.m1229getColor0d7_KjU(), f), OffsetKt.lerp-Wko1d7g(shadow.m1230getOffsetF1C5BW0(), shadow2.m1230getOffsetF1C5BW0(), f), MathHelpersKt.lerp(shadow.getBlurRadius(), shadow2.getBlurRadius(), f), null);
    }
}
