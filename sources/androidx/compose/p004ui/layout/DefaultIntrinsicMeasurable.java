package androidx.compose.p004ui.layout;

import androidx.compose.p004ui.unit.Constraints;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public final class DefaultIntrinsicMeasurable implements Measurable {

    @NotNull
    private final IntrinsicMeasurable measurable;

    @NotNull
    private final IntrinsicMinMax minMax;

    @NotNull
    private final IntrinsicWidthHeight widthHeight;

    public DefaultIntrinsicMeasurable(@NotNull IntrinsicMeasurable intrinsicMeasurable, @NotNull IntrinsicMinMax intrinsicMinMax, @NotNull IntrinsicWidthHeight intrinsicWidthHeight) {
        Intrinsics.checkNotNullParameter(intrinsicMeasurable, "measurable");
        Intrinsics.checkNotNullParameter(intrinsicMinMax, "minMax");
        Intrinsics.checkNotNullParameter(intrinsicWidthHeight, "widthHeight");
        this.measurable = intrinsicMeasurable;
        this.minMax = intrinsicMinMax;
        this.widthHeight = intrinsicWidthHeight;
    }

    @NotNull
    public final IntrinsicMeasurable getMeasurable() {
        return this.measurable;
    }

    @NotNull
    public final IntrinsicMinMax getMinMax() {
        return this.minMax;
    }

    @Override // androidx.compose.p004ui.layout.IntrinsicMeasurable
    @Nullable
    public Object getParentData() {
        return this.measurable.getParentData();
    }

    @NotNull
    public final IntrinsicWidthHeight getWidthHeight() {
        return this.widthHeight;
    }

    @Override // androidx.compose.p004ui.layout.IntrinsicMeasurable
    public int maxIntrinsicHeight(int i) {
        return this.measurable.maxIntrinsicHeight(i);
    }

    @Override // androidx.compose.p004ui.layout.IntrinsicMeasurable
    public int maxIntrinsicWidth(int i) {
        return this.measurable.maxIntrinsicWidth(i);
    }

    @Override // androidx.compose.p004ui.layout.Measurable
    @NotNull
    /* renamed from: measure-BRTryo0, reason: not valid java name */
    public Placeable mo4187measureBRTryo0(long j) {
        if (this.widthHeight == IntrinsicWidthHeight.Width) {
            return new FixedSizeIntrinsicsPlaceable(this.minMax == IntrinsicMinMax.Max ? this.measurable.maxIntrinsicWidth(Constraints.m5183getMaxHeightimpl(j)) : this.measurable.minIntrinsicWidth(Constraints.m5183getMaxHeightimpl(j)), Constraints.m5183getMaxHeightimpl(j));
        }
        return new FixedSizeIntrinsicsPlaceable(Constraints.m5184getMaxWidthimpl(j), this.minMax == IntrinsicMinMax.Max ? this.measurable.maxIntrinsicHeight(Constraints.m5184getMaxWidthimpl(j)) : this.measurable.minIntrinsicHeight(Constraints.m5184getMaxWidthimpl(j)));
    }

    @Override // androidx.compose.p004ui.layout.IntrinsicMeasurable
    public int minIntrinsicHeight(int i) {
        return this.measurable.minIntrinsicHeight(i);
    }

    @Override // androidx.compose.p004ui.layout.IntrinsicMeasurable
    public int minIntrinsicWidth(int i) {
        return this.measurable.minIntrinsicWidth(i);
    }
}
