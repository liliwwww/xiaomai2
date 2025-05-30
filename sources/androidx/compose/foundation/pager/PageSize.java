package androidx.compose.foundation.pager;

import androidx.compose.foundation.ExperimentalFoundationApi;
import androidx.compose.runtime.Stable;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.unit.Density;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@Stable
@ExperimentalFoundationApi
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public interface PageSize {

    /* compiled from: Taobao */
    @StabilityInferred(parameters = 0)
    @ExperimentalFoundationApi
    public static final class Fill implements PageSize {
        public static final int $stable = 0;

        @NotNull
        public static final Fill INSTANCE = new Fill();

        private Fill() {
        }

        @Override // androidx.compose.foundation.pager.PageSize
        public int calculateMainAxisPageSize(@NotNull Density density, int i, int i2) {
            Intrinsics.checkNotNullParameter(density, "<this>");
            return i;
        }
    }

    int calculateMainAxisPageSize(@NotNull Density density, int i, int i2);
}
