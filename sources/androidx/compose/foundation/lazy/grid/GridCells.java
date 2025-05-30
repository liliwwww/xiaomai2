package androidx.compose.foundation.lazy.grid;

import androidx.compose.runtime.Stable;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@Stable
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public interface GridCells {

    /* compiled from: Taobao */
    @StabilityInferred(parameters = 0)
    public static final class Adaptive implements GridCells {
        public static final int $stable = 0;
        private final float minSize;

        private Adaptive(float f) {
            this.minSize = f;
            if (!(Dp.m2141compareTo0680j_4(f, Dp.m2142constructorimpl((float) 0)) > 0)) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
        }

        public /* synthetic */ Adaptive(float f, DefaultConstructorMarker defaultConstructorMarker) {
            this(f);
        }

        @Override // androidx.compose.foundation.lazy.grid.GridCells
        @NotNull
        public List<Integer> calculateCrossAxisCellSizes(@NotNull Density density, int i, int i2) {
            Intrinsics.checkNotNullParameter(density, "<this>");
            return LazyGridDslKt.access$calculateCellsCrossAxisSizeImpl(i, Math.max((i + i2) / (density.mo319roundToPx0680j_4(this.minSize) + i2), 1), i2);
        }

        public boolean equals(@Nullable Object obj) {
            return (obj instanceof Adaptive) && Dp.m2147equalsimpl0(this.minSize, ((Adaptive) obj).minSize);
        }

        public int hashCode() {
            return Dp.m2148hashCodeimpl(this.minSize);
        }
    }

    /* compiled from: Taobao */
    @StabilityInferred(parameters = 0)
    public static final class Fixed implements GridCells {
        public static final int $stable = 0;
        private final int count;

        public Fixed(int i) {
            this.count = i;
            if (!(i > 0)) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
        }

        @Override // androidx.compose.foundation.lazy.grid.GridCells
        @NotNull
        public List<Integer> calculateCrossAxisCellSizes(@NotNull Density density, int i, int i2) {
            Intrinsics.checkNotNullParameter(density, "<this>");
            return LazyGridDslKt.access$calculateCellsCrossAxisSizeImpl(i, this.count, i2);
        }

        public boolean equals(@Nullable Object obj) {
            return (obj instanceof Fixed) && this.count == ((Fixed) obj).count;
        }

        public int hashCode() {
            return -this.count;
        }
    }

    @NotNull
    List<Integer> calculateCrossAxisCellSizes(@NotNull Density density, int i, int i2);
}
