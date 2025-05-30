package androidx.compose.foundation.pager;

import androidx.compose.foundation.ExperimentalFoundationApi;
import androidx.compose.p004ui.unit.Density;
import androidx.compose.runtime.Stable;
import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@Stable
@ExperimentalFoundationApi
/* loaded from: classes2.dex */
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

    /* compiled from: Taobao */
    @StabilityInferred(parameters = 0)
    @ExperimentalFoundationApi
    /* loaded from: classes.dex */
    public static final class Fixed implements PageSize {
        public static final int $stable = 0;
        private final float pageSize;

        private Fixed(float f) {
            this.pageSize = f;
        }

        public /* synthetic */ Fixed(float f, DefaultConstructorMarker defaultConstructorMarker) {
            this(f);
        }

        @Override // androidx.compose.foundation.pager.PageSize
        public int calculateMainAxisPageSize(@NotNull Density density, int i, int i2) {
            Intrinsics.checkNotNullParameter(density, "<this>");
            return density.mo1277roundToPx0680j_4(this.pageSize);
        }

        /* renamed from: getPageSize-D9Ej5fM, reason: not valid java name */
        public final float m1646getPageSizeD9Ej5fM() {
            return this.pageSize;
        }
    }

    int calculateMainAxisPageSize(@NotNull Density density, int i, int i2);
}
