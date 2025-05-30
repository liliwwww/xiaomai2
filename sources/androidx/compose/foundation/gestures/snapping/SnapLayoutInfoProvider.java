package androidx.compose.foundation.gestures.snapping;

import androidx.compose.foundation.ExperimentalFoundationApi;
import androidx.compose.p004ui.unit.Density;
import kotlin.ranges.ClosedFloatingPointRange;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@ExperimentalFoundationApi
/* loaded from: classes2.dex */
public interface SnapLayoutInfoProvider {
    float calculateApproachOffset(@NotNull Density density, float f);

    float calculateSnapStepSize(@NotNull Density density);

    @NotNull
    ClosedFloatingPointRange<Float> calculateSnappingOffsetBounds(@NotNull Density density);
}
