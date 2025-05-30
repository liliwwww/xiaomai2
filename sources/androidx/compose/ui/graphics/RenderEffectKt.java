package androidx.compose.ui.graphics;

import androidx.compose.runtime.Stable;
import androidx.compose.ui.geometry.OffsetKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class RenderEffectKt {
    @Stable
    @NotNull
    /* renamed from: BlurEffect-3YTHUZs, reason: not valid java name */
    public static final BlurEffect m1204BlurEffect3YTHUZs(float f, float f2, int i) {
        return new BlurEffect((RenderEffect) null, f, f2, i, (DefaultConstructorMarker) null);
    }

    /* renamed from: BlurEffect-3YTHUZs$default, reason: not valid java name */
    public static /* synthetic */ BlurEffect m1205BlurEffect3YTHUZs$default(float f, float f2, int i, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            i = TileMode.Companion.getClamp-3opZhB0();
        }
        return m1204BlurEffect3YTHUZs(f, f2, i);
    }

    @Stable
    @NotNull
    public static final OffsetEffect OffsetEffect(float f, float f2) {
        return new OffsetEffect(null, OffsetKt.Offset(f, f2), null);
    }
}
