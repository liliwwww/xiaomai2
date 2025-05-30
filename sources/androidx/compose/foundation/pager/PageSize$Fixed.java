package androidx.compose.foundation.pager;

import androidx.compose.foundation.ExperimentalFoundationApi;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.unit.Density;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@StabilityInferred(parameters = 0)
@ExperimentalFoundationApi
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class PageSize$Fixed implements PageSize {
    public static final int $stable = 0;
    private final float pageSize;

    private PageSize$Fixed(float f) {
        this.pageSize = f;
    }

    public /* synthetic */ PageSize$Fixed(float f, DefaultConstructorMarker defaultConstructorMarker) {
        this(f);
    }

    public int calculateMainAxisPageSize(@NotNull Density density, int i, int i2) {
        Intrinsics.checkNotNullParameter(density, "<this>");
        return density.mo319roundToPx0680j_4(this.pageSize);
    }

    /* renamed from: getPageSize-D9Ej5fM, reason: not valid java name */
    public final float m341getPageSizeD9Ej5fM() {
        return this.pageSize;
    }
}
