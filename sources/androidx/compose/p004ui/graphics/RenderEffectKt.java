package androidx.compose.p004ui.graphics;

import androidx.compose.p004ui.geometry.OffsetKt;
import androidx.compose.runtime.Stable;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public final class RenderEffectKt {
    @Stable
    @NotNull
    /* renamed from: BlurEffect-3YTHUZs, reason: not valid java name */
    public static final BlurEffect m3055BlurEffect3YTHUZs(float f, float f2, int i) {
        return new BlurEffect(null, f, f2, i, null);
    }

    /* renamed from: BlurEffect-3YTHUZs$default, reason: not valid java name */
    public static /* synthetic */ BlurEffect m3056BlurEffect3YTHUZs$default(float f, float f2, int i, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            i = TileMode.Companion.m3112getClamp3opZhB0();
        }
        return m3055BlurEffect3YTHUZs(f, f2, i);
    }

    @Stable
    @NotNull
    public static final OffsetEffect OffsetEffect(float f, float f2) {
        return new OffsetEffect(null, OffsetKt.Offset(f, f2), null);
    }
}
