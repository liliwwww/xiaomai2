package androidx.recyclerview.widget;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
class PagerSnapHelper$1 extends LinearSmoothScroller {
    final /* synthetic */ PagerSnapHelper this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PagerSnapHelper$1(PagerSnapHelper pagerSnapHelper, Context context) {
        super(context);
        this.this$0 = pagerSnapHelper;
    }

    @Override // androidx.recyclerview.widget.LinearSmoothScroller
    protected float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
        return 100.0f / displayMetrics.densityDpi;
    }

    @Override // androidx.recyclerview.widget.LinearSmoothScroller
    protected int calculateTimeForScrolling(int i) {
        return Math.min(100, super.calculateTimeForScrolling(i));
    }

    @Override // androidx.recyclerview.widget.LinearSmoothScroller
    protected void onTargetFound(View view, RecyclerView.State state, RecyclerView$SmoothScroller$Action recyclerView$SmoothScroller$Action) {
        PagerSnapHelper pagerSnapHelper = this.this$0;
        int[] calculateDistanceToFinalSnap = pagerSnapHelper.calculateDistanceToFinalSnap(pagerSnapHelper.mRecyclerView.getLayoutManager(), view);
        int i = calculateDistanceToFinalSnap[0];
        int i2 = calculateDistanceToFinalSnap[1];
        int calculateTimeForDeceleration = calculateTimeForDeceleration(Math.max(Math.abs(i), Math.abs(i2)));
        if (calculateTimeForDeceleration > 0) {
            recyclerView$SmoothScroller$Action.update(i, i2, calculateTimeForDeceleration, this.mDecelerateInterpolator);
        }
    }
}
