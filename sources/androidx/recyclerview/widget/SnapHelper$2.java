package androidx.recyclerview.widget;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView$SmoothScroller;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
class SnapHelper$2 extends LinearSmoothScroller {
    final /* synthetic */ SnapHelper this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SnapHelper$2(SnapHelper snapHelper, Context context) {
        super(context);
        this.this$0 = snapHelper;
    }

    protected float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
        return 100.0f / displayMetrics.densityDpi;
    }

    protected void onTargetFound(View view, RecyclerView$State recyclerView$State, RecyclerView$SmoothScroller.Action action) {
        SnapHelper snapHelper = this.this$0;
        RecyclerView recyclerView = snapHelper.mRecyclerView;
        if (recyclerView == null) {
            return;
        }
        int[] calculateDistanceToFinalSnap = snapHelper.calculateDistanceToFinalSnap(recyclerView.getLayoutManager(), view);
        int i = calculateDistanceToFinalSnap[0];
        int i2 = calculateDistanceToFinalSnap[1];
        int calculateTimeForDeceleration = calculateTimeForDeceleration(Math.max(Math.abs(i), Math.abs(i2)));
        if (calculateTimeForDeceleration > 0) {
            action.update(i, i2, calculateTimeForDeceleration, ((LinearSmoothScroller) this).mDecelerateInterpolator);
        }
    }
}
