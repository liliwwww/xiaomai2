package androidx.compose.foundation.pager;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.lazy.LazyListItemInfo;
import androidx.compose.foundation.lazy.LazyListLayoutInfo;
import java.util.List;
import kotlin.collections.CollectionsKt;
import org.jetbrains.annotations.NotNull;
import tb.ld2;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class PagerStateKt$EmptyLayoutInfo$1 implements LazyListLayoutInfo {
    private final int totalItemsCount;
    private final int viewportEndOffset;
    private final int viewportStartOffset;

    @NotNull
    private final List<LazyListItemInfo> visibleItemsInfo = CollectionsKt.emptyList();

    PagerStateKt$EmptyLayoutInfo$1() {
    }

    public /* synthetic */ int getAfterContentPadding() {
        return ld2.a(this);
    }

    public /* synthetic */ int getBeforeContentPadding() {
        return ld2.b(this);
    }

    public /* synthetic */ Orientation getOrientation() {
        return ld2.c(this);
    }

    public /* synthetic */ boolean getReverseLayout() {
        return ld2.d(this);
    }

    public int getTotalItemsCount() {
        return this.totalItemsCount;
    }

    public int getViewportEndOffset() {
        return this.viewportEndOffset;
    }

    /* renamed from: getViewportSize-YbymL2g, reason: not valid java name */
    public /* synthetic */ long m514getViewportSizeYbymL2g() {
        return ld2.e(this);
    }

    public int getViewportStartOffset() {
        return this.viewportStartOffset;
    }

    @NotNull
    public List<LazyListItemInfo> getVisibleItemsInfo() {
        return this.visibleItemsInfo;
    }
}
