package androidx.compose.foundation.lazy.grid;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.ui.unit.IntSize;
import java.util.List;
import kotlin.collections.CollectionsKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class EmptyLazyGridLayoutInfo implements LazyGridLayoutInfo {
    private static final int afterContentPadding = 0;
    private static final int beforeContentPadding = 0;
    private static final boolean reverseLayout = false;
    private static final int totalItemsCount = 0;
    private static final int viewportEndOffset = 0;
    private static final int viewportStartOffset = 0;

    @NotNull
    public static final EmptyLazyGridLayoutInfo INSTANCE = new EmptyLazyGridLayoutInfo();

    @NotNull
    private static final List<LazyGridItemInfo> visibleItemsInfo = CollectionsKt.emptyList();
    private static final long viewportSize = IntSize.Companion.m2690getZeroYbymL2g();

    @NotNull
    private static final Orientation orientation = Orientation.Vertical;

    private EmptyLazyGridLayoutInfo() {
    }

    public int getAfterContentPadding() {
        return afterContentPadding;
    }

    public int getBeforeContentPadding() {
        return beforeContentPadding;
    }

    @NotNull
    public Orientation getOrientation() {
        return orientation;
    }

    public boolean getReverseLayout() {
        return reverseLayout;
    }

    public int getTotalItemsCount() {
        return totalItemsCount;
    }

    public int getViewportEndOffset() {
        return viewportEndOffset;
    }

    /* renamed from: getViewportSize-YbymL2g, reason: not valid java name */
    public long m438getViewportSizeYbymL2g() {
        return viewportSize;
    }

    public int getViewportStartOffset() {
        return viewportStartOffset;
    }

    @NotNull
    public List<LazyGridItemInfo> getVisibleItemsInfo() {
        return visibleItemsInfo;
    }
}
