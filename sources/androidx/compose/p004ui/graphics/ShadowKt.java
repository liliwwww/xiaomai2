package androidx.compose.p004ui.graphics;

import android.taobao.windvane.extra.p002uc.AliRequestAdapter;
import androidx.compose.p004ui.geometry.OffsetKt;
import androidx.compose.p004ui.util.MathHelpersKt;
import androidx.compose.runtime.Stable;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public final class ShadowKt {
    @Stable
    @NotNull
    public static final Shadow lerp(@NotNull Shadow shadow, @NotNull Shadow shadow2, float f) {
        Intrinsics.checkNotNullParameter(shadow, "start");
        Intrinsics.checkNotNullParameter(shadow2, AliRequestAdapter.PHASE_STOP);
        return new Shadow(ColorKt.m2838lerpjxsXWHM(shadow.m3072getColor0d7_KjU(), shadow2.m3072getColor0d7_KjU(), f), OffsetKt.m2579lerpWko1d7g(shadow.m3073getOffsetF1C5BW0(), shadow2.m3073getOffsetF1C5BW0(), f), MathHelpersKt.lerp(shadow.getBlurRadius(), shadow2.getBlurRadius(), f), null);
    }
}
