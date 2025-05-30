package androidx.compose.material;

import androidx.compose.foundation.ScrollState;
import androidx.compose.p004ui.unit.Density;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.d;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes.dex */
final class ScrollableTabData {

    @NotNull
    private final CoroutineScope coroutineScope;

    @NotNull
    private final ScrollState scrollState;

    @Nullable
    private Integer selectedTab;

    public ScrollableTabData(@NotNull ScrollState scrollState, @NotNull CoroutineScope coroutineScope) {
        Intrinsics.checkNotNullParameter(scrollState, "scrollState");
        Intrinsics.checkNotNullParameter(coroutineScope, "coroutineScope");
        this.scrollState = scrollState;
        this.coroutineScope = coroutineScope;
    }

    private final int calculateTabOffset(TabPosition tabPosition, Density density, int i, List<TabPosition> list) {
        int mo1277roundToPx0680j_4 = density.mo1277roundToPx0680j_4(((TabPosition) CollectionsKt.last(list)).m2287getRightD9Ej5fM()) + i;
        int maxValue = mo1277roundToPx0680j_4 - this.scrollState.getMaxValue();
        return RangesKt.coerceIn(density.mo1277roundToPx0680j_4(tabPosition.m2286getLeftD9Ej5fM()) - ((maxValue / 2) - (density.mo1277roundToPx0680j_4(tabPosition.m2288getWidthD9Ej5fM()) / 2)), 0, RangesKt.coerceAtLeast(mo1277roundToPx0680j_4 - maxValue, 0));
    }

    public final void onLaidOut(@NotNull Density density, int i, @NotNull List<TabPosition> list, int i2) {
        int calculateTabOffset;
        Intrinsics.checkNotNullParameter(density, "density");
        Intrinsics.checkNotNullParameter(list, "tabPositions");
        Integer num = this.selectedTab;
        if (num != null && num.intValue() == i2) {
            return;
        }
        this.selectedTab = Integer.valueOf(i2);
        TabPosition tabPosition = (TabPosition) CollectionsKt.getOrNull(list, i2);
        if (tabPosition == null || this.scrollState.getValue() == (calculateTabOffset = calculateTabOffset(tabPosition, density, i, list))) {
            return;
        }
        d.d(this.coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new ScrollableTabData$onLaidOut$1$1(this, calculateTabOffset, null), 3, (Object) null);
    }
}
