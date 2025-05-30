package androidx.recyclerview.widget;

import android.graphics.PointF;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView$SmoothScroller;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public class PagerSnapHelper extends SnapHelper {
    private static final int MAX_SCROLL_ON_FLING_DURATION = 100;

    @Nullable
    private OrientationHelper mHorizontalHelper;

    @Nullable
    private OrientationHelper mVerticalHelper;

    private int distanceToCenter(@NonNull View view, OrientationHelper orientationHelper) {
        return (orientationHelper.getDecoratedStart(view) + (orientationHelper.getDecoratedMeasurement(view) / 2)) - (orientationHelper.getStartAfterPadding() + (orientationHelper.getTotalSpace() / 2));
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

    @Nullable
    private OrientationHelper getOrientationHelper(RecyclerView$LayoutManager recyclerView$LayoutManager) {
        if (recyclerView$LayoutManager.canScrollVertically()) {
            return getVerticalHelper(recyclerView$LayoutManager);
        }
        if (recyclerView$LayoutManager.canScrollHorizontally()) {
            return getHorizontalHelper(recyclerView$LayoutManager);
        }
        return null;
    }

    @NonNull
    private OrientationHelper getVerticalHelper(@NonNull RecyclerView$LayoutManager recyclerView$LayoutManager) {
        OrientationHelper orientationHelper = this.mVerticalHelper;
        if (orientationHelper == null || orientationHelper.mLayoutManager != recyclerView$LayoutManager) {
            this.mVerticalHelper = OrientationHelper.createVerticalHelper(recyclerView$LayoutManager);
        }
        return this.mVerticalHelper;
    }

    private boolean isForwardFling(RecyclerView$LayoutManager recyclerView$LayoutManager, int i, int i2) {
        return recyclerView$LayoutManager.canScrollHorizontally() ? i > 0 : i2 > 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private boolean isReverseLayout(RecyclerView$LayoutManager recyclerView$LayoutManager) {
        PointF computeScrollVectorForPosition;
        int itemCount = recyclerView$LayoutManager.getItemCount();
        if (!(recyclerView$LayoutManager instanceof RecyclerView$SmoothScroller.ScrollVectorProvider) || (computeScrollVectorForPosition = ((RecyclerView$SmoothScroller.ScrollVectorProvider) recyclerView$LayoutManager).computeScrollVectorForPosition(itemCount - 1)) == null) {
            return false;
        }
        return computeScrollVectorForPosition.x < 0.0f || computeScrollVectorForPosition.y < 0.0f;
    }

    @Nullable
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

    @Nullable
    protected RecyclerView$SmoothScroller createScroller(@NonNull RecyclerView$LayoutManager recyclerView$LayoutManager) {
        if (recyclerView$LayoutManager instanceof RecyclerView$SmoothScroller.ScrollVectorProvider) {
            return new 1(this, ((SnapHelper) this).mRecyclerView.getContext());
        }
        return null;
    }

    @Nullable
    public View findSnapView(RecyclerView$LayoutManager recyclerView$LayoutManager) {
        if (recyclerView$LayoutManager.canScrollVertically()) {
            return findCenterView(recyclerView$LayoutManager, getVerticalHelper(recyclerView$LayoutManager));
        }
        if (recyclerView$LayoutManager.canScrollHorizontally()) {
            return findCenterView(recyclerView$LayoutManager, getHorizontalHelper(recyclerView$LayoutManager));
        }
        return null;
    }

    public int findTargetSnapPosition(RecyclerView$LayoutManager recyclerView$LayoutManager, int i, int i2) {
        OrientationHelper orientationHelper;
        int itemCount = recyclerView$LayoutManager.getItemCount();
        if (itemCount == 0 || (orientationHelper = getOrientationHelper(recyclerView$LayoutManager)) == null) {
            return -1;
        }
        int i3 = Integer.MIN_VALUE;
        int i4 = Integer.MAX_VALUE;
        int childCount = recyclerView$LayoutManager.getChildCount();
        View view = null;
        View view2 = null;
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = recyclerView$LayoutManager.getChildAt(i5);
            if (childAt != null) {
                int distanceToCenter = distanceToCenter(childAt, orientationHelper);
                if (distanceToCenter <= 0 && distanceToCenter > i3) {
                    view2 = childAt;
                    i3 = distanceToCenter;
                }
                if (distanceToCenter >= 0 && distanceToCenter < i4) {
                    view = childAt;
                    i4 = distanceToCenter;
                }
            }
        }
        boolean isForwardFling = isForwardFling(recyclerView$LayoutManager, i, i2);
        if (isForwardFling && view != null) {
            return recyclerView$LayoutManager.getPosition(view);
        }
        if (!isForwardFling && view2 != null) {
            return recyclerView$LayoutManager.getPosition(view2);
        }
        if (isForwardFling) {
            view = view2;
        }
        if (view == null) {
            return -1;
        }
        int position = recyclerView$LayoutManager.getPosition(view) + (isReverseLayout(recyclerView$LayoutManager) == isForwardFling ? -1 : 1);
        if (position < 0 || position >= itemCount) {
            return -1;
        }
        return position;
    }
}
