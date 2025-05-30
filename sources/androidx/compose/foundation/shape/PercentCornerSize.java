package androidx.compose.foundation.shape;

import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.platform.InspectableValue;
import androidx.compose.ui.unit.Density;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.h82;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class PercentCornerSize implements CornerSize, InspectableValue {
    private final float percent;

    public PercentCornerSize(float f) {
        this.percent = f;
        if (f < 0.0f || f > 100.0f) {
            throw new IllegalArgumentException("The percent should be in the range of [0, 100]");
        }
    }

    private final float component1() {
        return this.percent;
    }

    public static /* synthetic */ PercentCornerSize copy$default(PercentCornerSize percentCornerSize, float f, int i, Object obj) {
        if ((i & 1) != 0) {
            f = percentCornerSize.percent;
        }
        return percentCornerSize.copy(f);
    }

    @NotNull
    public final PercentCornerSize copy(float f) {
        return new PercentCornerSize(f);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof PercentCornerSize) && Float.compare(this.percent, ((PercentCornerSize) obj).percent) == 0;
    }

    @Override // androidx.compose.ui.platform.InspectableValue
    public /* synthetic */ Sequence getInspectableElements() {
        return h82.a(this);
    }

    @Override // androidx.compose.ui.platform.InspectableValue
    public /* synthetic */ String getNameFallback() {
        return h82.b(this);
    }

    public int hashCode() {
        return Float.floatToIntBits(this.percent);
    }

    @Override // androidx.compose.foundation.shape.CornerSize
    /* renamed from: toPx-TmRCtEA */
    public float mo536toPxTmRCtEA(long j, @NotNull Density density) {
        Intrinsics.checkNotNullParameter(density, "density");
        return Size.getMinDimension-impl(j) * (this.percent / 100.0f);
    }

    @NotNull
    public String toString() {
        return "CornerSize(size = " + this.percent + "%)";
    }

    @Override // androidx.compose.ui.platform.InspectableValue
    @NotNull
    public String getValueOverride() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.percent);
        sb.append('%');
        return sb.toString();
    }
}
