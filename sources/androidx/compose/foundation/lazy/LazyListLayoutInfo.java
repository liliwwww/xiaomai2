package androidx.compose.foundation.lazy;

import androidx.compose.foundation.gestures.Orientation;
import java.util.List;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public interface LazyListLayoutInfo {
    int getAfterContentPadding();

    int getBeforeContentPadding();

    @NotNull
    Orientation getOrientation();

    boolean getReverseLayout();

    int getTotalItemsCount();

    int getViewportEndOffset();

    /* renamed from: getViewportSize-YbymL2g, reason: not valid java name */
    long mo261getViewportSizeYbymL2g();

    int getViewportStartOffset();

    @NotNull
    List<LazyListItemInfo> getVisibleItemsInfo();
}
