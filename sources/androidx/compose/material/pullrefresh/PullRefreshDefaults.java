package androidx.compose.material.pullrefresh;

import androidx.compose.material.ExperimentalMaterialApi;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.unit.Dp;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@StabilityInferred(parameters = 0)
@ExperimentalMaterialApi
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class PullRefreshDefaults {
    public static final int $stable = 0;

    @NotNull
    public static final PullRefreshDefaults INSTANCE = new PullRefreshDefaults();
    private static final float RefreshThreshold = Dp.constructor-impl(80);
    private static final float RefreshingOffset = Dp.constructor-impl(56);

    private PullRefreshDefaults() {
    }

    /* renamed from: getRefreshThreshold-D9Ej5fM, reason: not valid java name */
    public final float m887getRefreshThresholdD9Ej5fM() {
        return RefreshThreshold;
    }

    /* renamed from: getRefreshingOffset-D9Ej5fM, reason: not valid java name */
    public final float m888getRefreshingOffsetD9Ej5fM() {
        return RefreshingOffset;
    }
}
