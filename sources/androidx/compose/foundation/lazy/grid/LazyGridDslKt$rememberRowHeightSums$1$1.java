package androidx.compose.foundation.lazy.grid;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
final class LazyGridDslKt$rememberRowHeightSums$1$1 extends Lambda implements Function2<Density, Constraints, List<Integer>> {
    final /* synthetic */ PaddingValues $contentPadding;
    final /* synthetic */ GridCells $rows;
    final /* synthetic */ Arrangement.Vertical $verticalArrangement;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    LazyGridDslKt$rememberRowHeightSums$1$1(PaddingValues paddingValues, GridCells gridCells, Arrangement.Vertical vertical) {
        super(2);
        this.$contentPadding = paddingValues;
        this.$rows = gridCells;
        this.$verticalArrangement = vertical;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return m290invoke0kLqBqw((Density) obj, ((Constraints) obj2).m2128unboximpl());
    }

    @NotNull
    /* renamed from: invoke-0kLqBqw, reason: not valid java name */
    public final List<Integer> m290invoke0kLqBqw(@NotNull Density density, long j) {
        Intrinsics.checkNotNullParameter(density, "$this$null");
        if (!(Constraints.m2121getMaxHeightimpl(j) != Integer.MAX_VALUE)) {
            throw new IllegalArgumentException("LazyHorizontalGrid's height should be bound by parent.".toString());
        }
        List<Integer> mutableList = CollectionsKt.toMutableList(this.$rows.calculateCrossAxisCellSizes(density, Constraints.m2121getMaxHeightimpl(j) - density.mo319roundToPx0680j_4(Dp.m2142constructorimpl(this.$contentPadding.mo219calculateTopPaddingD9Ej5fM() + this.$contentPadding.mo216calculateBottomPaddingD9Ej5fM())), density.mo319roundToPx0680j_4(this.$verticalArrangement.getSpacing-D9Ej5fM())));
        int size = mutableList.size();
        for (int i = 1; i < size; i++) {
            mutableList.set(i, Integer.valueOf(mutableList.get(i).intValue() + mutableList.get(i - 1).intValue()));
        }
        return mutableList;
    }
}
