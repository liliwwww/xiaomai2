package androidx.recyclerview.widget;

import android.graphics.PointF;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView$SmoothScroller;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public class LinearSnapHelper extends SnapHelper {
    private static final float INVALID_DISTANCE = 1.0f;

    @Nullable
    private OrientationHelper mHorizontalHelper;

    @Nullable
    private OrientationHelper mVerticalHelper;

    private float computeDistancePerChild(RecyclerView$LayoutManager recyclerView$LayoutManager, OrientationHelper orientationHelper) {
        int childCount = recyclerView$LayoutManager.getChildCount();
        if (childCount == 0) {
            return 1.0f;
        }
        View view = null;
        View view2 = null;
        int i = Integer.MAX_VALUE;
        int i2 = Integer.MIN_VALUE;
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = recyclerView$LayoutManager.getChildAt(i3);
            int position = recyclerView$LayoutManager.getPosition(childAt);
            if (position != -1) {
                if (position < i) {
                    view = childAt;
                    i = position;
                }
                if (position > i2) {
                    view2 = childAt;
                    i2 = position;
                }
            }
        }
        if (view == null || view2 == null) {
            return 1.0f;
        }
        int max = Math.max(orientationHelper.getDecoratedEnd(view), orientationHelper.getDecoratedEnd(view2)) - Math.min(orientationHelper.getDecoratedStart(view), orientationHelper.getDecoratedStart(view2));
        if (max == 0) {
            return 1.0f;
        }
        return (max * 1.0f) / ((i2 - i) + 1);
    }

    private int distanceToCenter(@NonNull View view, OrientationHelper orientationHelper) {
        return (orientationHelper.getDecoratedStart(view) + (orientationHelper.getDecoratedMeasurement(view) / 2)) - (orientationHelper.getStartAfterPadding() + (orientationHelper.getTotalSpace() / 2));
    }

    private int estimateNextPositionDiffForFling(RecyclerView$LayoutManager recyclerView$LayoutManager, OrientationHelper orientationHelper, int i, int i2) {
        int[] calculateScrollDistance = calculateScrollDistance(i, i2);
        float computeDistancePerChild = computeDistancePerChild(recyclerView$LayoutManager, orientationHelper);
        if (computeDistancePerChild <= 0.0f) {
            return 0;
        }
        return Math.round((Math.abs(calculateScrollDistance[0]) > Math.abs(calculateScrollDistance[1]) ? calculateScrollDistance[0] : calculateScrollDistance[1]) / computeDistancePerChild);
    }

    @Nullable
    private View findCenterView(RecyclerView$LayoutManager recyclerView$LayoutManager, OrientationHelper orientationHelper) {
        int childCount = recyclerView$LayoutManager.getChildCount();
        View view = null;
        if (childCount == 0) {
            return null;
        }
        int startAfterPadding = orientationHelper.getStartAfterPadding() + (orientationHelper.getTotalSpace() / 2);
        int i = Integer.MAX_VALUE;
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = recyclerView$LayoutManager.getChildAt(i2);
            int abs = Math.abs((orientationHelper.getDecoratedStart(childAt) + (orientationHelper.getDecoratedMeasurement(childAt) / 2)) - startAfterPadding);
            if (abs < i) {
                view = childAt;
                i = abs;
            }
        }
        return view;
    }

    @NonNull
    private OrientationHelper getHorizontalHelper(@NonNull RecyclerView$LayoutManager recyclerView$LayoutManager) {
        OrientationHelper orientationHelper = this.mHorizontalHelper;
        if (orientationHelper == null || orientationHelper.mLayoutManager != recyclerView$LayoutManager) {
            this.mHorizontalHelper = OrientationHelper.createHorizontalHelper(recyclerView$LayoutManager);
        }
        return this.mHorizontalHelper;
    }

    @NonNull
    private OrientationHelper getVerticalHelper(@NonNull RecyclerView$LayoutManager recyclerView$LayoutManager) {
        OrientationHelper orientationHelper = this.mVerticalHelper;
        if (orientationHelper == null || orientationHelper.mLayoutManager != recyclerView$LayoutManager) {
            this.mVerticalHelper = OrientationHelper.createVerticalHelper(recyclerView$LayoutManager);
        }
        return this.mVerticalHelper;
    }

    public int[] calculateDistanceToFinalSnap(@NonNull RecyclerView$LayoutManager recyclerView$LayoutManager, @NonNull View view) {
        int[] iArr = new int[2];
        if (recyclerView$LayoutManager.canScrollHorizontally()) {
            iArr[0] = distanceToCenter(view, getHorizontalHelper(recyclerView$LayoutManager));
        } else {
            iArr[0] = 0;
        }
        if (recyclerView$LayoutManager.canScrollVertically()) {
            iArr[1] = distanceToCenter(view, getVerticalHelper(recyclerView$LayoutManager));
        } else {
            iArr[1] = 0;
        }
        return iArr;
    }

    public View findSnapView(RecyclerView$LayoutManager recyclerView$LayoutManager) {
        if (recyclerView$LayoutManager.canScrollVertically()) {
            return findCenterView(recyclerView$LayoutManager, getVerticalHelper(recyclerView$LayoutManager));
        }
        if (recyclerView$LayoutManager.canScrollHorizontally()) {
            return findCenterView(recyclerView$LayoutManager, getHorizontalHelper(recyclerView$LayoutManager));
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int findTargetSnapPosition(RecyclerView$LayoutManager recyclerView$LayoutManager, int i, int i2) {
        int itemCount;
        View findSnapView;
        int position;
        int i3;
        PointF computeScrollVectorForPosition;
        int i4;
        int i5;
        if (!(recyclerView$LayoutManager instanceof RecyclerView$SmoothScroller.ScrollVectorProvider) || (itemCount = recyclerView$LayoutManager.getItemCount()) == 0 || (findSnapView = findSnapView(recyclerView$LayoutManager)) == null || (position = recyclerView$LayoutManager.getPosition(findSnapView)) == -1 || (computeScrollVectorForPosition = ((RecyclerView$SmoothScroller.ScrollVectorProvider) recyclerView$LayoutManager).computeScrollVectorForPosition(itemCount - 1)) == null) {
            return -1;
        }
        if (recyclerView$LayoutManager.canScrollHorizontally()) {
            i4 = estimateNextPositionDiffForFling(recyclerView$LayoutManager, getHorizontalHelper(recyclerView$LayoutManager), i, 0);
            if (computeScrollVectorForPosition.x < 0.0f) {
                i4 = -i4;
            }
        } else {
            i4 = 0;
        }
        if (recyclerView$LayoutManager.canScrollVertically()) {
            i5 = estimateNextPositionDiffForFling(recyclerView$LayoutManager, getVerticalHelper(recyclerView$LayoutManager), 0, i2);
            if (computeScrollVectorForPosition.y < 0.0f) {
                i5 = -i5;
            }
        } else {
            i5 = 0;
        }
        if (recyclerView$LayoutManager.canScrollVertically()) {
            i4 = i5;
        }
        if (i4 == 0) {
            return -1;
        }
        int i6 = position + i4;
        int i7 = i6 >= 0 ? i6 : 0;
        return i7 >= itemCount ? i3 : i7;
    }
}
