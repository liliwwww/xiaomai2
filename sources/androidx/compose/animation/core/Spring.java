package androidx.compose.animation.core;

import androidx.compose.runtime.internal.StabilityInferred;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@StabilityInferred(parameters = 0)
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class Spring {
    public static final int $stable = 0;
    public static final float DampingRatioHighBouncy = 0.2f;
    public static final float DampingRatioLowBouncy = 0.75f;
    public static final float DampingRatioMediumBouncy = 0.5f;
    public static final float DampingRatioNoBouncy = 1.0f;
    public static final float DefaultDisplacementThreshold = 0.01f;

    @NotNull
    public static final Spring INSTANCE = new Spring();
    public static final float StiffnessHigh = 10000.0f;
    public static final float StiffnessLow = 200.0f;
    public static final float StiffnessMedium = 1500.0f;
    public static final float StiffnessMediumLow = 400.0f;
    public static final float StiffnessVeryLow = 50.0f;

    private Spring() {
    }
}
