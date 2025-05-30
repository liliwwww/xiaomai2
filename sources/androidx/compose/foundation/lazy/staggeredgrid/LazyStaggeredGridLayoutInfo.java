package androidx.compose.foundation.lazy.staggeredgrid;

import androidx.compose.foundation.ExperimentalFoundationApi;
import androidx.compose.foundation.gestures.Orientation;
import java.util.List;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@ExperimentalFoundationApi
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public interface LazyStaggeredGridLayoutInfo {
    int getAfterContentPadding();

    int getBeforeContentPadding();

    @NotNull
    Orientation getOrientation();

    int getTotalItemsCount();

    int getViewportEndOffset();

    /* renamed from: getViewportSize-YbymL2g */
    long mo325getViewportSizeYbymL2g();

    int getViewportStartOffset();

    @NotNull
    List<LazyStaggeredGridItemInfo> getVisibleItemsInfo();
}
