package androidx.compose.foundation.lazy.staggeredgrid;

import androidx.compose.foundation.ExperimentalFoundationApi;
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
@ExperimentalFoundationApi
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public interface StaggeredGridCells {

    /* compiled from: Taobao */
    @StabilityInferred(parameters = 0)
    public static final class Adaptive implements StaggeredGridCells {
        public static final int $stable = 0;
        private final float minSize;

        private Adaptive(float f) {
            this.minSize = f;
            if (!(Dp.compareTo-0680j_4(f, Dp.constructor-impl((float) 0)) > 0)) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
        }

        public /* synthetic */ Adaptive(float f, DefaultConstructorMarker defaultConstructorMarker) {
            this(f);
        }

        @Override // androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
        @NotNull
        public List<Integer> calculateCrossAxisCellSizes(@NotNull Density density, int i, int i2) {
            List<Integer> calculateCellsCrossAxisSizeImpl;
            Intrinsics.checkNotNullParameter(density, "<this>");
            calculateCellsCrossAxisSizeImpl = LazyStaggeredGridCellsKt.calculateCellsCrossAxisSizeImpl(i, Math.max((i + i2) / (density.roundToPx-0680j_4(this.minSize) + i2), 1), i2);
            return calculateCellsCrossAxisSizeImpl;
        }

        public boolean equals(@Nullable Object obj) {
            return (obj instanceof Adaptive) && Dp.equals-impl0(this.minSize, ((Adaptive) obj).minSize);
        }

        public int hashCode() {
            return Dp.hashCode-impl(this.minSize);
        }
    }

    /* compiled from: Taobao */
    @StabilityInferred(parameters = 0)
    public static final class Fixed implements StaggeredGridCells {
        public static final int $stable = 0;
        private final int count;

        public Fixed(int i) {
            this.count = i;
            if (!(i > 0)) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
        }

        @Override // androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
        @NotNull
        public List<Integer> calculateCrossAxisCellSizes(@NotNull Density density, int i, int i2) {
            List<Integer> calculateCellsCrossAxisSizeImpl;
            Intrinsics.checkNotNullParameter(density, "<this>");
            calculateCellsCrossAxisSizeImpl = LazyStaggeredGridCellsKt.calculateCellsCrossAxisSizeImpl(i, this.count, i2);
            return calculateCellsCrossAxisSizeImpl;
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
