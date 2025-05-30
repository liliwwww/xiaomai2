package androidx.compose.material;

import androidx.compose.p004ui.unit.Density;
import androidx.compose.runtime.Stable;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@Stable
@ExperimentalMaterialApi
/* loaded from: classes2.dex */
public interface ThresholdConfig {
    float computeThreshold(@NotNull Density density, float f, float f2);
}
