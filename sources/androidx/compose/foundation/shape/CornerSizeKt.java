package androidx.compose.foundation.shape;

import androidx.compose.runtime.Stable;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class CornerSizeKt {

    @NotNull
    private static final CornerSize ZeroCornerSize = new CornerSizeKt$ZeroCornerSize$1();

    @Stable
    @NotNull
    public static final CornerSize CornerSize(float f) {
        return new PxCornerSize(f);
    }

    @Stable
    @NotNull
    /* renamed from: CornerSize-0680j_4, reason: not valid java name */
    public static final CornerSize m537CornerSize0680j_4(float f) {
        return new DpCornerSize(f, null);
    }

    @NotNull
    public static final CornerSize getZeroCornerSize() {
        return ZeroCornerSize;
    }

    @Stable
    public static /* synthetic */ void getZeroCornerSize$annotations() {
    }

    @Stable
    @NotNull
    public static final CornerSize CornerSize(int i) {
        return new PercentCornerSize(i);
    }
}
